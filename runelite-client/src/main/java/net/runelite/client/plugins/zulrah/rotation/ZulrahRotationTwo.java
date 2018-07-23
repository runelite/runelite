/*
 * Copyright (c) 2018, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.zulrah.rotation;

import net.runelite.client.plugins.zulrah.phase.SafeLocation;
import net.runelite.client.plugins.zulrah.phase.ZulrahLocation;
import net.runelite.client.plugins.zulrah.phase.ZulrahType;

public class ZulrahRotationTwo extends ZulrahRotation
{
	public ZulrahRotationTwo()
	{
		add(ZulrahLocation.NORTH, ZulrahType.RANGE, SafeLocation.TOP_EAST);
		add(ZulrahLocation.NORTH, ZulrahType.MELEE, SafeLocation.TOP_EAST);
		add(ZulrahLocation.NORTH, ZulrahType.MAGIC, SafeLocation.PILLAR_WEST_OUTSIDE);
		add(ZulrahLocation.WEST, ZulrahType.RANGE, SafeLocation.PILLAR_WEST_OUTSIDE);
		add(ZulrahLocation.SOUTH, ZulrahType.MAGIC, SafeLocation.SOUTH_WEST);
		add(ZulrahLocation.NORTH, ZulrahType.MELEE, SafeLocation.PILLAR_WEST_INSIDE);
		add(ZulrahLocation.EAST, ZulrahType.RANGE, SafeLocation.SOUTH_EAST);
		add(ZulrahLocation.SOUTH, ZulrahType.MAGIC, SafeLocation.SOUTH_WEST);
		add(ZulrahLocation.WEST, ZulrahType.RANGE, true, SafeLocation.TOP_WEST);
		add(ZulrahLocation.NORTH, ZulrahType.MELEE, SafeLocation.TOP_WEST);
		add(ZulrahLocation.NORTH, ZulrahType.RANGE, SafeLocation.TOP_WEST);
	}

	@Override
	public String toString()
	{
		return "Rotation 2";
	}
}
