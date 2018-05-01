package net.runelite.client.plugins.kitten;

import net.runelite.client.ui.overlay.infobox.Timer;
import net.runelite.client.plugins.Plugin;

import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

class kittenGrowthTimer extends Timer {
    private final Felines kitten;
    public kittenGrowthTimer(Felines kitten, BufferedImage petImage, Plugin plugin, Duration seconds)
    {
        super(seconds.toMillis(), ChronoUnit.MILLIS, petImage, plugin);
        this.kitten = kitten;
    }
    public Felines getKitten() { return kitten;}
}
