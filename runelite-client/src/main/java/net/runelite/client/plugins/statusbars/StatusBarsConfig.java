/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
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
package net.runelite.client.plugins.statusbars;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

@ConfigGroup(StatusBarsConfig.GROUP)
public interface StatusBarsConfig extends Config
{
	String GROUP = "statusbars";

	@ConfigItem(
		keyName = "enableCounter",
		name = "Show counters",
		description = "Shows current value of the status on the bar."
	)
	default boolean enableCounter()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enableSkillIcon",
		name = "Show icons",
		description = "Adds skill icons at the top of the bars."
	)
	default boolean enableSkillIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "enableRestorationBars",
		name = "Show restores",
		description = "Visually shows how much will be restored to your status bar."
	)
	default boolean enableRestorationBars()
	{
		return true;
	}

	enum BarMode
	{
		DISABLED,
		HITPOINTS,
		PRAYER,
		RUN_ENERGY,
		SPECIAL_ATTACK,
		WARMTH,
	}

	@ConfigItem(
		keyName = "leftBarMode",
		name = "Left bar",
		description = "Configures the left status bar."
	)
	default BarMode leftBarMode()
	{
		return BarMode.HITPOINTS;
	}

	@ConfigItem(
		keyName = "rightBarMode",
		name = "Right bar",
		description = "Configures the right status bar."
	)
	default BarMode rightBarMode()
	{
		return BarMode.PRAYER;
	}

	@ConfigItem(
		keyName = "hideAfterCombatDelay",
		name = "Hide after combat delay",
		description = "Amount of ticks before hiding status bars after no longer in combat. 0 = always show status bars."
	)
	@Units(Units.TICKS)
	default int hideAfterCombatDelay()
	{
		return 0;
	}

	@Range(
		min = BarRenderer.MIN_WIDTH,
		max = BarRenderer.MAX_WIDTH
	)
	@ConfigItem(
		keyName = "barWidth",
		name = "Bar width",
		description = "The width of the status bars in the modern resizeable layout."
	)
	default int barWidth()
	{
		return BarRenderer.DEFAULT_WIDTH;
	}
}
