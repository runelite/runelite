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

import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientInt;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.ChatboxInputListener;
import net.runelite.client.chat.CommandManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.PrivateMessageInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.twitch.irc.TwitchIRCClient;
import net.runelite.client.plugins.twitch.irc.TwitchListener;
import net.runelite.client.task.Schedule;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import java.awt.Color;
import net.runelite.client.callback.ClientThread;

@PluginDescriptor(
	name = "Twitch",
	description = "Integrates Twitch chat",
	enabledByDefault = false
)
@Slf4j
public class TwitchPlugin extends Plugin implements TwitchListener, ChatboxInputListener
{
	private static final Color twitchMenuOpColor = new Color(0x800080);
	private static final Color clanMenuOpColor = new Color(0xFF0000);

	private static final String TWITCH_CHAT_MENUTARGET = ColorUtil.wrapWithColorTag("Twitch chat", twitchMenuOpColor);
	private static final String CLAN_CHAT_MENUTARGET = ColorUtil.wrapWithColorTag("Clan chat", clanMenuOpColor);
	private static final String TWITCH_FILTER_MENUOPTION = ColorUtil.wrapWithColorTag("Twitch:", twitchMenuOpColor);

	private boolean twitchChatSelected = false;
	private boolean twitchChatFilter = false;

	private static final int CLAN_BUTTON_ID = WidgetInfo.CHATBOX_CLAN_BUTTON.getId();

	@Inject
	private TwitchConfig twitchConfig;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private CommandManager commandManager;

	@Inject
	private twitchChatButtonOverlay buttonOverlay;

	@Inject
	private OverlayManager overlayManager;

	private TwitchIRCClient twitchIRCClient;

	Widget clanChatButtonBackground;
	Widget clanChatButtonText;
	Widget clanChatButtonFilterText;

	public boolean getTwitchChatSelected()
	{
		return twitchChatSelected;
	}

	public boolean getTwitchChatFilter()
	{
		return twitchChatFilter;
	}

	@Override
	protected void startUp()
	{
		connect();
		commandManager.register(this);
		overlayManager.add(buttonOverlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(buttonOverlay);

		if (twitchChatSelected)
		{
			twitchChatSelected = false;
			clanChatButtonText.setText("Clan");

			if (client.getVar(VarClientInt.CHAT_PANEL_SELECTED) == 6)
			{
				clientThread.invoke(() -> client.runScript(ScriptID.CHAT_BUTTON_ONOP, 1, 4));
			}
			else
			{
				clientThread.invoke(() -> client.runScript(178));
			}
		}

			if (twitchIRCClient != null) {
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

	private synchronized void connect()
	{
		if (twitchIRCClient != null)
		{
			log.debug("Terminating Twitch client {}", twitchIRCClient);
			twitchIRCClient.close();
			twitchIRCClient = null;
		}

		if (!Strings.isNullOrEmpty(twitchConfig.username())
			&& !Strings.isNullOrEmpty(twitchConfig.oauthToken())
			&& !Strings.isNullOrEmpty(twitchConfig.channel()))
		{
			String channel = twitchConfig.channel().toLowerCase();
			if (!channel.startsWith("#"))
			{
				channel = "#" + channel;
			}

			log.debug("Connecting to Twitch as {}", twitchConfig.username());

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
		if (!configChanged.getGroup().equals("twitch"))
		{
			return;
		}

		connect();
	}

	private void addChatMessage(String sender, String message)
	{
		if (!twitchChatFilter)
		{
			String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.NORMAL)
				.append(message)
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.TWITCH)
				.sender("Twitch")
				.name(sender)
				.runeLiteFormattedMessage(chatMessage)
				.build());
		}
	}

	@Override
	public void privmsg(Map<String, String> tags, String message)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		String displayName = tags.get("display-name");
		addChatMessage(displayName, message);
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


	@Subscribe
	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getWidgetId() != CLAN_BUTTON_ID)
		{
			return;
		}

