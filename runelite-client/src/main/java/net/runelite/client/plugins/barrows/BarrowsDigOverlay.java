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
package net.runelite.client.plugins.barrows;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.geometry.Geometry;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class BarrowsDigOverlay extends Overlay
{
	private final Client client;
	private final BarrowsPlugin plugin;
	private final BarrowsConfig config;

	@Inject
	private BarrowsDigOverlay(Client client, BarrowsPlugin plugin, BarrowsConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isBarrowsLoaded() && config.showDigLoc())
		{
			renderDigLocations(graphics);
		}

		return null;
	}

	private void transformWorldToLocal(float[] coords)
	{
		final LocalPoint lp = LocalPoint.fromWorld(client, (int)coords[0], (int)coords[1]);
		coords[0] = lp.getX() - Perspective.LOCAL_TILE_SIZE / 2f;
		coords[1] = lp.getY() - Perspective.LOCAL_TILE_SIZE / 2f;
	}

	private void renderDigLocations(Graphics2D graphics)
	{
		Area greenArea = new Area();
		Area redArea = new Area();
		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			if (client.getVarbitValue(brother.getKilledVarbit()) == 0)
			{
				greenArea.add(new Area(new Rectangle(brother.getLocation().getX(), brother.getLocation().getY(), brother.getLocation().getWidth(), brother.getLocation().getHeight())));
			}
			if (client.getVarbitValue(brother.getKilledVarbit()) == 1)
			{
				redArea.add(new Area(new Rectangle(brother.getLocation().getX(), brother.getLocation().getY(), brother.getLocation().getWidth(), brother.getLocation().getHeight())));
			}
		}

		final Rectangle sceneRect = new Rectangle(client.getBaseX() + 1, client.getBaseY() + 1, Constants.SCENE_SIZE - 2, Constants.SCENE_SIZE - 2);
		GeneralPath greenPath = new GeneralPath(greenArea);
		greenPath = Geometry.clipPath(greenPath, sceneRect);
		greenPath = Geometry.splitIntoSegments(greenPath, 1);
		greenPath = Geometry.transformPath(greenPath, this::transformWorldToLocal);
		greenPath = Geometry.filterPath(greenPath, (p1, p2) ->
			Perspective.localToCanvas(client, new LocalPoint((int)p1[0], (int)p1[1]), client.getPlane()) != null &&
				Perspective.localToCanvas(client, new LocalPoint((int)p2[0], (int)p2[1]), client.getPlane()) != null);
		greenPath = Geometry.transformPath(greenPath, coords ->
		{
			Point point = Perspective.localToCanvas(client, new LocalPoint((int)coords[0], (int)coords[1]), client.getPlane());
			coords[0] = point.getX();
			coords[1] = point.getY();
		});

		graphics.setStroke(new BasicStroke(1));
		graphics.setColor(config.digLocColor());
		graphics.draw(greenPath);

		GeneralPath redPath = new GeneralPath(redArea);
		redPath = Geometry.clipPath(redPath, sceneRect);
		redPath = Geometry.splitIntoSegments(redPath, 1);
		redPath = Geometry.transformPath(redPath, this::transformWorldToLocal);
		redPath = Geometry.filterPath(redPath, (p1, p2) ->
			Perspective.localToCanvas(client, new LocalPoint((int)p1[0], (int)p1[1]), client.getPlane()) != null &&
				Perspective.localToCanvas(client, new LocalPoint((int)p2[0], (int)p2[1]), client.getPlane()) != null);

		redPath = Geometry.transformPath(redPath, coords ->
		{
			Point point = Perspective.localToCanvas(client, new LocalPoint((int)coords[0], (int)coords[1]), client.getPlane());
			coords[0] = point.getX();
			coords[1] = point.getY();
		});

		graphics.setColor(config.emptyDigLocColor());
		graphics.draw(redPath);
	}
}