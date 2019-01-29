/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.combatindicator;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("combatindicator")
public interface CombatIndicatorConfig extends Config
{
	@ConfigItem(
			keyName = "targetedIndicatorEnabled",
			name = "NPC -> Player",
			description = "Configures an indicator when an entity has targeted you",
			position = 0
	)
	default boolean getTargetedIndicatorEnabled()
	{
		return true;
	}

	@ConfigItem(
			keyName = "targetedIndicatorColour",
			name = "NPC -> Player Color",
			description = "Configures the color of the indicator when entity has targeted you",
			position = 1
	)
	default Color getTargetedIndicatorColour()
	{
		return Color.decode("#FF0000");
	}

	@ConfigItem(
			keyName = "targetIndicatorEnabled",
			name = "Player -> NPC",
			description = "Configures an indicator when you target an entity",
			position = 2
	)
	default boolean getTargetIndicatorEnabled()
	{
		return true;
	}

	@ConfigItem(
			keyName = "targetIndicatorColour",
			name = "Player -> NPC Color",
			description = "Configures the color of the indicator when you target an entity",
			position = 3
	)
	default Color getTargetIndicatorColour()
	{
		return Color.decode("#00FF00");
	}

	@ConfigItem(
			keyName = "combinedColour",
			name = "Combined Color",
			description = "Configures the color when both cases are true",
			position = 4
	)
	default Color getCombinedColour()
	{
		return Color.decode("#0000FF");
	}
}
