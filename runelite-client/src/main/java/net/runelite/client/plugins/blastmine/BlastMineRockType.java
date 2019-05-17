/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.blastmine;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ObjectID;

public enum BlastMineRockType
{
	NORMAL(ObjectID.HARD_ROCK, ObjectID.HARD_ROCK_28580),
	CHISELED(ObjectID.CAVITY, ObjectID.CAVITY_28582),
	LOADED(ObjectID.POT_OF_DYNAMITE, ObjectID.POT_OF_DYNAMITE_28584),
	LIT(ObjectID.POT_OF_DYNAMITE_28585, ObjectID.POT_OF_DYNAMITE_28586),
	EXPLODED(ObjectID.SHATTERED_ROCKFACE, ObjectID.SHATTERED_ROCKFACE_28588);

	private static final Map<Integer, BlastMineRockType> rockTypes;

	static
	{
		ImmutableMap.Builder<Integer, BlastMineRockType> builder = new ImmutableMap.Builder<>();

		for (BlastMineRockType type : values())
		{
			for (int spotId : type.getObjectIds())
			{
				builder.put(spotId, type);
			}
		}

		rockTypes = builder.build();
	}

	@Getter
	private final int[] objectIds;

	BlastMineRockType(int... objectIds)
	{
		this.objectIds = objectIds;
	}

	public static BlastMineRockType getRockType(int objectId)
	{
		return rockTypes.get(objectId);
	}
}
