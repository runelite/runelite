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
package net.runelite.client.plugins.performancetracker.overlays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.plugins.performancetracker.PerformanceTracker;
import net.runelite.client.plugins.performancetracker.data.stats.Performance;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class GenericOverlay extends Overlay
{
	private final PerformanceTracker tracker;
	private final PanelComponent panelComponent = new PanelComponent();

	private Performance performance;

	private double dealt;
	private double taken;
	private double seconds;

	private static String formatSeconds(double seconds)
	{
		if (seconds <= 60)
		{
			return String.format("%2.0f", seconds);
		}

		double s = seconds % 3600 % 60;
		double m = Math.floor(seconds % 3600 / 60);
		double h = Math.floor(seconds / 3600);

		return h < 1 ? String.format("%2.0f:%02.0f", m, s) : String.format("%2.0f:%02.0f:%02.0f", h, m, s);
	}

	@Inject
	GenericOverlay(PerformanceTracker tracker)
	{
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.LOW);
		this.tracker = tracker;
		this.performance = tracker.getCurrent();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!tracker.isEnabled())
		{
			return null;
		}

		double o1 = dealt;
		double o2 = taken;
		double o3 = seconds;

		this.performance = tracker.getCurrent();

		this.dealt = performance.getDamageDealt();
		this.taken = performance.getDamageTaken();
		this.seconds = performance.getSecondsSpent();

		// Only recreate the components if necessary
		if (o1 != dealt || o2 != taken || o3 != seconds)
		{
			panelComponent.getChildren().clear();

			graphics.setColor(Color.WHITE);

			LayoutableRenderableEntity title = TitleComponent.builder().text("Performance Tracker").build();
			LayoutableRenderableEntity dealt = LineComponent.builder().left("Dmg Dealt").right(String.valueOf((int) Math.round(this.dealt))).build();
			LayoutableRenderableEntity taken = LineComponent.builder().left("Dmg Taken").right(String.valueOf((int) Math.round(this.taken))).build();
			LayoutableRenderableEntity timeSpent = LineComponent.builder().left("Time Spent").right(formatSeconds(this.seconds)).build();
			double dpsValue = Math.round((this.dealt / this.seconds) * 100) / 100.00;
			LayoutableRenderableEntity dps = LineComponent.builder().left("DPS").right(String.valueOf(dpsValue)).build();

			add(title);
			add(dealt);
			add(taken);
			add(timeSpent);
			add(dps);
		}

		return panelComponent.render(graphics);
	}

	private void add(LayoutableRenderableEntity a)
	{
		panelComponent.getChildren().add(a);
	}
}
