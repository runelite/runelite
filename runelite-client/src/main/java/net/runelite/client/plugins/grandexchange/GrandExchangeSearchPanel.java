/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
package net.runelite.client.plugins.grandexchange;

import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.api.ItemComposition;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.ItemStats;

/**
 * This panel holds the search section of the Grand Exchange Plugin.
 * It should display a search bar and either item results or a error panel.
 */
class GrandExchangeSearchPanel extends JPanel
{
	private static final String ERROR_PANEL = "ERROR_PANEL";
	private static final String RESULTS_PANEL = "RESULTS_PANEL";
	private static final int MAX_SEARCH_ITEMS = 100;

	private final GridBagConstraints constraints = new GridBagConstraints();
	private final CardLayout cardLayout = new CardLayout();

	private final ClientThread clientThread;
	private final ItemManager itemManager;
	private final ScheduledExecutorService executor;
	private final RuneLiteConfig runeLiteConfig;
	private final GrandExchangePlugin grandExchangePlugin;

	private final IconTextField searchBar = new IconTextField();

	/*  The results container, this will hold all the individual ge item panels */
	private final JPanel searchItemsPanel = new JPanel();

	/*  The center panel, this holds either the error panel or the results container */
	private final JPanel centerPanel = new JPanel(cardLayout);

	/*  The error panel, this displays an error message */
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();

	@Inject
	private GrandExchangeSearchPanel(ClientThread clientThread, ItemManager itemManager,
		ScheduledExecutorService executor, RuneLiteConfig runeLiteConfig, GrandExchangePlugin grandExchangePlugin)
	{
		this.clientThread = clientThread;
		this.itemManager = itemManager;
		this.executor = executor;
		this.runeLiteConfig = runeLiteConfig;
		this.grandExchangePlugin = grandExchangePlugin;

		setLayout(new BorderLayout());
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
		searchBar.addClearListener(this::updateSearch);

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
	}

	void priceLookup(String item)
	{
		searchBar.setText(item);
		executor.execute(() -> priceLookup(true));
	}

	private boolean updateSearch()
	{
		String lookup = searchBar.getText();

		if (Strings.isNullOrEmpty(lookup))
		{
			searchItemsPanel.removeAll();
			SwingUtilities.invokeLater(searchItemsPanel::updateUI);
			return false;
		}

		// Input is not empty, add searching label
		searchItemsPanel.removeAll();
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setEditable(false);
		searchBar.setIcon(IconTextField.Icon.LOADING);
		return true;
	}

	private void priceLookup(boolean exactMatch)
	{
		if (!updateSearch())
		{
			return;
		}

		List<ItemPrice> result = itemManager.search(searchBar.getText());
		if (result.isEmpty())
		{
			searchBar.setIcon(IconTextField.Icon.ERROR);
			errorPanel.setContent("No results found.", "No items were found with that name, please try again.");
			cardLayout.show(centerPanel, ERROR_PANEL);
			searchBar.setEditable(true);
			return;
		}

		// move to client thread to lookup item composition
		clientThread.invokeLater(() -> processResult(result, searchBar.getText(), exactMatch));
	}

	private void processResult(List<ItemPrice> result, String lookup, boolean exactMatch)
	{
		final List<GrandExchangeItems> itemsList = new ArrayList<>();

		cardLayout.show(centerPanel, RESULTS_PANEL);

		int count = 0;
		boolean useActivelyTradedPrice = runeLiteConfig.useWikiItemPrices();

		for (ItemPrice item : result)
		{
			int itemId = item.getId();
			ItemComposition itemComp = itemManager.getItemComposition(itemId);
			if (!itemComp.isTradeable())
			{
				continue;
			}

			if (count++ > MAX_SEARCH_ITEMS)
			{
				// Cap search
				break;
			}

			ItemStats itemStats = itemManager.getItemStats(itemId, false);

			int itemPrice = useActivelyTradedPrice ? itemManager.getWikiPrice(item) : item.getPrice();
			int itemLimit = itemStats != null ? itemStats.getGeLimit() : 0;
			final int haPrice = itemComp.getHaPrice();
			AsyncBufferedImage itemImage = itemManager.getImage(itemId);

			itemsList.add(new GrandExchangeItems(itemImage, item.getName(), itemId, itemPrice, haPrice, itemLimit));

			// If using hotkey to lookup item, stop after finding match.
			if (exactMatch && item.getName().equalsIgnoreCase(lookup))
			{
				break;
			}
		}

		SwingUtilities.invokeLater(() ->
		{
			int index = 0;
			for (GrandExchangeItems item : itemsList)
			{
				GrandExchangeItemPanel panel = new GrandExchangeItemPanel(grandExchangePlugin, item.getIcon(), item.getName(),
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
				searchBar.setIcon(IconTextField.Icon.SEARCH);
			}
		});
	}

}