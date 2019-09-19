/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.idlenotifier;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("idlenotifier")
public interface IdleNotifierConfig extends Config
{
	@ConfigItem(
		keyName = "animationidle",
		name = "Idle Animation Notifications",
		description = "Configures if idle animation notifications are enabled",
		position = 1
	)
	default boolean animationIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "outOfItemsIdle",
		name = "Out of Items Idle Notifications",
		position = 2,
		description = "Configures if notifications for running out of items for another action are enabled."
	)
	default boolean outOfItemsIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "animationidlesound",
		name = "Idle Animation Sound",
		description = "Plays a custom sound accompanying Idle Animation notifications",
		position = 3
	)
	default boolean animationIdleSound()
	{
		return false;
	}

	@ConfigItem(
		keyName = "interactionidle",
		name = "Idle Interaction Notifications",
		description = "Configures if idle interaction notifications are enabled e.g. combat, fishing",
		position = 4
	)
	default boolean interactionIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "interactionidlesound",
		name = "Idle Interaction Sound",
		description = "Plays a custom sound accompanying Idle Interaction notifications",
		position = 5
	)
	default boolean interactionIdleSound()
	{
		return false;
	}

	@ConfigItem(
		keyName = "movementidle",
		name = "Idle Movement Notifications",
		description = "Configures if idle movement notifications are enabled e.g. running, walking",
		position = 6
	)
	default boolean movementIdle()
	{
		return false;
	}

	@ConfigItem(
		keyName = "logoutidle",
		name = "Idle Logout Notifications",
		description = "Configures if the idle logout notifications are enabled",
		position = 7
	)
	default boolean logoutIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "outofcombatsound",
		name = "Out of Combat Sound",
		description = "Plays a custom sound whenever you leave combat",
		position = 8
	)
	default boolean outOfCombatSound()
	{
		return false;
	}

	@ConfigItem(
		keyName = "skullNotification",
		name = "Skull Notification",
		description = "Receive a notification when you skull.",
		position = 9
	)
	default boolean showSkullNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "unskullNotification",
		name = "Unskull Notification",
		description = "Receive a notification when you unskull.",
		position = 10
	)
	default boolean showUnskullNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "timeout",
		name = "Idle Notification Delay (ms)",
		description = "The notification delay after the player is idle",
		position = 11
	)
	default int getIdleNotificationDelay()
	{
		return 5000;
	}

	@ConfigItem(
		keyName = "hitpoints",
		name = "Hitpoints Notification Threshold",
		description = "The amount of hitpoints to send a notification at. A value of 0 will disable notification.",
		position = 12
	)
	default int getHitpointsThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "playHealthSound",
		name = "Play sound for Low Health",
		description = "Will play a sound for every Low Health notification sent",
		position = 13
	)
	default boolean getPlayHealthSound()
	{
		return false;
	}

	@ConfigItem(
		keyName = "prayer",
		name = "Prayer Notification Threshold",
		description = "The amount of prayer points to send a notification at. A value of 0 will disable notification.",
		position = 14
	)
	default int getPrayerThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "playPrayerSound",
		name = "Play sound for Low Prayer",
		description = "Will play a sound for every Low Prayer notification sent",
		position = 15
	)
	default boolean getPlayPrayerSound()
	{
		return false;
	}

	@ConfigItem(
		keyName = "oxygen",
		name = "Oxygen Notification Threshold",
		description = "The amount of remaining oxygen to send a notification at. A value of 0 will disable notification.",
		position = 16
	)
	default int getOxygenThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "spec",
		name = "Special Attack Energy Notification Threshold",
		description = "The amount of spec energy reached to send a notification at. A value of 0 will disable notification.",
		position = 17
	)
	default int getSpecEnergyThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "specSound",
		name = "Special Attack Energy Sound",
		description = "Plays a custom sound accompanying Special Attack energy notifications",
		position = 18
	)
	default boolean getSpecSound()
	{
		return false;
	}

	@ConfigItem(
		keyName = "overspec",
		name = "Over Special Energy Notification",
		description = "Will repeat notifications for any value over the special energy threshold",
		position = 19
	)
	default boolean getOverSpecEnergy()
	{
		return false;
	}


	@ConfigSection(
		position = 20,
		keyName = "pvpSection",
		name = "PvP",
		description = ""
	)
	default boolean pvpSection()
	{
		return false;
	}

	@ConfigItem(
		keyName = "pkers",
		name = "PKer Notifier",
		description = "Notifies if an attackable player based on your level range appears on screen.",
		position = 21,
		section = "pvpSection",
		warning = "This will not notify you if the player is in your cc or is online on your friends list."
	)
	default boolean notifyPkers()
	{
		return false;
	}

	@ConfigItem(
		keyName = "resourceDoor",
		name = "Resource Door Notifier",
		description = "Notifies if the wilderness resource area door is opened",
		position = 22,
		section = "pvpSection"
	)
	default boolean notifyResourceDoor()
	{
		return false;
	}
}
