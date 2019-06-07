/*
 * Copyright (c) 2019, xperiaclash <https://github.com/xperiaclash>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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
package net.runelite.client.plugins.banlist;

import com.google.inject.Provides;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import api.ChatMessageType;
import api.ClanMember;
import api.Client;
import api.GameState;
import api.events.ClanMemberJoined;
import api.events.ConfigChanged;
import api.events.WidgetHiddenChanged;
import api.events.WidgetLoaded;
import api.widgets.Widget;
import api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.Text;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

@PluginDescriptor(
		name = "Ban List",
		description = "Displays warning in chat when you join a" +
				"clan chat/new member join your clan chat and he is in a WDR/RuneWatch/Manual List",
		tags = {"PVM", "WDR", "RuneWatch"},
		type = PluginType.UTILITY
)
@Slf4j
public class BanListPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private BanListConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private ArrayList<String> wdrArrayList = new ArrayList<>();
	private ArrayList<String> runeWatchArrayList = new ArrayList<>();
	private ArrayList<String> manualBans = new ArrayList<>();

	@Provides
	BanListConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BanListConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		manualBans.addAll(Text.fromCSV(config.getBannedPlayers()));
		fetchFromWebsites();
	}

	@Override
	protected void shutDown() throws Exception
	{
		wdrArrayList.clear();
		runeWatchArrayList.clear();
		manualBans.clear();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("banlist"))
		{
			if (event.getKey().equals("bannedPlayers"))
			{
				for (String manual : Text.fromCSV(config.getBannedPlayers()))
				{
					if (!manualBans.contains(manual))
					{
						manualBans.add(Text.standardize(manual));
					}
				}
			}
		}
	}

	/**
	 * Event to keep making sure player names are highlighted red in clan chat, since the red name goes away frequently
	 */
	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged widgetHiddenChanged)
	{
		if (client.getGameState() != GameState.LOGGED_IN
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
			|| client.getViewportWidget() == null
			|| !config.highlightInClan())
		{
			return;
		}

		clientThread.invokeLater(() ->
		{
			if (!client.getWidget(WidgetInfo.CLAN_CHAT).isHidden())
			{
				highlightRedInCC();
			}
		});
	}



	@Subscribe
	public void onClanMemberJoined(ClanMemberJoined event)
	{
		ClanMember member = event.getMember();
		ListType listType = checkBanList(Text.standardize(member.getUsername()));
		if (listType != null)
		{
			sendWarning(Text.standardize(member.getUsername()), listType);
			if (config.highlightInClan())
			{
				highlightRedInCC();
			}
		}
	}

	/**
	 * If a trade window is opened and the person trading us is on the list, modify "trading with"
	 */
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (config.highlightInTrade())
		{
			if (widgetLoaded.getGroupId() == 335)
			{ //if trading window was loaded
				clientThread.invokeLater(() ->
				{
					Widget tradingWith = client.getWidget(335, 31);
					String name = tradingWith.getText().replaceAll("Trading With: ", "");
					if (checkBanList(name) != null)
					{
						tradingWith.setText(tradingWith.getText().replaceAll(name, "<col=ff0000>" + name + " (Scammer)" + "</col>"));
					}
				});
			}
		}
	}

	/**
	 * Compares player name to everything in the ban lists
	 */
	private ListType checkBanList(String nameToBeChecked)
	{
		if (wdrArrayList.size() > 0 && config.enableWDR())
		{
			if (wdrArrayList.stream().anyMatch(nameToBeChecked::equalsIgnoreCase))
			{
				return ListType.WEDORAIDS_LIST;
			}
		}

		if (runeWatchArrayList.size() > 0 && config.enableRuneWatch())
		{
			if (runeWatchArrayList.stream().anyMatch(nameToBeChecked::equalsIgnoreCase))
			{
				return ListType.RUNEWATCH_LIST;
			}
		}

		if (manualBans.size() > 0)
		{
			if (manualBans.stream().anyMatch(nameToBeChecked::equalsIgnoreCase))
			{
				return ListType.MANUAL_LIST;
			}
		}

		return null;
	}

	/**
	 * Sends a warning to our player, notifying them that a player is on a ban list
	 */
	private void sendWarning(String playerName, ListType listType)
	{
		switch (listType)
		{
			case WEDORAIDS_LIST:
				final String wdr_message = new ChatMessageBuilder()
						.append(ChatColorType.HIGHLIGHT)
						.append("Warning! " + playerName + " is on WeDoRaids\' scammer list!")
						.build();

				chatMessageManager.queue(
						QueuedMessage.builder()
								.type(ChatMessageType.CONSOLE)
								.runeLiteFormattedMessage(wdr_message)
								.build());
				break;
			case RUNEWATCH_LIST:
				final String rw_message = new ChatMessageBuilder()
						.append(ChatColorType.HIGHLIGHT)
						.append("Warning! " + playerName + " is on the Runewatch\'s scammer list!")
						.build();

				chatMessageManager.queue(
						QueuedMessage.builder()
								.type(ChatMessageType.CONSOLE)
								.runeLiteFormattedMessage(rw_message)
								.build());
				break;
			case MANUAL_LIST:
				final String manual_message = new ChatMessageBuilder()
						.append(ChatColorType.HIGHLIGHT)
						.append("Warning! " + playerName + " is on your manual scammer list!")
						.build();

				chatMessageManager.queue(
						QueuedMessage.builder()
								.type(ChatMessageType.CONSOLE)
								.runeLiteFormattedMessage(manual_message)
								.build());
				break;
		}
	}

	/**
	 * Pulls data from wdr and runewatch to build a list of blacklisted usernames
	 */
	private void fetchFromWebsites()
	{
		Request request = new Request.Builder()
				.url("https://wdrdev.github.io/index")
				.build();
		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.debug("error retrieving names from wdr");
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				String text = response.body().string();
				text = text.substring(text.indexOf("<p>") + 3, text.indexOf("</p>"));
				text = text.replace("/", ",");
				text = text.replace(", $", "");

				ArrayList<String> wdrList = new ArrayList<>(Arrays.asList(text.split(",")));
				ArrayList<String> wdrList2 = new ArrayList<>();
				wdrList.forEach((name) -> wdrList2.add(Text.standardize(name)));

				wdrArrayList.addAll(wdrList2);
			}
		});


		Request secondRequest = new Request.Builder()
				.url("https://runewatch.com/incident-index-page/")
				.build();
		RuneLiteAPI.CLIENT.newCall(secondRequest).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException e)
			{
				log.debug("error retrieving names from runewatch");
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				String text = response.body().string();
				String mytext = text.substring(text.indexOf("lcp_instance_0"), text.indexOf("strong>Evidence Quality Suggestion"));
				String[] split = mytext.split("href=");
				for (String x : split)
				{
					if (x.contains("title"))
					{
						x = x.substring(x.indexOf("title"), x.indexOf(">"));
						x = x.substring(x.indexOf("=") + 2, x.length() - 1);
						runeWatchArrayList.add(Text.standardize(x));
					}
				}
			}
		});
	}

	/**
	 * Iterates through the clan chat list widget and checks if a string (name) is on any of the ban lists to highlight them red.
	 */
	private void highlightRedInCC()
	{
		clientThread.invokeLater(() ->
		{
			Widget widget = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
			for (Widget widgetChild : widget.getDynamicChildren())
			{
				ListType listType = checkBanList(widgetChild.getText());

				if (listType != null)
				{
					widgetChild.setText("<col=ff0000>" + widgetChild.getText() + "</col>");
				}
			}
		});
	}
}