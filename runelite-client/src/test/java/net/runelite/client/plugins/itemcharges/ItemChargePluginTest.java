/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemcharges;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemChargePluginTest
{
	private static final String CHECK = "Your dodgy necklace has 10 charges left.";
	private static final String PROTECT = "Your dodgy necklace protects you. It has 9 charges left.";
	private static final String PROTECT_1 = "Your dodgy necklace protects you. <col=ff0000>It has 1 charge left.</col>";
	private static final String BREAK = "Your dodgy necklace protects you. <col=ff0000>It then crumbles to dust.</col>";

	private static final String CHECK_RING_OF_FORGING_FULL = "You can smelt 140 more pieces of iron ore before a ring melts.";
	private static final String CHECK_RING_OF_FORGING_ONE = "You can smelt one more piece of iron ore before a ring melts.";
	private static final String USED_RING_OF_FORGING = "You retrieve a bar of iron.";
	private static final String BREAK_RING_OF_FORGING = "<col=7f007f>Your Ring of Forging has melted.</col>";

	private static final String CHECK_AMULET_OF_CHEMISTRY = "Your amulet of chemistry has 5 charges left.";
	private static final String CHECK_AMULET_OF_CHEMISTRY_1 = "Your amulet of chemistry has 1 charge left.";
	private static final String USED_AMULET_OF_CHEMISTRY = "Your amulet of chemistry helps you create a 4-dose potion. It has 4 charges left.";
	private static final String USED_AMULET_OF_CHEMISTRY_3_DOSES = "Your amulet of chemistry helps you create a 3-dose potion. It has 2 charges left.";
	private static final String USED_AMULET_OF_CHEMISTRY_2_DOSES = "Your amulet of chemistry helps you create a 2-dose potion. It has one charge left.";
	private static final String BREAK_AMULET_OF_CHEMISTRY = "Your amulet of chemistry helps you create a 4-dose potion. It then crumbles to dust.";
	private static final String BREAK_AMULET_OF_CHEMISTRY_3_DOSES = "Your amulet of chemistry helps you create a 3-dose potion. It then crumbles to dust.";
	private static final String BREAK_AMULET_OF_CHEMISTRY_2_DOSES = "Your amulet of chemistry helps you create a 2-dose potion. It then crumbles to dust.";

	private static final String CHRONICLE_CHECK_CHARGES_FULL = "Your book has 1000 charges left.";
	private static final String CHRONICLE_CHECK_CHARGES_ONE = "You have one charge left in your book.";
	private static final String CHRONICLE_CHECK_CHARGES_EMPTY = "Your book has run out of charges.";
	private static final String CHRONICLE_TELEPORT = "<col=ef1020>Your book has 999 charges left.</col>";
	private static final String CHRONICLE_TELEPORT_ONE = "<col=ef1020>You have one charge left in your book.</col>";
	private static final String CHRONICLE_TELEPORT_EMPTY = "<col=ef1020>Your book has run out of charges.</col>";
	private static final String CHRONICLE_TELEPORT_FAIL = "Your book does not have any charges. Purchase some Teleport Cards from Diango.";
	private static final String CHRONICLE_ADD_SINGLE_CHARGE = "You add a single charge to your book. It now has one charge.";
	private static final String CHRONICLE_ADD_SINGLE_CHARGE_FULL = "You add a single charge to your book. It now has 1000 charges.";
	private static final String CHRONICLE_ADD_MULTIPLE_CHARGES = "You add 5 charges to your book. It now has 5 charges.";
	private static final String CHRONICLE_ADD_FULL = "Your book is fully charged! It has 1,000 charges already.";

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ScheduledExecutorService scheduledExecutorService;

	@Mock
	@Bind
	private RuneLiteConfig runeLiteConfig;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private ItemChargeConfig config;

	@Inject
	private ItemChargePlugin itemChargePlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testOnChatMessage()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(10);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", PROTECT, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(9);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", PROTECT_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(1);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).dodgyNecklace(10);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_RING_OF_FORGING_ONE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(1);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_RING_OF_FORGING_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(140);
		reset(config);

		when(config.ringOfForging()).thenReturn(90);
		// Create equipment inventory with ring of forging
		ItemContainer equipmentItemContainer = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipmentItemContainer);
		when(equipmentItemContainer.contains(ItemID.RING_OF_FORGING)).thenReturn(true);
		// Run message
		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_RING_OF_FORGING, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(89);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_RING_OF_FORGING, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).ringOfForging(140);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_AMULET_OF_CHEMISTRY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(5);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_AMULET_OF_CHEMISTRY_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(1);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_AMULET_OF_CHEMISTRY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(4);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_AMULET_OF_CHEMISTRY_3_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(2);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_AMULET_OF_CHEMISTRY_2_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(1);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_AMULET_OF_CHEMISTRY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(5);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_AMULET_OF_CHEMISTRY_3_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(5);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_AMULET_OF_CHEMISTRY_2_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).amuletOfChemistry(5);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_CHECK_CHARGES_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(1000);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_CHECK_CHARGES_ONE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(1);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_CHECK_CHARGES_EMPTY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(0);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(999);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT_ONE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(1);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT_EMPTY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(0);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT_FAIL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(0);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_SINGLE_CHARGE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(1);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_SINGLE_CHARGE_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(1000);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_MULTIPLE_CHARGES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(5);
		reset(config);

		chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(config).chronicle(1000);
		reset(config);
	}
}