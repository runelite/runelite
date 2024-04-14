/*
 * Copyright (c) 2020, Jordan Zomerlei <https://github.com/JZomerlei>
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
package net.runelite.client.plugins.mining;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MiningPluginTest
{
	@Inject
	MiningPlugin miningPlugin;

	@Mock
	@Bind
	MiningConfig miningConfig;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	MiningOverlay miningOverlay;

	@Mock
	@Bind
	MiningRocksOverlay miningRocksOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testClay()
	{
		testMessage("You manage to mine some clay.");
	}

	@Test
	public void testIron()
	{
		testMessage("You manage to mine some iron.");
	}

	@Test
	public void testRunite()
	{
		testMessage("You manage to mine some runite.");
	}

	@Test
	public void testSandstone()
	{
		testMessage("You manage to quarry some sandstone.");
	}

	@Test
	public void testGranite()
	{
		testMessage("You manage to quarry some granite.");
	}

	@Test
	public void testOpal()
	{
		testMessage("You just mined an Opal!");
	}

	@Test
	public void testJade()
	{
		testMessage("You just mined a piece of Jade!");
	}

	@Test
	public void testRedTopaz()
	{
		testMessage("You just mined a Red Topaz!");
	}

	@Test
	public void testSapphire()
	{
		testMessage("You just mined a Sapphire!");
	}

	@Test
	public void testEmerald()
	{
		testMessage("You just mined an Emerald!");
	}

	@Test
	public void testRuby()
	{
		testMessage("You just mined a Ruby!");
	}

	@Test
	public void testDiamond()
	{
		testMessage("You just mined a Diamond!");
	}

	private void testMessage(String gameMessage)
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", gameMessage, "", 0);
		miningPlugin.onChatMessage(chatMessage);
		assertNotNull(miningPlugin.getSession());
	}

	@Test
	public void testCamTorumWaterNotify()
	{
		when(client.getLocalPlayer()).thenReturn(mock(Player.class));
		when(client.getLocalPlayer().getWorldLocation()).thenReturn(new WorldPoint(1501, 9538, 1));

		GameStateChanged gameStateChanged = new GameStateChanged();
		gameStateChanged.setGameState(GameState.LOGGED_IN);
		miningPlugin.onGameStateChanged(gameStateChanged);
		when(miningConfig.camTorumMaxDistanceHighlight()).thenReturn(10);
		when(miningConfig.camTorumNotifyWaterSpawn()).thenReturn(true);

		Tile tile = mock(Tile.class);
		when(tile.getWorldLocation()).thenReturn(new WorldPoint(1505, 9537, 1));

		DecorativeObject object = mock(DecorativeObject.class);
		when(object.getId()).thenReturn(51493);

		DecorativeObjectSpawned event = mock(DecorativeObjectSpawned.class);
		when(event.getDecorativeObject()).thenReturn(object);
		when(event.getTile()).thenReturn(tile);
		miningPlugin.onDecorativeObjectSpawned(event);
		miningPlugin.onGameTick(new GameTick());

		verify(notifier).notify("Watery rocks spawned!");
	}
}
