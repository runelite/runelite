/*
 * Copyright (c) 2019, jkybtw <https://github.com/jkybtw>
 * Copyright (c) 2019, openosrs <https://openosrs.com>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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
package net.runelite.client.plugins.reminders;

import com.google.inject.Provides;
import static java.lang.Math.floor;
import static java.time.Duration.between;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.task.Schedule;
import javax.inject.Inject;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@PluginDescriptor(
	name = "Reminders",
	description = "various reminders",
	tags = {"session", "reminder", "hydrate", "hydration"},
	enabledByDefault = false,
	type = PluginType.UTILITY
)

@Slf4j
public class RemindersPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Inject
	private RemindersConfig config;

	@Inject
	private ChatMessageManager chatMessageManager;

	private Instant loginTime;
	private boolean ready;
	private int seconds;
	private int minutes;
	private int hours;
	private int ounces;
	private int millilitres;
	private boolean hydrationReminder;
	private boolean breakReminder;
	private boolean personalReminders;
	private boolean personalReminder1;
	private String personalReminderText1;
	private int personalReminderTime1;
	private boolean personalReminder2;
	private String personalReminderText2;
	private int personalReminderTime2;
	private boolean personalReminder3;
	private String personalReminderText3;
	private int personalReminderTime3;



	@Provides
	RemindersConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RemindersConfig.class);
	}

	@Override
	public void startUp()
	{
		addSubscriptions();
		updateConfig();
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);
		loginTime = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
	}

	public void onGameStateChanged(GameStateChanged event)
	{
		final GameState state = event.getGameState();

		switch (state)
		{
			case LOGIN_SCREEN:
			case LOGIN_SCREEN_AUTHENTICATOR:
			case LOGGING_IN:
				ready = true;
				loginTime = null;
				break;
			case LOGGED_IN:
				if (ready)
				{
					loginTime = Instant.now();
					ready = false;
				}
				break;
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("Reminders"))
		{
			updateConfig();
		}
	}

	private void timers()
	{
		if (loginTime == null)
		{
			return;
		}
		seconds = 60;
		minutes = (int) floor(between(loginTime, Instant.now()).getSeconds() / seconds);
		hours = minutes / seconds;
		ounces = 4 * hours;
		millilitres = 120 * hours;
	}

	private String pluralizeTime(String time, int count)
	{
		final StringBuilder sb = new StringBuilder();
		sb
			.append(count)
			.append(" ")
			.append(time);
		if (count != 1)
		{
			sb.append("s");
		}
		return sb.toString();
	}

	private void breakReminders()
	{
		timers();
		if (!this.breakReminder)
		{
			log.error("breakReminder - Unexpected value: " + hours);
		}

		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(
			new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("You have been logged in for ")
				.append(pluralizeTime("hour", hours))
				.append(". You should take a 5-10 minute break.")
				.build())
			.build());
	}

	private void hydrationReminders()
	{
		timers();
		if (!this.hydrationReminder)
		{
			log.error("hydrationReminder - Unexpected value: " + hours);
		}

		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(
			new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("You have been logged in for ")
				.append(pluralizeTime("hour", hours))
				.append(". By this point, you should have consumed at least " + ounces + "oz (" + millilitres + "ml) of Water to maintain optimum hydration.")
				.build())
			.build());
	}

	private void personalReminder1()
	{
		if (!this.personalReminders && !this.personalReminder1)
		{
			log.error("personalReminder1 - Unexpected value: " + this.personalReminderText1 + hours);
		}
		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(
			new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(this.personalReminderText1)
				.build())
			.build());
	}

	private void personalReminder2()
	{
		if (!this.personalReminders && !this.personalReminder2)
		{
			log.error("personalReminder2 - Unexpected value: " + this.personalReminderText2 + hours);
		}
		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(
			new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(this.personalReminderText2)
				.build())
			.build());
	}

	private void personalReminder3()
	{
		if (!this.personalReminders && !this.personalReminder3)
		{
			log.error("personalReminder3 - Unexpected value: " + this.personalReminderText3 + hours);
		}
		chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(
			new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(this.personalReminderText3)
				.build())
			.build());
	}


	@Schedule(
		period = 1,
		unit = ChronoUnit.MINUTES
	)
	public void reminders()
	{

		timers();
		if (minutes % seconds == 0 && minutes > 0)
		{
			if (this.breakReminder)
			{
				breakReminders();
			}
			if (this.hydrationReminder)
			{
				hydrationReminders();
			}
		}
		if (minutes % this.personalReminderTime1 == 0 && minutes > 0 && !this.personalReminderText1.isEmpty())
		{
			personalReminder1();
		}
		if (minutes % this.personalReminderTime2 == 0 && minutes > 0 && !this.personalReminderText2.isEmpty())
		{
			personalReminder2();
		}
		if (minutes % this.personalReminderTime3 == 0 && minutes > 0 && !this.personalReminderText3.isEmpty())
		{
			personalReminder3();
		}
	}

	private void updateConfig()
	{
		this.hydrationReminder = config.hydrationReminder();
		this.breakReminder = config.breakReminder();
		this.personalReminders = config.personalReminders();
		this.personalReminder1 = config.personalReminder1();
		this.personalReminder2 = config.personalReminder2();
		this.personalReminder3 = config.personalReminder3();
		this.personalReminderText1 = config.personalReminderText1();
		this.personalReminderText2 = config.personalReminderText2();
		this.personalReminderText3 = config.personalReminderText3();
		this.personalReminderTime1 = config.personalReminderTime1();
		this.personalReminderTime2 = config.personalReminderTime2();
		this.personalReminderTime3 = config.personalReminderTime3();
	}
}
