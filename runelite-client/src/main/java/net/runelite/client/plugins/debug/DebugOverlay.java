package net.runelite.client.plugins.debug;

import net.runelite.api.Client;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.time.Instant;
import java.util.Arrays;

/**
 * Created by bold on 1/19/17.
 */
public class DebugOverlay extends Overlay
{
    private static Client c = RuneLite.getClient();
    private static Instant t = Instant.now();
    private static int[] old;
    private static int[] zz;

    public DebugOverlay(OverlayPosition position, OverlayPriority priority)
    {
        super(position, priority);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        return null;
    }
}
