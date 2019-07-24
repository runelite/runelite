/*
 *  Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 *  Copyright (c) 2017, Adam <Adam@sigterm.info>
 *  Copyright (c) 2019, Yani <yani@xenokore.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.pestcontrol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Slf4j
@Singleton
public class WidgetOverlay extends Overlay
{
	private final Client client;

	private final PestControlPlugin plugin;

	@Inject
	public WidgetOverlay(final Client client, final PestControlPlugin plugin)
	{
		this.plugin = plugin;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	Integer getPortalHitpoints(PortalColor color)
	{
		if (plugin.getGame() == null)
		{
			return null;
		}

		WidgetInfo healthWidgetInfo = null;

		switch (color)
		{
			case RED:
			{
				healthWidgetInfo = WidgetPortal.RED.getHitpoints();
				break;
			}
			case BLUE:
			{
				healthWidgetInfo = WidgetPortal.BLUE.getHitpoints();
				break;
			}
			case PURPLE:
			{
				healthWidgetInfo = WidgetPortal.PURPLE.getHitpoints();
				break;
			}
			case YELLOW:
			{
				healthWidgetInfo = WidgetPortal.YELLOW.getHitpoints();
				break;
			}
		}

		if (healthWidgetInfo == null)
		{
			return null;
		}

		Widget healthWidget = client.getWidget(healthWidgetInfo);

		if (healthWidget == null)
		{
			return null;
		}

		return Integer.parseInt(healthWidget.getText().trim());
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getGame() == null)
		{
			return null;
		}

		for (Portal portal : plugin.getGame().getNextPortals())
		{
			renderWidgetOverlay(graphics, portal, "NEXT", Color.ORANGE);
		}

		for (Portal portal : plugin.getGame().getActivePortals())
		{
			renderWidgetOverlay(graphics, portal, "ATT", Color.RED);
		}

		renderProgressWidget(graphics);

		return null;
	}

	private void renderWidgetOverlay(Graphics2D graphics, Portal portal, String text, Color color)
	{
		Widget shield = client.getWidget(portal.getWidget().getShield());
		Widget icon = client.getWidget(portal.getWidget().getIcon());
		Widget hp = client.getWidget(portal.getWidget().getHitpoints());

		Widget bar = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_BAR).getChild(0);

		Rectangle2D barBounds = bar.getBounds().getBounds2D();

		// create one rectangle from two different widget bounds
		Rectangle2D bounds = union(shield.getBounds().getBounds2D(), icon.getBounds().getBounds2D());
		bounds = union(bounds, hp.getBounds().getBounds2D());

		graphics.setColor(color);
		graphics.draw(new Rectangle2D.Double(bounds.getX(), bounds.getY() - 2, bounds.getWidth(), bounds.getHeight() - 3));

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);
		int x = (int) (bounds.getX() + (bounds.getWidth() / 2) - (textBounds.getWidth() / 2));
		int y = (int) (bounds.getY() + bounds.getHeight() + textBounds.getHeight() + barBounds.getHeight());

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 5);
		graphics.setColor(color);
		graphics.drawString(text, x, y + 4);
	}

	private void renderProgressWidget(Graphics2D graphics)
	{
		String text;
		int percentage;

		Widget bar = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_BAR).getChild(0);
		Rectangle2D bounds = bar.getBounds().getBounds2D();

		Widget prgs = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_PROGRESS).getChild(0);

		// At 0% the inner widget changes and your progress will not increase anymore
		if ((int) (prgs.getBounds().getX()) - bounds.getX() != 2)
		{
			percentage = 0;
			text = "FAILED";
		}
		else
		{
			percentage = (int) ((prgs.getBounds().getWidth() / bounds.getWidth()) * 100);
			text = percentage + "%";
		}

		Color color = Color.GREEN;
		if (percentage < 25)
		{
			color = Color.RED;
		}

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);
		int x = (int) (bounds.getX() - textBounds.getWidth() - 4);
		int y = (int) (bounds.getY() + fm.getHeight() - 2);

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);
		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}

	private static Rectangle2D union(Rectangle2D src1, Rectangle2D src2)
	{
		double x1 = Math.min(src1.getMinX(), src2.getMinX());
		double y1 = Math.min(src1.getMinY(), src2.getMinY());
		double x2 = Math.max(src1.getMaxX(), src2.getMaxX());
		double y2 = Math.max(src1.getMaxY(), src2.getMaxY());

		Rectangle2D result = new Rectangle2D.Double();
		result.setFrameFromDiagonal(x1, y1, x2, y2);

		return result;
	}
}
