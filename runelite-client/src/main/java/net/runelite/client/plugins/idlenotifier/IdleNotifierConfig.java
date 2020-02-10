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
import net.runelite.client.config.Units;

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
		keyName = "interactionidle",
		name = "Idle Interaction Notifications",
		description = "Configures if idle interaction notifications are enabled e.g. combat, fishing",
		position = 2
	)
	default boolean interactionIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "movementidle",
		name = "Idle Movement Notifications",
		description = "Configures if idle movement notifications are enabled e.g. running, walking",
		position = 3
	)
	default boolean movementIdle()
	{
		return false;
	}

	@ConfigItem(
		keyName = "logoutidle",
		name = "Idle Logout Notifications",
		description = "Configures if the idle logout notifications are enabled",
		position = 4
	)
	default boolean logoutIdle()
	{
		return true;
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
		keyName = "hitpoints",
		name = "Hitpoints Notification Threshold",
		description = "The amount of hitpoints to send a notification at. A value of 0 will disable notification.",
		position = 6
	)
	default int getHitpointsThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "prayer",
		name = "Prayer Notification Threshold",
		description = "The amount of prayer points to send a notification at. A value of 0 will disable notification.",
		position = 7
	)
	default int getPrayerThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "oxygen",
		name = "Oxygen Notification Threshold",
		position = 8,
		description = "The amount of remaining oxygen to send a notification at. A value of 0 will disable notification."
	)
	@Units(Units.PERCENT)
	default int getOxygenThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "spec",
		name = "Special Attack Energy Notification Threshold",
		position = 9,
		description = "The amount of spec energy reached to send a notification at. A value of 0 will disable notification."
	)
	@Units(Units.PERCENT)
	default int getSpecEnergyThreshold()
	{
		return 0;
	}
}
