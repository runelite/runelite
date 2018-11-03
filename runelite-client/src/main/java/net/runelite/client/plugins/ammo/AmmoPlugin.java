/*
 * Copyright (c) 2018, Arthur Tyukayev <https://github.com/arthurtyukayev>
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
package net.runelite.client.plugins.ammo;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import javax.inject.Inject;
import java.awt.image.BufferedImage;

@PluginDescriptor(
		name = "Ammo",
		description = "Show your current ammo count",
		tags = {"combat", "ranged", "ammo", "arrows"}
)
public class AmmoPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private AmmoConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Provides
	AmmoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AmmoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{ }

	@Override
	protected void shutDown()
	{
		removeCounter();
		ammoCount = 0;
	}

	private ArrowCounter counter = null;
	private int ammoCount;
	private int activeEquipmentId;
	private int activeCounterImageItemId;

	private void debugToChat(String s)
	{
		client.addChatMessage(ChatMessageType.SERVER, "DEBUG", s, "DEBUG");
	}

	private void addCounter(int imageItemId)
	{
		if (counter == null)
		{
			int itemSpriteId = (imageItemId > 0) ? imageItemId :  ItemID.RUNE_ARROW;
			BufferedImage taskImg = itemManager.getImage(itemSpriteId, 50, false);
			counter = new ArrowCounter(taskImg, this, 0);

			infoBoxManager.addInfoBox(counter);
		}
	}

	private void removeCounter()
	{
		if (counter != null) infoBoxManager.removeInfoBox(counter);
		counter = null;
	}

	private void updateCounter(int itemId)
	{
		if (activeCounterImageItemId != itemId)
		{
			removeCounter();
			activeCounterImageItemId = itemId;
			addCounter(itemId);
		}
	}

	@Subscribe
	public void onAnimationChange(AnimationChanged event)
	{
		int animationId = event.getActor().getAnimation();

		if (
			(animationId == AnimationID.RANGED_ARROW_SHOOT) ||
			(animationId == AnimationID.RANGED_CROSSBOW_FIRE))
		{
			addCounter(0);
			activeEquipmentId = 13;
		}
			else if (
				(animationId == AnimationID.RANGED_KNIFE_THROW) ||
				(animationId == AnimationID.RANGED_DART_THROW)
			)
		{
			addCounter(0);
			activeEquipmentId = KitType.WEAPON.getIndex();
		}
	}

	@Subscribe
	public void onItemContainerChange(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.EQUIPMENT))
		{
			return;
		}

		Item[] items = event.getItemContainer().getItems();

		if (counter != null)
		{
			Item ammoItem = items[activeEquipmentId];
			ItemComposition heldItem = itemManager.getItemComposition(items[KitType.WEAPON.getIndex()].getId());


			if (activeEquipmentId == KitType.WEAPON.getIndex() && !(heldItem.isStackable()))
			{
				return;
			}

			ammoCount = ammoItem.getQuantity();
			updateCounter(ammoItem.getId());
			counter.setText(String.valueOf(ammoCount));
		}
	}
}