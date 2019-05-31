/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.runeliteplus;


import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientUI;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	loadWhenOutdated = true, // prevent users from disabling
	hidden = true, // prevent users from disabling
	name = "RuneLitePlus",
	description = "Configures various aspects of RuneLitePlus",
	type = PluginType.EXTERNAL
)

@Slf4j
public class RuneLitePlusPlugin extends Plugin
{
	private class RuneLitePlusKeyListener implements KeyListener
	{
		private int lastKeyCycle;

		@Override
		public void keyTyped(KeyEvent keyEvent)
		{
			if (!isNumber(keyEvent))
			{
				return;
			}

			if (client.getGameCycle() - lastKeyCycle <= 5)
			{
				keyEvent.consume();
				return;
			}

			lastKeyCycle = client.getGameCycle();

			clientThread.invoke(() -> handleKey(keyEvent.getKeyChar()));
			keyEvent.consume();
		}

		@Override
		public void keyPressed(KeyEvent keyEvent)
		{
		}

		@Override
		public void keyReleased(KeyEvent keyEvent)
		{
		}

		private boolean isNumber(KeyEvent keyEvent)
		{
			char character = keyEvent.getKeyChar();
			return ArrayUtils.contains(numbers, character);
		}
	}

	private static final ImmutableSet<WidgetInfo> buttons = ImmutableSet.of(
		WidgetInfo.BANK_PIN_1,
		WidgetInfo.BANK_PIN_2,
		WidgetInfo.BANK_PIN_3,
		WidgetInfo.BANK_PIN_4,
		WidgetInfo.BANK_PIN_5,
		WidgetInfo.BANK_PIN_6,
		WidgetInfo.BANK_PIN_7,
		WidgetInfo.BANK_PIN_8,
		WidgetInfo.BANK_PIN_9,
		WidgetInfo.BANK_PIN_0
	);
	public static boolean customPresenceEnabled = false;
	public static final String rlPlusDiscordApp = "560644885250572289";
	public static final String rlDiscordApp = "409416265891971072";
	private static final char[] numbers = "0123456789".toCharArray();

	@Inject
	public RuneLitePlusConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	public DiscordService discordService;

	@Inject
	private KeyManager keyManager;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Provides
	RuneLitePlusConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RuneLitePlusConfig.class);
	}

	private RuneLitePlusKeyListener keyListener;

	@Override
	protected void startUp() throws Exception
	{
		if (getConfig(configManager).customPresence())
		{
			ClientUI.currentPresenceName = ("RuneLitePlus");
			ClientUI.frame.setTitle(ClientUI.currentPresenceName);
		}

		if (config.logOpt())
		{
			Sentry.init("https://f0ed76be2fe847f8b9eb3620fa55d729@sentry.io/1468399?stacktrace.app.packages=net.runelite.client");
		}

		if (config.customPresence())
		{
			RuneLiteProperties.discordAppID = rlPlusDiscordApp;
			discordService.close();
			discordService.init();
		}
		else
		{
			RuneLiteProperties.discordAppID = rlDiscordApp;
			discordService.close();
			discordService.init();
		}
	}

	@Subscribe
	protected void onConfigChanged(ConfigChanged event)
	{
		if (event.getKey().equals("customPresence"))
		{
			if (config.customPresence())
			{
				ClientUI.currentPresenceName = ("RuneLitePlus");
				ClientUI.frame.setTitle(ClientUI.currentPresenceName);
			}
			else
			{
				ClientUI.currentPresenceName = ("RuneLite");
				ClientUI.frame.setTitle(ClientUI.currentPresenceName);
			}

			if (config.customPresence())
			{
				RuneLiteProperties.discordAppID = rlPlusDiscordApp;
				discordService.close();
				discordService.init();
			}
			else
			{
				RuneLiteProperties.discordAppID = rlDiscordApp;
				discordService.close();
				discordService.init();
			}

			if (!config.keyboardPin())
			{
				keyManager.unregisterKeyListener(keyListener);
			}
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(keyListener);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (!config.keyboardPin())
		{
			return;
		}

		if (event.getGroupId() == WidgetID.BANK_GROUP_ID)
		{
			// log.debug("Bank opened, removing key listener");
			keyManager.unregisterKeyListener(keyListener);
			return;
		}
		else if (event.getGroupId() != WidgetID.BANK_PIN_GROUP_ID)
		{
			return;
		}

		// log.debug("Registering key listener");
		keyListener = new RuneLitePlusKeyListener();
		keyManager.registerKeyListener(keyListener);
	}

	private void handleKey(char c)
	{
		if (client.getWidget(WidgetID.BANK_PIN_GROUP_ID, 0) == null)
		{
			// log.debug("Key was pressed, but widget wasn't open");
			keyManager.unregisterKeyListener(keyListener);
			return;
		}

		Map<Character, Widget> buttonMap = new HashMap<>();
		Widget unknown = null;

		for (WidgetInfo w : buttons)
		{
			Widget widget = client.getWidget(w);

			if (widget == null)
			{
				// log.debug(w.toString() + " is null, returning early");
				continue;
			}
			else if (widget.getChild(1) == null || widget.getChild(1).isHidden())
			{
				// log.debug(widget.getId() + " wasn't null, but either the text was missing or child was null");
				unknown = widget;
			}
			else
			{
				try
				{
					char number = widget.getChild(1).getText().charAt(0);
					buttonMap.put(number, widget);
					// log.debug(number + " is widget " + widget.getId());
				}
				catch (IndexOutOfBoundsException e)
				{
					// log.debug("There was no text in widget " + widget.getId());
					unknown = widget;
				}
			}
		}

		if (unknown != null && buttonMap.size() == 9)
		{
			for (char num : numbers)
			{
				if (!buttonMap.containsKey(num))
				{
					// log.debug(num + " must be the unknown char for widget " + unknown.getId());
					buttonMap.put(num, unknown);
				}
			}
		}

		if (buttonMap.size() != 10)
		{
			// log.debug("We didn't have 10 numbers, rip");
			return;
		}

		Widget w = buttonMap.get(c);
//todo once bytecodes work again, re-enable
/*
		client.invokeMenuAction(0, w.getId(), MenuAction.WIDGET_DEFAULT.getId(), 1, "Select", "", w.getCanvasLocation().getX() + 32, w.getCanvasLocation().getY() + 32);
*/
	}
}
