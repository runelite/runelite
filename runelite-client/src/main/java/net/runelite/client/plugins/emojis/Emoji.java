/*
 * Copyright (c) 2019, Lotto <https://github.com/devLotto>
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
import java.awt.image.BufferedImage;
import java.util.Map;
import net.runelite.client.util.ImageUtil;

enum Emoji
{
	SLIGHT_SMILE(":)"),
	JOY("=')"),
	COWBOY("3:)"),
	BLUSH("^_^"),
	SMILE(":D"),
	GRINNING("=D"),
	WINK(";)"),
	STUCK_OUT_TONGUE_CLOSED_EYES("X-P"),
	STUCK_OUT_TONGUE(":P"),
	YUM("=P~"),
	HUGGING("<gt>:D<lt>"), // >:D<
	TRIUMPH(":<gt>"), // :>
	THINKING(":-?"),
	CONFUSED(":/"),
	NEUTRAL_FACE("=|"),
	EXPRESSIONLESS(":|"),
	UNAMUSED(":-|"),
	SLIGHT_FROWN(":("),
	FROWNING2("=("),
	CRY(":'("),
	SOB(":_("),
	FLUSHED(":$"),
	ZIPPER_MOUTH(":-#"),
	PERSEVERE("<gt>_<lt>"), // >_<
	SUNGLASSES("8-)"),
	INNOCENT("O:)"),
	SMILING_IMP("<gt>:)"), // >:)
	RAGE("<gt>:("), // >:(
	HUSHED(":-O"),
	OPEN_MOUTH(":O"),
	SCREAM(":-@"),
	SEE_NO_EVIL("X_X"),
	DANCER("\\:D/"),
	OK_HAND("(Ok)"),
	THUMBSUP("(Y)"),
	THUMBSDOWN("(N)"),
	HEARTS("<lt>3"), // <3
	BROKEN_HEART("<lt>/3"), // </3
	ZZZ("Zzz"),
	FISH("<lt><gt><lt>"), // <><
	CAT(":3"),
	DOG("=3"),
	CRAB("V(;,;)V"),
	FORK_AND_KNIFE("--E"),
	COOKING("--(o)"),
	PARTY_POPPER("@@@"),
	EYES("O.O"),
	SWEAT(";;"),
	PILE_OF_POO("~@~"),
	FIRE("(/\\)"),
	ALIEN("(@.@)"),
	EGGPLANT("8=D"),
	WAVE("(^_^)/"),
	HEART_EYES("(*.*)"),
	FACEPALM("M-)"),
	PENSIVE("V_V"),
	ACORN("<lt>D~"), // <D~
	GORILLA(":G"),
	PLEADING("(n_n)"),
	XD("Xd"),
	SPOON("--o"),
	WEARY_FACE("Dx"),
	ROCKETSHIP("<gt>==<gt>"), // >==>
	CLOWN(":O)"),
	COW("3:O"),
	HANDSHAKE("(=)"),
	;

	private static final Map<String, Emoji> emojiMap;

	private final String trigger;

	static
	{
		ImmutableMap.Builder<String, Emoji> builder = new ImmutableMap.Builder<>();

		for (final Emoji emoji : values())
		{
			builder.put(emoji.trigger, emoji);
		}

		emojiMap = builder.build();
	}

	Emoji(String trigger)
	{
		this.trigger = trigger;
	}

	BufferedImage loadImage()
	{
		return ImageUtil.loadImageResource(getClass(), this.name().toLowerCase() + ".png");
	}

	static Emoji getEmoji(String trigger)
	{
		return emojiMap.get(trigger);
	}
}
