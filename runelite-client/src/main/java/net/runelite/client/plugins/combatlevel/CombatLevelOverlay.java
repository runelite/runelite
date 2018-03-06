/*
 * Copyright (c) 2018, arlyon <https://github.com/arlyon>
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
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.tooltip.PanelTooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.text.NumberFormat;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.max;

public class CombatLevelOverlay extends Overlay
{
	private final Client client;
	private final CombatLevelConfig config;

	private final PanelTooltip combatLevelTooltip;
	private final TooltipManager tooltipManager;

	@Inject
	CombatLevelOverlay(Client client, CombatLevelConfig config, TooltipManager tooltipManager)
	{
		this.client = client;
		this.config = config;
		this.tooltipManager = tooltipManager;
		this.combatLevelTooltip = new PanelTooltip();
		this.combatLevelTooltip.setTitle("Next Combat Level");
		this.combatLevelTooltip.setTitleColor(Color.WHITE);
	}

	/**
	 * Renders the stat box onto the screen when the
	 * user mouses over the combat level widget.
	 */
	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		// don't render if the combat level widget doesn't exist
		Widget combatLevelWidget = client.getWidget(WidgetInfo.COMBAT_LEVEL);
		if (combatLevelWidget == null)
		{
			return null;
		}

		// don't render if mouse isn't hovering over the combat level widget
		net.runelite.api.Point mouse = client.getMouseCanvasPosition();
		if (!combatLevelWidget.getBounds().contains(mouse.getX(), mouse.getY()) || combatLevelWidget.isHidden())
		{
			return null;
		}

		// don't render if the settings set none to show
		if (!config.showDeltaLevel() && !config.showExperience() && !config.showTotalLevel())
		{
			return null;
		}

		Queue<SkillLevelEntry> experienceNeededList = getMinXpForCombatLevelUp(
			client.getSkillExperience(Skill.DEFENCE),
			client.getSkillExperience(Skill.HITPOINTS),
			client.getSkillExperience(Skill.PRAYER),
			client.getSkillExperience(Skill.ATTACK),
			client.getSkillExperience(Skill.STRENGTH),
			client.getSkillExperience(Skill.RANGED),
			client.getSkillExperience(Skill.MAGIC)
		);

		// populate panel in order of least experience
		combatLevelTooltip.getLines().clear();
		while (!experienceNeededList.isEmpty())
		{
			SkillLevelEntry skill = experienceNeededList.poll();
			String value = (config.showExperience() ? NumberFormat.getIntegerInstance().format(skill.getRemainingXp()) + "xp" : "") +
				(config.showExperience() && config.showTotalLevel() ? " " : "") +
				(config.showTotalLevel() ? String.format("[lvl %02d]", skill.getTargetLevel()) : "") +
				(config.showExperience() || config.showTotalLevel() ? " " : "") +
				(config.showDeltaLevel() ? String.format("[+%02d]", (skill.getTargetLevel() - skill.getCurrentLevel())) : "");

			combatLevelTooltip.getLines().add(new PanelComponent.Line(
				skill.getName() + ":",
				Color.ORANGE,
				value,
				Color.WHITE
			));
		}

		tooltipManager.add(combatLevelTooltip);
		return null;
	}

	/**
	 * Calculates the minimum amount of experience needed in each skill
	 * to reach the next combat level. It is only required to reach one
	 * of these levels.
	 *
	 * @return A {@link Queue} containing the combat skills ordered by
	 * how much XP is required to reach the next combat level.
	 */
	private Queue<SkillLevelEntry> getMinXpForCombatLevelUp(int defenceXP, int hitpointsXP, int prayerXP, int attackXP, int strengthXP, int rangeXP, int magicXP)
	{
		PriorityQueue<SkillLevelEntry> nextLevels = new PriorityQueue<>();

		int defenceLevel = Experience.getLevelForXp(defenceXP);
		int hitpointsLevel = Experience.getLevelForXp(hitpointsXP);
		int prayerLevel = Experience.getLevelForXp(prayerXP);
		int attackLevel = Experience.getLevelForXp(attackXP);
		int strengthLevel = Experience.getLevelForXp(strengthXP);
		int rangeLevel = Experience.getLevelForXp(rangeXP);
		int magicLevel = Experience.getLevelForXp(magicXP);

		double base = 0.25 * (defenceLevel + hitpointsLevel + floor(prayerLevel / 2));
		double melee = 0.325 * (attackLevel + strengthLevel);
		double range = 0.325 * (floor(rangeLevel / 2) + rangeLevel);
		double magic = 0.325 * (floor(magicLevel / 2) + magicLevel);

		double bonus = max(melee, max(range, magic));
		double combat = base + bonus;
		int nextCombat = (int) floor(combat + 1); // because ceil(45.0) is still 45

		int nextDefenceLevel = (int) ceil((nextCombat - bonus) / 0.25 - hitpointsLevel - floor(prayerLevel / 2));
		int nextHitpointsLevel = (int) ceil((nextCombat - bonus) / 0.25 - defenceLevel - floor(prayerLevel / 2));
		int nextPrayerLevel = (int) ceil((nextCombat - bonus) / 0.25 - hitpointsLevel - defenceLevel) * 2;

		int nextAttackLevel = (int) ceil((nextCombat - base) / 0.325 - strengthLevel);
		int nextStrengthLevel = (int) ceil((nextCombat - base) / 0.325 - attackLevel);

		int nextMagicLevel = (int) ceil((nextCombat - base) / 0.325 / 1.5);
		int nextRangeLevel = (int) ceil((nextCombat - base) / 0.325 / 1.5);

		nextLevels.add(new SkillLevelEntry(Skill.DEFENCE, nextDefenceLevel, defenceXP));
		nextLevels.add(new SkillLevelEntry(Skill.HITPOINTS, nextHitpointsLevel, hitpointsXP));
		nextLevels.add(new SkillLevelEntry(Skill.PRAYER, nextPrayerLevel, prayerXP));

		nextLevels.add(new SkillLevelEntry(Skill.ATTACK, nextAttackLevel, attackXP));
		nextLevels.add(new SkillLevelEntry(Skill.STRENGTH, nextStrengthLevel, strengthXP));

		nextLevels.add(new SkillLevelEntry(Skill.MAGIC, nextMagicLevel, magicXP));
		nextLevels.add(new SkillLevelEntry(Skill.RANGED, nextRangeLevel, rangeXP));

		return nextLevels;
	}
}
