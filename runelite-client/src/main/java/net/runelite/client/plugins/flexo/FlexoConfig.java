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
import net.runelite.client.config.Stub;

@ConfigGroup("flexo")
public interface FlexoConfig extends Config
{
	@ConfigItem(
		keyName = "overlayStub",
		name = "Overlay",
		description = "",
		position = 1
	)
	default Stub overlayStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 2,
		keyName = "overlayEnabled",
		name = "Overlay Enabled",
		description = "Shows clicking area and points etc.",
		parent = "overlayStub"
	)
	default boolean overlayEnabled()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "debugNPCs",
		name = "Debug NPCs",
		description = "Draws clickArea and clickPoints across all visible npcs",
		parent = "overlayStub",
		hidden = true,
		unhide = "overlayEnabled"
	)
	default boolean getDebugNPCs()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "debugPlayers",
		name = "Debug Players",
		description = "Draws clickArea and clickPoints across all visible players",
		parent = "overlayStub",
		hidden = true,
		unhide = "overlayEnabled"
	)
	default boolean getDebugPlayers()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "debugGroundItems",
		name = "Debug Ground Items",
		description = "Draws clickArea and clickPoints across all visible ground items",
		parent = "overlayStub",
		hidden = true,
		unhide = "overlayEnabled"
	)
	default boolean getDebugGroundItems()
	{
		return false;
	}

	@ConfigItem(
		keyName = "mouseStub",
		name = "Mouse",
		description = "",
		position = 6
	)
	default Stub mouseStub()
	{
		return new Stub();
	}

	@ConfigItem(
		position = 7,
		keyName = "minDelayAmount",
		name = "Min Delay",
		description = "Minimum delay that is applied to every action at the end (ms)",
		parent = "mouseStub"
	)
	default int minDelayAmt()
	{
		return 45;
	}


	@ConfigItem(
		position = 8,
		keyName = "reactionTime",
		name = "Reaction Time",
		description = "The base time between actions (ms)",
		parent = "mouseStub"
	)
	default int getReactionTimeVariation()
	{
		return 80;
	}

	@ConfigItem(
		position = 9,
		keyName = "mouseDragSpeed",
		name = "Mouse drag speed",
		description = "The speed at which steps are executed. Keep at 49? cuz jagex mouse recorder?",
		parent = "mouseStub"
	)
	default int getMouseDragSpeed()
	{
		return 49;
	}


	@ConfigItem(
		position = 10,
		keyName = "overshoots",
		name = "Overshoots",
		description = "Higher number = more overshoots",
		parent = "mouseStub"
	)
	default int getOvershoots()
	{
		return 4;
	}

	@ConfigItem(
		position = 11,
		keyName = "variatingFlow",
		name = "Flow - Variating",
		description = "",
		parent = "mouseStub"
	)
	default boolean getVariatingFlow()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "slowStartupFlow",
		name = "Flow - Slow startup",
		description = "",
		parent = "mouseStub"
	)
	default boolean getSlowStartupFlow()
	{
		return true;
	}


	@ConfigItem(
		position = 13,
		keyName = "slowStartup2Flow",
		name = "Flow - Slow startup 2",
		description = "",
		parent = "mouseStub"
	)
	default boolean getSlowStartup2Flow()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "jaggedFlow",
		name = "Flow - Jagged",
		description = "",
		parent = "mouseStub"
	)
	default boolean getJaggedFlow()
	{
		return true;
	}

	@ConfigItem(
		position = 15,
		keyName = "interruptedFlow",
		name = "Flow - Interrupted",
		description = "",
		parent = "mouseStub"
	)
	default boolean getInterruptedFlow()
	{
		return false;
	}


	@ConfigItem(
		position = 16,
		keyName = "interruptedFlow2",
		name = "Flow - Interrupted 2",
		description = "",
		parent = "mouseStub"
	)
	default boolean getInterruptedFlow2()
	{
		return false;
	}

	@ConfigItem(
		position = 17,
		keyName = "stoppingFlow",
		name = "Flow - Stopping",
		description = "",
		parent = "mouseStub"
	)
	default boolean getStoppingFlow()
	{
		return false;
	}

	@ConfigItem(
		position = 18,
		keyName = "deviationSlopeDivider",
		name = "Deviation slope divider",
		description = "",
		parent = "mouseStub"
	)
	default int getDeviationSlope()
	{
		return 10;
	}


	@ConfigItem(
		position = 19,
		keyName = "noisinessDivider",
		name = "Noisiness divider",
		description = "",
		parent = "mouseStub"
	)
	default String getNoisinessDivider()
	{
		return "2.0D";
	}
}
