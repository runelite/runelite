package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.maxhit.config.CustomFormulaConfig;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;
import net.runelite.client.plugins.maxhit.config.SpellConfig;
import net.runelite.client.plugins.maxhit.equipment.EquipmentCombatBonus;
import net.runelite.client.plugins.maxhit.equipment.EquipmentHelper;
import net.runelite.client.plugins.maxhit.equipment.EquipmentItemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public abstract class MaxHitCalculator {

    Client client;
    private Item[] equipedItems;

    public enum CombatMethod {
        MELEE,
        RANGE,
        MAGIC
    }

    public MaxHitCalculator(Client client, Item[] equipedItems) {
        this.client = client;
        this.equipedItems = equipedItems;
    }

    protected abstract String getSkillStrengthText(String equipmentText);

    abstract Widget equipmentSkillPower();

    public abstract double getCurrentSkillPower();

    private ArrayList<EquipmentBonusConfig> getBonusItemSets() {
        return new ArrayList<>(Arrays.asList(EquipmentBonusConfig.values()));
    }

    public double getBonus(Function<EquipmentCombatBonus, Double> bonusExtractor){
        ArrayList<EquipmentBonusConfig> itemSets = this.getBonusItemSets();
        double bonus = 1;
        for(EquipmentBonusConfig itemSetMultiplier: itemSets) {

            EquipmentItemset items = itemSetMultiplier.getItemset();

            boolean wearsSet = EquipmentHelper.wearsItemSet(this.client, this.equipedItems, items);

            if(wearsSet) {
                bonus += bonusExtractor.apply(itemSetMultiplier.getEquipmentCombatBonus());
            }
        }
        return bonus;
    }

    public double calculate() {
        Function<Client, Double> customFormula = this.getCustomFormula();
        if(customFormula != null){
            return customFormula.apply(this.client);
        }

        return this.calculateDefault();
    }

    protected abstract CombatMethod getCombatMethod();

    private Function<Client, Double> getCustomFormula() {
        for(CustomFormulaConfig customFormula: CustomFormulaConfig.values()) {
            if(this.getCombatMethod() != customFormula.getRequiredCombatMethod()){
                continue;
            }

            boolean wearsSet = EquipmentHelper.wearsItemSet(this.client, this.equipedItems, customFormula.getRequiredItemSet());
            boolean isCastingSpell = this.isCastingSpell(customFormula.getRequiredSpells());
            if(wearsSet && isCastingSpell) {
                return customFormula.getCustomFormula();
            }
        }

        return null;
    }

    protected abstract double calculateDefault();

    private boolean isCastingSpell(List<SpellConfig> requiredSpells) {
        if(requiredSpells == null){
            return false;
        }
        int currentSpellId = client.getVar(Varbits.AUTO_CAST_SPELL);
        return requiredSpells.stream().anyMatch(spell -> spell.getSpellID() == currentSpellId);
    }

    double getSkillStrength() {
        return Double.parseDouble(this.getSkillStrengthText(this.equipmentSkillPower().getText()));
    }
}
