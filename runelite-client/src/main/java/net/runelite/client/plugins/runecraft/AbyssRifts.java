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

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.function.Predicate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.ItemID.AIR_RUNE;
import static net.runelite.api.ItemID.BLOOD_RUNE;
import static net.runelite.api.ItemID.BODY_RUNE;
import static net.runelite.api.ItemID.CHAOS_RUNE;
import static net.runelite.api.ItemID.COSMIC_RUNE;
import static net.runelite.api.ItemID.DEATH_RUNE;
import static net.runelite.api.ItemID.EARTH_RUNE;
import static net.runelite.api.ItemID.FIRE_RUNE;
import static net.runelite.api.ItemID.LAW_RUNE;
import static net.runelite.api.ItemID.MIND_RUNE;
import static net.runelite.api.ItemID.NATURE_RUNE;
import static net.runelite.api.ItemID.SOUL_RUNE;
import static net.runelite.api.ItemID.WATER_RUNE;
import net.runelite.api.ObjectID;

@AllArgsConstructor
enum AbyssRifts
{
	AIR_RIFT(ObjectID.AIR_RIFT, AIR_RUNE, RunecraftConfig::showAir),
	BLOOD_RIFT(ObjectID.BLOOD_RIFT, BLOOD_RUNE, RunecraftConfig::showBlood),
	BODY_RIFT(ObjectID.BODY_RIFT, BODY_RUNE, RunecraftConfig::showBody),
	CHAOS_RIFT(ObjectID.CHAOS_RIFT, CHAOS_RUNE, RunecraftConfig::showChaos),
	COSMIC_RIFT(ObjectID.COSMIC_RIFT, COSMIC_RUNE, RunecraftConfig::showCosmic),
	DEATH_RIFT(ObjectID.DEATH_RIFT, DEATH_RUNE, RunecraftConfig::showDeath),
	EARTH_RIFT(ObjectID.EARTH_RIFT, EARTH_RUNE, RunecraftConfig::showEarth),
	FIRE_RIFT(ObjectID.FIRE_RIFT, FIRE_RUNE, RunecraftConfig::showFire),
	LAW_RIFT(ObjectID.LAW_RIFT, LAW_RUNE, RunecraftConfig::showLaw),
	MIND_RIFT(ObjectID.MIND_RIFT, MIND_RUNE, RunecraftConfig::showMind),
	NATURE_RIFT(ObjectID.NATURE_RIFT, NATURE_RUNE, RunecraftConfig::showNature),
	SOUL_RIFT(ObjectID.SOUL_RIFT, SOUL_RUNE, RunecraftConfig::showSoul),
	WATER_RIFT(ObjectID.WATER_RIFT, WATER_RUNE, RunecraftConfig::showWater);

	@Getter
	private final int objectId;

	@Getter
	private final int itemId;

	@Getter
	private final Predicate<RunecraftConfig> configEnabled;

	private static final Map<Integer, AbyssRifts> rifts;

	static
	{
		ImmutableMap.Builder<Integer, AbyssRifts> builder = new ImmutableMap.Builder<>();

		for (AbyssRifts s : values())
		{
			builder.put(s.getObjectId(), s);
		}

		rifts = builder.build();
	}

	static AbyssRifts getRift(int id)
	{
		return rifts.get(id);
	}
}
