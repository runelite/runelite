/*
 *
 *  * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
 *  * All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  * 1. Redistributions of source code must retain the above copyright notice, this
 *  *    list of conditions and the following disclaimer.
 *  * 2. Redistributions in binary form must reproduce the above copyright notice,
 *  *    this list of conditions and the following disclaimer in the documentation
 *  *    and/or other materials provided with the distribution.
 *  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.zalcano;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("zalcano")
public interface ZalcanoConfig extends Config
{

	@ConfigTitleSection(
		keyName = "zalcanoTitle",
		name = "Zalcano",
		description = "",
		position = 0
	)
	default Title zalcanoTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "highlightZalcanoHull",
		name = "Highlight Zalcano",
		description = "Highlight Zalcano\'s convex hull.",
		titleSection = "zalcanoTitle",
		position = 1
	)
	default boolean highlightZalcanoHull()
	{
		return false;
	}

	@ConfigItem(
		keyName = "zalcanoHullColor",
		name = "Color for highlight",
		description = "",
		titleSection = "zalcanoTitle",
		position = 2
	)
	default Color zalcanoHullColor()
	{
		return new Color(255, 25, 0);
	}

	@ConfigTitleSection(
		keyName = "zalcanoAoesTitle",
		name = "Area of Effect",
		description = "",
		position = 3
	)
	default Title zalcanoAoesTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "showAoeZalcanoWakeup",
		name = "Zalcano Wakeup",
		description = "Shows an AOE warning for Zalcano waking back up.",
		titleSection = "zalcanoAoesTitle",
		position = 4
	)
	default boolean showAoeZalcanoWakeup()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAoeForRockfall",
		name = "Small Rocks",
		description = "Shows an AOE warning for the rocks that fall occasionally.",
		titleSection = "zalcanoAoesTitle",
		position = 5
	)
	default boolean showAoeForRockfall()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAoeForRedSymbols",
		name = "Red Symbols",
		description = "Shows an AOE warning for the 3x3 red symbols that appear.",
		titleSection = "zalcanoAoesTitle",
		position = 6
	)
	default boolean showAoeForRedSymbols()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightMiningSpot",
		name = "Mining spot",
		description = "Highlights the glowing rock and warns you if Zalcano attacks it.",
		titleSection = "zalcanoAoesTitle",
		position = 7
	)
	default boolean highlightMiningSpot()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "helperTitle",
		name = "Helpers",
		description = "",
		position = 8
	)
	default Title helperTitle()
	{
		return new Title();
	}

	/**
	 * TODO: improve helper
	 */
	@ConfigItem(
		keyName = "showSteps",
		name = "Show Step",
		description = "",
		titleSection = "helperTitle",
		position = 9,
		hidden = true //hidden until fully functional
	)
	default boolean showSteps()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showAoeZalcanoMineable",
		name = "Zalcano Mineable",
		description = "Highlights Zalcano if she is mineable.",
		titleSection = "helperTitle",
		position = 10
	)
	default boolean showAoeZalcanoMineable()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightGolem",
		name = "Highlight Golem",
		description = "Highlights the Golem that Zalcano spawns in.",
		titleSection = "helperTitle",
		position = 11
	)
	default boolean highlightGolem()
	{
		return true;
	}


}
