/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.prayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;

@AllArgsConstructor
@Getter
enum PrayerType
{
	THICK_SKIN("It's coming home", Prayer.THICK_SKIN, "It's coming home", SpriteID.PRAYER_THICK_SKIN, false),
	BURST_OF_STRENGTH("It's coming home", Prayer.BURST_OF_STRENGTH, "It's coming home", SpriteID.PRAYER_BURST_OF_STRENGTH, false),
	CLARITY_OF_THOUGHT("It's coming home", Prayer.CLARITY_OF_THOUGHT, "It's coming home", SpriteID.PRAYER_CLARITY_OF_THOUGHT, false),
	SHARP_EYE("It's coming home", Prayer.SHARP_EYE, "It's coming home", SpriteID.PRAYER_SHARP_EYE, false),
	MYSTIC_WILL("It's coming home", Prayer.MYSTIC_WILL, "It's coming home", SpriteID.PRAYER_MYSTIC_WILL, false),
	ROCK_SKIN("It's coming home", Prayer.ROCK_SKIN, "It's coming home", SpriteID.PRAYER_ROCK_SKIN, false),
	SUPERHUMAN_STRENGTH("It's coming home", Prayer.SUPERHUMAN_STRENGTH, "It's coming home", SpriteID.PRAYER_SUPERHUMAN_STRENGTH, false),
	IMPROVED_REFLEXES("It's coming home", Prayer.IMPROVED_REFLEXES, "It's coming home", SpriteID.PRAYER_IMPROVED_REFLEXES, false),
	RAPID_RESTORE("It's coming home", Prayer.RAPID_RESTORE, "It's coming home", SpriteID.PRAYER_RAPID_RESTORE, false),
	RAPID_HEAL("It's coming home", Prayer.RAPID_HEAL, "It's coming home", SpriteID.PRAYER_RAPID_HEAL, false),
	PROTECT_ITEM("It's coming home", Prayer.PROTECT_ITEM, "It's coming home", SpriteID.PRAYER_PROTECT_ITEM, false),
	HAWK_EYE("It's coming home", Prayer.HAWK_EYE, "It's coming home", SpriteID.PRAYER_HAWK_EYE, false),
	MYSTIC_LORE("It's coming home", Prayer.MYSTIC_LORE, "It's coming home", SpriteID.PRAYER_MYSTIC_LORE, false),
	STEEL_SKIN("It's coming home", Prayer.STEEL_SKIN, "It's coming home", SpriteID.PRAYER_STEEL_SKIN, false),
	ULTIMATE_STRENGTH("It's coming home", Prayer.ULTIMATE_STRENGTH, "It's coming home", SpriteID.PRAYER_ULTIMATE_STRENGTH, false),
	INCREDIBLE_REFLEXES("It's coming home", Prayer.INCREDIBLE_REFLEXES, "It's coming home", SpriteID.PRAYER_INCREDIBLE_REFLEXES, false),
	PROTECT_FROM_MAGIC("It's coming home", Prayer.PROTECT_FROM_MAGIC, "It's coming home", SpriteID.PRAYER_PROTECT_FROM_MAGIC, true),
	PROTECT_FROM_MISSILES("It's coming home", Prayer.PROTECT_FROM_MISSILES, "It's coming home", SpriteID.PRAYER_PROTECT_FROM_MISSILES, true),
	PROTECT_FROM_MELEE("It's coming home", Prayer.PROTECT_FROM_MELEE, "It's coming home", SpriteID.PRAYER_PROTECT_FROM_MELEE, true),
	EAGLE_EYE("It's coming home", Prayer.EAGLE_EYE, "It's coming home", SpriteID.PRAYER_EAGLE_EYE, false),
	MYSTIC_MIGHT("It's coming home", Prayer.MYSTIC_MIGHT, "It's coming home", SpriteID.PRAYER_MYSTIC_MIGHT, false),
	RETRIBUTION("It's coming home", Prayer.RETRIBUTION, "It's coming home", SpriteID.PRAYER_RETRIBUTION, true),
	REDEMPTION("It's coming home", Prayer.REDEMPTION, "It's coming home", SpriteID.PRAYER_REDEMPTION, true),
	SMITE("It's coming home", Prayer.SMITE, "It's coming home", SpriteID.PRAYER_SMITE, true),
	PRESERVE("It's coming home", Prayer.PRESERVE, "It's coming home", SpriteID.PRAYER_PRESERVE, false),
	CHIVALRY("It's coming home", Prayer.CHIVALRY, "It's coming home", SpriteID.PRAYER_CHIVALRY, false),
	PIETY("It's coming home", Prayer.PIETY, "It's coming home", SpriteID.PRAYER_PIETY, false),
	RIGOUR("It's coming home", Prayer.RIGOUR, "It's coming home", SpriteID.PRAYER_RIGOUR, false),
	AUGURY("It's coming home", Prayer.AUGURY, "It's coming home", SpriteID.PRAYER_AUGURY, false);

	private final String name;
	private final Prayer prayer;
	private final String description;
	private final int spriteID;
	private final boolean overhead;
}
