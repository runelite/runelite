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
package net.runelite.client.plugins.banktags;

import com.google.common.base.Strings;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ItemID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.CONFIG_GROUP;
import net.runelite.client.plugins.cluescrolls.ClueScrollService;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.CoordinateClue;
import net.runelite.client.plugins.cluescrolls.clues.EmoteClue;
import net.runelite.client.plugins.cluescrolls.clues.FairyRingClue;
import net.runelite.client.plugins.cluescrolls.clues.HotColdClue;
import net.runelite.client.plugins.cluescrolls.clues.MapClue;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import net.runelite.api.util.Text;

@Singleton
public class TagManager
{
	private static final String ITEM_KEY_PREFIX = "item_";
	private final ConfigManager configManager;
	private final ItemManager itemManager;
	private final ClueScrollService clueScrollService;

	@Inject
	private TagManager(
		final ItemManager itemManager,
		final ConfigManager configManager,
		final ClueScrollService clueScrollService)
	{
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.clueScrollService = clueScrollService;
	}

	private String getTagString(int itemId, boolean variation)
	{
		itemId = getItemId(itemId, variation);

		String config = configManager.getConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
		if (config == null)
		{
			return "";
		}

		return config;
	}

	Collection<String> getTags(int itemId, boolean variation)
	{
		return new LinkedHashSet<>(Text.fromCSV(getTagString(itemId, variation).toLowerCase()));
	}

	void setTagString(int itemId, String tags, boolean variation)
	{
		itemId = getItemId(itemId, variation);

		if (Strings.isNullOrEmpty(tags))
		{
			configManager.unsetConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId, tags);
		}
	}

	public void addTags(int itemId, final Collection<String> t, boolean variation)
	{
		final Collection<String> tags = getTags(itemId, variation);
		if (tags.addAll(t))
		{
			setTags(itemId, tags, variation);
		}
	}

	public void addTag(int itemId, String tag, boolean variation)
	{
		final Collection<String> tags = getTags(itemId, variation);
		if (tags.add(Text.standardize(tag)))
		{
			setTags(itemId, tags, variation);
		}
	}

	private void setTags(int itemId, Collection<String> tags, boolean variation)
	{
		setTagString(itemId, Text.toCSV(tags), variation);
	}

	boolean findTag(int itemId, String search)
	{
		if (search.equals("clue") && testClue(itemId))
		{
			return true;
		}

		Collection<String> tags = getTags(itemId, false);
		tags.addAll(getTags(itemId, true));
		return tags.stream().anyMatch(tag -> tag.startsWith(Text.standardize(search)));
	}

	public List<Integer> getItemsForTag(String tag)
	{
		final String prefix = CONFIG_GROUP + "." + ITEM_KEY_PREFIX;
		return configManager.getConfigurationKeys(prefix).stream()
			.map(item -> Integer.parseInt(item.replace(prefix, "")))
			.filter(item -> getTags(item, false).contains(tag) || getTags(item, true).contains(tag))
			.collect(Collectors.toList());
	}

	public void removeTag(String tag)
	{
		final String prefix = CONFIG_GROUP + "." + ITEM_KEY_PREFIX;
		configManager.getConfigurationKeys(prefix).forEach(item ->
		{
			int id = Integer.parseInt(item.replace(prefix, ""));
			removeTag(id, tag);
		});
	}

	public void removeTag(int itemId, String tag)
	{
		Collection<String> tags = getTags(itemId, false);
		if (tags.remove(Text.standardize(tag)))
		{
			setTags(itemId, tags, false);
		}

		tags = getTags(itemId, true);
		if (tags.remove(Text.standardize(tag)))
		{
			setTags(itemId, tags, true);
		}
	}

	public void renameTag(String oldTag, String newTag)
	{
		List<Integer> items = getItemsForTag(Text.standardize(oldTag));
		items.forEach(id ->
		{
			Collection<String> tags = getTags(id, id < 0);

			tags.remove(Text.standardize(oldTag));
			tags.add(Text.standardize(newTag));

			setTags(id, tags, id < 0);
		});
	}

	private int getItemId(int itemId, boolean variation)
	{
		itemId = Math.abs(itemId);
		itemId = itemManager.canonicalize(itemId);

		if (variation)
		{
			itemId = ItemVariationMapping.map(itemId) * -1;
		}

		return itemId;
	}

	private boolean testClue(int itemId)
	{
		ClueScroll c = clueScrollService.getClue();

		if (c == null)
		{
			return false;
		}

		if (c instanceof EmoteClue)
		{
			EmoteClue emote = (EmoteClue) c;

			for (ItemRequirement ir : emote.getItemRequirements())
			{
				if (ir.fulfilledBy(itemId))
				{
					return true;
				}
			}
		}
		else if (c instanceof CoordinateClue || c instanceof HotColdClue || c instanceof FairyRingClue)
		{
			return itemId == ItemID.SPADE;
		}
		else if (c instanceof MapClue)
		{
			MapClue mapClue = (MapClue) c;

			return mapClue.getObjectId() == -1 && itemId == ItemID.SPADE;
		}

		return false;
	}
}
