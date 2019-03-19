package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.attackstyle.AttackStyle;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;

public class MeleeMaxHitCalculator extends MaxHitCalculator {

    public MeleeMaxHitCalculator(Client client, Item[] equipedItems) {
        super(client, CombatMethod.MELEE, equipedItems);
    }

    @Override
    protected String getSkillStrengthText(String equipmentText) {
        return equipmentText.replace("Melee strength: ", "");
    }

    @Override
    public Widget equipmentSkillPower() {
        return this.client.getWidget(WidgetInfo.EQUIPMENT_MELEE_STRENGTH);
    }

    @Override
    public double getCurrentSkillPower() {
        return this.client.getRealSkillLevel(Skill.STRENGTH);
    }

    private double getEffectiveLevel() {
//      a. Take the visible strength or ranged level from the skills interface.
        double skillPower = this.getCurrentSkillPower();

//      b. Multiply the level by the prayer adjustment
        double effectiveLevel = skillPower * this.getPrayerBonus();

//      c. Round down to the nearest integer.
        effectiveLevel = Math.floor(effectiveLevel);

//      d. Add the stance bonus from the combat options interface.
//        Melee:
//        • Aggressive: +3
//        • Controlled: +1
//        Ranged:
//        * Accurate: +3
        AttackStyle attackStyle = this.getAttackStyle();
        effectiveLevel += attackStyle.getMaxHitBonus();

//      e. Add up +8.
        effectiveLevel += 8;

//      f.  Multiply by the void bonus:
//      • Void melee: multiply by 1.10. Round down.
//      • Void ranged: multiply by 1.10. Round down.
//      • Elite void ranged: multiply by 1.125. Round down.


//      g. This is the effective (ranged) strength level. Let this equal 'A' in the formula in
        return effectiveLevel;
    }

//  3.3 Take the melee or ranged strength bonus from the equipment stats interface and let this equal 'B' in the formula in 3.1.
    private double getEquipmentBonus() {
        return this.getSkillStrength();
    }

    /*
     * Damage formula based on:
     * http://services.runescape.com/m=forum/forums.ws?317,318,712,65587452
     * Section 3.1
     * */
    @Override
    protected double calculateDefault() {

//      a. Max hit = 0.5 + A * (B+64) /640 (A is effective level, B is Equipment bonus)
        double maxHit = 0.5 + this.getEffectiveLevel() * (this.getEquipmentBonus() + 64) / 640;

//      b. Round down the max hit to the nearest integer.
        maxHit = Math.floor(maxHit);

//      3.4 Special attacks (not actually taking weapon special attacks into account)
//      a. Multiply by the bonus of one of the following items (slayer)
        double slayerBonus = this.getEquipmentBonus(EquipmentBonusConfig.BonusType.SLAYER);
        maxHit = maxHit * slayerBonus;

//      b. Round down the max hit to the nearest integer.
        maxHit = Math.floor(maxHit);

//      c. Multiply by the bonus of one of the following items
        double specialBonus = this.getEquipmentBonus(EquipmentBonusConfig.BonusType.SPECIAL);
        maxHit = maxHit * specialBonus;

        return maxHit;
    }
}


