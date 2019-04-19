/*
 * Copyright (c) 2018, Craftiii4 <Craftiii4@gmail.com>
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
package net.runelite.client.plugins.mining;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import static net.runelite.api.ObjectID.ROCKS_7453;
import static net.runelite.api.ObjectID.ROCKS_7455;
import static net.runelite.api.ObjectID.ROCKS_7456;
import static net.runelite.api.ObjectID.ROCKS_7457;
import static net.runelite.api.ObjectID.ROCKS_7458;
import static net.runelite.api.ObjectID.ROCKS_7459;
import static net.runelite.api.ObjectID.ROCKS_7460;
import static net.runelite.api.ObjectID.ROCKS_7461;
import static net.runelite.api.ObjectID.ROCKS_7484;
import static net.runelite.api.ObjectID.ROCKS_7485;
import static net.runelite.api.ObjectID.ROCKS_7486;
import static net.runelite.api.ObjectID.ROCKS_7488;
import static net.runelite.api.ObjectID.ROCKS_7489;
import static net.runelite.api.ObjectID.ROCKS_7490;
import static net.runelite.api.ObjectID.ROCKS_7491;
import static net.runelite.api.ObjectID.ROCKS_7492;
import static net.runelite.api.ObjectID.ROCKS_7493;
import static net.runelite.api.ObjectID.ROCKS_7494;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26665;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26666;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26667;
import static net.runelite.api.ObjectID.DEPLETED_VEIN_26668;

/**
 * All the possible rock types the user can mine.
 */
@AllArgsConstructor
public enum MiningRockType
{

	COPPER("Copper", 1, 2.5, -1, false, true, new int[] {ROCKS_7453, ROCKS_7484}),
	TIN("Tin", 1, 2.5, -1, false, true, new int[] {ROCKS_7485, ROCKS_7486}),
	IRON( "Iron", 15, 5.5, -1, false, true, new int[] {ROCKS_7455, ROCKS_7488}),
	SILVER("Silver", 15, 60, -1, false, true, new int[] {ROCKS_7457, ROCKS_7490}),
	COAL("Coal", 30, 29.5, -1, false, true, new int[] {ROCKS_7456, ROCKS_7489}),
	GOLD("Gold", 40, 59.5, -1, false, true, new int[] {ROCKS_7458, ROCKS_7491}),
	MITHRIL("Mithril", 55, 119.5, -1, false, true, new int[] {ROCKS_7459, ROCKS_7492}),
	ADAMANTITE("Adamantite", 70, 239.5, -1, false, true, new int[] {ROCKS_7460, ROCKS_7493}),
	RUNITE("Runite", 85, 720, -1, false, true, new int[] {ROCKS_7461, ROCKS_7494}),
	AMETHYST("Amethyst", 92, 150, -1, true, false, new int[] {EMPTY_WALL}),
	PAY_DIRT("Pay-Dirt", 30, 95, 125, true, false, new int[] {DEPLETED_VEIN_26665, DEPLETED_VEIN_26666, DEPLETED_VEIN_26667, DEPLETED_VEIN_26668});

	@Getter(AccessLevel.PACKAGE)
	private final String name;

	@Getter(AccessLevel.PACKAGE)
	private final int requiredMiningLevel;

	@Getter(AccessLevel.PACKAGE)
	private final double minRespawnTime, maxRespawnTime;

	@Getter(AccessLevel.PACKAGE)
	private final boolean memberOnly;

	@Getter(AccessLevel.PACKAGE)
	private final boolean groundObject;

	private final int[] rockIDs;

	public static MiningRockType getTypeFromID(int id)
	{
		for (MiningRockType type : values())
		{
			for (int i : type.rockIDs)
			{
				if (i == id)
				{
					return type;
				}
			}
		}
		return null;
	}

	public static MiningRockType getTypeFromName(String name)
	{
		for (MiningRockType type : values())
		{
			if (type.getName().equalsIgnoreCase(name))
			{
				return type;
			}
		}
		return null;
	}

	/**
	 * The rocks which can be tracked across worlds
	 */
	@AllArgsConstructor
	public enum WorldRock
	{
		None(null),
		Adamantite(MiningRockType.ADAMANTITE),
		Gold(MiningRockType.GOLD),
		Mithril(MiningRockType.MITHRIL),
		Runite(MiningRockType.RUNITE);

		@Getter(AccessLevel.PACKAGE)
		private final MiningRockType rockType;
	}
}
