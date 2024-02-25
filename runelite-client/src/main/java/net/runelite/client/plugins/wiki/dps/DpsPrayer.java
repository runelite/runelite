/*
 * Copyright (c) 2024 LlemonDuck
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
package net.runelite.client.plugins.wiki.dps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Prayer;

@RequiredArgsConstructor
@Getter
public enum DpsPrayer
{

	BURST_OF_STRENGTH(Prayer.BURST_OF_STRENGTH, 0),
	CLARITY_OF_THOUGHT(Prayer.CLARITY_OF_THOUGHT, 1),
	SHARP_EYE(Prayer.SHARP_EYE, 2),
	MYSTIC_WILL(Prayer.MYSTIC_WILL, 3),
	SUPERHUMAN_STRENGTH(Prayer.SUPERHUMAN_STRENGTH, 4),
	IMPROVED_REFLEXES(Prayer.IMPROVED_REFLEXES, 5),
	HAWK_EYE(Prayer.HAWK_EYE, 6),
	MYSTIC_LORE(Prayer.MYSTIC_LORE, 7),
	ULTIMATE_STRENGTH(Prayer.ULTIMATE_STRENGTH, 8),
	INCREDIBLE_REFLEXES(Prayer.INCREDIBLE_REFLEXES, 9),
	EAGLE_EYE(Prayer.EAGLE_EYE, 10),
	MYSTIC_MIGHT(Prayer.MYSTIC_MIGHT, 11),
	CHIVALRY(Prayer.CHIVALRY, 12),
	PIETY(Prayer.PIETY, 13),
	RIGOUR(Prayer.RIGOUR, 14),
	AUGURY(Prayer.AUGURY, 15),
	THICK_SKIN(Prayer.THICK_SKIN, 16),
	ROCK_SKIN(Prayer.ROCK_SKIN, 17),
	STEEL_SKIN(Prayer.STEEL_SKIN, 18),
	;

	private final Prayer rlPrayer;
	private final int jsValue;

}
