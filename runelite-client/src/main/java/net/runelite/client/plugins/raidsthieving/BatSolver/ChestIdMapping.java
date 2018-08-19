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

import lombok.Getter;

public class ChestIdMapping
{
	// A ChestIdMapping maps the distance of an id'd chest to the storage chest, the point of origin.
	// To see the defined chest ids, please go to https://dikkenoob.github.io/
	public static final ChestIdMapping[] CHEST_ID_MAPPINGS = {
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -9, -9, 1),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -8, -11, 2),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -7, -5, 3),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -6, -13, 4),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -6, -7, 5),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -5, -10, 6),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -4, -9, 7),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -4, -12, 8),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -4, -14, 9),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -3, -3, 10),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -3, -6, 11),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -2, -11, 12),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -2, -16, 13),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -1, -1, 14),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -1, -13, 15),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, -1, -14, 16),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 0, -7, 17),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 0, -17, 18),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 1, -6, 19),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 1, -11, 20),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 1, -15, 21),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 2, -9, 22),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 2, -11, 23),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 2, -14, 24),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 2, -16, 25),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 3, -8, 26),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 3, -15, 27),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 3, -18, 28),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 4, -5, 29),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 5, -2, 30),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 5, -5, 31),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 5, -10, 32),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 5, -11, 33),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 5, -17, 34),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 6, -1, 35),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 6, -3, 36),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 6, -14, 37),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 7, -2, 38),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 7, -7, 39),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 7, -11, 40),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 7, -13, 41),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 7, -15, 42),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 8, 0, 43),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 8, -9, 44),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 8, -11, 45),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 8, -14, 46),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 9, 2, 47),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 9, -6, 48),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 10, -3, 49),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 10, -7, 50),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 10, -10, 51),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 11, -2, 52),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 11, -4, 53),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 11, -9, 54),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 11, -11, 55),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 12, -3, 56),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 12, -10, 57),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 12, -14, 58),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 13, -7, 59),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 13, -12, 60),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 14, -5, 61),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 14, -11, 62),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 15, -6, 63),
		new ChestIdMapping(ThievingRoomType.LEFT_TURN, 15, -9, 64),

		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -5, -10, 1),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -5, -14, 2),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -4, -6, 3),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -4, -8, 4),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -3, -3, 5),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -3, -14, 6),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -3, -18, 7),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -2, -5, 8),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -2, -6, 9),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -2, -9, 10),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -2, -10, 11),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -2, -12, 12),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -1, -1, 13),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, -1, -18, 14),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 0, -3, 15),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 0, -7, 16),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 0, -11, 17),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 0, -14, 18),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 1, -3, 19),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 1, -5, 20),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 1, -8, 21),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 1, -13, 22),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 1, -17, 23),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 2, -10, 24),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 2, -11, 25),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 3, -3, 26),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 3, -7, 27),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 3, -14, 28),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 3, -17, 29),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 4, -2, 30),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 4, -5, 31),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 4, -9, 32),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 4, -13, 33),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 4, -15, 34),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 5, -8, 35),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 5, -11, 36),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 5, -14, 37),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 6, -3, 38),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 6, -6, 39),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 6, -16, 40),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 7, -5, 41),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 7, -7, 42),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 7, -10, 43),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 7, -13, 44),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 7, -14, 45),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 8, -2, 46),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 8, -6, 47),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 8, -16, 48),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 9, 2, 49),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 9, -2, 50),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 9, -8, 51),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 9, -9, 52),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 9, -12, 53),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 9, -15, 54),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 10, 1, 55),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 10, -5, 56),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 10, -11, 57),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 10, -13, 58),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 11, -4, 59),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 11, -8, 60),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 11, -12, 61),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 11, -15, 62),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 12, -2, 63),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 13, -8, 64),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 14, -11, 65),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 14, -15, 66),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 15, -10, 67),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 15, -12, 68),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 16, -11, 69),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 18, -8, 70),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 17, -14, 71),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 21, -8, 72),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 20, -10, 73),
		new ChestIdMapping(ThievingRoomType.RIGHT_TURN, 19, -12, 74),

		new ChestIdMapping(ThievingRoomType.STRAIGHT, -8, -17, 1),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -11, -16, 2),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -9, -16, 3),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -12, -14, 4),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -6, -14, 5),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -14, -13, 6),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -9, -13, 7),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -4, -13, 8),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 1, -13, 9),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 3, -13, 10),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -12, -12, 11),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -11, -12, 12),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -9, -12, 13),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -6, -12, 14),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -1, -12, 15),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 4, -12, 16),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -16, -11, 17),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -7, -11, 18),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -5, -11, 19),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -3, -11, 20),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 1, -11, 21),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 2, -11, 22),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -14, -10, 23),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -10, -10, 24),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -6, -10, 25),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -3, -10, 26),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 4, -10, 27),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -14, -9, 28),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -11, -9, 29),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 0, -9, 30),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 5, -9, 31),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -16, -8, 32),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -8, -8, 33),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -2, -8, 34),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 1, -8, 35),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -15, -7, 36),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -10, -7, 37),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -4, -7, 38),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 6, -7, 39),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -7, -6, 40),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -5, -6, 41),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -3, -6, 42),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 0, -6, 43),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 4, -6, 44),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -16, -5, 45),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -13, -5, 46),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -12, -5, 47),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -4, -5, 48),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 4, -5, 49),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -9, -4, 50),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -6, -4, 51),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 1, -4, 52),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 2, -4, 53),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 7, -4, 54),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -15, -3, 55),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -13, -3, 56),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -7, -3, 57),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -2, -3, 58),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 6, -3, 59),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -11, -2, 60),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -9, -2, 61),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -7, -1, 62),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -4, -1, 63),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 0, -2, 64),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, 6, -1, 65),
		new ChestIdMapping(ThievingRoomType.STRAIGHT, -6, -16, 66)
	};

	private ChestIdMapping(ThievingRoomType roomType, int dx, int dy, int id)
	{
		this.dx = dx;
		this.dy = dy;
		this.id = id;
		this.roomType = roomType;
	}

	@Getter
	private int dx;

	@Getter
	private int dy;

	@Getter
	private int id;

	@Getter
	private ThievingRoomType roomType;
}
