/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2019, Kyle <https://github.com/kyleeld>
 * Copyright (c) 2018, Raiever <https://github.com/Raieverr>
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

package net.runelite.client.plugins.hideprayers.PVM;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("hideprayersPVM")
public interface HidePrayersPVMConfig extends Config
{
	@ConfigItem
	(
		position = 0,
		keyName = "barrowscheap",
		name = "Barrows Eagle Eye/Mystic Might",
		description = "Shows prayers for Barrows"
	)
	default boolean showBarrowsCheap() {return false;}

	@ConfigItem
	(
		position = 1,
		keyName = "barrowsexpensive",
		name = "Barrows Augury/Rigour",
		description = "Shows prayers for Barrows"
	)
	default boolean showBarrowsExpensive() {return false;}

	@ConfigItem
	(
		position = 2,
		keyName = "zulrahcheap",
		name = "Zulrah Eagle Eye/Mystic Might",
		description = "Show prayers for Zulrah"
	)
	default boolean showZulrahCheap() {return false;}

	@ConfigItem
	(
		position = 3,
		keyName = "zulrahexpensive",
		name = "Zulrah Augury/Rigour",
		description = "Shows prayers for Zulrah"
	)
	default boolean showZulrahExpensive() {return false;}

	@ConfigItem
	(
		position = 4,
		keyName = "vorkathcheap",
		name = "Vorkath Eagle Eye",
		description = "Shows prayers for Vorkath"
	)
	default boolean showVorkathCheap() {return false;}

	@ConfigItem
	(
		position = 5,
		keyName = "vorkathexpensive",
		name = "Vorkath Rigour",
		description = "Shows prayers for Vorkath"
	)
	default boolean showVorkathExpensive() {return false;}

	@ConfigItem
	(
		position = 6,
		keyName = "cerberuscheap",
		name = "Cerberus Strength/Skin/Reflexes",
		description = "Shows prayers for Cerberus"
	)
	default boolean showCerberusCheap() {return false;}

	@ConfigItem
	(
		position = 7,
		keyName = "cerberusexpensive",
		name = "Cerberus Piety",
		description = "Shows prayers for Cerberus"
	)
	default boolean showCerberusExpensive() {return false;}

	@ConfigItem
	(
		position = 8,
		keyName = "cerberusrangeexpensive",
		name = "Cerberus Eagle Eye",
		description = "Shows prayers for Cerberus"
	)
	default boolean showCerberusRangeCheap() {return false;}

	@ConfigItem
	(
		position = 9,
		keyName = "cerberuserangexpensive",
		name = "Cerberus Rigour",
		description = "Shows prayers for Cerberus"
	)
	default boolean showCerberusRangeExpensive() {return false;}

	@ConfigItem
	(
		position = 10,
		keyName = "armadylcheap",
		name = "Armadyl Eagle eye",
		description = "Shows prayers for Armadyl GWD"
	)
	default boolean showArmadylCheap() {return false;}

	@ConfigItem
	(
		position = 11,
		keyName = "armadylexpensive",
		name = "Armadyl Rigour",
		description = "Shows prayers for Armadyl GWD"
	)
	default boolean showArmadylExpensive() {return false;}

	@ConfigItem
	(
		position = 12,
		keyName = "bandoscheap",
		name = "Bandos Strength/Skin/Reflexes",
		description = "Shows prayers for Bandos GWD"
	)
	default boolean showBandosCheap() {return false;}

	@ConfigItem
	(
		position = 13,
		keyName = "bandosexpensive",
		name = "Bandos Piety",
		description = "Shows prayers for Bandos GWD"
	)
	default boolean showBandosExpensive() {return false;}

	@ConfigItem
	(
		position = 14,
		keyName = "sardomincheap",
		name = "Saradomin Eagle eye/Steel Skin",
		description = "Shows prayers for Saradomin GWD"
	)
	default boolean showSaradominCheap() {return false;}

	@ConfigItem
	(
		position = 15,
		keyName = "saradominexpensive",
		name = "Saradomin Piety/Rigour",
		description = "Shows prayers for Saradomin GWD"
	)
	default boolean showSaradominExpensive() {return false;}

	@ConfigItem
	(
		position = 16,
		keyName = "zamorakcheap",
		name = "Zamorak Strength/Skin/Reflexes",
		description = "Shows prayers for Zamorak GWD"
	)
	default boolean showZamorakCheap() {return false;}

	@ConfigItem
	(
		position = 17,
		keyName = "zamorakexpensive",
		name = "Zamorak Piety",
		description = "Shows prayers for Zamorak GWD"
	)
	default boolean showZamorakExpensive() {return false;}
}
