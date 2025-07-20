/*
 * Copyright (c) 2020, Pratted <https://github.com/Pratted>
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
package net.runelite.client.plugins.devtools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.CollisionDataFlag;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * An enum that binds a name to each movement flag.
 *
 * @see CollisionDataFlag
 */
@AllArgsConstructor
enum MovementFlag
{
	BLOCK_MOVEMENT_NORTH_WEST(CollisionDataFlag.BLOCK_MOVEMENT_NORTH_WEST),
	BLOCK_MOVEMENT_NORTH(CollisionDataFlag.BLOCK_MOVEMENT_NORTH),
	BLOCK_MOVEMENT_NORTH_EAST(CollisionDataFlag.BLOCK_MOVEMENT_NORTH_EAST),
	BLOCK_MOVEMENT_EAST(CollisionDataFlag.BLOCK_MOVEMENT_EAST),
	BLOCK_MOVEMENT_SOUTH_EAST(CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_EAST),
	BLOCK_MOVEMENT_SOUTH(CollisionDataFlag.BLOCK_MOVEMENT_SOUTH),
	BLOCK_MOVEMENT_SOUTH_WEST(CollisionDataFlag.BLOCK_MOVEMENT_SOUTH_WEST),
	BLOCK_MOVEMENT_WEST(CollisionDataFlag.BLOCK_MOVEMENT_WEST),

	BLOCK_MOVEMENT_OBJECT(CollisionDataFlag.BLOCK_MOVEMENT_OBJECT),
	BLOCK_MOVEMENT_FLOOR_DECORATION(CollisionDataFlag.BLOCK_MOVEMENT_FLOOR_DECORATION),
	BLOCK_MOVEMENT_FLOOR(CollisionDataFlag.BLOCK_MOVEMENT_FLOOR),
	BLOCK_MOVEMENT_FULL(CollisionDataFlag.BLOCK_MOVEMENT_FULL);

	@Getter
	private int flag;

	/**
	 * @param collisionData The tile collision flags.
	 * @return The set of {@link MovementFlag}s that have been set.
	 */
	public static Set<MovementFlag> getSetFlags(int collisionData)
	{
		return Arrays.stream(values())
			.filter(movementFlag -> (movementFlag.flag & collisionData) != 0)
			.collect(Collectors.toSet());
	}
}
