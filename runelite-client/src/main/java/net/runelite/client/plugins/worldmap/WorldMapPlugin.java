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
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.AgilityShortcut;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "World Map",
	description = "Enhance the world map to display additional information",
	tags = {"agility", "fairy", "farming", "rings", "teleports"}
)
public class WorldMapPlugin extends Plugin
{
	static final BufferedImage BLANK_ICON;
	private static final BufferedImage FAIRY_TRAVEL_ICON;
	private static final BufferedImage NOPE_ICON;
	private static final BufferedImage NOT_STARTED_ICON;
	private static final BufferedImage STARTED_ICON;
	private static final BufferedImage FINISHED_ICON;

	static final String CONFIG_KEY = "worldmap";
	static final String CONFIG_KEY_FAIRY_RING_TOOLTIPS = "fairyRingTooltips";
	static final String CONFIG_KEY_FAIRY_RING_ICON = "fairyRingIcon";
	static final String CONFIG_KEY_AGILITY_SHORTCUT_TOOLTIPS = "agilityShortcutTooltips";
	static final String CONFIG_KEY_AGILITY_SHORTCUT_LEVEL_ICON = "agilityShortcutIcon";
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
	static final String CONFIG_KEY_TRANSPORATION_TELEPORT_TOOLTIPS = "transportationTooltips";

	static
	{
		//A size of 17 gives us a buffer when triggering tooltips
		final int iconBufferSize = 17;

		//Quest icons are a bit bigger.
		final int questIconBufferSize = 22;

		BLANK_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);

		FAIRY_TRAVEL_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage fairyTravelIcon = ImageUtil.getResourceStreamFromClass(WorldMapPlugin.class, "fairy_ring_travel.png");
		FAIRY_TRAVEL_ICON.getGraphics().drawImage(fairyTravelIcon, 1, 1, null);

		NOPE_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage nopeImage = ImageUtil.getResourceStreamFromClass(WorldMapPlugin.class, "nope_icon.png");
		NOPE_ICON.getGraphics().drawImage(nopeImage, 1, 1, null);

