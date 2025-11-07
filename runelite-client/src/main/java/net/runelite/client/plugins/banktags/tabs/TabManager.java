/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.plugins.banktags.tabs;

import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.config.ConfigManager;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.CONFIG_GROUP;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.TAG_ICON_PREFIX;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.TAG_TABS_CONFIG;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.math.NumberUtils;

@Singleton
public class TabManager
{
	@Getter
	private final List<TagTab> tabs = new ArrayList<>();
	private final ConfigManager configManager;

	@Inject
	private TabManager(ConfigManager configManager)
	{
		this.configManager = configManager;
	}

	public void add(TagTab tagTab)
	{
		if (!contains(tagTab.getTag()))
		{
			tabs.add(tagTab);
		}
	}

	void clear()
	{
		tabs.clear();
	}

	public TagTab find(String tag)
	{
		Optional<TagTab> first = tabs.stream().filter(t -> t.getTag().equals(Text.standardize(tag))).findAny();
		return first.orElse(null);
	}

	List<String> loadAllTabNames()
	{
		return Text.fromCSV(MoreObjects.firstNonNull(configManager.getConfiguration(CONFIG_GROUP, TAG_TABS_CONFIG), ""));
	}

	TagTab load(String tag)
	{
		TagTab tagTab = find(tag);

		if (tagTab == null)
		{
			tag = Text.standardize(tag);
			String item = configManager.getConfiguration(CONFIG_GROUP, TAG_ICON_PREFIX + tag);
			int itemid = NumberUtils.toInt(item, ItemID.SPADE);
			tagTab = new TagTab(itemid, tag);
		}

		return tagTab;
	}

	private void save(TagTab tab)
	{
		setIcon(tab.getTag(), tab.getIconItemId());
	}

	void swap(String tagToMove, String tagDestination)
	{
		tagToMove = Text.standardize(tagToMove);
		tagDestination = Text.standardize(tagDestination);

		if (contains(tagToMove) && contains(tagDestination))
		{
			Collections.swap(tabs, indexOf(tagToMove), indexOf(tagDestination));
		}
	}

	void insert(String tagToMove, String tagDestination)
	{
		tagToMove = Text.standardize(tagToMove);
		tagDestination = Text.standardize(tagDestination);

		if (contains(tagToMove) && contains(tagDestination))
		{
			tabs.add(indexOf(tagDestination), tabs.remove(indexOf(tagToMove)));
		}
	}

	public void remove(String tag)
	{
		TagTab tagTab = find(tag);

		if (tagTab != null)
		{
			tabs.remove(tagTab);
			removeIcon(tag);
		}
	}

	public void save()
	{
		String tags = Text.toCSV(tabs.stream().map(TagTab::getTag).collect(Collectors.toList()));
		configManager.setConfiguration(CONFIG_GROUP, TAG_TABS_CONFIG, tags);

		for (TagTab tab : tabs)
		{
			save(tab);
		}
	}

	private void removeIcon(final String tag)
	{
		configManager.unsetConfiguration(CONFIG_GROUP, TAG_ICON_PREFIX + Text.standardize(tag));
	}

	private void setIcon(final String tag, int itemId)
	{
		configManager.setConfiguration(CONFIG_GROUP, TAG_ICON_PREFIX + Text.standardize(tag), itemId);
	}

	int size()
	{
		return tabs.size();
	}

	private boolean contains(String tag)
	{
		return tabs.stream().anyMatch(t -> t.getTag().equals(tag));
	}

	private int indexOf(TagTab tagTab)
	{
		return tabs.indexOf(tagTab);
	}

	private int indexOf(String tag)
	{
		return indexOf(find(tag));
	}
}
