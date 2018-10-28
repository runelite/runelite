package net.runelite.api;

public enum Boss
{
    CORPOREAL_BEAST("Corporeal Beast"),
    TZTOK_JAD("TzTok-Jad"),
    KALPHITE_QUEEN("Kalphite Queen"),
    CHAOS_ELEMENTAL("Chaos Elemental"),
    GROTESQUE_GUARDIANS("Grotesque Guardians"),
    CRAZY_ARCHEOLOGIST("Crazy Archaeologist"),
    DERANGED_ARCHEOLOGIST("Deranged Archaeologist"),
    GIANT_MOLE("Giant Mole"),
    VETION("Vet'ion"),
    VENENATIS("Venenatis"),
    KING_BLACK_DRAGON("King Black Dragon"),
    VORKATH("Vorkath"),
    ABYSSAL_SIRE("Abyssal Sire"),
    THERMONUCLEAR_SMOKE_DEVIL("Thermonuclear Smoke Devil"),
    CERBERUS("Cerberus"),
    TZKAL_ZUK("TzKal-Zuk"),
    COMMANDER_ZILYANA("Commander Zilyana"),
    KRIL_TSUTSAROTH("K'ril Tsutsaroth"),
    KREEARRA("Kree'arra"),
    GENERAL_GRAARDOR("General Graardor"),
    DAGANNOTH_SUPREME("Dagannoth Supreme"),
    DAGANNOTH_REX("Dagannoth Rex"),
    DAGANNOTH_PRIME("Dagannoth Prime"),
    WINTERTODT("Wintertodt"),
    BARROWS("Barrows Chests"),
    CHAMBERS_OF_XERIC("Chambers of Xeric"),
    THEATRE_OF_BLOOD("Theatre of Blood");

    private final String name;

    Boss(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name of the boss.
     *
     * @return the boss name
     */
    public String getName()
    {
        return name;
    }
}
