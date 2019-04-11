package net.runelite.http.api.hiscore;

import lombok.Getter;

@Getter
public class Progression
{
    private int xpGained;
    private double ehpGained;

    public Progression(int xpGained, double ehpGained)
    {
        this.xpGained = xpGained;
        this.ehpGained = ehpGained;
    }
}
