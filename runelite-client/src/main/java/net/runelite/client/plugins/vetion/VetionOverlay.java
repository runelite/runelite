/*
 * Copyright (c) 2019, Frosty Fridge <https://github.com/frostyfridge>
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
package net.runelite.client.plugins.vetion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

public class VetionOverlay extends Overlay
{

	private static final Color RED_ALPHA = new Color(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue(), 100);
	private static final Duration MAX_TIME = Duration.ofSeconds(9);
	private final VetionPlugin plugin;
	private final Client client;

	@Inject
	private VetionOverlay(Client client, VetionPlugin plugin)
	{
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		plugin.getVetions().forEach((actor, timer) ->
		{
			LocalPoint localPos = actor.getLocalLocation();
			if (localPos != null)
			{
				Point position = Perspective.localToCanvas(client, localPos, client.getPlane(),
					actor.getLogicalHeight() + 96);
				if (position != null)
				{
					position = new Point(position.getX(), position.getY());

					final ProgressPieComponent progressPie = new ProgressPieComponent();
					progressPie.setDiameter(30);
					progressPie.setFill(RED_ALPHA);
					progressPie.setBorderColor(Color.RED);
					progressPie.setPosition(position);

					final Duration duration = Duration.between(timer, Instant.now());
					progressPie.setProgress(1 - (duration.compareTo(MAX_TIME) < 0
						? (double) duration.toMillis() / MAX_TIME.toMillis()
						: 1));

					progressPie.render(graphics);
					if (1 - duration.compareTo(MAX_TIME) < 0)
					{
						plugin.getVetions().remove(actor);
					}
				}
			}
		});

		return null;
	}
}