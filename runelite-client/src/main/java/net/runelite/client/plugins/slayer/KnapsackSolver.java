/*
 * Copyright (c) 2018, Davis Cook <daviscook447@gmail.com>
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
package net.runelite.client.plugins.slayer;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

@Singleton
class KnapsackSolver
{

	private List<Integer> reconstructItemsInSack(int[][] sackMatrix, List<Integer> items, int i, int w)
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

	int howMuchFitsInSack(List<Integer> items, int maxWeight)
	{
		int itemCount = items.size();

		int[][] sackMatrix = new int[itemCount + 1][maxWeight + 1];
		for (int i = 1; i <= itemCount; i++)
		{
			for (int j = 0; j <= maxWeight; j++)
			{
				if (items.get(i - 1) > j)
				{
					sackMatrix[i][j] = sackMatrix[i - 1][j];
				}
				else
				{
					sackMatrix[i][j] = Math.max(
						sackMatrix[i - 1][j],
						sackMatrix[i - 1][j - items.get(i - 1)] + items.get(i - 1)
					);
				}
			}
		}

		return reconstructItemsInSack(sackMatrix, items, itemCount, maxWeight).size();
	}

}
