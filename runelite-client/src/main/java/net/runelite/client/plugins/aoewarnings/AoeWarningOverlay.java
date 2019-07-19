/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 *
 * Modified by farhan1666
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
package net.runelite.client.plugins.aoewarnings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import static net.runelite.client.util.ColorUtil.setAlphaComponent;

@Singleton
public class AoeWarningOverlay extends Overlay
{
	private static final int FILL_START_ALPHA = 25;
	private static final int OUTLINE_START_ALPHA = 255;

	private final Client client;
	private final AoeWarningPlugin plugin;

	@Inject
	public AoeWarningOverlay(final Client client, final AoeWarningPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		WorldPoint lp = client.getLocalPlayer().getWorldLocation();
		for (WorldPoint point : plugin.getLightningTrail())
		{
			OverlayUtil.drawTiles(graphics, client, point, lp, new Color(0, 150, 200), 2, 150, 50);
		}

		for (WorldPoint point : plugin.getAcidTrail())
		{
			OverlayUtil.drawTiles(graphics, client, point, lp, new Color(69, 241, 44), 2, 150, 50);
		}

		for (WorldPoint point : plugin.getCrystalSpike())
		{
			OverlayUtil.drawTiles(graphics, client, point, lp, new Color(255, 0, 84), 2, 150, 50);
		}

		for (WorldPoint point : plugin.getWintertodtSnowFall())
		{
			OverlayUtil.drawTiles(graphics, client, point, lp, new Color(255, 0, 84), 2, 150, 50);
		}

		Instant now = Instant.now();
		Set<ProjectileContainer> projectiles = plugin.getProjectiles();
		projectiles.forEach(proj ->
		{
			if (proj.getTargetPoint() == null)
			{
				return;
			}

			Color color;

			if (now.isAfter(proj.getStartTime().plus(Duration.ofMillis(proj.getLifetime()))))
			{
				return;
			}

			final Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, proj.getTargetPoint(), proj.getAoeProjectileInfo().getAoeSize());
			if (tilePoly == null)
			{
				return;
			}

			final double progress = (System.currentTimeMillis() - proj.getStartTime().toEpochMilli()) / (double) proj.getLifetime();

			final int tickProgress = proj.getFinalTick() - client.getTickCount();

			int fillAlpha, outlineAlpha;
			if (plugin.isConfigFadeEnabled())
			{
				fillAlpha = (int) ((1 - progress) * FILL_START_ALPHA);
				outlineAlpha = (int) ((1 - progress) * OUTLINE_START_ALPHA);
			}
			else
			{
				fillAlpha = FILL_START_ALPHA;
				outlineAlpha = OUTLINE_START_ALPHA;
			}
			if (tickProgress == 0)
			{
				color = Color.RED;
			}
			else
			{
				color = Color.WHITE;
			}

			if (fillAlpha < 0)
			{
				fillAlpha = 0;
			}
			if (outlineAlpha < 0)
			{
				outlineAlpha = 0;
			}

			if (fillAlpha > 255)
			{
				fillAlpha = 255;
			}
			if (outlineAlpha > 255)
			{
				outlineAlpha = 255;
			}

			if (plugin.isConfigOutlineEnabled())
			{
				graphics.setColor(new Color(setAlphaComponent(plugin.getOverlayColor().getRGB(), outlineAlpha), true));
				graphics.drawPolygon(tilePoly);
			}
			if (plugin.isTickTimers() && tickProgress >= 0)
			{
				OverlayUtil.renderTextLocation(graphics, Integer.toString(tickProgress), plugin.getTextSize(),
					plugin.getFontStyle(), color, centerPoint(tilePoly.getBounds()), plugin.isShadows(), 0);
			}

			graphics.setColor(new Color(setAlphaComponent(plugin.getOverlayColor().getRGB(), fillAlpha), true));
			graphics.fillPolygon(tilePoly);
		});
		projectiles.removeIf(proj -> now.isAfter(proj.getStartTime().plus(Duration.ofMillis(proj.getLifetime()))));
		return null;
	}

	private Point centerPoint(Rectangle rect)
	{
		int x = (int) (rect.getX() + rect.getWidth() / 2);
		int y = (int) (rect.getY() + rect.getHeight() / 2);
		return new Point(x, y);
	}
}