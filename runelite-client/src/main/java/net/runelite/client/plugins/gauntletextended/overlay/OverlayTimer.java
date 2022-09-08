/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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

package net.runelite.client.plugins.gauntletextended.overlay;

import net.runelite.api.ChatMessageType;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedConfig;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedPlugin;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.time.Instant;

@Singleton
public class OverlayTimer extends Overlay
{
	private final GauntletExtendedConfig config;
	private final ChatMessageManager chatMessageManager;

	private final PanelComponent panelComponent;


	private long timeGauntletStart;
	private long timeHunllefStart;

	@Inject
	public OverlayTimer(final GauntletExtendedPlugin plugin, final GauntletExtendedConfig config, final ChatMessageManager chatMessageManager)
	{
		super(plugin);

		this.config = config;

		this.chatMessageManager = chatMessageManager;

		this.panelComponent = new PanelComponent();

		panelComponent.getChildren().add(TitleComponent.builder().text("Gauntlet Timer").build());


		this.timeGauntletStart = -1;
		this.timeHunllefStart = -1;

		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		setPriority(OverlayPriority.HIGH);
		determineLayer();
	}

	@Override
	public Dimension render(final Graphics2D graphics2D)
	{
		if (!config.timerOverlay() || timeGauntletStart == -1)
		{
			return null;
		}


		return panelComponent.render(graphics2D);
	}

	public void determineLayer()
	{
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	public void reset()
	{
		timeGauntletStart = -1;
		timeHunllefStart = -1;

	}

	public void setGauntletStart()
	{
		timeGauntletStart = Instant.now().getEpochSecond();

	}

	public void setHunllefStart()
	{
		timeHunllefStart = Instant.now().getEpochSecond();

	}

	public void onPlayerDeath()
	{
		if (!config.timerChatMessage())
		{
			return;
		}

		printTime();
		reset();
	}

	private void printTime()
	{
		if (timeGauntletStart == -1 || timeHunllefStart == -1)
		{
			return;
		}

		final long current = Instant.now().getEpochSecond();

		final String elapsedPrepTime = calculateElapsedTime(timeHunllefStart, timeGauntletStart);
		final String elapsedBossTime = calculateElapsedTime(current, timeHunllefStart);
		final String elapsedTotalTime = calculateElapsedTime(current, timeGauntletStart);

		final ChatMessageBuilder chatMessageBuilder = new ChatMessageBuilder()
			.append(ChatColorType.NORMAL)
			.append("Preparation time: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(elapsedPrepTime)
			.append(ChatColorType.NORMAL)
			.append(". Hunllef kill time: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(elapsedBossTime)
			.append(ChatColorType.NORMAL)
			.append(". Total time: ")
			.append(ChatColorType.HIGHLIGHT)
			.append(elapsedTotalTime + ".");

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.CONSOLE)
			.runeLiteFormattedMessage(chatMessageBuilder.build())
			.build());
	}

	private static String calculateElapsedTime(final long end, final long start)
	{
		final long elapsed = end - start;

		final long minutes = elapsed % 3600 / 60;
		final long seconds = elapsed % 60;

		return String.format("%01d:%02d", minutes, seconds);
	}
}
