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

@ConfigGroup("agility")
public interface AgilityConfig extends Config
{
	@ConfigItem(
		keyName = "showLapCount",
		name = "Show Lap count",
		description = "Enable/disable the lap counter",
		position = 1
	)
	default boolean showLapCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lapTimeout",
		name = "Hide Lap Count (minutes)",
		description = "Time until the lap counter hides/resets",
		position = 2
	)
	default int lapTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "overlayColor",
		name = "Overlay Color",
		description = "Color of Agility overlay",
		position = 3
	)
	default Color getOverlayColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "highlightMarks",
		name = "Highlight Marks of Grace",
		description = "Enable/disable the highlighting of retrievable Marks of Grace",
		position = 4
	)
	default boolean highlightMarks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "markHighlight",
		name = "Mark Highlight Color",
		description = "Color of highlighted Marks of Grace",
		position = 5
	)
	default Color getMarkColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "highlightShortcuts",
		name = "Highlight Agility Shortcuts",
		description = "Enable/disable the highlighting of Agility shortcuts",
		position = 6
	)
	default boolean highlightShortcuts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trapOverlay",
		name = "Show Trap Overlay",
		description = "Enable/disable the highlighting of traps on Agility courses",
		position = 7
	)
	default boolean showTrapOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trapHighlight",
		name = "Trap Overlay Color",
		description = "Color of Agility trap overlay",
		position = 8
	)
	default Color getTrapColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "agilityArenaNotifier",
		name = "Agility Arena notifier",
		description = "Notify on ticket location change in Agility Arena",
		position = 9
	)
	default boolean notifyAgilityArena()
	{
		return true;
	}

	@ConfigItem(
		keyName = "agilityArenaTimer",
		name = "Agility Arena timer",
		description = "Configures whether Agility Arena timer is displayed",
		position = 10
	)
	default boolean showAgilityArenaTimer()
	{
		return true;
	}
}
