/*
 * Copyright (c) 2019, Jacky <liangj97@gmail.com>
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
package net.runelite.client.plugins.cox;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("hydra")
public interface CoxConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "showHydraTile",
		name = "Hydra's Size Box ",
		description = "Displays hydra's size box for luring over vents"
	)
	default boolean showHydraTile()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "tileColour",
		name = "Color of hydra tile size",
		description = "Configures the color of hydra's size"
	)
	default Color hydraTileColour()
	{
		return Color.ORANGE;
	}

	@Range(
		min = -1000,
		max = 1000
	)
	@ConfigItem(
		position = 2,
		keyName = "prayerHeight",
		name = "Sets hydra's prayer height",
		description = "The height of the prayer indicator over Hydra"
	)
	default int prayerHeight()
	{
		return 450;
	}

	@ConfigItem(
		position = 3,
		keyName = "showHydraPrayer",
		name = "Hydra's Attack Style Indicator",
		description = "Displays hydra's size box for luring over vents"
	)
	default boolean showPrayer()
	{
		return false;
	}
}
