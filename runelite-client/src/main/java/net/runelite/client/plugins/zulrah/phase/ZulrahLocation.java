/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.zulrah.phase;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.coords.LocalPoint;

@Slf4j
public enum ZulrahLocation
{
	NORTH, SOUTH, EAST, WEST;

	public static ZulrahLocation valueOf(LocalPoint start, LocalPoint current)
	{
		int dx = start.getX() - current.getX();
		int dy = start.getY() - current.getY();
		if (dx == -10 * 128 && dy == 2 * 128)
		{
			return ZulrahLocation.EAST;
		}
		else if (dx == 10 * 128 && dy == 2 * 128)
		{
			return ZulrahLocation.WEST;
		}
		else if (dx == 0 && dy == 11 * 128)
		{
			return ZulrahLocation.SOUTH;
		}
		else if (dx == 0 && dy == 0)
		{
			return ZulrahLocation.NORTH;
		}
		else
		{
			log.debug("Unknown Zulrah location dx: {}, dy: {}", dx, dy);
			return null;
		}
	}
}
