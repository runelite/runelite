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
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("agility")
public interface AgilityConfig extends Config
{
	@ConfigTitleSection(
		keyName = "mainConfig",
		position = 0,
		name = "Main Config",
		description = ""
	)
	default Title mainConfig()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "removeDistanceCap",
		name = "Remove Distance Cap",
		description = "This will remove the distance cap on rendering overlays for agility.",
		warning = "<html><center>Enabling this setting on a low end machine may severely affect your fps." +
			"<br>Click yes to enable this setting, knowing it might affect performance.</center></html>",
		position = 1,
		titleSection = "mainConfig"
	)
	default boolean removeDistanceCap()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showLapCount",
		name = "Show Lap Count",
		description = "Enable/disable the lap counter",
		position = 2,
		titleSection = "mainConfig"
	)
	default boolean showLapCount()
	{
		return true;
	}

	@ConfigItem(
		keyName = "lapTimeout",
		name = "Hide Lap Count",
		description = "Time in minutes until the lap counter hides/resets",
		position = 3,
		titleSection = "mainConfig",
		hidden = true,
		unhide = "showLapCount"
	)
	default int lapTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "lapsToLevel",
		name = "Show Laps Until Level",
		description = "Show number of laps remaining until next level is reached.",
		position = 4,
		titleSection = "mainConfig",
		hidden = true,
		unhide = "showLapCount"
	)
	default boolean lapsToLevel()
	{
		return false;
	}

	@ConfigItem(
		keyName = "lapsToGoal",
		name = "Show Laps Until Goal",
		description = "Show number of laps remaining until experience tracker goal is reached",
		position = 5,
		titleSection = "mainConfig",
		hidden = true,
		unhide = "showLapCount"
	)
	default boolean lapsToGoal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "agilityArenaTimer",
		name = "Agility Arena timer",
		description = "Configures whether Agility Arena timer is displayed",
		position = 6,
		titleSection = "mainConfig"
	)
	default boolean showAgilityArenaTimer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "addLevelsToShortcutOptions",
		name = "Show Shortcut Agility Reqs",
		description = "Enable/disable showing shortcut agility level requirements in right-click options",
		position = 7,
		titleSection = "mainConfig"
	)
	default boolean showShortcutLevel()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "miscConfig",
		position = 8,
		name = "Misc Config",
		description = ""
	)
	default Title miscConfig()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "highlightMarks",
		name = "Highlight Marks of Grace",
		description = "Enable/disable the highlighting of retrievable Marks of Grace",
		position = 9,
		titleSection = "miscConfig"
	)
	default boolean highlightMarks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightShortcuts",
		name = "Highlight Agility Shortcuts",
		description = "Enable/disable the highlighting of Agility shortcuts",
		position = 10,
		titleSection = "miscConfig"
	)
	default boolean highlightShortcuts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTrapOverlay",
		name = "Highlight Traps",
		description = "Enable/disable the highlighting of traps on Agility courses",
		position = 11,
		titleSection = "miscConfig"
	)
	default boolean showTrapOverlay()
	{
		return false;
	}

	@ConfigItem(
		keyName = "agilityArenaNotifier",
		name = "Agility Arena notifier",
		description = "Notify on ticket location change in Agility Arena",
		position = 12,
		titleSection = "miscConfig"
	)
	default boolean notifyAgilityArena()
	{
		return false;
	}

	@ConfigItem(
		keyName = "overlayColor",
		name = "Global Overlay Color",
		description = "Color of Agility overlay",
		position = 13,
		titleSection = "miscConfig"
	)
	default Color getOverlayColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "trapHighlight",
		name = "Trap Overlay Color",
		description = "Color of Agility trap overlay",
		position = 14,
		titleSection = "miscConfig",
		hidden = true,
		unhide = "showTrapOverlay"
	)
	default Color getTrapColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "markHighlight",
		name = "Mark Highlight Color",
		description = "Color of highlighted Marks of Grace",
		position = 15,
		titleSection = "miscConfig",
		hidden = true,
		unhide = "highlightMarks"
	)
	default Color getMarkColor()
	{
		return Color.RED;
	}
}
