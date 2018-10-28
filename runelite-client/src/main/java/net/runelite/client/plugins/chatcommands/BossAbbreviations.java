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

import net.runelite.api.Boss;

import java.util.HashMap;
import java.util.Map;

public class BossAbbreviations
{
    private static final Map<String, String> MAP = new HashMap<>();

    static
    {
        MAP.put("corp", Boss.CORPOREAL_BEAST.getName());
        MAP.put("jad", Boss.TZTOK_JAD.getName());
        MAP.put("kq", Boss.KALPHITE_QUEEN.getName());
        MAP.put("chaos ele", Boss.CHAOS_ELEMENTAL.getName());
        MAP.put("dusk", Boss.GROTESQUE_GUARDIANS.getName());
        MAP.put("dawn", Boss.GROTESQUE_GUARDIANS.getName());
        MAP.put("gargs", Boss.GROTESQUE_GUARDIANS.getName());
        MAP.put("crazy arch", Boss.CRAZY_ARCHEOLOGIST.getName());
        MAP.put("deranged arch", Boss.DERANGED_ARCHEOLOGIST.getName());
        MAP.put("mole", Boss.GIANT_MOLE.getName());
        MAP.put("vetion", Boss.VETION.getName());
        MAP.put("vene", Boss.VENENATIS.getName());
        MAP.put("kbd", Boss.KING_BLACK_DRAGON.getName());
        MAP.put("vork", Boss.VORKATH.getName());
        MAP.put("sire", Boss.ABYSSAL_SIRE.getName());
        MAP.put("smoke devil", Boss.THERMONUCLEAR_SMOKE_DEVIL.getName());
        MAP.put("thermy", Boss.THERMONUCLEAR_SMOKE_DEVIL.getName());
        MAP.put("cerb", Boss.CERBERUS.getName());
        MAP.put("zuk", Boss.TZKAL_ZUK.getName());
        MAP.put("inferno", Boss.TZKAL_ZUK.getName());
        MAP.put("sara", Boss.COMMANDER_ZILYANA.getName());
        MAP.put("saradomin", Boss.COMMANDER_ZILYANA.getName());
        MAP.put("zilyana", Boss.COMMANDER_ZILYANA.getName());
        MAP.put("zily", Boss.COMMANDER_ZILYANA.getName());
        MAP.put("zammy", Boss.KRIL_TSUTSAROTH.getName());
        MAP.put("zamorak", Boss.KRIL_TSUTSAROTH.getName());
        MAP.put("kril", Boss.KRIL_TSUTSAROTH.getName());
        MAP.put("kril tsutsaroth", Boss.KRIL_TSUTSAROTH.getName());
        MAP.put("arma", Boss.KREEARRA.getName());
        MAP.put("kree", Boss.KREEARRA.getName());
        MAP.put("kreearra", Boss.KREEARRA.getName());
        MAP.put("armadyl", Boss.KREEARRA.getName());
        MAP.put("bando", Boss.GENERAL_GRAARDOR.getName());
        MAP.put("bandos", Boss.GENERAL_GRAARDOR.getName());
        MAP.put("graardor", Boss.GENERAL_GRAARDOR.getName());
        MAP.put("supreme", Boss.DAGANNOTH_SUPREME.getName());
        MAP.put("rex", Boss.DAGANNOTH_REX.getName());
        MAP.put("prime", Boss.DAGANNOTH_PRIME.getName());
        MAP.put("wt", Boss.WINTERTODT.getName());
        MAP.put("barrows", Boss.BARROWS.getName());
        MAP.put("cox", Boss.CHAMBERS_OF_XERIC.getName());
        MAP.put("xeric", Boss.CHAMBERS_OF_XERIC.getName());
        MAP.put("chambers", Boss.CHAMBERS_OF_XERIC.getName());
        MAP.put("olm", Boss.CHAMBERS_OF_XERIC.getName());
        MAP.put("raids", Boss.CHAMBERS_OF_XERIC.getName());
        MAP.put("tob", Boss.THEATRE_OF_BLOOD.getName());
        MAP.put("theatre", Boss.THEATRE_OF_BLOOD.getName());
        MAP.put("verzik", Boss.THEATRE_OF_BLOOD.getName());
        MAP.put("verzik vitur", Boss.THEATRE_OF_BLOOD.getName());
        MAP.put("raids 2", Boss.THEATRE_OF_BLOOD.getName());
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
        return MAP.getOrDefault(abbrev.toUpperCase(), abbrev);
    }
}
