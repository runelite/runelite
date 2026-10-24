/*
 * Copyright (c) 2020, winterdaze <https://github.com/winterdaze>
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
package net.runelite.client.plugins.animatedicons;

import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Getter;
import lombok.ToString;
import net.runelite.api.ItemID;

@Getter
@ToString
public enum Icon
{
	DRAMEN_BRANCH(ItemID.DRAMEN_BRANCH),
	FIRE_CAPE(ItemID.FIRE_CAPE, ItemID.FIRE_CAPE_L, ItemID.FIRE_CAPE_10566),
	INFERNAL_CAPE(ItemID.INFERNAL_CAPE, ItemID.INFERNAL_CAPE_L, ItemID.INFERNAL_CAPE_21297, ItemID.INFERNAL_CAPE_23622),
	INFERNAL_MAX_CAPE(ItemID.INFERNAL_MAX_CAPE, ItemID.INFERNAL_MAX_CAPE_L, ItemID.INFERNAL_MAX_CAPE_21285),
	MAGIC_LOGS(ItemID.MAGIC_LOGS),
	MAGIC_PYRE_LOGS(ItemID.MAGIC_PYRE_LOGS),
	VOLCANIC_WHIP(ItemID.VOLCANIC_ABYSSAL_WHIP),
	VOLCANIC_WHIP_MIX(ItemID.VOLCANIC_WHIP_MIX);

	private final Set<Integer> itemIDs;
	private final int defaultID;

	Icon(Integer... ids)
	{
		this.defaultID = ids[0];
		this.itemIDs = Sets.newHashSet(ids);
	}

	Icon(int defaultID)
	{
		this.defaultID = defaultID;
		this.itemIDs = Sets.newHashSet(defaultID);
	}

	static Icon getAnimatedIcon(int id)
	{
		for (Icon icon : values())
		{
			if (icon.itemIDs.contains(id))
			{
				return icon;
			}
		}

		return null;
	}
}
