package net.runelite.client.plugins.easy.util;

public enum DuelingRingMode {
    DUEL_ARENA("Duel Arena"),
    CASTLE_WARS("Castle Wars"),
    CLAN_WARS("Clan Wars");

    private final String name;

    DuelingRingMode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
