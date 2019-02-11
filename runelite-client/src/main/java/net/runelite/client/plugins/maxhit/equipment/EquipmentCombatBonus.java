package net.runelite.client.plugins.maxhit.equipment;

import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;

public class EquipmentCombatBonus {


    private final double equipmentBonus;
    private final double meleeEffectiveBonus;
    private final double rangeEffectiveBonus;
    private final double magicEffectiveBonus;
    private final double meleeSlayerBonus;
    private final double rangeSlayerBonus;
    private final double magicSlayerBonus;

    public EquipmentCombatBonus(double equipmentBonus, double meleeEffectiveBonus, double rangeEffectiveBonus, double magicEffectiveBonus, double meleeSlayerBonus, double rangeSlayerBonus, double magicSlayerBonus) {
        this.equipmentBonus = equipmentBonus;
        this.meleeEffectiveBonus = meleeEffectiveBonus;
        this.rangeEffectiveBonus = rangeEffectiveBonus;
        this.magicEffectiveBonus = magicEffectiveBonus;

        this.meleeSlayerBonus = meleeSlayerBonus;
        this.rangeSlayerBonus = rangeSlayerBonus;
        this.magicSlayerBonus = magicSlayerBonus;
    }

    public double getCombatEquipmentBonus() {
        return equipmentBonus;
    }

    public double getCombatEffectiveBonus(MaxHitCalculator.CombatMethod combatMethod) {
        switch (combatMethod) {
            default:
            case MELEE:
                return this.getMeleeEffectiveBonus();
            case RANGE:
                return this.getRangeEffectiveBonus();
            case MAGIC:
                return this.getMagicEffectiveBonus();
        }
    }


    public double getCombatSlayerBonus(MaxHitCalculator.CombatMethod combatMethod) {
        switch (combatMethod) {
            default:
            case MELEE:
                return this.getMeleeSlayerBonus();
            case RANGE:
                return this.getRangeSlayerBonus();
            case MAGIC:
                return this.getMagicSlayerBonus();
        }
    }

    public double getMeleeSlayerBonus() {
        return meleeSlayerBonus;
    }

    public double getRangeSlayerBonus() {
        return rangeSlayerBonus;
    }

    public double getMagicSlayerBonus() {
        return magicSlayerBonus;
    }

    public double getMeleeEffectiveBonus() {
        return meleeEffectiveBonus;
    }

    public double getRangeEffectiveBonus() {
        return rangeEffectiveBonus;
    }

    public double getMagicEffectiveBonus() {
        return magicEffectiveBonus;
    }

}
