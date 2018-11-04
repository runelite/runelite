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

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import javax.inject.Inject;

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
	private Notifier notifier;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	private AmmoCounterManager ammoCounterManager;
	private int ammoCount;
	private int activeEquipmentId;

	@Provides
	AmmoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AmmoConfig.class);
	}

	private final static ImmutableList<Integer> RANGED_THROWN_ANIMATIONS = ImmutableList.of(
		AnimationID.RANGED_DART_THROW,
		AnimationID.RANGED_KNIFE_THROW
	);

	private final static ImmutableList<Integer> RANGED_BOW_ANIMATIONS = ImmutableList.of(
		AnimationID.RANGED_CROSSBOW_FIRE,
		AnimationID.RANGED_ARROW_SHOOT
	);


	@Override
	protected void startUp() throws Exception
	{
		this.ammoCounterManager = new AmmoCounterManager(this, config, itemManager, infoBoxManager);
	}

	@Override
	protected void shutDown()
	{
		ammoCount = 0;
		ammoCounterManager.removeCounter();
		ammoCounterManager = null;
	}

	@Subscribe
	public void onAnimationChange(AnimationChanged event)
	{
		int animationId = event.getActor().getAnimation();

		if (!RANGED_BOW_ANIMATIONS.contains(animationId) &&
			!RANGED_THROWN_ANIMATIONS.contains(animationId))
		{
			return;
		}

		if (RANGED_BOW_ANIMATIONS.contains(animationId))
		{
			activeEquipmentId = 13;
		}
		else if (RANGED_THROWN_ANIMATIONS.contains(animationId))
		{
			activeEquipmentId = KitType.WEAPON.getIndex();
		}

		ammoCounterManager.createCounter(0, "");
	}

	@Subscribe
	public void onItemContainerChange(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.EQUIPMENT))
		{
			return;
		}

		if (ammoCounterManager.getCounter() == null)
		{
			return;
		}

		Item[] items = event.getItemContainer().getItems();
		Item ammoItem = items[activeEquipmentId];
		ItemComposition heldItem = itemManager.getItemComposition(items[KitType.WEAPON.getIndex()].getId());

		if (activeEquipmentId == KitType.WEAPON.getIndex() && !(heldItem.isStackable()))
		{
			return;
		}

		ammoCount = ammoItem.getQuantity();

		ammoCounterManager.updateCounter(ammoItem.getId());
		ammoCounterManager.getCounter().setText(String.valueOf(ammoCount));
		ammoCounterManager.displayCounter();

		if (config.showLowAmmoNotification() && ammoCount == config.notificationThreshold())
		{
			notifier.notify("You're running low on ammunition.");
		}
	}
}