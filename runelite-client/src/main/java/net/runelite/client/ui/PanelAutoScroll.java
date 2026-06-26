/*
 * Copyright (c) 2024, RuneLite contributors
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
package net.runelite.client.ui;

import java.awt.AWTEvent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import net.runelite.client.config.RuneLiteConfig;

/**
 * Adds press-and-hold middle mouse button autoscroll to any Swing {@link JScrollPane} in the
 * client, mirroring the behaviour of web browsers and text editors. While the middle button is
 * held the view scrolls continuously, with the speed proportional to the distance the cursor is
 * dragged away from where the button was first pressed.
 */
@Singleton
public class PanelAutoScroll implements AWTEventListener
{
	private static final int TICK_MS = 15;
	private static final int DEAD_ZONE = 16;
	private static final double SPEED = 0.18;

	private static final int DIR_NEUTRAL = 0;
	private static final int DIR_UP = 1;
	private static final int DIR_DOWN = 2;
	private static final int DIR_LEFT = 3;
	private static final int DIR_RIGHT = 4;

	private static final Color DISC_OUTLINE = new Color(70, 70, 70);

	private final RuneLiteConfig config;
	private final Timer timer;
	private final Cursor[] cursors = new Cursor[5];

	private JScrollPane scrollPane;
	private Point origin;
	private Cursor previousCursor;
	private int direction;
	private double residualX;
	private double residualY;

	@Inject
	private PanelAutoScroll(RuneLiteConfig config)
	{
		this.config = config;
		this.timer = new Timer(TICK_MS, e -> tick());
		this.timer.setCoalesce(true);
	}

	public void register()
	{
		Toolkit.getDefaultToolkit().addAWTEventListener(this, AWTEvent.MOUSE_EVENT_MASK);
	}

	@Override
	public void eventDispatched(AWTEvent event)
	{
		if (!(event instanceof MouseEvent))
		{
			return;
		}

		final MouseEvent e = (MouseEvent) event;
		switch (e.getID())
		{
			case MouseEvent.MOUSE_PRESSED:
				if (e.getButton() == MouseEvent.BUTTON2)
				{
					if (scrollPane != null)
					{
						// A second middle press while active cancels the scroll
						stop();
						e.consume();
					}
					else if (config.panelMiddleClickAutoscroll())
					{
						start(e);
					}
				}
				else if (scrollPane != null)
				{
					stop();
				}
				break;
			case MouseEvent.MOUSE_RELEASED:
				if (scrollPane != null && e.getButton() == MouseEvent.BUTTON2)
				{
					stop();
					e.consume();
				}
				break;
			default:
				break;
		}
	}

	private void start(MouseEvent e)
	{
		final Component source = e.getComponent();
		final JScrollPane sp = source instanceof JScrollPane
			? (JScrollPane) source
			: (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, source);
		if (sp == null || !canScroll(sp))
		{
			return;
		}

		scrollPane = sp;
		origin = e.getLocationOnScreen();
		residualX = 0;
		residualY = 0;
		direction = DIR_NEUTRAL;
		previousCursor = sp.getCursor();
		sp.setCursor(cursor(DIR_NEUTRAL));
		timer.start();
		e.consume();
	}

	private void stop()
	{
		timer.stop();
		if (scrollPane != null)
		{
			scrollPane.setCursor(previousCursor);
		}
		scrollPane = null;
		origin = null;
		previousCursor = null;
	}

	private void tick()
	{
		if (scrollPane == null || !scrollPane.isShowing())
		{
			stop();
			return;
		}

		final PointerInfo pointerInfo = MouseInfo.getPointerInfo();
		if (pointerInfo == null)
		{
			return;
		}

		final Point p = pointerInfo.getLocation();
		final int rawY = p.y - origin.y;
		final int rawX = p.x - origin.x;
		residualY += scrollAmount(rawY);
		residualX += scrollAmount(rawX);

		final int dy = (int) residualY;
		final int dx = (int) residualX;
		residualY -= dy;
		residualX -= dx;

		if (dy != 0)
		{
			move(scrollPane.getVerticalScrollBar(), dy);
		}
		if (dx != 0)
		{
			move(scrollPane.getHorizontalScrollBar(), dx);
		}

		updateCursor(rawX, rawY);
	}

