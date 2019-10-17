/*
 * Copyright (c) 2018, Jasper Ketelaar <Jasper0781@gmail.com>
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
package net.runelite.client.plugins.xptracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Experience;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.SkillColor;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.SplitComponent;
import net.runelite.client.util.QuantityFormatter;

class XpInfoBoxOverlay extends Overlay
{
	private static final int PANEL_PREFERRED_WIDTH = 150;
	private static final int BORDER_SIZE = 2;
	private static final int XP_AND_PROGRESS_BAR_GAP = 2;
	private static final int XP_AND_ICON_GAP = 4;
	private static final Rectangle XP_AND_ICON_COMPONENT_BORDER = new Rectangle(2, 1, 4, 0);

	private final PanelComponent panel = new PanelComponent();
	private final PanelComponent iconXpSplitPanel = new PanelComponent();
	private final XpTrackerPlugin plugin;

	@Getter(AccessLevel.PACKAGE)
	private final Skill skill;
	private final BufferedImage icon;

	XpInfoBoxOverlay(
		XpTrackerPlugin plugin,
		Skill skill,
		BufferedImage icon)
	{
		super(plugin);
		this.plugin = plugin;
		this.skill = skill;
		this.icon = icon;
		panel.setBorder(new Rectangle(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		panel.setGap(new Point(0, XP_AND_PROGRESS_BAR_GAP));
		panel.setPreferredSize(new Dimension(PANEL_PREFERRED_WIDTH, 0));
		iconXpSplitPanel.setBorder(XP_AND_ICON_COMPONENT_BORDER);
		iconXpSplitPanel.setBackgroundColor(null);
		iconXpSplitPanel.setPreferredSize(new Dimension(PANEL_PREFERRED_WIDTH, 0));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "XP Tracker overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panel.getChildren().clear();
		iconXpSplitPanel.getChildren().clear();

		//Setting the font to rs small font so that the overlay isn't huge
		graphics.setFont(FontManager.getRunescapeSmallFont());

		final XpSnapshotSingle snapshot = plugin.getSkillSnapshot(skill);

		final String leftStr;
		final int rightNum;

		switch (plugin.getOnScreenDisplayMode())
		{
			case ACTIONS_DONE:
				leftStr = snapshot.getActionType().getLabel() + " Done";
				rightNum = snapshot.getActionsInSession();
				break;
			case ACTIONS_LEFT:
				leftStr = snapshot.getActionType().getLabel() + " Left";
				rightNum = snapshot.getActionsRemainingToGoal();
				break;
			case XP_LEFT:
				leftStr = "XP Left";
				rightNum = snapshot.getXpRemainingToGoal();
				break;
			case XP_GAINED:
			default:
				leftStr = "XP Gained";
				rightNum = snapshot.getXpGainedInSession();
				break;
		}

		final LineComponent xpLine = LineComponent.builder()
			.left(leftStr + ":")
			.right(QuantityFormatter.quantityToRSDecimalStack(rightNum, true))
			.build();

		final String bottemLeftStr;
		final int bottomRightNum;

		switch (plugin.getOnScreenDisplayModeBottom())
		{
			case ACTIONS_HOUR:
				bottemLeftStr = snapshot.getActionType().getLabel() + "/Hour";
				bottomRightNum = snapshot.getActionsPerHour();
				break;
			case XP_HOUR:
			default:
				bottemLeftStr = "XP/Hour";
				bottomRightNum = snapshot.getXpPerHour();
				break;
		}

		final LineComponent xpLineBottom = LineComponent.builder()
				.left(bottemLeftStr + ":")
				.right(QuantityFormatter.quantityToRSDecimalStack(bottomRightNum, true))
				.build();

		final SplitComponent xpSplit = SplitComponent.builder()
				.first(xpLine)
				.second(xpLineBottom)
				.orientation(ComponentOrientation.VERTICAL)
				.build();

		final ImageComponent imageComponent = new ImageComponent(icon);
		final SplitComponent iconXpSplit = SplitComponent.builder()
			.first(imageComponent)
			.second(xpSplit)
			.orientation(ComponentOrientation.HORIZONTAL)
			.gap(new Point(XP_AND_ICON_GAP, 0))
			.build();

		iconXpSplitPanel.getChildren().add(iconXpSplit);

		final ProgressBarComponent progressBarComponent = new ProgressBarComponent();

		progressBarComponent.setBackgroundColor(new Color(61, 56, 49));
		progressBarComponent.setForegroundColor(SkillColor.find(skill).getColor());

		progressBarComponent.setLeftLabel(String.valueOf(snapshot.getStartLevel()));
		progressBarComponent.setRightLabel(snapshot.getEndGoalXp() == Experience.MAX_SKILL_XP
			? "200M"
			: String.valueOf(snapshot.getEndLevel()));

		progressBarComponent.setValue(snapshot.getSkillProgressToGoal());

		panel.getChildren().add(iconXpSplitPanel);
		panel.getChildren().add(progressBarComponent);

		return panel.render(graphics);
	}

	@Override
	public String getName()
	{
		return super.getName() + skill.getName();
	}
}
