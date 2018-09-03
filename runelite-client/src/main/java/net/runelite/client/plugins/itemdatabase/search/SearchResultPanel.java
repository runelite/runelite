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
package net.runelite.client.plugins.itemdatabase.search;

import java.util.concurrent.CompletableFuture;
import net.runelite.client.plugins.itemdatabase.DisplayPanel;
import net.runelite.client.plugins.itemdatabase.ItemDatabasePanel;

public class SearchResultPanel extends DisplayPanel
{

	private final ItemDatabasePanel itemDatabasePanel;

	public SearchResultPanel(ItemDatabasePanel itemDatabasePanel)
	{
		this.itemDatabasePanel = itemDatabasePanel;
	}
	
	

	public CompletableFuture search(String text)
	{
		itemDatabasePanel.setDisplayPanel(this);

		CompletableFuture<Integer> searchResultItems = new CompletableFuture();

		new Thread(new Search(searchResultItems, text)).start();

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
			searchResultItems.complete(1); // Amount of search results
		}

	}

}
