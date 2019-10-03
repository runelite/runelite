/*
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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Reminders")
public interface RemindersConfig extends Config
{
	@ConfigItem(
		keyName = "breakReminder",
		name = "Break Reminder",
		description = "Reminds you to take a 5-10 minute break every hour.",
		position = 0
	)
	default boolean breakReminder()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hydrationReminder",
		name = "Hydration Reminder",
		description = "Reminds you to drink 4oz/120ml of water every hour",
		position = 1
	)
	default boolean hydrationReminder()
	{
		return false;
	}

	@ConfigItem(
		keyName = "personalReminders",
		name = "Personal Reminders",
		description = "Set your own personal reminders",
		position = 2
	)
	default boolean personalReminders()
	{
		return false;
	}

	@ConfigItem(
		keyName = "personalReminder1",
		name = "Personal Reminder #1",
		description = "Set your first personal reminder",
		position = 3,
		hidden = true,
		unhide = "personalReminders"
	)
	default boolean personalReminder1()
	{
		return false;
	}

	@ConfigItem(
		keyName = "personalReminderText1",
		name = "Personal Reminder Text #1",
		description = "Set the text to your first personal reminder",
		position = 4,
		hidden = true,
		unhide = "personalReminder1"
	)
	default String personalReminderText1()
	{
		return "";
	}

	@ConfigItem(
		keyName = "personalreminderTime1",
		name = "Personal Reminder Time #1",
		description = "Time in minutes for your first personal reminder",
		position = 5,
		hidden = true,
		unhide = "personalReminder1"
	)
	default int personalReminderTime1()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "personalReminder2",
		name = "Personal Reminder #2",
		description = "Set your second personal reminder",
		position = 6,
		hidden = true,
		unhide = "personalReminders"
	)
	default boolean personalReminder2()
	{
		return false;
	}

	@ConfigItem(
		keyName = "personalReminderText2",
		name = "Personal Reminder Text #2",
		description = "Set the text to your second personal reminder",
		position = 7,
		hidden = true,
		unhide = "personalReminder2"
	)
	default String personalReminderText2()
	{
		return "";
	}

	@ConfigItem(
		keyName = "personalreminderTime2",
		name = "Personal Reminder Time #2",
		description = "Time in minutes for your second personal reminder",
		position = 8,
		hidden = true,
		unhide = "personalReminder2"
	)
	default int personalReminderTime2()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "personalReminder3",
		name = "Personal Reminder #3",
		description = "Set your third personal reminder",
		position = 9,
		hidden = true,
		unhide = "personalReminders"
	)
	default boolean personalReminder3()
	{
		return false;
	}

	@ConfigItem(
		keyName = "personalReminderText3",
		name = "Personal Reminder Text #3",
		description = "Set the text to your third personal reminder",
		position = 10,
		hidden = true,
		unhide = "personalReminder3"
	)
	default String personalReminderText3()
	{
		return "";
	}

	@ConfigItem(
		keyName = "personalreminderTime3",
		name = "Personal Reminder Time #3",
		description = "Time in minutes for your third personal reminder",
		position = 11,
		hidden = true,
		unhide = "personalReminder3"
	)
	default int personalReminderTime3()
	{
		return 0;
	}
}
