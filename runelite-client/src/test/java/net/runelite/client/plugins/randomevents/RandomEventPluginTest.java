/*
 * Copyright (c) 2023, Joshua Kuan <jkuan1997@gmail.com>
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
package net.runelite.client.plugins.randomevents;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import javax.inject.Inject;

import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.*;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.Notifier;
import net.runelite.client.menus.TestMenuEntry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class RandomEventPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private RandomEventConfig randomEventConfig;

	@Inject
	private RandomEventPlugin randomEventPlugin;

	@Mock
	private Player localPlayer;

	private MenuEntry[] entries;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(client.getLocalPlayer()).thenReturn(localPlayer);

		when(client.getMenuEntries()).thenAnswer((Answer<MenuEntry[]>) invocationOnMock ->
		{
			// The menu implementation returns a copy of the array, which causes swap() to not
			// modify the same array being iterated in onClientTick
			return Arrays.copyOf(entries, entries.length);
		});
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			entries = (MenuEntry[]) argument;
			return null;
		}).when(client).setMenuEntries(any(MenuEntry[].class));
	}

	@Test
	public void testClearsRandomEvent()
	{
		when(randomEventConfig.notifyAllEvents()).thenReturn(true);
		assertTrue(randomEventConfig.notifyAllEvents());

		final NPC npc = mock(NPC.class);
		when(npc.getId()).thenReturn(NpcID.QUIZ_MASTER_6755);
		when(npc.getName()).thenReturn("Quiz Master");
		randomEventPlugin.onInteractingChanged(new InteractingChanged(npc, localPlayer));
		assertEquals(npc, randomEventPlugin.getCurrentRandomEvent());

		randomEventPlugin.onNpcDespawned(new NpcDespawned(npc));
		assertNull(randomEventPlugin.getCurrentRandomEvent());
	}

	@Test
	public void testSetsRandomEventWhenIsPlayerRandom()
	{
		final NPC npc = mock(NPC.class);
		when(npc.getId()).thenReturn(NpcID.QUIZ_MASTER_6755);
		when(npc.getName()).thenReturn("Quiz Master");

		randomEventPlugin.onInteractingChanged(new InteractingChanged(npc, localPlayer));
		assertEquals(npc, randomEventPlugin.getCurrentRandomEvent());
	}

	@Test
	public void testIgnoreEventWhenIsNotPlayerRandom()
	{
		final NPC npc = mock(NPC.class);
		randomEventPlugin.onInteractingChanged(new InteractingChanged(npc, null));
		assertNull(randomEventPlugin.getCurrentRandomEvent());
	}

	@Test
	public void testAllowMenuOptionsWhenIsPlayerRandom()
	{
		final NPC npc = mock(NPC.class);
		when(npc.getId()).thenReturn(NpcID.SANDWICH_LADY);
		when(npc.getName()).thenReturn("Sandwich Lady");
		randomEventPlugin.onInteractingChanged(new InteractingChanged(npc, localPlayer));

		MenuEntry[] menuEntries = new MenuEntry[]{
				menu("Cancel", "", MenuAction.CANCEL, npc),
				menu("Examine", "Sandwich Lady", MenuAction.EXAMINE_NPC, npc),
				menu("Walk Here", "", MenuAction.WALK, npc),
				menu("Dismiss", "Sandwich Lady", MenuAction.NPC_FIFTH_OPTION, npc),
				menu("Talk-to", "Sandwich Lady", MenuAction.NPC_FIRST_OPTION, npc)
		};
		client.setMenuEntries(menuEntries);
		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(menuEntries, argumentCaptor.getValue());
	}

	@Test
	public void testHideMenuOptionsWhenNotPlayerRandom()
	{
		when(randomEventConfig.removeMenuOptions()).thenReturn(true);
		final NPC npc = mock(NPC.class);
		when(npc.getId()).thenReturn(NpcID.SANDWICH_LADY);
		randomEventPlugin.onInteractingChanged(new InteractingChanged(npc, null));

		MenuEntry[] menuEntries = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Sandwich Lady", MenuAction.EXAMINE_NPC, npc),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Sandwich Lady", MenuAction.NPC_FIFTH_OPTION, npc),
				menu("Talk-to", "Sandwich Lady", MenuAction.NPC_FIRST_OPTION, npc)
		};
		client.setMenuEntries(menuEntries);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client, times(3)).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Sandwich Lady", MenuAction.EXAMINE_NPC, npc),
				menu("Walk Here", MenuAction.WALK),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testKissTheFrogIsPlayerEvent()
	{
		when(randomEventConfig.removeMenuOptions()).thenReturn(true);
		when(randomEventConfig.notifyAllEvents()).thenReturn(true);
		assertTrue(randomEventConfig.notifyAllEvents());

		final ImmutableList<NPC> frogNpcs = createFrogNpcs();
		randomEventPlugin.onInteractingChanged(new InteractingChanged(frogNpcs.get(0), localPlayer));
		assertEquals(frogNpcs.get(0), randomEventPlugin.getCurrentRandomEvent());

		MenuEntry[] menuEntriesFrog5429 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(0)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_SECOND_OPTION, frogNpcs.get(0)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(0))
		};
		client.setMenuEntries(menuEntriesFrog5429);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(menuEntriesFrog5429, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5430 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(1)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_FIFTH_OPTION, frogNpcs.get(1)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(1))
		};
		client.setMenuEntries(menuEntriesFrog5430);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(2)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(menuEntriesFrog5430, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5430_2 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(2)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_FIFTH_OPTION, frogNpcs.get(2)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(2))
		};
		client.setMenuEntries(menuEntriesFrog5430_2);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(3)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(menuEntriesFrog5430_2, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5431 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(3)),
				menu("Walk Here", MenuAction.WALK),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(3))
		};
		client.setMenuEntries(menuEntriesFrog5431);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(4)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(menuEntriesFrog5431, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5432 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(4)),
				menu("Walk Here", MenuAction.WALK),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(4))
		};
		client.setMenuEntries(menuEntriesFrog5432);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(5)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(menuEntriesFrog5432, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog312 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(5)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_FIFTH_OPTION, frogNpcs.get(5)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(5))
		};
		client.setMenuEntries(menuEntriesFrog312);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(6)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(menuEntriesFrog312, argumentCaptor.getValue());
	}

	@Test
	public void testKissTheFrogIsNotPlayerEvent()
	{
		when(randomEventConfig.removeMenuOptions()).thenReturn(true);
		when(randomEventConfig.notifyAllEvents()).thenReturn(true);
		assertTrue(randomEventConfig.notifyAllEvents());

		final ImmutableList<NPC> frogNpcs = createFrogNpcs();
		randomEventPlugin.onInteractingChanged(new InteractingChanged(frogNpcs.get(0), null));
		assertNull(randomEventPlugin.getCurrentRandomEvent());

		MenuEntry[] menuEntriesFrog5429 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(0)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_SECOND_OPTION, frogNpcs.get(0)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(0))
		};
		client.setMenuEntries(menuEntriesFrog5429);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client, times(3)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(0)),
				menu("Walk Here", MenuAction.WALK)
		}, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5430 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(1)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_FIFTH_OPTION, frogNpcs.get(1)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(1))
		};
		client.setMenuEntries(menuEntriesFrog5430);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(6)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(1)),
				menu("Walk Here", MenuAction.WALK)
		}, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5430_2 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(2)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_FIFTH_OPTION, frogNpcs.get(2)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(2))
		};
		client.setMenuEntries(menuEntriesFrog5430_2);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(9)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(2)),
				menu("Walk Here", MenuAction.WALK)
		}, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5431 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(3)),
				menu("Walk Here", MenuAction.WALK),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(3))
		};
		client.setMenuEntries(menuEntriesFrog5431);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(11)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(3)),
				menu("Walk Here", MenuAction.WALK)
		}, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog5432 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(4)),
				menu("Walk Here", MenuAction.WALK),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(4))
		};
		client.setMenuEntries(menuEntriesFrog5432);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(13)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(4)),
				menu("Walk Here", MenuAction.WALK)
		}, argumentCaptor.getValue());

		MenuEntry[] menuEntriesFrog312 = new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(5)),
				menu("Walk Here", MenuAction.WALK),
				menu("Dismiss", "Frog", MenuAction.NPC_FIFTH_OPTION, frogNpcs.get(5)),
				menu("Talk-to", "Frog", MenuAction.NPC_FIRST_OPTION, frogNpcs.get(5))
		};
		client.setMenuEntries(menuEntriesFrog312);
		Arrays.stream(client.getMenuEntries()).forEach(e -> randomEventPlugin.onMenuEntryAdded(new MenuEntryAdded(e)));
		verify(client, times(16)).setMenuEntries(argumentCaptor.capture());
		assertArrayEquals(new MenuEntry[]{
				menu("Cancel", MenuAction.CANCEL),
				menu("Examine", "Frog", MenuAction.EXAMINE_NPC, frogNpcs.get(5)),
				menu("Walk Here", MenuAction.WALK)
		}, argumentCaptor.getValue());
	}

	private ImmutableList<NPC> createFrogNpcs()
	{
		final NPC frog1 = mock(NPC.class);
		when(frog1.getId()).thenReturn(NpcID.FROG_5429);

		final NPC frog2 = mock(NPC.class);
		when(frog2.getId()).thenReturn(NpcID.FROG_5430);

		final NPC frog3 = mock(NPC.class);
		when(frog3.getId()).thenReturn(NpcID.FROG_5430);

		final NPC frog4 = mock(NPC.class);
		when(frog4.getId()).thenReturn(NpcID.FROG_5431);

		final NPC frog5 = mock(NPC.class);
		when(frog5.getId()).thenReturn(NpcID.FROG_5432);

		final NPC frog6 = mock(NPC.class);
		when(frog6.getId()).thenReturn(NpcID.FROG);

		return ImmutableList.of(frog1, frog2, frog3, frog4, frog5, frog6);
	}

	private MenuEntry menu(String option, MenuAction menuAction)
	{
		return menu(option, "", menuAction, null);
	}

	private MenuEntry menu(String option, String target, MenuAction menuAction, NPC npc)
	{
		TestMenuEntry menuEntry = new TestMenuEntry();
		menuEntry.setOption(option);
		menuEntry.setTarget(target);
		menuEntry.setType(menuAction);
		menuEntry.setActor(npc);
		return menuEntry;
	}
}
