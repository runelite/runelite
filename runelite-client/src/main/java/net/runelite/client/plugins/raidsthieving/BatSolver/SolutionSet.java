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

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;

// Each Thieving room has 4 empty chests
// User-reported data shows these 4 come in groups,
//
// e.g. if there is an empty chest in L room chest 1, the other empty chests could be 16, 17, 38, 54, 55
// See https://dikkenoob.github.io/ for more information

class SolutionSet
{
	static final Multimap<ThievingRoomType, SolutionSet> SOLUTION_SETS =
		ImmutableMultimap.<ThievingRoomType, SolutionSet>builder()
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(1, 16, 17, 55))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(1, 17, 38, 54))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(2, 7, 21, 37))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(3, 5, 19, 30))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(3, 11, 15, 40))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(4, 22, 27, 46))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(5, 9, 19, 45))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(6, 24, 26, 41))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(6, 26, 32, 52))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(7, 13, 44, 59))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(8, 14, 41, 43))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(8, 10, 28, 33))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(8, 31, 47, 50))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(10, 35, 54, 63))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(10, 30, 32, 59))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(12, 40, 53, 56))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(12, 13, 42, 54))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(13, 22, 27, 46))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(14, 18, 23, 51))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(15, 43, 44, 58))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(15, 16, 42, 45))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(20, 29, 45, 51))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(20, 25, 32, 34))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(20, 28, 51, 62))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(21, 39, 41, 58))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(22, 25, 54, 64))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(23, 31, 47, 55))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(23, 33, 37, 60))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(24, 34, 55))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(26, 50, 63, 27))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(29, 39, 41, 61))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(33, 46, 52, 57))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(34, 45, 49, 60))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(36, 40, 42, 62))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(37, 38, 51, 64))
			.put(ThievingRoomType.LEFT_TURN, new SolutionSet(48, 53, 55, 56))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(1, 6, 28, 41))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(1, 42, 55, 60))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(2, 10, 31, 44))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(2, 33, 51, 68))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(3, 31, 43, 46))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(3, 5, 21, 48))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(4, 20, 24, 33))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(4, 38, 47))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(5, 21, 48))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(5, 17, 35, 63))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(7, 17, 45, 47))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(7, 37, 41, 52))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(8, 13, 40, 42))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(8, 20, 24, 30))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(9, 15, 23, 35))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(11, 13, 21, 50))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(11, 18, 37, 39))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(12, 14, 27, 34))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(14, 45, 67, 71))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(16, 22, 29, 32))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(18, 28, 31, 64))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(19, 21, 63, 69))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(20, 51, 68, 72))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(22, 29, 56, 61))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(23, 53, 66, 74))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(26, 35, 53, 59))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(27, 30, 55, 57))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(31, 58, 60, 73))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(34, 57, 58, 70))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(38, 56, 61, 70))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(40, 54, 65, 72))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(42, 46, 65))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(47, 49, 66, 67))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(48, 62, 69))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(9, 19, 32, 41))
			.put(ThievingRoomType.RIGHT_TURN, new SolutionSet(16, 26, 36, 39))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(1, 39, 43, 51))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(2, 15, 20, 53))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(3, 10, 42, 44))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(4, 14, 38, 52))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(5, 6, 35, 41))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(7, 16, 34, 49))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(9, 12, 26, 27))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(13, 25, 30, 31))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(15, 20, 53))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(17, 24, 34, 58))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(18, 23, 35, 57))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(19, 26, 47, 65))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(21, 33, 36, 61))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(21, 54, 66))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(22, 25, 46, 55))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(24, 34, 58))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(28, 40, 52, 62))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(29, 41, 42, 63))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(30, 32, 37, 64))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(39, 43, 51))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(43, 45, 50, 60))
			.put(ThievingRoomType.STRAIGHT, new SolutionSet(51, 53, 56, 59))
			.build();

	SolutionSet()
	{
		emptyChests = new HashSet<>();
	}

	private SolutionSet(final Integer... emptyChests)
	{
		this.emptyChests = new HashSet<>(Arrays.asList(emptyChests));
	}

	void addEmptyChest(int chestId)
	{
		emptyChests.add(chestId);
	}

	boolean containsChest(int chestId)
	{
		return emptyChests.contains(chestId);
	}

	@Getter(AccessLevel.PACKAGE)
	private Set<Integer> emptyChests;
}
