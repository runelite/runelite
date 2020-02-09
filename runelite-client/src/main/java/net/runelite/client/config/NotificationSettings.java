/*
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.config;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;
import net.runelite.client.Notifier;

@Data
@Accessors(fluent = true)
@Wither
public class NotificationSettings
{
	public enum States
	{
		OFF,
		ON,
		CUSTOM
	}

	public static final String KEY_NAME = "notificationSettings";

	@ConfigItem(
		keyName = "notificationState",
		name = "Notifications",
		description = "Controls whether notifications for this plugin are ignored(OFF), use the global settings(ON), or use plugin-level settings(CUSTOM).",
		position = 990
	)
	private final NotificationSettings.States notificationState;

	@ConfigItem(
		keyName = "enableTrayNotifications",
		name = "Enable tray notifications",
		description = "Enables tray notifications",
		position = 991
	)
	private final Boolean enableTrayNotifications;

	@ConfigItem(
		keyName = "requestFocusOnNotification",
		name = "Request focus on notification",
		description = "Toggles window focus request",
		position = 992
	)
	private final Boolean requestFocusOnNotification;

	@ConfigItem(
		keyName = "notificationSound",
		name = "Notification sound",
		description = "Enables the playing of a beep sound when notifications are displayed",
		position = 993
	)
	private final Notifier.NativeCustomOff notificationSound;

	@ConfigItem(
		keyName = "enableGameMessageNotification",
		name = "Enable game message notifications",
		description = "Puts a notification message in the chatbox",
		position = 994
	)
	private final Boolean enableGameMessageNotification;

	@ConfigItem(
		keyName = "flashNotification",
		name = "Flash notification",
		description = "Flashes the game frame as a notification",
		position = 995
	)
	private final FlashNotification flashNotification;

	@ConfigItem(
		keyName = "sendNotificationsWhenFocused",
		name = "Send notifications when focused",
		description = "Toggles all notifications for when the client is focused",
		position = 996
	)
	private final Boolean sendNotificationsWhenFocused;
}
