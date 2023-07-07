package net.runelite.client.plugins.alfred;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.alfred.debug.DebugThread;
import net.runelite.client.plugins.alfred.event.EventSelector;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Alfred",
        description = "Alfred butles.",
        tags = {},
        loadWhenOutdated = true
)
@Slf4j
public class AlfredPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private ClientToolbar clientToolbar;

//    @Inject
//    private AlfredConfig config;

    @Inject
    private AlfredOverlay overlay;

    @Inject
    private OverlayManager overlayManager;

    private EventSelector eventSelector;

    @Getter
    private static Alfred alfred;

    private DebugThread debugThread;

    @Override
    protected void startUp() throws Exception {
        log.info("Alfred putting his suit on.");
        alfred = new Alfred(client);

        overlayManager.add(overlay);

        eventSelector = new EventSelector(clientToolbar);
        eventSelector.startUp();

        debugThread = new DebugThread();
        debugThread.start();

        log.info("Alfred is suited up!");
    }

    @Override
    protected void shutDown() throws Exception {
        debugThread.stop();
        eventSelector.shutDown();
        overlayManager.remove(overlay);
        log.info("Alfred is going home for the day.");
    }
}
