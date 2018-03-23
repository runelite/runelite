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

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;

enum WateringCan
{
	WATERING_CAN0(ItemID.WATERING_CAN, 0, Color.RED),
	WATERING_CAN1(ItemID.WATERING_CAN1, 1, Color.ORANGE),
	WATERING_CAN2(ItemID.WATERING_CAN2, 2, Color.YELLOW),
	WATERING_CAN3(ItemID.WATERING_CAN3, 3, Color.WHITE),
	WATERING_CAN4(ItemID.WATERING_CAN4, 4, Color.WHITE),
	WATERING_CAN5(ItemID.WATERING_CAN5, 5, Color.WHITE),
	WATERING_CAN6(ItemID.WATERING_CAN6, 6, Color.WHITE),
	WATERING_CAN7(ItemID.WATERING_CAN7, 7, Color.WHITE),
	WATERING_CAN8(ItemID.WATERING_CAN8, 8, Color.WHITE);

	@Getter
	private final int id;
	@Getter
	private final int charges;
	@Getter
	private final Color color;

	private static final Map<Integer, WateringCan> wateringCans = new HashMap<>();

	static
	{
		for (WateringCan can : values())
		{
			wateringCans.put(can.getId(), can);
		}
	}

	WateringCan(int id, int charges, Color color)
	{
		this.id = id;
		this.charges = charges;
		this.color = color;
	}

	public static WateringCan getWateringCan(int itemId)
	{
		return wateringCans.get(itemId);
	}
}
