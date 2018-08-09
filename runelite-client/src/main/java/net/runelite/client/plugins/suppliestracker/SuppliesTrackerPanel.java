/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

class SuppliesTrackerPanel extends PluginPanel
{
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// When there is no loot, display this
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	// Handle loot logs
	private final JPanel logsContainer = new JPanel();

	// Handle overall session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallSuppliesUsedLabel = new JLabel();
	private final JLabel overallCostLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();
	private final ItemManager itemManager;
	private int overallSuppliesUsed;
	private int overallCost;


	SuppliesTrackerPanel(final ItemManager itemManager)
	{
		this.itemManager = itemManager;
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
		overallPanel.setVisible(false);

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

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			overallSuppliesUsed = 0;
			overallCost = 0;
			updateOverall();
			SuppliesTrackerPlugin t = new SuppliesTrackerPlugin();
			t.clearSupplies();
			logsContainer.removeAll();
			logsContainer.repaint();
		});

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		overallPanel.setComponentPopupMenu(popupMenu);

		// Create loot logs wrapper
		logsContainer.setLayout(new BoxLayout(logsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(logsContainer);


		// Add error pane
		errorPanel.setContent("Supplies trackers", "You have not used any supplies yet.");
		add(errorPanel);
	}



	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	private static String htmlLabel(String key, long value)
	{
		final String valueStr = StackFormatter.quantityToStackSize(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}

	void addRow(HashMap<Integer, SuppliesTrackerItemEntry> supplies) throws ExecutionException
	{
		//Remove error and show overall
		remove(errorPanel);
		overallPanel.setVisible(true);

		//Reset
		logsContainer.removeAll();
		overallCost = 0;
		overallSuppliesUsed = 0;

		//Iterate through supplies used and build rows
		for (int itemId: supplies.keySet())
		{
			SuppliesTrackerItemEntry tempSuppleEntry = supplies.get(itemId);
			String name = tempSuppleEntry.getName();
			int originalId = itemId;
			if (name.contains("(4)"))
			{

				name = name.replace("(4)", "(1)");
				itemId = getSingleDose(name);
			}
			else if (name.toLowerCase().contains("pizza") || name.toLowerCase().contains(" pie"))
			{
				itemId = getHalf(itemId);
			}
			else if (name.toLowerCase().contains("cake"))
			{
				itemId = getSlice(itemId);
			}
			long cost = tempSuppleEntry.getPrice();
			int quantity = tempSuppleEntry.getQuantity();
			final SuppliesTrackRow row = new SuppliesTrackRow(itemManager.getImage(itemId, 1, false), name, quantity, cost, originalId);
			logsContainer.add(row, 0);
			overallSuppliesUsed += quantity;
			overallCost += cost;

			//Create reset menu
			final JMenuItem reset = new JMenuItem("Reset");
			reset.addActionListener((ActionEvent e) ->
			{
				overallCost -= row.totalCost;
				overallSuppliesUsed -= row.quantity;
				SuppliesTrackerPlugin t = new SuppliesTrackerPlugin();
				t.clearItem(row.itemId);
				updateOverall();
				logsContainer.remove(row);logsContainer.repaint();
			});

			// Create popup menu
			final JPopupMenu popupMenu = new JPopupMenu();
			popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
			popupMenu.add(reset);
			row.setComponentPopupMenu(popupMenu);

		}
		updateOverall();
		logsContainer.validate();
		logsContainer.repaint();



	}

	private int getSlice(int itemId)
	{
		switch (itemId)
		{
			case 1891:
				itemId = 1895;
				break;
			case 1897:
				itemId = 1901;
				break;
		}
		return itemId;
	}

	private int getHalf(int itemId) throws ExecutionException
	{
		switch (itemId)
		{
			case 2297:
				itemId = 2299;
				break;
			case 2293:
				itemId = 2295;
				break;
			case 2301:
				itemId = 2303;
				break;
			case 2289:
				itemId = 2291;
				break;
			case 2325:
				itemId = 2333;
				break;
			case 7178:
				itemId = 7180;
				break;
			case 7218:
				itemId = 7220;
				break;
			case 7188:
				itemId = 7190;
				break;
			case 19662:
				itemId = 19659;
				break;
			case 21690:
				itemId = 21687;
				break;
			case 7198:
				itemId = 7200;
				break;
			case 7208:
				itemId = 7210;
				break;
			case 2323:
				itemId = 2335;
				break;
			case 2327:
				itemId = 2331;
				break;

		}
		return itemId;
	}

	private int getSingleDose(String name) throws ExecutionException
	{
		int itemId = 0;
		List<net.runelite.http.api.item.Item> items = itemManager.searchForItem(name).getItems();
		for (net.runelite.http.api.item.Item item: items)
		{
			if (item.getName().contains(name))
			{
				itemId = item.getId();
			}
		}
		return itemId;
	}

	private void updateOverall()
	{
		overallSuppliesUsedLabel.setText(htmlLabel("Total Supplies: ", overallSuppliesUsed));
		overallCostLabel.setText(htmlLabel("Total Cost: ", overallCost));
	}
}
