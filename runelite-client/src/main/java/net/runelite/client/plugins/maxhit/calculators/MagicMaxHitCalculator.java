package net.runelite.client.plugins.maxhit.calculators;

import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.config.EquipmentBonusConfig;
import net.runelite.client.plugins.maxhit.config.SpellBaseDamageConfig;
import net.runelite.client.plugins.maxhit.config.SpellBonus;

import java.util.ArrayList;

public class MagicMaxHitCalculator extends MaxHitCalculator {

    public MagicMaxHitCalculator(Client client, Item[] equipedItems) {
        super(client, CombatMethod.MAGIC, equipedItems);
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

    /*
    * Damage formula based on:
    * http://services.runescape.com/m=forum/forums.ws?317,318,712,65587452
    * Section 4.
    * */
    @Override
    public double calculateDefault() {
        int spellBaseDamage = this.baseDamage;

        if(spellBaseDamage == 0) {
            int autoCastSpellId = client.getVar(Varbits.AUTO_CAST_SPELL);
            if(autoCastSpellId == 0) {
                return 0.0;
            }

            SpellBaseDamageConfig autoCastSpell = SpellBaseDamageConfig.findSpellById(autoCastSpellId);
            spellBaseDamage = autoCastSpell.getBaseDamage();
        }

//      a.Find the base maximum damage a spell can deal.
//      See CustomFormulaConfig for spells based on magic lvl
        double maxHit = spellBaseDamage;

//      b. Increase the base damage (God spells and Chaos Gauntlets)
        maxHit = this.getSpellBonus(maxHit, false);

//      c. The following bonuses stack by adding up. (List of bonus items)
        maxHit = maxHit * getEquipmentBonus(EquipmentBonusConfig.BonusType.EQUIPMENT);

//      d. Round down to the nearest integer.
        maxHit = Math.floor(maxHit);

//      e. On a slayer task, multiply by 1.15 (imbued)
        double slayerBonus = this.getEquipmentBonus(EquipmentBonusConfig.BonusType.SLAYER);
        maxHit = maxHit * slayerBonus;

//      f. Round down to the nearest integer.
        maxHit = Math.floor(maxHit);

//      g. If a fire spell is used, multiply by 1.5 (Tome of fire)
        maxHit = this.getSpellBonus(maxHit, true);

//      h. Round down to the nearest integer.
        maxHit = Math.floor(maxHit);

//      i, j. Castle Wars will not be included
        return maxHit;
    }

    private double getSpellBonus(double inputDamage, boolean afterEqupment) {
        ArrayList<SpellBonus> spellBonusses = SpellBonus.getMeetsRequirements(this.client);
        for(SpellBonus spellBonus: spellBonusses) {
            if(spellBonus.getAfterEquipment() == afterEqupment) {
                inputDamage = spellBonus.applyBonus(inputDamage);
            }
        }

        return inputDamage;
    }
}
