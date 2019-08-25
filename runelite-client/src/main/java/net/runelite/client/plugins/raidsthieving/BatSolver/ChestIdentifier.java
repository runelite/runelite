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

import java.util.Map;
import net.runelite.api.Point;
import net.runelite.client.plugins.raidsthieving.ThievingChest;
import java.util.HashMap;

public class ChestIdentifier
{
	public ChestIdentifier(final ThievingRoomType roomType)
	{
		chestIds = new HashMap<>();
		switch (roomType)
		{
			case LEFT_TURN:
				chestIds.put(new Point(3283, 5379), 1);
				chestIds.put(new Point(3285, 5380), 2);
				chestIds.put(new Point(3279, 5381), 3);
				chestIds.put(new Point(3287, 5382), 4);
				chestIds.put(new Point(3281, 5382), 5);
				chestIds.put(new Point(3284, 5383), 6);
				chestIds.put(new Point(3283, 5384), 7);
				chestIds.put(new Point(3286, 5384), 8);
				chestIds.put(new Point(3288, 5384), 9);
				chestIds.put(new Point(3277, 5385), 10);
				chestIds.put(new Point(3280, 5385), 11);
				chestIds.put(new Point(3285, 5386), 12);
				chestIds.put(new Point(3290, 5386), 13);
				chestIds.put(new Point(3275, 5387), 14);
				chestIds.put(new Point(3287, 5387), 15);
				chestIds.put(new Point(3288, 5387), 16);
				chestIds.put(new Point(3281, 5388), 17);
				chestIds.put(new Point(3291, 5388), 18);
				chestIds.put(new Point(3280, 5389), 19);
				chestIds.put(new Point(3285, 5389), 20);
				chestIds.put(new Point(3289, 5389), 21);
				chestIds.put(new Point(3283, 5390), 22);
				chestIds.put(new Point(3285, 5390), 23);
				chestIds.put(new Point(3288, 5390), 24);
				chestIds.put(new Point(3290, 5390), 25);
				chestIds.put(new Point(3282, 5391), 26);
				chestIds.put(new Point(3289, 5391), 27);
				chestIds.put(new Point(3292, 5391), 28);
				chestIds.put(new Point(3279, 5392), 29);
				chestIds.put(new Point(3276, 5393), 30);
				chestIds.put(new Point(3279, 5393), 31);
				chestIds.put(new Point(3284, 5393), 32);
				chestIds.put(new Point(3285, 5393), 33);
				chestIds.put(new Point(3291, 5393), 34);
				chestIds.put(new Point(3275, 5394), 35);
				chestIds.put(new Point(3277, 5394), 36);
				chestIds.put(new Point(3288, 5394), 37);
				chestIds.put(new Point(3276, 5395), 38);
				chestIds.put(new Point(3281, 5395), 39);
				chestIds.put(new Point(3285, 5395), 40);
				chestIds.put(new Point(3287, 5395), 41);
				chestIds.put(new Point(3289, 5395), 42);
				chestIds.put(new Point(3274, 5396), 43);
				chestIds.put(new Point(3283, 5396), 44);
				chestIds.put(new Point(3285, 5396), 45);
				chestIds.put(new Point(3288, 5396), 46);
				chestIds.put(new Point(3272, 5397), 47);
				chestIds.put(new Point(3280, 5397), 48);
				chestIds.put(new Point(3277, 5398), 49);
				chestIds.put(new Point(3281, 5398), 50);
				chestIds.put(new Point(3284, 5398), 51);
				chestIds.put(new Point(3276, 5399), 52);
				chestIds.put(new Point(3278, 5399), 53);
				chestIds.put(new Point(3283, 5399), 54);
				chestIds.put(new Point(3285, 5399), 55);
				chestIds.put(new Point(3277, 5400), 56);
				chestIds.put(new Point(3284, 5400), 57);
				chestIds.put(new Point(3288, 5400), 58);
				chestIds.put(new Point(3281, 5401), 59);
				chestIds.put(new Point(3286, 5401), 60);
				chestIds.put(new Point(3279, 5402), 61);
				chestIds.put(new Point(3285, 5402), 62);
				chestIds.put(new Point(3280, 5403), 63);
				chestIds.put(new Point(3283, 5403), 64);
				break;
			case RIGHT_TURN:
				chestIds.put(new Point(3338, 5405), 1);
				chestIds.put(new Point(3334, 5405), 2);
				chestIds.put(new Point(3342, 5404), 3);
				chestIds.put(new Point(3340, 5404), 4);
				chestIds.put(new Point(3345, 5403), 5);
				chestIds.put(new Point(3334, 5403), 6);
				chestIds.put(new Point(3330, 5403), 7);
				chestIds.put(new Point(3343, 5402), 8);
				chestIds.put(new Point(3342, 5402), 9);
				chestIds.put(new Point(3339, 5402), 10);
				chestIds.put(new Point(3338, 5402), 11);
				chestIds.put(new Point(3336, 5402), 12);
				chestIds.put(new Point(3347, 5401), 13);
				chestIds.put(new Point(3330, 5401), 14);
				chestIds.put(new Point(3345, 5400), 15);
				chestIds.put(new Point(3341, 5400), 16);
				chestIds.put(new Point(3337, 5400), 17);
				chestIds.put(new Point(3334, 5400), 18);
				chestIds.put(new Point(3345, 5399), 19);
				chestIds.put(new Point(3343, 5399), 20);
				chestIds.put(new Point(3340, 5399), 21);
				chestIds.put(new Point(3335, 5399), 22);
				chestIds.put(new Point(3331, 5399), 23);
				chestIds.put(new Point(3338, 5398), 24);
				chestIds.put(new Point(3337, 5398), 25);
				chestIds.put(new Point(3345, 5397), 26);
				chestIds.put(new Point(3341, 5397), 27);
				chestIds.put(new Point(3334, 5397), 28);
				chestIds.put(new Point(3331, 5397), 29);
				chestIds.put(new Point(3346, 5396), 30);
				chestIds.put(new Point(3343, 5396), 31);
				chestIds.put(new Point(3339, 5396), 32);
				chestIds.put(new Point(3335, 5396), 33);
				chestIds.put(new Point(3333, 5396), 34);
				chestIds.put(new Point(3340, 5395), 35);
				chestIds.put(new Point(3337, 5395), 36);
				chestIds.put(new Point(3334, 5395), 37);
				chestIds.put(new Point(3345, 5394), 38);
				chestIds.put(new Point(3342, 5394), 39);
				chestIds.put(new Point(3332, 5394), 40);
				chestIds.put(new Point(3343, 5393), 41);
				chestIds.put(new Point(3341, 5393), 42);
				chestIds.put(new Point(3338, 5393), 43);
				chestIds.put(new Point(3335, 5393), 44);
				chestIds.put(new Point(3334, 5393), 45);
				chestIds.put(new Point(3346, 5392), 46);
				chestIds.put(new Point(3342, 5392), 47);
				chestIds.put(new Point(3332, 5392), 48);
				chestIds.put(new Point(3350, 5391), 49);
				chestIds.put(new Point(3346, 5391), 50);
				chestIds.put(new Point(3340, 5391), 51);
				chestIds.put(new Point(3339, 5391), 52);
				chestIds.put(new Point(3336, 5391), 53);
				chestIds.put(new Point(3333, 5391), 54);
				chestIds.put(new Point(3349, 5390), 55);
				chestIds.put(new Point(3343, 5390), 56);
				chestIds.put(new Point(3337, 5390), 57);
				chestIds.put(new Point(3335, 5390), 58);
				chestIds.put(new Point(3344, 5389), 59);
				chestIds.put(new Point(3340, 5389), 60);
				chestIds.put(new Point(3336, 5389), 61);
				chestIds.put(new Point(3333, 5389), 62);
				chestIds.put(new Point(3346, 5388), 63);
				chestIds.put(new Point(3340, 5387), 64);
				chestIds.put(new Point(3337, 5386), 65);
				chestIds.put(new Point(3333, 5386), 66);
				chestIds.put(new Point(3338, 5385), 67);
				chestIds.put(new Point(3336, 5385), 68);
				chestIds.put(new Point(3337, 5384), 69);
				chestIds.put(new Point(3340, 5382), 70);
				chestIds.put(new Point(3334, 5383), 71);
				chestIds.put(new Point(3340, 5379), 72);
				chestIds.put(new Point(3338, 5380), 73);
				chestIds.put(new Point(3336, 5381), 74);
				break;
			case STRAIGHT:
				chestIds.put(new Point(3308, 5378), 1);
				chestIds.put(new Point(3305, 5379), 2);
				chestIds.put(new Point(3307, 5379), 3);
				chestIds.put(new Point(3304, 5381), 4);
				chestIds.put(new Point(3310, 5381), 5);
				chestIds.put(new Point(3302, 5382), 6);
				chestIds.put(new Point(3307, 5382), 7);
				chestIds.put(new Point(3312, 5382), 8);
				chestIds.put(new Point(3317, 5382), 9);
				chestIds.put(new Point(3319, 5382), 10);
				chestIds.put(new Point(3304, 5383), 11);
				chestIds.put(new Point(3305, 5383), 12);
				chestIds.put(new Point(3307, 5383), 13);
				chestIds.put(new Point(3310, 5383), 14);
				chestIds.put(new Point(3315, 5383), 15);
				chestIds.put(new Point(3320, 5383), 16);
				chestIds.put(new Point(3300, 5384), 17);
				chestIds.put(new Point(3309, 5384), 18);
				chestIds.put(new Point(3311, 5384), 19);
				chestIds.put(new Point(3313, 5384), 20);
				chestIds.put(new Point(3317, 5384), 21);
				chestIds.put(new Point(3318, 5384), 22);
				chestIds.put(new Point(3302, 5385), 23);
				chestIds.put(new Point(3306, 5385), 24);
				chestIds.put(new Point(3310, 5385), 25);
				chestIds.put(new Point(3313, 5385), 26);
				chestIds.put(new Point(3320, 5385), 27);
				chestIds.put(new Point(3302, 5386), 28);
				chestIds.put(new Point(3305, 5386), 29);
				chestIds.put(new Point(3316, 5386), 30);
				chestIds.put(new Point(3321, 5386), 31);
				chestIds.put(new Point(3300, 5387), 32);
				chestIds.put(new Point(3308, 5387), 33);
				chestIds.put(new Point(3314, 5387), 34);
				chestIds.put(new Point(3317, 5387), 35);
				chestIds.put(new Point(3301, 5388), 36);
				chestIds.put(new Point(3306, 5388), 37);
				chestIds.put(new Point(3312, 5388), 38);
				chestIds.put(new Point(3322, 5388), 39);
				chestIds.put(new Point(3309, 5389), 40);
				chestIds.put(new Point(3311, 5389), 41);
				chestIds.put(new Point(3313, 5389), 42);
				chestIds.put(new Point(3316, 5389), 43);
				chestIds.put(new Point(3320, 5389), 44);
				chestIds.put(new Point(3300, 5390), 45);
				chestIds.put(new Point(3303, 5390), 46);
				chestIds.put(new Point(3304, 5390), 47);
				chestIds.put(new Point(3312, 5390), 48);
				chestIds.put(new Point(3320, 5390), 49);
				chestIds.put(new Point(3307, 5391), 50);
				chestIds.put(new Point(3310, 5391), 51);
				chestIds.put(new Point(3317, 5391), 52);
				chestIds.put(new Point(3318, 5391), 53);
				chestIds.put(new Point(3323, 5391), 54);
				chestIds.put(new Point(3301, 5392), 55);
				chestIds.put(new Point(3303, 5392), 56);
				chestIds.put(new Point(3309, 5392), 57);
				chestIds.put(new Point(3314, 5392), 58);
				chestIds.put(new Point(3322, 5392), 59);
				chestIds.put(new Point(3305, 5393), 60);
				chestIds.put(new Point(3307, 5393), 61);
				chestIds.put(new Point(3316, 5393), 62);
				chestIds.put(new Point(3309, 5394), 63);
				chestIds.put(new Point(3312, 5394), 64);
				chestIds.put(new Point(3322, 5394), 65);
				chestIds.put(new Point(3310, 5379), 66);
				break;
		}
	}

	public void indentifyChest(ThievingChest chest)
	{
		int id = chestIds.get(chest.getInstancePoint());
		chest.setChestId(id);
	}

	private final Map<Point, Integer> chestIds;
}
