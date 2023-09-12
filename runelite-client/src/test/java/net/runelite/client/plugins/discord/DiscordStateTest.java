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
package net.runelite.client.plugins.discord;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import javax.inject.Named;
import net.runelite.api.Client;
import net.runelite.client.discord.DiscordPresence;
import net.runelite.client.discord.DiscordService;
import net.runelite.client.party.PartyService;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiscordStateTest
{
	@Inject
	DiscordState discordState;

	@Mock
	@Bind
	DiscordConfig discordConfig;

	@Mock
	@Bind
	DiscordService discordService;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	PartyService partyService;

	@Bind
	@Named("runelite.title")
	private String runeliteTitle = "RuneLite";

	@Bind
	@Named("runelite.version")
	private String runeliteVersion = "version";

	@Bind
	@Named("safeMode")
	private boolean safeMode = false;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testStatusReset()
	{
		when(discordConfig.actionTimeout()).thenReturn(-1);
		when(discordConfig.elapsedTimeType()).thenReturn(DiscordConfig.ElapsedTimeType.ACTIVITY);

		discordState.triggerEvent(DiscordGameEventType.IN_MENU);
		verify(discordService).updatePresence(any(DiscordPresence.class)); // menu presence

		discordState.checkForTimeout();

		// menu is not clearable and so no changes will be made
		verifyNoMoreInteractions(discordService);
	}

	@Test
	public void testStatusTimeout()
	{
		when(discordConfig.actionTimeout()).thenReturn(-1);
		when(discordConfig.elapsedTimeType()).thenReturn(DiscordConfig.ElapsedTimeType.ACTIVITY);

		discordState.triggerEvent(DiscordGameEventType.TRAINING_AGILITY);
		verify(discordService).updatePresence(any(DiscordPresence.class));

		discordState.checkForTimeout();
		verify(discordService, times(1)).clearPresence();
	}

	@Test
	public void testAreaChange()
	{
		when(discordConfig.elapsedTimeType()).thenReturn(DiscordConfig.ElapsedTimeType.TOTAL);

		// Start with state of IN_GAME
		ArgumentCaptor<DiscordPresence> captor = ArgumentCaptor.forClass(DiscordPresence.class);
		discordState.triggerEvent(DiscordGameEventType.IN_GAME);
		verify(discordService, times(1)).updatePresence(captor.capture());
		assertEquals(DiscordGameEventType.IN_GAME.getState(), captor.getValue().getState());

		// IN_GAME -> CITY
		discordState.triggerEvent(DiscordGameEventType.CITY_VARROCK);
		verify(discordService, times(2)).updatePresence(captor.capture());
		assertEquals(DiscordGameEventType.CITY_VARROCK.getState(), captor.getValue().getState());

		// CITY -> IN_GAME
		discordState.triggerEvent(DiscordGameEventType.IN_GAME);
		verify(discordService, times(3)).updatePresence(captor.capture());
		assertEquals(DiscordGameEventType.IN_GAME.getState(), captor.getValue().getState());
	}
}
