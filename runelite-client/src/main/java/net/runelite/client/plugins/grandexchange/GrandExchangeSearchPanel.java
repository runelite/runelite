/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
<<<<<<< HEAD
=======
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
>>>>>>> upstream/master
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
<<<<<<< HEAD
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
=======
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
>>>>>>> upstream/master
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ItemComposition;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
<<<<<<< HEAD
import net.runelite.client.plugins.hiscore.IconTextField;
=======
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.PluginErrorPanel;
<<<<<<< HEAD
>>>>>>> upstream/master
import net.runelite.http.api.item.Item;
=======
>>>>>>> upstream/master
import net.runelite.http.api.item.ItemPrice;

<<<<<<< HEAD
@Slf4j
class GrandExchangeSearchPanel extends JPanel
{
	private static final List<GrandExchangeItems> ITEMS_LIST = new ArrayList<>();
=======
/**
 * This panel holds the search section of the Grand Exchange Plugin.
 * It should display a search bar and either item results or a error panel.
 */
@Slf4j
class GrandExchangeSearchPanel extends JPanel
{
	private static final String ERROR_PANEL = "ERROR_PANEL";
	private static final String RESULTS_PANEL = "RESULTS_PANEL";
	private static final int MAX_SEARCH_ITEMS = 100;

	private final GridBagConstraints constraints = new GridBagConstraints();
	private final CardLayout cardLayout = new CardLayout();
>>>>>>> upstream/master

	private final ClientThread clientThread;
	private final ItemManager itemManager;
	private final ScheduledExecutorService executor;

<<<<<<< HEAD
<<<<<<< HEAD
	private Icon search;

	private IconTextField searchBox = new IconTextField();
	private JPanel container = new JPanel();
	private JPanel searchItemsPanel = new JPanel();
	private JLabel searchingLabel = new JLabel();
=======
	private final IconTextField searchBox = new IconTextField();

	/*  The main container, this holds the search bar and the center panel */
	private final JPanel container = new JPanel();
=======
	private final IconTextField searchBar = new IconTextField();
>>>>>>> upstream/master

	/*  The results container, this will hold all the individual ge item panels */
	private final JPanel searchItemsPanel = new JPanel();

	/*  The center panel, this holds either the error panel or the results container */
	private final JPanel centerPanel = new JPanel(cardLayout);

