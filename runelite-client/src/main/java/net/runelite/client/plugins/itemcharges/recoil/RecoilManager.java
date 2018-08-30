/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemcharges.recoil;

import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.Hitsplat;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.client.plugins.itemcharges.ItemWithVarCharge;

@Slf4j
public class RecoilManager
{
	private static final MaxCapacityMap<Integer, List<Integer>> PLAYER_HITSPLATS_PER_TICK = new MaxCapacityMap<>();
	private static final int MAX_TICKS_EARLIER = 10;
	private static final Set<Integer> SNAKELING_IDS = ImmutableSet.of(
		NpcID.SNAKELING, NpcID.SNAKELING_2127, NpcID.SNAKELING_2128, NpcID.SNAKELING_2129, NpcID.SNAKELING_2130,
		NpcID.SNAKELING_2131, NpcID.SNAKELING_2132, NpcID.SNAKELING_2046, NpcID.SNAKELING_2047);

	private final Client client;

	@Inject
	private RecoilManager(Client client)
	{
		this.client = client;
	}

	public void addPlayerHitsplat(Hitsplat hitsplat)
	{
		final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (itemContainer == null)
		{
			return;
		}

		final Item equippedRing = itemContainer.getItems()[EquipmentInventorySlot.RING.getSlotIdx()];
		if (equippedRing == null || equippedRing.getId() != ItemWithVarCharge.RING_OF_RECOIL.getItemId())
		{
			return;
		}

		if (hitsplat.getAmount() > 0 && hitsplat.getHitsplatType() == Hitsplat.HitsplatType.DAMAGE)
		{
			final int currentTick = client.getTickCount();
			log.debug("Player received hitsplat [{}] on tick [{}].", hitsplat.getAmount(), currentTick);
			PLAYER_HITSPLATS_PER_TICK.putIfAbsent(currentTick, new ArrayList<>());
			PLAYER_HITSPLATS_PER_TICK.get(currentTick).add(hitsplat.getAmount());
		}
	}

	public Optional<Integer> reduceChargesForOpponentHitsplat(Actor opponent, Hitsplat opponentHitsplat)
	{
		if (opponentHitsplat.getAmount() <= 0 || opponentHitsplat.getHitsplatType() != Hitsplat.HitsplatType.DAMAGE)
		{
			return Optional.empty();
		}

		final int currentTick = client.getTickCount();
		log.debug("Actor [{}] received hitsplat [{}] on tick [{}].", opponent.getName(), opponentHitsplat.getAmount(), currentTick);

		final Optional<Integer> consumedHitsplat = PLAYER_HITSPLATS_PER_TICK.entrySet().stream()
			.filter(pEntry -> pEntry.getKey() >= currentTick - MAX_TICKS_EARLIER)
			.flatMap(pEntry -> pEntry.getValue().stream())
			.filter(playerHit -> wasProbableCause(playerHit, opponentHitsplat.getAmount(), opponent))
			.findFirst();

		consumedHitsplat.ifPresent(this::removeConsumedHitsplat);

		return consumedHitsplat.map(playerHitsplat -> mapToChargeReduction(playerHitsplat, opponent));
	}

	private void removeConsumedHitsplat(int playerHitsplat)
	{
		for (List<Integer> hitsplatsPerTick : PLAYER_HITSPLATS_PER_TICK.values())
		{
			final Iterator<Integer> hitsplatIterator = hitsplatsPerTick.iterator();
			while (hitsplatIterator.hasNext())
			{
				final Integer nextHitsplat = hitsplatIterator.next();
				if (playerHitsplat == nextHitsplat)
				{
					hitsplatIterator.remove();
					return;
				}
			}
		}
	}

	private int mapToChargeReduction(Integer playerHit, Actor opponent)
	{
		if (isSnakeling(opponent))
		{
			return 1;
		}

		return calculateChargeReduction(playerHit);
	}

	private boolean wasProbableCause(Integer playerHit, int opponentHit, Actor opponent)
	{
		if (isSnakeling(opponent))
		{
			return true;
		}

		final int chargeReduction = calculateChargeReduction(playerHit);
		return opponentHit == chargeReduction;
	}

	/**
	 * Calculates the charges that would be reduced for the hitsplat received by the player. Charges used is 10% of
	 * damage received, rounded up to the nearest integer. Except when the recoil damage would be greater than the health
	 * of the opponent (such as Snakelings), in which the charges reduced is the remaining health of the opponent.
	 * Every 10th increment also changes the threshold. E.g.: 10 hitsplat = 2 charges, 20 hitsplat = 3 charges, ...
	 *
	 * @param hitsplat the hitsplat received by the player for which the charge reduction should be calculated
	 * @return the charges that should be reduced based on the received hitsplat
	 */
	private int calculateChargeReduction(int hitsplat)
	{
		return hitsplat == 0 ? 0 : (int) Math.ceil((hitsplat + 1) * 0.1);
	}

	private boolean isSnakeling(Actor actor)
	{
		if (!(actor instanceof NPC))
		{
			return false;
		}

		final int npcId = ((NPC) actor).getComposition().getId();
		return SNAKELING_IDS.contains(npcId);
	}

	/**
	 * Implementation of a {@link LinkedHashMap} which overrides the {@link #removeEldestEntry(Map.Entry)} method.
	 * It allows its eldest entries to be auto-removed after its max capacity has been reached.
	 *
	 * @param <K> the type of keys maintained by this map
	 * @param <V> the type of mapped values
	 */
	private static class MaxCapacityMap<K, V> extends LinkedHashMap<K, V>
	{
		private static final int MAX_ENTRIES = 5;

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
		{
			return size() > MAX_ENTRIES;
		}
	}
}
