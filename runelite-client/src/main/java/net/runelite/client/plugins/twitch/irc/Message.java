/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.twitch.irc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
class Message
{
	private final Map<String, String> tags = new HashMap<>();
	private String source;
	private String command;
	private String[] arguments;

	public static Message parse(String in)
	{
		Message message = new Message();
		if (in.startsWith("@"))
		{
			String[] tags = in.substring(1)
				.split(";");
			for (String tag : tags)
			{
				int eq = tag.indexOf('=');
				if (eq == -1)
				{
					continue;
				}

				String key = tag.substring(0, eq);
				String value = tag.substring(eq + 1)
					.replace("\\:", ";")
					.replace("\\s", " ")
					.replace("\\\\", "\\")
					.replace("\\r", "\r")
					.replace("\\n", "\n");

				message.tags.put(key, value);
			}

			int sp = in.indexOf(' ');
			in = in.substring(sp + 1);
		}

		if (in.startsWith(":"))
		{
			int sp = in.indexOf(' ');
			message.source = in.substring(1, sp);

			in = in.substring(sp + 1);
		}

		int sp = in.indexOf(' ');
		if (sp == -1)
		{
			message.command = in;
			message.arguments = new String[0];
			return message;
		}

		message.command = in.substring(0, sp);

		String args = in.substring(sp + 1);
		List<String> argList = new ArrayList<>();
		do
		{
			String arg;
			if (args.startsWith(":"))
			{
				arg = args.substring(1);
				sp = -1;
			}
			else
			{
				sp = args.indexOf(' ');
				arg = sp == -1 ? args : args.substring(0, sp);
			}
			args = args.substring(sp + 1);
			argList.add(arg);
		} while (sp != -1);

		message.arguments = argList.toArray(new String[0]);
		return message;
	}
}
