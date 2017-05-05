package net.runelite.client.plugins.zulrah;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

/**
 * Created by aria on 5/3/17.
 */
public class ZulrahHelper extends Plugin {

    private final ZulrahHelperOverlay overlay = new ZulrahHelperOverlay();
    @Override
    public Overlay getOverlay() {
        return overlay;
    }

    @Override
    protected void startUp() throws Exception {

    }

    @Override
    protected void shutDown() throws Exception {

    }
}
