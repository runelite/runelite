/*
 * Copyright (c) 2019, halworsen <mwh@halvorsenfamilien.com>
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
package net.runelite.client.plugins.itemgoals;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.api.ItemComposition;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.ui.components.PluginErrorPanel;

public class ItemGoalsAddPanel extends JPanel
{
	private static final String ERROR_PANEL = "ERROR_PANEL";
	private static final String RESULT_PANEL = "RESULT_PANEL";
	private static final int MAX_SEARCH_ITEMS = 50;

	private final ClientThread clientThread;
	private final ItemManager itemManager;
	private final ScheduledExecutorService executor;

	private final CardLayout cardLayout = new CardLayout();
	private final JPanel searchContainer = new JPanel(cardLayout);

	private final JPanel resultPanel = new JPanel();

	private final IconTextField searchBar = new IconTextField();
	private final PluginErrorPanel searchFailPanel = new PluginErrorPanel();

	private ItemGoalFullItemSearch searcher;

	private final List<Integer> itemIdsList = new ArrayList<>();
	private final List<ItemGoalsResultPanel> activeResults = new ArrayList<>();

	private ItemGoalsPlugin plugin;

	ItemGoalsAddPanel(ItemGoalsPlugin plugin, ItemManager itemManager, ClientThread clientThread, ScheduledExecutorService executor)
	{
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.clientThread = clientThread;
		this.executor = executor;
		searcher = new ItemGoalFullItemSearch(itemManager);

		init();
	}

	private void init()
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		// Holds the search bar & result list
		JPanel mainContainer = new JPanel();
		mainContainer.setLayout(new BorderLayout(5, 5));
		mainContainer.setBackground(ColorScheme.DARK_GRAY_COLOR);

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(100, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.addActionListener(e -> executor.execute(() -> searchItems()));

		resultPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		resultPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		// Wrap the results panel to prevent results spacing out to cover the full plugin panel
		JPanel resultWrapper = new JPanel();
		resultWrapper.setLayout(new BorderLayout());
		resultWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		resultWrapper.add(resultPanel, BorderLayout.PAGE_START);

		// Give the results a scroll bar
		JScrollPane scrollWrapper = new JScrollPane(resultWrapper);
		scrollWrapper.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		scrollWrapper.getVerticalScrollBar().setBorder(new EmptyBorder(0, 5, 0, 0));
		scrollWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		scrollWrapper.setVisible(false);

		// Wrap the error panel
		JPanel errorWrapper = new JPanel();
		errorWrapper.setLayout(new BorderLayout());
		errorWrapper.add(searchFailPanel, BorderLayout.NORTH);
		searchFailPanel.setContent("Item Search", "Search for any item and add it as a tracked goal.");

		searchContainer.add(scrollWrapper, RESULT_PANEL);
		searchContainer.add(errorWrapper, ERROR_PANEL);
		cardLayout.show(searchContainer, ERROR_PANEL);

		mainContainer.add(searchBar, BorderLayout.NORTH);
		mainContainer.add(searchContainer, BorderLayout.CENTER);

		add(mainContainer, BorderLayout.CENTER);
	}

	private void searchItems()
	{
		itemIdsList.clear();
		resultPanel.removeAll();

		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setEditable(false);
		searchBar.setIcon(IconTextField.Icon.LOADING);

		final String searchText = searchBar.getText();
		List<Integer> results = searcher.searchByName(searchText, false);

		if(results.isEmpty())
		{
			searchBar.setIcon(IconTextField.Icon.ERROR);
			searchFailPanel.setContent("No results found", "No items were found with that name, please try again.");
			cardLayout.show(searchContainer, ERROR_PANEL);
			searchBar.setEditable(true);

			return;
		}

		// Move the search results into a new list with no more than 50 items
		int resultCount = 0;
		for(int itemID : results)
		{
			if(resultCount == MAX_SEARCH_ITEMS)
			{
				break;
			}

			itemIdsList.add(itemID);

			resultCount++;
		}

		clientThread.invokeLater(() -> processResults());
	}

	private void processResults()
	{
		final Map<Integer, String> idToNameMap = new HashMap<>();

		for(int itemID : itemIdsList)
		{
			ItemComposition composition = itemManager.getItemComposition(itemID);

			idToNameMap.put(itemID, composition.getName());
		}

		SwingUtilities.invokeLater(() ->
		{
			activeResults.clear();

			cardLayout.show(searchContainer, RESULT_PANEL);

			// Add a result panel for each item we found
			for(int itemID : itemIdsList)
			{
				final AsyncBufferedImage icon = itemManager.getImage(itemID);
				String name = idToNameMap.get(itemID);

				/*
				 * No point in showing these to F2Ps
				 * Note however: some item variations are mapped down to members only counterparts of items that
				 * are actually available to F2Ps! This can be fixed by mapping variations to the proper
				 * itemIDs in item_variations.json but is a huge undertaking. To-do, maybe?
				*/
				if(name == "Members object")
				{
					continue;
				}

				ItemGoalsResultPanel searchResultPanel = new ItemGoalsResultPanel(plugin, itemID, icon, name);

				activeResults.add(searchResultPanel);
				resultPanel.add(searchResultPanel);
			}

			searchBar.setEditable(true);
			searchBar.setIcon(IconTextField.Icon.SEARCH);
		});
	}

	protected void reset()
	{
		searchBar.setText("");
		activeResults.clear();
		resultPanel.removeAll();
	}

	protected void rebuildResults(boolean onlyIfConnected)
	{
		for(ItemGoalsResultPanel panel : activeResults)
		{
			panel.rebuild(onlyIfConnected);
		}
	}
}
