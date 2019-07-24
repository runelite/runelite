/*
 * Copyright (c) 2018, Jasper Ketelaar <Jasper0781@gmail.com>
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
package net.runelite.client.plugins.mta.graveyard;

import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.ANIMALS_BONES;
import static net.runelite.api.ItemID.ANIMALS_BONES_6905;
import static net.runelite.api.ItemID.ANIMALS_BONES_6906;
import static net.runelite.api.ItemID.ANIMALS_BONES_6907;
import net.runelite.api.Player;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.mta.MTAConfig;
import net.runelite.client.plugins.mta.MTAPlugin;
import net.runelite.client.plugins.mta.MTARoom;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

public class GraveyardRoom extends MTARoom
{
	private static final int MTA_GRAVEYARD_REGION = 13462;

	static final int MIN_SCORE = 16;

	private final Client client;
	private final MTAPlugin plugin;
	private final ItemManager itemManager;
	private final InfoBoxManager infoBoxManager;
	private final EventBus eventBus;

	private GraveyardCounter counter;

	private boolean graveyard;

	@Inject
	private GraveyardRoom(final MTAConfig config, final Client client, final MTAPlugin plugin, final ItemManager itemManager, final InfoBoxManager infoBoxManager, final EventBus eventBus)
	{
		super(config);
		this.client = client;
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.infoBoxManager = infoBoxManager;
		this.eventBus = eventBus;

		this.graveyard = config.graveyard();

		addSubscriptions();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
	}

	@Override
	public boolean inside()
	{
		Player player = client.getLocalPlayer();
		return player != null && player.getWorldLocation().getRegionID() == MTA_GRAVEYARD_REGION
			&& player.getWorldLocation().getPlane() == 1;
	}

	private void onGameTick(GameTick tick)
	{
		if ((!inside() || !this.graveyard) && this.counter != null)
		{
			infoBoxManager.removeIf(e -> e instanceof GraveyardCounter);
			this.counter = null;
		}
	}

	private void onItemContainerChanged(ItemContainerChanged event)
	{
		if (!inside())
		{
			return;
		}

		ItemContainer container = event.getItemContainer();

		if (container == client.getItemContainer(InventoryID.INVENTORY))
		{
			int score = score(container.getItems());

			if (counter == null)
			{
				BufferedImage image = itemManager.getImage(ANIMALS_BONES);
				counter = new GraveyardCounter(image, plugin);
				infoBoxManager.addInfoBox(counter);
			}
			counter.setCount(score);
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("mta") || !event.getKey().equals("graveyard"))
		{
			return;
		}

		this.graveyard = config.graveyard();
	}

	private int score(Item[] items)
	{
		int score = 0;

		if (items == null)
		{
			return score;
		}

		for (Item item : items)
		{
			score += getPoints(item.getId());
		}

		return score;
	}

	private int getPoints(int id)
	{
		switch (id)
		{
			case ANIMALS_BONES:
				return 1;
			case ANIMALS_BONES_6905:
				return 2;
			case ANIMALS_BONES_6906:
				return 3;
			case ANIMALS_BONES_6907:
				return 4;
			default:
				return 0;
		}
	}
}