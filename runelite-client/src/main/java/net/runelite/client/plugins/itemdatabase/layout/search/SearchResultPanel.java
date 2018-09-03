/*
 * Copyright (c) 2018 Patrick Beuks (killje) <patrick.beuks@gmail.com>
 * Copyright (c) 2018 CC007 <Coolcat_the_best2@hotmail.com>
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
package net.runelite.client.plugins.itemdatabase.layout.search;

import java.awt.Color;
import java.awt.TextArea;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ItemID;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.plugins.itemdatabase.layout.DisplayPanel;
import net.runelite.client.plugins.itemdatabase.layout.DisplayPanelWrapper;
import net.runelite.client.plugins.itemdatabase.layout.DisplayState;
import net.runelite.client.plugins.itemdatabase.layout.DisplayStateManager;

@Singleton
public class SearchResultPanel extends DisplayPanel
{

	@Inject
	private ClientThread clientThread;

	@Inject
	private DisplayStateManager displayStateManager;

	@Inject
	private DisplayPanelWrapper displayPanelWrapper;

	public SearchResultPanel()
	{
		TextArea panel = new TextArea();
		panel.append("Good bye!");
		panel.setBackground(Color.BLUE);
		add(panel);
	}

	public CompletableFuture search(String text)
	{
		displayStateManager.setDisplayState(DisplayState.RESULTS);
		displayPanelWrapper.setDisplayPanel(RuneLite.getInjector().getInstance(DisplayPanel.class));
		CompletableFuture<Integer> searchResultItems = new CompletableFuture<>();

		clientThread.invokeLater(new Search(searchResultItems, text));
		return searchResultItems;

	}

	private class Search implements Runnable
	{

		private final CompletableFuture<Integer> searchResultItems;
		private final String searchText;

		public Search(CompletableFuture<Integer> searchResultItems, String searchText)
		{
			this.searchResultItems = searchResultItems;
			this.searchText = searchText;
		}

		@Override
		public void run()
		{
			searchResultItems.complete(ItemID.IRON_ORE); // Amount of search results
		}

	}

}
