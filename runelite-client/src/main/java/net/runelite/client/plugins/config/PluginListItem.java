/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconButton;
import net.runelite.client.util.ImageUtil;
import org.apache.commons.text.similarity.JaroWinklerDistance;

class PluginListItem extends JPanel
{
	private static final JaroWinklerDistance DISTANCE = new JaroWinklerDistance();

	private static final ImageIcon CONFIG_ICON;
	private static final ImageIcon CONFIG_ICON_HOVER;
	private static final ImageIcon ON_SWITCHER;
	private static final ImageIcon OFF_SWITCHER;
	private static final ImageIcon ON_STAR;
	private static final ImageIcon OFF_STAR;

	private final ConfigPanel configPanel;

	@Getter
	@Nullable
	private final Plugin plugin;

	@Getter
	private final String name;

	@Getter
	private final String description;

	private final List<String> keywords = new ArrayList<>();

	private final IconButton pinButton = new IconButton(OFF_STAR);
	private final IconButton configButton = new IconButton(CONFIG_ICON, CONFIG_ICON_HOVER);
	private final IconButton toggleButton = new IconButton(OFF_SWITCHER);

	private boolean isPluginEnabled = false;

	@Getter
	private boolean isPinned = false;

	static
	{
		BufferedImage configIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "config_edit_icon.png");
		BufferedImage onSwitcher = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "switcher_on.png");
		BufferedImage onStar = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "star_on.png");
		CONFIG_ICON = new ImageIcon(configIcon);
		ON_SWITCHER = new ImageIcon(onSwitcher);
		ON_STAR = new ImageIcon(onStar);
		CONFIG_ICON_HOVER = new ImageIcon(ImageUtil.grayscaleOffset(configIcon, -100));
		BufferedImage offSwitcherImage = ImageUtil.flipImage(
			ImageUtil.grayscaleOffset(
				ImageUtil.grayscaleImage(onSwitcher),
				0.61f
			),
			true,
			false
		);
		OFF_SWITCHER = new ImageIcon(offSwitcherImage);
		BufferedImage offStar = ImageUtil.grayscaleOffset(
			ImageUtil.grayscaleImage(onStar),
			0.77f
		);
		OFF_STAR = new ImageIcon(offStar);
	}

	/**
	 * Creates a new {@code PluginListItem} for a plugin.
	 * <p>
	 * Note that {@code config} and {@code configDescriptor} can be {@code null}
	 * if there is no configuration associated with the plugin.
	 */
	PluginListItem(ConfigPanel configPanel, Plugin plugin, PluginDescriptor descriptor,
		@Nullable Config config, @Nullable ConfigDescriptor configDescriptor)
	{
		this(configPanel, plugin, config, configDescriptor,
			descriptor.name(), descriptor.description(), descriptor.tags());
	}

	/**
	 * Creates a new {@code PluginListItem} for a core configuration.
	 */
	PluginListItem(ConfigPanel configPanel, Config config, ConfigDescriptor configDescriptor,
		String name, String description, String... tags)
	{
		this(configPanel, null, config, configDescriptor, name, description, tags);
	}

	private PluginListItem(ConfigPanel configPanel, @Nullable Plugin plugin, @Nullable Config config,
		@Nullable ConfigDescriptor configDescriptor, String name, String description, String... tags)
	{
		this.configPanel = configPanel;
		this.plugin = plugin;
		this.name = name;
		this.description = description;
		Collections.addAll(keywords, name.toLowerCase().split(" "));
		Collections.addAll(keywords, description.toLowerCase().split(" "));
		Collections.addAll(keywords, tags);

		setLayout(new BorderLayout(3, 0));
		setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH, 20));

		JLabel nameLabel = new JLabel(name);
		nameLabel.setForeground(Color.WHITE);

		if (!description.isEmpty())
		{
			nameLabel.setToolTipText("<html>" + name + ":<br>" + description + "</html>");
		}

		add(nameLabel, BorderLayout.CENTER);

		pinButton.setPreferredSize(new Dimension(21, 0));
		add(pinButton, BorderLayout.LINE_START);

		pinButton.addActionListener(e ->
		{
			setPinned(!isPinned);
			configPanel.savePinnedPlugins();
			configPanel.openConfigList();
		});

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		add(buttonPanel, BorderLayout.LINE_END);

		configButton.setPreferredSize(new Dimension(25, 0));
		configButton.setVisible(false);
		buttonPanel.add(configButton);

		// add a listener to configButton only if there are config items to show
		if (config != null && !configDescriptor.getItems().stream().allMatch(item -> item.getItem().hidden()))
		{
			configButton.addActionListener(e ->
			{
				configButton.setIcon(CONFIG_ICON);
				configPanel.openGroupConfigPanel(PluginListItem.this, config, configDescriptor);
			});

			configButton.setVisible(true);
			configButton.setToolTipText("Edit plugin configuration");
		}

		toggleButton.setPreferredSize(new Dimension(25, 0));
		attachToggleButtonListener(toggleButton);
		buttonPanel.add(toggleButton);
	}

	private void attachToggleButtonListener(IconButton button)
	{
		// no need for a listener if there is no plugin to enable / disable
		if (plugin == null)
		{
			button.setVisible(false);
			return;
		}

		button.addActionListener(e ->
		{
			if (isPluginEnabled)
			{
				configPanel.stopPlugin(plugin, PluginListItem.this);
			}
			else
			{
				configPanel.startPlugin(plugin, PluginListItem.this);
			}

			setPluginEnabled(!isPluginEnabled);
			updateToggleButton(button);
		});
	}

	IconButton createToggleButton()
	{
		IconButton button = new IconButton(OFF_SWITCHER);
		button.setPreferredSize(new Dimension(25, 0));
		updateToggleButton(button);
		attachToggleButtonListener(button);
		return button;
	}

	void setPluginEnabled(boolean enabled)
	{
		isPluginEnabled = enabled;
		updateToggleButton(toggleButton);
	}

	void setPinned(boolean pinned)
	{
		isPinned = pinned;
		pinButton.setIcon(pinned ? ON_STAR : OFF_STAR);
		pinButton.setToolTipText(pinned ? "Unpin plugin" : "Pin plugin");
	}

	private void updateToggleButton(IconButton button)
	{
		button.setIcon(isPluginEnabled ? ON_SWITCHER : OFF_SWITCHER);
		button.setToolTipText(isPluginEnabled ? "Disable plugin" : "Enable plugin");
	}

	/**
	 * Checks if all the search terms in the given list matches at least one keyword.
	 * @return true if all search terms matches at least one keyword, or false if otherwise.
	 */
	boolean matchesSearchTerms(String[] searchTerms)
	{
		for (String term : searchTerms)
		{
			if (keywords.stream().noneMatch((t) -> t.contains(term) ||
				DISTANCE.apply(t, term) > 0.9))
			{
				return false;
			}
		}
		return true;
	}
}
