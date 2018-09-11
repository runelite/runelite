/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.game;

import com.google.common.eventbus.Subscribe;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.WidgetInfo;

@Singleton
public class WorldHoppingManager
{
	private static final int DISPLAY_SWITCHER_MAX_ATTEMPTS = 3;

	private final Client client;

	private net.runelite.api.World targetWorld;
	private Consumer<WorldHoppingResult> resultConsumer;
	private int displaySwitcherAttempts = 0;

	@Inject
	public WorldHoppingManager(Client client)
	{
		this.client = client;
	}

	public synchronized void hop(net.runelite.api.World targetWorld, Consumer<WorldHoppingResult> resultConsumer)
	{
		this.targetWorld = targetWorld;
		this.resultConsumer = resultConsumer;
		this.displaySwitcherAttempts = 0;
	}

	@Subscribe
	public synchronized void onGameTick(GameTick event)
	{
		if (targetWorld == null)
		{
			return;
		}

		if (client.getWidget(WidgetInfo.WORLD_SWITCHER_LIST) == null)
		{
			if (++displaySwitcherAttempts > DISPLAY_SWITCHER_MAX_ATTEMPTS)
			{
				resultConsumer.accept(WorldHoppingResult.FAILED_TO_OPEN_HOPPER_AFTER_RETRYING);
				resetQuickHopper();
			}
			else
			{
				client.openWorldHopper();
			}
		}
		else
		{
			client.hopToWorld(targetWorld);
			resultConsumer.accept(WorldHoppingResult.SUCCESSFUL);
			resetQuickHopper();
		}
	}

	@Subscribe
	public synchronized void onChatMessage(ChatMessage event)
	{
		if (targetWorld == null)
		{
			return;
		}

		if (event.getType() != ChatMessageType.SERVER)
		{
			return;
		}

		if (event.getMessage().equals("Please finish what you're doing before using the World Switcher."))
		{
			resultConsumer.accept(WorldHoppingResult.FAILED_TO_OPEN_HOPPER);
			resetQuickHopper();
		}
	}

	private void resetQuickHopper()
	{
		targetWorld = null;
		resultConsumer = null;
		displaySwitcherAttempts = 0;
	}
}
