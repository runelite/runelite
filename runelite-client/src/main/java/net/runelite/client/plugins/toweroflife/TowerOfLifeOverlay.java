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

import com.google.common.collect.ImmutableMap;
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
import java.util.Map;

class TowerOfLifeOverlay extends Overlay
{
	private static final Map<WorldPoint, Integer> ALTAR_LOCATIONS_TO_ITEM_ICON_ID = ImmutableMap.<WorldPoint, Integer>builder()
			.put(new WorldPoint(3059, 4410, 0), ItemID.EYE_OF_NEWT)
			.put(new WorldPoint(3019, 4410, 0), ItemID.UNICORN_HORN)
			.put(new WorldPoint(3043, 4362, 0), ItemID.RED_SPIDERS_EGGS)
			.put(new WorldPoint(3034, 4362, 0), ItemID.RAW_SWORDFISH)
			.put(new WorldPoint(3066, 4381, 0), ItemID.RAW_JUBBLY)
			.put(new WorldPoint(3012, 4381, 0), ItemID.RAW_CAVE_EEL)
			.build();

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
			WorldPoint worldPoint = towerOfLifeAltar.getWorldLocation();
			Integer imageItemId = ALTAR_LOCATIONS_TO_ITEM_ICON_ID.get(worldPoint);
			if (imageItemId != null)
			{
				BufferedImage image = itemManager.getImage(imageItemId);
				if (image != null)
				{
					Point canvasLoc = Perspective.getCanvasImageLocation(client, towerOfLifeAltar.getLocalLocation(), image, IMAGE_Z_OFFSET);

					if (canvasLoc != null)
					{
						graphics.drawImage(image, canvasLoc.getX(), canvasLoc.getY(), null);
					}
				}
			}
		}

		return null;
	}
}
