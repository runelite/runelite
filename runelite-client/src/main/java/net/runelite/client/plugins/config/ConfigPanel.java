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

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.ConfigObject;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ConfigSectionDescriptor;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.config.Notification;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ColorJButton;
import net.runelite.client.ui.components.TitleCaseListCellRenderer;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@Slf4j
class ConfigPanel extends PluginPanel
{
	private static final int SPINNER_FIELD_WIDTH = 6;
	private static final ImageIcon SECTION_EXPAND_ICON;
	private static final ImageIcon SECTION_RETRACT_ICON;
	static final ImageIcon CONFIG_ICON;
	static final ImageIcon BACK_ICON;

	private static final Map<ConfigSectionDescriptor, Boolean> sectionExpandStates = new HashMap<>();

	static
	{
		final BufferedImage backIcon = ImageUtil.loadImageResource(ConfigPanel.class, "config_back_icon.png");
		BACK_ICON = new ImageIcon(backIcon);

		BufferedImage sectionRetractIcon = ImageUtil.loadImageResource(ConfigPanel.class, "/util/arrow_right.png");
		sectionRetractIcon = ImageUtil.luminanceOffset(sectionRetractIcon, -121);
		SECTION_EXPAND_ICON = new ImageIcon(sectionRetractIcon);
		final BufferedImage sectionExpandIcon = ImageUtil.rotateImage(sectionRetractIcon, Math.PI / 2);
		SECTION_RETRACT_ICON = new ImageIcon(sectionExpandIcon);
		BufferedImage configIcon = ImageUtil.loadImageResource(ConfigPanel.class, "config_edit_icon.png");
		CONFIG_ICON = new ImageIcon(configIcon);
	}

	private final PluginListPanel pluginList;
	private final ConfigManager configManager;
	private final PluginManager pluginManager;
	private final ExternalPluginManager externalPluginManager;
	private final ColorPickerManager colorPickerManager;
	private final Provider<NotificationPanel> notificationPanelProvider;

	private final TitleCaseListCellRenderer listCellRenderer = new TitleCaseListCellRenderer();

	private final FixedWidthPanel mainPanel;
	private final JLabel title;
	private final PluginToggleButton pluginToggle;

	private PluginConfigurationDescriptor pluginConfig = null;

