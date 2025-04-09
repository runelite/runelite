/*
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.timestamp;

import com.google.inject.Provides;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.ScriptID;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Chat Timestamps",
	description = "Add timestamps to chat messages",
	tags = {"timestamp"},
	enabledByDefault = false
)
public class TimestampPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private TimestampConfig config;

	@Getter
	private SimpleDateFormat formatter;

	@Provides
	public TimestampConfig provideConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(TimestampConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateFormatter();
	}

	@Override
	protected void shutDown() throws Exception
	{
		formatter = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(TimestampConfig.GROUP))
		{
			switch (event.getKey())
			{
				case "format":
					updateFormatter();
					break;
				case "opaqueTimestamp":
				case "transparentTimestamp":
					clientThread.invokeLater(() -> client.runScript(ScriptID.SPLITPM_CHANGED));
					break;
			}
		}
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!"chatMessageBuilding".equals(event.getEventName()))
		{
			return;
		}

		int uid = client.getIntStack()[client.getIntStackSize() - 1];
		final MessageNode messageNode = client.getMessages().get(uid);
		assert messageNode != null : "chat message build for unknown message";

		String timestamp = generateTimestamp(messageNode.getTimestamp(), ZoneId.systemDefault());

		Color timestampColour = getTimestampColour();
		if (timestampColour != null)
		{
			timestamp = ColorUtil.wrapWithColorTag(timestamp, timestampColour);
		}

		client.getStringStack()[client.getStringStackSize() - 1] = timestamp;
	}

	private Color getTimestampColour()
	{
		boolean isChatboxTransparent = client.isResized() && client.getVarbitValue(VarbitID.CHATBOX_TRANSPARENCY) == 1;

		return isChatboxTransparent ? config.transparentTimestamp() : config.opaqueTimestamp();
	}

	String generateTimestamp(int timestamp, ZoneId zoneId)
	{
		final ZonedDateTime time = ZonedDateTime.ofInstant(
			Instant.ofEpochSecond(timestamp), zoneId);

		return formatter.format(Date.from(time.toInstant()));
	}

	private void updateFormatter()
	{
		try
		{
			formatter = new SimpleDateFormat(config.timestampFormat());
		}
		catch (IllegalArgumentException e)
		{
			formatter = new SimpleDateFormat("[HH:mm]");
		}
	}
}