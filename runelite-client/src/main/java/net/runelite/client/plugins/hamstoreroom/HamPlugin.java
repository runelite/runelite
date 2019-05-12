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

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectID;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
	name = "H.A.M Store Room",
	description = "Show green / red overlays on chests in H.A.M store room, depending on the keys you have",
	tags = {"overlay"}
)
public class HamPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private HamOverlay hamOverlay;

	@Inject
	private Client client;

	public GameObject steelObject;
	public GameObject ironObject;
	public GameObject silverObject;
	public GameObject bronzeObject;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(hamOverlay);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject object = event.getGameObject();
		if (object != null)
		{
			check(object);
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}
			for (Item item : event.getItemContainer().getItems())
			{
				switch (item.getId())
				{
					case ItemID.STEEL_KEY:
						hamOverlay.drawSteel = true;
						break;
					case ItemID.IRON_KEY_8869:
						hamOverlay.drawIron = true;
						break;
					case ItemID.SILVER_KEY:
						hamOverlay.drawSilver = true;
						break;
					case ItemID.BRONZE_KEY_8867:
						hamOverlay.drawBronze = true;
						break;
				}
			}
	}

	public void check(GameObject object)
	{
		switch (object.getId())
		{
			case ObjectID.SMALL_CHEST:
				if (object.getY() < 8000)
				{
					steelObject = object;
				}
				break;
			case ObjectID.SMALL_CHEST_15726:
				ironObject = object;
				break;
			case ObjectID.SMALL_CHEST_15724:
				silverObject = object;
				break;
			case ObjectID.SMALL_CHEST_15723:
				bronzeObject = object;
				break;
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(hamOverlay);
	}
}
