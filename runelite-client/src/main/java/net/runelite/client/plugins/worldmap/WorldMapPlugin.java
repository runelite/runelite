/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.worldmap;

import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.function.Predicate;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.AgilityShortcut;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "World Map",
	description = "Enhance the world map to display additional information",
	tags = {"agility", "dungeon", "fairy", "farming", "rings", "teleports"}
)
public class WorldMapPlugin extends Plugin
{
	static final BufferedImage BLANK_ICON;
	private static final BufferedImage FAIRY_TRAVEL_ICON;
	private static final BufferedImage NOPE_ICON;
	private static final BufferedImage NOT_STARTED_ICON;
	private static final BufferedImage STARTED_ICON;
	private static final BufferedImage FINISHED_ICON;
	private static final BufferedImage MINING_SITE_ICON;
	private static final BufferedImage ROOFTOP_COURSE_ICON;

	static final String CONFIG_KEY = "worldmap";
	static final String CONFIG_KEY_FAIRY_RING_TOOLTIPS = "fairyRingTooltips";
	static final String CONFIG_KEY_FAIRY_RING_ICON = "fairyRingIcon";
	static final String CONFIG_KEY_AGILITY_SHORTCUT_TOOLTIPS = "agilityShortcutTooltips";
	static final String CONFIG_KEY_AGILITY_SHORTCUT_LEVEL_ICON = "agilityShortcutIcon";
	static final String CONFIG_KEY_AGILITY_COURSE_TOOLTIPS = "agilityCourseTooltips";
	static final String CONFIG_KEY_AGILITY_COURSE_ROOFTOP_ICON = "agilityCourseRooftopIcon";
	static final String CONFIG_KEY_NORMAL_TELEPORT_ICON = "standardSpellbookIcon";
	static final String CONFIG_KEY_ANCIENT_TELEPORT_ICON = "ancientSpellbookIcon";
	static final String CONFIG_KEY_LUNAR_TELEPORT_ICON = "lunarSpellbookIcon";
	static final String CONFIG_KEY_ARCEUUS_TELEPORT_ICON = "arceuusSpellbookIcon";
	static final String CONFIG_KEY_JEWELLERY_TELEPORT_ICON = "jewelleryIcon";
	static final String CONFIG_KEY_SCROLL_TELEPORT_ICON = "scrollIcon";
	static final String CONFIG_KEY_MISC_TELEPORT_ICON = "miscellaneousTeleportIcon";
	static final String CONFIG_KEY_QUEST_START_TOOLTIPS = "questStartTooltips";
	static final String CONFIG_KEY_MINIGAME_TOOLTIP = "minigameTooltip";
	static final String CONFIG_KEY_FARMING_PATCH_TOOLTIPS = "farmingpatchTooltips";
	static final String CONFIG_KEY_RARE_TREE_TOOLTIPS = "rareTreeTooltips";
	static final String CONFIG_KEY_RARE_TREE_LEVEL_ICON = "rareTreeIcon";
	static final String CONFIG_KEY_TRANSPORTATION_TELEPORT_TOOLTIPS = "transportationTooltips";
	static final String CONFIG_KEY_RUNECRAFTING_ALTAR_ICON = "runecraftingAltarIcon";
	static final String CONFIG_KEY_MINING_SITE_TOOLTIPS = "miningSiteTooltips";
	static final String CONFIG_KEY_DUNGEON_TOOLTIPS = "dungeonTooltips";
	static final String CONFIG_KEY_HUNTER_AREA_TOOLTIPS = "hunterAreaTooltips";
	static final String CONFIG_KEY_FISHING_SPOT_TOOLTIPS = "fishingSpotTooltips";
	static final String CONFIG_KEY_KOUREND_TASK_TOOLTIPS = "kourendTaskTooltips";

	static
	{
		//A size of 17 gives us a buffer when triggering tooltips
		final int iconBufferSize = 17;

		//Quest icons are a bit bigger.
		final int questIconBufferSize = 22;

		BLANK_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);

		FAIRY_TRAVEL_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage fairyTravelIcon = ImageUtil.loadImageResource(WorldMapPlugin.class, "fairy_ring_travel.png");
		FAIRY_TRAVEL_ICON.getGraphics().drawImage(fairyTravelIcon, 1, 1, null);

