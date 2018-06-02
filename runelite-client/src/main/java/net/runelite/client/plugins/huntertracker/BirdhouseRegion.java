/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018 Jeff LaJoie
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.huntertracker;

import lombok.Getter;
import net.runelite.api.VarPlayer;

@Getter
public enum BirdhouseRegion
{
	VERDANT_VALLEY("Verdant Valley", 14906,
		new BirdhouseSpace("Southwest", VarPlayer.BIRDHOUSE_1629, SpaceImplementation.BIRDHOUSE),
		new BirdhouseSpace("Northeast", VarPlayer.BIRDHOUSE_1628, SpaceImplementation.BIRDHOUSE)),
	MUSHROOM_MEADOW_NORTH("Mushroom Meadow", 14652,
		new BirdhouseSpace("North", VarPlayer.BIRDHOUSE_1626, SpaceImplementation.BIRDHOUSE)
	),
	MUSHROOM_MEADOW_SOUTH("Mushroom Meadow", 14651,
		new BirdhouseSpace("South", VarPlayer.BIRDHOUSE_1627, SpaceImplementation.BIRDHOUSE)
	);

	private final String name;
	private final int regionID;
	private final BirdhouseSpace[] spaces;
	private final VarPlayer[] varps;

	BirdhouseRegion(String name, int regionID, BirdhouseSpace... spaces)
	{
		this.name = name;
		this.regionID = regionID;
		this.spaces = spaces;
		this.varps = new VarPlayer[spaces.length];
		for (int i = 0; i < spaces.length; i++)
		{
			BirdhouseSpace s = spaces[i];
			s.setRegion(this);
			varps[i] = s.getVarPlayer();
		}
	}
}
