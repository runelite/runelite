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
package net.runelite.client.plugins.performancestats;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.MenuOpcode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
public class PerformanceStatsOverlay extends Overlay
{
	private static final String TARGET = "Performance Stats";
	private static final String[] COLUMNS = {
		"Player", "Dealt", "Taken", "DPS", "Elapsed"
	};

	private final PerformanceStatsPlugin tracker;
	private final PanelComponent panelComponent = new PanelComponent();
	private final TableComponent tableComponent = new TableComponent();

	@Inject
	PerformanceStatsOverlay(final PerformanceStatsPlugin tracker)
	{
		super(tracker);
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.LOW);
		this.tracker = tracker;

		getMenuEntries().add(new OverlayMenuEntry(MenuOpcode.RUNELITE_OVERLAY, "Pause", TARGET));
		getMenuEntries().add(new OverlayMenuEntry(MenuOpcode.RUNELITE_OVERLAY, "Reset", TARGET));
		getMenuEntries().add(new OverlayMenuEntry(MenuOpcode.RUNELITE_OVERLAY, "Submit", TARGET));

		panelComponent.setPreferredSize(new Dimension(350, 0));
		panelComponent.setBackgroundColor(ComponentConstants.STANDARD_BACKGROUND_COLOR);

		tableComponent.setDefaultAlignment(TableAlignment.CENTER);
		tableComponent.setColumns(COLUMNS);

		panelComponent.getChildren().add(tableComponent);
	}

	@Override
	public String getName()
	{
		return TARGET;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!tracker.isEnabled())
		{
			return null;
		}

		final Performance performance = tracker.getPerformance();
		graphics.setColor(Color.WHITE);

		tableComponent.getRows().clear();

		final String[] rowElements = createRowElements(performance);
		tableComponent.addRow(rowElements);

		for (Performance p : tracker.getPartyDataMap().values())
		{
			if (p.getMemberId().equals(performance.getMemberId()))
			{
				continue;
			}

			final String[] eles = createRowElements(p);
			tableComponent.addRow(eles);
		}

		return panelComponent.render(graphics);
	}

	private String[] createRowElements(Performance performance)
	{
		return new String[]
			{
				performance.getUsername(),
				(int) Math.round(performance.getDamageDealt()) + " | " + (int) Math.round(performance.getHighestHitDealt()),
				(int) Math.round(performance.getDamageTaken()) + " | " + (int) Math.round(performance.getHighestHitTaken()),
				String.valueOf(performance.getDPS()),
				performance.getHumanReadableSecondsSpent()
			};
	}
}
