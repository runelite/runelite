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
package net.runelite.client.plugins.tithefarm;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.gameval.ObjectID;

public enum TitheFarmPlantType
{
	EMPTY("Empty", ObjectID.HOSIDIUS_TITHE_EMPTY,
		ObjectID.HOSIDIUS_TITHE_EMPTY
	),
	GOLOVANOVA("Golovanova", ObjectID.HOSIDIUS_TITHE_A_4,
		ObjectID.HOSIDIUS_TITHE_A_1_DRY, ObjectID.HOSIDIUS_TITHE_A_1_WET, ObjectID.HOSIDIUS_TITHE_A_1_DEAD,
		ObjectID.HOSIDIUS_TITHE_A_2_DRY, ObjectID.HOSIDIUS_TITHE_A_2_WET, ObjectID.HOSIDIUS_TITHE_A_2_DEAD,
		ObjectID.HOSIDIUS_TITHE_A_3_DRY, ObjectID.HOSIDIUS_TITHE_A_3_WET, ObjectID.HOSIDIUS_TITHE_A_3_DEAD,
		ObjectID.HOSIDIUS_TITHE_A_4, ObjectID.HOSIDIUS_TITHE_A_4_DEAD
	),
	BOLOGANO("Bologano", ObjectID.HOSIDIUS_TITHE_B_4,
		ObjectID.HOSIDIUS_TITHE_B_1_DRY, ObjectID.HOSIDIUS_TITHE_B_1_WET, ObjectID.HOSIDIUS_TITHE_B_1_DEAD,
		ObjectID.HOSIDIUS_TITHE_B_2_DRY, ObjectID.HOSIDIUS_TITHE_B_2_WET, ObjectID.HOSIDIUS_TITHE_B_2_DEAD,
		ObjectID.HOSIDIUS_TITHE_B_3_DRY, ObjectID.HOSIDIUS_TITHE_B_3_WET, ObjectID.HOSIDIUS_TITHE_B_3_DEAD,
		ObjectID.HOSIDIUS_TITHE_B_4, ObjectID.HOSIDIUS_TITHE_B_4_DEAD
	),
	LOGAVANO("Logavano", ObjectID.HOSIDIUS_TITHE_C_4,
		ObjectID.HOSIDIUS_TITHE_C_1_DRY, ObjectID.HOSIDIUS_TITHE_C_1_WET, ObjectID.HOSIDIUS_TITHE_C_1_DEAD,
		ObjectID.HOSIDIUS_TITHE_C_2_DRY, ObjectID.HOSIDIUS_TITHE_C_2_WET, ObjectID.HOSIDIUS_TITHE_C_2_DEAD,
		ObjectID.HOSIDIUS_TITHE_C_3_DRY, ObjectID.HOSIDIUS_TITHE_C_3_WET, ObjectID.HOSIDIUS_TITHE_C_3_DEAD,
		ObjectID.HOSIDIUS_TITHE_C_4, ObjectID.HOSIDIUS_TITHE_C_4_DEAD
	);

	@Getter
	private final String name;
	@Getter
	private final int baseId;
	@Getter
	private final int[] objectIds;

	private static final Map<Integer, TitheFarmPlantType> plantTypes;

	static
	{
		ImmutableMap.Builder<Integer, TitheFarmPlantType> builder = new ImmutableMap.Builder<>();

		for (TitheFarmPlantType type : values())
		{
			for (int spotId : type.getObjectIds())
			{
				builder.put(spotId, type);
			}
		}

		plantTypes = builder.build();
	}

	TitheFarmPlantType(String name, int baseId, int... objectIds)
	{
		this.name = name;
		this.baseId = baseId;
		this.objectIds = objectIds;
	}

	public static TitheFarmPlantType getPlantType(int objectId)
	{
		return plantTypes.get(objectId);
	}
}
