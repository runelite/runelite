package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;

public class MeleeMaxHitCalculator extends MaxHitCalculator {

    public MeleeMaxHitCalculator(Client client, Item[] equipedItems) {
        super(client, equipedItems);
    }

    @Override
    protected CombatMethod getCombatMethod(){
        return CombatMethod.MELEE;
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

    @Override
    protected double calculateDefault() {

        double equipmentBonus = this.getBonus(EquipmentCombatBonus::getCombatEquipmentBonus);
        double effectiveBonus = this.getBonus(equipmentCombatBonus -> equipmentCombatBonus.getCombatEffectiveBonus(this.getCombatMethod()));
        double slayerBonus = this.getBonus(combatEquipmentBonus -> combatEquipmentBonus.getCombatSlayerBonus(this.getCombatMethod()));

//         TODO replace 1.000000 with prayer bonus
        double effectiveStrength = Math.floor((Math.floor(this.getCurrentSkillPower() * 1.000000) + 11) * effectiveBonus);

        double maxHit = Math.floor((0.5 + effectiveStrength * (this.getSkillStrength() + 64) / 640) * slayerBonus);
        maxHit = Math.floor(maxHit * equipmentBonus);

        return maxHit;
    }
}


