/*
 *
 *  * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
 *  * All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  * 1. Redistributions of source code must retain the above copyright notice, this
 *  *    list of conditions and the following disclaimer.
 *  * 2. Redistributions in binary form must reproduce the above copyright notice,
 *  *    this list of conditions and the following disclaimer in the documentation
 *  *    and/or other materials provided with the distribution.
 *  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.zalcano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

/**
 * some ids
 * 9049 = zalcano npc id 8439 wakeup animation 8437 mineable stage
 * 1727 = rocks falling graphics object id
 * 1728 = red projectile flying into rock
 * <p>
 * 36192 + anim 8448 = glowing rock
 * <p>
 * 36199 red circle
 * 36200 blue circle
 * <p>
 * golem id = 9051
 * <p>
 * 23905, 23906, 23907
 */
@Slf4j
public class ZalcanoOverlay extends Overlay
{

	private final ZalcanoPlugin plugin;
	private final ZalcanoConfig config;
	private final ZalcanoUtil util;
	private final Client client;


	@Inject
	ZalcanoOverlay(final ZalcanoPlugin plugin, final ZalcanoConfig config, final ZalcanoUtil util, final Client client)
	{
		super(plugin);
		this.plugin = plugin;
		this.config = config;
		this.util = util;
		this.client = client;

		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!util.isInZalcanoRegion())
		{
			return null;
		}

		if (config.showAoeForRockfall())
		{
			renderBadTiles(graphics);
		}
		if (config.showAoeForRedSymbols())
		{
			renderRedSymbols(graphics);
		}
		if (config.highlightMiningSpot())
		{
			renderRockToMine(graphics);
		}
		if (config.highlightGolem())
		{
			renderGolem(graphics);
		}
		if (config.highlightZalcanoHull())
		{
			renderZalcano(graphics);
		}

		//has their own configs within this method
		renderZalcanoAnimations(graphics);

		return null;
	}

	private void renderBadTiles(Graphics2D graphics)
	{
		List<GraphicsObject> rockFall = util.getRockfall();

		if (rockFall != null)
		{
			for (GraphicsObject graphicsObject : rockFall)
			{
				WorldPoint worldPoint = WorldPoint.fromLocal(client, graphicsObject.getLocation());
				OverlayUtil.drawTiles(graphics, client, worldPoint, client.getLocalPlayer().getWorldLocation(), Color.RED, 2, 150, 50);
			}
		}
	}

	private void renderRedSymbols(Graphics2D graphics)
	{
		List<GameObject> symbolsToRender = util.getRedSymbols();

		if (symbolsToRender != null)
		{
			for (GameObject gameObject : symbolsToRender)
			{
				final LocalPoint loc = gameObject.getLocalLocation();
				final Polygon poly = Perspective.getCanvasTileAreaPoly(client, loc, 3);
				if (poly != null)
				{
					OverlayUtil.renderPolygon(graphics, poly, new Color(249, 47, 30));
				}
			}
		}
	}

	private void renderRockToMine(Graphics2D graphics)
	{
		GameObject glowingRock = util.getGlowingRock();

		if (glowingRock != null)
		{
			final Polygon poly = Perspective.getCanvasTileAreaPoly(client, glowingRock.getLocalLocation(), !util.projectileExists() ? 2 : 4);

			if (poly != null)
			{
				final Color green = new Color(140, 255, 60);
				OverlayUtil.renderPolygon(graphics, poly, !util.projectileExists() ? green : Color.RED);
				OverlayUtil.renderTextLocation(graphics, glowingRock.getCanvasLocation(), !util.projectileExists() ? util.mine : util.warning, !util.projectileExists() ? green : Color.RED);
			}
		}
	}

	private void renderGolem(Graphics2D graphics)
	{
		if (plugin.getGolem() != null)
		{
			Shape hull = plugin.getGolem().getConvexHull();
			if (hull != null)
			{
				OverlayUtil.renderPolygon(graphics, hull, new Color(206, 41, 231));
			}

		}
	}

	private void renderZalcano(Graphics2D graphics)
	{
		if (plugin.getZalcano() != null)
		{
			Shape hull = plugin.getZalcano().getConvexHull();
			if (hull != null)
			{
				OverlayUtil.renderPolygon(graphics, hull, config.zalcanoHullColor());
			}

		}
	}

	private void renderZalcanoAnimations(Graphics2D graphics)
	{
		if (plugin.getZalcano() != null)
		{
			switch (plugin.getZalcano().getAnimation())
			{
				case AnimationID.ZALCANO_KNOCKED_DOWN:
					if (config.showAoeZalcanoMineable())
					{
						renderZalcanoMineable(graphics);
					}
					break;
				case AnimationID.ZALCANO_WAKEUP:
					if (config.showAoeZalcanoWakeup())
					{
						renderZalcanoWakeup(graphics);
					}
					break;
			}
		}
	}

	private void renderZalcanoMineable(Graphics2D graphics)
	{
		renderZalcanoAOE(graphics, 4, util.mine, Color.GREEN);
	}

	private void renderZalcanoWakeup(Graphics2D graphics)
	{
		renderZalcanoAOE(graphics, 6, ZalcanoUtil.warning, Color.RED);
	}

	private void renderZalcanoAOE(Graphics2D graphics, int polySize, String text, Color color)
	{
		Polygon poly = Perspective.getCanvasTileAreaPoly(client, plugin.getZalcano().getLocalLocation(), polySize);
		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, color);
			OverlayUtil.renderTextLocation(graphics, plugin.getZalcano().getCanvasTextLocation(graphics, text, plugin.getZalcano().getLogicalHeight() / 2), text, color);
		}
	}


}
