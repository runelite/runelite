/*
 * ******************************************************************************
 *  * Copyright (c) 2019 RuneLitePlus
 *  *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 *  *  ST0NEWALL#9112
 *  *   RuneLitePlus Discord: https://discord.gg/Q7wFtCe
 *  *   RuneLitePlus website: https://runelitepl.us
 *  *****************************************************************************
 */

package net.runelite.client.plugins.loottracker;


import java.time.Duration;
import lombok.Getter;

public enum LootRecordDateFilter
{
	HOUR("Hour", Duration.ofHours(1)),
	DAY("Day", Duration.ofDays(1)),
	WEEK("Week", Duration.ofDays(7)),
	MONTH("Month", Duration.ofDays(30)),
	YEAR("Year", Duration.ofDays(365)),
	ALL("All", Duration.ZERO);

	private final String name;
	@Getter
	private final Duration duration;

	private LootRecordDateFilter(String name, Duration duration)
	{
		this.name = name;
		this.duration = duration;
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}
