/*
 * Copyright (c) 2020 Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.dpscounter;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.QuantityFormatter;
import net.runelite.client.ws.PartyService;

class DpsOverlay extends OverlayPanel
{
	private static final DecimalFormat DPS_FORMAT = new DecimalFormat("#0.0");
	private static final int PANEL_WIDTH_OFFSET = 10; // assumes 8 for panel component border + 2px between left and right

	static final OverlayMenuEntry RESET_ENTRY = new OverlayMenuEntry(RUNELITE_OVERLAY, "Reset", "DPS counter");
	static final OverlayMenuEntry PAUSE_ENTRY = new OverlayMenuEntry(RUNELITE_OVERLAY, "Pause", "DPS counter");
	static final OverlayMenuEntry UNPAUSE_ENTRY = new OverlayMenuEntry(RUNELITE_OVERLAY, "Unpause", "DPS counter");

	private final DpsCounterPlugin dpsCounterPlugin;
	private final DpsConfig dpsConfig;
	private final PartyService partyService;
	private final Client client;
	private final TooltipManager tooltipManager;

	@Inject
	DpsOverlay(DpsCounterPlugin dpsCounterPlugin, DpsConfig dpsConfig, PartyService partyService, Client client,
		TooltipManager tooltipManager)
	{
		super(dpsCounterPlugin);
		this.dpsCounterPlugin = dpsCounterPlugin;
		this.dpsConfig = dpsConfig;
		this.partyService = partyService;
		this.client = client;
		this.tooltipManager = tooltipManager;
		getMenuEntries().add(RESET_ENTRY);
		setPaused(false);
	}

	@Override
	public void onMouseOver()
	{
		DpsMember total = dpsCounterPlugin.getTotal();
		Duration elapsed = total.elapsed();
		long s = elapsed.getSeconds();
		String format;
		if (s >= 3600)
		{
			format = String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
		}
		else
		{
			format = String.format("%d:%02d", s / 60, (s % 60));
		}
		tooltipManager.add(new Tooltip("Elapsed time: " + format));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Map<String, DpsMember> dpsMembers = dpsCounterPlugin.getMembers();
		if (dpsMembers.isEmpty())
		{
			return null;
		}

		boolean inParty = !partyService.getMembers().isEmpty();
		boolean showDamage = dpsConfig.showDamage();
		DpsMember total = dpsCounterPlugin.getTotal();
		boolean paused = total.isPaused();

		final String title = (inParty ? "Party " : "") + (showDamage ? "Damage" : "DPS") + (paused ? " (paused)" : "");
		panelComponent.getChildren().add(
			TitleComponent.builder()
				.text(title)
				.build());

		int maxWidth = ComponentConstants.STANDARD_WIDTH;
		FontMetrics fontMetrics = graphics.getFontMetrics();

		for (DpsMember dpsMember : dpsMembers.values())
		{
			String left = dpsMember.getName();
			String right = showDamage ? QuantityFormatter.formatNumber(dpsMember.getDamage()) : DPS_FORMAT.format(dpsMember.getDps());
			maxWidth = Math.max(maxWidth, fontMetrics.stringWidth(left) + fontMetrics.stringWidth(right));
			panelComponent.getChildren().add(
				LineComponent.builder()
					.left(left)
					.right(right)
					.build());
		}

		panelComponent.setPreferredSize(new Dimension(maxWidth + PANEL_WIDTH_OFFSET, 0));

		if (!inParty)
		{
			Player player = client.getLocalPlayer();
			if (player.getName() != null)
			{
				DpsMember self = dpsMembers.get(player.getName());

				if (self != null && total.getDamage() > self.getDamage())
				{
					panelComponent.getChildren().add(
						LineComponent.builder()
							.left(total.getName())
							.right(showDamage ? Integer.toString(total.getDamage()) : DPS_FORMAT.format(total.getDps()))
							.build());
				}
			}
		}

		return super.render(graphics);
	}

	void setPaused(boolean paused)
	{
		OverlayMenuEntry remove = paused ? PAUSE_ENTRY : UNPAUSE_ENTRY;
		OverlayMenuEntry add = paused ? UNPAUSE_ENTRY : PAUSE_ENTRY;
		getMenuEntries().remove(remove);
		if (!getMenuEntries().contains(add))
		{
			getMenuEntries().add(add);
		}
	}
}
