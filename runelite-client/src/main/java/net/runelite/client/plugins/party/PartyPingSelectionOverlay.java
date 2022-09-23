/*
 * Copyright (c) 2022, kamielvf <code@kamiel.dev>
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
package net.runelite.client.plugins.party;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class PartyPingSelectionOverlay extends Overlay
{
	private static final Color BACKGROUND_COLOR = new Color(42, 38, 27, 155);
	private static final Color OUTSIDE_STROKE_COLOR = new Color(111, 108, 94, 120);
	private static final Color INSIDE_STROKE_COLOR = new Color(80, 72, 59, 200);
	private static final Color PING_SELECTION_HIGHLIGHT_COLOR = new Color(107, 105, 97, 155);

	private static final int RADIAL_MENU_RADIUS = 55;
	private static final int RADIAL_MENU_THICKNESS = 30;
	private static final int RADIAL_MENU_SIZE = RADIAL_MENU_RADIUS * 2;
	private static final int RADIAL_MENU_HOLE_SIZE = RADIAL_MENU_RADIUS * 2 - RADIAL_MENU_THICKNESS * 2;

	private final Client client;
	private final PartyPlugin plugin;

	@Inject
	private PartyPingSelectionOverlay(final Client client, final PartyPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isAdvancedPingMenuOpen())
		{
			return null;
		}

		Point mouseStartPosition = plugin.getMouseStartPosition();
		Point mouseCanvasPosition = client.getMouseCanvasPosition();
		int centerX = mouseStartPosition.getX();
		int centerY = mouseStartPosition.getY();
		int baseX = centerX - RADIAL_MENU_RADIUS;
		int baseY = centerY - RADIAL_MENU_RADIUS;

		renderRadialMenuBackground(graphics, baseX, baseY);

		// highlight ping type option if one is selected
		if (plugin.getPendingPartyPing() != null && plugin.getPendingPartyPing().getPingType() != null)
		{
			renderRadialHighlight(graphics, baseX, baseY);
		}

		renderMenuIcons(graphics, centerX, centerY);
		renderIndicationLine(graphics, mouseStartPosition, mouseCanvasPosition);

		return null;
	}

	private void renderRadialMenuBackground(final Graphics2D graphics, int baseX, int baseY)
	{
		Ellipse2D outer = new Ellipse2D.Double(baseX, baseY, RADIAL_MENU_SIZE, RADIAL_MENU_SIZE);
		Ellipse2D inner = new Ellipse2D.Double(baseX + RADIAL_MENU_THICKNESS,  baseY + RADIAL_MENU_THICKNESS, RADIAL_MENU_HOLE_SIZE, RADIAL_MENU_HOLE_SIZE);
		
		Area area = new Area(outer);
		area.subtract(new Area(inner));
		graphics.setColor(BACKGROUND_COLOR);
		graphics.fill(area);
		
		// outlines
		graphics.setColor(INSIDE_STROKE_COLOR);
		graphics.drawOval(baseX - 1, baseY - 1, RADIAL_MENU_SIZE + 1, RADIAL_MENU_SIZE + 1);
		graphics.drawOval(baseX + RADIAL_MENU_THICKNESS, baseY + RADIAL_MENU_THICKNESS, RADIAL_MENU_HOLE_SIZE - 1, RADIAL_MENU_HOLE_SIZE - 1);

		graphics.setColor(OUTSIDE_STROKE_COLOR);
		graphics.drawOval(baseX - 2, baseY - 2, RADIAL_MENU_SIZE + 3, RADIAL_MENU_SIZE + 3);
		graphics.drawOval(baseX + RADIAL_MENU_THICKNESS + 1, baseY + RADIAL_MENU_THICKNESS + 1, RADIAL_MENU_HOLE_SIZE - 3, RADIAL_MENU_HOLE_SIZE - 3);
	}

	private void renderRadialHighlight(final Graphics2D graphics, int baseX, int baseY)
	{
		// substract 1 because TARGET ping type is our default and not shown in advanced menu
		double optionSelectionSize = 360.0 / (PartyPingType.values().length - 1);
		double offset = optionSelectionSize / 2.0;

		PartyPingType pingType = plugin.getPendingPartyPing().getPingType();

		// Arc2D draws counter-clockwise and 0deg = 3 o'clock, but our radial menu starts at 9 o'clock + offset, going clockwise
		double startAngle = 180 - offset - pingType.ordinal() * optionSelectionSize;
		if (startAngle < 0)
		{
			startAngle += 360;
		}
		
		Arc2D arc = new Arc2D.Double(baseX, baseY, RADIAL_MENU_SIZE, RADIAL_MENU_SIZE, startAngle, -optionSelectionSize, Arc2D.PIE);
		Ellipse2D inner = new Ellipse2D.Double(baseX + RADIAL_MENU_THICKNESS,  baseY + RADIAL_MENU_THICKNESS, RADIAL_MENU_HOLE_SIZE, RADIAL_MENU_HOLE_SIZE);
		Area area = new Area(arc);
		area.subtract(new Area(inner));

		graphics.setColor(PING_SELECTION_HIGHLIGHT_COLOR);
		graphics.fill(area);
	}
	
	private void renderMenuIcons(final Graphics2D graphics, int centerX, int centerY)
	{
		double optionSelectionSize = 360.0 / (PartyPingType.values().length - 1);
		for (PartyPingType type : PartyPingType.values())
		{
			// skip default target ping
			if (type == PartyPingType.TARGET)
			{
				continue;
			}
			
			// substract optionSelectionSize because our radial menu is slightly rotated
			double angle = type.ordinal() * optionSelectionSize - optionSelectionSize;
			final BufferedImage img = type.getImage();
			
			int radius = RADIAL_MENU_RADIUS - RADIAL_MENU_THICKNESS / 2 - 1;
			double rad = Math.toRadians(angle);
			int x = (int) (centerX - (img.getWidth() / 2) + (radius * Math.cos(rad)));
			int y = (int) (centerY - (img.getHeight() / 2) + (radius * Math.sin(rad)));
			graphics.drawImage(img, x, y, null);
		}
	}

	private void renderIndicationLine(final Graphics2D graphics, Point start, Point end)
	{
		graphics.setColor(Color.WHITE);
		graphics.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
	}
}
