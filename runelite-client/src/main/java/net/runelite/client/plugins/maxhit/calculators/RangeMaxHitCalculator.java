//package net.runelite.client.plugins.maxhit.calculators;
//
//public class RangeMaxHitCalculator implements MaxHitCalculator {
//
//    @Override
//    public double calculate() {
//        double equipmentRangedStrength = Double.parseDouble(widget.getText().replace("Ranged strength: ", ""));
//        double effectiveRangedStrength = Math.floor((Math.floor(currentStat * prayerBonus) + 8) * SetBoosts.find(set).getVoidRange());
//        maxHit = Math.floor((0.5 + effectiveRangedStrength * (equipmentRangedStrength + 64) / 640) * SetBoosts.find(set).getSlayerRange());
//        maxHit = Math.floor(maxHit * multiplier);
//
//        return 0.0;
//    }
//}
