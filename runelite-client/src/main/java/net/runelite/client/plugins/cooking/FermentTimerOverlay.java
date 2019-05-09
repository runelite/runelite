/*
 * Copyright (c) 2019, Lucas C <lucas1757@gmail.com>
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
package net.runelite.client.plugins.cooking;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.api.AnimationID.COOKING_WINE;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Slf4j
class FermentTimerOverlay extends Overlay
{
	private static final int INITIAL_TIME = 12;

	private final Client client;
	private final CookingPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private FermentTimerOverlay(final Client client, final CookingPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Fermenting Timer overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		FermentTimerSession session = plugin.getFermentTimerSession();
		if (session == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		if (isMakingWine() || Duration.between(session.getLastWineMakingAction(), Instant.now()).getSeconds() < INITIAL_TIME)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Making Wine")
				.color(Color.GREEN)
				.build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Ferments in: ")
				.right(String.valueOf(INITIAL_TIME - Duration.between(session.getLastWineMakingAction(), Instant.now()).getSeconds()))
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Wine Fermented")
				.color(Color.ORANGE)
				.build());
		}

		return panelComponent.render(graphics);
	}

	private boolean isMakingWine()
	{
		return (client.getLocalPlayer().getAnimation() == COOKING_WINE);
	}
}
