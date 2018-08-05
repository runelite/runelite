/*
 * Copyright (c) 2018, Mathew Hylkema <mathewhylkema@gmail.com>
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
package net.runelite.client.plugins.tabsviewer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.SpriteID;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum EquipmentToViewerMap
{
	HELM(1, 0, SpriteID.EQUIPMENT_SLOT_HEAD),
	CAPE(3, 1, SpriteID.EQUIPMENT_SLOT_CAPE),
	NECK(4, 2, SpriteID.EQUIPMENT_SLOT_NECK),
	AMMO(5, 13, SpriteID.EQUIPMENT_SLOT_AMMUNITION),
	WEAPON(6, 3, SpriteID.EQUIPMENT_SLOT_WEAPON),
	TORSO(7, 4, SpriteID.EQUIPMENT_SLOT_TORSO),
	SHIELD(8, 5, SpriteID.EQUIPMENT_SLOT_SHIELD),
	LEGS(10, 7, SpriteID.EQUIPMENT_SLOT_LEGS),
	HANDS(12, 9, SpriteID.EQUIPMENT_SLOT_HANDS),
	FEET(13, 10, SpriteID.EQUIPMENT_SLOT_FEET),
	RING(14, 12, SpriteID.EQUIPMENT_SLOT_RING);

	@Getter
	private final int viewerPosition;

	@Getter
	private final int equipmentPosition;

	@Getter
	private final int placeholder;

	private static final Map<Integer, EquipmentToViewerMap> POSITIONS = new HashMap<>();

	static
	{
		for (EquipmentToViewerMap mapping : values())
		{
			POSITIONS.put(mapping.viewerPosition, mapping);
		}
	}

	static EquipmentToViewerMap findMapping(int viewPos)
	{
		return POSITIONS.get(viewPos);
	}
}
