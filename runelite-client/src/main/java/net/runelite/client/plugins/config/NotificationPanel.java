/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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

import com.google.common.primitives.Ints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TrayIcon;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.FlashNotification;
import net.runelite.client.config.Notification;
import net.runelite.client.config.RequestFocusType;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.UnitFormatterFactory;
import net.runelite.client.ui.components.ColorJButton;
import net.runelite.client.ui.components.TitleCaseListCellRenderer;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.SwingUtil;
import net.runelite.client.util.Text;

@Slf4j
class NotificationPanel extends PluginPanel
{
	private final ConfigManager configManager;
	private final ColorPickerManager colorPickerManager;

	private final JLabel title;
	private final FixedWidthPanel mainPanel;
	private final JCheckBox enabled;

	private ConfigDescriptor configDescriptor;
	private ConfigItemDescriptor configItemDescriptor;

	@Inject
	private NotificationPanel(
		ConfigManager configManager,
		ColorPickerManager colorPickerManager,
		RuneLiteConfig runeLiteConfig,
		PluginListPanel pluginList
	)
	{
		super(false);

		this.configManager = configManager;
		this.colorPickerManager = colorPickerManager;

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

		JPanel contentsPanel = new FixedWidthPanel();
		contentsPanel.setLayout(new BorderLayout());
		contentsPanel.add(mainPanel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(contentsPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);

		JButton topPanelBackButton = new JButton(ConfigPanel.BACK_ICON);
		SwingUtil.removeButtonDecorations(topPanelBackButton);
		topPanelBackButton.setPreferredSize(new Dimension(22, 0));
		topPanelBackButton.setBorder(new EmptyBorder(0, 0, 0, 5));
		topPanelBackButton.addActionListener(e -> pluginList.getMuxer().popState());
		topPanelBackButton.setToolTipText("Back");
		topPanel.add(topPanelBackButton, BorderLayout.WEST);

		title = new JLabel();
		title.setForeground(Color.WHITE);
		topPanel.add(title, BorderLayout.CENTER);

		enabled = new JCheckBox();
		enabled.addActionListener(l ->
		{
			Notification notif = loadNotification();
			// If the notification has not been initialized yet, apply default config from the RuneLite settings
			if (enabled.isSelected() && !notif.isInitialized())
			{
				log.debug("Initializing notification {}.{}", configDescriptor.getGroup().value(), configItemDescriptor.getItem().name());
				notif = new Notification(true, true, true,
					runeLiteConfig.enableTrayNotifications(), TrayIcon.MessageType.NONE, runeLiteConfig.notificationRequestFocus(),
					runeLiteConfig.notificationSound(), runeLiteConfig.notificationVolume(), runeLiteConfig.notificationTimeout(),
					runeLiteConfig.enableGameMessageNotification(), runeLiteConfig.flashNotification(), runeLiteConfig.notificationFlashColor(),
					runeLiteConfig.sendNotificationsWhenFocused());
			}
			else
			{
				notif = notif.withOverride(enabled.isSelected());
			}
			saveNotification(notif);
			rebuild(notif);
		});
	}

	private void item(String name, String description, Component component)
	{
		JPanel item = new JPanel();
		item.setLayout(new BorderLayout());
		item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
		JLabel configEntryName = new JLabel(name);
		configEntryName.setForeground(Color.WHITE);
		if (!"".equals(description))
		{
			configEntryName.setToolTipText("<html>" + name + ":<br>" + description + "</html>");
		}
		item.add(configEntryName, BorderLayout.CENTER);
		item.add(component, BorderLayout.EAST);
		mainPanel.add(item);
	}

	private JCheckBox checkbox(boolean selected)
	{
		JCheckBox checkbox = new JCheckBox();
		checkbox.setSelected(selected);
		return checkbox;
	}

	private <T extends Enum<T>> JComboBox<Enum<T>> combobox(Class<T> clazz, T value)
	{
		JComboBox<Enum<T>> box = new JComboBox<>(clazz.getEnumConstants());
		// set renderer prior to calling box.getPreferredSize(), since it will invoke the renderer
		// to build components for each combobox element in order to compute the display size of the
		// combobox
		box.setRenderer(new TitleCaseListCellRenderer());
		box.setPreferredSize(new Dimension(box.getPreferredSize().width, 22));

		try
		{
			Enum<?> selectedItem = Enum.valueOf(clazz, value.name());
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
				box.setToolTipText(Text.titleCase((Enum<?>) box.getSelectedItem()));
			}
		});

