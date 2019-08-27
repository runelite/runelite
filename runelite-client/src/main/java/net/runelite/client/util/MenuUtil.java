/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
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
package net.runelite.client.util;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.util.Text;

@Deprecated
@Slf4j
public class MenuUtil
{
	public static void swap(Client client, MenuEntry entry1, MenuEntry entry2)
	{
		List<MenuEntry> entries = Arrays.asList(client.getMenuEntries());

		if (!entries.contains(entry1) || !entries.contains(entry2))
		{
			log.warn("Can't swap {} with {} as one or both menuentries aren't present", entry1, entry2);
			return;
		}

		int idxA = entries.indexOf(entry1);
		int idxB = entries.indexOf(entry2);

		entries.set(idxA, entry2);
		entries.set(idxB, entry1);

		client.setMenuEntries(entries.toArray(new MenuEntry[0]));
	}

	public static void swap(Client client, String option1, String option2, String target1, String target2, boolean strict)
	{
		if (strict)
		{
			swap(client, option1, option2, target1, target2);
		}
		else
		{
			swapNotStrict(client, option1, option2, target1, target2);
		}
	}

	public static void swap(Client client, String option1, String option2, String target1, String target2)
	{
		MenuEntry entry1 = findOptionTarget(getMenuStream(client), Text.standardize(option1), Text.standardize(target1));
		MenuEntry entry2 = findOptionTarget(getMenuStream(client), Text.standardize(option2), Text.standardize(target2));

		if (entry1 != null && entry2 != null)
		{
			swap(client, entry1, entry2);
		}
	}

	private static void swapNotStrict(Client client, String option1, String option2, String target1, String target2)
	{
		MenuEntry entry1 = findOptionTargetLenient(getMenuStream(client), Text.standardize(option1), Text.standardize(target1));
		MenuEntry entry2 = findOptionTargetLenient(getMenuStream(client), Text.standardize(option2), Text.standardize(target2));

		if (entry1 != null && entry2 != null)
		{
			swap(client, entry1, entry2);
		}
	}

	public static void swap(Client client, String option1, String option2, String targetforboth)
	{
		swap(client, option1, option2, targetforboth, targetforboth);
	}

	public static void swap(Client client, String option1, String option2, String targetforboth, boolean strict)
	{
		if (strict)
		{
			swap(client, option1, option2, targetforboth, targetforboth);
		}
		else
		{
			swapNotStrict(client, option1, option2, targetforboth, targetforboth);
		}
	}

	private static MenuEntry findOptionTarget(Stream<MenuEntry> stream, String option, String target)
	{
		Optional<MenuEntry> maybeEntry = stream.filter(e -> Text.standardize(e.getOption()).equals(option) &&
			Text.standardize(e.getTarget()).equals(target))
			/* autism */.findFirst();

		return maybeEntry.orElse(null);
	}

	private static MenuEntry findOptionTargetLenient(Stream<MenuEntry> stream, String option, String target)
	{
		Optional<MenuEntry> maybeEntry = stream.filter(e -> Text.standardize(e.getOption()).contains(option) &&
			Text.standardize(e.getTarget()).contains(target))
			/* autism */.findFirst();

		return maybeEntry.orElse(null);
	}

	private static Stream<MenuEntry> getMenuStream(Client client)
	{
		List<MenuEntry> entries = Arrays.asList(client.getMenuEntries());
		return Lists.reverse(entries).stream();
	}
}
