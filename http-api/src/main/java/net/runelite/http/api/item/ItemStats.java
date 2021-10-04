/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.http.api.item;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class ItemStats
{
	private boolean equipable;
	private double weight;
	@SerializedName("ge_limit")
	private int geLimit;

	private ItemEquipmentStats equipment;

	public ItemStats subtract(ItemStats other)
	{
		if (other == null)
		{
			return this;
		}

		final double newWeight = weight - other.weight;
		final ItemEquipmentStats newEquipment;


		if (other.equipment != null)
		{
			final ItemEquipmentStats equipment = this.equipment != null
				? this.equipment
				: new ItemEquipmentStats.ItemEquipmentStatsBuilder().build();

			newEquipment = new ItemEquipmentStats.ItemEquipmentStatsBuilder()
				.slot(equipment.getSlot())
				.astab(equipment.getAstab() - other.equipment.getAstab())
				.aslash(equipment.getAslash() - other.equipment.getAslash())
				.acrush(equipment.getAcrush() - other.equipment.getAcrush())
				.amagic(equipment.getAmagic() - other.equipment.getAmagic())
				.arange(equipment.getArange() - other.equipment.getArange())
				.dstab(equipment.getDstab() - other.equipment.getDstab())
				.dslash(equipment.getDslash() - other.equipment.getDslash())
				.dcrush(equipment.getDcrush() - other.equipment.getDcrush())
				.dmagic(equipment.getDmagic() - other.equipment.getDmagic())
				.drange(equipment.getDrange() - other.equipment.getDrange())
				.str(equipment.getStr() - other.equipment.getStr())
				.rstr(equipment.getRstr() - other.equipment.getRstr())
				.mdmg(equipment.getMdmg() - other.equipment.getMdmg())
				.prayer(equipment.getPrayer() - other.equipment.getPrayer())
				.aspeed(equipment.getAspeed() - other.equipment.getAspeed())
				.build();
		}
		else
		{
			newEquipment = equipment;
		}

		return new ItemStats(equipable, newWeight, 0, newEquipment);
	}
}

