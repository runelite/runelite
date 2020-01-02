/*
 * Copyright (c) 2018, https://openosrs.com Dutta64
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
package net.runelite.client.plugins.lizardmanshaman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import static net.runelite.client.plugins.lizardmanshaman.LizardmanShamanConfig.SpawnOverlayConfig;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Slf4j
@Singleton
class LizardmanShamanOverlay extends Overlay
{
	private final Client client;
	private final LizardmanShamanPlugin plugin;

	@Inject
	private LizardmanShamanOverlay(final Client client, final LizardmanShamanPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getSpawnOverlayConfig().equals(SpawnOverlayConfig.DISABLED))
		{
			renderValidMovement(graphics);
		}

		return null;
	}

	/**
	 * Adapted from net.runelite.client.plugins.devtools.SceneOverlay
	 *
	 * @param graphics
	 */
	private void renderValidMovement(Graphics2D graphics)
	{
		for (NPC npc : client.getNpcs())
		{
			if (!isSpawnNpc(npc))
			{
				continue;
			}

			for (int dx = -1; dx <= 1; dx++)
			{
				for (int dy = -1; dy <= 1; dy++)
				{
					if (dx == 0 && dy == 0)
					{
						continue;
					}

					renderTileIfValidForMovement(graphics, npc, dx, dy);
				}
			}
		}
	}

	/**
	 * Adapted from net.runelite.client.plugins.devtools.SceneOverlay
	 *
	 * @param graphics
	 * @param actor
	 * @param dx
	 * @param dy
	 */
	private void renderTileIfValidForMovement(Graphics2D graphics, Actor actor, int dx, int dy)
	{
		WorldArea area = actor.getWorldArea();

		if (area == null)
		{
			return;
		}

		if (area.canTravelInDirection(client, dx, dy))
		{
			LocalPoint lp = actor.getLocalLocation();

			if (lp == null)
			{
				return;
			}

			lp = new LocalPoint(
				lp.getX() + dx * Perspective.LOCAL_TILE_SIZE + dx * Perspective.LOCAL_TILE_SIZE * (area.getWidth() - 1) / 2,
				lp.getY() + dy * Perspective.LOCAL_TILE_SIZE + dy * Perspective.LOCAL_TILE_SIZE * (area.getHeight() - 1) / 2);

			Polygon poly = Perspective.getCanvasTilePoly(client, lp);

			if (poly == null)
			{
				return;
			}

			if (isExplodingAnimation(actor))
			{
				renderPolygon(graphics, poly, 1, plugin.getExplosionBorderColor(), plugin.getExplosionFillColor());
			}
			else if (plugin.getSpawnOverlayConfig().equals(SpawnOverlayConfig.ALWAYS))
			{
				renderPolygon(graphics, poly, 1, plugin.getSpawnWalkableBorderColor(), plugin.getSpawnWalkableFillColor());
			}
		}
	}

	/**
	 * Adapted from net.runelite.client.ui.overlay.OverlayUtil
	 *
	 * @param graphics
	 * @param poly
	 * @param strokeWidth
	 * @param strokeColor
	 * @param fillColor
	 */
	private static void renderPolygon(Graphics2D graphics, Shape poly, int strokeWidth, Color strokeColor, Color fillColor)
	{
		graphics.setColor(strokeColor);
		final Stroke originalStroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(strokeWidth));
		graphics.draw(poly);
		graphics.setColor(fillColor);
		graphics.fill(poly);
		graphics.setStroke(originalStroke);
	}

	/**
	 * Returns true if the Actor's animation is exploding.
	 *
	 * @param actor an Actor object.
	 * @return true if the Actor is exploding, else returns false.
	 */
	private static boolean isExplodingAnimation(Actor actor)
	{
		return actor.getAnimation() == AnimationID.LIZARDMAN_SHAMAN_SPAWN_EXPLOSION;
	}

	/**
	 * Returns true if the NPC is a Lizardman Shaman Spawn.
	 *
	 * @param npc an NPC object.
	 * @return true if the NPC is a lizardman shaman spawn, else returns false.
	 */
	private static boolean isSpawnNpc(NPC npc)
	{
		final int NPC_ID_SPAWN = 6768;

		return npc.getId() == NPC_ID_SPAWN;
	}
}
