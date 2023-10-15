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
import net.runelite.api.widgets.WidgetID;
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
		if (!config.showLevelsUntil() || client.getLocalPlayer().getCombatLevel() == Experience.MAX_COMBAT_LEVEL)
		{
			return null;
		}

		Widget combatTabLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		Widget characterTabWidget = client.getWidget(WidgetInfo.CHARACTER_SUMMARY_CONTAINER);

		Rectangle combatCanvas = null;
		if (combatTabLevelWidget != null && !combatTabLevelWidget.isHidden())
		{
			combatCanvas = combatTabLevelWidget.getBounds();
		}
		else if (characterTabWidget != null && !characterTabWidget.isHidden())
		{
			combatCanvas = characterTabWidget.getChild(WidgetID.CharacterSummary.COMBAT_LEVEL_BOX_CHILD_ID).getBounds();
		}

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

	@VisibleForTesting
	String getLevelsUntilTooltip()
	{
		// grab combat skills from player
		int attackLevel = client.getRealSkillLevel(Skill.ATTACK);
		int strengthLevel = client.getRealSkillLevel(Skill.STRENGTH);
		int defenceLevel = client.getRealSkillLevel(Skill.DEFENCE);
		int hitpointsLevel = client.getRealSkillLevel(Skill.HITPOINTS);
		int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
		int rangeLevel = client.getRealSkillLevel(Skill.RANGED);
		int prayerLevel = client.getRealSkillLevel(Skill.PRAYER);

		// find the needed levels until level up
		int meleeNeed = Experience.getNextCombatLevelMelee(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int hpDefNeed = Experience.getNextCombatLevelHpDef(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int rangeNeed = Experience.getNextCombatLevelRange(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int magicNeed = Experience.getNextCombatLevelMagic(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);
		int prayerNeed = Experience.getNextCombatLevelPrayer(attackLevel, strengthLevel, defenceLevel, hitpointsLevel,
			magicLevel, rangeLevel, prayerLevel);

		// create tooltip string
		StringBuilder sb = new StringBuilder();
		sb.append(ColorUtil.wrapWithColorTag("Next combat level:</br>", COMBAT_LEVEL_COLOUR));

		if ((attackLevel + strengthLevel) < Experience.MAX_REAL_LEVEL * 2)
		{
			sb.append(meleeNeed).append(" Attack/Strength</br>");
		}
		if ((hitpointsLevel + defenceLevel) < Experience.MAX_REAL_LEVEL * 2)
		{
			sb.append(hpDefNeed).append(" Defence/Hitpoints</br>");
		}
		if (rangeLevel < Experience.MAX_REAL_LEVEL)
		{
			sb.append(rangeNeed).append(" Ranged</br>");
		}
		if (magicLevel < Experience.MAX_REAL_LEVEL)
		{
			sb.append(magicNeed).append(" Magic</br>");
		}
		if (prayerLevel < Experience.MAX_REAL_LEVEL)
		{
			sb.append(prayerNeed).append(" Prayer");
		}
		return sb.toString();
	}

}
