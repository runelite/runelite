package net.runelite.client.plugins.maxhit.config;

import net.runelite.api.Client;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlot;
import net.runelite.client.plugins.maxhit.equipment.EquipmentSlotItem;
import net.runelite.client.plugins.maxhit.requirements.AutocastSpellRequirement;
import net.runelite.client.plugins.maxhit.requirements.EquipmentItemRequirement;
import net.runelite.client.plugins.maxhit.requirements.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum SpellBonus {
    CHAOS_GAUNTLETS(3, Operation.ADD,  new ArrayList<>(Collections.singletonList(
            new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
                    SpellBaseDamageConfig.AIR_BOLT,
                    SpellBaseDamageConfig.WATER_BOLT,
                    SpellBaseDamageConfig.EARTH_BOLT,
                    SpellBaseDamageConfig.FIRE_BOLT
            )))
    ))),
    TOME_OF_FIRE(1.5, Operation.MULTIPLY, new ArrayList<>(Arrays.asList(
            new EquipmentItemRequirement(new EquipmentSlotItem(EquipmentSlot.SHIELD_SLOT, "Tome of fire")),
            new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
                SpellBaseDamageConfig.FIRE_BLAST,
                SpellBaseDamageConfig.FIRE_BOLT,
                SpellBaseDamageConfig.FIRE_STRIKE,
                SpellBaseDamageConfig.FIRE_SURGE,
                SpellBaseDamageConfig.FIRE_WAVE
            ))
    ))), true),
    CHARGE(10, Operation.ADD,  new ArrayList<>(Collections.singletonList(
        new AutocastSpellRequirement(new ArrayList<>(Arrays.asList(
            SpellBaseDamageConfig.FLAMES_OF_ZAMAROK,
            SpellBaseDamageConfig.CLAWS_OF_GUTHIX,
            SpellBaseDamageConfig.SARADOMIN_STRIKE
        )))
    )));

    private final double bonusDamage;
    private final Operation operation;
    private final ArrayList<Requirement> requirement;
    private boolean afterEquipment = false;

    public boolean getAfterEquipment() {
        return this.afterEquipment;
    }

    private enum Operation {
        ADD,
        MULTIPLY
    }

    SpellBonus(double bonusDamage, Operation operation, ArrayList<Requirement> requirement) {
        this.bonusDamage = bonusDamage;
        this.operation = operation;
        this.requirement = requirement;
    }

    SpellBonus(double bonusDamage, Operation operation, ArrayList<Requirement> requirement, boolean afterEquipment) {
        this.bonusDamage = bonusDamage;
        this.operation = operation;
        this.requirement = requirement;
        this.afterEquipment = afterEquipment;
    }

    public static ArrayList<SpellBonus> getMeetsRequirements(Client client) {
        ArrayList<SpellBonus> result = new ArrayList<>();

        for(SpellBonus spellBonus: values()) {
            boolean meetsRequirements = true;
            for(Requirement requirement : spellBonus.requirement) {
                if(!requirement.meetsRequirements(client)) {
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
