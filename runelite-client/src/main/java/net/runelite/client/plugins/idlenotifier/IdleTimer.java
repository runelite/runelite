package net.runelite.client.plugins.idlenotifier;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.Timer;

import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

class IdleTimer extends Timer
{
    IdleTimer(BufferedImage infoImage, Plugin plugin, Duration seconds){
        super(seconds.toMillis(), ChronoUnit.MILLIS, infoImage, plugin);
    }
}
