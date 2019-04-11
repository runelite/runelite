/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.cluescrolls.clues.hotcold;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.ASGARNIA;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.DESERT;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.FELDIP_HILLS;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.FREMENNIK_PROVINCE;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.KANDARIN;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.KARAMJA;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.MISTHALIN;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.MORYTANIA;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.WESTERN_PROVINCE;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.WILDERNESS;
import static net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdArea.ZEAH;

@AllArgsConstructor
@Getter
public enum HotColdLocationBeginner
{
	DRAYNOR_WHEAT_FIELD(new WorldPoint(3125,3280,0), ASGARNIA, "Inside Draynor village wheat field"),
	ICE_MOUNTAIN(new WorldPoint(3005,3473,0), ASGARNIA, "On Ice Mountain, west of Edgeville"),
	LUMBRIDGE_NORTH_COW_FIELD(new WorldPoint(3177,3339,0), ASGARNIA, "Cow field north of Lumbridge, along the River Lum"),
	DRAYNOR_MANOR(new WorldPoint(3093,3377,0), ASGARNIA, "North western corner, outside of Draynor Manor"),
	AL_KHARID_MINE(new WorldPoint(3329,3313,0), ASGARNIA, "Northeast of the mine Al Kharid mine");

	private final WorldPoint worldPoint;
	private final HotColdArea hotColdArea;
	private final String area;

	public Rectangle2D getRect()
	{
		return new Rectangle(worldPoint.getX() - 4, worldPoint.getY() - 4, 9, 9);
	}
}