		return box;
	}

	private JSpinner createIntSpinner(int min, int max, int value, String unit)
	{
		// Config may previously have been out of range
		value = Ints.constrainToRange(value, min, max);

		SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
		JSpinner spinner = new JSpinner(model);
		Component editor = spinner.getEditor();
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
		spinnerTextField.setColumns(6);
		spinnerTextField.setFormatterFactory(new UnitFormatterFactory(unit));
		return spinner;
	}

	private ColorJButton createColorPicker(String name, Color existing, Consumer<Color> onClose)
	{
		ColorJButton colorPickerBtn;

		if (existing == null)
		{
			colorPickerBtn = new ColorJButton("Pick a color", Color.BLACK);
		}
		else
		{
			String colorHex = "#" + ColorUtil.colorToAlphaHexCode(existing).toUpperCase();
			colorPickerBtn = new ColorJButton(colorHex, existing);
		}

		colorPickerBtn.setFocusable(false);
		colorPickerBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				RuneliteColorPicker colorPicker = colorPickerManager.create(
					SwingUtilities.windowForComponent(NotificationPanel.this),
					colorPickerBtn.getColor(),
					name,
					false);
				colorPicker.setLocationRelativeTo(colorPickerBtn);
				colorPicker.setOnColorChange(c ->
				{
					colorPickerBtn.setColor(c);
					colorPickerBtn.setText("#" + ColorUtil.colorToAlphaHexCode(c).toUpperCase());
				});
				colorPicker.setOnClose(onClose);
				colorPicker.setVisible(true);
			}
		});

		return colorPickerBtn;
	}

	void init(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		title.setText(cid.name());

		configDescriptor = cd;
		configItemDescriptor = cid;

		var notif = loadNotification();
		enabled.setSelected(notif.isOverride());

		rebuild(notif);
	}

	private void rebuild(Notification notif)
	{
		mainPanel.removeAll();

		mainPanel.add(enabled);

		item("Customize notification", "", enabled);

		if (notif.isOverride())
		{
			var checkboxTray = checkbox(notif.isTray());
			checkboxTray.addActionListener(ae ->
			{
				var n = loadNotification();
				saveNotification(n.withTray(checkboxTray.isSelected()));
			});
			item("Tray notification", "Enables tray notifications.", checkboxTray);

			var comboboxRequestFocus = combobox(RequestFocusType.class, notif.getRequestFocus());
			comboboxRequestFocus.addItemListener(e ->
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					var n = loadNotification();
					saveNotification(n.withRequestFocus((RequestFocusType) comboboxRequestFocus.getSelectedItem()));
				}
			});
			item("Request focus", "Configures the window focus request type on notification.", comboboxRequestFocus);

			var comboboxSound = combobox(Notifier.NativeCustomOff.class, notif.getSound());
			comboboxSound.addItemListener(e ->
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					var n = loadNotification();
					saveNotification(n.withSound((Notifier.NativeCustomOff) comboboxSound.getSelectedItem()));
				}
			});
			item("Notification sound", "Enables the playing of a beep sound when notifications are displayed.", comboboxSound);

			var spinnerVolume = createIntSpinner(0, 100, notif.getVolume(), "%");
			spinnerVolume.addChangeListener(ce ->
			{
				var n = loadNotification();
				saveNotification(n.withVolume((int) spinnerVolume.getValue()));
			});
			item("Notification volume", "Configures the volume of custom notifications (does not control native volume).", spinnerVolume);

			var spinnerTimeout = createIntSpinner(0, Integer.MAX_VALUE, notif.getTimeout(), "ms");
			spinnerVolume.addChangeListener(ce ->
			{
				var n = loadNotification();
				saveNotification(n.withTimeout((int) spinnerTimeout.getValue()));
			});
			item("Notification timeout", "How long notification will be shown in milliseconds. A value of 0 will make it use the system configuration. (Linux only)", spinnerTimeout);

			var checkboxGameMessage = checkbox(notif.isGameMessage());
			checkboxGameMessage.addActionListener(ae ->
			{
				var n = loadNotification();
				saveNotification(n.withGameMessage(checkboxGameMessage.isSelected()));
			});
			item("Game message notification", "Adds a notification message to the chatbox.", checkboxGameMessage);

			var comboboxFlash = combobox(FlashNotification.class, notif.getFlash());
			comboboxFlash.addItemListener(e ->
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					var n = loadNotification();
					saveNotification(n.withFlash((FlashNotification) comboboxFlash.getSelectedItem()));
				}
			});
			item("Flash", "Flashes the game frame as a notification.", comboboxFlash);

			var colorpickerFlashColor = createColorPicker("Flash color", notif.getFlashColor(), c ->
			{
				var n = loadNotification();
				saveNotification(n.withFlashColor(c));
			});
			item("Flash color", "The color of the notification flashes.", colorpickerFlashColor);

			var checkboxSendWhenFocused = checkbox(notif.isSendWhenFocused());
			checkboxSendWhenFocused.addActionListener(ae ->
			{
				var n = loadNotification();
				saveNotification(n.withSendWhenFocused(checkboxSendWhenFocused.isSelected()));
			});
			item("Send notifications when focused", "Send the notification even when the client is focused.", checkboxSendWhenFocused);

			JButton resetButton = new JButton("Reset");
			resetButton.addActionListener((e) ->
			{
				final int result = JOptionPane.showOptionDialog(resetButton, "Are you sure you want to reset this notification configuration?",
					"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, new String[]{"Yes", "No"}, "No");

				if (result == JOptionPane.YES_OPTION)
				{
					enabled.setSelected(false);

					// Reset every setting
					var n = new Notification().withEnabled(true);
					saveNotification(n);
					rebuild(n);
				}
			});
			mainPanel.add(resetButton);
		}
		else
		{
			JPanel infoPanel = new JPanel();
			infoPanel.setLayout(new BorderLayout());
			mainPanel.add(infoPanel);

			infoPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
			infoPanel.add(new JLabel("<html>Notification settings can be customized for each type of notification. Notifications without custom settings use the default settings found in the 'RuneLite' configuration under 'Notification Settings'.</html>"));
		}
	}

	private Notification loadNotification()
	{
		return configManager.getConfiguration(configDescriptor.getGroup().value(), configItemDescriptor.getItem().keyName(), Notification.class);
	}

	private void saveNotification(Notification notification)
	{
		configManager.setConfiguration(configDescriptor.getGroup().value(), configItemDescriptor.getItem().keyName(), notification);
	}
}
