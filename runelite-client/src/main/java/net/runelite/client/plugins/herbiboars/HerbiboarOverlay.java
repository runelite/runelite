/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.herbiboars;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.Set;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class HerbiboarOverlay extends Overlay
{
	private final HerbiboarPlugin plugin;
	private final HerbiboarConfig config;

	@Inject
	public HerbiboarOverlay(HerbiboarPlugin plugin, HerbiboarConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInHerbiboarArea())
		{
			return null;
		}

		HerbiboarTrail currentTrail = plugin.getCurrentTrail();

		int finishId = plugin.getFinishId();

		// Draw start objects
		if (config.isStartShown() && (currentTrail == null && finishId == 0))
		{
			plugin.getStarts().values().forEach((obj) ->
			{
				OverlayUtil.renderTileOverlay(graphics, obj, "", config.getStartColor());
			});
		}

		// Draw trails
		if (config.isTrailShown())
		{
			Set<Integer> shownTrailIds = plugin.getShownTrails();
			plugin.getTrails().values().forEach((x) ->
			{
				int id = x.getId();
				if (shownTrailIds.contains(id) && (finishId > 0 || (currentTrail != null && currentTrail.getTrailId() != id && currentTrail.getTrailId() + 1 != id)))
				{
					OverlayUtil.renderTileOverlay(graphics, x, "", config.getTrailColor());
				}
			});
		}

		// Draw trail objects (mushrooms, mud, etc)
		if (config.isObjectShown() && currentTrail != null)
		{
			int currentPath = plugin.getCurrentPath();
			WorldPoint[] trailLocs = currentTrail.getObjectLocs(currentPath);
			for (WorldPoint trailLoc : trailLocs)
			{
				if (trailLoc == null)
				{
					continue;
				}

				TileObject object = plugin.getTrailObjects().get(trailLoc);
				if (object != null)
				{
					if (config.showClickBoxes())
					{
						Area clickbox = object.getClickbox();
						if (clickbox != null)
						{
							graphics.setColor(config.getObjectColor());
							graphics.draw(clickbox);
							graphics.setColor(new Color(255, 0, 255, 20));
							graphics.fill(clickbox);
						}
					}
					else
					{
						OverlayUtil.renderTileOverlay(graphics, object, "", config.getObjectColor());
					}
				}
			}
		}

		// Draw finish tunnels
		if (config.isTunnelShown() && finishId > 0)
		{
			WorldPoint finishLoc = plugin.getEndLocations().get(finishId - 1);
			TileObject object = plugin.getTunnels().get(finishLoc);
			if (object != null)
			{
				if (config.showClickBoxes())
				{
					Area clickbox = object.getClickbox();
					if (clickbox != null)
					{
						Color col = config.getObjectColor();
						graphics.setColor(col);
						graphics.draw(clickbox);
						graphics.setColor(new Color(col.getRed(), col.getGreen(), col.getBlue(), 20));
						graphics.fill(clickbox);
					}
				}
				else
				{
					OverlayUtil.renderTileOverlay(graphics, object, "", config.getTunnelColor());
				}
			}
		}

		return null;
	}
}