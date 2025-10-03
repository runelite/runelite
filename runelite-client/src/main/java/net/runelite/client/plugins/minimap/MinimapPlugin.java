/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.plugins.minimap;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
import net.runelite.api.QuestState;
import net.runelite.api.Scene;
import net.runelite.api.ScriptID;
import net.runelite.api.SpritePixels;
import net.runelite.api.Tile;
import net.runelite.api.annotations.Component;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Minimap",
	description = "Customize the color of minimap dots, visibility of icons, hide the minimap, and zoom",
	tags = {"items", "npcs", "players", "zoom", "icons"}
)
public class MinimapPlugin extends Plugin
{
	private static final int DOT_ITEM = 0;
	private static final int DOT_NPC = 1;
	private static final int DOT_PLAYER = 2;
	private static final int DOT_FRIEND = 3;
	private static final int DOT_TEAM = 4;
	private static final int DOT_FRIENDSCHAT = 5;
	private static final int DOT_CLAN = 6;
	private static final WorldPoint GROUP_IRONMAN_TRANSPORT_WORLD_POINT = new WorldPoint(3217, 3235, 0);

	@Inject
	private Client client;

	@Inject
	private MinimapConfig config;

	@Inject
	private ClientThread clientThread;

	private SpritePixels[] originalDotSprites;

