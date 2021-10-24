/*
 * Copyright (c) 2021, Wesley <https://github.com/WesleyM77>
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
package net.runelite.client.plugins.agility;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.Map;
import static net.runelite.api.NpcID.*;
import static net.runelite.api.NullNpcID.*;

import java.util.Set;
import static net.runelite.api.NullObjectID.NULL_10872;
import static net.runelite.api.NullObjectID.NULL_10873;

public class Npcs
{

	static final Set<Integer> NPC_IDS = ImmutableSet.of(
		// Agility Pyramid
		PYRAMID_BLOCK, PYRAMID_BLOCK_5788,
		// Hallowed Sepulchre
		NULL_9672, NULL_9673, NULL_9674,  // arrows
		NULL_9669, NULL_9670, NULL_9671   // swords
	);

	static final Set<Integer> TRAP_NPC_IDS = ImmutableSet.of(
		// Agility pyramid
		PYRAMID_BLOCK, PYRAMID_BLOCK_5788
	);

	static final Map<Integer, Integer> TRAP_RESTING_POSITION = ImmutableMap.of(
		PYRAMID_BLOCK, 2845,
		PYRAMID_BLOCK_5788, 3372
	);

	static final Map<Integer, String> TRAP_MOVEMENT_DIMENSION = ImmutableMap.of(
		PYRAMID_BLOCK, "y",
		PYRAMID_BLOCK_5788, "x"
	);

	static final Map<Integer, String> TRAP_RESTING_TIME = ImmutableMap.of(
		PYRAMID_BLOCK, "PT4.8S",
		PYRAMID_BLOCK_5788, "PT6.0S"
	);

	static final Map<Integer, Integer> TRAP_RESTING_TILE = ImmutableMap.of(
		PYRAMID_BLOCK, NULL_10873,
		PYRAMID_BLOCK_5788, NULL_10872
	);

	static final Set<Integer> SEPULCHRE_NPC_IDS = ImmutableSet.of(
		NULL_9672, NULL_9673, NULL_9674,  // arrows
		NULL_9669, NULL_9670, NULL_9671   // swords
	);
}
