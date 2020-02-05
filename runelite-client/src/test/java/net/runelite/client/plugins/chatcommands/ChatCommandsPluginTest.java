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
package net.runelite.client.plugins.chatcommands;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import static net.runelite.api.ChatMessageType.FRIENDSCHATNOTIFICATION;
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import static net.runelite.api.ChatMessageType.TRADE;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatCommandsPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ConfigManager configManager;

	@Mock
	@Bind
	ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	ChatColorConfig chatColorConfig;

	@Mock
	@Bind
	ChatCommandsConfig chatCommandsConfig;

	@Inject
	ChatCommandsPlugin chatCommandsPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testCorporealBeastKill()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", "Your Corporeal Beast kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "corporeal beast", 4);
	}

	@Test
	public void testTheatreOfBlood()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Theatre of Blood count is: <col=ff0000>73</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "theatre of blood", 73);
	}

	@Test
	public void testWintertodt()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", "Your subdued Wintertodt count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "wintertodt", 4);
	}

	@Test
	public void testKreearra()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", "Your Kree'arra kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "kree'arra", 4);
	}

	@Test
	public void testBarrows()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", "Your Barrows chest count is: <col=ff0000>277</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "barrows chests", 277);
	}

	@Test
	public void testHerbiboar()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", "Your herbiboar harvest count is: <col=ff0000>4091</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "herbiboar", 4091);
	}

	@Test
	public void testGauntlet()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage gauntletMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Gauntlet completion count is: <col=ff0000>123</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(gauntletMessage);

		verify(configManager).setConfiguration("killcount.adam", "gauntlet", 123);
	}

	@Test
	public void testCorruptedGauntlet()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage corruptedGauntletMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Corrupted Gauntlet completion count is: <col=ff0000>4729</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(corruptedGauntletMessage);

		verify(configManager).setConfiguration("killcount.adam", "corrupted gauntlet", 4729);
	}

	@Test
	public void testPersonalBest()
	{
		final String FIGHT_DURATION = "Fight duration: <col=ff0000>2:06</col>. Personal best: 1:19.";

		when(client.getUsername()).thenReturn("Adam");

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Kree'arra kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", FIGHT_DURATION, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("kree'arra"), eq(79));
	}

	@Test
	public void testPersonalBestNoTrailingPeriod()
	{
		final String FIGHT_DURATION = "Fight duration: <col=ff0000>0:59</col>. Personal best: 0:55";

		when(client.getUsername()).thenReturn("Adam");

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Zulrah kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", FIGHT_DURATION, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("zulrah"), eq(55));
	}

	@Test
	public void testNewPersonalBest()
	{
		final String NEW_PB = "Fight duration: <col=ff0000>3:01</col> (new personal best).";

		when(client.getUsername()).thenReturn("Adam");

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Kree'arra kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", NEW_PB, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("kree'arra"), eq(181));
	}

	@Test
	public void testDuelArenaWin()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, TRADE, "", "You won! You have now won 27 duels.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "duel arena wins", 27);
		verify(configManager).setConfiguration("killcount.adam", "duel arena win streak", 1);
	}

	@Test
	public void testDuelArenaWin2()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, TRADE, "", "You were defeated! You have won 22 duels.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "duel arena wins", 22);
	}

	@Test
	public void testDuelArenaLose()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessageEvent = new ChatMessage(null, TRADE, "", "You have now lost 999 duels.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setConfiguration("killcount.adam", "duel arena losses", 999);
	}

	@Test
	public void testAgilityLap()
	{
		final String NEW_PB = "Lap duration: <col=ff0000>1:01</col> (new personal best).";

		when(client.getUsername()).thenReturn("Adam");

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Prifddinas Agility Course lap count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", NEW_PB, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("prifddinas agility course"), eq(61));
		verify(configManager).setConfiguration(eq("killcount.adam"), eq("prifddinas agility course"), eq(2));
	}

	@Test
	public void testZukNewPb()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your TzKal-Zuk kill count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>104:31</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("tzkal-zuk"), eq(104 * 60 + 31));
		verify(configManager).setConfiguration(eq("killcount.adam"), eq("tzkal-zuk"), eq(2));
	}

	@Test
	public void testZukKill()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your TzKal-Zuk kill count is: <col=ff0000>3</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>172:18</col>. Personal best: 134:52", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("tzkal-zuk"), eq(134 * 60 + 52));
		verify(configManager).setConfiguration(eq("killcount.adam"), eq("tzkal-zuk"), eq(3));
	}

	@Test
	public void testGgNewPb()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Fight duration: <col=ff0000>1:36</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Grotesque Guardians kill count is: <col=ff0000>179</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("grotesque guardians"), eq(96));
		verify(configManager).setConfiguration(eq("killcount.adam"), eq("grotesque guardians"), eq(179));
	}

	@Test
	public void testGgKill()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Fight duration: <col=ff0000>2:41</col>. Personal best: 2:14", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Grotesque Guardians kill count is: <col=ff0000>32</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("grotesque guardians"), eq(2 * 60 + 14));
		verify(configManager).setConfiguration(eq("killcount.adam"), eq("grotesque guardians"), eq(32));
	}

	@Test
	public void testGuantletPersonalBest()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>10:24</col>. Personal best: 7:59.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Gauntlet completion count is: <col=ff0000>124</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("killcount.adam"), eq("gauntlet"), eq(124));
		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("gauntlet"), eq(7 * 60 + 59));
	}

	@Test
	public void testGuantletNewPersonalBest()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>10:24</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Gauntlet completion count is: <col=ff0000>124</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("gauntlet"), eq(10 * 60 + 24));
		verify(configManager).setConfiguration(eq("killcount.adam"), eq("gauntlet"), eq(124));
	}

	@Test
	public void testCoXKill()
	{
		when(client.getUsername()).thenReturn("Adam");

		ChatMessage chatMessage = new ChatMessage(null, FRIENDSCHATNOTIFICATION, "", "<col=ef20ff>Congratulations - your raid is complete! Duration:</col> <col=ff0000>37:04</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Chambers of Xeric count is: <col=ff0000>51</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("killcount.adam"), eq("chambers of xeric"), eq(51));
		verify(configManager).setConfiguration(eq("personalbest.adam"), eq("chambers of xeric"), eq(37 * 60 + 4));
	}

	@Test
	public void testCoXKillNoPb()
	{
		when(client.getUsername()).thenReturn("Adam");
		when(configManager.getConfiguration(anyString(), anyString(), any())).thenReturn(2224);

		ChatMessage chatMessage = new ChatMessage(null, FRIENDSCHATNOTIFICATION, "", "<col=ef20ff>Congratulations - your raid is complete! Duration:</col> <col=ff0000>1:45:04</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Chambers of Xeric count is: <col=ff0000>52</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setConfiguration(eq("killcount.adam"), eq("chambers of xeric"), eq(52));
		verify(configManager, never()).setConfiguration(eq("personalbest.adam"), eq("chambers of xeric"), anyInt());
	}
}
