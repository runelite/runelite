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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.SwingUtil;
import org.apache.commons.text.similarity.JaroWinklerDistance;

class PluginListItem extends JPanel
{
	private static final JaroWinklerDistance DISTANCE = new JaroWinklerDistance();

	private static final ImageIcon CONFIG_ICON;
	private static final ImageIcon CONFIG_ICON_HOVER;
	private static final ImageIcon ON_SWITCHER;
	private static final ImageIcon OFF_SWITCHER;

	private final ConfigPanel configPanel;
	private @Getter @Nullable final Plugin plugin;
	private @Nullable final Config config;
	private @Nullable final ConfigDescriptor configDescriptor;

	private final String name;
	private final String description;
	private final List<String> keywords = new ArrayList<>();

	private final JLabel configButton = new JLabel(CONFIG_ICON);
	private final JLabel toggleButton = new JLabel(OFF_SWITCHER);

	private boolean isPluginEnabled = false;

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
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates a new {@code PluginListItem} for a plugin.
	 * <p>
	 * Note that {@code config} and {@code configDescriptor} can be {@code null}
	 * if there is no configuration associated with the plugin.
	 */
	PluginListItem(ConfigPanel configPanel, Plugin plugin, @Nullable Config config,
		@Nullable ConfigDescriptor configDescriptor)
	{
		final PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);

		this.configPanel = configPanel;
		this.plugin = plugin;
		this.config = config;
		this.configDescriptor = configDescriptor;
		this.name = descriptor.name();
		this.description = descriptor.description();
		Collections.addAll(keywords, name.toLowerCase().split(" "));
		Collections.addAll(keywords, descriptor.tags());

		initialize();
	}

	/**
	 * Creates a new {@code PluginListItem} for a core configuration.
	 */
	PluginListItem(ConfigPanel configPanel, Config config, ConfigDescriptor configDescriptor,
		String name, String description, String... tags)
	{
		this.configPanel = configPanel;
		this.plugin = null;
		this.config = config;
		this.configDescriptor = configDescriptor;
		this.name = name;
		this.description = description;
		Collections.addAll(keywords, name.toLowerCase().split(" "));
		Collections.addAll(keywords, tags);

		initialize();
	}

	private void initialize()
	{
		setLayout(new BorderLayout(3, 0));
		setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH, 20));

		JLabel nameLabel = new JLabel(name);
		nameLabel.setForeground(Color.WHITE);

		if (!description.isEmpty())
		{
			nameLabel.setToolTipText("<html>" + name + ":<br>" + description + "</html>");
		}

		add(nameLabel, BorderLayout.CENTER);

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		add(buttonPanel, BorderLayout.LINE_END);

		configButton.setPreferredSize(new Dimension(25, 0));
		configButton.setVisible(false);
		attachConfigButtonListener();
		buttonPanel.add(configButton);

		toggleButton.setPreferredSize(new Dimension(25, 0));
		toggleButton.setHorizontalAlignment(SwingConstants.RIGHT);
		attachToggleButtonListener();
		buttonPanel.add(toggleButton);
	}

	private void attachConfigButtonListener()
	{
		// no need for a listener if there are no config item to show
		if (config == null || configDescriptor.getItems().stream().allMatch(item -> item.getItem().hidden()))
		{
			return;
		}

		configButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				configButton.setIcon(CONFIG_ICON);
				configPanel.openGroupConfigPanel(config, configDescriptor);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				configButton.setIcon(CONFIG_ICON_HOVER);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				configButton.setIcon(CONFIG_ICON);
			}
		});
		configButton.setVisible(true);
		configButton.setToolTipText("Edit plugin configuration");
	}

	private void attachToggleButtonListener()
	{
		// no need for a listener if there is no plugin to enable / disable
		if (plugin == null)
		{
			toggleButton.setEnabled(false);
			return;
		}

		toggleButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (isPluginEnabled)
				{
					configPanel.stopPlugin(plugin, PluginListItem.this);
				}
				else
				{
					configPanel.startPlugin(plugin, PluginListItem.this);
				}
			}
		});
	}

	void setPluginEnabled(boolean enabled)
	{
		isPluginEnabled = enabled;
		toggleButton.setIcon(enabled ? ON_SWITCHER : OFF_SWITCHER);
		toggleButton.setToolTipText(enabled ? "Disable plugin" : "Enable plugin");
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
