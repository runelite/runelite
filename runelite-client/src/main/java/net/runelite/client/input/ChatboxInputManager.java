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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.vars.InputType;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@Singleton
@Slf4j
public class ChatboxInputManager
{
	private final Client client;
	private final ClientThread clientThread;
	private final RuneLiteConfig config;

	private volatile char blockedChar = KeyEvent.CHAR_UNDEFINED;
	private volatile char exitChar = KeyEvent.CHAR_UNDEFINED;

	@Getter
	private volatile boolean typing;

	@Inject
	private ChatboxInputManager(Client client, ClientThread clientThread, RuneLiteConfig config, EventBus eventBus)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.config = config;
		eventBus.register(this);
	}

	private boolean isEnabled()
	{
		return config.pressEnterToChat() && !Keybind.NOT_SET.equals(config.chatActivationKey());
	}

	public boolean isChatInputActive()
	{
		return isEnabled() && isChatInputAvailable();
	}

	/** Whether vanilla chat accepts input, including when press-to-chat is disabled. */
	public boolean isChatInputAvailable()
	{
		return isPublicChatInput() && (!isEnabled() || typing) || isPrivateMessageInput();
	}

	public boolean processKeyTyped(KeyEvent e)
	{
		if (!isEnabled() || !isPublicChatInput())
		{
			blockedChar = KeyEvent.CHAR_UNDEFINED;
			exitChar = KeyEvent.CHAR_UNDEFINED;
			return isChatInputActive();
		}

		// Enter/empty Backspace already relocked chat on KEY_PRESSED, but their
		// trailing typed event still belongs to the same chat action.
		boolean suppress = typing || e.getKeyChar() == exitChar;
		exitChar = KeyEvent.CHAR_UNDEFINED;
		if (e.getKeyChar() == blockedChar)
		{
			blockedChar = KeyEvent.CHAR_UNDEFINED;
			e.consume();
		}
		return suppress;
	}

	public void processKeyPressed(KeyEvent e)
	{
		if (!isEnabled() || !isPublicChatInput())
		{
			blockedChar = KeyEvent.CHAR_UNDEFINED;
			exitChar = KeyEvent.CHAR_UNDEFINED;
			// Private messages have their own vanilla editor and exit handling.
			if (isPrivateMessageInput() && (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE))
			{
				typing = false;
				exitChar = e.getKeyChar();
			}
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
				exitChar = e.getKeyChar();
				typing = false;
				clientThread.invoke(this::lockChat);
				break;
			case KeyEvent.VK_BACK_SPACE:
				if (Strings.isNullOrEmpty(client.getVarcStrValue(VarClientID.CHATINPUT)))
				{
					exitChar = e.getKeyChar();
					typing = false;
					clientThread.invoke(this::lockChat);
				}
				break;
		}
	}

	public void processKeyReleased(KeyEvent e)
	{
		if (e.getKeyChar() == exitChar)
		{
			exitChar = KeyEvent.CHAR_UNDEFINED;
		}
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
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return false;
		}

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

	private boolean isPublicChatInput()
	{
		// ChatDefaultOnKey returns before processing input when either layer is hidden.
		return chatboxFocused() && client.getVarcIntValue(VarClientID.MESLAYERMODE) == InputType.NONE.getType()
			&& isVisible(InterfaceID.Chatbox.MES_LAYER_HIDE) && isVisible(InterfaceID.Chatbox.CHATDISPLAY)
			&& client.getWidget(InterfaceID.Chatmenu.OPTIONS) == null && !isVisible(InterfaceID.BankpinKeypad.UNIVERSE);
	}

	private boolean isPrivateMessageInput()
	{
		return chatboxFocused() && client.getVarcIntValue(VarClientID.MESLAYERMODE) == InputType.PRIVATE_MESSAGE.getType()
			&& client.getWidget(InterfaceID.Chatmenu.OPTIONS) == null && !isVisible(InterfaceID.BankpinKeypad.UNIVERSE);
	}

	private boolean isVisible(int component)
	{
		Widget widget = client.getWidget(component);
		return widget != null && !widget.isSelfHidden();
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			blockedChar = KeyEvent.CHAR_UNDEFINED;
			exitChar = KeyEvent.CHAR_UNDEFINED;
		}
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged event)
	{
		if (event.getIndex() == VarClientID.MESLAYERMODE)
		{
			blockedChar = KeyEvent.CHAR_UNDEFINED;
			exitChar = KeyEvent.CHAR_UNDEFINED;
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		if (!isEnabled() || !isPublicChatInput())
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
					if (intStack != null && intStackSize > 0 && intStackSize <= intStack.length)
					{
						intStack[intStackSize - 1] = 1;
					}
					else
					{
						log.warn("Unexpected blockChatInput stack size: {}", intStackSize);
					}
				}
				break;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			// A normal region load also ends in LOGGED_IN. Keep its draft and typing state.
			if (isEnabled() && !typing)
			{
				lockChat();
			}
			else
			{
				unlockChat();
			}
		}
		else if (event.getGameState() != GameState.LOADING)
		{
			typing = false;
			blockedChar = KeyEvent.CHAR_UNDEFINED;
			exitChar = KeyEvent.CHAR_UNDEFINED;
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
		typing = false;
		blockedChar = KeyEvent.CHAR_UNDEFINED;
		exitChar = KeyEvent.CHAR_UNDEFINED;

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

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
		if (!isPublicChatInput())
		{
			return;
		}

		Widget widget = client.getWidget(InterfaceID.Chatbox.INPUT);
		if (widget == null)
		{
			return;
		}

		String text = widget.getText();
		int idx = text == null ? -1 : text.indexOf(':');
		if (idx != -1)
		{
			String newText = text.substring(0, idx) + ": " + input;
			widget.setText(newText);
		}
	}
}
