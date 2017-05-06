/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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

import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.client.plugins.zulrah.StandLocation;
import net.runelite.client.plugins.zulrah.ZulrahInstance;
import net.runelite.client.plugins.zulrah.ZulrahLocation;
import net.runelite.client.plugins.zulrah.ZulrahType;

public class ZulrahPatternA extends ZulrahPattern
{
	public ZulrahPatternA(Client client)
	{
		this.client = client;
		pattern = new ZulrahInstance[11];

		pattern[0] = new ZulrahInstance(ZulrahLocation.NORTH, ZulrahType.RANGE, false, StandLocation.TOP_EAST);
		pattern[1] = new ZulrahInstance(ZulrahLocation.NORTH, ZulrahType.MELEE, false, StandLocation.TOP_EAST);
		pattern[2] = new ZulrahInstance(ZulrahLocation.NORTH, ZulrahType.MAGIC, false, StandLocation.WEST);
		pattern[3] = new ZulrahInstance(ZulrahLocation.SOUTH, ZulrahType.RANGE, false, StandLocation.PILLAR_WEST_OUTSIDE);
		pattern[4] = new ZulrahInstance(ZulrahLocation.NORTH, ZulrahType.MELEE, false, StandLocation.PILLAR_WEST_OUTSIDE);
		pattern[5] = new ZulrahInstance(ZulrahLocation.WEST, ZulrahType.MAGIC, false, StandLocation.PILLAR_WEST_OUTSIDE);
		pattern[6] = new ZulrahInstance(ZulrahLocation.SOUTH, ZulrahType.RANGE, false, StandLocation.EAST);
		pattern[7] = new ZulrahInstance(ZulrahLocation.SOUTH, ZulrahType.MAGIC, false, StandLocation.EAST);
		pattern[8] = new ZulrahInstance(ZulrahLocation.WEST, ZulrahType.RANGE, true, StandLocation.TOP_WEST);
		pattern[9] = new ZulrahInstance(ZulrahLocation.NORTH, ZulrahType.MELEE, false, StandLocation.TOP_WEST);
		pattern[10] = new ZulrahInstance(ZulrahLocation.NORTH, ZulrahType.RANGE, false, StandLocation.TOP_WEST);
	}

	@Override
	public boolean canReset(int index)
	{
		return index >= 10;
	}

	@Override
	public void render(Graphics2D graphics, net.runelite.api.Point startTile, int index)
	{
		super.render(graphics, startTile, index);
		graphics.drawString("Pattern A", 200, 200);
	}
}
