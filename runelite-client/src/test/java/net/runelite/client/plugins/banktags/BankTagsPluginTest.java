/*
 * Copyright (c) 2020, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.plugins.banktags;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import javax.inject.Named;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.plugins.banktags.BankTagsPlugin.ITEM_KEY_PREFIX;
import net.runelite.client.plugins.banktags.tabs.TabInterface;
import net.runelite.client.plugins.cluescrolls.ClueScrollService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankTagsPluginTest
{
	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private BankTagsConfig bankTagsConfig;

	@Mock
	@Bind
	private RuneLiteConfig runeLiteConfig;

	@Mock
	@Bind
	private TabInterface tabInterface;

	@Mock
	@Bind
	private ClueScrollService clueScrollService;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private ChatMessageManager chatMessageManager;

	@Bind
	@Named("developerMode")
	boolean developerMode;

	@Inject
	private TagManager tagManager;

	@Inject
	private BankTagsPlugin bankTagsPlugin;

	private final ScriptCallbackEvent EVENT = new ScriptCallbackEvent();

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		EVENT.setEventName("bankSearchFilter");

		when(itemManager.canonicalize(ItemID.ABYSSAL_WHIP)).thenReturn(ItemID.ABYSSAL_WHIP);
		when(client.getIntStackSize()).thenReturn(2);
		when(client.getObjectStackSize()).thenReturn(1);
	}

	@Test
	public void testExplicitSearch()
	{
		when(client.getIntStack()).thenReturn(new int[]{0, ItemID.ABYSSAL_WHIP});
		when(client.getObjectStack()).thenReturn(new String[]{"tag:whip"});

		when(configManager.getConfiguration(BankTagsPlugin.CONFIG_GROUP,
			ITEM_KEY_PREFIX + ItemID.ABYSSAL_WHIP)).thenReturn("herb,bossing,whip");
		bankTagsPlugin.onScriptCallbackEvent(EVENT);
		assertEquals(1, client.getIntStack()[0]);

		// Search should be found at the start of the tag
		when(client.getIntStack()).thenReturn(new int[]{0, ItemID.ABYSSAL_WHIP});
		when(configManager.getConfiguration(BankTagsPlugin.CONFIG_GROUP,
			ITEM_KEY_PREFIX + ItemID.ABYSSAL_WHIP)).thenReturn("herb,bossing,whip long tag");
		bankTagsPlugin.onScriptCallbackEvent(EVENT);
		assertEquals(1, client.getIntStack()[0]);

		// Search should not be be found in the middle of the tag
		// and explicit search does not allow fall through
		when(configManager.getConfiguration(BankTagsPlugin.CONFIG_GROUP,
			ITEM_KEY_PREFIX + ItemID.ABYSSAL_WHIP)).thenReturn("herb,bossing whip");
		bankTagsPlugin.onScriptCallbackEvent(EVENT);
		assertEquals(0, client.getIntStack()[0]);
	}

	@Test
	public void testFallThrough()
	{
		when(client.getIntStack()).thenReturn(new int[]{1, ItemID.ABYSSAL_WHIP});
		when(client.getObjectStack()).thenReturn(new String[]{"whip"});

		when(configManager.getConfiguration(BankTagsPlugin.CONFIG_GROUP,
			ITEM_KEY_PREFIX + ItemID.ABYSSAL_WHIP)).thenReturn("herb,bossing");

		assertFalse(tagManager.findTag(ItemID.ABYSSAL_WHIP, "whip"));
		bankTagsPlugin.onScriptCallbackEvent(EVENT);
		assertEquals(1, client.getIntStack()[0]);
	}

	@Test
	public void testNonExplicitSearch()
	{
		when(client.getIntStack()).thenReturn(new int[]{0, ItemID.ABYSSAL_WHIP});
		when(client.getObjectStack()).thenReturn(new String[]{"whip"});

		when(configManager.getConfiguration(BankTagsPlugin.CONFIG_GROUP,
			ITEM_KEY_PREFIX + ItemID.ABYSSAL_WHIP)).thenReturn("herb,bossing,whip long tag");

		bankTagsPlugin.onScriptCallbackEvent(EVENT);
		assertEquals(1, client.getIntStack()[0]);
	}
}
