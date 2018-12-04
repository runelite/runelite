package net.runelite.client.plugins.hotkeys;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@PluginDescriptor(
	name = "Hotkeys",
	description = "Allows you to change hotkeys",
	tags = {"fkeys", "keys"},
	enabledByDefault = false
)
@Slf4j
public class HotkeysPlugin extends Plugin
{

	private static final String PRESS_ENTER_TO_CHAT = "Press Enter to Chat...";
	private static final String SET_CHATBOX_INPUT = "setChatboxInput";
	private static final String BLOCK_CHAT_INPUT = "blockChatInput";



	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private HotkeysListener inputListener;

	@Inject
	private KeyManager keyManager;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean isTyping;

	@Provides
	HotkeysConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HotkeysConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		isTyping = false;
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
					final Color textColor = isChatboxTransparent ? JagexColors.CHAT_TYPED_TEXT_TRANSPARENT_BACKGROUND :
						JagexColors.CHAT_TYPED_TEXT_OPAQUE_BACKGROUND;
					chatboxInput.setText(client.getLocalPlayer().getName() + ": " +
						ColorUtil.wrapWithColorTag(client.getVar(VarClientStr.CHATBOX_TYPED_TEXT) + "*", textColor));
				}
			}
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
				chatboxInput.setText(client.getLocalPlayer().getName() + ": " + PRESS_ENTER_TO_CHAT);
			}
		}
	}

	boolean chatboxFocused()
	{
		Widget chatboxParent = client.getWidget(WidgetInfo.CHATBOX_PARENT);
		if (chatboxParent == null || chatboxParent.getOnKeyListener() == null)
		{
			return false;
		}

		Widget worldMapSearch = client.getWidget(WidgetInfo.WORLD_MAP_SEARCH);
		return worldMapSearch == null || client.getVar(VarClientInt.WORLD_MAP_SEARCH_FOCUSED) != 1;
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		switch (scriptCallbackEvent.getEventName())
		{
			case SET_CHATBOX_INPUT:
				Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
				if (chatboxInput != null)
				{
					if (chatboxFocused() && !isTyping)
					{
						chatboxInput.setText(client.getLocalPlayer().getName() + ": " + PRESS_ENTER_TO_CHAT);
					}
				}
				break;
			case BLOCK_CHAT_INPUT:
				if (!isTyping)
				{
					int[] intStack = client.getIntStack();
					int intStackSize = client.getIntStackSize();
					intStack[intStackSize - 1] = 1;
				}
				break;
		}
	}
}
