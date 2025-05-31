/*
 * Copyright (c) 2019, Lotto <https://github.com/devLotto>
 * Copyright (c) 2025, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.emojis;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

enum Emoji
{
	SLIGHT_SMILE(0x1f642, ":)"),
	JOY(0x1f639, "=')"),
	COWBOY(0x1f920, "3:)"),
	BLUSH(0x1f60a, "^_^"),
	SMILE(0x1f601, ":D"),
	GRINNING(0x1f600, "=D"),
	WINK(0x1f609, ";)"),
	STUCK_OUT_TONGUE_CLOSED_EYES(0x1f61d, "X-P"),
	STUCK_OUT_TONGUE(0x1f61b, ":P"),
	YUM(0x1f60b, "=P~"),
	HUGGING(0x1f917, "<gt>:D<lt>"), // >:D<
	TRIUMPH(0x1f624, ":<gt>"), // :>
	THINKING(0x1f914, ":-?"),
	CONFUSED(0x1f615, ":/"),
	NEUTRAL_FACE(0x1f610, "=|"),
	EXPRESSIONLESS(0x1f611, ":|"),
	UNAMUSED(0x1f612, ":-|"),
	SLIGHT_FROWN(0x1f641, ":("),
	FROWNING2(0x1f626, "=("),
	CRY(0x1f622, ":'("),
	SOB(0x1f62d, ":_("),
	FLUSHED(0x1f633, ":$"),
	ZIPPER_MOUTH(0x1f910, ":-#"),
	PERSEVERE(0x1f623, "<gt>_<lt>"), // >_<
	SUNGLASSES(0x1f60e, "8-)"),
	INNOCENT(0x1f607, "O:)"),
	SMILING_IMP(0x1f608, "<gt>:)"), // >:)
	RAGE(0x1f621, "<gt>:("), // >:(
	HUSHED(0x1f62f, ":-O"),
	OPEN_MOUTH(0x1f62e, ":O"),
	SCREAM(0x1f631, ":-@"),
	SEE_NO_EVIL(0x1f648, "X_X"),
	DANCER(0x1f483, "\\:D/"),
	OK_HAND(0x1f44c, "(Ok)"),
	THUMBSUP(0x1f44d, "(Y)"),
	THUMBSDOWN(0x1f44e, "(N)"),
	HEARTS(0x2764, "<lt>3"), // <3
	BROKEN_HEART(0x1f494, "<lt>/3"), // </3
	ZZZ(0x1f4a4, "Zzz"),
	FISH(0x1f41f, "<lt><gt><lt>"), // <><
	CAT(0x1f431, ":3"),
	DOG(0x1f436, "=3"),
	CRAB(0x1f980, "V(;,;)V"),
	FORK_AND_KNIFE(0x1f374, "--E"),
	COOKING(0x1f373, "--(o)"),
	PARTY_POPPER(0x1f389, "@@@"),
	EYES(0x1f440, "O.O"),
	SWEAT(0x1f4a6, ";;"),
	PILE_OF_POO(0x1f4a9, "~@~"),
	FIRE(0x1f525, "(/\\)"),
	ALIEN(0x1f47d, "(@.@)"),
	EGGPLANT(0x1f346, "8=D"),
	WAVE(0x1f44b, "(^_^)/"),
	HEART_EYES(0x1f60d, "(*.*)"),
	FACEPALM(0x1f926, "M-)"),
	PENSIVE(0x1f614, "V_V"),
	ACORN(0x1f330, "<lt>D~"), // <D~
	GORILLA(0x1f98d, ":G"),
	PLEADING(0x1f97a, "(n_n)"),
	XD(0x1f606, "Xd"),
	SPOON(0x1f944, "--o"),
	WEARY_FACE(0x1f629, "Dx"),
	ROCKETSHIP(0x1f680, "<gt>==<gt>"), // >==>
	CLOWN(0x1f921, ":O)"),
	COW(0x1f42e, "3:O"),
	HANDSHAKE(0x1f91d, "(=)"),
	RABBIT(0x1f430, "=:3"),
	;

	private static final Map<String, Emoji> emojiMap;

	private final String trigger;
	final int codepoint;

	static
	{
		ImmutableMap.Builder<String, Emoji> builder = new ImmutableMap.Builder<>();

		for (final Emoji emoji : values())
		{
			builder.put(emoji.trigger, emoji);
		}

		emojiMap = builder.build();
	}

	Emoji(int codepoint, String shortName)
	{
		this.trigger = shortName;
		this.codepoint = codepoint;
	}

	static Emoji getEmoji(String trigger)
	{
		return emojiMap.get(trigger);
	}
}
