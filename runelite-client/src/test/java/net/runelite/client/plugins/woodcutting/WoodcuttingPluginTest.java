/*
 * Copyright (c) 2020, Jordan Zomerlei <https://github.com/JZomerlei>
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
package net.runelite.client.plugins.woodcutting;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.plugins.woodcutting.config.ClueNestTier;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WoodcuttingPluginTest
{
	private static final String BIRDS_NEST_MESSAGE = "A bird's nest falls out of the tree.";

	@Inject
	WoodcuttingPlugin woodcuttingPlugin;

	@Mock
	@Bind
	WoodcuttingConfig woodcuttingConfig;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	WoodcuttingOverlay woodcuttingOverlay;

	@Mock
	@Bind
	WoodcuttingTreesOverlay woodcuttingTreesOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testLogs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get some logs.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testOakLogs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get some oak logs.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testArcticLogs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get an arctic log.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testMushrooms()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You get some mushrooms.", "", 0);
		woodcuttingPlugin.onChatMessage(chatMessage);
		assertNotNull(woodcuttingPlugin.getSession());
	}

	@Test
	public void testBirdsNest()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);
		woodcuttingPlugin.onChatMessage(chatMessage);
		verify(notifier).notify("A bird nest has spawned!");

		when(woodcuttingConfig.showNestNotification()).thenReturn(false);
		woodcuttingPlugin.onChatMessage(chatMessage);
		verifyNoMoreInteractions(notifier);
	}

	@Test
	public void testClueNestConfigSameAsSpawn()
	{
		ChatMessage nestChatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);
		Tile tile = mock(Tile.class);
		TileItem beginnerTileItem = mock(TileItem.class);
		when(beginnerTileItem.getId()).thenReturn(ItemID.CLUE_NEST_BEGINNER);
		ItemSpawned beginnerClueSpawned = new ItemSpawned(tile, beginnerTileItem);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);
		when(woodcuttingConfig.clueNestNotifyTier()).thenReturn(ClueNestTier.BEGINNER);
		woodcuttingPlugin.onItemSpawned(beginnerClueSpawned);
		woodcuttingPlugin.onChatMessage(nestChatMessage);
		woodcuttingPlugin.onGameTick(null);
		verify(notifier).notify("A bird nest has spawned!");
	}

	@Test
	public void testClueNestConfigSmallerThanSpawn()
	{
		ChatMessage nestChatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);
		Tile tile = mock(Tile.class);
		TileItem eliteTileItem = mock(TileItem.class);
		when(eliteTileItem.getId()).thenReturn(ItemID.CLUE_NEST_ELITE);
		ItemSpawned eliteClueSpawned = new ItemSpawned(tile, eliteTileItem);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);
		when(woodcuttingConfig.clueNestNotifyTier()).thenReturn(ClueNestTier.BEGINNER);
		woodcuttingPlugin.onItemSpawned(eliteClueSpawned);
		woodcuttingPlugin.onChatMessage(nestChatMessage);
		woodcuttingPlugin.onGameTick(null);
		verify(notifier).notify("A bird nest has spawned!");
	}

	@Test
	public void testClueNestDisabledConfig()
	{
		ChatMessage nestChatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);
		Tile tile = mock(Tile.class);
		TileItem eliteTileItem = mock(TileItem.class);
		when(eliteTileItem.getId()).thenReturn(ItemID.CLUE_NEST_ELITE);
		ItemSpawned eliteClueSpawned = new ItemSpawned(tile, eliteTileItem);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);
		when(woodcuttingConfig.clueNestNotifyTier()).thenReturn(ClueNestTier.DISABLED);
		woodcuttingPlugin.onItemSpawned(eliteClueSpawned);
		woodcuttingPlugin.onChatMessage(nestChatMessage);
		woodcuttingPlugin.onGameTick(null);
		verifyNoInteractions(notifier);
	}

	@Test
	public void testClueNestConfigLargerThanSpawn()
	{
		ChatMessage nestChatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);
		Tile tile = mock(Tile.class);
		TileItem beginnerTileItem = mock(TileItem.class);
		when(beginnerTileItem.getId()).thenReturn(ItemID.CLUE_NEST_BEGINNER);
		ItemSpawned beginnerClueSpawned = new ItemSpawned(tile, beginnerTileItem);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);
		when(woodcuttingConfig.clueNestNotifyTier()).thenReturn(ClueNestTier.HARD);
		woodcuttingPlugin.onItemSpawned(beginnerClueSpawned);
		woodcuttingPlugin.onChatMessage(nestChatMessage);
		woodcuttingPlugin.onGameTick(null);
		verifyNoInteractions(notifier);
	}

	@Test
	public void testClueNestPlayerDrop()
	{
		ChatMessage nestChatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);
		Tile tile = mock(Tile.class);
		TileItem beginnerTileItem = mock(TileItem.class);
		when(beginnerTileItem.getId()).thenReturn(ItemID.CLUE_NEST_BEGINNER);
		ItemSpawned beginnerClueSpawned = new ItemSpawned(tile, beginnerTileItem);
		TileItem nestTileItem = mock(TileItem.class);
		when(nestTileItem.getId()).thenReturn(ItemID.BIRD_NEST_22798);
		ItemSpawned regularNestSpawned = new ItemSpawned(tile, nestTileItem);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);

		// Player drops clue nest
		woodcuttingPlugin.onItemSpawned(beginnerClueSpawned);
		woodcuttingPlugin.onGameTick(null);
		verifyNoInteractions(notifier);
		// A regular nest has spawned
		woodcuttingPlugin.onItemSpawned(regularNestSpawned);
		woodcuttingPlugin.onChatMessage(nestChatMessage);
		woodcuttingPlugin.onGameTick(null);
		verify(notifier).notify("A bird nest has spawned!");
	}

	@Test
	public void testClueNestOtherItemSpawn()
	{
		ChatMessage nestChatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BIRDS_NEST_MESSAGE, "", 0);
		Tile tile = mock(Tile.class);
		TileItem beginnerTileItem = mock(TileItem.class);
		when(beginnerTileItem.getId()).thenReturn(ItemID.CLUE_NEST_BEGINNER);
		ItemSpawned beginnerClueSpawned = new ItemSpawned(tile, beginnerTileItem);
		TileItem anotherItemTileItem = mock(TileItem.class);
		ItemSpawned anotherItemSpawned = new ItemSpawned(tile, anotherItemTileItem);

		when(woodcuttingConfig.showNestNotification()).thenReturn(true);
		when(woodcuttingConfig.clueNestNotifyTier()).thenReturn(ClueNestTier.BEGINNER);

		woodcuttingPlugin.onItemSpawned(beginnerClueSpawned);
		woodcuttingPlugin.onItemSpawned(anotherItemSpawned);

		woodcuttingPlugin.onChatMessage(nestChatMessage);
		woodcuttingPlugin.onGameTick(null);
		verify(notifier).notify("A bird nest has spawned!");
	}
}