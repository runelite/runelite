/*
 * MIT License
 *
 * Copyright (c) 2018 Tomas Slusny
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.runelite.data.dump.wiki;

import com.google.common.base.Strings;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.ItemManager;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.Namer;
import net.runelite.data.App;
import net.runelite.data.dump.MediaWiki;
import net.runelite.data.dump.MediaWikiTemplate;

@Slf4j
public class ItemLimitsDumper
{
	public static void dump(final Store store, final MediaWiki wiki, final File path) throws IOException
	{
		log.info("Dumping item limits to {}", path);

		final ItemManager itemManager = new ItemManager(store);
		itemManager.load();
		final Pattern pattern = Pattern.compile("limit {6}= (.*),");

		final Map<Integer, Integer> limits = new TreeMap<>();
		final Collection<ItemDefinition> items = itemManager.getItems();
		final Stream<ItemDefinition> itemDefinitionStream = items.parallelStream();
		List<String> missing = new ArrayList<>();

		itemDefinitionStream.forEach(item ->
		{
			if (!item.isTradeable)
			{
				return;
			}

			if (item.getNotedTemplate() != -1)
			{
				return;
			}

			if (item.name.equalsIgnoreCase("NULL"))
			{
				return;
			}

			String name = Namer
				.removeTags(item.name)
				.replace('\u00A0', ' ')
				.replaceAll("\\+", "%2b")
				.trim();

			if (name.isEmpty())
			{
				return;
			}

			String data = wiki.getPageData("Module:Exchange/" + name, -1);

			if (Strings.isNullOrEmpty(data))
			{
				log.debug("Data is null or empty: {}", name);
				missing.add(name);
				return;
			}

			final MediaWikiTemplate geStats = MediaWikiTemplate.parseLua(data);

			if (geStats == null)
			{
				return;
			}

			final Integer limit = geStats.getInt("limit");

			if (limit == null || limit <= 0)
			{
				Matcher matcher = pattern.matcher(data);
				String temp = "";
				while (matcher.find())
				{
					temp = matcher.group(1);
					if (Strings.isNullOrEmpty(temp) ||
						temp.equalsIgnoreCase("no") ||
						temp.equalsIgnoreCase("n/a") ||
						temp.equals("nil") ||
						temp.equalsIgnoreCase("varies"))
					{
						temp = null;
					}
				}
				if (!Strings.isNullOrEmpty(temp))
				{
					limits.put(item.id, Integer.valueOf(temp));
				}
				else
				{
					log.debug("Item was still null: {}", name);
					missing.add(name);
				}
				return;
			}

			limits.put(item.id, limit);
			log.debug("Dumped item limit for {} {}", item.id, name);
		});

		try (FileWriter fw = new FileWriter(new File(path, "ge_limits.json")))
		{
			fw.write(App.GSON.toJson(limits));
		}

		log.info("Dumped {} item limits", limits.size());
		log.info("Total Missing: " + missing.size());
		missing.forEach(str ->
		{
			log.info("Still Missing: {}", str);
		});
	}
}