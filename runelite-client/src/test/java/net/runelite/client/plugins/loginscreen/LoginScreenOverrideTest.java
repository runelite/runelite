/*
 * Copyright (c) 2024, Macweese <https://github.com/Macweese>
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
package net.runelite.client.plugins.loginscreen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LoginScreenOverrideTest
{
	@Test
	public void testLoginScreenSorted()
	{
		// Exclude alphabetic sorting of "Off", "Custom", "Random" to maintain
		// fidelity to user comfort in the drop-down menu
		LoginScreenOverride[] sorted = Arrays.stream(LoginScreenOverride.values())
			.filter(e -> Objects.nonNull(e.getFileName()))
			.sorted(Comparator.comparing(LoginScreenOverride::name))
			.collect(Collectors.toList())
			.toArray(LoginScreenOverride[]::new);
		sorted = ArrayUtils.insert(0, sorted, LoginScreenOverride.OFF);
		sorted = ArrayUtils.addAll(sorted, LoginScreenOverride.CUSTOM, LoginScreenOverride.RANDOM);

		Assert.assertArrayEquals("Unexpected mismatch"
			+ "\n* Entries with associated backgrounds in LoginScreenOverride must be sorted alphabetically."
			+ "\n* Entry \"OFF\" must be first."
			+ "\n* Entries \"CUSTOM\" and \"RANDOM\" must be last."
			+ "\nFailure", sorted, LoginScreenOverride.values());
	}

	@Test
	public void testUniqueResource()
	{
		String[] fileNames = Arrays.stream(LoginScreenOverride.values())
			.filter(e -> Objects.nonNull(e.getFileName()))
			.map(LoginScreenOverride::getFileName)
			.toArray(String[]::new);

		HashSet<String> used = new HashSet<>();
		AtomicReference<String> duplicate = new AtomicReference<>();
		for (String s : fileNames)
		{
			if (used.contains(s))
			{
				duplicate.set(s);
				break;
			}
			used.add(s);
		}

		assertTrue(String.format("Login screen background entries must have unique resources, duplicate resource file usage found in LoginScreenOverride.\nFile: %s\nEntries: %s",
				duplicate.get(),
				Arrays.stream(LoginScreenOverride.values()).filter(e -> Objects.nonNull(e.getFileName()) && e.getFileName().equals(duplicate.get())).collect(Collectors.toList())),
			Objects.isNull(duplicate.get()));
	}
}