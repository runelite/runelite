/*
 * Copyright (c) 2020, TheStonedTurtle <https://github.com/TheStonedTurtle>
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

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableMap;
import java.awt.Component;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Function;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.Notifier;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.FlashNotification;
import net.runelite.client.config.NotificationSettings;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;

class NotificationSettingsPanel extends FixedWidthPanel
{
	private static final ImmutableMap<String, ConfigItemDescriptor> DESCRIPTORS = Arrays.stream(NotificationSettings.class.getDeclaredFields())
		.filter(f -> !Modifier.isStatic(f.getModifiers()) && Modifier.isFinal(f.getModifiers()))
		.map(f -> new ConfigItemDescriptor(
			f.getDeclaredAnnotation(ConfigItem.class),
			f.getType(),
			f.getDeclaredAnnotation(Range.class),
			f.getDeclaredAnnotation(Alpha.class),
			f.getDeclaredAnnotation(Units.class)
		))
		.sorted((a, b) -> ComparisonChain.start()
			.compare(a.getItem().position(), b.getItem().position())
			.compare(a.getItem().name(), b.getItem().name())
			.result())
		.collect(ImmutableMap.toImmutableMap(cid -> cid.getItem().keyName(), Function.identity()));

	private final PluginConfigurationDescriptor pluginConfig;
	private final ConfigManager configManager;

	NotificationSettingsPanel(PluginConfigurationDescriptor pluginConfig, ConfigManager configManager)
	{
		super();

		this.pluginConfig = pluginConfig;
		this.configManager = configManager;

		setLayout(new DynamicGridLayout(0, 1, 0, 5));
		setAlignmentX(Component.LEFT_ALIGNMENT);

		rebuild();
	}

	private void rebuild()
	{
		removeAll();
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(0, 2, 0, 0));

		final ConfigDescriptor cd = pluginConfig.getConfigDescriptor();
		if (cd == null || !pluginConfig.hasNotificationConfigurables())
		{
			return;
		}

		final String groupName = cd.getGroup().value();
		final NotificationSettings storedSettings = configManager.getConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings.class);

		final JComboBox stateOption = ConfigPanel.createEnumOption(NotificationSettings.States.class, storedSettings.notificationState().name());
		stateOption.addItemListener(l ->
		{
			final NotificationSettings.States selected = (NotificationSettings.States) stateOption.getSelectedItem();
			configManager.updateConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings::withNotificationState, selected);
			if (NotificationSettings.States.CUSTOM.equals(selected) != NotificationSettings.States.CUSTOM.equals(storedSettings.notificationState()))
			{
				rebuild();
			}
		});
		final JPanel statePanel = ConfigPanel.createConfigOptionPanel(DESCRIPTORS.get("notificationState"), stateOption);
		statePanel.setOpaque(false);
		add(statePanel);

		if (NotificationSettings.States.CUSTOM.equals(storedSettings.notificationState()))
		{
			setBackground(ColorScheme.DARK_GRAY_COLOR.brighter());
			setBorder(new EmptyBorder(4, 6, 4, 4));
			final JCheckBox trayOption = ConfigPanel.createBooleanOption(storedSettings.enableTrayNotifications());
			trayOption.addActionListener(l -> configManager.updateConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings::withEnableTrayNotifications, trayOption.isSelected()));
			final JPanel trayPanel = ConfigPanel.createConfigOptionPanel(DESCRIPTORS.get("enableTrayNotifications"), trayOption);
			trayPanel.setOpaque(false);
			add(trayPanel);

			final JCheckBox requestFocusOption = ConfigPanel.createBooleanOption(storedSettings.requestFocusOnNotification());
			requestFocusOption.addActionListener(l -> configManager.updateConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings::withRequestFocusOnNotification, requestFocusOption.isSelected()));
			final JPanel requestFocusPanel = ConfigPanel.createConfigOptionPanel(DESCRIPTORS.get("requestFocusOnNotification"), requestFocusOption);
			requestFocusPanel.setOpaque(false);
			add(requestFocusPanel);

			final JComboBox soundOption = ConfigPanel.createEnumOption(Notifier.NativeCustomOff.class, storedSettings.notificationSound().name());
			soundOption.addItemListener(l -> configManager.updateConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings::withNotificationSound, (Notifier.NativeCustomOff) soundOption.getSelectedItem()));
			final JPanel soundPanel = ConfigPanel.createConfigOptionPanel(DESCRIPTORS.get("notificationSound"), soundOption);
			soundPanel.setOpaque(false);
			add(soundPanel);

			final JCheckBox gameMessageOption = ConfigPanel.createBooleanOption(storedSettings.enableGameMessageNotification());
			gameMessageOption.addActionListener(l -> configManager.updateConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings::withEnableGameMessageNotification, gameMessageOption.isSelected()));
			final JPanel gameMessagePanel = ConfigPanel.createConfigOptionPanel(DESCRIPTORS.get("enableGameMessageNotification"), gameMessageOption);
			gameMessagePanel.setOpaque(false);
			add(gameMessagePanel);

			final JComboBox flashOption = ConfigPanel.createEnumOption(FlashNotification.class, storedSettings.flashNotification().name());
			flashOption.addActionListener(l -> configManager.updateConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings::withFlashNotification, (FlashNotification) flashOption.getSelectedItem()));
			final JPanel flashPanel = ConfigPanel.createConfigOptionPanel(DESCRIPTORS.get("flashNotification"), flashOption);
			flashPanel.setOpaque(false);
			add(flashPanel);

			final JCheckBox focusOption = ConfigPanel.createBooleanOption(storedSettings.sendNotificationsWhenFocused());
			focusOption.addActionListener(l -> configManager.updateConfiguration(groupName, NotificationSettings.KEY_NAME, NotificationSettings::withSendNotificationsWhenFocused, focusOption.isSelected()));
			final JPanel focusPanel = ConfigPanel.createConfigOptionPanel(DESCRIPTORS.get("sendNotificationsWhenFocused"), focusOption);
			focusPanel.setOpaque(false);
			add(focusPanel);
		}

		revalidate();
	}
}
