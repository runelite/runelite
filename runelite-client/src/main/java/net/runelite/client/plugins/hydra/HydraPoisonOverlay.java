/*
 * Copyright (c) 2018, https://openosrs.com
 * Copyright (c) 2020, Dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.hydra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import static net.runelite.api.Perspective.getCanvasTileAreaPoly;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Singleton
public class HydraPoisonOverlay extends Overlay
{
	private static final Color poisonBorder = new Color(255, 0, 0, 100);;
	private static final Color poisonFill = new Color(255, 0, 0, 50);;

	private final Client client;

	@Setter(AccessLevel.PACKAGE)
	private Map<LocalPoint, Projectile> poisonProjectiles;

	@Inject
	public HydraPoisonOverlay(final Client client)
	{
		this.client = client;
		this.poisonProjectiles = new HashMap<>();
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		if (!poisonProjectiles.isEmpty())
		{
			drawPoisonArea(graphics, poisonProjectiles);
		}

		return null;
	}

	/**
	 * See net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraSceneOverlay
	 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
	 *
	 * @param graphics          graphics object
	 * @param poisonProjectiles poisonProjectiles object
	 */
	private void drawPoisonArea(final Graphics2D graphics, final Map<LocalPoint, Projectile> poisonProjectiles)
	{
		final Area poisonTiles = new Area();

		for (final Map.Entry<LocalPoint, Projectile> entry : poisonProjectiles.entrySet())
		{
			if (entry.getValue().getEndCycle() < client.getGameCycle())
			{
				continue;
			}

			final LocalPoint point = entry.getKey();
			final Polygon poly = getCanvasTileAreaPoly(client, point, 3);

			if (poly != null)
			{
				poisonTiles.add(new Area(poly));
			}
		}

		graphics.setPaintMode();
		graphics.setColor(poisonBorder);
		graphics.draw(poisonTiles);
		graphics.setColor(poisonFill);
		graphics.fill(poisonTiles);
	}
}
