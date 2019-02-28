package net.runelite.client.plugins.maxhit.config;

import net.runelite.api.Client;
import net.runelite.client.plugins.maxhit.bonus.requirements.AutocastSpellRequirement;
import net.runelite.client.plugins.maxhit.bonus.requirements.BonusRequirement;
import net.runelite.client.plugins.maxhit.bonus.requirements.EquipmentRequirement;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlot;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum SpellBonus {
    CHAOS_GAUNTLETS(3, Operation.ADD,  new ArrayList<>(Collections.singletonList(
            new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
                    SpellConfig.AIR_BOLT,
                    SpellConfig.WATER_BOLT,
                    SpellConfig.EARTH_BOLT,
                    SpellConfig.FIRE_BOLT
            )))
    ))),
    TOME_OF_FIRE(1.5, Operation.MULTIPLY, new ArrayList<>(Arrays.asList(
            new EquipmentRequirement(new EquipmentSlotItem(EquipmentSlot.SHIELD_SLOT, "Tome of fire")),
            new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
                SpellConfig.FIRE_BLAST,
                SpellConfig.FIRE_BOLT,
                SpellConfig.FIRE_STRIKE,
                SpellConfig.FIRE_SURGE,
                SpellConfig.FIRE_WAVE
            ))
    ))), true),
    CHARGE(10, Operation.ADD,  new ArrayList<>(Collections.singletonList(
        new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
            SpellConfig.FLAMES_OF_ZAMAROK,
            SpellConfig.CLAWS_OF_GUTHIX,
            SpellConfig.SARADOMIN_STRIKE
        )))
    )));

    private double bonusDamage;
    private Operation operation;
    private ArrayList<BonusRequirement> bonusRequirement;
    private boolean afterEquipment = false;

    public boolean getAfterEquipment() {
        return this.afterEquipment;
    }

    private enum Operation {
        ADD,
        MULTIPLY
    }

    SpellBonus(double bonusDamage, Operation operation, ArrayList<BonusRequirement> bonusRequirement) {
        this.bonusDamage = bonusDamage;
        this.operation = operation;
        this.bonusRequirement = bonusRequirement;
    }

    SpellBonus(double bonusDamage, Operation operation, ArrayList<BonusRequirement> bonusRequirement, boolean afterEquipment) {
        this.bonusDamage = bonusDamage;
        this.operation = operation;
        this.bonusRequirement = bonusRequirement;
        this.afterEquipment = afterEquipment;
    }

    public static ArrayList<SpellBonus> getMeetsRequirements(Client client) {
        ArrayList<SpellBonus> result = new ArrayList<>();

        for(SpellBonus spellBonus: values()) {
            boolean meetsRequirements = true;
            for(BonusRequirement bonusRequirement: spellBonus.bonusRequirement) {
                if(!bonusRequirement.meetsRequirements(client)) {
                    meetsRequirements = false;
                }
            }

            if(meetsRequirements) {
                result.add(spellBonus);
            }
        }

        return result;
    }

    public double applyBonus(double inputDamage) {
        if(this.operation == Operation.ADD) {
            return inputDamage + this.bonusDamage;
        } else if(this.operation == Operation.MULTIPLY) {
            return inputDamage * this.bonusDamage;
        } else {
            return inputDamage;
        }
    }
}
