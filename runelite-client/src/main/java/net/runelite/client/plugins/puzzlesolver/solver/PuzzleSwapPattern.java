/*
 * Copyright (c) 2018, Steffen Hauge <steffen.oerum.hauge@hotmail.com>
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
package net.runelite.client.plugins.puzzlesolver.solver;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PuzzleSwapPattern
{
	ROTATE_LEFT_UP(new int[]{1, -1, 0, -1, -1, -1, -1, 0}, 1, 1), //Reference point
	ROTATE_LEFT_DOWN(1, -1),
	ROTATE_RIGHT_UP(-1, 1),
	ROTATE_RIGHT_DOWN(-1, -1),
	ROTATE_UP_LEFT(new int[]{-1, 1, -1, 0, -1, -1, 0, -1}, 1 , 1), //Reference point
	ROTATE_UP_RIGHT(-1, 1),
	ROTATE_DOWN_LEFT(1, -1),
	ROTATE_DOWN_RIGHT(-1, -1),
	LAST_PIECE_ROW(new int[]{-1, -1, 0, -1, -1, 0, -1, 1}, 1, 1),
	LAST_PIECE_COLUMN(new int[]{-1, -1, -1, 0, 0, -1, 1, -1}, 1, 1),
	SHUFFLE_UP_RIGHT(new int[]{1, -1, 0, -1}, 1, 1),
	SHUFFLE_UP_LEFT(new int[]{-1, -1, 0, -1}, 1, 1),
	SHUFFLE_UP_BELOW(new int[]{-1, 1, -1, 0}, 1, 1),
	SHUFFLE_UP_ABOVE(new int[]{-1, -1, -1, 0}, 1, 1);

	/**
	 * Points used for swaps relative to locVal
	 */
	private final int[] points;
	/**
	 * Modifier for X coordinate
	 */
	private final int modX;
	/**
	 * Modifier for Y coordinate
	 */
	private final int modY;

	PuzzleSwapPattern(int modX, int modY)
	{
		this(null, modX, modY);
	}
}
