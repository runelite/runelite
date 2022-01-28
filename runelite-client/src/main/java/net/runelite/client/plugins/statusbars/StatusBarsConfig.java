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
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Units;
import net.runelite.client.plugins.statusbars.config.BarMode;

@ConfigGroup(StatusBarsConfig.GROUP)
public interface StatusBarsConfig extends Config
{
	String GROUP = "statusbars";

	@ConfigItem(
		keyName = "enableCounter",
		name = "Show counters",
		description = "Shows current value of the status on the bar"
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

	@ConfigItem(
		keyName = "leftBarMode",
		name = "Left Bar",
		description = "Configures the left status bar"
	)
	default BarMode leftBarMode()
	{
		return BarMode.HITPOINTS;
	}

	@ConfigItem(
		keyName = "rightBarMode",
		name = "Right Bar",
		description = "Configures the right status bar"
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

	@ConfigItem(
		keyName = "barHeight",
		name = "Height of bars",
		description = "Height of the status bars in classic mode",
		section = resizeableClassicLayout
	)
	default int barHeight() {return 252;}

	@ConfigItem(
		keyName = "leftBarXOffset",
		name = "Left bar X offset",
		description = "X offset of left bar",
		section = resizeableClassicLayout
	)
	default int leftBarXOffset() {return 45;}

	@ConfigItem(
		keyName = "rightBarXOffset",
		name = "Right bar X offset",
		description = "X offset of right bar in classic mode",
		section = resizeableClassicLayout
	)
	default int rightBarXOffset() {return 43;}

	@ConfigItem(
		keyName = "leftBarYOffset",
		name = "Left bar Y offset",
		description = "Y offset of left bar",
		section = resizeableClassicLayout
	)
	default int leftBarYOffset() {return 0;}

	@ConfigItem(
		keyName = "rightBarYOffset",
		name = "Right bar Y offset",
		description = "Y offset of right bar in classic mode",
		section = resizeableClassicLayout
	)
	default int rightBarYOffset() {return 0;}

	@ConfigItem(
		keyName = "groupTogether",
		name = "Left and Right bar grouped",
		description = "Left and Right bar displayed beside each other on left of inventory",
		section = resizeableClassicLayout
	)
	default boolean groupTogether() {return false;}

	@ConfigItem(
		keyName = "overlapPillar",
		name = "Overlap inventory pillar",
		description = "Should the right bar overlap the inventory pillar while grouped",
		section = resizeableClassicLayout
	)
	default boolean overlapPillar() {return false;}

	@ConfigSection(
		name = "Resizable - Classic Layout",
		description = "All options that swap item menu entries",
		position = 0,
		closedByDefault = true
	)
	String resizeableClassicLayout = "resizeableClassicLayout";


}
