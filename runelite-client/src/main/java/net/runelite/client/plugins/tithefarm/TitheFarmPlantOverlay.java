/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.tithefarm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class TitheFarmPlantOverlay extends Overlay
{
	private static final int TIMER_SIZE = 25;
	private static final int TIMER_BORDER_WIDTH = 1;

	private final Client client;
	private final TitheFarmPlugin plugin;
	private final TitheFarmPluginConfig config;

	@Inject
	TitheFarmPlantOverlay(Client client, TitheFarmPlugin plugin, TitheFarmPluginConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget viewport = client.getViewportWidget();
		for (TitheFarmPlant plant : plugin.getPlants())
		{
			LocalPoint localLocation = LocalPoint.fromWorld(client, plant.getWorldLocation());
			if (localLocation == null)
			{
				continue;
			}
			net.runelite.api.Point canvasLocation = Perspective.worldToCanvas(client, localLocation.getX(), localLocation.getY(), client.getPlane());
			if (viewport != null && canvasLocation != null)
			{
				switch (plant.getState())
				{
					case UNWATERED:
						drawTimerOnPlant(graphics, plant, canvasLocation, config.getColorUnwatered());
						break;
					case WATERED:
						drawTimerOnPlant(graphics, plant, canvasLocation, config.getColorWatered());
						break;
					case GROWN:
						drawTimerOnPlant(graphics, plant, canvasLocation, config.getColorGrown());
						break;
				}
			}
		}

		return null;
	}

	private void drawTimerOnPlant(Graphics2D graphics, TitheFarmPlant plant, net.runelite.api.Point loc, Color color)
	{
		//Construct the arc
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setAngleStart(90);
		double timeLeft = 1 - plant.getPlantTimeRelative();
		arc.setAngleExtent(timeLeft * 360);
		arc.setFrame(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);

		//Draw the inside of the arc
		graphics.setColor(color);
		graphics.fill(arc);

		//Draw the outlines of the arc
		graphics.setStroke(new BasicStroke(TIMER_BORDER_WIDTH));
		graphics.drawOval(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);
	}
}
