/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("barrows")
public interface BarrowsConfig extends Config
{
	@ConfigItem(
		keyName = "showMinimap",
		name = "Show Minimap in tunnels",
		description = "Configures whether or not the minimap is displayed",
		position = 0
	)
	default boolean showMinimap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBrotherLoc",
		name = "Show Brothers location",
		description = "Configures whether or not the brothers location is displayed",
		position = 1
	)
	default boolean showBrotherLoc()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showChestValue",
		name = "Show Value of Chests",
		description = "Configure whether to show total exchange value of chest when opened",
		position = 2
	)
	default boolean showChestValue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "brotherLocColor",
		name = "Brother location color",
		description = "Change the color of the name displayed on the minimap",
		position = 3
	)
	default Color brotherLocColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "deadBrotherLocColor",
		name = "Dead Brother loc. color",
		description = "Change the color of the name displayed on the minimap for a dead brother",
		position = 4
	)
	default Color deadBrotherLocColor()
	{
		return Color.RED;
	}
}
