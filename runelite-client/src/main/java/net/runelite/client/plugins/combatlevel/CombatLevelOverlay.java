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
	private static final double PRAY_MULT = 0.125;
	static final double ATT_STR_MULT = 0.325;
	static final double DEF_HP_MULT = 0.25;
	static final double RANGE_MAGIC_LEVEL_MULT = 1.5;
	static final double RANGE_MAGIC_MULT = 0.325;

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
		double base = DEF_HP_MULT * (defenceLevel + hitpointsLevel + Math.floor(prayerLevel / 2));
		double melee = ATT_STR_MULT * (attackLevel + strengthLevel);
		double range = RANGE_MAGIC_MULT * Math.floor(rangedLevel * RANGE_MAGIC_LEVEL_MULT);
		double mage = RANGE_MAGIC_MULT * Math.floor(magicLevel * RANGE_MAGIC_LEVEL_MULT);
		double max = Math.max(melee, Math.max(range, mage));

		// find the needed levels until level up
		int next = client.getLocalPlayer().getCombatLevel() + 1;
		int meleeNeed = calcLevels(base + melee, next, ATT_STR_MULT);
		int hpdefNeed = calcLevels(base + max, next, DEF_HP_MULT);
		int prayNeed = calcLevelsPray(base + max, next, prayerLevel);
		int rangeNeed = calcLevelsRM(rangedLevel, next, base);
		int magicNeed = calcLevelsRM(magicLevel, next, base);

		// create tooltip string
		StringBuilder sb = new StringBuilder();
		sb.append(ColorUtil.wrapWithColorTag("Next combat level:</br>", COMBAT_LEVEL_COLOUR));

		if ((attackLevel + strengthLevel + meleeNeed) <= Experience.MAX_REAL_LEVEL * 2)
		{
			sb.append(meleeNeed).append(" Attack/Strength</br>");
		}
		if ((hitpointsLevel + defenceLevel + hpdefNeed) <= Experience.MAX_REAL_LEVEL * 2)
		{
			sb.append(hpdefNeed).append(" Defence/Hitpoints</br>");
		}
		if ((rangedLevel + rangeNeed) <= Experience.MAX_REAL_LEVEL)
		{
			sb.append(rangeNeed).append(" Ranged</br>");
		}
		if ((magicLevel + magicNeed) <= Experience.MAX_REAL_LEVEL)
		{
			sb.append(magicNeed).append(" Magic</br>");
		}
		if ((prayerLevel + prayNeed) <= Experience.MAX_REAL_LEVEL)
		{
			sb.append(prayNeed).append(" Prayer");
		}
		return sb.toString();
	}

	/**
	 * Calculate skill levels required for increasing combat level, meant
	 * for all combat skills besides prayer, ranged, and magic.
	 * @param start	initial value
	 * @param end	ending value (combat level + 1)
	 * @param multiple	how much adding one skill level will change combat
	 * @return	levels required for a specific skill to level up combat
	 */
	@VisibleForTesting
	static int calcLevels(double start, int end, double multiple)
	{
		return (int) Math.ceil(calcMultipliedLevels(start, end, multiple));
	}

	/**
	 * Calculate skill levels for increasing combat level, meant ONLY for the Prayer skill.
	 * <p>
	 * Note: Prayer is a special case, only leveling up upon even level numbers. This is accounted
	 *       for in this function.
	 * </p>
	 * @param start       current combat level
	 * @param end         ending value (combat level + 1)
	 * @param prayerLevel the player's current prayer level
	 * @return Prayer levels required to level up combat
	 */
	@VisibleForTesting
	static int calcLevelsPray(double start, int end, int prayerLevel)
	{
		final int neededLevels = (int) Math.floor(calcMultipliedLevels(start, end, PRAY_MULT));

		if ((prayerLevel + neededLevels) % 2 != 0)
		{
			return neededLevels + 1;
		}
		return neededLevels;
	}

	private static double calcMultipliedLevels(double start, int end, double multiple)
	{
		return (end - start) / multiple;
	}

	/**
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
		start = Math.floor(start * RANGE_MAGIC_LEVEL_MULT) * RANGE_MAGIC_MULT;
		return (int) Math.ceil((end - dhp - start) / (RANGE_MAGIC_MULT * RANGE_MAGIC_LEVEL_MULT));
	}
}
