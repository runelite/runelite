/*
 * Copyright (c) 2018, Kbman99 <https://github.com/Kbman99>
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
package net.runelite.client.plugins.world;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;


@Slf4j
class WorldOverlay extends Overlay
{
	private final WorldConfig config;
	private final Client client;
	private final TextComponent textComponent = new TextComponent();

	@Inject
	private WorldOverlay(Client client, WorldConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.config = config;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		boolean showWorld = config.showWorld();

		if (!showWorld)
		{
			return null;
		}

		final String world = Integer.toString(client.getWorld());
		final Color worldTextColor = new Color(0, 255, 0);
		final Widget view = client.getWidget(WidgetInfo.WORLD_MAP_OPTION);

		Point orbPosition = view.getCanvasLocation();

		int x = orbPosition.getX();
		int y = orbPosition.getY();
		int orbWidth = view.getWidth();
		int orbHeight = view.getHeight();

		Color transparentOrb = new Color(0, 0, 0, 80);

		graphics.setColor(transparentOrb);
		graphics.fillOval(x, y, orbWidth, orbHeight);

		java.awt.Point newPoint = new java.awt.Point(x + 1, y + (orbWidth * 3) / 4);
		textComponent.setColor(worldTextColor);
		textComponent.setText(world);
		textComponent.setPosition(newPoint);

		return textComponent.render(graphics);
	}
}
