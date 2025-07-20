/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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
package net.runelite.client.plugins.timetracking.clocks;

import com.google.common.base.Strings;
import com.google.common.collect.Comparators;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.Getter;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.timetracking.SortOrder;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Singleton
public class ClockManager
{
	@Inject
	private ConfigManager configManager;

	@Inject
	private TimeTrackingConfig config;

	@Inject
	private Notifier notifier;

	@Inject
	private Gson gson;

	@Getter
	private final List<Timer> timers = new CopyOnWriteArrayList<>();

	@Getter
	private final List<Stopwatch> stopwatches = new ArrayList<>();

	@Getter
	private final ClockTabPanel clockTabPanel = new ClockTabPanel(this);

	void addTimer()
	{
		timers.add(new Timer("Timer " + (timers.size() + 1), config.defaultTimerMinutes() * 60));
		saveTimers();

		SwingUtilities.invokeLater(clockTabPanel::rebuild);
	}

	void addStopwatch()
	{
		stopwatches.add(new Stopwatch("Stopwatch " + (stopwatches.size() + 1)));
		saveStopwatches();

		SwingUtilities.invokeLater(clockTabPanel::rebuild);
	}

	void removeTimer(Timer timer)
	{
		timers.remove(timer);
		saveTimers();

		SwingUtilities.invokeLater(clockTabPanel::rebuild);
	}

	void removeStopwatch(Stopwatch stopwatch)
	{
		stopwatches.remove(stopwatch);
		saveStopwatches();

		SwingUtilities.invokeLater(clockTabPanel::rebuild);
	}

	public long getActiveTimerCount()
	{
		return timers.stream().filter(Timer::isActive).count();
	}

	public long getActiveStopwatchCount()
	{
		return stopwatches.stream().filter(Stopwatch::isActive).count();
	}

	/**
	 * Checks if any timers have completed, and send notifications if required.
	 */
	public boolean checkCompletion()
	{
		boolean changed = false;

		for (Timer timer : timers)
		{
			if (timer.isActive() && timer.getDisplayTime() == 0)
			{
				timer.pause();
				changed = true;

				notifier.notify(config.timerNotification(), "[" + timer.getName() + "] has finished counting down.");

				if (timer.isLoop())
				{
					timer.start();
				}
			}
		}

		if (changed)
		{
			saveTimers();
			SwingUtilities.invokeLater(clockTabPanel::rebuild);
		}

		return changed;
	}

	/**
	 * Checks to ensure the timers are in the correct order.
	 * If they are not, sort them and rebuild the clock panel
	 *
	 * @return whether the timer order was changed or not
	 */
	public boolean checkTimerOrder()
	{
		SortOrder sortOrder = config.sortOrder();
		if (sortOrder != SortOrder.NONE)
		{
			Comparator<Timer> comparator = Comparator.comparingLong(Timer::getDisplayTime);
			if (sortOrder == SortOrder.DESC)
			{
				comparator = comparator.reversed();
			}

			if (!Comparators.isInOrder(timers, comparator))
			{
				timers.sort(comparator);
				SwingUtilities.invokeLater(clockTabPanel::rebuild);
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets the warning flag on each timer that should be in the warning state
	 */
	public void checkForWarnings()
	{
		for (Timer timer : timers)
		{
			timer.setWarning(timer.getDisplayTime() <= config.timerWarningThreshold());
		}
	}

	public void loadTimers()
	{
		final String timersJson = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.TIMERS);

		if (!Strings.isNullOrEmpty(timersJson))
		{
			final List<Timer> timers = gson.fromJson(timersJson, new TypeToken<ArrayList<Timer>>()
			{
			}.getType());

			this.timers.clear();
			this.timers.addAll(timers);
			SwingUtilities.invokeLater(clockTabPanel::rebuild);
		}
	}

	public void loadStopwatches()
	{
		final String stopwatchesJson = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.STOPWATCHES);

		if (!Strings.isNullOrEmpty(stopwatchesJson))
		{
			final List<Stopwatch> stopwatches = gson.fromJson(stopwatchesJson, new TypeToken<ArrayList<Stopwatch>>()
			{
			}.getType());

			this.stopwatches.clear();
			this.stopwatches.addAll(stopwatches);
			SwingUtilities.invokeLater(clockTabPanel::rebuild);
		}
	}

	public void clear()
	{
		timers.clear();
		stopwatches.clear();

		SwingUtilities.invokeLater(clockTabPanel::rebuild);
	}

	void saveToConfig()
	{
		saveTimers();
		saveStopwatches();
	}

	void saveTimers()
	{
		final String json = gson.toJson(timers);
		configManager.setConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.TIMERS, json);
	}

	void saveStopwatches()
	{
		final String json = gson.toJson(stopwatches);
		configManager.setConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.STOPWATCHES, json);
	}
}
