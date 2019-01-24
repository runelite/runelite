/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.kingdomofmiscellania;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import static net.runelite.api.ItemID.TEAK_CHEST;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;


@PluginDescriptor(
	name = "Kingdom of Miscellania",
	description = "Show amount of favor when inside Miscellania and calculate most profitable rewards",
	tags = {"favor", "favour", "managing", "overlay"},
	enabledByDefault = false
)

@Slf4j
public class KingdomPlugin extends Plugin
{
	private static final ImmutableSet<Integer> KINGDOM_REGION = ImmutableSet.of(10044, 10300);

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Getter
	private int favor = 0, coffer = 0, primaryProfit = 0, secondaryProfit = 0, estimatedNetProfit = 0;

	@Getter
	private int workers = 10;

	@Getter
	private HashMap <ResourceType, Integer> workerDistribution = new HashMap();

	@Getter
	private String primaryResource = "None", secondaryResource = "None";

	private KingdomCounter counter;

	@Override
	protected void shutDown() throws Exception
	{
		removeKingdomInfobox();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		favor = client.getVar(Varbits.KINGDOM_FAVOR);
		coffer = client.getVar(Varbits.KINGDOM_COFFER);
		processInfobox();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			processInfobox();
		}
	}

	private void processInfobox()
	{
		if (client.getGameState() == GameState.LOGGED_IN && hasCompletedQuests() && isInKingdom())
		{
			addKingdomInfobox();
			calculateMaxRewards();
			//getWorkerDistribution();
		}
		else
		{
			removeKingdomInfobox();
		}

	}

	private void getWorkerDistribution()
	{
		int hardwoodButton = client.getVar(Varbits.KINGDOM_WORKERS_HARDWOOD_BUTTON);
		int cookedFishButton = client.getVar(Varbits.KINGDOM_WORKERS_FISH_COOKED_BUTTON);
		int herbsButton = client.getVar(Varbits.KINGDOM_WORKERS_HERBS_BUTTON);

		ResourceType herbsOrFlax = herbsButton == 0 ? ResourceType.HERBS : ResourceType.FLAX;
		ResourceType cookedOrRaw = cookedFishButton == 0 ? ResourceType.RAW_FISH : ResourceType.COOKED_FISH;
		ResourceType hardwoodType = hardwoodButton == 0 ? ResourceType.HARDWOOD_MAHOGANY
			: hardwoodButton == 1 ? ResourceType.HARDWOOD_TEAK : ResourceType.HARDWOOD_BOTH;

		// Clear to ignore inactive resources
		workerDistribution.clear();
		workerDistribution.put(herbsOrFlax, client.getVar(Varbits.KINGDOM_WORKERS_HERBS));
		workerDistribution.put(cookedOrRaw, client.getVar(Varbits.KINGDOM_WORKERS_FISHING));
		workerDistribution.put(hardwoodType, client.getVar(Varbits.KINGDOM_WORKERS_HARDWOOD));
		workerDistribution.put(ResourceType.MINING, client.getVar(Varbits.KINGDOM_WORKERS_MINING));
		workerDistribution.put(ResourceType.WOOD, client.getVar(Varbits.KINGDOM_WORKERS_WOOD));
		workerDistribution.put(ResourceType.FARM, client.getVar(Varbits.KINGDOM_WORKERS_FARM));

		calculateCurrentRewards();
	}

	private void calculateCurrentRewards()
	{
		int workersPerResource, amount = 0;
		double salary, rewardQuantity;

		if (workers == 10)
		{
			salary = coffer >= 500000 ? 50000 : (double) coffer / 10;
			log.debug("salary: " + salary);
		}
		else
		{
			salary = coffer >= 750000 ? 75000 : (double) coffer / 10;
			log.debug("salary: " + salary);
		}

		// Salary after favor cut
		log.debug("salary: " + salary);
		salary = (double) getFavorPercent(favor) / 100 * salary;
		// Salary per employee
		salary = salary / workers;
		log.debug("salary: " + salary);

		Iterator it = workerDistribution.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry pairs = (Map.Entry) it.next();
			log.debug(pairs.getKey() + " = " + pairs.getValue());

			workersPerResource = (int) pairs.getValue();
			log.debug("workers: " + workersPerResource);
			for (Reward reward : Reward.values())
			{
				if (reward.getType() == pairs.getKey())
				{
					// number of workers multiplied by their salary divided by the cost of the rewards
					rewardQuantity = workersPerResource * salary / reward.getCost();
					log.debug("Reward: " + reward.getName() + ", Quantity: " + rewardQuantity);
					amount += rewardQuantity * itemManager.getItemPrice(reward.getRewardId());
				}
			}
		}

	}

	private void calculateMaxRewards()
	{
		ResourceType type = ResourceType.FARM;
		double amount = 0;
		for (Reward reward : Reward.values())
		{
			if (reward.getType() != type)
			{
				// reset amount
				amount = 0;
				type = reward.getType();
			}
			amount += reward.getQuantity() * itemManager.getItemPrice(reward.getRewardId());
			log.debug("Reward: " + reward.getName() + ", Quantity: " + reward.getQuantity() + ", Amount: " + amount);
			log.debug("RID: " + reward.getRewardId() + ", Item Price: " + itemManager.getItemPrice(reward.getRewardId()));
			if (amount > primaryProfit)
			{
				primaryProfit = (int) Math.round(amount);
				primaryResource = type.getType();
			}
			else if (amount > secondaryProfit && type.getType() != primaryResource)
			{
				secondaryProfit = (int) Math.round(amount);
				secondaryResource = type.getType();
			}
		}

		// 10 workers
		primaryProfit -= 50000;
		// 5 workers
		secondaryProfit = secondaryProfit / 2 - 25000;
		estimatedNetProfit = primaryProfit + secondaryProfit;
	}

	private void addKingdomInfobox()
	{
		if (counter == null)
		{
			counter = new KingdomCounter(itemManager.getImage(TEAK_CHEST), this);
			infoBoxManager.addInfoBox(counter);
			log.debug("Added Kingdom Infobox");
		}
	}

	private void removeKingdomInfobox()
	{
		if (counter != null)
		{
			infoBoxManager.removeInfoBox(counter);
			counter = null;
			log.debug("Removed Kingdom Infobox");
		}
	}

	private boolean isInKingdom()
	{
		return client.getLocalPlayer() != null
				&& KINGDOM_REGION.contains(client.getLocalPlayer().getWorldLocation().getRegionID());
	}

	private boolean hasCompletedQuests()
	{
		if (Quest.ROYAL_TROUBLE.getState(client) == QuestState.FINISHED)
		{
			workers = 15;
		}

		log.debug("Number of available workers: " + workers);
		return Quest.THRONE_OF_MISCELLANIA.getState(client) == QuestState.FINISHED;
	}

	static int getFavorPercent(int favor)
	{
		return (favor * 100) / 127;
	}

}
