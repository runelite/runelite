/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.playerinfo;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("playerinfo")
public interface PlayerInfoConfig extends Config
{
	@ConfigItem(
		keyName = "enableHealth",
		name = "Enable Health Display",
		description = "Configures whether or not to display health information",
		position = 1
	)
	default boolean enableHealth()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enablePrayer",
		name = "Enable Prayer Display",
		description = "Configures whether or not to display prayer information",
		position = 2
	)
	default boolean enablePrayer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableEnergy",
		name = "Enable Run Energy Display",
		description = "Configures whether or not to display run energy information",
		position = 3
	)
	default boolean enableEnergy()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableSpec",
		name = "Enable Special Attack Display",
		description = "Configures whether or not to display special attack information",
		position = 4
	)
	default boolean enableSpec()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableWorld",
		name = "Enable World Display",
		description = "Configures whether or not to display world information",
		position = 4
	)
	default boolean enableWorld()
	{
		return true;
	}

	@ConfigItem(
		keyName = "colorHigh",
		name = "Color High",
		description = "The color displayed for high values.",
		position = 5
	)
	default Color colorHigh()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "colorMed",
		name = "Color Medium",
		description = "The color displayed for medium values.",
		position = 6
	)
	default Color colorMed()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		keyName = "colorLow",
		name = "Color Low",
		description = "The color displayed for low values.",
		position = 7
	)
	default Color colorLow()
	{
		return Color.RED;
	}
}
