/*
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.cinematicmode;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.Client;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Cinematic Mode",
	description = "Hide UI and overlays"
)

public class CinematicModePlugin extends Plugin
{
	private boolean test = false;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private CinematicModeConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Provides
	CinematicModeConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CinematicModeConfig.class);
	}

	@Override
	protected void shutDown() throws Exception
	{
		cinematicMode(false);
		overlayManager.hideAllOverlays(false);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!event.getMessage().equals("Reset"))
		{
			return;
		}
		cinematicMode(true);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		cinematicMode(true);
		overlayManager.hideAllOverlays(true);
	}

	private void cinematicMode(Boolean hide)
	{
		Widget sidePannelTypeCheck = client.getWidget(164, 0);

		int groupID = 164;
		int widgetCount = 63;

		if (sidePannelTypeCheck == null  || sidePannelTypeCheck.isHidden())
		{
			groupID = 161;
			widgetCount = 66;
		}

		for (int i = 3; i < widgetCount; i++)
		{
			Widget WidgetI = client.getWidget(groupID, i);

			if (WidgetI != null)
			{
				if (!config.includeEffect() || i != 3)
				{
					WidgetI.setHidden(hide);
				}
				else
				{
					WidgetI.setHidden(false);
				}
			}
		}
	}
}