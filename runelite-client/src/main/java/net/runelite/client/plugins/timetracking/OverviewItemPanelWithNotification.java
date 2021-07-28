/*
 * Copyright (c) 2021, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.timetracking;

import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.BooleanSupplier;

public class OverviewItemPanelWithNotification extends OverviewItemPanel
{
	private static final ImageIcon NOTIFY_ICON = new ImageIcon(ImageUtil.loadImageResource(TimeTrackingPlugin.class, "notify_icon.png"));
	private static final ImageIcon NOTIFY_SELECTED_ICON = new ImageIcon(ImageUtil.loadImageResource(TimeTrackingPlugin.class, "notify_selected_icon.png"));

	private final JToggleButton notifyButton = new JToggleButton();
	private final JPanel notifyPanel = new JPanel();
	private final ConfigManager configManager;
	private final String configKey;

	OverviewItemPanelWithNotification(ItemManager itemManager, Runnable onTabSwitched, BooleanSupplier isSelectable, int iconItemID, String title, ConfigManager configManager, String configKey)
	{
		super(itemManager, onTabSwitched, isSelectable, iconItemID, title);
		this.configManager = configManager;
		this.configKey = configKey;

		notifyButton.setPreferredSize(new Dimension(30, 16));
		notifyButton.setBorder(new EmptyBorder(0, 0, 0, 10));
		notifyButton.setIcon(NOTIFY_ICON);
		notifyButton.setSelectedIcon(NOTIFY_SELECTED_ICON);
		SwingUtil.removeButtonDecorations(notifyButton);
		SwingUtil.addModalTooltip(notifyButton, "Disable notifications", "Enable notifications");

		notifyButton.setSelected(Boolean.TRUE
			.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey, Boolean.class)));

		notifyButton.addActionListener(e ->
		{
			if (configManager.getRSProfileKey() != null)
			{
				configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey, notifyButton.isSelected());
			}
		});

		notifyPanel.setLayout(new BorderLayout());
		notifyPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		notifyPanel.add(notifyButton, BorderLayout.CENTER);

		notifyPanel.add(arrowLabel, BorderLayout.EAST);

		add(notifyPanel, BorderLayout.EAST);

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				onTabSwitched.run();

				setHighlighted(false);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				setHighlighted(true);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				setHighlighted(true);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				setHighlighted(false);
			}
		});
	}

	@Override
	void updateStatus(String text, Color color)
	{
		super.updateStatus(text, color);

		boolean notifyEnabled = Boolean.TRUE
			.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey, Boolean.class));

		notifyButton.setSelected(notifyEnabled);
	}

	@Override
	protected void setHighlighted(boolean highlighted)
	{
		if (highlighted && !isSelectable.getAsBoolean())
		{
			return;
		}

		super.setHighlighted(highlighted);
		notifyPanel.setBackground(highlighted ? HOVER_COLOR : ColorScheme.DARKER_GRAY_COLOR);
	}
}