	@Provides
	private MinimapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MinimapConfig.class);
	}

	@Override
	protected void startUp()
	{
		clientThread.invokeLater(() -> updateMinimapWidgetVisibility(config.hideMinimap()));
		storeOriginalDots();
		replaceMapDots();
		client.setMinimapZoom(config.zoom());
	}

	@Override
	protected void shutDown()
	{
		clientThread.invokeLater(() -> updateMinimapWidgetVisibility(false));
		restoreOriginalDots();
		client.setMinimapZoom(false);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		var state = event.getGameState();
		if (state == GameState.STARTING)
		{
			originalDotSprites = null;
		}
		else if (state == GameState.LOGIN_SCREEN && originalDotSprites == null)
		{
			storeOriginalDots();
			replaceMapDots();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(MinimapConfig.GROUP))
		{
			return;
		}

		if (event.getKey().equals("hideMinimap"))
		{
			clientThread.invokeLater(() -> updateMinimapWidgetVisibility(config.hideMinimap()));
			return;
		}
		else if (event.getKey().equals("zoom"))
		{
			client.setMinimapZoom(config.zoom());
			return;
		}

		restoreOriginalDots();
		replaceMapDots();
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.TOPLEVEL_REDRAW)
		{
			updateMinimapWidgetVisibility(config.hideMinimap());
		}
	}

	private void updateMinimapWidgetVisibility(boolean hide)
	{
		boolean vanillaHideMinimap = client.getVarbitValue(VarbitID.MINIMAP_TOGGLE) == 1;

		setHidden(InterfaceID.ToplevelOsrsStretch.MAP_MINIMAP, hide || vanillaHideMinimap);
		setHidden(InterfaceID.ToplevelOsrsStretch.ORBS, hide);

		setHidden(InterfaceID.ToplevelPreEoc.MAP_MINIMAP, hide || vanillaHideMinimap);
		setHidden(InterfaceID.ToplevelPreEoc.ORBS, hide);
	}

	private void setHidden(@Component int widget, boolean hide)
	{
		var w = client.getWidget(widget);

		if (w != null)
		{
			w.setHidden(hide);
		}
	}

	private void replaceMapDots()
	{
		SpritePixels[] mapDots = client.getMapDots();

		if (mapDots == null)
		{
			return;
		}

		applyDot(mapDots, DOT_ITEM, config.itemColor());
		applyDot(mapDots, DOT_NPC, config.npcColor());
		applyDot(mapDots, DOT_PLAYER, config.playerColor());
		applyDot(mapDots, DOT_FRIEND, config.friendColor());
		applyDot(mapDots, DOT_TEAM, config.teamColor());
		applyDot(mapDots, DOT_FRIENDSCHAT, config.friendsChatColor());
		applyDot(mapDots, DOT_CLAN, config.clanChatColor());
	}

	private void applyDot(SpritePixels[] mapDots, int id, Color color)
	{
		if (id < mapDots.length && color != null)
		{
			mapDots[id] = MinimapDot.create(client, color);
		}
	}

	private void storeOriginalDots()
	{
		SpritePixels[] originalDots = client.getMapDots();

		if (originalDots == null)
		{
			return;
		}

		originalDotSprites = Arrays.copyOf(originalDots, originalDots.length);
	}

	private void restoreOriginalDots()
	{
		SpritePixels[] mapDots = client.getMapDots();

		if (originalDotSprites == null || mapDots == null)
		{
			return;
		}

		System.arraycopy(originalDotSprites, 0, mapDots, 0, mapDots.length);
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		checkObjects(event.getGroundObject(), event.getTile());
	}

	private void checkObjects(GroundObject obj, Tile tile)
	{
		if (obj == null || tile == null)
		{
			return;
		}

		int groundObjectID = obj.getId();
		if (MinimapQuestObjectLookup.objectsToQuests.containsKey(groundObjectID))
		{
			if (config.questStartIcon() == MinimapConfig.questIconEnum.HIDE_ALL)
			{
				tile.setGroundObject(null);
			}
			else if (config.questStartIcon() == MinimapConfig.questIconEnum.VIEW_INCOMPLETE)
			{
				clientThread.invoke(() -> {
					if (MinimapQuestObjectLookup.objectsToQuests.get(groundObjectID).getState(client) == QuestState.FINISHED)
					{
						tile.setGroundObject(null);
					}
				});
			}
		}
		else
		{
			switch (groundObjectID)
			{
				case net.runelite.api.gameval.ObjectID.AGILITY_SHORTCUT_ICON:
					if (config.agilityShortcutIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.ALTAR_ICON:
				case net.runelite.api.gameval.ObjectID.ZALCANO_ALTAR:
					if (config.altarIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.BANK_STORE_ICON:
					if (config.bankIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.CLAN_HUB_ICON:
					if (config.clanHubIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.COMBAT_ACHIEVEMENTS_ICON:
					if (config.combatAchievementsIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.DEATH_OFFICE_ICON:
					if (config.deathsOfficeIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.DANDD_ICON:
					if (config.distractionAndDiversionIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.DUNGEONENTRANCE_ICON_CLICKABLE:
				case
					net.runelite.api.gameval.ObjectID.MAPLINK_ICON: // Should be exclusive to the WorldMap but included just in case
				case net.runelite.api.gameval.ObjectID.DUNGEONENTRANCE_ICON:
					if (config.dungeonIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.HAIRDRESSER_ICON:
					if (config.hairdresserIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.HOLIDAY_EVENT_ICON:
					if (config.holidayEventIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.POH_PORTAL_ICON:
					if (config.housePortalIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.MAKEOVERMAGE_ICON:
					if (config.makeoverMageIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.MINIGAME_START_ICON:
					if (config.minigameIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.POLL_BOOTH_ICON:
					if (config.pollBoothIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.RAID_ICON:
					if (config.raidIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TASK_ICON:
					if (config.taskMasterIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON:
					if (tile.getWorldLocation() == GROUP_IRONMAN_TRANSPORT_WORLD_POINT && config.groupIronmanTransportationIcon())
					{
						tile.setGroundObject(null);
					}
					else if (config.transportationIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AIP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AIS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AIR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AIQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_ALP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_ALS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_ALR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AKP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AKS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AKR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AKQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AJP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AJS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AJR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_AJQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DIP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DIS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DIR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DIQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DLP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DLS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DLR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DLQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DKP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DKS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DKR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DKQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DJP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DJS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DJR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_DJQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CIP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CIS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CIR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CIQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CLP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CLS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CLR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CLQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CKP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CKS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CKR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CKQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CJP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CJS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CJR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_CJQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BIP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BIS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BIR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BIQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BLP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BLS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BLR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BLQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BKP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BKS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BKR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BKQ:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BJP:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BJS:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BJR:
				case net.runelite.api.gameval.ObjectID.TRANSPORTATION_ICON_BJQ:
					if (config.fairyRingTransportationIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_BANK_ICON:
					if (config.bankTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_BOND_ICON:
					if (config.bondTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.CLUESCROLL_TUTOR_ICON:
					if (config.clueTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_COMBAT_ICON:
					if (config.combatTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_COOKING_ICON:
					if (config.cookingTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_CRAFTING_ICON:
					if (config.craftingTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_DANGER_ICON:
					if (config.dangerTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_DEADMAN_ICON:
					if (config.deadmanTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_FISHING_ICON:
					if (config.fishingTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_HUNTER_ICON:
					if (config.hunterTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_IRONMAN_ICON:
					if (config.ironmanTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.LEAGUE_TUTOR_ICON:
					if (config.leaguesTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_MAIN_ICON:
					if (config.lumbridgeGuideIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_MINING_ICON:
					if (config.miningTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_PRAYER_ICON:
					if (config.prayerTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_SECURITY_ICON:
					if (config.securityTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_SMITHING_ICON:
					if (config.smithingTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TUTOR_WOODCUTTING_ICON:
					if (config.woodcuttingTutorIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.AGILITY_TRAINING_ICON:
					if (config.agilityCourseIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.ANVIL_ICON:
					if (config.anvilIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.BIRD_HOUSE_ICON:
					if (config.birdHouseSiteIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.BREWING_ICON:
					if (config.breweryIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.COMBATTRAINING_STORE_ICON:
					if (config.combatTrainingIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.RANGE_ICON_KITCHEN:
				case net.runelite.api.gameval.ObjectID.RANGE_ICON:
					if (config.cookingRangeIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.MILK_CHURN_ICON:
					if (config.dairyChurnIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.DAIRY_COW_ICON:
					if (config.dairyCowIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FARMING_PATCH_ICON:
					if (config.farmingPatchIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FISHING_POINT_ICON:
					if (config.fishingSpotIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FURNACE_ICON:
					if (config.furnaceIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.GIANTS_FOUNDRY_TOOL_GRINDSTONE:
					if (config.grindstoneIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.HUNTING_AREA_ICON:
					if (config.hunterTrainingIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.LOOM_ICON:
					if (config.loomIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.MINING_SITE_ICON:
					if (config.miningSiteIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.GIANTS_FOUNDRY_TOOL_POLISHING_WHEEL:
					if (config.polishingWheelIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.POTTERY_ICON:
					if (config.potteryWheelIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.RARE_TREES_ICON:
					if (config.rareTreesIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SANDPIT_ICON:
					if (config.sandpitIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SINGING_BOWL_ICON:
					if (config.singingBowlIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SLAYER_MASTER_ICON:
					if (config.slayerMasterIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SPINNINGWHEEL_ICON:
					if (config.spinningWheelIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.STAGNENT_WATER_ICON:
					if (config.stagnantWaterSourceIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.THIEVING_ICON:
					if (config.thievingActivityIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.GIANTS_FOUNDRY_TOOL_TRIP_HAMMER:
					if (config.tripHammerIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.V3_TOTEM_ICON:
					if (config.valeTotemIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.WATER_SOURCE_ICON_KITCHEN:
				case net.runelite.api.gameval.ObjectID.WATER_SOURCE_ICON:
					if (config.waterSourceIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FLOUR_MILL_ICON:
					if (config.windmillIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FRIS_TREESTUMP_ICON:
					if (config.woodcuttingStumpIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.AMULET_STORE_ICON:
					if (config.amuletShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.POTIONS_STORE_ICON:
					if (config.apothecaryIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.ARCHERY_STORE_ICON:
					if (config.archeryShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.AXE_STORE_ICON:
					if (config.axeShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.BH_ICON:
					if (config.bountyHunterTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.CANDLE_STORE_ICON:
					if (config.candleShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.CHAIN_SHOP_ICON:
					if (config.chainbodyShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.CLOTHING_STORE_ICON:
					if (config.clothesShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.CRAFTING_STORE_ICON:
					if (config.craftingShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.DYE_TRADER_ICON:
					if (config.dyeTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.POH_ESTATEAGENT_ICON:
					if (config.estateAgentIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FARM_SHOP_ICON:
					if (config.farmingShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FISHING_STORE_ICON:
					if (config.fishingShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.COOKING_STORE_ICON:
				case net.runelite.api.gameval.ObjectID.FOOD_STORE_ICON:
				case net.runelite.api.gameval.ObjectID.KEBAB_STORE_ICON:
				case net.runelite.api.gameval.ObjectID.VEG_STORE_ICON:
					if (config.foodShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FORESTRY_SHOP_ICON:
					if (config.forestryShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.FUR_STORE_ICON:
					if (config.furTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.GARDEN_SUPPLIER_ICON:
					if (config.gardenSupplierIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.GEM_STORE_ICON:
					if (config.gemShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.GENERAL_STORE_ICON:
					if (config.generalStoreIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.GE_MAPICON_EXCHANGE:
				case net.runelite.api.gameval.ObjectID.GE_MAPICON_RUNES:
				case net.runelite.api.gameval.ObjectID.GE_MAPICON_HERBS:
				case net.runelite.api.gameval.ObjectID.GE_MAPICON_LOGS:
				case net.runelite.api.gameval.ObjectID.GE_MAPICON_ORES:
				case net.runelite.api.gameval.ObjectID.GE_MAPICON_COMBAT:
					if (config.grandExchangeIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.HELMET_STORE_ICON:
					if (config.helmetShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.HERBALIST_STORE_ICON:
					if (config.herbalistIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.HOLIDAY_SHOP_ICON:
					if (config.holidayItemTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.HUNTING_SHOP_ICON:
					if (config.hunterShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.JEWLERY_STORE_ICON:
					if (config.jewelleryShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.QUEST_SHOP_ICON:
					if (config.junkCheckerIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.MACE_STORE_ICON:
					if (config.maceShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.MAGIC_STORE_ICON:
					if (config.magicShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.MINING_SHOP_ICON:
					if (config.miningShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.NEWSPAPER_TRADER_ICON:
					if (config.newspaperTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.PET_ICON:
					if (config.petInsuranceIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.PLATE_STORE_ICON:
					if (config.platebodyShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.PLATELEGS_STORE_ICON:
					if (config.platelegsShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SKIRTS_STORE_ICON:
					if (config.plateskirtShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.BEER_STORE_ICON:
					if (config.pubIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.ROPE_TRADER_ICON:
					if (config.ropeTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.POH_SAWMILL_ICON:
					if (config.sawmillIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SCIMITAR_STORE_ICON:
					if (config.scimitarShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SHIELD_STORE_ICON:
					if (config.shieldShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SILK_STORE_ICON:
					if (config.silkTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SILVER_STORE_ICON:
					if (config.silverShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SPEEDRUNNING_ICON:
					if (config.speedrunningShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SPICE_STORE_ICON:
					if (config.spiceShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.STAFF_STORE_ICON:
					if (config.staffShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.POH_STONEMASON_ICON:
					if (config.stonemasonIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.SWORD_STORE_ICON:
					if (config.swordShopIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TANNER_STORE_ICON:
					if (config.tanneryIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TAXIDERMIST_ICON:
					if (config.taxidermistIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case net.runelite.api.gameval.ObjectID.TEA_SELLER_ICON:
					if (config.teaTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
				case ObjectID.WINE_TRADER_ICON:
					if (config.wineTraderIcon())
					{
						tile.setGroundObject(null);
					}
					break;
			}
		}
	}

	private void refreshSceneGroundObjects()
	{
		final Scene scene = client.getScene();
		final Tile[][][] tiles = scene.getTiles();

		if (tiles != null)
		{
			for (int plane = 0; plane < tiles.length; plane++)
			{
				for (int x = 0; x < tiles[plane].length; x++)
				{
					for (int y = 0; y < tiles[plane][x].length; y++)
					{
						final Tile currentTile = tiles[plane][x][y];
						if (currentTile != null)
						{
							checkObjects(currentTile.getGroundObject(), currentTile);
						}
					}
				}
			}
		}

		// Ground Object updates but MiniMap doesn't refresh unless this is called
		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				client.setGameState(GameState.LOADING);
			}
		});
	}
}