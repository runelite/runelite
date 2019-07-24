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

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.text.JTextComponent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigItemsGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.ConfigPanelItem;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.config.Range;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.config.RuneLitePlusConfig;
import net.runelite.client.config.Stub;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ComboBoxListRenderer;
import net.runelite.client.ui.components.IconButton;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.MiscUtils;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@Singleton
public class ConfigPanel extends PluginPanel
{
	private static final int SPINNER_FIELD_WIDTH = 6;
	private static final int SCROLLBAR_WIDTH = 17;
	private static final int OFFSET = 6;
	private static final ImageIcon BACK_ICON;
	private static final ImageIcon BACK_ICON_HOVER;

	private static final String RUNELITE_GROUP_NAME = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).value();
	private static final String PINNED_PLUGINS_CONFIG_KEY = "pinnedPlugins";
	private static final String RUNELITE_PLUGIN = "RuneLite";
	private static final String RUNELITEPLUS_PLUGIN = "RuneLitePlus";
	private static final String CHAT_COLOR_PLUGIN = "Chat Color";
	private final PluginManager pluginManager;
	private final ConfigManager configManager;
	private final ScheduledExecutorService executorService;
	private final RuneLiteConfig runeLiteConfig;
	private final RuneLitePlusConfig runeLitePlusConfig;
	private final ChatColorConfig chatColorConfig;
	private final ColorPickerManager colorPickerManager;
	public static List<PluginListItem> pluginList = new ArrayList<>();

	private final IconTextField searchBar = new IconTextField();
	private final JPanel topPanel;
	private final JPanel mainPanel;
	private final JScrollPane scrollPane;

	private boolean showingPluginList = true;
	private int scrollBarPosition = 0;

	static
	{
		final BufferedImage backIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "config_back_icon.png");
		BACK_ICON = new ImageIcon(backIcon);
		BACK_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(backIcon, -100));
	}

	ConfigPanel(PluginManager pluginManager, ConfigManager configManager, ScheduledExecutorService executorService,
				RuneLiteConfig runeLiteConfig, RuneLitePlusConfig runeLitePlusConfig, ChatColorConfig chatColorConfig,
				ColorPickerManager colorPickerManager)
	{
		super(false);
		this.pluginManager = pluginManager;
		this.configManager = configManager;
		this.executorService = executorService;
		this.runeLiteConfig = runeLiteConfig;
		this.runeLitePlusConfig = runeLitePlusConfig;
		this.chatColorConfig = chatColorConfig;
		this.colorPickerManager = colorPickerManager;

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

		topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		topPanel.setLayout(new BorderLayout(0, OFFSET));
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

		initializePluginList();
		refreshPluginList();

	}

	static class configTextArea extends JTextArea
	{
		private static final int WIDTH = 212;
		private static final int HEIGHT_PADDING = 13;

		@Override
		public void scrollRectToVisible(final Rectangle aRect)
		{
			// suppress scrollToRect in textarea
		}

		@Override
		public Dimension getSize()
		{
			if (StringUtils.isAllEmpty(getText()))
			{
				return super.getSize();
			}

			final ArrayList<String> lines = new ArrayList<>();
			final FontMetrics fontMetrics = getFontMetrics(getFont());

			StringBuilder sb = new StringBuilder();
			for (final Character c : getText().toCharArray())
			{
				sb.append(c);
				if (fontMetrics.stringWidth(sb.toString()) > WIDTH || c == '\n')
				{
					sb.setLength(sb.length() - 1);
					lines.add(sb.toString());
					sb = new StringBuilder(c.toString());
				}
			}
			lines.add(sb.toString());

			return new Dimension(WIDTH, (lines.size() * fontMetrics.getHeight()) + HEIGHT_PADDING);
		}
	}

	private void initializePluginList()
	{
		final List<String> pinnedPlugins = getPinnedPluginNames();

		// set RuneLite config on top, as it should always have been
		final PluginListItem runeLite = new PluginListItem(this, configManager, runeLiteConfig,
			configManager.getConfigDescriptor(runeLiteConfig),
			RUNELITE_PLUGIN, "RuneLite client settings", "client");
		runeLite.setPinned(pinnedPlugins.contains(RUNELITE_PLUGIN));
		runeLite.nameLabel.setForeground(Color.WHITE);
		pluginList.add(runeLite);

		// set RuneLitePlus config on top, as it should always have been
		final PluginListItem runeLitePlus = new PluginListItem(this, configManager, runeLitePlusConfig,
			configManager.getConfigDescriptor(runeLitePlusConfig),
			RUNELITEPLUS_PLUGIN, "RuneLitePlus client settings", "client");
		runeLitePlus.setPinned(pinnedPlugins.contains(RUNELITEPLUS_PLUGIN));
		runeLitePlus.nameLabel.setForeground(Color.WHITE);
		pluginList.add(runeLitePlus);

		List<PluginListItem> externalPlugins = new ArrayList<>();
		// populate pluginList with all external Plugins
		pluginManager.getPlugins().stream()
			.filter(plugin -> plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.EXTERNAL))
			.forEach(plugin ->
			{
				final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
				final Config config = pluginManager.getPluginConfigProxy(plugin);
				final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

				final PluginListItem listItem = new PluginListItem(this, configManager, plugin, descriptor, config, configDescriptor);
				listItem.setPinned(pinnedPlugins.contains(listItem.getName()));
				externalPlugins.add(listItem);
			});

		externalPlugins.sort(Comparator.comparing(PluginListItem::getName));
		pluginList.addAll(externalPlugins);

		List<PluginListItem> pvmPlugins = new ArrayList<>();

		// populate pluginList with all non-hidden plugins
		pluginManager.getPlugins().stream()
			.filter(plugin -> plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.PVM))
			.forEach(plugin ->
			{
				final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
				final Config config = pluginManager.getPluginConfigProxy(plugin);
				final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

				final PluginListItem listItem = new PluginListItem(this, configManager, plugin, descriptor, config, configDescriptor);
				listItem.setPinned(pinnedPlugins.contains(listItem.getName()));
				pvmPlugins.add(listItem);
			});

		pvmPlugins.sort(Comparator.comparing(PluginListItem::getName));
		pluginList.addAll(pvmPlugins);

		List<PluginListItem> skillingPlugins = new ArrayList<>();

		// populate pluginList with all non-hidden plugins
		pluginManager.getPlugins().stream()
			.filter(plugin -> plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.SKILLING))
			.forEach(plugin ->
			{
				final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
				final Config config = pluginManager.getPluginConfigProxy(plugin);
				final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

				final PluginListItem listItem = new PluginListItem(this, configManager, plugin, descriptor, config, configDescriptor);
				listItem.setPinned(pinnedPlugins.contains(listItem.getName()));
				skillingPlugins.add(listItem);
			});

		skillingPlugins.sort(Comparator.comparing(PluginListItem::getName));
		pluginList.addAll(skillingPlugins);

		List<PluginListItem> pvpPlugins = new ArrayList<>();
		// populate pluginList with all PVP Plugins
		pluginManager.getPlugins().stream()
			.filter(plugin -> plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.PVP))
			.forEach(plugin ->
			{
				final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
				final Config config = pluginManager.getPluginConfigProxy(plugin);
				final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

				final PluginListItem listItem = new PluginListItem(this, configManager, plugin, descriptor, config, configDescriptor);
				listItem.setPinned(pinnedPlugins.contains(listItem.getName()));
				pvpPlugins.add(listItem);
			});

		pvpPlugins.sort(Comparator.comparing(PluginListItem::getName));
		pluginList.addAll(pvpPlugins);

		List<PluginListItem> utilPlugins = new ArrayList<>();
		// populate pluginList with all PVP Plugins
		pluginManager.getPlugins().stream()
			.filter(plugin -> plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.UTILITY))
			.forEach(plugin ->
			{
				final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
				final Config config = pluginManager.getPluginConfigProxy(plugin);
				final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

				final PluginListItem listItem = new PluginListItem(this, configManager, plugin, descriptor, config, configDescriptor);
				listItem.setPinned(pinnedPlugins.contains(listItem.getName()));
				utilPlugins.add(listItem);
			});

		utilPlugins.sort(Comparator.comparing(PluginListItem::getName));
		pluginList.addAll(utilPlugins);

		// populate pluginList with all vanilla RL plugins
		List<PluginListItem> vanillaPlugins = new ArrayList<>();
		pluginManager.getPlugins().stream()
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).hidden())
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.PVM))
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.PVP))
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.SKILLING))
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.UTILITY))
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.PLUGIN_ORGANIZER))
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.EXTERNAL))
			.forEach(plugin ->
				{
					final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
					final Config config = pluginManager.getPluginConfigProxy(plugin);
					final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

					final PluginListItem listItem = new PluginListItem(this, configManager, plugin, descriptor, config, configDescriptor);
					listItem.setPinned(pinnedPlugins.contains(listItem.getName()));
					vanillaPlugins.add(listItem);
				}
			);

		final PluginListItem chatColor = new PluginListItem(this, configManager, chatColorConfig,
			configManager.getConfigDescriptor(chatColorConfig),
			CHAT_COLOR_PLUGIN, "Recolor chat text", "colour", "messages");
		chatColor.setPinned(pinnedPlugins.contains(CHAT_COLOR_PLUGIN));
		chatColor.nameLabel.setForeground(Color.WHITE);
		vanillaPlugins.add(chatColor);

		vanillaPlugins.sort(Comparator.comparing(PluginListItem::getName));
		pluginList.addAll(vanillaPlugins);

		// Add plugin sorter to bottom
		pluginManager.getPlugins().stream()
			.filter(plugin -> plugin.getClass().getAnnotation(PluginDescriptor.class).type().equals(PluginType.PLUGIN_ORGANIZER))
			.forEach(plugin ->
			{
				final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
				final Config config = pluginManager.getPluginConfigProxy(plugin);
				final ConfigDescriptor configDescriptor = config == null ? null : configManager.getConfigDescriptor(config);

				final PluginListItem listItem = new PluginListItem(this, configManager, plugin, descriptor, config, configDescriptor);
				pluginList.add(listItem);
			});
	}

	void refreshPluginList()
	{
		if (pluginManager != null)
		{
			// update enabled / disabled status of all items
			pluginList.forEach(listItem ->
			{
				final Plugin plugin = listItem.getPlugin();
				if (plugin != null)
				{
					listItem.setPluginEnabled(pluginManager.isPluginEnabled(plugin));
				}
			});
		}

		if (showingPluginList)
		{
			openConfigList();
		}
	}

	void openConfigList()
	{
		if (showingPluginList)
		{
			scrollBarPosition = scrollPane.getVerticalScrollBar().getValue();
		}

		showingPluginList = true;

		topPanel.removeAll();
		mainPanel.removeAll();
		topPanel.add(searchBar, BorderLayout.CENTER);

		onSearchBarChanged();
		searchBar.requestFocusInWindow();
		validate();
		scrollPane.getVerticalScrollBar().setValue(scrollBarPosition);
	}

	private void onSearchBarChanged()
	{
		final String text = searchBar.getText();

		pluginList.forEach(mainPanel::remove);

		showMatchingPlugins(true, text);
		showMatchingPlugins(false, text);

		revalidate();
	}

	private void showMatchingPlugins(boolean pinned, String text)
	{
		if (text.isEmpty())
		{
			pluginList.stream().filter(item -> pinned == item.isPinned()).forEach(mainPanel::add);
			return;
		}

		final String[] searchTerms = text.toLowerCase().split(" ");
		pluginList.forEach(listItem ->
		{
			if (pinned == listItem.isPinned() && listItem.matchesSearchTerms(searchTerms))
			{
				mainPanel.add(listItem);
			}
		});
	}

	private Boolean parse(ConfigItem item, String value)
	{
		try
		{
			Method parse = item.clazz().getMethod(item.method(), String.class);

			return (boolean) parse.invoke(null, value);
		}
		catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex)
		{
			log.error("Parsing failed: {}", ex.getMessage());
		}

		return null;
	}

	private void parseLabel(ConfigItem item, JLabel label, String value)
	{
		Boolean result = parse(item, value);

		if (result == null)
		{
			label.setForeground(Color.RED);
			label.setText("Parsing failed");
		}
		else if (result)
		{
			label.setForeground(Color.GREEN);
			label.setText("Valid input");
		}
		else
		{
			label.setForeground(Color.RED);
			label.setText("Error: Invalid input");
		}
	}

	void openGroupConfigPanel(PluginListItem listItem, Config config, ConfigDescriptor cd)
	{
		openGroupConfigPanel(listItem, config, cd, false);
	}

	private void openGroupConfigPanel(PluginListItem listItem, Config config, ConfigDescriptor cd, boolean refresh)
	{
		showingPluginList = false;

		scrollBarPosition = scrollPane.getVerticalScrollBar().getValue();
		topPanel.removeAll();
		mainPanel.removeAll();

		final IconButton topPanelBackButton = new IconButton(BACK_ICON, BACK_ICON_HOVER);
		topPanelBackButton.setPreferredSize(new Dimension(22, 0));
		topPanelBackButton.setBorder(new EmptyBorder(0, 0, 0, 5));
		topPanelBackButton.addActionListener(e -> openConfigList());
		topPanelBackButton.setToolTipText("Back");
		topPanel.add(topPanelBackButton, BorderLayout.WEST);

		if (!listItem.getName().equals("RuneLitePlus"))
		{
			topPanel.add(listItem.createToggleButton(), BorderLayout.EAST);
		}

		String name = listItem.getName();
		JLabel title = new JLabel(name);
		title.setForeground(Color.WHITE);
		title.setToolTipText("<html>" + name + ":<br>" + listItem.getDescription() + "</html>");
		topPanel.add(title);

		for (ConfigItemsGroup cig : cd.getItemGroups())
		{
			ConfigPanelItem mainParent = new ConfigPanelItem(null, null);

			boolean collapsed = false;
			if (!cig.getGroup().equals(""))
			{
				String header = cig.getGroup();

				JPanel item = new JPanel();
				item.setLayout(new BorderLayout());
				item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

				JLabel headerLabel = new JLabel(header);
				headerLabel.setForeground(Color.ORANGE);
				headerLabel.setPreferredSize(new Dimension(PANEL_WIDTH, (int) headerLabel.getPreferredSize().getHeight()));
				String sCollapsed = configManager.getConfiguration(cd.getGroup().value(), cig.getGroup() + "_collapse");

				if (sCollapsed != null)
				{
					collapsed = Boolean.parseBoolean(sCollapsed);
				}

				JButton collapse = new JButton(collapsed ? "+" : "-");
				collapse.setPreferredSize(new Dimension(20, 20));
				collapse.setFont(collapse.getFont().deriveFont(16.0f));
				collapse.setBorder(null);
				collapse.setMargin(new Insets(0, 0, 0, 0));
				collapse.addActionListener(ae -> changeGroupCollapse(listItem, config, collapse, cd, cig));
				headerLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

				item.add(collapse, BorderLayout.WEST);
				item.add(headerLabel, BorderLayout.CENTER);

				mainPanel.add(item);
			}

			if (collapsed)
			{
				continue;
			}

			List<ConfigItemDescriptor> allItems = new ArrayList<>(cig.getItems());

			int maxDepth = 3;
			do
			{
				for (ConfigItemDescriptor cid : new ArrayList<>(allItems))
				{

					String parent = cid.getItem().parent();

					if (parent.equals(""))
					{
						mainParent.getChildren().add(new ConfigPanelItem(mainParent, cid));
						allItems.remove(cid);
					}
					else
					{
						if (mainParent.addChildIfMatchParent(cid))
						{
							allItems.remove(cid);
						}
					}

				}

				maxDepth--;

			} while (allItems.size() > 0 && maxDepth > 0);

			List<ConfigPanelItem> orderedList = mainParent.getItemsAsList();

			for (ConfigPanelItem cpi : orderedList)
			{
				ConfigItemDescriptor cid = cpi.getItem();

				if (cid == null)
				{
					continue; // Ignore main 'parent'
				}

				Boolean unhide = cid.getItem().hidden();
				Boolean hide = !cid.getItem().hide().isEmpty();

				if (unhide || hide)
				{
					boolean show = false;

					List<String> itemHide = Splitter
						.onPattern("\\|\\|")
						.trimResults()
						.omitEmptyStrings()
						.splitToList(String.format("%s || %s", cid.getItem().unhide(), cid.getItem().hide()));

					for (ConfigItemDescriptor cid2 : cd.getItems())
					{
						if (itemHide.contains(cid2.getItem().keyName()))
						{
							if (cid2.getType() == boolean.class)
							{
								show = Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().value(), cid2.getItem().keyName()));
							}
							else if (cid2.getType().isEnum())
							{
								Class<? extends Enum> type = (Class<? extends Enum>) cid2.getType();
								try
								{
									Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().value(), cid2.getItem().keyName()));
									if (!cid.getItem().unhideValue().equals(""))
									{
										show = selectedItem.toString().equals(cid.getItem().unhideValue());
									}
									else if (!cid.getItem().hideValue().equals(""))
									{
										show = !selectedItem.toString().equals(cid.getItem().hideValue());
									}
								}
								catch (IllegalArgumentException ex)
								{
									log.info("So bad, so sad: {}", ex.toString());
								}
							}
						}

						if (show)
						{
							break;
						}
					}

					if ((unhide && !show) || (hide && show))
					{
						continue;
					}
				}

				JPanel item = new JPanel();
				item.setLayout(new BorderLayout());
				item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
				name = cid.getItem().name();

				StringBuilder depthOffset = new StringBuilder();
				for (int depth = 1; depth < cpi.getDepth(); depth++)
				{
					depthOffset.append("   ");
				}

				name = depthOffset + name;

				JLabel configEntryName = new JLabel(name);
				configEntryName.setPreferredSize(new Dimension(PANEL_WIDTH, (int) configEntryName.getPreferredSize().getHeight()));
				configEntryName.setForeground(Color.WHITE);
				configEntryName.setToolTipText("<html>" + name + ":<br>" + cid.getItem().description() + "</html>");
				item.add(configEntryName, cid.getType() != String.class ? BorderLayout.CENTER : BorderLayout.NORTH);

				if (cid.getType() == Stub.class)
				{
					Border border = item.getBorder();
					Border margin = new EmptyBorder(10, 0, 0, 0);
					item.setBorder(new CompoundBorder(border, margin));

					configEntryName.setForeground(Color.ORANGE);
					configEntryName.setToolTipText(null);
				}

				else if (cid.getType() == boolean.class)
				{
					JCheckBox checkbox = new JCheckBox();
					checkbox.setBackground(ColorScheme.LIGHT_GRAY_COLOR);
					checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName())));
					checkbox.addActionListener(ae -> changeConfiguration(listItem, config, checkbox, cd, cid));

					item.add(checkbox, BorderLayout.EAST);
				}

				else if (cid.getType() == int.class)
				{
					int value = Integer.parseInt(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));

					Range range = cid.getRange();
					int min = 0, max = Integer.MAX_VALUE;
					if (range != null)
					{
						min = range.min();
						max = range.max();
					}

					// Config may previously have been out of range
					value = MiscUtils.clamp(value, min, max);

					if (max < Integer.MAX_VALUE)
					{
						JLabel sliderValueLabel = new JLabel();
						JSlider slider = new JSlider(min, max, value);
						sliderValueLabel.setText(String.valueOf(slider.getValue()));
						slider.setPreferredSize(new Dimension(85, 25));
						slider.addChangeListener((l) ->
							{
								sliderValueLabel.setText(String.valueOf(slider.getValue()));
								if (!slider.getValueIsAdjusting())
								{
									changeConfiguration(listItem, config, slider, cd, cid);
								}
							}
						);

						SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
						JSpinner spinner = new JSpinner(model);
						Component editor = spinner.getEditor();
						JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
						spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
						spinner.setUI(new BasicSpinnerUI()
						{
							protected Component createNextButton()
							{
								return null;
							}

							protected Component createPreviousButton()
							{
								return null;
							}
						});
						spinner.addChangeListener((ce) ->
						{
							changeConfiguration(listItem, config, spinner, cd, cid);
							spinner.setVisible(false);
							sliderValueLabel.setText(String.valueOf(spinner.getValue()));
							sliderValueLabel.setVisible(true);
							slider.setValue((Integer) spinner.getValue());
							slider.setVisible(true);
						});
						spinner.setVisible(false);

						sliderValueLabel.addMouseListener(new MouseAdapter()
						{
							public void mouseClicked(MouseEvent e)
							{
								spinner.setValue(slider.getValue());
								spinner.setVisible(true);
								sliderValueLabel.setVisible(false);
								slider.setVisible(false);
							}
						});

						JPanel subPanel = new JPanel();

						subPanel.add(spinner);
						subPanel.add(sliderValueLabel);
						subPanel.add(slider);

						item.add(subPanel, BorderLayout.EAST);
					}
					else
					{
						SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
						JSpinner spinner = new JSpinner(model);
						Component editor = spinner.getEditor();
						JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
						spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
						spinner.addChangeListener(ce -> changeConfiguration(listItem, config, spinner, cd, cid));

						item.add(spinner, BorderLayout.EAST);
					}
				}

				else if (cid.getType() == String.class)
				{
					JTextComponent textField;

					if (cid.getItem().secret())
					{
						textField = new JPasswordField();
					}
					else
					{
						final JTextArea textArea = new configTextArea();
						textArea.setLineWrap(true);
						textArea.setWrapStyleWord(true);
						textField = textArea;
					}

					textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
					textField.setText(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));

					textField.addFocusListener(new FocusAdapter()
					{
						@Override
						public void focusLost(FocusEvent e)
						{
							ConfigItem item = cid.getItem();
							if (item.parse())
							{
								Boolean result = parse(item, textField.getText());

								if (result != null && result)
								{
									changeConfiguration(listItem, config, textField, cd, cid);
								}
							}
							else
							{
								changeConfiguration(listItem, config, textField, cd, cid);
							}
						}
					});

					if (cid.getItem().parse())
					{
						JLabel parsingLabel = new JLabel();
						parsingLabel.setHorizontalAlignment(SwingConstants.CENTER);
						parsingLabel.setPreferredSize(new Dimension(PANEL_WIDTH, 15));

						DeferredDocumentChangedListener listener = new DeferredDocumentChangedListener();
						listener.addChangeListener(e ->
						{
							if (cid.getItem().parse())
							{
								parseLabel(cid.getItem(), parsingLabel, textField.getText());
							}
						});
						textField.getDocument().addDocumentListener(listener);

						item.add(textField, BorderLayout.CENTER);

						parseLabel(cid.getItem(), parsingLabel, textField.getText());
						item.add(parsingLabel, BorderLayout.SOUTH);
					}
					else
					{
						item.add(textField, BorderLayout.SOUTH);
					}
				}

				else if (cid.getType() == Color.class)
				{
					String existing = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());

					Color existingColor;
					JButton colorPickerBtn;

					if (existing == null)
					{
						existingColor = Color.BLACK;
						colorPickerBtn = new JButton("Pick a color");
					}
					else
					{
						existingColor = ColorUtil.fromString(existing);
						colorPickerBtn = new JButton(ColorUtil.toHexColor(existingColor).toUpperCase());
					}

					colorPickerBtn.setFocusable(false);
					colorPickerBtn.setBackground(existingColor);
					colorPickerBtn.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							RuneliteColorPicker colorPicker = colorPickerManager.create(
								SwingUtilities.windowForComponent(ConfigPanel.this),
								colorPickerBtn.getBackground(),
								cid.getItem().name(),
								cid.getAlpha() == null);
							colorPicker.setLocation(getLocationOnScreen());
							colorPicker.setOnColorChange(c ->
							{
								colorPickerBtn.setBackground(c);
								colorPickerBtn.setText(ColorUtil.toHexColor(c).toUpperCase());
							});

							colorPicker.setOnClose(c -> changeConfiguration(listItem, config, colorPicker, cd, cid));
							colorPicker.setVisible(true);
						}
					});

					item.add(colorPickerBtn, BorderLayout.EAST);
				}

				else if (cid.getType() == Dimension.class)
				{
					JPanel dimensionPanel = new JPanel();
					dimensionPanel.setLayout(new BorderLayout());

					String str = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());
					String[] splitStr = str.split("x");
					int width = Integer.parseInt(splitStr[0]);
					int height = Integer.parseInt(splitStr[1]);

					SpinnerModel widthModel = new SpinnerNumberModel(width, 0, Integer.MAX_VALUE, 1);
					JSpinner widthSpinner = new JSpinner(widthModel);
					Component widthEditor = widthSpinner.getEditor();
					JFormattedTextField widthSpinnerTextField = ((JSpinner.DefaultEditor) widthEditor).getTextField();
					widthSpinnerTextField.setColumns(4);

					SpinnerModel heightModel = new SpinnerNumberModel(height, 0, Integer.MAX_VALUE, 1);
					JSpinner heightSpinner = new JSpinner(heightModel);
					Component heightEditor = heightSpinner.getEditor();
					JFormattedTextField heightSpinnerTextField = ((JSpinner.DefaultEditor) heightEditor).getTextField();
					heightSpinnerTextField.setColumns(4);

					ChangeListener listener = e ->
						configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), widthSpinner.getValue() + "x" + heightSpinner.getValue());

					widthSpinner.addChangeListener(listener);
					heightSpinner.addChangeListener(listener);

					dimensionPanel.add(widthSpinner, BorderLayout.WEST);
					dimensionPanel.add(new JLabel(" x "), BorderLayout.CENTER);
					dimensionPanel.add(heightSpinner, BorderLayout.EAST);

					item.add(dimensionPanel, BorderLayout.EAST);
				}

				else if (cid.getType().isEnum())
				{
					Class<? extends Enum> type = (Class<? extends Enum>) cid.getType();
					JComboBox box = new JComboBox(type.getEnumConstants());
					box.setPreferredSize(new Dimension(box.getPreferredSize().width, 25));
					box.setRenderer(new ComboBoxListRenderer());
					box.setForeground(Color.WHITE);
					box.setFocusable(false);
					box.setPrototypeDisplayValue("XXXXXXXX"); //sorry but this is the way to keep the size of the combobox in check.
					try
					{
						Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));
						box.setSelectedItem(selectedItem);
						box.setToolTipText(selectedItem.toString());
					}
					catch (IllegalArgumentException ex)
					{
						log.debug("invalid seleced item", ex);
					}
					box.addItemListener(e ->
					{
						if (e.getStateChange() == ItemEvent.SELECTED)
						{
							changeConfiguration(listItem, config, box, cd, cid);
							box.setToolTipText(Objects.requireNonNull(box.getSelectedItem()).toString());
						}
					});
					item.add(box, BorderLayout.EAST);
				}

				else if (cid.getType() == Keybind.class || cid.getType() == ModifierlessKeybind.class)
				{
					Keybind startingValue = configManager.getConfiguration(cd.getGroup().value(),
						cid.getItem().keyName(),
						(Class<? extends Keybind>) cid.getType());

					HotkeyButton button = new HotkeyButton(startingValue, cid.getType() == ModifierlessKeybind.class);

					button.addFocusListener(new FocusAdapter()
					{
						@Override
						public void focusLost(FocusEvent e)
						{
							changeConfiguration(listItem, config, button, cd, cid);
						}
					});

					item.add(button, BorderLayout.EAST);
				}

				if (cid.getType() == Font.class)
				{
					JComboBox box = new JComboBox(FontManager.getAvailableFontNames());
					box.setPreferredSize(new Dimension(150, 25));
					box.setRenderer(new ComboBoxListRenderer());
					box.setForeground(Color.WHITE);
					box.setFocusable(false);
					String currentlyConfigured = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());
					if (FontManager.lookupFont(currentlyConfigured) != null)
					{
						box.setSelectedItem(currentlyConfigured);
						box.setToolTipText(currentlyConfigured);
					}
					else
					{
						log.debug("Selected font wasn't found on this system, resetting font back to runescape regular");
						configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), FontManager.getRunescapeFont());
					}
					box.addItemListener(e ->
					{
						if (e.getStateChange() == ItemEvent.SELECTED && box.getSelectedItem() != null)
						{
							final Font selected = FontManager.lookupFont(box.getSelectedItem().toString());
							configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), selected);
							box.setToolTipText(box.getSelectedItem().toString());
						}
					});
					item.add(box, BorderLayout.EAST);
				}

				mainPanel.add(item);
			}
		}

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener((e) ->
		{
			final int result = JOptionPane.showOptionDialog(resetButton, "Are you sure you want to reset this plugin's configuration?",
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result == JOptionPane.YES_OPTION)
			{
				configManager.setDefaultConfiguration(config, true);

				// Reload configuration panel
				openGroupConfigPanel(listItem, config, cd);
			}
		});
		mainPanel.add(resetButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> openConfigList());
		mainPanel.add(backButton);

		if (refresh)
		{
			scrollPane.getVerticalScrollBar().setValue(scrollBarPosition);
		}
		else
		{
			scrollPane.getVerticalScrollBar().setValue(0);
		}
		revalidate();
	}

	private void changeGroupCollapse(PluginListItem listItem, Config config, JComponent component, ConfigDescriptor cd, ConfigItemsGroup cig)
	{
		if (component instanceof JButton)
		{

			String sCollapsed = configManager.getConfiguration(cd.getGroup().value(), cig.getGroup() + "_collapse");
			boolean collapse = true;

			if (sCollapsed != null)
			{
				collapse = !Boolean.parseBoolean(sCollapsed);
			}

			configManager.setConfiguration(cd.getGroup().value(), cig.getGroup() + "_collapse", collapse);

			reloadPluginlist(listItem, config, cd);
		}
	}

	private void changeConfiguration(PluginListItem listItem, Config config, Component component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		final ConfigItem configItem = cid.getItem();

		if (!Strings.isNullOrEmpty(configItem.warning()))
		{
			final int result = JOptionPane.showOptionDialog(component, configItem.warning(),
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				openGroupConfigPanel(listItem, config, cd);
				return;
			}
		}

		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + checkbox.isSelected());

			for (ConfigItemDescriptor cid2 : cd.getItems())
			{
				if (cid2.getItem().hidden() || !cid2.getItem().hide().isEmpty())
				{
					List<String> itemHide = Splitter
						.onPattern("\\|\\|")
						.trimResults()
						.omitEmptyStrings()
						.splitToList(String.format("%s || %s", cid2.getItem().unhide(), cid2.getItem().hide()));

					if (itemHide.contains(cid.getItem().keyName()))
					{
						// If another options visibility changes depending on the value of this checkbox, then render the entire menu again
						reloadPluginlist(listItem, config, cd);
					}
				}

				if (checkbox.isSelected())
				{
					if (cid2.getItem().enabledBy().contains(cid.getItem().keyName()))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "true");
						reloadPluginlist(listItem, config, cd);
					}
					else if (cid2.getItem().disabledBy().contains(cid.getItem().keyName()))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "false");
						reloadPluginlist(listItem, config, cd);
					}
				}
			}
		}
		else if (component instanceof JSpinner)
		{
			JSpinner spinner = (JSpinner) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + spinner.getValue());
		}
		else if (component instanceof JTextComponent)
		{
			JTextComponent textField = (JTextComponent) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), textField.getText());
		}
		else if (component instanceof RuneliteColorPicker)
		{
			RuneliteColorPicker colorPicker = (RuneliteColorPicker) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), colorPicker.getSelectedColor().getRGB() + "");
		}
		else if (component instanceof JComboBox)
		{
			JComboBox jComboBox = (JComboBox) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), ((Enum) Objects.requireNonNull(jComboBox.getSelectedItem())).name());

			for (ConfigItemDescriptor cid2 : cd.getItems())
			{
				if (cid2.getItem().hidden() || !cid2.getItem().hide().isEmpty())
				{
					List<String> itemHide = Splitter
						.onPattern("\\|\\|")
						.trimResults()
						.omitEmptyStrings()
						.splitToList(String.format("%s || %s", cid2.getItem().unhide(), cid2.getItem().hide()));

					if (itemHide.contains(cid.getItem().keyName()))
					{
						reloadPluginlist(listItem, config, cd);
					}

					String changedVal = ((Enum) jComboBox.getSelectedItem()).name();

					if (cid2.getItem().enabledBy().contains(cid.getItem().keyName()) && cid2.getItem().enabledByValue().equals(changedVal))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "true");
						reloadPluginlist(listItem, config, cd);
					}
					else if (cid2.getItem().disabledBy().contains(cid.getItem().keyName()) && cid2.getItem().disabledByValue().equals(changedVal))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "false");
						reloadPluginlist(listItem, config, cd);
					}
				}
			}
		}
		else if (component instanceof HotkeyButton)
		{
			HotkeyButton hotkeyButton = (HotkeyButton) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), hotkeyButton.getValue());
		}
		else if (component instanceof JSlider)
		{
			JSlider slider = (JSlider) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), slider.getValue());
		}
	}

	void startPlugin(Plugin plugin, PluginListItem listItem)
	{
		executorService.submit(() ->
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

			listItem.setPluginEnabled(true);
		});
	}

	void stopPlugin(Plugin plugin, PluginListItem listItem)
	{
		executorService.submit(() ->
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

			listItem.setPluginEnabled(false);
		});
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
			.map(PluginListItem::getName)
			.collect(Collectors.joining(","));

		configManager.setConfiguration(RUNELITE_GROUP_NAME, PINNED_PLUGINS_CONFIG_KEY, value);
	}

	void openConfigurationPanel(String configGroup)
	{
		for (PluginListItem pluginListItem : pluginList)
		{
			if (pluginListItem.getName().equals(configGroup))
			{
				openGroupConfigPanel(pluginListItem, pluginListItem.getConfig(), pluginListItem.getConfigDescriptor());
				break;
			}
		}
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

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(PANEL_WIDTH + SCROLLBAR_WIDTH, super.getPreferredSize().height);
	}

	private class FixedWidthPanel extends JPanel
	{
		@Override
		public Dimension getPreferredSize()
		{
			return new Dimension(PANEL_WIDTH, super.getPreferredSize().height);
		}

	}

	private void reloadPluginlist(PluginListItem listItem, Config config, ConfigDescriptor cd)
	{
		openGroupConfigPanel(listItem, config, cd, true);
	}
}