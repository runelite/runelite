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

import com.google.inject.Provides;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.ScriptID;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.StatChanged;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

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
	private static final int MIN_COMBAT_LEVEL = 3;
	private static final String COMBAT_LEVEL_SECTION_TEXT = "Combat Level:";
	private static final Color CHARACTER_SUMMARY_GREEN = Color.decode("#0dc10d");

	@Inject
	private Client client;

	@Inject
	private CombatLevelConfig config;

	@Inject
	private CombatLevelOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	private String combatLevelStr;

	@Provides
	CombatLevelConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CombatLevelConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		double combatLevel = Experience.getCombatLevelPrecise(
			client.getRealSkillLevel(Skill.ATTACK),
			client.getRealSkillLevel(Skill.STRENGTH),
			client.getRealSkillLevel(Skill.DEFENCE),
			client.getRealSkillLevel(Skill.HITPOINTS),
			client.getRealSkillLevel(Skill.MAGIC),
			client.getRealSkillLevel(Skill.RANGED),
			client.getRealSkillLevel(Skill.PRAYER)
		);
		combatLevelStr = DECIMAL_FORMAT.format(combatLevel);

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
		Widget combatLevelWidget = client.getWidget(InterfaceID.CombatInterface.LEVEL);

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
	private void onStatChanged(StatChanged statChanged)
	{
		Skill skill = statChanged.getSkill();
		if (skill == Skill.ATTACK || skill == Skill.DEFENCE || skill == Skill.STRENGTH || skill == Skill.HITPOINTS
			|| skill == Skill.MAGIC || skill == Skill.PRAYER || skill == Skill.RANGED)
		{
			double combatLevel = Experience.getCombatLevelPrecise(
				client.getRealSkillLevel(Skill.ATTACK),
				client.getRealSkillLevel(Skill.STRENGTH),
				client.getRealSkillLevel(Skill.DEFENCE),
				client.getRealSkillLevel(Skill.HITPOINTS),
				client.getRealSkillLevel(Skill.MAGIC),
				client.getRealSkillLevel(Skill.RANGED),
				client.getRealSkillLevel(Skill.PRAYER)
			);
			combatLevelStr = DECIMAL_FORMAT.format(combatLevel);
		}
	}

	@Subscribe
	private void onClientTick(ClientTick tick)
	{
		Widget combatLevelWidget = client.getWidget(InterfaceID.CombatInterface.LEVEL);
		if (combatLevelWidget == null || !config.showPreciseCombatLevel())
		{
			return;
		}

		combatLevelWidget.setText("Combat Lvl: " + combatLevelStr);
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
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		final int scriptId = scriptPreFired.getScriptId();
		if (scriptId != ScriptID.ACCOUNT_SUMMARY_TEXT_FORMAT && scriptId != ScriptID.ACCOUNT_SUMMARY_SECTION_FORMAT || !config.showPreciseCombatLevel())
		{
			return;
		}

		final Object[] objectStack = client.getObjectStack();
		final int objectStackSize = client.getObjectStackSize();

		if (scriptId == ScriptID.ACCOUNT_SUMMARY_TEXT_FORMAT)
		{
			// This script is used for both total level and combat level, so verify the script is modifying the combat level
			final String levelText = Text.removeTags((String) objectStack[objectStackSize - 1]); // first argument
			if (client.getLocalPlayer().getCombatLevel() != Integer.parseInt(levelText))
			{
				return;
			}
		}
		else // scriptId == ScriptID.ACCOUNT_SUMMARY_SECTION_FORMAT
		{
			// This script is used for all account summary sections, so verify the script is running for the combat level section
			final String sectionText = Text.removeTags((String) objectStack[objectStackSize - 3]); // third argument
			if (!COMBAT_LEVEL_SECTION_TEXT.equals(sectionText))
			{
				return;
			}
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

		objectStack[objectStackSize - 1] = ColorUtil.wrapWithColorTag(DECIMAL_FORMAT.format(combatLevelPrecise), CHARACTER_SUMMARY_GREEN);
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.PVP_WIDGET_BUILDER && config.wildernessAttackLevelRange())
		{
			appendAttackLevelRangeText();
		}
	}

	private void appendAttackLevelRangeText()
	{
		final Widget wildernessLevelWidget = client.getWidget(InterfaceID.PvpIcons.WILDERNESSLEVEL);
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

		final int wildernessLevel = Integer.parseInt(m.group(1));
		final int combatLevel = client.getLocalPlayer().getCombatLevel();

		wildernessLevelWidget.setText(wildernessLevelText + "<br>" + combatAttackRange(combatLevel, wildernessLevel));
	}

	private void shutDownAttackLevelRange()
	{
		if (WorldType.isPvpWorld(client.getWorldType()))
		{
			return;
		}

		final Widget wildernessLevelWidget = client.getWidget(InterfaceID.PvpIcons.WILDERNESSLEVEL);
		if (wildernessLevelWidget != null)
		{
			String wildernessLevelText = wildernessLevelWidget.getText();
			if (wildernessLevelText.contains("<br>"))
			{
				wildernessLevelWidget.setText(wildernessLevelText.substring(0, wildernessLevelText.indexOf("<br>")));
			}
		}
	}

	private static String combatAttackRange(final int combatLevel, final int wildernessLevel)
	{
		return Math.max(MIN_COMBAT_LEVEL, combatLevel - wildernessLevel) + "-" + Math.min(Experience.MAX_COMBAT_LEVEL, combatLevel + wildernessLevel);
	}
}
