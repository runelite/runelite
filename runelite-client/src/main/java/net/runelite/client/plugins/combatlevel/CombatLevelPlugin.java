/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.combatlevel;

import com.google.common.base.Preconditions;
import com.google.inject.Provides;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Combat Level",
	description = "Show a more accurate combat level in Combat Options panel and other combat level functions",
	tags = {"wilderness", "attack", "range"}
)
public class CombatLevelPlugin extends Plugin
{
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");
	private static final String CONFIG_GROUP = "combatlevel";
	private static final String ATTACK_RANGE_CONFIG_KEY = "wildernessAttackLevelRange";
	private static final Pattern WILDERNESS_LEVEL_PATTERN = Pattern.compile("^Level: (\\d+)$");
	private static final int SKULL_CONTAINER_ADJUSTED_ORIGINAL_Y = 6;
	private static final int WILDERNESS_LEVEL_TEXT_ADJUSTED_ORIGINAL_Y = 3;
	private static final int MIN_COMBAT_LEVEL = 3;
	private static final Color COMBAT_LEVEL_COLOUR = new Color(0xff981f);
	static final EnumSet<Skill> COMBAT_SKILLS = EnumSet.of(
		Skill.ATTACK,
		Skill.STRENGTH,
		Skill.DEFENCE,
		Skill.HITPOINTS,
		Skill.RANGED,
		Skill.MAGIC,
		Skill.PRAYER
	);

	private final EnumMap<Skill, Integer> cmbSkillLevels = new EnumMap<>(Skill.class);
	private Tooltip levelsUntilTooltip;
	private int originalWildernessLevelTextPosition = -1;
	private int originalSkullContainerPosition = -1;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private CombatLevelConfig config;

	@Inject
	private CombatLevelOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Provides
	CombatLevelConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CombatLevelConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		if (config.wildernessAttackLevelRange())
		{
			appendAttackLevelRangeText();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		cmbSkillLevels.clear();
		levelsUntilTooltip = null;

		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);

		if (combatLevelWidget != null)
		{
			String widgetText = combatLevelWidget.getText();

			if (widgetText.contains("."))
			{
				combatLevelWidget.setText(widgetText.substring(0, widgetText.indexOf(".")));
			}
		}

		shutDownAttackLevelRange();
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		if (combatLevelWidget == null)
		{
			return;
		}

		double combatLevelPrecise = Experience.getCombatLevelPrecise(
				client.getRealSkillLevel(Skill.ATTACK),
				client.getRealSkillLevel(Skill.STRENGTH),
				client.getRealSkillLevel(Skill.DEFENCE),
				client.getRealSkillLevel(Skill.HITPOINTS),
				client.getRealSkillLevel(Skill.MAGIC),
				client.getRealSkillLevel(Skill.RANGED),
				client.getRealSkillLevel(Skill.PRAYER)
		);

