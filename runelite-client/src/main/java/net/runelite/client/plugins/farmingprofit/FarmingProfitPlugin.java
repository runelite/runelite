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

	// UI vars
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

	// Static vars
	final private static int MAX_PATCH_DISTANCE = 14;
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
		log.info("Starting New Farming Profit Plugin");

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

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		// Set the previous crop inventory as soon as one is available.
		if (prevCropInv.size() == 0 && getCropInv().size() > 0)
		{
			prevCropInv = getCropInv();
		}

		// Back-up check to make sure all harvests will finish eventually
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

		// Flag used to do corresponding actions to starting a harvest on the next game tick
		if (START_HARVEST_NEXT_GAMETICK)
		{
			log.debug("Player has started harvesting");
			printCropInv(getCropInv());

			startedHarvesting = true;
			storedObjID = latestObjID;

			checkForHarvest();

			START_HARVEST_NEXT_GAMETICK = false;
		}

		// Flag used to do corresponding actions when a harvest is finished on the next game tick
		if (FINISH_HARVEST_NEXT_GAMETICK)
		{
			log.debug("Patch empty");
			printCropInv(getCropInv());

			startedHarvesting = false;

			checkForHarvest();

			submitRun(latestRun);
			latestRun = null;
			storedObjID = -1;

			FINISH_HARVEST_NEXT_GAMETICK = false;
		}
	}

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

	private void checkForHarvest()
	{
		Multiset<Crop> currentCropInv = getCropInv();
		Multiset<Crop> newCrops = getNewCrops(prevCropInv, currentCropInv);
		if (newCrops.size() > 0)
		{
			handleNewCrops(newCrops);
		}
		prevCropInv = currentCropInv;
	}

	private void handleNewCrops(Multiset<Crop> newCrops)
	{
		log.debug("Handle a new harvest with crops:");
		printCropInv(newCrops);

		// Get the crop from the product ID
		Iterator<Crop> it = newCrops.iterator();
		if (it.hasNext())
		{
			Crop crop = it.next();
			int amount = newCrops.size();

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
		if (!isPatchTypeEnabled(crop.getPatchType())) {
			return;
		}

		log.debug("Harvested " + amount + "x of " + crop.getDisplayName());

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

			if (latestRun.getCrop() == crop && MAX_PATCH_DISTANCE > dist && storedObjID == latestRun.getGameObjClicked())
			{
				latestRun.addAmount(amount);

				log.debug("  Latest run is most likely the same patch, so added to the latest run:");
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

	private Multiset<Crop> getCropInv()
	{
		ItemContainer currentItemContainer = client.getItemContainer(InventoryID.INVENTORY);
		if (currentItemContainer != null)
		{
			return invToCropSet(currentItemContainer.getItems());
		}
		return HashMultiset.create();
	}

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

	private static boolean isHarvestStartMsg(String msg)
	{
		return (msg.startsWith("You begin to harvest the"));

	}

	private static boolean isHarvestFinishMsg(String msg)
	{
		return (msg.endsWith("patch is now empty.") ||
			msg.endsWith("allotment is now empty."));
	}

	private static void printCropInv(Multiset<Crop> cropInv)
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
