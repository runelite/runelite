package net.runelite.client.plugins.oddsoverlay;

import lombok.Getter;

public class OddsPlayer {

    @Getter
    private final int att;
    @Getter
    private final int str;
    @Getter
    private final int def;
    @Getter
    private final int hp;
    @Getter
    private final int range;

    public OddsPlayer(int att, int str, int def, int hp, int range) {
        this.att = att;
        this.str = str;
        this.def = def;
        this.hp = hp;
        this.range = range;
    }

}