	@Inject
	private ConfigPanel(
		PluginListPanel pluginList,
		ConfigManager configManager,
		PluginManager pluginManager,
		ExternalPluginManager externalPluginManager,
		ColorPickerManager colorPickerManager,
		Provider<NotificationPanel> notificationPanelProvider
	)
	{
		super(false);

		this.pluginList = pluginList;
		this.configManager = configManager;
		this.pluginManager = pluginManager;
		this.externalPluginManager = externalPluginManager;
		this.colorPickerManager = colorPickerManager;
		this.notificationPanelProvider = notificationPanelProvider;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		topPanel.setLayout(new BorderLayout(0, BORDER_OFFSET));
		add(topPanel, BorderLayout.NORTH);

		mainPanel = new FixedWidthPanel();
		mainPanel.setBorder(new EmptyBorder(8, 10, 10, 10));
		mainPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel northPanel = new FixedWidthPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(mainPanel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(northPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);

		JButton topPanelBackButton = new JButton(BACK_ICON);
		SwingUtil.removeButtonDecorations(topPanelBackButton);
		topPanelBackButton.setPreferredSize(new Dimension(22, 0));
		topPanelBackButton.setBorder(new EmptyBorder(0, 0, 0, 5));
		topPanelBackButton.addActionListener(e -> pluginList.getMuxer().popState());
		topPanelBackButton.setToolTipText("Back");
		topPanel.add(topPanelBackButton, BorderLayout.WEST);

		pluginToggle = new PluginToggleButton();
		topPanel.add(pluginToggle, BorderLayout.EAST);
		title = new JLabel();
		title.setForeground(Color.WHITE);

		topPanel.add(title);
	}

	void init(PluginConfigurationDescriptor pluginConfig)
	{
		assert this.pluginConfig == null;
		this.pluginConfig = pluginConfig;

		String name = pluginConfig.getName();
		title.setText(name);
		title.setForeground(Color.WHITE);
		title.setToolTipText("<html>" + name + ":<br>" + pluginConfig.getDescription() + "</html>");

		String iname = pluginConfig.getInternalPluginHubName();
		JMenuItem uninstallItem = null;
		if (iname != null)
		{
			uninstallItem = new JMenuItem("Uninstall");
			uninstallItem.addActionListener(ev -> externalPluginManager.remove(iname));
		}

		PluginListItem.addLabelPopupMenu(title, pluginConfig.createSupportMenuItem(), uninstallItem);

		if (pluginConfig.getPlugin() != null)
		{
			pluginToggle.setConflicts(pluginConfig.getConflicts());
			pluginToggle.setSelected(pluginManager.isPluginEnabled(pluginConfig.getPlugin()));
			pluginToggle.addItemListener(i ->
			{
				if (pluginToggle.isSelected())
				{
					pluginList.startPlugin(pluginConfig.getPlugin());
				}
				else
				{
					pluginList.stopPlugin(pluginConfig.getPlugin());
				}
			});
		}
		else
		{
			pluginToggle.setVisible(false);
		}

		rebuild();
	}

	private void toggleSection(ConfigSectionDescriptor csd, JButton button, JPanel contents)
	{
		boolean newState = !contents.isVisible();
		contents.setVisible(newState);
		button.setIcon(newState ? SECTION_RETRACT_ICON : SECTION_EXPAND_ICON);
		button.setToolTipText(newState ? "Retract" : "Expand");
		sectionExpandStates.put(csd, newState);
		SwingUtilities.invokeLater(contents::revalidate);
	}

	private void rebuild()
	{
		mainPanel.removeAll();

		ConfigDescriptor cd = pluginConfig.getConfigDescriptor();

		final Map<String, JPanel> sectionWidgets = new HashMap<>();
		final Map<ConfigObject, JPanel> topLevelPanels = new TreeMap<>((a, b) ->
			ComparisonChain.start()
			.compare(a.position(), b.position())
			.compare(a.name(), b.name())
			.result());

		for (ConfigSectionDescriptor csd : cd.getSections())
		{
			ConfigSection cs = csd.getSection();
			final boolean isOpen = sectionExpandStates.getOrDefault(csd, !cs.closedByDefault());

			final JPanel section = new JPanel();
			section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
			section.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

			final JPanel sectionHeader = new JPanel();
			sectionHeader.setLayout(new BorderLayout());
			sectionHeader.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
			// For whatever reason, the header extends out by a single pixel when closed. Adding a single pixel of
			// border on the right only affects the width when closed, fixing the issue.
			sectionHeader.setBorder(new CompoundBorder(
				new MatteBorder(0, 0, 1, 0, ColorScheme.MEDIUM_GRAY_COLOR),
				new EmptyBorder(0, 0, 3, 1)));
			section.add(sectionHeader, BorderLayout.NORTH);

			final JButton sectionToggle = new JButton(isOpen ? SECTION_RETRACT_ICON : SECTION_EXPAND_ICON);
			sectionToggle.setPreferredSize(new Dimension(18, 0));
			sectionToggle.setBorder(new EmptyBorder(0, 0, 0, 5));
			sectionToggle.setToolTipText(isOpen ? "Retract" : "Expand");
			SwingUtil.removeButtonDecorations(sectionToggle);
			sectionHeader.add(sectionToggle, BorderLayout.WEST);

			String name = cs.name();
			final JLabel sectionName = new JLabel(name);
			sectionName.setForeground(ColorScheme.BRAND_ORANGE);
			sectionName.setFont(FontManager.getRunescapeBoldFont());
			sectionName.setToolTipText("<html>" + name + ":<br>" + cs.description() + "</html>");
			sectionHeader.add(sectionName, BorderLayout.CENTER);

			final JPanel sectionContents = new JPanel();
			sectionContents.setLayout(new DynamicGridLayout(0, 1, 0, 5));
			sectionContents.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
			sectionContents.setBorder(new CompoundBorder(
				new MatteBorder(0, 0, 1, 0, ColorScheme.MEDIUM_GRAY_COLOR),
				new EmptyBorder(BORDER_OFFSET, 0, BORDER_OFFSET, 0)));
			sectionContents.setVisible(isOpen);
			section.add(sectionContents, BorderLayout.SOUTH);

			// Add listeners to each part of the header so that it's easier to toggle them
			final MouseAdapter adapter = new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					toggleSection(csd, sectionToggle, sectionContents);
				}
			};
			sectionToggle.addActionListener(actionEvent -> toggleSection(csd, sectionToggle, sectionContents));
			sectionName.addMouseListener(adapter);
			sectionHeader.addMouseListener(adapter);

			sectionWidgets.put(csd.getKey(), sectionContents);

			topLevelPanels.put(csd, section);
		}

