package net.runelite.client.plugins.maxhit.config;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlot;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum CustomFormulaConfig {
    MAGIC_DART(
            MaxHitCalculator.CombatMethod.MAGIC,
            new EquipmentItemset(Collections.singletonList(
                new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Slayer's staff")
            )),
            Collections.singletonList(SpellConfig.MAGIC_DART),
            (client, calculator) -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
                return Math.floor((magicLevel / 10.0) + 10.0);
            }
    ),

    DHAROK(
            MaxHitCalculator.CombatMethod.MELEE,
            new EquipmentItemset(Arrays.asList(
                    new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "dharok")
            )),
            null,
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
    private final EquipmentItemset requiredItemSet;
    private final List<SpellConfig> requiredSpells;
    private final BiFunction<Client, MaxHitCalculator, Double> customFormula;

    CustomFormulaConfig(MaxHitCalculator.CombatMethod requiredCombatMethod, EquipmentItemset requiredItemSet, List<SpellConfig> requiredSpells, BiFunction<Client, MaxHitCalculator, Double> customFormula) {
        this.requiredCombatMethod = requiredCombatMethod;
        this.requiredItemSet = requiredItemSet;
        this.requiredSpells = requiredSpells;
        this.customFormula = customFormula;
    }

    public MaxHitCalculator.CombatMethod getRequiredCombatMethod() {
        return requiredCombatMethod;
    }

    public EquipmentItemset getRequiredItemSet() {
        return requiredItemSet;
    }

    public List<SpellConfig> getRequiredSpells() {
        return requiredSpells;
    }

    public BiFunction<Client, MaxHitCalculator, Double> getCustomFormula() {
        return customFormula;
    }


}
