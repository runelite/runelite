package net.runelite.client.plugins.skillbuddy;

import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.config.SkillbuddyPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.MultiplexingPluginPanel;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
        name = "Skillbuddy",
        description = "Skillbuddy plugin hub",
        tags = {"skillbuddy"},
        enabledByDefault = true,
        hidden = true
)
public class SkillbuddyPlugin extends Plugin
{
    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private Injector injector;

    @Inject
    private EventBus eventBus;

    private NavigationButton navButton;
    private MultiplexingPluginPanel muxer;

    @Override
    protected void startUp()
    {
        SkillbuddyPanel panel = injector.getInstance(SkillbuddyPanel.class);

        muxer = new MultiplexingPluginPanel(panel)
        {
            @Override
            protected void onAdd(PluginPanel p)
            {
                eventBus.register(p);
            }

            @Override
            protected void onRemove(PluginPanel p)
            {
                eventBus.unregister(p);
            }
        };

        panel.setMuxer(muxer);

        final BufferedImage icon = ImageUtil.loadImageResource(
                getClass(), "blood_rune.png"
        );

        navButton = NavigationButton.builder()
                .tooltip("Skillbuddy")
                .icon(icon)
                .priority(1)
                .panel(muxer)
                .build();

        clientToolbar.addNavigation(navButton);
        log.info("Skillbuddy started");
    }

    @Override
    protected void shutDown()
    {
        clientToolbar.removeNavigation(navButton);
        muxer.destroy();
        log.info("Skillbuddy stopped");
    }
}