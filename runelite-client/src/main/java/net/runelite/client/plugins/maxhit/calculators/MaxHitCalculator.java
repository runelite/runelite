package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;
import net.runelite.client.plugins.maxhit.config.PrayerBonusConfig;
import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;
import net.runelite.client.plugins.maxhit.equipment.EquipmentHelper;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class MaxHitCalculator {

    Client client;
    private Item[] equipedItems;
    double prayerBonus;

    public enum CombatMethod {
        MELEE,
        RANGE,
        MAGIC
    }

    public MaxHitCalculator(Client client, Item[] equipedItems, PrayerBonusConfig prayer) {
        this.client = client;
        this.equipedItems = equipedItems;
        this.prayerBonus = prayer.getBonus();
    }

    protected abstract String getSkillStrengthText();

    abstract Widget equipmentSkillPower();

    public abstract double currentSkillPower();

    public abstract ArrayList<EquipmentBonusConfig> getBonusItemSets();

    public double getBonus(Function<EquipmentCombatBonus, Double> bonusExtractor){
        ArrayList<EquipmentBonusConfig> itemSets = this.getBonusItemSets();
        double bonus = 1;
        for(EquipmentBonusConfig itemSetMultiplier: itemSets) {
            List<EquipmentSlotItem> items = itemSetMultiplier.getItemset().getItems();
            boolean wearsSet = EquipmentHelper.wearsItemSet(this.client, this.equipedItems, items);
            if(wearsSet) {
                bonus += bonusExtractor.apply(itemSetMultiplier.getEquipmentCombatBonus());
            }
        }
        return bonus;
    }

    public abstract double calculate();

    double getSkillStrength() {
        return Double.parseDouble(this.equipmentSkillPower().getText().replace(this.getSkillStrengthText(), ""));
    }

    private boolean contains(int slot, String string, Item[] equip)
    {
        return client.getItemDefinition(equip[slot].getId()).getName().toLowerCase().contains(string);
    }
}
