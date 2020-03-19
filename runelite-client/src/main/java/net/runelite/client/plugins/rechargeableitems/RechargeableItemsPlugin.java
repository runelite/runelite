package net.runelite.client.plugins.rechargeableitems;

import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
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

	@Inject
	private Client client;

	private Integer itemId;

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuOption().equalsIgnoreCase("check"))
		{
			this.itemId = event.getId();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() == ChatMessageType.GAMEMESSAGE
			&& stringContainsNumber(chatMessage.getMessage())
			&& itemId != null)
		{
			sendRechargeStatus(chatMessage.getMessage());
		}
	}

	private boolean stringContainsNumber(String string)
	{
		for (int i = 0; i < string.length(); ++i)
		{
			if (Character.isDigit(string.charAt(i)))
			{
				return true;
			}
		}

		return false;
	}

	private void sendRechargeStatus(String message)
	{
		final RechargeableItem rechargeableItem = RechargeableItemFactory.createRechargeableItem(itemId, client);

		if (rechargeableItem != null)
		{
			final String rechargeMessage = rechargeableItem.getRechargeMessage(message);
			sendChatMessage(rechargeMessage);
		}
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
