//package net.runelite.client.plugins.maxhit.calculators;
//
//public class MagicMaxHitCalculator implements MaxHitCalculator {
//
//    @Override
//    public double calculate() {
//        double equipmentMagicDamage = Double.parseDouble(widget.getText().replace("Magic damage: ", "").replace(".", "").replace("%", ""));
//        maxHit = Math.floor(((Math.floor(currentStat / 3) - i[0]) * ( 1 + ((equipmentMagicDamage) / 1000))) * SetBoosts.find(set).getSlayerRange());
//        maxHit = Math.floor(maxHit * multiplier);
//
//        return 0.0;
//    }
//}
