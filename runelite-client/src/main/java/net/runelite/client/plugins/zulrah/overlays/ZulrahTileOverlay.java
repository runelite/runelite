/*
 * Copyright (c) 2018, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.zulrah.overlays;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.zulrah.ZulrahInstance;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;
import net.runelite.client.plugins.zulrah.phase.ZulrahPhase;
import net.runelite.client.plugins.zulrah.phase.ZulrahType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class ZulrahTileOverlay extends Overlay
{
	private static final Color NEXT_COLOR = new Color(255, 255, 255, 150);

	private Client client;
	private ZulrahPlugin plugin;
	private SpriteManager spriteManager;

	@Inject
	ZulrahTileOverlay(Client client, ZulrahPlugin plugin, SpriteManager spriteManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.spriteManager = spriteManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ZulrahInstance instance = plugin.getInstance();
		if (instance == null)
		{
			return null;
		}
		ZulrahPhase currentPhase = instance.getPhase();
		ZulrahPhase nextPhase = instance.getNextPhase();
		WorldPoint startPoint = instance.getStartWorldPoint();
		if (currentPhase == null || startPoint == null)
		{
			return null;
		}
		if (nextPhase == null)
		{
			drawSafeCanvas(graphics, currentPhase, startPoint, false);
			drawSafeMinimap(graphics, currentPhase, startPoint);
			drawZulrahMinimap(graphics, currentPhase, startPoint);
		}
		else if (currentPhase.getSafeLocation() == nextPhase.getSafeLocation())
		{
			drawSafeCanvas(graphics, currentPhase, nextPhase, startPoint);
			drawSafeMinimap(graphics, currentPhase, startPoint);
			drawZulrahMinimap(graphics, currentPhase, startPoint);
		}
		else
		{
			drawSafeCanvas(graphics, currentPhase, startPoint, false);
			drawSafeCanvas(graphics, nextPhase, startPoint, true);
			drawSafeMinimap(graphics, currentPhase, startPoint);
			drawZulrahMinimap(graphics, currentPhase, startPoint);
		}
		return null;
	}

	private void drawSafeCanvas(Graphics2D graphics, ZulrahPhase phase, WorldPoint start, boolean next)
	{
		Color color = phase.getColor();
		WorldPoint safe = phase.getSafeWorldPoint(start);
		LocalPoint local = LocalPoint.fromWorld(client, safe);
		if (local == null)
		{
			return;
		}
		Polygon poly = Perspective.getCanvasTilePoly(client, local);
		if (poly == null)
		{
			return;
		}
		Rectangle2D bounds = poly.getBounds2D();
		int centerX = (int) bounds.getCenterX();
		int centerY = (int) bounds.getCenterY();
		graphics.setColor(color);
		OverlayUtil.renderPolygon(graphics, poly, color);
		if (next && !phase.isJad())
		{
			graphics.setColor(NEXT_COLOR);
			int strWidth = graphics.getFontMetrics().stringWidth("next");
			graphics.drawString("next", centerX - (strWidth / 2), centerY);
		}
		if (phase.isJad())
		{
			Prayer prayer = phase.getType() == ZulrahType.RANGE ? Prayer.PROTECT_FROM_MISSILES : Prayer.PROTECT_FROM_MAGIC;
			BufferedImage prayerImg = getPrayerBufferedImage(prayer);
			if (prayerImg != null)
			{
				Point imgPoint = Perspective.getCanvasImageLocation(client, local, prayerImg, 0);
				if (imgPoint != null)
				{
					graphics.drawImage(prayerImg, imgPoint.getX(), imgPoint.getY(), null);
				}
			}
		}
	}

	private void drawSafeCanvas(Graphics2D graphics, ZulrahPhase current, ZulrahPhase next, WorldPoint start)
	{
		Color color1 = current.getColor();
		Color color2 = next.getColor();
		WorldPoint safe = current.getSafeWorldPoint(start);
		LocalPoint local = LocalPoint.fromWorld(client, safe);
		if (local == null)
		{
			return;
		}
		Polygon poly = Perspective.getCanvasTilePoly(client, local);
		if (poly == null)
		{
			return;
		}
		Rectangle2D bounds = poly.getBounds2D();
		int centerX = (int) bounds.getCenterX();
		int centerY = (int) bounds.getCenterY();
		graphics.setColor(color2);
		final Stroke originalStroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(2));
		graphics.drawPolygon(poly);
		graphics.setColor(new Color(color1.getRed(), color1.getGreen(), color1.getBlue(), 50));
		graphics.fillPolygon(poly);
		graphics.setStroke(originalStroke);
		graphics.setColor(NEXT_COLOR);
		if (!next.isJad())
		{
			int strWidth = graphics.getFontMetrics().stringWidth("next");
			graphics.drawString("next", centerX - (strWidth / 2), centerY);
		}
		if (current.isJad() || next.isJad())
		{
			ZulrahPhase phase = current.isJad() ? current : next;
			Prayer prayer = phase.getType() == ZulrahType.RANGE ? Prayer.PROTECT_FROM_MISSILES : Prayer.PROTECT_FROM_MAGIC;
			BufferedImage prayerImg = getPrayerBufferedImage(prayer);
			if (prayerImg != null)
			{
				Point imgPoint = Perspective.getCanvasImageLocation(client, local, prayerImg, 0);
				if (imgPoint != null)
				{
					graphics.drawImage(prayerImg, imgPoint.getX(), imgPoint.getY(), null);
				}
			}
		}
	}

	private void drawSafeMinimap(Graphics2D graphics, ZulrahPhase phase, WorldPoint start)
	{
		WorldPoint safe = phase.getSafeWorldPoint(start);
		Point minimap = worldToMinimap(safe);
		if (minimap != null)
		{
			graphics.setColor(Color.BLACK);
			graphics.drawLine(minimap.getX(), minimap.getY(), minimap.getX() + 5, minimap.getY() + 5);
			graphics.drawLine(minimap.getX() + 5, minimap.getY(), minimap.getX(), minimap.getY() + 5);
			graphics.setColor(Color.WHITE);
			graphics.drawLine(minimap.getX() - 1, minimap.getY(), minimap.getX() + 4, minimap.getY() + 5);
			graphics.drawLine(minimap.getX() + 4, minimap.getY(), minimap.getX() - 1, minimap.getY() + 5);
		}
	}

	private void drawZulrahMinimap(Graphics2D graphics, ZulrahPhase phase, WorldPoint start)
	{
		Point minimap = worldToMinimap(phase.getZulrahWorldPoint(start));
		if (minimap != null)
		{
			OverlayUtil.renderMinimapLocation(graphics, minimap, phase.getColor());
		}
	}

	private BufferedImage getPrayerBufferedImage(Prayer prayer)
	{
		switch (prayer)
		{
			case PROTECT_FROM_MAGIC:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MAGIC, 0);
			case PROTECT_FROM_MISSILES:
				return spriteManager.getSprite(SpriteID.PRAYER_PROTECT_FROM_MISSILES, 0);
		}
		return null;
	}

	private Point worldToMinimap(WorldPoint world)
	{
		LocalPoint local = LocalPoint.fromWorld(client, world);
		if (local != null)
		{
			return Perspective.localToMinimap(client, local);
		}
		return null;
	}
}
