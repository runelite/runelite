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
package net.runelite.client.plugins.chatcommands;

import java.util.HashMap;
import java.util.Map;

class BossAbbreviations
{
	private static final Map<String, String> MAP = new HashMap<>();

	static
	{
		MAP.put("corp", "Corporeal Beast");
		MAP.put("jad", "TzTok-Jad");
		MAP.put("kq", "Kalphite Queen");
		MAP.put("chaos ele", "Chaos Element");
		MAP.put("dusk", "Grotesque Guardians");
		MAP.put("dawn", "Grotesque Guardians");
		MAP.put("gargs", "Grotesque Guardians");
		MAP.put("crazy arch", "Crazy Archaeologist");
		MAP.put("deranged arch", "Deranged Archaeologist");
		MAP.put("mole", "Giant Mole");
		MAP.put("vetion", "Vet'ion");
		MAP.put("vene",  "Venenatis");
		MAP.put("kbd", "King Black Dragon");
		MAP.put("vork", "Vorkath");
		MAP.put("sire", "Abyssal Sire");
		MAP.put("smoke devil", "Thermonuclear Smoke Devil");
		MAP.put("thermy", "Thermonuclear Smoke Devil");
		MAP.put("cerb", "Cerberus");
		MAP.put("zuk", "TzKal-Zuk");
		MAP.put("inferno", "TzKal-Zuk");
		MAP.put("sara", "Commander Zilyana");
		MAP.put("saradomin", "Commander Zilyana");
		MAP.put("zilyana", "Commander Zilyana");
		MAP.put("zily", "Commander Zilyana");
		MAP.put("zammy", "K'ril Tsutsaroth");
		MAP.put("zamorak", "K'ril Tsutsaroth");
		MAP.put("kril", "K'ril Tsutsaroth");
		MAP.put("kril tsutsaroth", "K'ril Tsutsaroth");
		MAP.put("arma", "Kree'arra");
		MAP.put("kree", "Kree'arra");
		MAP.put("kreearra", "Kree'arra");
		MAP.put("armadyl", "Kree'arra");
		MAP.put("bando", "General Graardor");
		MAP.put("bandos", "General Graardor");
		MAP.put("graardor", "General Graardor");
		MAP.put("supreme", "Dagannoth Supreme");
		MAP.put("rex", "Dagannoth Rex");
		MAP.put("prime", "Dagannoth Prime");
		MAP.put("wt", "Wintertodt");
		MAP.put("barrows", "Barrows Chests");
		MAP.put("cox", "Chambers of Xeric");
		MAP.put("xeric", "Chambers of Xeric");
		MAP.put("chambers", "Chambers of Xeric");
		MAP.put("olm", "Chambers of Xeric");
		MAP.put("raids", "Chambers of Xeric");
		MAP.put("tob", "Theatre of Blood");
		MAP.put("theatre", "Theatre of Blood");
		MAP.put("verzik", "Theatre of Blood");
		MAP.put("verzik vitur", "Theatre of Blood");
		MAP.put("raids 2", "Theatre of Blood");
	}

	/**
	 * Takes a string representing the name of a boss, and if abbreviated,
	 * expands it into its full canonical name. Case-insensitive.
	 *
	 * @param abbrev Boss name that may be abbreviated.
	 * @return Full boss name if recognized, else the original string.
	 */

	static String getFullName(String abbrev)
	{
		return MAP.getOrDefault(abbrev.toLowerCase(), abbrev);
	}
}
