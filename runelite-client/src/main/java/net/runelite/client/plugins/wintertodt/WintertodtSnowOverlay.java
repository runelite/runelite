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
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
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


	//The location the snow attack graphics object will spawn at for a south east brazier attack
	private static final WorldPoint SOUTH_EAST_BRAZIER_ATTACK_CENTER = new WorldPoint(1638, 3997, 0);
	//The center of the snow attacks AOE damage
	private static final WorldPoint SOUTH_EAST_BRAZIER_DAMAGE_CENTER = new WorldPoint(1640, 3998, 0);

	private static final WorldPoint SOUTH_WEST_BRAZIER_ATTACK_CENTER = new WorldPoint(1620, 3997, 0);
	private static final WorldPoint SOUTH_WEST_BRAZIER_DAMAGE_CENTER = new WorldPoint(1621, 3998, 0);

	private static final WorldPoint NORTH_WEST_BRAZIER_DAMAGE_CENTER = new WorldPoint(1621, 4017, 0);

	private static final WorldPoint NORTH_EAST_BRAZIER_DAMAGE_CENTER = new WorldPoint(1640, 4017, 0);

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

					if (worldX == SOUTH_EAST_BRAZIER_ATTACK_CENTER.getX() && worldY == SOUTH_EAST_BRAZIER_ATTACK_CENTER.getY())
					{
						LocalPoint AOECenter = LocalPoint.fromWorld(client, SOUTH_EAST_BRAZIER_DAMAGE_CENTER);
						dangerZone = Perspective.getCanvasTileAreaPoly(client, AOECenter, 4);
					}
					else if (worldX == SOUTH_WEST_BRAZIER_ATTACK_CENTER.getX() && worldY == SOUTH_WEST_BRAZIER_ATTACK_CENTER.getY())
					{
						LocalPoint AOECenter = LocalPoint.fromWorld(client, SOUTH_WEST_BRAZIER_DAMAGE_CENTER);
						dangerZone = Perspective.getCanvasTileAreaPoly(client, AOECenter, 4);
					}
					else
					{
						dangerZone = Perspective.getCanvasTileAreaPoly(client, localCenter, 3);
					}

					if (dangerZone != null  && localLocation.distanceTo(localCenter) <= MAX_DISTANCE)
					{
						OverlayUtil.renderPolygon(graphics, dangerZone, Color.RED);
						WorldPoint tile = WorldPoint.fromLocal(client, localCenter);
						System.out.println("Snow attack at " + tile.toString());
						//TODO, FIND SPAWN POINT OF NORTHERN BRAZIERS
					}
				}
			}

		}


		return null;
	}
}
