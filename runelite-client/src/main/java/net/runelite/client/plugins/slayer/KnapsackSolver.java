package net.runelite.client.plugins.slayer;

import java.util.ArrayList;
import java.util.List;

public class KnapsackSolver
{

	private List<Integer> reconstructItemsInSack(int [] [] sackMatrix, List<Integer> items, int i, int w)
	{
		if (i == 0)
		{
			return new ArrayList<>();
		}
		if (sackMatrix[i][w] > sackMatrix[i - 1][w])
		{
			List<Integer> list = reconstructItemsInSack(sackMatrix, items,
					i - 1, w - items.get(i - 1));
			list.add(items.get(i - 1));
			return list;
		}
		else
		{
			return reconstructItemsInSack(sackMatrix, items, i - 1, w);
		}
	}

	public int howMuchFitsInSack(List<Integer> items, int maxWeight)
	{
		int itemCount = items.size();

		int[] [] sackMatrix = new int[itemCount + 1] [maxWeight + 1];
		for (int i = 1; i <= itemCount; i++)
		{
			for (int j = 0; j <= maxWeight; j++)
			{
				if (items.get(i - 1) > j)
				{
					sackMatrix[i] [j] = sackMatrix[i - 1] [j];
				}
				else
				{
					sackMatrix[i] [j] = Math.max(
						sackMatrix[i - 1] [j],
						sackMatrix[i - 1] [j - items.get(i - 1)] + items.get(i - 1)
					);
				}
			}
		}

		return reconstructItemsInSack(sackMatrix, items, itemCount, maxWeight).size();
	}

}
