/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
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
package net.runelite.cache.util;

import java.util.HashSet;
import java.util.Set;

public class Namer
{
	private final Set<String> used = new HashSet<>();

	public String name(String name, int id)
	{
		name = sanitize(name);

		if (name == null)
		{
			return null;
		}

		if (used.contains(name))
		{
			name = name + "_" + id;
			assert !used.contains(name);
		}

		used.add(name);

		return name;
	}

	private static String sanitize(String in)
	{
		String s = removeTags(in)
			.toUpperCase()
			.replace(' ', '_')
			.replaceAll("[^a-zA-Z0-9_]", "");
		if (s.isEmpty())
		{
			return null;
		}
		if (Character.isDigit(s.charAt(0)))
		{
			return "_" + s;
		}
		else
		{
			return s;
		}
	}

	public static String removeTags(String str)
	{
		StringBuilder builder = new StringBuilder(str.length());
		boolean inTag = false;

		for (int i = 0; i < str.length(); i++)
		{
			char currentChar = str.charAt(i);

			if (currentChar == '<')
			{
				inTag = true;
			}
			else if (currentChar == '>')
			{
				inTag = false;
			}
			else if (!inTag)
			{
				builder.append(currentChar);
			}
		}

		return builder.toString();
	}
}
