/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.loottracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.SwingUtil;

@Slf4j
public class LootTrackerPanel extends PluginPanel
{
	private static final int ITEMS_PER_ROW = 5;

	private static final ImageIcon RESET_ICON;
	private static final ImageIcon SETTINGS_ICON;
	private static final ImageIcon RESET_CLICK_ICON;
	private static final ImageIcon SETTINGS_CLICK_ICON;

	private final JPanel logsContainer = new JPanel();

	@Inject
	@Nullable
	private Client client;

	@Inject
	private ItemManager itemManager;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				BufferedImage resetIcon = ImageIO.read(LootTrackerPanel.class.getResourceAsStream("reset.png"));
				RESET_ICON = new ImageIcon(resetIcon);
				RESET_CLICK_ICON = new ImageIcon(SwingUtil.grayscaleOffset(resetIcon, -100));

				BufferedImage settingsIcon = ImageIO.read(LootTrackerPanel.class.getResourceAsStream("settings.png"));
				SETTINGS_ICON = new ImageIcon(settingsIcon);
				SETTINGS_CLICK_ICON = new ImageIcon(SwingUtil.grayscaleOffset(settingsIcon, -100));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	void init()
	{
		JPanel container = new JPanel(new BorderLayout(0, 10));

		JPanel topBar = new JPanel(new BorderLayout());

		final JLabel pluginTitle = new JLabel("Loot Tracker");
		pluginTitle.setForeground(Color.WHITE);

		JPanel actionsContainer = new JPanel(new GridLayout(1, 2, 10, 0));
		actionsContainer.setOpaque(true);

		final JLabel reset = new JLabel(RESET_ICON);
		reset.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				reset.setIcon(RESET_CLICK_ICON);
				reset();
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent)
			{
				reset.setIcon(RESET_ICON);
			}
		});

		final JLabel settings = new JLabel(SETTINGS_ICON);
		settings.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				settings.setIcon(SETTINGS_CLICK_ICON);
				//TODO open display configs here
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent)
			{
				settings.setIcon(SETTINGS_ICON);
			}
		});

		actionsContainer.add(reset);
		actionsContainer.add(settings);

		topBar.add(pluginTitle, BorderLayout.WEST);
		topBar.add(actionsContainer, BorderLayout.EAST);

		logsContainer.setLayout(new DynamicGridLayout(0, 1, 0, 10));

		container.add(topBar, BorderLayout.NORTH);
		container.add(logsContainer, BorderLayout.CENTER);

		add(container);
	}

	public void addLog(String npcName, int npcLevel, Item... items)
	{
		JPanel logContainer = new JPanel();
		logContainer.setLayout(new BorderLayout(0, 1));

		JPanel logTitle = new JPanel(new BorderLayout(5, 0));
		logTitle.setBorder(new EmptyBorder(7, 7, 7, 7));
		logTitle.setBackground(ColorScheme.DARKER_GRAY_COLOR.darker());

		JLabel npcNameLabel = new JLabel(npcName);
		npcNameLabel.setFont(FontManager.getRunescapeSmallFont());
		npcNameLabel.setForeground(Color.WHITE);

		logTitle.add(npcNameLabel, BorderLayout.WEST);

		// For events outside of npc drops (barrows, raids, etc) the level should be -1
		if (npcLevel > -1)
		{
			JLabel npcLevelLabel = new JLabel("(lvl. " + npcLevel + ")");
			npcLevelLabel.setFont(FontManager.getRunescapeSmallFont());
			npcLevelLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

			logTitle.add(npcLevelLabel, BorderLayout.CENTER);
		}

		int rowSize = (items.length / ITEMS_PER_ROW) + 1;

		JPanel itemContainer = new JPanel(new GridLayout(rowSize, ITEMS_PER_ROW));

		for (int i = 0; i < rowSize * ITEMS_PER_ROW; i++)
		{
			JPanel slotContainer = new JPanel();
			slotContainer.setPreferredSize(new Dimension(40, 40));
			slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			if (i < items.length)
			{
				Item item = items[i];

				AsyncBufferedImage icon = itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1);
				Runnable addImage = () ->
				{
					SwingUtilities.invokeLater(() ->
					{
						JLabel imageLabel = new JLabel(new ImageIcon(icon));
						imageLabel.setVerticalAlignment(SwingConstants.CENTER);
						imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

						slotContainer.add(imageLabel);
						slotContainer.revalidate();
						slotContainer.repaint();
					});
				};
				icon.onChanged(addImage);
				addImage.run();
			}

			itemContainer.add(slotContainer);
		}

		logContainer.add(logTitle, BorderLayout.NORTH);
		logContainer.add(itemContainer, BorderLayout.CENTER);

		logsContainer.add(logContainer);

		logsContainer.revalidate();
		logsContainer.repaint();
	}

	public void reset()
	{
		//TODO reset the data collector
		logsContainer.removeAll();
	}

	private void testPopulate()
	{
		final ItemContainer inv = client.getItemContainer(InventoryID.INVENTORY);

		if (inv == null)
		{
			return;
		}

		addLog("Demonic gorilla", 135, inv.getItems());
	}
}
