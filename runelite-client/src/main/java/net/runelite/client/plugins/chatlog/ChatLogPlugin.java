/*
 * Copyright (c) 2018, Rprrr <https://github.com/rprrr>
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
package net.runelite.client.plugins.chatlog;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static net.runelite.client.RuneLite.CHATLOG_DIR;

@PluginDescriptor
		(
		name = "Chat Log",
		enabledByDefault = false
		)

@Slf4j
public class ChatLogPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ChatLogConfig config;

	@Provides
	ChatLogConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ChatLogConfig.class);
	}

	@Override
	protected void startUp()
	{
		CHATLOG_DIR.mkdirs();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!saveMessage(event.getType()))
		{
			return;
		}

		File playerFolder;
		if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null) //Checking for an available player (name) to store chat logs per account.
		{
			playerFolder = new File(CHATLOG_DIR, client.getLocalPlayer().getName()); //Player name available: will get stored in the specific file in the account's folder
		}
		else
		{
			playerFolder = CHATLOG_DIR; //No player name available: will get stored in the general file in the root folder
		}

		playerFolder.mkdirs();
		File file = new File(playerFolder, "chatlog.txt");

		try (FileWriter fw = new FileWriter(file.getPath(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{
			if (!file.canRead() || file.length() == 0) //Adding data headers to new or empty files, so that people can more easily interpret the chat logs.
			//noinspection CheckStyle,CheckStyle
			{
				String headersFormat = "yyyy_MM_dd_HH_mm_ss" + "," + "message_Type" + "," + "message_Sender" + "," + "message_Sender_Name" + "," + "message";

				out.println(headersFormat);
				out.flush();
			}

			String timeLog = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			String messageFormat = timeLog + "," + event.getType() + "," + event.getSender() + "," + event.getName() + "," + "\"" + event.getMessage() + "\""; //This is what gets stored. Can be imported into software as a comma separated file with quotes as text-delimiter.

			//In order to prevent the same message being stored twice when there is no player (name) available (which shouldn't happen in theory, though).
			//Only checking this without a player name available, because it's impossible to login on the same account multiple times at once.
			if (playerFolder.equals(CHATLOG_DIR))
			{
				BufferedReader input = new BufferedReader(new FileReader(file));

				String last = null;
				String line;
				while ((line = input.readLine()) != null)
				{
					last = line;
				}

				if (last.equals(messageFormat))
				{
					return;
				}
			}

			out.println(messageFormat);
			out.flush();
		}
		catch (IOException e)
		{
			log.warn("'Chat Log' plugin file writing error: " + e.getMessage());
		}
	}

	private boolean saveMessage(ChatMessageType type)
	{
		if (type.equals(ChatMessageType.PUBLIC))
		{
			if (!config.savePublicChat())
			{
				return false;
			}

			return true;
		}

		if (type.equals(ChatMessageType.PRIVATE_MESSAGE_RECEIVED) || type.equals(ChatMessageType.PRIVATE_MESSAGE_RECEIVED_MOD) || type.equals(ChatMessageType.PRIVATE_MESSAGE_SENT))
		{
			if (!config.savePrivateChat())
			{
				return false;
			}

			return true;
		}

		if (type.equals(ChatMessageType.CLANCHAT))
		{
			if (!config.saveClanChat())
			{
				return false;
			}

			return true;
		}

		if (type.equals(ChatMessageType.AUTOCHAT))
		{
			if (!config.saveAutoChat())
			{
				return false;
			}

			return true;
		}

		if (!config.saveGameInfo())
		{
			return false;
		}

		return true;
	}
}