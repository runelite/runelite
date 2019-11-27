/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2019, Gamer1120 <https://github.com/Gamer1120>
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
import com.google.inject.Singleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
class HerbiboarOverlay extends Overlay
{
	private static final Color TRANSPARENT = new Color(0, 0, 0, 0);

	private final Client client;

	private final HerbiboarPlugin plugin;
	private final ModelOutlineRenderer modelOutlineRenderer;

	@Inject
	public HerbiboarOverlay(final HerbiboarPlugin plugin, ModelOutlineRenderer modelOutlineRenderer, Client client)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.modelOutlineRenderer = modelOutlineRenderer;
		this.client = client;
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
		if (plugin.isStartShown() && currentTrail == null && finishId == 0 && !plugin.isHerbiboarRendered())
		{
			plugin.getStarts().values().forEach((obj) ->
				OverlayUtil.renderTileOverlay(graphics, obj, "", plugin.getGetStartColor()));
		}

		// Draw trails
		Set<Integer> shownTrailIds;
		if (plugin.isTrailShown())
		{
			if (plugin.isOnlyCurrentTrailShown())
			{
				shownTrailIds = plugin.getCurrentTrailIds();
			}
			else
			{
				shownTrailIds = plugin.getShownTrails();
			}
			plugin.getTrails().values().forEach((x) ->
			{
				int id = x.getId();
				if (shownTrailIds.contains(id) && (finishId > 0 || (currentTrail != null && currentTrail.getTrailId() != id && currentTrail.getTrailId() + 1 != id)))
				{
					OverlayUtil.renderTileOverlay(graphics, x, "", plugin.getGetTrailColor());
				}
			});
		}

		// Draw trail objects (mushrooms, mud, etc)
		if (plugin.isObjectShown() && currentTrail != null)
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
					if (plugin.isShowOutlines())
					{
						renderOutline(object, new Color(255, 0, 255, 20));
					}
					else
					{
						OverlayUtil.renderTileOverlay(graphics, object, "", plugin.getGetObjectColor());
					}
				}
			}
		}

		// Draw finish tunnels
		if (plugin.isTunnelShown() && finishId > 0)
		{
			WorldPoint finishLoc = plugin.getEndLocations().get(finishId - 1);
			TileObject object = plugin.getTunnels().get(finishLoc);
			if (object != null)
			{
				if (plugin.isShowOutlines())
				{
					Color col = plugin.getGetObjectColor();
					renderOutline(object, new Color(col.getRed(), col.getGreen(), col.getBlue(), 20));
				}
				else
				{
					OverlayUtil.renderTileOverlay(graphics, object, "", plugin.getGetTunnelColor());
				}
			}
		}

		// Draw herbiboar
		if (plugin.isHerbiboarRendered())
		{
			for (NPC npc : client.getNpcs())
			{
				if (npc.getId() == NpcID.HERBIBOAR || npc.getId() == NpcID.HERBIBOAR_7786)
				{
					modelOutlineRenderer.drawOutline(npc, 2, plugin.getGetObjectColor());
				}
			}
		}
		return null;
	}

	private void renderOutline(TileObject object, Color color)
	{
		switch (plugin.getOutlineStyle())
		{
			case THIN_OUTLINE:
				modelOutlineRenderer.drawOutline(object, 1, color);
				break;

			case OUTLINE:
				modelOutlineRenderer.drawOutline(object, 2, color);
				break;

			case THIN_GLOW:
				modelOutlineRenderer.drawOutline(object, 4, color, TRANSPARENT);
				break;

			case GLOW:
				modelOutlineRenderer.drawOutline(object, 8, color, TRANSPARENT);
				break;
		}
	}
}
