/*
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
package net.runelite.client.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TextTest
{
	@Test
	public void removeTags()
	{
		assertEquals("Test", Text.removeTags("<col=FFFFFF>Test</col>"));
		assertEquals("Test", Text.removeTags("<img=1><s>Test</s>"));
		assertEquals("Zezima  (level-126)", Text.removeTags("<col=ffffff><img=2>Zezima<col=00ffff>  (level-126)"));
		assertEquals("", Text.removeTags("<colrandomtext test>"));
		assertEquals("Not so much.", Text.removeTags("<col=FFFFFF This is a very special message.</col>Not so much."));
		assertEquals("Use Item -> Man", Text.removeTags("Use Item -> Man"));
		assertEquals("a < b", Text.removeTags("a < b"));
		assertEquals("a  b", Text.removeTags("a <lt> b"));
		assertEquals("Remove no tags", Text.removeTags("Remove no tags"));
	}

	@Test
	public void removeFormattingTags()
	{
		assertEquals("Test", Text.removeFormattingTags("<col=FFFFFF>Test</col>"));
		assertEquals("Test", Text.removeFormattingTags("<img=1><s>Test</s>"));
		assertEquals("Zezima  (level-126)", Text.removeFormattingTags("<col=ffffff><img=2>Zezima<col=00ffff>  (level-126)"));
		assertEquals("", Text.removeFormattingTags("<colrandomtext test>"));
		assertEquals("Not so much.", Text.removeFormattingTags("<col=FFFFFF This is a very special message.</col>Not so much."));
		assertEquals("Use Item -> Man", Text.removeFormattingTags("Use Item -> Man"));
		assertEquals("a < b", Text.removeFormattingTags("a < b"));
		assertEquals("a <lt> b", Text.removeFormattingTags("a <lt> b"));
		assertEquals("Remove no tags", Text.removeFormattingTags("Remove no tags"));
	}

	@Test
	public void toJagexName()
	{
		assertEquals("lab rat", Text.toJagexName("lab rat"));
		assertEquals("lab rat", Text.toJagexName("-lab_rat"));
		assertEquals("lab rat", Text.toJagexName("  lab-rat__"));
		assertEquals("lab rat", Text.toJagexName("lab\u00A0rat\u00A0\u00A0"));
		assertEquals("Test Man", Text.toJagexName("蹔Test\u00A0蹔Man"));
		assertEquals("Test Boy", Text.toJagexName(" Te⓲st\u00A0B⓲oy⓲ "));
		assertEquals("mR  nAmE", Text.toJagexName("mR  nAmE"));
		assertEquals("mR  nAmE", Text.toJagexName("mR__nAmE"));
		assertEquals("mR  nAmE", Text.toJagexName("mR--nAmE"));
		assertEquals("mR  nAmE", Text.toJagexName("-_ mR\u00A0-nAmE _-"));
		assertEquals("mR  nAmE", Text.toJagexName("--__--mR_-nAmE__  --"));
		assertEquals("Mind    the     gap", Text.toJagexName("Mind_-_-the-- __gap"));
	}
}
