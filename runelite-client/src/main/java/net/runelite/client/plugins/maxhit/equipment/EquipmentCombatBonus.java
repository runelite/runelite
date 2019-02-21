package net.runelite.client.plugins.maxhit.equipment;

import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;

public class EquipmentCombatBonus {

    private final double meleeBonus;
    private final double rangeBonus;
    private final double magicBonus;

    public EquipmentCombatBonus(double meleeBonus, double rangeBonus, double magicBonus) {
        this.meleeBonus = meleeBonus;
        this.rangeBonus = rangeBonus;
        this.magicBonus = magicBonus;
    }

    public double getCombatBonus(MaxHitCalculator.CombatMethod combatMethod) {
        switch (combatMethod) {
            default:
            case MELEE:
                return this.meleeBonus;
            case RANGE:
                return this.rangeBonus;
            case MAGIC:
                return this.magicBonus;
        }
    }

}
