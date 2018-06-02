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

import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ComboBoxListRenderer;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.util.SwingUtil;

@Slf4j
public class ConfigPanel extends PluginPanel
{
	private static final int SPINNER_FIELD_WIDTH = 6;

	private static final ImageIcon CONFIG_ICON;
	private static final ImageIcon CONFIG_ICON_HOVER;
	private static final ImageIcon ON_SWITCHER;
	private static final ImageIcon OFF_SWITCHER;
	private static final ImageIcon SEARCH;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				BufferedImage configIcon = ImageIO.read(ConfigPanel.class.getResourceAsStream("config_edit_icon.png"));
				CONFIG_ICON = new ImageIcon(configIcon);
				CONFIG_ICON_HOVER = new ImageIcon(SwingUtil.grayscaleOffset(configIcon, -100));
				ON_SWITCHER = new ImageIcon(ImageIO.read(ConfigPanel.class.getResourceAsStream("switchers/on.png")));
				OFF_SWITCHER = new ImageIcon(ImageIO.read(ConfigPanel.class.getResourceAsStream("switchers/off.png")));
				SEARCH = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	private final PluginManager pluginManager;
	private final ConfigManager configManager;
	private final ScheduledExecutorService executorService;
	private final RuneLiteConfig runeLiteConfig;
	private final ChatColorConfig chatColorConfig;
	private final IconTextField searchBar = new IconTextField();
	private Map<String, JPanel> children = new TreeMap<>();
	private int scrollBarPosition = 0;

