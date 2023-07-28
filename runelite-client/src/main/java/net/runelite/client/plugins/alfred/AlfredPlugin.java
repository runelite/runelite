package net.runelite.client.plugins.alfred;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ProfileManager;
import net.runelite.client.game.WorldService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.alfred.event.EventSelector;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(name = "Alfred", enabledByDefault = true)
@Slf4j
public class AlfredPlugin extends Plugin {
    @Inject
    private Client client;
    @Inject
    private ClientThread clientThread;
    @Inject
    private ClientToolbar clientToolbar;
    @Inject
    private AlfredOverlay overlay;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private WorldService worldService;
    @Inject
    private ProfileManager profileManager;
    @Getter
    private static Alfred alfred;
    private EventSelector eventSelector;

    @Override
    protected void startUp() throws Exception {
        log.info("Alfred putting his suit on.");
        alfred = new Alfred(client, clientThread, worldService, profileManager);
        alfred.start();

        overlayManager.add(overlay);

        eventSelector = new EventSelector(clientToolbar);
        eventSelector.startUp();

        log.info("Alfred is suited up!");
    }

    @Override
    protected void shutDown() throws Exception {
        eventSelector.shutDown();
        overlayManager.remove(overlay);
        alfred.stop();
        log.info("Alfred is going home for the day.");
    }
}
