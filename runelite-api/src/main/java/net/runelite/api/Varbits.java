/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

public enum Varbits
{
	/**
	 * Runecraft pouches
	 */
	POUCH_SMALL(603, 486, 0, 2),
	POUCH_MEDIUM(604, 486, 3, 8),
	POUCH_LARGE(605, 486, 9, 17),
	POUCH_GIANT(606, 486, 18, 29),

	/**
	 * Runepouch
	 */
	RUNE_POUCH_RUNE1(29, 1139, 0, 5),
	RUNE_POUCH_RUNE2(1622, 1139, 6, 11),
	RUNE_POUCH_RUNE3(1623, 1139, 12, 17),
	RUNE_POUCH_AMOUNT1(1624, 1139, 18, 31),
	RUNE_POUCH_AMOUNT2(1625, 1140, 0, 13),
	RUNE_POUCH_AMOUNT3(1626, 1140, 14, 27),

	/**
	 * Prayers
	 */
	PRAYER_THICK_SKIN(4104, 83, 0, 0),

	/**
	 * Special Attack
	 */
	SPECIAL_ATTACK_PERCENT(300, 31, 0),
	SPECIAL_ATTACK_ENABLED(301, 0, 0),

	/**
	 * Poison
	 * Venom - 1,000,000 (6dmg/hit) - 1,000,008 (20 dmg/hit)
	 */
	POISON(102, 0, 5),
	VENOM(102, 6, 9),

	/**
	 * Options
	 */
	SIDE_PANELS(4607, 1055, 8, 8);

	/**
	 * varbit id
	 */
	private final int id;

	/**
	 * index into settings
	 */
	private final int index;
	private final int leastSignificantBit;
	private final int mostSignificantBit;

	private Varbits(int index, int leastSignificantBit, int mostSignificantBit)
	{
		this(-1, index, leastSignificantBit, mostSignificantBit);
	}

	private Varbits(int id, int index, int leastSignificantBit, int mostSignificantBit)
	{
		this.id = id;
		this.index = index;
		this.leastSignificantBit = leastSignificantBit;
		this.mostSignificantBit = mostSignificantBit;
	}

	public int getId()
	{
		return id;
	}

	public int getIndex()
	{
		return index;
	}

	public int getLeastSignificantBit()
	{
		return leastSignificantBit;
	}

	public int getMostSignificantBit()
	{
		return mostSignificantBit;
	}

	/**
	 * Get the value of this varbit from the given int
	 *
	 * @param value
	 * @return
	 */
	public int get(int value)
	{
		int mask = getMax() - 1;

		return (value >> leastSignificantBit) & mask;
	}

	/**
	 * Set the value of this varbit to a given int
	 *
	 * @param varbit The int to set the value on
	 * @param value The value to set
	 * @return
	 */
	public int set(int varbit, int value)
	{
		int mask = getMax() - 1;

		value &= mask; // Ensure new value is in range

		mask <<= leastSignificantBit; // Align mask to the correct place

		varbit &= ~mask; // And off existing value

		value <<= leastSignificantBit; // Align new value
		varbit |= value;
		return varbit;
	}

	/**
	 * Get the maximum possible value for this varbit
	 *
	 * @return
	 */
	public int getMax()
	{
		return 1 << getNumberOfBits();
	}

	/**
	 * Get the number of bits of storage in this varbit
	 *
	 * @return
	 */
	public int getNumberOfBits()
	{
		// leastSignificantBit and mostSignificantBit are inclusive
		return (mostSignificantBit - leastSignificantBit) + 1;
	}
}
