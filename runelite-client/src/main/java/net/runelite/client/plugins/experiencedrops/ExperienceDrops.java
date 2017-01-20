package net.runelite.client.plugins.experiencedrops;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

/**
 * Created by bold on 1/14/17.
 */
public class ExperienceDrops extends Plugin
{

    @Override
    public Overlay getOverlay()
    {
        return new ExpDropsOverlay(OverlayPosition.CUSTOM, OverlayPriority.HIGH);
    }
}
