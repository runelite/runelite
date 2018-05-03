/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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


package net.runelite.client.plugins.chompyhunting;

import lombok.Getter;
import net.runelite.api.ItemID;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

enum Bellows
{
	BELLOWS0(ItemID.OGRE_BELLOWS, 0, Color.RED),
	BELLOWS1(ItemID.OGRE_BELLOWS_1, 1, Color.ORANGE),
	BELLOWS2(ItemID.OGRE_BELLOWS_2, 2, Color.YELLOW),
	BELLOWS3(ItemID.OGRE_BELLOWS_3, 3, Color.GREEN);


	@Getter
	private final int id;
	@Getter
	private final int charges;
	@Getter
	private final Color color;

	private static final Map<Integer, Bellows> bellows = new HashMap<>();

	static
	{
		for (Bellows bellow : values())
		{
			bellows.put(bellow.getId(), bellow);
		}
	}

	Bellows(int id, int charges, Color color)
	{
		this.id = id;
		this.charges = charges;
		this.color = color;
	}

	public static Bellows getBellow(int itemId)
	{
		return bellows.get(itemId);
	}
}
