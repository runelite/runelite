/*
 * Copyright (c) 2019, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.plugins.banktags;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.banktags.tabs.BankSearch;
import net.runelite.client.plugins.banktags.tabs.TabInterface;
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
public class ItemValueSearchTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Inject
	private BankTagsPlugin bankTagsPlugin;

	@Mock
	@Bind
	private ClientThread clientThread;

	@Mock
	@Bind
	private ChatboxPanelManager chatboxPanelManager;

	@Mock
	@Bind
	private MouseManager mouseManager;

	@Mock
	@Bind
	private BankTagsConfig config;

	@Mock
	@Bind
	private TagManager tagManager;

	@Mock
	@Bind
	private TabInterface tabInterface;

	@Mock
	@Bind
	private BankSearch bankSearch;

	@Mock
	@Bind
	private KeyManager keyManager;

	@Mock
	@Bind
	private SpriteManager spriteManager;

	@Mock
	@Bind
	private RuneLiteConfig runeLiteConfig;

	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testCalculate()
	{
		int itemId = ItemID.ABYSSAL_WHIP;

		bankTagsPlugin.itemQuantities.add(itemId, 30);

		ItemDefinition comp = mock(ItemDefinition.class);

		// 60k HA price * 30 = 1.8m
		when(comp.getPrice())
			.thenReturn(100_000);

		// 400k GE Price * 30 = 12m
		when(itemManager.getItemPrice(itemId))
			.thenReturn(400_000);
		when(itemManager.getItemDefinition(itemId))
			.thenReturn(comp);

		assertTrue(bankTagsPlugin.valueSearch(itemId, ">500k"));
		assertTrue(bankTagsPlugin.valueSearch(itemId, "< 5.5b"));
		assertTrue(bankTagsPlugin.valueSearch(itemId, "500k - 20.6m"));

		assertTrue(bankTagsPlugin.valueSearch(itemId, "ha=1.8m"));
		assertTrue(bankTagsPlugin.valueSearch(itemId, "ha 500k - 20.6m"));
		assertTrue(bankTagsPlugin.valueSearch(itemId, "ha > 940k"));

		assertFalse(bankTagsPlugin.valueSearch(itemId, "<500k"));
		assertFalse(bankTagsPlugin.valueSearch(itemId, "ha >2m"));
		assertFalse(bankTagsPlugin.valueSearch(itemId, "ge > 0.02b"));

		assertFalse(bankTagsPlugin.valueSearch(itemId, "1000k"));
	}
}