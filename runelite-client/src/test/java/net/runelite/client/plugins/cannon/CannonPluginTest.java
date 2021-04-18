/*
 * Copyright (c) 2021, Alexsuperfly <alexsuperfly@users.noreply.github.com>
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.cannon;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CannonPluginTest
{

	@Inject
	private CannonPlugin plugin;

	@Mock
	@Bind
	private CannonConfig config;

	@Mock
	@Bind
	private CannonOverlay cannonOverlay;

	@Mock
	@Bind
	private CannonSpotOverlay cannonSpotOverlay;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	private static final ChatMessage ADD_FURNACE = new ChatMessage();

	@BeforeClass
	public static void chatMessageSetup()
	{
		ADD_FURNACE.setType(ChatMessageType.SPAM);
		ADD_FURNACE.setMessage("You add the furnace.");
	}

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void addWrongTypeOfCannonballs()
	{
		final ChatMessage message = new ChatMessage();
		message.setType(ChatMessageType.GAMEMESSAGE);
		message.setMessage("Your cannon contains 20 x Cannonball.<br>You can only add cannonballs of the same kind.");

		plugin.onChatMessage(message);

		assertEquals(20, plugin.getCballsLeft());
	}

	@Test
	public void addMaxCannonballs()
	{
		final ItemContainer inventory = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(inventory);
		when(inventory.count(ItemID.CANNONBALL)).thenReturn(100);
		when(inventory.count(ItemID.GRANITE_CANNONBALL)).thenReturn(0);

		plugin.onChatMessage(ADD_FURNACE);
		assertTrue(plugin.isCannonPlaced());

		assertEquals(30, plugin.getCballsLeft());

		plugin.onChatMessage(loadCannonballs(30));
		assertEquals(30, plugin.getCballsLeft());
	}

	@Test
	public void addNotMaxCannonballs()
	{
		final ItemContainer inventory = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(inventory);
		when(inventory.count(ItemID.GRANITE_CANNONBALL)).thenReturn(12);

		plugin.onChatMessage(ADD_FURNACE);
		assertTrue(plugin.isCannonPlaced());

		assertEquals(0, plugin.getCballsLeft());

		plugin.onChatMessage(loadCannonballs(12));
		assertEquals(12, plugin.getCballsLeft());
	}

	@Test
	public void addReclaimedCannonballs()
	{
		final ItemContainer inventory = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(inventory);
		when(inventory.count(ItemID.CANNONBALL)).thenReturn(1250);

		plugin.onChatMessage(ADD_FURNACE);
		assertTrue(plugin.isCannonPlaced());

		assertEquals(30, plugin.getCballsLeft());

		plugin.onChatMessage(loadCannonballs(18));
		assertEquals(30, plugin.getCballsLeft());
	}

	private static ChatMessage loadCannonballs(final int numCannonballs)
	{
		final ChatMessage message = new ChatMessage();
		message.setType(ChatMessageType.GAMEMESSAGE);

		// Cannons use the same chat message for loading cannonballs regardless of whether they're normal or granite.
		if (numCannonballs == 1)
		{
			message.setMessage("You load the cannon with one cannonball.");
		}
		else
		{
			message.setMessage(String.format("You load the cannon with %s cannonballs.", numCannonballs));
		}

		return message;
	}

}
