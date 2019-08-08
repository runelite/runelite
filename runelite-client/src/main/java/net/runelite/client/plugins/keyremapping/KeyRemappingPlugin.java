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
package net.runelite.client.plugins.keyremapping;

import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.IconID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Key Remapping",
	description = "Allows use of WASD keys for camera movement with 'Press Enter to Chat', and remapping number keys to F-keys",
	tags = {"enter", "chat", "wasd", "camera"},
	enabledByDefault = false
)
@Singleton
public class KeyRemappingPlugin extends Plugin
{
	private static final String PRESS_ENTER_TO_CHAT = "Press Enter to Chat...";
	private static final String SCRIPT_EVENT_SET_CHATBOX_INPUT = "setChatboxInput";
	private static final String SCRIPT_EVENT_BLOCK_CHAT_INPUT = "blockChatInput";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private KeyRemappingConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private KeyRemappingListener inputListener;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean typing;

	private boolean hideDisplayName;
	@Getter(AccessLevel.PACKAGE)
	private boolean cameraRemap;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind up;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind down;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind left;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind right;
	@Getter(AccessLevel.PACKAGE)
	private boolean fkeyRemap;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f1;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f2;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f3;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f4;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f5;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f6;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f7;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f8;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f9;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f10;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f11;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind f12;
	@Getter(AccessLevel.PACKAGE)
	private ModifierlessKeybind esc;

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		typing = false;
		keyManager.registerKeyListener(inputListener);

		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				lockChat();
				// Clear any typed text
				client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, "");
			}
		});
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				unlockChat();
			}
		});

		keyManager.unregisterKeyListener(inputListener);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ScriptCallbackEvent.class, this, this::onScriptCallbackEvent);
	}

	@Provides
	KeyRemappingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KeyRemappingConfig.class);
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
		return worldMapSearch == null || client.getVar(VarClientInt.WORLD_MAP_SEARCH_FOCUSED) != 1;
	}

	/**
	 * Check if a dialog is open that will grab numerical input, to prevent F-key remapping
	 * from triggering.
	 *
	 * @return
	 */
	boolean isDialogOpen()
	{
		// Most chat dialogs with numerical input are added without the chatbox or its key listener being removed,
		// so chatboxFocused() is true. The chatbox onkey script uses the following logic to ignore key presses,
		// so we will use it too to not remap F-keys.
		return isHidden(WidgetInfo.CHATBOX_MESSAGES) || isHidden(WidgetInfo.CHATBOX_TRANSPARENT_LINES);
	}

	private boolean isHidden(WidgetInfo widgetInfo)
	{
		Widget w = client.getWidget(widgetInfo);
		return w == null || w.isSelfHidden();
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("keyremapping"))
		{
			return;
		}

		updateConfig();

		clientThread.invoke(() ->
			{
				Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
				if (chatboxInput != null && chatboxInput.getText().endsWith(PRESS_ENTER_TO_CHAT))
				{
					chatboxInput.setText(getWaitingText());
				}
			}
		);
	}

	private void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		switch (scriptCallbackEvent.getEventName())
		{
			case SCRIPT_EVENT_SET_CHATBOX_INPUT:
				Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
				if (chatboxInput != null && chatboxFocused() && !typing)
				{
					chatboxInput.setText(getWaitingText());
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
		Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
		if (chatboxInput != null)
		{
			chatboxInput.setText(getWaitingText());
		}
	}

	void unlockChat()
	{
		Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
		if (chatboxInput != null && client.getGameState() == GameState.LOGGED_IN)
		{
			final boolean isChatboxTransparent = client.isResized() && client.getVar(Varbits.TRANSPARENT_CHATBOX) == 1;
			final Color textColor = isChatboxTransparent ? JagexColors.CHAT_TYPED_TEXT_TRANSPARENT_BACKGROUND : JagexColors.CHAT_TYPED_TEXT_OPAQUE_BACKGROUND;
			chatboxInput.setText(getPlayerNameWithIcon() + ": " + ColorUtil.wrapWithColorTag(client.getVar(VarClientStr.CHATBOX_TYPED_TEXT) + "*", textColor));
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

	private String getWaitingText()
	{
		if (this.hideDisplayName)
		{
			return PRESS_ENTER_TO_CHAT;
		}
		else
		{
			return getPlayerNameWithIcon() + ": " + PRESS_ENTER_TO_CHAT;
		}
	}

	private void updateConfig()
	{
		this.hideDisplayName = config.hideDisplayName();
		this.cameraRemap = config.cameraRemap();
		this.up = config.up();
		this.down = config.down();
		this.left = config.left();
		this.right = config.right();
		this.fkeyRemap = config.fkeyRemap();
		this.f1 = config.f1();
		this.f2 = config.f2();
		this.f3 = config.f3();
		this.f4 = config.f4();
		this.f5 = config.f5();
		this.f6 = config.f6();
		this.f7 = config.f7();
		this.f8 = config.f8();
		this.f9 = config.f9();
		this.f10 = config.f10();
		this.f11 = config.f11();
		this.f12 = config.f12();
		this.esc = config.esc();
	}
}
