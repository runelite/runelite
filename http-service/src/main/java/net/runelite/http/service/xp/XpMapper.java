/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.xp;

import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.xp.XpData;
import net.runelite.http.service.xp.beans.XpEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface XpMapper
{
	XpMapper INSTANCE = Mappers.getMapper(XpMapper.class);

	XpData xpEntityToXpData(XpEntity xpEntity);

	@Mapping(source = "attack.experience", target = "attack_xp")
	@Mapping(source = "defence.experience", target = "defence_xp")
	@Mapping(source = "strength.experience", target = "strength_xp")
	@Mapping(source = "hitpoints.experience", target = "hitpoints_xp")
	@Mapping(source = "ranged.experience", target = "ranged_xp")
	@Mapping(source = "prayer.experience", target = "prayer_xp")
	@Mapping(source = "magic.experience", target = "magic_xp")
	@Mapping(source = "cooking.experience", target = "cooking_xp")
	@Mapping(source = "woodcutting.experience", target = "woodcutting_xp")
	@Mapping(source = "fletching.experience", target = "fletching_xp")
	@Mapping(source = "fishing.experience", target = "fishing_xp")
	@Mapping(source = "firemaking.experience", target = "firemaking_xp")
	@Mapping(source = "crafting.experience", target = "crafting_xp")
	@Mapping(source = "smithing.experience", target = "smithing_xp")
	@Mapping(source = "mining.experience", target = "mining_xp")
	@Mapping(source = "herblore.experience", target = "herblore_xp")
	@Mapping(source = "agility.experience", target = "agility_xp")
	@Mapping(source = "thieving.experience", target = "thieving_xp")
	@Mapping(source = "slayer.experience", target = "slayer_xp")
	@Mapping(source = "farming.experience", target = "farming_xp")
	@Mapping(source = "runecraft.experience", target = "runecraft_xp")
	@Mapping(source = "hunter.experience", target = "hunter_xp")
	@Mapping(source = "construction.experience", target = "construction_xp")

	@Mapping(source = "attack.level", target = "attack_level")
	@Mapping(source = "defence.level", target = "defence_level")
	@Mapping(source = "strength.level", target = "strength_level")
	@Mapping(source = "hitpoints.level", target = "hitpoints_level")
	@Mapping(source = "ranged.level", target = "ranged_level")
	@Mapping(source = "prayer.level", target = "prayer_level")
	@Mapping(source = "magic.level", target = "magic_level")
	@Mapping(source = "cooking.level", target = "cooking_level")
	@Mapping(source = "woodcutting.level", target = "woodcutting_level")
	@Mapping(source = "fletching.level", target = "fletching_level")
	@Mapping(source = "fishing.level", target = "fishing_level")
	@Mapping(source = "firemaking.level", target = "firemaking_level")
	@Mapping(source = "crafting.level", target = "crafting_level")
	@Mapping(source = "smithing.level", target = "smithing_level")
	@Mapping(source = "mining.level", target = "mining_level")
	@Mapping(source = "herblore.level", target = "herblore_level")
	@Mapping(source = "agility.level", target = "agility_level")
	@Mapping(source = "thieving.level", target = "thieving_level")
	@Mapping(source = "slayer.level", target = "slayer_level")
	@Mapping(source = "farming.level", target = "farming_level")
	@Mapping(source = "runecraft.level", target = "runecraft_level")
	@Mapping(source = "hunter.level", target = "hunter_level")
	@Mapping(source = "construction.level", target = "construction_level")

	@Mapping(source = "overall.rank", target = "overall_rank")
	@Mapping(source = "attack.rank", target = "attack_rank")
	@Mapping(source = "defence.rank", target = "defence_rank")
	@Mapping(source = "strength.rank", target = "strength_rank")
	@Mapping(source = "hitpoints.rank", target = "hitpoints_rank")
	@Mapping(source = "ranged.rank", target = "ranged_rank")
	@Mapping(source = "prayer.rank", target = "prayer_rank")
	@Mapping(source = "magic.rank", target = "magic_rank")
	@Mapping(source = "cooking.rank", target = "cooking_rank")
	@Mapping(source = "woodcutting.rank", target = "woodcutting_rank")
	@Mapping(source = "fletching.rank", target = "fletching_rank")
	@Mapping(source = "fishing.rank", target = "fishing_rank")
	@Mapping(source = "firemaking.rank", target = "firemaking_rank")
	@Mapping(source = "crafting.rank", target = "crafting_rank")
	@Mapping(source = "smithing.rank", target = "smithing_rank")
	@Mapping(source = "mining.rank", target = "mining_rank")
	@Mapping(source = "herblore.rank", target = "herblore_rank")
	@Mapping(source = "agility.rank", target = "agility_rank")
	@Mapping(source = "thieving.rank", target = "thieving_rank")
	@Mapping(source = "slayer.rank", target = "slayer_rank")
	@Mapping(source = "farming.rank", target = "farming_rank")
	@Mapping(source = "runecraft.rank", target = "runecraft_rank")
	@Mapping(source = "hunter.rank", target = "hunter_rank")
	@Mapping(source = "construction.rank", target = "construction_rank")
	XpData hiscoreResultToXpData(HiscoreResult hiscoreResult);
}
