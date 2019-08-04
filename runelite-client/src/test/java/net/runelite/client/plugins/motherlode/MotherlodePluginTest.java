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
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.RuneLiteConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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
	MotherlodeSession motherlodeSession;

	@Mock
	@Bind
	private MotherlodeConfig motherlodeConfig;

	@Mock
	@Bind
	private MotherlodeGemOverlay motherlodeGemOverlay;

	@Mock
	@Bind
	private MotherlodeOreOverlay motherlodeOreOverlay;

	@Mock
	@Bind
	private MotherlodeRocksOverlay motherlodeRocksOverlay;

	@Mock
	@Bind
	private MotherlodeSackOverlay motherlodeSackOverlay;

	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	private ChatColorConfig chatColorConfig;

	@Mock
	@Bind
	private RuneLiteConfig runeliteConfig;

	@Mock
	@Bind
	private Notifier notifier;

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
		when(client.getVar(Varbits.SACK_NUMBER)).thenReturn(42);
		motherlodePlugin.onVarbitChanged(new VarbitChanged());

		// Create before inventory
		ItemContainer inventory = mock(ItemContainer.class);
		Item[] items = new Item[]{
			item(ItemID.RUNITE_ORE, 1),
			item(ItemID.GOLDEN_NUGGET, 4),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),
			item(ItemID.COAL, 1),

		};
		when(inventory.getItems())
			.thenReturn(items);
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(inventory);

		// Withdraw 20
		when(client.getVar(Varbits.SACK_NUMBER)).thenReturn(22);
		motherlodePlugin.onVarbitChanged(new VarbitChanged());

		inventory = mock(ItemContainer.class);
		// +1 rune, +4 nugget, +2 coal, +1 addy
		items = new Item[]{
			item(ItemID.RUNITE_ORE, 1),
			item(ItemID.RUNITE_ORE, 1),
			item(ItemID.GOLDEN_NUGGET, 8),
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
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(inventory);

		// Trigger comparison
		motherlodePlugin.onItemContainerChanged(new ItemContainerChanged(InventoryID.INVENTORY.getId(), inventory));

		verify(motherlodeSession).updateOreFound(ItemID.RUNITE_ORE, 1);
		verify(motherlodeSession).updateOreFound(ItemID.GOLDEN_NUGGET, 4);
		verify(motherlodeSession).updateOreFound(ItemID.COAL, 2);
		verify(motherlodeSession).updateOreFound(ItemID.ADAMANTITE_ORE, 1);
		verifyNoMoreInteractions(motherlodeSession);
	}

	private static Item item(int itemId, int quantity)
	{
		return new Item(itemId, quantity);
	}
}