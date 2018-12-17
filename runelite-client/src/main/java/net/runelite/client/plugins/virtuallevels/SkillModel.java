/*
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.virtuallevels;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.util.List;
import lombok.Getter;
import net.runelite.api.ModelID;
import net.runelite.api.Skill;

@Getter
public enum SkillModel
{
	CONSTRUCTION1(Skill.CONSTRUCTION, ModelID.HAMMER, 10, 14, 669, 0, 15, 329),
	CONSTRUCTION2(Skill.CONSTRUCTION, ModelID.SAW, 11, 14, 615, 0, 111, 451),
	COOKING(Skill.COOKING, ModelID.COOKING_SKILL_MODEL, 31, 59, 169, 0, 1593, 963),
	CRAFTING1(Skill.CRAFTING, ModelID.HAMMER, 30, 24, 418, 0, 14, 496),
	CRAFTING2(Skill.CRAFTING, ModelID.CHISEL, 39, 45, 353, 0, 18, 400),
	DEFENCE(Skill.DEFENCE, ModelID.STEEL_KITESHIELD, 34, 37, 337, 0, 1074, 598),
	FARMING(Skill.FARMING, ModelID.WATERING_CAN, 31, 52, 118, 0, 1278, 451),
	FIREMAKING(Skill.FIREMAKING, ModelID.FIREMAKING_SKILL_MODEL, 29, 55, 115, 0, 1689, 771),
	FISHING(Skill.FISHING, ModelID.RAW_TUNA, 33, 30, 351, 0, 1865, 517),
	FLETCHING1(Skill.FLETCHING, ModelID.STEEL_ARROW, 43, 19, 254, 0, 1257, 408),
	FLETCHING2(Skill.FLETCHING, ModelID.STEEL_ARROW, 46, 44, 223, 0, 177, 444),
	HERBLORE(Skill.HERBLORE, ModelID.CLEAN_HERB, 20, 35, 550, 0, 2024, 344),
	HITPOINTS(Skill.HITPOINTS, ModelID.HEARTH, 35, 58, 538, 0, 0, 250),
	MAGIC(Skill.MAGIC, ModelID.BLUE_WIZARD_HAT, 29, 50, 131, 0, 1913, 344),
	MINING(Skill.MINING, ModelID.STEEL_PICKAXE, 38, 33, 292, 0, 1166, 413),
	PRAYER(Skill.PRAYER, ModelID.PRAYER_SKILL_MODEL, 29, 27, 582, 0, 504, 505),
	RANGED1(Skill.RANGED, ModelID.STEEL_ARROW, 28, 34, 206, 0, 195, 405),
	RANGED2(Skill.RANGED, ModelID.SHORTBOW, 42, 17, 422, 0, 1618, 397),
	RUNECRAFT(Skill.RUNECRAFT, ModelID.PURE_ESSENCE, 35, 38, 242, 0, 1979, 328),
	SLAYER(Skill.SLAYER, ModelID.SLAYER_SKILL_MODEL, 34, 60, 221, 0, 1944, 649),
	SMITHING(Skill.SMITHING, ModelID.ANVIL, 34, 53, 97, 0, 1868, 716),
	STRENGTH(Skill.STRENGTH, ModelID.STRENGTH_SKILL_MODEL, 35, 23, 512, 0, 14, 631),
	AGILITY(Skill.AGILITY, ModelID.AGILITY_SKILL_MODEL, 29, 29, 533, 0, 2040, 685),
	THIEVING(Skill.THIEVING, ModelID.HIGHWAYMAN_MASK, 42, 31, 366, 0, 55, 155),
	WOODCUTTING(Skill.WOODCUTTING, ModelID.WILLOW_TREE, 20, 69, 116, 0, 1978, 1800),
	ATTACK1(Skill.ATTACK, ModelID.STEEL_SWORD, 65, 38, 234, 0, 148, 444),
	ATTACK2(Skill.ATTACK, ModelID.STEEL_LONGSWORD, 27, 29, 198, 0, 1419, 330),
	HUNTER(Skill.HUNTER, ModelID.FOOTPRINT, 45, 48, 512, 0, 0, 1000);

	private static final ListMultimap<Skill, SkillModel> skillModels =  ArrayListMultimap.create();

	private final Skill skill;
	private final int modelID;
	private final int originalX;
	private final int originalY;
	private final int rotationX;
	private final int rotationY;
	private final int rotationZ;
	private final int modelZoom;

	SkillModel(Skill skill, int modelID, int originalX, int originalY, int rotationX, int rotationY, int rotationZ, int modelZoom)
	{
		this.skill = skill;
		this.modelID = modelID;
		this.originalX = originalX;
		this.originalY = originalY;
		this.rotationX = rotationX;
		this.rotationY = rotationY;
		this.rotationZ = rotationZ;
		this.modelZoom = modelZoom;
	}

	static
	{
		for (SkillModel skillModel : values())
		{
			skillModels.put(skillModel.skill, skillModel);
		}
	}

	public static List<SkillModel> getSkillModels(Skill skill)
	{
		return skillModels.get(skill);
	}
}
