/*
 * Copyright (c) 2018, Mika Kuijpers <github.com/mkuijpers>
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

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.Skill;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Farming Profit",
	description = "Calculates the profit of a farm run",
	tags = {"farm", "farming", "runs", "run", "profit"}
)
@Slf4j
public class FarmingProfitPlugin extends Plugin
{
	// Injections
	@Inject
	private Client client;
	@Inject
	private ClientToolbar clientToolbar;
	@Inject
	private ItemManager itemManager;
	@Inject
	private SpriteManager spriteManager;
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FarmingProfitOverlay debugOverlay;
	@Inject
	private FarmingProfitConfig config;

	@Provides
	FarmingProfitConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FarmingProfitConfig.class);
	}

	// UI elements
	private FarmingProfitPanel panel;
	private NavigationButton navButton;

	// Plugin vars
	@Getter
	private Multiset<Crop> prevCropInv;
	@Getter
	private FarmingProfitRun latestRun = null;
	@Getter
	private int latestObjID = -1;
	@Getter
	private int storedObjID = -1;
	@Getter
	private boolean startedHarvesting = false;

	// Static vars for back-up checks
	final private static int MAX_PATCH_DISTANCE = 20;
	final private static int MIN_TELEPORT_DISTANCE = 40;

	// Flags
	private boolean START_HARVEST_NEXT_GAMETICK = false;
	private boolean FINISH_HARVEST_NEXT_GAMETICK = false;

	// ====================== //
	//     PLUGIN ACTIONS     //
	// ====================== //

	@Override
	protected void startUp()
	{
		log.debug("Starting Farming Profit Plugin");

		prevCropInv = HashMultiset.create();

		// Farming Profit Panel
		panel = new FarmingProfitPanel(itemManager);
		spriteManager.getSpriteAsync(SpriteID.SKILL_FARMING, 0, panel::loadHeaderIcon);

		final BufferedImage icon = new SkillIconManager().getSkillImage(Skill.FARMING, false);

		navButton = NavigationButton.builder()
			.tooltip("Farming Profit")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		if (log.isDebugEnabled())
		{
			overlayManager.add(debugOverlay);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (log.isDebugEnabled())
		{
			overlayManager.remove(debugOverlay);
		}
		clientToolbar.removeNavigation(navButton);
	}

	// ====================== //
	//      EVENT ACTIONS     //
	// ====================== //

	/**
	 * OnGameTick event handler.
	 * The on game tick events are used to perform most harvest actions synced with the game tick timer.
	 * <p>
	 * Most of these actions use flags set in the onChatMessage since shat messages would trigger when the inventory
	 * has not updated yet. Doing it on the next game tick makes sure that the inventory is updated.
	 *
	 * @param gameTick
	 */
	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		// Set the previous crop inventory as soon as one is available.
		if (prevCropInv.size() == 0 && getCropInv().size() > 0)
		{
			prevCropInv = getCropInv();
		}

		// Distance check to make sure all runs will be added to the UI eventually
		if (latestRun != null)
		{
			int dist = client.getLocalPlayer().getWorldLocation().distanceTo2D(latestRun.getLatestHarvestWorldPoint());
			if (dist > MIN_TELEPORT_DISTANCE)
			{
				submitRun(latestRun);
				latestRun = null;
				storedObjID = -1;
			}
		}

		// Flag used to do handle starting a harvest on the next game tick
		if (START_HARVEST_NEXT_GAMETICK)
		{
			log.debug("Starting harvest");

			startedHarvesting = true;
			storedObjID = latestObjID;

			checkForHarvest();

			START_HARVEST_NEXT_GAMETICK = false;
		}

		// Flag used to handle finishing a harvest on the next game tick
		if (FINISH_HARVEST_NEXT_GAMETICK)
		{
			log.debug("Finishing harvest");

			startedHarvesting = false;

			checkForHarvest();

			submitRun(latestRun);
			latestRun = null;
			storedObjID = -1;

			FINISH_HARVEST_NEXT_GAMETICK = false;
		}
	}

	/**
	 * MenuOptionClicked event handler.
	 * The menu option clicked is used to track if different patches are harvested based on the latest
	 * game object clicked.
	 *
	 * @param menuOption
	 */
	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOption)
	{
		if (menuOption.getMenuAction() == MenuAction.GAME_OBJECT_FIRST_OPTION &&
			!isHarvestAnim(client.getLocalPlayer().getAnimation()))
		{
			latestObjID = menuOption.getId();
		}
	}

	/**
	 * ChatMessage event handler.
	 * The chat messages of harvesting are used to perform the harvest actions.
	 *
	 * @param chatMessage
	 */
	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		String msg = chatMessage.getMessage();

		// Harvest when chat messages are sent for individual harvests
		Crop crop = Crop.fromHarvestMessage(msg);
		if (crop != Crop.UNKNOWN)
		{
			storedObjID = latestObjID;
			handleHarvest(crop, 1);
		}

		// Since chat messages and gameticks are not synced, the inventory might not be updated when the
		// chat message is received. Flags are used handle the harvest on the next game tick.

		// Harvest Start
		if (isHarvestStartMsg(msg))
		{
			START_HARVEST_NEXT_GAMETICK = true;
		}

		// Harvest Finish
		if (startedHarvesting && isHarvestFinishMsg(msg))
		{
			FINISH_HARVEST_NEXT_GAMETICK = true;
		}
	}

	// ====================== //
	//       HARVESTING       //
	// ====================== //

	/**
	 * Check inventory for a new harvest, handle harvest if new crops are detected in the inventory.
	 */
	private void checkForHarvest()
	{
		Multiset<Crop> currentCropInv = getCropInv();
		Multiset<Crop> newCrops = getNewCrops(prevCropInv, currentCropInv);
		if (newCrops.size() > 0)
		{
			Iterator<Crop> it = newCrops.iterator();
			if (it.hasNext())
			{
				Crop crop = it.next();
				int amount = newCrops.size();
				handleHarvest(crop, amount);
			}
		}
		prevCropInv = currentCropInv;
	}

	/**
	 * Handle the harvest of a crop with a given amount harvested
	 * When there is no latest run, create a new one with this crop and amount.
	 * When there is a latest run, check whether is could be the same patch. If it is the same patch, add amount to the
	 * latest run. If not, submit latest run and create a new run.
	 *
	 * @param crop   The crop that has been harvested
	 * @param amount The amount of the crop that is harvested
	 */
	private void handleHarvest(Crop crop, int amount)
	{
		// Check whether the crop patch type is enabled in the plugin config
		if (!isPatchTypeEnabled(crop.getPatchType()))
		{
			return;
		}

		log.debug("Handle harvest of " + amount + "x of " + crop.getDisplayName());

		WorldPoint harvestLocation = client.getLocalPlayer().getWorldLocation();

		if (latestRun == null)
		{
			latestRun = new FarmingProfitRun(itemManager, crop, amount, harvestLocation, storedObjID);

			log.debug(" There is no latest harvest run, create new run:");
			log.debug(" " + latestRun.toString());
		}
		else
		{
			int dist = harvestLocation.distanceTo2D(latestRun.getLatestHarvestWorldPoint());
			if (latestRun.getCrop() == crop &&
				MAX_PATCH_DISTANCE > dist &&
				storedObjID == latestRun.getGameObjClicked())
			{
				latestRun.addAmount(amount);

				log.debug("  Latest run is most likely the same patch, added to latest run:");
				log.debug("  " + latestRun.toString());
			}
			else
			{
				log.debug("  Harvesting other patch type or patch far away, add latest run and start new run, because:");
				if (latestRun.getCrop() != crop)
				{
					log.debug("  Different crop type");
				}
				if (MAX_PATCH_DISTANCE <= dist)
				{
					log.debug("  Crop harvested far away");
				}
				if (storedObjID != latestRun.getGameObjClicked())
				{
					log.debug("  Different game obj clicked " + storedObjID + " != " + latestRun.getGameObjClicked());
				}

				submitRun(latestRun);
				latestRun = new FarmingProfitRun(itemManager, crop, amount, harvestLocation, storedObjID);

				log.debug(" " + latestRun.toString());
			}
		}

		prevCropInv = getCropInv();
	}

	// ====================== //
	//      UTIL METHODS      //
	// ====================== //

	/**
	 * Submit the latest run to the UI
	 */
	private void submitRun(FarmingProfitRun run)
	{
		if (run != null)
		{
			SwingUtilities.invokeLater(() ->
			{
				log.debug("Submitting latest run " + run.toString());
				panel.addRun(run);
			});
		}
	}

	/**
	 * Get the new crops which would have to be added to prevCropInv to get the currentCropInv.
	 *
	 * @param prevCropInv
	 * @param currentCropInv
	 * @return Multiset of crops
	 */
	private static Multiset<Crop> getNewCrops(Multiset<Crop> prevCropInv, Multiset<Crop> currentCropInv)
	{
		Multiset<Crop> newItems = HashMultiset.create();

		for (Crop crop : currentCropInv.elementSet())
		{
			int count = currentCropInv.count(crop) - prevCropInv.count(crop);
			if (count > 0)
			{
				newItems.setCount(crop, count);
			}
		}

		return newItems;
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
	 * Gets the crops inside the player inventory as a multiset of crops
	 *
	 * @return Multiset of crops in the inventory of the player
	 */
	private Multiset<Crop> getCropInv()
	{
		ItemContainer currentItemContainer = client.getItemContainer(InventoryID.INVENTORY);
		if (currentItemContainer != null)
		{
			return invToCropSet(currentItemContainer.getItems());
		}
		return HashMultiset.create();
	}

	/**
	 * Convert an Item array (player inventory) to a Multiset of crops which are found inside this array of items.
	 *
	 * @param inv Item array (player inventory)
	 * @return Multiset of crops from the item array
	 */
	private Multiset<Crop> invToCropSet(Item[] inv)
	{
		Multiset<Crop> map = HashMultiset.create();
		for (Item item : inv)
		{
			int unnotedItemId = itemManager.canonicalize(item.getId());
			Crop crop = Crop.fromProductId(unnotedItemId);
			if (crop != Crop.UNKNOWN)
			{
				map.add(crop, item.getQuantity());
			}
		}
		return map;
	}

	/**
	 * Checks whether the chat message is a harvest starting message.
	 *
	 * @param msg
	 * @return Whether the message is sent when starting a harvest.
	 */
	private static boolean isHarvestStartMsg(String msg)
	{
		return (msg.startsWith("You begin to harvest the"));

	}

	/**
	 * Checks whether the chat message is a harvest finishing message.
	 *
	 * @param msg
	 * @return Whether the message is sent when finishing a harvest.
	 */
	private static boolean isHarvestFinishMsg(String msg)
	{
		return (msg.endsWith("patch is now empty.") ||
			msg.endsWith("allotment is now empty."));
	}

	/**
	 * Debug log a multiset of crops
	 *
	 * @param cropInv Multiset of Crop to be logged
	 */
	private static void debugLogCropSet(Multiset<Crop> cropInv)
	{
		if (cropInv.elementSet().size() == 0)
		{
			log.debug(" < no crops in multiset >");
		}
		for (Crop crop : cropInv.elementSet())
		{
			log.debug(" " + cropInv.count(crop) + "x " + crop.getDisplayName());
		}
	}

	/**
	 * Check if patch type is enabled in plugin config.
	 *
	 * @param patchType
	 * @return Whether the patch type is enabled in the plugin config.
	 */
	private boolean isPatchTypeEnabled(PatchType patchType)
	{
		switch (patchType)
		{
			case UNKNOWN:
				log.debug("Checking unknown patch type");
				return false;
			case ALLOTMENTS:
				return config.trackAllotments();
			case HERBS:
				return config.trackHerbs();
			case HOPS:
				return config.trackHops();
			case BUSHES:
				return config.trackBushes();
			case SPECIAL:
				return config.trackSpecial();
		}
		return false;
	}

}
