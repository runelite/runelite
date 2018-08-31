/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingprofit;

import com.google.common.eventbus.Subscribe;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@PluginDescriptor(
	name = "Farming Profit",
	description = "Calculates the profit of a farm run",
	tags = {"farm", "farming", "runs", "run", "profit"}
)
@Slf4j
public class FarmingProfitPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private SpriteManager spriteManager;

	private FarmingProfitPanel panel;
	private NavigationButton navButton;

	private Item[] previousItems;

	private FarmingProfitRun latestRun = null;

	private boolean wasHarvesting = false;
	private boolean harvestedUsingChat = false;
	private boolean readyToSubmitRun = false;

	final private static int MAX_PATCH_DISTANCE = 14;
	final private static int MIN_TELEPORT_DISTANCE = 40;
	final private static int RUN_TIMEOUT_SECONDS = 45;


	@Override
	protected void startUp()
	{
		log.info("Starting Farming Profit Plugin");

		previousItems = new Item[0];

		// Farming Profit Panel
		panel = new FarmingProfitPanel(itemManager);
		spriteManager.getSpriteAsync(SpriteID.SKILL_FARMING, 0, panel::loadHeaderIcon);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "farming.png");

		navButton = NavigationButton.builder()
			.tooltip("Farming Profit")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Shut down Farming Profit Plugin");
	}

	/**
	 * OnChatMessage event handler:
	 * - When a chat message is received about a certain patch being harvested this overrides the animation
	 * harvesting detection system and adds the harvested patches to the latest run.
	 * - If the chat message displays something about a patch being empty, a flag is set to submit the run. After the
	 * next harvest update, the run will be submitted and shown in the UI.
	 *
	 * @param chatMessage The chat message object passed to the event.
	 */
	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		Crop crop = HarvestMessages.cropFromMessage(chatMessage.getMessage());
		if (crop != Crop.UNKNOWN)
		{
			log.debug("Harvesting " + crop.getDisplayName() + " because message: [" + chatMessage.getMessage() + "]");
			handleHarvest(crop, 1);
			harvestedUsingChat = true;
		}

		if (chatMessage.getMessage().endsWith("patch is now empty.") ||
			chatMessage.getMessage().endsWith("allotment is now empty."))
		{
			log.debug("The patch is empty so mark latest run ready to submit");
			readyToSubmitRun = true;
		}
	}

	/**
	 * OnAnimationChanged event handler:
	 * If a harvesting animation is observed, store current items.
	 * If a idle animation is observed, two cases are possible depending on how the harvest was observed:
	 * If using a chat message;
	 * The harvested by chat flag is set to false and the event handler is aborted since everything is already
	 * handled after the chat messages are observed.
	 * If using a harvesting animation;
	 * The new items are retrieved, comparing the current inventory and the stored items. These are then
	 * checked for valid crops followed by calling the handleHarvest method with the respective crop and amount
	 * harvested.
	 *
	 * @param event The AnimationChanged event, used to check what animation is changed
	 */
	@Subscribe
	public void onAnimationChanged(final AnimationChanged event)
	{
		// Check for null actor and whether the actor is the player
		if (event.getActor() == null || event.getActor() != client.getLocalPlayer())
		{
			return;
		}

		// Get animation ID
		int animationID = event.getActor().getAnimation();

		// Check whether the player is harvesting
		if (isHarvestAnim(animationID))
		{
			// Player is harvesting, store current inventory
			storeItems();
			wasHarvesting = true;
		}

		// Used to prevent deadlock after tracking crop harvest using chat message
		if (animationID == AnimationID.IDLE && harvestedUsingChat)
		{
			harvestedUsingChat = false;
			return;
		}

		// If the player is idle and was harvesting
		if (animationID == AnimationID.IDLE && wasHarvesting)
		{
			wasHarvesting = false;

			// Set currentItems to previousItems by default, will be updated if the inventory container is not null.
			// This is to ensure no new items will be observed when the inventory is null.
			Item[] currentItems = previousItems;
			ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);
			if (itemContainer != null)
			{
				currentItems = itemContainer.getItems();
			}

			// Get new items
			Item[] newItems = getNewItems(previousItems, currentItems);
			newItems = removeUnknownCrops(newItems);

			// Stop when no new items were found
			if (newItems.length == 0)
			{
				return;
			}

			// Get the crop from the product ID
			Crop crop = Crop.fromProductId(newItems[0].getId());
			int amount = newItems.length;

			// Handle the harvest of the crop with respective amount
			handleHarvest(crop, amount);
		}
	}

	/**
	 * Handle the harvest of a crop with a certain amount, basic flow:
	 * If there is not latest run, create a now farming run
	 * Else:
	 * If the current run is most likely the same patch: add amount to the latest run
	 * Else: add run to UI and start a new run with the harvested crop
	 *
	 * @param crop   The crop that has been harvested
	 * @param amount The amount of the crop that is harvested
	 */
	private void handleHarvest(Crop crop, int amount)
	{
		log.debug("Harvested " + amount + "x of " + crop.getDisplayName());

		WorldPoint harvestLocation = client.getLocalPlayer().getWorldLocation();

		if (latestRun == null)
		{
			log.debug(" There is no latest harvest run, create new run:");

			latestRun = new FarmingProfitRun(itemManager, crop, amount, harvestLocation);
			storeItems();

			log.debug(" " + latestRun.toString());
		}
		else
		{
			int distance = harvestLocation.distanceTo(latestRun.getLatestHarvestWorldPoint());
			if (latestRun.getCrop() == crop && distance < MAX_PATCH_DISTANCE)
			{
				log.debug(" Latest run is close to current run with same crop type, most likely the same patch," +
					" so add to the latest run:");

				latestRun.addAmount(amount, harvestLocation);
				storeItems();

				log.debug(" " + latestRun.toString());
			}
			else
			{
				log.debug(" Harvesting other patch type or patch far away, add latest run and start new run");

				submitLatestRun(latestRun);
				latestRun = new FarmingProfitRun(itemManager, crop, amount, harvestLocation);
				storeItems();

				log.debug(" " + latestRun.toString());
			}
		}

		if (readyToSubmitRun)
		{
			log.debug(" Submitting latest run");

			readyToSubmitRun = false;
			submitLatestRun(latestRun);
			latestRun = null;
		}
	}

	/**
	 * Once the run is not added using the chat messages, this event handler makes sure that the run will always be added
	 * eventually. This is done using a timeout and a distance check to see whether the player has teleported.
	 *
	 * @param tick
	 */
	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (latestRun != null)
		{
			// Check whether the time of the last run is past the timeout
			LocalDateTime offsetTime = LocalDateTime.now();
			boolean pastTimeout = offsetTime.isAfter(latestRun.getLatestHarvestTime().plusSeconds(RUN_TIMEOUT_SECONDS));

			// Check the distance to latest run in order to see guess if the player has teleported away
			int distance = client.getLocalPlayer().getWorldLocation().distanceTo(latestRun.getLatestHarvestWorldPoint());
			boolean hasTeleported = (distance > MIN_TELEPORT_DISTANCE);

			// Add run to panel if the run was done longer ago than the timeout or if the player has teleported
			if (pastTimeout || hasTeleported)
			{
				if (pastTimeout)
				{
					log.debug("Adding harvest run to UI, harvest time past timeout");
				}
				if (hasTeleported)
				{
					log.debug("Adding harvest run to UI, player has teleported");
				}
				submitLatestRun(latestRun);
				latestRun = null;
			}
		}
	}

	/**
	 * Submit the latest run to the UI
	 */
	private void submitLatestRun(FarmingProfitRun run)
	{
		SwingUtilities.invokeLater(() ->
		{
			panel.addRun(run);
			wasHarvesting = false;
			harvestedUsingChat = false;
		});
	}

	/**
	 * From two arrays of items, previous and next, find the new items in compared to the previous.
	 *
	 * @param prev Previous items
	 * @param next The next array of items, which might contain new items compared to the previous.
	 * @return An array of items that exist in `next` but not in `prev`
	 */
	private Item[] getNewItems(Item[] prev, Item[] next)
	{
		if (prev == null || prev.length == 0)
		{
			return next;
		}

		ArrayList<Item> prevList = new ArrayList<>(Arrays.asList(prev));
		ArrayList<Item> nextList = new ArrayList<>(Arrays.asList(next));

		for (Item item : prevList)
		{
			AtomicInteger index = new AtomicInteger(0);
			int itemId = item.getId();
			nextList.removeIf(p -> (p.getId() == itemId && index.getAndIncrement() < 1));
		}

		nextList.removeIf(item -> item.getQuantity() == 0);

		return nextList.toArray(new Item[nextList.size()]);
	}

	/**
	 * From a lot of items, remove the items that are not crops
	 *
	 * @param items Array of items to be checked
	 * @return Array of items, where all items are valid crops
	 */
	private Item[] removeUnknownCrops(Item[] items)
	{
		ArrayList<Item> newItemsList = new ArrayList<>(Arrays.asList(items));
		newItemsList.removeIf(item -> (Crop.fromProductId(item.getId()) == Crop.UNKNOWN));
		return newItemsList.toArray(new Item[newItemsList.size()]);
	}

	/**
	 * Checks whether an animation ID is a harvest animation id
	 *
	 * @param animId Animation ID to be checked
	 * @return True if the animation ID is a harvest animation, false if not
	 */
	private boolean isHarvestAnim(int animId)
	{
		return (animId == AnimationID.FARMING_HARVEST_BUSH ||
			animId == AnimationID.FARMING_HARVEST_FLOWER ||
			animId == AnimationID.FARMING_HARVEST_FRUIT_TREE ||
			animId == AnimationID.FARMING_HARVEST_HERB ||
			animId == AnimationID.DIG);
	}

	/**
	 * Store the current inventory in a local variable
	 * This is used to check whether items have been added to the inventory after harvesting
	 */
	private void storeItems()
	{
		ItemContainer currentItemContainer = client.getItemContainer(InventoryID.INVENTORY);
		if (currentItemContainer != null)
		{
			previousItems = currentItemContainer.getItems();
		}
	}
}
