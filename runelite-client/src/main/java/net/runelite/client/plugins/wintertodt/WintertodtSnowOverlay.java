/*
 * Copyright (c) 2018, EmptySet <https://github.com/OTRD5k>
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

package net.runelite.client.plugins.wintertodt;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import javax.inject.Inject;
import java.awt.*;
import java.util.List;

public class WintertodtSnowOverlay extends Overlay
{
	private final Client client;
	private final WintertodtPlugin plugin;
	private final WintertodtConfig config;

	private static final int MAX_DISTANCE = 2350; //Grabbed from the cannon plugin, magic number to keep overlay from rendering in unloaded tiles
	private static final int SNOW_ATTACK_CENTER_ID = 502; //Id of the graphics object at center of snow attack
	private static final int SNOW_PARTICLES_ID = 1311; //Id of the particles that spawn around an attack that was spawned on a player


	Brazier[] Braziers = {
			//south east brazier
			new Brazier(
					//The location the snow attack graphics object will spawn at for a south east brazier attack
					new WorldPoint(1638, 3997, 0),
					//The center of the snow attacks AOE damage
					new WorldPoint(1640, 3998, 0)
			),
			//south west brazier
			new Brazier(
					new WorldPoint(1620, 3997, 0),
					new WorldPoint(1621, 3998, 0)
			),
			//north west brazier
			new Brazier(
					new WorldPoint(1620, 4015, 0),
					new WorldPoint(1621, 4017, 0)
			),
			//north east brazier
			new Brazier(
					new WorldPoint(1638, 4015, 0),
					new WorldPoint(1640, 4017, 0)
			)
	};

	private boolean isAttackingPyromancer(int x, int y, List<GraphicsObject> graphicsObjects)
	{
		for (int i = 0; i < graphicsObjects.size(); i++)
		{
			GraphicsObject object = graphicsObjects.get(i);
			if (object.getId() == SNOW_PARTICLES_ID)
			{
				WorldPoint particleLocation = WorldPoint.fromLocal(client, object.getLocation());
				int particleX = particleLocation.getX();
				int particleY = particleLocation.getY();

				//particles spawn on the tiles diagonal to the main attack object
				if (particleX == x - 1 && particleY == y - 1 ||
						particleX == x - 1 && particleY == y + 1 ||
						particleX == x + 1 && particleY == y - 1 ||
						particleX == x + 1 && particleY == y + 1)
				{
					return false;
				}
			}
		}
		//if there are no particles around an attack object, and it's not attacking a brazier, it is a non-damaging pyro hit
		return true;
	}

	@Inject
	WintertodtSnowOverlay(Client client, WintertodtPlugin plugin, WintertodtConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showDangerTiles() && plugin.isInWintertodt())
		{
			List<GraphicsObject> graphicsObjects = client.getGraphicsObjects();
			LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();

			GameObjectQuery query = new GameObjectQuery();
			GameObject[] gameObjects = query.result(client);

			for (int i = 0; i < graphicsObjects.size(); i++)
			{
				GraphicsObject object = graphicsObjects.get(i);
				if (object.getId() == SNOW_ATTACK_CENTER_ID)
				{
					LocalPoint localCenter = object.getLocation();
					WorldPoint worldCenter = WorldPoint.fromLocal(client, localCenter);
					Polygon dangerZone = null;

					int worldX = worldCenter.getX();
					int worldY = worldCenter.getY();

					boolean brazierHit = false;

					for (int j = 0; i < Braziers.length; i++)
					{
						if (Braziers[i].isAttackingBrazier(worldX, worldY))
						{
							brazierHit = true;
							if (Braziers[i].isBrazierAttackDangerous(gameObjects))
							{
								dangerZone = Braziers[i].dangerZone(client);
								break;
							}
							else
							{
								break;
							}
						}
					}

					if (dangerZone == null && brazierHit == false && !isAttackingPyromancer(worldX, worldY, graphicsObjects))
					{
						dangerZone = Perspective.getCanvasTileAreaPoly(client, localCenter, 3);
					}

					if (dangerZone != null && localLocation.distanceTo(localCenter) <= MAX_DISTANCE)
					{
						OverlayUtil.renderPolygon(graphics, dangerZone, Color.RED);
					}
				}
			}

		}


		return null;
	}
}
