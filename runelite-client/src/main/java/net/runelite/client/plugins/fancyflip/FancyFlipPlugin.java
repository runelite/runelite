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
import java.awt.image.BufferedImage;
import net.runelite.client.util.ImageUtil;


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
    panel = new FancyFlipPanel();

    BufferedImage icon = ImageUtil.loadImageResource(
        FancyFlipPlugin.class, "pixel-diamond.png" // ← new asset
    );

        navButton = NavigationButton.builder()
        .tooltip("FancyFlip")
        .icon(icon)
        .panel(panel)
        .priority(5)
        .build();

        clientToolbar.addNavigation(navButton);

        BufferedImage icon = null;
        try {
                icon = ImageUtil.loadImageResource(FancyFlipPlugin.class, "pixel-diamond.png");
        } catch (Exception ex) {
        log.warn("Icon load failed, continuing without icon", ex);
}

navButton = NavigationButton.builder()
    .tooltip("FancyFlip")
    .icon(icon) // null is fine; default icon is used
    .panel(panel)
    .build();

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
