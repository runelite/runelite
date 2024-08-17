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
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.IterableHashTable;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.client.account.SessionManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemStack;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.http.api.item.ItemPrice;
import net.runelite.http.api.loottracker.LootRecordType;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import org.mockito.Mock;
import org.mockito.Mockito;
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

	@Mock
	@Bind
	private LootTrackerClient lootTrackerClient;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private ClientToolbar clientToolbar;

	private WorldView wv;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		Player player = mock(Player.class);
		when(player.getWorldLocation()).thenReturn(new WorldPoint(0, 0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		wv = mock(WorldView.class);
		when(client.getTopLevelWorldView()).thenReturn(wv);

		when(client.getWorldView(anyInt())).thenReturn(wv);

		lootTrackerPlugin = spy(lootTrackerPlugin);
		doNothing().when(lootTrackerPlugin).addLoot(any(), anyInt(), any(), any(), any(Collection.class));
	}

	private void sendInvChange(InventoryID inv, Collection<ItemStack> items)
	{
		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(items.stream()
			.map(is -> new Item(is.getId(), is.getQuantity()))
			.toArray(Item[]::new));
		when(client.getItemContainer(inv)).thenReturn(itemContainer);

		ItemContainerChanged event = new ItemContainerChanged(inv.getId(), itemContainer);
		lootTrackerPlugin.onItemContainerChanged(event);
	}

	@Test
	public void testPickPocket()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You pick the hero's pocket.", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		List<ItemStack> items = Collections.singletonList(
			new ItemStack(ItemID.COINS_995, 1)
		);
		sendInvChange(InventoryID.INVENTORY, items);

		verify(lootTrackerPlugin).addLoot("Hero", -1, LootRecordType.PICKPOCKET, null, items);
	}

	@Test
	public void testFirstClue()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "You have completed 1 master Treasure Trail.", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		List<ItemStack> items = Collections.singletonList(
			new ItemStack(ItemID.COINS_995, 1)
		);
		sendInvChange(InventoryID.BARROWS_REWARD, items);

		verify(lootTrackerPlugin).addLoot("Clue Scroll (Master)", -1, LootRecordType.EVENT, null, items);
	}

	@Test
	public void testHerbiboarHerbSack()
	{
		when(client.getBoostedSkillLevel(Skill.HERBLORE)).thenReturn(42);

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

			ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", LootTrackerPlugin.HERBIBOAR_LOOTED_MESSAGE, "", 0);
			lootTrackerPlugin.onChatMessage(chatMessage);

			verify(lootTrackerPlugin).addLoot("Herbiboar", -1, LootRecordType.EVENT, 42, Arrays.asList(
				new ItemStack(id, 1),
				new ItemStack(id, 1)
			));
		}
	}

	@Test
	public void testCoXRaidsLootValue()
	{
		when(lootTrackerConfig.showRaidsLootValue()).thenReturn(true);
		when(lootTrackerConfig.priceType()).thenReturn(LootTrackerPriceType.GRAND_EXCHANGE);

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.TWISTED_BOW, 1),
			new Item(ItemID.PURE_ESSENCE, 42)
		});
		when(client.getItemContainer(InventoryID.CHAMBERS_OF_XERIC_CHEST)).thenReturn(itemContainer);

		when(itemManager.getItemPrice(ItemID.TWISTED_BOW)).thenReturn(1_100_000_000);
		when(itemManager.getItemPrice(ItemID.PURE_ESSENCE)).thenReturn(6);

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.CHAMBERS_OF_XERIC_REWARD);
		lootTrackerPlugin.onWidgetLoaded(widgetLoaded);

		ArgumentCaptor<QueuedMessage> captor = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(captor.capture());

		QueuedMessage queuedMessage = captor.getValue();
		assertEquals("<colNORMAL>Your loot is worth around <colHIGHLIGHT>1,100,000,252<colNORMAL> coins.", queuedMessage.getRuneLiteFormattedMessage());
	}

	@Test
	public void testToBRaidsLootValue()
	{
		when(lootTrackerConfig.priceType()).thenReturn(LootTrackerPriceType.HIGH_ALCHEMY);
		when(lootTrackerConfig.showRaidsLootValue()).thenReturn(true);

		LootTrackerPlugin spyPlugin = Mockito.spy(lootTrackerPlugin);
		// Make sure we don't execute addLoot, so we don't have to mock LootTrackerPanel and everything else also
		doNothing().when(spyPlugin).addLoot(anyString(), anyInt(), any(LootRecordType.class), isNull(), anyCollection());

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.SCYTHE_OF_VITUR, 1),
			new Item(ItemID.MAHOGANY_SEED, 10)
		});
		when(client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST)).thenReturn(itemContainer);

		ItemComposition compScythe = mock(ItemComposition.class);
		when(itemManager.getItemComposition(ItemID.SCYTHE_OF_VITUR)).thenReturn(compScythe);
		when(compScythe.getHaPrice()).thenReturn(60_000_000);

		ItemComposition compSeed = mock(ItemComposition.class);
		when(itemManager.getItemComposition(ItemID.MAHOGANY_SEED)).thenReturn(compSeed);
		when(compSeed.getHaPrice()).thenReturn(2_102);

		when(wv.getBaseX()).thenReturn(3232);
		when(wv.getBaseY()).thenReturn(4320);
		LocalPoint localPoint = new LocalPoint(0, 0);
		when(client.getLocalPlayer().getLocalLocation()).thenReturn(localPoint);

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.TOB_REWARD);
		spyPlugin.onWidgetLoaded(widgetLoaded);

		ArgumentCaptor<QueuedMessage> captor = ArgumentCaptor.forClass(QueuedMessage.class);
		verify(chatMessageManager).queue(captor.capture());

		QueuedMessage queuedMessage = captor.getValue();
		assertEquals("<colNORMAL>Your loot is worth around <colHIGHLIGHT>60,021,020<colNORMAL> coins.", queuedMessage.getRuneLiteFormattedMessage());
	}

	@Test
	public void testBirdhouses()
	{
		when(client.getBoostedSkillLevel(Skill.HUNTER)).thenReturn(42);
		List<ItemStack> items = Collections.singletonList(
			new ItemStack(ItemID.BIRD_NEST, 42)
		);

		// No bird nests
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You dismantle and discard the trap, retrieving 10 dead birds, 30 feathers and 1140 Hunter XP.", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		sendInvChange(InventoryID.INVENTORY, items);
		verify(lootTrackerPlugin).addLoot("Magic Bird House", -1, LootRecordType.EVENT, 42, items);

		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(null);

		// Single bird nest
		chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You dismantle and discard the trap, retrieving a nest, 10 dead birds, 50 feathers and 700 Hunter XP.", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		sendInvChange(InventoryID.INVENTORY, items);
		verify(lootTrackerPlugin).addLoot("Teak Bird House", -1, LootRecordType.EVENT, 42, items);

		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(null);

		// Multiple nests
		chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You dismantle and discard the trap, retrieving 2 nests, 10 dead birds, 40 feathers and 280 Hunter XP.", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		sendInvChange(InventoryID.INVENTORY, items);
		verify(lootTrackerPlugin).addLoot("Regular Bird House", -1, LootRecordType.EVENT, 42, items);
	}

	@Test
	public void testGrubbyChest()
	{
		Player player = mock(Player.class);
		when(player.getWorldLocation()).thenReturn(new WorldPoint(7323 >> 2, (7323 & 0xff) << 6, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		LootTrackerPlugin lootTrackerPluginSpy = spy(this.lootTrackerPlugin);
		doNothing().when(lootTrackerPluginSpy).addLoot(any(), anyInt(), any(), any(), any(Collection.class));

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.TWISTED_BOW, 1),
			new Item(ItemID.GRUBBY_KEY, 1)
		});
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(itemContainer);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You unlock the chest with your key.", "", 0);
		lootTrackerPluginSpy.onChatMessage(chatMessage);

		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.TWISTED_BOW, 1)
		});
		lootTrackerPluginSpy.onItemContainerChanged(new ItemContainerChanged(InventoryID.INVENTORY.getId(), itemContainer));

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "You have opened the Grubby Chest 2 times.", "", 0);
		lootTrackerPluginSpy.onChatMessage(chatMessage);

		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.TWISTED_BOW, 1),
			new Item(ItemID.SHARK, 42)
		});
		lootTrackerPluginSpy.onItemContainerChanged(new ItemContainerChanged(InventoryID.INVENTORY.getId(), itemContainer));

		verify(lootTrackerPluginSpy).addLoot("Grubby Chest", -1, LootRecordType.EVENT, null, Arrays.asList(
			new ItemStack(ItemID.SHARK, 42)
		));
	}

	@Test
	public void testTemporossRewardPool()
	{
		Player player = mock(Player.class);
		when(client.getLocalPlayer()).thenReturn(player);
		when(client.getLocalPlayer().getWorldLocation()).thenReturn(new WorldPoint(3153, 2833, 0));
		when(client.getBoostedSkillLevel(Skill.FISHING)).thenReturn(69);

		doNothing().when(lootTrackerPlugin).addLoot(any(), anyInt(), any(), any(), any(Collection.class));

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.BUCKET_OF_WATER, 1),
			new Item(ItemID.ROPE, 1)
		});
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(itemContainer);

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You found some loot: 30 x Raw tuna", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.BUCKET_OF_WATER, 1),
			new Item(ItemID.ROPE, 1),
			new Item(ItemID.RAW_TUNA, 30)
		});
		lootTrackerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.INVENTORY.getId(), itemContainer));

		verify(lootTrackerPlugin).addLoot("Reward pool (Tempoross)", -1, LootRecordType.EVENT, 69, Arrays.asList(
			new ItemStack(ItemID.RAW_TUNA, 30)
		));

		chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", "You found some loot: <col=ef1020>Tome of water (empty)</col>", "", 0);
		lootTrackerPlugin.onChatMessage(chatMessage);

		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.BUCKET_OF_WATER, 1),
			new Item(ItemID.ROPE, 1),
			new Item(ItemID.RAW_TUNA, 30),
			new Item(ItemID.TOME_OF_WATER_EMPTY, 1)
		});
		lootTrackerPlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.INVENTORY.getId(), itemContainer));

		verify(lootTrackerPlugin).addLoot("Reward pool (Tempoross)", -1, LootRecordType.EVENT, 69, Arrays.asList(
			new ItemStack(ItemID.TOME_OF_WATER_EMPTY, 1)
		));
	}

	@Test
	public void testReopenChestInInstance()
	{
		LootTrackerPlugin spyPlugin = Mockito.spy(lootTrackerPlugin);
		// Make sure we don't execute addLoot, so we don't have to mock LootTrackerPanel and everything else also
		doNothing().when(spyPlugin).addLoot(anyString(), anyInt(), any(LootRecordType.class), isNull(), anyCollection());
		doReturn(true).when(spyPlugin).inTobChestRegion();

		final GameStateChanged loading = new GameStateChanged();
		loading.setGameState(GameState.LOADING);

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.SCYTHE_OF_VITUR_UNCHARGED, 1)
		});
		when(client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST)).thenReturn(itemContainer);

		when(client.isInInstancedRegion()).thenReturn(true);
		spyPlugin.onGameStateChanged(loading);

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.TOB_REWARD);
		spyPlugin.onWidgetLoaded(widgetLoaded);

		verify(spyPlugin).addLoot("Theatre of Blood", -1, LootRecordType.EVENT, null, Collections.singletonList(
			new ItemStack(ItemID.SCYTHE_OF_VITUR_UNCHARGED, 1)
		));
	}

	@Test
	public void testReopenChestOutsideOfInstance()
	{
		LootTrackerPlugin spyPlugin = Mockito.spy(lootTrackerPlugin);
		// Make sure we don't execute addLoot, so we don't have to mock LootTrackerPanel and everything else also
		doNothing().when(spyPlugin).addLoot(anyString(), anyInt(), any(LootRecordType.class), isNull(), anyCollection());
		doReturn(true).when(spyPlugin).inTobChestRegion();

		final GameStateChanged loading = new GameStateChanged();
		loading.setGameState(GameState.LOADING);

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.SCYTHE_OF_VITUR_UNCHARGED, 1)
		});
		when(client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST)).thenReturn(itemContainer);

		when(client.isInInstancedRegion()).thenReturn(false);
		spyPlugin.onGameStateChanged(loading);

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.TOB_REWARD);
		spyPlugin.onWidgetLoaded(widgetLoaded);

		verify(spyPlugin).addLoot("Theatre of Blood", -1, LootRecordType.EVENT, null, Collections.singletonList(
			new ItemStack(ItemID.SCYTHE_OF_VITUR_UNCHARGED, 1)
		));
	}

	@Test
	public void testOpenInstancedAreaChestAfterNonInstancedAreaChest()
	{
		LootTrackerPlugin spyPlugin = Mockito.spy(lootTrackerPlugin);
		// Make sure we don't execute addLoot, so we don't have to mock LootTrackerPanel and everything else also
		doNothing().when(spyPlugin).addLoot(anyString(), anyInt(), any(LootRecordType.class), isNull(), anyCollection());
		doReturn(true).when(spyPlugin).inTobChestRegion();

		final GameStateChanged loading = new GameStateChanged();
		loading.setGameState(GameState.LOADING);

		ItemContainer itemContainer = mock(ItemContainer.class);
		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.SCYTHE_OF_VITUR_UNCHARGED, 1)
		});
		when(client.getItemContainer(InventoryID.THEATRE_OF_BLOOD_CHEST)).thenReturn(itemContainer);

		when(client.isInInstancedRegion()).thenReturn(false);
		spyPlugin.onGameStateChanged(loading);

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.TOB_REWARD);
		spyPlugin.onWidgetLoaded(widgetLoaded);

		verify(spyPlugin).addLoot("Theatre of Blood", -1, LootRecordType.EVENT, null, Collections.singletonList(
			new ItemStack(ItemID.SCYTHE_OF_VITUR_UNCHARGED, 1)
		));

		when(itemContainer.getItems()).thenReturn(new Item[]{
			new Item(ItemID.SANGUINESTI_STAFF_UNCHARGED, 1)
		});
		when(client.isInInstancedRegion()).thenReturn(true);
		spyPlugin.onGameStateChanged(loading);
		spyPlugin.onWidgetLoaded(widgetLoaded);

		verify(spyPlugin).addLoot("Theatre of Blood", -1, LootRecordType.EVENT, null, Collections.singletonList(
			new ItemStack(ItemID.SANGUINESTI_STAFF_UNCHARGED, 1)
		));
	}
}
