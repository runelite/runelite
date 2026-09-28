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
package net.runelite.client.party.data.prayers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.party.data.PartySerializationUtils;
import net.runelite.client.party.data.PlayerPartyData;

public class PrayerService
{
	private final Client client;

	@Getter
	private int prayerBookID = 0;

	public PrayerService(Client client)
	{
		this.client = client;
		updatePrayerBook();
	}

	public void updatePrayerBook()
	{
		this.prayerBookID = client.getVarbitValue(VarbitID.PRAYERBOOK);
	}

	public byte[][] handlePrayerCheck(PlayerPartyData playerData)
	{
		// We want to include all prayers that are available, enabled, or unlocked if any of that type change
		boolean availableChanged = false;
		boolean enabledChanged = false;
		boolean unlockedChanged = false;

		for (Prayer p : Prayer.values())
		{
			if (p.getPrayerBookID() != this.prayerBookID)
			{
				continue;
			}

			boolean[] changes = updatePrayerState(playerData, p, client);
			availableChanged |= changes[0];
			enabledChanged |= changes[1];
			unlockedChanged |= changes[2];
		}

		return getPrayerDeltas(playerData, availableChanged, enabledChanged, unlockedChanged);
	}

	public boolean[] updatePrayerState(final PlayerPartyData playerData, final Prayer p, final Client client)
	{
		boolean available, enabled, unlocked;

		available = Prayers.isPrayerAvailable(p, p.getItemID(), client);
		enabled = Prayers.isPrayerEnabled(p, client);
		unlocked = Prayers.isPrayerUnlocked(p, client);

		boolean[] changes = {
				playerData.getAvailablePrayers().contains(p) != available,
				playerData.getEnabledPrayers().contains(p) != enabled,
				playerData.getUnlockedPrayers().contains(p) != unlocked,
		};

		updateEnumSet(playerData.getAvailablePrayers(), p, available);
		updateEnumSet(playerData.getEnabledPrayers(), p, enabled);
		updateEnumSet(playerData.getUnlockedPrayers(), p, unlocked);

		return changes;
	}

	public byte[][] getPrayerDeltas(
			PlayerPartyData playerData,
			boolean includeAvailable,
			boolean includeEnabled,
			boolean includeUnlocked
	)
	{
		final Collection<Prayer> available = new ArrayList<>();
		final Collection<Prayer> enabled = new ArrayList<>();
		final Collection<Prayer> unlocked = new ArrayList<>();

		for (Prayer p : Prayer.values())
		{
			if (includeAvailable && playerData.getAvailablePrayers().contains(p)) available.add(p);
			if (includeEnabled && playerData.getEnabledPrayers().contains(p)) enabled.add(p);
			if (includeUnlocked && playerData.getUnlockedPrayers().contains(p)) unlocked.add(p);
		}

		return new byte[][]{
			PartySerializationUtils.pack(available),
			PartySerializationUtils.pack(enabled),
			PartySerializationUtils.pack(unlocked),
		};
	}

	private void updateEnumSet(EnumSet<Prayer> set, Prayer prayer, boolean include)
	{
		if (include) set.add(prayer); else set.remove(prayer);
	}
}
