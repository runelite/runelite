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
import java.text.DecimalFormat;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.ui.overlay.components.TextComponent;

public class BurnerOverlay extends Overlay
{
	private final Client client;
	private final PohConfig config;
	private final PohPlugin plugin;
	private final TextComponent textComponent = new TextComponent(); //todo remove this as it is unused?

	@Inject
	public BurnerOverlay(Client client, PohConfig config, PohPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showBurner())
		{
			return null;
		}

		// Get each object in POH
		plugin.getPohObjects().forEach((object, tile) ->
		{
			// If planes match
			if (tile.getPlane() == client.getPlane())
			{
				if (getBURNER_LIT().contains(object.getId()))
				{
					if (config.showBurnerTime())
					{
						DecimalFormat df = new DecimalFormat("#.##");
						if (plugin.getCountdownTimerMap().containsKey(tile))
						{
							double certainSec = plugin.getCountdownTimerMap().get(tile);
							double randomSec = plugin.getRandomTimerMap().get(tile);
							certainSec = Double.valueOf(df.format(certainSec));
							randomSec = Double.valueOf(df.format(randomSec));
							ProgressPieComponent pieTimer = new ProgressPieComponent();
							pieTimer.setPosition(object.getCanvasLocation());
							pieTimer.setProgress((certainSec / plugin.getCountdownTimer()));

							if (certainSec > 0)
							{
								renderPie(graphics, Color.GREEN, Color.GREEN, pieTimer);
							}
							else
							{
								pieTimer.setProgress((randomSec / plugin.getRandomTimer()));
								if (randomSec > 0)
								{
									renderPie(graphics, Color.ORANGE, Color.ORANGE, pieTimer);
								}
							}
						}
					}
				}
			}
		});
		return null;
	}

	private void renderPie(Graphics2D graphics, Color fillColor, Color borderColor, ProgressPieComponent pieProgress)
	{
		pieProgress.setFill(fillColor);
		pieProgress.setBorderColor(borderColor);
		pieProgress.render(graphics);
	}
}
