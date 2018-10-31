/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import static net.runelite.client.plugins.raids.RaidsPlugin.POINTS_FORMAT;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class RaidsPointsOverlay extends Overlay
{
	@Inject
	private Client client;

	@Inject
	private RaidsPlugin plugin;

	private final PanelComponent panel = new PanelComponent();

	@Inject
	public RaidsPointsOverlay()
	{
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInRaidChambers())
		{
			return null;
		}

		int totalPoints = client.getVar(Varbits.TOTAL_POINTS);
		int personalPoints = client.getVar(Varbits.PERSONAL_POINTS);
		int partySize = client.getVar(Varbits.RAID_PARTY_SIZE);

		panel.getChildren().clear();
		panel.getChildren().add(LineComponent.builder()
			.left("Total:")
			.right(POINTS_FORMAT.format(totalPoints))
			.build());

		panel.getChildren().add(LineComponent.builder()
			.left(client.getLocalPlayer().getName() + ":")
			.right(POINTS_FORMAT.format(personalPoints))
			.build());

		if (partySize > 1)
		{
			panel.getChildren().add(LineComponent.builder()
				.left("Party size:")
				.right(String.valueOf(partySize))
				.build());
		}

		return panel.render(graphics);
	}
}
