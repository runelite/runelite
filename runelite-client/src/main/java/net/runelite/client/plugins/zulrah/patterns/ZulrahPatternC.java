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
import net.runelite.client.plugins.zulrah.ZulrahInstance;
import net.runelite.client.plugins.zulrah.ZulrahType;

public class ZulrahPatternC extends ZulrahPattern
{

	public ZulrahPatternC(Client client)
	{
		this.client = client;
		pattern = new ZulrahInstance[10];

		pattern[0] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahType.RANGE, false, ZulrahInstance.STAND_LOCATION.TOP_EAST);
		pattern[1] = new ZulrahInstance(ZulrahInstance.LOCATION.EAST, ZulrahType.RANGE, false, ZulrahInstance.STAND_LOCATION.TOP_EAST);
		pattern[2] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahType.MELEE, false, ZulrahInstance.STAND_LOCATION.TOP_WEST);
		pattern[3] = new ZulrahInstance(ZulrahInstance.LOCATION.WEST, ZulrahType.MAGIC, false, ZulrahInstance.STAND_LOCATION.TOP_WEST);
		pattern[4] = new ZulrahInstance(ZulrahInstance.LOCATION.SOUTH, ZulrahType.RANGE, false, ZulrahInstance.STAND_LOCATION.EAST);
		pattern[5] = new ZulrahInstance(ZulrahInstance.LOCATION.EAST, ZulrahType.MAGIC, false, ZulrahInstance.STAND_LOCATION.PILLAR_EAST_OUTSIDE);
		pattern[6] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahType.RANGE, false, ZulrahInstance.STAND_LOCATION.WEST);
		pattern[7] = new ZulrahInstance(ZulrahInstance.LOCATION.WEST, ZulrahType.RANGE, false, ZulrahInstance.STAND_LOCATION.PILLAR_WEST_OUTSIDE);
		pattern[8] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahType.MAGIC, false, ZulrahInstance.STAND_LOCATION.PILLAR_EAST_OUTSIDE);
		pattern[9] = new ZulrahInstance(ZulrahInstance.LOCATION.EAST, ZulrahType.MAGIC, true, ZulrahInstance.STAND_LOCATION.PILLAR_EAST_OUTSIDE);
	}

	@Override
	public void render(Graphics2D graphics, net.runelite.api.Point startTile, int index)
	{
		super.render(graphics, startTile, index);
		graphics.drawString("Pattern C", 200, 200);
	}

	@Override
	public boolean canReset(int index)
	{
		return index >= 7;
	}
}
