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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.ItemID;
import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;
import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;
import net.runelite.client.plugins.maxhit.requirements.AutocastSpellRequirement;
import net.runelite.client.plugins.maxhit.requirements.Requirement;
import net.runelite.client.plugins.maxhit.requirements.SpellBookRequirement;


public enum EquipmentBonusConfig
{

	/*
	 * Slayer bonus items
	 */
	BLACKMASK(BonusType.SLAYER, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.BLACK_MASK_10,
			ItemID.BLACK_MASK_9,
			ItemID.BLACK_MASK_8,
			ItemID.BLACK_MASK_7,
			ItemID.BLACK_MASK_6,
			ItemID.BLACK_MASK_5,
			ItemID.BLACK_MASK_4,
			ItemID.BLACK_MASK_3,
			ItemID.BLACK_MASK_2,
			ItemID.BLACK_MASK_1,
			ItemID.BLACK_MASK
		)))
	)), new EquipmentCombatBonus(((7.0 / 6.0) - 1), 0, 0)),

	SLAYERHELM(BonusType.SLAYER, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.SLAYER_HELMET,
			ItemID.BLACK_SLAYER_HELMET,
			ItemID.GREEN_SLAYER_HELMET,
			ItemID.RED_SLAYER_HELMET,
			ItemID.PURPLE_SLAYER_HELMET,
			ItemID.TURQUOISE_SLAYER_HELMET,
			ItemID.HYDRA_SLAYER_HELMET
		)))
	)), new EquipmentCombatBonus(((7.0 / 6.0) - 1), 0, 0)),

	BLACKMASKI(BonusType.SLAYER, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.BLACK_MASK_10_I,
			ItemID.BLACK_MASK_9_I,
			ItemID.BLACK_MASK_8_I,
			ItemID.BLACK_MASK_7_I,
			ItemID.BLACK_MASK_6_I,
			ItemID.BLACK_MASK_5_I,
			ItemID.BLACK_MASK_4_I,
			ItemID.BLACK_MASK_3_I,
			ItemID.BLACK_MASK_2_I,
			ItemID.BLACK_MASK_1_I,
			ItemID.BLACK_MASK_I
		)))
	)), new EquipmentCombatBonus(((7.0 / 6.0) - 1), 0.15, 0.15)),

	SLAYERHELMI(BonusType.SLAYER, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.SLAYER_HELMET_I,
			ItemID.BLACK_SLAYER_HELMET_I,
			ItemID.GREEN_SLAYER_HELMET_I,
			ItemID.RED_SLAYER_HELMET_I,
			ItemID.PURPLE_SLAYER_HELMET_I,
			ItemID.TURQUOISE_SLAYER_HELMET_I,
			ItemID.HYDRA_SLAYER_HELMET_I
		)))
	)), new EquipmentCombatBonus(((7.0 / 6.0) - 1), 0.15, 0.15)),

	/*
	 * Void bonus items
	 * */
	MELEEVOID(BonusType.VOID_KNIGHT, new EquipmentItemset(Arrays.asList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.VOID_MELEE_HELM,
			ItemID.VOID_MELEE_HELM_11676
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Arrays.asList(
			ItemID.VOID_KNIGHT_TOP,
			ItemID.VOID_KNIGHT_TOP_10611
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Collections.singletonList(
			ItemID.VOID_KNIGHT_ROBE
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.GLOVES, new ArrayList<>(Collections.singletonList(
			ItemID.VOID_KNIGHT_GLOVES
		)))
	)), new EquipmentCombatBonus(0.1, 0, 0)),

	RANGERVOID(BonusType.VOID_KNIGHT, new EquipmentItemset(Arrays.asList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.VOID_RANGER_HELM,
			ItemID.VOID_RANGER_HELM_11675
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Arrays.asList(
			ItemID.VOID_KNIGHT_TOP,
			ItemID.VOID_KNIGHT_TOP_10611
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Collections.singletonList(
			ItemID.VOID_KNIGHT_ROBE
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.GLOVES, new ArrayList<>(Collections.singletonList(
			ItemID.VOID_KNIGHT_GLOVES
		)))
	)), new EquipmentCombatBonus(0, 0.1, 0)),


	ELITEMELEERVOID(BonusType.VOID_KNIGHT, new EquipmentItemset(Arrays.asList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.VOID_MELEE_HELM,
			ItemID.VOID_MELEE_HELM_11676
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Collections.singletonList(
			ItemID.ELITE_VOID_TOP
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Collections.singletonList(
			ItemID.ELITE_VOID_ROBE
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.GLOVES, new ArrayList<>(Collections.singletonList(
			ItemID.VOID_KNIGHT_GLOVES
		)))
	)), new EquipmentCombatBonus(0.125, 0, 0)),


	ELITERANGERVOID(BonusType.VOID_KNIGHT, new EquipmentItemset(Arrays.asList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.VOID_RANGER_HELM,
			ItemID.VOID_RANGER_HELM_11675
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Collections.singletonList(
			ItemID.ELITE_VOID_TOP
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Collections.singletonList(
			ItemID.ELITE_VOID_ROBE
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.GLOVES, new ArrayList<>(Collections.singletonList(
			ItemID.VOID_KNIGHT_GLOVES
		)))
	)), new EquipmentCombatBonus(0, 0.125, 0)),

	ELITEMAGICVOID(BonusType.EQUIPMENT, new EquipmentItemset(Arrays.asList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Arrays.asList(
			ItemID.VOID_MAGE_HELM,
			ItemID.VOID_MAGE_HELM_11674
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Collections.singletonList(
			ItemID.ELITE_VOID_TOP
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Collections.singletonList(
			ItemID.ELITE_VOID_ROBE
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.GLOVES, new ArrayList<>(Collections.singletonList(
			ItemID.VOID_KNIGHT_GLOVES
		)))
	)), new EquipmentCombatBonus(0, 0, 0.025)),

	/*
	 * Special Melee Equipment
	 * */
	OBISIDIAN(BonusType.SPECIAL, new EquipmentItemset(Arrays.asList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Collections.singletonList(
			ItemID.OBSIDIAN_HELMET
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Collections.singletonList(
			ItemID.OBSIDIAN_PLATEBODY
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Collections.singletonList(
			ItemID.OBSIDIAN_PLATELEGS
		))),
		new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
			ItemID.TOKTZXILAK,
			ItemID.TOKTZXILEK,
			ItemID.TZHAARKETEM,
			ItemID.TZHAARKETOM,
			ItemID.TOKTZXILAK_20554
		)))
	)), new EquipmentCombatBonus(0.1, 0, 0)),

	BERSERKERNECKLACE(BonusType.SPECIAL, new EquipmentItemset(Arrays.asList(
		new EquipmentSlotItem(EquipmentInventorySlot.AMULET, new ArrayList<>(Collections.singletonList(ItemID.BERSERKER_NECKLACE))),
		new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
			ItemID.TOKTZXILAK,
			ItemID.TOKTZXILEK,
			ItemID.TZHAARKETEM,
			ItemID.TZHAARKETOM,
			ItemID.TOKTZXILAK_20554
		)))
	)), new EquipmentCombatBonus(0.2, 0, 0)),


	/*
	 * Magic Equipment
	 */
	ANCESTRAL_HAT(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.HEAD, new ArrayList<>(Collections.singletonList(
			ItemID.ANCESTRAL_HAT
		)))
	)), new EquipmentCombatBonus(0, 0, 0.02)),

	ANCESTRAL_ROBE_TOP(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.BODY, new ArrayList<>(Collections.singletonList(
			ItemID.ANCESTRAL_ROBE_TOP
		)))
	)), new EquipmentCombatBonus(0, 0, 0.02)),

	ANCESTRAL_ROBE_BOTTOM(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.LEGS, new ArrayList<>(Collections.singletonList(
			ItemID.ANCESTRAL_ROBE_BOTTOM
		)))
	)), new EquipmentCombatBonus(0, 0, 0.02)),

	IMBUED_GOD_CAPE(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.CAPE, new ArrayList<>(Arrays.asList(
			ItemID.IMBUED_SARADOMIN_MAX_CAPE,
			ItemID.IMBUED_SARADOMIN_CAPE,
			ItemID.IMBUED_ZAMORAK_MAX_CAPE,
			ItemID.IMBUED_ZAMORAK_CAPE,
			ItemID.IMBUED_GUTHIX_MAX_CAPE,
			ItemID.IMBUED_GUTHIX_CAPE
		)))
	)), new EquipmentCombatBonus(0, 0, 0.02)),

	KODAI_WAND(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Collections.singletonList(
			ItemID.KODAI_WAND
		)))
	)), new EquipmentCombatBonus(0, 0, 0.15)),

	OCCULT_NECKLACE(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.AMULET, new ArrayList<>(Arrays.asList(
			ItemID.OCCULT_NECKLACE,
			ItemID.OCCULT_NECKLACE_OR
		)))
	)), new EquipmentCombatBonus(0, 0, 0.10)),

	STAFF_OF_THE_DEAD(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
			ItemID.STAFF_OF_THE_DEAD,
			ItemID.TOXIC_STAFF_OF_THE_DEAD,
			ItemID.STAFF_OF_LIGHT
		)))
	)), new EquipmentCombatBonus(0, 0, 0.15)),

	TORMENTED_BRACELET(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.GLOVES, new ArrayList<>(Collections.singletonList(
			ItemID.TORMENTED_BRACELET
		)))
	)), new EquipmentCombatBonus(0, 0, 0.05)),

	SMOKE_STAFF(BonusType.EQUIPMENT, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.WEAPON, new ArrayList<>(Arrays.asList(
			ItemID.SMOKE_BATTLESTAFF,
			ItemID.MYSTIC_SMOKE_STAFF
		)))
	)), new EquipmentCombatBonus(0, 0, 0.10), Collections.singletonList(new SpellBookRequirement(SpellBaseDamageConfig.SpellBook.NORMAL))),


	/*
	 * Special magic bonusses
	 * */

	CHAOS_GAUNTLETS(BonusType.SPECIAL, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.GLOVES, new ArrayList<>(Collections.singletonList(
			ItemID.CHAOS_GAUNTLETS
		))))),
		new EquipmentCombatBonus(0, 0, 3),
		Collections.singletonList(
			new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
				SpellBaseDamageConfig.AIR_BOLT,
				SpellBaseDamageConfig.WATER_BOLT,
				SpellBaseDamageConfig.EARTH_BOLT,
				SpellBaseDamageConfig.FIRE_BOLT
			)))
		),
		Operation.ADD
	),

	TOME_OF_FIRE(BonusType.MAGIC_SPECIAL, new EquipmentItemset(Collections.singletonList(
		new EquipmentSlotItem(EquipmentInventorySlot.SHIELD, new ArrayList<>(Collections.singletonList(
			ItemID.TOME_OF_FIRE
		))))),
		new EquipmentCombatBonus(0, 0, 0.5),
		Collections.singletonList(
			new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
				SpellBaseDamageConfig.FIRE_BLAST,
				SpellBaseDamageConfig.FIRE_BOLT,
				SpellBaseDamageConfig.FIRE_STRIKE,
				SpellBaseDamageConfig.FIRE_SURGE,
				SpellBaseDamageConfig.FIRE_WAVE
			)))
		)
	);


	private static final Map<BonusType, ArrayList<EquipmentBonusConfig>> bonusTypes = new HashMap<>();

	static
	{
		for (EquipmentBonusConfig equipmentBonus : values())
		{
			BonusType bonusType = equipmentBonus.bonusType;
			if (!bonusTypes.containsKey(bonusType))
			{
				bonusTypes.put(bonusType, new ArrayList<>());
			}
			ArrayList<EquipmentBonusConfig> list = bonusTypes.get(bonusType);
			list.add(equipmentBonus);
			bonusTypes.put(bonusType, list);
		}
	}

	private final EquipmentItemset itemset;
	private BonusType bonusType;
	private EquipmentCombatBonus equipmentCombatBonus;
	private List<Requirement> requirements = new ArrayList<>();
	private Operation operation = Operation.MULTIPLY;

	EquipmentBonusConfig(BonusType bonusType, EquipmentItemset itemset, EquipmentCombatBonus equipmentCombatBonus)
	{
		this.bonusType = bonusType;
		this.itemset = itemset;
		this.equipmentCombatBonus = equipmentCombatBonus;
	}

	EquipmentBonusConfig(BonusType bonusType, EquipmentItemset itemset, EquipmentCombatBonus equipmentCombatBonus, List<Requirement> requirements)
	{
		this.bonusType = bonusType;
		this.itemset = itemset;
		this.equipmentCombatBonus = equipmentCombatBonus;
		this.requirements = requirements;
	}

	EquipmentBonusConfig(BonusType bonusType, EquipmentItemset itemset, EquipmentCombatBonus equipmentCombatBonus, List<Requirement> requirements, Operation operation)
	{
		this.bonusType = bonusType;
		this.itemset = itemset;
		this.equipmentCombatBonus = equipmentCombatBonus;
		this.requirements = requirements;
		this.operation = operation;
	}

	public static List<EquipmentBonusConfig> getBonusByType(BonusType bonusType)
	{
		if (!bonusTypes.containsKey(bonusType))
		{
			return new ArrayList<>();
		}
		return bonusTypes.get(bonusType);
	}

	public EquipmentItemset getItemset()
	{
		return itemset;
	}

	public Operation getOperation()
	{
		return operation;
	}

	public double getBonus(MaxHitCalculator.CombatMethod combatMethod)
	{
		return this.equipmentCombatBonus.getCombatBonus(combatMethod);
	}

	public boolean meetsRequirements(Client client)
	{
		return requirements.stream().allMatch(requirement -> requirement.meetsRequirements(client));
	}

	public enum BonusType
	{
		EQUIPMENT,
		SLAYER,
		VOID_KNIGHT,
		SPECIAL,
		MAGIC_SPECIAL
	}

	public enum Operation
	{
		ADD,
		MULTIPLY
	}

}

