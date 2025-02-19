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

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import static net.runelite.api.ChatMessageType.FRIENDSCHATNOTIFICATION;
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import static net.runelite.api.ChatMessageType.TRADE;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.GameState;
import net.runelite.api.IndexedSprite;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatClient;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.game.ItemManager;
import net.runelite.client.hiscore.HiscoreClient;
import net.runelite.client.hiscore.HiscoreEndpoint;
import net.runelite.client.hiscore.HiscoreResult;
import net.runelite.client.hiscore.HiscoreSkill;
import net.runelite.client.hiscore.Skill;
import net.runelite.client.util.AsyncBufferedImage;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class ChatCommandsPluginTest
{
	private static final String PLAYER_NAME = "Adam";

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ClientThread clientThread;

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
	ChatCommandManager chatCommandManager;

	@Mock
	@Bind
	HiscoreClient hiscoreClient;

	@Mock
	@Bind
	ChatClient chatClient;

	@Mock
	@Bind
	RuneLiteConfig runeLiteConfig;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	ChatCommandsConfig chatCommandsConfig;

	@Inject
	ChatCommandsPlugin chatCommandsPlugin;

	@Inject
	Gson gson;

	private IndexedSprite[] modIcons;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		Player player = mock(Player.class);
		when(player.getName()).thenReturn(PLAYER_NAME);
		when(client.getLocalPlayer()).thenReturn(player);

		modIcons = new IndexedSprite[0];
		when(client.getModIcons()).thenAnswer(a -> modIcons);
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			modIcons = (IndexedSprite[]) argument;
			return null;
		}).when(client).setModIcons(any(IndexedSprite[].class));

		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);

		EnumComposition enum_ = mock(EnumComposition.class);
		when(enum_.size()).thenReturn(1);
		when(enum_.getIntValue(0)).thenReturn(ItemID.CHOMPY_CHICK);
		when(client.getEnum(EnumID.PETS)).thenReturn(enum_);

		when(itemManager.getImage(anyInt())).thenReturn(new AsyncBufferedImage(clientThread, 1, 1, BufferedImage.TYPE_INT_ARGB));

		chatCommandsPlugin.startUp();

		// clientthread callback
		ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invoke(captor.capture());
		captor.getValue().run();
	}

	@After
	public void after()
	{
		chatCommandsPlugin.shutDown();
	}

	@Test
	public void testStartupShutdown()
	{
		// minor kludge since before/after will startup/shutdown
		chatCommandsPlugin.shutDown();

		ArgumentCaptor<String> registerCaptor = ArgumentCaptor.forClass(String.class);
		verify(chatCommandManager, atLeastOnce()).registerCommand(registerCaptor.capture(), any());
		verify(chatCommandManager, atLeastOnce()).registerCommandAsync(registerCaptor.capture(), any());
		verify(chatCommandManager, atLeastOnce()).registerCommandAsync(registerCaptor.capture(), any(), any());

		ArgumentCaptor<String> unregisterCaptor = ArgumentCaptor.forClass(String.class);
		verify(chatCommandManager, atLeastOnce()).unregisterCommand(unregisterCaptor.capture());

		assertEquals(Sets.newHashSet(registerCaptor.getAllValues()), Sets.newHashSet(unregisterCaptor.getAllValues()));

		chatCommandsPlugin.startUp();
	}

	@Test
	public void testCorporealBeastKill()
	{
		testKillCountChatMessage("corporeal beast", "Your Corporeal Beast kill count is: <col=ff0000>4</col>.", 4);
	}

	@Test
	public void testTheatreOfBlood()
	{
		when(client.getVarbitValue(Varbits.THEATRE_OF_BLOOD_ORB1)).thenReturn(1);
		when(client.getVarbitValue(Varbits.THEATRE_OF_BLOOD_ORB2)).thenReturn(15);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "",
			"Wave 'The Final Challenge' (Normal Mode) complete!<br>" +
				"Duration: <col=ff0000>2:42.0</col><br>" +
				"Theatre of Blood completion time: <col=ff0000>17:00.20</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Theatre of Blood total completion time: <col=ff0000>24:40.20</col>. Personal best: 20:45.00", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Theatre of Blood count is: <col=ff0000>73</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "theatre of blood", 73);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood", 17 * 60 + .2);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood 2 players", 17 * 60 + .2);
	}

	@Test
	public void testTheatreOfBloodNoPb()
	{
		when(client.getVarbitValue(Varbits.THEATRE_OF_BLOOD_ORB1)).thenReturn(1);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "",
			"Wave 'The Final Challenge' (Normal Mode) complete!<br>" +
				"Duration: <col=ff0000>2:42</col><br>" +
				"Theatre of Blood completion time: <col=ff0000>17:00</col>. Personal best: 13:52.80", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Theatre of Blood total completion time: <col=ff0000>24:40.20</col>. Personal best: 20:45.00", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Theatre of Blood count is: <col=ff0000>73</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "theatre of blood", 73);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood", 13 * 60 + 52.8);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood solo", 13 * 60 + 52.8);
	}

	@Test
	public void testTheatreOfBloodEntryMode()
	{
		when(client.getVarbitValue(Varbits.THEATRE_OF_BLOOD_ORB1)).thenReturn(1);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "",
			"Wave 'The Final Challenge' (Entry Mode) complete!<br>" +
				"Duration: <col=ff0000>2:42</col><br>" +
				"Theatre of Blood completion time: <col=ff0000>17:00</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Theatre of Blood total completion time: <col=ff0000>24:40.20</col>. Personal best: 20:45.00", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Theatre of Blood: Entry Mode count is: <col=ff0000>73</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "theatre of blood entry mode", 73);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood entry mode", 17 * 60.);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood entry mode solo", 17 * 60.);
	}

	@Test
	public void testWintertodt()
	{
		testKillCountChatMessage("wintertodt", "Your subdued Wintertodt count is: <col=ff0000>4</col>.", 4);
	}

	@Test
	public void testKreearra()
	{
		testKillCountChatMessage("kree'arra", "Your Kree'arra kill count is: <col=ff0000>4</col>.", 4);
	}

	@Test
	public void testBarrows()
	{
		testKillCountChatMessage("barrows chests", "Your Barrows chest count is: <col=ff0000>277</col>.", 277);
	}

	@Test
	public void testHerbiboar()
	{
		testKillCountChatMessage("herbiboar", "Your herbiboar harvest count is: <col=ff0000>4091</col>.", 4091);
	}

	@Test
	public void testGauntlet()
	{
		testKillCountChatMessage("gauntlet", "Your Gauntlet completion count is: <col=ff0000>123</col>.", 123);
	}

	@Test
	public void testCorruptedGauntlet()
	{
		testKillCountChatMessage("corrupted gauntlet", "Your Corrupted Gauntlet completion count is: <col=ff0000>4729</col>.", 4729);
	}

	@Test
	public void testHunllefEcho()
	{
		testKillCountChatMessage("corrupted hunllef (echo)", "Your <col=a53fff>Corrupted Hunllef (Echo)</col> kill count is: <col=ff3045>31</col>", 31);
	}

	@Test
	public void testKalphiteEcho()
	{
		testKillCountChatMessage("kalphite queen (echo)", "Your <col=6800bf>Kalphite Queen (Echo)</col> kill count is:<col=e00a19>1</col>", 1);
	}

	@Test
	public void testPersonalBest()
	{
		final String FIGHT_DURATION = "Fight duration: <col=ff0000>2:06</col>. Personal best: 1:19.";
		final String FIGHT_DURATION_PRECISE = "Fight duration: <col=ff0000>2:06.40</col>. Personal best: 1:19.20.";

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Kree'arra kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", FIGHT_DURATION, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "kree'arra", 79.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", FIGHT_DURATION_PRECISE, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "kree'arra", 79.2);
	}

	@Test
	public void testPersonalBestNoTrailingPeriod()
	{
		final String FIGHT_DURATION = "Fight duration: <col=ff0000>0:59</col>. Personal best: 0:55";
		final String FIGHT_DURATION_PRECISE = "Fight duration: <col=ff0000>0:59.20</col>. Personal best: 0:55.40";

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Zulrah kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", FIGHT_DURATION, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "zulrah", 55.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", FIGHT_DURATION_PRECISE, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "zulrah", 55.4);
	}

	@Test
	public void testNewPersonalBest()
	{
		final String NEW_PB = "Fight duration: <col=ff0000>3:01</col> (new personal best).";
		final String NEW_PB_PRECISE = "Fight duration: <col=ff0000>3:01.40</col> (new personal best).";

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Kree'arra kill count is: <col=ff0000>4</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", NEW_PB, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "kree'arra", 181.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", NEW_PB_PRECISE, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "kree'arra", 181.4);
	}

	@Test
	public void testDuelArenaWin()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, TRADE, "", "You won! You have now won 1,909 duels.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		chatMessageEvent = new ChatMessage(null, TRADE, "", "You have lost 1,999 duels.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration("killcount", "duel arena wins", 1909);
		verify(configManager).setRSProfileConfiguration("killcount", "duel arena win streak", 1);

		verify(configManager).setRSProfileConfiguration("killcount", "duel arena losses", 1999);
	}

	@Test
	public void testDuelArenaLoss()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, TRADE, "", "You were defeated! You have won 1,909 duels.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		chatMessageEvent = new ChatMessage(null, TRADE, "", "You have now lost 1999 duels.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration("killcount", "duel arena wins", 1909);
		verify(configManager).setRSProfileConfiguration("killcount", "duel arena losses", 1999);
	}

	@Test
	public void testAgilityLap()
	{
		final String NEW_PB = "Lap duration: <col=ff0000>1:01</col> (new personal best).";
		final String NEW_PB_PRECISE = "Lap duration: <col=ff0000>1:01.20</col> (new personal best).";

		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Prifddinas Agility Course lap count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", NEW_PB, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "prifddinas agility course", 61.0);
		verify(configManager).setRSProfileConfiguration("killcount", "prifddinas agility course", 2);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", NEW_PB_PRECISE, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "prifddinas agility course", 61.2);
	}

	@Test
	public void testShayzienAdvancedAgilityLap()
	{
		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Shayzien Advanced Agility Course lap count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Lap duration: <col=ff0000>1:01</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "shayzien advanced agility course", 61.0);
		verify(configManager).setRSProfileConfiguration("killcount", "shayzien advanced agility course", 2);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Lap duration: <col=ff0000>1:01.20</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "shayzien advanced agility course", 61.2);
	}

	@Test
	public void testShayzienBasicAgilityLap()
	{
		// This sets lastBoss
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Shayzien Basic Agility Course lap count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Lap duration: <col=ff0000>1:01</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "shayzien basic agility course", 61.0);
		verify(configManager).setRSProfileConfiguration("killcount", "shayzien basic agility course", 2);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Lap duration: <col=ff0000>1:01.20</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "shayzien basic agility course", 61.2);
	}

	@Test
	public void testZukNewPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your TzKal-Zuk kill count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>104:31</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "tzkal-zuk", 104 * 60 + 31.0);
		verify(configManager).setRSProfileConfiguration("killcount", "tzkal-zuk", 2);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>104:31.20</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration("personalbest", "tzkal-zuk", 104 * 60 + 31.2);
	}

	@Test
	public void testZukKill()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your TzKal-Zuk kill count is: <col=ff0000>3</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>172:18</col>. Personal best: 134:52", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "tzkal-zuk", 134 * 60 + 52.0);
		verify(configManager).setRSProfileConfiguration("killcount", "tzkal-zuk", 3);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>172:18.40</col>. Personal best: 134:52.20", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration("personalbest", "tzkal-zuk", 134 * 60 + 52.2);
	}

	@Test
	public void testGgNewPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Fight duration: <col=ff0000>1:36</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Grotesque Guardians kill count is: <col=ff0000>179</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "grotesque guardians", 96.0);
		verify(configManager).setRSProfileConfiguration("killcount", "grotesque guardians", 179);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Fight duration: <col=ff0000>1:36.40</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Grotesque Guardians kill count is: <col=ff0000>179</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "grotesque guardians", 96.4);
	}

	@Test
	public void testGgKill()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Fight duration: <col=ff0000>2:41</col>. Personal best: 2:14", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Grotesque Guardians kill count is: <col=ff0000>32</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "grotesque guardians", 2 * 60 + 14.0);
		verify(configManager).setRSProfileConfiguration("killcount", "grotesque guardians", 32);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Fight duration: <col=ff0000>2:41.40</col>. Personal best: 2:14.20", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Grotesque Guardians kill count is: <col=ff0000>32</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "grotesque guardians", 2 * 60 + 14.2);
	}

	@Test
	public void testGauntletPersonalBest()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>10:24</col>. Personal best: 7:59.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Gauntlet completion count is: <col=ff0000>124</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "gauntlet", 124);
		verify(configManager).setRSProfileConfiguration("personalbest", "gauntlet", 7 * 60 + 59.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>10:24.20</col>. Personal best: 7:52.40.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Gauntlet completion count is: <col=ff0000>124</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "gauntlet", 7 * 60 + 52.4);
	}

	@Test
	public void testGauntletNewPersonalBest()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>10:24</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Gauntlet completion count is: <col=ff0000>124</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "gauntlet", 10 * 60 + 24.0);
		verify(configManager).setRSProfileConfiguration("killcount", "gauntlet", 124);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>10:24.40</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Gauntlet completion count is: <col=ff0000>124</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "gauntlet", 10 * 60 + 24.4);
	}

	@Test
	public void testCoXKill()
	{
		ChatMessage chatMessage = new ChatMessage(null, FRIENDSCHATNOTIFICATION, "", "<col=ef20ff>Congratulations - your raid is complete!</col><br>Team size: <col=ff0000>24+ players</col> Duration:</col> <col=ff0000>37:04.20</col> (new personal best)</col>>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Chambers of Xeric count is: <col=ff0000>51</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "chambers of xeric", 51);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric", 37 * 60 + 4.2);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric 24+ players", 37 * 60 + 4.2);
	}

	@Test
	public void testCoXKillNoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, FRIENDSCHATNOTIFICATION, "", "<col=ef20ff>Congratulations - your raid is complete!</col><br>Team size: <col=ff0000>11-15 players</col> Duration:</col> <col=ff0000>23:25.40</col> Personal best: </col><col=ff0000>20:19.20</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Chambers of Xeric count is: <col=ff0000>52</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "chambers of xeric", 52);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric", 20 * 60 + 19.2);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric 11-15 players", 20 * 60 + 19.2);
	}

	@Test
	public void testCoxCmNoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, FRIENDSCHATNOTIFICATION, "",
			"<col=ef20ff>Congratulations - your raid is complete!</col><br>Team size: <col=ff0000>3 players</col> Duration:</col> <col=ff0000>41:10</col> Personal best: </col><col=ff0000>40:03</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "",
			"Your completed Chambers of Xeric Challenge Mode count is: <col=ff0000>13</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "chambers of xeric challenge mode", 13);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric challenge mode", 40 * 60 + 3.);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric challenge mode 3 players", 40 * 60 + 3.);
	}

	@Test
	public void testPlayerSkillLookup() throws IOException
	{
		when(chatCommandsConfig.lvl()).thenReturn(true);

		HiscoreResult hiscoreResult = new HiscoreResult(PLAYER_NAME,
			ImmutableMap.of(HiscoreSkill.CHAMBERS_OF_XERIC_CHALLENGE_MODE, new Skill(10, 1000, -1)));

		when(hiscoreClient.lookup(eq(PLAYER_NAME), nullable(HiscoreEndpoint.class))).thenReturn(hiscoreResult);

		MessageNode messageNode = mock(MessageNode.class);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName(PLAYER_NAME);
		chatMessage.setMessageNode(messageNode);
		chatCommandsPlugin.playerSkillLookup(chatMessage, "!lvl cox cm");

		verify(messageNode).setRuneLiteFormatMessage("<colNORMAL>Level <colHIGHLIGHT>Chambers of Xeric: Challenge Mode: 1000<colNORMAL> Rank: <colHIGHLIGHT>10");
	}

	@Test
	public void testKillCountLookup() throws IOException
	{
		when(chatCommandsConfig.killcount()).thenReturn(true);

		when(chatClient.getKc(PLAYER_NAME, "Kalphite Queen (Echo)")).thenReturn(1);

		MessageNode messageNode = mock(MessageNode.class);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName(PLAYER_NAME);
		chatMessage.setMessageNode(messageNode);
		chatCommandsPlugin.killCountLookup(chatMessage, "!kc kq (echo)");

		verify(messageNode).setRuneLiteFormatMessage("<colHIGHLIGHT>Kalphite Queen (Echo)<colNORMAL> kill count: <colHIGHLIGHT>1");
	}

	@Test
	public void testHsFloorNoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 1 time: <col=ff0000>1:19</col>. Personal best: 0:28", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 1", 28.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 1 time: <col=ff0000>1:19.20</col>. Personal best: 0:28.40", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 1", 28.4);
	}

	@Test
	public void testHsFloorPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 2 time: <col=ff0000>0:47</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 2", 47.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 2 time: <col=ff0000>0:47.20</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 2", 47.2);
	}

	@Test
	public void testHsOverallPb_Pb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>4:46</col> (new personal best)<br>Overall time: <col=ff0000>9:53</col> (new personal best)<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 4 * 60 + 46.0);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 9 * 60 + 53.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>4:46.20</col> (new personal best)<br>Overall time: <col=ff0000>9:53.40</col> (new personal best)<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 4 * 60 + 46.2);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 9 * 60 + 53.4);
	}

	@Test
	public void testHsOverallPb_NoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>3:26</col> (new personal best)<br>Overall time: <col=ff0000>9:17</col>. Personal best: 9:15<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 3 * 60 + 26.0);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 9 * 60 + 15.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>3:26.20</col> (new personal best)<br>Overall time: <col=ff0000>9:17.00</col>. Personal best: 9:15.40<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 3 * 60 + 26.2);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 9 * 60 + 15.4);
	}

	@Test
	public void testHsOverallNoPb_NoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>3:56</col>. Personal best: 3:05<br>Overall time: <col=ff0000>9:14</col>. Personal best: 7:49<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 3 * 60 + 5.0);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 7 * 60 + 49.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>3:56.40</col>. Personal best: 3:05.20<br>Overall time: <col=ff0000>9:14.20</col>. Personal best: 7:49.20<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 3 * 60 + 5.2);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 7 * 60 + 49.2);
	}

	@Test
	public void testHsOverallNoPb_Pb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>3:10</col>. Personal best: 3:04<br>Overall time: <col=ff0000>7:47</col> (new personal best)<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 3 * 60 + 4.0);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 7 * 60 + 47.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Floor 5 time: <col=ff0000>3:10.00</col>. Personal best: 3:04.40<br>Overall time: <col=ff0000>7:47.20</col> (new personal best)<br>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre floor 5", 3 * 60 + 4.4);
		verify(configManager).setRSProfileConfiguration("personalbest", "hallowed sepulchre", 7 * 60 + 47.2);
	}

	@Test
	public void testHsFloorKc()
	{
		testKillCountChatMessage("hallowed sepulchre floor 5", "You have completed Floor 5 of the Hallowed Sepulchre! Total completions: <col=ff0000>1,114</col>.", 1114);
	}

	@Test
	public void testHsGhcKc()
	{
		testKillCountChatMessage("hallowed sepulchre", "You have opened the Grand Hallowed Coffin <col=ff0000>1,542</col> times!", 1542);
	}

	@Test
	public void testJadNewPbWithLeagueTask()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your TzTok-Jad kill count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Congratulations, you've completed a master task: <col=7f3700>Complete the Fight Caves in 25:00</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>21:58</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "tztok-jad", 21 * 60 + 58.0);
		verify(configManager).setRSProfileConfiguration("killcount", "tztok-jad", 2);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Duration: <col=ff0000>21:58.40</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "tztok-jad", 21 * 60 + 58.4);
	}

	@Test
	public void testJadChallengeNewPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completion count for TzHaar-Ket-Rak's First Challenge is: <col=ff0000>1</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>1:46</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "TzHaar-Ket-Rak's First Challenge".toLowerCase(), 1);
		verify(configManager).setRSProfileConfiguration("personalbest", "TzHaar-Ket-Rak's First Challenge".toLowerCase(), 60 + 46.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>1:46.40</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "TzHaar-Ket-Rak's First Challenge".toLowerCase(), 60 + 46.4);
	}

	@Test
	public void testJadChallengeNoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completion count for TzHaar-Ket-Rak's First Challenge is: <col=ff0000>3</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>1:10</col>. Personal best: <col=ff0000>0:59</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "TzHaar-Ket-Rak's First Challenge".toLowerCase(), 3);
		verify(configManager).setRSProfileConfiguration("personalbest", "TzHaar-Ket-Rak's First Challenge".toLowerCase(), 59.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge duration: <col=ff0000>1:10.00</col>. Personal best: <col=ff0000>0:59.20</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "TzHaar-Ket-Rak's First Challenge".toLowerCase(), 59.2);
	}

	@Test
	public void testTemporossNewPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Subdued in <col=ef1020>6:35</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Tempoross kill count is: <col=ff0000>60</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "tempoross", 60);
		verify(configManager).setRSProfileConfiguration("personalbest", "tempoross", 6 * 60 + 35.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Subdued in <col=ef1020>5:20.60</col> (new personal best).", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Tempoross kill count is: <col=ff0000>60</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "tempoross", 5 * 60 + 20.6);
	}

	@Test
	public void testTemporossNoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Subdued in <col=ef1020>7:40</col>. Personal best: 5:38.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Tempoross kill count is: <col=ff0000>55</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "tempoross", 55);
		verify(configManager).setRSProfileConfiguration("personalbest", "tempoross", 5 * 60 + 38.0);

		// Precise times
		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Subdued in <col=ef1020>6:19.80</col>. Personal best: 5:42.60.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Tempoross kill count is: <col=ff0000>55</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("personalbest", "tempoross", 5 * 60 + 42.6);
	}

	@Test
	public void testNightmarePb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Nightmare kill count is: <col=ff0000>1130</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Team size: <col=ff0000>5 players</col> Fight duration: <col=ff0000>3:28</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "nightmare", 1130);
		verify(configManager).setRSProfileConfiguration("personalbest", "nightmare", 3 * 60 + 28.0);
	}

	@Test
	public void testNightmareNoPb()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Nightmare kill count is: <col=ff0000>1,130</col>", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Team size: <col=ff0000>Solo</col> Fight duration: <col=ff0000>10:47</col>. Personal best: 8:44", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "nightmare", 1130);
		verify(configManager).setRSProfileConfiguration("personalbest", "nightmare", 8 * 60 + 44.0);
	}

	@Test
	public void testPlayerPetList()
	{
		Widget logEntryHeaderWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.COLLECTION_LOG_ENTRY_HEADER)).thenReturn(logEntryHeaderWidget);

		Widget[] logEntryHeaderItemsWidget = new Widget[1];
		when(logEntryHeaderWidget.getChildren()).thenReturn(logEntryHeaderItemsWidget);

		Widget logEntryHeaderTitleWidget = mock(Widget.class);
		when(logEntryHeaderWidget.getChild(ChatCommandsPlugin.COL_LOG_ENTRY_HEADER_TITLE_INDEX))
			.thenReturn(logEntryHeaderTitleWidget);
		when(logEntryHeaderTitleWidget.getText()).thenReturn("All Pets");

		Widget logEntryItemsWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.COLLECTION_LOG_ENTRY_ITEMS)).thenReturn(logEntryItemsWidget);

		Widget[] logPetEntriesWidget = new Widget[3];
		for (int i = 0; i < 3; i++)
		{
			logPetEntriesWidget[i] = mock(Widget.class);
			when(logPetEntriesWidget[i].getOpacity()).thenReturn(175);
		}

		when(logPetEntriesWidget[1].getOpacity()).thenReturn(0);
		when(logPetEntriesWidget[1].getItemId()).thenReturn(ItemID.IKKLE_HYDRA);

		when(logEntryItemsWidget.getChildren()).thenReturn(logPetEntriesWidget);

		ScriptPostFired scriptPostFired = new ScriptPostFired(ScriptID.COLLECTION_DRAW_LIST);
		chatCommandsPlugin.onScriptPostFired(scriptPostFired);

		chatCommandsPlugin.onGameTick(new GameTick());

		verify(configManager).setRSProfileConfiguration("chatcommands", "pets2", gson.toJson(new int[]{ItemID.IKKLE_HYDRA}));
	}

	@Test
	public void testEmptyPlayerPetList()
	{
		Widget logEntryHeaderWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.COLLECTION_LOG_ENTRY_HEADER)).thenReturn(logEntryHeaderWidget);

		Widget[] logEntryHeaderItemsWidget = new Widget[1];
		when(logEntryHeaderWidget.getChildren()).thenReturn(logEntryHeaderItemsWidget);

		Widget logEntryHeaderTitleWidget = mock(Widget.class);
		when(logEntryHeaderWidget.getChild(ChatCommandsPlugin.COL_LOG_ENTRY_HEADER_TITLE_INDEX))
			.thenReturn(logEntryHeaderTitleWidget);
		when(logEntryHeaderTitleWidget.getText()).thenReturn("All Pets");

		Widget logEntryItemsWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.COLLECTION_LOG_ENTRY_ITEMS)).thenReturn(logEntryItemsWidget);

		Widget[] logPetEntriesWidget = new Widget[3];
		for (int i = 0; i < 3; i++)
		{
			logPetEntriesWidget[i] = mock(Widget.class);
			when(logPetEntriesWidget[i].getOpacity()).thenReturn(175);
		}

		when(logEntryItemsWidget.getChildren()).thenReturn(logPetEntriesWidget);

		ScriptPostFired scriptPostFired = new ScriptPostFired(ScriptID.COLLECTION_DRAW_LIST);
		chatCommandsPlugin.onScriptPostFired(scriptPostFired);

		chatCommandsPlugin.onGameTick(new GameTick());

		verify(configManager).setRSProfileConfiguration("chatcommands", "pets2", gson.toJson(new int[0]));
	}

	@Test
	public void testUpdatePlayerPetList()
	{
		Widget logEntryHeaderWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.COLLECTION_LOG_ENTRY_HEADER)).thenReturn(logEntryHeaderWidget);

		Widget[] logEntryHeaderItemsWidget = new Widget[1];
		when(logEntryHeaderWidget.getChildren()).thenReturn(logEntryHeaderItemsWidget);

		Widget logEntryHeaderTitleWidget = mock(Widget.class);
		when(logEntryHeaderWidget.getChild(ChatCommandsPlugin.COL_LOG_ENTRY_HEADER_TITLE_INDEX))
			.thenReturn(logEntryHeaderTitleWidget);
		when(logEntryHeaderTitleWidget.getText()).thenReturn("All Pets");

		Widget logEntryItemsWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.COLLECTION_LOG_ENTRY_ITEMS)).thenReturn(logEntryItemsWidget);

		Widget[] logPetEntriesWidget = new Widget[3];
		for (int i = 0; i < 3; i++)
		{
			logPetEntriesWidget[i] = mock(Widget.class);
			when(logPetEntriesWidget[i].getOpacity()).thenReturn(175);
		}

		when(logPetEntriesWidget[1].getOpacity()).thenReturn(0);
		when(logPetEntriesWidget[1].getItemId()).thenReturn(ItemID.IKKLE_HYDRA);

		when(logEntryItemsWidget.getChildren()).thenReturn(logPetEntriesWidget);

		ScriptPostFired scriptPostFired = new ScriptPostFired(ScriptID.COLLECTION_DRAW_LIST);
		chatCommandsPlugin.onScriptPostFired(scriptPostFired);

		chatCommandsPlugin.onGameTick(new GameTick());

		verify(configManager).setRSProfileConfiguration("chatcommands", "pets2", gson.toJson(new int[]{ItemID.IKKLE_HYDRA}));

		// chompy chick item
		ItemComposition chompy = mock(ItemComposition.class);
		when(chompy.getId()).thenReturn(ItemID.CHOMPY_CHICK);
		when(chompy.getName()).thenReturn("Chompy chick");
		when(itemManager.getItemComposition(ItemID.CHOMPY_CHICK)).thenReturn(chompy);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setMessage("New item added to your collection log: Chompy chick");
		chatMessage.setType(GAMEMESSAGE);
		when(configManager.getRSProfileConfiguration("chatcommands", "pets2",
			String.class)).thenReturn(gson.toJson(new int[]{ItemID.IKKLE_HYDRA}));
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("chatcommands", "pets2", gson.toJson(new int[]{ItemID.IKKLE_HYDRA, ItemID.CHOMPY_CHICK}));
	}

	@Test
	public void testTimeStringToSeconds()
	{
		final double DELTA = 0.0001;

		// ss
		assertEquals(55.0, ChatCommandsPlugin.timeStringToSeconds("55.00"), DELTA);
		// mm:ss
		assertEquals(6 * 60 + 55.4, ChatCommandsPlugin.timeStringToSeconds("6:55.40"), DELTA);
		// h:mm:ss
		assertEquals(2 * 3600 + 50 * 60 + 30.2, ChatCommandsPlugin.timeStringToSeconds("2:50:30.20"), DELTA);
	}

	@Test
	public void testSecondsToTimeString()
	{
		assertEquals("0:03.60", ChatCommandsPlugin.secondsToTimeString(3.6));
		assertEquals("0:03", ChatCommandsPlugin.secondsToTimeString(3));
		assertEquals("1:23:45.60", ChatCommandsPlugin.secondsToTimeString(5025.6));
		assertEquals("8:00:00", ChatCommandsPlugin.secondsToTimeString(60 * 60 * 8));
	}

	@Test
	public void testCounters()
	{
		final String[] log = {
			"Chompy Hunting",
			"Kills: <col=ffffff>1,003</col>",
			"Rank: <col=ffffff>Ogre Expert</col>",
			"",
			"Order of the White Knights",
			"Rank: <col=ffffff>Master</col>",
			"with a kill score of <col=ffffff>1,300</col>",
			"",
			"TzHaar Fight Cave",
			"Fastest run: <col=ffffff>33:53</col>",
			"",
			"Inferno",
			"Fastest run: <col=ffffff>2:02:20</col>",
			"",
			"Zulrah",
			"Fastest kill: <col=ffffff>0:47</col>",
			"",
			"Vorkath",
			"Fastest kill: <col=ffffff>1:04</col>",
			"",
			"Galvek",
			"Fastest kill: <col=ffffff>-</col>",
			"",
			"Grotesque Guardians",
			"Fastest kill: <col=ffffff>1:20</col>",
			"",
			"Alchemical Hydra",
			"Fastest kill: <col=ffffff>1:34</col>",
			"",
			"Hespori",
			"Fastest kill: <col=ffffff>1:24</col>",
			"",
			// Nightmare is here 3x!
			"Nightmare", // including one only called "Nightmare"
			"Fastest kill: <col=ffffff>-</col>", // with no time
			"",
			"The Nightmare",
			"Fastest kill - (Team size: 6+ players): <col=ffffff>3:22</col>",
			"",
			"The Nightmare",
			"Fastest kill - (Team size: 6+ players): <col=ffffff>3:22</col>",
			"",
			"Phosani's Nightmare",
			"Fastest kill: <col=ffffff>-</col>",
			"",
			"The Gauntlet",
			"Fastest run: <col=ffffff>-</col>",
			"",
			"The Corrupted Gauntlet",
			"Fastest run: <col=ffffff>-</col>",
			"",
			"Fragment of Seren",
			"Fastest kill: <col=ffffff>-</col>",
			"",
			"Chambers of Xeric",
			"Fastest run - (Team size: Solo): <col=ffffff>28:07</col>",
			"Fastest run - (Team size: 2 players): <col=ffffff>24:40</col>",
			"Fastest run - (Team size: 3 players): <col=ffffff>25:35</col>",
			"Fastest run - (Team size: 4 players): <col=ffffff>22:40</col>",
			"Fastest run - (Team size: 5 players): <col=ffffff>23:00</col>",
			"Fastest run - (Team size: 6 players): <col=ffffff>28:11</col>",
			"",
			"Chambers of Xeric - Challenge mode",
			"Fastest run - (Team size: 3 players): <col=ffffff>45:41</col>",
			"",
			"Theatre of Blood",
			"Fastest Room time (former): <col=ffffff>18:45</col>",
			"Fastest Wave time (former): <col=ffffff>22:01</col>",
			"Fastest Room time - (Team size: (1 player): <col=ffffff>1:01:57.00</col>",
			"Fastest Overall time - (Team size: 1 player): <col=ffffff>1:06:40.20</col>",
			"Fastest Room time - (Team size: (2 player): <col=ffffff>22:43.80</col>",
			"Fastest Overall time - (Team size: 2 player): <col=ffffff>27:36.60</col>",
			"Fastest Room time - (Team size: (3 player): <col=ffffff>19:50</col>",
			"Fastest Overall time - (Team size: 3 player): <col=ffffff>22:47</col>",
			"Fastest Room time - (Team size: (4 player): <col=ffffff>17:38</col>",
			"Fastest Overall time - (Team size: 4 player): <col=ffffff>20:31</col>",
			"Fastest Room time - (Team size: (5 player): <col=ffffff>18:45</col>",
			"Fastest Overall time - (Team size: 5 player): <col=ffffff>22:01</col>",
			"",
			"Tombs of Amascut - Entry",
			"Fastest Room time - (Team size: Solo): <col=ffffff>32:53</col>",
			"Fastest Overall time - (Team size: Solo): <col=ffffff>39:06</col>",
			"Fastest Room time - (Team size: (2 player): <col=ffffff>25:44</col>",
			"Fastest Overall time - (Team size: (2 player): <col=ffffff>34:36</col>",
			"Fastest Room time - (Team size: (3 player): <col=ffffff>28:32</col>",
			"Fastest Overall time - (Team size: (3 player): <col=ffffff>36:31</col>",
			"Fastest Room time - (Team size: (4 player): <col=ffffff>27:52</col>",
			"Fastest Overall time - (Team size: (4 player): <col=ffffff>49:06</col>",
			"Fastest Room time - (Team size: (5 player): <col=ffffff>39:38</col>",
			"Fastest Overall time - (Team size: (5 player): <col=ffffff>1:12:08</col>",
			"",
			"Tombs of Amascut",
			"Fastest Room time - (Team size: Solo): <col=ffffff>25:35</col>",
			"Fastest Overall time - (Team size: Solo): <col=ffffff>28:44</col>",
			"Fastest Room time - (Team size: (2 player): <col=ffffff>22:02</col>",
			"Fastest Overall time - (Team size: (2 player): <col=ffffff>24:23</col>",
			"Fastest Room time - (Team size: (3 player): <col=ffffff>25:25</col>",
			"Fastest Overall time - (Team size: (3 player): <col=ffffff>29:37</col>",
			"Fastest Room time - (Team size: (4 player): <col=ffffff>23:11</col>",
			"Fastest Overall time - (Team size: (4 player): <col=ffffff>27:26</col>",
			"Fastest Room time - (Team size: (5 player): <col=ffffff>30:36</col>",
			"Fastest Overall time - (Team size: (5 player): <col=ffffff>34:44</col>",
			"Fastest Room time - (Team size: (6 player): <col=ffffff>29:19</col>",
			"Fastest Overall time - (Team size: (6 player): <col=ffffff>33:54</col>",
			"Fastest Room time - (Team size: (7 player): <col=ffffff>25:27</col>",
			"Fastest Overall time - (Team size: (7 player): <col=ffffff>28:49</col>",
			"Fastest Room time - (Team size: (8 player): <col=ffffff>24:55</col>",
			"Fastest Overall time - (Team size: (8 player): <col=ffffff>28:04</col>",
			"",
			"Tombs of Amascut - Expert",
			"Fastest Room time - (Team size: Solo): <col=ffffff>37:43</col>",
			"Fastest Overall time - (Team size: Solo): <col=ffffff>46:19</col>",
			"Fastest Room time - (Team size: (2 player): <col=ffffff>28:53</col>",
			"Fastest Overall time - (Team size: (2 player): <col=ffffff>32:38</col>",
			"Fastest Room time - (Team size: (3 player): <col=ffffff>28:20</col>",
			"Fastest Overall time - (Team size: (3 player): <col=ffffff>31:40</col>",
			"Fastest Room time - (Team size: (4 player): <col=ffffff>29:04</col>",
			"Fastest Overall time - (Team size: (4 player): <col=ffffff>32:26</col>",
			"Fastest Room time - (Team size: (5 player): <col=ffffff>26:49</col>",
			"Fastest Overall time - (Team size: (5 player): <col=ffffff>30:07</col>",
			"Fastest Room time - (Team size: (6 player): <col=ffffff>23:14</col>",
			"Fastest Overall time - (Team size: (6 player): <col=ffffff>26:13</col>",
			"Fastest Room time - (Team size: (7 player): <col=ffffff>23:42</col>",
			"Fastest Overall time - (Team size: (7 player): <col=ffffff>26:58</col>",
			"Fastest Room time - (Team size: (8 player): <col=ffffff>23:07</col>",
			"Fastest Overall time - (Team size: (8 player): <col=ffffff>26:18</col>",
			"",
			"Tempoross",
			"Fastest run: <col=ffffff>3:54</col>",
			"",
			"Barbarian Assault",
			"High-level gambles: <col=ffffff>0</col>",
			"",
			"Fremennik spirits rested: <col=ffffff>0</col>",
		};

		// adv log
		Widget advLogWidget = mock(Widget.class);
		Widget advLogExploitsTextWidget = mock(Widget.class);
		when(advLogWidget.getChild(ChatCommandsPlugin.ADV_LOG_EXPLOITS_TEXT_INDEX)).thenReturn(advLogExploitsTextWidget);
		when(advLogExploitsTextWidget.getText()).thenReturn("The Exploits of " + PLAYER_NAME);
		when(client.getWidget(ComponentID.ADVENTURE_LOG_CONTAINER)).thenReturn(advLogWidget);

		// counters
		when(client.getWidget(ComponentID.ACHIEVEMENT_DIARY_SCROLL_TEXT)).thenAnswer(a ->
		{
			Widget widget = mock(Widget.class);
			Widget[] children = Arrays.stream(log)
				.map(s ->
				{
					Widget w = mock(Widget.class);
					when(w.getText()).thenReturn(s);
					return w;
				})
				.toArray(Widget[]::new);
			when(widget.getStaticChildren()).thenReturn(children);
			return widget;
		});

		WidgetLoaded advLogEvent = new WidgetLoaded();
		advLogEvent.setGroupId(InterfaceID.ADVENTURE_LOG);
		chatCommandsPlugin.onWidgetLoaded(advLogEvent);
		chatCommandsPlugin.onGameTick(new GameTick());

		WidgetLoaded countersLogEvent = new WidgetLoaded();
		countersLogEvent.setGroupId(InterfaceID.ACHIEVEMENT_DIARY_SCROLL);
		chatCommandsPlugin.onWidgetLoaded(countersLogEvent);
		chatCommandsPlugin.onGameTick(new GameTick());

		verify(configManager).setRSProfileConfiguration("personalbest", "tztok-jad", 2033.0);
		verify(configManager).setRSProfileConfiguration("personalbest", "tempoross", 234.0);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric solo", 60 * 28 + 7.);
		verify(configManager).setRSProfileConfiguration("personalbest", "chambers of xeric 2 players", 60 * 24 + 40.);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood solo", 3600 + 60 + 57.);
		verify(configManager).setRSProfileConfiguration("personalbest", "theatre of blood 3 players", 19 * 60 + 50.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut entry mode solo", 32 * 60 + 53.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut entry mode 2 players", 25 * 60 + 44.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut solo", 25 * 60 + 35.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut 8 players", 24 * 60 + 55.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut expert mode solo", 37 * 60 + 43.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut expert mode 4 players", 29 * 60 + 4.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut expert mode 8 players", 23 * 60 + 7.);
	}

	@Test
	public void testGuardiansOfTheRift()
	{
		testKillCountChatMessage("guardians of the rift", "Amount of rifts you have closed: <col=ff0000>1,627</col>.", 1627);
	}

	@Test
	public void testBirdsEgg()
	{
		testKillCountChatMessage("bird's egg offerings", "You have made <col=ff0000>one</col> offering.", 1);
		testKillCountChatMessage("bird's egg offerings", "You have made <col=ff0000>420</col> offerings.", 420);
		testKillCountChatMessage("bird's egg offerings", "You have made <col=ff0000>10,000</col> offerings.", 10_000);
	}

	@Test
	public void testBrimstoneChest()
	{
		testKillCountChatMessage("brimstone chest", "You have opened the Brimstone chest 0 times.", 0);
		testKillCountChatMessage("brimstone chest", "You have opened the Brimstone chest once.", 1);
		testKillCountChatMessage("brimstone chest", "You have opened the Brimstone chest 2 times.", 2);
		testKillCountChatMessage("brimstone chest", "You have opened the Brimstone chest 1,234 times.", 1234);
	}

	@Test
	public void testLarransChests()
	{
		testKillCountChatMessage("larran's small chest", "You have opened Larran's small chest 0 times.", 0);
		testKillCountChatMessage("larran's small chest", "You have opened Larran's small chest once.", 1);
		testKillCountChatMessage("larran's small chest", "You have opened Larran's small chest 2 times.", 2);

		testKillCountChatMessage("larran's big chest", "You have opened Larran's big chest 0 times.", 0);
		testKillCountChatMessage("larran's big chest", "You have opened Larran's big chest once.", 1);
		testKillCountChatMessage("larran's big chest", "You have opened Larran's big chest 26,644 times.", 26644);
	}

	@Test
	public void testCrystalChest()
	{
		testKillCountChatMessage("crystal chest", "You have never opened the crystal chest.", 0);
		testKillCountChatMessage("crystal chest", "You have opened the crystal chest once.", 1);
		testKillCountChatMessage("crystal chest", "You have opened the crystal chest 172 times.", 172);
		testKillCountChatMessage("crystal chest", "You have opened the crystal chest 2,015 times.", 2015);
	}

	@Test
	public void testHunterRumours()
	{
		testKillCountChatMessage("hunter rumours", "You have completed <col=ff3045>77</col> rumours for the Hunter Guild.", 77);
		// single kc has no s.
		testKillCountChatMessage("hunter rumours", "You have completed <col=ff3045>1</col> rumour for the Hunter Guild.", 1);
		// opaque chatbox has different color
		testKillCountChatMessage("hunter rumours", "You have completed <col=e00a19>2</col> rumours for the Hunter Guild.", 2);
		// with comma in number
		testKillCountChatMessage("hunter rumours", "You have completed <col=ff3045>1,032</col> rumours for the Hunter Guild.", 1032);
	}

	@Test
	public void testReward()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your reward is: <col=ff0000>1</col> x <col=ff0000>Kebab</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager, never()).setRSProfileConfiguration(anyString(), anyString(), anyInt());
	}

	@Test
	public void testToaKc()
	{
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Tombs of Amascut: Expert Mode count is: <col=ff0000>1</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Tombs of Amascut count is: <col=ff0000>2</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Tombs of Amascut: Entry Mode count is: <col=ff0000>3</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "tombs of amascut expert mode", 1);
		verify(configManager).setRSProfileConfiguration("killcount", "tombs of amascut", 2);
		verify(configManager).setRSProfileConfiguration("killcount", "tombs of amascut entry mode", 3);
	}

	@Test
	public void testToaPbNew()
	{
		when(client.getVarbitValue(Varbits.TOA_MEMBER_1_HEALTH)).thenReturn(27);
		when(client.getVarbitValue(Varbits.TOA_MEMBER_2_HEALTH)).thenReturn(30);
		when(client.getVarbitValue(Varbits.TOA_MEMBER_3_HEALTH)).thenReturn(20);
		when(client.getVarbitValue(Varbits.TOA_MEMBER_4_HEALTH)).thenReturn(13);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge complete: The Wardens. Duration: <col=ef1020>8:30</col><br>Tombs of Amascut challenge completion time: <col=ef1020>8:31</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Tombs of Amascut total completion time: <col=ef1020>0:01</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Tombs of Amascut count is: <col=ff0000>1</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "tombs of amascut", 1);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut", 8 * 60 + 31.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut 4 players", 8 * 60 + 31.);
	}

	@Test
	public void testToaPb()
	{
		when(client.getVarbitValue(Varbits.TOA_MEMBER_1_HEALTH)).thenReturn(24);
		when(client.getVarbitValue(Varbits.TOA_MEMBER_2_HEALTH)).thenReturn(15);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge complete: The Wardens. Duration: <col=ef1020>9:40</col><br>Tombs of Amascut: Expert Mode challenge completion time: <col=ef1020>9:40</col>. Personal best: 8:31", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Tombs of Amascut total completion time: <col=ef1020>0:01</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Tombs of Amascut: Expert Mode count is: <col=ff0000>1</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "tombs of amascut expert mode", 1);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut expert mode", 8 * 60 + 31.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut expert mode 2 players", 8 * 60 + 31.);
	}

	@Test
	public void testToaPbEntry()
	{
		when(client.getVarbitValue(Varbits.TOA_MEMBER_1_HEALTH)).thenReturn(24);
		when(client.getVarbitValue(Varbits.TOA_MEMBER_2_HEALTH)).thenReturn(15);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Challenge complete: The Wardens. Duration: <col=ef1020>9:40</col><br>Tombs of Amascut: Entry Mode challenge completion time: <col=ef1020>9:40</col>. Personal best: 20:31", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Tombs of Amascut total completion time: <col=ef1020>0:01</col> (new personal best)", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your completed Tombs of Amascut: Entry Mode count is: <col=ff0000>9</col>.", null, 0);
		chatCommandsPlugin.onChatMessage(chatMessage);

		verify(configManager).setRSProfileConfiguration("killcount", "tombs of amascut entry mode", 9);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut entry mode", 20 * 60 + 31.);
		verify(configManager).setRSProfileConfiguration("personalbest", "tombs of amascut entry mode 2 players", 20 * 60 + 31.);
	}

	private void testKillCountChatMessage(String key, String message, int kc)
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", message, null, 0);
		chatCommandsPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration("killcount", key, kc);
	}
}