	private void updateCursor(int rawX, int rawY)
	{
		final boolean vertical = isVisible(scrollPane.getVerticalScrollBar());
		final boolean horizontal = isVisible(scrollPane.getHorizontalScrollBar());
		final int absX = Math.abs(rawX);
		final int absY = Math.abs(rawY);

		int dir = DIR_NEUTRAL;
		if (vertical && (!horizontal || absY >= absX) && absY >= DEAD_ZONE)
		{
			dir = rawY < 0 ? DIR_UP : DIR_DOWN;
		}
		else if (horizontal && absX >= DEAD_ZONE)
		{
			dir = rawX < 0 ? DIR_LEFT : DIR_RIGHT;
		}

		if (dir != direction)
		{
			direction = dir;
			scrollPane.setCursor(cursor(dir));
		}
	}

	static double scrollAmount(int distance)
	{
		if (distance > -DEAD_ZONE && distance < DEAD_ZONE)
		{
			return 0;
		}

		final int sign = distance < 0 ? -1 : 1;
		return sign * (Math.abs(distance) - DEAD_ZONE) * SPEED;
	}

	private static void move(JScrollBar bar, int delta)
	{
		if (bar == null || !bar.isVisible())
		{
			return;
		}

		final int value = bar.getValue() + delta;
		final int max = bar.getMaximum() - bar.getVisibleAmount();
		bar.setValue(Math.max(bar.getMinimum(), Math.min(max, value)));
	}

	private static boolean canScroll(JScrollPane sp)
	{
		return isVisible(sp.getVerticalScrollBar()) || isVisible(sp.getHorizontalScrollBar());
	}

	private static boolean isVisible(JScrollBar bar)
	{
		return bar != null && bar.isVisible();
	}

	private Cursor cursor(int dir)
	{
		Cursor c = cursors[dir];
		if (c == null)
		{
			c = buildCursor(dir);
			cursors[dir] = c;
		}
		return c;
	}

	private static Cursor buildCursor(int dir)
	{
		final Dimension best = Toolkit.getDefaultToolkit().getBestCursorSize(48, 48);
		final int w = best.width > 0 ? best.width : 32;
		final int h = best.height > 0 ? best.height : 32;
		final BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		final Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		paintBadge(g, dir, w / 2, h / 2, Math.min(w, h));
		g.dispose();
		return Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(w / 2, h / 2), "panelAutoScroll" + dir);
	}

	private static void paintBadge(Graphics2D g, int dir, int cx, int cy, int size)
	{
		final int tip = Math.round(size * 0.40f);
		final int base = Math.round(size * 0.20f);
		final int wing = Math.max(3, Math.round(size * 0.13f));
		final int dot = Math.max(2, Math.round(size * 0.07f));

		if (dir == DIR_UP || dir == DIR_DOWN)
		{
			// Scrolling: outlined black glyph showing the active direction, no disc
			g.setStroke(new BasicStroke(Math.max(2f, size * 0.06f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			drawOutlined(g, arrow(cx, cy, tip, base, wing, dir == DIR_UP));
			drawOutlined(g, new Ellipse2D.Float(cx - dot, cy - dot, dot * 2, dot * 2));
			return;
		}

		// Stationary: conventional white disc badge with both arrows
		final int radius = Math.max(10, Math.round(size * 0.46f));
		g.setColor(Color.WHITE);
		g.fillOval(cx - radius, cy - radius, radius * 2, radius * 2);
		g.setStroke(new BasicStroke(Math.max(1f, size * 0.03f)));
		g.setColor(DISC_OUTLINE);
		g.drawOval(cx - radius, cy - radius, radius * 2, radius * 2);

		g.setColor(Color.BLACK);
		g.fill(arrow(cx, cy, tip, base, wing, true));
		g.fill(arrow(cx, cy, tip, base, wing, false));
		g.fillOval(cx - dot, cy - dot, dot * 2, dot * 2);
	}

	private static void drawOutlined(Graphics2D g, Shape shape)
	{
		g.setColor(Color.WHITE);
		g.draw(shape);
		g.setColor(Color.BLACK);
		g.fill(shape);
	}

	private static Polygon arrow(int cx, int cy, int tip, int base, int wing, boolean up)
	{
		final int sign = up ? -1 : 1;
		final Polygon p = new Polygon();
		p.addPoint(cx, cy + sign * tip);
		p.addPoint(cx - wing, cy + sign * base);
		p.addPoint(cx + wing, cy + sign * base);
		return p;
	}
}
