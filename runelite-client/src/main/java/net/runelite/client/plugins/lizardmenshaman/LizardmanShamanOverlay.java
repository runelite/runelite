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
package net.runelite.client.plugins.lizardmenshaman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.lizardmenshaman.LizardmanShamanConfig.SpawnOverlayConfig;
import static net.runelite.client.plugins.lizardmenshaman.LizardmanShamanPlugin.LIZARDMAN_SHAMAN_SPAWN_EXPLOSION;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Slf4j
@Singleton
class LizardmanShamanOverlay extends Overlay
{
	private final Client client;
	private final LizardmanShamanConfig config;

	//private static final Set<Integer> CANYON_REGION_IDS = Set.of(5689, 5690);
	public static final int CANYON1 = 5689;
	private static final int CANYON2 = 5690;

	@Inject
	private LizardmanShamanOverlay(final Client client, final LizardmanShamanConfig config)
	{
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showSpawnOverlay().equals(SpawnOverlayConfig.DISABLED))
		{
			final boolean inCanyon = isPlayerInCanyonRegion();

			for (NPC npc : client.getNpcs())
			{
				if (npc.getId() != NpcID.SPAWN_6768)
				{
					continue;
				}

				renderExplosionArea(graphics, npc, inCanyon);
			}
		}

		return null;
	}

	private void renderExplosionArea(Graphics2D graphics, Actor actor, boolean inCanyon)
	{
		WorldArea worldArea = actor.getWorldArea();

		if (worldArea == null)
		{
			return;
		}

		LocalPoint localPoint = actor.getLocalLocation();

		if (localPoint == null)
		{
			return;
		}

		final int explosionRadius = inCanyon ? 2 : 1;

		for (int x = -explosionRadius; x <= explosionRadius; x++)
		{
			for (int y = -explosionRadius; y <= explosionRadius; y++)
			{
				if (!worldArea.canTravelInDirection(client, x, y))
				{
					continue;
				}

				LocalPoint lp = new LocalPoint(
					localPoint.getX() + x * Perspective.LOCAL_TILE_SIZE + x * Perspective.LOCAL_TILE_SIZE * (worldArea.getWidth() - 1) / 2,
					localPoint.getY() + y * Perspective.LOCAL_TILE_SIZE + y * Perspective.LOCAL_TILE_SIZE * (worldArea.getHeight() - 1) / 2);

				Polygon polygon = Perspective.getCanvasTilePoly(client, lp);

				if (polygon == null)
				{
					return;
				}

				if (actor.getAnimation() == LIZARDMAN_SHAMAN_SPAWN_EXPLOSION)
				{
					renderPolygon(graphics, polygon, 1, config.explosionBorderColor(), config.explosionFillColor());
				}
				else if (config.showSpawnOverlay().equals(SpawnOverlayConfig.ALWAYS))
				{
					renderPolygon(graphics, polygon, 1, config.spawnWalkableBorderColor(), config.spawnWalkableFillColor());
				}
			}
		}
	}

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

	private boolean isPlayerInCanyonRegion()
	{
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return false;
		}

		WorldPoint worldPoint = player.getWorldLocation();

		if (worldPoint == null)
		{
			return false;
		}

		return CANYON1 == (worldPoint.getRegionID()) || CANYON2 == (worldPoint.getRegionID());
	}
}
