/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Daddy Dozer <Whitedylan7@gmail.com>
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
package net.runelite.client.plugins.suppliestracker;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.QuantityFormatter;

@Singleton
class SuppliesTrackerPanel extends PluginPanel
{
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// Handle loot logs
	private final JPanel logsContainer = new JPanel();

	private final List<SuppliesBox> boxList = new ArrayList<>();

	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	// Handle overall session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallSuppliesUsedLabel = new JLabel();
	private final JLabel overallCostLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();
	private int overallSuppliesUsed;
	private int overallCost;

	SuppliesTrackerPanel(final ItemManager itemManager, SuppliesTrackerPlugin plugin)
	{
		setBorder(new EmptyBorder(6, 6, 6, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		// Create layout panel for wrapping
		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
		add(layoutPanel, BorderLayout.NORTH);

		// Create panel that will contain overall data
		overallPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());
		overallPanel.setVisible(true);

		// Add icon and contents
		final JPanel overallInfo = new JPanel();
		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(2, 1));
		overallInfo.setBorder(new EmptyBorder(0, 10, 0, 0));
		overallSuppliesUsedLabel.setFont(FontManager.getRunescapeSmallFont());
		overallCostLabel.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(overallSuppliesUsedLabel);
		overallInfo.add(overallCostLabel);
		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		for (ItemType type : ItemType.values())
		{
			SuppliesBox newBox = new SuppliesBox(itemManager, type.getLabel(), plugin, this, type);
			logsContainer.add(newBox);
			boxList.add(newBox);
		}

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			overallSuppliesUsed = 0;
			overallCost = 0;
			plugin.clearSupplies();
			for (SuppliesBox box : boxList)
			{
				box.clearAll();
			}
			updateOverall();
			logsContainer.repaint();
		});

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		overallPanel.setComponentPopupMenu(popupMenu);

		// Create Supply Rows wrapper
		logsContainer.setLayout(new BoxLayout(logsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(logsContainer);

		errorPanel.setContent("Supply trackers", "You have not used any supplies yet.");
		add(errorPanel);
		overallPanel.setVisible(false);
	}

	/**
	 * loads an img to the icon on the header
	 *
	 * @param img the img for the header icon
	 */
	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	/**
	 * convert key value pair to html formatting needed to display nicely
	 *
	 * @param key   key
	 * @param value value
	 * @return key: value in html
	 */
	private static String htmlLabel(String key, long value)
	{
		final String valueStr = QuantityFormatter.quantityToStackSize(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}

	/**
	 * Add an item to the supply panel by placing it into the correct box
	 *
	 * @param item the item to add
	 */
	void addItem(SuppliesTrackerItem item)
	{
		ItemType category = ItemType.categorize(item);
		for (SuppliesBox box : boxList)
		{
			if (box.getType() == category)
			{
				box.update(item);
				box.rebuild();
				break;
			}
		}
		updateOverall();
	}

	/**
	 * Updates overall stats to calculate overall used and overall cost from
	 * the info in each box
	 */
	void updateOverall()
	{
		overallSuppliesUsed = 0;
		for (SuppliesBox box : boxList)
		{
			overallSuppliesUsed += box.getTotalSupplies();
		}

		overallCost = 0;
		for (SuppliesBox box : boxList)
		{
			overallCost += box.getTotalPrice();
		}

		overallSuppliesUsedLabel.setText(htmlLabel("Total Supplies: ", overallSuppliesUsed));
		overallCostLabel.setText(htmlLabel("Total Cost: ", overallCost));

		if (overallSuppliesUsed <= 0)
		{
			add(errorPanel);
			overallPanel.setVisible(false);
		}
		else
		{
			remove(errorPanel);
			overallPanel.setVisible(true);
		}
	}
}
