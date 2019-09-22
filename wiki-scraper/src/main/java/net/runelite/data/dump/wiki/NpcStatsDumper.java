/*
 * MIT License
 *
 * Copyright (c) 2019 TheStonedTurtle <https://github.com/TheStonedTurtle>
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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.NpcManager;
import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.Namer;
import net.runelite.data.App;
import net.runelite.data.dump.MediaWiki;
import net.runelite.data.dump.MediaWikiTemplate;

@Slf4j
public class NpcStatsDumper
{
	@Data
	@Builder
	private static final class NpcStats
	{
		private String name;
		private final Integer hitpoints;
		private final Integer hitpoints1;
		private final Integer combatLevel;
		private final Integer slayerLevel;
		private final Integer attackSpeed;

		private final Integer attackLevel;
		private final Integer strengthLevel;
		private final Integer defenceLevel;
		private final Integer rangeLevel;
		private final Integer magicLevel;

		private final Integer stab;
		private final Integer slash;
		private final Integer crush;
		private final Integer range;
		private final Integer magic;

		private final Integer stabDef;
		private final Integer slashDef;
		private final Integer crushDef;
		private final Integer rangeDef;
		private final Integer magicDef;

		private final Integer bonusAttack;
		private final Integer bonusStrength;
		private final Integer bonusRangeStrength;
		private final Integer bonusMagicDamage;

		private final Boolean poisonImmune;
		private final Boolean venomImmune;

		private final Boolean dragon;
		private final Boolean demon;
		private final Boolean undead;
	}

	private static final NpcStats DEFAULT = NpcStats.builder().build();

	/**
	 * Looks for and parses the `Switch infobox` into a {@link MediaWikiTemplate} and then iterates over the `item#` values.
	 * Attempts to parse each `item#` value via `parseWikiText`, matching the `name` attribute. null values are ignored
	 *
	 * @param name only parses MediaWikiTemplates from `Switch infobox` if matches this value. (case insensitive)
	 * @param baseTemplate the {@link MediaWikiTemplate} representation of the `Switch infobox` to parse from
	 * @return List of all valid {@link MediaWikiTemplate}s matching `name` from `baseTemplate`s `item#` values
	 */
	static List<MediaWikiTemplate> parseSwitchInfoboxItems(final String name, final MediaWikiTemplate baseTemplate)
	{
		final List<MediaWikiTemplate> templates = new ArrayList<>();

		String value;
		int suffix = 1;
		while ((value = baseTemplate.getValue("item" + suffix)) != null)
		{
			final MediaWikiTemplate subTemplate = MediaWikiTemplate.parseWikitext(name, value);
			if (subTemplate != null)
			{
				templates.add(subTemplate);
			}

			suffix++;
		}

		return templates;
	}

	public static void dump(final Store store, final MediaWiki wiki, final File path) throws IOException
	{

		log.info("Dumping npc stats to {}", path);

		final NpcManager npcManager = new NpcManager(store);
		npcManager.load();

		final Map<Integer, NpcStats> npcStats = new HashMap<>();
		final Collection<NpcDefinition> definitions = npcManager.getNpcs();
		final Stream<NpcDefinition> npcDefinitionStream = definitions.parallelStream();

		// Ensure variant names match cache as wiki isn't always correct
		final Map<Integer, String> nameMap = new HashMap<>();
		for (NpcDefinition n : definitions)
		{
			if (n.getName().equalsIgnoreCase("NULL"))
			{
				continue;
			}

			final String name = Namer
				.removeTags(n.getName())
				.replace('\u00A0', ' ')
				.trim();

			if (name.isEmpty())
			{
				continue;
			}

			nameMap.put(n.getId(), name);
		}

		npcDefinitionStream.forEach(n ->
		{
			if (npcStats.containsKey(n.getId()))
			{
				return;
			}

			final String name = nameMap.get(n.getId());
			if (name == null)
			{
				return;
			}

			if (!isAttackableNpc(n))
			{
				return;
			}

			final String data = wiki.getSpecialLookupData("npc", n.getId(), 0);
			if (Strings.isNullOrEmpty(data))
			{
				return;
			}

			List<MediaWikiTemplate> bases = new ArrayList<>();

			final MediaWikiTemplate switchBase = MediaWikiTemplate.parseWikitext("Switch infobox", data);
			if (switchBase != null)
			{
				bases = parseSwitchInfoboxItems("Infobox Monster", switchBase);
			}
			else
			{
				final MediaWikiTemplate base = MediaWikiTemplate.parseWikitext("Infobox Monster", data);
				if (base == null)
				{
					return;
				}

				bases.add(base);
			}

			for (final MediaWikiTemplate base : bases)
			{
				int variantKey = 0;
				String wikiIdString = getWikiIdString(base, variantKey);
				if (wikiIdString == null)
				{
					// Try again as `id` will be null if there are variants and `id1` is the starting key
					variantKey++;
					wikiIdString = getWikiIdString(base, variantKey);
				}

				while (wikiIdString != null)
				{
					if (wikiIdString.isEmpty())
					{
						continue;
					}

					final Set<Integer> ids = Arrays.stream(wikiIdString.split(","))
						.map(s -> Integer.parseInt(s.trim()))
						.collect(Collectors.toSet());

					final NpcStats stats = buildNpcStats(base, variantKey);
					if (!stats.equals(DEFAULT))
					{
						stats.setName(name);
						for (final int curID : ids)
						{
							// Update variant name or fall back to current name
							final String curName = nameMap.get(curID);
							stats.setName(curName == null ? stats.getName() : curName);

							npcStats.put(curID, stats);
							log.debug("Dumped npc stats for npc id: {}", curID);
						}
					}

					variantKey++;
					wikiIdString = getWikiIdString(base, variantKey);
				}
			}
		});

		// Cast to TreeMap so sort output JSON in numerical order (npc id)
		final Map<Integer, NpcStats> sorted = new TreeMap<>(npcStats);

		try (FileWriter fw = new FileWriter(new File(path, "npc_stats.json")))
		{
			fw.write(App.GSON.toJson(sorted));
		}

//		try (FileWriter fw = new FileWriter(new File(out, "npc_stats.min.json")))
//		{
//			fw.write(new GsonBuilder().disableHtmlEscaping().create().toJson(sorted));
//		}

		log.info("Dumped {} npc stats", sorted.size());
	}

	private static boolean isAttackableNpc(final NpcDefinition n)
	{
		for (final String s : n.getOptions())
		{
			if ("attack".equalsIgnoreCase(s))
			{
				return true;
			}
		}

		return false;
	}

	private static String getKeySuffix(final int variantKey)
	{
		return variantKey > 0 ? String.valueOf(variantKey) : "";
	}

	private static String getWikiIdString(final MediaWikiTemplate template, final int variantKey)
	{
		return template.getValue("id" + getKeySuffix(variantKey));
	}

	private static NpcStats buildNpcStats(final MediaWikiTemplate template, int variantKey)
	{
		final NpcStats.NpcStatsBuilder stats = NpcStats.builder();

		stats.hitpoints(getInt("hitpoints", variantKey, template));
		if (stats.hitpoints == null)
		{
			stats.hitpoints(getInt("hitpoints1", variantKey, template));
		}
		stats.combatLevel(getInt("combat", variantKey, template));
		stats.slayerLevel(getInt("slaylvl", variantKey, template));
		stats.attackSpeed(getInt("attack speed", variantKey, template));

		stats.attackLevel(getInt("att", variantKey, template));
		stats.strengthLevel(getInt("str", variantKey, template));
		stats.defenceLevel(getInt("def", variantKey, template));
		stats.rangeLevel(getInt("range", variantKey, template));
		stats.magicLevel(getInt("mage", variantKey, template));

		stats.stab(getInt("astab", variantKey, template));
		stats.slash(getInt("aslash", variantKey, template));
		stats.crush(getInt("acrush", variantKey, template));
		stats.range(getInt("arange", variantKey, template));
		stats.magic(getInt("amagic", variantKey, template));

		stats.stabDef(getInt("dstab", variantKey, template));
		stats.slashDef(getInt("dslash", variantKey, template));
		stats.crushDef(getInt("dcrush", variantKey, template));
		stats.rangeDef(getInt("drange", variantKey, template));
		stats.magicDef(getInt("dmagic", variantKey, template));

		stats.bonusAttack(getInt("attbns", variantKey, template));
		stats.bonusStrength(getInt("strbns", variantKey, template));
		stats.bonusRangeStrength(getInt("rngbns", variantKey, template));
		stats.bonusMagicDamage(getInt("mbns", variantKey, template));

		final String keySuffix = getKeySuffix(variantKey);
		boolean pImmune = "immune".equalsIgnoreCase(template.getValue("immunepoison" + keySuffix));
		boolean vImmune = "immune".equalsIgnoreCase(template.getValue("immunevenom" + keySuffix));

		stats.poisonImmune(!pImmune ? null : true);
		stats.venomImmune(!vImmune ? null : true);

		final String weaknessValue = template.getValue("weakness");
		if (weaknessValue != null)
		{
			final String[] values = weaknessValue.split(",");
			for (String value : values)
			{
				value = value.toLowerCase();
				if (stats.dragon == null && (value.contains("dragonbane weapons")))
				{
					stats.dragon(true);
				}

				if (stats.demon == null && (value.contains("demonbane weapons") || value.contains("silverlight") || value.contains("arclight")))
				{
					stats.demon(true);
				}

				if (stats.undead == null && (value.contains("salve amulet") || value.contains("crumble undead")))
				{
					stats.undead(true);
				}
			}
		}

		return stats.build();
	}

	static Integer getInt(final String mainKey, final Integer variation, final MediaWikiTemplate template)
	{
		final String key = mainKey + getKeySuffix(variation);
		if (!template.containsKey(key))
		{
			if (variation >= 1)
			{
				// Use variation fallback via recursion
				return getInt(mainKey, variation - 1, template);
			}

			return null;
		}

		final String val = template.getValue(key);
		if (Strings.isNullOrEmpty(val))
		{
			return null;
		}

		try
		{
			// Remove everything after the first non-number character to account for any comments
			final String fixedVal = val.trim().replaceAll("\\D+.*", "");
			if (fixedVal.isEmpty())
			{
				return null;
			}

			int v = Integer.parseInt(fixedVal);
			return v != 0 ? v : null;
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
