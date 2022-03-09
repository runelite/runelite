/*
 * Copyright (c) 2018 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("timetracking")
public interface TimeTrackingConfig extends Config
{
	String CONFIG_GROUP = "timetracking";
	String FARM_TICK_OFFSET = "farmTickOffset";
	String FARM_TICK_OFFSET_PRECISION = "farmTickOffsetPrecision";
	String AUTOWEED = "autoweed";
	String BIRD_HOUSE = "birdhouse";
	String BOTANIST = "botanist";
	String TIMERS = "timers";
	String STOPWATCHES = "stopwatches";
	String PREFER_SOONEST = "preferSoonest";
	String NOTIFY = "notify";
	String BIRDHOUSE_NOTIFY = "birdHouseNotification";

	@ConfigItem(
		keyName = "timeFormatMode",
		name = "Time format",
		description = "What format to display times in",
		position = 1
	)
	default TimeFormatMode timeFormatMode()
	{
		return TimeFormatMode.ABSOLUTE_24H;
	}

	@ConfigItem(
		keyName = "timerNotification",
		name = "Timer notification",
		description = "Notify you whenever a timer has finished counting down",
		position = 2
	)
	default boolean timerNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "farmingContractInfoBox",
		name = "Show farming contract infobox",
		description = "Show an infobox of your current farming contract when inside the farming guild",
		position = 4
	)
	default boolean farmingContractInfoBox()
	{
		return true;
	}

	@ConfigItem(
		keyName = "defaultTimerMinutes",
		name = "Default Time",
		description = "The default time for the timer in minutes",
		position = 5
	)
	@Units(Units.MINUTES)
	default int defaultTimerMinutes()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "sortOrder",
		name = "Sort Order",
		description = "The order in which to sort the timers",
		position = 6
	)
	default SortOrder sortOrder()
	{
		return SortOrder.NONE;
	}

	@ConfigItem(
		keyName = "timerWarningThreshold",
		name = "Warning Threshold",
		description = "The time at which to change the timer color to the warning color",
		position = 6
	)
	@Units(Units.SECONDS)
	default int timerWarningThreshold()
	{
		return 10;
	}

	@ConfigItem(
		keyName = PREFER_SOONEST,
		name = "Prefer soonest completion",
		description = "When displaying completion times on the overview, prefer showing the soonest any patch will complete.",
		position = 7
	)
	default boolean preferSoonest()
	{
		return false;
	}

	@ConfigItem(
		keyName = "activeTab",
		name = "Active Tab",
		description = "The currently selected tab",
		hidden = true
	)
	default Tab activeTab()
	{
		return Tab.CLOCK;
	}

	@ConfigItem(
		keyName = "activeTab",
		name = "",
		description = "",
		hidden = true
	)
	void setActiveTab(Tab t);
}
