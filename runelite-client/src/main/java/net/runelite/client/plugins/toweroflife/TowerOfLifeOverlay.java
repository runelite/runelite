/*
 * Copyright (c) 2019, Ryan <https://github.com/rherms>
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
package net.runelite.client.plugins.toweroflife;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ItemID;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

class TowerOfLifeOverlay extends Overlay
{
	private static final int IMAGE_Z_OFFSET = 150;

	private final TowerOfLifePlugin plugin;
	private final Client client;
	private final ItemManager itemManager;

	@Inject
	private TowerOfLifeOverlay(TowerOfLifePlugin plugin, Client client, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.client = client;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (GameObject towerOfLifeAltar : plugin.getTowerOfLifeAltars())
		{
			BufferedImage image = null;
			WorldPoint worldPoint = towerOfLifeAltar.getWorldLocation();
			if (worldPoint.getX() == 3059 && worldPoint.getY() == 4410)
			{
				image = itemManager.getImage(ItemID.FEATHER);
			}
			else if (worldPoint.getX() == 3066 && worldPoint.getY() == 4381)
			{
				image = itemManager.getImage(ItemID.RAW_LOBSTER);
			}
			else if (worldPoint.getX() == 3043 && worldPoint.getY() == 4362)
			{
				image = itemManager.getImage(ItemID.RED_SPIDERS_EGGS);
			}
			else if (worldPoint.getX() == 3034 && worldPoint.getY() == 4362)
			{
				image = itemManager.getImage(ItemID.RAW_SWORDFISH);
			}
			else if (worldPoint.getX() == 3012 && worldPoint.getY() == 4381)
			{
				image = itemManager.getImage(ItemID.GIANT_FROG_LEGS);
			}
			else if (worldPoint.getX() == 3019 && worldPoint.getY() == 4410)
			{
				image = itemManager.getImage(ItemID.UNICORN_HORN);
			}

			if (image != null)
			{
				Point canvasLoc = Perspective.getCanvasImageLocation(client, towerOfLifeAltar.getLocalLocation(), image, IMAGE_Z_OFFSET);

				if (canvasLoc != null)
				{
					graphics.drawImage(image, canvasLoc.getX(), canvasLoc.getY(), null);
				}
			}
		}

		return null;
	}
}
