/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.jewelrycount;

import net.runelite.api.ItemID;

import java.util.HashMap;
import java.util.Map;

public enum JewelryCharges
{
	GLORY1(JewelryType.GLORY, ItemID.AMULET_OF_GLORY1, 1),
	GLORY2(JewelryType.GLORY, ItemID.AMULET_OF_GLORY2, 2),
	GLORY3(JewelryType.GLORY, ItemID.AMULET_OF_GLORY3, 3),
	GLORY4(JewelryType.GLORY, ItemID.AMULET_OF_GLORY4, 4),
	GLORY5(JewelryType.GLORY, ItemID.AMULET_OF_GLORY5, 5),
	GLORY6(JewelryType.GLORY, ItemID.AMULET_OF_GLORY6, 6),
	GLORYT1(JewelryType.GLORY, ItemID.AMULET_OF_GLORY_T1, 1),
	GLORYT2(JewelryType.GLORY, ItemID.AMULET_OF_GLORY_T2, 2),
	GLORYT3(JewelryType.GLORY, ItemID.AMULET_OF_GLORY_T3, 3),
	GLORYT4(JewelryType.GLORY, ItemID.AMULET_OF_GLORY_T4, 4),
	GLORYT5(JewelryType.GLORY, ItemID.AMULET_OF_GLORY_T5, 5),
	GLORYT6(JewelryType.GLORY, ItemID.AMULET_OF_GLORY_T6, 6),
	ROD1(JewelryType.ROD, ItemID.RING_OF_DUELING1, 1),
	ROD2(JewelryType.ROD, ItemID.RING_OF_DUELING2, 2),
	ROD3(JewelryType.ROD, ItemID.RING_OF_DUELING3, 3),
	ROD4(JewelryType.ROD, ItemID.RING_OF_DUELING4, 4),
	ROD5(JewelryType.ROD, ItemID.RING_OF_DUELING5, 5),
	ROD6(JewelryType.ROD, ItemID.RING_OF_DUELING6, 6),
	ROD7(JewelryType.ROD, ItemID.RING_OF_DUELING7, 7),
	ROD8(JewelryType.ROD, ItemID.RING_OF_DUELING8, 8),
	GAMES1(JewelryType.GAMES, ItemID.GAMES_NECKLACE1, 1),
	GAMES2(JewelryType.GAMES, ItemID.GAMES_NECKLACE2, 2),
	GAMES3(JewelryType.GAMES, ItemID.GAMES_NECKLACE3, 3),
	GAMES4(JewelryType.GAMES, ItemID.GAMES_NECKLACE4, 4),
	GAMES5(JewelryType.GAMES, ItemID.GAMES_NECKLACE5, 5),
	GAMES6(JewelryType.GAMES, ItemID.GAMES_NECKLACE6, 6),
	GAMES7(JewelryType.GAMES, ItemID.GAMES_NECKLACE7, 7),
	GAMES8(JewelryType.GAMES, ItemID.GAMES_NECKLACE8, 8),
	ROW1(JewelryType.ROW, ItemID.RING_OF_WEALTH_1, 1),
	ROW2(JewelryType.ROW, ItemID.RING_OF_WEALTH_2, 2),
	ROW3(JewelryType.ROW, ItemID.RING_OF_WEALTH_3, 3),
	ROW4(JewelryType.ROW, ItemID.RING_OF_WEALTH_4, 4),
	ROW5(JewelryType.ROW, ItemID.RING_OF_WEALTH_5, 5),
	ROS1(JewelryType.ROS, ItemID.SLAYER_RING_1, 1),
	ROS2(JewelryType.ROS, ItemID.SLAYER_RING_2, 2),
	ROS3(JewelryType.ROS, ItemID.SLAYER_RING_3, 3),
	ROS4(JewelryType.ROS, ItemID.SLAYER_RING_4, 4),
	ROS5(JewelryType.ROS, ItemID.SLAYER_RING_5, 5),
	ROS6(JewelryType.ROS, ItemID.SLAYER_RING_6, 6),
	ROS7(JewelryType.ROS, ItemID.SLAYER_RING_7, 7),
	ROS8(JewelryType.ROS, ItemID.SLAYER_RING_8, 8);

	private final JewelryType type;
	private final int id;
	private final int charges;

	private static final Map<Integer, JewelryCharges> ITEM_ID = new HashMap<>();

	static
	{
		for (JewelryCharges s : values())
		{
			ITEM_ID.put(s.getId(), s);
		}
	}

	JewelryCharges(JewelryType type, int ID, int charges)
	{
		this.type = type;
		this.id = ID;
		this.charges = charges;
	}

	public JewelryType getType()
	{
		return type;
	}

	public int getId()
	{
		return id;
	}

	public int getCharges()
	{
		return charges;
	}

	public static JewelryCharges getCharges(int id)
	{
		return ITEM_ID.get(id);
	}
}
