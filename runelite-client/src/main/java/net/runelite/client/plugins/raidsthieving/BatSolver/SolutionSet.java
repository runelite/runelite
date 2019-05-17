/*
 * Copyright (c) 2018, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving.BatSolver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

// Each Thieving room has 4 empty chests
// User-reported data shows these 4 come in groups,
//
// e.g. if there is an empty chest in L room chest 1, the other empty chests could be 16, 17, 38, 54, 55
// See https://dikkenoob.github.io/ for more information

public class SolutionSet
{
	public static final SolutionSet[] SOLUTION_SETS =
		{
			new SolutionSet(ThievingRoomType.LEFT_TURN, 1, 16, 17, 55),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 1, 17, 38, 54),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 2, 7, 21, 37),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 3, 5, 19, 30),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 3, 11, 15, 40),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 4, 22, 27, 46),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 5, 9, 19, 45),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 6, 24, 26, 41),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 6, 26, 32, 52),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 7, 13, 44, 59),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 8, 14, 41, 43),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 8, 10, 28, 33),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 8, 31, 47, 50),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 10, 35, 54, 63),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 10, 30, 32, 59),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 12, 40, 53, 56),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 12, 13, 42, 54),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 13, 22, 27, 46),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 14, 18, 23, 51),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 15, 43, 44, 58),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 15, 16, 42, 45),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 20, 29, 45, 51),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 20, 25, 32, 34),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 20, 28, 51, 62),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 21, 39, 41, 58),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 22, 25, 54, 64),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 23, 31, 47, 55),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 23, 33, 37, 60),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 24, 34, 55),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 26, 50, 63, 27),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 29, 39, 41, 61),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 33, 46, 52, 57),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 34, 45, 49, 60),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 36, 40, 42, 62),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 37, 38, 51, 64),
			new SolutionSet(ThievingRoomType.LEFT_TURN, 48, 53, 55, 56),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 1, 6, 28, 41),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 1, 42, 55, 60),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 2, 10, 31, 44),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 2, 33, 51, 68),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 3, 31, 43, 46),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 3, 5, 21, 48),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 4, 20, 24, 33),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 4, 38, 47),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 5, 21, 48),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 5, 17, 35, 63),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 7, 17, 45, 47),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 7, 37, 41, 52),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 8, 13, 40, 42),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 8, 20, 24, 30),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 9, 15, 23, 35),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 11, 13, 21, 50),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 11, 18, 37, 39),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 12, 14, 27, 34),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 14, 45, 67, 71),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 16, 22, 29, 32),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 18, 28, 31, 64),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 19, 21, 63, 69),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 20, 51, 68, 72),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 22, 29, 56, 61),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 23, 53, 66, 74),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 26, 35, 53, 59),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 27, 30, 55, 57),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 31, 58, 60, 73),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 34, 57, 58, 70),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 38, 56, 61, 70),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 40, 54, 65, 72),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 42, 46, 65),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 47, 49, 66, 67),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 48, 62, 69),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 9, 19, 32, 41),
			new SolutionSet(ThievingRoomType.RIGHT_TURN, 16, 26, 36, 39),
			new SolutionSet(ThievingRoomType.STRAIGHT, 1, 39, 43, 51),
			new SolutionSet(ThievingRoomType.STRAIGHT, 2, 15, 20, 53),
			new SolutionSet(ThievingRoomType.STRAIGHT, 3, 10, 42, 44),
			new SolutionSet(ThievingRoomType.STRAIGHT, 4, 14, 38, 52),
			new SolutionSet(ThievingRoomType.STRAIGHT, 5, 6, 35, 41),
			new SolutionSet(ThievingRoomType.STRAIGHT, 7, 16, 34, 49),
			new SolutionSet(ThievingRoomType.STRAIGHT, 9, 12, 26, 27),
			new SolutionSet(ThievingRoomType.STRAIGHT, 13, 25, 30, 31),
			new SolutionSet(ThievingRoomType.STRAIGHT, 15, 20, 53),
			new SolutionSet(ThievingRoomType.STRAIGHT, 17, 24, 34, 58),
			new SolutionSet(ThievingRoomType.STRAIGHT, 18, 23, 35, 57),
			new SolutionSet(ThievingRoomType.STRAIGHT, 19, 26, 47, 65),
			new SolutionSet(ThievingRoomType.STRAIGHT, 21, 33, 36, 61),
			new SolutionSet(ThievingRoomType.STRAIGHT, 21, 54, 66),
			new SolutionSet(ThievingRoomType.STRAIGHT, 22, 25, 46, 55),
			new SolutionSet(ThievingRoomType.STRAIGHT, 24, 34, 58),
			new SolutionSet(ThievingRoomType.STRAIGHT, 28, 40, 52, 62),
			new SolutionSet(ThievingRoomType.STRAIGHT, 29, 41, 42, 63),
			new SolutionSet(ThievingRoomType.STRAIGHT, 30, 32, 37, 64),
			new SolutionSet(ThievingRoomType.STRAIGHT, 39, 43, 51),
			new SolutionSet(ThievingRoomType.STRAIGHT, 43, 45, 50, 60),
			new SolutionSet(ThievingRoomType.STRAIGHT, 51, 53, 56, 59)
		};

	SolutionSet(ThievingRoomType type)
	{
		this.type = type;
		emptyChests = new HashSet<>();
	}

	private SolutionSet(ThievingRoomType type, Integer... emptyChests)
	{
		this.type = type;
		this.emptyChests = new HashSet<>(Arrays.asList(emptyChests));
	}

	public void addEmptyChest(int chestId)
	{
		emptyChests.add(chestId);
	}

	public boolean containsChest(int chestId)
	{
		return emptyChests.contains(chestId);
	}

	@Getter
	private ThievingRoomType type;

	@Getter
	private Set<Integer> emptyChests;
}