		if (!event.getMenuOption().equals("Switch tab") && !event.getMenuOption().equals("Switch:") &&
			!event.getMenuOption().equals(TWITCH_FILTER_MENUOPTION))
		{
			return;
		}

		event.consume();

		clanChatButtonBackground = client.getWidget(WidgetInfo.CHATBOX_CLAN_BUTTON_BACKGROUND);
		clanChatButtonText = client.getWidget(WidgetInfo.CHATBOX_CLAN_BUTTON_TEXT);
		clanChatButtonFilterText = client.getWidget(WidgetInfo.CHATBOX_CLAN_BUTTON_FILTER_TEXT);

		if (event.getMenuOption().equals("Switch tab"))
		{
			if (twitchChatSelected)
			{
				client.runScript(ScriptID.CHAT_BUTTON_ONOP, 1, 6);
				clanChatButtonText.setText("Twitch");
			}
			else
			{
				client.runScript(ScriptID.CHAT_BUTTON_ONOP, 1, 4);
			}
		}
		else if (event.getMenuOption().equals("Switch:"))
		{

			if (event.getMenuTarget().equals(TWITCH_CHAT_MENUTARGET))
			{
				twitchChatSelected = true;
				client.runScript(ScriptID.CHAT_BUTTON_ONOP, 1, 6);
				clanChatButtonText.setText("Twitch");
			}
			else if (event.getMenuTarget().equals(CLAN_CHAT_MENUTARGET))
			{
				twitchChatSelected = false;
				client.runScript(ScriptID.CHAT_BUTTON_ONOP, 1, 4);
				clanChatButtonText.setText("Clan");
			}
		}
		else if (event.getMenuOption().equals(TWITCH_FILTER_MENUOPTION))
		{
			if (event.getMenuTarget().equals("Show all"))
			{
				twitchChatFilter = false;
			}
			else
			{
				twitchChatFilter = true;
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		int widgetIndex = event.getActionParam0();
		int widgetID = event.getActionParam1();
		MenuEntry[] menuEntries = client.getMenuEntries();

		if (widgetID == CLAN_BUTTON_ID && event.getOption().equals("Switch tab"))
		{
			MenuEntry [] newMenu = new MenuEntry[menuEntries.length + 3];
			newMenu[newMenu.length - 1] = menuEntries[menuEntries.length - 1];
			MenuEntry switchOption = newMenu[newMenu.length - 2] = new MenuEntry();
			if (!twitchChatSelected)
			{
				switchOption.setTarget(TWITCH_CHAT_MENUTARGET);
			}
			else
			{
				switchOption.setTarget(CLAN_CHAT_MENUTARGET);
			}
			switchOption.setOption("Switch:");
			switchOption.setParam0(widgetIndex);
			switchOption.setParam1(widgetID);
			switchOption.setIdentifier(event.getIdentifier());
			switchOption.setType(MenuAction.RUNELITE_PRIORITY.getId());
			System.arraycopy(menuEntries, 0, newMenu, 0, 4);
			MenuEntry twitchChatFilterAll = newMenu[5] = new MenuEntry();
			twitchChatFilterAll.setTarget("Show all");
			twitchChatFilterAll.setOption(TWITCH_FILTER_MENUOPTION);
			twitchChatFilterAll.setParam0(widgetIndex);
			twitchChatFilterAll.setParam1(widgetID);
			twitchChatFilterAll.setIdentifier(event.getIdentifier());
			twitchChatFilterAll.setType(MenuAction.RUNELITE_PRIORITY.getId());
			MenuEntry twitchChatFilterOff = newMenu[4] = new MenuEntry();
			twitchChatFilterOff.setTarget("Off");
			twitchChatFilterOff.setOption(TWITCH_FILTER_MENUOPTION);
			twitchChatFilterOff.setParam0(widgetIndex);
			twitchChatFilterOff.setParam1(widgetID);
			twitchChatFilterOff.setIdentifier(event.getIdentifier());
			twitchChatFilterOff.setType(MenuAction.RUNELITE_PRIORITY.getId());

			client.setMenuEntries(newMenu);
		}
	}
}
