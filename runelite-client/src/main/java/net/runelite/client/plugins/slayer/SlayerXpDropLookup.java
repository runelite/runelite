/*
 * Copyright (c) 2018, Davis Cook <daviscook447@gmail.com>
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
package net.runelite.client.plugins.slayer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

class SlayerXpDropLookup
{
	private Map<String, List<Double>> xpMap;

	// floating point math equality
	private static final double EPSILON = 1e-6;

	private void loadXpJson() throws IOException
	{
		try (final InputStream xpFile = getClass().getResourceAsStream("/slayer_xp.json"))
		{
			Gson gson = new Gson();
			xpMap = gson.fromJson(new InputStreamReader(xpFile), new TypeToken<Map<String, List<Double>>>() {}.getType());
		}
	}

	/**
	 * Finds the xp for a given npc using the xp + combat level data provided
	 * from the JSON - since scrapping from the wiki isn't perfectly accurate
	 * we make some estimations
	 * <p>
	 * precondition is that xpCombatLevel array is non-null - if it is null
	 * we can simply return -1 to indicate no slayer xp because this npc
	 * has no associated xpCombatLevel array
	 * <p>
	 * 1. first check to see if anywhere in the xp + combat level data this
	 * creature name give slayer xp - if it doesn't just return -1 and
	 * be done with this - if it does give slayer xp then continue
	 * 2. now check to see if we can find the xp for this combat level where
	 * that xp is greater than 0. note that we don't just find the xp for
	 * this combat level - this is because for some monsters the wiki
	 * only has slayer xp data for some combat levels and has it unknown
	 * for the other combat levels. this way we only return the combat level
	 * related xp data for a monster if it is know
	 * 3. finally if the slayer xp data for the monster was unknown for the given
	 * level we estimate the slayer xp by using one of the slayer xps for a level
	 * that does have xp given
	 * 4. note that if a monster gives no slayer xp for any level it will return
	 * -1 so we don't accidentally misscount non-slayer targets dying as giving
	 * slayer xp
	 *
	 * @param npc the npc we are estimating slayer xp for
	 * @return our best guess for the slayer xp for this npc
	 */
	double findXpForNpc(NPCPresence npc)
	{
		List<Double> xpCombatLevel = xpMap.get(npc.getName());
		if (xpCombatLevel == null)
		{
			return -1;
		}
		boolean givesSlayerXp = false;
		for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
		{
			if (xpCombatLevel.get(i) > 0)
			{
				givesSlayerXp = true;
				break;
			}
		}
		if (!givesSlayerXp)
		{
			return -1;
		}
		boolean foundCombatLevel = false;
		for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
		{
			if (Math.abs(xpCombatLevel.get(i + 1) - npc.getCombatLevel()) < EPSILON
				&& xpCombatLevel.get(i) > 0)
			{
				foundCombatLevel = true;
				break;
			}
		}
		if (foundCombatLevel)
		{
			for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
			{
				if (Math.abs(xpCombatLevel.get(i + 1) - npc.getCombatLevel()) < EPSILON)
				{
					return xpCombatLevel.get(i);
				}
			}
		}
		else
		{
			for (int i = 0; i < xpCombatLevel.size() - 1; i += 2)
			{
				if (xpCombatLevel.get(i) > 0)
				{
					return xpCombatLevel.get(i);
				}
			}
		}
		return -1;
	}

	SlayerXpDropLookup()
	{
		try
		{
			loadXpJson();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
