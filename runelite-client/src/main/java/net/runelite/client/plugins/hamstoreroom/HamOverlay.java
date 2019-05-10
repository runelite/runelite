/*
 * Copyright (c) 2019, Alex <https://github.com/Barragek0>
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

import java.awt.Color;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectID;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.OverlayUtil;

class HamOverlay extends Overlay
{
	private final Client client;
	private final HamPlugin hamPlugin;

	private boolean drawSteel = false;
	private boolean drawIron = false;
	private boolean drawSilver = false;
	private boolean drawBronze = false;

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
		if (client.getLocalPlayer().getWorldLocation().getRegionID() == 10321)
		{
			drawSteel = false;
			drawIron = false;
			drawSilver = false;
			drawBronze = false;

			ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

			if (itemContainer != null)
			{
				for (Item item : itemContainer.getItems())
				{
					switch (item.getId())
					{
						case ItemID.STEEL_KEY:
							drawSteel = true;
							break;
						case ItemID.IRON_KEY_8869:
							drawIron = true;
							break;
						case ItemID.SILVER_KEY:
							drawSilver = true;
							break;
						case ItemID.BRONZE_KEY_8867:
							drawBronze = true;
							break;
					}
				}
			}
			if (hamPlugin.steelObject.getCanvasTilePoly() != null)
			{
				OverlayUtil.renderPolygon(graphics, hamPlugin.steelObject.getCanvasTilePoly(), drawSteel ? Color.GREEN.brighter() : Color.RED.brighter());
			}
			if (hamPlugin.ironObject.getCanvasTilePoly() != null)
			{
				OverlayUtil.renderPolygon(graphics, hamPlugin.ironObject.getCanvasTilePoly(), drawIron ? Color.GREEN.brighter() : Color.RED.brighter());
			}
			if (hamPlugin.silverObject.getCanvasTilePoly() != null)
			{
				OverlayUtil.renderPolygon(graphics, hamPlugin.silverObject.getCanvasTilePoly(), drawSilver ? Color.GREEN.brighter() : Color.RED.brighter());
			}
			if (hamPlugin.bronzeObject.getCanvasTilePoly() != null)
			{
				OverlayUtil.renderPolygon(graphics, hamPlugin.bronzeObject.getCanvasTilePoly(), drawBronze ? Color.GREEN.brighter() : Color.RED.brighter());
			}
		}
		return null;
	}

	public void check(GameObject object)
	{
		switch (object.getId())
		{
			case ObjectID.SMALL_CHEST:
				if (object.getY() < 8000)
				{
					hamPlugin.steelObject = object;
				}
				break;
			case ObjectID.SMALL_CHEST_15726:
				hamPlugin.ironObject = object;
				break;
			case ObjectID.SMALL_CHEST_15724:
				hamPlugin.silverObject = object;
				break;
			case ObjectID.SMALL_CHEST_15723:
				hamPlugin.bronzeObject = object;
				break;
		}
	}


}
