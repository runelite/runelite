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
package net.runelite.client.plugins.timersandbuffs;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Predicate;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.RSTimeUnit;
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
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class TimersAndBuffsPluginTest
{
	@Inject
	private TimersAndBuffsPlugin timersAndBuffsPlugin;

	@Mock
	@Bind
	private TimersAndBuffsConfig timersAndBuffsConfig;

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
	public void removeTimersOnConfigChanged()
	{
		timersAndBuffsPlugin = spy(timersAndBuffsPlugin);
		final ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(TimersAndBuffsConfig.GROUP);

		timersAndBuffsPlugin.onConfigChanged(configChanged);

		for (GameTimer timer : GameTimer.values())
		{
			verify(timersAndBuffsPlugin).removeGameTimer(timer);
		}
	}

	@Test
	public void testDivineRanging()
	{
		when(timersAndBuffsConfig.showDivine()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.DIVINE_RANGING);
		varbitChanged.setValue(500);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DIVINE_RANGING, infoBox.getTimer());
	}

	@Test
	public void testDivineBastion()
	{
		when(timersAndBuffsConfig.showDivine()).thenReturn(true);

		VarbitChanged rangingVarbitChanged = new VarbitChanged();
		rangingVarbitChanged.setVarbitId(Varbits.DIVINE_RANGING);
		rangingVarbitChanged.setValue(500);
		timersAndBuffsPlugin.onVarbitChanged(rangingVarbitChanged);
		when(client.getVarbitValue(Varbits.DIVINE_RANGING)).thenReturn(500);

		VarbitChanged superDefenceVarbitChanged = new VarbitChanged();
		superDefenceVarbitChanged.setVarbitId(Varbits.DIVINE_SUPER_DEFENCE);
		superDefenceVarbitChanged.setValue(500);
		timersAndBuffsPlugin.onVarbitChanged(superDefenceVarbitChanged);
		when(client.getVarbitValue(Varbits.DIVINE_SUPER_DEFENCE)).thenReturn(500);

		VarbitChanged bastionVarbitChanged = new VarbitChanged();
		bastionVarbitChanged.setVarbitId(Varbits.DIVINE_BASTION);
		bastionVarbitChanged.setValue(500);
		timersAndBuffsPlugin.onVarbitChanged(bastionVarbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager, times(3)).addInfoBox(captor.capture());
		List<InfoBox> infoBoxes = captor.getAllValues();

		ArgumentCaptor<Predicate<InfoBox>> prcaptor = ArgumentCaptor.forClass(Predicate.class);
		verify(infoBoxManager, times(6)).removeIf(prcaptor.capture());
		List<Predicate<InfoBox>> filters = prcaptor.getAllValues();

		// test defence, ranging, and bastion infoboxes added
		assertEquals(((TimerTimer) infoBoxes.get(0)).getTimer(), GameTimer.DIVINE_RANGING);
		assertEquals(((TimerTimer) infoBoxes.get(1)).getTimer(), GameTimer.DIVINE_SUPER_DEFENCE);
		assertEquals(((TimerTimer) infoBoxes.get(2)).getTimer(), GameTimer.DIVINE_BASTION);

		// test ranging and defence infoboxes removed
		assertTrue(filters.get(0).test(infoBoxes.get(0)));  // divine ranging infobox added
		// filters.get(1) tries to remove a non-existent moonlight potion timer since Varbits.DIVINE_SUPER_DEFENCE
		// was changed
		assertTrue(filters.get(2).test(infoBoxes.get(1)));  // divine super defence infobox added
		assertTrue(filters.get(3).test(infoBoxes.get(0)));  // divine ranging infobox removed
		assertTrue(filters.get(4).test(infoBoxes.get(1)));  // divine super defence infobox removed
		assertTrue(filters.get(5).test(infoBoxes.get(2)));  // divine bastion infobox added
	}

	@Test
	public void testDivineRangingAfterBastion()
	{
		when(timersAndBuffsConfig.showDivine()).thenReturn(true);
		when(client.getVarbitValue(Varbits.DIVINE_BASTION)).thenReturn(400);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.DIVINE_RANGING);
		varbitChanged.setValue(500);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.DIVINE_RANGING, infoBox.getTimer());
	}

	@Test
	public void testStamina()
	{
		when(timersAndBuffsConfig.showStamina()).thenReturn(true);
		when(client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE)).thenReturn(1);
		when(client.getVarbitValue(Varbits.STAMINA_EFFECT)).thenReturn(20);
		when(client.getVarbitValue(Varbits.RING_OF_ENDURANCE_EFFECT)).thenReturn(0);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.RUN_SLOWED_DEPLETION_ACTIVE); // just has to be one of the vars
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.STAMINA, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(2), infoBox.getDuration());
	}

	@Test
	public void testSireStunTimer()
	{
		when(timersAndBuffsConfig.showAbyssalSireStun()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "The Sire has been disorientated temporarily.", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.ABYSSAL_SIRE_STUN, infoBox.getTimer());
		assertEquals(Duration.ofSeconds(30), infoBox.getDuration());
	}

	@Test
	public void testEndurance()
	{
		when(timersAndBuffsConfig.showStamina()).thenReturn(true);
		when(client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE)).thenReturn(1);
		when(client.getVarbitValue(Varbits.STAMINA_EFFECT)).thenReturn(20);
		when(client.getVarbitValue(Varbits.RING_OF_ENDURANCE_EFFECT)).thenReturn(20);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.RUN_SLOWED_DEPLETION_ACTIVE); // just has to be one of the vars
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.STAMINA, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(4), infoBox.getDuration());

		// unwield ring
		when(client.getVarbitValue(Varbits.RING_OF_ENDURANCE_EFFECT)).thenReturn(0);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);
		int mins = (int) infoBox.getDuration().toMinutes();
		assertEquals(2, mins);
	}

	@Test
	public void testTzhaarTimer()
	{
		when(timersAndBuffsConfig.showTzhaarTimers()).thenReturn(true);
		when(client.getMapRegions()).thenReturn(new int[]{TimersAndBuffsPlugin.FIGHT_CAVES_REGION_ID});

		class InstantRef
		{
			Instant i;
		}

		InstantRef startTime = new InstantRef();
		when(timersAndBuffsConfig.tzhaarStartTime()).then(a -> startTime.i);
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			startTime.i = (Instant) argument;
			return null;
		}).when(timersAndBuffsConfig).tzhaarStartTime(nullable(Instant.class));

		InstantRef lastTime = new InstantRef();
		when(timersAndBuffsConfig.tzhaarLastTime()).then(a -> lastTime.i);
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			lastTime.i = (Instant) argument;
			return null;
		}).when(timersAndBuffsConfig).tzhaarLastTime(nullable(Instant.class));

		// test timer creation: verify the infobox was added and that it is an ElapsedTimer
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>Wave: 1</col>", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);
		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager, times(1)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);

		// test timer pause: verify the added ElapsedTimer has a non-null lastTime
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>The Inferno has been paused. You may now log out.", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, times(1)).removeInfoBox(captor.capture());
		verify(infoBoxManager, times(2)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);
		ElapsedTimer timer = (ElapsedTimer) captor.getValue();
		assertNotEquals(timer.getLastTime(), null);
		Instant oldTime = ((ElapsedTimer) captor.getValue()).getStartTime();

		// test timer unpause: verify the last time is null after being unpaused
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>Wave: 2</col>", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);
		verify(infoBoxManager, times(2)).removeInfoBox(captor.capture());
		verify(infoBoxManager, times(3)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);
		timer = (ElapsedTimer) captor.getValue();
		assertNull(timer.getLastTime());

		// test timer remove: verify the infobox was removed (and no more were added)
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "You have been defeated!", "", 0);
		final GameStateChanged gameStateChanged = new GameStateChanged();
		gameStateChanged.setGameState(GameState.LOADING);
		when(client.getMapRegions()).thenReturn(new int[0]);
		timersAndBuffsPlugin.onChatMessage(chatMessage);
		timersAndBuffsPlugin.onGameStateChanged(gameStateChanged);
		verify(infoBoxManager, times(3)).removeInfoBox(captor.capture());
		verify(infoBoxManager, times(3)).addInfoBox(captor.capture());
	}

	@Test
	public void testInfernoTimerStartOffset()
	{
		when(timersAndBuffsConfig.showTzhaarTimers()).thenReturn(true);
		when(client.getMapRegions()).thenReturn(new int[]{TimersAndBuffsPlugin.INFERNO_REGION_ID});

		class InstantRef
		{
			Instant i;
		}

		InstantRef startTime = new InstantRef();
		when(timersAndBuffsConfig.tzhaarStartTime()).then(a -> startTime.i);
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			startTime.i = (Instant) argument;
			return null;
		}).when(timersAndBuffsConfig).tzhaarStartTime(nullable(Instant.class));

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>Wave: 1</col>", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager, times(1)).addInfoBox(captor.capture());
		assertTrue(captor.getValue() instanceof ElapsedTimer);
		ElapsedTimer timer = (ElapsedTimer) captor.getValue();
		assertEquals("00:06", timer.getText());
	}

	// region Arceuus spells
	@Test
	public void testDeathChargeCast()
	{
		when(timersAndBuffsConfig.showArceuus()).thenReturn(true);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(50);
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.DEATH_CHARGE);
		varbitChanged.setValue(1);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> ibcaptor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(ibcaptor.capture());
		TimerTimer infoBox = (TimerTimer) ibcaptor.getValue();
		assertEquals(GameTimer.DEATH_CHARGE, infoBox.getTimer());
		assertEquals(Duration.of(50, RSTimeUnit.GAME_TICKS), infoBox.getDuration());
	}

	@Test
	public void testDeathChargeCooldown()
	{
		when(timersAndBuffsConfig.showArceuusCooldown()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.DEATH_CHARGE_COOLDOWN);
		varbitChanged.setValue(1);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> ibcaptor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(ibcaptor.capture());
		TimerTimer infoBox = (TimerTimer) ibcaptor.getValue();
		assertEquals(GameTimer.DEATH_CHARGE_COOLDOWN, infoBox.getTimer());
	}

	@Test
	public void testArceuusWard()
	{
		when(timersAndBuffsConfig.showArceuus()).thenReturn(true);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(57);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=0000b2>Your defence against Arceuus magic has been strengthened.</col>", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.WARD_OF_ARCEUUS, infoBox.getTimer());
		assertEquals(Duration.of(57, RSTimeUnit.GAME_TICKS), infoBox.getDuration());
	}

	@Test
	public void testArceuusWardCooldown()
	{
		when(timersAndBuffsConfig.showArceuusCooldown()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.WARD_OF_ARCEUUS_COOLDOWN);
		varbitChanged.setValue(1);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.WARD_OF_ARCEUUS_COOLDOWN, infoBox.getTimer());
	}

	@Test
	public void testCorruptionCooldown()
	{
		when(timersAndBuffsConfig.showArceuusCooldown()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.CORRUPTION_COOLDOWN);
		varbitChanged.setValue(1);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.CORRUPTION_COOLDOWN, infoBox.getTimer());
	}

	@Test
	public void testShadowVeil()
	{
		when(timersAndBuffsConfig.showArceuus()).thenReturn(true);
		when(client.getRealSkillLevel(Skill.MAGIC)).thenReturn(57);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=6800bf>Your thieving abilities have been enhanced.</col>", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.SHADOW_VEIL, infoBox.getTimer());
	}

	@Test
	public void testShadowVeilCooldown()
	{
		when(timersAndBuffsConfig.showArceuusCooldown()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.SHADOW_VEIL_COOLDOWN);
		varbitChanged.setValue(1);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.SHADOW_VEIL_COOLDOWN, infoBox.getTimer());
	}

	@Test
	public void testThrall()
	{
		when(timersAndBuffsConfig.showArceuus()).thenReturn(true);
		when(client.getBoostedSkillLevel(Skill.MAGIC)).thenReturn(60);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef0083>You resurrect a greater zombified thrall.</col>", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> ibcaptor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(ibcaptor.capture());
		TimerTimer infoBox = (TimerTimer) ibcaptor.getValue();
		assertEquals(GameTimer.RESURRECT_THRALL, infoBox.getTimer());
		assertEquals(Duration.of(60, RSTimeUnit.GAME_TICKS), infoBox.getDuration());
	}

	@Test
	public void testThrallCooldown()
	{
		when(timersAndBuffsConfig.showArceuusCooldown()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.RESURRECT_THRALL_COOLDOWN);
		varbitChanged.setValue(1);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> ibcaptor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(ibcaptor.capture());
		TimerTimer infoBox = (TimerTimer) ibcaptor.getValue();
		assertEquals(GameTimer.RESURRECT_THRALL_COOLDOWN, infoBox.getTimer());
	}
	// endregion

	@Test
	public void testImbuedHeartStart()
	{
		when(timersAndBuffsConfig.showImbuedHeart()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.IMBUED_HEART_COOLDOWN);
		varbitChanged.setValue(70);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.IMBUEDHEART, infoBox.getTimer());
		assertEquals(Duration.ofMinutes(7), infoBox.getDuration());
	}

	@Test
	public void testImbuedHeartEnd()
	{
		when(timersAndBuffsConfig.showImbuedHeart()).thenReturn(true);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.IMBUED_HEART_COOLDOWN);
		varbitChanged.setValue(70);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged); // Calls removeIf once (on createGameTimer)

		ArgumentCaptor<Predicate<InfoBox>> prcaptor = ArgumentCaptor.forClass(Predicate.class);
		TimerTimer imbuedHeartInfoBox = new TimerTimer(GameTimer.IMBUEDHEART, Duration.ofSeconds(420), timersAndBuffsPlugin);
		verify(infoBoxManager, times (1)).addInfoBox(any());
		verify(infoBoxManager, times(1)).removeIf(prcaptor.capture());
		Predicate<InfoBox> pred = prcaptor.getValue();
		assertTrue(pred.test(imbuedHeartInfoBox));

		varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.IMBUED_HEART_COOLDOWN);
		varbitChanged.setValue(0);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged); // Calls removeIf once

		verify(infoBoxManager, times(1)).addInfoBox(any());
		verify(infoBoxManager, times(2)).removeIf(prcaptor.capture());
		pred = prcaptor.getValue();
		assertTrue(pred.test(imbuedHeartInfoBox));
	}

	@Test
	public void testMartinPickpocket()
	{
		when(timersAndBuffsConfig.showPickpocketStun()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You fail to pick Martin's pocket.", "", 0);
		timersAndBuffsPlugin.onChatMessage(chatMessage);

		ArgumentCaptor<InfoBox> captor = ArgumentCaptor.forClass(InfoBox.class);
		verify(infoBoxManager).addInfoBox(captor.capture());
		TimerTimer infoBox = (TimerTimer) captor.getValue();
		assertEquals(GameTimer.PICKPOCKET_STUN, infoBox.getTimer());
		assertEquals(Duration.ofSeconds(5), infoBox.getDuration());
	}

	@Test
	public void testCoXOverload()
	{
		when(timersAndBuffsConfig.showOverload()).thenReturn(true);
		ArgumentCaptor<Predicate<InfoBox>> prcaptor = ArgumentCaptor.forClass(Predicate.class);

		when(client.getVarbitValue(Varbits.IN_RAID)).thenReturn(1);
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.COX_OVERLOAD_REFRESHES_REMAINING);
		varbitChanged.setValue(15);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		TimerTimer overloadInfobox = new TimerTimer(GameTimer.OVERLOAD_RAID, Duration.ofSeconds(225), timersAndBuffsPlugin);
		verify(infoBoxManager).addInfoBox(any());
		verify(infoBoxManager).removeIf(prcaptor.capture());
		Predicate<InfoBox> pred = prcaptor.getValue();
		assertTrue(pred.test(overloadInfobox));

		// Remove on running out
		varbitChanged.setValue(0);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		verify(infoBoxManager).addInfoBox(any());
		verify(infoBoxManager, times(2)).removeIf(any());
	}

	@Test
	public void testNMZOverload()
	{
		when(timersAndBuffsConfig.showOverload()).thenReturn(true);
		ArgumentCaptor<Predicate<InfoBox>> prcaptor = ArgumentCaptor.forClass(Predicate.class);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(Varbits.NMZ_OVERLOAD_REFRESHES_REMAINING);
		varbitChanged.setValue(9);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		TimerTimer overloadInfobox = new TimerTimer(GameTimer.OVERLOAD, Duration.ofSeconds(135), timersAndBuffsPlugin);
		verify(infoBoxManager).addInfoBox(any());
		verify(infoBoxManager).removeIf(prcaptor.capture());
		Predicate<InfoBox> pred = prcaptor.getValue();
		assertTrue(pred.test(overloadInfobox));

		// Remove on running out
		varbitChanged.setValue(0);
		timersAndBuffsPlugin.onVarbitChanged(varbitChanged);

		verify(infoBoxManager).addInfoBox(any());
		verify(infoBoxManager, times(2)).removeIf(any());
	}
}
