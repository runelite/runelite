/*
 * Copyright (c) 2019, Abiyaz C <chowdh2@cooper.edu>
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
package net.runelite.client.plugins.driftnet;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("driftnetfishing")
public interface DriftNetConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "infoBox",
		name = "Net status infobox",
		description = "Configures whether to display an infobox showing the current status of each net."
	)
	default boolean infoBox()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "netOverlay",
		name = "Net overlay",
		description = "Configures whether to display an overlay on each drift net."
	)
	default boolean netOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "highlightFish",
		name = "Highlight tagged fish",
		description = "Configures whether to highlight tagged fish."
	)
	default boolean highlightFish()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "highlightDuration",
		name = "Highlight duration",
		description = "If highlight fish is enabled, this configures how long the tagged fish should be highlighted."
	)
	default int highlightDuration()
	{
		return 10;
	}
}
