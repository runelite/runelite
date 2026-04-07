package net.runelite.client.plugins.config;

import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.fishingbuddy.FishingBuddyPlugin;
import net.runelite.client.plugins.miningbuddy.MiningBuddyPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.MultiplexingPluginPanel;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkillbuddyPanel extends PluginPanel
{
    private final PluginManager pluginManager;
    private final ConfigManager configManager;
    private final PluginListPanel pluginListPanel;
    private final Provider<ConfigPanel> configPanelProvider;

    private MultiplexingPluginPanel muxer;

    private final FixedWidthPanel mainPanel;
    private final JScrollPane scrollPane;
    private final IconTextField searchBar;
    private List<PluginListItem> pluginList = new ArrayList<>();

    @Inject
    public SkillbuddyPanel(
            PluginManager pluginManager,
            ConfigManager configManager,
            PluginListPanel pluginListPanel,
            Provider<ConfigPanel> configPanelProvider)
    {
        super(false);

        this.pluginManager = pluginManager;
        this.configManager = configManager;
        this.pluginListPanel = pluginListPanel;
        this.configPanelProvider = configPanelProvider;

        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        // Search bar — exact same as RuneLite
        searchBar = new IconTextField();
        searchBar.setIcon(IconTextField.Icon.SEARCH);
        searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
        searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
        searchBar.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                onSearchBarChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                onSearchBarChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                onSearchBarChanged();
            }
        });

        // Top panel with search bar
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPanel.setLayout(new BorderLayout(0, BORDER_OFFSET));
        topPanel.add(searchBar, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Main plugin list panel
        mainPanel = new FixedWidthPanel();
        mainPanel.setBorder(new EmptyBorder(8, 10, 10, 10));
        mainPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel northPanel = new FixedWidthPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(mainPanel, BorderLayout.NORTH);

        scrollPane = new JScrollPane(northPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setMuxer(MultiplexingPluginPanel muxer)
    {
        this.muxer = muxer;
        buildPluginList();
    }

    private void buildPluginList()
    {
        pluginList.clear();
        mainPanel.removeAll();

        // Voeg hier al je plugins toe
        addPlugin(FishingBuddyPlugin.class);
        addPlugin(MiningBuddyPlugin.class);

        onSearchBarChanged();
    }

    private void addPlugin(Class<? extends Plugin> pluginClass)
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
                    ConfigPanel panel = configPanelProvider.get();
                    panel.setOverrideMuxer(muxer);
                    panel.init(pluginConfigDescriptor);
                    muxer.pushState(panel);
                }
            }
        };

        listItem.setPluginEnabled(pluginManager.isPluginEnabled(plugin));
        pluginList.add(listItem);
    }

    private void onSearchBarChanged()
    {
        final String text = searchBar.getText();
        pluginList.forEach(mainPanel::remove);
        PluginSearch.search(pluginList, text).forEach(mainPanel::add);
        revalidate();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(PANEL_WIDTH + SCROLLBAR_WIDTH, super.getPreferredSize().height);
    }

    @Override
    public void onActivate()
    {
        super.onActivate();
        if (searchBar.getParent() != null)
        {
            searchBar.requestFocusInWindow();
        }
    }
}