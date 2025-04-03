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
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
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

	private static final String CHECK_BRACELET_OF_SLAUGHTER = "Your bracelet of slaughter has 25 charges left.";
	private static final String CHECK_BRACELET_OF_SLAUGHTER_1 = "Your bracelet of slaughter has 1 charge left.";
	private static final String ACTIVATE_BRACELET_OF_SLAUGHTER = "Your bracelet of slaughter prevents your slayer count from decreasing. It has 16 charges left.";
	private static final String BREAK_BRACELET_OF_SLAUGHTER = "Your bracelet of slaughter prevents your slayer count from decreasing. <col=ff0000>It then crumbles to dust.</col>";
	private static final String REGENERATE_BRACELET_OF_SLAUGHTER = "Your bracelet of slaughter prevents your slayer count from decreasing. <col=047f06>It then regenerates itself to full charge!</col>";

	private static final String CHECK_EXPEDITIOUS_BRACELET = "Your expeditious bracelet has 6 charges left.";
	private static final String CHECK_EXPEDITIOUS_BRACELET_1 = "Your expeditious bracelet has 1 charge left.";
	private static final String ACTIVATE_EXPEDITIOUS_BRACELET = "Your expeditious bracelet helps you progress your slayer task faster. It has 11 charges left.";
	private static final String BREAK_EXPEDITIOUS_BRACELET = "Your expeditious bracelet helps you progress your slayer task faster. <col=ff0000>It then crumbles to dust.</col>";

	private static final String ACTIVATE_BLOOD_ESSENCE = "You activate the blood essence.";
	private static final String EXTRACT_BLOOD_ESSENCE = "You manage to extract power from the Blood Essence and craft 67 extra runes.";
	private static final String CHECK_BLOOD_ESSENCE = "Your blood essence has 56 charges remaining";
	private static final String CHECK_BRACELET_OF_CLAY = "You can mine 13 more pieces of soft clay before your bracelet crumbles to dust.";
	private static final String USED_BRACELET_OF_CLAY = "You manage to mine some clay.";

	private static final String USED_BRACELET_OF_CLAY_TRAHAEARN = "You manage to mine some soft clay.";

	private static final String BREAK_BRACELET_OF_CLAY = "Your bracelet of clay crumbles to dust.";

	private static final String CHECK_ALCHEMISTS_AMULET = "Your Alchemist's amulet has 25 charges left.";
	private static final String CHECK_ALCHEMISTS_AMULET_1 = "Your Alchemist's amulet has 1 charge left.";
	private static final String ACTIVATE_ALCHEMISTS_AMULET = "Your Alchemist's amulet helps you create a 4-dose potion. It has 25 charges left.";
	private static final String ACTIVATE_ALCHEMISTS_AMULET_1 = "Your Alchemist's amulet helps you create a 4-dose potion. It has one charge left.";
	private static final String DEPLETED_ALCHEMISTS_AMULET = "Your Alchemist's amulet helps you create a 4-dose potion. It no longer has any charges.";
	private static final String INITIAL_APPLY_ALCHEMISTS_AMULET = "You apply 30 charges to your Alchemist's amulet.";
	private static final String ADDITIONAL_APPLY_ALCHEMISTS_AMULET = "You apply an additional 70 charges to your Alchemist's<br>amulet. It now has 86 charges in total.";
	private static final String UNCHARGE_ALCHEMISTS_AMULET = "You uncharge your Alchemist's amulet, regaining 3<br>amulets of chemistry in the process.";

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ClientThread clientThread;

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

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Inject
	private ItemChargePlugin itemChargePlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		// Stub the clientThread to run immediately in tests
		Mockito.doAnswer(invocation ->
		{
			Runnable runnable = invocation.getArgument(0);
			runnable.run();
			return null;
		}).when(clientThread).invokeLater(Mockito.any(Runnable.class));
	}

	// Dodgy necklace
	@Test
	public void testDodgyCheck()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_DODGY_NECKLACE, 10);
	}

	@Test
	public void testDodgyProtect()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", PROTECT, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_DODGY_NECKLACE, 9);
	}

	@Test
	public void testDodgyProtect1()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", PROTECT_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_DODGY_NECKLACE, 1);
	}

	@Test
	public void testDodgyBreak()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_DODGY_NECKLACE, 10);
	}

	// Ring of forging
	@Test
	public void testRofOne()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_RING_OF_FORGING_ONE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_RING_OF_FORGING, 1);
	}

	@Test
	public void testRofFull()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_RING_OF_FORGING_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_RING_OF_FORGING, 140);
	}

	@Test
	public void testRof()
	{
		when(configManager.getRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_RING_OF_FORGING, Integer.class)).thenReturn(90);
		// Create equipment inventory with ring of forging
		ItemContainer equipmentItemContainer = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipmentItemContainer);
		when(equipmentItemContainer.contains(ItemID.RING_OF_FORGING)).thenReturn(true);
		when(equipmentItemContainer.getItems()).thenReturn(new Item[0]);
		// Run message
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_RING_OF_FORGING, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_RING_OF_FORGING, 89);
	}

	@Test
	public void testRofBreak()
	{
		// Create equipment inventory with ring of forging
		ItemContainer equipmentItemContainer = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipmentItemContainer);
		when(equipmentItemContainer.contains(ItemID.RING_OF_FORGING)).thenReturn(true);
		when(equipmentItemContainer.getItems()).thenReturn(new Item[0]);
		// Run message to break ring and then use ring, to simulate actual client behavior
		ChatMessage breakMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_RING_OF_FORGING, "", 0);
		itemChargePlugin.onChatMessage(breakMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_RING_OF_FORGING, 141);
		when(configManager.getRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_RING_OF_FORGING, Integer.class)).thenReturn(141);
		ChatMessage useMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_RING_OF_FORGING, "", 0);
		itemChargePlugin.onChatMessage(useMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_RING_OF_FORGING, 140);
	}

	// Chemistry
	@Test
	public void testChemistryCheck()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_AMULET_OF_CHEMISTRY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, 5);
	}

	@Test
	public void testChemistry1()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_AMULET_OF_CHEMISTRY_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, 1);
	}

	@Test
	public void testChemistryUsed4()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_AMULET_OF_CHEMISTRY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, 4);
	}

	@Test
	public void testChemistryUsed3()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_AMULET_OF_CHEMISTRY_3_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, 2);
	}

	@Test
	public void testChemistryUsed2()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_AMULET_OF_CHEMISTRY_2_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, 1);
	}

	@Test
	public void testChemistryBreak()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_AMULET_OF_CHEMISTRY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, 5);
	}

	@Test
	public void testChemistryBreak3()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_AMULET_OF_CHEMISTRY_3_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
	}

	@Test
	public void testChemistryBreak2()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_AMULET_OF_CHEMISTRY_2_DOSES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, 5);
	}

	// Chronicle
	@Test
	public void testChronicleCheckFull()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_CHECK_CHARGES_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 1000);
	}

	@Test
	public void testChronicleChargeOne()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_CHECK_CHARGES_ONE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 1);
	}

	@Test
	public void testChronicleChargeEmpty()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_CHECK_CHARGES_EMPTY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 0);
	}

	@Test
	public void testChronicleTeleport()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 999);
	}

	@Test
	public void testChronicleTeleportOne()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT_ONE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 1);
	}

	@Test
	public void testChronicleTeleportEmpty()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT_EMPTY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 0);
	}

	@Test
	public void testChronicleTeleportFail()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_TELEPORT_FAIL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 0);
	}

	@Test
	public void testChronicleAddSingleCharge()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_SINGLE_CHARGE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 1);
	}

	@Test
	public void testChronicleAddSingleChargeFull()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_SINGLE_CHARGE_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 1000);
	}

	@Test
	public void testChronicleAddMultipleCharges()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_MULTIPLE_CHARGES, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 5);
	}

	@Test
	public void testChronicleAddFull()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHRONICLE_ADD_FULL, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_CHRONICLE, 1000);
	}

	// Bracelet of Slaughter
	@Test
	public void testSlaughterCheck()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_BRACELET_OF_SLAUGHTER, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, 25);
	}

	@Test
	public void testSlaughterCheck1()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_BRACELET_OF_SLAUGHTER_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, 1);
	}

	@Test
	public void testSlaughterActivate()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", ACTIVATE_BRACELET_OF_SLAUGHTER, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, 16);
	}

	@Test
	public void testSlaughterBreak()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_BRACELET_OF_SLAUGHTER, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, 30);
	}

	@Test
	public void testSlaughterRegenerate()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", REGENERATE_BRACELET_OF_SLAUGHTER, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, 30);
	}

	// Expeditious Bracelet
	@Test
	public void testExpeditiousCheck()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_EXPEDITIOUS_BRACELET, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_EXPEDITIOUS_BRACELET, 6);
	}

	@Test
	public void testExpeditiousCheck1()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_EXPEDITIOUS_BRACELET_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_EXPEDITIOUS_BRACELET, 1);
	}

	@Test
	public void testExpeditiousActivate()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.SPAM, "", ACTIVATE_EXPEDITIOUS_BRACELET, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_EXPEDITIOUS_BRACELET, 11);
	}

	@Test
	public void testExpeditiousBreak()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_EXPEDITIOUS_BRACELET, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_EXPEDITIOUS_BRACELET, 30);
	}

	@Test
	public void testBloodEssenceActivate()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", ACTIVATE_BLOOD_ESSENCE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BLOOD_ESSENCE, 1000);
	}

	@Test
	public void testBloodEssenceExtract()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", EXTRACT_BLOOD_ESSENCE, "", 0);
		when(configManager.getConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BLOOD_ESSENCE, Integer.class)).thenReturn(1000);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BLOOD_ESSENCE, 933);
	}

	@Test
	public void testBloodEssenceCheck()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_BLOOD_ESSENCE, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BLOOD_ESSENCE, 56);
	}

	@Test
	public void testBraceletOfClayCheck()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_BRACELET_OF_CLAY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_CLAY, 13);
	}

	@Test
	public void testBraceletOfClayUsed()
	{
		when(configManager.getRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_CLAY, Integer.class)).thenReturn(25);
		// Create equipment inventory with bracelet of clay
		ItemContainer equipmentItemContainer = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipmentItemContainer);
		when(equipmentItemContainer.contains(ItemID.BRACELET_OF_CLAY)).thenReturn(true);
		when(equipmentItemContainer.getItems()).thenReturn(new Item[0]);
		// Run message
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_BRACELET_OF_CLAY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_CLAY, 24);
	}

	@Test
	public void testBraceletOfClayBreak()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", BREAK_BRACELET_OF_CLAY, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_CLAY, 28);
	}

	@Test
	public void testBraceletOfClayUseTrahaearn()
	{
		// Set bracelet of clay charges to 13
		when(configManager.getRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_CLAY, Integer.class))
			.thenReturn(13);

		// Equip bracelet of clay
		ItemContainer equipmentItemContainer = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT))
			.thenReturn(equipmentItemContainer);
		when(equipmentItemContainer.contains(ItemID.BRACELET_OF_CLAY)).thenReturn(true);
		when(equipmentItemContainer.getItems()).thenReturn(new Item[0]);

		// Set inventory to 2 free slots
		ItemContainer inventoryItemContainer = mock(ItemContainer.class);
		when(inventoryItemContainer.count()).thenReturn(26);
		when(client.getItemContainer(InventoryID.INVENTORY)).thenReturn(inventoryItemContainer);

		// Verify bracelet of clay charges decreased
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_BRACELET_OF_CLAY_TRAHAEARN, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_BRACELET_OF_CLAY, 12);
	}

	@Test
	public void testBraceletOfClayUseTrahaearn1FreeInvSlot()
	{
		// Equip bracelet of clay
		ItemContainer equipmentItemContainer = mock(ItemContainer.class);
		when(client.getItemContainer(InventoryID.EQUIPMENT))
			.thenReturn(equipmentItemContainer);
		when(equipmentItemContainer.contains(ItemID.BRACELET_OF_CLAY))
			.thenReturn(true);

		// Set inventory to 1 free slots
		ItemContainer inventoryItemContainer = mock(ItemContainer.class);
		when(inventoryItemContainer.count())
			.thenReturn(27);
		when(client.getItemContainer(InventoryID.INVENTORY))
			.thenReturn(inventoryItemContainer);

		// Verify bracelet of clay charges were not changed
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", USED_BRACELET_OF_CLAY_TRAHAEARN, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager, Mockito.times(0)).setRSProfileConfiguration(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt());
	}

	@Test
	public void testAlchemistsAmuletCheck()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_ALCHEMISTS_AMULET, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 25);
	}

	@Test
	public void testAlchemistsAmuletCheck1Charge()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", CHECK_ALCHEMISTS_AMULET_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 1);
	}

	@Test
	public void testAlchemistsAmuletActivate()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", ACTIVATE_ALCHEMISTS_AMULET, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 25);
	}

	@Test
	public void testAlchemistsAmuletActivate1Charge()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", ACTIVATE_ALCHEMISTS_AMULET_1, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 1);
	}

	@Test
	public void testAlchemistsAmuletDepleted()
	{
		ChatMessage chatMessage = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", DEPLETED_ALCHEMISTS_AMULET, "", 0);
		itemChargePlugin.onChatMessage(chatMessage);
		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 0);
	}

	@Test
	public void testAlchemistsAmuletInitialApply()
	{
		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.DIALOG_SPRITE);

		Widget textWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.DIALOG_SPRITE_TEXT)).thenReturn(textWidget);
		when(textWidget.getText()).thenReturn(INITIAL_APPLY_ALCHEMISTS_AMULET);

		itemChargePlugin.onWidgetLoaded(widgetLoaded);

		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 30);
	}

	@Test
	public void testAlchemistsAmuletAdditionalApply()
	{
		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.DIALOG_SPRITE);

		Widget textWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.DIALOG_SPRITE_TEXT)).thenReturn(textWidget);
		when(textWidget.getText()).thenReturn(ADDITIONAL_APPLY_ALCHEMISTS_AMULET);

		itemChargePlugin.onWidgetLoaded(widgetLoaded);

		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 86);
	}

	@Test
	public void testAlchemistsAmuletUncharge()
	{
		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.DIALOG_SPRITE);

		Widget textWidget = mock(Widget.class);
		when(client.getWidget(ComponentID.DIALOG_SPRITE_TEXT)).thenReturn(textWidget);
		when(textWidget.getText()).thenReturn(UNCHARGE_ALCHEMISTS_AMULET);

		itemChargePlugin.onWidgetLoaded(widgetLoaded);

		verify(configManager).setRSProfileConfiguration(ItemChargeConfig.GROUP, ItemChargeConfig.KEY_ALCHEMISTS_AMULET, 0);
	}
}
