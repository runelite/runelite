/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.game;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ItemChargeChanged;

@Singleton
@Slf4j
public class ItemChargeManager
{
	@Getter
	@RequiredArgsConstructor
	public enum SharedChargeItem
	{
		AMULET_OF_CHEMISTRY(ItemID.AMULET_OF_CHEMISTRY, 5, true, Pattern.compile(
			"Your amulet of chemistry .*(?:(?:has (?<v>\\d{1,2}|one) charges?)|(?<z>crumbles))")),
		DODGY_NECKLACE(ItemID.DODGY_NECKLACE, 10, true, Pattern.compile(
			"Your dodgy necklace.*(?:(?:has (?<v>\\d{1,2}) charges?)|(?<z>crumbles))"));
		
		private final int itemID;
		private final int maxCharges;
		private final boolean resetAtZero;
		private final Pattern chatPattern;

		private static final Map<Integer, SharedChargeItem> ID_MAP = new HashMap<>();

		static
		{
			for (SharedChargeItem item : values())
			{
				ID_MAP.put(item.getItemID(), item);
			}
		}

		@Nullable
		static SharedChargeItem findItem(int itemId)
		{
			return ID_MAP.get(itemId);
		}
	}
	
	private final ConfigManager configManager;
	private final EventBus eventBus;
	private Map<SharedChargeItem, Integer> charges = new HashMap<>();
	private final String CONFIG_GROUP = "charges";
	private final String PREFIX = "item_";

	@Inject
	public ItemChargeManager(ConfigManager configManager, EventBus eventBus)
	{
		this.configManager = configManager;
		this.eventBus = eventBus;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = event.getMessage();
		if (event.getType() == ChatMessageType.SERVER || event.getType() == ChatMessageType.FILTERED)
		{
			for (SharedChargeItem item : SharedChargeItem.values())
			{
				Matcher matcher = item.chatPattern.matcher(message);
				if (matcher.find())
				{
					if (matcher.group("z") != null)
					{
						setCharge(item, 0);
					}
					else if (matcher.group("v") != null )
					{
						if (matcher.group("v").equals("one"))
						{
							setCharge(item, 1);
						}
						else
						{
							setCharge(item, Integer.parseInt(matcher.group("v")));
						}
					}
					else if (matcher.group("d") != null)
					{
						decrementCharge(item);
					}
					else if (matcher.group("i") != null)
					{
						incrementCharge(item);
					}
				}
			}
		}
	}
	
	private void setCharge(SharedChargeItem item, int charge)
	{
		log.debug("{} -> {}", item.name(), charge);
		if (charges.get(item) != charge)
		{
			eventBus.post(new ItemChargeChanged(item.itemID, charge));
		}
		if (charge == 0 && item.resetAtZero)
		{
			charge = item.maxCharges;
		}
		charges.put(item, charge);
		configManager.setConfiguration(CONFIG_GROUP, PREFIX + String.valueOf(item.getItemID()), charge);
	}

	private void decrementCharge(SharedChargeItem item)
	{
		decrementCharge(item, 1);
	}

	private void decrementCharge(SharedChargeItem item, int delta)
	{
		if (!charges.containsKey(item))
		{
			return;
		}
		int next = charges.get(item) - delta;

		log.debug("{} -> {}", item.name(), next);
		eventBus.post(new ItemChargeChanged(item.itemID, next));
		if (next == 0 && item.resetAtZero)
		{
			next = item.maxCharges;
		}
		charges.put(item, next);
		configManager.setConfiguration(CONFIG_GROUP, PREFIX + String.valueOf(item.getItemID()), next);
	}

	private void incrementCharge(SharedChargeItem item)
	{
		incrementCharge(item, 1);
	}

	private void incrementCharge(SharedChargeItem item, int delta)
	{
		if (!charges.containsKey(item))
		{
			return;
		}
		int next = charges.get(item) + delta;
		if (next == item.maxCharges)
		{
			return;
		}

		log.debug("{} -> {}", item.name(), next);
		eventBus.post(new ItemChargeChanged(item.itemID, next));
		charges.put(item, next);
		configManager.setConfiguration(CONFIG_GROUP, PREFIX + String.valueOf(item.getItemID()), next);
	}

	public Integer getCharge(SharedChargeItem item)
	{
		return charges.get(item);
	}
}
