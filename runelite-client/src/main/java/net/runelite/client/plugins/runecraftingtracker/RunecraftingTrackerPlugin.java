/*
 * Copyright (c) 2018, Henning Berge <henning@henning.tech>
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
package net.runelite.client.plugins.runecraftingtracker;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.events.ItemContainerChanged;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static net.runelite.api.ItemID.*;

@PluginDescriptor(
		name = "RunecraftingTracker",
		description = "Show runecrafting statistics and profit",
		tags = {"runecrafting", "runes", "crafting", "overlay", "skilling"}
)
@PluginDependency(XpTrackerPlugin.class)
public class RunecraftingTrackerPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RunecraftingTrackerOverlay overlay;

	@Inject
	private RunecraftingTrackerConfig config;

	@Getter
	private RunecraftingTrackerSession session;

	@Getter
	private int DeathRuneEXP = 10;

	@Getter
	private int carriedRunes = 0;

	@Getter
	private int carriedEssence = 0;

	@Getter
	private int craftedRunes = 0;

	@Getter
	private Map<Integer, Rune> RUNES = new HashMap<>();

	@Provides
	RunecraftingTrackerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftingTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		session = null;
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (this.RUNES.isEmpty())
		{
			this.RUNES.put(AIR_RUNE, new Rune(5, "Air", AIR_RUNE));
			this.RUNES.put(MIND_RUNE, new Rune(5.5, "Mind", MIND_RUNE));
			this.RUNES.put(WATER_RUNE, new Rune(6, "Water", WATER_RUNE));
			this.RUNES.put(EARTH_RUNE, new Rune(6.5, "Earth", EARTH_RUNE));
			this.RUNES.put(FIRE_RUNE, new Rune(7, "Fire", FIRE_RUNE));
			this.RUNES.put(BODY_RUNE, new Rune(7.5, "Body", BODY_RUNE));
			this.RUNES.put(COSMIC_RUNE, new Rune(8, "Cosmic", COSMIC_RUNE));
			this.RUNES.put(CHAOS_RUNE, new Rune(8.5, "Chaos", CHAOS_RUNE));
			this.RUNES.put(ASTRAL_RUNE, new Rune(8.7, "Astral", ASTRAL_RUNE));
			this.RUNES.put(NATURE_RUNE, new Rune(9, "Nature", NATURE_RUNE));
			this.RUNES.put(LAW_RUNE, new Rune(9.5, "Law", LAW_RUNE));
			this.RUNES.put(DEATH_RUNE, new Rune(10, "Death", DEATH_RUNE));
		}
		if (session == null || session.getLastRuneCraft() == null)
		{
			return;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastRuneCraft(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			session = null;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.FILTERED || event.getType() == ChatMessageType.SERVER)
		{
			if (event.getMessage().startsWith("You bind the temple") && event.getMessage().endsWith("runes."))
			{
				if (session == null)
				{
					session = new RunecraftingTrackerSession();
				}
				session.setLastRuneCraft();
			}
		}
	}


	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged itemContainerChanged)
	{
		ItemContainer itemContainer = itemContainerChanged.getItemContainer();
		if (itemContainer == client.getItemContainer(InventoryID.INVENTORY))
		{
			checkForItems(itemContainer);
		}
	}

	private void checkForItems(ItemContainer itemContainer)
	{
		int essence = 0;
		int totalRunes = 0;

		for (Rune rune : RUNES.values())
		{
			rune.setCount(0);
		}

		if (itemContainer == null)
		{
			return;
		}

		Item[] items = itemContainer.getItems();
		if (items != null)
		{
			for (Item item : items)
			{
				if (item == null)
				{
					continue;
				}
				if (item.getId() == PURE_ESSENCE || item.getId() == RUNE_ESSENCE)
				{
					essence++;
				}
				if (this.RUNES.containsKey(item.getId()))
				{
					Rune runeItem = this.RUNES.get(item.getId());
					runeItem.setCount(item.getQuantity());
					this.RUNES.put(item.getId(), runeItem);
					totalRunes += item.getQuantity();
				}
			}
		}
		if (essence == 0 && carriedEssence != 0)
		{
			for (Rune rune : this.RUNES.values())
			{
				if (rune.getCount() > rune.getCarried())
				{
					this.craftedRunes += rune.getCount() - rune.getCarried();
					rune.setCrafted(rune.getCrafted() + (rune.getCount() - rune.getCarried()));
				}
			}
		}
		for (Rune rune : this.RUNES.values())
		{
			rune.setCarried(rune.getCount());
		}
		this.carriedEssence = essence;
		this.carriedRunes = totalRunes;
	}
}