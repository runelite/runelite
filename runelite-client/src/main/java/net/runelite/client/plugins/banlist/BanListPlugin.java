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
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@PluginDescriptor(
	name = "Ban List",
	description = "Displays warning in chat when you join a" +
		"clan chat/new member join your clan chat and he is in a WDR/RuneWatch/Manual List",
	tags = {"PVM", "WDR", "RuneWatch"},
	type = PluginType.MISCELLANEOUS,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class BanListPlugin extends Plugin
{
	private final Set<String> wdrScamSet = new HashSet<>();
	private final Set<String> wdrToxicSet = new HashSet<>();
	private final Set<String> runeWatchSet = new HashSet<>();
	private final Set<String> manualBans = new HashSet<>();

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private BanListConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private String tobNames = "";
	private boolean enableWDRScam;
	private boolean enableWDRToxic;
	private boolean enableRuneWatch;
	private boolean highlightInClan;
	private boolean highlightInTrade;

	@Provides
	BanListConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BanListConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();

		manualBans.addAll(Text.fromCSV(Text.standardize(config.getBannedPlayers())));

		fetchFromWebsites();
	}

	@Override
	protected void shutDown()
	{

		wdrScamSet.clear();
		wdrToxicSet.clear();
		runeWatchSet.clear();
		manualBans.clear();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("banlist") && event.getKey().equals("bannedPlayers"))
		{
			manualBans.clear();

			String newValue = event.getNewValue();

			manualBans.addAll(Text.fromCSV(Text.standardize(newValue)));
		}
	}

	private void updateConfig()
	{
		this.enableWDRScam = config.enableWDRScam();
		this.enableWDRToxic = config.enableWDRToxic();
		this.enableRuneWatch = config.enableRuneWatch();
		this.highlightInClan = config.highlightInClan();
		this.highlightInTrade = config.highlightInTrade();
	}

	/**
	 * Event to keep making sure player names are highlighted red in clan chat, since the red name goes away frequently
	 */
	@Subscribe
	private void onWidgetHiddenChanged(WidgetHiddenChanged widgetHiddenChanged)
	{
		if (client.getGameState() != GameState.LOGGED_IN
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
			|| client.getViewportWidget() == null
			|| client.getWidget(WidgetInfo.CLAN_CHAT) == null
			|| !this.highlightInClan)
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
	private void onClanMemberJoined(ClanMemberJoined event)
	{
		ClanMember member = event.getMember();
		String memberUsername = Text.standardize(member.getUsername().toLowerCase());

		ListType scamList = checkScamList(memberUsername);
		ListType toxicList = checkToxicList(memberUsername);

		if (scamList != null)
		{
			sendWarning(memberUsername, scamList);
			if (this.highlightInClan)
			{
				highlightRedInCC();
			}
		}

		if (toxicList != null)
		{
			sendWarning(memberUsername, toxicList);
			if (this.highlightInClan)
			{
				highlightRedInCC();
			}
		}
	}

	/**
	 * If a trade window is opened and the person trading us is on the list, modify "trading with"
	 */
	@Subscribe
	private void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (this.highlightInTrade && widgetLoaded.getGroupId() == PLAYER_TRADE_SCREEN_GROUP_ID)
		{ //if trading window was loaded
			clientThread.invokeLater(() ->
			{
				Widget tradingWith = client.getWidget(WidgetInfo.TRADING_WITH);

				String name = tradingWith.getText().replaceAll("Trading With: ", "").toLowerCase();
				if (checkScamList(name) != null)
				{
					tradingWith.setText(tradingWith.getText().replaceAll(name, "<col=ff0000>" + name + " (Scammer)" + "</col>"));
				}
				if (checkToxicList(name) != null)
				{
					tradingWith.setText(tradingWith.getText().replaceAll(name, "<col=ff6400>" + name + " (Toxic)" + "</col>"));
				}
			});
		}
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		final Widget raidingParty = client.getWidget(WidgetInfo.THEATRE_OF_BLOOD_RAIDING_PARTY);
		if (raidingParty == null)
		{
			return;
		}

		String allNames = raidingParty.getText();

		if (allNames.equalsIgnoreCase(tobNames))
		{
			return;
		}

		tobNames = allNames;

		String[] split = allNames.split("<br>");

		for (String name : split)
		{
			if (!name.equals("-"))
			{
				String stdName = Text.standardize(name);

				ListType scamList = checkScamList(stdName);

				if (scamList != null)
				{
					sendWarning(name, scamList);
				}

				ListType toxicList = checkToxicList(stdName);

				if (toxicList != null)
				{
					sendWarning(name, toxicList);
				}
			}
		}
	}

	/**
	 * Compares player name to everything in the ban lists
	 */
	private ListType checkScamList(String nameToBeChecked)
	{
		if (this.enableWDRScam && wdrScamSet.contains(nameToBeChecked))
		{
			return ListType.WEDORAIDSSCAM_LIST;
		}

		if (this.enableRuneWatch && runeWatchSet.contains(nameToBeChecked))
		{
			return ListType.RUNEWATCH_LIST;
		}

		if (manualBans.contains(nameToBeChecked))
		{
			return ListType.MANUAL_LIST;
		}

		return null;
	}

	private ListType checkToxicList(String nameToBeChecked)
	{
		if (this.enableWDRToxic && wdrToxicSet.contains(nameToBeChecked))
		{
			return ListType.WEDORAIDSTOXIC_LIST;
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
			case WEDORAIDSSCAM_LIST:
				final String wdr__scam_message = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Warning! " + playerName + " is on WeDoRaids\' scammer list!")
					.build();

				chatMessageManager.queue(
					QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.runeLiteFormattedMessage(wdr__scam_message)
						.build());
				break;

			case WEDORAIDSTOXIC_LIST:
				final String wdr__toxic_message = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Warning! " + playerName + " is on WeDoRaids\' toxic list!")
					.build();

				chatMessageManager.queue(
					QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.runeLiteFormattedMessage(wdr__toxic_message)
						.build());
				break;

			case RUNEWATCH_LIST:
				final String rw_message = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Warning! " + playerName + " is on the Runewatch\'s potential scammer list!")
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
		fetchAndParseWdr(request, wdrScamSet);


		Request secondRequest = new Request.Builder()
			.url("https://runewatch.com/incident-index-page/")
			.build();
		RuneLiteAPI.CLIENT.newCall(secondRequest).enqueue(new Callback()
		{
			@Override
			public void onFailure(@NotNull Call call, @NotNull IOException e)
			{
				log.debug("error retrieving names from runewatch");
			}

			@Override
			public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException
			{
				String text = response.body().string();
				String mytext = text.substring(text.indexOf("lcp_instance_0"), text.indexOf("strong>Evidence Quality Suggestion"));
				String[] split = mytext.split("href=");
				for (String x : split)
				{
					if (x.contains("title"))
					{
						x = x.substring(x.indexOf("title"), x.indexOf('>'));
						x = x.substring(x.indexOf('=') + 2, x.length() - 1);
						runeWatchSet.add(Text.standardize(x).toLowerCase());
					}
				}
			}
		});

		Request thirdRequest = new Request.Builder()
			.url("https://wdrdev.github.io/toxic")
			.build();
		fetchAndParseWdr(thirdRequest, wdrToxicSet);
	}

	private void fetchAndParseWdr(Request req, Set<String> tgtSet)
	{
		RuneLiteAPI.CLIENT.newCall(req).enqueue(new Callback()
		{
			@Override
			public void onFailure(@NotNull Call call, @NotNull IOException e)
			{
				log.debug("error retrieving names from wdr");
			}

			@Override
			public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException
			{
				String text = response.body().string();
				text = text.substring(text.indexOf("<p>") + 3, text.indexOf("</p>"));
				text = text.replace("/", ",");
				text = text.replace(", $", "");

				Text.fromCSV(text).forEach(str -> tgtSet.add(Text.standardize(str)));
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
				String text = widgetChild.getText(), lc = text.toLowerCase();

				if (checkScamList(lc) != null)
				{
					widgetChild.setText("<col=ff0000>" + text + "</col>");
				}
				else if (checkToxicList(lc) != null)
				{
					widgetChild.setText("<col=ff6400>" + text + "</col>");
				}
			}
		});
	}
}
