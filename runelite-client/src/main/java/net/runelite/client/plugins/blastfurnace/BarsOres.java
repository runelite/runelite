/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.blastfurnace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;

@AllArgsConstructor
@Getter
enum BarsOres
{
	COPPER_ORE(VarbitID.BLAST_FURNACE_COPPER_ORE, ItemID.COPPER_ORE),
	TIN_ORE(VarbitID.BLAST_FURNACE_TIN_ORE, ItemID.TIN_ORE),
	IRON_ORE(VarbitID.BLAST_FURNACE_IRON_ORE, ItemID.IRON_ORE),
	COAL(VarbitID.BLAST_FURNACE_COAL, ItemID.COAL),
	MITHRIL_ORE(VarbitID.BLAST_FURNACE_MITHRIL_ORE, ItemID.MITHRIL_ORE),
	ADAMANTITE_ORE(VarbitID.BLAST_FURNACE_ADAMANTITE_ORE, ItemID.ADAMANTITE_ORE),
	RUNITE_ORE(VarbitID.BLAST_FURNACE_RUNITE_ORE, ItemID.RUNITE_ORE),
	SILVER_ORE(VarbitID.BLAST_FURNACE_SILVER_ORE, ItemID.SILVER_ORE),
	GOLD_ORE(VarbitID.BLAST_FURNACE_GOLD_ORE, ItemID.GOLD_ORE),
	BRONZE_BAR(VarbitID.BLAST_FURNACE_BRONZE_BARS, ItemID.BRONZE_BAR),
	IRON_BAR(VarbitID.BLAST_FURNACE_IRON_BARS, ItemID.IRON_BAR),
	STEEL_BAR(VarbitID.BLAST_FURNACE_STEEL_BARS, ItemID.STEEL_BAR),
	MITHRIL_BAR(VarbitID.BLAST_FURNACE_MITHRIL_BARS, ItemID.MITHRIL_BAR),
	ADAMANTITE_BAR(VarbitID.BLAST_FURNACE_ADAMANTITE_BARS, ItemID.ADAMANTITE_BAR),
	RUNITE_BAR(VarbitID.BLAST_FURNACE_RUNITE_BARS, ItemID.RUNITE_BAR),
	SILVER_BAR(VarbitID.BLAST_FURNACE_SILVER_BARS, ItemID.SILVER_BAR),
	GOLD_BAR(VarbitID.BLAST_FURNACE_GOLD_BARS, ItemID.GOLD_BAR);

	@Getter(onMethod_ = {@Varbit})
	private final int varbit;
	private final int itemID;
}
