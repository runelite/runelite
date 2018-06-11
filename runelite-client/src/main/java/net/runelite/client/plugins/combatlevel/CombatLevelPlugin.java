/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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

import com.google.common.eventbus.Subscribe;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

@PluginDescriptor(
	name = "Combat Level"
)
public class CombatLevelPlugin extends Plugin
{
	private final DecimalFormat decimalFormat = new DecimalFormat("#.###");

	@Inject
	Client client;

	@Inject
	CombatLevelConfig config;

	@Inject
	CombatLevelOverlay overlay;

	@Provides
	CombatLevelConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CombatLevelConfig.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);

		if (combatLevelWidget != null)
		{
			String widgetText = combatLevelWidget.getText();

			if (widgetText.contains("."))
			{
				combatLevelWidget.setText(widgetText.substring(0, widgetText.indexOf(".")));
			}
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void updateCombatLevel(GameTick event)
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

		combatLevelWidget.setText("Combat Lvl: " + decimalFormat.format(combatLevelPrecise));
	}

	public Map<Skill, Integer> getLevelsUntil()
	{
		// put together information
		int attackLevel = client.getRealSkillLevel(Skill.ATTACK);
		int strengthLevel = client.getRealSkillLevel(Skill.STRENGTH);
		int defenceLevel = client.getRealSkillLevel(Skill.DEFENCE);
		int hitpointsLevel = client.getRealSkillLevel(Skill.HITPOINTS);
		int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
		int rangedLevel = client.getRealSkillLevel(Skill.RANGED);
		int prayerLevel = client.getRealSkillLevel(Skill.PRAYER);
		final Map<Skill, Integer> skillsLeft = new HashMap<>();
		skillsLeft.put(Skill.ATTACK, 0);
		skillsLeft.put(Skill.DEFENCE, 0);
		skillsLeft.put(Skill.MAGIC, 0);
		skillsLeft.put(Skill.RANGED, 0);
		skillsLeft.put(Skill.PRAYER, 0);
		double base = 0.25 * (defenceLevel + hitpointsLevel + floor(prayerLevel / 2));
		double melee = 0.325 * (attackLevel + strengthLevel);
		double range = 0.325 * (floor(rangedLevel / 2) + rangedLevel);
		double mage = 0.325 * (floor(magicLevel / 2) + magicLevel);
		double max = Math.max(melee, Math.max(range, mage));

		// begin calculating levels
		int next = (int) floor(base + max) + 1;
		int meleeNeed = calcLevels((base + melee), next, 0.325);
		int hpdefNeed = calcLevels((base + max), next, 0.25025);
		int prayNeed = calcLevels((base + max), next, 0.125);
		int rangeNeed = calcLevelsRM(rangedLevel, next, base);
		int magicNeed = calcLevelsRM(magicLevel, next, base);


		if ((attackLevel + strengthLevel + meleeNeed) <= 198)
		{
			skillsLeft.put(Skill.ATTACK, meleeNeed);
		}
		if ((hitpointsLevel + defenceLevel + hpdefNeed) <= 198)
		{
			skillsLeft.put(Skill.DEFENCE, hpdefNeed);
		}
		if ((rangedLevel + rangeNeed) <= 99)
		{
			skillsLeft.put(Skill.RANGED, rangeNeed);
		}
		if ((magicLevel + magicNeed) <= 99)
		{
			skillsLeft.put(Skill.MAGIC, magicNeed);
		}
		if ((prayerLevel + prayNeed) <= 99)
		{
			skillsLeft.put(Skill.PRAYER, prayNeed);
		}
		return skillsLeft;
	}

	private int calcLevels(double start, int end, double multiple)
	{
		int need = 0;
		while(start < end)
		{
			start += multiple;
			need++;
		}
		return need;
	}

	private int calcLevelsRM(double start, int end, double dhp)
	{
		int need = 0;
		double base = start;
		start = floor(start * 1.5) * 0.325;
		while((start + dhp) < end)
		{
			need++;
			start = floor((base + need) * 1.5) * 0.325;
		}
		return need;
	}

	public int getCombatLevel()
	{
		return Experience.getCombatLevel(
			client.getRealSkillLevel(Skill.ATTACK),
			client.getRealSkillLevel(Skill.STRENGTH),
			client.getRealSkillLevel(Skill.DEFENCE),
			client.getRealSkillLevel(Skill.HITPOINTS),
			client.getRealSkillLevel(Skill.MAGIC),
			client.getRealSkillLevel(Skill.RANGED),
			client.getRealSkillLevel(Skill.PRAYER)
		);
	}
}
