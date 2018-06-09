/*
 * Copyright (c) 2018, Toocanzs <https://github.com/Toocanzs>
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
package net.runelite.client.plugins.magetrainingarena;

import net.runelite.api.ObjectID;

public enum AlchemyRoomCabinet
{
	WEST_0(ObjectID.CUPBOARD_23684, ObjectID.CUPBOARD_23685),
	WEST_1(ObjectID.CUPBOARD_23682, ObjectID.CUPBOARD_23683),
	WEST_2(ObjectID.CUPBOARD_23680, ObjectID.CUPBOARD_23681),
	WEST_3(ObjectID.CUPBOARD_23678, ObjectID.CUPBOARD_23679),

	EAST_0(ObjectID.CUPBOARD_23686, ObjectID.CUPBOARD_23687),
	EAST_1(ObjectID.CUPBOARD_23688, ObjectID.CUPBOARD_23689),
	EAST_2(ObjectID.CUPBOARD_23690, ObjectID.CUPBOARD_23691),
	EAST_3(ObjectID.CUPBOARD_23692, ObjectID.CUPBOARD_23693);

	int closedObjectId;
	int openObjectId;

	static AlchemyRoomCabinet getCabinetById(int objectId)
	{
		for (AlchemyRoomCabinet cabinet : values())
		{
			if (cabinet.openObjectId == objectId || cabinet.closedObjectId == objectId)
			{
				return cabinet;
			}
		}
		return null;
	}

	AlchemyRoomCabinet(int closedObjectId, int openObjectId)
	{
		this.closedObjectId = closedObjectId;
		this.openObjectId = openObjectId;
	}
}
