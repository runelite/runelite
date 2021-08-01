/*
 * Copyright (c) 2021 FatFingers23
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
package net.runelite.client.plugins.npcunaggroarea;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.slayer.Task;
import net.runelite.client.plugins.slayer.events.SlayerTaskEndsEvent;
import net.runelite.client.plugins.slayer.events.SlayerTaskIsSetEvent;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NpcAggroAreaPluginTest
{

	private static final String NPC_NAME_PATTERNS_FROM_CONFIG = "Moss Giant, Iron Dragon";

	private static final List<String> NPC_NAME_PATTERNS_ARRAY = Arrays.asList("Moss Giant", "Iron Dragon");

	private static final List<String> EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS = Arrays.asList("*fossil island wyvern*", "*ancient wyvern*", "*long-tailed wyvern*", "*spitting wyvern*", "*taloned wyvern*");

	@Inject
	private NpcAggroAreaPlugin npcAggroAreaPlugin;

	@Bind
	@Mock
	private Client client;

	@Bind
	@Mock
	private NpcAggroAreaConfig config;

	@Bind
	@Mock
	private OverlayManager overlayManager;

	@Bind
	@Mock
	private ItemManager itemManager;

	@Bind
	@Mock
	private InfoBoxManager infoBoxManager;

	@Bind
	@Mock
	private ConfigManager configManager;

	@Bind
	@Mock
	private Notifier notifier;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testNewSlayerTask() throws Exception
	{

		SlayerTaskIsSetEvent slayerTaskIsSetEventTrolls = new SlayerTaskIsSetEvent(Task.FOSSIL_ISLAND_WYVERNS);
		when(config.npcNamePatterns()).thenReturn(NPC_NAME_PATTERNS_FROM_CONFIG);
		when(config.autoShowSlayerTaskAggroTimer()).thenReturn(true);
		when(client.getCachedNPCs()).thenReturn(new NPC[]{});
		npcAggroAreaPlugin.startUp();
		npcAggroAreaPlugin.onSlayerTaskIsSetEvent(slayerTaskIsSetEventTrolls);

		List<String> npcNamePatterns = npcAggroAreaPlugin.getNpcNamePatterns();
		for (String target : EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS)
		{
			assertTrue(npcNamePatterns.contains(target));
		}
		assertTrue(npcNamePatterns.containsAll(NPC_NAME_PATTERNS_ARRAY));
	}

	@Test
	public void testNewSlayerTaskWithConfigTurnedOff() throws Exception
	{

		SlayerTaskIsSetEvent slayerTaskIsSetEventTrolls = new SlayerTaskIsSetEvent(Task.FOSSIL_ISLAND_WYVERNS);
		when(config.npcNamePatterns()).thenReturn(NPC_NAME_PATTERNS_FROM_CONFIG);
		when(config.autoShowSlayerTaskAggroTimer()).thenReturn(false);
		when(client.getCachedNPCs()).thenReturn(new NPC[]{});
		npcAggroAreaPlugin.startUp();
		npcAggroAreaPlugin.onSlayerTaskIsSetEvent(slayerTaskIsSetEventTrolls);

		List<String> npcNamePatterns = npcAggroAreaPlugin.getNpcNamePatterns();
		for (String target : EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS)
		{
			assertFalse(npcNamePatterns.contains(target));
		}
		assertTrue(npcNamePatterns.containsAll(NPC_NAME_PATTERNS_ARRAY));
	}

	@Test
	public void testAgroTurnsActiveForSlayerTask() throws Exception
	{

		SlayerTaskIsSetEvent slayerTaskIsSetEventTrolls = new SlayerTaskIsSetEvent(Task.FOSSIL_ISLAND_WYVERNS);
		when(config.npcNamePatterns()).thenReturn(NPC_NAME_PATTERNS_FROM_CONFIG);
		when(config.autoShowSlayerTaskAggroTimer()).thenReturn(true);
		when(config.alwaysActive()).thenReturn(false);

		NPC npc = mock(NPC.class);
		NPCComposition npcComposition = mock(NPCComposition.class);
		when(npcComposition.getName()).thenReturn("Ancient wyvern");
		when(npcComposition.getCombatLevel()).thenReturn(210);
		when(npc.getTransformedComposition()).thenReturn(npcComposition);
		when(client.getCachedNPCs()).thenReturn(new NPC[]{
			npc
		});

		Player player = mock(Player.class);
		when(player.getCombatLevel()).thenReturn(99);
		when(client.getLocalPlayer()).thenReturn(player);
		NpcSpawned npcSpawnedMockEvent = new NpcSpawned(npc);

		npcAggroAreaPlugin.startUp();
		npcAggroAreaPlugin.onSlayerTaskIsSetEvent(slayerTaskIsSetEventTrolls);
		assertFalse(npcAggroAreaPlugin.isActive());
		npcAggroAreaPlugin.onNpcSpawned(npcSpawnedMockEvent);
		assertTrue(npcAggroAreaPlugin.isActive());
	}

	@Test
	public void testSlayerTaskEnded() throws Exception
	{

		SlayerTaskEndsEvent slayerTaskEndsEvent = new SlayerTaskEndsEvent(Task.TROLLS);

		when(config.npcNamePatterns()).thenReturn(NPC_NAME_PATTERNS_FROM_CONFIG);
		when(client.getCachedNPCs()).thenReturn(new NPC[]{});
		npcAggroAreaPlugin.startUp();

		List<String> npcPatternAndSlayerTask = new ArrayList<>();
		npcPatternAndSlayerTask.addAll(EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS);
		npcPatternAndSlayerTask.addAll(NPC_NAME_PATTERNS_ARRAY);
		npcAggroAreaPlugin.setNpcNamePatterns(npcPatternAndSlayerTask);
		npcAggroAreaPlugin.setSlayerTaskList(EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS);


		npcAggroAreaPlugin.onSlayerTaskEndsEvent(slayerTaskEndsEvent);

		List<String> npcNamePatterns = npcAggroAreaPlugin.getNpcNamePatterns();
		for (String target : EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS)
		{
			assertFalse(npcNamePatterns.contains(target));
		}
		assertEquals(0, npcAggroAreaPlugin.getSlayerTaskList().size());
		assertTrue(npcNamePatterns.containsAll(NPC_NAME_PATTERNS_ARRAY));
	}

	@Test
	public void newSlayerTaskToReplaceOldOne() throws Exception
	{

		SlayerTaskIsSetEvent secondSlayerTaskIsSetEventTrolls = new SlayerTaskIsSetEvent(Task.TROLLS);

		when(config.npcNamePatterns()).thenReturn(NPC_NAME_PATTERNS_FROM_CONFIG);
		when(config.autoShowSlayerTaskAggroTimer()).thenReturn(true);
		when(client.getCachedNPCs()).thenReturn(new NPC[]{});
		npcAggroAreaPlugin.startUp();

		List<String> npcPatternAndSlayerTask = new ArrayList<>();
		npcPatternAndSlayerTask.addAll(EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS);
		npcPatternAndSlayerTask.addAll(NPC_NAME_PATTERNS_ARRAY);
		npcAggroAreaPlugin.setNpcNamePatterns(npcPatternAndSlayerTask);
		npcAggroAreaPlugin.setSlayerTaskList(EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS);

		npcAggroAreaPlugin.onSlayerTaskIsSetEvent(secondSlayerTaskIsSetEventTrolls);

		List<String> npcNamePatterns = npcAggroAreaPlugin.getNpcNamePatterns();
		for (String target : EXPECTED_FOSSIL_ISLAND_WYVERNS_TASK_PATTERNS)
		{
			assertFalse(npcNamePatterns.contains(target));
		}

		assertEquals(3, npcAggroAreaPlugin.getSlayerTaskList().size());
		assertTrue(npcNamePatterns.containsAll(NPC_NAME_PATTERNS_ARRAY));
	}

}
