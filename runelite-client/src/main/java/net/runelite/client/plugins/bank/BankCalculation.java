/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.bank;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;
import net.runelite.client.game.ItemManager;

import static net.runelite.api.ItemID.*;
import static net.runelite.api.ItemID.ENSOULED_DRAGON_HEAD_13511;

@Slf4j
class BankCalculation
{
	private static final float HIGH_ALCHEMY_CONSTANT = 0.6f;
	private static final double ECTOFUNTUS_MULTIPLIER = 4;
	private static final double GILDED_ALTAR_MULTIPLIER = 3.5;
	private static final ImmutableList<Varbits> TAB_VARBITS = ImmutableList.of(
		Varbits.BANK_TAB_ONE_COUNT,
		Varbits.BANK_TAB_TWO_COUNT,
		Varbits.BANK_TAB_THREE_COUNT,
		Varbits.BANK_TAB_FOUR_COUNT,
		Varbits.BANK_TAB_FIVE_COUNT,
		Varbits.BANK_TAB_SIX_COUNT,
		Varbits.BANK_TAB_SEVEN_COUNT,
		Varbits.BANK_TAB_EIGHT_COUNT,
		Varbits.BANK_TAB_NINE_COUNT
	);

	private final BankConfig config;
	private final ItemManager itemManager;
	private final Client client;

	// Used to avoid extra calculation if the bank has not changed
	private int itemsHash;

	@Getter
	private long gePrice;

	@Getter
	private long haPrice;

	@Getter
	private long ensouledExperience;

	@Getter
	private long bonesExperience;

	private double multiplier;

	@Inject
	BankCalculation(ItemManager itemManager, BankConfig config, Client client)
	{
		this.itemManager = itemManager;
		this.config = config;
		this.client = client;
	}

	/**
	 * Calculate the bank based on the cache, price can be 0 if bank not active, or cache not set
	 */
	void calculate()
	{
		ItemContainer bankInventory = client.getItemContainer(InventoryID.BANK);

		if (bankInventory == null)
		{
			return;
		}

		Item[] items = bankInventory.getItems();
		int currentTab = client.getVar(Varbits.CURRENT_BANK_TAB);

		if (currentTab > 0)
		{
			int startIndex = 0;

			for (int i = currentTab - 1; i > 0; i--)
			{
				startIndex += client.getVar(TAB_VARBITS.get(i - 1));
			}

			int itemCount = client.getVar(TAB_VARBITS.get(currentTab - 1));
			items = Arrays.copyOfRange(items, startIndex, startIndex + itemCount);
		}

		if (items.length == 0 || !isBankDifferent(items))
		{
			return;
		}

		log.debug("Calculating new bank value...");

		gePrice = haPrice = 0;
		ensouledExperience = bonesExperience = 0;
		switch (config.prayerBoost()) {
			case ECTOFUNTUS:
				multiplier = ECTOFUNTUS_MULTIPLIER;
				break;
			case GILDED_ALTAR:
				multiplier = GILDED_ALTAR_MULTIPLIER;
				break;
			case NONE:
				multiplier = 1;
				break;
		}

		List<Integer> itemIds = new ArrayList<>();

		// Generate our lists (and do some quick price additions)
		for (Item item : items)
		{
			int quantity = item.getQuantity();

			if (item.getId() <= 0 || quantity == 0)
			{
				continue;
			}

			if (item.getId() == COINS_995)
			{
				gePrice += quantity;
				haPrice += quantity;
				continue;
			}

			if (item.getId() == PLATINUM_TOKEN)
			{
				gePrice += quantity * 1000L;
				haPrice += quantity * 1000L;
				continue;
			}

			final ItemComposition itemComposition = itemManager.getItemComposition(item.getId());

			if (config.showGE())
			{
				itemIds.add(item.getId());
			}

			if (config.showHA())
			{
				int price = itemComposition.getPrice();

				if (price > 0)
				{
					haPrice += (long) Math.round(price * HIGH_ALCHEMY_CONSTANT) *
						(long) quantity;
				}
			}
			calculateEnsouled(item);
			calculateBones(item);
		}

		// Now do the calculations
		if (config.showGE() && !itemIds.isEmpty())
		{
			for (Item item : items)
			{
				int itemId = item.getId();
				int quantity = item.getQuantity();

				if (itemId <= 0 || quantity == 0
					|| itemId == ItemID.COINS_995 || itemId == ItemID.PLATINUM_TOKEN)
				{
					continue;
				}

				gePrice += (long) itemManager.getItemPrice(itemId) * quantity;
			}
		}
	}

