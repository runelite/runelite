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
	/*
	 * If chatbox is transparent or not
	 */
	TRANSPARANT_CHATBOX(4608, 1055, 9, 9),
	SPLIT_CHAT(287, 0, 0),

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
	PRAYER_BURST_OF_STRENGTH(4105, 83, 1, 1),
	PRAYER_CLARITY_OF_THOUGHT(4106, 83, 2, 2),
	PRAYER_SHARP_EYE(4122, 83, 18, 18),
	PRAYER_MYSTIC_WILL(4123, 83, 19, 19),
	PRAYER_ROCK_SKIN(4107, 83, 3, 3),
	PRAYER_SUPERHUMAN_STRENGTH(4108, 83, 4, 4),
	PRAYER_IMPROVED_REFLEXES(4109, 83, 5, 5),
	PRAYER_RAPID_RESTORE(4110, 83, 6, 6),
	PRAYER_RAPID_HEAL(4111, 83, 7, 7),
	PRAYER_PROTECT_ITEM(4112, 83, 8, 8),
	PRAYER_HAWK_EYE(4124, 83, 20, 20),
	PRAYER_MYSTIC_LORE(4125, 83, 21, 21),
	PRAYER_STEEL_SKIN(4113, 83, 9, 9),
	PRAYER_ULTIMATE_STRENGTH(4114, 83, 10, 10),
	PRAYER_INCREDIBLE_REFLEXES(4115, 83, 11, 11),
	PRAYER_PROTECT_FROM_MAGIC(4116, 83, 12, 12),
	PRAYER_PROTECT_FROM_MISSILES(4117, 83, 13, 13),
	PRAYER_PROTECT_FROM_MELEE(4118, 83, 14, 14),
	PRAYER_EAGLE_EYE(4126, 83, 22, 22),
	PRAYER_MYSTIC_MIGHT(4127, 83, 23, 23),
	PRAYER_RETRIBUTION(4119, 83, 15, 15),
	PRAYER_REDEMPTION(4120, 83, 16, 16),
	PRAYER_SMITE(4121, 83, 17, 17),
	PRAYER_CHIVALRY(4128, 83, 25, 25),
	PRAYER_PIETY(4129, 83, 26, 26),
	PRAYER_PRESERVE(5466, 83, 28, 28),
	PRAYER_RIGOUR(5464, 83, 24, 24),
	PRAYER_AUGURY(5465, 83, 27, 27),

	/**
	 * Diary Entries
	 */
	DIARY_ARDOUGNE_EASY(4458, 1188, 10, 10),
	DIARY_ARDOUGNE_MEDIUM(4459, 1188, 11, 11),
	DIARY_ARDOUGNE_HARD(4460, 1188, 12, 12),
	DIARY_ARDOUGNE_ELITE(4461, 1188, 13, 13),

	DIARY_DESERT_EASY(4483, 1189, 2, 2),
	DIARY_DESERT_MEDIUM(4484, 1189, 3, 3),
	DIARY_DESERT_HARD(4485, 1189, 4, 4),
	DIARY_DESERT_ELITE(4486, 1189, 5, 5),

	DIARY_FALADOR_EASY(4462, 1188, 14, 14),
	DIARY_FALADOR_MEDIUM(4463, 1188, 15, 15),
	DIARY_FALADOR_HARD(4464, 1188, 16, 16),
	DIARY_FALADOR_ELITE(4465, 1188, 17, 17),

	DIARY_FREMENNIK_EASY(4491, 1189, 10, 10),
	DIARY_FREMENNIK_MEDIUM(4492, 1189, 11, 11),
	DIARY_FREMENNIK_HARD(4493, 1189, 12, 12),
	DIARY_FREMENNIK_ELITE(4494, 1189, 13, 13),

	DIARY_KANDARIN_EASY(4475, 1188, 26, 26),
	DIARY_KANDARIN_MEDIUM(4476, 1188, 27, 27),
	DIARY_KANDARIN_HARD(4477, 1188, 28, 28),
	DIARY_KANDARIN_ELITE(4478, 1188, 29, 29),

	DIARY_KARAMJA_EASY(3578, 1000, 30, 31),
	DIARY_KARAMJA_MEDIUM(3599, 1001, 30, 31),
	DIARY_KARAMJA_HARD(3611, 1002, 29, 30),
	DIARY_KARAMJA_ELITE(4566, 1200, 7, 7),

	DIARY_LUMBRIDGE_EASY(4495, 1189, 14, 14),
	DIARY_LUMBRIDGE_MEDIUM(4496, 1189, 15, 15),
	DIARY_LUMBRIDGE_HARD(4497, 1189, 16, 16),
	DIARY_LUMBRIDGE_ELITE(4498, 1189, 17, 17),

	DIARY_MORYTANIA_EASY(4487, 1189, 6, 6),
	DIARY_MORYTANIA_MEDIUM(4488, 1189, 7, 7),
	DIARY_MORYTANIA_HARD(4489, 1189, 8, 8),
	DIARY_MORYTANIA_ELITE(4490, 1189, 9, 9),

	DIARY_VARROCK_EASY(4479, 1188, 30, 30),
	DIARY_VARROCK_MEDIUM(4480, 1188, 31, 31),
	DIARY_VARROCK_HARD(4481, 1189, 0, 0),
	DIARY_VARROCK_ELITE(4482, 1189, 1, 1),

	DIARY_WESTERN_EASY(4471, 1188, 22, 22),
	DIARY_WESTERN_MEDIUM(4472, 1188, 23, 23),
	DIARY_WESTERN_HARD(4473, 1188, 24, 24),
	DIARY_WESTERN_ELITE(4474, 1188, 25, 25),

	DIARY_WILDERNESS_EASY(4466, 1188, 18, 18),
	DIARY_WILDERNESS_MEDIUM(4467, 1188, 19, 19),
	DIARY_WILDERNESS_HARD(4468, 1188, 20, 20),
	DIARY_WILDERNESS_ELITE(4469, 1188, 21, 21),

	/**
	 * Special Attack
	 */
	SPECIAL_ATTACK_PERCENT(300, 0, 16),
	SPECIAL_ATTACK_ENABLED(301, 0, 0),

	/**
	 * Poison
	 * Venom - 1,000,000 (6dmg/hit) - 1,000,008 (20 dmg/hit)
	 */
	POISON(102, 0, 5),
	VENOM(102, 6, 9),

	/**
	 * Attack Style
	 */
	ATTACK_STYLE(43, 0, 7),

	/**
	 * Equipped weapon type
	 */
	EQUIPPED_WEAPON_TYPE(357, 843, 0, 5),

	/**
	 * Defensive casting mode
	 */
	DEFENSIVE_CASTING_MODE(2668, 439, 8, 8),

	/**
	 * Options
	 */
	SIDE_PANELS(4607, 1055, 8, 8),

	/**
	 * Barbarian Assault
	 */
	IN_GAME_BA(3923, 638, 12, 12),

	/**
	 * Motherlode mine sack
	 */
	SACK_NUMBER(5558, 375, 8, 15),

	/**
	 * Experience drop color
	 */
	EXPERIENCE_DROP_COLOR(4695, 1227, 6, 8),

	/**
	 * Raids
	 */
	IN_RAID(5432, 1431, 31, 31);

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
		if (mostSignificantBit < leastSignificantBit)
		{
			throw new IllegalStateException("MSB < LSB");
		}

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
