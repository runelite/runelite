/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.prayer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("prayer")
public interface PrayerConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "prayerFlickLocation",
		name = "Pray flick location",
		description = "Choose where to display the prayer flick helper."
	)
	default PrayerFlickLocation prayerFlickLocation()
	{
		return PrayerFlickLocation.NONE;
	}

	@ConfigItem(
		position = 1,
		keyName = "prayerFlickAlwaysOn",
		name = "Never hide prayer flick helper",
		description = "Show prayer flick helper regardless of if you're praying or not."
	)
	default boolean prayerFlickAlwaysOn()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "prayerIndicator",
		name = "Boost indicator",
		description = "Enable infoboxes for prayers."
	)
	default boolean prayerIndicator()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "prayerIndicatorOverheads",
		name = "Overhead indicator",
		description = "Also enable infoboxes for overheads."
	)
	default boolean prayerIndicatorOverheads()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "showPrayerDoseIndicator",
		name = "Show prayer dose indicator",
		description = "Enables the prayer dose indicator."
	)
	default boolean showPrayerDoseIndicator()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "showPrayerTooltip",
		name = "Show prayer orb tooltip",
		description = "Displays time remaining and prayer bonus as a tooltip on the quick-prayer icon."
	)
	default boolean showPrayerStatistics()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "showPrayerBar",
		name = "Show prayer bar",
		description = "Displays prayer bar under HP bar when praying."
	)
	default boolean showPrayerBar()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "prayerBarHideIfNotPraying",
		name = "Hide bar while prayer is inactive",
		description = "Prayer bar will be hidden while prayers are inactive."
	)
	default boolean hideIfNotPraying()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "prayerBarHideIfNonCombat",
		name = "Hide bar while out-of-combat",
		description = "Prayer bar will be hidden while out-of-combat."
	)
	default boolean hideIfOutOfCombat()
	{
		return false;
	}
}