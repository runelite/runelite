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
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Converts variation items to it's base item counterparts
 */
@Slf4j
public class ItemVariationMapping
{
	private static Map<Integer, Integer> MAPPINGS;

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

	static void load() throws IOException
	{
		try (JsonReader reader = new JsonReader(new InputStreamReader(ItemVariationMapping.class.getResourceAsStream("/item_variations.min.json"), StandardCharsets.UTF_8)))
		{
			ImmutableMap.Builder<Integer, Integer> builder = ImmutableMap.builderWithExpectedSize(5039);
			reader.beginObject();

			while (reader.hasNext())
			{
				// Names are useless
				reader.skipValue();
				reader.beginArray();

				int base = reader.nextInt();
				while (reader.hasNext())
				{
					builder.put(
						reader.nextInt(),
						base
					);
				}

				reader.endArray();
			}

			reader.endObject();
			MAPPINGS = builder.build();
		}
	}

	static int getSize()
	{
		return MAPPINGS.size();
	}
}
