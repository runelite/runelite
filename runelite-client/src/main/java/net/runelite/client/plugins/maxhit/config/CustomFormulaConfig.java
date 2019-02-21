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
import java.util.function.Function;

public enum CustomFormulaConfig {
    MAGIC_DART(
            MaxHitCalculator.CombatMethod.MAGIC,
            new EquipmentItemset(Collections.singletonList(
                new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "Slayer's staff")
            )),
            Collections.singletonList(SpellConfig.MAGIC_DART),
            client -> {
                int magicLevel = client.getRealSkillLevel(Skill.MAGIC);
                return Math.floor((magicLevel / 10.0) + 10.0);
            }
    ),

    DHAROCK(
            MaxHitCalculator.CombatMethod.MELEE,
            new EquipmentItemset(Arrays.asList(
                    new EquipmentSlotItem(EquipmentSlot.HELM_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.CHEST_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.LEG_SLOT, "dharok"),
                    new EquipmentSlotItem(EquipmentSlot.WEAPON_SLOT, "dharok")
            )),
            null,
            client -> {

                return 0.0;
            }
    );

    private MaxHitCalculator.CombatMethod requiredCombatMethod;
    private final EquipmentItemset requiredItemSet;
    private final List<SpellConfig> requiredSpells;
    private final Function<Client, Double> customFormula;

    CustomFormulaConfig(MaxHitCalculator.CombatMethod requiredCombatMethod, EquipmentItemset requiredItemSet, List<SpellConfig> requiredSpells, Function<Client, Double> customFormula) {
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

    public Function<Client, Double> getCustomFormula() {
        return customFormula;
    }


}
