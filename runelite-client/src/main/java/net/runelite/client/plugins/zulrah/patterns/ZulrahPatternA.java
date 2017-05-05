package net.runelite.client.plugins.zulrah.patterns;/*
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

import net.runelite.api.*;
import net.runelite.client.plugins.zulrah.ZulrahInstance;

import java.awt.*;

public class ZulrahPatternA extends ZulrahPattern {

    public ZulrahPatternA(Client client) {
        this.client = client;
        pattern = new ZulrahInstance[11];

        pattern[0] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahInstance.TYPE.RANGE, false, ZulrahInstance.STAND_LOCATION.TOP_EAST);
		pattern[1] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahInstance.TYPE.MELEE, false, ZulrahInstance.STAND_LOCATION.TOP_EAST);
		pattern[2] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahInstance.TYPE.MAGIC, false, ZulrahInstance.STAND_LOCATION.TOP_EAST);
		pattern[3] = new ZulrahInstance(ZulrahInstance.LOCATION.SOUTH, ZulrahInstance.TYPE.RANGE, false, ZulrahInstance.STAND_LOCATION.WEST);
		pattern[4] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahInstance.TYPE.MELEE, false, ZulrahInstance.STAND_LOCATION.PILLAR_WEST_OUTSIDE);
		pattern[5] = new ZulrahInstance(ZulrahInstance.LOCATION.WEST, ZulrahInstance.TYPE.MAGIC, false, ZulrahInstance.STAND_LOCATION.WEST);
		pattern[6] = new ZulrahInstance(ZulrahInstance.LOCATION.SOUTH, ZulrahInstance.TYPE.RANGE, false, ZulrahInstance.STAND_LOCATION.EAST);
		pattern[7] = new ZulrahInstance(ZulrahInstance.LOCATION.SOUTH, ZulrahInstance.TYPE.MAGIC, false, ZulrahInstance.STAND_LOCATION.EAST);
		pattern[8] = new ZulrahInstance(ZulrahInstance.LOCATION.WEST, ZulrahInstance.TYPE.RANGE, true, ZulrahInstance.STAND_LOCATION.TOP_WEST);
		pattern[9] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahInstance.TYPE.MELEE, false, ZulrahInstance.STAND_LOCATION.TOP_WEST);
        pattern[10] = new ZulrahInstance(ZulrahInstance.LOCATION.NORTH, ZulrahInstance.TYPE.RANGE, false, ZulrahInstance.STAND_LOCATION.TOP_WEST);
    }

    @Override
    public boolean canReset(int index) {
        return index >= 10;
    }

    @Override
    public void render(Graphics2D graphics, net.runelite.api.Point startTile, int index) {
        super.render(graphics, startTile, index);
        graphics.drawString("Pattern A", 200, 200);
    }
}
