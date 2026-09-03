/*
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
package net.runelite.client.input;

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@Singleton
public class ChatboxInputManager
{
	private final Client client;
	private final ClientThread clientThread;
	private final RuneLiteConfig config;

	private boolean keyRemappingPluginEnabled;
	private char blockedChar = KeyEvent.CHAR_UNDEFINED;

	@Getter
	private boolean typing;

	@Inject
	private ChatboxInputManager(Client client, ClientThread clientThread, RuneLiteConfig config, EventBus eventBus)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.config = config;
		eventBus.register(this);
	}

	public void setKeyRemappingPluginEnabled(boolean keyRemappingPluginEnabled)
	{
		if (this.keyRemappingPluginEnabled == keyRemappingPluginEnabled)
		{
			return;
		}

		boolean wasEnabled = isEnabled();
		this.keyRemappingPluginEnabled = keyRemappingPluginEnabled;
		if (wasEnabled != isEnabled())
		{
			clientThread.invoke(this::updateChatLock);
		}
	}

	private boolean isEnabled()
	{
		return config.pressEnterToChat() || keyRemappingPluginEnabled;
	}

	public boolean isChatInputActive()
	{
		return isEnabled() && typing && chatboxFocused();
	}

	public void processKeyTyped(KeyEvent e)
	{
		if (e.getKeyChar() == blockedChar)
		{
			blockedChar = KeyEvent.CHAR_UNDEFINED;
			e.consume();
		}
	}

	public void processKeyPressed(KeyEvent e)
	{
		if (!isEnabled() || !chatboxFocused())
		{
			return;
		}

		if (!typing)
		{
			if (isChatActivationKey(e))
			{
				typing = true;
				clientThread.invoke(this::unlockChat);

				if (shouldConsumeActivationKey(e))
				{
					blockedChar = e.getKeyChar();
					e.consume();
				}
			}

			return;
		}

		switch (e.getKeyCode())
		{
			case KeyEvent.VK_ESCAPE:
				e.consume();
				typing = false;
				clientThread.invoke(() ->
				{
					client.setVarcStrValue(VarClientID.CHATINPUT, "");
					lockChat();
				});
				break;
			case KeyEvent.VK_ENTER:
				typing = false;
				clientThread.invoke(this::lockChat);
				break;
			case KeyEvent.VK_BACK_SPACE:
				if (Strings.isNullOrEmpty(client.getVarcStrValue(VarClientID.CHATINPUT)))
				{
					typing = false;
					clientThread.invoke(this::lockChat);
				}
				break;
		}
	}

	public void processKeyReleased(KeyEvent e)
	{
		if (e.getKeyChar() == blockedChar)
		{
			blockedChar = KeyEvent.CHAR_UNDEFINED;
		}
	}

	private boolean isChatActivationKey(KeyEvent e)
	{
		return config.chatActivationKey().matches(e)
			|| isChatPrefixKey(e);
	}

	private static boolean shouldConsumeActivationKey(KeyEvent e)
	{
		return e.getKeyChar() != KeyEvent.CHAR_UNDEFINED
			&& !isChatPrefixKey(e);
	}

	private static boolean isChatPrefixKey(KeyEvent e)
	{
		return e.getKeyChar() == '/'
			|| e.getKeyChar() == ':'
			|| e.getKeyCode() == KeyEvent.VK_COLON
			|| e.getKeyCode() == KeyEvent.VK_SEMICOLON && e.isShiftDown();
	}

	public boolean chatboxFocused()
	{
		Widget chatboxParent = client.getWidget(InterfaceID.Chatbox.UNIVERSE);
		if (chatboxParent == null || chatboxParent.getOnKeyListener() == null)
		{
			return false;
		}

		// If the search box on the world map is open and focused, ~keypress_permit blocks the keypress.
		Widget worldMapSearch = client.getWidget(InterfaceID.Worldmap.MAPLIST_DISPLAY);
		if (worldMapSearch != null && client.getVarcIntValue(VarClientID.WORLDMAP_SEARCHING) == 1)
		{
			return false;
		}

		// The report interface blocks input due to 162:54 being hidden, however player/npc dialog and
		// options do this too, and so we can't disable remapping just due to 162:54 being hidden.
		Widget report = client.getWidget(InterfaceID.Reportabuse.UNIVERSE);
		if (report != null)
		{
			return false;
		}

		return client.getFocusedInputFieldWidget() == null;
	}

	public boolean isDialogOpen()
	{
		return isHidden(InterfaceID.Chatbox.MES_LAYER_HIDE) || isHidden(InterfaceID.Chatbox.CHATDISPLAY)
			|| !isHidden(InterfaceID.BankpinKeypad.UNIVERSE);
	}

	public boolean isOptionsDialogOpen()
	{
		return client.getWidget(InterfaceID.Chatmenu.OPTIONS) != null;
	}

	private boolean isHidden(int component)
	{
		Widget w = client.getWidget(component);
		return w == null || w.isSelfHidden();
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		if (!isEnabled())
		{
			return;
		}

		switch (scriptCallbackEvent.getEventName())
		{
			case "setChatboxInput":
				if (!typing)
				{
					lockChat();
				}
				break;
			case "blockChatInput":
				if (!typing)
				{
					int[] intStack = client.getIntStack();
					int intStackSize = client.getIntStackSize();
					intStack[intStackSize - 1] = 1;
				}
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			updateChatLock();
		}
		else
		{
			typing = false;
			blockedChar = KeyEvent.CHAR_UNDEFINED;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (RuneLiteConfig.GROUP_NAME.equals(event.getGroup())
			&& ("pressEnterToChat".equals(event.getKey()) || "chatActivationKey".equals(event.getKey())))
		{
			clientThread.invoke(this::updateChatLock);
		}
	}

	private void updateChatLock()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		typing = false;
		blockedChar = KeyEvent.CHAR_UNDEFINED;
		if (isEnabled())
		{
			client.setVarcStrValue(VarClientID.CHATINPUT, "");
			lockChat();
		}
		else
		{
			unlockChat();
		}
	}

	private void lockChat()
	{
		setChatboxInput("Press " + config.chatActivationKey() + " to Chat...");
	}

	private void unlockChat()
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			final boolean isChatboxTransparent = client.isResized() && client.getVarbitValue(VarbitID.CHATBOX_TRANSPARENCY) == 1;
			final Color textColor = isChatboxTransparent ? JagexColors.CHAT_TYPED_TEXT_TRANSPARENT_BACKGROUND : JagexColors.CHAT_TYPED_TEXT_OPAQUE_BACKGROUND;
			setChatboxInput(ColorUtil.wrapWithColorTag(client.getVarcStrValue(VarClientID.CHATINPUT) + "*", textColor));
		}
	}

	private void setChatboxInput(String input)
	{
		Widget widget = client.getWidget(InterfaceID.Chatbox.INPUT);
		if (widget == null)
		{
			return;
		}

		String text = widget.getText();
		int idx = text.indexOf(':');
		if (idx != -1)
		{
			String newText = text.substring(0, idx) + ": " + input;
			widget.setText(newText);
		}
	}
}
