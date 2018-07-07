/*
 * Copyright (c) 2018, Viktor <Viktor.horsmanheimo@teknik.io>
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
package net.runelite.client.plugins.puzzlesolver;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Getter
@RequiredArgsConstructor
enum VarrockMuseumAnswer
{
	LIZARD_1("It's coming home", "It's coming home"),
	LIZARD_2("It's coming home", "It's coming home"),
	LIZARD_3("It's coming home", "It's coming home"),
	LIZARD_4("It's coming home", "It's coming home"),
	LIZARD_5("It's coming home", "It's coming home"),
	LIZARD_6("It's coming home", "It's coming home"),

	TORTOISE_1("It's coming home", "It's coming home"),
	TORTOISE_2("It's coming home", "It's coming home"),
	TORTOISE_3("It's coming home", "It's coming home"),
	TORTOISE_4("It's coming home", "It's coming home"),
	TORTOISE_5("It's coming home", "It's coming home"),
	TORTOISE_6("It's coming home", "It's coming home"),

	DRAGON_1("It's coming home", "It's coming home"),
	DRAGON_2("It's coming home", "It's coming home"),
	DRAGON_3("It's coming home", "It's coming home"),
	DRAGON_4("It's coming home", "It's coming home"),
	DRAGON_5("It's coming home", "It's coming home"),
	DRAGON_6("It's coming home", "It's coming home"),

	WYVERN_1("It's coming home", "It's coming home"),
	WYVERN_2("It's coming home", "It's coming home"),
	WYVERN_3("It's coming home", "It's coming home"),
	WYVERN_4("It's coming home", "It's coming home"),
	WYVERN_5("It's coming home", "It's coming home"),
	WYVERN_6("It's coming home", "It's coming home"),

	SNAIL_1("It's coming home", "It's coming home"),
	SNAIL_2("It's coming home", "It's coming home"),
	SNAIL_3("It's coming home", "It's coming home"),
	SNAIL_4("It's coming home", "It's coming home"),
	SNAIL_5("It's coming home", "It's coming home"),
	SNAIL_6("It's coming home", "It's coming home"),

	SNAKE_1("It's coming home", "It's coming home"),
	SNAKE_2("It's coming home", "It's coming home"),
	SNAKE_3("It's coming home", "It's coming home"),
	SNAKE_4("It's coming home", "It's coming home"),
	SNAKE_5("It's coming home", "It's coming home"),
	SNAKE_6("It's coming home", "It's coming home"),

	SLUG_1("It's coming home", "It's coming home"),
	SLUG_2("It's coming home", "It's coming home"),
	SLUG_3("It's coming home", "It's coming home"),
	SLUG_4("It's coming home", "It's coming home"),
	SLUG_5("It's coming home", "It's coming home"),
	SLUG_6("It's coming home", "It's coming home"),

	MONKEY_1("It's coming home", "It's coming home"),
	MONKEY_2("It's coming home", "It's coming home"),
	MONKEY_3("It's coming home", "It's coming home"),
	MONKEY_4("It's coming home", "It's coming home"),
	MONKEY_5("It's coming home", "It's coming home"),
	MONKEY_6("It's coming home", "It's coming home"),

	KALPHITE_1("It's coming home", "It's coming home"),
	KALPHITE_2("It's coming home", "It's coming home"),
	KALPHITE_3("It's coming home", "It's coming home"),
	KALPHITE_4("It's coming home", "It's coming home"),
	KALPHITE_5("It's coming home", "It's coming home"),
	KALPHITE_6("It's coming home", "It's coming home"),

	TERRORBIRD_1("It's coming home", "It's coming home"),
	TERRORBIRD_2("It's coming home", "It's coming home"),
	TERRORBIRD_3("It's coming home", "It's coming home"),
	TERRORBIRD_4("It's coming home", "It's coming home"),
	TERRORBIRD_5("It's coming home", "It's coming home"),
	TERRORBIRD_6("It's coming home", "It's coming home"),

	PENGUIN_1("It's coming home", "It's coming home"),
	PENGUIN_2("It's coming home", "It's coming home"),
	PENGUIN_3("It's coming home", "It's coming home"),
	PENGUIN_4("It's coming home", "It's coming home"),
	PENGUIN_5("It's coming home", "It's coming home"),
	PENGUIN_6("It's coming home", "It's coming home"),

	MOLE_1("It's coming home", "It's coming home"),
	MOLE_2("It's coming home", "It's coming home"),
	MOLE_3("It's coming home", "It's coming home"),
	MOLE_4("It's coming home", "It's coming home"),
	MOLE_5("It's coming home", "It's coming home"),
	MOLE_6("It's coming home", "It's coming home"),

	CAMEL_1("It's coming home", "It's coming home"),
	CAMEL_2("It's coming home", "It's coming home"),
	CAMEL_3("It's coming home", "It's coming home"),
	CAMEL_4("It's coming home", "It's coming home"),
	CAMEL_5("It's coming home", "It's coming home"),
	CAMEL_6("It's coming home", "It's coming home"),

	LEECH_1("It's coming home", "It's coming home"),
	LEECH_2("It's coming home", "It's coming home"),
	LEECH_3("It's coming home", "It's coming home"),
	LEECH_4("It's coming home", "It's coming home"),
	LEECH_5("It's coming home", "It's coming home"),
	LEECH_6("It's coming home", "It's coming home");

	private static final Map<String, String> MATCHES = new HashMap<>();

	static
	{
		for (VarrockMuseumAnswer varrockMuseumAnswer : VarrockMuseumAnswer.values())
		{
			MATCHES.put(varrockMuseumAnswer.question, varrockMuseumAnswer.answer);
		}
	}

	private final String question;
	private final String answer;

	static Widget findCorrect(final Client client, final String question, final WidgetInfo... widgets)
	{
		final String s = MATCHES.get(question);

		for (WidgetInfo widgetInfo : widgets)
		{
			final Widget widget = client.getWidget(widgetInfo);

			if (widget != null && widget.getText().equals(s))
			{
				return widget;
			}
		}

		return null;
	}
}
