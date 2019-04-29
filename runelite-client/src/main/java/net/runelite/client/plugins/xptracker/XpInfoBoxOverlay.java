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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.SplitComponent;
import net.runelite.client.util.StackFormatter;

class XpInfoBoxOverlay extends Overlay
{
	private static final int PANEL_PREFERRED_WIDTH = 155;
	private static final int BORDER_SIZE = 7;
	private static final int GAP_SIZE = 5;

	private final PanelComponent panel = new PanelComponent();
	private final XpTrackerPlugin plugin;

	@Getter(AccessLevel.PACKAGE)
	private final Skill skill;
	private final BufferedImage icon;

	XpInfoBoxOverlay(XpTrackerPlugin plugin, Skill skill, BufferedImage icon)
	{
		this.plugin = plugin;
		this.skill = skill;
		this.icon = icon;
		panel.setBorder(new Rectangle(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		panel.setGap(new Point(0, GAP_SIZE));
		panel.setPreferredSize(new Dimension(PANEL_PREFERRED_WIDTH, 0));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		//Setting the font to rs small font so that the overlay isn't huge
		graphics.setFont(FontManager.getRunescapeSmallFont());

		final XpSnapshotSingle snapshot = plugin.getSkillSnapshot(skill);
		panel.getChildren().clear();

		final LineComponent xpLeft = LineComponent.builder()
			.left("Xp Gained:")
			.right(StackFormatter.quantityToRSDecimalStack(snapshot.getXpGainedInSession()))
			.build();

		final LineComponent xpHour = LineComponent.builder()
			.left("Xp/Hour:")
			.right(StackFormatter.quantityToRSDecimalStack(snapshot.getXpPerHour()))
			.build();

		final SplitComponent xpSplit = SplitComponent.builder()
			.first(xpLeft)
			.second(xpHour)
			.orientation(ComponentOrientation.VERTICAL)
			.build();

		final ImageComponent imageComponent = new ImageComponent(icon);
		final SplitComponent iconSplit = SplitComponent.builder()
			.first(imageComponent)
			.second(xpSplit)
			.orientation(ComponentOrientation.HORIZONTAL)
			.gap(new Point(GAP_SIZE, 0))
			.build();

		final ProgressBarComponent progressBarComponent = new ProgressBarComponent();
		progressBarComponent.setValue(snapshot.getSkillProgressToGoal());

		panel.getChildren().add(iconSplit);
		panel.getChildren().add(progressBarComponent);

		return panel.render(graphics);
	}
}
