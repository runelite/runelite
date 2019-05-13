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
		keyName = "Barrows",
		name = "Barrows",
		description = "Shows prayers for Barrows"
	)
	default Barrows Barrows() {return Barrows.DISABLED;}

	@ConfigItem
	(
		position = 1,
		keyName = "Cerberus",
		name = "Cerberus",
		description = "Shows prayers for Cerberus"
	)
	default Cerberus Cerberus() {return Cerberus.DISABLED;}

	@ConfigItem
	(
		position = 2,
		keyName = "Vorkath",
		name = "Vorkath",
		description = "Shows prayers for Vorkath"
	)
	default Vorkath Vorkath() {return Vorkath.DISABLED;}

	@ConfigItem
	(
		position = 3,
		keyName = "Zulrah",
		name = "Zulrah",
		description = "Shows prayers for Zulrah"
	)
	default Zulrah Zulrah() {return Zulrah.DISABLED;}

	@ConfigItem
	(
		position = 4,
		keyName = "Armadyl",
		name = "Armadyl",
		description = "Shows prayers for Armadyl"
	)
	default Armadyl Armadyl() {return Armadyl.DISABLED;}

	@ConfigItem
	(
		position = 5,
		keyName = "Bandos",
		name = "Bandos",
		description = "Shows prayers for Bandos"
	)
	default Bandos Bandos() {return Bandos.DISABLED;}

	@ConfigItem
	(
		position = 6,
		keyName = "Saradomin",
		name = "Saradomin",
		description = "Shows prayers for Saradomin"
	)
	default Saradomin Saradomin() {return Saradomin.DISABLED;}

	@ConfigItem
	(
		position = 7,
		keyName = "Zamorak",
		name = "Zamorak",
		description = "Shows prayers for Zamorak"
	)
	default Zamorak Zamorak() {return Zamorak.DISABLED;}
}