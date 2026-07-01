/*
 * Copyright (c) 2020, Jack Hodkinson <https://github.com/jrhodkinson>
 * All rights reserved
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
package net.runelite.client.plugins.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PluginSearchTest
{
	private Map<String, SearchablePlugin> plugins;

	@Before
	public void setUp()
	{
		plugins = new HashMap<>();
		plugins.put("Discord", new TestSearchablePlugin("Discord", false, "action", "activity", "external", "integration", "status"));
		plugins.put("Emojis", new TestSearchablePlugin("Emojis", true, "replaces", "common", "emoticons"));
		plugins.put("Grand Exchange", new TestSearchablePlugin("Grand Exchange", true, "external", "integration", "notifications", "panel", "prices", "trade"));
		plugins.put("Status Bars", new TestSearchablePlugin("Status Bars", false, "Draws", "status", "bars"));
	}

	@Test
	public void emptyQueryReturnsPluginsInAlphabeticalOrderWithPinnedItemsFirst()
	{
		List<SearchablePlugin> results = PluginSearch.search(plugins.values(), " ");
		assertThat(results, containsInAnyOrder(plugins.values().toArray(new SearchablePlugin[] {})));
	}

	@Test
	public void searchReturnsMatchingPlugins()
	{
		List<SearchablePlugin> results = PluginSearch.search(plugins.values(), "sTATus");
		assertThat(results, hasSize(2));
		assertThat(results, containsInAnyOrder(plugins.get("Discord"), plugins.get("Status Bars")));
	}

	@Test
	public void searchOrdersItemsWithMatchesInTitleFirst()
	{
		List<SearchablePlugin> results = PluginSearch.search(plugins.values(), "STATUS");
		assertThat(results.get(0), equalTo(plugins.get("Status Bars")));
	}

	@Test
	public void searchOrdersPinnedItemsFirstIfThereAreNoExactMatches()
	{
		List<SearchablePlugin> results = PluginSearch.search(plugins.values(), "integrat");
		assertThat(results, contains(plugins.get("Grand Exchange"), plugins.get("Discord")));
	}

	private static class TestSearchablePlugin implements SearchablePlugin
	{
		private final String name;
		private final boolean pinned;
		private final List<String> keywords;

		public TestSearchablePlugin(String name, boolean pinned, String... keywords)
		{
			this.name = name;
			this.pinned = pinned;
			this.keywords = Arrays.asList(keywords);
		}

		@Override
		public String getSearchableName()
		{
			return name;
		}

		@Override
		public boolean isPinned()
		{
			return pinned;
		}

		@Override
		public List<String> getKeywords()
		{
			return keywords;
		}
	}
}
