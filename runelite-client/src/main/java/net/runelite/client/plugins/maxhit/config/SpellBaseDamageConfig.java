package net.runelite.client.plugins.maxhit.config;

import java.util.Arrays;

public enum SpellBaseDamageConfig {

    /*
    * Normal Spellbook
    * */
    AIR_STRIKE(SpellBook.NORMAL, 1, 2),
    WATER_STRIKE(SpellBook.NORMAL, 2, 4),
    EARTH_STRIKE(SpellBook.NORMAL, 3, 6),
    FIRE_STRIKE(SpellBook.NORMAL, 4, 8),

    AIR_BOLT(SpellBook.NORMAL, 5, 9),
    WATER_BOLT(SpellBook.NORMAL, 6, 10),
    EARTH_BOLT(SpellBook.NORMAL, 7, 11),
    FIRE_BOLT(SpellBook.NORMAL, 8, 12),

    AIR_BLAST(SpellBook.NORMAL, 9, 13),
    WATER_BLAST(SpellBook.NORMAL, 10, 14),
    EARTH_BLAST(SpellBook.NORMAL, 11, 15),
    FIRE_BLAST(SpellBook.NORMAL, 12, 16),

    AIR_WAVE(SpellBook.NORMAL, 13, 17),
    WATER_WAVE(SpellBook.NORMAL, 14, 18),
    EARTH_WAVE(SpellBook.NORMAL, 15, 19),
    FIRE_WAVE(SpellBook.NORMAL, 16, 20),

    AIR_SURGE(SpellBook.NORMAL, 17, 21),
    WATER_SURGE(SpellBook.NORMAL, 18, 22),
    EARTH_SURGE(SpellBook.NORMAL, 19, 23),
    FIRE_SURGE(SpellBook.NORMAL, 20, 24),

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
    FLAMES_OF_ZAMAROK(SpellBook.OTHER, 18, 20),
    CLAWS_OF_GUTHIX(SpellBook.OTHER, 19, 20),
    SARADOMIN_STRIKE(SpellBook.OTHER, 20, 20),

    /*
    * Custom Formula spells
    * */
    MAGIC_DART(SpellBook.OTHER, 18, 0);

    public enum SpellBook {
        NORMAL,
        ANCIENT,
        OTHER
    }

    private final SpellBook spellBook;
    private final int spellID;
    private final int baseDamage;

    SpellBaseDamageConfig(SpellBook spellBook, int spellID, int baseDamage) {
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

    public SpellBook getSpellBook() {
        return spellBook;
    }

    public static SpellBaseDamageConfig findSpellById(int spellID){
        return Arrays.stream(values()).filter(spell -> spell.getSpellID() == spellID).findFirst().orElse(null);
    }
}
