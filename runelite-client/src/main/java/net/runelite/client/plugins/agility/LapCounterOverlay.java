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
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;

class LapCounterOverlay extends OverlayPanel
{
	static final String AGILITY_RESET = "Reset";

	private final AgilityPlugin plugin;
	private final AgilityConfig config;

	@Inject
	private LapCounterOverlay(AgilityPlugin plugin, AgilityConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.plugin = plugin;
		this.config = config;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Agility overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, AGILITY_RESET, "Agility overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		AgilitySession session = plugin.getSession();

		if (!config.showLapCount() ||
			session == null ||
			session.getLastLapCompleted() == null ||
			session.getCourse() == null)
		{
			return null;
		}

		Duration lapTimeout = Duration.ofMinutes(config.lapTimeout());
		Duration sinceLap = Duration.between(session.getLastLapCompleted(), Instant.now());

		if (sinceLap.compareTo(lapTimeout) >= 0)
		{
			// timeout session
			session.setLastLapCompleted(null);
			return null;
		}

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Total Laps:")
			.right(Integer.toString(session.getTotalLaps()))
			.build());

		if (config.lapsToLevel() && session.getLapsTillGoal() > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Laps until goal:")
				.right(Integer.toString(session.getLapsTillGoal()))
				.build());
		}

		if (config.lapsPerHour() && session.getLapsPerHour() > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Laps per hour:")
				.right(Integer.toString(session.getLapsPerHour()))
				.build());
		}

		return super.render(graphics);
	}
}
