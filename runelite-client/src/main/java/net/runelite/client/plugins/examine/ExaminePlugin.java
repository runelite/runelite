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
import io.reactivex.schedulers.Schedulers;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_CHILD;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.examine.ExamineClient;
import net.runelite.http.api.osbuddy.OSBGrandExchangeClient;

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
@Singleton
public class ExaminePlugin extends Plugin
{
	private static final Pattern X_PATTERN = Pattern.compile("^\\d+ x ");

	private final Deque<PendingExamine> pending = new ArrayDeque<>();
	private final OSBGrandExchangeClient CLIENT = new OSBGrandExchangeClient();
	private final Cache<CacheKey, Boolean> cache = CacheBuilder.newBuilder()
		.maximumSize(128L)
		.build();

	@Inject
	private ExamineClient examineClient;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private EventBus eventBus;

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		pending.clear();
	}

	void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!event.getOption().equals("Examine"))
		{
			return;
		}

		ExamineType type;
		int id, quantity = -1;
		switch (event.getMenuAction())
		{
			case EXAMINE_ITEM:
			{
				type = ExamineType.ITEM;
				id = event.getIdentifier();

				int widgetId = event.getActionParam1();
				int widgetGroup = TO_GROUP(widgetId);
				int widgetChild = TO_CHILD(widgetId);
				Widget widget = client.getWidget(widgetGroup, widgetChild);
				WidgetItem widgetItem = widget.getWidgetItem(event.getActionParam0());
				quantity = widgetItem != null && widgetItem.getId() >= 0 ? widgetItem.getQuantity() : 1;
				break;
			}
			case EXAMINE_ITEM_BANK_EQ:
			{
				type = ExamineType.ITEM_BANK_EQ;
				int[] qi = findItemFromWidget(event.getActionParam1(), event.getActionParam0());
				if (qi == null)
				{
					log.debug("Examine for item with unknown widget: {}", event);
					return;
				}
				quantity = qi[0];
				id = qi[1];
				break;
			}
			case EXAMINE_OBJECT:
				type = ExamineType.OBJECT;
				id = event.getIdentifier();
				break;
			case EXAMINE_NPC:
				type = ExamineType.NPC;
				id = event.getIdentifier();
				break;
			default:
				return;
		}

		PendingExamine pendingExamine = new PendingExamine();
		pendingExamine.setType(type);
		pendingExamine.setId(id);
		pendingExamine.setQuantity(quantity);
		pendingExamine.setCreated(Instant.now());
		pending.push(pendingExamine);
	}

	void onChatMessage(ChatMessage event)
	{
		ExamineType type;
		switch (event.getType())
		{
			case ITEM_EXAMINE:
				type = ExamineType.ITEM;
				break;
			case OBJECT_EXAMINE:
				type = ExamineType.OBJECT;
				break;
			case NPC_EXAMINE:
				type = ExamineType.NPC;
				break;
			case GAMEMESSAGE:
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

		// If it is an item, show the price of it
		final ItemDefinition Itemdefinition;
		if (pendingExamine.getType() == ExamineType.ITEM || pendingExamine.getType() == ExamineType.ITEM_BANK_EQ)
		{
			final int itemId = pendingExamine.getId();
			final int itemQuantity = pendingExamine.getQuantity();
			Itemdefinition = itemManager.getItemDefinition(itemId);

			if (Itemdefinition != null)
			{
				final int id = itemManager.canonicalize(Itemdefinition.getId());
				executor.submit(() -> getItemPrice(id, Itemdefinition, itemQuantity));
			}
		}
		else
		{
			Itemdefinition = null;
		}

		// Don't submit examine info for tradeable items, which we already have from the RS item api
		if (Itemdefinition != null && Itemdefinition.isTradeable())
		{
			return;
		}

		// Large quantities of items show eg. 100000 x Coins
		if (type == ExamineType.ITEM && X_PATTERN.matcher(event.getMessage()).lookingAt())
		{
			return;
		}

		CacheKey key = new CacheKey(type, pendingExamine.getId());
		Boolean cached = cache.getIfPresent(key);
		if (cached != null)
		{
			return;
		}

		cache.put(key, Boolean.TRUE);
		submitExamine(pendingExamine, event.getMessage());
	}

	private int[] findItemFromWidget(int widgetId, int actionParam)
	{
		int widgetGroup = TO_GROUP(widgetId);
		int widgetChild = TO_CHILD(widgetId);
		Widget widget = client.getWidget(widgetGroup, widgetChild);

		if (widget == null)
		{
			return null;
		}

		if (WidgetInfo.EQUIPMENT.getGroupId() == widgetGroup)
		{
			Widget widgetItem = widget.getChild(1);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.SMITHING_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget widgetItem = widget.getChild(2);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.getGroupId() == widgetGroup
			|| WidgetInfo.RUNE_POUCH_ITEM_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget widgetItem = widget.getChild(actionParam);
			if (widgetItem != null)
			{
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.BANK_ITEM_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget[] children = widget.getDynamicChildren();
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.SHOP_ITEMS_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget[] children = widget.getDynamicChildren();
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{1, widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.CLUE_SCROLL_REWARD_ITEM_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget[] children = widget.getDynamicChildren();
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}
		else if (WidgetInfo.LOOTING_BAG_CONTAINER.getGroupId() == widgetGroup)
		{
			Widget[] children = widget.getDynamicChildren();
			if (actionParam < children.length)
			{
				Widget widgetItem = children[actionParam];
				return new int[]{widgetItem.getItemQuantity(), widgetItem.getItemId()};
			}
		}

		return null;
	}

	private void getItemPrice(int id, ItemDefinition itemComposition, int quantity)
	{
		// quantity is at least 1
		quantity = Math.max(1, quantity);
		int itemCompositionPrice = itemComposition.getPrice();
		final int gePrice = itemManager.getItemPrice(id);
		final int alchPrice = itemCompositionPrice <= 0 ? 0 : itemManager.getAlchValue(itemComposition);

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
				int finalQuantity = quantity;
				CLIENT.lookupItem(id)
					.subscribeOn(Schedulers.single())
					.subscribe(
						(osbresult) ->
							clientThread.invoke(() ->
							{
								message
									.append(ChatColorType.NORMAL)
									.append(" GE  ")
									.append(ChatColorType.HIGHLIGHT)
									.append(StackFormatter.formatNumber(gePrice * finalQuantity));

								if (osbresult != null)
								{
									message
										.append(ChatColorType.NORMAL)
										.append(" OSB  ")
										.append(ChatColorType.HIGHLIGHT)
										.append(StackFormatter.formatNumber(osbresult.getOverall_average() * finalQuantity));
								}

								if (finalQuantity > 1)
								{
									message
										.append(ChatColorType.NORMAL)
										.append(" (")
										.append(ChatColorType.HIGHLIGHT)
										.append(StackFormatter.formatNumber(gePrice))
										.append(ChatColorType.NORMAL)
										.append("ea)");
								}
							}),
						(e) -> log.error(e.toString())
					);
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
				.type(ChatMessageType.ITEM_EXAMINE)
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
