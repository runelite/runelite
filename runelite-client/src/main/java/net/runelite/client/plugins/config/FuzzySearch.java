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

	/**
	 * Try to find a match and call callback on each match, sorted by score and filtered by average
	 *
	 * @param query    query to search for
	 * @param entries  entries to search in
	 * @param callback callback to call
	 */
	public static void findAndProcess(final String query, final Collection<String> entries, final Consumer<String> callback)
	{
		final Set<FuzzyMatch> matches = entries.stream()
			.map(e -> new FuzzyMatch(FUZZY_SCORE.apply(query, e), e))
			.collect(Collectors.toSet());

		final double average = matches.stream().mapToDouble(m -> m.score).average().orElse(0);

		matches.stream()
			.filter(m -> m.score > average * 1.5)
			.sorted((left, right) -> Double.compare(right.score, left.score))
			.map(m -> m.text)
			.forEach(callback);
	}

	@Value
	private static class FuzzyMatch
	{
		double score;
		String text;
	}
}
