/*
 * Copyright (c) 2020 Adam <Adam@sigterm.info>
 * Copyright (c) 2020 MMagicala
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
package net.runelite.client.plugins.itemstats.potions;

import com.google.common.collect.ImmutableMap;
import java.time.Duration;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;

public enum PotionDuration
{
	ANTIPOISON(Duration.ofSeconds(90), ItemID.ANTIPOISON4, ItemID.ANTIPOISON3, ItemID.ANTIPOISON2, ItemID.ANTIPOISON1),
	SUPERANTIPOISON(Duration.ofMinutes(6), ItemID.SUPERANTIPOISON4, ItemID.SUPERANTIPOISON3, ItemID.SUPERANTIPOISON2, ItemID.SUPERANTIPOISON1),
	ANTIDOTE_P(Duration.ofMinutes(9), ItemID.ANTIDOTE4, ItemID.ANTIDOTE3, ItemID.ANTIDOTE2, ItemID.ANTIDOTE1),
	ANTIDOTE_PP(Duration.ofMinutes(12), ItemID.ANTIDOTE4_5952, ItemID.ANTIDOTE3_5954, ItemID.ANTIDOTE2_5956, ItemID.ANTIDOTE1_5958),
	ANTIVENOM(new PotionDurationRange[]{
		new PotionDurationRange("Anti-venom", Duration.ofSeconds(18), Duration.ofSeconds(36)),
		new PotionDurationRange("Anti-poison", Duration.ofMinutes(12))},
		ItemID.ANTIVENOM4, ItemID.ANTIVENOM3, ItemID.ANTIVENOM2, ItemID.ANTIVENOM1),
	ANTIVENOM_P(new PotionDurationRange[]{
		new PotionDurationRange("Anti-venom", Duration.ofMinutes(3)),
		new PotionDurationRange("Anti-poison", Duration.ofMinutes(15))},
		ItemID.ANTIVENOM4_12913, ItemID.ANTIVENOM3_12915, ItemID.ANTIVENOM2_12917, ItemID.ANTIVENOM1_12919),
	ANTIFIRE(Duration.ofMinutes(6), ItemID.ANTIFIRE_POTION4, ItemID.ANTIFIRE_POTION3, ItemID.ANTIFIRE_POTION2, ItemID.ANTIFIRE_POTION1),
	EXTENDED_ANTIFIRE(Duration.ofMinutes(12), ItemID.EXTENDED_ANTIFIRE4, ItemID.EXTENDED_ANTIFIRE3, ItemID.EXTENDED_ANTIFIRE2, ItemID.EXTENDED_ANTIFIRE1),
	SUPER_ANTIFIRE(Duration.ofMinutes(3), ItemID.SUPER_ANTIFIRE_POTION4, ItemID.SUPER_ANTIFIRE_POTION3, ItemID.SUPER_ANTIFIRE_POTION2, ItemID.SUPER_ANTIFIRE_POTION1),
	EXTENDED_SUPER_ANTIFIRE(Duration.ofMinutes(6), ItemID.EXTENDED_SUPER_ANTIFIRE4, ItemID.EXTENDED_SUPER_ANTIFIRE3, ItemID.EXTENDED_SUPER_ANTIFIRE2, ItemID.EXTENDED_SUPER_ANTIFIRE1),
	ANTIPOISON_MIX(Duration.ofSeconds(90), ItemID.ANTIPOISON_MIX1, ItemID.ANTIPOISON_MIX2),
	ANTIPOISON_SUPERMIX(Duration.ofMinutes(6), ItemID.ANTIPOISON_SUPERMIX1, ItemID.ANTIPOISON_SUPERMIX2),
	ANTIDOTE_PLUS_MIX(Duration.ofMinutes(9), ItemID.ANTIDOTE_MIX1, ItemID.ANTIDOTE_MIX2),
	EXTENDED_ANTIFIRE_MIX(Duration.ofMinutes(12), ItemID.EXTENDED_ANTIFIRE_MIX1, ItemID.EXTENDED_ANTIFIRE_MIX2),
	SUPER_ANTIFIRE_MIX(Duration.ofMinutes(3), ItemID.SUPER_ANTIFIRE_MIX1, ItemID.SUPER_ANTIFIRE_MIX2),
	EXTENDED_SUPER_ANTIFIRE_MIX(Duration.ofMinutes(6), ItemID.EXTENDED_SUPER_ANTIFIRE_MIX1, ItemID.EXTENDED_SUPER_ANTIFIRE_MIX2);

	@Getter
	private final PotionDurationRange[] durationRanges;
	private final int[] itemIds;

	PotionDuration(Duration duration, int... itemIds)
	{
		PotionDurationRange[] ranges = new PotionDurationRange[1];
		// Only need the duration, not the potion name or a range
		ranges[0] = new PotionDurationRange("", duration);
		this.durationRanges = ranges;
		this.itemIds = itemIds;
	}

	PotionDuration(PotionDurationRange[] durationRanges, int... itemIds)
	{
		this.durationRanges = durationRanges;
		this.itemIds = itemIds;
	}

	private static final Map<Integer, PotionDuration> potions;

	static
	{
		ImmutableMap.Builder<Integer, PotionDuration> builder = new ImmutableMap.Builder<>();

		for (PotionDuration potion : values())
		{
			for (int id : potion.itemIds)
			{
				builder.put(id, potion);
			}
		}

		potions = builder.build();
	}

	public static PotionDuration get(int id)
	{
		return potions.get(id);
	}

	@Getter
	public static class PotionDurationRange
	{
		private final String potionName;
		private final Duration lowestDuration, highestDuration;

		public PotionDurationRange(String potionName, Duration duration)
		{
			this.potionName = potionName;
			this.lowestDuration = this.highestDuration = duration;
		}

		public PotionDurationRange(String potionName, Duration lowestDuration, Duration highestDuration)
		{
			this.potionName = potionName;
			this.lowestDuration = lowestDuration;
			this.highestDuration = highestDuration;
		}
	}

}
