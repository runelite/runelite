/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.duelnotifier;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.corp.CorpConfig;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
	name = "Duel Notifier",
	description = "Highlight screen when a duel request is received",
	tags = {"highlight", "duel", "notifier", "loudpacks"}
)
public class DuelNotifierPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private DuelNotifierConfig config;

	@Inject
	private DuelNotifierOverlay duelNotifierOverlay;

	@Inject
	private Client client;

	@Provides
	DuelNotifierConfig getConfig(ConfigManager configManager) { return configManager.getConfig(DuelNotifierConfig.class); }

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(duelNotifierOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(duelNotifierOverlay);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if ( event.getType() == ChatMessageType.DUEL)
		{
			if (event.getMessage().toLowerCase().endsWith("duel with you."))
			{
				duelNotifierOverlay.startTimer();
			}
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event) {
		if(event.getWidget().equals(client.getWidget(WidgetInfo.DUEL_INTERFACE))) {
			duelNotifierOverlay.resetTimer();
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event) {
		if(event.getGroupId() == WidgetID.DUEL_GROUP_ID) {
			duelNotifierOverlay.resetTimer();
		}
	}

}
