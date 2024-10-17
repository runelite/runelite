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
import net.runelite.client.config.Notification;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

@ConfigGroup(IdleNotifierConfig.GROUP)
public interface IdleNotifierConfig extends Config
{
	String GROUP = "idlenotifier";

	@ConfigItem(
		keyName = "animationidle",
		name = "Idle Animation Notifications",
		description = "Configures if idle animation notifications are enabled",
		position = 1
	)
	default Notification animationIdle()
	{
		return Notification.ON;
	}

	@ConfigItem(
		keyName = "interactionidle",
		name = "Idle Interaction Notifications",
		description = "Configures if idle interaction notifications are enabled e.g. combat, fishing",
		position = 2
	)
	default Notification interactionIdle()
	{
		return Notification.ON;
	}

	@ConfigItem(
		keyName = "movementidle",
		name = "Idle Movement Notifications",
		description = "Configures if idle movement notifications are enabled e.g. running, walking",
		position = 3
	)
	default Notification movementIdle()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "logoutidle",
		name = "Idle Logout Notifications",
		description = "Configures if the idle logout notifications are enabled",
		position = 4
	)
	default Notification logoutIdle()
	{
		return Notification.ON;
	}

	@ConfigItem(
		keyName = "timeout",
		name = "Idle Notification Delay",
		description = "The notification delay after the player is idle",
		position = 5
	)
	@Units(Units.MILLISECONDS)
	default int getIdleNotificationDelay()
	{
		return 5000;
	}

	@ConfigItem(
		keyName = "hitpointsNotification",
		name = "Hitpoints Notification",
		description = "Configures if hitpoints notifications are enabled",
		position = 6
	)
	default Notification getHitpointsNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "hitpoints",
		name = "Hitpoints Threshold",
		description = "The amount of hitpoints to send a notification at.",
		position = 7
	)
	@Range(min = 1)
	default int getHitpointsThreshold()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "prayerNotification",
		name = "Prayer Notification",
		description = "Configures if prayer notifications are enabled.",
		position = 8
	)
	default Notification getPrayerNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "prayer",
		name = "Prayer Threshold",
		description = "The amount of prayer points to send a notification at.",
		position = 9
	)
	@Range(min = 1)
	default int getPrayerThreshold()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "lowEnergyNotification",
		name = "Low Energy Notification",
		description = "Configures if low energy notifications are enabled",
		position = 10
	)
	default Notification getLowEnergyNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "lowEnergy",
		name = "Low Energy Threshold",
		description = "The amount of energy points remaining to send a notification at.",
		position = 11
	)
	@Units(Units.PERCENT)
	@Range(max = 99)
	default int getLowEnergyThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "highEnergyNotification",
		name = "High Energy Notification",
		description = "Configures if high energy notifications are enabled",
		position = 12
	)
	default Notification getHighEnergyNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "highEnergy",
		name = "High Energy Threshold",
		description = "The amount of energy points reached to send a notification.",
		position = 13
	)
	@Units(Units.PERCENT)
	@Range(min = 1, max = 100)
	default int getHighEnergyThreshold()
	{
		return 100;
	}

	@ConfigItem(
		keyName = "oxygenNotification",
		name = "Oxygen Notification",
		description = "Configures if oxygen notifications are enabled",
		position = 14
	)
	default Notification getOxygenNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "oxygen",
		name = "Oxygen Threshold",
		position = 15,
		description = "The amount of remaining oxygen to send a notification at."
	)
	@Units(Units.PERCENT)
	@Range(min = 1)
	default int getOxygenThreshold()
	{
		return 1;
	}

	@ConfigItem(
		keyName = "specNotification",
		name = "Spec Notification",
		description = "Configures if special attack notifications are enabled",
		position = 16
	)
	default Notification getSpecNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "spec",
		name = "Spec Threshold",
		position = 17,
		description = "The amount of special attack energy reached to send a notification at."
	)
	@Units(Units.PERCENT)
	@Range(min = 1)
	default int getSpecEnergyThreshold()
	{
		return 1;
	}
}
