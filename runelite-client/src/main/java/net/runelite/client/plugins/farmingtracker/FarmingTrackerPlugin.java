/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.farmingtracker;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.FARMING_HARVEST_FLOWER;
import static net.runelite.api.AnimationID.IDLE;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.ObjectComposition;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.farmingtracker.data.FarmingTick;
import net.runelite.client.plugins.farmingtracker.data.PatchLocation;
import net.runelite.client.plugins.farmingtracker.data.PatchRowData;
import net.runelite.client.plugins.farmingtracker.data.Seed;
import net.runelite.client.plugins.farmingtracker.data.SeedStatus;
import net.runelite.client.plugins.farmingtracker.ui.PatchList;
import net.runelite.client.plugins.farmingtracker.ui.PatchRow;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.util.QueryRunner;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Farming Tracker"
)
public class FarmingTrackerPlugin extends Plugin
{
	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private ConfigManager configManager;

	private FarmingTrackerPanel panel;
	private NavigationButton navButton;
	private BufferedImage weeds;

	private PatchLocation clickedOnPatch;
	private ObjectComposition previousPatchObject;
	private String menuTargetHardWood;
	private int previousAnimation;
	private int tickedAtEpoch = 0;

	private final String CHAT_MESSAGE_PLANTED_SEED = "You plant ";
	private final String CONFIG_GROUP = "farmingTracker";
	private String lastUsername;

