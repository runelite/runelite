/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.util.Text;
import net.runelite.client.RuneLite;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.OpenOSRSConfig;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ExternalPluginChanged;
import net.runelite.client.events.ExternalPluginsLoaded;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.ExternalPluginManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.MultiplexingPluginPanel;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.MinimumSizedPanel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;

@Slf4j
@Singleton
public class PluginListPanel extends PluginPanel
{
	private static final int OFFSET = 6;

	private static final ImageIcon SECTION_EXPAND_ICON;
	private static final ImageIcon SECTION_EXPAND_ICON_HOVER;
	private static final ImageIcon SECTION_RETRACT_ICON;
	private static final ImageIcon SECTION_RETRACT_ICON_HOVER;

	private static final String RUNELITE_GROUP_NAME = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).value();
	private static final String PINNED_PLUGINS_CONFIG_KEY = "pinnedPlugins";

	private static final List<String> colorOptions = Arrays.asList("enabledColors", "pvmColor", "pvpColor", "skillingColor", "utilityColor", "minigameColor", "miscellaneousColor", "gamemodeColor");
	private static final List<PluginType> definedOrder = List.of(PluginType.IMPORTANT, PluginType.PVM, PluginType.SKILLING, PluginType.PVP, PluginType.UTILITY, PluginType.MINIGAME, PluginType.MISCELLANEOUS, PluginType.GAMEMODE, PluginType.EXTERNAL, PluginType.UNCATEGORIZED);
	private static final Comparator<PluginListItem> categoryComparator = Comparator.comparing(plugin -> definedOrder.indexOf(plugin.getPluginType()));

	private final ConfigManager configManager;
	private final PluginManager pluginManager;
	private final Provider<ConfigPanel> configPanelProvider;
	private final OpenOSRSConfig openOSRSConfig;
	private final ExternalPluginManager externalPluginManager;

	@Getter
	private final MultiplexingPluginPanel muxer;
	private final IconTextField searchBar;
	private final JScrollPane scrollPane;
	private final FixedWidthPanel mainPanel;
	private final Set<JPanel> sectionsCopy = new HashSet<>();

	public static List<PluginListItem> pluginList;

	static
	{
		final BufferedImage backIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "config_back_icon.png");
		final BufferedImage orangeBackIcon = ImageUtil.fillImage(backIcon, ColorScheme.BRAND_BLUE);

		final BufferedImage sectionRetractIcon = ImageUtil.rotateImage(orangeBackIcon, Math.PI * 1.5);
		SECTION_RETRACT_ICON = new ImageIcon(sectionRetractIcon);
		SECTION_RETRACT_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(sectionRetractIcon, -100));

		final BufferedImage sectionExpandIcon = ImageUtil.rotateImage(orangeBackIcon, Math.PI);
		SECTION_EXPAND_ICON = new ImageIcon(sectionExpandIcon);
		SECTION_EXPAND_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(sectionExpandIcon, -100));
	}

	@Inject
	public PluginListPanel(
		ConfigManager configManager,
		PluginManager pluginManager,
		Provider<ConfigPanel> configPanelProvider,
		OpenOSRSConfig openOSRSConfig,
		ExternalPluginManager externalPluginManager,
		EventBus eventBus)
	{
		super(false);

		this.configManager = configManager;
		this.pluginManager = pluginManager;
		this.configPanelProvider = configPanelProvider;
		this.openOSRSConfig = openOSRSConfig;
		this.externalPluginManager = externalPluginManager;

		eventBus.subscribe(ConfigChanged.class, this, ev -> {
			if (ev.getGroup().equals("runelite") && ev.getKey().equals("pinnedPlugins") && !ev.getOrigin().equals(RuneLite.uuid))
			{
				SwingUtilities.invokeLater(this::rebuildPluginList);
			}

			if (!ev.getGroup().equals("openosrs"))
			{
				return;
			}

			if (ev.getKey().equals("enableCategories") || ev.getKey().equals("pluginSortMode"))
			{
				SwingUtilities.invokeLater(this::rebuildPluginList);
			}

			if (ev.getKey().equals("pluginSortMode"))
			{
				sortPluginList(null);
			}

			if (colorOptions.stream().anyMatch(option -> option.equals(ev.getKey())))
			{
				pluginList.forEach(listItem ->
				{
					if (listItem.getPluginType() == PluginType.IMPORTANT)
					{
						return;
					}

					listItem.setColor(getColorByCategory(listItem.getPluginType()));
				});
			}
		});

		eventBus.subscribe(ExternalPluginsLoaded.class, this, ignored -> {
			eventBus.subscribe(ExternalPluginChanged.class, this, ev -> SwingUtilities.invokeLater(this::rebuildPluginList));

			SwingUtilities.invokeLater(this::rebuildPluginList);
		});

		eventBus.subscribe(PluginChanged.class, this, this::onPluginChanged);

		muxer = new MultiplexingPluginPanel(this);

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

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		topPanel.setLayout(new BorderLayout(0, BORDER_OFFSET));
		topPanel.add(searchBar, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);

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

	void rebuildPluginList()
	{
		final List<String> pinnedPlugins = getPinnedPluginNames();

		// populate pluginList with all non-hidden plugins
		pluginList = Stream.concat(
			pluginManager.getFakePlugins().stream(),
			pluginManager.getPlugins().stream()
				.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).hidden())
				.map(plugin ->
				{
					PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
					Config config = pluginManager.getPluginConfigProxy(plugin);
					ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

					return new PluginConfigurationDescriptor(
						descriptor.name(),
						descriptor.description(),
						descriptor.type(),
						descriptor.tags(),
						plugin,
						config,
						configDescriptor);
				})
		).map(desc ->
		{
			PluginListItem listItem = new PluginListItem(this, desc, externalPluginManager);
			listItem.setPinned(pinnedPlugins.contains(desc.getName()));
			listItem.setColor(getColorByCategory(listItem.getPluginType()));

			return listItem;
		}).collect(Collectors.toList());

		sortPluginList(null);
		mainPanel.removeAll();
		refresh();
	}

	void addFakePlugin(PluginConfigurationDescriptor... descriptor)
	{
		Collections.addAll(pluginManager.getFakePlugins(), descriptor);
		pluginManager.loadFakePluginConfiguration();
	}

	void refresh()
	{
		// update enabled / disabled status of all items
		pluginList.forEach(listItem ->
		{
			final Plugin plugin = listItem.getPluginConfig().getPlugin();
			if (plugin != null)
			{
				listItem.setPluginEnabled(pluginManager.isPluginEnabled(plugin));
			}
		});

		int scrollBarPosition = scrollPane.getVerticalScrollBar().getValue();

		onSearchBarChanged();
		searchBar.requestFocusInWindow();
		validate();

		scrollPane.getVerticalScrollBar().setValue(scrollBarPosition);
	}

	private void onSearchBarChanged()
	{
		final String text = searchBar.getText();

		pluginList.forEach(mainPanel::remove);

		sectionsCopy.forEach(mainPanel::remove);
		sectionsCopy.clear();

		showMatchingPlugins(true, text);
		showMatchingPlugins(false, text);

		revalidate();
	}

	private void generatePluginList(List<PluginListItem> pluginListItems)
	{
		final Map<String, JPanel> sections = new HashMap<>();

		for (PluginListItem pluginListItem : pluginListItems)
		{
			if (pluginListItem.isPinned())
			{
				if (!sections.containsKey("Pinned"))
				{
					sections.put("Pinned", addSection("Pinned"));
				}

				sections.get("Pinned").add(pluginListItem);
				continue;
			}

			String sectionName = pluginListItem.getPluginConfig().getPluginType().getName();

			if (!sections.containsKey(sectionName))
			{
				sections.put(sectionName, addSection(sectionName));
			}

			sections.get(sectionName).add(pluginListItem);
		}

		sections.forEach((key, value) ->
		{
			Container parent = value.getParent();
			JToggleButton collapseButton = (JToggleButton) ((JPanel) parent.getComponent(0)).getComponent(0);

			if (searchBar.getText().equals(""))
			{
				resetSection(key, collapseButton, value);
			}
			else
			{
				forceExpandSection(collapseButton, value);
			}
		});
	}

	private void showMatchingPlugins(boolean pinned, String text)
	{
		final List<PluginListItem> plugins = new ArrayList<>();

		if (text.isEmpty())
		{
			if (openOSRSConfig.pluginSortMode() == OpenOSRSConfig.SortStyle.ALPHABETICALLY || !openOSRSConfig.enableCategories())
			{
				pluginList.stream().filter(item -> pinned == item.isPinned()).forEach(mainPanel::add);
			}
			else
			{
				pluginList.stream().filter(item -> pinned == item.isPinned()).forEach(plugins::add);
			}
		}
		else
		{
			final String[] searchTerms = text.toLowerCase().split(" ");
			pluginList.forEach(listItem ->
			{
				if (pinned == listItem.isPinned() && Text.matchesSearchTerms(searchTerms, listItem.getKeywords()))
				{
					if (openOSRSConfig.pluginSortMode() == OpenOSRSConfig.SortStyle.ALPHABETICALLY || !openOSRSConfig.enableCategories())
					{
						mainPanel.add(listItem);
					}
					else
					{
						plugins.add(listItem);
					}
				}
			});
		}

		if (openOSRSConfig.pluginSortMode() == OpenOSRSConfig.SortStyle.CATEGORY && openOSRSConfig.enableCategories())
		{
			generatePluginList(plugins);
		}
	}

	void openConfigurationPanel(String configGroup)
	{
		for (PluginListItem pluginListItem : pluginList)
		{
			if (pluginListItem.getPluginConfig().getName().equals(configGroup))
			{
				openConfigurationPanel(pluginListItem.getPluginConfig());
				break;
			}
		}
	}

	void openConfigurationPanel(PluginConfigurationDescriptor plugin)
	{
		ConfigPanel panel = configPanelProvider.get();
		panel.init(plugin);
		muxer.pushState(panel);
	}

	void startPlugin(Plugin plugin)
	{
		pluginManager.setPluginEnabled(plugin, true);

		try
		{
			pluginManager.startPlugin(plugin);
		}
		catch (PluginInstantiationException ex)
		{
			log.warn("Error when starting plugin {}", plugin.getClass().getSimpleName(), ex);
		}
	}

	void stopPlugin(Plugin plugin)
	{
		pluginManager.setPluginEnabled(plugin, false);

		try
		{
			pluginManager.stopPlugin(plugin);
		}
		catch (PluginInstantiationException ex)
		{
			log.warn("Error when stopping plugin {}", plugin.getClass().getSimpleName(), ex);
		}
	}

	private List<String> getPinnedPluginNames()
	{
		final String config = configManager.getConfiguration(RUNELITE_GROUP_NAME, PINNED_PLUGINS_CONFIG_KEY);

		if (config == null)
		{
			return Collections.emptyList();
		}

		return Text.fromCSV(config);
	}

	void savePinnedPlugins()
	{
		final String value = pluginList.stream()
			.filter(PluginListItem::isPinned)
			.map(p -> p.getPluginConfig().getName())
			.collect(Collectors.joining(","));

		configManager.setConfiguration(RUNELITE_GROUP_NAME, PINNED_PLUGINS_CONFIG_KEY, value);
	}

	public void onPluginChanged(PluginChanged event)
	{
		SwingUtilities.invokeLater(this::refresh);
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

	private JPanel addSection(String name)
	{
		final MinimumSizedPanel section = new MinimumSizedPanel();
		section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
		section.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

		JPanel item = new JPanel();
		item.setLayout(new BorderLayout());
		item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

		JLabel headerLabel = new JLabel(name);
		headerLabel.setFont(FontManager.getRunescapeFont());
		headerLabel.setForeground(ColorScheme.BRAND_BLUE);
		headerLabel.setPreferredSize(new Dimension(PANEL_WIDTH, (int) headerLabel.getPreferredSize().getHeight()));

		final boolean state = Boolean.parseBoolean(configManager.getConfiguration("pluginlist", name));
		final JToggleButton collapse = new JToggleButton(SECTION_EXPAND_ICON, state);

		SwingUtil.removeButtonDecorations(collapse);
		collapse.setRolloverIcon(SECTION_EXPAND_ICON_HOVER);
		collapse.setSelectedIcon(SECTION_RETRACT_ICON);
		collapse.setRolloverSelectedIcon(SECTION_RETRACT_ICON_HOVER);
		collapse.setToolTipText(state ? "Retract" : "Expand");
		collapse.setPreferredSize(new Dimension(20, 20));
		collapse.setFont(collapse.getFont().deriveFont(16.0f));
		collapse.setBorder(null);
		collapse.setMargin(new Insets(0, 0, 0, 0));

		headerLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

		item.add(collapse, BorderLayout.WEST);
		item.add(headerLabel, BorderLayout.CENTER);

		final JPanel sectionContents = new JPanel();
		sectionContents.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		sectionContents.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
		sectionContents.setBorder(new EmptyBorder(OFFSET, 5, 0, 0));
		section.add(item, BorderLayout.NORTH);
		section.add(sectionContents, BorderLayout.SOUTH);

		sectionContents.setVisible(state);

		// Add listeners to each part of the header so that it's easier to toggle them
		final MouseAdapter adapter = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				toggleSection(name, collapse, sectionContents);
			}
		};
		collapse.addActionListener(e -> toggleSection(name, collapse, sectionContents));
		headerLabel.addMouseListener(adapter);

		// Allow for sub-sections
		mainPanel.add(section);
		sectionsCopy.add(section);

		return sectionContents;
	}

	private void toggleSection(String key, JToggleButton button, JPanel contents)
	{
		if (!button.isEnabled())
		{
			return;
		}

		boolean newState = !contents.isVisible();
		button.setSelected(newState);
		button.setToolTipText(newState ? "Retract" : "Expand");
		contents.setVisible(newState);
		configManager.setConfiguration("pluginlist", key, newState);
		SwingUtilities.invokeLater(() ->
		{
			contents.revalidate();
			contents.repaint();
		});
	}

	private void forceExpandSection(JToggleButton button, JPanel contents)
	{
		button.setSelected(true);
		button.setToolTipText(null);
		button.setEnabled(false);
		contents.setVisible(true);

		SwingUtilities.invokeLater(() ->
		{
			contents.revalidate();
			contents.repaint();
		});
	}

	private void resetSection(String key, JToggleButton button, JPanel contents)
	{
		boolean newState = Boolean.parseBoolean(configManager.getConfiguration("pluginlist", key));
		button.setSelected(newState);
		button.setToolTipText(newState ? "Retract" : "Expand");
		contents.setVisible(newState);
		SwingUtilities.invokeLater(() ->
		{
			contents.revalidate();
			contents.repaint();
		});
	}

	private Color getColorByCategory(PluginType pluginType)
	{
		if (!openOSRSConfig.enabledColors())
		{
			return Color.LIGHT_GRAY;
		}

		switch (pluginType)
		{
			case EXTERNAL:
				return openOSRSConfig.externalColor();
			case PVM:
				return openOSRSConfig.pvmColor();
			case PVP:
				return openOSRSConfig.pvpColor();
			case SKILLING:
				return openOSRSConfig.skillingColor();
			case UTILITY:
				return openOSRSConfig.utilityColor();
			case MISCELLANEOUS:
				return openOSRSConfig.miscellaneousColor();
			case MINIGAME:
				return openOSRSConfig.minigameColor();
			case GAMEMODE:
				return openOSRSConfig.gamemodeColor();
			case IMPORTANT:
				return Color.WHITE;
		}

		return Color.LIGHT_GRAY;
	}

	public void sortPluginList(Comparator<PluginListItem> comparator)
	{
		if (comparator != null)
		{
			pluginList.sort(comparator.thenComparing(ev -> ev.getPluginConfig().getName()));
			return;
		}

		if (openOSRSConfig.pluginSortMode() == OpenOSRSConfig.SortStyle.CATEGORY)
		{
			pluginList.sort(categoryComparator.thenComparing(ev -> ev.getPluginConfig().getName()));
		}
		else
		{
			pluginList.sort(Comparator.comparing(ev -> ev.getPluginConfig().getName()));
		}
	}
}