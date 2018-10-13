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
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.config.ConfigManager;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.CONFIG_GROUP;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.JOINER;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.SPLITTER;
import net.runelite.client.util.Text;

@Singleton
public class TagManager
{
	private static final String ITEM_KEY_PREFIX = "item_";
	private final ConfigManager configManager;

	@Inject
	private TagManager(final ConfigManager configManager)
	{
		this.configManager = configManager;
	}

	public String getTagString(int itemId)
	{
		String config = configManager.getConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
		if (config == null)
		{
			return "";
		}

		return config;
	}

	Collection<String> getTags(int itemId)
	{
		return new LinkedHashSet<>(SPLITTER.splitToList(getTagString(itemId).toLowerCase()));
	}

	public void setTagString(int itemId, String tags)
	{
		if (Strings.isNullOrEmpty(tags))
		{
			configManager.unsetConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId);
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, ITEM_KEY_PREFIX + itemId, tags);
		}
	}

	public void addTag(int itemId, String tag)
	{
		final Collection<String> tags = getTags(itemId);
		if (tags.add(Text.standardize(tag)))
		{
			setTags(itemId, tags);
		}
	}

	private void setTags(int itemId, Collection<String> tags)
	{
		setTagString(itemId, JOINER.join(tags));
	}

	boolean findTag(int itemId, String search)
	{
		return getTags(itemId).stream().anyMatch(tag -> tag.contains(Text.standardize(search)));
	}

	public void removeTag(String tag)
	{
		final String prefix = CONFIG_GROUP + "." + ITEM_KEY_PREFIX;
		configManager.getConfigurationKeys(prefix).forEach(item -> removeTag(Integer.parseInt(item.replace(prefix, "")), tag));
	}

	public void removeTag(int itemId, String tag)
	{
		final Collection<String> tags = getTags(itemId);
		if (tags.remove(Text.standardize(tag)))
		{
			setTags(itemId, tags);
		}
	}
}
