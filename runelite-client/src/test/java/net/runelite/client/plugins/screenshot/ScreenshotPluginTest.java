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
import javax.inject.Inject;
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import static net.runelite.api.ChatMessageType.TRADE;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
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
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScreenshotPluginTest
{
	private static final String CLUE_SCROLL = "<col=3300ff>You have completed 2,823 medium Treasure Trails</col>";
	private static final String BARROWS_CHEST = "Your Barrows chest count is <col=ff0000>310</col>";
	private static final String CHAMBERS_OF_XERIC_CHEST = "Your completed Chambers of Xeric count is: <col=ff0000>489</col>.";
	private static final String THEATRE_OF_BLOOD_CHEST = "Your completed Theatre of Blood count is: <col=ff0000>73</col>.";
	private static final String THREATRE_OF_BLOOD_SM_CHEST = "Your completed Theatre of Blood: Story Mode count is: <col=ff0000>73</col>.";
	private static final String THREATRE_OF_BLOOD_HM_CHEST = "Your completed Theatre of Blood: Hard Mode count is: <col=ff0000>73</col>.";
	private static final String NOT_SO_VALUABLE_DROP = "<col=ef1020>Valuable drop: 6 x Bronze arrow (42 coins)</col>";
	private static final String VALUABLE_DROP = "<col=ef1020>Valuable drop: Rune scimitar (25,600 coins)</col>";
	private static final String UNTRADEABLE_DROP = "<col=ef1020>Untradeable drop: Rusty sword";
	private static final String BA_HIGH_GAMBLE_REWARD = "Raw shark (x 300)!<br>High level gamble count: <col=7f0000>100</col>";
	private static final String HUNTER_LEVEL_2_TEXT = "<col=000080>Congratulations, you've just advanced a Hunter level.<col=000000><br><br>Your Hunter level is now 2.";
	private static final String CRAFTING_LEVEL_96_MESSAGE = "Congratulations, you've just advanced your Crafting level. You are now level 96.";
	private static final String STRENGTH_LEVEL_99_MESSAGE = "Congratulations, you've reached the highest possible Strength level of 99.";
	private static final String COLLECTION_LOG_CHAT = "New item added to your collection log: <col=ef1020>Chompy bird hat</col>";

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
		screenshotPlugin = spy(screenshotPlugin);
		when(screenshotConfig.screenshotLevels()).thenReturn(true);
		when(screenshotConfig.screenshotValuableDrop()).thenReturn(true);
		when(screenshotConfig.valuableDropThreshold()).thenReturn(1000);
		when(screenshotConfig.screenshotUntradeableDrop()).thenReturn(true);
		when(screenshotConfig.screenshotCollectionLogEntries()).thenReturn(true);
		when(screenshotConfig.screenshotDuels()).thenReturn(true);
	}

	@Test
	public void testClueScroll()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", CLUE_SCROLL, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals("medium", screenshotPlugin.getClueType());
		assertEquals(2823, screenshotPlugin.getClueNumber());
	}

	@Test
	public void testBarrowsChest()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", BARROWS_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(310, screenshotPlugin.getKillCountNumber());
	}

	@Test
	public void testChambersOfXericChest()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Seth", CHAMBERS_OF_XERIC_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(489, screenshotPlugin.getKillCountNumber());
	}

	@Test
	public void testTheatreOfBloodChest()
	{
		when(screenshotConfig.screenshotRewards()).thenReturn(true);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Magic fTail", THEATRE_OF_BLOOD_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(73, screenshotPlugin.getKillCountNumber());
		assertEquals(ScreenshotPlugin.KillType.TOB, screenshotPlugin.getKillType());

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.TOB_CHESTS);
		screenshotPlugin.onWidgetLoaded(widgetLoaded);

		verify(screenshotPlugin).takeScreenshot("Theatre of Blood(73)", "Boss Kills");
	}

	@Test
	public void testTheatreOfBloodSmChest()
	{
		when(screenshotConfig.screenshotRewards()).thenReturn(true);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Magic fTail", THREATRE_OF_BLOOD_SM_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(73, screenshotPlugin.getKillCountNumber());
		assertEquals(ScreenshotPlugin.KillType.TOB_SM, screenshotPlugin.getKillType());

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.TOB_CHESTS);
		screenshotPlugin.onWidgetLoaded(widgetLoaded);

		verify(screenshotPlugin).takeScreenshot("Theatre of Blood Story Mode(73)", "Boss Kills");
	}

	@Test
	public void testTheatreOfBloodHmChest()
	{
		when(screenshotConfig.screenshotRewards()).thenReturn(true);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Magic fTail", THREATRE_OF_BLOOD_HM_CHEST, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		assertEquals(73, screenshotPlugin.getKillCountNumber());
		assertEquals(ScreenshotPlugin.KillType.TOB_HM, screenshotPlugin.getKillType());

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.TOB_CHESTS);
		screenshotPlugin.onWidgetLoaded(widgetLoaded);

		verify(screenshotPlugin).takeScreenshot("Theatre of Blood Hard Mode(73)", "Boss Kills");
	}

	@Test
	public void testNotSoValuableDrop()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", NOT_SO_VALUABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());

		when(screenshotConfig.valuableDropThreshold()).thenReturn(0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Valuable drop 6 x Bronze arrow (42 coins)", "Valuable Drops");
	}

	@Test
	public void testValuableDrop()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", VALUABLE_DROP, null, 0);
		when(screenshotConfig.valuableDropThreshold()).thenReturn(100_000);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());

		when(screenshotConfig.valuableDropThreshold()).thenReturn(1000);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Valuable drop Rune scimitar (25,600 coins)", "Valuable Drops");
	}

	@Test
	public void testUntradeableDrop()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", UNTRADEABLE_DROP, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Untradeable drop Rusty sword", "Untradeable Drops");
	}

	@Test
	public void testHitpointsLevel99()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(InterfaceID.LevelupDisplay.TEXT2)).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn("Your Hitpoints are now 99.");

		assertEquals("Hitpoints(99)", screenshotPlugin.parseLevelUpWidget(InterfaceID.LevelupDisplay.TEXT2));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(InterfaceID.LEVELUP_DISPLAY);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(screenshotPlugin).takeScreenshot("Hitpoints(99)", "Levels");
	}

	@Test
	public void testFiremakingLevel9()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(InterfaceID.LevelupDisplay.TEXT2)).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn("Your Firemaking level is now 9.");

		assertEquals("Firemaking(9)", screenshotPlugin.parseLevelUpWidget(InterfaceID.LevelupDisplay.TEXT2));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(InterfaceID.LEVELUP_DISPLAY);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(screenshotPlugin).takeScreenshot("Firemaking(9)", "Levels");
	}

	@Test
	public void testAttackLevel70()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(InterfaceID.LevelupDisplay.TEXT2)).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn("Your Attack level is now 70.");

		assertEquals("Attack(70)", screenshotPlugin.parseLevelUpWidget(InterfaceID.LevelupDisplay.TEXT2));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(InterfaceID.LEVELUP_DISPLAY);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(screenshotPlugin).takeScreenshot("Attack(70)", "Levels");
	}

	@Test
	public void testHunterLevel2()
	{
		Widget levelChild = mock(Widget.class);
		when(client.getWidget(InterfaceID.Objectbox.TEXT)).thenReturn(levelChild);

		when(levelChild.getText()).thenReturn(HUNTER_LEVEL_2_TEXT);

		assertEquals("Hunter(2)", screenshotPlugin.parseLevelUpWidget(InterfaceID.Objectbox.TEXT));

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(InterfaceID.OBJECTBOX);
		screenshotPlugin.onWidgetLoaded(event);

		GameTick tick = new GameTick();
		screenshotPlugin.onGameTick(tick);

		verify(screenshotPlugin).takeScreenshot("Hunter(2)", "Levels");
	}

	@Test
	public void testCraftingLevel96NoInterface()
	{
		when(client.getVarbitValue(VarbitID.OPTION_LEVEL_UP_MESSAGE)).thenReturn(1);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", CRAFTING_LEVEL_96_MESSAGE, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Crafting(96)", "Levels");
		reset(screenshotPlugin);

		when(client.getVarbitValue(VarbitID.OPTION_LEVEL_UP_MESSAGE)).thenReturn(0);

		screenshotPlugin.onChatMessage(chatMessageEvent);
		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());
	}

	@Test
	public void testStrengthLevel99NoInterface()
	{
		when(client.getVarbitValue(VarbitID.OPTION_LEVEL_UP_MESSAGE)).thenReturn(1);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", STRENGTH_LEVEL_99_MESSAGE, null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Strength(99)", "Levels");
		reset(screenshotPlugin);

		when(client.getVarbitValue(VarbitID.OPTION_LEVEL_UP_MESSAGE)).thenReturn(0);

		screenshotPlugin.onChatMessage(chatMessageEvent);
		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());
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
	public void testCombatAchievementsParsing()
	{
		assertEquals("Combat task (Into the Den of Giants)", ScreenshotPlugin.parseCombatAchievementWidget("Congratulations, you've completed an easy combat task: <col=06600c>Into the Den of Giants</col>."));
		assertEquals("Combat task (I'd Rather Not Learn)", ScreenshotPlugin.parseCombatAchievementWidget("Congratulations, you've completed a medium combat task: <col=06600c>I'd Rather Not Learn</col>."));
		assertEquals("Combat task (Why Cook)", ScreenshotPlugin.parseCombatAchievementWidget("Congratulations, you've completed a hard combat task: <col=0cc919>Why Cook?</col>."));
		assertEquals("Combat task (From Dusk...)", ScreenshotPlugin.parseCombatAchievementWidget("Congratulations, you've completed an elite combat task: <col=06600c>From Dusk...</col>."));
		assertEquals("Combat task (Perfect Olm (Trio))", ScreenshotPlugin.parseCombatAchievementWidget("Congratulations, you've completed a master combat task: <col=0cc919>Perfect Olm (Trio)</col>."));
		assertEquals("Combat task (Chambers of Xeric CM (5-Scale) Speed-Runner)", ScreenshotPlugin.parseCombatAchievementWidget("Congratulations, you've completed a grandmaster combat task: <col=0cc919>Chambers of Xeric: CM (5-Scale) Speed-Runner</col>."));
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
		when(client.getWidget(InterfaceID.Objectbox.TEXT)).thenReturn(dialogChild);

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(InterfaceID.OBJECTBOX);
		screenshotPlugin.onWidgetLoaded(event);

		screenshotPlugin.onGameTick(new GameTick());

		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());
	}

	@Test
	public void testBAHighGambleScreenshotsDisabled()
	{
		// BA high gamble results use the same widget interface as level up dialogs
		when(screenshotConfig.screenshotLevels()).thenReturn(true);
		when(screenshotConfig.screenshotHighGamble()).thenReturn(false);
		Widget dialogChild = mock(Widget.class);
		when(dialogChild.getText()).thenReturn(BA_HIGH_GAMBLE_REWARD);
		when(client.getWidget(InterfaceID.Objectbox.TEXT)).thenReturn(dialogChild);

		WidgetLoaded event = new WidgetLoaded();
		event.setGroupId(InterfaceID.OBJECTBOX);
		screenshotPlugin.onWidgetLoaded(event);

		screenshotPlugin.onGameTick(new GameTick());

		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());
	}

	@Test
	public void testCollectionLogPopup()
	{
		ScriptPreFired notificationStart = new ScriptPreFired(ScriptID.NOTIFICATION_START);
		screenshotPlugin.onScriptPreFired(notificationStart);

		when(client.getVarcStrValue(VarClientStr.NOTIFICATION_TOP_TEXT)).thenReturn("Collection log");
		when(client.getVarcStrValue(VarClientStr.NOTIFICATION_BOTTOM_TEXT)).thenReturn("New item:<br><br><col=ffffff>Chompy bird hat</col>");

		ScriptPreFired notificationDelay = new ScriptPreFired(ScriptID.NOTIFICATION_DELAY);
		screenshotPlugin.onScriptPreFired(notificationDelay);

		verify(screenshotPlugin).takeScreenshot("Collection log (Chompy bird hat)", "Collection Log");
	}

	@Test
	public void testCollectionLogChat()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", COLLECTION_LOG_CHAT, null, 0);

		when(client.getVarbitValue(VarbitID.OPTION_COLLECTION_NEW_ITEM)).thenReturn(1);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Collection log (Chompy bird hat)", "Collection Log");
		reset(screenshotPlugin);

		when(client.getVarbitValue(VarbitID.OPTION_COLLECTION_NEW_ITEM)).thenReturn(3);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());
	}

	@Test
	public void testDuelWin()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, TRADE, "", "You won! You have now won 1,909 duels.", null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Duel won (1909)", "Duels");
		reset(screenshotPlugin);

		chatMessageEvent = new ChatMessage(null, TRADE, "", "You have lost 145 duels.", null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());
	}

	@Test
	public void testDuelLoss()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, TRADE, "", "You were defeated! You have won 1,909 duels.", null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin, never()).takeScreenshot(anyString(), anyString());

		chatMessageEvent = new ChatMessage(null, TRADE, "", "You have now lost 1,909 duels.", null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Duel lost (1909)", "Duels");
	}

	@Test
	public void testCombatAchievementsPopup()
	{
		when(screenshotConfig.screenshotCombatAchievements()).thenReturn(true);

		ScriptPreFired notificationStart = new ScriptPreFired(ScriptID.NOTIFICATION_START);
		screenshotPlugin.onScriptPreFired(notificationStart);

		when(client.getVarcStrValue(VarClientStr.NOTIFICATION_TOP_TEXT)).thenReturn("Combat Task Completed!");
		when(client.getVarcStrValue(VarClientStr.NOTIFICATION_BOTTOM_TEXT)).thenReturn("Task Completed: <col=ffffff>Handyman</col> (6 points)");

		ScriptPreFired notificationDelay = new ScriptPreFired(ScriptID.NOTIFICATION_DELAY);
		screenshotPlugin.onScriptPreFired(notificationDelay);

		verify(screenshotPlugin).takeScreenshot("Combat task (Handyman)", "Combat Achievements");
	}

	@Test
	public void testCombatAchievementsChat()
	{
		when(screenshotConfig.screenshotCombatAchievements()).thenReturn(true);

		when(client.getVarbitValue(VarbitID.CA_TASK_POPUP)).thenReturn(1);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "",
			"Congratulations, you've completed a grandmaster combat task: <col=06600c>Egniol Diet II</col> (6 points).", null, 0);
		screenshotPlugin.onChatMessage(chatMessageEvent);

		verify(screenshotPlugin).takeScreenshot("Combat task (Egniol Diet II)", "Combat Achievements");
	}

	@Test
	public void testWildernessLootChest()
	{
		when(screenshotConfig.screenshotWildernessLootChest()).thenReturn(true);

		WidgetLoaded widgetLoaded = new WidgetLoaded();
		widgetLoaded.setGroupId(InterfaceID.WILDY_LOOT_CHEST);
		screenshotPlugin.onWidgetLoaded(widgetLoaded);

		verify(screenshotPlugin).takeScreenshot("Loot key", "Wilderness Loot Chest");
	}

	@Test
	public void testBossKillCount()
	{
		when(screenshotConfig.screenshotBossKills()).thenReturn(true);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your Nightmare kill count is: <col=ff0000>1,130</col>", null, 0);
		screenshotPlugin.onChatMessage(chatMessage);

		verify(screenshotPlugin).takeScreenshot("Nightmare(1130)", "Boss Kills");
	}

	@Test
	public void testEchoBossKillCount()
	{
		when(screenshotConfig.screenshotBossKills()).thenReturn(true);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your <col=6800bf>Kalphite Queen (Echo)</col> kill count is:<col=e00a19>1</col>", null, 1);
		screenshotPlugin.onChatMessage(chatMessage);

		verify(screenshotPlugin).takeScreenshot("Kalphite Queen (Echo)(1)", "Boss Kills");
	}

	@Test
	public void testEchoGauntletKillCount()
	{
		when(screenshotConfig.screenshotBossKills()).thenReturn(true);
		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", "Your <col=a53fff>Corrupted Hunllef (Echo)</col> kill count is: <col=ff3045>31</col>", null, 0);
		screenshotPlugin.onChatMessage(chatMessage);
		verify(screenshotPlugin).takeScreenshot("Corrupted Hunllef (Echo)(31)", "Boss Kills");
	}

}
