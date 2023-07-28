package net.runelite.client.plugins.alfred.scripts.gerber;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(name = GerberPlugin.CONFIG_GROUP, enabledByDefault = false)
@Slf4j
public class GerberPlugin extends Plugin {
    static final String CONFIG_GROUP = "Alfred Gerber";
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private GerberOverlay overlay;
    @Inject
    private GerberConfig config;

    @Provides
    GerberConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(GerberConfig.class);
    }

    private GerberThread gerberThread;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
        gerberThread = new GerberThread(config);
        gerberThread.start();
    }

    @Override
    protected void shutDown() throws Exception {
        gerberThread.stop();
        overlayManager.remove(overlay);
    }
}
