/*
 * Copyright (c) 2019, whs
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
package net.runelite.client.plugins.thieving;

import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ObjectID;

enum Chest
{
	TEN_COIN(Duration.ofMillis(6000), ObjectID.CHEST_11735),
	FIFTY_COIN(Duration.ofMillis(46000), ObjectID.CHEST_11737),
	NATURE_RUNE(Duration.ofMillis(10000), ObjectID.CHEST_11736),
	STEEL_ARROWTIPS(Duration.ofMillis(77000), ObjectID.CHEST_11742),
	AVERAGE_CHEST(Duration.ofMillis(90000), ObjectID.CHEST_22697),
	BLOOD_RUNE(Duration.ofMillis(120000), ObjectID.CHEST_11738),
	ARDOUGNE_CASTLE(Duration.ofMillis(400000), ObjectID.CHEST_11739), // FIXME: Please time
	RICH_CHEST(Duration.ofMillis(300000), ObjectID.CHEST_22681), // FIXME: Please time
	ROGUE_CASTLE(Duration.ofMillis(10000), ObjectID.CHEST_26757); // FIXME: Please time

	private static final Map<Integer, Chest> CHESTS;

	static
	{
		ImmutableMap.Builder<Integer, Chest> builder = new ImmutableMap.Builder<>();
		for (Chest chest : values())
		{
			for (int id : chest.ids)
			{
				builder.put(id, chest);
			}
		}
		CHESTS = builder.build();
	}

	@Getter(AccessLevel.PACKAGE)
	private final Duration respawnTime;
	private final int[] ids;

	Chest(Duration respawnTime, int... ids)
	{
		this.respawnTime = respawnTime;
		this.ids = ids;
	}

	static Chest of(int id)
	{
		return CHESTS.get(id);
	}
}
