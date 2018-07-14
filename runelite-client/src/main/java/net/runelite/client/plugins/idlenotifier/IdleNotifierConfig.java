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
		keyName = "timeout",
		name = "Idle Notification Delay (ms)",
		description = "The notification delay after the player is idle",
		position = 1
	)
	default int getIdleNotificationDelay()
	{
		return 5000;
	}

	@ConfigItem(
		keyName = "hitpointsThreshold",
		name = "Hitpoints Notification Threshold",
		description = "The amount of hitpoints to send a notification at. A value of 0 will disable notification.",
		position = 2
	)
	default int getHitpointsThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "prayerThreshold",
		name = "Prayer Notification Threshold",
		description = "The amount of prayer points to send a notification at. A value of 0 will disable notification.",
		position = 3
	)
	default int getPrayerThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "combatidle",
		name = "Combat Idle Notifications",
		description = "Configures if out of combat notifications are enabled",
		position = 4
	)
	default boolean combatIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "woodcutting",
		name = "Woodcutting Idle Notification",
		description = "Configures if woodcutting notifications are enabled",
		position = 5
	)
	default boolean woodcuttingIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "cooking",
		name = "Cooking Idle Notification",
		description = "Configures if cooking notifications are enabled",
		position = 6
	)
	default boolean cookingIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "crafting",
		name = "Crafting Idle Notification",
		description = "Configures if crafting notifications are enabled",
		position = 7
	)
	default boolean craftingIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "fletching",
		name = "Fletching Idle Notification",
		description = "Configures if fletching notifications are enabled",
		position = 8
	)
	default boolean fletchingIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "smithing",
		name = "Smithing Idle Notification",
		description = "Configures if smithing notifications are enabled",
		position = 9
	)
	default boolean smithingIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "fishing",
		name = "Fishing Idle Notification",
		description = "Configures if fishing notifications are enabled",
		position = 10
	)
	default boolean fishingIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "mining",
		name = "Mining Idle Notification",
		description = "Configures if mining notifications are enabled",
		position = 11
	)
	default boolean miningIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "herblore",
		name = "Herblore Idle Notification",
		description = "Configures if herblore notifications are enabled",
		position = 12
	)
	default boolean herbloreIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "prayer2",
		name = "Prayer Idle Notification",
		description = "Configures if prayer notifications are enabled",
		position = 13
	)
	default boolean prayerIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "magic",
		name = "Magic Idle Notification",
		description = "Configures if magic idle notifications are enabled",
		position = 14
	)
	default boolean magicIdle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "idleLogout",
		name = "Idle Logout Notification",
		description = "Configures if the idle logout notification is enabled",
		position = 15
	)
	default boolean idleLogout()
	{
		return true;
	}
}