		for (ConfigItemDescriptor cid : cd.getItems())
		{
			if (cid.getItem().hidden())
			{
				continue;
			}

			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
			String name = cid.getItem().name();
			JLabel configEntryName = new JLabel(name);
			configEntryName.setForeground(Color.WHITE);
			String description = cid.getItem().description();
			if (!"".equals(description))
			{
				configEntryName.setToolTipText("<html>" + name + ":<br>" + description + "</html>");
			}
			PluginListItem.addLabelPopupMenu(configEntryName, createResetMenuItem(pluginConfig, cid));
			item.add(configEntryName, BorderLayout.CENTER);

			if (cid.getType() == boolean.class)
			{
				item.add(createCheckbox(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() == int.class)
			{
				item.add(createIntSpinner(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() == double.class)
			{
				item.add(createDoubleSpinner(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() == String.class)
			{
				item.add(createTextField(cd, cid), BorderLayout.SOUTH);
			}
			else if (cid.getType() == Color.class)
			{
				item.add(createColorPicker(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() == Dimension.class)
			{
				item.add(createDimension(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() instanceof Class && ((Class<?>) cid.getType()).isEnum())
			{
				item.add(createComboBox(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() == Keybind.class || cid.getType() == ModifierlessKeybind.class)
			{
				item.add(createKeybind(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() == Notification.class)
			{
				item.add(createNotification(cd, cid), BorderLayout.EAST);
			}
			else if (cid.getType() instanceof ParameterizedType)
			{
				ParameterizedType parameterizedType = (ParameterizedType) cid.getType();
				if (parameterizedType.getRawType() == Set.class)
				{
					item.add(createList(cd, cid), BorderLayout.EAST);
				}
			}

			JPanel section = sectionWidgets.get(cid.getItem().section());
			if (section == null)
			{
				topLevelPanels.put(cid, item);
			}
			else
			{
				section.add(item);
			}
		}

		topLevelPanels.values().forEach(mainPanel::add);

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener((e) ->
		{
			final int result = JOptionPane.showOptionDialog(resetButton, "Are you sure you want to reset this plugin's configuration?",
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result == JOptionPane.YES_OPTION)
			{
				configManager.setDefaultConfiguration(pluginConfig.getConfig(), true);

				// Reset non-config panel keys
				Plugin plugin = pluginConfig.getPlugin();
				if (plugin != null)
				{
					plugin.resetConfiguration();
				}

				rebuild();
			}
		});
		mainPanel.add(resetButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> pluginList.getMuxer().popState());
		mainPanel.add(backButton);

		revalidate();
	}

	private JCheckBox createCheckbox(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		JCheckBox checkbox = new JCheckBox();
		checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName())));
		checkbox.addActionListener(ae -> changeConfiguration(checkbox, cd, cid));
		return checkbox;
	}

	private JSpinner createIntSpinner(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		int value = MoreObjects.firstNonNull(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName(), int.class), 0);

		Range range = cid.getRange();
		int min = 0, max = Integer.MAX_VALUE;
		if (range != null)
		{
			min = range.min();
			max = range.max();
		}

		// Config may previously have been out of range
		value = Ints.constrainToRange(value, min, max);

		SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
		JSpinner spinner = new JSpinner(model);
		Component editor = spinner.getEditor();
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
		spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
		spinner.addChangeListener(ce -> changeConfiguration(spinner, cd, cid));

		Units units = cid.getUnits();
		if (units != null)
		{
			spinnerTextField.setFormatterFactory(new UnitFormatterFactory(units.value()));
		}

		return spinner;
	}

	private JSpinner createDoubleSpinner(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		double value = MoreObjects.firstNonNull(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName(), double.class), 0d);

		SpinnerModel model = new SpinnerNumberModel(value, 0, Double.MAX_VALUE, 0.1);
		JSpinner spinner = new JSpinner(model);
		Component editor = spinner.getEditor();
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
		spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
		spinner.addChangeListener(ce -> changeConfiguration(spinner, cd, cid));

		Units units = cid.getUnits();
		if (units != null)
		{
			spinnerTextField.setFormatterFactory(new UnitFormatterFactory(units.value()));
		}

		return spinner;
	}

	private JTextComponent createTextField(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		JTextComponent textField;

		if (cid.getItem().secret())
		{
			textField = new JPasswordField();
		}
		else
		{
			final JTextArea textArea = new JTextArea();
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
				changeConfiguration(textField, cd, cid);
			}
		});

		return textField;
	}

	private ColorJButton createColorPicker(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		Color existing = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName(), Color.class);

		ColorJButton colorPickerBtn;

		boolean alphaHidden = cid.getAlpha() == null;

		if (existing == null)
		{
			colorPickerBtn = new ColorJButton("Pick a color", Color.BLACK);
		}
		else
		{
			String colorHex = "#" + (alphaHidden ? ColorUtil.colorToHexCode(existing) : ColorUtil.colorToAlphaHexCode(existing)).toUpperCase();
			colorPickerBtn = new ColorJButton(colorHex, existing);
		}

		colorPickerBtn.setFocusable(false);
		colorPickerBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				RuneliteColorPicker colorPicker = colorPickerManager.create(
					SwingUtilities.windowForComponent(ConfigPanel.this),
					colorPickerBtn.getColor(),
					cid.getItem().name(),
					alphaHidden);
				colorPicker.setLocationRelativeTo(colorPickerBtn);
				colorPicker.setOnColorChange(c ->
				{
					colorPickerBtn.setColor(c);
					colorPickerBtn.setText("#" + (alphaHidden ? ColorUtil.colorToHexCode(c) : ColorUtil.colorToAlphaHexCode(c)).toUpperCase());
				});
				colorPicker.setOnClose(c -> changeConfiguration(colorPicker, cd, cid));
				colorPicker.setVisible(true);
			}
		});

		return colorPickerBtn;
	}

	private JPanel createDimension(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		JPanel dimensionPanel = new JPanel();
		dimensionPanel.setLayout(new BorderLayout());

		Dimension dimension = MoreObjects.firstNonNull(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName(), Dimension.class), new Dimension());
		int width = dimension.width;
		int height = dimension.height;

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

		return dimensionPanel;
	}

	private JComboBox<Enum<?>> createComboBox(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		Class<? extends Enum> type = (Class<? extends Enum>) cid.getType();

		JComboBox<Enum<?>> box = new JComboBox<Enum<?>>(type.getEnumConstants()); // NOPMD: UseDiamondOperator
		// set renderer prior to calling box.getPreferredSize(), since it will invoke the renderer
		// to build components for each combobox element in order to compute the display size of the
		// combobox
		box.setRenderer(listCellRenderer);
		box.setPreferredSize(new Dimension(box.getPreferredSize().width, 22));

		try
		{
			Enum<?> selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));
			box.setSelectedItem(selectedItem);
			box.setToolTipText(Text.titleCase(selectedItem));
		}
		catch (IllegalArgumentException ex)
		{
			log.debug("invalid selected item", ex);
		}
		box.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				changeConfiguration(box, cd, cid);
				box.setToolTipText(Text.titleCase((Enum<?>) box.getSelectedItem()));
			}
		});

		return box;
	}

	private HotkeyButton createKeybind(ConfigDescriptor cd, ConfigItemDescriptor cid)
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
				changeConfiguration(button, cd, cid);
			}
		});

		return button;
	}

	private JPanel createNotification(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JButton button = new JButton(ConfigPanel.CONFIG_ICON);
		SwingUtil.removeButtonDecorations(button);
		button.setPreferredSize(new Dimension(25, 0));
		button.addActionListener(l ->
		{
			var muxer = pluginList.getMuxer();
			var notifPanel = notificationPanelProvider.get();
			notifPanel.init(cd, cid);
			muxer.pushState(notifPanel);
		});
		panel.add(button, BorderLayout.WEST);

		JCheckBox checkbox = new JCheckBox();
		{
			Notification notif = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName(), Notification.class);
			checkbox.setSelected(notif.isEnabled());
		}
		checkbox.addActionListener(ae ->
		{
			button.setVisible(checkbox.isSelected());

			Notification notif = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName(), Notification.class);
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), notif.withEnabled(checkbox.isSelected()));
		});
		checkbox.setBackground(ColorScheme.LIGHT_GRAY_COLOR);
		panel.add(checkbox, BorderLayout.EAST);

		// button visibility is tied to the checkbox
		button.setVisible(checkbox.isSelected());
		return panel;
	}

	private JList<Enum<?>> createList(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		ParameterizedType parameterizedType = (ParameterizedType) cid.getType();
		Class<? extends Enum> type = (Class<? extends Enum>) parameterizedType.getActualTypeArguments()[0];
		Set<? extends Enum> set = configManager.getConfiguration(cd.getGroup().value(), null,
			cid.getItem().keyName(), parameterizedType);

		JList<Enum<?>> list = new JList<Enum<?>>(type.getEnumConstants()); // NOPMD: UseDiamondOperator
		list.setCellRenderer(listCellRenderer);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectedIndices(
			MoreObjects.firstNonNull(set, Collections.emptySet())
				.stream()
				.mapToInt(e -> ArrayUtils.indexOf(type.getEnumConstants(), e))
				.toArray());
		list.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				changeConfiguration(list, cd, cid);
			}
		});

		return list;
	}

	private void changeConfiguration(Component component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		final ConfigItem configItem = cid.getItem();

		if (!Strings.isNullOrEmpty(configItem.warning()))
		{
			final int result = JOptionPane.showOptionDialog(component, configItem.warning(),
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				rebuild();
				return;
			}
		}

		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + checkbox.isSelected());
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
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), ((Enum) jComboBox.getSelectedItem()).name());
		}
		else if (component instanceof HotkeyButton)
		{
			HotkeyButton hotkeyButton = (HotkeyButton) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), hotkeyButton.getValue());
		}
		else if (component instanceof JList)
		{
			JList<?> list = (JList<?>) component;
			List<?> selectedValues = list.getSelectedValuesList();

			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), Sets.newHashSet(selectedValues));
		}
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(PANEL_WIDTH + SCROLLBAR_WIDTH, super.getPreferredSize().height);
	}

	@Subscribe
	public void onPluginChanged(PluginChanged event)
	{
		if (event.getPlugin() == this.pluginConfig.getPlugin())
		{
			SwingUtilities.invokeLater(() ->
				pluginToggle.setSelected(event.isLoaded()));
		}
	}

	@Subscribe
	private void onExternalPluginsChanged(ExternalPluginsChanged ev)
	{
		if (pluginManager.getPlugins().stream()
			.noneMatch(p -> p == this.pluginConfig.getPlugin()))
		{
			pluginList.getMuxer().popState();
		}
		SwingUtilities.invokeLater(this::rebuild);
	}

	@Subscribe
	private void onProfileChanged(ProfileChanged profileChanged)
	{
		SwingUtilities.invokeLater(this::rebuild);
	}

	private JMenuItem createResetMenuItem(PluginConfigurationDescriptor pluginConfig, ConfigItemDescriptor configItemDescriptor)
	{
		JMenuItem menuItem = new JMenuItem("Reset");
		menuItem.addActionListener(e ->
		{
			ConfigDescriptor configDescriptor = pluginConfig.getConfigDescriptor();
			ConfigGroup configGroup = configDescriptor.getGroup();
			ConfigItem configItem = configItemDescriptor.getItem();

			// To reset one item we'll just unset it and then apply defaults over the whole group
			configManager.unsetConfiguration(configGroup.value(), configItem.keyName());
			configManager.setDefaultConfiguration(pluginConfig.getConfig(), false);

			rebuild();
		});
		return menuItem;
	}
}
