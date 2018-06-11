/*
 * Copyright (c) 2018, Brett Middle <https://github.com/bmiddle>
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

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.VarClientInt;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.lang.Math.floor;

public class CombatLevelOverlay extends Overlay
{
	@Inject
	private Client client;

	@Inject
	private CombatLevelConfig config;

	@Inject
	private TooltipManager tooltipManager;

	private final Map<Skill, Integer> skillsLeft = new LinkedHashMap<>();

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showLevelsUntil() || client.getLocalPlayer().getCombatLevel() == 126
			|| client.getVar(VarClientInt.CURRENT_TAB) != 0)
		{
			return null;
		}

		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		Rectangle combatCanvas = combatLevelWidget.getBounds();

		if (combatCanvas.contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY()))
		{
			getLevelsUntil();
			StringBuilder sb = new StringBuilder();
			sb.append("<col=ff981f>Next combat level:</col></br>");

			for (Map.Entry<Skill, Integer> entry : skillsLeft.entrySet())
			{
				String skillType;
				switch (entry.getKey())
				{
					case ATTACK:
						skillType = " Attack/Strength";
						break;
					case DEFENCE:
						skillType = " Defence/Hitpoints";
						break;
					default:
						skillType = " " + entry.getKey().getName();
				}

				sb.append(entry.getValue()).append(skillType).append("</br>");
			}

			tooltipManager.add(new Tooltip(sb.toString()));
		}

		return null;
	}

	private void getLevelsUntil()
	{
		skillsLeft.clear();

		// put together information
		int attackLevel = client.getRealSkillLevel(Skill.ATTACK);
		int strengthLevel = client.getRealSkillLevel(Skill.STRENGTH);
		int defenceLevel = client.getRealSkillLevel(Skill.DEFENCE);
		int hitpointsLevel = client.getRealSkillLevel(Skill.HITPOINTS);
		int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
		int rangedLevel = client.getRealSkillLevel(Skill.RANGED);
		int prayerLevel = client.getRealSkillLevel(Skill.PRAYER);
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
	}

	private static int calcLevels(double start, int end, double multiple)
	{
		int need = 0;
		while (start < end)
		{
			start += multiple;
			need++;
		}
		return need;
	}

	private static int calcLevelsRM(double start, int end, double dhp)
	{
		int need = 0;
		double base = start;
		start = floor(start * 1.5) * 0.325;
		while ((start + dhp) < end)
		{
			need++;
			start = floor((base + need) * 1.5) * 0.325;
		}
		return need;
	}
}
