/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.pileindicators;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

import java.awt.*;

@ConfigGroup("pileindicators")
public interface PileIndicatorsConfig extends Config
{
	@ConfigItem(
			position = 0,
			keyName = "enablePlayers",
			name = "Enable Player Piling",
			description = "Enable the option to highlight players when they pile.",
			group = "1. Player Piles"
	)
	default boolean enablePlayers()
	{
		return true;
	}

	@ConfigItem(
			position = 1,
			keyName = "wildyOnlyPlayer",
			name = "Wilderness Only",
			description = "Show player piling only when in the Wilderness.",
			group = "1. Player Piles"
	)
	default boolean wildyOnlyPlayer()
	{
		return true;
	}

	@ConfigItem(
			position = 3,
			keyName = "enableNPCS",
			name = "Enable NPC Piling",
			description = "Enable the option to highlight NPCs when they pile.",
			group = "2. NPC Piles"
	)
	default boolean enableNPCS()
	{
		return false;
	}

	@ConfigItem(
			position = 2,
			keyName = "playerPileColor",
			name = "Player Pile Color",
			description = "Color used for player piles.",
			group = "1. Player Piles"
	)
	default Color playerPileColor()
	{
		return Color.RED;
	}

	@ConfigItem(
			position = 4,
			keyName = "npcPileColor",
			name = "NPC Pile Color",
			description = "Color used for NPC piles.",
			group = "2. NPC Piles"
	)
	default Color npcPileColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
			position = 5,
			keyName = "mixedPileColor",
			name = "Mixed Pile Color",
			description = "Color used for mixed piles.",
			group = "3. Mixed Piles"
	)
	default Color mixedPileColor()
	{
		return new Color(255, 0, 255);
	}

	@Range(
			min = 2
	)
	@ConfigItem(
			position = 6,
			keyName = "minimumPileSize",
			name = "Minimum Pile Size",
			description = "Any pile under this size will not show up. (Minimum: 2)",
			group = "4. Pile Size"
	)
	default int minimumPileSize()
	{
		return 2;
	}

	@ConfigItem(
			position = 7,
			keyName = "numberOnly",
			name = "Display Number Only",
			description = "Shorten \"PILE SIZE: 1\" to \"1\"",
			group = "5. Miscellaneous"
	)
	default boolean numberOnly()
	{
		return false;
	}
}
