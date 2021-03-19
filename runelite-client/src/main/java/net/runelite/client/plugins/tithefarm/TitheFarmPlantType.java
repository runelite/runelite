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
import net.runelite.api.ObjectID;

public enum TitheFarmPlantType
{
	EMPTY("Empty", ObjectID.TITHE_PATCH,
		ObjectID.TITHE_PATCH
	),
	GOLOVANOVA("Golovanova", ObjectID.GOLOVANOVA_PLANT_27393,
		ObjectID.GOLOVANOVA_SEEDLING, ObjectID.GOLOVANOVA_SEEDLING_27385, ObjectID.BLIGHTED_GOLOVANOVA_SEEDLING,
		ObjectID.GOLOVANOVA_PLANT, ObjectID.GOLOVANOVA_PLANT_27388, ObjectID.BLIGHTED_GOLOVANOVA_PLANT,
		ObjectID.GOLOVANOVA_PLANT_27390, ObjectID.GOLOVANOVA_PLANT_27391, ObjectID.BLIGHTED_GOLOVANOVA_PLANT_27392,
		ObjectID.GOLOVANOVA_PLANT_27393, ObjectID.BLIGHTED_GOLOVANOVA_PLANT_27394
	),
	BOLOGANO("Bologano", ObjectID.BOLOGANO_PLANT_27404,
		ObjectID.BOLOGANO_SEEDLING, ObjectID.BOLOGANO_SEEDLING_27396, ObjectID.BLIGHTED_BOLOGANO_SEEDLING,
		ObjectID.BOLOGANO_PLANT, ObjectID.BOLOGANO_PLANT_27399, ObjectID.BLIGHTED_BOLOGANO_PLANT,
		ObjectID.BOLOGANO_PLANT_27401, ObjectID.BOLOGANO_PLANT_27402, ObjectID.BLIGHTED_BOLOGANO_PLANT_27403,
		ObjectID.BOLOGANO_PLANT_27404, ObjectID.BLIGHTED_BOLOGANO_PLANT_27405
	),
	LOGAVANO("Logavano", ObjectID.LOGAVANO_PLANT_27415,
		ObjectID.LOGAVANO_SEEDLING, ObjectID.LOGAVANO_SEEDLING_27407, ObjectID.BLIGHTED_LOGAVANO_SEEDLING,
		ObjectID.LOGAVANO_PLANT, ObjectID.LOGAVANO_PLANT_27410, ObjectID.BLIGHTED_LOGAVANO_PLANT,
		ObjectID.LOGAVANO_PLANT_27412, ObjectID.LOGAVANO_PLANT_27413, ObjectID.BLIGHTED_LOGAVANO_PLANT_27414,
		ObjectID.LOGAVANO_PLANT_27415, ObjectID.BLIGHTED_LOGAVANO_PLANT_27416
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
