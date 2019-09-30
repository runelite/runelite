/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.lizardmenshaman;

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
class ShamanSpawnOverlay extends Overlay
{
	private final Client client;
	private final LizardmenShamanPlugin plugin;

	@Inject
	private ShamanSpawnOverlay(final Client client, final LizardmenShamanPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		plugin.getSpawns().forEach((localPoint, spawn) ->
		{
			final Instant now = Instant.now();
			final long startCountdown = Duration.between(spawn.getStart(), now).getSeconds();
			final double certainSec = spawn.getCountdownTimer() - startCountdown;

			if (certainSec <= 0 && spawn.getEnd() == null)
			{
				spawn.setEnd(Instant.now());
			}

			final ProgressPieComponent pieComponent = new ProgressPieComponent();
			final Point loc = Perspective.localToCanvas(client, localPoint, client.getPlane());

			if (loc == null || certainSec < 0)
			{
				return;
			}

			pieComponent.setPosition(loc);
			pieComponent.setProgress(certainSec / spawn.getCountdownTimer());
			if (certainSec > 4.8)
			{
				pieComponent.setFill(Color.GREEN);
				pieComponent.setBorderColor(Color.GREEN);
				pieComponent.render(graphics);
			}
			else if (certainSec > 3.6)
			{
				pieComponent.setFill(Color.YELLOW);
				pieComponent.setBorderColor(Color.YELLOW);
				pieComponent.render(graphics);
			}
			else if (certainSec > 2.4)
			{
				pieComponent.setFill(Color.ORANGE);
				pieComponent.setBorderColor(Color.ORANGE);
				pieComponent.render(graphics);
			}
			else if (certainSec > 1.2)
			{
				pieComponent.setFill(new Color(255, 140, 0));
				pieComponent.setBorderColor(new Color(255, 140, 0));
				pieComponent.render(graphics);
			}
			else
			{
				pieComponent.setFill(Color.RED);
				pieComponent.setBorderColor(Color.RED);
				pieComponent.render(graphics);
			}
		});
		return null;
	}
}
