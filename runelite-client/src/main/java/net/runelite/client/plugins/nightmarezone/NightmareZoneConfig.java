/*
 * Copyright (c) 2018, Nickolaj <https://github.com/fire-proof>
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
package net.runelite.client.plugins.nightmarezone;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "nightmareZone",
		name = "Nightmare Zone",
		description = "Configuration for the nightmare zone plugin"
)
public interface NightmareZoneConfig extends Config
{
	@ConfigItem(
			keyName = "tray",
			name = "Send Tray Notification",
			description = "Toggles tray notifications",
			position = 2
	)
	default boolean sendTrayNotification()
	{
		return true;
	}

	@ConfigItem(
			keyName = "request",
			name = "Request Window Focus",
			description = "Toggles window focus request",
			position = 3
	)
	default boolean requestFocus()
	{
		return true;
	}

	@ConfigItem(
			keyName = "overloadnotification",
			name = "Overload notification",
			description = "Toggles notifications when your overload runs out",
			position = 4
	)
	default boolean overloadNotification()
	{
		return true;
	}

	@ConfigItem(
			keyName = "absorptionnotification",
			name = "Absorption notification",
			description = "Toggles notifications when your absorption points gets below your threshold",
			position = 5
	)
	default boolean absorptionNotification()
	{
		return true;
	}

	@ConfigItem(
			keyName = "absorptionthreshold",
			name = "Absorption Threshold",
			description = "The amount of absorption points to send a notification at",
			position = 6
	)
	default int absorptionThreshold()
	{
		return 50;
	}

	@ConfigItem(
			keyName = "moveoverlay",
			name = "Override NMZ overlay",
			description = "Overrides the overlay so it doesn't conflict with other RuneLite plugins",
			position = 7
	)
	default boolean moveOverlay()
	{
		return true;
	}
}
