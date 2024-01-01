/*
 * Copyright (c) 2023, LlemonDuck <napkinorton@gmail.com>
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

package net.runelite.client.plugins.grandexchange;

import java.util.function.ToDoubleFunction;
import javax.inject.Singleton;
import net.runelite.api.ItemComposition;
import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.apache.commons.text.similarity.SimilarityScore;

@Singleton
public class FuzzySearchScorer
{

	// can be swapped, but i found jaro-winkler to do well considering the variable length of inputs
	// whereas levenshtein biases toward strings of same len, regardless of overlap
	private final SimilarityScore<Double> baseAlgorithm = new JaroWinklerDistance();

	public Double score(String query, String itemName)
	{
		query = query.toLowerCase().replace('-', ' ');
		itemName = itemName.toLowerCase().replace('-', ' ');

		// we raise the score for items that share a prefix with the query
		int prefixLen = 0;
		int maxLen = Math.min(query.length(), itemName.length());
		while (prefixLen < maxLen && query.charAt(prefixLen) == itemName.charAt(prefixLen))
		{
			prefixLen++;
		}
		double prefixScore = ((double) prefixLen) / query.length() - 0.25;

		// and also raise the score for string "closeness"
		double proximityScore = baseAlgorithm.apply(query, itemName) - 0.25;
		return prefixScore + proximityScore;
	}

	public ToDoubleFunction<ItemComposition> comparator(String query)
	{
		// We do this so that for example the items "Anti-venom ..." are still at the top
		// when searching "anti venom"
		return item -> score(
			query.toLowerCase().replace('-', ' '),
			item.getName().toLowerCase().replace('-', ' ')
		);
	}

}
