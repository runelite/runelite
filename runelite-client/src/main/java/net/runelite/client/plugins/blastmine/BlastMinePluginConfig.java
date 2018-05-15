/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.blastmine;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup(
	keyName = "blastmineplugin",
	name = "Blast Mine",
	description = "Configuration for the Blast Mine plugin"
)
public interface BlastMinePluginConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "showOreOverlay",
		name = "Show ore overlay",
		description = "Configures whether or not the ore count overlay is displayed"
	)
	default boolean showOreOverlay()
	{
		return true;
	}

	@ConfigItem(
			position = 1,
			keyName = "showSackDetails",
			name = "Show xp and gp in sack",
			description = "Configures whether or not the collected experience and gp is displayed"
	)
	default boolean showSackDetails()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "showRockIconOverlay",
		name = "Show icons overlay",
		description = "Configures whether or not the icon overlay is displayed"
	)
	default boolean showRockIconOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "showTimerOverlay",
		name = "Show timer overlay",
		description = "Configures whether or not the timer overlay is displayed"
	)
	default boolean showTimerOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 4,
		keyName = "showWarningOverlay",
		name = "Show explosion warning",
		description = "Configures whether or not the explosion warning overlay is displayed"
	)
	default boolean showWarningOverlay()
	{
		return true;
	}

	@ConfigItem(
			position = 5,
			keyName = "hexTimerFillColor",
			name = "Timer fill color",
			description = "Fill Color of timer overlay"
	)
	default Color getTimerFillColor()
	{
		return new Color(217, 54, 0);
	}

	@ConfigItem(
			position = 6,
			keyName = "hexTimerBorderColor",
			name = "Timer border color",
			description = "Border Color of timer overlay"
	)
	default Color getTimerBorderColor()
	{
		return new Color(255, 255, 255);
	}

	@ConfigItem(
		position = 7,
		keyName = "hexWarningColor",
		name = "Warning color",
		description = "Color of warning overlay"
	)
	default Color getWarningColor()
	{
		return new Color(217, 54, 0);
	}
}
