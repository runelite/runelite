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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
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
			if (!Character.isDigit(keyEvent.getKeyChar()))
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

	private RuneLitePlusKeyListener keyListener = new RuneLitePlusKeyListener();
	private int entered = -1;
	private int enterIdx;
	private boolean expectInput;

	@Override
	protected void startUp() throws Exception
	{
		if (config.customPresence())
		{
			ClientUI.currentPresenceName = ("RuneLitePlus");
			ClientUI.frame.setTitle(ClientUI.currentPresenceName);
			RuneLiteProperties.discordAppID = rlPlusDiscordApp;
			discordService.close();
			discordService.init();
		}

		entered = -1;
		enterIdx = 0;
		expectInput = false;
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
				RuneLiteProperties.discordAppID = rlPlusDiscordApp;
				discordService.close();
				discordService.init();
			}
			else
			{
				ClientUI.currentPresenceName = ("RuneLite");
				ClientUI.frame.setTitle(ClientUI.currentPresenceName);
				RuneLiteProperties.discordAppID = rlDiscordApp;
				discordService.close();
				discordService.init();
			}
		}

		else if (!config.keyboardPin())
		{
			entered = 0;
			enterIdx = 0;
			expectInput = false;
			keyManager.unregisterKeyListener(keyListener);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		entered = 0;
		enterIdx = 0;
		expectInput = false;
		keyManager.unregisterKeyListener(keyListener);
	}

	@Subscribe
	private void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		if (e.getEventName().equals("bankpin"))
		{
			int[] intStack = client.getIntStack();
			int intStackSize = client.getIntStackSize();

			// This'll be anywhere from -1 to 3
			// 0 = first number, 1 second, etc
			// Anything other than 0123 means the bankpin interface closes
			int enterIdx = intStack[intStackSize - 1];

			if (enterIdx < 0 || enterIdx > 3)
			{
				keyManager.unregisterKeyListener(keyListener);
				this.enterIdx = 0;
				this.entered = 0;
				expectInput = false;
				return;
			}
			else if (enterIdx == 0)
			{
				keyManager.registerKeyListener(keyListener);
			}

			this.enterIdx = enterIdx;
			expectInput = true;
		}
	}

	private void handleKey(char c)
	{
		if (client.getWidget(WidgetID.BANK_PIN_GROUP_ID, 0) == null
			|| !client.getWidget(WidgetInfo.BANK_PIN_TOP_LEFT_TEXT).getText().equals("Bank of Gielinor"))
		{
			entered = 0;
			enterIdx = 0;
			expectInput = false;
			keyManager.unregisterKeyListener(keyListener);
			return;
		}

		if (!expectInput)
		{
			return;
		}

		int num = Character.getNumericValue(c);

		// We gotta copy this cause enteridx changes while the script is executing
		int oldEnterIdx = enterIdx;

		// Script 685 will call 653, which in turn will set expectInput to true
		expectInput = false;
		client.runScript(685, num, enterIdx, entered, 13959181, 13959183, 13959184, 13959186, 13959188, 13959190, 13959192, 13959194, 13959196, 13959198, 13959200, 13959202, 13959171, 13959172, 13959173, 13959174, 13959178);

		if (oldEnterIdx == 0)
		{
			entered = num * 1000;
		}
		else if (oldEnterIdx == 1)
		{
			entered += num * 100;
		}
		else if (oldEnterIdx == 2)
		{
			entered += num * 10;
		}
	}
}
