package net.runelite.client.plugins.regionlocker;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
    name = RegionLockerPlugin.PLUGIN_NAME,
    description = "Adds graphical effect to locked regions.",
    tags = {"region", "locker", "chunk", "map square"}
)
public class RegionLockerPlugin extends Plugin {
    static final String PLUGIN_NAME = "Region Locker";
    static final String CONFIG_KEY = "regionlocker";

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RegionLockerConfig config;

    @Inject
    private RegionLockerOverlay regionLockerOverlay;

    private UnlockedRegions unlockedRegions;

    @Provides
    RegionLockerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(RegionLockerConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        unlockedRegions = new UnlockedRegions(client, config);
        overlayManager.add(regionLockerOverlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(regionLockerOverlay);
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!event.getGroup().equals(RegionLockerPlugin.CONFIG_KEY))
        {
            return;
        }

        unlockedRegions.readRegions();
    }
}
