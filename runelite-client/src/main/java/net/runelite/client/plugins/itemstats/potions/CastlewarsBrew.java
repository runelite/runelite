/*
 * Copyright (c) 2026, Bonfire
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
package net.runelite.client.plugins.itemstats.potions;

import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;

import static net.runelite.client.plugins.itemstats.Builders.boost;
import static net.runelite.client.plugins.itemstats.Builders.perc;

import net.runelite.client.plugins.itemstats.*;

import static net.runelite.client.plugins.itemstats.stats.Stats.*;

@RequiredArgsConstructor
public class CastlewarsBrew implements Effect
{
	@Override
	public StatsChanges calculate(Client client)
	{
		// Super Restore
		final StatsChanges changes = new SuperRestore(.25, 8).calculate(client);

		// Super Restore prayer restore (not applied above for some reason?)
		final StatChange superRestorePrayer = new PrayerPotion(8, .25).effect(client);

		// Super Combat
		final StatChange superAttack = boost(ATTACK, perc(.15, 5)).effect(client);
		final StatChange superStrength = boost(STRENGTH, perc(.15, 5)).effect(client);
		final StatChange superDefence = boost(DEFENCE, perc(.15, 5)).effect(client);

		// Ranging potion
		final StatChange rangingPot = boost(RANGED, perc(.10, 4)).effect(client);

		// Stamina potion
		final StatChange staminaPot = new StaminaPotion(20).effect(client);

		// Imbued Heart
		final StatChange imbuedHeart = boost(MAGIC, perc(.10, 1)).effect(client);

		// Set the stat changes
		changes.setStatChanges(new StatChange[]{superAttack, superStrength, superDefence, rangingPot, staminaPot, imbuedHeart, superRestorePrayer});

		return changes;
	}

}
