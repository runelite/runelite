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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;
import lombok.Getter;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.plugins.ExternalPluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;

public class PluginListItem extends JPanel
{
	private static final ImageIcon CONFIG_ICON;
	private static final ImageIcon CONFIG_ICON_HOVER;
	private static final ImageIcon REFRESH_ICON;
	private static final ImageIcon REFRESH_ICON_HOVER;
	private static final ImageIcon ON_STAR;
	private static final ImageIcon OFF_STAR;

	private final PluginListPanel pluginListPanel;

	@Getter
	private final PluginConfigurationDescriptor pluginConfig;

	@Getter
	private final List<String> keywords = new ArrayList<>();

	public JLabel nameLabel;
	private final JToggleButton pinButton;
	private final JToggleButton onOffToggle;

	private Color color = null;

	static
	{
		BufferedImage configIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "config_edit_icon.png");
		BufferedImage refreshIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "refresh.png");
		BufferedImage onStar = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "star_on.png");
		CONFIG_ICON = new ImageIcon(configIcon);
		REFRESH_ICON = new ImageIcon(refreshIcon);
		ON_STAR = new ImageIcon(ImageUtil.recolorImage(onStar, ColorScheme.BRAND_BLUE));
		CONFIG_ICON_HOVER = new ImageIcon(ImageUtil.luminanceOffset(configIcon, -100));
		REFRESH_ICON_HOVER = new ImageIcon(ImageUtil.luminanceOffset(refreshIcon, -100));

		BufferedImage offStar = ImageUtil.luminanceScale(
			ImageUtil.grayscaleImage(onStar),
			0.77f
		);
		OFF_STAR = new ImageIcon(offStar);
	}

	PluginListItem(PluginListPanel pluginListPanel, PluginConfigurationDescriptor pluginConfig, ExternalPluginManager externalPluginManager)
	{
		this.pluginListPanel = pluginListPanel;
		this.pluginConfig = pluginConfig;

		Collections.addAll(keywords, pluginConfig.getName().toLowerCase().split(" "));
		Collections.addAll(keywords, pluginConfig.getDescription().toLowerCase().split(" "));
		Collections.addAll(keywords, pluginConfig.getTags());

		setLayout(new BorderLayout(3, 0));
		setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH, 20));

		nameLabel = new JLabel(pluginConfig.getName());
		nameLabel.setForeground(Color.WHITE);

		if (!pluginConfig.getDescription().isEmpty())
		{
			nameLabel.setToolTipText("<html>" + pluginConfig.getName() + ":<br>" + pluginConfig.getDescription() + "</html>");
		}

		pinButton = new JToggleButton(OFF_STAR);
		pinButton.setSelectedIcon(ON_STAR);
		SwingUtil.removeButtonDecorations(pinButton);
		SwingUtil.addModalTooltip(pinButton, "Unpin plugin", "Pin plugin");
		pinButton.setPreferredSize(new Dimension(21, 0));
		add(pinButton, BorderLayout.LINE_START);

		pinButton.addActionListener(e ->
		{
			pluginListPanel.savePinnedPlugins();
			pluginListPanel.refresh();
		});

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		add(buttonPanel, BorderLayout.LINE_END);

		Map<String, Map<String, String>> pluginsInfoMap = externalPluginManager.getPluginsInfoMap();

		if (RuneLiteProperties.getLauncherVersion() == null && pluginConfig.getPlugin() != null && pluginsInfoMap.containsKey(pluginConfig.getPlugin().getClass().getSimpleName()))
		{
			JButton hotSwapButton = new JButton(REFRESH_ICON);
			hotSwapButton.setRolloverIcon(REFRESH_ICON_HOVER);
			SwingUtil.removeButtonDecorations(hotSwapButton);
			hotSwapButton.setPreferredSize(new Dimension(25, 0));
			hotSwapButton.setVisible(false);
			buttonPanel.add(hotSwapButton);

			hotSwapButton.addActionListener(e ->
			{
				Map<String, String> pluginInfo = pluginsInfoMap.get(pluginConfig.getPlugin().getClass().getSimpleName());
				String pluginId = pluginInfo.get("id");

				hotSwapButton.setIcon(REFRESH_ICON);
				externalPluginManager.uninstall(pluginId);

				SwingWorker<Boolean, Void> worker = new SwingWorker<>()
				{
					@Override
					protected Boolean doInBackground()
					{
						return externalPluginManager.uninstall(pluginId);
					}
				};
				worker.execute();

				JOptionPane.showMessageDialog(ClientUI.getFrame(),
					pluginId + " is unloaded, put the new jar file in the externalmanager folder and click `ok`",
					"Hotswap " + pluginId,
					JOptionPane.INFORMATION_MESSAGE);

				worker = new SwingWorker<>()
				{
					@Override
					protected Boolean doInBackground()
					{
						return externalPluginManager.reloadStart(pluginId);
					}
				};
				worker.execute();
			});

			hotSwapButton.setVisible(true);
			hotSwapButton.setToolTipText("Hotswap plugin");
		}

		if (pluginConfig.hasConfigurables())
		{
			JButton configButton = new JButton(CONFIG_ICON);
			configButton.setRolloverIcon(CONFIG_ICON_HOVER);
			SwingUtil.removeButtonDecorations(configButton);
			configButton.setPreferredSize(new Dimension(25, 0));
			configButton.setVisible(false);
			buttonPanel.add(configButton);

			configButton.addActionListener(e ->
			{
				configButton.setIcon(CONFIG_ICON);
				openGroupConfigPanel();
			});

			configButton.setVisible(true);
			configButton.setToolTipText("Edit plugin configuration");
		}

		addLabelMouseOver(nameLabel);
		add(nameLabel, BorderLayout.CENTER);

		onOffToggle = new PluginToggleButton();
		buttonPanel.add(onOffToggle);
		if (pluginConfig.getPlugin() != null)
		{
			onOffToggle.addItemListener(i ->
			{
				if (onOffToggle.isSelected())
				{
					pluginListPanel.startPlugin(pluginConfig.getPlugin());
				}
				else
				{
					pluginListPanel.stopPlugin(pluginConfig.getPlugin());
				}
			});
		}
		else
		{
			onOffToggle.setVisible(false);
		}
	}

	boolean isPinned()
	{
		return pinButton.isSelected();
	}

	void setPinned(boolean pinned)
	{
		pinButton.setSelected(pinned);
	}

	public PluginType getPluginType()
	{
		return pluginConfig.getPluginType();
	}

	public Color getColor()
	{
		return this.color == null ? Color.WHITE : this.color;
	}

	public void setColor(Color color)
	{
		if (color == null)
		{
			return;
		}

		this.color = color;
		this.nameLabel.setForeground(color);
	}

	void setPluginEnabled(boolean enabled)
	{
		onOffToggle.setSelected(enabled);
	}

	private void openGroupConfigPanel()
	{
		pluginListPanel.openConfigurationPanel(pluginConfig);
	}

	/**
	 * Adds a mouseover effect to change the text of the passed label to {@link ColorScheme#BRAND_BLUE} color
	 *
	 * @param label The label to attach the mouseover and click effects to
	 */
	static void addLabelMouseOver(final JLabel label)
	{
		label.addMouseListener(new MouseAdapter()
		{
			private Color lastForeground;

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				lastForeground = label.getForeground();
				label.setForeground(ColorScheme.BRAND_BLUE);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				label.setForeground(lastForeground);
			}
		});
	}
}
