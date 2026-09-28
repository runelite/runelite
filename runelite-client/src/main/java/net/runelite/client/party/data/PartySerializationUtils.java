/*
 * Copyright (c) 2026, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.party.data;

import java.util.BitSet;
import java.util.Collection;
import java.util.EnumSet;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;

public class PartySerializationUtils
{
	public static int[] convertItemsToIntArray(Item[] items)
	{
		int[] itemInts = new int[items.length * 2];
		for (int i = 0; i < items.length * 2; i += 2)
		{
			if (items[i / 2] == null)
			{
				itemInts[i] = -1;
				itemInts[i + 1] = 0;
				continue;
			}

			itemInts[i] = items[i / 2].getId();
			itemInts[i + 1] = items[i / 2].getQuantity();
		}

		return itemInts;
	}

	public static Item[] convertIntArrayToItemArray(int[] itemInts)
	{
		Item[] output = new Item[itemInts.length / 2];
		for (int i = 0; i < itemInts.length; i += 2)
		{
			if (itemInts[i] == -1 || itemInts[i + 1] <= 0)
			{
				output[i / 2] = null;
			}
			else
			{
				output[i / 2] = new Item(itemInts[i], itemInts[i + 1]);
			}
		}

		return output;
	}

	public static int[] convertItemContainerToIntArray(ItemContainer itemContainer)
	{
		return convertItemsToIntArray(itemContainer.getItems());
	}

	public static <E extends Enum<E>> byte[] pack(Collection<E> items)
	{
		if (items.isEmpty())
		{
			return null;
		}

		final BitSet bits = new BitSet();
		for (E e : items)
		{
			bits.set(e.ordinal());
		}

		return bits.toByteArray();
	}

	public static <E extends Enum<E>> EnumSet<E> unpack(byte[] packed, Class<E> clazz)
	{
		if (packed == null)
		{
			return null;
		}
		EnumSet<E> out = EnumSet.noneOf(clazz);

		E[] constants = clazz.getEnumConstants();
		BitSet bits = BitSet.valueOf(packed);

		for (int i = bits.nextSetBit(0); i >= 0; i = bits.nextSetBit(i + 1))
		{
			if (i >= constants.length)
			{
				break;
			}

			out.add(constants[i]);
		}

		return out;
	}
}
