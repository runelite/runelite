/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.ticktimers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import net.runelite.client.config.Stub;

@ConfigGroup("TickTimers")
public interface TickTimersConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "bosses",
		name = "Bosses",
		description = ""
	)
	default Stub bosses()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 1,
		keyName = "graardor",
		name = "General Graardor",
		description = "Show tick timers for General Graardor",
		parent = "bosses"
	)
	default boolean graardor()
	{
		return true;
	}

	@ConfigItem(
		position = 22,
		keyName = "text",
		name = "Text",
		description = ""
	)
	default Stub text()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 23,
		keyName = "fontStyle",
		name = "Font Style",
		description = "Plain | Bold | Italics",
		parent = "text"
	)
	default FontStyle fontStyle()
	{
		return FontStyle.PLAIN;
	}

	@Range(
		min = 14,
		max = 40
	)
	@ConfigItem(
		position = 24,
		keyName = "textSize",
		name = "Text Size",
		description = "Text Size for Timers.",
		parent = "text"
	)
	default int textSize()
	{
		return 32;
	}

	@ConfigItem(
		position = 25,
		keyName = "shadows",
		name = "Shadows",
		description = "Adds Shadows to text.",
		parent = "text"
	)
	default boolean shadows()
	{
		return false;
	}
}
