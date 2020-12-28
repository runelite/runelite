package net.runelite.client.plugins.nightmare;

import java.awt.Color;

public enum TotemPhase
{
    TOTEM_9434(true, Color.ORANGE),
    TOTEM_9437(true, Color.ORANGE),
    TOTEM_9440(true, Color.ORANGE),
    TOTEM_9443(true, Color.ORANGE),
    TOTEM_9435(true, Color.GREEN),
    TOTEM_9438(true, Color.GREEN),
    TOTEM_9441(true, Color.GREEN),
    TOTEM_9444(true, Color.GREEN),
    TOTEM_9436(false, Color.RED),
    TOTEM_9439(false, Color.RED),
    TOTEM_9442(false, Color.RED),
    TOTEM_9445(false, Color.RED);

    private final boolean active;
    private final Color color;

    TotemPhase(final boolean active, final Color color)
    {
        this.active = active;
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public boolean isActive()
    {
        return active;
    }
}