	/*  The error panel, this displays an error message */
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	private final List<GrandExchangeItems> itemsList = new ArrayList<>();

<<<<<<< HEAD
	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				SEARCH_ICON = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search_darker.png")));
				LOADING_ICON = new ImageIcon(IconTextField.class.getResource("loading_spinner.gif"));
				ERROR_ICON = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("error.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
>>>>>>> upstream/master
=======
	@Setter
	private Map<Integer, Integer> itemGELimits = Collections.emptyMap();
>>>>>>> upstream/master

	GrandExchangeSearchPanel(ClientThread clientThread, ItemManager itemManager, ScheduledExecutorService executor)
	{
		this.clientThread = clientThread;
		this.itemManager = itemManager;
		this.executor = executor;

		setLayout(new BorderLayout());
<<<<<<< HEAD
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
=======
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		/*  The main container, this holds the search bar and the center panel */
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout(5, 5));
		container.setBorder(new EmptyBorder(10, 10, 10, 10));
		container.setBackground(ColorScheme.DARK_GRAY_COLOR);

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(100, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.addActionListener(e -> executor.execute(() -> priceLookup(false)));

		searchItemsPanel.setLayout(new GridBagLayout());
		searchItemsPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		/* This panel wraps the results panel and guarantees the scrolling behaviour */
		JPanel wrapper = new JPanel(new BorderLayout());
		wrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		wrapper.add(searchItemsPanel, BorderLayout.NORTH);

		/*  The results wrapper, this scrolling panel wraps the results container */
		JScrollPane resultsWrapper = new JScrollPane(wrapper);
		resultsWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		resultsWrapper.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		resultsWrapper.getVerticalScrollBar().setBorder(new EmptyBorder(0, 5, 0, 0));
		resultsWrapper.setVisible(false);

		/* This panel wraps the error panel and limits its height */
		JPanel errorWrapper = new JPanel(new BorderLayout());
		errorWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		errorWrapper.add(errorPanel, BorderLayout.NORTH);

		errorPanel.setContent("Grand Exchange Search",
			"Here you can search for an item by its name to find price information.");

		centerPanel.add(resultsWrapper, RESULTS_PANEL);
		centerPanel.add(errorWrapper, ERROR_PANEL);

		cardLayout.show(centerPanel, ERROR_PANEL);

		container.add(searchBar, BorderLayout.NORTH);
		container.add(centerPanel, BorderLayout.CENTER);

		add(container, BorderLayout.CENTER);
>>>>>>> upstream/master
	}

	void priceLookup(String item)
	{
		searchBar.setText(item);
		executor.execute(() -> priceLookup(true));
	}

	private void priceLookup(boolean exactMatch)
	{
		String lookup = searchBar.getText();

		if (Strings.isNullOrEmpty(lookup))
		{
			searchItemsPanel.removeAll();
			SwingUtilities.invokeLater(searchItemsPanel::updateUI);
			return;
		}

		// Input is not empty, add searching label
		searchItemsPanel.removeAll();
<<<<<<< HEAD
<<<<<<< HEAD
		showSearchString("Searching...");
=======
		searchBox.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
		searchBox.setEditable(false);
		searchBox.setIcon(LOADING_ICON);
>>>>>>> upstream/master

		SearchResult result;

		try
		{
			result = itemManager.searchForItem(lookup);
		}
<<<<<<< HEAD
		catch (ExecutionException ex)
		{
			log.warn("Unable to search for item {}", lookup, ex);
			showSearchString("Error performing search");
			return;
		}


		if (result != null && !result.getItems().isEmpty())
		{
=======
		catch (Exception ex) // handle com.google.common.cache.CacheLoader$InvalidCacheLoadException
=======
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setEditable(false);
		searchBar.setIcon(IconTextField.Icon.LOADING);

		List<ItemPrice> result = itemManager.search(lookup);
		if (result.isEmpty())
>>>>>>> upstream/master
		{
			searchBar.setIcon(IconTextField.Icon.ERROR);
			errorPanel.setContent("No results found.", "No items were found with that name, please try again.");
			cardLayout.show(centerPanel, ERROR_PANEL);
			searchBar.setEditable(true);
			return;
		}

		// move to client thread to lookup item composition
		clientThread.invokeLater(() -> processResult(result, lookup, exactMatch));
	}

	private void processResult(List<ItemPrice> result, String lookup, boolean exactMatch)
	{
		itemsList.clear();

		cardLayout.show(centerPanel, RESULTS_PANEL);

<<<<<<< HEAD
>>>>>>> upstream/master
			for (Item item : result.getItems())
=======
		int count = 0;

		for (ItemPrice item : result)
		{
			if (count++ > MAX_SEARCH_ITEMS)
>>>>>>> upstream/master
			{
				// Cap search
				break;
			}

			int itemId = item.getId();

			ItemComposition itemComp = itemManager.getItemComposition(itemId);
			if (itemComp == null)
			{
				continue;
			}

			int itemPrice = item.getPrice();
			int itemLimit = itemGELimits.getOrDefault(itemId, 0);
			AsyncBufferedImage itemImage = itemManager.getImage(itemId);

<<<<<<< HEAD
<<<<<<< HEAD
				ITEMS_LIST.add(new GrandExchangeItems(itemImage, item.getName(), itemId, itemPrice != null ? itemPrice.getPrice() : 0, itemComp.getPrice() * 0.6));
=======
				itemsList.add(new GrandExchangeItems(itemImage, item.getName(), itemId, itemPrice != null ? itemPrice.getPrice() : 0, itemComp.getPrice() * 0.6));
>>>>>>> upstream/master
=======
			itemsList.add(new GrandExchangeItems(itemImage, item.getName(), itemId, itemPrice, itemComp.getPrice() * 0.6, itemLimit));
>>>>>>> upstream/master

			// If using hotkey to lookup item, stop after finding match.
			if (exactMatch && item.getName().equalsIgnoreCase(lookup))
			{
				break;
			}
		}
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
		else
		{
			searchBox.setIcon(ERROR_ICON);
			errorPanel.setContent("No results found.", "No items were found with that name, please try again.");
			cardLayout.show(centerPanel, ERROR_PANEL);
		}
=======
>>>>>>> upstream/master

		SwingUtilities.invokeLater(() ->
		{
			int index = 0;
			for (GrandExchangeItems item : itemsList)
			{
				GrandExchangeItemPanel panel = new GrandExchangeItemPanel(item.getIcon(), item.getName(),
					item.getItemId(), item.getGePrice(), item.getHaPrice(), item.getGeItemLimit());

				/*
				Add the first item directly, wrap the rest with margin. This margin hack is because
				gridbaglayout does not support inter-element margins.
				 */
				if (index++ > 0)
				{
					JPanel marginWrapper = new JPanel(new BorderLayout());
					marginWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
					marginWrapper.setBorder(new EmptyBorder(5, 0, 0, 0));
					marginWrapper.add(panel, BorderLayout.NORTH);
					searchItemsPanel.add(marginWrapper, constraints);
				}
				else
				{
					searchItemsPanel.add(panel, constraints);
				}

				constraints.gridy++;
			}

			// if exactMatch was set, then it came from the applet, so don't lose focus
			if (!exactMatch)
			{
				searchItemsPanel.requestFocusInWindow();
			}
			searchBar.setEditable(true);

			// Remove searching label after search is complete
			if (!itemsList.isEmpty())
			{
<<<<<<< HEAD
				searchBox.setIcon(SEARCH_ICON);
>>>>>>> upstream/master
=======
				searchBar.setIcon(IconTextField.Icon.SEARCH);
>>>>>>> upstream/master
			}
		});
	}

<<<<<<< HEAD
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
=======
}
>>>>>>> upstream/master
