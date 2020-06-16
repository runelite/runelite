/*
 * Copyright (c) 2020, Truth Forger <https://github.com/Blackberry0Pie>
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
package net.runelite.client.plugins.stealingartefacts;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@PluginDescriptor(
	name = "Stealing Artefacts",
	description = "Gives a chatbox message for which house that Captain Khaled specified",
	tags = {"piscarilius", "thieving", "artifact"}
)
@Slf4j
public class StealingArtefactsPlugin extends Plugin
{
	static final int REGION_KHALED = 7226;
	private static final Pattern LOCATION_EXTRACTOR = Pattern.compile("found in the (.*) house");
	private static String prevLocation;
	private static boolean notSent = false;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (client.getLocalPlayer().getWorldLocation().getRegionID() != REGION_KHALED)
		{
			return;
		}

		Widget npcText = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);
		Widget npcName = client.getWidget(WidgetInfo.DIALOG_NPC_NAME);
		if (npcText != null && npcName != null && npcName.getText().equals("Captain Khaled"))
		{
			String text = npcText.getText();
			Matcher m = LOCATION_EXTRACTOR.matcher(text);
			if (m.find())
			{
				prevLocation = m.group(1);
				notSent = true;
			}
		}

		if (client.getWidget(WidgetInfo.DIALOG_NPC) == null && notSent)
		{
			sendLocationMessage(prevLocation);
			notSent = false;
		}
	}

	private void sendLocationMessage(String location)
	{
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Captain Khaled has asked for an artefact from the ")
			.append(ChatColorType.HIGHLIGHT)
			.append(location)
			.append(ChatColorType.NORMAL)
			.append(" house.")
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage(message)
				.build());
	}
}
