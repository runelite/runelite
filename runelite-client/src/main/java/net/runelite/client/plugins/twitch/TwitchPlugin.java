/*
 * Copyright (c) 2018, William Gray <wgray5093@gmail.com>
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
import javax.inject.Inject;
import net.engio.mbassy.listener.Handler;
import net.runelite.api.ChatMessageType;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.apache.commons.lang3.StringUtils;
import org.kitteh.irc.client.library.Client;
import org.kitteh.irc.client.library.element.User;
import org.kitteh.irc.client.library.event.abstractbase.ActorChannelMessageEventBase;
import org.kitteh.irc.client.library.event.channel.ChannelCtcpEvent;
import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent;
import org.kitteh.irc.client.library.feature.twitch.TwitchDelaySender;
import org.kitteh.irc.client.library.feature.twitch.TwitchListener;
import org.kitteh.irc.client.library.feature.twitch.event.RoomStateEvent;
import org.kitteh.irc.client.library.feature.twitch.event.UserNoticeEvent;
import org.kitteh.irc.client.library.feature.twitch.event.UserStateEvent;

@PluginDescriptor(
	name = "Twitch",
	enabledByDefault = false
)
public class TwitchPlugin extends Plugin
{
	@Inject
	private net.runelite.api.Client client;

	@Inject
	private TwitchConfig config;

	private Client irc;
	private boolean subscribed;
	private boolean mod;
	private boolean broadcaster;
	private boolean subsOnly;
	private boolean emoteOnly;
	private String badges = "";
	private String oColor;
	private String tColor;

	@Provides
	TwitchConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TwitchConfig.class);
	}

	@Override
	protected void startUp()
	{
		twitchShutdown(irc);
		irc = twitchSetup(config.oauthToken(), config.channelName(), config.nickName());
		oColor = Integer.toHexString(config.chatOColor().getRGB() & 0xFFFFFF);
		tColor = Integer.toHexString(config.chatTColor().getRGB() & 0xFFFFFF);
	}

	@Override
	protected void shutDown()
	{
		twitchShutdown(irc);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("twitch"))
		{
			return;
		}

		oColor = Integer.toHexString(config.chatOColor().getRGB() & 0xFFFFFF);
		tColor = Integer.toHexString(config.chatTColor().getRGB() & 0xFFFFFF);

		if (event.getKey().equals("channel") || event.getKey().equals("oauth") || event.getKey().equals("nick"))
		{
			twitchShutdown(irc);
			irc = twitchSetup(config.oauthToken(), config.channelName(), config.nickName());
		}
	}

	private boolean isChatboxTransparent()
	{
		return client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1;
	}

	private Client twitchSetup(String oauth, String nick, String name)
	{
		Client ircClient = Client.builder()
				.serverHost("irc.chat.twitch.tv").serverPort(443)
				.serverPassword(oauth)
				.nick(nick)
				.messageSendingQueueSupplier(TwitchDelaySender.getSupplier(false))
				.build();
		TwitchListener listener = new TwitchListener(ircClient);
		ircClient.getEventManager().registerEventListener(listener);
		ircClient.getEventManager().registerEventListener(this);
		ircClient.connect();
		ircClient.addChannel("#" + name);
		return ircClient;
	}

	//Send messages to twitch chat using command "t"
	@Subscribe
	private void onCommand(CommandExecuted executed)
	{
		if (!client.getGameState().equals(GameState.LOGGED_IN))
		{
			return;
		}

		String[] args = executed.getArguments();
		StringBuilder sb = new StringBuilder();
		String command = executed.getCommand();

		if (command.equalsIgnoreCase("t"))
		{
			for (String arg : args)
			{
				sb.append(arg + " ");
			}

			String message = sb.toString();
			irc.sendMessage("#" + config.nickName(), message);
			//Echos the message back in in-game chat
			if (irc.getChannels().toString().contains("#" + config.nickName()))
			{
				//If the chat is in sub only mode and they are not a subscriber
				if (!subscribed && subsOnly)
				{
					final String subsOnlyMessage = "<col=FF0000>This channel is in Subscriber only mode!</col>";
					sendMessage(subsOnlyMessage, "Notification");
				}
				//If chat is in emote only mode
				else if (emoteOnly && !broadcaster && !mod)
				{
					final String emoteOnlyMessage = "<col=FF0000>This channel is in emote only mode!</col><br><col=FF0000>Function coming soon to a Runelite client near you.</col>";
					sendMessage(emoteOnlyMessage, "Notification");
				}
				else
				{
					sendMessage(message, badges + config.channelName());
				}
			}
		}
	}

	private void sendMessage(String message, String name)
	{
		if (isChatboxTransparent())
		{
			final String transparentMessage = "<col=ffffff></col>[<col=9070ff>Twitch</col>] " +  name + ": <col=" + tColor + ">" + message + "</col>";
			client.addChatMessage(ChatMessageType.TRADE, "", transparentMessage, "");
		}
		else
		{
			final String opaqueMessage = "<col=000000></col>[<col=0000FF>Twitch</col>] " +  name + ": <col=" + oColor + ">" + message + "</col>";
			client.addChatMessage(ChatMessageType.TRADE, "", opaqueMessage, "");
		}
	}

	/**
	 * Shut off current running irc client
	 * @param client
	 */
	private void twitchShutdown(Client client)
	{
		if (client != null)
		{
			client.shutdown();
		}
	}

	/**
	 * Triggers when a message is sent to twitch chat
	 * @param event
	 */
	@Handler
	private void onMessage(ChannelMessageEvent event)
	{
		if (!client.getGameState().equals(GameState.LOGGED_IN))
		{
			return;
		}

		String message = event.getMessage();
		messageBuilder(event, message);
	}

	/**
	 * Triggers when a /me message is sent in twitch chat
	 * Works the same as the onMessage method
	 * @param event
	 */
	@Handler
	private void onMe(ChannelCtcpEvent event)
	{
		if (!client.getGameState().equals(GameState.LOGGED_IN))
		{
			return;
		}

		String message = event.getMessage().replace("ACTION ", "");
		messageBuilder(event, message);
	}

	private void messageBuilder(ActorChannelMessageEventBase<User> event, String message)
	{
		String username = event.getActor().getUserString();
		String badge = event.getOriginalMessages().get(0).getTag("badges").toString();

		//Sub length badges
		//0 months
		if (badge.contains("subscriber/0"))
		{
			username = "<img=9>" + username;
		}
		//3 months
		else if (badge.contains("subscriber/3"))
		{
			username = "<img=8>" + username;
		}
		//6 months
		else if (badge.contains("subscriber/6"))
		{
			username = "<img=7>" + username;
		}
		//12 months
		else if (badge.contains("subscriber/12"))
		{
			username = "<img=6>" + username;
		}
		//24 months
		else if (badge.contains("subscriber/24"))
		{
			username = "<img=5>" + username;
		}
		//48 months
		else if (badge.contains("subscriber/48"))
		{
			username = "<img=4>" + username;
		}

		//Moderator badge
		if (badge.contains("moderator/1"))
		{
			username = "<img=26>" + username;
		}

		//Streamer badge
		if (badge.contains("broadcaster/1"))
		{
			username = "<img=27>" + username;
		}
		sendMessage(message, username);
	}

	/**
	 * User and room information update events
	 * Triggers whenever the user's state is updated or they join a room
	 * @param event
	 */
	@Handler
	private void onUserStateEvent(UserStateEvent event)
	{
		String originalMessage = event.getOriginalMessage().toString();
		badges = "";
		//Finding if the user is a subscriber
		if ((originalMessage.contains("subscriber=1") || originalMessage.contains("mod=1") || originalMessage.contains("value=broadcaster/1")) && StringUtils.containsIgnoreCase(originalMessage, "display-name=" + config.channelName()))
		{
			subscribed = true;
			if (originalMessage.contains("subscriber=1"))
			{
				if (originalMessage.contains("subscriber/0"))
				{
					badges = "<img=9>";
				}
				else if (originalMessage.contains("subscriber/3"))
				{
					badges = "<img=8>";
				}
				else if (originalMessage.contains("subscriber/6"))
				{
					badges = "<img=7>";
				}
				else if (originalMessage.contains("subscriber/12"))
				{
					badges = "<img=6>";
				}
				else if (originalMessage.contains("subscriber/24"))
				{
					badges = "<img=5>";
				}
				else if (originalMessage.contains("subscriber/48"))
				{
					badges = "<img=4>";
				}
			}
		}
		else
		{
			subscribed = false;
		}

		//Finding if the user is a moderator or broadcaster which allows them to talk during emote-only and sub-only while not actually subscribed
		if (originalMessage.contains("mod=1") && originalMessage.toLowerCase().contains("display-name=" + config.channelName()))
		{
			mod = true;
			badges = "<img=26>" + badges;
		}
		else
		{
			mod = false;
		}

		if (originalMessage.contains("value=broadcaster/1") && originalMessage.toLowerCase().contains("display-name=" + config.channelName()))
		{
			broadcaster = true;
			badges = "<img=27>" + badges;
		}
		else
		{
			broadcaster = false;
		}
	}

	/**
	 * Triggers when the room state changes. I.E. Sub mode, slow mode, etc.
	 * @param event
	 */
	@Handler
	private void onRoomStateEvent(RoomStateEvent event)
	{
		String originalMessage = event.getOriginalMessage().toString();
		//Checking if the subs-only state has changed
		subsOnly = originalMessage.contains("subs-only=1");

		//Checking if the emote-only state has changed
		emoteOnly = originalMessage.contains("emote-only=1");
	}

	/**
	 * Triggers when a user subscribes/re-subscribes
	 * @param event
	 */
	@Handler
	private void onUserNoticeEvent(UserNoticeEvent event)
	{
		if (!client.getGameState().equals(GameState.LOGGED_IN) || !config.subNotifs())
		{
			return;
		}

		String newSubMessage;
		String originalMessage = event.getOriginalMessage().toString();
		String[] subMessage = originalMessage.split(";");

		//Fixes and issue where gifted subs say "Notification: msg-param-sub-plan-name=1000" instead of the proper sub message
		if (subMessage[13].contains("msg-param-sub-plan-name="))
		{
			newSubMessage = subMessage[17].replace("\\s", " ").replace("system-msg=", "");
		}
		else
		{
			newSubMessage = subMessage[13].replace("\\s", " ").replace("system-msg=", "");
		}

		//Sends the sub notification
		if (isChatboxTransparent())
		{
			final String transparentMessage = "<col=ffffff></col>[<col=9070ff>Twitch</col>] <col=" + tColor + ">" + newSubMessage + "</col>";
			client.addChatMessage(ChatMessageType.TRADE, "", transparentMessage, "");
		}
		else
		{
			final String opaqueMessage = "<col=000000></col>[<col=0000FF>Twitch</col>] <col=" + oColor + ">" + newSubMessage + "</col>";
			client.addChatMessage(ChatMessageType.TRADE, "", opaqueMessage, "");
		}
	}
}