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

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.QuantityFormatter;

@PluginDescriptor(
	name = "Examine",
	description = "Shows additional examine information (eg. GE Average, HA Value)",
	tags = {"npcs", "items", "inventory", "objects", "prices", "high alchemy"}
)
@Slf4j
public class ExaminePlugin extends Plugin
{
	private final Deque<PendingExamine> pending = new ArrayDeque<>();

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

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

		final ChatMessageType type;
		int id, quantity = -1;
		switch (event.getMenuAction())
		{
			case EXAMINE_ITEM_GROUND:
				type = ChatMessageType.ITEM_EXAMINE;
				id = event.getId();
				break;
			case CC_OP_LOW_PRIORITY:
			{
				type = ChatMessageType.ITEM_EXAMINE; // these are spoofed by us from a [proc,examine_item] script edit
				int[] qi = findItemFromWidget(event.getParam1(), event.getParam0());
				if (qi == null)
				{
					log.debug("Examine for item with unknown widget: {}", event);
					return;
				}
				quantity = qi[0];
				id = qi[1];
				break;
			}
			default:
				return;
		}

		PendingExamine pendingExamine = new PendingExamine();
		pendingExamine.setResponseType(type);
		pendingExamine.setId(id);
		pendingExamine.setQuantity(quantity);
		pending.push(pendingExamine);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (pending.isEmpty())
		{
			return;
		}

		PendingExamine pendingExamine = pending.peek();
		if (pendingExamine.getResponseType() != event.getType())
		{
			log.debug("Type mismatch for pending examine: {} != {}", pendingExamine.getResponseType(), event.getType());
			return;
		}
		pending.pop();

		log.debug("Got examine type {} {}: {}", pendingExamine.getResponseType(), pendingExamine.getId(), event.getMessage());

		final int itemId = pendingExamine.getId();
		final int itemQuantity = pendingExamine.getQuantity();

		if (itemId == ItemID.COINS)
		{
			return;
		}

		final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
		getItemPrice(itemComposition.getId(), itemComposition, itemQuantity);
	}

	private int[] findItemFromWidget(int widgetId, int childIdx)
	{
		final int widgetGroup = WidgetUtil.componentToInterface(widgetId);
		final Widget widget = client.getWidget(widgetId);
		if (widget == null)
		{
			return null;
		}

		if (InterfaceID.WORNITEMS == widgetGroup)
		{
			Widget widgetItem = widget.getChild(1);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (InterfaceID.SMITHING == widgetGroup)
		{
			Widget widgetItem = widget.getChild(2);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (InterfaceID.SHOPMAIN == widgetGroup)
		{
			Widget widgetItem = widget.getChild(childIdx);
			if (widgetItem != null)
			{
				return new int[]{1, widgetItem.getItemId()};
			}
		}
		else
		{
			Widget widgetItem = widget.getChild(childIdx);
			if (widgetItem != null && widgetItem.getItemId() > -1)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}

		return null;
	}

	@VisibleForTesting
	void getItemPrice(int id, ItemComposition itemComposition, int quantity)
	{
		// quantity is at least 1
		quantity = Math.max(1, quantity);
		final int gePrice = itemManager.getItemPrice(id);
		final int alchPrice = itemComposition.getHaPrice();

		if (gePrice > 0 || alchPrice > 0)
		{
			final ChatMessageBuilder message = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append("Price of ")
				.append(ChatColorType.HIGHLIGHT);

			if (quantity > 1)
			{
				message
					.append(QuantityFormatter.formatNumber(quantity))
					.append(" x ");
			}

			message
				.append(itemComposition.getMembersName())
				.append(ChatColorType.NORMAL)
				.append(":");

			if (gePrice > 0)
			{
				message
					.append(ChatColorType.NORMAL)
					.append(" GE average ")
					.append(ChatColorType.HIGHLIGHT)
					.append(QuantityFormatter.formatNumber((long) gePrice * quantity));

				if (quantity > 1)
				{
					message
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
						.append(QuantityFormatter.formatNumber(gePrice))
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
					.append(QuantityFormatter.formatNumber((long) alchPrice * quantity));

				if (quantity > 1)
				{
					message
						.append(ChatColorType.NORMAL)
						.append(" (")
						.append(ChatColorType.HIGHLIGHT)
						.append(QuantityFormatter.formatNumber(alchPrice))
						.append(ChatColorType.NORMAL)
						.append("ea)");
				}
			}

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.ITEM_EXAMINE)
				.runeLiteFormattedMessage(message.build())
				.build());
		}
	}
}
