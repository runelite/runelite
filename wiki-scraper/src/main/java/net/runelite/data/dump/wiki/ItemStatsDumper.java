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
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.cache.ItemManager;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.Namer;
import net.runelite.data.App;
import net.runelite.data.dump.MediaWiki;
import net.runelite.data.dump.MediaWikiTemplate;

@Slf4j
public class ItemStatsDumper
{
	private final static Integer MAX_ITEMS_ON_PAGE = 50;

	public static void dump(final Store store, final MediaWiki wiki, final File path) throws IOException
	{
		log.info("Dumping item stats to {}", path);

		final ItemManager itemManager = new ItemManager(store);
		itemManager.load();

		final Map<Integer, ItemStats> itemStats = new TreeMap<>();
		final Collection<ItemDefinition> items = itemManager.getItems();
		final Stream<ItemDefinition> itemDefinitionStream = items.parallelStream();

		itemDefinitionStream.forEach(item ->
		{
			if (item.getNotedTemplate() != -1)
			{
				return;
			}

			if (item.name.equalsIgnoreCase("NULL"))
			{
				return;
			}

			final String name = Namer
				.removeTags(item.name)
				.replace('\u00A0', ' ')
				.trim();

			if (name.isEmpty())
			{
				return;
			}

			String data = wiki.getSpecialLookupData("item", item.id, 0);

			if (Strings.isNullOrEmpty(data))
			{
				return;
			}

			MediaWikiTemplate base = MediaWikiTemplate.parseWikitext("Infobox Item", data);

			if (base == null)
			{
				return;
			}

			final int nItems = findMaxIndex(base);
			final ItemStats.ItemStatsBuilder itemStat = ItemStats.builder();

			for (int index = 1; index <= nItems; index++)
			{
				final int offset = nItems == 1 ? 0 : index;
				final String wikiName = getVarString(base, "name", offset);

				// Skip this index if name or itemId doesn't match with wiki
				if (nItems > 1 && !wikiName.equalsIgnoreCase(name))
				{
					continue;
				}

				itemStat.name(getVarString(base, "name", offset) == null ? getVarString(base, "name1", offset) : getVarString(base, "name", offset));
				itemStat.quest(getVarBoolean(base, "quest", offset));
				itemStat.equipable(getVarBoolean(base, "equipable", offset) == null
					? getVarBoolean(base, "equipable1", offset) : getVarBoolean(base, "equipable", offset));
				itemStat.weight(getVarDouble(base, "weight", offset));


				if (Boolean.TRUE.equals(itemStat.equipable))
				{
					MediaWikiTemplate stats = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);

					if (stats == null)
					{
						data = wiki.getSpecialLookupData("item", item.id, 1);

						if (Strings.isNullOrEmpty(data))
						{
							break;
						}

						stats = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
					}

					if (stats == null)
					{
						break;
					}

					final ItemEquipmentStats.ItemEquipmentStatsBuilder equipmentStat = ItemEquipmentStats.builder();

					equipmentStat.slot(toEquipmentSlot(getVarString(stats, "slot", offset)));
					equipmentStat.astab(getVarInt(stats, "astab", offset));
					equipmentStat.aslash(getVarInt(stats, "aslash", offset));
					equipmentStat.acrush(getVarInt(stats, "acrush", offset));
					equipmentStat.amagic(getVarInt(stats, "amagic", offset));
					equipmentStat.arange(getVarInt(stats, "arange", offset));

					equipmentStat.dstab(getVarInt(stats, "dstab", offset));
					equipmentStat.dslash(getVarInt(stats, "dslash", offset));
					equipmentStat.dcrush(getVarInt(stats, "dcrush", offset));
					equipmentStat.dmagic(getVarInt(stats, "dmagic", offset));
					equipmentStat.drange(getVarInt(stats, "drange", offset));

					equipmentStat.str(getVarInt(stats, "str", offset));
					equipmentStat.rstr(getVarInt(stats, "rstr", offset));
					equipmentStat.mdmg(getVarInt(stats, "mdmg", offset));
					equipmentStat.prayer(getVarInt(stats, "prayer", offset));
					equipmentStat.aspeed(getVarInt(stats, "aspeed", offset));

					final ItemEquipmentStats builtEqStat = equipmentStat.build();

					if (!builtEqStat.equals(ItemEquipmentStats.builder().build()))
					{
						itemStat.equipment(builtEqStat);
					}
				}

				break;
			}

			final ItemStats val = itemStat.build();

			if (ItemStats.DEFAULT.equals(val))
			{
				return;
			}

			itemStats.put(item.id, val);
			log.debug("Dumped item stat for {} {}", item.id, name);
		});

