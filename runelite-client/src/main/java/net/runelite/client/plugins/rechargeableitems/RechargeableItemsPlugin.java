package net.runelite.client.plugins.rechargeableitems;

import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.rechargeableitems.items.RechargeableItem;

@PluginDescriptor(
	name = "Rechargeable Items",
	description = "Show what items are required to fully recharge an item",
	tags = {"notifications", "messages"}
)
public class RechargeableItemsPlugin extends Plugin
{
	@Inject
	private ChatMessageManager chatMessageManager;

	private Integer itemId;

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuOption().equalsIgnoreCase("check"))
		{
			final int itemId = event.getId();

			if (RechargeableItemEnum.containsItem(itemId))
			{
				this.itemId = itemId;
			}
			else
			{
				this.itemId = null;
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() == ChatMessageType.GAMEMESSAGE)
		{
			sendRechargeStatus(chatMessage.getMessage());
		}
	}

	private void sendRechargeStatus(String message)
	{
		if (this.itemId != null)
		{
			final RechargeableItem rechargeableItem = createRechargeableItem(this.itemId);
			rechargeableItem.setupValues(message);
			sendChatMessage(rechargeableItem.getRechargeMessage());
		}
	}

	private RechargeableItem createRechargeableItem(int itemId)
	{
		final RechargeableItemEnum itemEnum = RechargeableItemEnum.getRechargeableItemEnum(itemId);
		return RechargeableItemFactory.createRechargeableItem(itemEnum);
	}

	private void sendChatMessage(String message)
	{
		final String result = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append(message)
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(result)
				.build()
		);
	}
}
