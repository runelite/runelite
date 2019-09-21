/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, pklite <https://github.com/pklite/pklite>
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
package net.runelite.client.plugins.freezetimers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@ConfigGroup("freezetimers")
public interface FreezeTimersConfig extends Config
{
	@ConfigTitleSection(
		keyName = "timersTitle",
		name = "Timers",
		description = "",
		position = 1
	)
	default Title timersTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "showOverlay",
		name = "Show Players",
		description = "Configure if the player overlay should be shown",
		position = 2,
		titleSection = "timersTitle"
	)
	default boolean showPlayers()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showNpcs",
		name = "Show NPCs",
		description = "Configure if the npc overlay should be shown",
		position = 3,
		titleSection = "timersTitle"
	)
	default boolean showNpcs()
	{
		return false;
	}

	@ConfigItem(
		keyName = "FreezeTimers",
		name = "Show Freeze Timers",
		description = "Toggle overlay for Freeze timers",
		position = 4,
		titleSection = "timersTitle"
	)
	default boolean FreezeTimers()
	{
		return true;
	}

	@ConfigItem(
		keyName = "TB",
		name = "Show TB Timers",
		description = "Toggle overlay for TB timers",
		position = 5,
		titleSection = "timersTitle"
	)
	default boolean TB()
	{
		return true;
	}

	@ConfigItem(
		keyName = "Veng",
		name = "Show Veng Timers",
		description = "Toggle overlay for Veng timers",
		position = 6,
		titleSection = "timersTitle"
	)
	default boolean Veng()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "overlayTitle",
		name = "Overlay",
		description = "",
		position = 7
	)
	default Title overlayTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "xoffset",
		name = "X Offset",
		description = "Increasing this will push further away from model. Does not apply to text timers.",
		position = 8,
		titleSection = "overlayTitle"
	)
	default int offset()
	{
		return 20;
	}

	@ConfigItem(
		keyName = "noImage",
		name = "Text Timers",
		description = "Remove Images from Timers",
		position = 9,
		titleSection = "overlayTitle"
	)
	default boolean noImage()
	{
		return false;
	}

	@ConfigItem(
		keyName = "fontStyle",
		name = "Font Style",
		description = "Bold/Italics/Plain",
		position = 10,
		titleSection = "overlayTitle"
	)
	default FontStyle fontStyle()
	{
		return FontStyle.BOLD;
	}

	@Range(
		min = 9,
		max = 14
	)
	@ConfigItem(
		keyName = "textSize",
		name = "Text Size",
		description = "Text Size for Timers.",
		position = 11,
		titleSection = "overlayTitle"
	)
	default int textSize()
	{
		return 11;
	}
}
