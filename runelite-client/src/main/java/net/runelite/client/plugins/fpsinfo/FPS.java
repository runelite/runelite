package net.runelite.client.plugins.fpsinfo;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

/**
 * Created by bold on 1/13/17.
 */
public class FPS extends Plugin
{
    private final Overlay overlay = new FPSOverlay();

    @Override
    public Overlay getOverlay()
    {
        return overlay;
    }
}
