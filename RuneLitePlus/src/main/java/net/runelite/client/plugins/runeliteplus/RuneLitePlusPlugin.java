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

import com.google.inject.Provides;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import api.Client;
import api.events.ConfigChanged;
import api.events.WidgetLoaded;
import api.widgets.WidgetID;
import api.widgets.WidgetInfo;
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

	/* Can't feed this as args to runscript?
	private static final int[] widgetArgs = new int[]
		{
			WidgetInfo.BANK_PIN_EXIT_BUTTON.getId(),
			WidgetInfo.BANK_PIN_FORGOT_BUTTON.getId(),
			WidgetInfo.BANK_PIN_1.getId(),
			WidgetInfo.BANK_PIN_2.getId(),
			WidgetInfo.BANK_PIN_3.getId(),
			WidgetInfo.BANK_PIN_4.getId(),
			WidgetInfo.BANK_PIN_5.getId(),
			WidgetInfo.BANK_PIN_6.getId(),
			WidgetInfo.BANK_PIN_7.getId(),
			WidgetInfo.BANK_PIN_8.getId(),
			WidgetInfo.BANK_PIN_9.getId(),
			WidgetInfo.BANK_PIN_0.getId(),
			WidgetInfo.BANK_PIN_EXIT_BUTTON.getId(),
			WidgetInfo.BANK_PIN_FORGOT_BUTTON.getId(),
			WidgetInfo.BANK_PIN_FIRST_ENTERED.getId(),
			WidgetInfo.BANK_PIN_SECOND_ENTERED.getId(),
			WidgetInfo.BANK_PIN_THIRD_ENTERED.getId(),
			WidgetInfo.BANK_PIN_FOURTH_ENTERED.getId(),
			WidgetInfo.BANK_PIN_INSTRUCTION_TEXT.getId()
		};*/
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
	private int entered = -1;
	private int enterIdx;

	@Override
	protected void startUp() throws Exception
	{
		entered = -1;
		enterIdx = 0;

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
		if (!event.getGroup().equals("runeliteplus"))
		{
			return;
		}

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
		}
		else if (!config.keyboardPin())
		{
			entered = -1;
			enterIdx = 0;
			keyManager.unregisterKeyListener(keyListener);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		entered = -1;
		enterIdx = 0;
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
			//|| !Text.standardize(client.getWidget(WidgetInfo.BANK_PIN_TOP_LEFT_TEXT).getText()).equals("bank of gielinor"))
		{
			return;
		}

		// log.debug("Registering key listener");
		keyListener = new RuneLitePlusKeyListener();
		keyManager.registerKeyListener(keyListener);
	}

	private void handleKey(char c)
	{
		if (client.getWidget(WidgetID.BANK_PIN_GROUP_ID, 0) == null
			|| !client.getWidget(WidgetInfo.BANK_PIN_TOP_LEFT_TEXT).getText().equals("Bank of Gielinor"))
		{
			// log.debug("Key was pressed, but widget wasn't open");
			entered = -1;
			enterIdx = 0;
			keyManager.unregisterKeyListener(keyListener);
			keyListener = null;
			return;
		}

		int num = Character.getNumericValue(c);

	client.runScript(685, num, enterIdx, entered, 13959181, 13959183, 13959184, 13959186, 13959188, 13959190, 13959192, 13959194, 13959196, 13959198, 13959200, 13959202, 13959171, 13959172, 13959173, 13959174, 13959178);

		if (enterIdx == 0)
		{
			entered = num * 1000;
			enterIdx++;
		}
		else if (enterIdx == 1)
		{
			entered += num * 100;
			enterIdx++;
		}
		else if (enterIdx == 2)
		{
			entered += num * 10;
			enterIdx++;
		}
		else if (enterIdx == 3)
		{
			entered = -1;
			enterIdx = 0;
			keyManager.unregisterKeyListener(keyListener);
		}
	}
}
