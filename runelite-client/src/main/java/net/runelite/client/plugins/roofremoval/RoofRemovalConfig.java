/*
 * Copyright (c) 2021, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.roofremoval;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(RoofRemovalConfig.CONFIG_GROUP)
public interface RoofRemovalConfig extends Config
{
	String CONFIG_GROUP = "roofremoval";

	@ConfigItem(
		keyName = "removePosition",
		name = "Player's position",
		description = "Remove roofs above the player's position"
	)
	default boolean removePosition()
	{
		return true;
	}

	@ConfigItem(
		keyName = "removeHovered",
		name = "Hovered tile",
		description = "Remove roofs above the hovered tile"
	)
	default boolean removeHovered()
	{
		return true;
	}

	@ConfigItem(
		keyName = "removeDestination",
		name = "Destination tile",
		description = "Remove roofs above the destination tile"
	)
	default boolean removeDestination()
	{
		return true;
	}

	@ConfigItem(
		keyName = "removeBetween",
		name = "Between camera & player",
		description = "Remove roofs between the camera and the player at low camera angles"
	)
	default boolean removeBetween()
	{
		return true;
	}
}
