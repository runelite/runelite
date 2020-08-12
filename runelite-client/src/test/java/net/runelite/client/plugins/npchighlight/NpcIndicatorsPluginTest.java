/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.npchighlight;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NpcIndicatorsPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ScheduledExecutorService executorService;

	@Mock
	@Bind
	private NpcIndicatorsConfig npcIndicatorsConfig;

	@Inject
	private NpcIndicatorsPlugin npcIndicatorsPlugin;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void getHighlights()
	{
		when(npcIndicatorsConfig.getNpcToHighlight()).thenReturn("goblin, , zulrah   , *wyvern, ,");
		final List<String> highlightedNpcs = npcIndicatorsPlugin.getHighlights();
		assertEquals("Length of parsed NPCs is incorrect", 3, highlightedNpcs.size());

		final Iterator<String> iterator = highlightedNpcs.iterator();
		assertEquals("goblin", iterator.next());
		assertEquals("zulrah", iterator.next());
		assertEquals("*wyvern", iterator.next());
	}

	@Test
	public void testDeadNpcMenuHighlight()
	{
		when(npcIndicatorsConfig.getNpcToHighlight()).thenReturn("goblin");
		when(npcIndicatorsConfig.deadNpcMenuColor()).thenReturn(Color.RED);

		npcIndicatorsPlugin.rebuildAllNpcs();

		NPC npc = mock(NPC.class);
		when(npc.getName()).thenReturn("Goblin");
		when(npc.isDead()).thenReturn(true);
		npcIndicatorsPlugin.onNpcSpawned(new NpcSpawned(npc));

		when(client.getCachedNPCs()).thenReturn(new NPC[]{npc}); // id 0

		when(client.getMenuEntries()).thenReturn(new MenuEntry[]{new MenuEntry()});
		MenuEntryAdded menuEntryAdded = new MenuEntryAdded("", "Goblin", MenuAction.NPC_FIRST_OPTION.getId(), 0, -1, -1);
		npcIndicatorsPlugin.onMenuEntryAdded(menuEntryAdded);

		MenuEntry target = new MenuEntry();
		target.setTarget("<col=ff0000>Goblin"); // red
		verify(client).setMenuEntries(new MenuEntry[]{target});
	}

	@Test
	public void testAliveNpcMenuHighlight()
	{
		when(npcIndicatorsConfig.getNpcToHighlight()).thenReturn("goblin");
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(true);
		when(npcIndicatorsConfig.getHighlightColor()).thenReturn(Color.BLUE);

		npcIndicatorsPlugin.rebuildAllNpcs();

		NPC npc = mock(NPC.class);
		when(npc.getName()).thenReturn("Goblin");
		npcIndicatorsPlugin.onNpcSpawned(new NpcSpawned(npc));

		when(client.getCachedNPCs()).thenReturn(new NPC[]{npc}); // id 0

		when(client.getMenuEntries()).thenReturn(new MenuEntry[]{new MenuEntry()});
		MenuEntryAdded menuEntryAdded = new MenuEntryAdded("", "Goblin", MenuAction.NPC_FIRST_OPTION.getId(), 0, -1, -1);
		npcIndicatorsPlugin.onMenuEntryAdded(menuEntryAdded);

		MenuEntry target = new MenuEntry();
		target.setTarget("<col=0000ff>Goblin"); // blue
		verify(client).setMenuEntries(new MenuEntry[]{target});
	}
}
