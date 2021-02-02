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
package net.runelite.client.plugins.screenshot;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import javax.inject.Inject;
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import static net.runelite.api.widgets.WidgetID.DIALOG_SPRITE_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.LEVEL_UP_GROUP_ID;
import static net.runelite.api.widgets.WidgetInfo.DIALOG_SPRITE_TEXT;
import static net.runelite.api.widgets.WidgetInfo.LEVEL_UP_LEVEL;
import net.runelite.client.Notifier;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ImageCapture;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScreenshotPluginTest
{
	private static final String CLUE_SCROLL = "<col=3300ff>You have completed 28 medium Treasure Trails</col>";
	private static final String BARROWS_CHEST = "Your Barrows chest count is <col=ff0000>310</col>";
	private static final String CHAMBERS_OF_XERIC_CHEST = "Your completed Chambers of Xeric count is: <col=ff0000>489</col>.";
	private static final String THEATRE_OF_BLOOD_CHEST = "Your completed Theatre of Blood count is: <col=ff0000>73</col>.";
	private static final String NOT_SO_VALUABLE_DROP = "<col=ef1020>Valuable drop: 6 x Bronze arrow (42 coins)</col>";
	private static final String VALUABLE_DROP = "<col=ef1020>Valuable drop: Rune scimitar (25,600 coins)</col>";
	private static final String UNTRADEABLE_DROP = "<col=ef1020>Untradeable drop: Rusty sword";
	private static final String BA_HIGH_GAMBLE_REWARD = "Raw shark (x 300)!<br>High level gamble count: <col=7f0000>100</col>";
	private static final String HUNTER_LEVEL_2_TEXT = "<col=000080>Congratulations, you've just advanced a Hunter level.<col=000000><br><br>Your Hunter level is now 2.";

	@Mock
	@Bind
	private Client client;

	@Inject
	private ScreenshotPlugin screenshotPlugin;

	@Mock
	@Bind
	private ScreenshotConfig screenshotConfig;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	ClientUI clientUi;

	@Mock
	@Bind
	DrawManager drawManager;

	@Mock
	@Bind
	RuneLiteConfig config;

	@Mock
	@Bind
	ScheduledExecutorService service;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private ImageCapture imageCapture;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(screenshotConfig.screenshotLevels()).thenReturn(true);
		when(screenshotConfig.screenshotValuableDrop()).thenReturn(true);
		when(screenshotConfig.valuableDropThreshold()).thenReturn(1000);
		when(screenshotConfig.screenshotUntradeableDrop()).thenReturn(true);
	}

	@Test
	public void testClueScroll()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", CLUE_SCROLL, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals("medium", screenshotPlugin.getClueType());
		assertEquals(28, screenshotPlugin.getClueNumber());
	}

	@Test
	public void testBarrowsChest()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", BARROWS_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(310, screenshotPlugin.getBarrowsNumber());
	}

	@Test
	public void testChambersOfXericChest()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", CHAMBERS_OF_XERIC_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(489, screenshotPlugin.getChambersOfXericNumber());
	}

	@Test
	public void testTheatreOfBloodChest()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Magic fTail", THEATRE_OF_BLOOD_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(73, screenshotPlugin.gettheatreOfBloodNumber());
	}

	@Test
	public void testNotSoValuableDrop()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", NOT_SO_VALUABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verifyNoInteractions(drawManager);

		when(screenshotConfig.valuableDropThreshold()).thenReturn(0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testValuableDrop()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", VALUABLE_DROP, null, 0);
		when(screenshotConfig.valuableDropThreshold()).thenReturn(100_000);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verifyNoInteractions(drawManager);

		when(screenshotConfig.valuableDropThreshold()).thenReturn(1000);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testUntradeableDrop()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", UNTRADEABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testHitpointsLevel99()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn("Your Hitpoints are now 99.");

		assertEquals("Hitpoints(99)", screenshotPlugin.parseLevelUpWidget(LEVEL_UP_LEVEL));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(LEVEL_UP_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testFiremakingLevel9()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn("Your Firemaking level is now 9.");

		assertEquals("Firemaking(9)", screenshotPlugin.parseLevelUpWidget(LEVEL_UP_LEVEL));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(LEVEL_UP_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testAttackLevel70()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(LEVEL_UP_LEVEL))).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn("Your Attack level is now 70.");

		assertEquals("Attack(70)", screenshotPlugin.parseLevelUpWidget(LEVEL_UP_LEVEL));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(LEVEL_UP_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testHunterLevel2()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(eq(DIALOG_SPRITE_TEXT))).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn(HUNTER_LEVEL_2_TEXT);

		assertEquals("Hunter(2)", screenshotPlugin.parseLevelUpWidget(DIALOG_SPRITE_TEXT));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(DIALOG_SPRITE_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(drawManager).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testQuestParsing()
	{
		assertEquals("Quest(The Corsair Curse)", ScreenshotPlugin.parseQuestCompletedWidget("You have completed The Corsair Curse!"));
		assertEquals("Quest(One Small Favour)", ScreenshotPlugin.parseQuestCompletedWidget("'One Small Favour' completed!"));
		assertEquals("Quest(Hazeel Cult partial completion)", ScreenshotPlugin.parseQuestCompletedWidget("You have... kind of... completed the Hazeel Cult Quest!"));
		assertEquals("Quest(Rag and Bone Man II)", ScreenshotPlugin.parseQuestCompletedWidget("You have completely completed Rag and Bone Man!"));
		assertEquals("Quest(Recipe for Disaster - Culinaromancer)", ScreenshotPlugin.parseQuestCompletedWidget("Congratulations! You have defeated the Culinaromancer!"));
		assertEquals("Quest(Recipe for Disaster - Another Cook's Quest)", ScreenshotPlugin.parseQuestCompletedWidget("You have completed Another Cook's Quest!"));
		assertEquals("Quest(Doric's Quest)", ScreenshotPlugin.parseQuestCompletedWidget("You have completed Doric's Quest!"));
		assertEquals("Quest(quest not found)", ScreenshotPlugin.parseQuestCompletedWidget("Sins of the Father forgiven!"));
	}

	@Test
	public void testBAHighGambleRewardParsing()
	{
		assertEquals("High Gamble(100)", ScreenshotPlugin.parseBAHighGambleWidget(BA_HIGH_GAMBLE_REWARD));
	}

	@Test
	public void testLevelUpScreenshotsDisabled()
	{
		// Level up dialogs use the same widget interface as BA high gamble results
		when(screenshotConfig.screenshotLevels()).thenReturn(false);
		when(screenshotConfig.screenshotHighGamble()).thenReturn(true);
		Widget dialogChild = mock(Widget.class);
		when(dialogChild.getText()).thenReturn(HUNTER_LEVEL_2_TEXT);
		when(client.getWidget(DIALOG_SPRITE_TEXT)).thenReturn(dialogChild);

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(DIALOG_SPRITE_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		screenshotPlugin.onGameTick(new GameTick());

		verify(drawManager, times(0)).requestNextFrameListener(any(Consumer.class));
	}

	@Test
	public void testBAHighGambleScreenshotsDisabled()
	{
		// BA high gamble results use the same widget interface as level up dialogs
		when(screenshotConfig.screenshotLevels()).thenReturn(true);
		when(screenshotConfig.screenshotHighGamble()).thenReturn(false);
		Widget dialogChild = mock(Widget.class);
		when(dialogChild.getText()).thenReturn(BA_HIGH_GAMBLE_REWARD);
		when(client.getWidget(DIALOG_SPRITE_TEXT)).thenReturn(dialogChild);

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(DIALOG_SPRITE_GROUP_ID);
		screenshotPlugin.onWidgetLoaded(event);

		screenshotPlugin.onGameTick(new GameTick());

		verify(drawManager, times(0)).requestNextFrameListener(any(Consumer.class));
	}
}
