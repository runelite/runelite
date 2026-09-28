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

import com.google.common.collect.Sets;
import java.util.EnumSet;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.party.data.prayers.PrayerState;
import net.runelite.client.party.data.prayers.Prayers;

@Getter
public class PlayerPartyData
{
	private final EnumSet<Prayer> availablePrayers = EnumSet.noneOf(Prayer.class);
	private final EnumSet<Prayer> enabledPrayers = EnumSet.noneOf(Prayer.class);
	private final EnumSet<Prayer> unlockedPrayers = EnumSet.noneOf(Prayer.class);

	@Setter
	private int prayerBookID;

	public PlayerPartyData(Client client)
	{
		for (final Prayer p : Prayer.values())
		{
			if (Prayers.isUnlockedByDefault(p))
			{
				unlockedPrayers.add(p);
			}
		}

		prayerBookID = client.getVarbitValue(VarbitID.PRAYERBOOK);
	}

	public void resetPrayers()
	{
		this.availablePrayers.clear();
		this.enabledPrayers.clear();
		this.unlockedPrayers.clear();
		this.prayerBookID = 0;
	}

	public PrayerState prayerSnapshot()
	{
		return new PrayerState(
			Sets.immutableEnumSet(availablePrayers),
			Sets.immutableEnumSet(enabledPrayers),
			Sets.immutableEnumSet(unlockedPrayers),
			this.prayerBookID
		);
	}
}
