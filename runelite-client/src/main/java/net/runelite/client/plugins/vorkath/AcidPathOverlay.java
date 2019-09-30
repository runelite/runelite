/*
 * Copyright (c) 2018, https://openosrs.com
 * Copyright (c) 2019, Infinitay <https://github.com/Infinitay>
 *
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
package net.runelite.client.plugins.vorkath;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class AcidPathOverlay extends Overlay
{
	private static final Color ACID_SPOTS_COLOR = Color.GREEN;
	private static final Color ACID_FREE_PATH_COLOR = Color.PINK;
	private static final Color WOOXWALK_ATTACK_SPOT_COLOR = Color.YELLOW;
	private static final Color WOOXWALK_OUT_OF_REACH_SPOT_COLOR = Color.RED;
	private static final int BAR_INDICATOR_SPACER = 5;

	private final Client client;
	private final VorkathPlugin plugin;

	@Inject
	public AcidPathOverlay(final Client client, final VorkathPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);

		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getVorkath() == null || plugin.getVorkath().getVorkath().getLocalLocation() == null)
		{
			return null;
		}

		if (plugin.isIndicateAcidPools() && plugin.getAcidSpots() != null
				&& !plugin.getAcidSpots().isEmpty())
		{
			for (WorldPoint acidWorldPoint : plugin.getAcidSpots())
			{
				LocalPoint acidLocalPoint = LocalPoint.fromWorld(client, acidWorldPoint);
				if (acidLocalPoint == null)
				{
					continue;
				}
				OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
						acidLocalPoint), ACID_SPOTS_COLOR);
			}
		}

		if (plugin.isIndicateAcidFreePath() && plugin.getAcidFreePath() != null
				&& !plugin.getAcidFreePath().isEmpty())
		{
			for (WorldPoint acidFreeWorldPoint : plugin.getAcidFreePath())
			{
				LocalPoint acidFreeLocalPoint = LocalPoint.fromWorld(client, acidFreeWorldPoint);
				if (acidFreeLocalPoint == null)
				{
					continue;
				}

				OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
						acidFreeLocalPoint), ACID_FREE_PATH_COLOR);
			}
		}

		if (plugin.isIndicateWooxWalkPath() && plugin.getWooxWalkPath()[0] != null
				&& plugin.getWooxWalkPath()[1] != null)
		{
			LocalPoint attackLocalPoint = LocalPoint.fromWorld(client, plugin.getWooxWalkPath()[0]);
			LocalPoint outOfReachLocalPoint = LocalPoint.fromWorld(client, plugin.getWooxWalkPath()[1]);

			if (attackLocalPoint != null && outOfReachLocalPoint != null)
			{
				OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
					attackLocalPoint), Color.YELLOW);
				OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
					outOfReachLocalPoint), Color.RED);

				if (plugin.isIndicateWooxWalkTick() && plugin.getWooxWalkBar() != null
					&& plugin.getWooxWalkTimer() != -1)
				{
					int[] xpointsAttack = {
							(int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2.0 + 1),
							(int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth()),
							(int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth()),
							(int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2 + 1)
					};
					int[] xpointsOutOfReach = {
							(int) plugin.getWooxWalkBar().getX(),
							(int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2.0),
							(int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2.0),
							(int) plugin.getWooxWalkBar().getX()
					};
					int[] ypointsBoth = {
							(int) plugin.getWooxWalkBar().getY(),
							(int) plugin.getWooxWalkBar().getY(),
							(int) (plugin.getWooxWalkBar().getY() + plugin.getWooxWalkBar().getHeight()),
							(int) (plugin.getWooxWalkBar().getY() + plugin.getWooxWalkBar().getHeight())
					};
					Polygon wooxWalkAttack = new Polygon(xpointsAttack, ypointsBoth, 4);
					Polygon wooxWalkOutOfReach = new Polygon(xpointsOutOfReach, ypointsBoth, 4);
					OverlayUtil.renderPolygon(graphics, wooxWalkAttack, WOOXWALK_ATTACK_SPOT_COLOR);
					OverlayUtil.renderPolygon(graphics, wooxWalkOutOfReach, WOOXWALK_OUT_OF_REACH_SPOT_COLOR);

					long timeLeft = (System.currentTimeMillis() - plugin.getWooxWalkTimer()) % 1200;
					double timeScale;
					if (timeLeft <= 600)
					{
						timeScale = 1 - timeLeft / 600.0;
					}
					else
					{
						timeLeft -= 600;
						timeScale = timeLeft / 600.0;
					}
					int progress = (int) Math.round(plugin.getWooxWalkBar().getWidth() * timeScale);

					int[] xpointsIndicator = {
							(int) (plugin.getWooxWalkBar().getX() - plugin.getWooxWalkBar().getHeight() / 2 + progress),
							(int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getHeight() / 2 + progress),
							(int) plugin.getWooxWalkBar().getX() + progress
					};
					int[] ypointsIndicator = {
							(int) (plugin.getWooxWalkBar().getY() - plugin.getWooxWalkBar().getHeight() - BAR_INDICATOR_SPACER),
							(int) (plugin.getWooxWalkBar().getY() - plugin.getWooxWalkBar().getHeight() - BAR_INDICATOR_SPACER),
							(int) (plugin.getWooxWalkBar().getY() - BAR_INDICATOR_SPACER)
					};
					Polygon indicator = new Polygon(xpointsIndicator, ypointsIndicator, 3);
					OverlayUtil.renderPolygon(graphics, indicator, Color.WHITE);
				}
			}
		}

		return null;
	}
}