		combatLevelWidget.setText("Combat Lvl: " + DECIMAL_FORMAT.format(combatLevelPrecise));
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!CONFIG_GROUP.equals(event.getGroup()) || !ATTACK_RANGE_CONFIG_KEY.equals(event.getKey()))
		{
			return;
		}

		if (config.wildernessAttackLevelRange())
		{
			appendAttackLevelRangeText();
		}
		else
		{
			shutDownAttackLevelRange();
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (config.wildernessAttackLevelRange()
			&& "wildernessWidgetTextSet".equals(event.getEventName()))
		{
			appendAttackLevelRangeText();
		}
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		final Skill skill = event.getSkill();

		if (!COMBAT_SKILLS.contains(skill))
		{
			return;
		}

		levelsUntilTooltip = null;

		final int level = Math.min(Experience.MAX_REAL_LEVEL, Experience.getLevelForXp(client.getSkillExperience(skill)));
		cmbSkillLevels.put(skill, level);
	}

	private void appendAttackLevelRangeText()
	{
		final Widget wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);
		if (wildernessLevelWidget == null)
		{
			return;
		}

		final String wildernessLevelText = wildernessLevelWidget.getText();
		final Matcher m = WILDERNESS_LEVEL_PATTERN.matcher(wildernessLevelText);
		if (!m.matches()
			|| WorldType.isPvpWorld(client.getWorldType()))
		{
			return;
		}

		final Widget skullContainer = client.getWidget(WidgetInfo.PVP_SKULL_CONTAINER);
		if (originalWildernessLevelTextPosition == -1)
		{
			originalWildernessLevelTextPosition = wildernessLevelWidget.getOriginalY();
		}
		if (originalSkullContainerPosition == -1)
		{
			originalSkullContainerPosition = skullContainer.getRelativeY();
		}

		final int wildernessLevel = Integer.parseInt(m.group(1));
		final int combatLevel = client.getLocalPlayer().getCombatLevel();

		wildernessLevelWidget.setText(wildernessLevelText + "<br>" + combatAttackRange(combatLevel, wildernessLevel));
		wildernessLevelWidget.setOriginalY(WILDERNESS_LEVEL_TEXT_ADJUSTED_ORIGINAL_Y);
		skullContainer.setOriginalY(SKULL_CONTAINER_ADJUSTED_ORIGINAL_Y);

		clientThread.invoke(wildernessLevelWidget::revalidate);
		clientThread.invoke(skullContainer::revalidate);
	}

	private void shutDownAttackLevelRange()
	{
		if (WorldType.isPvpWorld(client.getWorldType()))
		{
			return;
		}

		final Widget wildernessLevelWidget = client.getWidget(WidgetInfo.PVP_WILDERNESS_LEVEL);
		if (wildernessLevelWidget != null)
		{
			String wildernessLevelText = wildernessLevelWidget.getText();
			if (wildernessLevelText.contains("<br>"))
			{
				wildernessLevelWidget.setText(wildernessLevelText.substring(0, wildernessLevelText.indexOf("<br>")));
			}
			wildernessLevelWidget.setOriginalY(originalWildernessLevelTextPosition);
			clientThread.invoke(wildernessLevelWidget::revalidate);
		}
		originalWildernessLevelTextPosition = -1;

		final Widget skullContainer = client.getWidget(WidgetInfo.PVP_SKULL_CONTAINER);
		if (skullContainer != null)
		{
			skullContainer.setOriginalY(originalSkullContainerPosition);
			clientThread.invoke(skullContainer::revalidate);
		}
		originalSkullContainerPosition = -1;
	}

	private static String combatAttackRange(final int combatLevel, final int wildernessLevel)
	{
		return Math.max(MIN_COMBAT_LEVEL, combatLevel - wildernessLevel) + "-" + Math.min(Experience.MAX_COMBAT_LEVEL, combatLevel + wildernessLevel);
	}

	Tooltip getLevelsUntilTooltip()
	{
		if (levelsUntilTooltip == null)
		{
			levelsUntilTooltip = buildLevelsUntilTooltip();
		}

		return levelsUntilTooltip;
	}

	private Tooltip buildLevelsUntilTooltip()
	{
		// find the needed levels until level up
		int meleeNeed = levelsToCombat(Skill.ATTACK);
		int hpdefNeed = levelsToCombat(Skill.HITPOINTS);
		int rangeNeed = levelsToCombat(Skill.RANGED);
		int magicNeed = levelsToCombat(Skill.MAGIC);
		int prayNeed = levelsToCombat(Skill.PRAYER);

		// create tooltip string
		StringBuilder sb = new StringBuilder();
		sb.append(ColorUtil.wrapWithColorTag("Next combat level:</br>", COMBAT_LEVEL_COLOUR));

		if ((cmbSkillLevels.get(Skill.ATTACK) + cmbSkillLevels.get(Skill.STRENGTH) + meleeNeed) <= Experience.MAX_REAL_LEVEL * 2)
		{
			sb.append(meleeNeed).append(" Attack/Strength</br>");
		}
		if ((cmbSkillLevels.get(Skill.HITPOINTS) + cmbSkillLevels.get(Skill.DEFENCE) + hpdefNeed) <= Experience.MAX_REAL_LEVEL * 2)
		{
			sb.append(hpdefNeed).append(" Defence/Hitpoints</br>");
		}
		if ((cmbSkillLevels.get(Skill.RANGED) + rangeNeed) <= Experience.MAX_REAL_LEVEL)
		{
			sb.append(rangeNeed).append(" Ranged</br>");
		}
		if ((cmbSkillLevels.get(Skill.MAGIC) + magicNeed) <= Experience.MAX_REAL_LEVEL)
		{
			sb.append(magicNeed).append(" Magic</br>");
		}
		if ((cmbSkillLevels.get(Skill.PRAYER) + prayNeed) <= Experience.MAX_REAL_LEVEL)
		{
			sb.append(prayNeed).append(" Prayer");
		}
		return new Tooltip(sb.toString());
	}

	/**
	 * Determines the number of levels in the given combat skill to reach a new combat level, given a map of combat
	 * skills to their skill levels.
	 *
	 * @param skill        The combat skill to check how many levels it will need to reach a new combat level
	 * @return The number of levels in the given skill required to reach a new combat level
	 */
	int levelsToCombat(final Skill skill)
	{
		Preconditions.checkArgument(COMBAT_SKILLS.contains(skill));

		final EnumMap<Skill, Integer> levels = cmbSkillLevels.clone();
		final int startingLevel = levels.get(skill);
		final int startingCombat = client.getLocalPlayer().getCombatLevel();

		do
		{
			levels.compute(skill, (skillKey, level) ->
				{
					if (level == null)
					{
						return 1;
					}
					return level + 1;
				});
		}
		while (getCombatLevel(levels) <= startingCombat);

		return levels.get(skill) - startingLevel;
	}

	/**
	 * Wrapper for {@link Experience#getCombatLevel(int, int, int, int, int, int, int)}, accepting a combat skills map
	 * as the input.
	 *
	 * @param combatLevels A {@link Map} of {@link Skill}s to {@link Integer}s representing a player's combat skill
	 *                     levels
	 * @return The combat level of a player with the combat skills in the given map
	 */
	private static int getCombatLevel(final Map<Skill, Integer> combatLevels)
	{
		Preconditions.checkArgument(combatLevels != null && COMBAT_SKILLS.equals(combatLevels.keySet()));

		return Experience.getCombatLevel(
			combatLevels.get(Skill.ATTACK),
			combatLevels.get(Skill.STRENGTH),
			combatLevels.get(Skill.DEFENCE),
			combatLevels.get(Skill.HITPOINTS),
			combatLevels.get(Skill.RANGED),
			combatLevels.get(Skill.MAGIC),
			combatLevels.get(Skill.PRAYER));
	}
}
