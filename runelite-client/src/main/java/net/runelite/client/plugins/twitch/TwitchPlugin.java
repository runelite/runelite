/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.twitch;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.awt.Color;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.SetMessage;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.ChatboxInputListener;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.PrivateMessageInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.twitch.irc.TwitchIRCClient;
import net.runelite.client.plugins.twitch.irc.TwitchListener;
import net.runelite.client.task.Schedule;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Twitch",
	description = "Twitch integration for RuneLite",
	tags = {"twitch", "stream", "streaming"},
	enabledByDefault = false
)
@Slf4j
public class TwitchPlugin extends Plugin implements TwitchListener, ChatboxInputListener
{
	@Inject
	private TwitchConfig twitchConfig;

	@Inject
	private ChatColorConfig chatColorConfig;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private CommandManager commandManager;

	private TwitchIRCClient twitchIRCClient;

	private Color chatColor;

	@Override
	protected void startUp()
	{
		connect();
		commandManager.register(this);
	}

	@Override
	protected void shutDown()
	{
		if (twitchIRCClient != null)
		{
			twitchIRCClient.close();
			twitchIRCClient = null;
		}

		commandManager.unregister(this);
	}

	@Provides
	TwitchConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TwitchConfig.class);
	}

	/**
	 * Checks to see if the user has entered in the appropriate
	 * information for RuneLite's Twitch plugin to connect to
	 * Specified Twitch stream
	 *
	 * @return boolean;
	 * True: PluginConfig contains an instance of Username and OAuth
	 * False: PluginConfig doesn't contain either, or
	 */
	private boolean isReady()
	{
		if (twitchConfig.username() != null
			&& !twitchConfig.username().isEmpty()
			&& twitchConfig.oauthToken() != null
			&& !twitchConfig.oauthToken().isEmpty()
			&& twitchConfig.channel() != null
			&& !twitchConfig.channel().isEmpty())
		{
			return true;
		}
		return false;
	}

	private void connect()
	{
		if (isReady())
		{
			String channel = twitchConfig.channel().toLowerCase();
			if (!channel.startsWith("#"))
			{
				channel = "#" + channel;
			}

			twitchIRCClient = new TwitchIRCClient(
				this,
				twitchConfig.username(),
				twitchConfig.oauthToken(),
				channel
			);
			twitchIRCClient.start();
		}
	}

	@Schedule(period = 30, unit = ChronoUnit.SECONDS, asynchronous = true)
	public void checkClient()
	{
		if (twitchIRCClient != null)
		{
			if (twitchIRCClient.isConnected())
			{
				twitchIRCClient.pingCheck();
			}

			if (!twitchIRCClient.isConnected())
			{
				log.debug("Reconnecting...");

				connect();
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("twitch") && !configChanged.getGroup().equals("textrecolor"))
		{
			return;
		}

		if (twitchIRCClient != null)
		{
			twitchIRCClient.close();
			twitchIRCClient = null;
		}

		connect();
	}

	@Subscribe
	public void onSetMessage(SetMessage setMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (setMessage.getType() == ChatMessageType.TWITCH && setMessage.getMessageNode().getSender().contains("Twitch"))
		{
			beautifyTwitchMessage(setMessage);
		}
	}

	private void beautifyTwitchMessage(final SetMessage message)
	{
		StringBuilder sb = new StringBuilder();

		//System.out.println(message.getMessageNode().getRuneLiteFormatMessage());

		// TODO: Make the Sender (Twitch) text purple
		String senderInfo = constructBadgeIcons(message.getMessageNode().getName());

		sb.append(message.getMessageNode().getValue().replaceAll("<colNORMAL>", ColorUtil.colorTag(chatColor)));
		//sb.insert(sb.length(), "</col>");

		message.getMessageNode().setSender("<col=8e00ba>" + message.getMessageNode().getSender() + "</col>");
		message.getMessageNode().setName(senderInfo);
		message.getMessageNode().setValue(sb.toString());

		//client.refreshChat();
	}

	private void repaintChat()
	{
		// All messages
		Widget messages = client.getWidget(162, 58);

		for (Widget message : messages.getDynamicChildren())
		{
			if (message.getText().contains("<col=7f0000>"))
			{
				//C1
				System.out.println("DEBUG 1: " + message.getText());

				StringBuilder sb = new StringBuilder(message.getText().replaceAll("<col=7f0000>", ""));
				sb.insert(0, ColorUtil.colorTag(chatColor));

				message.setText(sb.toString());
				System.out.println("DEBUG 2: " + message.getText());
				//message.revalidate();
			}

		}

	}

	/**
	 * @author JBerben
	 *
	 * Constructs a formatted message displaying the senders
	 * color, name and all appropriate badges. Hopefully in the
	 * future, we can add "TWITCH" as a ChatMessageType enum into
	 * RuneLite's api. I'm not sure if it's allowed or not.
	 *
	 * Examples of params
	 * 	badgeString: swagtwitchuser:f70000:subscriber/1,moderator/1
	 *				 TWITCH-USER	COLOR	BADGE/RANK,BADGE2/RANK
	 *
	 * @param badgeString a string containing all the information
	 *                    required in order to display the sender's
	 *                    user handle, color and relevant Twitch badges.
	 *
	 * @return returns a formatted string that will be ready to send.
	 * 			Examples:
	 *
	 * 	This is one clan chat message. First is cc motd, rank, senderName.
	 * 	Second is the actual content of the message.
	 * 	1st: OriginalX: 3, OriginalWidth: 486
	 * 	2nd: OriginalX: 133, OriginalWidth: Dependant on message length.
	 *	[<col=0000ff>Mining <img=20></col>] AustinDies:
	 *	<col=7f0000>Or uhh 6, that is</col>
	 *
	 * 	This is what a fully constructed user badge handle would look like:
	 *	Broadcaster>Mod>Sub>Turbo>Prime>BitCheer(Not currently supported) | Hierarchy
	 *	<col=SENDERCOLOR><img=7><img=25>SENDERNAME</col>
	 *	COLOR_OF_SENDER | SUB6 | PRIME | USER_NAME
	 */
	static String constructBadgeIcons(String badgeString)
	{
		StringBuilder sb = new StringBuilder();

		//DEBUG
		System.out.println(badgeString);

		String senderName = badgeString.split(":")[0];
		String senderColor = badgeString.split(":")[1];
		String badges = badgeString.split(":")[2];

		int senderSubRank = TwitchBadges.getCodeGivenRank("subscriber", getSubRank(badges)).getImgCode();

		/** Create the badge string **/
		// TODO: Enable bit cheer badges
		sb.append("<col=" + senderColor + ">");
		if (isBroadcaster(badges))
		{
			sb.append("<img=" + TwitchBadges.getCodeGivenRank("broadcaster", 1).getImgCode() + ">");
		}
		if (isModerator(badges))
		{
			sb.append("<img=" + TwitchBadges.getCodeGivenRank("moderator", 1).getImgCode() + ">");
		}
		if (senderSubRank != 0)
		{
			sb.append("<img=" + senderSubRank + ">");
		}
		if (isTurbo(badges))
		{
			sb.append("<img=" + TwitchBadges.getCodeGivenRank("turbo", 1).getImgCode() + ">");
		}
		if (isPrime(badges))
		{
			sb.append("<img=" + TwitchBadges.getCodeGivenRank("prime", 1).getImgCode() + ">");
		}
		sb.append(senderName + "</col>");
		System.out.println("Constructed Badge Message: " + sb.toString());
		return sb.toString();
	}

	static int getSubRank(String badgeString)
	{
		if (isSubscriber(badgeString))
		{
			for (String token : badgeString.split(","))
			{
				if (token.contains("subscriber"))
				{
					return Integer.valueOf(token.split("/")[1]);
				}
			}
		}
		// Not a subscriber.
		return 0;
	}

	/** boolean functions to assist code readability **/
	static boolean isSubscriber(String badgeString)
	{
		if (badgeString.contains("subscriber"))
		{
			return true;
		}
		return false;
	}

	static boolean isModerator(String badgeString)
	{
		if (badgeString.contains("moderator"))
		{
			return true;
		}
		return false;
	}

	static boolean isBroadcaster(String badgeString)
	{
		if (badgeString.contains("broadcaster"))
		{
			return true;
		}
		return false;
	}

	static boolean isTurbo(String badgeString)
	{
		if (badgeString.contains("turbo"))
		{
			return true;
		}
		return false;
	}

	static boolean isPrime(String badgeString)
	{
		if (badgeString.contains("prime"))
		{
			return true;
		}
		return false;
	}


	/**
	 * ClanChatMessage Configs:
	 * sender: cc motd
	 * name: sender of the message
	 * runeLiteFormattedMessage: message content formatted to the right length in chat
	 */
	private void addTwitchChatMessage(String sender, String senderColor, String badges, String message)
	{
		// Sets twitch chat message color according to whether client is resizeable mode or not
		boolean transparent = client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1;
		chatColor = (transparent ? chatColorConfig.opaqueTwitchChatColor()
				: chatColorConfig.transparentTwitchChatColor());

		/**
		 * Creates a message with certain color
		 * and content
		 */
		String messageData = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(message)
				.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.TWITCH)
			.sender("Twitch")
			.name(sender + ":" + senderColor + ":" + badges) // Parse this in onSetMessageListener
			.runeLiteFormattedMessage(messageData) // The color (currently red) will be changed as name will be
			.build());
	}

	private void addChatMessage(String sender, String message)
	{
		String chatMessage = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append(message)
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CLANCHAT)
			.sender("Twitch")
			.name(sender)
			.runeLiteFormattedMessage(chatMessage)
			.build());
	}

	/**
	 * Overrides TwitchListener's privmsg(), allowing this class
	 * to listen in for a "privmsg", which is a message sent in the
	 * chatroom.
	 *
	 * @param tags: HashMap<String parameter, String description>();
	 *            Examples: https://dev.twitch.tv/docs/irc/tags/
	 * @param message: Content of sent message
	 */
	@Override
	public void privmsg(Map<String, String> tags, String message)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// Name of message sender
		String displayName = tags.get("display-name");

		// Color of message sender's name
		String color = ((tags.get("color").isEmpty()
						|| tags.get("color").length() == 0) ? "000000" : tags.get("color").substring(1));


		// Badges of sender
		String badges = ((tags.get("badges").isEmpty()
				|| tags.get("badges").length() == 0) ? "none" : tags.get("badges"));

		// Sends message to the queue of ChatMessageManager
		// OLD: addChatMessage(displayName, color, message);
		addTwitchChatMessage(displayName, color, badges, message);
	}

	@Override
	public void roomstate(Map<String, String> tags)
	{
		log.debug("Room state: {}", tags);
	}

	@Override
	public void usernotice(Map<String, String> tags, String message)
	{
		log.debug("Usernotice tags: {} message: {}", tags, message);

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		String sysmsg = tags.get("system-msg");
		addChatMessage("[System]", sysmsg);
	}

	@Override
	public boolean onChatboxInput(ChatboxInput chatboxInput)
	{
		String message = chatboxInput.getValue();
		if (message.startsWith("//"))
		{
			message = message.substring(2);
			if (message.isEmpty() || twitchIRCClient == null)
			{
				return true;
			}

			twitchIRCClient.privmsg(message);
			addChatMessage(twitchConfig.username(), message);

			return true;
		}
		return false;
	}

	@Override
	public boolean onPrivateMessageInput(PrivateMessageInput privateMessageInput)
	{
		return false;
	}
}
