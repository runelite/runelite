package net.runelite.client.plugins.wintertodt;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Wintertodt Plugin"
)

@Slf4j
public class WintertodtPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private WintertodtOverlay overlay;

    @Inject
    private WintertodtConfig config;

    @Override
    public Overlay getOverlay(){ return overlay; }

    @Provides
    WintertodtConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(WintertodtConfig.class);
    }

}
