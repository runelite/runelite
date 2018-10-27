package net.runelite.api;

public enum Boss
{
    CORPOREALBEAST("Corporeal Beast"),
    TZTOKJAD("TzTok-Jad"),
    KALPHITEQUEEN("Kalphite Queen"),
    CHAOSELEMENTAL("Chaos Elemental"),
    GROTESQUEGUARDIANS("Grotesque Guardians"),
    CRAZYARCHEOLOGIST("Crazy Archaeologist"),
    DERANGEDARCHEOLOGIST("Deranged Archaeologist"),
    GIANTMOLE("Giant Mole"),
    VETION("Vet'ion"),
    VENENATIS("Venenatis"),
    KINGBLACKDRAGON("King Black Dragon"),
    VORKATH("Vorkath"),
    ABYSSALSIRE("Abyssal Sire"),
    THERMONUCLEARSMOKEDEVIL("Thermonuclear Smoke Devil"),
    CERBERUS("Cerberus"),
    TZKALZUK("TzKal-Zuk"),
    COMMANDERZILYANA("Commander Zilyana"),
    KRILTSUTSAROTH("K'ril Tsutsaroth"),
    KREEARRA("Kree'arra"),
    GENERALGRAARDOR("General Graardor"),
    DAGANNOTHSUPREME("Dagannoth Supreme"),
    DAGANNOTHREX("Dagannoth Rex"),
    DAGANNOTHPRIME("Dagannoth Prime"),
    WINTERTODT("Wintertodt"),
    BARROWS("Barrows Chests"),
    CHAMBERSOFXERIC("Chambers of Xeric"),
    THEATREOFBLOOD("Theatre of Blood");

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
