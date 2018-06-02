/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.fixedmode;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("fixedmode")
public interface FixedModeConfig extends Config
{
	@ConfigItem(
		keyName = "expandView",
		name = "Expand view to chat",
		description = "Expands main view to chat and makes the chat toggleable",
		position = 1
	)
	default boolean expandViewToChat()
	{
		return false;
	}

	@ConfigItem(
		keyName = "stretchedEnabled",
		name = "Stretch fixed mode",
		description = "Resizes the game while in fixed mode",
		position = 2
	)
	default boolean stretchedEnabled()
	{
		return false;
	}

	@ConfigItem(
		keyName = "keepAspectRatio",
		name = "Keep aspect ratio",
		description = "Keeps the aspect ratio when stretching",
		position = 3
	)
	default boolean keepAspectRatio()
	{
		return false;
	}

	@ConfigItem(
		keyName = "increasedPerformance",
		name = "Increased performance mode",
		description = "Uses a fast algorithm when stretching, lowering quality but increasing performance",
		position = 4
	)
	default boolean increasedPerformance()
	{
		return false;
	}

	@ConfigItem(
		keyName = "integerScaling",
		name = "Integer scaling",
		description = "Forces use of a whole number scale factor",
		position = 5
	)
	default boolean integerScaling()
	{
		return false;
	}
}
