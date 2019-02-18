package net.runelite.client.plugins.maxhit.config;

public enum SpellConfig {


    AIR_STRIKE(1, 2),
    WATER_STRIKE(2, 4),
    EARTH_STRIKE(3, 6),
    FIRE_STRIKE(4, 8),

    AIR_BOLT(5, 9),
    WATER_BOLT(6, 10),
    EARTH_BOLT(7, 11),
    FIRE_BOLT(8, 12),

    AIR_BLAST(9, 13),
    WATER_BLAST(10, 14),
    EARTH_BLAST(11, 15),
    FIRE_BLAST(12, 16),

    AIR_WAVE(13, 17),
    WATER_WAVE(14, 18),
    EARTH_WAVE(15, 19),
    FIRE_WAVE(16, 20),

    AIR_SURGE(17, 21),
    WATER_SURGE(18, 22),
    EARTH_SURGE(19, 23),
    FIRE_SURGE(20, 24),

    SMOKE_RUSH(1, 14),
    SHADOW_RUSH(1, 15),
    BLOOD_RUSH(1, 16),
    ICE_RUSH(1, 17),

    SMOKE_BURST(1, 18),
    SHADOW_BURST(1, 19),
    BLOOD_BURST(1, 21),
    ICE_BURST(1, 22),

    SMOKE_BLITZ(1, 23),
    SHADOW_BLITZ(1, 24),
    BLOOD_BLITZ(1, 25),
    ICE_BLITZ(1, 26),

    SMOKE_BARRAGE(1, 27),
    SHADOW_BARRAGE(1, 28),
    BLOOD_BARRAGE(1, 29),
    ICE_BARRAGE(1, 30),

    /*
    * Other spells
    * */
    CRUMBLE_UNDEAD(17, 15),
    IBAN_BLAST(1, 25),
    SARADOMIN_STRIKE(1, 20),
    CLAWS_OF_GUTHIX(1, 20),
    FLAMES_OF_ZAMAROK(1, 20),

    /*
    * Custom Formula spells
    * */
    MAGIC_DART(18, 0);

    private int spellID;

    SpellConfig(int spellID, int baseMaxHit) {

        this.spellID = spellID;
    }

    public int getSpellID() {
        return spellID;
    }
}
