/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.agility;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
class LapCounterOverlay extends Overlay
{
	private final AgilityPlugin plugin;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private LapCounterOverlay(final AgilityPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.plugin = plugin;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Agility overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		AgilitySession session = plugin.getSession();

		if (!plugin.isShowLapCount() ||
			session == null ||
			session.getLastLapCompleted() == null ||
			session.getCourse() == null)
		{
			return null;
		}

		Duration lapTimeout = Duration.ofMinutes(plugin.getLapTimeout());
		Duration sinceLap = Duration.between(session.getLastLapCompleted(), Instant.now());

		if (sinceLap.compareTo(lapTimeout) >= 0)
		{
			// timeout session
			session.setLastLapCompleted(null);
			return null;
		}

		panelComponent.getChildren().clear();
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
		tableComponent.addRow("Total Laps:", Integer.toString(session.getTotalLaps()));

		if (plugin.isLapsToLevel() && session.getLapsTillLevel() > 0)
		{
			tableComponent.addRow("Laps until level:", Integer.toString(session.getLapsTillLevel()));
		}

		if (plugin.isLapsToGoal() && session.getLapsTillGoal() > 0)
		{
			tableComponent.addRow("Laps until goal:", Integer.toString(session.getLapsTillGoal()));
		}

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}
}
