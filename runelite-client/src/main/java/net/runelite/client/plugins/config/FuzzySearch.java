/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.config;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.Value;
import org.apache.commons.text.similarity.JaroWinklerDistance;

public class FuzzySearch
{
	private static final JaroWinklerDistance FUZZY_SCORE = new JaroWinklerDistance();
	private static final double STRING_OCCURRENCE_MULTIPLIER = 3d;

	/**
	 * Try to find a match and call callback on each match, sorted by score and filtered by average
	 *
	 * @param query    query to search for
	 * @param entries  entries to search in
	 * @param callback callback to call
	 */
	public static void findAndProcess(final String query, final Collection<String> entries, final Consumer<String> callback)
	{
		// Calculate score for each entry matching query
		final Set<FuzzyMatch> matches = entries.stream()
			.map(entry -> new FuzzyMatch(
				FUZZY_SCORE.apply(query, entry)
					+ calculateStringOccurrenceBonus(entry, query)
					* STRING_OCCURRENCE_MULTIPLIER,
				entry))
			.collect(Collectors.toSet());

		// Calculate average score of the matches to filter out the less relevant ones
		final double average = matches.stream().mapToDouble(m -> m.score).average().orElse(0);
		final double max = matches.stream().mapToDouble(m -> m.score).max().orElse(0);
		final double limit = Math.min(average * 1.7, max);

		matches.stream()
			.filter(m -> m.score >= limit)
			.sorted((left, right) -> Double.compare(right.score, left.score))
			.map(m -> m.value)
			.forEach(callback);
	}

	/**
	 * Calculates string occurrence bonus of query in the entry string
	 * @param entry entry string
	 * @param query query string
	 * @return string occurrence bonus
	 */
	private static double calculateStringOccurrenceBonus(final String entry, final String query)
	{
		// Exit early, no occurrence bonus for too long query
		if (query.length() > entry.length())
		{
			return 0;
		}

		// Create relaxed variants of the input (e.g lower cased ones)
		final String relaxedEntry = entry.toLowerCase();
		final String relaxedQuery = query.toLowerCase();

		// Create base bonus
		final double base = 1d / 6d;

		if (entry.equals(query))
		{
			return base * 6d;
		}
		if (entry.equals(relaxedQuery) || relaxedQuery.equals(entry))
		{
			return base * 5d;
		}
		if (relaxedEntry.equals(relaxedQuery))
		{
			return base * 4d;
		}
		if (entry.contains(query))
		{
			return base * 3d;
		}
		if (entry.contains(relaxedQuery) || relaxedEntry.contains(query))
		{
			return base * 2d;
		}
		if (relaxedEntry.contains(relaxedQuery))
		{
			return base;
		}

		return 0;
	}

	@Value
	private static class FuzzyMatch
	{
		/**
		 * Score of the match
		 */
		double score;

		/**
		 * Match value
		 */
		String value;
	}
}
