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
package net.runelite.client.plugins.learntoclick;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("learntoclick")
public interface LearnToClickConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "blockCompass",
		name = "Compass",
		description = "Prevents the camera from moving when you misclick on the compass"
	)
	default boolean shouldBlockCompass()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "rightClickMap",
		name = "World Map",
		description = "Prevents the world map from opening on left click without disabling it entirely"
	)
	default boolean shouldRightClickMap()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "rightClickXp",
		name = "Xp Drops Toggle",
		description = "Prevents toggling xp drops on left click without disabling the toggle function entirely"
	)
	default boolean shouldRightClickXp()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "rightClickRetaliate",
		name = "Auto Retaliate",
		description = "Prevents toggling auto retaliate on left click without disabling the toggle function entirely"
	)
	default boolean shouldRightClickRetaliate()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "hideOrbs",
		name = "Hide Orbs",
		description = "Completely hides the world map and special attack orbs"
	)
	default boolean hideOrbs()
	{
		return false;
	}
}