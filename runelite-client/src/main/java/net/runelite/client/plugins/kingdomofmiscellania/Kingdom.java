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
import lombok.Getter;

public class Kingdom
{
	@Getter
	private int totalWorkers;

	// How much money is withdrawn from the coffer for that day
	@Getter
	private int baseSalary;
	// How much of that money is used towards gathering resources
	@Getter
	private int effectiveSalary;

	// Highest is 5000 per worker minus the effectiveSalary / totalWorkers
	@Getter
	private int individualWorkerSalary;

	@Getter
	int netProfit;

	@Getter
	ResourceType primaryResource;

	@Getter
	ResourceType secondaryResource;

	@Getter
	int primaryAmount = 0;

	@Getter
	int secondaryAmount = 0;

	@Getter
	HashMap <ResourceType, Integer> resourceDistribution;

	@Getter
	HashMap <String, Integer> rewardSummary;


	Kingdom(int workers)
	{
		totalWorkers = workers;
	}

	void getSalary(int coffer, int favor)
	{
		if (totalWorkers == 10)
		{
			baseSalary = coffer >= 500000 ? 50000 : coffer / 10;
		}
		else
		{
			baseSalary = coffer >= 750000 ? 75000 : coffer / 10;
		}

		// take favour percentage into account
		effectiveSalary = (int) (baseSalary * ((double) favor / 100));
		individualWorkerSalary = effectiveSalary / totalWorkers;
	}
}
