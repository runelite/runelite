package net.runelite.client.plugins.maxhit.config;

import net.runelite.api.Varbits;
import net.runelite.client.plugins.maxhit.calculators.MaxHitCalculator;

public enum PrayerBonusConfig
{
    BURST_OF_STRENGTH(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_BURST_OF_STRENGTH, 0.05),
    SUPERHUMAN_STRENGTH(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_SUPERHUMAN_STRENGTH, 0.1),
    ULTIMATE_STRENGTH(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_ULTIMATE_STRENGTH, 0.15),
    CHIVALRY(MaxHitCalculator.CombatMethod.MELEE, Varbits.PRAYER_CHIVALRY, 0.18),

    PIETY(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_PIETY, 0.23),
    SHARP_EYE(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_SHARP_EYE, 0.05),
    HAWK_EYE(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_HAWK_EYE, 0.1),
    EAGLE_EYE(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_EAGLE_EYE, 0.15),
    RIGOUR(MaxHitCalculator.CombatMethod.RANGE, Varbits.PRAYER_RIGOUR, 0.23);

    private final MaxHitCalculator.CombatMethod combatMethod;
    private final Varbits prayerVarbit;
    private final double strengthBonus;

    PrayerBonusConfig(MaxHitCalculator.CombatMethod combatMethod, Varbits prayerVarbit, double strengthBonus) {
        this.combatMethod = combatMethod;
        this.prayerVarbit = prayerVarbit;
        this.strengthBonus = strengthBonus;
    }

    public MaxHitCalculator.CombatMethod getCombatMethod() {
        return combatMethod;
    }

    public Varbits getPrayerVarbit() {
        return prayerVarbit;
    }

    public double getStrengthBonus() {
        return strengthBonus;
    }
}