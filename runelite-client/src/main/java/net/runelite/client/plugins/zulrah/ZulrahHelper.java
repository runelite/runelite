package net.runelite.client.plugins.zulrah;


import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by aria on 5/5/17.
 */
public class ZulrahHelper extends Plugin {

    private ScheduledFuture<?> future = null;
    private final ZulrahHelperOverlay overlay = new ZulrahHelperOverlay();

    @Override
    public Overlay getOverlay() {
        return overlay;
    }

    @Override
    protected void startUp() throws Exception {
        ScheduledExecutorService executor = RuneLite.getRunelite().getExecutor();
        future = executor.scheduleAtFixedRate(overlay::update, 100, 100, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println("FUTURE CANCELLED");

        future.cancel(true);
    }
}
