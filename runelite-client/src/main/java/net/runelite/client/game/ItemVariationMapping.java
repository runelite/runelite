/*
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.game;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**
 * Converts variation items to it's base item counterparts
 */
public class ItemVariationMapping
{
	private static final Map<Integer, Integer> MAPPINGS;
	private static final Multimap<Integer, Integer> INVERTED_MAPPINGS;

	static
	{
		final Gson gson = new Gson();
		final TypeToken<Map<String, Collection<Integer>>> typeToken = new TypeToken<Map<String, Collection<Integer>>>()
		{
		};

		final InputStream geLimitData = ItemVariationMapping.class.getResourceAsStream("/item_variations.json");
		final Map<String, Collection<Integer>> itemVariations = gson.fromJson(new InputStreamReader(geLimitData, StandardCharsets.UTF_8), typeToken.getType());

		ImmutableMap.Builder<Integer, Integer> builder = new ImmutableMap.Builder<>();
		ImmutableMultimap.Builder<Integer, Integer> invertedBuilder = new ImmutableMultimap.Builder<>();
		for (Collection<Integer> value : itemVariations.values())
		{
			final Iterator<Integer> iterator = value.iterator();
			final int base = iterator.next();

			while (iterator.hasNext())
			{
				final int id = iterator.next();
				builder.put(id, base);
				invertedBuilder.put(base, id);
			}

			invertedBuilder.put(base, base);
		}

		INVERTED_MAPPINGS = invertedBuilder.build();
		MAPPINGS = builder.build();
	}

	/**
	 * Get base item id for provided variation item id.
	 *
	 * @param itemId the item id
	 * @return the base item id
	 */
	public static int map(int itemId)
	{
		return MAPPINGS.getOrDefault(itemId, itemId);
	}

	/**
	 * Get item ids for provided variation item id.
	 *
	 * @param itemId the item id
	 * @return the item ids
	 */
	public static Collection<Integer> getVariations(int itemId)
	{
		return INVERTED_MAPPINGS.asMap().getOrDefault(itemId, Collections.singletonList(itemId));
	}
}
