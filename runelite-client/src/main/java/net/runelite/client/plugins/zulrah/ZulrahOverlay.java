/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.zulrah;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.zulrah.phase.ZulrahPhase;
import net.runelite.client.plugins.zulrah.phase.ZulrahType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZulrahOverlay extends Overlay
{
	private static final Logger logger = LoggerFactory.getLogger(ZulrahOverlay.class);

	private static final int CURRENT_PHASE_WIDTH = 86;
	private static final int NEXT_PHASE_WIDTH = 54;
	private static final int SPACER = 6;
	private static final int BOTTOM_BORDER = 4;
	private static final Color TILE_BORDER_COLOR = new Color(0, 0, 0, 100);
	private static final Color NEXT_TEXT_COLOR = new Color(255, 255, 255, 100);
	private static final Color RANGE_BACKGROUND_COLOR = new Color(150, 255, 0, 100);
	private static final Color MAGIC_BACKGROUND_COLOR = new Color(20, 170, 200, 100);
	private static final Color MELEE_BACKGROUND_COLOR = new Color(180, 50, 20, 100);
	private static final Color JAD_BACKGROUND_COLOR = new Color(255, 115, 0, 100);

	private final Client client = RuneLite.getClient();
	private final Zulrah plugin;
	private final Image[] zulrahImages = new Image[3];
	private final Image[] smallZulrahImages = new Image[3];
	private final Image[] prayerImages = new Image[2];

	ZulrahOverlay(Zulrah plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ZulrahInstance instance = plugin.getInstance();

		if (instance == null || client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		Rectangle viewport = getViewportBounds();
		if (viewport == null)
		{
			return null;
		}

		ZulrahPhase currentPhase = instance.getPhase();
		ZulrahPhase nextPhase = instance.getNextPhase();
		if (currentPhase == null)
		{
			return null;
		}

		String pattern = instance.getPattern() != null ? instance.getPattern().toString() : "Unknown";
		Point startTile = instance.getStartLocation();
		if (nextPhase != null && currentPhase.getStandLocation() == nextPhase.getStandLocation())
		{
			drawStandTiles(graphics, startTile, currentPhase, nextPhase);
		}
		else
		{
			drawStandTile(graphics, startTile, currentPhase, false);
			drawStandTile(graphics, startTile, nextPhase, true);
		}
		drawZulrahTileMinimap(graphics, startTile, currentPhase, false);
		drawZulrahTileMinimap(graphics, startTile, nextPhase, true);
		drawCurrentPhaseBox(graphics, viewport, currentPhase, pattern);
		drawNextPhaseBox(graphics, viewport, nextPhase);
		drawPrayerOutline(graphics, currentPhase.getPrayer());

		return null;
	}

	private void drawStandTiles(Graphics2D graphics, Point startTile, ZulrahPhase currentPhase, ZulrahPhase nextPhase)
	{
		Point localTile = Perspective.worldToLocal(client, currentPhase.getStandTile(startTile));
		localTile = new Point(localTile.getX() + Perspective.LOCAL_TILE_SIZE / 2, localTile.getY() + Perspective.LOCAL_TILE_SIZE / 2);
		Polygon northPoly = getCanvasTileNorthPoly(client, localTile);
		Polygon southPoly = getCanvasTileSouthPoly(client, localTile);
		Polygon poly = Perspective.getCanvasTilePoly(client, localTile);
		Point textLoc = Perspective.getCanvasTextLocation(client, graphics, localTile, "Next", 0);
		if (northPoly != null && southPoly != null && poly != null && textLoc != null)
		{
			Color northColor = getBackgroundColor(currentPhase.getType());
			Color southColor = getBackgroundColor(nextPhase.getType());
			graphics.setColor(northColor);
			graphics.fillPolygon(northPoly);
			graphics.setColor(southColor);
			graphics.fillPolygon(southPoly);
			graphics.setColor(TILE_BORDER_COLOR);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(poly);
			graphics.setColor(NEXT_TEXT_COLOR);
			graphics.drawString("Next", textLoc.getX(), textLoc.getY());
		}
		if (nextPhase.isJad())
		{
			Image jadPrayerImg = getProtectionPrayerImage(nextPhase.getPrayer());
			if (jadPrayerImg != null)
			{
				Point imageLoc = Perspective.getCanvasImageLocation(client, graphics, localTile, (BufferedImage) jadPrayerImg, 0);
				if (imageLoc != null)
				{
					graphics.drawImage(jadPrayerImg, imageLoc.getX(), imageLoc.getY(), null);
				}
			}
		}
	}

	private void drawStandTile(Graphics2D graphics, Point startTile, ZulrahPhase phase, boolean next)
	{
		if (phase == null)
		{
			return;
		}

		Point localTile = Perspective.worldToLocal(client, phase.getStandTile(startTile));
		localTile = new Point(localTile.getX() + Perspective.LOCAL_TILE_SIZE / 2, localTile.getY() + Perspective.LOCAL_TILE_SIZE / 2);
		Polygon poly = Perspective.getCanvasTilePoly(client, localTile);
		Color color = getBackgroundColor(phase.getType());
		if (poly != null)
		{
			graphics.setColor(TILE_BORDER_COLOR);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(poly);
			graphics.setColor(color);
			graphics.fillPolygon(poly);
		}
		if (next)
		{
			Point textLoc = Perspective.getCanvasTextLocation(client, graphics, localTile, "Next", 0);
			if (textLoc != null)
			{
				graphics.setColor(NEXT_TEXT_COLOR);
				graphics.drawString("Next", textLoc.getX(), textLoc.getY());
			}
			if (phase.isJad())
			{
				Image jadPrayerImg = getProtectionPrayerImage(phase.getPrayer());
				if (jadPrayerImg != null)
				{
					Point imageLoc = Perspective.getCanvasImageLocation(client, graphics, localTile, (BufferedImage) jadPrayerImg, 0);
					if (imageLoc != null)
					{
						graphics.drawImage(jadPrayerImg, imageLoc.getX(), imageLoc.getY(), null);
					}
				}
			}
		}
	}

	private void drawZulrahTileMinimap(Graphics2D graphics, Point startTile, ZulrahPhase phase, boolean next)
	{
		if (phase == null)
		{
			return;
		}
		Point zulrahLocalTile = Perspective.worldToLocal(client, phase.getZulrahTile(startTile));
		Point zulrahMinimapPoint = Perspective.worldToMiniMap(client, zulrahLocalTile.getX(), zulrahLocalTile.getY());
		Color color = getBackgroundColor(phase.getType());
		graphics.setColor(color);
		graphics.fillOval(zulrahMinimapPoint.getX(), zulrahMinimapPoint.getY(), 5, 5);
		graphics.setColor(TILE_BORDER_COLOR);
		graphics.setStroke(new BasicStroke(1));
		graphics.drawOval(zulrahMinimapPoint.getX(), zulrahMinimapPoint.getY(), 5, 5);
		if (next)
		{
			graphics.setColor(NEXT_TEXT_COLOR);
			FontMetrics fm = graphics.getFontMetrics();
			graphics.drawString("Next", zulrahMinimapPoint.getX() - fm.stringWidth("Next") / 2, zulrahMinimapPoint.getY() - 2);
		}
	}

	private void drawCurrentPhaseBox(Graphics2D graphics, Rectangle viewport, ZulrahPhase phase, String pattern)
	{
		Image zulrahImg = getZulrahImage(phase.getType());
		if (zulrahImg == null)
		{
			return;
		}

		FontMetrics fm = graphics.getFontMetrics();
		int height = fm.getHeight() * 2 + zulrahImg.getHeight(null) + SPACER + BOTTOM_BORDER;
		int bgX = (int) (viewport.getX() + viewport.getWidth() - CURRENT_PHASE_WIDTH);
		int bgY = (int) (viewport.getY() + viewport.getHeight() - height);
		Color backgroundColor = phase.isJad() ? JAD_BACKGROUND_COLOR : getBackgroundColor(phase.getType());

		graphics.setColor(backgroundColor);
		graphics.fillRect(bgX, bgY, CURRENT_PHASE_WIDTH, height);
		graphics.setColor(Color.WHITE);
		graphics.drawString(pattern, bgX + (CURRENT_PHASE_WIDTH - fm.stringWidth(pattern)) / 2, bgY + fm.getHeight());
		graphics.drawImage(zulrahImg, bgX + (CURRENT_PHASE_WIDTH - zulrahImg.getWidth(null)) / 2, bgY + fm.getHeight() + SPACER, null);
		if (phase.isJad())
		{
			graphics.setColor(Color.RED.darker());
			graphics.drawString("JAD PHASE", bgX + (CURRENT_PHASE_WIDTH - fm.stringWidth("JAD PHASE")) / 2, bgY + height - BOTTOM_BORDER);
		}
	}

	private void drawNextPhaseBox(Graphics2D graphics, Rectangle viewport, ZulrahPhase phase)
	{
		if (phase == null)
		{
			return;
		}
		Image zulrahImg = getSmallZulrahImage(phase.getType());
		if (zulrahImg == null)
		{
			return;
		}

		FontMetrics fm = graphics.getFontMetrics();
		int height = fm.getHeight() + zulrahImg.getHeight(null) + SPACER + BOTTOM_BORDER;
		int bgX = (int) (viewport.getX() + viewport.getWidth() - NEXT_PHASE_WIDTH - CURRENT_PHASE_WIDTH);
		int bgY = (int) (viewport.getY() + viewport.getHeight() - height);
		Color backgroundColor = phase.isJad() ? JAD_BACKGROUND_COLOR : getBackgroundColor(phase.getType());
		graphics.setColor(backgroundColor);
		graphics.fillRect(bgX, bgY, NEXT_PHASE_WIDTH, height);
		graphics.drawImage(zulrahImg, bgX + (NEXT_PHASE_WIDTH - zulrahImg.getWidth(null)) / 2, bgY + fm.getHeight() + SPACER, null);
		if (phase.isJad())
		{
			Image jadFirstPrayerImg = getProtectionPrayerImage(phase.getPrayer());
			graphics.drawImage(jadFirstPrayerImg, bgX + (NEXT_PHASE_WIDTH - zulrahImg.getWidth(null)) / 2, bgY + fm.getHeight() + SPACER, null);
			graphics.setColor(Color.RED.darker());
			graphics.drawString("Jad Next", bgX + (NEXT_PHASE_WIDTH - fm.stringWidth("Jad Next")) / 2, bgY + fm.getHeight());
		}
		else
		{
			graphics.setColor(Color.WHITE);
			graphics.drawString("Next", bgX + (NEXT_PHASE_WIDTH - fm.stringWidth("Next")) / 2, bgY + fm.getHeight());
		}
	}

	private Rectangle getViewportBounds()
	{
		Widget viewport = client.getViewportWidget();
		return viewport != null ? viewport.getBounds() : null;
	}

	private void drawPrayerOutline(Graphics2D graphics, Prayer prayer)
	{
		if (prayer == null || client.isPrayerActive(prayer))
		{
			return;
		}
		Widget prayerWidget;
		if (prayer == Prayer.PROTECT_FROM_MISSILES)
		{
			prayerWidget = client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MISSILES);
		}
		else
		{
			prayerWidget = client.getWidget(WidgetInfo.PRAYER_PROTECT_FROM_MAGIC);
		}
		if (prayerWidget != null)
		{
			Rectangle prayerBounds = prayerWidget.getBounds();
			if (prayerBounds != null)
			{
				graphics.setColor(Color.RED.darker());
				graphics.draw(prayerBounds);
			}
		}
	}

	private Polygon getCanvasTileNorthPoly(Client client, Point localLocation)
	{
		int plane = client.getPlane();
		int halfTile = Perspective.LOCAL_TILE_SIZE / 2;

		Point p1 = Perspective.worldToCanvas(client, localLocation.getX() - halfTile, localLocation.getY() - halfTile, plane);
		Point p2 = Perspective.worldToCanvas(client, localLocation.getX() - halfTile, localLocation.getY() + halfTile, plane);
		Point p3 = Perspective.worldToCanvas(client, localLocation.getX() + halfTile, localLocation.getY() + halfTile, plane);

		if (p1 == null || p2 == null || p3 == null)
		{
			return null;
		}

		Polygon poly = new Polygon();
		poly.addPoint(p1.getX(), p1.getY());
		poly.addPoint(p2.getX(), p2.getY());
		poly.addPoint(p3.getX(), p3.getY());

		return poly;
	}

	private Polygon getCanvasTileSouthPoly(Client client, Point localLocation)
	{
		int plane = client.getPlane();
		int halfTile = Perspective.LOCAL_TILE_SIZE / 2;

		Point p1 = Perspective.worldToCanvas(client, localLocation.getX() - halfTile, localLocation.getY() - halfTile, plane);
		Point p2 = Perspective.worldToCanvas(client, localLocation.getX() + halfTile, localLocation.getY() + halfTile, plane);
		Point p3 = Perspective.worldToCanvas(client, localLocation.getX() + halfTile, localLocation.getY() - halfTile, plane);

		if (p1 == null || p2 == null || p3 == null)
		{
			return null;
		}

		Polygon poly = new Polygon();
		poly.addPoint(p1.getX(), p1.getY());
		poly.addPoint(p2.getX(), p2.getY());
		poly.addPoint(p3.getX(), p3.getY());

		return poly;
	}

	private Color getBackgroundColor(ZulrahType type)
	{
		switch (type)
		{
			case RANGE:
				return RANGE_BACKGROUND_COLOR;
			case MAGIC:
				return MAGIC_BACKGROUND_COLOR;
			case MELEE:
				return MELEE_BACKGROUND_COLOR;
		}
		return Color.DARK_GRAY;
	}

	private Image getZulrahImage(ZulrahType type)
	{
		switch (type)
		{
			case RANGE:
				if (zulrahImages[0] == null)
				{
					zulrahImages[0] = getImage("zulrah_range.png");
				}
				return zulrahImages[0];
			case MAGIC:
				if (zulrahImages[1] == null)
				{
					zulrahImages[1] = getImage("zulrah_magic.png");
				}
				return zulrahImages[1];
			case MELEE:
				if (zulrahImages[2] == null)
				{
					zulrahImages[2] = getImage("zulrah_melee.png");
				}
				return zulrahImages[2];
		}
		return null;
	}

	private Image getSmallZulrahImage(ZulrahType type)
	{
		switch (type)
		{
			case RANGE:
				if (smallZulrahImages[0] == null)
				{
					smallZulrahImages[0] = getImage("zulrah_range_small.png");
				}
				return smallZulrahImages[0];
			case MAGIC:
				if (smallZulrahImages[1] == null)
				{
					smallZulrahImages[1] = getImage("zulrah_magic_small.png");
				}
				return smallZulrahImages[1];
			case MELEE:
				if (smallZulrahImages[2] == null)
				{
					smallZulrahImages[2] = getImage("zulrah_melee_small.png");
				}
				return smallZulrahImages[2];
		}
		return null;
	}

	private Image getProtectionPrayerImage(Prayer prayer)
	{
		switch (prayer)
		{
			case PROTECT_FROM_MAGIC:
				if (prayerImages[0] == null)
				{
					prayerImages[0] = getImage("/prayers/protect_from_magic.png");
				}
				return prayerImages[0];
			case PROTECT_FROM_MISSILES:
				if (prayerImages[1] == null)
				{
					prayerImages[1] = getImage("/prayers/protect_from_missiles.png");
				}
				return prayerImages[1];
		}
		return null;
	}

	private Image getImage(String path)
	{
		Image image = null;
		try
		{
			InputStream in = ZulrahOverlay.class.getResourceAsStream(path);
			image = ImageIO.read(in);
		}
		catch (IOException e)
		{
			logger.debug("Error loading image {}", e);
		}
		return image;
	}
}
