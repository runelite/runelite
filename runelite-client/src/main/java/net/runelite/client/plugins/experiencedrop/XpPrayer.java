/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.experiencedrop;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Prayer;
import static net.runelite.api.Prayer.*;
import static net.runelite.client.plugins.experiencedrop.PrayerType.MAGIC;
import static net.runelite.client.plugins.experiencedrop.PrayerType.MELEE;
import static net.runelite.client.plugins.experiencedrop.PrayerType.RANGE;

enum XpPrayer
{
	XP_BURST_OF_STRENGTH(BURST_OF_STRENGTH, MELEE),
	XP_CLARITY_OF_THOUGHT(CLARITY_OF_THOUGHT, MELEE),
	XP_SHARP_EYE(SHARP_EYE, RANGE),
	XP_MYSTIC_WILL(MYSTIC_WILL, MAGIC),
	XP_SUPERHUMAN_STRENGTH(SUPERHUMAN_STRENGTH, MELEE),
	XP_IMPROVED_REFLEXES(IMPROVED_REFLEXES, MELEE),
	XP_HAWK_EYE(HAWK_EYE, RANGE),
	XP_MYSTIC_LORE(MYSTIC_LORE, MAGIC),
	XP_ULTIMATE_STRENGTH(ULTIMATE_STRENGTH, MELEE),
	XP_INCREDIBLE_REFLEXES(INCREDIBLE_REFLEXES, MELEE),
	XP_EAGLE_EYE(EAGLE_EYE, RANGE),
	XP_MYSTIC_MIGHT(MYSTIC_MIGHT, MAGIC),
	XP_CHIVALRY(CHIVALRY, MELEE),
	XP_PIETY(PIETY, MELEE),
	XP_RIGOUR(RIGOUR, RANGE),
	XP_AUGURY(AUGURY, MAGIC);

	@Getter(AccessLevel.PACKAGE)
	private final Prayer prayer;
	@Getter(AccessLevel.PACKAGE)
	private final PrayerType type;

	XpPrayer(Prayer prayer, PrayerType type)
	{
		this.prayer = prayer;
		this.type = type;
	}
}
