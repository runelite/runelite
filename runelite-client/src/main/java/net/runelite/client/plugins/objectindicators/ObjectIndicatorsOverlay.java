/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.objectindicators;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.TileObject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

class ObjectIndicatorsOverlay extends Overlay
{
	private final Client client;
	private final ObjectIndicatorsConfig config;
	private final ObjectIndicatorsPlugin plugin;

	@Inject
	private ObjectIndicatorsOverlay(Client client, ObjectIndicatorsConfig config, ObjectIndicatorsPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (TileObject object : plugin.getObjects())
		{
<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/plugins/npchighlight/NpcClickboxOverlay.java
<<<<<<< HEAD
			renderNpcOverlay(graphics, npc, npc.getName(), config.getNpcColor());
		}

		NPC[] npcs = client.getCachedNPCs();
		for (int npcId : plugin.getNpcTags())
		{
			NPC npc = npcs[npcId];
			if (npc != null && npc.getName() != null)
			{
				renderNpcOverlay(graphics, npc, npc.getName(), config.getTagColor());
			}
=======
			renderNpcOverlay(graphics, npc, npc.getName(), config.getHighlightColor());
>>>>>>> upstream/master
		}

		return null;
	}

	private void renderNpcOverlay(Graphics2D graphics, NPC actor, String name, Color color)
	{
		switch (config.renderStyle())
		{
			case TILE:
				Polygon objectTile = actor.getCanvasTilePoly();

				if (objectTile != null)
				{
					graphics.setColor(color);
					graphics.setStroke(new BasicStroke(2));
					graphics.draw(objectTile);
<<<<<<< HEAD
					graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 255)); // ollie 5-14-2018
=======
					graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
>>>>>>> upstream/master
					graphics.fill(objectTile);
				}
				break;
=======
			if (object.getPlane() != client.getPlane())
			{
				continue;
			}
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/objectindicators/ObjectIndicatorsOverlay.java

			final Polygon polygon;
			Polygon polygon2 = null;

<<<<<<< HEAD:runelite-client/src/main/java/net/runelite/client/plugins/npchighlight/NpcClickboxOverlay.java
				if (objectClickbox != null)
				{
					graphics.setColor(color);
					graphics.setStroke(new BasicStroke(2));
					graphics.draw(objectClickbox);
<<<<<<< HEAD
					graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 255));
=======
					graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
>>>>>>> upstream/master
					graphics.fill(objectClickbox);
				}
				break;
		}
=======
			if (object instanceof GameObject)
			{
				polygon = ((GameObject) object).getConvexHull();
			}
			else if (object instanceof DecorativeObject)
			{
				polygon = ((DecorativeObject) object).getConvexHull();
				polygon2 = ((DecorativeObject) object).getConvexHull2();
			}
			else
			{
				polygon = object.getCanvasTilePoly();
			}
>>>>>>> upstream/master:runelite-client/src/main/java/net/runelite/client/plugins/objectindicators/ObjectIndicatorsOverlay.java

			if (polygon != null)
			{
				OverlayUtil.renderPolygon(graphics, polygon, config.markerColor());
			}

			if (polygon2 != null)
			{
				OverlayUtil.renderPolygon(graphics, polygon2, config.markerColor());
			}
		}

		return null;
	}
}