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

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import net.runelite.client.config.Stub;

@ConfigGroup("pileindicators")
public interface PileIndicatorsConfig extends Config
{
	@ConfigItem(
			keyName = "playerPilesStub",
			name = "Player Piles",
			description = "",
			position = 0
	)
	default Stub playerPilesStub()
	{
		return new Stub();
	}

	@ConfigItem(
			position = 1,
			keyName = "enablePlayers",
			name = "Enable Player Piling",
			description = "Enable the option to highlight players when they pile.",
			parent = "playerPilesStub"
	)
	default boolean enablePlayers()
	{
		return true;
	}

	@ConfigItem(
			position = 2,
			keyName = "wildyOnlyPlayer",
			name = "Wilderness Only",
			description = "Show player piling only when in the Wilderness.",
			parent = "playerPilesStub"
	)
	default boolean wildyOnlyPlayer()
	{
		return true;
	}

	@ConfigItem(
			position = 3,
			keyName = "playerPileColor",
			name = "Player Pile Color",
			description = "Color used for player piles.",
			parent = "playerPilesStub"
	)
	default Color playerPileColor()
	{
		return Color.RED;
	}

	@ConfigItem(
			keyName = "npcPilesStub",
			name = "NPC Piles",
			description = "",
			position = 4
	)
	default Stub npcPilesStub()
	{
		return new Stub();
	}

	@ConfigItem(
			position = 5,
			keyName = "enableNPCS",
			name = "Enable NPC Piling",
			description = "Enable the option to highlight NPCs when they pile.",
			parent = "npcPilesStub"
	)
	default boolean enableNPCS()
	{
		return false;
	}

	@ConfigItem(
			position = 6,
			keyName = "npcPileColor",
			name = "NPC Pile Color",
			description = "Color used for NPC piles.",
			parent = "npcPilesStub"
	)
	default Color npcPileColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
			keyName = "mixedPilesStub",
			name = "Mixed Piles",
			description = "",
			position = 7
	)
	default Stub mixedPilesStub()
	{
		return new Stub();
	}

	@ConfigItem(
			position = 8,
			keyName = "mixedPileColor",
			name = "Mixed Pile Color",
			description = "Color used for mixed piles.",
			parent = "mixedPilesStub"
	)
	default Color mixedPileColor()
	{
		return new Color(255, 0, 255);
	}

	@ConfigItem(
			keyName = "pilesSizeStub",
			name = "Pile size",
			description = "",
			position = 9
	)
	default Stub pilesSizeStub()
	{
		return new Stub();
	}

	@Range(
			min = 2
	)
	@ConfigItem(
			position = 10,
			keyName = "minimumPileSize",
			name = "Minimum Pile Size",
			description = "Any pile under this size will not show up. (Minimum: 2)",
			parent = "pilesSizeStub"
	)
	default int minimumPileSize()
	{
		return 2;
	}

	@ConfigItem(
			keyName = "miscellaneousStub",
			name = "Miscellaneous",
			description = "",
			position = 11
	)
	default Stub miscellaneousStub()
	{
		return new Stub();
	}

	@ConfigItem(
			position = 12,
			keyName = "numberOnly",
			name = "Display Number Only",
			description = "Shorten \"PILE SIZE: 1\" to \"1\"",
			parent = "miscellaneousStub"
	)
	default boolean numberOnly()
	{
		return false;
	}

	@ConfigItem(
			position = 13,
			keyName = "drawPileTile",
			name = "Draw Pile Tile",
			description = "Draws the tile of the pile for best visibility.",
			parent = "miscellaneousStub"
	)
	default boolean drawPileTile()
	{
		return true;
	}

	@ConfigItem(
			position = 14,
			keyName = "drawPileHull",
			name = "Draw Pile Convex Hull",
			description = "Draws the hull of the pile for best visibility.",
			parent = "miscellaneousStub"
	)
	default boolean drawPileHull()
	{
		return false;
	}

}
