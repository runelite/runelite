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
import java.util.Iterator;
import java.util.Map;
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
import net.runelite.client.util.StackFormatter;
import net.runelite.client.callback.ClientThread;
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
	private ClientThread clientThread;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Getter
	private int favor = 0, coffer = 0, hardwoodButton = 0, cookedFishButton = 0, herbsButton = 0;

	@Getter
	private int miningWorkers = 0, herbsWorkers = 0, farmWorkers = 0;

	@Getter
	private int fishingWorkers = 0, woodWorkers = 0, hardwoodWorkers = 0;

	private int workers;



	private boolean throneOfMiscellania = false;
	private boolean royalTrouble = false;

	private KingdomCounter counter;

	@Getter
	private Kingdom max = new Kingdom(15);

	@Getter
	private Kingdom personal;

	@Override
	protected void shutDown() throws Exception
	{
		removeKingdomInfobox();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if  (client.getGameState() == GameState.LOGGED_IN)
		{
			getVarbits();
			processInfobox();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			getVarbits();
			processInfobox();
		}
	}

	private void getVarbits()
	{
		if (isInKingdom())
		{
			favor = client.getVar(Varbits.KINGDOM_FAVOR);
			coffer = client.getVar(Varbits.KINGDOM_COFFER);

			miningWorkers = client.getVar(Varbits.KINGDOM_WORKERS_MINING);
			herbsWorkers = client.getVar(Varbits.KINGDOM_WORKERS_HERBS);
			farmWorkers = client.getVar(Varbits.KINGDOM_WORKERS_FARM);
			fishingWorkers = client.getVar(Varbits.KINGDOM_WORKERS_FISHING);
			woodWorkers = client.getVar(Varbits.KINGDOM_WORKERS_WOOD);
			hardwoodWorkers = client.getVar(Varbits.KINGDOM_WORKERS_HARDWOOD);

			hardwoodButton = client.getVar(Varbits.KINGDOM_WORKERS_HARDWOOD_BUTTON);
			cookedFishButton = client.getVar(Varbits.KINGDOM_WORKERS_FISH_COOKED_BUTTON);
			herbsButton = client.getVar(Varbits.KINGDOM_WORKERS_HERBS_BUTTON);
		}
	}

	private void processInfobox()
	{
		if (client.getGameState() == GameState.LOGGED_IN && isInKingdom())
		{
			if (!throneOfMiscellania || !royalTrouble)
			{
				clientThread.invokeLater(() -> hasCompletedQuests());
			}
			else
			{
				createMaxKingdom();
				createPersonalKingdom();
				addKingdomInfobox();
			}
		}
		else
		{
			removeKingdomInfobox();
		}
	}

	private void createMaxKingdom()
	{
		max.getSalary(750000, getFavorPercent(127));
		getMaxWorkerDistribution();
		calculateRewards(max);
	}

	private void createPersonalKingdom()
	{
		personal = new Kingdom(workers);
		personal.getSalary(coffer, getFavorPercent(favor));

		log.debug("Number of workers in Kingdom " + personal.getTotalWorkers());
		log.debug("Effective salary: " + personal.getEffectiveSalary());
		log.debug("Individual worker salary: " + personal.getIndividualWorkerSalary());

		getPersonalWorkerDistribution();
		calculateRewards(personal);
	}

	private void getMaxWorkerDistribution()
	{
		max.resourceDistribution = new HashMap<>();
		for (ResourceType resource : ResourceType.values())
		{
			// Put 10 workers on each resource
			max.resourceDistribution.put(resource, 10);
		}
	}

	private void getPersonalWorkerDistribution()
	{
		ResourceType herbsOrFlax = herbsButton == 0 ? ResourceType.HERBS : ResourceType.FLAX;
		ResourceType cookedOrRaw = cookedFishButton == 0 ? ResourceType.RAW_FISH : ResourceType.COOKED_FISH;
		ResourceType hardwoodType = hardwoodButton == 0 ? ResourceType.HARDWOOD_MAHOGANY
			: hardwoodButton == 1 ? ResourceType.HARDWOOD_TEAK : ResourceType.HARDWOOD_BOTH;

		personal.resourceDistribution = new HashMap<>();
		personal.resourceDistribution.put(herbsOrFlax, herbsWorkers);
		personal.resourceDistribution.put(cookedOrRaw, fishingWorkers);
		personal.resourceDistribution.put(hardwoodType, hardwoodWorkers);
		personal.resourceDistribution.put(ResourceType.MINING, miningWorkers);
		personal.resourceDistribution.put(ResourceType.WOOD, woodWorkers);
		personal.resourceDistribution.put(ResourceType.FARM, farmWorkers);
	}

	private void calculateRewards(Kingdom kingdom)
	{
		int workersOnResource;
		int rewardQuantity;
		int rewardAmount;
		int resourceAmount;
		int totalAmount = 0;

		kingdom.rewardSummary = new HashMap<>();
		Iterator it = kingdom.resourceDistribution.entrySet().iterator();

		while (it.hasNext())
		{
			Map.Entry pairs = (Map.Entry) it.next();
			workersOnResource = (int) pairs.getValue();
			resourceAmount = 0;
			log.debug(workersOnResource + " workers on resource: " + pairs.getKey());

			for (Reward reward : Reward.values())
			{
				if (reward.getType() == pairs.getKey() && workersOnResource != 0)
				{
					// Calculate the quantity of the specific reward
					rewardQuantity = (int) (reward.getMaxQuantity() * workersOnResource
						* kingdom.getIndividualWorkerSalary()) / 50000;

					// Get the amount in gp from the quantity and cost
					rewardAmount = rewardQuantity * itemManager.getItemPrice(reward.getRewardId());

					// Add to total resource accumulator
					resourceAmount += rewardAmount;

					String summary = reward.getName() + " x " + rewardQuantity + " : "
						+ StackFormatter.formatNumber(rewardAmount);

					// Populate the rewards summary hashMap
					kingdom.getRewardSummary().put(reward.getName(), summary);

					log.debug(reward.getName() + " Workers: " + workersOnResource + ", Salary: "
						+ kingdom.getIndividualWorkerSalary()
						+ ", Quantity: " + rewardQuantity + ", GP: " + rewardAmount);
				}
			}
			totalAmount += resourceAmount;

			if (resourceAmount > kingdom.getPrimaryAmount())
			{
				kingdom.primaryAmount = resourceAmount;
				kingdom.primaryResource = (ResourceType) pairs.getKey();
			}
			else if (resourceAmount > kingdom.getSecondaryAmount() && pairs.getKey() != kingdom.primaryResource)
			{
				kingdom.secondaryAmount = resourceAmount;
				kingdom.secondaryResource = (ResourceType) pairs.getKey();
			}
		}
		kingdom.netProfit = totalAmount - kingdom.getBaseSalary();
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

	private void hasCompletedQuests()
	{
		if (Quest.ROYAL_TROUBLE.getState(client) == QuestState.FINISHED)
		{
			workers = 15;
			royalTrouble = true;
			throneOfMiscellania = true;
			createMaxKingdom();
			createPersonalKingdom();
			addKingdomInfobox();

			log.debug("Royal Trouble quest check");
		}
		else if (Quest.THRONE_OF_MISCELLANIA.getState(client) == QuestState.FINISHED)
		{
			workers = 10;
			throneOfMiscellania = true;
			createMaxKingdom();
			createPersonalKingdom();
			addKingdomInfobox();

			log.debug("Throne of Miscellania quest check");
		}
	}
	
	static int getFavorPercent(int favor)
	{
		return (favor * 100) / 127;
	}

}
