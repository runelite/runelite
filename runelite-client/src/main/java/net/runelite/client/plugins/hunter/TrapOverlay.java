/*
 * Copyright (c) 2017, Robin Weymans <Robin.weymans@gmail.com>
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
package net.runelite.client.plugins.hunter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

/**
 * Represents the overlay that shows timers on traps that are placed by the
 * player.
 */
public class TrapOverlay extends Overlay
{
	/**
	 * Size of the trap timer.
	 */
	private static final int TIMER_SIZE = 25;

	/**
	 * Width of the border around the trap timer.
	 */
	private static final int TIMER_BORDER_WIDTH = 1;

	/**
	 * The timer is low when only 25% is left.
	 */
	private static final double TIMER_LOW = 0.25; // When the timer is under a quarter left, if turns red.

	private final Client client;
	private final HunterPlugin plugin;
	private final HunterConfig config;

	private Color colorOpen, colorOpenBorder;
	private Color colorEmpty, colorEmptyBorder;
	private Color colorFull, colorFullBorder;
	private Color colorTrans, colorTransBorder;

	@Inject
	TrapOverlay(@Nullable Client client, HunterPlugin plugin, HunterConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (config.enabled())
		{
			drawTraps(graphics);
		}
		return null;
	}

	/**
	 * Updates the timer colors.
	 */
	public void updateConfig()
	{
		colorEmptyBorder = config.getEmptyTrapColor();
		colorEmpty = new Color(colorEmptyBorder.getRed(), colorEmptyBorder.getGreen(), colorEmptyBorder.getBlue(), 100);
		colorFullBorder = config.getFullTrapColor();
		colorFull = new Color(colorFullBorder.getRed(), colorFullBorder.getGreen(), colorFullBorder.getBlue(), 100);
		colorOpenBorder = config.getOpenTrapColor();
		colorOpen = new Color(colorOpenBorder.getRed(), colorOpenBorder.getGreen(), colorOpenBorder.getBlue(), 100);
		colorTransBorder = config.getTransTrapColor();
		colorTrans = new Color(colorTransBorder.getRed(), colorTransBorder.getGreen(), colorTransBorder.getBlue(), 100);
	}

	/**
	 * Iterates over all the traps that were placed by the local player, and
	 * draws a circle or a timer on the trap, depending on the trap state.
	 *
	 * @param graphics
	 */
	private void drawTraps(Graphics2D graphics)
	{
		Widget viewport = client.getViewportWidget();
		for (HunterTrap trap : plugin.getTraps())
		{
			if (viewport != null && viewport.contains(trap.getGameObject().getCanvasLocation()))
			{
				switch (trap.getState())
				{
					case OPEN:
						drawTimerOnTrap(graphics, trap, colorOpen, colorOpenBorder, colorEmpty, colorOpenBorder);
						break;
					case EMPTY:
						drawTimerOnTrap(graphics, trap, colorEmpty, colorEmptyBorder, colorEmpty, colorEmptyBorder);
						break;
					case FULL:
						drawCircleOnTrap(graphics, trap, colorFull, colorFullBorder);
						break;
					case TRANSITION:
						drawCircleOnTrap(graphics, trap, colorTrans, colorTransBorder);
						break;
				}
			}
		}
	}

	/**
	 * Draws a timer on a given trap.
	 *
	 * @param graphics
	 * @param trap The trap on which the timer needs to be drawn
	 * @param fill The fill color of the timer
	 * @param border The border color of the timer
	 * @param fillTimeLow The fill color of the timer when it is low
	 * @param borderTimeLow The border color of the timer when it is low
	 */
	private void drawTimerOnTrap(Graphics2D graphics, HunterTrap trap, Color fill, Color border, Color fillTimeLow, Color borderTimeLow)
	{
		net.runelite.api.Point loc = trap.getGameObject().getCanvasLocation();

		//Construct the arc
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setAngleStart(90);
		double timeLeft = 1 - trap.getTrapTimeRelative();
		arc.setAngleExtent(timeLeft * 360);
		arc.setFrame(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);

		//Draw the inside of the arc
		graphics.setColor(timeLeft > TIMER_LOW ? fill : fillTimeLow);
		graphics.fill(arc);

		//Draw the outlines of the arc
		graphics.setStroke(new BasicStroke(TIMER_BORDER_WIDTH));
		graphics.setColor(timeLeft > TIMER_LOW ? border : borderTimeLow);
		graphics.drawOval(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);
	}

	/**
	 * Draws a timer on a given trap.
	 *
	 * @param graphics
	 * @param trap The trap on which the timer needs to be drawn
	 * @param fill The fill color of the timer
	 * @param border The border color of the timer
	 */
	private void drawCircleOnTrap(Graphics2D graphics, HunterTrap trap, Color fill, Color border)
	{
		net.runelite.api.Point loc = trap.getGameObject().getCanvasLocation();

		//Draw the inside of the arc
		graphics.setColor(fill);
		graphics.fillOval(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);

		//Draw the border of the cirlce
		graphics.setColor(border);
		graphics.setStroke(new BasicStroke(TIMER_BORDER_WIDTH));
		graphics.drawOval(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);
	}
}
