/*
 * Copyright (c) 2018 Abex
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
package net.runelite.api.vars;

import net.runelite.api.Client;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;

/**
 * Unlockables in the slayer interface
 */
public enum SlayerUnlock
{
	// Copied from enum 834 in the cache
	// enum 854 contains if you can disable the unlock
	GARGOYLE_SMASHER(0),
	SLUG_SALTER(1),
	REPTILE_FREEZER(2),
	SHROOM_SPRAYER(3),
	DARK_BEAST_EXTEND(4),
	SLAYER_HELMET(5),
	SLAYER_RINGS(6),
	BROADER_FLETCHING(7),
	ANKOU_EXTEND(8),
	SUQAH_EXTEND(9),
	BLACK_DRAGON_EXTEND(10),
	METAL_DRAGON_EXTEND(11),
	SPIRITUAL_MAGE_EXTEND(12),
	ABYSSAL_DEMON_EXTEND(13),
	BLACK_DEMON_EXTEND(14),
	GREATER_DEMON_EXTEND(15),
	MITHRIL_DRAGON_UNLOCK(16),
	AVIANSIES_ENABLE(17),
	TZHARR_ENABLE(18),
	BOSS_ENABLE(19),
	BLOODVELD_EXTEND(20),
	ABERRANT_SPECTRE_EXTEND(21),
	AVIANSIES_EXTEND(22),
	MITHRIL_DRAGON_EXTEND(23),
	CAVE_HORROR_EXTEND(24),
	DUST_DEVIL_EXTEND(25),
	SKELETAL_WYVERN_EXTEND(26),
	GARGOYLE_EXTEND(27),
	NECHRYAEL_EXTEND(28),
	CAVE_KRAKEN_EXTEND(29),
	LIZARDMEN_ENABLE(30),
	KBD_SLAYER_HELM(31),
	KALPHITE_QUEEN_SLAYER_HELM(32),
	ABYSSAL_DEMON_SAYER_HELM(33),
	RED_DRAGON_ENABLE(34),
	SUPERIOR_ENABLE(35, Varbits.SUPERIOR_ENABLED),
	SCABARITE_EXTEND(36),
	MITHRIL_DRAGON_NOTES(37),
	SKOTIZO_SLAYER_HELM(38),
	FOSSIL_ISLAND_WYVERN_EXTEND(39),
	ADAMANT_DRAGON_EXTEND(40),
	RUNE_DRAGON_EXTEND(41),
	VORKATH_SLAYER_HELM(42),
	FOSSIL_ISLAND_WYVERN_DISABLE(43, Varbits.FOSSIL_ISLAND_WYVERN_DISABLE),
	GROTESQUE_GUARDIAN_DOUBLE_COUNT(44);

	private Varbits toggleVarbit;

	SlayerUnlock(int index)
	{
		this(index, null);
	}

	SlayerUnlock(int index, Varbits toggleVarbit)
	{
		assert index == ordinal();
		this.toggleVarbit = toggleVarbit;
	}

	/**
	 * @return true if this unlock is bought
	 */
	public boolean isOwned(Client client)
	{
		VarPlayer varp = ordinal() > 32 ? VarPlayer.SLAYER_UNLOCK_2 : VarPlayer.SLAYER_UNLOCK_1;
		return (client.getVar(varp) & (1 << (ordinal() % 32))) != 0;
	}

	/**
	 * @return true if this unlock is bought and enabled
	 */
	public boolean isEnabled(Client client)
	{
		if (isOwned(client))
		{
			if (toggleVarbit == null)
			{
				return true;
			}
			return client.getVar(toggleVarbit) == 0;
		}
		return false;
	}
}
