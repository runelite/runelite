/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RaidRoom
{
	START("Start", RoomType.START),
	END("End", RoomType.END),
	SCAVENGERS("Scavengers", RoomType.SCAVENGERS),
	FARMING("Farming", RoomType.FARMING),
	EMPTY("Empty", RoomType.EMPTY),

	TEKTON("Tekton", RoomType.COMBAT),
	MUTTADILES("Muttadiles", RoomType.COMBAT),
	GUARDIANS("Guardians", RoomType.COMBAT),
	VESPULA("Vespula", RoomType.COMBAT),
	SHAMANS("Shamans", RoomType.COMBAT),
	VASA("Vasa", RoomType.COMBAT),
	VANGUARDS("Vanguards", RoomType.COMBAT),
	MYSTICS("Mystics", RoomType.COMBAT),
	UNKNOWN_COMBAT("Unknown (combat)", RoomType.COMBAT),

	CRABS("Crabs", RoomType.PUZZLE),
	ICE_DEMON("Ice Demon", RoomType.PUZZLE),
	TIGHTROPE("Tightrope", RoomType.PUZZLE),
	THIEVING("Thieving", RoomType.PUZZLE),
	UNKNOWN_PUZZLE("Unknown (puzzle)", RoomType.PUZZLE);

	static final int ROOM_MAX_SIZE = 32;

	private final String name;
	private final RoomType type;
}
