/*
 * Copyright (c) 2018, Cas <https://github.com/casvandongen>
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
package net.runelite.client.plugins.agility;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("It's coming home")
public interface AgilityConfig extends Config
{
	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 1
	)
	default boolean showLapCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 2
	)
	default int lapTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 3
	)
	default Color getOverlayColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 4
	)
	default boolean highlightMarks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 5
	)
	default Color getMarkColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 6
	)
	default boolean highlightShortcuts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 7
	)
	default boolean showTrapOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 8
	)
	default Color getTrapColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 9
	)
	default boolean notifyAgilityArena()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 10
	)
	default boolean showAgilityArenaTimer()
	{
		return true;
	}
}
