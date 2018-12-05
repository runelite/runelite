/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.cannon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

public enum CannonSpots
{

	BLOODVELDS(new WorldPoint(2439, 9821, 0), new WorldPoint(2448, 9821, 0), new WorldPoint(2472, 9833, 0), new WorldPoint(2453, 9817, 0)),
	FIRE_GIANTS(new WorldPoint(2393, 9782, 0), new WorldPoint(2412, 9776, 0), new WorldPoint(2401, 9780, 0)),
	ABBERANT_SPECTRES(new WorldPoint(2456, 9791, 0)),
	HELLHOUNDS(new WorldPoint(2431, 9776, 0), new WorldPoint(2413, 9786, 0), new WorldPoint(2783, 9686, 0)),
	BLACK_DEMONS(new WorldPoint(2859, 9778, 0), new WorldPoint(2841, 9791, 0)),
	ELVES(new WorldPoint(2044, 4635, 0)),
	SUQAHS(new WorldPoint(2114, 3943, 0)),
	TROLLS(new WorldPoint(2401, 3856, 0)),
	GREATER_DEMONS(new WorldPoint(1435, 10086, 2)),
	BRINE_RAT(new WorldPoint(2707, 10132, 0)),
	DAGGANOTH(new WorldPoint(2524, 10020, 0)),
	DARK_BEAST(new WorldPoint(1992, 4655, 0)),
	DUST_DEVIL(new WorldPoint(3218, 9366, 0)),
	KALPHITE(new WorldPoint(3307, 9528, 0)),
	LESSER_DEMON(new WorldPoint(2838, 9559, 0)),
	LIZARDMEN(new WorldPoint(1500, 3703, 0)),
	MINIONS_OF_SCARABAS(new WorldPoint(3297, 9252, 0)),
	SMOKE_DEVIL(new WorldPoint(2398, 9444, 0)),
	CAVE_HORROR(new WorldPoint(3785, 9460, 0)),
	BLUE_DRAGON(new WorldPoint(1933, 8973, 1));

	@Getter
	private static final List<WorldPoint> cannonSpots = new ArrayList<>();

	static
	{
		for (CannonSpots cannonSpot : values())
		{
			cannonSpots.addAll(Arrays.asList(cannonSpot.spots));
		}
	}

	private final WorldPoint[] spots;

	CannonSpots(WorldPoint... spots)
	{
		this.spots = spots;
	}
}
