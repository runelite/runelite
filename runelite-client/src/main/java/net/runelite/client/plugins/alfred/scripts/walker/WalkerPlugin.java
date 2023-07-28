package net.runelite.client.plugins.alfred.scripts.walker;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(name = WalkerPlugin.CONFIG_GROUP, enabledByDefault = false)
@Slf4j
public class WalkerPlugin extends Plugin {
    static final String CONFIG_GROUP = "Alfred Walker";
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private WalkerOverlay overlay;
    @Inject
    private WalkerConfig config;

    @Provides
    WalkerConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(WalkerConfig.class);
    }

    private WalkerThread walkerThread;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
        walkerThread = new WalkerThread(config);
        walkerThread.start();
    }

    @Override
    protected void shutDown() throws Exception {
        walkerThread.stop();
        overlayManager.remove(overlay);
    }
}
