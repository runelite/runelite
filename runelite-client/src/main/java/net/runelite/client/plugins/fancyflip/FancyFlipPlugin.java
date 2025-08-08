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
    log.info("FancyFlip starting...");
    try
    {
        // Always create a panel
        panel = new FancyFlipPanel();

        // Try to load icon; if missing, use a 1x1 transparent fallback
        BufferedImage icon;
        try
        {
            icon = ImageUtil.loadImageResource(
                FancyFlipPlugin.class, "pixel-diamond.png"
            );
            if (icon == null)
            {
                icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            }
        }
        catch (Exception ex)
        {
            log.warn("Icon load failed, using fallback", ex);
            icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        }

        // Give the button an explicit name (some RL builds expect this)
        navButton = NavigationButton.builder()
            .name("FancyFlip")          // <-- add name
            .tooltip("FancyFlip")
            .icon(icon)                 // <-- guaranteed non-null now
            .panel(panel)               // <-- guaranteed non-null
            .priority(5)
            .build();

        clientToolbar.addNavigation(navButton);
        log.info("FancyFlip started.");
    }
    catch (Throwable t)
    {
        log.error("FancyFlip failed to start", t);
        // Do not rethrow; keeps the toggle from flipping back off
    }
}

@Override
protected void shutDown()
{
    try
    {
        if (navButton != null)
        {
            clientToolbar.removeNavigation(navButton);
        }
    }
    finally
    {
        navButton = null;
        panel = null;
        log.info("FancyFlip stopped");
    }
}


    @Provides
    FancyFlipConfig provideConfig(ConfigManager cm) { return cm.getConfig(FancyFlipConfig.class); }
}
