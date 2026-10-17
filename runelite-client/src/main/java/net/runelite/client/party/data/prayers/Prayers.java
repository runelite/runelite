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

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.ScriptID;
import net.runelite.api.gameval.VarbitID;

@AllArgsConstructor
@Getter
public enum Prayers
{
	EAGLE_EYE(Prayer.EAGLE_EYE)
	{
		@Override
		public boolean isUnlocked(Client client)
		{
			return !DEADEYE.isUnlocked(client);
		}
	},
	DEADEYE(Prayer.DEADEYE)
	{
		@Override
		public boolean isUnlocked(Client client)
		{
			boolean inLms = client.getVarbitValue(VarbitID.BR_INGAME) != 0;
			boolean deadeye = client.getVarbitValue(VarbitID.PRAYER_DEADEYE_UNLOCKED) != 0;
			return deadeye && !inLms;
		}
	},
	MYSTIC_MIGHT(Prayer.MYSTIC_MIGHT)
	{
		@Override
		public boolean isUnlocked(Client client)
		{
			return !MYSTIC_VIGOUR.isUnlocked(client);
		}
	},
	MYSTIC_VIGOUR(Prayer.MYSTIC_VIGOUR)
	{
		@Override
		public boolean isUnlocked(Client client)
		{
			boolean inLms = client.getVarbitValue(VarbitID.BR_INGAME) != 0;
			boolean vigour = client.getVarbitValue(VarbitID.PRAYER_MYSTIC_VIGOUR_UNLOCKED) != 0;
			return vigour && !inLms;
		}
	},
	;

	private static final HashMap<Prayer, Prayers> CUSTOM_PRAYERS = new HashMap<>();

	static
	{
		for (Prayers p : Prayers.values())
		{
			CUSTOM_PRAYERS.put(p.getPrayer(), p);
		}
	}

	private final Prayer prayer;

	boolean isUnlocked(Client client)
	{
		return true;
	}

	public static boolean isPrayerAvailable(Prayer p, int prayerId, Client client)
	{
		if (CUSTOM_PRAYERS.containsKey(p) && !CUSTOM_PRAYERS.get(p).isUnlocked(client))
		{
			return false;
		}

		client.runScript(ScriptID.PRAYER_ISAVAILABLE, prayerId);
		return client.getIntStack()[0] > 0;
	}

	public static boolean isPrayerEnabled(Prayer p, Client client)
	{
		if (CUSTOM_PRAYERS.containsKey(p) && !CUSTOM_PRAYERS.get(p).isUnlocked(client))
		{
			return false;
		}

		// CUSTOM_PRAYERS.isUnlocked logic handles the deprecation warning
		return client.isPrayerActive(p);
	}

	public static boolean isPrayerUnlocked(Prayer p, Client client)
	{
		if (CUSTOM_PRAYERS.containsKey(p))
		{
			return CUSTOM_PRAYERS.get(p).isUnlocked(client);
		}

		return true;
	}

	public static boolean isUnlockedByDefault(Prayer p)
	{
		return !p.equals(Prayer.DEADEYE) && !p.equals(Prayer.MYSTIC_VIGOUR);
	}
}
