/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.mining;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

@Singleton
class MiningOverlay extends Overlay
{
	// Range of Motherlode vein respawn time - not 100% confirmed but based on observation
	static final int ORE_VEIN_MAX_RESPAWN_TIME = 166;
	private static final int ORE_VEIN_MIN_RESPAWN_TIME = 90;
	private static final float ORE_VEIN_RANDOM_PERCENT_THRESHOLD = (float) ORE_VEIN_MIN_RESPAWN_TIME / ORE_VEIN_MAX_RESPAWN_TIME;
	private static final Color DARK_GREEN = new Color(0, 100, 0);
	private static final int MOTHERLODE_UPPER_FLOOR_HEIGHT = -500;

	private final Client client;
	private final MiningPlugin plugin;
	private final MiningConfig config;

	@Inject
	private MiningOverlay(final Client client, final MiningPlugin plugin, final MiningConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<RockRespawn> respawns = plugin.getRespawns();
		if (respawns.isEmpty())
		{
			return null;
		}

		Instant now = Instant.now();
		for (Iterator<RockRespawn> it = respawns.iterator(); it.hasNext(); )
		{
			Color pieFillColor = config.progressPieColor();
			Color pieBorderColor;
			RockRespawn rockRespawn = it.next();
			float percent = (now.toEpochMilli() - rockRespawn.getStartTime().toEpochMilli()) / (float) rockRespawn.getRespawnTime();
			WorldPoint worldPoint = rockRespawn.getWorldPoint();
			LocalPoint loc = LocalPoint.fromWorld(client, worldPoint);
			if (loc == null || percent > 1.0f)
			{
				it.remove();
				continue;
			}

			Point point = Perspective.localToCanvas(client, loc, client.getPlane(), rockRespawn.getZOffset());
			if (point == null)
			{
				it.remove();
				continue;
			}

			Rock rock = rockRespawn.getRock();

			// Only draw timer for veins on the same level in motherlode mine
			LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();
			if (rock == Rock.ORE_VEIN && isUpstairsMotherlode(localLocation) != isUpstairsMotherlode(loc))
			{
				continue;
			}

			// Recolour pie on motherlode veins during the portion of the timer where they may respawn
			if (rock == Rock.ORE_VEIN && percent > ORE_VEIN_RANDOM_PERCENT_THRESHOLD)
			{
				pieFillColor = config.progressPieColorMotherlode();
			}

			if (config.progressPieInverted())
			{
				percent = 1.0f - percent;
			}

			pieBorderColor = pieFillColor.darker();

			ProgressPieComponent ppc = new ProgressPieComponent();
			ppc.setDiameter(config.progressPieDiameter());
			ppc.setBorderColor(pieBorderColor);
			ppc.setFill(pieFillColor);
			ppc.setPosition(point);
			ppc.setProgress(percent);
			ppc.render(graphics);
		}
		return null;
	}

	/**
	 * Checks if the given point is "upstairs" in the mlm.
	 * The upper floor is actually on z=0.
	 * <p>
	 * This method assumes that the given point is already in the mlm
	 * and is not meaningful when outside the mlm.
	 *
	 * @param localPoint the LocalPoint to be tested
	 * @return true if localPoint is at same height as mlm upper floor
	 */
	private boolean isUpstairsMotherlode(LocalPoint localPoint)
	{
		return Perspective.getTileHeight(client, localPoint, 0) < MOTHERLODE_UPPER_FLOOR_HEIGHT;
	}
}
