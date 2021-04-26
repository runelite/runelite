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
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NullObjectID;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.banktags.TagManager;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
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

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void getGetMirrorPoint()
	{
		WorldPoint point, converted;

		// Zalcano's entrance portal
		point = new WorldPoint(3282, 6058, 0);
		converted = ClueScrollPlugin.getMirrorPoint(point, true);
		assertNotEquals(point, converted);

		// Elven Crystal Chest, which is upstairs
		point = new WorldPoint(3273, 6082, 2);
		converted = ClueScrollPlugin.getMirrorPoint(point, true);
		assertNotEquals(point, converted);

		// Around the area of the Elite coordinate clue
		point = new WorldPoint(2185, 3280, 0);
		// To overworld
		converted = ClueScrollPlugin.getMirrorPoint(point, true);
		assertEquals(point, converted);
		// To real
		converted = ClueScrollPlugin.getMirrorPoint(point, false);
		assertNotEquals(point, converted);

		// Brugsen Bursen, Grand Exchange
		point = new WorldPoint(3165, 3477, 0);
		converted = ClueScrollPlugin.getMirrorPoint(point, false);
		assertEquals(point, converted);
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
		plugin.onGameTick(new GameTick());
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
		plugin.onGameTick(new GameTick());

		// Simulate clicking on the STASH
		MenuOptionClicked menuOptionClicked = new MenuOptionClicked();
		menuOptionClicked.setMenuOption("Search");
		menuOptionClicked.setMenuTarget("<col=ffff>STASH unit (easy)");
		menuOptionClicked.setId(NullObjectID.NULL_28983);
		plugin.onMenuOptionClicked(menuOptionClicked);

		// Check that the STASH is stored after withdrawing
		ChatMessage withdrawMessage = new ChatMessage();
		withdrawMessage.setType(ChatMessageType.GAMEMESSAGE);
		withdrawMessage.setMessage("You withdraw your items from the STASH unit.");
		plugin.onChatMessage(withdrawMessage);
		assertNotNull(plugin.getActiveSTASHClue());

		// Complete the step and get a new step, check that the clue is stored for rendering
		when(clueWidget.getText()).thenReturn("Talk to the bartender of the Rusty Anchor in Port Sarim.");
		plugin.onGameTick(new GameTick());
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
}