	public ConfigPanel(PluginManager pluginManager, ConfigManager configManager, ScheduledExecutorService executorService,
		RuneLiteConfig runeLiteConfig, ChatColorConfig chatColorConfig)
	{
		super();
		this.pluginManager = pluginManager;
		this.configManager = configManager;
		this.executorService = executorService;
		this.runeLiteConfig = runeLiteConfig;
		this.chatColorConfig = chatColorConfig;

		searchBar.setIcon(SEARCH);
		searchBar.setPreferredSize(new Dimension(100, 30));
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

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new DynamicGridLayout(0, 1, 0, 5));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		rebuildPluginList();
		openConfigList();
	}

	final void rebuildPluginList()
	{
		scrollBarPosition = getScrollPane().getVerticalScrollBar().getValue();
		Map<String, JPanel> newChildren = new TreeMap<>();

		pluginManager.getPlugins().stream()
			.filter(plugin -> !plugin.getClass().getAnnotation(PluginDescriptor.class).hidden())
			.sorted(Comparator.comparing(left -> left.getClass().getAnnotation(PluginDescriptor.class).name()))
			.forEach(plugin ->
			{
				final Config pluginConfigProxy = pluginManager.getPluginConfigProxy(plugin);
				final String pluginName = plugin.getClass().getAnnotation(PluginDescriptor.class).name();

				final JPanel groupPanel = buildGroupPanel();

				JLabel name = new JLabel(pluginName);
				name.setForeground(Color.WHITE);

				groupPanel.add(name, BorderLayout.CENTER);

				final JPanel buttonPanel = new JPanel();
				buttonPanel.setLayout(new GridLayout(1, 2));
				groupPanel.add(buttonPanel, BorderLayout.LINE_END);

				final JLabel editConfigButton = buildConfigButton(pluginConfigProxy);
				buttonPanel.add(editConfigButton);

				final JLabel toggleButton = buildToggleButton(plugin);
				toggleButton.setHorizontalAlignment(SwingConstants.RIGHT);
				buttonPanel.add(toggleButton);

				newChildren.put(pluginName, groupPanel);
			});

		addCoreConfig(newChildren, "RuneLite", runeLiteConfig);
		addCoreConfig(newChildren, "Chat Color", chatColorConfig);

		children = newChildren;
		openConfigList();
	}

	private void addCoreConfig(Map<String, JPanel> newChildren, String configName, Config config)
	{
		final JPanel groupPanel = buildGroupPanel();

		JLabel name = new JLabel(configName);
		name.setForeground(Color.WHITE);

		groupPanel.add(name, BorderLayout.CENTER);

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		groupPanel.add(buttonPanel, BorderLayout.LINE_END);

		final JLabel editConfigButton = buildConfigButton(config);
		buttonPanel.add(editConfigButton);

		final JLabel toggleButton = buildToggleButton(null);
		toggleButton.setVisible(false);
		buttonPanel.add(toggleButton);

		newChildren.put(configName, groupPanel);
	}

	private JPanel buildGroupPanel()
	{
		// Create base panel for the config button and enabled/disabled button
		final JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new BorderLayout(3, 0));
		groupPanel.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH, 20));
		return groupPanel;
	}

	private JLabel buildConfigButton(Config config)
	{
		// Create edit config button and disable it by default
		final JLabel editConfigButton = new JLabel(CONFIG_ICON);
		editConfigButton.setPreferredSize(new Dimension(25, 0));
		editConfigButton.setVisible(false);

		// If we have configuration proxy enable the button and add edit config listener
		if (config != null)
		{
			final ConfigDescriptor configDescriptor = configManager.getConfigDescriptor(config);
			final boolean configEmpty = configDescriptor.getItems().stream().allMatch(item -> item.getItem().hidden());

			if (!configEmpty)
			{
				editConfigButton.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent mouseEvent)
					{
						editConfigButton.setIcon(CONFIG_ICON);
						openGroupConfigPanel(config, configDescriptor, configManager);
					}

					@Override
					public void mouseEntered(MouseEvent e)
					{
						editConfigButton.setIcon(CONFIG_ICON_HOVER);
					}

					@Override
					public void mouseExited(MouseEvent e)
					{
						editConfigButton.setIcon(CONFIG_ICON);
					}
				});
				editConfigButton.setVisible(true);
				editConfigButton.setToolTipText("Edit plugin configuration");
			}
		}

		return editConfigButton;
	}

	private JLabel buildToggleButton(Plugin plugin)
	{
		// Create enabling/disabling button
		final JLabel toggleButton = new JLabel(ON_SWITCHER);
		toggleButton.setPreferredSize(new Dimension(25, 0));

		if (plugin == null)
		{
			toggleButton.setEnabled(false);
			return toggleButton;
		}

		highlightButton(toggleButton, pluginManager.isPluginEnabled(plugin));

		toggleButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				executorService.submit(() ->
				{
					final boolean enabled = pluginManager.isPluginEnabled(plugin);
					pluginManager.setPluginEnabled(plugin, !enabled);

					try
					{
						if (enabled)
						{
							pluginManager.stopPlugin(plugin);
						}
						else
						{
							pluginManager.startPlugin(plugin);
						}
					}
					catch (PluginInstantiationException ex)
					{
						log.warn("Error during starting/stopping plugin {}", plugin.getClass().getSimpleName(), ex);
					}

					highlightButton(toggleButton, !enabled);
				});
			}
		});

		return toggleButton;
	}

	private void highlightButton(JLabel button, boolean enabled)
	{
		button.setIcon(enabled ? ON_SWITCHER : OFF_SWITCHER);
		button.setToolTipText(enabled ? "Disable plugin" : "Enable plugin");
	}

	private void onSearchBarChanged()
	{
		final String text = searchBar.getText();

		children.values().forEach(this::remove);

		if (text.isEmpty())
		{
			children.values().forEach(this::add);
			revalidate();
			return;
		}

		FuzzySearch.findAndProcess(text, children.keySet(), (k) -> add(children.get(k)));
		revalidate();
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

	private void openConfigList()
	{
		removeAll();

		JLabel title = new JLabel("Configuration", SwingConstants.LEFT);
		title.setForeground(Color.WHITE);

		add(title);
		add(searchBar);

		onSearchBarChanged();
		searchBar.requestFocusInWindow();
		JScrollPane scrollbar = getScrollPane();
		scrollbar.validate();
		scrollbar.getVerticalScrollBar().setValue(scrollBarPosition);
	}

	private void changeConfiguration(Config config, JComponent component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		ConfigItem configItem = cid.getItem();

		if (!Strings.isNullOrEmpty(configItem.warning()))
		{
			final int result = JOptionPane.showOptionDialog(component, configItem.warning(),
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				openGroupConfigPanel(config, cd, configManager);
				return;
			}
		}

		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), "" + checkbox.isSelected());
		}

		if (component instanceof JSpinner)
		{
			JSpinner spinner = (JSpinner) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), "" + spinner.getValue());
		}

		if (component instanceof JTextArea)
		{
			JTextArea textField = (JTextArea) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), textField.getText());
		}

		if (component instanceof JColorChooser)
		{
			JColorChooser jColorChooser = (JColorChooser) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), String.valueOf(jColorChooser.getColor().getRGB()));
		}

		if (component instanceof JComboBox)
		{
			JComboBox jComboBox = (JComboBox) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), ((Enum) jComboBox.getSelectedItem()).name());
		}
	}

	private void openGroupConfigPanel(Config config, ConfigDescriptor cd, ConfigManager configManager)
	{
		scrollBarPosition = getScrollPane().getVerticalScrollBar().getValue();
		removeAll();
		String name = cd.getGroup().name() + " Configuration";
		JLabel title = new JLabel(name, SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setToolTipText(cd.getGroup().description());
		add(title);

		for (ConfigItemDescriptor cid : cd.getItems())
		{
			if (cid.getItem().hidden())
			{
				continue;
			}

			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			name = cid.getItem().name();
			JLabel configEntryName = new JLabel(name);
			configEntryName.setForeground(Color.WHITE);
			configEntryName.setToolTipText("<html>" + name + ":<br>" + cid.getItem().description() + "</html>");
			item.add(configEntryName, BorderLayout.CENTER);

			if (cid.getType() == boolean.class)
			{
				JCheckBox checkbox = new JCheckBox();
				checkbox.setBackground(ColorScheme.LIGHT_GRAY_COLOR);
				checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
				checkbox.addActionListener(ae -> changeConfiguration(config, checkbox, cd, cid));

				item.add(checkbox, BorderLayout.EAST);
			}

			if (cid.getType() == int.class)
			{
				int value = Integer.parseInt(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));

				SpinnerModel model = new SpinnerNumberModel(value, 0, Integer.MAX_VALUE, 1);
				JSpinner spinner = new JSpinner(model);
				Component editor = spinner.getEditor();
				JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
				spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
				spinner.addChangeListener(ce -> changeConfiguration(config, spinner, cd, cid));

				item.add(spinner, BorderLayout.EAST);
			}

			if (cid.getType() == String.class)
			{
				JTextArea textField = new JTextArea();
				textField.setLineWrap(true);
				textField.setWrapStyleWord(true);
				textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				textField.setText(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));

				textField.addFocusListener(new FocusAdapter()
				{
					@Override
					public void focusLost(FocusEvent e)
					{
						changeConfiguration(config, textField, cd, cid);
						textField.setToolTipText(textField.getText());
					}
				});

				textField.setToolTipText(textField.getText());
				item.add(textField, BorderLayout.SOUTH);
			}

			if (cid.getType() == Color.class)
			{
				String existing = configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName());
				Color existingColor = existing == null ? Color.BLACK : Color.decode(existing);

				JButton colorPicker = new JButton("Pick a color");
				colorPicker.setFocusable(false);
				colorPicker.setBackground(existingColor);
				colorPicker.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						final JFrame parent = new JFrame();
						JColorChooser jColorChooser = new JColorChooser(existingColor);
						jColorChooser.getSelectionModel().addChangeListener(e1 -> colorPicker.setBackground(jColorChooser.getColor()));
						parent.addWindowListener(new WindowAdapter()
						{
							@Override
							public void windowClosing(WindowEvent e)
							{
								changeConfiguration(config, jColorChooser, cd, cid);
							}
						});
						parent.add(jColorChooser);
						parent.pack();
						parent.setVisible(true);
					}
				});
				item.add(colorPicker, BorderLayout.EAST);
			}

			if (cid.getType() == Dimension.class)
			{
				JPanel dimensionPanel = new JPanel();
				dimensionPanel.setLayout(new BorderLayout());

				String str = configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName());
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
					configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), widthSpinner.getValue() + "x" + heightSpinner.getValue());

				widthSpinner.addChangeListener(listener);
				heightSpinner.addChangeListener(listener);

				dimensionPanel.add(widthSpinner, BorderLayout.WEST);
				dimensionPanel.add(new JLabel(" x "), BorderLayout.CENTER);
				dimensionPanel.add(heightSpinner, BorderLayout.EAST);

				item.add(dimensionPanel, BorderLayout.EAST);
			}

			if (cid.getType().isEnum())
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
					Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));
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
						changeConfiguration(config, box, cd, cid);
						box.setToolTipText(box.getSelectedItem().toString());
					}
				});
				item.add(box, BorderLayout.EAST);
			}

			add(item);
		}

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener((e) ->
		{
			configManager.setDefaultConfiguration(config, true);

			// Reload configuration panel
			openGroupConfigPanel(config, cd, configManager);
		});
		add(resetButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> openConfigList());
		add(backButton);

		revalidate();
		getScrollPane().getVerticalScrollBar().setValue(0);
	}
}