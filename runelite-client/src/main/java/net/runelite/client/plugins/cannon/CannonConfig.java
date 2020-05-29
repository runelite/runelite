/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.cannon;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import static net.runelite.client.plugins.cannon.CannonPlugin.MAX_CBALLS;

@ConfigGroup("cannon")
public interface CannonConfig extends Config
{
	@ConfigItem(
		keyName = "showEmptyCannonNotification",
		name = "Enable cannon notifications",
		description = "Configures whether to notify you when your cannon is low on cannonballs",
		position = 1
	)
	default boolean showCannonNotifications()
	{
		return true;
	}

	@Range(
		max = MAX_CBALLS
	)
	@ConfigItem(
		keyName = "lowWarningThreshold",
		name = "Low Warning Threshold",
		description = "Configures the number of cannonballs remaining before a notification is sent. <br>Regardless of this value, a notification will still be sent when your cannon is empty.",
		position = 2
	)
	default int lowWarningThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "showInfobox",
		name = "Show Cannonball infobox",
		description = "Configures whether to show the cannonballs in an infobox",
		position = 3
	)
	default boolean showInfobox()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showDoubleHitSpot",
		name = "Show double hit spots",
		description = "Configures whether to show the NPC double hit spot",
		position = 4
	)
	default boolean showDoubleHitSpot()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "highlightDoubleHitColor",
		name = "Color of double hit spots",
		description = "Configures the highlight color of double hit spots",
		position = 5
	)
	default Color highlightDoubleHitColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "showCannonSpots",
		name = "Show common cannon spots",
		description = "Configures whether to show common cannon spots or not",
		position = 6
	)
	default boolean showCannonSpots()
	{
		return true;
	}
}
