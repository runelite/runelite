/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.zulrah.patterns;

import net.runelite.api.Prayer;
import net.runelite.client.plugins.zulrah.phase.StandLocation;
import net.runelite.client.plugins.zulrah.phase.ZulrahLocation;
import net.runelite.client.plugins.zulrah.phase.ZulrahType;

public class ZulrahPatternC extends ZulrahPattern
{
	public ZulrahPatternC()
	{
		add(ZulrahLocation.NORTH, ZulrahType.RANGE, StandLocation.TOP_EAST, null);
		add(ZulrahLocation.EAST, ZulrahType.RANGE, StandLocation.TOP_EAST, Prayer.PROTECT_FROM_MISSILES);
		add(ZulrahLocation.NORTH, ZulrahType.MELEE, StandLocation.TOP_WEST, null);
		add(ZulrahLocation.WEST, ZulrahType.MAGIC, StandLocation.WEST, Prayer.PROTECT_FROM_MAGIC);
		add(ZulrahLocation.SOUTH, ZulrahType.RANGE, StandLocation.SOUTH_EAST, Prayer.PROTECT_FROM_MISSILES);
		add(ZulrahLocation.EAST, ZulrahType.MAGIC, StandLocation.PILLAR_EAST_OUTSIDE, Prayer.PROTECT_FROM_MAGIC);
		add(ZulrahLocation.NORTH, ZulrahType.RANGE, StandLocation.PILLAR_WEST_OUTSIDE, null);
		add(ZulrahLocation.WEST, ZulrahType.RANGE, StandLocation.PILLAR_WEST_OUTSIDE, Prayer.PROTECT_FROM_MISSILES);
		add(ZulrahLocation.NORTH, ZulrahType.MAGIC, StandLocation.TOP_EAST, Prayer.PROTECT_FROM_MAGIC);
		addJad(ZulrahLocation.EAST, ZulrahType.MAGIC, StandLocation.TOP_EAST, Prayer.PROTECT_FROM_MAGIC);
		add(ZulrahLocation.NORTH, ZulrahType.MAGIC, StandLocation.TOP_EAST, null);
	}

	@Override
	public String toString()
	{
		return "Pattern C";
	}
}