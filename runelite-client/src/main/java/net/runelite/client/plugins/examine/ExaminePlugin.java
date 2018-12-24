/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.examine;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.examine.ExamineClient;

/**
 * Submits examine info to the api
 *
 * @author Adam
 */
@PluginDescriptor(
	name = "Examine",
	description = "Send examine information to the API",
	tags = {"npcs", "items", "inventory", "objects"}
)
@Slf4j
public class ExaminePlugin extends Plugin
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;

	private final ExamineClient examineClient = new ExamineClient();
	private final Deque<PendingExamine> pending = new ArrayDeque<>();
	private final Cache<CacheKey, Boolean> cache = CacheBuilder.newBuilder()
		.maximumSize(128L)
		.build();

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ScheduledExecutorService executor;


	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		pending.clear();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!event.getMenuOption().equals("Examine"))
		{
			return;
		}

		ExamineType type;
		int id;
		switch (event.getMenuAction())
		{
			case EXAMINE_ITEM:
				type = ExamineType.ITEM;
				id = event.getId();
				break;
			case EXAMINE_ITEM_BANK_EQ:
				type = ExamineType.ITEM_BANK_EQ;
				id = event.getId();
				break;
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				id = event.getId();
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				id = event.getId();
				break;
			default:
				return;
		}

		PendingExamine pendingExamine = new PendingExamine();
		pendingExamine.setWidgetId(event.getWidgetId());
		pendingExamine.setActionParam(event.getActionParam());
		pendingExamine.setType(type);
		pendingExamine.setId(id);
		pendingExamine.setCreated(Instant.now());
		pending.push(pendingExamine);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		ExamineType type;
		switch (event.getType())
		{
			case EXAMINE_ITEM:
				type = ExamineType.ITEM;
				break;
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				break;
			case SERVER:
				type = ExamineType.ITEM_BANK_EQ;
				break;
			default:
				return;
		}

		if (pending.isEmpty())
		{
			log.debug("Got examine without a pending examine?");
			return;
		}

		PendingExamine pendingExamine = pending.pop();

		if (pendingExamine.getType() != type)
		{
			log.debug("Type mismatch for pending examine: {} != {}", pendingExamine.getType(), type);
			pending.clear(); // eh
			return;
		}

		log.debug("Got examine for {} {}: {}", pendingExamine.getType(), pendingExamine.getId(), event.getMessage());

		findExamineItem(pendingExamine);
		CacheKey key = new CacheKey(type, pendingExamine.getId());
		Boolean cached = cache.getIfPresent(key);
		if (cached != null)
		{
			return;
		}

		cache.put(key, Boolean.TRUE);
		submitExamine(pendingExamine, event.getMessage());
	}

	private void findExamineItem(PendingExamine pendingExamine)
	{
		int quantity = 1;
		int itemId = -1;

		// Get widget
		int widgetId = pendingExamine.getWidgetId();
		int widgetGroup = TO_GROUP(widgetId);
		int widgetChild = TO_CHILD(widgetId);
		Widget widget = client.getWidget(widgetGroup, widgetChild);

		if (widget == null)
		{
			return;
		}

		if (pendingExamine.getType() == ExamineType.ITEM)
		{
			WidgetItem widgetItem = widget.getWidgetItem(pendingExamine.getActionParam());
			quantity = widgetItem != null ? widgetItem.getQuantity() : 1;
			itemId = pendingExamine.getId();
		}
		else if (pendingExamine.getType() == ExamineType.ITEM_BANK_EQ)
		{
			if (WidgetInfo.EQUIPMENT.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(1);
				if (widgetItem != null)
				{
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.SMITHING_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(2);
				if (widgetItem != null)
				{
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup
					|| WidgetInfo.RUNE_POUCH_ITEM_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget widgetItem = widget.getChild(pendingExamine.getActionParam());
				if (widgetItem != null)
				{
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget[] children = widget.getDynamicChildren();
				if (pendingExamine.getActionParam() < children.length)
				{
					Widget widgetItem = children[pendingExamine.getActionParam()];
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.SHOP_ITEMS_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget[] children = widget.getDynamicChildren();
				if (pendingExamine.getActionParam() < children.length)
				{
					Widget widgetItem = children[pendingExamine.getActionParam()];
					quantity = 1;
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.CLUE_SCROLL_REWARD_ITEM_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget[] children = widget.getDynamicChildren();
				if (pendingExamine.getActionParam() < children.length)
				{
					Widget widgetItem = children[pendingExamine.getActionParam()];
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
			else if (WidgetInfo.LOOTING_BAG_CONTAINER.getGroupId() == widgetGroup)
			{
				Widget[] children = widget.getDynamicChildren();
				if (pendingExamine.getActionParam() < children.length)
				{
					Widget widgetItem = children[pendingExamine.getActionParam()];
					quantity = widgetItem.getItemQuantity();
					itemId = widgetItem.getItemId();
				}
			}
		}

		if (itemId == -1)
		{
			return;
		}

		final int itemQuantity = quantity;
		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);

		if (itemComposition != null)
		{
			final int id = itemManager.canonicalize(itemComposition.getId());
			executor.submit(() -> getItemPrice(id, itemComposition, itemQuantity));
		}
	}

	private void getItemPrice(int id, ItemComposition itemComposition, int quantity)
	{
		// quantity is at least 1
		quantity = Math.max(1, quantity);
		int itemCompositionPrice = itemComposition.getPrice();
		final int gePrice = itemManager.getItemPrice(id);
		final int alchPrice = itemCompositionPrice <= 0 ? 0 : Math.round(itemCompositionPrice * HIGH_ALCHEMY_CONSTANT);

		if (gePrice > 0 || alchPrice > 0)
		{
			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT);

			if (quantity > 1)
			{
				message
					.append(StackFormatter.formatNumber(quantity))
					.append(" x ");
			}

			message
				.append(itemComposition.getName())
				.append(ChatColorType.NORMAL)
				.append(":");

			if (gePrice > 0)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" GE average ")
					.append(ChatColorType.HIGHLIGHT)
					.append(StackFormatter.formatNumber(gePrice * quantity));

				if (quantity > 1)
				{
					message
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
						.append(StackFormatter.formatNumber(gePrice))
						.append(ChatColorType.NORMAL)
						.append("ea)");
				}
			}

			if (alchPrice > 0)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" HA value ")
					.append(ChatColorType.HIGHLIGHT)
					.append(StackFormatter.formatNumber(alchPrice * quantity));

				if (quantity > 1)
				{
					message
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
						.append(StackFormatter.formatNumber(alchPrice))
						.append(ChatColorType.NORMAL)
						.append("ea)");
				}
			}

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.EXAMINE_ITEM)
				.runeLiteFormattedMessage(message.build())
				.build());
		}
	}

	private void submitExamine(PendingExamine examine, String text)
	{
		int id = examine.getId();

		switch (examine.getType())
		{
			case ITEM:
				examineClient.submitItem(id, text);
				break;
			case OBJECT:
				examineClient.submitObject(id, text);
				break;
			case NPC:
				examineClient.submitNpc(id, text);
				break;
		}
	}

}
