/*
 * Copyright (c) 2020, Jack Hodkinson <https://github.com/jrhodkinson>
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

import com.google.common.base.Splitter;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.StringUtils;

public class PluginSearch
{
	private static final Splitter SPLITTER = Splitter.on(" ").trimResults().omitEmptyStrings();

	public static <T extends SearchablePlugin> List<T> search(Collection<T> searchablePlugins, String query)
	{
		return searchablePlugins.stream()
			.filter(plugin -> Text.matchesSearchTerms(SPLITTER.split(query.toLowerCase()), plugin.getKeywords()))
			.sorted(comparator(query))
			.collect(Collectors.toList());
	}

	private static Comparator<SearchablePlugin> comparator(String query)
	{
		if (StringUtils.isBlank(query))
		{
			return Comparator.nullsLast(Comparator.comparing(SearchablePlugin::isPinned, Comparator.nullsLast(Comparator.reverseOrder())))
				.thenComparing(SearchablePlugin::getSearchableName, Comparator.nullsLast(Comparator.naturalOrder()));
		}
		Iterable<String> queryPieces = SPLITTER.split(query.toLowerCase());
		return Comparator.nullsLast(Comparator.comparing((SearchablePlugin sp) -> query.equalsIgnoreCase(sp.getSearchableName()), Comparator.reverseOrder()))
			.thenComparing(sp ->
			{
				if (sp.getSearchableName() == null)
				{
					return 0L;
				}
				return stream(SPLITTER.split(sp.getSearchableName()))
					.filter(piece -> stream(queryPieces).anyMatch(qp -> containsOrIsContainedBy(piece.toLowerCase(), qp)))
					.count();
			}, Comparator.reverseOrder())
			.thenComparing(sp ->
			{
				if (sp.getKeywords() == null)
				{
					return 0L;
				}
				return stream(sp.getKeywords())
					.filter(piece -> stream(queryPieces).anyMatch(qp -> containsOrIsContainedBy(piece.toLowerCase(), qp)))
					.count();
			}, Comparator.reverseOrder())
			.thenComparing(SearchablePlugin::isPinned, Comparator.nullsLast(Comparator.reverseOrder()))
			.thenComparing(SearchablePlugin::getSearchableName, Comparator.nullsLast(Comparator.naturalOrder()));
	}

	private static Stream<String> stream(Iterable<String> iterable)
	{
		return StreamSupport.stream(iterable.spliterator(), false);
	}

	private static boolean containsOrIsContainedBy(String a, String b)
	{
		return a.contains(b) || b.contains(a);
	}
}
