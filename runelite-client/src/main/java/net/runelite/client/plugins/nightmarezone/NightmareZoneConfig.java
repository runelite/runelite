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

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Notification;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

@ConfigGroup("nightmareZone")
public interface NightmareZoneConfig extends Config
{
	@ConfigItem(
		keyName = "moveoverlay",
		name = "Override NMZ overlay",
		description = "Overrides the overlay so it doesn't conflict with other RuneLite plugins.",
		position = 1
	)
	default boolean moveOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "powersurgenotification",
		name = "Power surge notification",
		description = "Toggles notifications when a power surge power-up appears.",
		position = 2
	)
	default Notification powerSurgeNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "recurrentdamagenotification",
		name = "Recurrent damage notification",
		description = "Toggles notifications when a recurrent damage power-up appears.",
		position = 3
	)
	default Notification recurrentDamageNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "zappernotification",
		name = "Zapper notification",
		description = "Toggles notifications when a zapper power-up appears.",
		position = 4
	)
	default Notification zapperNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "ultimateforcenotification",
		name = "Ultimate force notification",
		description = "Toggles notifications when an ultimate force power-up appears.",
		position = 5
	)
	default Notification ultimateForceNotification()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "overloadnotification",
		name = "Overload notification",
		description = "Toggles notifications when your overload runs out.",
		position = 6
	)
	default Notification overloadNotification()
	{
		return Notification.ON;
	}

	@Range(
		min = 0,
		max = 300
	)
	@ConfigItem(
		keyName = "overloadearlywarningseconds",
		name = "Overload early warning",
		description = "You will be notified this many seconds before your overload potion expires.",
		position = 7
	)
	@Units(Units.SECONDS)
	default int overloadEarlyWarningSeconds()
	{
		return 10;
	}

	@ConfigItem(
		keyName = "absorptionnotification",
		name = "Absorption notification",
		description = "Toggles notifications when your absorption points gets below your threshold.",
		position = 8
	)
	default Notification absorptionNotification()
	{
		return Notification.ON;
	}

	@ConfigItem(
		keyName = "absorptionthreshold",
		name = "Absorption threshold",
		description = "The amount of absorption points to send a notification at.",
		position = 9
	)
	default int absorptionThreshold()
	{
		return 50;
	}

	@ConfigItem(
		keyName = "absorptioncoloroverthreshold",
		name = "Color above threshold",
		description = "Configures the color for the absorption widget when above the threshold.",
		position = 10
	)
	default Color absorptionColorAboveThreshold()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		keyName = "absorptioncolorbelowthreshold",
		name = "Color below threshold",
		description = "Configures the color for the absorption widget when below the threshold.",
		position = 11
	)
	default Color absorptionColorBelowThreshold()
	{
		return Color.RED;
	}

}
