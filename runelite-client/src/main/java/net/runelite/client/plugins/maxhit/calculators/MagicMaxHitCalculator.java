package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;

public class MagicMaxHitCalculator extends MaxHitCalculator {

    public MagicMaxHitCalculator(Client client, Item[] equipedItems) {
        super(client, equipedItems);
    }

    @Override
    protected String getSkillStrengthText(String equipmentText) {
        return equipmentText.replace("Magic damage: ", "").replace(".", "").replace("%", "");
    }

    @Override
    Widget equipmentSkillPower() {
        return this.client.getWidget(WidgetInfo.EQUIPMENT_MAGIC_DAMAGE);
    }

    @Override
    public double getCurrentSkillPower() {
        return this.client.getRealSkillLevel(Skill.MAGIC);
    }

    @Override
    protected CombatMethod getCombatMethod() {
        return CombatMethod.MAGIC;
    }

    @Override
    protected double calculateDefault() {
        double equipmentBonus = this.getBonus(EquipmentCombatBonus::getCombatEquipmentBonus);
        double slayerBonus = this.getBonus(combatEquipmentBonus -> combatEquipmentBonus.getCombatSlayerBonus(this.getCombatMethod()));
        double effectiveBonus = this.getBonus(equipmentCombatBonus -> equipmentCombatBonus.getCombatEffectiveBonus(this.getCombatMethod()));

        double maxHit = Math.floor(((Math.floor(this.getCurrentSkillPower() / 3) - effectiveBonus) * ( 1 + (this.getSkillStrength() / 1000))) * slayerBonus);
        maxHit = Math.floor(maxHit * equipmentBonus);

        return maxHit;
    }
}
