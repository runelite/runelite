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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SpaceImplementation
{
	BIRDHOUSE(Tab.FOSSIL_ISLAND, "")
	{
		@Override
		SpaceState forVarPlayerValue(int value)
		{
			SpaceState spaceState = null;
			switch (value)
			{
				case 0:
					spaceState = new SpaceState(BirdhouseState.EMPTY, null, value);
					break;
				case 1:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.NORMAL, value);
					break;
				case 3:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.NORMAL, value);
					break;
				case 4:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.OAK, value);
					break;
				case 6:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.OAK, value);
					break;
				case 7:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.WILLOW, value);
					break;
				case 9:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.WILLOW, value);
					break;
				case 10:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.TEAK, value);
					break;
				case 12:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.TEAK, value);
					break;
				case 13:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.MAPLE, value);
					break;
				case 15:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.MAPLE, value);
					break;
				case 16:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.MAHOGANY, value);
					break;
				case 18:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.MAHOGANY, value);
					break;
				case 19:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.YEW, value);
					break;
				case 21:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.YEW, value);
					break;
				case 22:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.MAGIC, value);
					break;
				case 24:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.MAGIC, value);
					break;
				case 25:
					spaceState = new SpaceState(BirdhouseState.BUILT, Birdhouse.REDWOOD, value);
					break;
				case 27:
					spaceState = new SpaceState(BirdhouseState.SEEDED, Birdhouse.REDWOOD, value);
					break;
			}
			return spaceState;
		}
	};

	abstract SpaceState forVarPlayerValue(int value);

	private final Tab tab;

	private final String name;
}
