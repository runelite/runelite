/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.flexo;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("flexo")
public interface FlexoConfig extends Config
{

	@ConfigItem(
		position = 0,
		keyName = "overlayEnabled",
		name = "Overlay Enabled",
		description = "Shows clicking area and points etc."
	)
	default boolean overlayEnabled()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "minDelayAmount",
		name = "Min Delay",
		description = "Minimum delay that is applied to every action at the end (ms)"
	)
	default int minDelayAmt()
	{
		return 45;
	}


	@ConfigItem(
		position = 2,
		keyName = "reactionTime",
		name = "Reaction Time",
		description = "The base time between actions (ms)"
	)
	default int getReactionTimeVariation()
	{
		return 80;
	}

	@ConfigItem(
		position = 3,
		keyName = "mouseDragSpeed",
		name = "Mouse drag speed",
		description = "The speed at which steps are executed. Keep at 49? cuz jagex mouse recorder?"
	)
	default int getMouseDragSpeed()
	{
		return 49;
	}


	@ConfigItem(
		position = 4,
		keyName = "overshoots",
		name = "Overshoots",
		description = "Higher number = more overshoots"
	)
	default int getOvershoots()
	{
		return 4;
	}

	@ConfigItem(
		position = 5,
		keyName = "variatingFlow",
		name = "Flow - Variating",
		description = ""
	)
	default boolean getVariatingFlow()
	{
		return true;
	}

	@ConfigItem(
		position = 6,
		keyName = "slowStartupFlow",
		name = "Flow - Slow startup",
		description = ""
	)
	default boolean getSlowStartupFlow()
	{
		return true;
	}


	@ConfigItem(
		position = 7,
		keyName = "slowStartup2Flow",
		name = "Flow - Slow startup 2",
		description = ""
	)
	default boolean getSlowStartup2Flow()
	{
		return true;
	}

	@ConfigItem(
		position = 8,
		keyName = "jaggedFlow",
		name = "Flow - Jagged",
		description = ""
	)
	default boolean getJaggedFlow()
	{
		return true;
	}

	@ConfigItem(
		position = 9,
		keyName = "interruptedFlow",
		name = "Flow - Interrupted",
		description = ""
	)
	default boolean getInterruptedFlow()
	{
		return false;
	}


	@ConfigItem(
		position = 10,
		keyName = "interruptedFlow2",
		name = "Flow - Interrupted 2",
		description = ""
	)
	default boolean getInterruptedFlow2()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "stoppingFlow",
		name = "Flow - Stopping",
		description = ""
	)
	default boolean getStoppingFlow()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "deviationSlopeDivider",
		name = "Deviation slope divider",
		description = ""
	)
	default int getDeviationSlope()
	{
		return 10;
	}


	@ConfigItem(
		position = 13,
		keyName = "noisinessDivider",
		name = "Noisiness divider",
		description = ""
	)
	default String getNoisinessDivider()
	{
		return "2.0D";
	}

	@ConfigItem(
		position = 14,
		keyName = "debugNPCs",
		name = "Debug NPCs",
		description = "Draws clickArea and clickPoints across all visible npcs"
	)
	default boolean getDebugNPCs()
	{
		return false;
	}

	@ConfigItem(
		position = 15,
		keyName = "debugPlayers",
		name = "Debug Players",
		description = "Draws clickArea and clickPoints across all visible players"
	)
	default boolean getDebugPlayers()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "debugGroundItems",
		name = "Debug Ground Items",
		description = "Draws clickArea and clickPoints across all visible ground items"
	)
	default boolean getDebugGroundItems()
	{
		return false;
	}
}
