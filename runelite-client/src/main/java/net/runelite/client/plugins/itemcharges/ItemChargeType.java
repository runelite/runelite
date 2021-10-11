/*
 * Copyright (c) 2017, Mitchell <https://github.com/Mitchell-Kovacs>
 * Copyright (c) 2020, Unmoon <https://github.com/unmoon>
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
package net.runelite.client.plugins.itemcharges;

import java.util.function.Predicate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum ItemChargeType
{
	ABYSSAL_BRACELET(ItemChargeConfig::showAbyssalBraceletCharges),
	AMULET_OF_CHEMISTRY(ItemChargeConfig::showAmuletOfChemistryCharges),
	AMULET_OF_BOUNTY(ItemChargeConfig::showAmuletOfBountyCharges),
	BELLOWS(ItemChargeConfig::showBellowCharges),
	BRACELET_OF_SLAUGHTER(ItemChargeConfig::showBraceletOfSlaughterCharges),
	EXPEDITIOUS_BRACELET(ItemChargeConfig::showExpeditiousBraceletCharges),
	FUNGICIDE_SPRAY(ItemChargeConfig::showFungicideCharges),
	IMPBOX(ItemChargeConfig::showImpCharges),
	TELEPORT(ItemChargeConfig::showTeleportCharges),
	WATERCAN(ItemChargeConfig::showWateringCanCharges),
	WATERSKIN(ItemChargeConfig::showWaterskinCharges),
	DODGY_NECKLACE(ItemChargeConfig::showDodgyCount),
	BINDING_NECKLACE(ItemChargeConfig::showBindingNecklaceCharges),
	EXPLORER_RING(ItemChargeConfig::showExplorerRingCharges),
	FRUIT_BASKET(ItemChargeConfig::showBasketCharges),
	SACK(ItemChargeConfig::showSackCharges),
	RING_OF_FORGING(ItemChargeConfig::showRingOfForgingCount),
	POTION(ItemChargeConfig::showPotionDoseCount),
	GUTHIX_REST(ItemChargeConfig::showGuthixRestDoses);

	private final Predicate<ItemChargeConfig> enabled;
}
