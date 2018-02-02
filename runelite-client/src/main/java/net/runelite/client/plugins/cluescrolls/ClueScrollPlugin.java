/*
 * Copyright (c) 2016-2017, Seth <Sethtroll3@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.cluescrolls;

import com.google.inject.Binder;
import com.google.inject.Provides;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;

@PluginDescriptor(
	name = "Clue scroll plugin"
)
public class ClueScrollPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClueScrollConfig config;

	@Inject
	private ClueScrollOverlay clueScrollOverlay;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(ClueScrollOverlay.class);
	}

	@Provides
	ClueScrollConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClueScrollConfig.class);
	}

	@Override
	public ClueScrollOverlay getOverlay()
	{
		return clueScrollOverlay;
	}

	@Schedule(
		period = 600,
		unit = ChronoUnit.MILLIS
	)
	public void checkForClues()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return;
		}

		Widget clueScroll = client.getWidget(WidgetInfo.CLUE_SCROLL_TEXT);

		if (clueScroll == null)
		{
			return;
		}

		//remove line breaks and also the rare occasion where there are double line breaks
		ClueScroll clue = ClueScroll.forText(clueScroll.getText().replaceAll("<br>", " ").replaceAll("  ", " ").toLowerCase());

		if (clue == null)
		{
			clueScrollOverlay.clue = null;
			return;
		}

		if (clue.getType() == ClueScrollType.EMOTE)
		{
			clueScrollOverlay.clue = clue;

			clueScrollOverlay.clueTimeout = Instant.now();
			return;
		}

		clueScrollOverlay.clue = null;

		//check for <col=ffffff> which tells us if the string has already been built
		if (clueScroll.getText().contains("<col=ffffff>"))
		{
			return;
		}

		//Build widget text
		StringBuilder clueText = new StringBuilder();

		clueText.append(clueScroll.getText()).append("<br><br>");

		if (clue.getNpc() != null)
		{
			clueText.append("<col=ffffff>Talk to: ").append(clue.getNpc()).append("<br>");
		}

		if (clue.getLocation() != null)
		{
			clueText.append("<col=ffffff>Location: ").append(clue.getLocation()).append("<br>");
		}

		if (clue.getAnswer() != null)
		{
			clueText.append("<col=ffffff>Answer: ").append(clue.getAnswer());
		}

		clueScroll.setText(clueText.toString());

	}
}
