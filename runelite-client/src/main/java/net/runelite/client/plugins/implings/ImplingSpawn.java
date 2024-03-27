/*
 * Copyright (c) 2018, Mantautas Jurksa <https://github.com/Juzzed>
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
package net.runelite.client.plugins.implings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

/**
 * @author Juzzed
 */
@AllArgsConstructor
@Getter
enum ImplingSpawn
{
	//Baby spawns
	SPAWN_BABY1(new WorldPoint(2563, 4291, 0), ImplingType.BABY),
	SPAWN_BABY2(new WorldPoint(2563, 4348, 0), ImplingType.BABY),
	SPAWN_BABY3(new WorldPoint(2569, 4323, 0), ImplingType.BABY),
	SPAWN_BABY4(new WorldPoint(2571, 4305, 0), ImplingType.BABY),
	SPAWN_BABY5(new WorldPoint(2581, 4300, 0), ImplingType.BABY),
	SPAWN_BABY6(new WorldPoint(2596, 4296, 0), ImplingType.BABY),
	SPAWN_BABY7(new WorldPoint(2609, 4339, 0), ImplingType.BABY),
	SPAWN_BABY8(new WorldPoint(2610, 4304, 0), ImplingType.BABY),
	SPAWN_BABY9(new WorldPoint(2615, 4322, 0), ImplingType.BABY),
	SPAWN_BABY10(new WorldPoint(2620, 4291, 0), ImplingType.BABY),
	SPAWN_BABY11(new WorldPoint(2620, 4348, 0), ImplingType.BABY),

	//Young spawns
	SPAWN_YOUNG1(new WorldPoint(2564, 4321, 0), ImplingType.YOUNG),
	SPAWN_YOUNG2(new WorldPoint(2573, 4330, 0), ImplingType.YOUNG),
	SPAWN_YOUNG3(new WorldPoint(2574, 4321, 0), ImplingType.YOUNG),
	SPAWN_YOUNG4(new WorldPoint(2590, 4348, 0), ImplingType.YOUNG),
	SPAWN_YOUNG5(new WorldPoint(2592, 4291, 0), ImplingType.YOUNG),
	SPAWN_YOUNG6(new WorldPoint(2595, 4343, 0), ImplingType.YOUNG),
	SPAWN_YOUNG7(new WorldPoint(2612, 4327, 0), ImplingType.YOUNG),
	SPAWN_YOUNG8(new WorldPoint(2612, 4309, 0), ImplingType.YOUNG),
	SPAWN_YOUNG9(new WorldPoint(2619, 4322, 0), ImplingType.YOUNG),
	SPAWN_YOUNG10(new WorldPoint(2587, 4300, 0), ImplingType.YOUNG),

	//Gourmet spawns
	SPAWN_GOURMET1(new WorldPoint(2568, 4296, 0), ImplingType.GOURMET),
	SPAWN_GOURMET2(new WorldPoint(2569, 4327, 0), ImplingType.GOURMET),
	SPAWN_GOURMET3(new WorldPoint(2574, 4311, 0), ImplingType.GOURMET),
	SPAWN_GOURMET4(new WorldPoint(2574, 4311, 0), ImplingType.GOURMET),
	SPAWN_GOURMET5(new WorldPoint(2585, 4296, 0), ImplingType.GOURMET),
	SPAWN_GOURMET6(new WorldPoint(2597, 4293, 0), ImplingType.GOURMET),
	SPAWN_GOURMET7(new WorldPoint(2609, 4317, 0), ImplingType.GOURMET),
	SPAWN_GOURMET8(new WorldPoint(2615, 4298, 0), ImplingType.GOURMET),
	SPAWN_GOURMET9(new WorldPoint(2618, 4321, 0), ImplingType.GOURMET),

	//Earth spawns
	SPAWN_EARTH1(new WorldPoint(2570, 4330, 0), ImplingType.EARTH),
	SPAWN_EARTH2(new WorldPoint(2598, 4340, 0), ImplingType.EARTH),
	SPAWN_EARTH3(new WorldPoint(2587, 4342, 0), ImplingType.EARTH),
	SPAWN_EARTH4(new WorldPoint(2612, 4310, 0), ImplingType.EARTH),
	SPAWN_EARTH5(new WorldPoint(2611, 4334, 0), ImplingType.EARTH),

	//Eclectic spawns
	SPAWN_ECLECTIC1(new WorldPoint(2567, 4319, 0), ImplingType.ECLECTIC),
	SPAWN_ECLECTIC2(new WorldPoint(2591, 4340, 0), ImplingType.ECLECTIC),
	SPAWN_ECLECTIC3(new WorldPoint(2591, 4295, 0), ImplingType.ECLECTIC),
	SPAWN_ECLECTIC4(new WorldPoint(2615, 4326, 0), ImplingType.ECLECTIC);

	private final WorldPoint spawnLocation;
	private final ImplingType type;
}
