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

@ConfigGroup("timetracking")
public interface TimeTrackingConfig extends Config
{
	String CONFIG_GROUP = "timetracking";
	String AUTOWEED = "autoweed";
	String BIRD_HOUSE = "birdhouse";
	String TIMERS = "timers";
	String STOPWATCHES = "stopwatches";

	@ConfigItem(
		keyName = "estimateRelative",
		name = "Show relative time",
		description = "Show amount of time remaining instead of completion time",
		position = 1
	)
	default boolean estimateRelative()
	{
		return false;
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
		keyName = "birdHouseNotification",
		name = "Bird house notification",
		description = "Notify you when all bird houses are full",
		position = 3
	)
	default boolean birdHouseNotification()
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
