/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/kyleeld>
 * Copyright (c) 2019, pklite <https://github.com/pklite/pklite>
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
package net.runelite.client.plugins.freezetimers;

import java.awt.Color;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

public class FreezeTimersOverlay extends Overlay
{
	private final FreezeTimersConfig config;
	private final Client client;
	private final Font timerFont = FontManager.getRunescapeBoldFont().deriveFont(14.0f);
	private final BufferedImage FREEZE_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "freeze.png");
	private final BufferedImage TB_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "teleblock.png");
	private final BufferedImage VENG_IMAGE = ImageUtil.getResourceStreamFromClass(getClass(), "veng.png");
	@Inject
	private Timers timers;
	private boolean lock;
	private long finishedAtTest;


	@Inject
	public FreezeTimersOverlay(FreezeTimersConfig config, Client client)
	{
		this.config = config;
		this.client = client;
		setPriority(OverlayPriority.HIGHEST);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showPlayers())
		{
			client.getPlayers().forEach((p) -> renderOverlayFor(graphics, p));
		}
		if (config.showNpcs())
		{
			client.getNpcs().forEach((npc) -> renderOverlayFor(graphics, npc));
		}
		return null;
	}

	private void renderOverlayFor(Graphics2D g, Actor actor)
	{
		if (timers.areAllTimersZero(actor))
		{
			return;
		}

		int overlaysDrawn = 0;

		if (drawFreezeOverlay(g, actor, overlaysDrawn) && config.FreezeTimers())
		{
			overlaysDrawn++;
		}
		if (drawTBOverlay(g, actor, overlaysDrawn) && config.TB())
		{
			overlaysDrawn++;
		}
		if (drawVengOverlay(g, actor, overlaysDrawn) && config.Veng())
		{
			overlaysDrawn++;
		}
	}

	private boolean drawFreezeOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		long currentTick = System.currentTimeMillis();
		if (timers.getTimerEnd(actor, TimerType.FREEZE) <= currentTick)
		{
			return false;
		}
		long finishedAt = timers.getTimerEnd(actor, TimerType.FREEZE);

		String text = processTickCounter(finishedAt);
		int test = Integer.parseInt(text);
		Point poi = actor.getCanvasTextLocation(g, text, 0);
		int xpoi = poi.getX();
		int ypoi = poi.getY();
		Point FixedPoint = new Point(xpoi, ypoi);

		if (config.noImage())
		{
			if (test > 3)
			{
				renderTextLocation(g, text, config.textSize(), config.fontStyle().getFont(), Color.WHITE, FixedPoint);
			}
			else
			{
				renderTextLocation(g, text, config.textSize(), config.fontStyle().getFont(), Color.YELLOW, FixedPoint);
			}
		}
		else
		{
			renderActorText(g, actor, text, overlaysDrawn, FREEZE_IMAGE);
		}
		return true;
	}

	private boolean drawTBOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		long currentTick = System.currentTimeMillis();
		if (!config.TB())
		{
			return false;
		}
		if (timers.getTimerEnd(actor, TimerType.TELEBLOCK) <= currentTick)
		{
			return false;
		}
		long finishedAt = timers.getTimerEnd(actor, TimerType.TELEBLOCK);

		String text = processTickCounter(finishedAt);
		Point poi = actor.getCanvasTextLocation(g, text, 0);
		int xpoi = poi.getX() + 20;
		int ypoi = poi.getY();
		Point FixedPoint = new Point(xpoi, ypoi);

		if (config.noImage())
		{
			if (timers.getTimerEnd(actor, TimerType.FREEZE) <= currentTick)
			{
				renderTextLocation(g, text, config.textSize(), config.fontStyle().getFont(), Color.CYAN, poi);
			}
			if (timers.getTimerEnd(actor, TimerType.FREEZE) >= currentTick)
			{
				renderTextLocation(g, " | " + text, config.textSize(), config.fontStyle().getFont(), Color.CYAN, FixedPoint);
			}
			if (timers.getTimerEnd(actor, TimerType.VENG) >= currentTick)
			{
				renderTextLocation(g, " | " + text, config.textSize(), config.fontStyle().getFont(), Color.CYAN, FixedPoint);
			}
		}
		else
		{
			renderActorText(g, actor, text, overlaysDrawn, TB_IMAGE);
		}
		return true;
	}

	private boolean drawVengOverlay(Graphics2D g, Actor actor, int overlaysDrawn)
	{
		long currentTick = System.currentTimeMillis();
		if (!config.Veng())
		{
			return false;
		}
		if (timers.getTimerEnd(actor, TimerType.VENG) <= currentTick)
		{
			return false;
		}
		long finishedAt = timers.getTimerEnd(actor, TimerType.VENG);

		String text = processTickCounter(finishedAt);
		Point poi = actor.getCanvasTextLocation(g, text, 0);
		int xpoi = poi.getX() - 20;
		int ypoi = poi.getY();
		Point FixedPoint = new Point(xpoi, ypoi);
		if (config.noImage())
		{
			if (timers.getTimerEnd(actor, TimerType.FREEZE) <= currentTick)
			{
				renderTextLocation(g, text, config.textSize(), config.fontStyle().getFont(), Color.RED, poi);
			}
			if (timers.getTimerEnd(actor, TimerType.FREEZE) >= currentTick)
			{
				renderTextLocation(g, text + " | ", config.textSize(), config.fontStyle().getFont(), Color.RED, FixedPoint);
			}
			if (timers.getTimerEnd(actor, TimerType.TELEBLOCK) >= currentTick)
			{
				renderTextLocation(g, text + " | ", config.textSize(), config.fontStyle().getFont(), Color.RED, FixedPoint);
			}
		}
		else
		{
			renderActorText(g, actor, text, overlaysDrawn, VENG_IMAGE);
		}
		if (actor.getSpotAnimation() == GraphicID.VENGEANCE || actor.getSpotAnimation() == GraphicID.VENGEANCE_OTHER)
		{

			g.setColor(RED);
			Polygon poly = actor.getCanvasTilePoly();
			if (poly != null)
			{
				OverlayUtil.renderPolygon(g, poly, RED);
			}
			OverlayUtil.renderTextLocation(g, new Point((int) poly.getBounds2D().getCenterX(),
				(int) poly.getBounds2D().getCenterY()), actor.getName(), RED);
		}
		return true;
	}

	private void renderActorText(Graphics2D g, Actor actor, String text, int overlaysDrawn, BufferedImage image)
	{
		int yOffset = (overlaysDrawn * 18);
		g.setFont(timerFont);
		g.setColor(WHITE);
		int xOffset = config.offset();
		renderActorTextAndImage(g, actor, text, Color.WHITE, image, yOffset,
			xOffset);
	}

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
				canvasPoint.getX(),
				canvasPoint.getY());
			final Point canvasCenterPoint_shadow = new Point(
				canvasPoint.getX() + 1,
				canvasPoint.getY() + 1);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	public void renderImageLocation(Graphics2D graphics, Point imgLoc, BufferedImage image)
	{
		int x = imgLoc.getX();
		int y = imgLoc.getY();

		graphics.drawImage(image, x, y, null);
	}

	public void renderActorTextAndImage(Graphics2D graphics, Actor actor, String text, Color color,
										BufferedImage image, int yOffset, int xOffset)
	{
		Point textLocation = new Point(actor.getCanvasImageLocation(image, 0).getX() + xOffset,
			actor.getCanvasImageLocation(image, 0).getY() + yOffset);

		renderImageLocation(graphics, textLocation, image);
		xOffset = image.getWidth() + 1;
		yOffset = (image.getHeight() - (int) graphics.getFontMetrics().getStringBounds(text, graphics).getHeight());
		textLocation = new Point(textLocation.getX() + xOffset, textLocation.getY() + image.getHeight() - yOffset);
		net.runelite.client.ui.overlay.OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
	}

	private String processTickCounter(long finishedAt)
	{
		long currentTick = System.currentTimeMillis();
		long tickDifference = finishedAt - currentTick;
		long seconds = tickDifference / 1000;
		seconds++;
		int minutes = (int) (seconds / 60);
		seconds = seconds % 60;
		String text = seconds > 9 ? seconds + "" : "0" + seconds;
		if (minutes > 0)
		{
			text = minutes + ":" + text;
		}
		return text + "";
	}
}
