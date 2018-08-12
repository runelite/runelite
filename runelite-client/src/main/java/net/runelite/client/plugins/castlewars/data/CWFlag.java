/*
 * Copyright (c) 2018, cw-dev
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
package net.runelite.client.plugins.castlewars.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectID;

@AllArgsConstructor
@Getter
public enum CWFlag
{
	ZAM(ItemID.ZAMORAK_BANNER, ObjectID.ZAMORAK_STANDARD, "Zamorak Standard"),
	SARA(ItemID.SARADOMIN_BANNER, ObjectID.SARADOMIN_STANDARD, "Saradomin Standard");

	private final Integer equipmentId;
	private final Integer droppedObjectId;
	private final String menuName;

	public static CWFlag fromEquipment(int equipmentId)
	{
		if (equipmentId == CWFlag.ZAM.getEquipmentId())
		{
			return ZAM;
		}

		if (equipmentId == CWFlag.SARA.getEquipmentId())
		{
			return SARA;
		}

		return null;
	}

	public static CWFlag fromDroppedObjectID(int gameObjectID)
	{
		if (gameObjectID == CWFlag.ZAM.getDroppedObjectId())
		{
			return ZAM;
		}

		if (gameObjectID == CWFlag.SARA.getDroppedObjectId())
		{
			return SARA;
		}

		return null;
	}
}
