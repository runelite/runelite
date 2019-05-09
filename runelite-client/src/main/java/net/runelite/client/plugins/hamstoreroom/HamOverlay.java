/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.hamstoreroom;

import net.runelite.api.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;

class HamOverlay extends Overlay
{
	private final Client client;
	private final HamPlugin hamPlugin;

	@Inject
	private HamOverlay(Client client, HamPlugin hamPlugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.hamPlugin = hamPlugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Scene scene = client.getScene();
		Tile[][][] tiles = scene.getTiles();
		int z = client.getPlane();

		for (int x = 0; x < Constants.SCENE_SIZE; ++x)
		{
			for (int y = 0; y < Constants.SCENE_SIZE; ++y)
			{
				Tile tile = tiles[z][x][y];

				if (tile == null)
				{
					continue;
				}
				GameObject[] gameObjects = tile.getGameObjects();
				if (gameObjects != null)
				{
					for (GameObject gameObject : gameObjects)
					{
						if (gameObject != null)
						{
							switch (gameObject.getId())
							{
								case 15722:
									if (gameObject.getY() < 6500)
									{
										hamPlugin.steelPolygon = gameObject.getCanvasTilePoly();
									}
									break;
								case 15726:
									hamPlugin.ironPolygon = gameObject.getCanvasTilePoly();
									break;
								case 15724:
									hamPlugin.silverPolygon = gameObject.getCanvasTilePoly();
									break;
								case 15723:
									hamPlugin.bronzePolygon = gameObject.getCanvasTilePoly();
									break;
							}
						}
					}
				}
			}
		}

		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);
		hamPlugin.drawSteel = false;
		hamPlugin.drawIron = false;
		hamPlugin.drawSilver = false;
		hamPlugin.drawBronze = false;
		for (WidgetItem item : inventory.getWidgetItems())
		{
			switch (item.getId())
			{
				case 8866:
					hamPlugin.drawSteel = true;
					break;
				case 8869:
					hamPlugin.drawIron = true;
					break;
				case 8868:
					hamPlugin.drawSilver = true;
					break;
				case 8867:
					hamPlugin.drawBronze = true;
					break;
			}
		}
		if (hamPlugin.steelPolygon != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.steelPolygon, hamPlugin.drawSteel ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		if (hamPlugin.ironPolygon != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.ironPolygon, hamPlugin.drawIron ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		if (hamPlugin.silverPolygon != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.silverPolygon, hamPlugin.drawSilver ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		if (hamPlugin.bronzePolygon != null)
		{
			OverlayUtil.renderPolygon(graphics, hamPlugin.bronzePolygon, hamPlugin.drawBronze ? Color.GREEN.brighter() : Color.RED.brighter());
		}
		return null;
	}


}
