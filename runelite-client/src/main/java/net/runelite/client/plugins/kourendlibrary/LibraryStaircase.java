/*
 * Copyright (c) 2019 Koekkruimels
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
package net.runelite.client.plugins.kourendlibrary;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nonnull;

@Slf4j
public enum LibraryStaircase
{
	SOUTH_WEST_0_1(new WorldPoint(1615, 3795, 0), LibrarySection.SOUTH_WEST, LibraryLevel.GROUND_FLOOR, LibraryLevel.MIDDLE_FLOOR),
	SOUTH_WEST_1_0(new WorldPoint(1612, 3795, 1), LibrarySection.SOUTH_WEST, LibraryLevel.MIDDLE_FLOOR, LibraryLevel.GROUND_FLOOR),
	SOUTH_WEST_1_2(new WorldPoint(1621, 3793, 1), LibrarySection.SOUTH_WEST, LibraryLevel.MIDDLE_FLOOR, LibraryLevel.TOP_FLOOR),
	SOUTH_WEST_2_1(new WorldPoint(1621, 3796, 2), LibrarySection.SOUTH_WEST, LibraryLevel.TOP_FLOOR, LibraryLevel.MIDDLE_FLOOR),
	NORTH_WEST_2_1(new WorldPoint(1610, 3818, 2), LibrarySection.NORTH_WEST, LibraryLevel.TOP_FLOOR, LibraryLevel.MIDDLE_FLOOR),
	NORTH_WEST_1_2(new WorldPoint(1613, 3818, 1), LibrarySection.NORTH_WEST, LibraryLevel.MIDDLE_FLOOR, LibraryLevel.TOP_FLOOR),
	NORTH_WEST_1_0(new WorldPoint(1612, 3826, 1), LibrarySection.NORTH_WEST, LibraryLevel.MIDDLE_FLOOR, LibraryLevel.GROUND_FLOOR),
	NORTH_WEST_0_1(new WorldPoint(1615, 3826, 0), LibrarySection.NORTH_WEST, LibraryLevel.GROUND_FLOOR, LibraryLevel.MIDDLE_FLOOR),
	NORTH_EAST_0_1(new WorldPoint(1644, 3820, 0), LibrarySection.NORTH_EAST, LibraryLevel.GROUND_FLOOR, LibraryLevel.MIDDLE_FLOOR),
	NORTH_EAST_1_0(new WorldPoint(1645, 3823, 1), LibrarySection.NORTH_EAST, LibraryLevel.MIDDLE_FLOOR, LibraryLevel.GROUND_FLOOR),
	NORTH_EAST_1_2(new WorldPoint(1645, 3828, 1), LibrarySection.NORTH_EAST, LibraryLevel.MIDDLE_FLOOR, LibraryLevel.TOP_FLOOR),
	NORTH_EAST_2_1(new WorldPoint(1648, 3828, 2), LibrarySection.NORTH_EAST, LibraryLevel.TOP_FLOOR, LibraryLevel.MIDDLE_FLOOR),
	CENTER_2_1(new WorldPoint(1638, 3805, 2), LibrarySection.CENTER, LibraryLevel.TOP_FLOOR, LibraryLevel.MIDDLE_FLOOR),
	CENTER_1_2(new WorldPoint(1638, 3808, 1), LibrarySection.CENTER, LibraryLevel.MIDDLE_FLOOR, LibraryLevel.TOP_FLOOR);

	@Getter
	private WorldPoint location;

	@Getter
	private LibraryLevel fromLevel;

	@Getter
	private LibraryLevel toLevel;

	@Getter
	private LibrarySection section;

	LibraryStaircase(@Nonnull WorldPoint location, @Nonnull LibrarySection section, @Nonnull LibraryLevel fromLevel, @Nonnull LibraryLevel toLevel)
	{
		this.location = location;
		this.section = section;
		this.fromLevel = fromLevel;
		this.toLevel = toLevel;
	}

	public int direction()
	{
		return Math.min(Math.max((toLevel.getPlane() - fromLevel.getPlane()), -1), 1);
	}
}
