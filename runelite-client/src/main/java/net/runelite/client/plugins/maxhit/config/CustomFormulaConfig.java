/*
 * Copyright (c) 2019, Bartvollebregt <https://github.com/Bartvollebregt>
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
package net.runelite.client.plugins.maxhit.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;
import net.runelite.client.plugins.maxhit.requirements.EquipmentItemRequirement;
import net.runelite.client.plugins.maxhit.requirements.EquipmentItemSetRequirement;
import net.runelite.client.plugins.maxhit.requirements.Requirement;
import net.runelite.client.plugins.maxhit.requirements.SpellRequirement;

public enum CustomFormulaConfig
{

	MAGIC_DART(
		MaxHitCalculator.CombatMethod.MAGIC,
		new ArrayList<>(Arrays.asList(
			new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
				ItemID.SLAYERS_STAFF,
				ItemID.SLAYERS_STAFF_E
			)))),
			new SpellRequirement(SpellBaseDamageConfig.MAGIC_DART)
		)),
		(client, calculator) ->
		{
			int magicLevel = client.getBoostedSkillLevel(Skill.MAGIC);
			return Math.floor((magicLevel / 10.0) + 10.0);
		}
	),

	TRIDENT_OF_SEAS(
		MaxHitCalculator.CombatMethod.MAGIC,
		new ArrayList<>(Collections.singletonList(
			new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
				ItemID.TRIDENT_OF_THE_SEAS_FULL,
				ItemID.TRIDENT_OF_THE_SEAS,
				ItemID.TRIDENT_OF_THE_SEAS_E
			))))
		)),
		(client, calculator) ->
		{
			int magicLevel = client.getBoostedSkillLevel(Skill.MAGIC);

			int baseDamage = (int) Math.floor(magicLevel / 3.0) - 5;
			calculator.setBaseDamage(baseDamage);

			return calculator.calculate();
		}
	),

	TRIDENT_OF_SWAMP(
		MaxHitCalculator.CombatMethod.MAGIC,
		new ArrayList<>(Collections.singletonList(
			new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
				ItemID.TRIDENT_OF_THE_SWAMP,
				ItemID.TRIDENT_OF_THE_SWAMP_E
			))))
		)),
		(client, calculator) ->
		{
			int magicLevel = client.getBoostedSkillLevel(Skill.MAGIC);

			int baseDamage = (int) Math.floor(magicLevel / 3.0) - 2;
			calculator.setBaseDamage(baseDamage);

			return calculator.calculate();
		}
	),

	SWAMP_LIZARD(
		MaxHitCalculator.CombatMethod.MAGIC,
		new ArrayList<>(Collections.singletonList(
			new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Collections.singletonList(
				ItemID.SWAMP_LIZARD
			))))
		)),
		(client, calculator) ->
		{
			int magicLevel = client.getBoostedSkillLevel(Skill.MAGIC);
			return Math.floor(0.5 + magicLevel * (64.0 + 56.0) / 640.0);
		}
	),

	ORANGE_SALAMANDER(
		MaxHitCalculator.CombatMethod.MAGIC,
		new ArrayList<>(Collections.singletonList(
			new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Collections.singletonList(
				ItemID.ORANGE_SALAMANDER
			))))
		)),
		(client, calculator) ->
		{
			int magicLevel = client.getBoostedSkillLevel(Skill.MAGIC);
			return Math.floor(0.5 + magicLevel * (64.0 + 59.0) / 640.0);
		}
	),

	RED_SALAMANDER(
		MaxHitCalculator.CombatMethod.MAGIC,
		new ArrayList<>(Collections.singletonList(
			new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Collections.singletonList(
				ItemID.RED_SALAMANDER
			))))
		)),
		(client, calculator) ->
		{
			int magicLevel = client.getBoostedSkillLevel(Skill.MAGIC);
			return Math.floor(0.5 + magicLevel * (64.0 + 77.0) / 640.0);
		}
	),

	BLACK_SALAMANDER(
		MaxHitCalculator.CombatMethod.MAGIC,
		new ArrayList<>(Collections.singletonList(
			new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Collections.singletonList(
				ItemID.BLACK_SALAMANDER
			))))
		)),
		(client, calculator) ->
		{
			int magicLevel = client.getBoostedSkillLevel(Skill.MAGIC);
			return Math.floor(0.5 + magicLevel * (64.0 + 92.0) / 640.0);
		}
	),

	DHAROK(
		MaxHitCalculator.CombatMethod.MELEE,
		new ArrayList<>(Collections.singletonList(new EquipmentItemSetRequirement(new EquipmentItemset(Arrays.asList(
			new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
				ItemID.DHAROKS_HELM,
				ItemID.DHAROKS_HELM_100,
				ItemID.DHAROKS_HELM_75,
				ItemID.DHAROKS_HELM_50,
				ItemID.DHAROKS_HELM_25,
				ItemID.DHAROKS_HELM_0
			))),
			new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Arrays.asList(
				ItemID.DHAROKS_PLATEBODY,
				ItemID.DHAROKS_PLATEBODY_100,
				ItemID.DHAROKS_PLATEBODY_75,
				ItemID.DHAROKS_PLATEBODY_50,
				ItemID.DHAROKS_PLATEBODY_25,
				ItemID.DHAROKS_PLATEBODY_0
			))),
			new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Arrays.asList(
				ItemID.DHAROKS_PLATELEGS,
				ItemID.DHAROKS_PLATELEGS_100,
				ItemID.DHAROKS_PLATELEGS_75,
				ItemID.DHAROKS_PLATELEGS_50,
				ItemID.DHAROKS_PLATELEGS_25,
				ItemID.DHAROKS_PLATELEGS_0
			))),
			new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
				ItemID.DHAROKS_GREATAXE,
				ItemID.DHAROKS_GREATAXE_100,
				ItemID.DHAROKS_GREATAXE_75,
				ItemID.DHAROKS_GREATAXE_50,
				ItemID.DHAROKS_GREATAXE_25,
				ItemID.DHAROKS_GREATAXE_0
			)))
		))))),
		(client, calculator) ->
		{
			int currentHP = client.getBoostedSkillLevel(Skill.HITPOINTS);
			int maxHP = client.getRealSkillLevel(Skill.HITPOINTS);
			int lostHP = maxHP - currentHP;

			double initialMaxHit = calculator.calculate();

			double multiplier = (1.0 + ((lostHP / 100.0) * (maxHP / 100.0)));

			return Math.floor(initialMaxHit * multiplier);
		}
	);

	private final MaxHitCalculator.CombatMethod requiredCombatMethod;
	private final List<Requirement> requirements;
	private final BiFunction<Client, MaxHitCalculator, Double> customFormula;

	CustomFormulaConfig(MaxHitCalculator.CombatMethod requiredCombatMethod, List<Requirement> requirements, BiFunction<Client, MaxHitCalculator, Double> customFormula)
	{
		this.requiredCombatMethod = requiredCombatMethod;
		this.requirements = requirements;
		this.customFormula = customFormula;
	}

	public MaxHitCalculator.CombatMethod getRequiredCombatMethod()
	{
		return requiredCombatMethod;
	}

	public BiFunction<Client, MaxHitCalculator, Double> getCustomFormula()
	{
		return customFormula;
	}

	public List<Requirement> getRequirements()
	{
		return this.requirements;
	}
}
