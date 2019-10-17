/*
 * Copyright (c) 2018, https://openosrs.com
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
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("playerinfo")
public interface PlayerInfoConfig extends Config
{
	@ConfigTitleSection(
		keyName = "overlaysTitle",
		name = "Overlays",
		description = "",
		position = 0
	)
	default Title overlaysTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "enableHealth",
		name = "Enable Health Display",
		description = "Configures whether or not to display health information",
		position = 1,
		titleSection = "overlaysTitle"
	)
	default boolean enableHealth()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enablePrayer",
		name = "Enable Prayer Display",
		description = "Configures whether or not to display prayer information",
		position = 2,
		titleSection = "overlaysTitle"
	)
	default boolean enablePrayer()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableEnergy",
		name = "Enable Run Energy Display",
		description = "Configures whether or not to display run energy information",
		position = 3,
		titleSection = "overlaysTitle"
	)
	default boolean enableEnergy()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableSpec",
		name = "Enable Special Attack Display",
		description = "Configures whether or not to display special attack information",
		position = 4,
		titleSection = "overlaysTitle"
	)
	default boolean enableSpec()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableWorld",
		name = "Enable World Display",
		description = "Configures whether or not to display world information",
		position = 5,
		titleSection = "overlaysTitle"
	)
	default boolean enableWorld()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "colorsTitle",
		name = "Colors",
		description = "",
		position = 6
	)
	default Title colorsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "colorHigh",
		name = "Color High",
		description = "The color displayed for high values.",
		position = 7,
		titleSection = "colorsTitle"
	)
	default Color colorHigh()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "colorMed",
		name = "Color Medium",
		description = "The color displayed for medium values.",
		position = 8,
		titleSection = "colorsTitle"
	)
	default Color colorMed()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		keyName = "colorLow",
		name = "Color Low",
		description = "The color displayed for low values.",
		position = 7,
		titleSection = "colorsTitle"
	)
	default Color colorLow()
	{
		return Color.RED;
	}
}
