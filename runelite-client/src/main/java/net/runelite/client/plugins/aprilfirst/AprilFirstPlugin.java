/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.aprilfirst;

import com.google.common.eventbus.Subscribe;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "April Fools",
	description = "Happy April Fools!",
	tags = {"April", "fools"}
)
@Slf4j
public class AprilFirstPlugin extends Plugin
{
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd");
	private static final String date = DATE_TIME_FORMATTER.format(LocalDate.now());
	private static final boolean enabled = date.equals("04/01") || true;
	private static final int EMPTY_BANK_CHANCE = 20; // Percent chance for feature to trigger


	private static final String IRONMAN_ICON = "<img=2>";
	private static final String ULTIMATE_IRONMAN_ICON = "<img=3>";
	private static final String HARDCORE_IRONMAN_ICON = "<img=10>";
	private static final String NAME_SUFFIX = ": ";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private OverlayManager overlayManager;

	// Using overlay for quicker redraws of play username
	@Inject
	private AprilFirstOverlay aprilFirstOverlay;

	// Empty Bank Feature
	private boolean bankOpened = false;
	private Widget[] widgets;

	// Fake Account Type Feature
	@Getter
	private String fakeName = "";
	private boolean isRunning = false;

	// Fake Defence Level overlay
	@Getter
	private int defenceLevel = -1;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(aprilFirstOverlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(aprilFirstOverlay);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!enabled)
		{
			return;
		}

		boolean old = bankOpened;
		bankOpened = client.getWidget(WidgetInfo.BANK_TITLE_BAR) != null;
		if (old != bankOpened)
		{
			bankToggled();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged changed)
	{
		if (!enabled)
		{
			return;
		}

		if (changed.getGameState().equals(GameState.LOGGING_IN) && !isRunning)
		{
			isRunning = true;
			clientThread.invokeLater(() ->
			{
				Player p = client.getLocalPlayer();
				// Checking for local username to ensure player has finished logging in.
				if (p != null && p.getName() != null)
				{
					toggleIcon(client.getAccountType());
					defenceLevel = client.getRealSkillLevel(Skill.DEFENCE);
					isRunning = false;
					return true;
				}
				else
				{
					return false;
				}
			});
		}
	}

	private void bankToggled()
	{
		if (bankOpened)
		{
			if (rng(EMPTY_BANK_CHANCE))
			{
				emptyBank();
			}
		}
		else
		{
			widgets = null;
		}
	}

	private void toggleIcon(AccountType t)
	{
		AccountType n;
		switch (t)
		{
			case IRONMAN:
				sendMessage("Your account has been successfully downgraded to a normal account!");
				n = AccountType.NORMAL;
				break;
			case HARDCORE_IRONMAN:
				sendMessage("Your account has been manually downgraded to normal iron status per your request!");
				n = AccountType.IRONMAN;
				break;
			case NORMAL:
				sendMessage("Your account has been successfully upgraded to an iron man account!");
				n = AccountType.IRONMAN;
				break;
			case ULTIMATE_IRONMAN:
				sendMessage("Your account has been successfully downgraded to a Hardcore iron!");
				n = AccountType.HARDCORE_IRONMAN;
				break;
			default:
				return;
		}

		updateInputName(n);
	}

	private void emptyBank()
	{
		log.debug("Emptying bank contents");
		Widget bankWidget = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
		bankWidget.deleteAllChildren();
		log.debug("Removed all items in bank");
		Widget w2 = client.getWidget(WidgetInfo.BANK_SPACE_TITLE);
		w2.setText("0");
		log.debug("Set current bank item count to 0");
		Widget w3 = client.getWidget(WidgetInfo.BANK_TABS_BAR);
		if (widgets == null)
		{
			widgets = w3.getChildren();
			int i = 0;
			for (Widget w : widgets)
			{
				if (i != 0 && i != widgets.length / 2)
				{
					// Hide all but main tab and its icon
					w.setHidden(true);
				}
				else
				{
					// Prevent click action on main tab
					w.setAction(0, null);
					w.setAction(w.getActions().length - 1, null);
				}
				i++;
			}
		}
		w3.setChildren(widgets);
		log.debug("Removed all bank tabs");

		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);
		widgetBankTitleBar.setText("The Bank of Gielinor");
		log.debug("Reset bank title");
	}

	private void updateInputName(AccountType t)
	{
		String prefix = "";
		switch (t)
		{
			case IRONMAN:
				prefix = IRONMAN_ICON;
				break;
			case HARDCORE_IRONMAN:
				prefix = HARDCORE_IRONMAN_ICON;
				break;
			case NORMAL:
				break;
			case ULTIMATE_IRONMAN:
				prefix = ULTIMATE_IRONMAN_ICON;
				break;
			default:
				return;
		}

		fakeName = prefix + client.getLocalPlayer().getName() + NAME_SUFFIX;
		log.debug("Updated fakeName to {}", fakeName);
	}

	private boolean rng(int percent)
	{
		Random r = new Random();
		int v = r.nextInt(100);
		return v < percent;
	}

	private void sendMessage(String msg)
	{
		log.debug("Sending chat message: {}", msg);
		final String message = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append(msg)
			.build();

		chatMessageManager.queue(
			QueuedMessage.builder()
				.type(ChatMessageType.GAME)
				.runeLiteFormattedMessage(message)
				.build());
	}
}
