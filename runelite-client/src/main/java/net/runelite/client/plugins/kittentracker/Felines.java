/*
 * Copyright (c) 2018, Nachtmerrie <https://github.com/Nachtmerrie>
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
package net.runelite.client.plugins.kittentracker;


import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemID;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public enum Felines
{

	//white/black
	KITTEN_5591(5591, ItemID.PET_KITTEN),
	CAT_1619(1619, ItemID.PET_CAT),

	//white
	KITTEN_5592(5592, ItemID.PET_KITTEN_1556),
	CAT_1620(1620, ItemID.PET_CAT_1562),

	//brown
	KITTEN_5593(5593, ItemID.PET_KITTEN_1557),
	CAT_1621(1621, ItemID.PET_CAT_1563),

	//black
	KITTEN_5594(5594, ItemID.PET_KITTEN_1558),
	CAT_1622(1622, ItemID.PET_CAT_1564),

	//white/brown
	KITTEN_5595(5595, ItemID.PET_KITTEN_1559),
	CAT_1623(1623, ItemID.PET_CAT_1565),

	//white/blue
	KITTEN_5596(5596, ItemID.PET_KITTEN_1560),
	CAT_1624(1624, ItemID.PET_CAT_1566),

	//hell
	HELLKITTEN(5597, ItemID.HELLKITTEN),
	HELL_CAT(1625, ItemID.HELL_CAT);


	private static final Map<Integer, Felines> felines = new HashMap<>();
	private final int id;
	private final int itemSpriteId;


	static
	{
		for (Felines cat : values())
		{
			felines.put(cat.getId(), cat);
		}
	}

	private Felines(int id, int ItemSpriteId)
	{
		this.id = id;
		this.itemSpriteId = ItemSpriteId;

	}

	public int getItemSpriteId()
	{
		return itemSpriteId;
	}
	public int getId()
	{
		return id;
	}

	public static Felines find(int id)
	{
		return felines.get(id);
	}
}
