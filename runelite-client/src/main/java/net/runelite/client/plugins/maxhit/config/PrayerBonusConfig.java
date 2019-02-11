package net.runelite.client.plugins.maxhit.config;

public enum PrayerBonusConfig
{
    DEFAULT("No Prayer", 1),
    BURST_OF_STRENGTH("Burst of Strength", 1.05),
    SUPERHUMAN_STRENGTH("Superhuman Strength", 1.1),
    ULTIMATE_STRENGTH("Ultimate Strength", 1.15),
    CHIVALRY("Chivalry", 1.18),
    PIETY("Piety", 1.23),
    SHARP_EYE("Sharp Eye", 1.05),
    HAWK_EYE("Hawk Eye", 1.1),
    EAGLE_EYE("Eagle Eye", 1.15),
    RIGOUR("Rigour", 1.23);

    private final String name;
    private double bonus;

    PrayerBonusConfig(String name, double bonus)
    {
        this.name = name;
        this.bonus = bonus;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public boolean isSet()
    {
        return this != DEFAULT;
    }

    public double getBonus() {
        return bonus;
    }
}