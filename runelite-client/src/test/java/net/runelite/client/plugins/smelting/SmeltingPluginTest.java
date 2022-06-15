/*
 * Copyright (c) 2019, Stephen <stepzhu@umich.edu>
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
package net.runelite.client.plugins.smelting;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Node;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SmeltingPluginTest
{
	private static final String SMELT_CANNONBALL = "You remove the cannonballs from the mould";
	private static final String SMELT_BAR = "You retrieve a bar of steel.";

	@Inject
	SmeltingPlugin smeltingPlugin;

	@Mock
	@Bind
	SmeltingConfig config;

	@Mock
	@Bind
	SmeltingOverlay smeltingOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	Client client;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testCannonballs()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_CANNONBALL, "", 0);
		smeltingPlugin.onChatMessage(chatMessage);

		SmeltingSession smeltingSession = smeltingPlugin.getSession();
		assertNotNull(smeltingSession);
		assertEquals(4, smeltingSession.getCannonBallsSmelted());
	}

	@Test
	public void testCannonballsWithDoubleMould()
	{
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(new ItemContainer()
		{
			@Override
			public int getId()
			{
				return 0;
			}

			@NotNull
			@Override
			public Item[] getItems()
			{
				return new Item[0];
			}

			@Nullable
			@Override
			public Item getItem(int slot)
			{
				return null;
			}

			@Override
			public boolean contains(int itemId)
			{
				return itemId == ItemID.DOUBLE_AMMO_MOULD;
			}

			@Override
			public int count(int itemId)
			{
				return 0;
			}

			@Override
			public int size()
			{
				return 0;
			}

			@Override
			public Node getNext()
			{
				return null;
			}

			@Override
			public Node getPrevious()
			{
				return null;
			}

			@Override
			public long getHash()
			{
				return 0;
			}
		});

		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_CANNONBALL, "", 0);
		smeltingPlugin.onChatMessage(chatMessage);

		SmeltingSession smeltingSession = smeltingPlugin.getSession();
		assertNotNull(smeltingSession);
		assertEquals(8, smeltingSession.getCannonBallsSmelted());
	}

	@Test
	public void testBars()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", SMELT_BAR, "", 0);
		smeltingPlugin.onChatMessage(chatMessage);

		SmeltingSession smeltingSession = smeltingPlugin.getSession();
		assertNotNull(smeltingSession);
		assertEquals(1, smeltingSession.getBarsSmelted());
	}
}
