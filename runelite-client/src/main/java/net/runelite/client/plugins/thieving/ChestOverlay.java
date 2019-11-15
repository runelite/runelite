/*
 * Copyright (c) 2019, whs
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
package net.runelite.client.plugins.thieving;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
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
class ChestOverlay extends Overlay
{
	private final Client client;
	private final List<ChestRespawn> respawns;

	@Setter(AccessLevel.PACKAGE)
	private Color pieFillColor;
	@Setter(AccessLevel.PACKAGE)
	private Color pieBorderColor;
	@Setter(AccessLevel.PACKAGE)
	private boolean respawnPieInverted;
	@Setter(AccessLevel.PACKAGE)
	private int respawnPieDiameter;

	@Inject
	private ChestOverlay(final Client client, final ThievingPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.respawns = plugin.getRespawns();
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (respawns.isEmpty())
		{
			return null;
		}

		Instant now = Instant.now();
		for (Iterator<ChestRespawn> it = respawns.iterator(); it.hasNext(); )
		{
			ChestRespawn chestRespawn = it.next();

			float percent = 1.0f - (now.until(chestRespawn.getEndTime(), ChronoUnit.MILLIS) / (float) chestRespawn.getRespawnTime());
			if (percent > 1.0f)
			{
				it.remove();
				continue;
			}

			if (chestRespawn.getWorld() != client.getWorld())
			{
				continue;
			}

			WorldPoint worldPoint = chestRespawn.getWorldPoint();
			LocalPoint loc = LocalPoint.fromWorld(client, worldPoint);
			if (loc == null)
			{
				continue;
			}

			Point point = Perspective.localToCanvas(client, loc, client.getPlane(), 0);
			if (point == null)
			{
				continue;
			}

			if (respawnPieInverted)
			{
				percent = 1.0f - percent;
			}

			ProgressPieComponent ppc = new ProgressPieComponent();
			ppc.setDiameter(respawnPieDiameter);
			ppc.setBorderColor(pieBorderColor);
			ppc.setFill(pieFillColor);
			ppc.setPosition(point);
			ppc.setProgress(percent);
			ppc.render(graphics);
		}
		return null;
	}
}
