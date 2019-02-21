package net.runelite.client.plugins.maxhit.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum SpellConfig {

    /*
    * Normal Spellbook
    * */
    AIR_STRIKE(SpellBook.NORMAL, 1, 2),
    WATER_STRIKE(SpellBook.NORMAL, 2, 4),
    EARTH_STRIKE(SpellBook.NORMAL, 3, 6),
    FIRE_STRIKE(SpellBook.NORMAL, 4, 8, Collections.singletonList(BonusSpellTypes.FIRE)),

    AIR_BOLT(SpellBook.NORMAL, 5, 9, Collections.singletonList(BonusSpellTypes.BOLT)),
    WATER_BOLT(SpellBook.NORMAL, 6, 10, Collections.singletonList(BonusSpellTypes.BOLT)),
    EARTH_BOLT(SpellBook.NORMAL, 7, 11, Collections.singletonList(BonusSpellTypes.BOLT)),
    FIRE_BOLT(SpellBook.NORMAL, 8, 12, Arrays.asList(BonusSpellTypes.BOLT, BonusSpellTypes.FIRE)),

    AIR_BLAST(SpellBook.NORMAL, 9, 13),
    WATER_BLAST(SpellBook.NORMAL, 10, 14),
    EARTH_BLAST(SpellBook.NORMAL, 11, 15),
    FIRE_BLAST(SpellBook.NORMAL, 12, 16, Collections.singletonList(BonusSpellTypes.FIRE)),

    AIR_WAVE(SpellBook.NORMAL, 13, 17),
    WATER_WAVE(SpellBook.NORMAL, 14, 18),
    EARTH_WAVE(SpellBook.NORMAL, 15, 19),
    FIRE_WAVE(SpellBook.NORMAL, 16, 20, Collections.singletonList(BonusSpellTypes.FIRE)),

    AIR_SURGE(SpellBook.NORMAL, 17, 21),
    WATER_SURGE(SpellBook.NORMAL, 18, 22),
    EARTH_SURGE(SpellBook.NORMAL, 19, 23),
    FIRE_SURGE(SpellBook.NORMAL, 20, 24, Collections.singletonList(BonusSpellTypes.FIRE)),

    /*
    * Ancient Spellbook
    * */
    SMOKE_RUSH(SpellBook.ANCIENT, 31, 14),
    SHADOW_RUSH(SpellBook.ANCIENT, 32, 15),
    BLOOD_RUSH(SpellBook.ANCIENT, 33, 16),
    ICE_RUSH(SpellBook.ANCIENT, 34, 17),

    SMOKE_BURST(SpellBook.ANCIENT, 35, 18),
    SHADOW_BURST(SpellBook.ANCIENT, 36, 19),
    BLOOD_BURST(SpellBook.ANCIENT, 37, 21),
    ICE_BURST(SpellBook.ANCIENT, 38, 22),

    SMOKE_BLITZ(SpellBook.ANCIENT, 39, 23),
    SHADOW_BLITZ(SpellBook.ANCIENT, 40, 24),
    BLOOD_BLITZ(SpellBook.ANCIENT, 41, 25),
    ICE_BLITZ(SpellBook.ANCIENT, 42, 26),

    SMOKE_BARRAGE(SpellBook.ANCIENT, 43, 27),
    SHADOW_BARRAGE(SpellBook.ANCIENT, 44, 28),
    BLOOD_BARRAGE(SpellBook.ANCIENT, 55, 29),
    ICE_BARRAGE(SpellBook.ANCIENT, 46, 30),

    /*
    * Other spells
    * */
    CRUMBLE_UNDEAD(SpellBook.OTHER, 17, 15),
    IBAN_BLAST(SpellBook.OTHER, 47, 25),
    FLAMES_OF_ZAMAROK(SpellBook.OTHER, 18, 20, Collections.singletonList(BonusSpellTypes.GOD)),
    CLAWS_OF_GUTHIX(SpellBook.OTHER, 19, 20, Collections.singletonList(BonusSpellTypes.GOD)),

    /*
    * Custom Formula spells
    * */
    MAGIC_DART(SpellBook.OTHER, 18, 0);

    public enum SpellBook {
        NORMAL,
        ANCIENT,
        OTHER
    }

    private enum Operations {
        ADD,
        MULTIPLY
    }

    public enum BonusSpellTypes {

        BOLT(3, Operations.ADD),
        FIRE(1.5, Operations.MULTIPLY, true),
        GOD(10, Operations.ADD);

        private final double bonusDamage;
        private final Operations operation;
        private boolean afterEquipment = false;

        BonusSpellTypes(double bonusDamage, Operations operation) {
            this.bonusDamage = bonusDamage;
            this.operation = operation;
        }

        BonusSpellTypes(double bonusDamage, Operations operation, boolean afterEquipment) {
            this.bonusDamage = bonusDamage;
            this.operation = operation;
            this.afterEquipment = afterEquipment;
        }

        public double applyBonus(double inputDamage) {
            if(this.operation == Operations.ADD) {
                return inputDamage + this.bonusDamage;
            } else if(this.operation == Operations.MULTIPLY) {
                return inputDamage * this.bonusDamage;
            } else {
                return inputDamage;
            }
        }

        public boolean getAfterEquipment() {
            return this.afterEquipment;
        }
    }

    private SpellBook spellBook;
    private int spellID;
    private int baseDamage;
    private List<BonusSpellTypes> bonusSpellTypes = new ArrayList<>();

    SpellConfig(SpellBook spellBook, int spellID, int baseDamage, List<BonusSpellTypes> bonusSpellTypes) {
        this.spellBook = spellBook;
        this.spellID = spellID;
        this.baseDamage = baseDamage;
        this.bonusSpellTypes = bonusSpellTypes;
    }

    SpellConfig(SpellBook spellBook, int spellID, int baseDamage) {
        this.spellBook = spellBook;
        this.spellID = spellID;
        this.baseDamage = baseDamage;
    }

    public int getSpellID() {
        return spellID;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public List<BonusSpellTypes> getBonusSpellTypes() {
        return bonusSpellTypes;
    }

    public SpellBook getSpellBook() {
        return spellBook;
    }

    public static SpellConfig findSpellById(int spellID){
        return Arrays.stream(values()).filter(spell -> spell.getSpellID() == spellID).findFirst().orElse(null);
    }
}
