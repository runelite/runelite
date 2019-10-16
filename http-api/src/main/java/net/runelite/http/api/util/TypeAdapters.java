/*
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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

package net.runelite.http.api.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.Instant;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.item.ItemStats;

/**
 * A class to put GSON TypeAdapters. These make just as fast the first time you
 * deserialize something as it would otherwise be after creating these itself.
 * Kinda funny actually, cause the first time probably matters the most, especially
 * for jsons that only get deserialized once.
 */
public class TypeAdapters
{
	public static final TypeAdapter<ItemStats> ITEMSTATS = new TypeAdapter<ItemStats>()
	{
		@Deprecated
		@Override
		public void write(JsonWriter out, ItemStats value)
		{
			throw new UnsupportedOperationException("Not supported");
		}

		@Override
		public ItemStats read(JsonReader in) throws IOException
		{
			in.beginObject();

			boolean quest = false;
			boolean equip = false;
			double weight = 0;
			ItemEquipmentStats stats = null;
			while (in.peek() != JsonToken.END_OBJECT)
			{
				switch (in.nextName())
				{
					case "quest":
						quest = in.nextBoolean();
						break;
					case "equipable":
						equip = in.nextBoolean();
						break;
					case "weight":
						weight = in.nextDouble();
						break;
					case "equipment":
						stats = EQUIPMENTSTATS.read(in);
						break;
				}
			}
			in.endObject();

			return new ItemStats(quest, equip, weight, stats);
		}
	};

	public static final TypeAdapter<ItemEquipmentStats> EQUIPMENTSTATS = new TypeAdapter<ItemEquipmentStats>()
	{
		@Deprecated
		@Override
		public void write(JsonWriter out, ItemEquipmentStats value)
		{
			throw new UnsupportedOperationException("Not supported");
		}

		@Override
		public ItemEquipmentStats read(JsonReader in) throws IOException
		{
			ItemEquipmentStats.Builder builder = ItemEquipmentStats.builder();

			in.beginObject();
			while (in.peek() != JsonToken.END_OBJECT)
			{
				String name = in.nextName();
				int val = in.nextInt();
				switch (name)
				{
					case "slot":
						builder.slot(val);
						break;
					case "astab":
						builder.astab(val);
						break;
					case "aslash":
						builder.aslash(val);
						break;
					case "acrush":
						builder.acrush(val);
						break;
					case "amagic":
						builder.amagic(val);
						break;
					case "arange":
						builder.arange(val);
						break;
					case "dstab":
						builder.dstab(val);
						break;
					case "dslash":
						builder.dslash(val);
						break;
					case "dcrush":
						builder.dcrush(val);
						break;
					case "dmagic":
						builder.dmagic(val);
						break;
					case "drange":
						builder.drange(val);
						break;
					case "str":
						builder.str(val);
						break;
					case "rstr":
						builder.rstr(val);
						break;
					case "mdmg":
						builder.mdmg(val);
						break;
					case "prayer":
						builder.prayer(val);
						break;
					case "aspeed":
						builder.aspeed(val);
						break;
				}
			}
			in.endObject();

			return builder.build();
		}
	};

	public static final TypeAdapter<ItemPrice> ITEMPRICE = new TypeAdapter<ItemPrice>()
	{
		@Override
		public void write(JsonWriter out, ItemPrice value)
		{
			throw new UnsupportedOperationException("Not supported");
		}

		@Override
		public ItemPrice read(JsonReader in) throws IOException
		{
			/*
			 * The ItemPrice json hosted by runelite is 'perfect'
			 * by that I mean every field always exists, even with value 0.
			 * This is why we can skip names and known-0 values
			 */
			ItemPrice ret = new ItemPrice();

			in.beginObject();

			// ID
			in.skipValue();
			ret.setId(in.nextInt());

			// Name
			in.skipValue();
			ret.setName(in.nextString());

			// Price
			in.skipValue();
			ret.setPrice(in.nextInt());

			// Time
			in.skipValue();
			in.beginObject();

			// Secs
			in.skipValue();
			ret.setTime(Instant.ofEpochSecond(in.nextLong()));

			// Nanos
			in.skipValue();
			in.skipValue();

			in.endObject();
			in.endObject();

			return ret;
		}
	};
}
