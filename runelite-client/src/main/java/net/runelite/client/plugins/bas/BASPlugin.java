/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
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
package net.runelite.client.plugins.bas;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ClanChanged;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;


@Slf4j
@PluginDescriptor(
	name = "BAS",
	description = "BAS Customer CC Info",
	tags = {"minigame"}
)
public class BASPlugin extends Plugin
{
	private List<String[]> csvContent = new ArrayList<>();
	private List<String> premList = new ArrayList<>();
	private int count;

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private BASConfig config;

	@Provides
	BASConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BASConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		readCSV();
	}

	@Override
	protected void shutDown()
	{
		count=0;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if(count!=client.getClanChatCount())
		{
			checkCustomers();
		}
	}

	@Subscribe
	public void onClanChanged(ClanChanged changed) throws Exception
	{

		if(client.getWidget(WidgetInfo.CLAN_CHAT_OWNER)==null)
		{
			return;
		}

		Widget owner = client.getWidget(WidgetInfo.CLAN_CHAT_OWNER);
		if(owner.getText().equals("<col=ffffff>Ba Services</col>"))
		{
			readCSV();
		}

		count=0;
	}

	private void checkCustomers()
	{
		if (config.basFeature())
		{
			log.info("checking");
			Widget clanChatTitleWidget = client.getWidget(WidgetInfo.CLAN_CHAT_TITLE);
			if (clanChatTitleWidget != null)
			{
				Widget clanChatList = client.getWidget(WidgetInfo.CLAN_CHAT_LIST);
				Widget owner = client.getWidget(WidgetInfo.CLAN_CHAT_OWNER);
				if (client.getClanChatCount() > 0 && owner.getText().equals("<col=ffffff>Ba Services</col>"))
				{
					Widget[] members = clanChatList.getDynamicChildren();
					for (Widget member : members)
					{
						if (member.getTextColor() == 16777215)
						{
							for (String[] user : csvContent)
							{
								if (user[1].toLowerCase().contains(member.getText().toLowerCase()))
								{
									switch(user[2])
									{
										case "":
											member.setText(member.getText() + " (U)");
											break;
										case "Online":
											member.setText(member.getText() + " (O)");
											break;
										case "In Progress":
											member.setText(member.getText() + " (P)");
											break;
									}
									if (user[0].equals("P"))
									{
										member.setTextColor(6604900);
										boolean inList = false;
										for (String prem : premList)
										{
											if (member.getText().toLowerCase().contains(prem.toLowerCase()))
											{
												inList = true;
											}
										}
										if (!inList)
										{
											premList.add(member.getText());
											final String chatMessage = new ChatMessageBuilder()
												.append(ChatColorType.NORMAL)
												.append("Premium leech " + member.getText())
												.append(ChatColorType.HIGHLIGHT)
												.append(" online.")
												.build();
											chatMessageManager.queue(QueuedMessage.builder()
												.type(ChatMessageType.GAMEMESSAGE)
												.runeLiteFormattedMessage(chatMessage)
												.build());
										}
									}
									else
									{
										member.setTextColor(6579400);
									}
								}
							}
						}
					}
					for (String prem : premList)
					{
						boolean online = false;
						log.info("members size = "+ members.length);
						for (Widget member : members)
						{
							if(member.getText().toLowerCase().contains(prem.toLowerCase()))
							{
								online = true;
							}
						}
						if(!online)
						{
							premList.remove(prem);
							final String chatMessage = new ChatMessageBuilder()
								.append(ChatColorType.NORMAL)
								.append("Premium leech " + prem)
								.append(ChatColorType.HIGHLIGHT)
								.append(" offline.")
								.build();
							chatMessageManager.queue(QueuedMessage.builder()
								.type(ChatMessageType.GAMEMESSAGE)
								.runeLiteFormattedMessage(chatMessage)
								.build());
						}
					}
				}
			}
		}
	}

	private void readCSV() throws Exception
	{
		String st = "https://docs.google.com/spreadsheets/d/1Jh9Nj6BvWVgzZ9urnTTNniQLkgprx_TMggaz8gt_iDM/export?format=csv";
		URL stockURL = new URL(st);
		BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream()));
		String s;
		csvContent.clear();
		while ((s = in.readLine()) != null)
		{
			String[] splitString = s.split(",");
			csvContent.add(new String[]{splitString[2], splitString[2].equals("R") ? splitString[4] : splitString[3], splitString[0]});
		}
	}
}