/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api;

import java.awt.Dimension;

/**
 * A utility class containing constant values.
 */
public class Constants
{
	/**
	 * The original width of the game when running in fixed mode.
	 */
	public static final int GAME_FIXED_WIDTH = 765;

	/**
	 * The original height of the game when running in fixed mode.
	 */
	public static final int GAME_FIXED_HEIGHT = 503;

	/**
	 * Dimension representation of the width and height of the game in fixed mode.
	 */
	public static final Dimension GAME_FIXED_SIZE = new Dimension(GAME_FIXED_WIDTH, GAME_FIXED_HEIGHT);

	/**
	 * The aspect ratio of the game when running in fixed mode.
	 */
	public static final double GAME_FIXED_ASPECT_RATIO = (double) GAME_FIXED_WIDTH / (double) GAME_FIXED_HEIGHT;

	/**
	 * The default camera zoom value.
	 */
	public static final int CLIENT_DEFAULT_ZOOM = 512;

	/**
	 * The width and length of a chunk (8x8 tiles).
	 */
	public static final int CHUNK_SIZE = 8;

	/**
	 * The width and length of a map region (64x64 tiles).
	 */
	public static final int REGION_SIZE = 64;

	/**
	 * The width and length of the scene (13 chunks x 8 tiles).
	 */
	public static final int SCENE_SIZE = 104;

	/**
	 * The max allowed plane by the game.
	 * <p>
	 * This value is exclusive. The plane is set by 2 bits which restricts
	 * the plane value to 0-3.
	 */
	public static final int MAX_Z = 4;

	public static final int TILE_FLAG_BRIDGE = 2;

	/**
	 * The number of milliseconds in a client tick.
	 * <p>
	 * This is the length of a single frame when the client is running at
	 * the maximum framerate of 50 fps.
	 */
	public static final int CLIENT_TICK_LENGTH = 20;

	/**
	 * The number of milliseconds in a server game tick.
	 * <p>
	 * This is the length of a single game cycle under ideal conditions.
	 * All game-play actions operate within multiples of this duration.
	 */
	public static final int GAME_TICK_LENGTH = 600;

	/**
	 * High alchemy = shop price * HIGH_ALCHEMY_MULTIPLIER
	 *
	 * @see ItemDefinition#getPrice
	 */
	public static final float HIGH_ALCHEMY_MULTIPLIER = 0.6f;

	/**
	 * Width of a standard item sprite
	 */
	public static final int ITEM_SPRITE_WIDTH = 36;

	/**
	 * Height of a standard item sprite
	 */
	public static final int ITEM_SPRITE_HEIGHT = 32;
}
