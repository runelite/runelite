/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.performancetracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.MenuAction;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class PerformanceTrackerOverlay extends Overlay
{
	private static final Color PAUSED_COLOR = new Color(100, 0, 0, 125);
	private static final String TARGET = "Performance Tracker";

	private final PerformanceTrackerPlugin tracker;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	PerformanceTrackerOverlay(PerformanceTrackerPlugin tracker)
	{
		super(tracker);
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.LOW);
		this.tracker = tracker;

		getMenuEntries().add(new OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY, "Pause", TARGET));
		getMenuEntries().add(new OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY, "Reset", TARGET));
	}

	@Override
	public String getName()
	{
		return TARGET;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Performance current = tracker.getCurrent();
		if (!tracker.isTracking() || current == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		graphics.setColor(Color.WHITE);
		panelComponent.setBackgroundColor(ComponentConstants.STANDARD_BACKGROUND_COLOR);

		add(TitleComponent.builder().text("Performance Tracker").build());
		add(LineComponent.builder().left("Dmg Dealt").right(String.valueOf((int) Math.round(current.getDamageDealt()))).build());
		add(LineComponent.builder().left("Dmg Taken").right(String.valueOf((int) Math.round(current.getDamageTaken()))).build());
		add(LineComponent.builder().left("Time Spent").right(current.getReadableSecondsSpent()).build());
		add(LineComponent.builder().left("DPS").right(String.valueOf(current.getDPS())).build());
		if (tracker.isPaused())
		{
			add(TitleComponent.builder().text("Paused").build());
			panelComponent.setBackgroundColor(PAUSED_COLOR);
		}

		return panelComponent.render(graphics);
	}

	private void add(LayoutableRenderableEntity a)
	{
		panelComponent.getChildren().add(a);
	}
}
