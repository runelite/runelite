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
package net.runelite.client.plugins.grounditems;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemLayer;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.grounditems.config.HighlightTier;
import net.runelite.client.plugins.grounditems.config.OwnershipFilterMode;
import net.runelite.client.ui.overlay.OverlayManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GroundItemsPluginTest
{
	@Inject
	private GroundItemsPlugin groundItemsPlugin;

	@Mock
	@Bind
	private MouseManager mouseManager;

	@Mock
	@Bind
	private KeyManager keyManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private GroundItemsConfig config;

	@Mock
	@Bind
	private GroundItemsOverlay overlay;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private ScheduledExecutorService executor;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Before
	public void setUp()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		doAnswer(a ->
		{
			a.<Runnable>getArgument(0).run();
			return null;
		}).when(executor).execute(any(Runnable.class));

		when(config.getHiddenItems()).thenReturn("");
		when(config.showLootbeamForHighlighted()).thenReturn(false);
		when(config.showLootbeamTier()).thenReturn(HighlightTier.OFF);
	}

	@Test
	public void testNotifyHighlightedItem()
	{
		when(config.getHighlightItems()).thenReturn("abyssal whip");
		when(config.notifyTier()).thenReturn(HighlightTier.OFF);
		when(config.notifyHighlightedDrops()).thenReturn(true);
		when(config.ownershipFilterMode()).thenReturn(OwnershipFilterMode.ALL);

		when(itemManager.getItemComposition(ItemID.ABYSSAL_WHIP)).thenAnswer(a ->
		{
			ItemComposition itemComposition = mock(ItemComposition.class);
			when(itemComposition.getName()).thenReturn("Abyssal whip");
			return itemComposition;
		});

		// trigger reload of highlighted items list
		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup("grounditems");
		groundItemsPlugin.onConfigChanged(configChanged);

		// spawn whip
		Tile tile = mock(Tile.class);
		when(tile.getItemLayer()).thenReturn(mock(ItemLayer.class));
		when(tile.getWorldLocation()).thenReturn(new WorldPoint(0, 0, 0));

		TileItem tileItem = mock(TileItem.class);
		when(tileItem.getId()).thenReturn(ItemID.ABYSSAL_WHIP);
		when(tileItem.getQuantity()).thenReturn(1);

		groundItemsPlugin.onItemSpawned(new ItemSpawned(tile, tileItem));

		verify(notifier).notify("You received a highlighted drop: Abyssal whip");
	}
}