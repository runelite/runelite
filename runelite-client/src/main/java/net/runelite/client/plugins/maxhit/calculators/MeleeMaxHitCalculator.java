package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;
import net.runelite.client.plugins.maxhit.config.PrayerBonusConfig;
import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;

import java.util.ArrayList;
import java.util.Arrays;

public class MeleeMaxHitCalculator extends MaxHitCalculator {

    public MeleeMaxHitCalculator(Client client, Item[] equipedItems, PrayerBonusConfig prayer) {
        super(client, equipedItems, prayer);
    }

    @Override
    protected String getSkillStrengthText() {
        return "Melee strength: ";
    }

    @Override
    public Widget equipmentSkillPower() {
        return this.client.getWidget(WidgetInfo.EQUIPMENT_MELEE_STRENGTH);
    }

    @Override
    public double currentSkillPower() {
        return this.client.getRealSkillLevel(Skill.STRENGTH);
    }


    @Override
    public ArrayList<EquipmentBonusConfig> getBonusItemSets(){
        return new ArrayList(Arrays.asList(
                EquipmentBonusConfig.BLACKMASK,
                EquipmentBonusConfig.BLACKMASKI,
                EquipmentBonusConfig.SLAYERHELM,
                EquipmentBonusConfig.SLAYERHELMI,
                EquipmentBonusConfig.ELITERANGERVOID,
                EquipmentBonusConfig.MELEEVOID,
                EquipmentBonusConfig.RANGERVOID,
                EquipmentBonusConfig.ELITERANGERVOID
        ));
    }

    @Override
    public double calculate() {
        double equipmentBonus = this.getBonus(EquipmentCombatBonus::getCombatEquipmentBonus);
        double effectiveBonus = this.getBonus(equipmentCombatBonus -> equipmentCombatBonus.getCombatEffectiveBonus(CombatMethod.MELEE));
        double slayerBonus = this.getBonus(equipmentCombatBonus -> equipmentCombatBonus.getCombatSlayerBonus(CombatMethod.MELEE));

        double effectiveStrength = Math.floor((Math.floor(currentSkillPower() * this.prayerBonus) + 11) * effectiveBonus);

        double maxHit = Math.floor((0.5 + effectiveStrength * (this.getSkillStrength() + 64) / 640) * slayerBonus);
        maxHit = Math.floor(maxHit * equipmentBonus);

        return maxHit;
    }
}
/*

        if (contains(HELM_SLOT, "dharok", equip) && contains(CHEST_SLOT, "dharok", equip) && contains(LEG_SLOT, "dharok", equip) && contains(WEAPON_SLOT, "dharok", equip))
        {
        maxHitText = maxHitText + " - " + maxHit.maxHit(meleeStrength, currentStrength, meleePrayerBonus, 1, dharokSetBoost);
        }
*/


