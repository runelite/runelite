/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.plugins.mapTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;

public class MapViewOverlay extends Overlay
{
	private final MapTestPlugin plugin;

	@Inject
	private MapTestConfig config;

	private BufferedImage image = null;

	@Inject
	MapViewOverlay(MapTestPlugin plugin, MapTestConfig config)
	{
		this.plugin = plugin;
		this.config = config;
	}


	void setImage(BufferedImage image)
	{
		this.image = image;
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		graphics.drawImage(image, 0, 0, null);
		graphics.setColor(Color.WHITE);
		int pixelsPerTile = (int) plugin.getMapView().getPixelsPerTile();
		graphics.fillRect(image.getWidth() / 2, image.getHeight() / 2, pixelsPerTile, pixelsPerTile);

		Point mapMarker = plugin.getMapView().worldPointToGraphicsPoint(new WorldPoint(config.mapTestMarkerCoords().width, config.mapTestMarkerCoords().height, 0));
		graphics.setColor(Color.CYAN);
		graphics.fillOval(mapMarker.x, mapMarker.y, pixelsPerTile, pixelsPerTile);

		return config.mapTestDisplay();
	}
}
