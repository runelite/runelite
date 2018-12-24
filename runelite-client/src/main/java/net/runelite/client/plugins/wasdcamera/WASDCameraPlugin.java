/*'
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Abexlry <abexlry@gmail.com>
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

import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IconID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "WASD Camera",
	description = "Allows use of WASD keys for camera movement with 'Press Enter to Chat'",
	tags = {"enter", "chat"},
	enabledByDefault = false
)
public class WASDCameraPlugin extends Plugin
{
	private static final String PRESS_ENTER_TO_CHAT = "Press Enter to Chat...";
	private static final String SCRIPT_EVENT_SET_CHATBOX_INPUT = "setChatboxInput";
	private static final String SCRIPT_EVENT_BLOCK_CHAT_INPUT = "blockChatInput";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private KeyManager keyManager;

	@Inject
	private WASDCameraListener inputListener;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean typing;

	@Override
	protected void startUp() throws Exception
	{
		typing = false;
		keyManager.registerKeyListener(inputListener);

		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				lockChat();
			}
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				unlockChat();
			}
		});

		keyManager.unregisterKeyListener(inputListener);
	}

	@Provides
	WASDCameraConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WASDCameraConfig.class);
	}

	boolean chatboxFocused()
	{
		Widget chatboxParent = client.getWidget(WidgetInfo.CHATBOX_PARENT);
		if (chatboxParent == null || chatboxParent.getOnKeyListener() == null)
		{
			return false;
		}

		// the search box on the world map can be focused, and chat input goes there, even
		// though the chatbox still has its key listener.
		Widget worldMapSearch = client.getWidget(WidgetInfo.WORLD_MAP_SEARCH);
		if (worldMapSearch != null && client.getVar(VarClientInt.WORLD_MAP_SEARCH_FOCUSED) == 1)
		{
			return false;
		}

		return true;
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		switch (scriptCallbackEvent.getEventName())
		{
			case SCRIPT_EVENT_SET_CHATBOX_INPUT:
				Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
				if (chatboxInput != null)
				{
					if (chatboxFocused() && !typing)
					{
						chatboxInput.setText(getPlayerNameWithIcon() + ": " + PRESS_ENTER_TO_CHAT);
					}
				}
				break;
			case SCRIPT_EVENT_BLOCK_CHAT_INPUT:
				if (!typing)
				{
					int[] intStack = client.getIntStack();
					int intStackSize = client.getIntStackSize();
					intStack[intStackSize - 1] = 1;
				}
				break;
		}
	}

	void lockChat()
	{
		Widget chatboxParent = client.getWidget(WidgetInfo.CHATBOX_PARENT);
		if (chatboxParent != null && chatboxParent.getOnKeyListener() != null)
		{
			Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
			if (chatboxInput != null)
			{
				chatboxInput.setText(getPlayerNameWithIcon() + ": " + PRESS_ENTER_TO_CHAT);
			}
		}
	}

	void unlockChat()
	{
		Widget chatboxParent = client.getWidget(WidgetInfo.CHATBOX_PARENT);
		if (chatboxParent != null)
		{
			Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
			if (chatboxInput != null)
			{
				if (client.getGameState() == GameState.LOGGED_IN)
				{
					final boolean isChatboxTransparent = client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1;
					final Color textColor = isChatboxTransparent ? JagexColors.CHAT_TYPED_TEXT_TRANSPARENT_BACKGROUND : JagexColors.CHAT_TYPED_TEXT_OPAQUE_BACKGROUND;
					chatboxInput.setText(getPlayerNameWithIcon() + ": " + ColorUtil.wrapWithColorTag(client.getVar(VarClientStr.CHATBOX_TYPED_TEXT) + "*", textColor));
				}
			}
		}
	}

	private String getPlayerNameWithIcon()
	{
		IconID icon;
		switch (client.getAccountType())
		{
			case IRONMAN:
				icon = IconID.IRONMAN;
				break;
			case ULTIMATE_IRONMAN:
				icon = IconID.ULTIMATE_IRONMAN;
				break;
			case HARDCORE_IRONMAN:
				icon = IconID.HARDCORE_IRONMAN;
				break;
			default:
				return client.getLocalPlayer().getName();
		}
		return icon + client.getLocalPlayer().getName();
	}
}
