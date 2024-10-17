/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.api;

/**
 * A utility class containing collision data flags for tiles.
 */
public final class CollisionDataFlag
{
	/**
	 * Directional movement blocking flags.
	 */
	public static final int BLOCK_MOVEMENT_NORTH_WEST = 0x1;
	public static final int BLOCK_MOVEMENT_NORTH = 0x2;
	public static final int BLOCK_MOVEMENT_NORTH_EAST = 0x4;
	public static final int BLOCK_MOVEMENT_EAST = 0x8;
	public static final int BLOCK_MOVEMENT_SOUTH_EAST = 0x10;
	public static final int BLOCK_MOVEMENT_SOUTH = 0x20;
	public static final int BLOCK_MOVEMENT_SOUTH_WEST = 0x40;
	public static final int BLOCK_MOVEMENT_WEST = 0x80;

	/**
	 * Movement blocking type flags.
	 */
	public static final int BLOCK_MOVEMENT_OBJECT = 0x100;
	public static final int BLOCK_MOVEMENT_FLOOR_DECORATION = 0x40000;
	public static final int BLOCK_MOVEMENT_FLOOR = 0x200000; // Eg. water
	public static final int BLOCK_MOVEMENT_FULL =
		BLOCK_MOVEMENT_OBJECT |
			BLOCK_MOVEMENT_FLOOR_DECORATION |
			BLOCK_MOVEMENT_FLOOR;

	/**
	 * Directional line of sight blocking flags.
	 */
	public static final int BLOCK_LINE_OF_SIGHT_NORTH = BLOCK_MOVEMENT_NORTH << 9; // 0x400
	public static final int BLOCK_LINE_OF_SIGHT_EAST = BLOCK_MOVEMENT_EAST << 9; // 0x1000
	public static final int BLOCK_LINE_OF_SIGHT_SOUTH = BLOCK_MOVEMENT_SOUTH << 9; // 0x4000
	public static final int BLOCK_LINE_OF_SIGHT_WEST = BLOCK_MOVEMENT_WEST << 9; // 0x10000
	public static final int BLOCK_LINE_OF_SIGHT_FULL = 0x20000;
}