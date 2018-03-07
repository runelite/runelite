/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.fightcave;

import lombok.Getter;

public enum Waves
{
	Wave_0(),
	Wave_1("Level-22"),
	Wave_2("Level-22", "Level-22"),
	Wave_3("Level-45"),
	Wave_4("Level-45", "Level-22"),
	Wave_5("Level-45", "Level-22", "Level-22"),
	Wave_6("Level-45", "Level-45", "[*] Level-90 is next"),
	Wave_7("Level-90"),
	Wave_8("Level-90", "Level-22"),
	Wave_9("Level-90", "Level-22", "Level-22"),
	Wave_10("Level-90", "Level-45"),
	Wave_11("Level-90", "Level-45", "Level-22"),
	Wave_12("Level-90", "Level-45", "Level-22", "Level-22"),
	Wave_13("Level-90", "Level-45", "Level-45"),
	Wave_14("Level-90", "Level-90", "[*] Level-180 is next"),
	Wave_15("Level-180"),
	Wave_16("Level-180", "Level-22"),
	Wave_17("Level-180", "Level-22", "Level-22"),
	Wave_18("Level-180", "Level-45"),
	Wave_19("Level-180", "Level-45", "Level-22"),
	Wave_20("Level-180", "Level-45", "Level-22", "Level-22"),
	Wave_21("Level-180", "Level-45", "Level-45"),
	Wave_22("Level-180", "Level-90"),
	Wave_23("Level-180", "Level-90", "Level-22"),
	Wave_24("Level-180", "Level-90", "Level-22", "Level-22"),
	Wave_25("Level-180", "Level-90", "Level-45"),
	Wave_26("Level-180", "Level-90", "Level-45", "Level-22"),
	Wave_27("Level-180", "Level-90", "Level-45", "Level-22", "Level-22"),
	Wave_28("Level-180", "Level-90", "Level-45", "Level-45"),
	Wave_29("Level-180", "Level-90", "Level-90"),
	Wave_30("Level-180", "Level-180", "[*] Level-360 is next"),
	Wave_31("Level-360"),
	Wave_32("Level-360", "Level-22"),
	Wave_33("Level-360", "Level-22", "Level-22"),
	Wave_34("Level-360", "Level-45"),
	Wave_35("Level-360", "Level-45", "Level-22"),
	Wave_36("Level-360", "Level-45", "Level-22", "Level-22"),
	Wave_37("Level-360", "Level-45", "Level-45", "[*] Level-90 is next"),
	Wave_38("Level-360", "Level-90"),
	Wave_39("Level-360", "Level-90", "Level-22"),
	Wave_40("Level-360", "Level-90", "Level-22", "Level-22"),
	Wave_41("Level-360", "Level-90", "Level-45"),
	Wave_42("Level-360", "Level-90", "Level-45", "Level-22"),
	Wave_43("Level-360", "Level-90", "Level-45", "Level-22", "Level-22"),
	Wave_44("Level-360", "Level-90", "Level-45", "Level-45"),
	Wave_45("Level-360", "Level-90", "Level-90"),
	Wave_46("Level-360", "Level-180"),
	Wave_47("Level-360", "Level-180", "Level-22"),
	Wave_48("Level-360", "Level-180", "Level-22", "Level-22"),
	Wave_49("Level-360", "Level-180", "Level-45"),
	Wave_50("Level-360", "Level-180", "Level-45", "Level-22"),
	Wave_51("Level-360", "Level-180", "Level-45", "Level-22", "Level-22"),
	Wave_52("Level-360", "Level-180", "Level-45", "Level-45"),
	Wave_53("Level-360", "Level-180", "Level-90"),
	Wave_54("Level-360", "Level-180", "Level-90", "Level-22"),
	Wave_55("Level-360", "Level-180", "Level-90", "Level-22", "Level-22"),
	Wave_56("Level-360", "Level-180", "Level-90", "Level-45"),
	Wave_57("Level-360", "Level-180", "Level-90", "Level-45", "Level-22"),
	Wave_58("Level-360", "Level-180", "Level-90", "Level-45", "Level-22", "Level-22"),
	Wave_59("Level-360", "Level-180", "Level-90", "Level-45", "Level-45"),
	Wave_60("Level-360", "Level-180", "Level-90", "Level-90"),
	Wave_61("Level-360", "Level-180", "Level-180"),
	Wave_62("Level-360", "Level-360", "[*] JAD is next"),
	Wave_63("JAD");

	@Getter
	private String[] names;

	Waves(String... names)
	{
		this.names = names;
	}
}
