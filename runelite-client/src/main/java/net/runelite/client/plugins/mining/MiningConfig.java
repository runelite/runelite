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

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("mining")
public interface MiningConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "statTimeout",
			name = "Reset stats",
			description = "Duration the mining indicator and session stats are displayed before being reset"
	)
	@Units(Units.MINUTES)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
			position = 2,
			keyName = "showMiningStats",
			name = "Show session stats",
			description = "Configures whether to display mining session stats"
	)
	default boolean showMiningStats()
	{
		return true;
	}

	@ConfigSection(
			name = "Graphics Settings",
			description = "Overlay Graphics settings",
			position = 10
	)
	String visualSection = "Graphics";

	@Alpha
	@ConfigItem(
			position = 11,
			keyName = "hexColorRockOverlay",
			name = "Overlay color",
			description = "Color of the rock overlay",
			section = visualSection
	)
	default Color getRockOverlayColor()
	{
		return Color.YELLOW;
	}

	@Alpha
	@ConfigItem(
			position = 12,
			keyName = "hexColorRockOverlayOutline",
			name = "Overlay outline color",
			description = "Color of the rock outline overlay",
			section = visualSection
	)
	default Color getRockOverlayOutlineColor()
	{
		return Color.ORANGE;
	}

	@Alpha
	@ConfigItem(
			position = 13,
			keyName = "hexColorRockOverlayMLM",
			name = "MLM Overlay color",
			description = "Color of the rock overlay (Motherload Mine, Lovakite)",
			section = visualSection
	)
	default Color getRockOverlayColorMLM()
	{
		return new Color(0, 100, 0);
	}

	@Alpha
	@ConfigItem(
			position = 14,
			keyName = "hexColorRockOutlineOverlayMLM",
			name = "MLM Overlay outline color",
			description = "Color of the outline for the rock overlay (Motherload Mine, Lovakite)",
			section = visualSection
	)
	default Color getRockOverlayOutlineColorMLM()
	{
		return Color.GREEN;
	}

	@ConfigItem(
			position = 15,
			keyName = "getRockOverlayDiameter",
			name = "Rock overlay diameter",
			description = "Adjust the size of the rock overlay",
			section = visualSection
	)
	default int getRockOverlayDiameter()
	{
		return 25;
	}
}