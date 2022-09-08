package net.runelite.client.plugins.externals.utils;

public enum Tab {
    COMBAT(4675),
    EXP(4676),
    QUESTS(4677),
    INVENTORY(4678),
    EQUIPMENT(4679),
    PRAYER(4680),
    SPELLBOOK(4682),
    CLAN(4683),
    FRIENDS(4684),
    SETTINGS(4686),
    EMOTES(4687),
    MUSIC(4688),
    LOGOUT(4689),
    ACCOUNT(6517);

    Tab(int varbit) {
        this.varbit = varbit;
    }

    private final int varbit;

    public int getVarbit() {
        return this.varbit;
    }
}