/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.dps;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ws.PartyService;

public class DpsOverlay extends Overlay
{
	private static final DecimalFormat DPS_FORMAT = new DecimalFormat("#0.0");
	private static final Color PAUSED_COLOR = new Color(100, 0, 0, 125);

	private final DpsPlugin plugin;
	private final DpsConfig dpsConfig;
	private final PartyService partyService;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	DpsOverlay(DpsPlugin plugin, DpsConfig dpsConfig, PartyService partyService)
	{
		super(plugin);
		this.plugin = plugin;
		this.dpsConfig = dpsConfig;
		this.partyService = partyService;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, "Clear", "DPS counter"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, "Reset", "DPS counter"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, "Pause", "DPS counter"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		boolean inParty = !partyService.getMembers().isEmpty();
		boolean showDamage = dpsConfig.showDamage();

		panelComponent.getChildren().clear();
		panelComponent.setBackgroundColor(ComponentConstants.STANDARD_BACKGROUND_COLOR);
		panelComponent.getChildren().add(
			TitleComponent.builder()
				.text((inParty ? "Party " : "") + "DPS Counter")
				.build());

		// Add yourself first
		DpsTracker self = plugin.getTracker();
		if (self != null)
		{
			panelComponent.getChildren().add(
				LineComponent.builder()
					.left(self.getName())
					.right(showDamage ? Integer.toString(self.getDamage()) : DPS_FORMAT.format(self.getDps()))
					.build());
		}
		else if (!inParty)
		{
			return null;
		}

		// Add party members if necessary
		Map<String, DpsTracker> partyMembers = plugin.getMembers();
		for (DpsTracker dpsTracker : partyMembers.values())
		{
			panelComponent.getChildren().add(
				LineComponent.builder()
					.left(dpsTracker.getName())
					.right(showDamage ? Integer.toString(dpsTracker.getDamage()) : DPS_FORMAT.format(dpsTracker.getDps()))
					.build());
		}

		// Add total
		if (partyMembers.size() > 0)
		{
			DpsTracker total = plugin.getTotalTracker();
			panelComponent.getChildren().add(
				LineComponent.builder()
					.left("Party Total")
					.right(showDamage ? Integer.toString(total.getDamage()) : DPS_FORMAT.format(total.getDps()))
					.build());
		}

		DpsTracker tracker = null;
		if (inParty && plugin.getTotalTracker() != null)
		{
			tracker = plugin.getTotalTracker();
		}
		else if (self != null)
		{
			tracker = self;
		}

		if (tracker != null)
		{
			panelComponent.getChildren().add(
				TitleComponent.builder()
					.text(getReadableSecondsElapsed(tracker))
					.build());

			if (tracker.isPaused())
			{
				panelComponent.setBackgroundColor(PAUSED_COLOR);
			}
		}

		return panelComponent.render(graphics);
	}

	/**
	 * Converts the time a tracker has been active into minimal human readable format (s, m:ss, or h:mm:ss)
	 */
	private String getReadableSecondsElapsed(final DpsTracker tracker)
	{
		final Instant endTime = tracker.getEnd() == null ? Instant.now() : tracker.getEnd();
		final double seconds = Duration.between(tracker.getStart(), endTime).getSeconds();
		if (seconds <= 60)
		{
			return String.format("%2.0f", seconds) + "s";
		}

		final double s = seconds % 3600 % 60;
		final double m = Math.floor(seconds % 3600 / 60);
		final double h = Math.floor(seconds / 3600);

		return h < 1 ? String.format("%2.0f:%02.0f", m, s) : String.format("%2.0f:%02.0f:%02.0f", h, m, s);
	}
}
