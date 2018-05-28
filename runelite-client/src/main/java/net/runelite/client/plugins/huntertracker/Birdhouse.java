/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
 * Copyright (c) 2018, Jeff LaJoie
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.huntertracker;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@RequiredArgsConstructor
@Getter
public enum Birdhouse
{
	NORMAL("Bird House", ItemID.BIRD_HOUSE),
	OAK("Oak Bird House", ItemID.OAK_BIRD_HOUSE),
	WILLOW("Willow Bird House", ItemID.WILLOW_BIRD_HOUSE),
	TEAK("Teak Bird House", ItemID.TEAK_BIRD_HOUSE),
	MAPLE("Maple Bird House", ItemID.MAPLE_BIRD_HOUSE),
	MAHOGANY("Mahogany Bird House", ItemID.MAHOGANY_BIRD_HOUSE),
	YEW("Yew Bird House", ItemID.YEW_BIRD_HOUSE),
	MAGIC("Magic Bird House", ItemID.MAGIC_BIRD_HOUSE),
	REDWOOD("Redwood Bird House", ItemID.REDWOOD_BIRD_HOUSE);

	/**
	 * User-visible name
	 */
	private final String name;
	/**
	 * User-visible item icon
	 */
	private final int itemID;
}
