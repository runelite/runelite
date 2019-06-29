/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.api.coords;

import static net.runelite.api.coords.Direction.EAST;
import static net.runelite.api.coords.Direction.NORTH;
import static net.runelite.api.coords.Direction.SOUTH;
import static net.runelite.api.coords.Direction.WEST;
import lombok.Value;

/**
 * Represents an in-game orientation that uses fixed point arithmetic.
 * <p>
 * Angles are represented as an int value ranging from 0-2047, where the
 * following is true:
 * <ul>
 *     <li>0 is true South</li>
 *     <li>512 is true West</li>
 *     <li>1024 is true North</li>
 *     <li>1536 is true East</li>
 * </ul>
 */
@Value
public class Angle
{
	/**
	 * The raw angle value.
	 */
	private final int angle;

	/**
	 * Converts the angle value to the nearest cardinal direction.
	 * <p>
	 * Each cardinal direction contains 512 angles, ranging between
	 * -256 and +256 of it's true value. Negative values and values
	 * above 2047 are wrapped accordingly.
	 *
	 * @return Nearest cardinal direction to the angle
	 */
	public Direction getNearestDirection()
	{
		int round = angle >>> 9;
		int up = angle & 256;
		if (up != 0)
		{
			// round up
			++round;
		}
		switch (round & 3)
		{
			case 0:
				return SOUTH;
			case 1:
				return WEST;
			case 2:
				return NORTH;
			case 3:
				return EAST;
			default:
				throw new IllegalStateException();
		}
	}
}
