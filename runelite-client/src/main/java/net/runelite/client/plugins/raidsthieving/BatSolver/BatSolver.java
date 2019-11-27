/*
 * Copyright (c) 2018, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving.BatSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class BatSolver
{
	private Map<Integer, Integer> numberOfSolutionsWithPoison;
	private final SolutionSet solution;
	private final ThievingRoomType roomType;
	private final Set<Integer> grubsChests;

	public BatSolver(final ThievingRoomType roomType)
	{
		solution = new SolutionSet();
		grubsChests = new HashSet<>();
		this.roomType = roomType;
	}

	public void addEmptyChest(int chestId)
	{
		// When a new empty chest is found, add it to the current solution set
		solution.addEmptyChest(chestId);
		calculateChanceOfPoison();
	}

	public void addGrubsChest(int chestId)
	{
		// When a chest with grubs is found, keep track of it to invalidate solutions
		grubsChests.add(chestId);
		calculateChanceOfPoison();
	}

	public Set<Integer> matchSolutions()
	{
		Set<Integer> possibleEmptyChests = new TreeSet<>();

		List<Set<Integer>> sols = SolutionSet.SOLUTION_SETS.get(roomType).stream()
			.filter(this::matchSolution)
			.map(SolutionSet::getEmptyChests)
			.collect(Collectors.toList());

		for (Set<Integer> sol : sols)
		{
			possibleEmptyChests.addAll(sol);
		}

		return possibleEmptyChests;
	}

	private boolean matchSolution(SolutionSet testSolution)
	{
		for (Integer grubsChest : grubsChests)
		{
			if (testSolution.containsChest(grubsChest))
			{
				// If one of the chests is known to have grubs, it cannot be a solution
				return false;
			}
		}

		boolean matchesAll = true;
		boolean everMatched = false;
		for (int i : solution.getEmptyChests())
		{
			if (!testSolution.containsChest(i))
			{
				matchesAll = false;
			}
			else
			{
				everMatched = true;
			}
		}
		return matchesAll && everMatched;
	}

	private void calculateChanceOfPoison()
	{
		numberOfSolutionsWithPoison = new HashMap<>();
		for (SolutionSet sol : getPosssibleSolutions())
		{
			if (solution.getEmptyChests().size() == 0 || matchSolution(sol))
			{
				for (Integer i : sol.getEmptyChests())
				{
					if (numberOfSolutionsWithPoison.containsKey(i))
					{
						numberOfSolutionsWithPoison.put(i, numberOfSolutionsWithPoison.get(i) + 1);
					}
					else
					{
						numberOfSolutionsWithPoison.put(i, 1);
					}
				}
			}
		}
	}

	private List<SolutionSet> getPosssibleSolutions()
	{
		List<SolutionSet> possibleSolutions = new ArrayList<>();
		for (SolutionSet soln : SolutionSet.SOLUTION_SETS.get(roomType))
		{
			// Check if we've found grubs in one of the chests, invalidating it as an solution
			boolean foundMatch = false;
			for (int i : grubsChests)
			{
				if (soln.containsChest(i))
				{
					foundMatch = true;
				}
			}
			if (!foundMatch)
			{
				possibleSolutions.add(soln);
			}
		}
		return possibleSolutions;
	}

	public double relativeLikelihoodPoison(int chestId)
	{
		// Returns a double between 0 and 1 of how likely the chest has poison based on the number of possible solutions
		// Uses a Sigmoid like function to give good contrast in drawn opacity,
		// perhaps could be changed to something more accurate quantitavely.
		if (numberOfSolutionsWithPoison == null)
		{
			calculateChanceOfPoison();
		}
		if (numberOfSolutionsWithPoison == null)
		{
			return 1.0;
		}
		int mostFrequentPoison = 0;
		for (Map.Entry<Integer, Integer> entry : numberOfSolutionsWithPoison.entrySet())
		{
			if (entry.getValue() > mostFrequentPoison)
			{
				mostFrequentPoison = entry.getValue();
			}
		}
		int timesFound = 0;
		if (numberOfSolutionsWithPoison.containsKey(chestId))
		{
			timesFound = numberOfSolutionsWithPoison.get(chestId);
		}
		double chestChance = (double) (timesFound) / (double) (mostFrequentPoison);
		return 1. / (1 + Math.exp(5 - 10 * chestChance));
	}
}
