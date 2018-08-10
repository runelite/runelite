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
package net.runelite.client.plugins.loottracker;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;

class LootTrackerPanel extends PluginPanel
{
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// When there is no loot, display this
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	// Handle loot logs
	private final JPanel logsContainer = new JPanel();
	private final JPanel visualContainer = new JPanel();

	// Handle overall session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallKillsLabel = new JLabel();
	private final JLabel overallGpLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();
	private final ItemManager itemManager;
	private int overallKills;
	private int overallGp;

	//my edits
	private String listOfItems = "";
	private HashMap<Integer, LootTrackerItemEntry> itemLog = new HashMap<>();
	private HashMap<Integer, Integer> suppliesUsed = new HashMap<>();
	private JFrame popout = new JFrame("Loot");
	private JFrame popout2 = new JFrame("Visual Loot");
	private JTextArea itemTF = new JTextArea();
	private final int ITEMS_PER_ROW = 5;
	private final int[] POTIONS = {2434, 6685, 12695, 10925, 2440, 2436, 22209, 2442, 5952, 3024, 12913, 2444};
	private int overallCost;


	LootTrackerPanel(final ItemManager itemManager)
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
		overallKillsLabel.setFont(FontManager.getRunescapeSmallFont());
		overallGpLabel.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(overallKillsLabel);
		overallInfo.add(overallGpLabel);
		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			overallKills = 0;
			overallGp = 0;
			overallCost = 0;
			suppliesUsed.clear();
			updateOverall();
			itemLog.clear();
			listOfItems = "";
			itemTF.setText(listOfItems);
			visualItemLog();
			logsContainer.removeAll();
			logsContainer.repaint();
		});

		//My edits
		final JMenuItem showAll = new JMenuItem("Show All");
		showAll.addActionListener(e ->
		{
			updateItemLog();
			visualItemLog();
			popout.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			popout.setLocation(0, 0);
			JScrollPane scroll = new JScrollPane ( itemTF );
			itemTF.setEditable(false);
			popout.getContentPane().add(scroll, BorderLayout.CENTER);
			popout.pack();
			popout.setVisible(true);
			popout.setSize(200, 500);
		});
		//My edits

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		popupMenu.add(showAll);
		overallPanel.setComponentPopupMenu(popupMenu);

		// Create loot logs wrapper
		logsContainer.setLayout(new BoxLayout(logsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(logsContainer);

		// Add error pane
		errorPanel.setContent("Loot trackers", "You have not received any loot yet.");
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

	void addLog(final String eventName, final int actorLevel, LootTrackerItemEntry[] items)
	{

		for (LootTrackerItemEntry getAll: items)
		{

			if (getAll.getId() == -1 || getAll.getName() != null)
			{
				System.out.println(getAll.getName() + " - " + getAll.getQuantity() + " - " + getAll.getPrice() + " - " + getAll.getId());
				if (itemLog.containsKey(getAll.getId()))
				{
					long tempPrice = 0;
					tempPrice = getAll.getPrice() + itemLog.get(getAll.getId()).getPrice();
					int tempquant = 0;
					tempquant = tempquant + getAll.getQuantity() + itemLog.get(getAll.getId()).getQuantity();
					LootTrackerItemEntry tempItem = new LootTrackerItemEntry(getAll.id, getAll.getName(), tempquant, tempPrice);
					itemLog.put(getAll.getId(), (tempItem));
				}
				else
				{
					itemLog.put(getAll.getId(), getAll);
				}
			}
		}

		// Remove error and show overall
		remove(errorPanel);
		overallPanel.setVisible(true);

		// Create box
		final String subTitle = actorLevel > -1 ? "(lvl-" + actorLevel + ")" : "";
		final LootTrackerBox box = new LootTrackerBox(itemManager, eventName, subTitle, items);
		logsContainer.add(box, 0);
		logsContainer.repaint();

		// Update overall
		overallGp += box.getTotalPrice();
		overallKills += 1;
		updateOverall();
		updateItemLog();
		visualItemLog();

		// Create reset menu
		final JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(e ->
		{
			overallGp -= box.getTotalPrice();
			overallKills -= 1;
			updateOverall();
			for (int i = 0; i < box.removedKeys.size();i++ )
			{
				System.out.println(box.removedKeys.get(i));
				if (itemLog.get(box.removedKeys.get(i)).getQuantity() == box.removedQuant.get(i))
				{
					itemLog.remove(box.removedKeys.get(i));
				}
				else
				{
					int tempItemQuant = itemLog.get(box.removedKeys.get(i)).getQuantity();
					itemLog.get(box.removedKeys.get(i)).setQuantity(tempItemQuant - box.removedQuant.get(i));
				}
			}
			updateItemLog();
			visualItemLog();
			logsContainer.remove(box);
			logsContainer.repaint();
		});

		//My edits
		final JMenuItem textLog = new JMenuItem("Text Log");
		textLog.addActionListener(e ->
		{
			updateItemLog();
			popout.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			popout.setLocation(0, 0);
			JScrollPane scroll = new JScrollPane ( itemTF );
			itemTF.setEditable(false);
			popout.getContentPane().add(scroll, BorderLayout.CENTER);
			popout.pack();
			popout.setVisible(true);
			popout.setSize(200, 500);
		});

		final JMenuItem visual = new JMenuItem("Visual");
		visual.addActionListener(e ->
		{
			visualItemLog();
			popout2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			popout2.add(visualContainer);
			popout2.pack();
			popout2.setVisible(true);
			popout2.setResizable(false);
		});

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		popupMenu.add(textLog);
		popupMenu.add(visual);
		box.setComponentPopupMenu(popupMenu);
	}

	private void updateOverall()
	{
		overallKillsLabel.setText(htmlLabel("Total count: ", overallKills));
		overallGpLabel.setText(htmlLabel("Total value: ", overallGp));
	}
	void updateItemLog()
	{
		listOfItems = "";


		for (int itemId: itemLog.keySet())
		{

			String itemName = itemLog.get(itemId).getName();
			int quantity = itemLog.get(itemId).getQuantity();
			long price = 0;
			long itemPrice = itemLog.get(itemId).getPrice();
			if (itemPrice != -1)
			{
				price = itemPrice;
			}
			else if (itemId == ItemID.COINS_995)
			{
				price = quantity;
			}
			if (itemLog.get(itemId).getQuantity() == 0)
			{
				itemLog.remove(itemId);
			}
			else
			{
				listOfItems = (listOfItems + itemName + " x " + quantity + "   (" + String.format("%,d", price) + "gp)" + "\r\n");
			}
		}

		String totGP = String.format("%,d", overallGp);
		listOfItems = listOfItems + "\r\n" + "Total Value:  " + totGP + "gp";

		if (!suppliesUsed.isEmpty())
		{
			listOfItems = listOfItems + "\r\n\r\nSupplies Used:\r\n";
			for (int itemId: suppliesUsed.keySet())
			{

				String itemName = itemManager.getItemComposition(itemId).getName();
				int quantity = suppliesUsed.get(itemId);
				long sprice = 0;
				int itemPrice = itemManager.getItemPrice(itemId);
				if (itemPrice != -1)
				{
					sprice = (long) itemPrice;
					boolean found = false;
					for (int element:POTIONS)
					{
						if ( element == itemId )
						{
							found = true;
						}
					}
					if (found)
					{
						sprice = sprice / 4;
						itemName = itemName.replace("(4)", "(1)");
					}
					overallCost += sprice;
				}

				listOfItems = (listOfItems + itemName + " x " + quantity + "   (" + String.format("%,d", sprice) + "gp)" + "\r\n");

			}
			String totCost = String.format("%,d", overallCost);
			listOfItems = listOfItems + "\r\n" + "Total Cost:  " + totCost + "gp";
			overallCost = 0;
		}


		itemTF.setText(listOfItems);

	}
	private void visualItemLog()
	{
		// Calculates how many rows need to be display to fit all items

		visualContainer.removeAll();
		visualContainer.repaint();

		final int rowSize = ((itemLog.size() % ITEMS_PER_ROW == 0) ? 0 : 1) + itemLog.size() / ITEMS_PER_ROW;

		final JPanel itemContainer = new JPanel(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));
		for (int itemId: itemLog.keySet())
		{
			final JPanel slotContainer = new JPanel();
			slotContainer.removeAll();
			slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			final JLabel imageLabel = new JLabel();
			imageLabel.setToolTipText(buildToolTip(itemLog.get(itemId)));
			imageLabel.setVerticalAlignment(SwingConstants.TOP);
			imageLabel.setHorizontalAlignment(SwingConstants.LEFT);
			itemManager.getImage(itemId, itemLog.get(itemId).getQuantity(), itemLog.get(itemId).getQuantity() > 1).addTo(imageLabel);
			slotContainer.add(imageLabel);
			itemContainer.add(slotContainer);
		}

		visualContainer.add(itemContainer);
		visualContainer.repaint();
		popout2.add(visualContainer);
		popout2.pack();
		popout2.repaint();

	}

	private String buildToolTip(LootTrackerItemEntry item)
	{


		final String name = item.getName();
		long price = 0;


		long itemPrice = item.getPrice();
		if (itemPrice != -1)
		{
			price =  itemPrice;
		}
		else if (item.getId() == ItemID.COINS_995)
		{
			price = item.getQuantity();
		}

		return name + " x " + item.getQuantity() + " (" + String.format("%,d", price) + "gp)";
	}

	void addSuppliesUsed(Integer itemid, Integer amount)
	{
		suppliesUsed.put(itemid, amount);
		updateItemLog();
	}
}
