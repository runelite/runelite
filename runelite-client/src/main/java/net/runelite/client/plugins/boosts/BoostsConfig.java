/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.boosts;

import java.awt.Color;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Config;

@ConfigGroup(
	keyName = "boosts",
	name = "Boosts Info",
	description = "Configuration for the Boosts plugin"
)
public interface BoostsConfig extends Config
{
	@ConfigItem(
		keyName = "enableSkill",
		name = "Enable non-combat Skill Boosts",
		description = "Configures whether or not to display skill boost information"
	)
	default boolean enableSkill()
	{
		return true;
	}

	@ConfigItem(
		keyName = "relativeBoost",
		name = "Use Relative Boosts",
		description = "Configures whether or not relative boost is used"
	)
	default boolean useRelativeBoost()
	{
		return false;
	}

	@ConfigItem(
		keyName = "displayIndicators",
		name = "Display as indicators",
		description = "Configures whether or not to display the boost as indicators"
	)
	default boolean displayIndicators()
	{
		return false;
	}

	@ConfigItem(
		keyName = "highBoost",
		name = "High boost color",
		description = "Configures color for high boost",
		position = 3
	)
	default Color highBoost()
	{
		return Color.green;
	}

	@ConfigItem(
		keyName = "medBoost",
		name = "Medium boost color",
		description = "Configures color for medium boost",
		position = 4
	)
	default Color medBoost()
	{
		return Color.yellow;
	}

	@ConfigItem(
		keyName = "medBoostPercentage",
		name = "Med boost percentage of level",
		description = "Configures at which percentage of the boost it should be colored medium",
		position = 5
	)
	default int medBoostPercentage()
	{
		return 63;
	}

	@ConfigItem(
		keyName = "lowBoost",
		name = "Low boost color",
		description = "Configures color for low boost",
		position = 6
	)
	default Color lowBoost()
	{
		return Color.decode("#FF9900");
	}

	@ConfigItem(
		keyName = "lowBoostPercentage",
		name = "Low boost percentage of level",
		description = "Configures at which percentage of the boost it should be colored low",
		position = 7
	)
	default int lowBoostPercentage()
	{
		return 47;
	}

	@ConfigItem(
		keyName = "fontType",
		name = "fontType",
		description = "Set the type of font, this will also impact size of the overlay component",
		position = 1
	)
	default BoostsOverlay.FontType type()
	{
		return BoostsOverlay.FontType.SMALL;
	}
}
