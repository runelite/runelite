/*
 * ******************************************************************************
 *  * Copyright (c) 2019 openosrs
 *  *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the file authors:
 *  *  ST0NEWALL#9112
 *  *   openosrs Discord: https://discord.gg/Q7wFtCe
 *  *   openosrs website: https://openosrs.com
 *  *****************************************************************************
 */

package net.runelite.client.plugins.loottracker;


import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.Duration;
import lombok.Getter;

public enum LootRecordDateFilter
{

	SESSION("Session", Duration.ofMillis(LootTrackerPlugin.SESSION_START_TIME.toEpochMilli())),
	HOUR("Hour", Duration.ofHours(1)),
	DAY("Day", Duration.ofDays(1)),
	WEEK("Week", Duration.ofDays(7)),
	MONTH("Month", Duration.ofDays(30)),
	YEAR("Year", Duration.ofDays(365)),
	ALL("All", Duration.ZERO);

	private final String name;
	@Getter
	private final Duration duration;
	static RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();


	/**
	 * Constructor for a Loot Tracker filter that filters by date, more specifically Duration.
	 *
	 * @param name - String the name that represents the date filter. This is what will be displayed in the GUI
	 * @param duration - The duration the current time - the time of the loot record must be greater than to display if
	 *                 a date filter other than all or Session is enabled
	 */
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
