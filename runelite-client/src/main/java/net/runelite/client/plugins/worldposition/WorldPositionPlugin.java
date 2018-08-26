package net.runelite.client.plugins.worldposition;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "World Position",
        description = "An overlay to display your current world position",
        tags = {"world", "position", "overlay", "loudpacks"}
)

public class WorldPositionPlugin extends Plugin {

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private WorldPositionOverlay worldPositionOverlay;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(worldPositionOverlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(worldPositionOverlay);
    }
}
