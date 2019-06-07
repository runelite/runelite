/*
 * Copyright (c) 2018, James Munson <https://github.com/james-munson>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.tickcounter;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tickcounter")
public interface TickCounterConfig extends Config
{
	@ConfigItem(
		keyName = "resetInstance",
		name = "Reset on new instances",
		description = "",
		position = 1
	)
	default boolean instance()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "selfColor",
		name = "Your color",
		description = "",
		position = 4
	)
	default Color selfColor()
	{
		return Color.green;
	}

	@Alpha
	@ConfigItem(
		keyName = "totalColor",
		name = "Total color",
		description = "",
		position = 6
	)
	default Color totalColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		keyName = "otherColor",
		name = "Other players color",
		description = "",
		position = 5
	)
	default Color otherColor()
	{
		return Color.white;
	}

	@Alpha
	@ConfigItem(
		keyName = "bgColor",
		name = "Background color",
		description = "",
		position = 3
	)
	default Color bgColor()
	{
		return new Color(70, 61, 50, 156);
	}

	@Alpha
	@ConfigItem(
		keyName = "titleColor",
		name = "Title color",
		description = "",
		position = 2
	)
	default Color titleColor()
	{
		return Color.white;
	}
}
