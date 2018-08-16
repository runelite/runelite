/*
 * Copyright (c) 2017, Ron <https://github.com/raiyni>
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
package net.runelite.client.plugins.worldmap;

import lombok.Getter;
import net.runelite.api.coords.WorldLine;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum WildernessLinesData
{
	WILDERNESS_5(5, new WorldLine(new WorldPoint(2945, 3552, 0), new WorldPoint(3383, 3552, 0))),
	WILDERNESS_10(10, new WorldLine(new WorldPoint(2952, 3592, 0), new WorldPoint(3364, 3592, 0))),
	WILDERNESS_15(15, new WorldLine(new WorldPoint(2953, 3632, 0), new WorldPoint(3347, 3632, 0))),
	WILDERNESS_20(20, new WorldLine(new WorldPoint(2951, 3672, 0), new WorldPoint(3378, 3672, 0))),
	WILDERNESS_25(25, new WorldLine(new WorldPoint(2951, 3712, 0), new WorldPoint(3369, 3712, 0))),
	WILDERNESS_30(30, new WorldLine(new WorldPoint(2951, 3752, 0), new WorldPoint(3384, 3752, 0))),
	WILDERNESS_35(35, new WorldLine(new WorldPoint(2951, 3792, 0), new WorldPoint(3348, 3792, 0))),
	WILDERNESS_40(40, new WorldLine(new WorldPoint(2952, 3832, 0), new WorldPoint(3345, 3832, 0))),
	WILDERNESS_45(45, new WorldLine(new WorldPoint(2945, 3872, 0), new WorldPoint(3380, 3872, 0))),
	WILDERNESS_50(50, new WorldLine(new WorldPoint(2945, 3912, 0), new WorldPoint(3380, 3912, 0))),
	WILDERNESS_55(55, new WorldLine(new WorldPoint(2963, 3952, 0), new WorldPoint(3380, 3952, 0))),

	EDGEVILLE_DUNGEON_5(5, new WorldLine(new WorldPoint(3079, 9952, 0), new WorldPoint(3128, 9952, 0))),
	EDGEVILLE_DUNGEON_10(5, new WorldLine(new WorldPoint(3115, 9992, 0), new WorldPoint(3127, 9992, 0))),

	WILDERNESS_DUNGEON(25, new WorldLine(new WorldPoint(2941, 10088, 0), new WorldPoint(2983, 10088, 0))),

	REVENANT_CAVE_20(20, new WorldLine(new WorldPoint(3193, 10072, 0), new WorldPoint(3232, 10072, 0))),
	REVENANT_CAVE_25(25, new WorldLine(new WorldPoint(3145, 10112, 0), new WorldPoint(3245, 10112, 0))),
	REVENANT_CAVE_30(30, new WorldLine(new WorldPoint(3157, 10152, 0), new WorldPoint(3255, 10152, 0))),
	REVENANT_CAVE_35(35, new WorldLine(new WorldPoint(3161, 10192, 0), new WorldPoint(3259, 10192, 0))),
	REVENANT_CAVE_40(40, new WorldLine(new WorldPoint(3238, 10232, 0), new WorldPoint(3243, 10232, 0))),

	LAVA_MAZE_DUNGEON(45, new WorldLine(new WorldPoint(3050, 10272, 0), new WorldPoint(3057, 10272, 0))),

	DUNGEON(50, new WorldLine(new WorldPoint(3018, 10312, 0), new WorldPoint(3046, 10312, 0)));


	private final String tooltip;

	private final int level;

	private final WorldLine worldLine;

	WildernessLinesData(int level, WorldLine worldLine)
	{
		this.tooltip = "Level " + Integer.toString(level) + " wilderness";
		this.level = level;
		this.worldLine = worldLine;
	}

}
