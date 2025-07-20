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
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.ObjectID;

@AllArgsConstructor
enum AbyssRifts
{
	AIR_RIFT(ObjectID.ABYSS_EXIT_TO_AIR, ItemID.AIRRUNE, RunecraftConfig::showAir),
	BLOOD_RIFT(ObjectID.ABYSS_EXIT_TO_BLOOD_PARENT, ItemID.BLOODRUNE, RunecraftConfig::showBlood),
	BODY_RIFT(ObjectID.ABYSS_EXIT_TO_BODY, ItemID.BODYRUNE, RunecraftConfig::showBody),
	CHAOS_RIFT(ObjectID.ABYSS_EXIT_TO_CHAOS, ItemID.CHAOSRUNE, RunecraftConfig::showChaos),
	COSMIC_RIFT(ObjectID.ABYSS_EXIT_TO_COSMIC, ItemID.COSMICRUNE, RunecraftConfig::showCosmic),
	DEATH_RIFT(ObjectID.ABYSS_EXIT_TO_DEATH, ItemID.DEATHRUNE, RunecraftConfig::showDeath),
	EARTH_RIFT(ObjectID.ABYSS_EXIT_TO_EARTH, ItemID.EARTHRUNE, RunecraftConfig::showEarth),
	FIRE_RIFT(ObjectID.ABYSS_EXIT_TO_FIRE, ItemID.FIRERUNE, RunecraftConfig::showFire),
	LAW_RIFT(ObjectID.ABYSS_EXIT_TO_LAW, ItemID.LAWRUNE, RunecraftConfig::showLaw),
	MIND_RIFT(ObjectID.ABYSS_EXIT_TO_MIND, ItemID.MINDRUNE, RunecraftConfig::showMind),
	NATURE_RIFT(ObjectID.ABYSS_EXIT_TO_NATURE, ItemID.NATURERUNE, RunecraftConfig::showNature),
	SOUL_RIFT(ObjectID.ABYSS_EXIT_TO_SOUL, ItemID.SOULRUNE, RunecraftConfig::showSoul),
	WATER_RIFT(ObjectID.ABYSS_EXIT_TO_WATER, ItemID.WATERRUNE, RunecraftConfig::showWater);

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
