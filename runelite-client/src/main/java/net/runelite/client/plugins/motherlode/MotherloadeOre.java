/*
 * Copyright (c) 2018, Craftiii4 <craftiii4@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ItemID;

import java.util.Arrays;

public enum MotherloadeOre
{

	ADAMANTITE_ORE("Adamantite", ItemID.ADAMANTITE_ORE),
	COAL("Coal", ItemID.COAL),
	GOLD_ORE("Gold", ItemID.GOLD_ORE),
	GOLDEN_NUGGET("Nuggets", ItemID.GOLDEN_NUGGET),
	MITHRIL_ORE("Mithril", ItemID.MITHRIL_ORE),
	RUNITE_ORE("Runite", ItemID.RUNITE_ORE);

	@Getter(AccessLevel.PACKAGE)
	private final String name;

	@Getter(AccessLevel.PACKAGE)
	private final int id;

	MotherloadeOre(String name, int itemID)
	{
		this.name = name;
		this.id = itemID;
	}

	public static MotherloadeOre getFromItem(int itemid)
	{
		return Arrays.stream(values()).filter(o -> o.getId() == itemid).findFirst().orElse(null);
	}

}
