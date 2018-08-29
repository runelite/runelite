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
	tags = {"farm", "farming", "profit"}
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

	final private static int MAX_PATCH_DISTANCE = 8;
	final private static int MIN_TELEPORT_DISTANCE = 40;
	final private static int RUN_TIMEOUT_SECONDS = 30;


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

		if (chatMessage.getMessage().endsWith("patch is now empty."))
		{
			log.debug("The patch is empty so mark latest run ready to submit");
			readyToSubmitRun = true;
		}
	}

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

		log.debug("AnimationID: " + animationID);

		// Check whether the player is harvesting
		if (isHarvestAnim(animationID))
		{
			// Player is harvesting, store current inventory
			setPreviousItems();
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

			// Player idle, find new items
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

			handleHarvest(crop, amount);

			log.debug("Harvested " + amount + "x of " + crop.getDisplayName());
		}
	}

	private void handleHarvest(Crop crop, int amount)
	{
		log.debug("Handling harvest: " + amount + "x " + crop.getDisplayName());

		WorldPoint harvestLocation = client.getLocalPlayer().getWorldLocation();

		if (latestRun == null)
		{
			log.debug("There is no latest run, create new run");

			latestRun = new FarmingProfitRun(itemManager, crop, amount, harvestLocation);
			setPreviousItems();

			log.debug(latestRun.toString());
		}
		else
		{
			int distance = harvestLocation.distanceTo(latestRun.getLatestHarvestWorldPoint());
			if (latestRun.getCrop() == crop && distance < MAX_PATCH_DISTANCE)
			{
				log.debug("  Latest run is close to current run with same crop type, most likely the same patch," +
					" so add to the latest run");

				latestRun.addAmount(amount, harvestLocation);
				setPreviousItems();

				log.debug(latestRun.toString());
			}
			else
			{
				log.debug(" Harvesting other patch type or patch far away, add latest run and start new run");
				SwingUtilities.invokeLater(() -> {
					panel.addRun(latestRun);

					latestRun = new FarmingProfitRun(itemManager, crop, amount, harvestLocation);
					setPreviousItems();

					log.debug(latestRun.toString());
				});
			}
		}

		if (readyToSubmitRun)
		{
			log.debug("Ready to submit, adding latest run");
			readyToSubmitRun = false;
			submitLatestRun();
		}
	}

	// Backup checks for adding the latest run
	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (latestRun != null)
		{
			// Check the last run was done longer ago than the timeout
			LocalDateTime offsetTime = LocalDateTime.now();
			boolean pastTimeout = offsetTime.isAfter(latestRun.getLatestHarvestTime().plusSeconds(RUN_TIMEOUT_SECONDS));

			// Check the distance to latest run in order to see whether the player has teleported away
			int distance = client.getLocalPlayer().getWorldLocation().distanceTo(latestRun.getLatestHarvestWorldPoint());
			boolean hasTeleported = (distance > MIN_TELEPORT_DISTANCE);

			// Add run to panel if the run was done longer ago than the timeout or if the player has teleported
			if (pastTimeout || hasTeleported)
			{
				if (pastTimeout)
				{
					log.debug("Harvest time past timeout");
				}
				if (hasTeleported)
				{
					log.debug("Player has teleported");
				}
				submitLatestRun();
			}
		}
	}

	private void submitLatestRun()
	{
		SwingUtilities.invokeLater(() -> {
			panel.addRun(latestRun);
			latestRun = null;
			wasHarvesting = false;
			harvestedUsingChat = false;
		});
	}

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

	private Item[] removeUnknownCrops(Item[] items)
	{
		ArrayList<Item> newItemsList = new ArrayList<>(Arrays.asList(items));
		newItemsList.removeIf(item -> (Crop.fromProductId(item.getId()) == Crop.UNKNOWN));
		return newItemsList.toArray(new Item[newItemsList.size()]);
	}

	private boolean isHarvestAnim(int animId)
	{
		return (animId == AnimationID.FARMING_HARVEST_BUSH ||
			animId == AnimationID.FARMING_HARVEST_FLOWER ||
			animId == AnimationID.FARMING_HARVEST_FRUIT_TREE ||
			animId == AnimationID.FARMING_HARVEST_HERB ||
			animId == AnimationID.DIG);
	}

	private void setPreviousItems()
	{
		ItemContainer currentItemContainer = client.getItemContainer(InventoryID.INVENTORY);
		if (currentItemContainer != null)
		{
			previousItems = currentItemContainer.getItems();
		}
	}
}
