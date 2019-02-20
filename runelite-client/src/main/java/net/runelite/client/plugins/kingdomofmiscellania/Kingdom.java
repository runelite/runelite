/*
 * Copyright (c) 2019, RyBo <https://github.com/RyBo>
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

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class Kingdom
{
	private int numberOfWorkers;

	// How much money is withdrawn from the coffer for that day
	private int kingdomFunds;
	// How much of that money is used towards gathering resources
	@Getter
	private int effectiveFunds;

	// Highest is 5000 per worker minus the effectiveFunds / totalWorkers
	private int workerSalary;

	int grossProfit;

	boolean isPersonalKingdom;

	HashMap <ResourceType, Integer> resourceDistribution;

	HashMap <ResourceType, Integer> resourceProfit;

	HashMap <Reward, Integer> rewardQuantity;

	HashMap <Reward, Integer> rewardProfit;

	Kingdom(int workers, boolean personal)
	{
		numberOfWorkers = workers;
		isPersonalKingdom = personal;
		effectiveFunds = 75000;
		workerSalary = 5000;

		resourceDistribution = new HashMap<>();
		for (ResourceType resource : ResourceType.values())
		{
			// Put 10 workers on each resource
			resourceDistribution.put(resource, 10);
		}
		calculateRewardQuantities();
	}

	void calculateKingdomFunds(int coffer, int favor)
	{

		if (numberOfWorkers == 10)
		{
			kingdomFunds = coffer >= 500000 ? 50000 : coffer / 10;
		}
		else
		{
			kingdomFunds = coffer >= 750000 ? 75000 : coffer / 10;
		}

		// take favour percentage into account
		effectiveFunds = (int) (kingdomFunds * ((double) favor / 100));
		workerSalary = effectiveFunds / numberOfWorkers;
	}

	void calculateRewardQuantities()
	{
		if (workerSalary == 0)
		{
			return;
		}

		rewardQuantity = new HashMap<>();
		for (Map.Entry<ResourceType, Integer> entry : resourceDistribution.entrySet())
		{
			int workersOnResource = entry.getValue();
			for (Reward reward : Reward.values())
			{
				if (reward.getType() == entry.getKey() && workersOnResource != 0)
				{
					// Calculate quantity of the specific reward
					int quantity = (int) (reward.getMaxQuantity() * workersOnResource * workerSalary) / 50000;
					rewardQuantity.put(reward, quantity);
				}
			}
		}
	}

	void getResourceProfit()
	{
		grossProfit = 0;
		resourceProfit = new HashMap<>();

		for (Map.Entry<Reward, Integer> entry : rewardProfit.entrySet())
		{
			Reward reward = entry.getKey();
			int profit = entry.getValue();
			ResourceType type = reward.getType();
			resourceProfit.put(type, resourceProfit.get(type) == null ? profit : resourceProfit.get(type) + profit);
			grossProfit += profit;
		}
	}
}
