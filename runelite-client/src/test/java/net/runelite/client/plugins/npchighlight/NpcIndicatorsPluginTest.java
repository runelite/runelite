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
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
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
	public void buildRecoloredNpcMenuEntryTarget_withCombatLevel_alive_noHighlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(false);
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Goblin<col=ff00>  (level-2)");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(false);
		when(npc.getName()).thenReturn("Goblin");
		when(npc.getCombatLevel()).thenReturn(2);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=ffff00>Goblin<col=00ff00>  (Level 2)", recoloredTarget);
	}

	@Test
	public void buildRecoloredNpcMenuEntryTarget_withCombatLevel_dead_noHighlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(false);
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Goblin<col=ff00>  (level-2)");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(true);
		when(npc.getName()).thenReturn("Goblin");
		when(npc.getCombatLevel()).thenReturn(2);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=b2b200>Goblin<col=00ff00>  (Level 2)", recoloredTarget);
	}

	@Test
	public void buildRecoloredNpcMenuEntryTarget_withCombatLevel_alive_highlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(true);
		when(npcIndicatorsConfig.getHighlightColor()).thenReturn(new Color(255, 200, 255));
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Goblin<col=ff00>  (level 2)");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(false);
		when(npc.getName()).thenReturn("Goblin");
		when(npc.getCombatLevel()).thenReturn(2);
		npcIndicatorsPlugin.highlightedNpcs.add(npc);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=ffc8ff>Goblin<col=00ff00>  (Level 2)", recoloredTarget);
	}

	@Test
	public void buildRecoloredNpcMenuEntryTarget_withCombatLevel_dead_highlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(true);
		when(npcIndicatorsConfig.getHighlightColor()).thenReturn(new Color(255, 200, 255));
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Goblin<col=ff00>  (level 2)");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(true);
		when(npc.getName()).thenReturn("Goblin");
		when(npc.getCombatLevel()).thenReturn(2);
		npcIndicatorsPlugin.highlightedNpcs.add(npc);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=b28cb2>Goblin<col=00ff00>  (Level 2)", recoloredTarget);
	}

	@Test
	public void buildRecoloredNpcMenuEntryTarget_withoutCombatLevel_alive_noHighlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(false);
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Tekton");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(false);
		when(npc.getName()).thenReturn("Tekton");
		when(npc.getCombatLevel()).thenReturn(0);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=ffff00>Tekton", recoloredTarget);
	}

	@Test
	public void buildRecoloredNpcMenuEntryTarget_withoutCombatLevel_dead_noHighlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(false);
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Tekton");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(true);
		when(npc.getName()).thenReturn("Tekton");
		when(npc.getCombatLevel()).thenReturn(0);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=b2b200>Tekton", recoloredTarget);
	}

	@Test
	public void buildRecoloredNpcMenuEntryTarget_withoutCombatLevel_alive_highlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(true);
		when(npcIndicatorsConfig.getHighlightColor()).thenReturn(new Color(255, 200, 255));
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Tekton");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(false);
		when(npc.getName()).thenReturn("Tekton");
		when(npc.getCombatLevel()).thenReturn(0);
		npcIndicatorsPlugin.highlightedNpcs.add(npc);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=ffc8ff>Tekton", recoloredTarget);
	}

	@Test
	public void buildRecoloredNpcMenuEntryTarget_withoutCombatLevel_dead_highlight()
	{
		npcIndicatorsPlugin.highlightedNpcs.clear();
		when(npcIndicatorsConfig.dampenDeadNPCs()).thenReturn(true);
		when(npcIndicatorsConfig.highlightMenuNames()).thenReturn(true);
		when(npcIndicatorsConfig.getHighlightColor()).thenReturn(new Color(255, 200, 255));
		final MenuEntry menuEntry = mock(MenuEntry.class);
		when(menuEntry.getTarget()).thenReturn("<col=ffff00>Tekton");
		final NPC npc = mock(NPC.class);
		when(npc.isDead()).thenReturn(true);
		when(npc.getName()).thenReturn("Tekton");
		when(npc.getCombatLevel()).thenReturn(0);
		npcIndicatorsPlugin.highlightedNpcs.add(npc);

		String recoloredTarget = npcIndicatorsPlugin.buildRecoloredNpcMenuEntryTarget(menuEntry, npc);
		assertEquals("<col=b28cb2>Tekton", recoloredTarget);
	}
}
