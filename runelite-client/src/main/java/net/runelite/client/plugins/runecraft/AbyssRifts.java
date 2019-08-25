/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.runecraft;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import static net.runelite.api.ItemID.*;
import net.runelite.api.ObjectID;

public enum AbyssRifts
{
	AIR_RIFT(ObjectID.AIR_RIFT, AIR_RUNE),
	BLOOD_RIFT(ObjectID.BLOOD_RIFT, BLOOD_RUNE),
	BODY_RIFT(ObjectID.BODY_RIFT, BODY_RUNE),
	CHAOS_RIFT(ObjectID.CHAOS_RIFT, CHAOS_RUNE),
	COSMIC_RIFT(ObjectID.COSMIC_RIFT, COSMIC_RUNE),
	DEATH_RIFT(ObjectID.DEATH_RIFT, DEATH_RUNE),
	EARTH_RIFT(ObjectID.EARTH_RIFT, EARTH_RUNE),
	FIRE_RIFT(ObjectID.FIRE_RIFT, FIRE_RUNE),
	LAW_RIFT(ObjectID.LAW_RIFT, LAW_RUNE),
	MIND_RIFT(ObjectID.MIND_RIFT, MIND_RUNE),
	NATURE_RIFT(ObjectID.NATURE_RIFT, NATURE_RUNE),
	SOUL_RIFT(ObjectID.SOUL_RIFT, SOUL_RUNE),
	WATER_RIFT(ObjectID.WATER_RIFT, WATER_RUNE);

	@Getter(AccessLevel.PACKAGE)
	private final int objectId;

	@Getter(AccessLevel.PACKAGE)
	private final int itemId;

	private static final Map<Integer, AbyssRifts> rifts = new HashMap<>();

	static
	{
		for (AbyssRifts s : values())
		{
			rifts.put(s.getObjectId(), s);
		}
	}

	AbyssRifts(final int objectId, final int itemId)
	{
		this.objectId = objectId;
		this.itemId = itemId;
	}

	public static AbyssRifts getRift(int id)
	{
		return rifts.get(id);
	}
}