		NOT_STARTED_ICON = new BufferedImage(questIconBufferSize, questIconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage notStartedIcon = ImageUtil.getResourceStreamFromClass(WorldMapPlugin.class, "quest_not_started_icon.png");
		NOT_STARTED_ICON.getGraphics().drawImage(notStartedIcon, 4, 4, null);

		STARTED_ICON = new BufferedImage(questIconBufferSize, questIconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage startedIcon = ImageUtil.getResourceStreamFromClass(WorldMapPlugin.class, "quest_started_icon.png");
		STARTED_ICON.getGraphics().drawImage(startedIcon, 4, 4, null);

		FINISHED_ICON = new BufferedImage(questIconBufferSize, questIconBufferSize, BufferedImage.TYPE_INT_ARGB);
		final BufferedImage finishedIcon = ImageUtil.getResourceStreamFromClass(WorldMapPlugin.class, "quest_completed_icon.png");
		FINISHED_ICON.getGraphics().drawImage(finishedIcon, 4, 4, null);
	}

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private WorldMapConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private EventBus eventBus;

	@Inject
	private ScheduledExecutorService executor;

	private int agilityLevel = 0;
	private int woodcuttingLevel = 0;

	private boolean fairyRingTooltips;
	private boolean fairyRingIcon;
	private boolean agilityShortcutTooltips;
	private boolean agilityShortcutLevelIcon;
	private boolean normalTeleportIcon;
	private boolean minigameTooltip;
	private boolean ancientTeleportIcon;
	private boolean lunarTeleportIcon;
	private boolean arceuusTeleportIcon;
	private boolean jewelleryTeleportIcon;
	private boolean scrollTeleportIcon;
	private boolean miscellaneousTeleportIcon;
	private boolean questStartTooltips;
	private boolean farmingPatchTooltips;
	private boolean rareTreeTooltips;
	private boolean rareTreeLevelIcon;
	private boolean transportationTeleportTooltips;

	@Provides
	WorldMapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldMapConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		agilityLevel = client.getRealSkillLevel(Skill.AGILITY);
		woodcuttingLevel = client.getRealSkillLevel(Skill.WOODCUTTING);
		updateShownIcons();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		worldMapPointManager.removeIf(FairyRingPoint.class::isInstance);
		worldMapPointManager.removeIf(AgilityShortcutPoint.class::isInstance);
		worldMapPointManager.removeIf(QuestStartPoint.class::isInstance);
		worldMapPointManager.removeIf(TeleportPoint.class::isInstance);
		worldMapPointManager.removeIf(TransportationPoint.class::isInstance);
		worldMapPointManager.removeIf(MinigamePoint.class::isInstance);
		worldMapPointManager.removeIf(FarmingPatchPoint.class::isInstance);
		worldMapPointManager.removeIf(RareTreePoint.class::isInstance);
		agilityLevel = 0;
		woodcuttingLevel = 0;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ExperienceChanged.class, this, this::onExperienceChanged);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_KEY))
		{
			return;
		}

		updateConfig();
		updateShownIcons();
	}

	private void onExperienceChanged(ExperienceChanged event)
	{
		if (event.getSkill() == Skill.AGILITY)
		{
			int newAgilityLevel = Experience.getLevelForXp(client.getSkillExperience(Skill.AGILITY));
			if (newAgilityLevel != agilityLevel)
			{
				agilityLevel = newAgilityLevel;
				updateAgilityIcons();
			}
		}

		if (event.getSkill() == Skill.WOODCUTTING)
		{
			int newWoodcutLevel = Experience.getLevelForXp(client.getSkillExperience(Skill.WOODCUTTING));
			if (newWoodcutLevel != woodcuttingLevel)
			{
				woodcuttingLevel = newWoodcutLevel;
				updateRareTreeIcons();
			}
		}
	}

	private void onWidgetLoaded(WidgetLoaded widgetLoaded)
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
		worldMapPointManager.removeIf(AgilityShortcutPoint.class::isInstance);

		if (this.agilityShortcutLevelIcon || this.agilityShortcutTooltips)
		{
			Arrays.stream(AgilityShortcut.values())
				.filter(value -> value.getWorldMapLocation() != null)
				.map(value -> new AgilityShortcutPoint(value,
					agilityLevel > 0 && this.agilityShortcutLevelIcon && value.getLevel() > agilityLevel ? NOPE_ICON : BLANK_ICON,
					this.agilityShortcutTooltips))
				.forEach(worldMapPointManager::add);
		}
	}

	private void updateRareTreeIcons()
	{
		worldMapPointManager.removeIf(RareTreePoint.class::isInstance);

		if (this.rareTreeLevelIcon || this.rareTreeTooltips)
		{
			Arrays.stream(RareTreeLocation.values()).forEach(rareTree ->
				Arrays.stream(rareTree.getLocations())
					.map(point -> new RareTreePoint(point,
						rareTree.getTooltip(),
						woodcuttingLevel > 0 && this.rareTreeLevelIcon &&
							rareTree.getLevelReq() > woodcuttingLevel ? NOPE_ICON : BLANK_ICON,
						this.rareTreeTooltips))
					.forEach(worldMapPointManager::add));
		}
	}

	private void updateShownIcons()
	{
		updateAgilityIcons();
		updateRareTreeIcons();
		updateQuestStartPointIcons();

		worldMapPointManager.removeIf(FairyRingPoint.class::isInstance);
		if (this.fairyRingIcon || this.fairyRingTooltips)
		{
			Arrays.stream(FairyRingLocation.values())
				.map(value -> new FairyRingPoint(value,
					this.fairyRingIcon ? FAIRY_TRAVEL_ICON : BLANK_ICON,
					this.fairyRingTooltips))
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(MinigamePoint.class::isInstance);
		if (this.minigameTooltip)
		{
			Arrays.stream(MinigameLocation.values())
				.map(value -> new MinigamePoint(value, BLANK_ICON))
				.forEach(worldMapPointManager::add);
		}

		worldMapPointManager.removeIf(TransportationPoint.class::isInstance);
		if (this.transportationTeleportTooltips)
		{
			Arrays.stream(TransportationPointLocation.values())
				.map(value -> new TransportationPoint(value, BLANK_ICON))
				.forEach((worldMapPointManager::add));
		}

		worldMapPointManager.removeIf(FarmingPatchPoint.class::isInstance);
		if (this.farmingPatchTooltips)
		{
			Arrays.stream(FarmingPatchLocation.values()).forEach(location ->
				Arrays.stream(location.getLocations())
					.map(point -> new FarmingPatchPoint(point, location.getTooltip(), BLANK_ICON))
					.forEach(worldMapPointManager::add)
			);
		}

		worldMapPointManager.removeIf(TeleportPoint.class::isInstance);
		// This next part gets 142 icons from disk, and does so on the EDT (at first run)
		executor.submit(() ->
			Arrays.stream(TeleportLocationData.values())
				.filter(data ->
				{
					switch (data.getType())
					{
						case NORMAL_MAGIC:
							return this.normalTeleportIcon;
						case ANCIENT_MAGICKS:
							return this.ancientTeleportIcon;
						case LUNAR_MAGIC:
							return this.lunarTeleportIcon;
						case ARCEUUS_MAGIC:
							return this.arceuusTeleportIcon;
						case JEWELLERY:
							return this.jewelleryTeleportIcon;
						case SCROLL:
							return this.scrollTeleportIcon;
						case OTHER:
							return this.miscellaneousTeleportIcon;
						default:
							return false;
					}
				}).map(TeleportPoint::new)
				.forEach(worldMapPointManager::add)
			);
	}

	private void updateQuestStartPointIcons()
	{
		worldMapPointManager.removeIf(QuestStartPoint.class::isInstance);

		if (!this.questStartTooltips)
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

	private QuestStartPoint createQuestStartPoint(QuestStartLocation data)
	{
		Quest[] quests = data.getQuests();

		// Get first uncompleted quest. Else, return the last quest.
		Quest quest = null;
		for (Quest value : quests)
		{
			if (value.getState(client) != QuestState.FINISHED)
			{
				quest = value;
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

		return new QuestStartPoint(data.getLocation(), icon, tooltip);
	}

	private void updateConfig()
	{
		this.fairyRingTooltips = config.fairyRingTooltips();
		this.fairyRingIcon = config.fairyRingIcon();
		this.agilityShortcutTooltips = config.agilityShortcutTooltips();
		this.agilityShortcutLevelIcon = config.agilityShortcutLevelIcon();
		this.normalTeleportIcon = config.normalTeleportIcon();
		this.minigameTooltip = config.minigameTooltip();
		this.ancientTeleportIcon = config.ancientTeleportIcon();
		this.lunarTeleportIcon = config.lunarTeleportIcon();
		this.arceuusTeleportIcon = config.arceuusTeleportIcon();
		this.jewelleryTeleportIcon = config.jewelleryTeleportIcon();
		this.scrollTeleportIcon = config.scrollTeleportIcon();
		this.miscellaneousTeleportIcon = config.miscellaneousTeleportIcon();
		this.questStartTooltips = config.questStartTooltips();
		this.farmingPatchTooltips = config.farmingPatchTooltips();
		this.rareTreeTooltips = config.rareTreeTooltips();
		this.rareTreeLevelIcon = config.rareTreeLevelIcon();
		this.transportationTeleportTooltips = config.transportationTeleportTooltips();
	}
}
