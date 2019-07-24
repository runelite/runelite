/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.poh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

@Singleton
class BurnerOverlay extends Overlay
{
	private final Client client;
	private final PohPlugin plugin;

	@Inject
	private BurnerOverlay(final Client client, final PohPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isShowBurner())
		{
			return null;
		}

		plugin.getIncenseBurners().forEach((tile, burner) ->
		{
			if (tile.getPlane() != client.getPlane())
			{
				return;
			}

			if (!PohPlugin.BURNER_LIT.contains(burner.getId()))
			{
				return;
			}

			final Instant now = Instant.now();
			final long startCountdown = Duration.between(burner.getStart(), now).getSeconds();
			final double certainSec = burner.getCountdownTimer() - startCountdown;

			long endCountdown = 0;

			if (certainSec <= 0)
			{
				if (burner.getEnd() == null)
				{
					burner.setEnd(Instant.now());
				}

				endCountdown = Duration.between(burner.getEnd(), now).getSeconds();
			}

			final double randomSec = burner.getRandomTimer() - endCountdown;
			final ProgressPieComponent pieComponent = new ProgressPieComponent();
			final Point loc = Perspective.localToCanvas(client, tile.getLocalLocation(), tile.getPlane());

			if (loc == null)
			{
				return;
			}

			pieComponent.setPosition(loc);

			if (certainSec > 0)
			{
				pieComponent.setProgress(certainSec / burner.getCountdownTimer());
				pieComponent.setFill(Color.GREEN);
				pieComponent.setBorderColor(Color.GREEN);
				pieComponent.render(graphics);
			}
			else if (randomSec > 0)
			{
				pieComponent.setProgress(randomSec / burner.getRandomTimer());
				pieComponent.setFill(Color.ORANGE);
				pieComponent.setBorderColor(Color.ORANGE);
				pieComponent.render(graphics);
			}
		});

		return null;
	}
}
