/*
 * Copyright (c) 2019, Cas <https://github.com/stealthAngel>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditisons are met:
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
package net.runelite.client.plugins.falconry;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("falconry")
public interface FalconryConfig extends Config {
	@ConfigItem(
		keyName = "Spotted kebbit",
		name = "Highlight Spotted Kebbits",
		description = "Enable/disable the highlighting of Spotted Kebbits",
		position = 1
	)
	default boolean SpottedKebbitHighlightEnabled() {
		return true;
	}

	@ConfigItem(
		keyName = "SpottedKebbitHighlight",
		name = "Spotted Kebbit Highlight Color",
		description = "Color of highlighted Spotted Kebbit",
		position = 2
	)
	default Color getSpottedKebbitHighlightColor() {
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "Dark kebbit",
		name = "Highlight Dark Kebbits",
		description = "Enable/disable the highlighting of Dark Kebbits",
		position = 3
	)
	default boolean DarkKebbitHighlightEnabled() {
		return true;
	}

	@ConfigItem(
		keyName = "DarkKebbitHighlight",
		name = "Dark Kebbit Highlight Color",
		description = "Color of highlighted Dark Kebbit",
		position = 4
	)
	default Color getDarkKebbitHighlightColor() {
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "Dashing kebbit",
		name = "Highlight Dashing Kebbits",
		description = "Enable/disable the highlighting of Dashing Kebbits",
		position = 5
	)
	default boolean DashingKebbitHighlightEnabled() {
		return true;
	}

	@ConfigItem(
		keyName = "DashingKebbitHighlight",
		name = "Dashing Kebbit Highlight Color",
		description = "Color of highlighted Dashing Kebbit",
		position = 6
	)
	default Color getDashingKebbitHighlightColor() {
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "Gyr Falcon",
		name = "Highlight Gyr Falcon",
		description = "Enable/disable the highlighting of Gyr Falcon",
		position = 7
	)
	default boolean GyrFalconHighlightEnabled() {
		return true;
	}

	@ConfigItem(
		keyName = "GyrFalconHighlight",
		name = "Gyr Falcon Highlight Color",
		description = "Color of highlighted Gyr Falcon",
		position = 8
	)
	default Color getGyrFalconHighlightColor() {
		return Color.GREEN;
	}
}