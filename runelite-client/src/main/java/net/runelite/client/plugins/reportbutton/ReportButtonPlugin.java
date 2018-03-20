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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;

@PluginDescriptor(
	name = "Report Button"
)
@Slf4j
public class ReportButtonPlugin extends Plugin
{
	private static final ZoneId UTC = ZoneId.of("UTC");
	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);

	private boolean ready;
	private boolean idle;

	private long loginTime;
	private long idleTime;

	@Inject
	private Client client;

	@Inject
	private ReportButtonConfig config;

	@Provides
	ReportButtonConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ReportButtonConfig.class);
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		GameState state = event.getGameState();

		switch (state)
		{
			case LOGGING_IN:
			case HOPPING:
			case CONNECTION_LOST:
			case LOGIN_SCREEN:
				ready = true;
				resetTimers();
				break;
			case LOGGED_IN:
				if (ready)
				{
					loginTime = System.nanoTime();
					ready = false;
				}
				break;
		}
	}

	@Schedule(
		period = 500,
		unit = ChronoUnit.MILLIS
	)
	public void updateReportButtonTime()
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

		if (!config.idleTime())
		{
			switch (config.time())
			{
				case UTC:
					reportButton.setText(getUTCTime());
					break;
				case LOCAL_TIME:
					reportButton.setText(getLocalTime());
					break;
				case LOGIN_TIME:
					reportButton.setText(getFormattedTime(loginTime));
					break;
				case OFF:
					reportButton.setText("Report");
					break;
			}
		}
		else
		{
			if(client.getMouseIdleTicks() > 25
					&& client.getKeyboardIdleTicks() > 25
					&& !idle)
			{
				idle = true;
				idleTime = System.nanoTime();
			}
			else if(client.getMouseIdleTicks() <= 25
					|| client.getKeyboardIdleTicks() <= 25
					&& idle)
			{
				idle = false;
				idleTime = 0L;
			}

			switch (config.time())
			{
				case UTC:
					reportButton.setText(getFormattedTime(idleTime) + "<br>" + getUTCTime());
					break;
				case LOCAL_TIME:
					reportButton.setText(getFormattedTime(idleTime) + "<br>" + getLocalTime());
					break;
				case LOGIN_TIME:
					reportButton.setText(getFormattedTime(idleTime) + "<br>" + getFormattedTime(loginTime));
					break;
				case OFF:
					reportButton.setText(getFormattedTime(idleTime) + "<br>" + "Report");
					break;
			}
		}
	}

	public void resetTimers()
	{
		loginTime = 0L;
		idleTime = 0L;
	}

	public String getUTCTime()
	{
		return LocalTime.now(UTC).format(DATE_TIME_FORMAT);
	}

	public String getLocalTime()
	{
		return LocalTime.now().format(DATE_TIME_FORMAT);
	}

	public String getFormattedTime(long time)
	{
		if(time == 0L)
		{
			return "00:00:00";
		}

		long duration = (System.nanoTime() - time) / 1000000000L;

		String strTime = String.format("%02d:%02d:%02d",
										(duration % 86400) / 3600,
										(duration % 3600) / 60,
										duration % 60);
		return strTime;
	}
}