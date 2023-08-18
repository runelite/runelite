/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2019 Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.cluescrolls;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NullObjectID;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.banktags.TagManager;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClueScrollPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	Scene scene;

	@Mock
	@Bind
	ClientThread clientThread;

	@Inject
	ClueScrollPlugin plugin;

	@Bind
	@Named("developerMode")
	boolean developerMode;

	@Mock
	@Bind
	ClueScrollConfig config;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	TagManager tagManager;

	@Mock
	@Bind
	ConfigManager configManager;

	@Mock
	@Bind
	ChatboxPanelManager chatboxPanelManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testLocationHintArrowCleared()
	{
		final Widget clueWidget = mock(Widget.class);
		when(clueWidget.getText()).thenReturn("Buried beneath the ground, who knows where it's found. Lucky for you, A man called Reldo may have a clue.");
		final ChatMessage hotColdMessage = new ChatMessage();
		hotColdMessage.setType(ChatMessageType.GAMEMESSAGE);
		final Player localPlayer = mock(Player.class);

		when(client.getWidget(WidgetInfo.CLUE_SCROLL_TEXT)).thenReturn(clueWidget);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(client.getPlane()).thenReturn(0);
		when(client.getCachedNPCs()).thenReturn(new NPC[] {});
		when(config.displayHintArrows()).thenReturn(true);

		// The hint arrow should be reset each game tick from when the clue is read onward
		// This is to verify the arrow is cleared the correct number of times during the clue updating process.
		int clueSetupHintArrowClears = 0;

		// Initialize a beginner hot-cold clue (which will have an end point of LUMBRIDGE_COW_FIELD)
		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(WidgetID.CLUE_SCROLL_GROUP_ID);
		plugin.onWidgetLoaded(widgetLoaded);

		// clientthread callback
		ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		verify(client, times(++clueSetupHintArrowClears)).clearHintArrow();

		// Perform the first hot-cold check in Lumbridge near sheep pen (get 2 possible points: LUMBRIDGE_COW_FIELD and DRAYNOR_WHEAT_FIELD)
		when(localPlayer.getWorldLocation()).thenReturn(new WorldPoint(3208, 3254, 0));
		hotColdMessage.setMessage("The device is hot.");
		plugin.onChatMessage(hotColdMessage);

		// Move to SW of DRAYNOR_WHEAT_FIELD (hint arrow should be visible here)
		when(localPlayer.getWorldLocation()).thenReturn(new WorldPoint(3105, 3265, 0));
		when(client.getBaseX()).thenReturn(3056);
		when(client.getBaseY()).thenReturn(3216);
		plugin.onGameTick(new GameTick());
		verify(client, times(++clueSetupHintArrowClears)).clearHintArrow();
		verify(client).setHintArrow(HotColdLocation.DRAYNOR_WHEAT_FIELD.getWorldPoint());

		// Test in that location (get 1 possible location: LUMBRIDGE_COW_FIELD)
		hotColdMessage.setMessage("The device is hot, and warmer than last time.");
		plugin.onChatMessage(hotColdMessage);
		plugin.onGameTick(new GameTick());

		// Hint arrow should be cleared and not re-set now as the only remaining location is outside of the current
		// scene
		verify(client, times(++clueSetupHintArrowClears)).clearHintArrow();
		verify(client, times(1)).setHintArrow(any(WorldPoint.class));
	}

	@Test
	public void testSTASHMarkerPersistence()
	{
		when(client.getCachedNPCs()).thenReturn(new NPC[] {});

		// Set up emote clue
		final Widget clueWidget = mock(Widget.class);
		when(clueWidget.getText()).thenReturn("Spin in the Varrock Castle courtyard. Equip a black axe, a coif and a ruby ring.");
		when(client.getWidget(WidgetInfo.CLUE_SCROLL_TEXT)).thenReturn(clueWidget);

		// open clue
		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(WidgetID.CLUE_SCROLL_GROUP_ID);
		plugin.onWidgetLoaded(widgetLoaded);

		// clientthread callback
		ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		// Simulate clicking on the STASH
		MenuOptionClicked menuOptionClicked = mock(MenuOptionClicked.class);
		when(menuOptionClicked.getMenuOption()).thenReturn("Search");
		lenient().when(menuOptionClicked.getMenuTarget()).thenReturn("<col=ffff>STASH unit (easy)");
		when(menuOptionClicked.getId()).thenReturn(NullObjectID.NULL_28983);
		plugin.onMenuOptionClicked(menuOptionClicked);

		// Check that the STASH is stored after withdrawing
		ChatMessage withdrawMessage = new ChatMessage();
		withdrawMessage.setType(ChatMessageType.GAMEMESSAGE);
		withdrawMessage.setMessage("You withdraw your items from the STASH unit.");
		plugin.onChatMessage(withdrawMessage);
		assertNotNull(plugin.getActiveSTASHClue());

		// Complete the step and get a new step, check that the clue is stored for rendering
		when(clueWidget.getText()).thenReturn("Talk to the bartender of the Rusty Anchor in Port Sarim.");

		// open clue
		reset(clientThread);
		widgetLoaded.setGroupId(WidgetID.CLUE_SCROLL_GROUP_ID);
		plugin.onWidgetLoaded(widgetLoaded);

		// clientthread callback
		captor = ArgumentCaptor.forClass(Runnable.class);
		verify(clientThread).invokeLater(captor.capture());
		captor.getValue().run();

		assertNotNull(plugin.getActiveSTASHClue());

		// Simulate depositing the emote items, make sure it's cleared the stored clue
		ChatMessage depositMessage = new ChatMessage();
		depositMessage.setType(ChatMessageType.GAMEMESSAGE);
		depositMessage.setMessage("You deposit your items into the STASH unit.");
		plugin.onChatMessage(depositMessage);
		assertNull(plugin.getActiveSTASHClue());

		// Make sure that the STASH won't get re-marked if it's not part of the active clue.
		plugin.onMenuOptionClicked(menuOptionClicked);
		plugin.onChatMessage(withdrawMessage);
		assertNull(plugin.getActiveSTASHClue());
	}

	@Test
	public void testThatRunepouchIsAddedToInventory()
	{
		ItemContainer container = mock(ItemContainer.class);
		ItemContainerChanged event = new ItemContainerChanged(InventoryID.INVENTORY.getId(), container);

		final Item[] inventory = {
			new Item(ItemID.COINS_995, 100),
			new Item(ItemID.MITHRIL_BAR, 1),
			new Item(ItemID.MITHRIL_BAR, 1),
			new Item(ItemID.MITHRIL_BAR, 1),
			new Item(ItemID.SOUL_RUNE, 30),
			new Item(ItemID.COSMIC_RUNE, 100),
			new Item(ItemID.RUNE_POUCH, 1),
			new Item(ItemID.SPADE, 1),
			new Item(ItemID.CLUE_SCROLL_MASTER, 1)
		};

		when(container.getItems()).thenReturn(inventory);
		when(container.contains(ItemID.RUNE_POUCH)).thenReturn(true);

		when(client.getVarbitValue(Varbits.RUNE_POUCH_RUNE1)).thenReturn(9); // Cosmic Rune
		when(client.getVarbitValue(Varbits.RUNE_POUCH_AMOUNT1)).thenReturn(20);
		when(client.getVarbitValue(Varbits.RUNE_POUCH_RUNE3)).thenReturn(4); // Fire Rune
		when(client.getVarbitValue(Varbits.RUNE_POUCH_AMOUNT3)).thenReturn(4000);

		EnumComposition enumComposition = mock(EnumComposition.class);
		when(enumComposition.getIntValue(9)).thenReturn(ItemID.COSMIC_RUNE);
		when(enumComposition.getIntValue(4)).thenReturn(ItemID.FIRE_RUNE);
		when(client.getEnum(EnumID.RUNEPOUCH_RUNE)).thenReturn(enumComposition);

		plugin.onItemContainerChanged(event);

		assertFalse(Arrays.equals(inventory, plugin.getInventoryItems()));

		List<Item> inventoryList = Arrays.asList(plugin.getInventoryItems());

		assertThat(inventoryList, hasItem(new Item(ItemID.COSMIC_RUNE, 120)));
		assertThat(inventoryList, hasItem(new Item(ItemID.FIRE_RUNE, 4000)));
	}
}
