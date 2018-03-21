/*
 * Copyright (c) 2018 Charlie Waters
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
package net.runelite.client.plugins.wasdcamera;

import com.google.common.eventbus.Subscribe;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetRedraw;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@PluginDescriptor(
	name = "WASD Camera",
	enabledByDefault = false
)
@Slf4j
public class WASDCameraPlugin extends Plugin
{
	private static final String PRESS_ENTER_TEXT = "Press Enter to Chat...";
	private static int CHATBOX_LINE_ID = WidgetInfo.CHATBOX_CHAT_LINE.getPackedId();

	@Inject
	Client client;

	@Inject
	private KeyManager keyManager;

	@Inject
	private WASDCameraInputListener inputListener;

	@Getter(AccessLevel.PACKAGE)
	private boolean inGame;
	@Getter(AccessLevel.PACKAGE)
	private boolean chatMode;
	@Getter(AccessLevel.PACKAGE)
	private boolean textWidgetOverride;
	
	@Override
	protected void startUp()
	{
		chatMode = false;
		inGame = false;
		textWidgetOverride = false;
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	public boolean shouldRemap()
	{
		return inGame && !chatMode && !textWidgetOverride;
	}

	public void setChatMode(boolean mode)
	{
		chatMode = mode;
		updateTooltip();
	}

	public void updateTooltip()
	{
		// Change the widget text when not in chat mode
		if (!chatMode)
		{
			final Widget widget = client.getWidget(WidgetInfo.CHATBOX_CHAT_LINE);
			if (widget != null)
			{
				updateChatLine(widget);
			}
		}
	}

	public void updateChatLine(Widget widget)
	{
		// Replace any text in the chat line with the message
		final String line = widget.getText();
		final int start = line.indexOf("<col=") + 12;
		final int end = line.indexOf("</col>");
		if (start < 0 || end < 0)
		{
			return;
		}

		final String nline = line.substring(0, start) + PRESS_ENTER_TEXT + line.substring(end);
		widget.setText(nline);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		chatMode = false;
		inGame = (event.getGameState() == GameState.LOGGED_IN);
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		final Widget widget = event.getWidget();
		// Watch for widgets that need text entry
		if (widget.getId() == WidgetInfo.CHATBOX_ENTRY_BOX.getPackedId() ||
			widget.getId() == WidgetInfo.FLOATING_WORLD_MAP.getPackedId())
		{
			textWidgetOverride = !widget.isHidden();
			//log.debug("Text Widget: " + textWidgetOverride);
		}
	}

	@Subscribe
	public void onWidgetRedraw(WidgetRedraw event)
	{
		// Whenever the widget would be redrawn, update the text
		if (!chatMode && event.getWidget().getId() == CHATBOX_LINE_ID)
		{
			updateChatLine(event.getWidget());
		}
	}
}
