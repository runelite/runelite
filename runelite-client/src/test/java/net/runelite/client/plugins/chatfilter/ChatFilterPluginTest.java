/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, osrs-music-map <osrs-music-map@users.noreply.github.com>
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
package net.runelite.client.plugins.chatfilter;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatFilterPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ChatFilterConfig chatFilterConfig;

	@Mock
	private Player localPlayer;

	@Inject
	private ChatFilterPlugin chatFilterPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		chatFilterPlugin.setFilterType(ChatFilterType.CENSOR_WORDS);
		chatFilterPlugin.setFilteredWords("");
		chatFilterPlugin.setFilteredRegex("");

		when(client.getLocalPlayer()).thenReturn(localPlayer);
	}

	@Test
	public void testCensorWords()
	{
		chatFilterPlugin.setFilteredWords("hat");

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("w***s up", chatFilterPlugin.censorMessage("whats up"));
	}

	@Test
	public void testCensorRegex()
	{
		chatFilterPlugin.setFilterType(ChatFilterType.REMOVE_MESSAGE);
		chatFilterPlugin.setFilteredRegex("5[0-9]x2\n(");

		chatFilterPlugin.updateFilteredPatterns();
		assertNull(chatFilterPlugin.censorMessage("55X2 Dicing | Trusted Ranks | Huge Pay Outs!"));
	}

	@Test
	public void testBrokenRegex()
	{
		chatFilterPlugin.setFilteredRegex("Test\n)\n73");

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("** isn't funny", chatFilterPlugin.censorMessage("73 isn't funny"));
	}

	@Test
	public void testCaseSensitivity()
	{
		chatFilterPlugin.setFilterType(ChatFilterType.CENSOR_MESSAGE);
		chatFilterPlugin.setFilteredWords("ReGeX!!!");

		chatFilterPlugin.updateFilteredPatterns();
		assertEquals("Hey, everyone, I just tried to say something very silly!",
			chatFilterPlugin.censorMessage("I love regex!!!!!!!!"));
	}

	@Test
	public void testNonPrintableCharacters()
	{
		chatFilterPlugin.setFilterType(ChatFilterType.REMOVE_MESSAGE);
		chatFilterPlugin.setFilteredWords("test");

		chatFilterPlugin.updateFilteredPatterns();
		assertNull(chatFilterPlugin.censorMessage("te\u008Cst"));
	}

	@Test
	public void testReplayedMessage()
	{
		chatFilterPlugin.setFilterType(ChatFilterType.REMOVE_MESSAGE);
		chatFilterPlugin.setFilteredWords("hello osrs");

		chatFilterPlugin.updateFilteredPatterns();
		assertNull(chatFilterPlugin.censorMessage("hello\u00A0osrs"));
	}

	@Test
	public void testMessageFromFriendIsFiltered()
	{
		chatFilterPlugin.setFilterFriends(true);
		assertTrue(chatFilterPlugin.shouldFilterPlayerMessage("Iron Mammal"));
	}

	@Test
	public void testMessageFromFriendIsNotFiltered()
	{
		when(client.isFriended("Iron Mammal", false)).thenReturn(true);
		chatFilterPlugin.setFilterFriends(false);
		assertFalse(chatFilterPlugin.shouldFilterPlayerMessage("Iron Mammal"));
	}

	@Test
	public void testMessageFromClanIsFiltered()
	{
		lenient().when(client.isClanMember("B0aty")).thenReturn(true);
		chatFilterPlugin.setFilterClan(true);
		assertTrue(chatFilterPlugin.shouldFilterPlayerMessage("B0aty"));
	}

	@Test
	public void testMessageFromClanIsNotFiltered()
	{
		lenient().when(client.isClanMember("B0aty")).thenReturn(true);
		chatFilterPlugin.setFilterClan(false);
		assertFalse(chatFilterPlugin.shouldFilterPlayerMessage("B0aty"));
	}

	@Test
	public void testMessageFromSelfIsNotFiltered()
	{
		lenient().when(localPlayer.getName()).thenReturn("Swampletics");
		assertFalse(chatFilterPlugin.shouldFilterPlayerMessage("Swampletics"));
	}

	@Test
	public void testMessageFromNonFriendNonClanIsFiltered()
	{
		lenient().when(client.isFriended("Woox", false)).thenReturn(false);
		lenient().when(client.isClanMember("Woox")).thenReturn(false);
		assertTrue(chatFilterPlugin.shouldFilterPlayerMessage("Woox"));
	}
}