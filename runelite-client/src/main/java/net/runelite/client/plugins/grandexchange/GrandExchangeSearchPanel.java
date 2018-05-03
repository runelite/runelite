/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.grandexchange;

import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.hiscore.IconTextField;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.SearchResult;

@Slf4j
class GrandExchangeSearchPanel extends JPanel
{
	private static final List<GrandExchangeItems> ITEMS_LIST = new ArrayList<>();

	private final Client client;
	private final ItemManager itemManager;
	private final ScheduledExecutorService executor;

	private Icon search;

	private IconTextField searchBox = new IconTextField();
	private JPanel container = new JPanel();
	private JPanel searchItemsPanel = new JPanel();
	private JLabel searchingLabel = new JLabel();

	GrandExchangeSearchPanel(Client client, ItemManager itemManager, ScheduledExecutorService executor)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.executor = executor;
		init();
	}

	void init()
	{
		setLayout(new BorderLayout());
		container.setLayout(new BorderLayout());

		// Search Box
		try
		{
			BufferedImage icon;
			synchronized (ImageIO.class)
			{
				icon = ImageIO.read(GrandExchangePlugin.class.getResourceAsStream("search.png"));
			}
			search = new ImageIcon(icon);
		}
		catch (IOException e)
		{
			log.warn("Failed to read icon", e);
		}

		searchBox.setIcon(search);
		searchBox.addActionListener(e -> executor.execute(() -> priceLookup(false)));

		container.add(searchBox, BorderLayout.NORTH);

		// Searching label
		searchingLabel.setHorizontalAlignment(JLabel.CENTER);
		searchingLabel.setForeground(Color.YELLOW);

		// Items Panel
		searchItemsPanel.setLayout(new GridLayout(0, 1, 0, 3));
		searchItemsPanel.setBorder(new EmptyBorder(3, 0, 0, 0));

		container.add(searchItemsPanel, BorderLayout.SOUTH);
		add(container, BorderLayout.NORTH);
	}

	void priceLookup(String item)
	{
		searchBox.setText(item);
		executor.execute(() -> priceLookup(true));
	}

	private void priceLookup(boolean exactMatch)
	{
		String lookup = searchBox.getText();

		if (Strings.isNullOrEmpty(lookup))
		{
			searchItemsPanel.removeAll();
			return;
		}

		// Input is not empty, add searching label
		searchItemsPanel.removeAll();
		showSearchString("Searching...");

		SearchResult result;

		try
		{
			result = itemManager.searchForItem(lookup);
		}
		catch (ExecutionException ex)
		{
			log.warn("Unable to search for item {}", lookup, ex);
			showSearchString("Error performing search");
			return;
		}


		if (result != null && !result.getItems().isEmpty())
		{
			for (Item item : result.getItems())
			{
				int itemId = item.getId();

				ItemComposition itemComp = client.getItemDefinition(itemId);
				if (itemComp == null)
				{
					continue;
				}

				ItemPrice itemPrice = null;
				try
				{
					itemPrice = itemManager.getItemPrice(itemId);
				}
				catch (IOException ex)
				{
					log.warn("Unable to fetch item price for {}", itemId, ex);
				}

				AsyncBufferedImage itemImage = itemManager.getImage(itemId);

				ITEMS_LIST.add(new GrandExchangeItems(itemImage, item.getName(), itemId, itemPrice != null ? itemPrice.getPrice() : 0, itemComp.getPrice() * 0.6));

				// If using hotkey to lookup item, stop after finding match.
				if (exactMatch && item.getName().equalsIgnoreCase(lookup))
				{
					break;
				}
			}
		}

		SwingUtilities.invokeLater(() ->
		{
			if (ITEMS_LIST.isEmpty())
			{
				showSearchString("No results found.");
			}
			else
			{
				for (GrandExchangeItems item : ITEMS_LIST)
				{
					GrandExchangeItemPanel panel = new GrandExchangeItemPanel(item.getIcon(), item.getName(),
						item.getItemId(), item.getGePrice(), item.getHaPrice());

					searchItemsPanel.add(panel);
				}

				// Remove searching label after search is complete
				showSearchString(null);
				ITEMS_LIST.clear();
			}
		});
	}

	private void showSearchString(String str)
	{
		if (str != null)
		{
			remove(searchingLabel);
			searchingLabel.setText(str);
			add(searchingLabel, BorderLayout.CENTER);
		}
		else
		{
			remove(searchingLabel);
		}

		revalidate();
		repaint();
	}
}
