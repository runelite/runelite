/*
 * Copyright (c) 2017, Robin Weymans <Robin.weymans@gmail.com>
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
package net.runelite.client.plugins.hunter;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("hunterplugin")
public interface HunterConfig extends Config
{
	@Alpha
	@ConfigItem(
		position = 1,
		keyName = "hexColorOpenTrap",
		name = "Open trap",
		description = "Color of open trap timer"
	)
	default Color getOpenTrapColor()
	{
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
		position = 2,
		keyName = "hexColorFullTrap",
		name = "Full trap",
		description = "Color of full trap timer"
	)
	default Color getFullTrapColor()
	{
		return Color.GREEN;
	}

	@Alpha
	@ConfigItem(
		position = 3,
		keyName = "hexColorEmptyTrap",
		name = "Empty trap",
		description = "Color of empty trap timer"
	)
	default Color getEmptyTrapColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "hexColorTransTrap",
		name = "Transitioning trap",
		description = "Color of transitioning trap timer"
	)
	default Color getTransTrapColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		position = 5,
		keyName = "maniacalMonkeyNotify",
		name = "Maniacal monkey notification",
		description = "Send notification when maniacal monkey is caught or you fail to catch."
	)
	default boolean maniacalMonkeyNotify()
	{
		return false;
	}
}
