package net.runelite.client.plugins.kitten;

import net.runelite.client.ui.overlay.infobox.Timer;
import net.runelite.client.plugins.Plugin;

import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class kittenHungryTimer extends Timer{

    public kittenHungryTimer(BufferedImage infoImage, Plugin plugin, Duration seconds) {
        super(seconds.toMillis(), ChronoUnit.MILLIS, infoImage, plugin);
    }
}
