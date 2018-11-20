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

import com.google.common.annotations.VisibleForTesting;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class CombatLevelOverlay extends Overlay
{
	private static final Color COMBAT_LEVEL_COLOUR = new Color(0xff981f);

	private final Client client;
	private final CombatLevelConfig config;
	private final TooltipManager tooltipManager;

	@Inject
	private CombatLevelOverlay(Client client, CombatLevelConfig config, TooltipManager tooltipManager)
	{
		this.client = client;
		this.config = config;
		this.tooltipManager = tooltipManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		if (!config.showLevelsUntil()
			|| client.getLocalPlayer().getCombatLevel() == Experience.MAX_COMBAT_LEVEL
			|| combatLevelWidget == null || combatLevelWidget.isHidden())
		{
			return null;
		}

		Rectangle combatCanvas = combatLevelWidget.getBounds();

		if (combatCanvas == null)
		{
			return null;
		}

		if (combatCanvas.contains(client.getMouseCanvasPosition().getX(), client.getMouseCanvasPosition().getY()))
		{
			tooltipManager.add(new Tooltip(getLevelsUntilTooltip()));
		}

		return null;
	}

	private String getLevelsUntilTooltip()
	{
		// grab combat skills from player
		int attackLevel = client.getRealSkillLevel(Skill.ATTACK);
		int strengthLevel = client.getRealSkillLevel(Skill.STRENGTH);
		int defenceLevel = client.getRealSkillLevel(Skill.DEFENCE);
		int hitpointsLevel = client.getRealSkillLevel(Skill.HITPOINTS);
		int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
		int rangedLevel = client.getRealSkillLevel(Skill.RANGED);
		int prayerLevel = client.getRealSkillLevel(Skill.PRAYER);

		// calculate initial required numbers
		double base = 0.25 * (defenceLevel + hitpointsLevel + Math.floor(prayerLevel / 2));
		double melee = 0.325 * (attackLevel + strengthLevel);
		double range = 0.325 * Math.floor(rangedLevel * 1.5);
		double mage = 0.325 * Math.floor(magicLevel * 1.5);
		double max = Math.max(melee, Math.max(range, mage));

		// find the needed levels until level up
		int next = client.getLocalPlayer().getCombatLevel() + 1;
		int meleeNeed = calcLevels(base + melee, next, 0.325);
		int hpdefNeed = calcLevels(base + max, next, 0.25);
		int prayNeed = calcLevels(base + max, next, 0.125);
		int rangeNeed = calcLevelsRM(rangedLevel, next, base);
		int magicNeed = calcLevelsRM(magicLevel, next, base);

		// prayer is a special case, increasing combat every even level. need to correct its value
		prayNeed = correctPrayer(prayerLevel, prayNeed);

		// create tooltip string
		StringBuilder sb = new StringBuilder();
		sb.append(ColorUtil.wrapWithColorTag("Next combat level:</br>", COMBAT_LEVEL_COLOUR));

		if ((attackLevel + strengthLevel + meleeNeed) <= 198)
		{
			sb.append(meleeNeed).append(" Attack/Strength</br>");
		}
		if ((hitpointsLevel + defenceLevel + hpdefNeed) <= 198)
		{
			sb.append(hpdefNeed).append(" Defence/Hitpoints</br>");
		}
		if ((rangedLevel + rangeNeed) <= 99)
		{
			sb.append(rangeNeed).append(" Ranged</br>");
		}
		if ((magicLevel + magicNeed) <= 99)
		{
			sb.append(magicNeed).append(" Magic</br>");
		}
		if ((prayerLevel + prayNeed) <= 99)
		{
			sb.append(prayNeed).append(" Prayer");
		}
		return sb.toString();
	}

	/***
	 * Calculate skill levels required for increasing combat level, meant
	 * for all combat skills besides ranged and magic.
	 * @param start	initial value
	 * @param end	ending value (combat level + 1)
	 * @param multiple	how much adding one skill level will change combat
	 * @return	levels required for a specific skill to level up combat
	 */
	@VisibleForTesting
	static int calcLevels(double start, int end, double multiple)
	{
		return (int) Math.ceil((end - start) / multiple);
	}

	/***
	 * Calculate skill levels required for increasing combat level, meant
	 * ONLY for Ranged and Magic skills.
	 * @param start	either the current ranged or magic level
	 * @param end	ending value (combat level + 1)
	 * @param dhp	defence, hitpoints, and prayer; this is the initial calculated "base" value
	 * @return	levels required for a specific skill to level up combat
	 */
	@VisibleForTesting
	static int calcLevelsRM(double start, int end, double dhp)
	{
		start = Math.floor(start * 1.5) * 0.325;
		return (int) Math.ceil((end - dhp - start) / 0.4875);
	}

	/***
	 * Corrects how many levels you need to level up combat through prayer.
	 * @param level	current prayer level
	 * @param need	needed prayer level calculated by calcLevels(...)
	 * @return	a corrected number to increase combat through prayer only
	 */
	@VisibleForTesting
	static int correctPrayer(int level, int need)
	{
		if ((level + need) % 2 == 1)
		{
			need++;
		}
		return need;
	}
}
