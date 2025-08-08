package net.runelite.client.plugins.fancyflip;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.plugins.fancyflip.ui.FancyFlipPanel;


@Slf4j
@PluginDescriptor(
        name = "FancyFlip",
        description = "Flip assistant with directives and KPIs",
        tags = {"ge","flip","market","profit"}
)
public class FancyFlipPlugin extends Plugin
{
    @Inject private Client client;
    @Inject private ClientToolbar clientToolbar;
    @Inject private FancyFlipConfig config;

    private NavigationButton navButton;
    private PluginPanel panel;

    @Override
    protected void startUp()
    {
        panel = new FancyFlipPanel(); // simple placeholder panel
        navButton = NavigationButton.builder()
                .tooltip("FancyFlip")
                .panel(panel)
                .build();
        clientToolbar.addNavigation(navButton);
        log.info("FancyFlip started");
    }

    @Override
    protected void shutDown()
    {
        if (navButton != null) clientToolbar.removeNavigation(navButton);
        navButton = null; panel = null;
        log.info("FancyFlip stopped");
    }

    @Provides
    FancyFlipConfig provideConfig(ConfigManager cm) { return cm.getConfig(FancyFlipConfig.class); }
}
