/*
 * Copyright (c) 2018, https://openosrs.com Dutta64
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
package net.runelite.client.plugins.lizardmanshaman;

import java.awt.Color;
import lombok.RequiredArgsConstructor;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("lizardmanshaman")
public interface LizardmanShamanConfig extends Config
{
	@RequiredArgsConstructor
	enum SpawnOverlayConfig
	{
		EXPLOSION_ONLY("Explosion Only"),
		ALWAYS("Always"),
		DISABLED("Disabled");

		private final String name;

		@Override
		public String toString()
		{
			return name;
		}
	}

	@ConfigSection(
		keyName = "features",
		name = "Features",
		description = "Enable or disable plugin features.",
		position = 0
	)
	default boolean features()
	{
		return true;
	}

	@ConfigItem(
		keyName = "spawnOverlay",
		name = "Spawn Overlay",
		description = "Show an overlay for Spawn's explosion tiles.",
		section = "features",
		position = 1
	)
	default SpawnOverlayConfig showSpawnOverlay()
	{
		return SpawnOverlayConfig.ALWAYS;
	}

	@ConfigSection(
		keyName = "colors",
		name = "Colors",
		description = "Customize overlay colors.",
		position = 1
	)
	default boolean colors()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "explosionBorderColor",
		name = "Explosion Border",
		description = "Spawn explosion tiles overlay border.",
		section = "colors",
		position = 1
	)
	default Color explosionBorderColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		keyName = "explosionFillColor",
		name = "Explosion Fill",
		description = "Spawn explosion tiles overlay fill.",
		section = "colors",
		position = 2
	)
	default Color explosionFillColor()
	{
		return new Color(255, 0, 0, 20);
	}

	@Alpha
	@ConfigItem(
		keyName = "spawnWalkableBorderColor",
		name = "Walkable Border",
		description = "Spawn walkable tiles overlay border.",
		section = "colors",
		position = 3
	)
	default Color spawnWalkableBorderColor()
	{
		return Color.ORANGE;
	}

	@Alpha
	@ConfigItem(
		keyName = "spawnWalkableFillColor",
		name = "Walkable Fill",
		description = "Spawn walkable tiles overlay fill.",
		section = "colors",
		position = 4
	)
	default Color spawnWalkableFillColor()
	{
		return new Color(255, 165, 0, 20);
	}
}