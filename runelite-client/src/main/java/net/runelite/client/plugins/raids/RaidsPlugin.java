/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.Instant;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColor;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Raids Plugin"
)
@Slf4j
public class RaidsPlugin extends Plugin
{
	private static final String RAID_START_MESSAGE = "The raid has begun!";
	private static final String RAID_COMPLETE_MESSAGE = "Congratulations - your raid is complete!";
	private static final int TOTAL_POINTS = 0, PERSONAL_POINTS = 1, TEXT_CHILD = 4;
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");
	private BufferedImage raidsIcon;
	private RaidsTimer timer;
	private int raidVarbit;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private Client client;

	@Inject
	private RaidsConfig config;

	@Provides
	RaidsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		cacheColors();
		updateInfoBoxState();
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (timer != null)
			infoBoxManager.removeInfoBox(timer);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (config.pointsMessage())
		{
			cacheColors();
		}

		if (event.getKey().equals("raidsTimer"))
		{
			updateInfoBoxState();
		}
	}

	@Subscribe
	public void onVarbitChange(VarbitChanged event)
	{
		int varbit = client.getSetting(Varbits.IN_RAID);

		if (raidVarbit != varbit)
		{
			raidVarbit = varbit;
			updateInfoBoxState();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (raidVarbit == 1 && event.getType() == ChatMessageType.CLANCHAT_INFO)
		{
			String message = event.getMessage().replaceAll("<[^>]*>", "");

			if (config.raidsTimer() && message.startsWith(RAID_START_MESSAGE))
			{
				timer = new RaidsTimer(getRaidsIcon(), Instant.now());
				infoBoxManager.addInfoBox(timer);
			}

			if (message.startsWith(RAID_COMPLETE_MESSAGE))
			{
				if (timer != null)
					timer.setStopped(true);

				if (config.pointsMessage())
				{
					Widget raidsWidget = client.getWidget(WidgetInfo.RAIDS_POINTS_INFOBOX).getChild(TEXT_CHILD);
					String[] raidPoints = raidsWidget.getText().split("<br>");
					int totalPoints = Integer.parseInt(raidPoints[TOTAL_POINTS].replace(",", ""));
					int personalPoints = Integer.parseInt(raidPoints[PERSONAL_POINTS].replace(",", ""));

					double percentage = personalPoints / (totalPoints / 100.0);

					String chatMessage = new ChatMessageBuilder()
							.append(ChatColorType.NORMAL)
							.append("Total points: ")
							.append(ChatColorType.HIGHLIGHT)
							.append(raidPoints[TOTAL_POINTS])
							.append(ChatColorType.NORMAL)
							.append(", Personal points: ")
							.append(ChatColorType.HIGHLIGHT)
							.append(raidPoints[PERSONAL_POINTS])
							.append(ChatColorType.NORMAL)
							.append(" (")
							.append(ChatColorType.HIGHLIGHT)
							.append(DECIMAL_FORMAT.format(percentage))
							.append(ChatColorType.NORMAL)
							.append("%)")
							.build();

					chatMessageManager.queue(ChatMessageType.CLANCHAT_INFO, chatMessage);
				}
			}
		}
	}

	private void updateInfoBoxState()
	{
		if (timer != null)
		{
			boolean inRaidChambers = client.getSetting(Varbits.IN_RAID) == 1;

			if (config.raidsTimer() && inRaidChambers)
				infoBoxManager.addInfoBox(timer);
			else
				infoBoxManager.removeInfoBox(timer);

			if (!inRaidChambers)
				timer = null;
		}
	}

	private void cacheColors()
	{
		chatMessageManager.cacheColor(new ChatColor(ChatColorType.NORMAL, Color.BLACK, false), ChatMessageType.CLANCHAT_INFO)
				.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, Color.RED, false), ChatMessageType.CLANCHAT_INFO)
				.cacheColor(new ChatColor(ChatColorType.NORMAL, Color.WHITE, true), ChatMessageType.CLANCHAT_INFO)
				.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, Color.RED, true), ChatMessageType.CLANCHAT_INFO)
				.refreshAll();
	}

	private BufferedImage getRaidsIcon()
	{
		if (raidsIcon != null)
			return raidsIcon;

		InputStream in = RaidsPlugin.class.getResourceAsStream("raids_icon.png");

		try
		{
			raidsIcon = ImageIO.read(in);
		}
		catch (IOException ex)
		{
			log.warn("Unable to load image", ex);
		}

		return raidsIcon;
	}
}
