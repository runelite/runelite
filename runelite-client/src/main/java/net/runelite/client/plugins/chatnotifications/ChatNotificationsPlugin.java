package net.runelite.client.plugins.chatnotifications;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@PluginDescriptor(
		name = "Chat Notifications",
		enabledByDefault = false
)
@Slf4j
public class ChatNotificationsPlugin extends Plugin
{
	final static String DUAL_REQ_NOTIF = "has received a dual request";
	final static String TRADE_REQ_NOTIF = "has received a trade request";
	@Provides
	ChatNotificationsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatNotificationsConfig.class);
	}

	@Inject
	private ChatNotificationsConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	Client client;

	@Subscribe
	public void onChatMessage(ChatMessage message)
	{
		Player player = client.getLocalPlayer();
		final String characterPrefix = "[" + player.getName() + "] ";

		if (config.dualNotifEnabled() && message.getType() == ChatMessageType.DUEL_RECEIVED)
		{
			notifier.notify(characterPrefix + DUAL_REQ_NOTIF);
		}

		if (config.tradeNotifEnabled() && message.getType() == ChatMessageType.TRADE_RECEIVED)
		{
			notifier.notify(characterPrefix + TRADE_REQ_NOTIF);
		}
	}
}
