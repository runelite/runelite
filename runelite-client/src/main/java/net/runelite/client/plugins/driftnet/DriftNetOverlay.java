/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
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
package net.runelite.client.plugins.driftnet;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.inject.Inject;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

class DriftNetOverlay extends Overlay
{
	private final DriftNetConfig config;
	private final DriftNetPlugin plugin;

	@Inject
	private DriftNetOverlay(DriftNetConfig config, DriftNetPlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInDriftNetArea())
		{
			return null;
		}

		if (config.highlightUntaggedFish())
		{
			renderFish(graphics);
		}
		if (config.showNetStatus())
		{
			renderNets(graphics);
		}
		if (config.tagAnnetteWhenNoNets())
		{
			renderAnnette(graphics);
		}

		return null;
	}

	private void renderFish(Graphics2D graphics)
	{
		for (NPC fish : plugin.getFish())
		{
			if (!plugin.getTaggedFish().containsKey(fish))
			{
				OverlayUtil.renderActorOverlay(graphics, fish, "", config.untaggedFishColor());
			}
		}
	}

	private void renderNets(Graphics2D graphics)
	{
		for (DriftNet net : plugin.getNETS())
		{
			final Shape polygon = net.getNet().getConvexHull();

			if (polygon != null)
			{
				OverlayUtil.renderPolygon(graphics, polygon, net.getStatus().getColor());
			}

			String text = net.getFormattedCountText();
			Point textLocation = net.getNet().getCanvasTextLocation(graphics, text, 0);
			if (textLocation != null)
			{
				OverlayUtil.renderTextLocation(graphics, textLocation, text, config.countColor());
			}
		}
	}

	private void renderAnnette(Graphics2D graphics)
	{
		GameObject annette = plugin.getAnnette();
		if (annette != null && !plugin.isDriftNetsInInventory())
		{
			OverlayUtil.renderPolygon(graphics, annette.getConvexHull(), config.annetteTagColor());
		}
	}
}
