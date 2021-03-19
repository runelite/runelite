/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.timers;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.time.Duration;
import java.time.Instant;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.StatChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class TimersPluginTest
{
	@Inject
	private TimersPlugin timersPlugin;

	@Mock
	@Bind
	private TimersConfig timersConfig;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private SpriteManager spriteManager;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testHalfTeleblock()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 2 minutes, 30 seconds.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.TELEBLOCK, infoBox.getTimer());
		assertEquals(Duration.ofSeconds(2 * 60 + 30), infoBox.getDuration());
	}

	@Test
	public void testFullTeleblock()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 5 minutes.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.TELEBLOCK, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(5), infoBox.getDuration());
	}

	@Test
	public void testDmmHalfTb()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 1 minute, 15 seconds.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.TELEBLOCK, infoBox.getTimer());
		assertEquals(Duration.ofSeconds(60 + 15), infoBox.getDuration());
	}

	@Test
	public void testDmmFullTb()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=4f006f>A Tele Block spell has been cast on you by Runelite. It will expire in 2 minutes, 30 seconds.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.TELEBLOCK, infoBox.getTimer());
		assertEquals(Duration.ofSeconds(60 * 2 + 30), infoBox.getDuration());
	}

	@Test
	public void testDivineBastion()
	{
		when(timersConfig.showDivine()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your divine bastion potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DIVINE_BASTION, infoBox.getTimer());
	}

	@Test
	public void testDivineBattlemage()
	{
		when(timersConfig.showDivine()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your divine battlemage potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DIVINE_BATTLEMAGE, infoBox.getTimer());
	}

	@Test
	public void testTransparentChatboxTb()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=c356ef>A Tele Block spell has been cast on you by Alexsuperfly. It will expire in 5 minutes.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.TELEBLOCK, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(5), infoBox.getDuration());
	}

	@Test
	public void testTransparentChatboxTbRemoved()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=c356ef>Your Tele Block has been removed because you killed Alexsuperfly.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		verify(infoBoxManager, atLeastOnce()).removeIf(any());
	}

	@Test
	public void testMageArena2TbFull()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=c356ef>A Tele Block spell has been cast on you. It will expire in 2 minutes.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.TELEBLOCK, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(2), infoBox.getDuration());
	}

	@Test
	public void testMageArena2TbHalf()
	{
		when(timersConfig.showTeleblock()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "<col=c356ef>A Tele Block spell has been cast on you. It will expire in 1 minute.</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.TELEBLOCK, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(1), infoBox.getDuration());
	}

	@Test
	public void testStamina()
	{
		when(timersConfig.showStamina()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your stamina potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.STAMINA, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(2), infoBox.getDuration());
	}

	@Test
	public void testSireStunTimer()
	{
		when(timersConfig.showAbyssalSireStun()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "The Sire has been disorientated temporarily.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.ABYSSAL_SIRE_STUN, infoBox.getTimer());
		assertEquals(Duration.ofSeconds(30), infoBox.getDuration());
	}

	@Test
	public void testEndurance()
	{
		when(timersConfig.showStamina()).thenReturn(true);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "Your Ring of endurance doubles the duration of your stamina potion's effect.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You drink some of your stamina potion.", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.STAMINA, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(4), infoBox.getDuration());

		// unwield ring
		timersPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.EQUIPMENT.getId(), mock(ItemContainer.class)));
		// some time has elapsed in the test; this should be just under 2 mins
		int mins = (int) infoBox.getDuration().toMinutes();
		assertTrue(mins == 1 || mins == 2);
	}

	@Test
	public void testTzhaarTimer()
	{
		when(timersConfig.showTzhaarTimers()).thenReturn(true);
		when(client.getMapRegions()).thenReturn(new int[]{TimersPlugin.FIGHT_CAVES_REGION_ID});

		class InstantRef
		{
			Instant i;
		}

		InstantRef startTime = new InstantRef();
		when(timersConfig.tzhaarStartTime()).then(a -> startTime.i);
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			startTime.i = (Instant) argument;
			return null;
		}).when(timersConfig).tzhaarStartTime(nullable(Instant.class));

		InstantRef lastTime = new InstantRef();
		when(timersConfig.tzhaarLastTime()).then(a -> lastTime.i);
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			lastTime.i = (Instant) argument;
			return null;
		}).when(timersConfig).tzhaarLastTime(nullable(Instant.class));

		// test timer creation: verify the infobox was added and that it is an ElapsedTimer
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>Wave: 1</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);
		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager, times(1)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);

		// test timer pause: verify the added ElapsedTimer has a non-null lastTime
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "",  "<col=ef1020>The Inferno has been paused. You may now log out.", "", 0);
		timersPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, times(1)).removeInfoBox(captor.capture());
		verify(infoBoxManager, times(2)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);
		ElapsedTimer timer = (ElapsedTimer) captor.getValue();
		assertNotEquals(timer.getLastTime(), null);
		Instant oldTime = ((ElapsedTimer) captor.getValue()).getStartTime();

		// test timer unpause: verify the last time is null after being unpaused
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "",  "<col=ef1020>Wave: 2</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, times(2)).removeInfoBox(captor.capture());
		verify(infoBoxManager, times(3)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);
		timer = (ElapsedTimer) captor.getValue();
		assertNull(timer.getLastTime());

		// test timer remove: verify the infobox was removed (and no more were added)
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "",  "You have been defeated!", "", 0);
		timersPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, times(3)).removeInfoBox(captor.capture());
		verify(infoBoxManager, times(3)).addInfoBox(captor.capture());
	}

	@Test
	public void testInfernoTimerStartOffset()
	{
		when(timersConfig.showTzhaarTimers()).thenReturn(true);
		when(client.getMapRegions()).thenReturn(new int[]{TimersPlugin.INFERNO_REGION_ID});

		class InstantRef
		{
			Instant i;
		}

		InstantRef startTime = new InstantRef();
		when(timersConfig.tzhaarStartTime()).then(a -> startTime.i);
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			startTime.i = (Instant) argument;
			return null;
		}).when(timersConfig).tzhaarStartTime(nullable(Instant.class));

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>Wave: 1</col>", "", 0);
		timersPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager, times(1)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);
		ElapsedTimer timer = (ElapsedTimer) captor.getValue();
		assertEquals("00:06", timer.getText());
	}

	@Test
	public void testImbuedHeartBoost()
	{
		when(timersConfig.showImbuedHeart()).thenReturn(true);
		when(client.getTickCount()).thenReturn(100);
		StatChanged event;

		final MenuOptionClicked imbuedHeartClick = new MenuOptionClicked();
		imbuedHeartClick.setMenuOption("Invigorate");
		imbuedHeartClick.setId(ItemID.IMBUED_HEART);
		timersPlugin.onMenuOptionClicked(imbuedHeartClick);

		when(client.getTickCount()).thenReturn(101);

		for (int level = 1, i = 0; level <= Experience.MAX_REAL_LEVEL; level++, i++)
		{
			event = new StatChanged(Skill.MAGIC, 0, level, heartBoostedLevel(level));
			timersPlugin.onStatChanged(event);

			ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
			verify(infoBoxManager, times(i + 1)).addInfoBox(captor.capture());
			TimerTimer infoBox = (TimerTimer) captor.getValue();
			assertEquals(GameTimer.IMBUEDHEART, infoBox.getTimer());
		}
	}

	@Test
	public void testImbuedHeartBoostFromDrained()
	{
		when(timersConfig.showImbuedHeart()).thenReturn(true);
		when(client.getTickCount()).thenReturn(100);

		final MenuOptionClicked imbuedHeartClick = new MenuOptionClicked();
		imbuedHeartClick.setMenuOption("Invigorate");
		imbuedHeartClick.setId(ItemID.IMBUED_HEART);
		timersPlugin.onMenuOptionClicked(imbuedHeartClick);

		when(client.getTickCount()).thenReturn(101);

		for (int level = 1, i = 0; level <= Experience.MAX_REAL_LEVEL; level++, i++)
		{
			timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, level, level - 1));
			timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, level, heartBoostedLevel(level) - 1));

			ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
			verify(infoBoxManager, times(i + 1)).addInfoBox(captor.capture());
			TimerTimer infoBox = (TimerTimer) captor.getValue();
			assertEquals(GameTimer.IMBUEDHEART, infoBox.getTimer());
		}
	}

	@Test
	public void testImbuedHeartBoostFromPartialBoost()
	{
		when(timersConfig.showImbuedHeart()).thenReturn(true);
		when(client.getTickCount()).thenReturn(100);

		final MenuOptionClicked imbuedHeartClick = new MenuOptionClicked();
		imbuedHeartClick.setMenuOption("Invigorate");
		imbuedHeartClick.setId(ItemID.IMBUED_HEART);
		timersPlugin.onMenuOptionClicked(imbuedHeartClick);

		when(client.getTickCount()).thenReturn(101);

		for (int level = 10, i = 0; level <= Experience.MAX_REAL_LEVEL; level++, i++)
		{
			timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, level, level + 1));
			timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, level, heartBoostedLevel(level)));

			ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
			verify(infoBoxManager, times(i + 1)).addInfoBox(captor.capture());
			TimerTimer infoBox = (TimerTimer) captor.getValue();
			assertEquals(GameTimer.IMBUEDHEART, infoBox.getTimer());
		}
	}

	@Test
	public void testNonImbuedHeartBoost()
	{
		lenient().when(timersConfig.showImbuedHeart()).thenReturn(true);
		timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, 1, 1));

		// Simulate stat changes of imbued heart boost amount without having clicked the imbued heart
		timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, 29, 34)); // equal to magic essence
		timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, 39, 43)); // equal to magic potion
		timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, 49, 54)); // equal to spicy stew
		timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, 99, 109));

		verifyNoInteractions(infoBoxManager);
	}

	@Test
	public void testMagicLevelDrain()
	{
		lenient().when(timersConfig.showImbuedHeart()).thenReturn(true);
		timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, 1, 1));
		when(client.getTickCount()).thenReturn(100);

		final MenuOptionClicked imbuedHeartClick = new MenuOptionClicked();
		imbuedHeartClick.setMenuOption("Invigorate");
		imbuedHeartClick.setId(ItemID.IMBUED_HEART);
		timersPlugin.onMenuOptionClicked(imbuedHeartClick);

		when(client.getTickCount()).thenReturn(101);

		// Simulate stat changes draining to the imbued heart boost amount
		for (int level = 1; level <= Experience.MAX_REAL_LEVEL; level++)
		{
			timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, level, level));
			timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, level, heartBoostedLevel(level) + 1));
			timersPlugin.onStatChanged(new StatChanged(Skill.MAGIC, 0, level, heartBoostedLevel(level)));
		}

		verifyNoInteractions(infoBoxManager);
	}

	private static int heartBoostedLevel(final int level)
	{
		return level + 1 + (level / 10);
	}
}
