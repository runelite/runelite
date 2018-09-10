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

@ConfigGroup("idlenotifier")
public interface IdleNotifierConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "animationidle",
		name = "Idle Animation Notifications",
		description = "Enable idle animation notifications."
	)
	default boolean animationIdle()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "combatidle",
		name = "Combat Idle Notifications",
		description = "Enable out of combat notifications."
	)
	default boolean combatIdle()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "logoutidle",
		name = "Idle Logout Notifications",
		description = "Enable idle logout notifications."
	)
	default boolean logoutIdle()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "ignoreMouseActivity",
		name = "Ignore Mouse Activity",
		description = "Send notifications even if there has been mouse activity in the past 200ms."
	)
	default boolean ignoreMouseActivity()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "timeout",
		name = "Idle Notification Delay (ms)",
		description = "The notification delay after the player is idle."
	)
	default int getIdleNotificationDelay()
	{
		return 5000;
	}

	@ConfigItem(
		position = 6,
		keyName = "hitpoints",
		name = "Hitpoints Notification Threshold",
		description = "The amount of hitpoints to send a notification at. A value of 0 will disable notification."
	)
	default int getHitpointsThreshold()
	{
		return 0;
	}

	@ConfigItem(
		position = 7,
		keyName = "prayer",
		name = "Prayer Notification Threshold",
		description = "The amount of prayer points to send a notification at. A value of 0 will disable notification."
	)
	default int getPrayerThreshold()
	{
		return 0;
	}
}
