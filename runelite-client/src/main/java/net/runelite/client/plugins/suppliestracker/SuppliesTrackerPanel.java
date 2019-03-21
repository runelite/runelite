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

import net.runelite.api.Client;
import static net.runelite.api.ItemID.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;
import javax.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;


class SuppliesTrackerPanel extends PluginPanel
{
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// Handle loot logs
	private final JPanel logsContainer = new JPanel();

	private final SuppliesBox food, potions, runes, ammo;

	private final ScheduledExecutorService executor;

	// Handle overall session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallSuppliesUsedLabel = new JLabel();
	private final JLabel overallCostLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();
	private final ItemManager itemManager;
	private final SuppliesTrackerPlugin plugin;
	private int overallSuppliesUsed;
	private int overallCost;
	private String menusAdded = "";
	private JMenu temp;
	private final SuppliesTrackSetAmountRow setAmountRow = new SuppliesTrackSetAmountRow();

	@Inject
	private Client client;

	private final ClientThread clientThread;

	SuppliesTrackerPanel(ClientThread clientThread, final ItemManager itemManager, ScheduledExecutorService executor, SuppliesTrackerPlugin plugin)
	{
		this.clientThread = clientThread;
		this.executor = executor;
		this.itemManager = itemManager;
		this.plugin = plugin;
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

		setAmountRow.setVisible(false);

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			overallSuppliesUsed = 0;
			overallCost = 0;
			updateOverall();
			plugin.clearSupplies();
			logsContainer.removeAll();
			logsContainer.repaint();
		});

		final JMenu addSupply = new JMenu("Add Supply: ");
		final JMenu addPotion = new JMenu("Potion dose");
		final JMenu addFood = new JMenu("Food");
		final JMenu addAmmo = new JMenu("Ammo");
		final JMenu addRune = new JMenu("Runes");

		for (String list: SuppliesEnum.Food.MenuItemList())
		{
			String[] item = list.split(" - #");
			ActionListener ActionMenuListener = e -> clientThread.invokeLater(() ->
			{
				try
				{
					processResult(Integer.parseInt(item[1].trim()));
				}
				catch (ExecutionException e1)
				{
					e1.printStackTrace();
				}
			});
			addFood.add(new JMenuItem(item[0])).addActionListener(ActionMenuListener);
		}

		for (String list: SuppliesEnum.Runes.MenuItemList())
		{
			String[] item = list.split(" - #");
			ActionListener ActionMenuListener = e -> clientThread.invokeLater(() ->
			{
				try
				{
					processResult(Integer.parseInt(item[1].trim()));
				}
				catch (ExecutionException e1)
				{
					e1.printStackTrace();
				}
			});
			addRune.add(new JMenuItem(item[0])).addActionListener(ActionMenuListener);
		}

		for (String list: SuppliesEnum.Potion.MenuItemList())
		{
			String[] item = list.split("#");
			ActionListener ActionMenuListener = e -> clientThread.invokeLater(() ->
			{
				try
				{
					processResult(Integer.parseInt(item[2].trim()));
				}
				catch (ExecutionException e1)
				{
					e1.printStackTrace();
				}
			});
			if (!item[0].equals(menusAdded))
			{
				temp = new JMenu(item[0]);
				addPotion.add(temp);
				temp.add(new JMenuItem(item[1])).addActionListener(ActionMenuListener);
				menusAdded = item[0];
			}
			else
				{
				temp.add(new JMenuItem(item[1])).addActionListener(ActionMenuListener);
			}
		}
		for (String list: SuppliesEnum.Ammo.MenuItemList())
		{
			String[] item = list.split("#");
			ActionListener ActionMenuListener = e -> clientThread.invokeLater(() ->
			{
				try
				{
					processResult(Integer.parseInt(item[2].trim()));
				}
				catch (ExecutionException e1)
				{
					e1.printStackTrace();
				}
			});
			if (!item[0].equals(menusAdded))
			{
				temp = new JMenu(item[0]);
				addAmmo.add(temp);
				temp.add(new JMenuItem(item[1])).addActionListener(ActionMenuListener);
				menusAdded = item[0];
			}
			else
			{
				temp.add( new JMenuItem(item[1])).addActionListener(ActionMenuListener);
			}
		}
		addSupply.add(addAmmo);
		addSupply.add(addFood);
		addSupply.add(addPotion);
		addSupply.add(addRune);

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		popupMenu.add(addSupply);
		overallPanel.setComponentPopupMenu(popupMenu);

		// Create Supply Rows wrapper
		logsContainer.setLayout(new BoxLayout(logsContainer, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(setAmountRow);
		layoutPanel.add(logsContainer);

		food = new SuppliesBox(itemManager, "Food", plugin, this);
		potions = new SuppliesBox(itemManager, "Potions", plugin, this);
		runes = new SuppliesBox(itemManager, "Runes", plugin, this);
		ammo = new SuppliesBox(itemManager, "Ammo", plugin, this);

		logsContainer.add(food);
		logsContainer.add(potions);
		logsContainer.add(runes);
		logsContainer.add(ammo);
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

	private ItemTypeEnum categorize(SuppliesTrackerItem item)
	{
		if (item.getName().contains("(4)"))
		{
			return ItemTypeEnum.POTION;
		}
		if (item.getName().contains("bolt") || item.getName().contains("dart")
			|| item.getName().contains("arrow") || item.getName().contains("javelin")
			|| item.getName().contains("knive") || item.getName().contains("throwing"))
		{
			return ItemTypeEnum.AMMO;
		}
		if (item.getName().contains("rune"))
		{
			return ItemTypeEnum.RUNE;
		}
		return ItemTypeEnum.FOOD;
	}

	void addItem(SuppliesTrackerItem item)
	{
		switch (categorize(item))
		{
			case FOOD:
				food.update(item);
				food.rebuild();
				break;
			case POTION:
				potions.update(item);
				potions.rebuild();
				break;
			case RUNE:
				runes.update(item);
				runes.rebuild();
				break;
			case AMMO:
				ammo.update(item);
				ammo.rebuild();
				break;
		}
		updateOverall();
	}

	public void updateOverall()
	{
		overallSuppliesUsed = 0;
		overallSuppliesUsed += food.getTotalSupplies();
		overallSuppliesUsed += potions.getTotalSupplies();
		overallSuppliesUsed += runes.getTotalSupplies();
		overallSuppliesUsed += ammo.getTotalSupplies();

		overallCost = 0;
		overallCost += food.getTotalPrice();
		overallCost += potions.getTotalPrice();
		overallCost += runes.getTotalPrice();
		overallCost += ammo.getTotalPrice();

		overallSuppliesUsedLabel.setText(htmlLabel("Total Supplies: ", overallSuppliesUsed));
		overallCostLabel.setText(htmlLabel("Total Cost: ", overallCost));
	}
	private void processResult(int itemID) throws ExecutionException
	{
		plugin.buildEntries(itemID);
	}
}