		NOPE_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage nopeImage = ImageUtil.loadImageResource(WorldMapPlugin.class, "nope_icon.png");
		NOPE_ICON.getGraphics().drawImage(nopeImage, 1, 1, null);

		NOT_STARTED_ICON = new BufferedImage(questIconBufferSize, questIconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage notStartedIcon = ImageUtil.loadImageResource(WorldMapPlugin.class, "quest_not_started_icon.png");
		NOT_STARTED_ICON.getGraphics().drawImage(notStartedIcon, 4, 4, null);

		STARTED_ICON = new BufferedImage(questIconBufferSize, questIconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage startedIcon = ImageUtil.loadImageResource(WorldMapPlugin.class, "quest_started_icon.png");
		STARTED_ICON.getGraphics().drawImage(startedIcon, 4, 4, null);

		FINISHED_ICON = new BufferedImage(questIconBufferSize, questIconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage finishedIcon = ImageUtil.loadImageResource(WorldMapPlugin.class, "quest_completed_icon.png");
		FINISHED_ICON.getGraphics().drawImage(finishedIcon, 4, 4, null);

		MINING_SITE_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage miningSiteIcon = ImageUtil.loadImageResource(WorldMapPlugin.class, "mining_site_icon.png");
		MINING_SITE_ICON.getGraphics().drawImage(miningSiteIcon, 1, 1, null);

		ROOFTOP_COURSE_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage rooftopCourseIcon = ImageUtil.loadImageResource(WorldMapPlugin.class, "rooftop_course_icon.png");
		ROOFTOP_COURSE_ICON.getGraphics().drawImage(rooftopCourseIcon, 1, 1, null);
	}

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private WorldMapConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	private int agilityLevel = 0;
	private int woodcuttingLevel = 0;

	@Provides
	WorldMapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldMapConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		agilityLevel = client.getRealSkillLevel(Skill.AGILITY);
		woodcuttingLevel = client.getRealSkillLevel(Skill.WOODCUTTING);
		updateShownIcons();
	}

	@Override
	protected void shutDown() throws Exception
	{
		worldMapPointManager.removeIf(MapPoint.class::isInstance);
		agilityLevel = 0;
		woodcuttingLevel = 0;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_KEY))
		{
			return;
		}

		updateShownIcons();
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		switch (statChanged.getSkill())
		{
			case AGILITY:
			{
				int newAgilityLevel = statChanged.getBoostedLevel();
				if (newAgilityLevel != agilityLevel)
				{
					agilityLevel = newAgilityLevel;
					updateAgilityIcons();
				}
				break;
			}
			case WOODCUTTING:
			{
				int newWoodcutLevel = statChanged.getBoostedLevel();
				if (newWoodcutLevel != woodcuttingLevel)
				{
					woodcuttingLevel = newWoodcutLevel;
					updateRareTreeIcons();
				}
				break;
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.WORLD_MAP_GROUP_ID)
		{
			// Quest icons are per-account due to showing quest status,
			// so we recreate them each time the map is loaded
			updateQuestStartPointIcons();
		}
	}

