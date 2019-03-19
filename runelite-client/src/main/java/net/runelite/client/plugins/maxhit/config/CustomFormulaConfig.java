package net.runelite.client.plugins.maxhit.config;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.maxhit.requirements.Requirement;
import net.runelite.client.plugins.maxhit.requirements.EquipmentItemRequirement;
import net.runelite.client.plugins.maxhit.requirements.EquipmentItemSetRequirement;
import net.runelite.client.plugins.maxhit.requirements.SpellRequirement;
import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlot;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.BiFunction;

public enum CustomFormulaConfig {

    MAGIC_DART(
            MaxHitCalculator.CombatMethod.MAGIC,
            new ArrayList<>(Arrays.asList(
                    new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Slayer's staff")),
                    new SpellRequirement(SpellBaseDamageConfig.MAGIC_DART)
            )),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
                return Math.floor((magicLevel / 10.0) + 10.0);
            }
    ),

    TRIDENT_OF_SEAS(
            MaxHitCalculator.CombatMethod.MAGIC,
            new ArrayList<>(Collections.singletonList(
                new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Trident of the seas"))
            )),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);

                int baseDamage = (int) Math.floor(magicLevel / 3.0) - 5;
                calculator.setBaseDamage(baseDamage);

                return calculator.calculateDefault();
            }
    ),

    TRIDENT_OF_SWAMP(
            MaxHitCalculator.CombatMethod.MAGIC,
            new ArrayList<>(Collections.singletonList(
                new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Trident of the swamp"))
            )),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);

                int baseDamage = (int) Math.floor(magicLevel / 3.0) - 2;
                calculator.setBaseDamage(baseDamage);

                return calculator.calculateDefault();
            }
    ),

    SWAMP_LIZARD(
            MaxHitCalculator.CombatMethod.MAGIC,
            new ArrayList<>(Collections.singletonList(
                new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Swamp lizard"))
            )),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
                return Math.floor(0.5 + magicLevel * (64.0 + 56.0) / 640.0);
            }
    ),

    ORANGE_SALAMANDER(
            MaxHitCalculator.CombatMethod.MAGIC,
            new ArrayList<>(Collections.singletonList(
                new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Orange salamander"))
            )),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
                return Math.floor(0.5 + magicLevel * (64.0 + 59.0) / 640.0);
            }
    ),

    RED_SALAMANDER(
            MaxHitCalculator.CombatMethod.MAGIC,
            new ArrayList<>(Collections.singletonList(
                new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Red salamander"))
            )),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
                return Math.floor(0.5 + magicLevel * (64.0 + 77.0) / 640.0);
            }
    ),

    BLACK_SALAMANDER(
            MaxHitCalculator.CombatMethod.MAGIC,
            new ArrayList<>(Collections.singletonList(
                new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Black salamander"))
            )),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
                return Math.floor(0.5 + magicLevel * (64.0 + 92.0) / 640.0);
            }
    ),

    DHAROK(
            MaxHitCalculator.CombatMethod.MELEE,
            new ArrayList<>(Collections.singletonList(new EquipmentItemSetRequirement(new EquipmentItemset(Arrays.asList(
                    new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "dharok")
            ))))),
            (client, calculator) -> {
                int currentHP = client.getBoostedSkillLevel(Skill.HITPOINTS);
                int maxHP = client.getRealSkillLevel(Skill.HITPOINTS);
                int lostHP = maxHP - currentHP;

                double initialMaxHit = calculator.calculate();

                double multiplier = (1.0 + lostHP / 100.0 * maxHP / 100.0);

                return initialMaxHit * multiplier;
            }
    );

    private MaxHitCalculator.CombatMethod requiredCombatMethod;
    private ArrayList<Requirement> requirements;
    private final BiFunction<Client, MaxHitCalculator, Double> customFormula;

    CustomFormulaConfig(MaxHitCalculator.CombatMethod requiredCombatMethod, ArrayList<Requirement> requirements, BiFunction<Client, MaxHitCalculator, Double> customFormula) {
        this.requiredCombatMethod = requiredCombatMethod;
        this.requirements = requirements;
        this.customFormula = customFormula;
    }

    public MaxHitCalculator.CombatMethod getRequiredCombatMethod() {
        return requiredCombatMethod;
    }

    public BiFunction<Client, MaxHitCalculator, Double> getCustomFormula() {
        return customFormula;
    }

    public ArrayList<Requirement> getRequirements() {
        return this.requirements;
    }
}
