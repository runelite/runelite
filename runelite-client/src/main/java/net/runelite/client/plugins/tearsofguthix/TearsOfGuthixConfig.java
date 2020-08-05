/*
 * Copyright (c) 2020, Truth Forger <https://github.com/Blackberry0Pie>
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
package net.runelite.client.plugins.tearsofguthix;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import java.awt.Color;

@ConfigGroup("tearsofgtuthix")
public interface TearsOfGuthixConfig extends Config
{
	@ConfigItem(
		keyName = "showRotationOverlay",
		name = "Show rotation overlay",
		description = "Displays the overlay of rotations",
		position = 1
	)
	default boolean showRotationOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "timeGreenTears",
		name = "Green stream timers",
		description = "Displays timers for green streams",
		position = 2
	)
	default boolean timeGreenTears()
	{
		return false;
	}

	@ConfigItem(
		keyName = "goodTearsColor",
		name = "Good rotation color",
		description = "Color for good rotation",
		position = 3
	)
	default Color goodTearsColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "badTearsColor",
		name = "Bad rotation color",
		description = "Color for bad rotation",
		position = 4
	)
	default Color badTearsColor()
	{
		return Color.RED;
	}
}
