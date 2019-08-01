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
import net.runelite.client.config.Stub;

@ConfigGroup("zalcano")
public interface ZalcanoConfig extends Config
{

	@ConfigItem(
		keyName = "zalcanoStub",
		name = "Zalcano",
		description = "",
		position = 0
	)
	default Stub zalcanoStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "highlightZalcanoHull",
		name = "Highlight Zalcano",
		description = "Highlight Zalcano\'s convex hull.",
		parent = "zalcanoStub",
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
		parent = "zalcanoStub",
		position = 2
	)
	default Color zalcanoHullColor()
	{
		return new Color(255, 25, 0);
	}

	@ConfigItem(
		keyName = "zalcanoAoesStub",
		name = "Area of Effect",
		description = "",
		position = 3
	)
	default Stub zalcanoAoesStub()
	{
		return new Stub();
	}

	@ConfigItem(
		keyName = "showAoeZalcanoWakeup",
		name = "Zalcano Wakeup",
		description = "Shows an AOE warning for Zalcano waking back up.",
		parent = "zalcanoAoesStub",
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
		parent = "zalcanoAoesStub",
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
		parent = "zalcanoAoesStub",
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
		parent = "zalcanoAoesStub",
		position = 7
	)
	default boolean highlightMiningSpot()
	{
		return true;
	}

	@ConfigItem(
		keyName = "helperStub",
		name = "Helpers",
		description = "",
		position = 8
	)
	default Stub helperStub()
	{
		return new Stub();
	}

	/**
	 * TODO: improve helper
	 */
	@ConfigItem(
		keyName = "showSteps",
		name = "Show Step",
		description = "",
		parent = "helperStub",
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
		parent = "helperStub",
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
		parent = "helperStub",
		position = 11
	)
	default boolean highlightGolem()
	{
		return true;
	}


}
