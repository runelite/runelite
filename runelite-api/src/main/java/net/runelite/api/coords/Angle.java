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

import lombok.Value;
import static net.runelite.api.coords.Direction.EAST;
import static net.runelite.api.coords.Direction.NORTH;
import static net.runelite.api.coords.Direction.SOUTH;
import static net.runelite.api.coords.Direction.WEST;

@Value
public class Angle
{
	/**
	 * angle, 0-2047.
	 * 0 is south, west is 512, south is 1024, east is 1536s
	 */
	private final int angle;

	/**
	 * Get the nearest N/S/E/W direction for this angle
	 * @return
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
