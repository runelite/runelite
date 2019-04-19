package net.runelite.client.plugins.easy.util;

public enum GamesNecklaceMode {
    BURTHORPE("Burthorpe"),
    BARBARIAN_OUTPOST("Barbarian Outpost"),
    CORPOREAL_BEAST("Corporeal Beast"),
    TEARS_OF_GUTHIX("Tears of Guthix"),
    WINTERTODT("Wintertodt Camp");

    private final String name;

    GamesNecklaceMode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
