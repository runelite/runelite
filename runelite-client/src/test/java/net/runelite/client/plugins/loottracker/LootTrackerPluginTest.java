/*
 * Copyright (c) 2020, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.loottracker;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemID;
import net.runelite.api.IterableHashTable;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.account.SessionManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.loottracker.LootRecordType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LootTrackerPluginTest
{
	private static final Map<Integer, String> HERB_IDS_TO_NAMES = ImmutableMap.<Integer, String>builder()
		.put(ItemID.GRIMY_GUAM_LEAF, "Grimy guam leaf")
		.put(ItemID.GRIMY_MARRENTILL, "Grimy marrentill")
		.put(ItemID.GRIMY_TARROMIN, "Grimy tarromin")
		.put(ItemID.GRIMY_HARRALANDER, "Grimy harralander")
		.put(ItemID.GRIMY_RANARR_WEED, "Grimy ranarr weed")
		.put(ItemID.GRIMY_IRIT_LEAF, "Grimy irit leaf")
		.put(ItemID.GRIMY_AVANTOE, "Grimy avantoe")
		.put(ItemID.GRIMY_KWUARM, "Grimy kwuarm")
		.put(ItemID.GRIMY_SNAPDRAGON, "Grimy snapdragon")
		.put(ItemID.GRIMY_CADANTINE, "Grimy cadantine")
		.put(ItemID.GRIMY_LANTADYME, "Grimy lantadyme")
		.put(ItemID.GRIMY_DWARF_WEED, "Grimy dwarf weed")
		.put(ItemID.GRIMY_TORSTOL, "Grimy torstol")
		.build();

	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private SpriteManager spriteManager;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Inject
	private LootTrackerPlugin lootTrackerPlugin;

	@Mock
	@Bind
	private LootTrackerConfig lootTrackerConfig;

	@Mock
	@Bind
	private SessionManager sessionManager;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private ChatMessageManager chatMessageManager;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		Player player = mock(Player.class);
		when(player.getWorldLocation()).thenReturn(new WorldPoint(0, 0, 0));
		when(client.getLocalPlayer()).thenReturn(player);
	}

	@Test
	public void testPickPocket()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You pick the hero's pocket.", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		assertEquals("Hero", lootTrackerPlugin.eventType);
		assertEquals(LootRecordType.PICKPOCKET, lootTrackerPlugin.lootRecordType);
	}

	@Test
	public void testFirstClue()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "You have completed 1 master Treasure Trail.", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		assertEquals("Clue Scroll (Master)", lootTrackerPlugin.eventType);
		assertEquals(LootRecordType.EVENT, lootTrackerPlugin.lootRecordType);
	}

	private static ItemComposition mockItem(String name)
	{
		ItemComposition itemComposition = mock(ItemComposition.class);
		when(itemComposition.getName()).thenReturn(name);
		return itemComposition;
	}

	@Test
	public void testHerbiboarHerbSack()
	{
		for (Map.Entry<Integer, String> herb : HERB_IDS_TO_NAMES.entrySet())
		{
			final int id = herb.getKey();
			final String name = herb.getValue();
			final String herbMessage = String.format("You put the %s herb into your herb sack.", name);
			final String herbFullMessage = String.format("Your herb sack is too full to hold the %s herb.", name);

			final ItemPrice herbPrice = new ItemPrice();
			herbPrice.setId(id);
			herbPrice.setName(name);
			when(itemManager.search(name)).thenReturn(Collections.singletonList(herbPrice));

			MessageNode node = mock(MessageNode.class);
			when(node.getType()).thenReturn(ChatMessageType.SPAM);
			when(node.getValue()).thenReturn(herbMessage);

			MessageNode nodeFull = mock(MessageNode.class);
			when(nodeFull.getType()).thenReturn(ChatMessageType.SPAM);
			when(nodeFull.getValue()).thenReturn(herbFullMessage);

			IterableHashTable<MessageNode> messageTable = mock(IterableHashTable.class);
			Iterator<MessageNode> mockIterator = mock(Iterator.class);
			when(mockIterator.hasNext()).thenReturn(true, true, false);
			when(mockIterator.next()).thenReturn(node).thenReturn(nodeFull);
			when(messageTable.iterator()).thenReturn(mockIterator);
			when(client.getMessages()).thenReturn(messageTable);

			LootTrackerPlugin lootTrackerPluginSpy = spy(this.lootTrackerPlugin);
			doNothing().when(lootTrackerPluginSpy).addLoot(any(), anyInt(), any(), any(Collection.class));

			ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", LootTrackerPlugin.HERBIBOAR_LOOTED_MESSAGE, "", 0);
			lootTrackerPluginSpy.onChatMessage(chatMessage);

			verify(lootTrackerPluginSpy).addLoot("Herbiboar", -1, LootRecordType.EVENT, Arrays.asList(
				new ItemStack(id, 1, null),
				new ItemStack(id, 1, null)
			));
			// Check the event type is null, which means the plugin isn't waiting on an inventory change event
			assertNull(lootTrackerPlugin.eventType);
		}
	}

	@Test
	public void testprocessChatMessageForLoot()
	{
		final ItemPrice fake = new ItemPrice();
		fake.setId(0);
		fake.setName("");

		LootTrackerPlugin lootTrackerPluginSpy = spy(this.lootTrackerPlugin);
		doReturn(true).when(lootTrackerPluginSpy).isPlayerWithinMapRegion(LootTrackerPlugin.HALLOWED_SEPULCHRE_MAP_REGIONS);
		when(client.getLocalPlayer().getName()).thenReturn("Sketchy Pat");
		when(client.getLocalPlayer().getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(itemManager.search(anyString())).thenReturn(Collections.singletonList(fake));

		ChatMessage openedCoffinMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", LootTrackerPlugin.COFFIN_LOOTED_MESSAGE, "", 0);
		lootTrackerPluginSpy.onChatMessage(openedCoffinMessage);
		assertTrue(lootTrackerPluginSpy.coffinOpened);

		// below test case has nbsp; in username
		ChatMessage dropMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=005f00>Sketchy Pat received a drop: Monk's robe</col>", "", 0);
		ChatMessage dropMessage2 = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=005f00>Sketchy Pat received a drop: 3 x Hallowed mark</col>", "", 0);
		ChatMessage dropMessage3 = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>Untradeable drop: 8 x Hallowed mark", "", 0);
		ChatMessage dropMessage4 = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=ef1020>Valuable drop: 2 x Sanfew serum(4) (61,788 coins)</col>", "", 0);
		ChatMessage dropMessage5 = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=005f00>Sketchy Pat received a drop: 19,306 x Coins</col>", "", 0);
		ChatMessage endMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "<col=005f00>Zezima received a drop: Strange old lockpick (full)</col>", "", 0);

		// The coffin should "remain open" as long as plugin is successfully processing loot messages
		lootTrackerPluginSpy.onChatMessage(dropMessage);
		assertTrue(lootTrackerPluginSpy.coffinOpened);
		lootTrackerPluginSpy.onChatMessage(dropMessage2);
		assertTrue(lootTrackerPluginSpy.coffinOpened);
		lootTrackerPluginSpy.onChatMessage(dropMessage3);
		assertTrue(lootTrackerPluginSpy.coffinOpened);
		lootTrackerPluginSpy.onChatMessage(dropMessage4);
		assertTrue(lootTrackerPluginSpy.coffinOpened);
		lootTrackerPluginSpy.onChatMessage(dropMessage5);
		assertTrue(lootTrackerPluginSpy.coffinOpened);

		lootTrackerPluginSpy.onChatMessage(endMessage);
		// Coffin should be "closed" now after player names don't match in last message (simulating a broadcast message)
		assertFalse(lootTrackerPluginSpy.coffinOpened);
	}

	@Test
	public void testwhiteLillyDropEdgecase()
	{
		LootTrackerPlugin lootTrackerPluginSpy = spy(this.lootTrackerPlugin);

		final ItemPrice lillySeed = new ItemPrice();
		lillySeed.setId(ItemID.WHITE_LILY_SEED);
		lillySeed.setName("White Lilly Seed");

		final ItemPrice lilly = new ItemPrice();
		lilly.setId(ItemID.WHITE_LILY);
		lilly.setName("White Lilly");
		
		List<ItemPrice> lookup = new ArrayList<>();
		
		lookup.add(lillySeed);
		lookup.add(lilly);
		
		int id = lootTrackerPluginSpy.DetermineCorrectItemPrice(lookup, "White Lilly");
		assertTrue(id == ItemID.WHITE_LILY);
	}
}
