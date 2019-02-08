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

	private final ScheduledExecutorService executor;

	// Handle overall session data
	private final JPanel overallPanel = new JPanel();
	private final JLabel overallSuppliesUsedLabel = new JLabel();
	private final JLabel overallCostLabel = new JLabel();
	private final JLabel overallIcon = new JLabel();
	private final ItemManager itemManager;
	private int overallSuppliesUsed;
	private int overallCost;
	private String menusAdded = "";
	private JMenu temp;
	private final SuppliesTrackSetAmountRow setAmountRow = new SuppliesTrackSetAmountRow();

	@Inject
	private Client client;

	private final ClientThread clientThread;

	SuppliesTrackerPanel(ClientThread clientThread, final ItemManager itemManager, ScheduledExecutorService executor)
	{
		this.clientThread = clientThread;
		this.executor = executor;
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
			SuppliesTrackerPlugin.getInstance().clearSupplies();
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
			logsContainer.add(row);
			overallSuppliesUsed += quantity;
			overallCost += cost;

			//Create delete row menu
			final JMenuItem reset = new JMenuItem("Delete");
			reset.addActionListener((ActionEvent e) ->
			{
				overallCost -= row.totalCost;
				overallSuppliesUsed -= row.quantity;
				SuppliesTrackerPlugin.getInstance().clearItem(row.itemId);
				updateOverall();
				logsContainer.remove(row);
				logsContainer.repaint();
			});

			//Create set amount menu
			final JMenuItem setAmount = new JMenuItem("Set Amount");
			setAmount.addActionListener((ActionEvent e) ->
			{
				setAmountRow(row);
				updateOverall();
			});

			// Create popup menu
			final JPopupMenu popupMenu = new JPopupMenu();
			popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
			popupMenu.add(reset);
			popupMenu.add(setAmount);
			row.setComponentPopupMenu(popupMenu);

		}
		updateOverall();
		logsContainer.validate();
		logsContainer.repaint();

	}

	private void setAmountRow(SuppliesTrackRow row)
	{
		setAmountRow.setVisible(true);
		setAmountRow.amount.setText("0");

		KeyAdapter keyAdapter = new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
					int c = e.getKeyCode();

					if (c == KeyEvent.VK_ENTER)
					{
						clientThread.invokeLater(() -> SuppliesTrackerPlugin.getInstance().setAmount(row.itemId, Integer.valueOf(setAmountRow.amount.getText().replace(",", ""))));

						((JFormattedTextField)e.getSource()).removeKeyListener( this );
						setAmountRow.setVisible(false);
					}

					if (c == KeyEvent.VK_BACK_SPACE && setAmountRow.amount.getText().length() == 1)
					{
						setAmountRow.amount.setText("0");
					}
			}
		};
		setAmountRow.amount.addKeyListener(keyAdapter);
	}

	//Switches full cake ids to get the image for slice
	private int getSlice(int itemId)
	{
		switch (itemId)
		{
			case CAKE:
				itemId = SLICE_OF_CAKE;
				break;
			case CHOCOLATE_CAKE:
				itemId = CHOCOLATE_SLICE;
				break;
		}
		return itemId;
	}

	//Switches full pizza and pie ids to get the image for half
	private int getHalf(int itemId)
	{
		switch (itemId)
		{
			case ANCHOVY_PIZZA:
				itemId = _12_ANCHOVY_PIZZA;
				break;
			case MEAT_PIZZA:
				itemId = _12_MEAT_PIZZA;
				break;
			case PINEAPPLE_PIZZA:
				itemId = _12_PINEAPPLE_PIZZA;
				break;
			case PLAIN_PIZZA:
				itemId = _12_PLAIN_PIZZA;
				break;
			case REDBERRY_PIE:
				itemId = HALF_A_REDBERRY_PIE;
				break;
			case GARDEN_PIE:
				itemId = HALF_A_GARDEN_PIE;
				break;
			case SUMMER_PIE:
				itemId = HALF_A_SUMMER_PIE;
				break;
			case FISH_PIE:
				itemId = HALF_A_FISH_PIE;
				break;
			case BOTANICAL_PIE:
				itemId = HALF_A_BOTANICAL_PIE;
				break;
			case MUSHROOM_PIE:
				itemId = HALF_A_MUSHROOM_PIE;
				break;
			case ADMIRAL_PIE:
				itemId = HALF_AN_ADMIRAL_PIE;
				break;
			case WILD_PIE:
				itemId = HALF_A_WILD_PIE;
				break;
			case APPLE_PIE:
				itemId = HALF_AN_APPLE_PIE;
				break;
			case MEAT_PIE:
				itemId = HALF_A_MEAT_PIE;
				break;

		}
		return itemId;
	}

	private int getSingleDose(String name) throws ExecutionException
	{
		int itemId = 0;
		List<ItemPrice> itemList = itemManager.search(name);
		for (ItemPrice item: itemList)
		{
			if (item.getName().equals(name))
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
	private void processResult(int itemID) throws ExecutionException
	{

		SuppliesTrackerPlugin.getInstance().buildEntries(itemID);
	}
	}
