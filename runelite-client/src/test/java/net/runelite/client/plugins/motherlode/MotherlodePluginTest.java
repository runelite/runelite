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
package net.runelite.client.plugins.motherlode;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.loottracker.PluginLootReceived;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MotherlodePluginTest
{
	@Inject
	private MotherlodePlugin motherlodePlugin;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private MotherlodeConfig motherlodeConfig;

	@Mock
	@Bind
	private MotherlodeSceneOverlay motherlodeSceneOverlay;

	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private EventBus eventBus;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);
		when(client.getMapRegions()).thenReturn(new int[]{14679});
	}

	@Test
	public void testOreCounter()
	{
		// set inMlm
		GameStateChanged gameStateChanged = new GameStateChanged();
		gameStateChanged.setGameState(GameState.LOADING);
		motherlodePlugin.onGameStateChanged(gameStateChanged);

		// Initial sack count
		VarbitChanged sackVarbit = new VarbitChanged();
		sackVarbit.setVarbitId(VarbitID.MOTHERLODE_SACK_TRANSMIT);
		when(client.getVarbitValue(VarbitID.MOTHERLODE_SACK_TRANSMIT)).thenReturn(42);
		motherlodePlugin.onVarbitChanged(sackVarbit);

		// Create before inventory
		ItemContainer inventory = mock(ItemContainer.class);
		Item[] items = new Item[]{
			item(ItemID.RUNITE_ORE, 1),
			item(ItemID.MOTHERLODE_NUGGET, 4),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),

		};
		when(inventory.getItems())
			.thenReturn(items);
		when(client.getItemContainer(InventoryID.INV)).thenReturn(inventory);

		// Withdraw 20
		when(client.getVarbitValue(VarbitID.MOTHERLODE_SACK_TRANSMIT)).thenReturn(22);
		motherlodePlugin.onVarbitChanged(sackVarbit);

		inventory = mock(ItemContainer.class);
		// +1 rune, +4 nugget, +2 coal, +1 addy
		items = new Item[]{
			item(ItemID.RUNITE_ORE, 1),
			item(ItemID.RUNITE_ORE, 1),
			item(ItemID.MOTHERLODE_NUGGET, 8),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.ADAMANTITE_ORE, 1),

		};
		when(inventory.getItems())
			.thenReturn(items);

		// Trigger comparison
		when(motherlodeConfig.trackOresFound()).thenReturn(true);
		motherlodePlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.INV, inventory));

		ArgumentCaptor<PluginLootReceived> captor = ArgumentCaptor.forClass(PluginLootReceived.class);
		verify(eventBus).post(captor.capture());
		PluginLootReceived event = captor.getValue();
		assertEquals(Arrays.asList(
			new ItemStack(ItemID.ADAMANTITE_ORE, 1),
			new ItemStack(ItemID.RUNITE_ORE, 1),
			new ItemStack(ItemID.COAL, 2),
			new ItemStack(ItemID.MOTHERLODE_NUGGET, 4)
		), event.getItems());
	}

	private static Item item(int itemId, int quantity)
	{
		return new Item(itemId, quantity);
	}
}
