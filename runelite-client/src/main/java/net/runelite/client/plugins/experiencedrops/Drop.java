package net.runelite.client.plugins.experiencedrops;

import java.awt.*;
import java.util.List;

/**
 * Created by bold on 1/18/17.
 */
public class Drop
{
    private int sumXP;
    private List<Image> iconNames;
    private int yCoord;

    public Drop(int sumXP, List<Image> iconNames, int yCoord)
    {
        this.sumXP = sumXP;
        this.iconNames = iconNames;
        this.yCoord = yCoord;
    }

    public int getY()
    {
        return this.yCoord;
    }

    public void setY(int yCoord)
    {
        this.yCoord = yCoord;
    }

    public int getSumXP()
    {
        return this.sumXP;
    }

    public List<Image> getIconNames()
    {
        return this.iconNames;
    }
}
