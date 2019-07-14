/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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
package net.runelite.client.plugins.reportbutton;

import com.google.inject.Provides;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;

@PluginDescriptor(
	name = "Report Button",
	description = "Replace the text on the Report button with the current time",
	tags = {"time", "utc"}
)
@Singleton
public class ReportButtonPlugin extends Plugin
{
	private static final ZoneId UTC = ZoneId.of("UTC");
	private static final ZoneId JAGEX = ZoneId.of("Europe/London");

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMM. dd, yyyy");

	private Instant loginTime;
	private boolean ready;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ReportButtonConfig config;

	@Inject
	private EventBus eventBus;

	private TimeStyle timeStyle;

	@Provides
	ReportButtonConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ReportButtonConfig.class);
	}

	@Override
	public void startUp()
	{
		addSubscriptions();

		this.timeStyle = config.time();
		clientThread.invoke(this::updateReportButtonTime);
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		clientThread.invoke(() ->
		{
			Widget reportButton = client.getWidget(WidgetInfo.CHATBOX_REPORT_TEXT);
			if (reportButton != null)
			{
				reportButton.setText("Report");
			}
		});
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		GameState state = event.getGameState();

		switch (state)
		{
			case LOGGING_IN:
			case HOPPING:
			case CONNECTION_LOST:
				ready = true;
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

	@Schedule(
		period = 500,
		unit = ChronoUnit.MILLIS
	)
	public void updateSchedule()
	{
		updateReportButtonTime();
	}

	private void updateReportButtonTime()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Widget reportButton = client.getWidget(WidgetInfo.CHATBOX_REPORT_TEXT);
		if (reportButton == null)
		{
			return;
		}

		switch (this.timeStyle)
		{
			case UTC:
				reportButton.setText(getUTCTime());
				break;
			case JAGEX:
				reportButton.setText(getJagexTime());
				break;
			case LOCAL_TIME:
				reportButton.setText(getLocalTime());
				break;
			case LOGIN_TIME:
				reportButton.setText(getLoginTime());
				break;
			case DATE:
				reportButton.setText(getDate());
				break;
			case OFF:
				reportButton.setText("Report");
				break;
		}
	}

	private String getLoginTime()
	{
		if (loginTime == null)
		{
			return "Report";
		}

		Duration duration = Duration.between(loginTime, Instant.now());
		LocalTime time = LocalTime.ofSecondOfDay(duration.getSeconds());
		return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}

	private static String getLocalTime()
	{
		return LocalTime.now().format(DATE_TIME_FORMAT);
	}

	private static String getUTCTime()
	{
		LocalTime time = LocalTime.now(UTC);
		return time.format(DATE_TIME_FORMAT);
	}

	private static String getJagexTime()
	{
		LocalTime time = LocalTime.now(JAGEX);
		return time.format(DATE_TIME_FORMAT);
	}

	private static String getDate()
	{
		return DATE_FORMAT.format(new Date());
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("regenmeter"))
		{
			this.timeStyle = config.time();
		}
	}
}
