/*
 * Copyright (c) 2020, Jordan Zomerlei <https://github.com/JZomerlei>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.mining;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Units;

@ConfigGroup("mining")
public interface MiningConfig extends Config
{
	@ConfigSection(
		name = "Cam Torum Mine",
		description = "Configuration for Cam Torum Mine",
		position = 10
	)
	String camTorumMineSection = "camTorumMineSection";

	@ConfigItem(
		keyName = "statTimeout",
		name = "Reset stats",
		description = "Duration the mining indicator and session stats are displayed before being reset",
		position = 0
	)
	@Units(Units.MINUTES)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
		keyName = "showMiningStats",
		name = "Show session stats",
		description = "Configures whether to display mining session stats",
		position = 1
	)
	default boolean showMiningStats()
	{
		return true;
	}

	@ConfigItem(
		keyName = "waterOverlayColor",
		name = "Water Overlay Color",
		description = "Color of water overlay",
		position = 2,
		section = camTorumMineSection
	)
	default Color camTorumWaterOverlayColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "notifyWater",
		name = "Notify Water Spawn",
		description = "Notifies you when watery rocks spawn",
		position = 3,
		section = camTorumMineSection
	)
	default boolean camTorumNotifyWaterSpawn()
	{
		return true;
	}
}
