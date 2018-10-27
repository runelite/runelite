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
        MAP.put("corp", Boss.CORPOREALBEAST.getName());
        MAP.put("jad", Boss.TZTOKJAD.getName());
        MAP.put("kq", Boss.KALPHITEQUEEN.getName());
        MAP.put("chaos ele", Boss.CHAOSELEMENTAL.getName());
        MAP.put("dusk", Boss.GROTESQUEGUARDIANS.getName());
        MAP.put("dawn", Boss.GROTESQUEGUARDIANS.getName());
        MAP.put("gargs", Boss.GROTESQUEGUARDIANS.getName());
        MAP.put("crazy arch", Boss.CRAZYARCHEOLOGIST.getName());
        MAP.put("deranged arch", Boss.DERANGEDARCHEOLOGIST.getName());
        MAP.put("mole", Boss.GIANTMOLE.getName());
        MAP.put("vetion", Boss.VETION.getName());
        MAP.put("vene", Boss.VENENATIS.getName());
        MAP.put("kbd", Boss.KINGBLACKDRAGON.getName());
        MAP.put("vork", Boss.VORKATH.getName());
        MAP.put("sire", Boss.ABYSSALSIRE.getName());
        MAP.put("smoke devil", Boss.THERMONUCLEARSMOKEDEVIL.getName());
        MAP.put("thermy", Boss.THERMONUCLEARSMOKEDEVIL.getName());
        MAP.put("cerb", Boss.CERBERUS.getName());
        MAP.put("zuk", Boss.TZKALZUK.getName());
        MAP.put("inferno", Boss.TZKALZUK.getName());
        MAP.put("sara", Boss.COMMANDERZILYANA.getName());
        MAP.put("saradomin", Boss.COMMANDERZILYANA.getName());
        MAP.put("zilyana", Boss.COMMANDERZILYANA.getName());
        MAP.put("zily", Boss.COMMANDERZILYANA.getName());
        MAP.put("zammy", Boss.KRILTSUTSAROTH.getName());
        MAP.put("zamorak", Boss.KRILTSUTSAROTH.getName());
        MAP.put("kril", Boss.KRILTSUTSAROTH.getName());
        MAP.put("kril tsutsaroth", Boss.KRILTSUTSAROTH.getName());
        MAP.put("arma", Boss.KREEARRA.getName());
        MAP.put("kree", Boss.KREEARRA.getName());
        MAP.put("kreearra", Boss.KREEARRA.getName());
        MAP.put("armadyl", Boss.KREEARRA.getName());
        MAP.put("bando", Boss.GENERALGRAARDOR.getName());
        MAP.put("bandos", Boss.GENERALGRAARDOR.getName());
        MAP.put("graardor", Boss.GENERALGRAARDOR.getName());
        MAP.put("supreme", Boss.DAGANNOTHSUPREME.getName());
        MAP.put("rex", Boss.DAGANNOTHREX.getName());
        MAP.put("prime", Boss.DAGANNOTHPRIME.getName());
        MAP.put("wt", Boss.WINTERTODT.getName());
        MAP.put("barrows", Boss.BARROWS.getName());
        MAP.put("cox", Boss.CHAMBERSOFXERIC.getName());
        MAP.put("xeric", Boss.CHAMBERSOFXERIC.getName());
        MAP.put("chambers", Boss.CHAMBERSOFXERIC.getName());
        MAP.put("olm", Boss.CHAMBERSOFXERIC.getName());
        MAP.put("raids", Boss.CHAMBERSOFXERIC.getName());
        MAP.put("tob", Boss.THEATREOFBLOOD.getName());
        MAP.put("theatre", Boss.THEATREOFBLOOD.getName());
        MAP.put("verzik", Boss.THEATREOFBLOOD.getName());
        MAP.put("verzik vitur", Boss.THEATREOFBLOOD.getName());
        MAP.put("raids 2", Boss.THEATREOFBLOOD.getName());
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
