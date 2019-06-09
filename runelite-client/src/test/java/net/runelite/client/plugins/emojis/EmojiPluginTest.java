/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import net.runelite.client.config.ChatColorConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import javax.inject.Inject;

@RunWith(MockitoJUnitRunner.class)
public class EmojiPluginTest
{
	@Inject
	EmojiPlugin emojiPlugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ChatColorConfig chatColorConfig;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	private String PARTY_POPPER = "<img=" + (-1 + Emoji.getEmoji("@@@").ordinal()) + '>';
	private String OPEN_MOUTH = "<img=" + (-1 + Emoji.getEmoji(":O").ordinal()) + '>';

	@Test
	public void testEmojiUpdateMessage()
	{
		assertNull( emojiPlugin.updateMessage("@@@@@"));
		assertEquals( PARTY_POPPER, emojiPlugin.updateMessage("@@@"));
		assertEquals( PARTY_POPPER + ' ' + PARTY_POPPER, emojiPlugin.updateMessage("@@@ @@@"));
		assertEquals( PARTY_POPPER + ' ' + OPEN_MOUTH, emojiPlugin.updateMessage("@@@\u00A0:O"));
		assertEquals( PARTY_POPPER + ' ' + OPEN_MOUTH + ' ' + PARTY_POPPER, emojiPlugin.updateMessage("@@@\u00A0:O @@@"));
		assertEquals( PARTY_POPPER + " Hello World " + PARTY_POPPER, emojiPlugin.updateMessage("@@@\u00A0Hello World\u00A0@@@"));

	}
}