		try (FileWriter fw = new FileWriter(new File(path, "item_stats.json")))
		{
			fw.write(App.GSON.toJson(itemStats));
		}

		log.info("Dumped {} item stats", itemStats.size());
	}

	/**
	 * Counts how many items are on page
	 *
	 * @param template media wiki template
	 * @return item count
	 */
	private static int findMaxIndex(final MediaWikiTemplate template)
	{
		int nItems = 1;

		if (template.getValue("version1") == null)
		{
			return nItems;
		}

		while (nItems < MAX_ITEMS_ON_PAGE)
		{
			if (template.getValue(fixIndex("name", nItems + 1)) != null || template.getValue(fixIndex("version", nItems + 1)) != null)
			{
				nItems++;
			}
			else
			{
				break;
			}
		}

		return nItems;
	}

	/**
	 * Return fixed string version of indexed key
	 *
	 * @param base  key name
	 * @param index current index
	 * @return string representation of index
	 */
	private static String fixIndex(final String base, final Integer index)
	{
		return index == 0 ? base : base + index;
	}

	private static String getVarString(final MediaWikiTemplate template, final String key, final Integer index)
	{
		final String var = template.getValue(fixIndex(key, index));

		if (var != null)
		{
			return var;
		}

		return template.getValue(key);
	}

	private static Boolean getVarBoolean(final MediaWikiTemplate template, final String key, final Integer index)
	{
		final Boolean var = template.getBoolean(fixIndex(key, index));

		if (var != null)
		{
			return var;
		}

		return template.getBoolean(key);
	}

	private static Integer getVarInt(final MediaWikiTemplate template, final String key, final Integer index)
	{
		final Integer var = template.getInt(fixIndex(key, index));

		if (var != null)
		{
			return var;
		}

		return template.getInt(key);
	}

	private static Double getVarDouble(final MediaWikiTemplate template, final String key, final Integer index)
	{
		final Double var = template.getDouble(fixIndex(key, index));

		if (var != null)
		{
			return var;
		}

		return template.getDouble(key);
	}

	private static Integer toEquipmentSlot(final String slotName)
	{
		if (slotName == null)
		{
			return null;
		}

		switch (slotName.toLowerCase())
		{
			case "weapon":
			case "2h":
				// TODO: 2h should return both weapon and shield somehow
				return EquipmentInventorySlot.WEAPON.getSlotIdx();
			case "body":
				return EquipmentInventorySlot.BODY.getSlotIdx();
			case "head":
				return EquipmentInventorySlot.HEAD.getSlotIdx();
			case "ammo":
				return EquipmentInventorySlot.AMMO.getSlotIdx();
			case "legs":
				return EquipmentInventorySlot.LEGS.getSlotIdx();
			case "feet":
				return EquipmentInventorySlot.BOOTS.getSlotIdx();
			case "hands":
				return EquipmentInventorySlot.GLOVES.getSlotIdx();
			case "cape":
				return EquipmentInventorySlot.CAPE.getSlotIdx();
			case "neck":
				return EquipmentInventorySlot.AMULET.getSlotIdx();
			case "ring":
				return EquipmentInventorySlot.RING.getSlotIdx();
			case "shield":
				return EquipmentInventorySlot.SHIELD.getSlotIdx();
		}

		return null;
	}

	@Value
	@Builder
	private static final class ItemEquipmentStats
	{
		private final Integer slot;

		private final Integer astab;
		private final Integer aslash;
		private final Integer acrush;
		private final Integer amagic;
		private final Integer arange;

		private final Integer dstab;
		private final Integer dslash;
		private final Integer dcrush;
		private final Integer dmagic;
		private final Integer drange;

		private final Integer str;
		private final Integer rstr;
		private final Integer mdmg;
		private final Integer prayer;
		private final Integer aspeed;
	}

	@Value
	@Builder
	private static final class ItemStats
	{
		static final ItemStats DEFAULT = ItemStats.builder().build();

		private final String name;
		private final Boolean quest;
		private final Boolean equipable;
		private final Double weight;

		private final ItemEquipmentStats equipment;
	}
}
