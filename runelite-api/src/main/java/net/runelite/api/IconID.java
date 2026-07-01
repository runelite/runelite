/*
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of all official icons that Jagex uses in chat.
 */
@RequiredArgsConstructor
@Getter
public enum IconID
{
	PLAYER_MODERATOR(0),
	JAGEX_MODERATOR(1),
	IRONMAN(2),
	ULTIMATE_IRONMAN(3),
	DMM_SKULL_5_KEYS(4),
	DMM_SKULL_4_KEYS(5),
	DMM_SKULL_3_KEYS(6),
	DMM_SKULL_2_KEYS(7),
	DMM_SKULL_1_KEYS(8),
	SKULL(9),
	HARDCORE_IRONMAN(10),
	NO_ENTRY(11),
	CHAIN_LINK(12),
	BOUNTY_HUNTER_EMBLEM(20),
	LEAGUE(22),
	GROUP_IRONMAN(41),
	HARDCORE_GROUP_IRONMAN(42),
	UNRANKED_GROUP_IRONMAN(43);

	private final int index;

	@Override
	public String toString()
	{
		return "<img=" + String.valueOf(this.index) + ">";
	}
}
