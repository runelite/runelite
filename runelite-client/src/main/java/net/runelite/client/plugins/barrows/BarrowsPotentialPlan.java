/*
 * Copyright (c) 2026, RuneLite
 * All rights reserved.
 */
package net.runelite.client.plugins.barrows;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

final class BarrowsPotentialPlan
{
	private static final int MAX_REWARD_POTENTIAL = 1012;
	private static final int MAX_PLANS = 5;
	private static final PotentialMonster[] MONSTERS = {
		new PotentialMonster("Bloodworm", 52, true),
		new PotentialMonster("Crypt rat", 43, true),
		new PotentialMonster("Crypt spider", 56, true),
		new PotentialMonster("Giant crypt rat", 76, true),
		new PotentialMonster("Giant crypt spider", 79, true),
		new PotentialMonster("Skeleton", 77, true),
		new PotentialMonster("Ahrim the Blighted", 98, false, BarrowsBrothers.AHRIM),
		new PotentialMonster("Dharok the Wretched", 115, false, BarrowsBrothers.DHAROK),
		new PotentialMonster("Guthan the Infested", 115, false, BarrowsBrothers.GUTHAN),
		new PotentialMonster("Karil the Tainted", 98, false, BarrowsBrothers.KARIL),
		new PotentialMonster("Torag the Corrupted", 115, false, BarrowsBrothers.TORAG),
		new PotentialMonster("Verac the Defiled", 115, false, BarrowsBrothers.VERAC)
	};

	private BarrowsPotentialPlan()
	{
	}

	static int getPotentialGoalPoints(int goalPercent)
	{
		return goalPercent * MAX_REWARD_POTENTIAL / 100;
	}

	static int getBrotherCombatLevel(BarrowsBrothers brother)
	{
		for (PotentialMonster monster : MONSTERS)
		{
			if (monster.brother == brother)
			{
				return monster.potential;
			}
		}
		throw new IllegalArgumentException("Unknown Barrows brother: " + brother);
	}

	static List<String> findClosestPlans(int currentPotential, Set<BarrowsBrothers> slainBrothers, int goalPercent)
	{
		int maxPotentialAtGoal = getPotentialGoalPoints(goalPercent);
		KillPlan requiredBrothers = new KillPlan(MONSTERS.length);
		int potentialAfterRequiredBrothers = currentPotential;
		for (int monsterIndex = 0; monsterIndex < MONSTERS.length; monsterIndex++)
		{
			PotentialMonster monster = MONSTERS[monsterIndex];
			if (monster.brother != null && !slainBrothers.contains(monster.brother))
			{
				potentialAfterRequiredBrothers += monster.potential + 2;
				requiredBrothers = requiredBrothers.add(monsterIndex);
			}
		}

		if (potentialAfterRequiredBrothers >= maxPotentialAtGoal)
		{
			if (requiredBrothers.killCount() > 0)
			{
				return Collections.singletonList(requiredBrothers.description()
					+ " (required; no optional kills recommended).");
			}
			return Collections.singletonList(potentialAfterRequiredBrothers == maxPotentialAtGoal
				? "Already at the closest potential below " + goalPercent + "%."
				: "Already above " + goalPercent + "%; no further kills recommended.");
		}

		int maxAdditionalPotential = maxPotentialAtGoal - potentialAfterRequiredBrothers;
		@SuppressWarnings("unchecked")
		List<KillPlan>[] plansByPotential = (List<KillPlan>[]) new List<?>[maxAdditionalPotential + 1];
		plansByPotential[0] = new ArrayList<>();
		plansByPotential[0].add(requiredBrothers);

		for (int monsterIndex = 0; monsterIndex < MONSTERS.length; monsterIndex++)
		{
			PotentialMonster monster = MONSTERS[monsterIndex];
			if (!monster.repeatable)
			{
				continue;
			}

			int points = monster.potential;
			if (points > maxAdditionalPotential)
			{
				continue;
			}

			int start = monster.repeatable ? 0 : maxAdditionalPotential - points;
			int end = monster.repeatable ? maxAdditionalPotential - points : 0;
			int step = monster.repeatable ? 1 : -1;
			for (int potential = start; monster.repeatable ? potential <= end : potential >= end; potential += step)
			{
				List<KillPlan> plans = plansByPotential[potential];
				if (plans == null)
				{
					continue;
				}

				List<KillPlan> nextPlans = plansByPotential[potential + points];
				if (nextPlans == null)
				{
					nextPlans = new ArrayList<>();
					plansByPotential[potential + points] = nextPlans;
				}

				for (KillPlan plan : plans)
				{
					insertBestPlan(nextPlans, plan.add(monsterIndex));
				}
			}
		}

		int bestPotential = maxAdditionalPotential;
		while (bestPotential > 0 && plansByPotential[bestPotential] == null)
		{
			bestPotential--;
		}

		List<KillPlan> bestPlans = plansByPotential[bestPotential];
		if (bestPlans == null || bestPlans.isEmpty())
		{
			return Collections.singletonList("No available NPC kills move closer to " + goalPercent + "%.");
		}

		List<String> descriptions = new ArrayList<>();
		for (KillPlan plan : bestPlans)
		{
			descriptions.add(plan.description());
		}
		return descriptions;
	}

	private static void insertBestPlan(List<KillPlan> plans, KillPlan candidate)
	{
		for (KillPlan plan : plans)
		{
			if (plan.sameCounts(candidate))
			{
				return;
			}
		}

		plans.add(candidate);
		plans.sort(Comparator.comparingInt(KillPlan::killCount).thenComparing(KillPlan::description));
		if (plans.size() > MAX_PLANS)
		{
			plans.remove(plans.size() - 1);
		}
	}

	private static final class PotentialMonster
	{
		private final String name;
		private final int potential;
		private final boolean repeatable;
		private final BarrowsBrothers brother;

		private PotentialMonster(String name, int potential, boolean repeatable)
		{
			this(name, potential, repeatable, null);
		}

		private PotentialMonster(String name, int potential, boolean repeatable, BarrowsBrothers brother)
		{
			this.name = name;
			this.potential = potential;
			this.repeatable = repeatable;
			this.brother = brother;
		}
	}

	private static final class KillPlan
	{
		private final int[] counts;

		private KillPlan(int monsterCount)
		{
			this.counts = new int[monsterCount];
		}

		private KillPlan(int[] counts)
		{
			this.counts = counts;
		}

		private KillPlan add(int monsterIndex)
		{
			int[] updatedCounts = counts.clone();
			updatedCounts[monsterIndex]++;
			return new KillPlan(updatedCounts);
		}

		private int killCount()
		{
			int total = 0;
			for (int count : counts)
			{
				total += count;
			}
			return total;
		}

		private boolean sameCounts(KillPlan other)
		{
			return Arrays.equals(counts, other.counts);
		}

		private String description()
		{
			StringBuilder description = new StringBuilder();
			for (int pass = 0; pass < 2; pass++)
			{
				boolean brothers = pass == 0;
				for (int i = 0; i < counts.length; i++)
				{
					if (counts[i] == 0 || (MONSTERS[i].brother != null) != brothers)
					{
						continue;
					}
					if (description.length() > 0)
					{
						description.append(", ");
					}
					description.append(counts[i]).append("x ").append(MONSTERS[i].name);
				}
			}
			return description.toString();
		}
	}
}
