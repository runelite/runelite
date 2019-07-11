/*
 * Copyright (c) 2019, Ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.ticktimers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class TimersOverlay extends Overlay
{
	private final TickTimersPlugin plugin;
	private final Client client;

	@Inject
	TimersOverlay(final TickTimersPlugin plugin, final Client client)
	{
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (NPCContainer npc : plugin.getNpcContainer())
		{
			if (npc.getNpc() == null)
			{
				continue;
			}

			int ticksLeft = npc.getTicksUntilAttack();
			final List<WorldPoint> hitSquares = OverlayUtil.getHitSquares(npc.getNpc().getWorldLocation(), npc.getNpcSize(), 1, false);
			final NPCContainer.AttackStyle attackStyle = npc.getAttackStyle();

			if (plugin.isShowHitSquares() && attackStyle.getName().equals("Melee"))
			{
				for (WorldPoint p : hitSquares)
				{
					OverlayUtil.drawTiles(graphics, client, p, client.getLocalPlayer().getWorldLocation(), attackStyle.getColor(), 0, 0, 50);
				}
			}

			if (ticksLeft <= 0)
			{
				continue;
			}

			final String ticksLeftStr = String.valueOf(ticksLeft);
			final int font = plugin.getFontStyle().getFont();
			final boolean shadows = plugin.isShadows();
			Color color = (ticksLeft <= 1 ? Color.WHITE : attackStyle.getColor());

			if (!plugin.isChangeTickColor())
			{
				color = attackStyle.getColor();
			}

			final Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, Integer.toString(ticksLeft), 0);

			OverlayUtil.renderTextLocation(graphics, ticksLeftStr, plugin.getTextSize(), font, color, canvasPoint, shadows, 0);

			if (plugin.isShowPrayerWidgetHelper() && attackStyle.getPrayer() != null)
			{
				Rectangle bounds = OverlayUtil.renderPrayerOverlay(graphics, client, attackStyle.getPrayer(), color);

				if (bounds != null)
				{
					renderTextLocation(graphics, ticksLeftStr, 16, plugin.getFontStyle().getFont(), color, centerPoint(bounds), shadows);
				}
			}
		}
		return null;
	}

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint, boolean shadows)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
				canvasPoint.getX() - 3,
				canvasPoint.getY() + 6);
			final Point canvasCenterPoint_shadow = new Point(
				canvasPoint.getX() - 2,
				canvasPoint.getY() + 7);
			if (shadows)
			{
				OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			}
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	private Point centerPoint(Rectangle rect)
	{
		int x = (int) (rect.getX() + rect.getWidth() / 2);
		int y = (int) (rect.getY() + rect.getHeight() / 2);
		return new Point(x, y);
	}
}
