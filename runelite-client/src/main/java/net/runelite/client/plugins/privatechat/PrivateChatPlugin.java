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
package net.runelite.client.plugins.privatechat;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
		name = "Private Chat"
)
public class PrivateChatPlugin extends Plugin
{
	private static final WidgetInfo PRIVATE_CHAT_WIDGET = WidgetInfo.PRIVATE_CHAT_MESSAGE;

	@Inject
	private Client client;

	@Inject
	private PrivateChatConfig config;

	@Inject
	private PrivateChatOverlay overlay;

	private int senderHexColor;
	private int messageHexColor;

	@Provides
	PrivateChatConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrivateChatConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	public void startUp()
	{
		updateSenderColor();
		updateMessageColor();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("senderColor"))
		{
			updateSenderColor();
		}

		if (event.getKey().equals("messageColor"))
		{
			updateMessageColor();
		}
	}

	private void updateSenderColor()
	{
		senderHexColor = config.getPrivateSenderColor().getRGB() & 0xFFFFFF;
	}

	private void updateMessageColor()
	{
		messageHexColor = config.getPrivateMessageColor().getRGB() & 0xFFFFFF;
	}

	public void updateWidgets()
	{
		for (Widget widget : client.getWidget(PRIVATE_CHAT_WIDGET).getDynamicChildren())
		{
			if (!widget.isHidden() && !widget.getText().isEmpty())
			{
				if (widget.getOriginalX() == 0)
				{
					widget.setTextColor(senderHexColor);
				}
				else
				{
					widget.setTextColor(messageHexColor);
				}
			}
		}
	}
}