	@Provides
	FarmingTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FarmingTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("farming.png"));
			weeds = ImageIO.read(getClass().getResourceAsStream("weeds.png"));
		}

		panel = injector.getInstance(FarmingTrackerPanel.class);
		panel.initPanel(weeds);

		navButton = NavigationButton.builder()
			.name("Farming Tracker")
			.icon(icon)
			.panel(panel)
			.build();

		pluginToolbar.addNavigation(navButton);

		//Reload the config on enabling the plugin
		if (client != null && client.getGameState() == GameState.LOGGED_IN)
		{
			loadConfig();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		Set<String> firstOptions = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		firstOptions.addAll(Arrays.asList("pick", "harvest", "cure", "prune", "clear"));

		if ((menuOptionClicked.getMenuAction() == MenuAction.GAME_OBJECT_FIRST_OPTION && firstOptions.contains(menuOptionClicked.getMenuOption())) || menuOptionClicked.getMenuAction() == MenuAction.ITEM_USE_ON_GAME_OBJECT)
		{
			PatchLocation patchLocation = PatchLocation.findByWorldLocation(client, queryRunner, menuOptionClicked.getId() & 127, menuOptionClicked.getId() >> 7 & 127);

			if (patchLocation != null)
			{
				clickedOnPatch = patchLocation;

				if (patchLocation.equals(PatchLocation.FOSSIL_ISLAND_TREE_HARDWOOD_EAST)
					|| patchLocation.equals(PatchLocation.FOSSIL_ISLAND_TREE_HARDWOOD_MIDDLE)
					|| patchLocation.equals(PatchLocation.FOSSIL_ISLAND_TREE_HARDWOOD_WEST))
				{
					menuTargetHardWood = Text.removeTags(menuOptionClicked.getMenuTarget());
				}
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();

		if (message.equals("The herb patch is now empty.") || message.equals("The hops patch is now empty."))
		{
			handlePatchCleared();
		}

		if (event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		if (message.equals("You plant the plantpot in the hardwood tree patch."))
		{
			handlePlantedSaplingHardwood();
		}
		else if (message.startsWith(CHAT_MESSAGE_PLANTED_SEED))
		{
			handlePlantedSeed(message);
		}
		else if (message.equals("You have successfully cleared this patch for new crops.")
			|| message.equals("The allotment is now empty.")
			|| message.equals("You dig up the tree stump."))
		{
			handlePatchCleared();
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (event.getActor() != client.getLocalPlayer() || clickedOnPatch == null)
		{
			return;
		}

		ObjectComposition currentPatch = client.getObjectDefinition(clickedOnPatch.getPatchObjectId()).getImpostor();

		switch (event.getActor().getAnimation())
		{
			case FARMING_HARVEST_FLOWER:
				previousPatchObject = currentPatch;
				previousAnimation = FARMING_HARVEST_FLOWER;
				break;
			case IDLE:
				handleHarvest(currentPatch);
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (!Objects.equals(client.getUsername(), lastUsername))
			{
				lastUsername = client.getUsername();

				loadConfig();
			}
		}
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void runFarmingTickChecker()
	{
		int epoch = FarmingTimer.getEpochTime();

		for (FarmingTick farmingTick : FarmingTick.values())
		{
			if ((tickedAtEpoch == 0 || epoch > tickedAtEpoch + 100) && FarmingTimer.isFarmingTick(epoch, farmingTick.getTick()))
			{
				tickedAtEpoch = epoch;
				handleFarmingTickPassed(farmingTick);
			}
		}
	}

	@Schedule(
		period = 10,
		unit = ChronoUnit.SECONDS
	)
	public void updateRemainingTime()
	{
		int epoch = FarmingTimer.getEpochTime();
		final Map<String, PatchList> patchListMap = panel.getPatchListMap();

		for (PatchLocation patchLocation : PatchLocation.values())
		{
			final PatchList patchList = patchListMap.get(patchLocation.getPatchType().name());

			patchList.updateRemainingTime(patchLocation, epoch);
		}
	}

	private void handleHarvest(ObjectComposition currentPatch)
	{
		if (previousPatchObject == null || currentPatch.getId() == previousPatchObject.getId() || previousAnimation != FARMING_HARVEST_FLOWER)
		{
			return;
		}

		handlePatchCleared();

		previousAnimation = -1;
		previousPatchObject = null;
	}

	private void handlePlantedSeed(String message)
	{
		String seedName = getSeedNameFromMessage(message);

		if (clickedOnPatch != null)
		{
			Seed seed = Seed.findByName(seedName, clickedOnPatch.getPatchType());

			if (seed != null)
			{
				updatePatchList(seed, new PatchRowData(seed, SeedStatus.ALIVE, 1, "Calculating..."));
			}
		}
	}

	private void handlePlantedSaplingHardwood()
	{
		if (clickedOnPatch != null && menuTargetHardWood != null)
		{
			Seed seed = Seed.findByName(menuTargetHardWood.split(" sapling")[0], clickedOnPatch.getPatchType());

			if (seed != null)
			{
				updatePatchList(seed, new PatchRowData(seed, SeedStatus.ALIVE, 1, "Calculating..."));
			}
		}

		menuTargetHardWood = null;
	}

	private void handlePatchCleared()
	{
		if (clickedOnPatch != null)
		{
			updatePatchList(null, null);
		}
	}

	private void updatePatchList(Seed seed, PatchRowData patchRowData)
	{
		final Map<String, PatchList> patchListMap = panel.getPatchListMap();
		final PatchList patchList = patchListMap.get(clickedOnPatch.getPatchType().name());

		BufferedImage bufferedImage = weeds;
		if (seed != null)
		{
			bufferedImage = itemManager.getImage(seed.getSpriteId());
		}

		if (patchRowData != null)
		{
			patchList.setPlanted(clickedOnPatch, bufferedImage, patchRowData);

			handleConfig(patchRowData, clickedOnPatch, FarmingTimer.getEpochTime());
		}
		else
		{
			patchList.setCleared(clickedOnPatch, bufferedImage);

			handleConfig(null, clickedOnPatch, 0);
		}
	}

	private String getSeedNameFromMessage(String message)
	{
		String[] sentences = message.split(CHAT_MESSAGE_PLANTED_SEED);
		String[] words = sentences[1].split(" ");

		return words[1];
	}

	private void handleFarmingTickPassed(FarmingTick farmingTick)
	{
		final Map<String, PatchList> patchListMap = panel.getPatchListMap();

		for (PatchLocation patchLocation : PatchLocation.findByFarmingTick(farmingTick))
		{
			final PatchList patchList = patchListMap.get(patchLocation.getPatchType().name());
			final PatchRow patchRow = patchList.getPatchRows().get(patchLocation.name());
			final PatchRowData patchRowData = patchRow.getPatchRowData();

			if (patchRowData == null)
			{
				continue;
			}

			patchRowData.applyFarmingTick();
		}
	}

	private void handleConfig(PatchRowData patchRowData, PatchLocation patchLocation, int timePlanted)
	{
		if (patchRowData == null)
		{
			configManager.unsetConfiguration(CONFIG_GROUP, patchLocation.name());
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, patchLocation.name(), patchRowData.objectToConfigString(timePlanted));
		}
	}

	private void loadConfig()
	{
		for (PatchLocation patchLocation : PatchLocation.values())
		{
			String configValue = configManager.getConfiguration(CONFIG_GROUP, patchLocation.name());

			if (configValue == null)
			{
				continue;
			}

			PatchRowData patchRowData = PatchRowData.configStringToObject(configValue);

			if (patchRowData == null)
			{
				handleConfig(null, patchLocation, 0);
				continue;
			}

			final Map<String, PatchList> patchListMap = panel.getPatchListMap();
			final PatchList patchList = patchListMap.get(patchLocation.getPatchType().name());

			BufferedImage bufferedImage = itemManager.getImage(patchRowData.getSeed().getSpriteId());

			patchList.setPlanted(patchLocation, bufferedImage, patchRowData);
		}
	}
}
