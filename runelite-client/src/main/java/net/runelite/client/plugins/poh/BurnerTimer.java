package net.runelite.client.plugins.poh;

import net.runelite.client.ui.overlay.infobox.Timer;
import java.time.temporal.ChronoUnit;
import java.awt.image.BufferedImage;

public class BurnerTimer extends Timer
{

    public BurnerTimer(int time, BufferedImage torchImage)
    {
        super(time , ChronoUnit.SECONDS, torchImage);
    }
}