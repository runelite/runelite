package net.runelite.client.plugins.debug;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

/**
 * Created by bold on 1/19/17.
 */
public class Debug extends Plugin
{
    private final Overlay overlay = new DebugOverlay(OverlayPosition.CUSTOM, OverlayPriority.HIGH);


    @Override
    public Overlay getOverlay()
    {
        return overlay;
    }
}
