package net.runelite.client.plugins.config;

import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.fishingbuddy.FishingBuddyPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.MultiplexingPluginPanel;
import net.runelite.client.ui.PluginPanel;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class SkillbuddyPanel extends PluginPanel
{
    private final PluginManager pluginManager;
    private final ConfigManager configManager;
    private final PluginListPanel pluginListPanel;
    private final Provider<ConfigPanel> configPanelProvider;

    private MultiplexingPluginPanel muxer;

    @Inject
    public SkillbuddyPanel(
            PluginManager pluginManager,
            ConfigManager configManager,
            PluginListPanel pluginListPanel,
            Provider<ConfigPanel> configPanelProvider)
    {
        this.pluginManager = pluginManager;
        this.configManager = configManager;
        this.pluginListPanel = pluginListPanel;
        this.configPanelProvider = configPanelProvider;

        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        // Title
        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        titlePanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

        JLabel title = new JLabel("Skillbuddy");
        title.setForeground(Color.WHITE);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // Plugin list
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(8, 10, 10, 10));
        mainPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
        mainPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

        addPlugin(mainPanel, FishingBuddyPlugin.class);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
        northPanel.add(mainPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(northPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(ColorScheme.DARK_GRAY_COLOR);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setMuxer(MultiplexingPluginPanel muxer)
    {
        this.muxer = muxer;
    }

    private void addPlugin(JPanel panel, Class<? extends Plugin> pluginClass)
    {
        Plugin plugin = pluginManager.getPlugins()
                .stream()
                .filter(p -> p.getClass() == pluginClass)
                .findFirst()
                .orElse(null);

        if (plugin == null)
        {
            return;
        }

        PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
        net.runelite.client.config.Config config = pluginManager.getPluginConfigProxy(plugin);
        ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);
        List<String> conflicts = pluginManager.conflictsForPlugin(plugin)
                .stream()
                .map(Plugin::getName)
                .collect(Collectors.toList());

        PluginConfigurationDescriptor pluginConfigDescriptor = new PluginConfigurationDescriptor(
                descriptor.name(),
                descriptor.description(),
                descriptor.tags(),
                plugin,
                config,
                configDescriptor,
                conflicts
        );

        PluginListItem listItem = new PluginListItem(pluginListPanel, pluginConfigDescriptor)
        {
            @Override
            void openGroupConfigPanel()
            {
                if (muxer != null)
                {
                    pluginListPanel.openConfigurationPanelWithMuxer(pluginConfigDescriptor, muxer);
                }
            }
        };

        listItem.setPluginEnabled(pluginManager.isPluginEnabled(plugin));
        panel.add(listItem);
    }
}