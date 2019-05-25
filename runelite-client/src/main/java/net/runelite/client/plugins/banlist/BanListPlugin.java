/*
 * Copyright (c) 2019 xperiaclash <https://github.com/xperiaclash>
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
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ConfigChanged;
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
public class BanListPlugin extends Plugin
{
	@Inject
	private Client client;

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
		wdrArrayList = new ArrayList<>();
		runeWatchArrayList = new ArrayList<>();
		manualBans = new ArrayList<>();
		manualBans.addAll(Text.fromCSV(config.getBannedPlayers()));
		fetchFromWebsites();
	}

	@Override
	protected void shutDown() throws Exception
	{
		wdrArrayList = null;
		runeWatchArrayList = null;
		manualBans = null;
	}

	@Subscribe
	public void onClanMemberJoined(ClanMemberJoined event)
	{
		ClanMember member = event.getMember();
		checkBanList(Text.standardize(member.getUsername()));
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		for (String manual : Text.fromCSV(config.getBannedPlayers()))
		{
			if (!manualBans.contains(manual))
			{
				manualBans.add(Text.standardize(manual));
			}
		}
	}

	private void checkBanList(String nameToBeChecked)
	{
		if (client.getClanMembers() != null)
		{
			if (wdrArrayList.size() > 0 && config.enableWDR())
			{
				if (wdrArrayList.stream().anyMatch(nameToBeChecked::equalsIgnoreCase))
				{
					sendWarning(nameToBeChecked, 1);
				}
			}

			if (runeWatchArrayList.size() > 0 && config.enableRuneWatch())
			{
				if (runeWatchArrayList.stream().anyMatch(nameToBeChecked::equalsIgnoreCase))
				{
					sendWarning(nameToBeChecked, 2);
				}
			}

			if (manualBans.size() > 0)
			{
				if (manualBans.stream().anyMatch(nameToBeChecked::equalsIgnoreCase))
				{
					sendWarning(nameToBeChecked, 3);
				}
			}
		}
	}

	private void sendWarning(String playerName, int list)
	{
		if (list == 1)
		{
			// on wdr list
			final String message = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Warning! " + playerName + " is on WDR ban List")
					.build();

			chatMessageManager.queue(
					QueuedMessage.builder()
							.type(ChatMessageType.CONSOLE)
							.runeLiteFormattedMessage(message)
							.build());
		}
		else if (list == 2)
		{
			// on runewatch list
			final String message = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Warning! " + playerName + " is on Runewatch ban List")
					.build();

			chatMessageManager.queue(
					QueuedMessage.builder()
							.type(ChatMessageType.CONSOLE)
							.runeLiteFormattedMessage(message)
							.build());
		}
		else if (list == 3)
		{
			// on manual list
			final String message = new ChatMessageBuilder()
					.append(ChatColorType.HIGHLIGHT)
					.append("Warning! " + playerName + " is on Your Manual ban List")
					.build();

			chatMessageManager.queue(
					QueuedMessage.builder()
							.type(ChatMessageType.CONSOLE)
							.runeLiteFormattedMessage(message)
							.build());
		}
	}


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
				log.println("error retrieving names from wdr");
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
				log.println("error retrieving names from runewatch");
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
}