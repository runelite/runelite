package net.runelite.client.plugins.toolbox;

import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.SwingUtilities;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.MenuAction;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
        name = "Toolbox",
        description = "Toolbox - Custom Made",
        tags = {"main", "net/runelite/client/plugins/toolbox", "parent"},
        enabledByDefault = true
)
@Slf4j
public class ToolBoxPlugin extends Plugin
{
    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private Provider<PluginListPanel> pluginListPanelProvider;

    @Inject
    private Provider<TopLevelConfigPanel> topLevelConfigPanelProvider;

    @Inject
    private ConfigManager configManager;

    @Inject
    private RuneLiteConfig runeLiteConfig;

    @Inject
    private ChatColorConfig chatColorConfig;

    private TopLevelConfigPanel topLevelConfigPanel;

    private NavigationButton navButton;

    @Override
    protected void startUp() throws Exception
    {
        PluginListPanel pluginListPanel = pluginListPanelProvider.get();
        /*pluginListPanel.addFakePlugin(new PluginConfigurationDescriptor(
                        "RuneLite", "RuneLite client settings",
                        new String[]{"client", "notification", "size", "position", "window", "chrome", "focus", "font", "overlay", "tooltip", "infobox"},
                        runeLiteConfig, configManager.getConfigDescriptor(runeLiteConfig)
                ),
                new PluginConfigurationDescriptor(
                        "Chat Color", "Recolor chat text", new String[]{"colour", "messages"},
                        chatColorConfig, configManager.getConfigDescriptor(chatColorConfig)
                ));*/
        pluginListPanel.rebuildPluginList();

        topLevelConfigPanel = topLevelConfigPanelProvider.get();

        final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "beemo.png");

        navButton = NavigationButton.builder()
                .tooltip("ToolBox")
                .icon(icon)
                .priority(-1)
                .panel(topLevelConfigPanel)
                .build();

        clientToolbar.addNavigation(navButton);
    }

    @Override
    protected void shutDown() throws Exception
    {
        clientToolbar.removeNavigation(navButton);
    }

    @Subscribe
    public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
    {
        OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
        if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY_CONFIG)
        {
            Overlay overlay = overlayMenuClicked.getOverlay();
            Plugin plugin = overlay.getPlugin();
            if (plugin == null)
            {
                return;
            }

            // Expand config panel for plugin
            SwingUtilities.invokeLater(() ->
            {
                clientToolbar.openPanel(navButton);
                topLevelConfigPanel.openConfigurationPanel(plugin.getName());
            });
        }
    }
}