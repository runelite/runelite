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
import net.runelite.api.gameval.ItemID;

public enum PotionDuration
{
	ANTIPOISON(Duration.ofSeconds(90), ItemID._4DOSEANTIPOISON, ItemID._3DOSEANTIPOISON, ItemID._2DOSEANTIPOISON, ItemID._1DOSEANTIPOISON),
	SUPERANTIPOISON(Duration.ofMinutes(6), ItemID._4DOSE2ANTIPOISON, ItemID._3DOSE2ANTIPOISON, ItemID._2DOSE2ANTIPOISON, ItemID._1DOSE2ANTIPOISON),
	ANTIDOTE_P(Duration.ofMinutes(9), ItemID.ANTIDOTE_4, ItemID.ANTIDOTE_3, ItemID.ANTIDOTE_2, ItemID.ANTIDOTE_1),
	ANTIDOTE_PP(Duration.ofMinutes(12), ItemID.ANTIDOTE__4, ItemID.ANTIDOTE__3, ItemID.ANTIDOTE__2, ItemID.ANTIDOTE__1),
	ANTIVENOM(new PotionDurationRange[]{
		new PotionDurationRange("Anti-venom", Duration.ofSeconds(18), Duration.ofSeconds(36)),
		new PotionDurationRange("Anti-poison", Duration.ofMinutes(12))},
		ItemID.ANTIVENOM4, ItemID.ANTIVENOM3, ItemID.ANTIVENOM2, ItemID.ANTIVENOM1),
	ANTIVENOM_P(new PotionDurationRange[]{
		new PotionDurationRange("Anti-venom", Duration.ofMinutes(3)),
		new PotionDurationRange("Anti-poison", Duration.ofMinutes(15))},
		ItemID.ANTIVENOM_4, ItemID.ANTIVENOM_3, ItemID.ANTIVENOM_2, ItemID.ANTIVENOM_1),
	EXTENDED_ANTIVENOM_P(new PotionDurationRange[]{
		new PotionDurationRange("Anti-venom", Duration.ofMinutes(6)),
		new PotionDurationRange("Anti-poison", Duration.ofMinutes(17))},
		ItemID.EXTENDED_ANTIVENOM_4, ItemID.EXTENDED_ANTIVENOM_3, ItemID.EXTENDED_ANTIVENOM_2, ItemID.EXTENDED_ANTIVENOM_1),
	ANTIFIRE(Duration.ofMinutes(6), ItemID._4DOSE1ANTIDRAGON, ItemID._3DOSE1ANTIDRAGON, ItemID._2DOSE1ANTIDRAGON, ItemID._1DOSE1ANTIDRAGON),
	EXTENDED_ANTIFIRE(Duration.ofMinutes(12), ItemID._4DOSE2ANTIDRAGON, ItemID._3DOSE2ANTIDRAGON, ItemID._2DOSE2ANTIDRAGON, ItemID._1DOSE2ANTIDRAGON),
	SUPER_ANTIFIRE(Duration.ofMinutes(3), ItemID._4DOSE3ANTIDRAGON, ItemID._3DOSE3ANTIDRAGON, ItemID._2DOSE3ANTIDRAGON, ItemID._1DOSE3ANTIDRAGON),
	EXTENDED_SUPER_ANTIFIRE(Duration.ofMinutes(6), ItemID._4DOSE4ANTIDRAGON, ItemID._3DOSE4ANTIDRAGON, ItemID._2DOSE4ANTIDRAGON, ItemID._1DOSE4ANTIDRAGON),
	ANTIPOISON_MIX(Duration.ofSeconds(90), ItemID.BRUTAL_1DOSEANTIPOISON, ItemID.BRUTAL_2DOSEANTIPOISON),
	ANTIPOISON_SUPERMIX(Duration.ofMinutes(6), ItemID.BRUTAL_1DOSE2ANTIPOISON, ItemID.BRUTAL_2DOSE2ANTIPOISON),
	ANTIDOTE_PLUS_MIX(Duration.ofMinutes(9), ItemID.BRUTAL_ANTIDOTE_1, ItemID.BRUTAL_ANTIDOTE_2),
	EXTENDED_ANTIFIRE_MIX(Duration.ofMinutes(12), ItemID.BRUTAL_1DOSE2ANTIDRAGON, ItemID.BRUTAL_2DOSE2ANTIDRAGON),
	SUPER_ANTIFIRE_MIX(Duration.ofMinutes(3), ItemID.BRUTAL_1DOSE3ANTIDRAGON, ItemID.BRUTAL_2DOSE3ANTIDRAGON),
	EXTENDED_SUPER_ANTIFIRE_MIX(Duration.ofMinutes(6), ItemID.BRUTAL_1DOSE4ANTIDRAGON, ItemID.BRUTAL_2DOSE4ANTIDRAGON);

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
