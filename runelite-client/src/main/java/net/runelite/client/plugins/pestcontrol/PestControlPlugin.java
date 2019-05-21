/*
 *  Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 *  Copyright (c) 2019, Yani <yani@xenokore.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
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
package net.runelite.client.plugins.pestcontrol;

import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemID;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.pestcontrol.config.HighlightPortalOption;
import net.runelite.client.plugins.pestcontrol.config.NpcHighlightStyle;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Pest Control",
	description = "Show helpful information for the Pest Control minigame",
	tags = {"minigame", "overlay"}
)
public class PestControlPlugin extends Plugin
{
	private final int NOVICE_GANGPLANK = 14315; // Combat 40+ (3 points)
	private final int INTERMEDIATE_GANGPLANK = 25631; // Combat 70+ (4 points)
	private final int VETERAN_GANGPLANK = 25632; // Combat 100+ (5 points)

	private final Pattern SHIELD_DROP_PATTERN = Pattern.compile("The ([a-z]+), [^ ]+ portal shield has dropped!");
	private final Pattern EXCHANGE_WINDOW_POINTS_PATTERN = Pattern.compile("Points: <col=ffffff>([0-9]+)</col>");
	private final Pattern BOAT_POINTS_PATTERN = Pattern.compile("Pest Points: ([0-9]+)");
	private final Pattern AWARDED_PATTERN = Pattern.compile("We've awarded you ([0-9]+) Void Knight Commendation points.");
	private final Pattern PURCHASE_PATTERN = Pattern.compile("Remaining Void Knight Commendation Points: ([0-9]+)");

	@Inject
	@Getter
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	@Getter
	private ItemManager itemManager;

	@Inject
	@Getter
	private PestControlConfig config;

	@Inject
	@Getter
	private WidgetOverlay widgetOverlay;

	@Inject
	private HintArrowOverlay hintArrowOverlay;

	@Inject
	private NpcHighlightOverlay npcHighlightOverlay;

	@Inject
	private RepairOverlay repairOverlay;

	@Inject
	private GangplankOverlay gangplankOverlay;

	@Inject
	private TimerOverlay timerOverlay;

	@Inject
	private PortalWeaknessOverlay portalWeaknessOverlay;

	@Getter
	private Game game;

	@Getter
	private HashMap<Integer, NpcHighlightContext> highlightedNpcList = new HashMap<>();

	@Getter
	private List<TileObject> highlightedRepairList = new ArrayList<>();

	@Getter
	private Tile noviceGangplankTile;

	@Getter
	private Tile intermediateGangplankTile;

	@Getter
	private Tile veteranGangplankTile;

	@Getter
	private Integer commendationPoints;

	private String userConfigKey;

	private boolean checkForPointWidgets;

	private PointsInfoboxCounter pointsInfoboxCounter;


	@Provides
	PestControlConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PestControlConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		loadPlugin();
	}

	@Override
	protected void shutDown() throws Exception
	{
		unloadPlugin();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configEvent)
	{
		if (configEvent.getGroup().equals("pestcontrol"))
		{
			unloadPlugin();
			loadPlugin();
		}
	}

	private boolean loadLocalUserPoints()
	{
		if (userConfigKey != null)
		{
			String configKey = "points." + userConfigKey;
			String pointString = configManager.getConfiguration("pestcontrol", configKey);
			if (pointString != null)
			{
				commendationPoints = Integer.parseInt(pointString);

				return true;
			}
		}

		return false;
	}

	private void loadPlugin()
	{
		if (loadLocalUserPoints())
		{
			handlePointsInfoboxCounter();
		}

		overlayManager.add(widgetOverlay);

		if (config.highlightSpinners() != NpcHighlightStyle.OFF)
		{
			for (Integer npcId : PestControlNpc.getSpinnerIdSet())
			{
				highlightedNpcList.put(npcId, new NpcHighlightContext(
					config.highlightSpinners(),
					config.spinnerColor(),
					true
				));
			}
		}

		if (config.highlightBrawlers() != NpcHighlightStyle.OFF)
		{
			for (Integer npcId : PestControlNpc.getBrawlerIdSet())
			{
				highlightedNpcList.put(npcId, new NpcHighlightContext(
					config.highlightBrawlers(),
					config.brawlerColor(),
					false
				));
			}
		}

		if (config.portalHighlight() != HighlightPortalOption.OFF)
		{
			if (config.portalHighlight() == HighlightPortalOption.ACTIVE ||
				config.portalHighlight() == HighlightPortalOption.ALL)
			{
				for (Integer portalNpcId : PestControlNpc.getActivePortalIdSet())
				{
					highlightedNpcList.put(portalNpcId, new NpcHighlightContext(
						NpcHighlightStyle.HULL,
						config.activePortalColor(),
						false
					));
				}
			}

			if (config.portalHighlight() == HighlightPortalOption.SHIELDED ||
				config.portalHighlight() == HighlightPortalOption.ALL)
			{
				for (Integer portalNpcId : PestControlNpc.getShieldedPortalIdSet())
				{
					highlightedNpcList.put(portalNpcId, new NpcHighlightContext(
						NpcHighlightStyle.HULL,
						config.shieldedPortalColor(),
						false
					));
				}
			}
		}

		if (!highlightedNpcList.isEmpty())
		{
			overlayManager.add(npcHighlightOverlay);
		}

		if (config.highlightRepairables())
		{
			overlayManager.add(repairOverlay);
		}

		if (config.showHintArrow())
		{
			overlayManager.add(hintArrowOverlay);

			if (game != null && client.hasHintArrow())
			{
				client.clearHintArrow();
			}
		}

		if (config.highlightGangplanks())
		{
			overlayManager.add(gangplankOverlay);
		}

		if (config.showTimeTillNextPortal())
		{
			overlayManager.add(timerOverlay);
		}

		if (config.showPortalWeakness())
		{
			overlayManager.add(portalWeaknessOverlay);
		}
	}

	private void unloadPlugin()
	{
		overlayManager.remove(widgetOverlay);
		overlayManager.remove(npcHighlightOverlay);
		overlayManager.remove(repairOverlay);
		overlayManager.remove(gangplankOverlay);
		overlayManager.remove(hintArrowOverlay);
		overlayManager.remove(timerOverlay);
		overlayManager.remove(portalWeaknessOverlay);

		infoBoxManager.removeInfoBox(pointsInfoboxCounter);
		pointsInfoboxCounter = null;

		highlightedNpcList.clear();

		if (game != null && config.showHintArrow() && client.hasHintArrow())
		{
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		// LOGGED_IN also triggers when teleporting to the island
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			handlePointsInfoboxCounter();
		}
	}

	private void handlePointsInfoboxCounter()
	{
		if (!config.showPoints())
		{
			return;
		}

		if (!isOnPestControlMainIsland() && !isInPestControlInstance())
		{
			infoBoxManager.removeInfoBox(pointsInfoboxCounter);
			pointsInfoboxCounter = null;

			return;
		}

		if (commendationPoints == null)
		{
			if (pointsInfoboxCounter != null)
			{
				infoBoxManager.removeInfoBox(pointsInfoboxCounter);
				pointsInfoboxCounter = null;
			}

			return;
		}

		if (pointsInfoboxCounter != null)
		{
			pointsInfoboxCounter.setCount(commendationPoints);
		}
		else
		{
			BufferedImage image = itemManager.getImage(ItemID.VOID_SEAL1);
			pointsInfoboxCounter = new PointsInfoboxCounter(image, this, commendationPoints);
			pointsInfoboxCounter.setTooltip("Void Knight Commendation Points");
			infoBoxManager.addInfoBox(pointsInfoboxCounter);
		}
	}


	private void getPointsFromWidgets()
	{

		// Get points from dialog after the game
		Widget npcDialog = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		if (npcDialog != null)
		{
			String npcText = Text.sanitizeMultilineText(npcDialog.getText());
			Matcher matcher = AWARDED_PATTERN.matcher(npcText);

			if (matcher.find())
			{
				int newPoints = Integer.parseInt(matcher.group(1));

				if (commendationPoints != null)
				{
					newPoints += commendationPoints;
				}

				setCommendationPoints(newPoints);
				log.debug("PEST CONTROL [POINTS REWARDED] UPDATE: {}", commendationPoints);
				return;
			}
		}

		// Get points from dialog after purchase
		Widget pestControlDialog = client.getWidget(WidgetInfo.PEST_CONTROL_DIALOG_TEXT);
		if (pestControlDialog != null)
		{
			String pestControlDialogText = Text.sanitizeMultilineText(pestControlDialog.getText());
			Matcher matcher = PURCHASE_PATTERN.matcher(pestControlDialogText);

			if (matcher.find())
			{
				setCommendationPoints(Integer.parseInt(matcher.group(1)));
				log.debug("PEST CONTROL [DIALOG] POINTS UPDATE: {}", commendationPoints);
				return;
			}
		}

		// Get points from exchange window
		Widget exchangeWindowPointsWidget = client.getWidget(WidgetInfo.PEST_CONTROL_EXCHANGE_WINDOW_POINTS);
		if (exchangeWindowPointsWidget != null)
		{
			String pointsString = exchangeWindowPointsWidget.getText();

			Matcher matcher = EXCHANGE_WINDOW_POINTS_PATTERN.matcher(pointsString);
			if (matcher.lookingAt())
			{
				setCommendationPoints(Integer.parseInt(matcher.group(1)));
				log.debug("PEST CONTROL [EXCHANGE WINDOW] POINTS UPDATE: {}", commendationPoints);
				return;
			}
		}

		// Get points in boat
		// NOTE: The boat info widget is still active right after the game
		// We should therefor only check for point updates if there are no dialogs
		Widget boatPointsWidget = client.getWidget(WidgetInfo.PEST_CONTROL_BOAT_INFO_POINTS);
		if (boatPointsWidget != null && npcDialog == null && pestControlDialog == null)
		{
			String pointsString = boatPointsWidget.getText();
			Matcher matcher = BOAT_POINTS_PATTERN.matcher(pointsString);

			if (matcher.lookingAt())
			{
				log.debug(matcher.toString());
				log.debug("MATCHER GROUP 1: {}", matcher.group(1));
				setCommendationPoints(Integer.parseInt(matcher.group(1)));
				log.debug("PEST CONTROL [BOAT] POINTS UPDATE: {}", commendationPoints);
			}
		}
	}

	private void setCommendationPoints(int newPoints)
	{
		if (userConfigKey == null)
		{
			return;
		}

		if (commendationPoints == null || commendationPoints != newPoints)
		{
			commendationPoints = newPoints;

			configManager.setConfiguration(
				"pestcontrol",
				"points." + userConfigKey,
				String.valueOf(commendationPoints)
			);
		}

		handlePointsInfoboxCounter();
	}

	@Subscribe
	public void onGameTick(GameTick gameTickEvent)
	{
		// Check for widgets on main island
		if (game == null && isOnPestControlMainIsland())
		{
			// This must be synchronized for some reason
			synchronized (this)
			{
				if (checkForPointWidgets)
				{
					checkForPointWidgets = false;
					getPointsFromWidgets();
				}
			}
		}

		// Load the points of the user
		if (userConfigKey == null)
		{
			String username = client.getUsername();

			if (username == null)
			{
				return;
			}

			userConfigKey = String.valueOf(username.hashCode());

			log.debug("USER CONFIG SCOPE: {}", userConfigKey);

			if (loadLocalUserPoints())
			{
				handlePointsInfoboxCounter();
			}
		}

		// Check if the game has started
		if (game == null && isInPestControlInstance())
		{
			log.debug("Pest control game has started");
			game = new Game(client, this);
		}

		// Check if we are in a game
		if (game == null)
		{
			return;
		}

		// Check if we left the game
		if (!isInPestControlInstance())
		{
			if (game != null)
			{
				log.debug("Pest control game has ended");
				game = null;
			}

			return;
		}

		game.onGameTick(gameTickEvent);
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (game != null && chatMessage.getType() == ChatMessageType.GAMEMESSAGE)
		{
			Matcher matcher = SHIELD_DROP_PATTERN.matcher(chatMessage.getMessage());
			if (matcher.lookingAt())
			{
				game.lowerPortalShield(matcher.group(1));
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (game != null)
		{
			log.debug(event.toString());
		}

		if (isOnPestControlMainIsland() && game == null)
		{
			checkForPointWidgets = true;
		}
	}

	private void unlistTileObject(TileObject tileObject)
	{
		int tileObjectId = tileObject.getId();

		if (PestControlRepairObject.isRepairableBarricadeId(tileObjectId) ||
			PestControlRepairObject.isRepairableGateId(tileObjectId))
		{
			highlightedRepairList.remove(tileObject);
			return;
		}

		switch (tileObjectId)
		{
			case NOVICE_GANGPLANK:
			{
				noviceGangplankTile = null;
				break;
			}
			case INTERMEDIATE_GANGPLANK:
			{
				intermediateGangplankTile = null;
				break;
			}
			case VETERAN_GANGPLANK:
			{
				veteranGangplankTile = null;
				break;
			}
		}
	}

	private void handleTileObject(Tile tile, TileObject tileObject)
	{
		int tileObjectId = tileObject.getId();

		if (PestControlRepairObject.isRepairableBarricadeId(tileObjectId) ||
			PestControlRepairObject.isRepairableGateId(tileObjectId))
		{
			highlightedRepairList.add(tileObject);
			return;
		}

		switch (tileObjectId)
		{
			case NOVICE_GANGPLANK:
			{
				noviceGangplankTile = tile;
				break;
			}
			case INTERMEDIATE_GANGPLANK:
			{
				intermediateGangplankTile = tile;
				break;
			}
			case VETERAN_GANGPLANK:
			{
				veteranGangplankTile = tile;
				break;
			}
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		handleTileObject(event.getTile(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		unlistTileObject(event.getPrevious());
		handleTileObject(event.getTile(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		unlistTileObject(event.getGameObject());
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		handleTileObject(event.getTile(), event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectChanged(GroundObjectChanged event)
	{
		unlistTileObject(event.getPrevious());
		handleTileObject(event.getTile(), event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectDespawned(GroundObjectDespawned event)
	{
		unlistTileObject(event.getGroundObject());
	}

	private boolean isInPestControlInstance()
	{
		return client.getWidget(WidgetInfo.PEST_CONTROL_BLUE_SHIELD) != null;
	}

	boolean isOnPestControlMainIsland()
	{
		return client.getLocalPlayer().getWorldLocation().getRegionID() == 10537;
	}
}