	private void updateAgilityIcons()
	{
		worldMapPointManager.removeIf(isType(MapPoint.Type.AGILITY_SHORTCUT));

		if (config.agilityShortcutLevelIcon() || config.agilityShortcutTooltips())
		{
			Arrays.stream(AgilityShortcut.values())
				.filter(value -> value.getWorldMapLocation() != null)
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.AGILITY_SHORTCUT)
						.worldPoint(l.getWorldMapLocation())
						.image(agilityLevel > 0 && config.agilityShortcutLevelIcon() && l.getLevel() > agilityLevel ? NOPE_ICON : BLANK_ICON)
						.tooltip(config.agilityShortcutTooltips() ? l.getTooltip() : null)
						.build()
				)
				.forEach(worldMapPointManager::add);
		}
	}

	private void updateAgilityCourseIcons()
	{
		worldMapPointManager.removeIf(isType(MapPoint.Type.AGILITY_COURSE));

		if (config.agilityCourseTooltip() || config.agilityCourseRooftop())
		{
			Arrays.stream(AgilityCourseLocation.values())
				.filter(value -> value.getLocation() != null)
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.AGILITY_COURSE)
						.worldPoint(l.getLocation())
						.image(config.agilityCourseRooftop() && l.isRooftopCourse() ? ROOFTOP_COURSE_ICON : BLANK_ICON)
						.tooltip(config.agilityCourseTooltip() ? l.getTooltip() : null)
						.build()
				)
				.forEach(worldMapPointManager::add);
		}
	}

	private void updateRareTreeIcons()
	{
		worldMapPointManager.removeIf(isType(MapPoint.Type.RARE_TREE));

		if (config.rareTreeLevelIcon() || config.rareTreeTooltips())
		{
			Arrays.stream(RareTreeLocation.values()).forEach(rareTree ->
				Arrays.stream(rareTree.getLocations())
					.map(point ->
						MapPoint.builder()
							.type(MapPoint.Type.RARE_TREE)
							.worldPoint(point)
							.image(woodcuttingLevel > 0 && config.rareTreeLevelIcon() &&
								rareTree.getLevelReq() > woodcuttingLevel ? NOPE_ICON : BLANK_ICON)
							.tooltip(config.rareTreeTooltips() ? rareTree.getTooltip() : null)
							.build()
					)
					.forEach(worldMapPointManager::add));
		}
	}

	private void updateShownIcons()
	{
		updateAgilityIcons();
		updateAgilityCourseIcons();
		updateRareTreeIcons();
		updateQuestStartPointIcons();

		worldMapPointManager.removeIf(isType(MapPoint.Type.FAIRY_RING));
		if (config.fairyRingIcon() || config.fairyRingTooltips())
		{
			Arrays.stream(FairyRingLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.FAIRY_RING)
						.worldPoint(l.getLocation())
						.image(config.fairyRingIcon() ? FAIRY_TRAVEL_ICON : BLANK_ICON)
						.tooltip(config.fairyRingTooltips() ? "Fairy Ring - " + l.getCode() : null)
						.build()
				)
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.MINIGAME));
		if (config.minigameTooltip())
		{
			Arrays.stream(MinigameLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.MINIGAME)
						.worldPoint(l.getLocation())
						.image(BLANK_ICON)
						.tooltip(l.getTooltip())
						.build()
				)
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.TRANSPORTATION));
		if (config.transportationTeleportTooltips())
		{
			Arrays.stream(TransportationPointLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.TRANSPORTATION)
						.worldPoint(l.getLocation())
						.image(BLANK_ICON)
						.target(l.getTarget())
						.jumpOnClick(l.getTarget() != null)
						.tooltip(l.getTooltip())
						.build()
				)
				.forEach((worldMapPointManager::add));
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.FARMING_PATCH));
		if (config.farmingPatchTooltips())
		{
			Arrays.stream(FarmingPatchLocation.values()).forEach(location ->
				Arrays.stream(location.getLocations())
					.map(point ->
						MapPoint.builder()
							.type(MapPoint.Type.FARMING_PATCH)
							.worldPoint(point)
							.image(BLANK_ICON)
							.tooltip(location.getTooltip())
							.build()
					)
					.forEach(worldMapPointManager::add)
			);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.TELEPORT));
		Arrays.stream(TeleportLocationData.values())
			.filter(data ->
			{
				switch (data.getType())
				{
					case NORMAL_MAGIC:
						return config.normalTeleportIcon();
					case ANCIENT_MAGICKS:
						return config.ancientTeleportIcon();
					case LUNAR_MAGIC:
						return config.lunarTeleportIcon();
					case ARCEUUS_MAGIC:
						return config.arceuusTeleportIcon();
					case JEWELLERY:
						return config.jewelleryTeleportIcon();
					case SCROLL:
						return config.scrollTeleportIcon();
					case OTHER:
						return config.miscellaneousTeleportIcon();
					default:
						return false;
				}
			})
			.map(l ->
				MapPoint.builder()
					.type(MapPoint.Type.TELEPORT)
					.worldPoint(l.getLocation())
					.tooltip(l.getTooltip())
					.image(ImageUtil.loadImageResource(WorldMapPlugin.class, l.getIconPath()))
					.build()
			)
			.forEach(worldMapPointManager::add);

		worldMapPointManager.removeIf(isType(MapPoint.Type.RUNECRAFT_ALTAR));
		if (config.runecraftingAltarIcon())
		{
			Arrays.stream(RunecraftingAltarLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.RUNECRAFT_ALTAR)
						.worldPoint(l.getLocation())
						.image(ImageUtil.loadImageResource(WorldMapPlugin.class, l.getIconPath()))
						.tooltip(l.getTooltip())
						.build()
				)
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.MINING_SITE));
		if (config.miningSiteTooltips())
		{
			Arrays.stream(MiningSiteLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.MINING_SITE)
						.worldPoint(l.getLocation())
						.image(l.isIconRequired() ? MINING_SITE_ICON : BLANK_ICON)
						.tooltip(l.getTooltip())
						.build()
				)
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.DUNGEON));
		if (config.dungeonTooltips())
		{
			Arrays.stream(DungeonLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.DUNGEON)
						.worldPoint(l.getLocation())
						.image(BLANK_ICON)
						.tooltip(l.getTooltip())
						.build()
				)
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.HUNTER));
		if (config.hunterAreaTooltips())
		{
			Arrays.stream(HunterAreaLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.HUNTER)
						.worldPoint(l.getLocation())
						.image(BLANK_ICON)
						.tooltip(l.getTooltip())
						.build()
				)
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.FISHING));
		if (config.fishingSpotTooltips())
		{
			Arrays.stream(FishingSpotLocation.values()).forEach(location ->
				Arrays.stream(location.getLocations())
					.map(point ->
						MapPoint.builder()
							.type(MapPoint.Type.FISHING)
							.worldPoint(point)
							.image(BLANK_ICON)
							.tooltip(location.getTooltip())
							.build()
					)
					.forEach(worldMapPointManager::add)
			);
		}

		worldMapPointManager.removeIf(isType(MapPoint.Type.KOUREND_TASK));
		if (config.kourendTaskTooltips())
		{
			Arrays.stream(KourendTaskLocation.values())
				.map(l ->
					MapPoint.builder()
						.type(MapPoint.Type.KOUREND_TASK)
						.worldPoint(l.getLocation())
						.image(BLANK_ICON)
						.tooltip(l.getTooltip())
						.build()
				)
				.forEach(worldMapPointManager::add);
		}
	}

	private void updateQuestStartPointIcons()
	{
		worldMapPointManager.removeIf(isType(MapPoint.Type.QUEST));

		if (!config.questStartTooltips())
		{
			return;
		}

		// Must setup the quest icons on the client thread, after the player has logged in.
		clientThread.invokeLater(() ->
		{
			if (client.getGameState() != GameState.LOGGED_IN)
			{
				return false;
			}

			Arrays.stream(QuestStartLocation.values())
				.map(this::createQuestStartPoint)
				.forEach(worldMapPointManager::add);
			return true;
		});
	}

	private MapPoint createQuestStartPoint(QuestStartLocation data)
	{
		Quest[] quests = data.getQuests();

		// Get first uncompleted quest. Else, return the last quest.
		Quest quest = null;
		for (Quest q : quests)
		{
			if (q.getState(client) != QuestState.FINISHED)
			{
				quest = q;
				break;
			}
		}
		if (quest == null)
		{
			quest = quests[quests.length - 1];
		}

		BufferedImage icon = BLANK_ICON;
		String tooltip = "";
		if (quest != null)
		{
			tooltip = quest.getName();
			switch (quest.getState(client))
			{
				case FINISHED:
					icon = FINISHED_ICON;
					tooltip += " - Finished";
					break;
				case IN_PROGRESS:
					icon = STARTED_ICON;
					tooltip += " - Started";
					break;
				case NOT_STARTED:
					icon = NOT_STARTED_ICON;
					tooltip += " - Not Started";
					break;
			}
		}

		return MapPoint.builder()
			.type(MapPoint.Type.QUEST)
			.worldPoint(data.getLocation())
			.image(icon)
			.tooltip(tooltip)
			.build();
	}

	private static Predicate<WorldMapPoint> isType(MapPoint.Type type)
	{
		return w -> w instanceof MapPoint && ((MapPoint) w).getType() == type;
	}
}
