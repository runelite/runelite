package net.runelite.client.plugins.playerindicators;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HighlightOtherPlayers
{
    DISABLED("Disabled"),
    EVERYWHERE("Everywhere"),
    ONLYPVP("Only in PvP");
    private final String option;

    @Override
    public String toString()
    {
        return option;
    }
}