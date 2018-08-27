/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.slayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class TargetClickboxOverlay extends Overlay
{
	private final SlayerConfig config;
	private final SlayerPlugin plugin;
	private final Client client;
	@Inject
	TargetClickboxOverlay(SlayerConfig config, SlayerPlugin plugin, Client client)
	{
		this.config = config;
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<NPC> targets = plugin.getHighlightedTargets();
		if (config.highlightStyle() == HighlightStyle.NONE)
		{
			return null;
		}
		renderTargetList(graphics, targets, config.getTargetColor(), config.highlightStyle());
		return null;
	}
	private void renderTargetList(Graphics2D graphics, List<NPC> targets, Color highlightColor, HighlightStyle style)
	{
		if (targets != null)
		{
			for (NPC npc : targets)
			{
				if (npc != null)
				{
					switch (style)
					{
						case NONE:
							break;
						case CONVEX_HULL:
							Polygon hPolygon = npc.getConvexHull();
							if (hPolygon != null)
							{
								OverlayUtil.renderPolygon(graphics, hPolygon, highlightColor);
							}
							break;
						case MARK_TILE:
							int targetSize = npc.getComposition().getSize();
							LocalPoint npcLocation = npc.getLocalLocation();
							Polygon tPolygon = targetSize >= 1 ? Perspective.getCanvasTileAreaPoly(client, npcLocation, targetSize) : null;
							if (tPolygon != null)
							{
								OverlayUtil.renderPolygon(graphics, tPolygon, highlightColor);
							}
							break;
					}
				}
			}
		}
	}
}