	private boolean isBankDifferent(Item[] items)
	{
		Map<Integer, Integer> mapCheck = new HashMap<>();

		for (Item item : items)
		{
			mapCheck.put(item.getId(), item.getQuantity());
		}

		int curHash = mapCheck.hashCode();

		if (curHash != itemsHash)
		{
			itemsHash = curHash;
			return true;
		}

		return false;
	}

	private void calculateEnsouled(Item item) {
		int quantity = item.getQuantity();
		if (item.getId() <= 0 || quantity == 0) {
			return;
		}
		switch (item.getId()) {
			case ENSOULED_GOBLIN_HEAD_13448:
				ensouledExperience += quantity * 130;
				break;
			case ENSOULED_MONKEY_HEAD_13451:
				ensouledExperience += quantity * 182;
				break;
			case ENSOULED_IMP_HEAD_13454:
				ensouledExperience += quantity * 286;
				break;
			case ENSOULED_MINOTAUR_HEAD_13457:
				ensouledExperience += quantity * 364;
				break;
			case ENSOULED_SCORPION_HEAD_13460:
				ensouledExperience += quantity * 454;
				break;
			case ENSOULED_BEAR_HEAD_13463:
				ensouledExperience += quantity * 480;
				break;
			case ENSOULED_UNICORN_HEAD_13466:
				ensouledExperience += quantity * 494;
				break;
			case ENSOULED_DOG_HEAD_13469:
				ensouledExperience += quantity * 520;
				break;
			case ENSOULED_CHAOS_DRUID_HEAD_13472:
				ensouledExperience += quantity * 584;
				break;
			case ENSOULED_GIANT_HEAD_13475:
				ensouledExperience += quantity * 650;
				break;
			case ENSOULED_OGRE_HEAD_13478:
				ensouledExperience += quantity * 716;
				break;
			case ENSOULED_ELF_HEAD_13481:
				ensouledExperience += quantity * 754;
				break;
			case ENSOULED_TROLL_HEAD_13484:
				ensouledExperience += quantity * 780;
				break;
			case ENSOULED_HORROR_HEAD_13487:
				ensouledExperience += quantity * 832;
				break;
			case ENSOULED_KALPHITE_HEAD_13490:
				ensouledExperience += quantity * 884;
				break;
			case ENSOULED_DAGANNOTH_HEAD_13493:
				ensouledExperience += quantity * 936;
				break;
			case ENSOULED_BLOODVELD_HEAD_13496:
				ensouledExperience += quantity * 1040;
				break;
			case ENSOULED_TZHAAR_HEAD_13499:
				ensouledExperience += quantity * 1104;
				break;
			case ENSOULED_DEMON_HEAD_13502:
				ensouledExperience += quantity * 1170;
				break;
			case ENSOULED_AVIANSIE_HEAD_13505:
				ensouledExperience += quantity * 1234;
				break;
			case ENSOULED_ABYSSAL_HEAD_13508:
				ensouledExperience += quantity * 1300;
				break;
			case ENSOULED_DRAGON_HEAD_13511:
				ensouledExperience += quantity * 1560;
				break;
		}
	}

	private void calculateBones(Item item) {
		int quantity = item.getQuantity();
		if (item.getId() <= 0 || quantity == 0) {
			return;
		}
		switch (item.getId()) {
			case 526:
				bonesExperience += quantity * 4.5 * multiplier;
				break;
			case BIG_BONES:
				bonesExperience += quantity * 15 * multiplier;
				break;
			case ZOGRE_BONES:
				bonesExperience += quantity * 22.5 * multiplier;
				break;
			case BABY_DRAGON_BONE_7841:
				bonesExperience += quantity * 30 * multiplier;
				break;
			case WYRM_BONES:
				bonesExperience += quantity * 50 * multiplier;
				break;
			case DRAGON_BONES:
				bonesExperience += quantity * 72 * multiplier;
				break;
			case WYVERN_BONES:
				bonesExperience += quantity * 72 * multiplier;
				break;
			case DRAKE_BONES:
				bonesExperience += quantity * 80 * multiplier;
				break;
			case LAVA_DRAGON_BONES:
				bonesExperience += quantity * 85 * multiplier;
				break;
			case HYDRA_BONES:
				bonesExperience += quantity * 110 * multiplier;
				break;
			case DAGANNOTH_BONES:
				bonesExperience += quantity * 125 * multiplier;
				break;
			case SUPERIOR_DRAGON_BONES:
				bonesExperience += quantity * 150 * multiplier;
				break;
		}
	}
}
