package net.runelite.client.plugins.textrecolor;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.chat.ChatColor;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;
import java.awt.*;

@PluginDescriptor(
	name = "Chat Text Recolor",
	enabledByDefault = false
)
public class TextRecolorPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private TextRecolorConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private boolean isChatboxTransparent = false;

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOGIN_SCREEN:
			case LOGGING_IN:
				cacheConfiguredColors();
			case LOGGED_IN:
				chatMessageManager.refreshAll();
				break;
		}
	}

	@Provides
	TextRecolorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TextRecolorConfig.class);
	}

	public void checkChatboxState()
	{
		isChatboxTransparent = client.isResized() && client.getVarbitValue(Varbits.TRANSPARENT_CHATBOX.getId()) == 1;
	}


	@Subscribe
	public void onVarbitsChanged(VarbitChanged event)
	{
		checkChatboxState();
	}


	@Subscribe
	public void onResizeableChanged(ResizeableChanged event)
	{
		checkChatboxState();
		chatMessageManager.refreshAll();
	}


	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final ChatMessageBuilder messageBuilder = new ChatMessageBuilder();
		final ChatMessageBuilder usernameBuilder = new ChatMessageBuilder();
		final ChatMessageBuilder clanChannelBuilder = new ChatMessageBuilder();

		MessageNode messageNode = setMessage.getMessageNode();

		//Username Colouring
		if (setMessage.getName() != "")
		{
			switch (setMessage.getType())
			{
				case PRIVATE_MESSAGE_RECEIVED_MOD:
				case PRIVATE_MESSAGE_RECEIVED:
				case PRIVATE_MESSAGE_SENT:
					usernameBuilder.append(wrapTextWithColour(setMessage.getName(),
						isChatboxTransparent ? config.transparentPrivateUsernames() : config.opaquePrivateUsernames()));
					break;

				case TRADE:
				case AUTOCHAT:
				case PUBLIC:
					usernameBuilder.append(wrapTextWithColour(setMessage.getName(),
						isChatboxTransparent ? config.transparentUsername() : config.opaqueUsername()));
					break;
				case CLANCHAT:
					usernameBuilder.append(wrapTextWithColour(setMessage.getName(),
						isChatboxTransparent ? config.transparentClanUsernames() : config.opaqueClanUsernames()));
					break;

				default:
					usernameBuilder.append(setMessage.getName());
					break;
			}

			messageNode.setName(usernameBuilder.build());
		}

		//Clan Channel Name Recolour
		if (setMessage.getSender() != "")
		{
			clanChannelBuilder.append(wrapTextWithColour(setMessage.getSender(),
				isChatboxTransparent ? config.transparentClanChannelName() : config.opaqueClanChannelName()));

			messageNode.setSender(clanChannelBuilder.build());
		}

		String message = setMessage.getValue();

		if (message.contains("<br>"))
		{
			String[] lines = message.split("<br>");

			for (int i = 0; i < lines.length; i++)
			{
				if (i > 0)
				{
					messageBuilder.append("<br>");
				}
				messageBuilder.append(ChatColorType.NORMAL).append(lines[i]);
			}
		}
		else
		{
			messageBuilder.append(ChatColorType.NORMAL).append(message);
		}

		messageNode.setRuneLiteFormatMessage(messageBuilder.build());
		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	private String wrapTextWithColour(String text, Color colour)
	{
		return "<col=" + Integer.toHexString(colour.getRGB() & 0xFFFFFF) + ">" + text + "</col>";
	}
	@Override
	protected void startUp()
	{
		cacheConfiguredColors();
		chatMessageManager.refreshAll();
	}

	@Override
	protected void shutDown()
	{
		chatMessageManager.refreshAll();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("textrecolor"))
		{
			cacheConfiguredColors();
		}
		chatMessageManager.refreshAll();
	}

	private void cacheConfiguredColors()
	{
		chatMessageManager
			//Opaque Chat Colours
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaquePublicChat(), false),
				ChatMessageType.PUBLIC)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaquePublicChatHighlight(), false),
				ChatMessageType.PUBLIC)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaquePrivateMessageSent(), false),
				ChatMessageType.PRIVATE_MESSAGE_SENT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaquePrivateMessageSentHighlight(), false),
				ChatMessageType.PRIVATE_MESSAGE_SENT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaquePrivateMessageReceived(), false),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaquePrivateMessageReceivedHighlight(), false),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueClanChatInfo(), false),
				ChatMessageType.CLANCHAT_INFO)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueClanChatMessage(), false),
				ChatMessageType.CLANCHAT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueClanChatMessageHighlight(), false),
				ChatMessageType.CLANCHAT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueAutochatMessage(), false),
				ChatMessageType.AUTOCHAT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueAutochatMessageHighlight(), false),
				ChatMessageType.AUTOCHAT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueTradeChatMessage(), false),
				ChatMessageType.TRADE)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueTradeChatMessageHighlight(), false),
				ChatMessageType.TRADE)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueServerMessage(), false),
				ChatMessageType.SERVER)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueServerMessageHighlight(), false),
				ChatMessageType.SERVER)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueGameMessage(), false),
				ChatMessageType.GAME)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueGameMessageHighlight(), false),
				ChatMessageType.GAME)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueExamine(), false),
				ChatMessageType.EXAMINE_OBJECT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_OBJECT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueExamine(), false),
				ChatMessageType.EXAMINE_NPC)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_NPC)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueExamine(), false),
				ChatMessageType.EXAMINE_ITEM)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueExamineHighlight(), false),
				ChatMessageType.EXAMINE_ITEM)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.opaqueFiltered(), false),
				ChatMessageType.FILTERED)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.opaqueFilteredHighlight(), false),
				ChatMessageType.FILTERED)
			//Transparent Chat Colours
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentPublicChat(), true),
				ChatMessageType.PUBLIC)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentPublicChatHighlight(), true),
				ChatMessageType.PUBLIC)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentPrivateMessageSent(), true),
				ChatMessageType.PRIVATE_MESSAGE_SENT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentPrivateMessageSentHighlight(), true),
				ChatMessageType.PRIVATE_MESSAGE_SENT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentPrivateMessageReceived(), true),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentPrivateMessageReceivedHighlight(), true),
				ChatMessageType.PRIVATE_MESSAGE_RECEIVED)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentClanChatInfo(), true),
				ChatMessageType.CLANCHAT_INFO)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentClanChatMessage(), true),
				ChatMessageType.CLANCHAT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentClanChatMessageHighlight(), true),
				ChatMessageType.CLANCHAT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentAutochatMessage(), true),
				ChatMessageType.AUTOCHAT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentAutochatMessageHighlight(), true),
				ChatMessageType.AUTOCHAT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentTradeChatMessage(), true),
				ChatMessageType.TRADE)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentTradeChatMessageHighlight(), true),
				ChatMessageType.TRADE)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentServerMessage(), true),
				ChatMessageType.SERVER)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentServerMessageHighlight(), true),
				ChatMessageType.SERVER)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentGameMessage(), true),
				ChatMessageType.GAME)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentGameMessageHighlight(), true),
				ChatMessageType.GAME)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentExamine(), true),
				ChatMessageType.EXAMINE_OBJECT)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_OBJECT)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentExamine(), true),
				ChatMessageType.EXAMINE_NPC)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_NPC)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentExamine(), true),
				ChatMessageType.EXAMINE_ITEM)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentExamineHighlight(), true),
				ChatMessageType.EXAMINE_ITEM)
			.cacheColor(new ChatColor(ChatColorType.NORMAL, config.transparentFiltered(), true),
				ChatMessageType.FILTERED)
			.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, config.transparentFilteredHighlight(), true),
				ChatMessageType.FILTERED);
	}
}
