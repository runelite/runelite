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

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
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
public enum MiningRockType
{

	COPPER(0, "Copper", 1, 2.5, -1, false, true, ROCKS_7453, ROCKS_7484),
	TIN(1, "Tin", 1, 2.5, -1, false, true, ROCKS_7485, ROCKS_7486),
	IRON(2, "Iron", 15, 5.5, -1, false, true, ROCKS_7455, ROCKS_7488),
	SILVER(3, "Silver", 15, 60, -1, false, true, ROCKS_7457, ROCKS_7490),
	COAL(4, "Coal", 30, 29.5, -1, false, true, ROCKS_7456, ROCKS_7489),
	GOLD(5, "Gold", 40, 59.5, -1, false, true, ROCKS_7458, ROCKS_7491),
	MITHRIL(6, "Mithril", 55, 119.5, -1, false, true, ROCKS_7459, ROCKS_7492),
	ADAMANTITE(7, "Adamantite", 70, 239.5, -1, false, true, ROCKS_7460, ROCKS_7493),
	RUNITE(8, "Runite", 85, 720, -1, false, true, ROCKS_7461, ROCKS_7494),
	AMETHYST(9, "Amethyst", 92, 75, -1, true, false, EMPTY_WALL),
	PAY_DIRT(10, "Pay-Dirt", 30, 95, 125, true, false, DEPLETED_VEIN_26665, DEPLETED_VEIN_26666, DEPLETED_VEIN_26667, DEPLETED_VEIN_26668);

	@Getter(AccessLevel.PACKAGE)
	private final int index;

	@Getter(AccessLevel.PACKAGE)
	private final String name;

	@Getter(AccessLevel.PACKAGE)
	private final int requiredLevel;

	@Getter(AccessLevel.PACKAGE)
	private final boolean memberOnly;

	@Getter(AccessLevel.PACKAGE)
	private final boolean ground;

	private final List<Integer> rocks;

	@Getter(AccessLevel.PACKAGE)
	private final double respawnTime, maxRespawnTime;

	/**
	 * @param index					Index, used to programmatically access element from an array.
	 * @param name					Name to check for in chat & to display to player
	 * @param level					The mining level required to mine this rock
	 * @param respawnTime			The minimum respawn time for this rock
	 * @param maxRespawnTime		The maximum respawn for this rock (-1 if no range)
	 * @param memberOnly			If the rock can only be mined by members
	 * @param ground				If the rock spawns on the ground or on a wall (true for ground, false for wall)
	 * @param rocks					The RS IDs for the rocks. (Wall rocks uses the blank ID)
	 */
	MiningRockType(int index, String name, int level, double respawnTime, double maxRespawnTime, boolean memberOnly, boolean ground, int... rocks)
	{
		this.index = index;
		this.name = name;
		this.requiredLevel = level;
		this.respawnTime = respawnTime;
		this.maxRespawnTime = maxRespawnTime;
		this.memberOnly = memberOnly;
		this.ground = ground;
		this.rocks = new ArrayList<>();

		for (int rock : rocks)
			this.rocks.add(rock);
	}

	/**
	 * Attempts to find the Type based on a TileObject ID
	 * @param id		TileObject id
	 * @return			Matching type, else null
	 */
	public static MiningRockType getTypeFromID(int id)
	{
		for (MiningRockType type : values())
		{
			if (type.rocks.contains(id))
				return type;
		}
		return null;
	}

	/**
	 * Attempts to find the Type based on the rocks name
	 * @param name		Rocks name (case insensitive)
	 * @return			Matching type, else null
	 */
	public static MiningRockType getTypeFromName(String name)
	{
		for (MiningRockType type : values())
		{
			if (type.getName().equalsIgnoreCase(name))
				return type;
		}
		return null;
	}

	/**
	 * The rocks which can be tracked across worlds
	 */
	public enum WorldRock
	{
		None(null),
		Adamantite(MiningRockType.ADAMANTITE),
		Gold(MiningRockType.GOLD),
		Mithril(MiningRockType.MITHRIL),
		Runite(MiningRockType.RUNITE);

		@Getter(AccessLevel.PACKAGE)
		private final MiningRockType rockType;

		/**
		 * @param type		The associated MiningRockType
		 */
		WorldRock(MiningRockType type)
		{
			rockType = type;
		}
	}

}
