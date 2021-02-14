/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.slayer;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.StatChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.http.api.chat.ChatClient;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SlayerPluginTest
{
	private static final String TASK_NEW = "Your new task is to kill 231 Suqahs.";
	private static final String TASK_NEW_KONAR = "You are to bring balance to 147 Wyrms in the Karuulm Slayer Dungeon.";
	private static final String TASK_NEW_KONAR_2 = "You are to bring balance to 142 Hellhounds in Witchhaven Dungeon.";
	private static final String TASK_NEW_KONAR_3 = "You are to bring balance to 135 Trolls south of Mount Quidamortem.";
	private static final String TASK_NEW_FIRST = "We'll start you off hunting goblins, you'll need to kill 17 of them.";
	private static final String TASK_NEW_FIRST_KONAR = "We'll start you off bringing balance to cows, you'll need to kill 44 of them.";
	private static final String TASK_NEW_NPC_CONTACT = "Excellent, you're doing great. Your new task is to kill<br>211 Suqahs.";
	private static final String TASK_NEW_FROM_PARTNER = "You have received a new Slayer assignment from breaklulz: Dust Devils (377)";
	private static final String TASK_CHECKSLAYERGEM = "You're assigned to kill Suqahs; only 211 more to go.";
	private static final String TASK_CHECKSLAYERGEM_WILDERNESS = "You're assigned to kill Suqahs in the Wilderness; only 211 more to go.";
	private static final String TASK_CHECKSLAYERGEM_KONAR = "You're assigned to kill Blue dragons in the Ogre Enclave; only 122 more to go.";
	private static final String TASK_UPDATE_COMBAT_BRACELET = "You still need to kill 30 monsters to complete your current Slayer assignment";

	private static final String TASK_BOSS_NEW = "Excellent. You're now assigned to kill Vet'ion 3 times.<br>Your reward point tally is 914.";
	private static final String TASK_BOSS_NEW_THE = "Excellent. You're now assigned to kill the Chaos <br>Elemental 3 times. Your reward point tally is 914.";
	private static final String TASK_KONAR_BOSS = "You're now assigned to bring balance to the Alchemical<br>Hydra 35 times. Your reward point tally is 724.";

	private static final String TASK_EXISTING = "You're still hunting suqahs; you have 222 to go. Come<br>back when you've finished your task.";
	private static final String TASK_EXISTING_KONAR = "You're still bringing balance to adamant dragons in the Lithkren Vault, with 3 to go. Come back when you're finished.";
	private static final String TASK_EXISTING_WILDERNESS = "You're still meant to be slaying bandits in the Wilderness; you have 99 to go. Come back when you've finished your task.";

	private static final String TASK_ACTIVATESLAYERGEM = "You're currently assigned to kill fossil island wyverns; only 23 more to go. Your reward point tally is 46.";
	private static final String TASK_ACTIVATESLAYERGEM_KONAR = "You're currently assigned to bring balance to adamant dragons in the Lithkren Vault; you have 3 more to go. Your reward point tally is 16.";
	private static final String TASK_ACTIVATESLAYERGEM_WILDERNESS = "You're currently assigned to kill bandits in the Wilderness; only 99 more to go. Your reward point tally is 34.";

	private static final String REWARD_POINTS = "Reward points: 17,566";

	private static final String TASK_ONE = "<col=ef1020>You've completed </col>1 task<col=ef1020> and will need</col> 4 more <col=ef1020>before you start receiving Slayer points; return to a Slayer master.</col>";
	private static final String TASK_COMPLETE_NO_POINTS = "<col=ef1020>You've completed </col>3 tasks<col=ef1020> and will need </col>2 more<col=ef1020> before you start receiving Slayer points; return to a Slayer master.";
	private static final String TASK_POINTS = "<col=ef1020>You've completed </col>9 tasks <col=ef1020>and received </col>10 points<col=ef1020>, giving you a total of </col>18,000<col=ef1020>; return to a Slayer master.";
	private static final String TASK_LARGE_STREAK = "<col=ef1020>You've completed </col>2,465 tasks <col=ef1020>and received </col>15 points<col=ef1020>, giving you a total of </col>131,071<col=ef1020>; return to a Slayer master.";
	private static final String TASK_COMPETE_TURAEL = "<col=ef1020>You've completed </col>104 tasks <col=ef1020>. You'll be eligible to earn reward points if you complete tasks from a more advanced Slayer Master.";
	private static final String TASK_MAX_STREAK = "<col=ef1020>You've completed at least </col>16,000 tasks <col=ef1020>and received </col>15 points<col=ef1020>, giving you a total of </col>131,071<col=ef1020>; return to a Slayer master.";
	private static final String TASK_MAX_POINTS = "<col=ef1020>You've completed </col>9 tasks <col=ef1020>and reached the maximum amount of Slayer points </col>(131,071)<col=ef1020>; return to a Slayer master.";
	private static final String TASK_WILDERNESS = "<col=ef1020>You've completed </col>9 Wilderness tasks <col=ef1020>and received </col>10 points<col=ef1020>, giving you a total of </col>18,000<col=ef1020>; return to a Slayer master.";

	private static final String TASK_COMPLETE = "You need something new to hunt.";
	private static final String TASK_CANCELED = "Your task has been cancelled.";

	private static final String SUPERIOR_MESSAGE = "A superior foe has appeared...";

	private static final String BRACLET_SLAUGHTER = "Your bracelet of slaughter prevents your slayer count from decreasing. It has 9 charges left.";
	private static final String BRACLET_EXPEDITIOUS = "Your expeditious bracelet helps you progress your slayer task faster. It has 9 charges left.";

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ConfigManager configManager;

	@Mock
	@Bind
	SlayerConfig slayerConfig;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	SlayerOverlay overlay;

	@Mock
	@Bind
	InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	ChatCommandManager chatCommandManager;

	@Mock
	@Bind
	ScheduledExecutorService executor;

	@Mock
	@Bind
	ChatClient chatClient;

	@Inject
	SlayerPlugin slayerPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testNewTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(231, slayerPlugin.getAmount());
	}

	@Test
	public void testNewKonarTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_KONAR);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Wyrms", slayerPlugin.getTaskName());
		assertEquals(147, slayerPlugin.getAmount());
		assertEquals("Karuulm Slayer Dungeon", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testNewKonarTask2()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_KONAR_2);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Hellhounds", slayerPlugin.getTaskName());
		assertEquals(142, slayerPlugin.getAmount());
		assertEquals("Witchhaven Dungeon", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testNewKonarTask3()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_KONAR_3);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Trolls", slayerPlugin.getTaskName());
		assertEquals(135, slayerPlugin.getAmount());
		assertEquals("Mount Quidamortem", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testFirstTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_FIRST);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("goblins", slayerPlugin.getTaskName());
		assertEquals(17, slayerPlugin.getAmount());
	}

	@Test
	public void testFirstTaskKonar()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_FIRST_KONAR);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("cows", slayerPlugin.getTaskName());
		assertEquals(44, slayerPlugin.getAmount());
	}

	@Test
	public void testNewNpcContactTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_NPC_CONTACT);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
	}

	@Test
	public void testBossTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_BOSS_NEW);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Vet'ion", slayerPlugin.getTaskName());
		assertEquals(3, slayerPlugin.getAmount());
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 914);
	}

	@Test
	public void testBossTaskThe()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_BOSS_NEW_THE);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Chaos Elemental", slayerPlugin.getTaskName());
		assertEquals(3, slayerPlugin.getAmount());
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 914);
	}

	@Test
	public void testKonarBossTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_KONAR_BOSS);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("Alchemical Hydra", slayerPlugin.getTaskName());
		assertEquals(35, slayerPlugin.getAmount());
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 724);
	}

	@Test
	public void testPartnerTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_NEW_FROM_PARTNER, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("Dust Devils", slayerPlugin.getTaskName());
		assertEquals(377, slayerPlugin.getAmount());
	}

	@Test
	public void testCheckSlayerGem()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_CHECKSLAYERGEM, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
	}

	@Test
	public void testCheckSlayerGemWildernessTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_CHECKSLAYERGEM_WILDERNESS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
		assertEquals("Wilderness", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testCheckSlayerGemKonarTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_CHECKSLAYERGEM_KONAR, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("Blue dragons", slayerPlugin.getTaskName());
		assertEquals(122, slayerPlugin.getAmount());
		assertEquals("Ogre Enclave", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testExistingTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_EXISTING);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("suqahs", slayerPlugin.getTaskName());
		assertEquals(222, slayerPlugin.getAmount());
	}

	@Test
	public void testExistingTaskKonar()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_EXISTING_KONAR);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("adamant dragons", slayerPlugin.getTaskName());
		assertEquals(3, slayerPlugin.getAmount());
		assertEquals("Lithkren Vault", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testExistingTaskWilderness()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_EXISTING_WILDERNESS);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("bandits", slayerPlugin.getTaskName());
		assertEquals(99, slayerPlugin.getAmount());
		assertEquals("Wilderness", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testSlayergemActivate()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_ACTIVATESLAYERGEM);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("fossil island wyverns", slayerPlugin.getTaskName());
		assertEquals(23, slayerPlugin.getAmount());
	}

	@Test
	public void testSlayergemActivateKonar()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_ACTIVATESLAYERGEM_KONAR);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("adamant dragons", slayerPlugin.getTaskName());
		assertEquals(3, slayerPlugin.getAmount());
		assertEquals("Lithkren Vault", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testSlayergemActivateWilderness()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_ACTIVATESLAYERGEM_WILDERNESS);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals("bandits", slayerPlugin.getTaskName());
		assertEquals(99, slayerPlugin.getAmount());
		assertEquals("Wilderness", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testRewardPointsWidget()
	{
		Widget rewardBar = mock(Widget.class);
		Widget rewardBarText = mock(Widget.class);
		Widget[] rewardBarChildren = new Widget[]{rewardBarText};

		when(rewardBar.getDynamicChildren()).thenReturn(rewardBarChildren);
		when(rewardBarText.getText()).thenReturn(REWARD_POINTS);
		when(client.getWidget(WidgetInfo.SLAYER_REWARDS_TOPBAR)).thenReturn(rewardBar);
		slayerPlugin.onGameTick(new GameTick());

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 17566);
	}

	@Test
	public void testOneTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_ONE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 1);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testNoPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_COMPLETE_NO_POINTS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 3);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_POINTS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 9);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 18_000);
	}

	@Test
	public void testLargeStreak()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_LARGE_STREAK, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 2465);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 131_071);
	}

	@Test
	public void testTaskCompleteTurael()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_COMPETE_TURAEL, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 104);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testTaskMaxStreak()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_MAX_STREAK, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 16000);
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 131_071);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testTaskMaxPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_MAX_POINTS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 9);
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 131_071);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testTaskWilderness()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_WILDERNESS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.STREAK_KEY, 9);
		verify(configManager).setRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.POINTS_KEY, 18_000);
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testComplete()
	{
		slayerPlugin.setTaskName("cows");
		slayerPlugin.setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_COMPLETE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());

		verify(configManager).unsetRSProfileConfiguration(SlayerConfig.GROUP_NAME, SlayerConfig.TASK_LOC_KEY);
	}

	@Test
	public void testCancelled()
	{
		slayerPlugin.setTaskName("cows");
		slayerPlugin.setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_CANCELED, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testSuperiorNotification()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Superior", SUPERIOR_MESSAGE, null, 0);

		when(slayerConfig.showSuperiorNotification()).thenReturn(true);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verify(notifier).notify(SUPERIOR_MESSAGE);

		when(slayerConfig.showSuperiorNotification()).thenReturn(false);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verifyNoMoreInteractions(notifier);
	}

	@Test
	public void testCorrectlyCapturedTaskKill()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		StatChanged statChanged = new StatChanged(
			Skill.SLAYER,
			100,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		slayerPlugin.setTaskName("Dagannoth");
		slayerPlugin.setAmount(143);

		statChanged = new StatChanged(
			Skill.SLAYER,
			110,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(142, slayerPlugin.getAmount());
	}

	@Test
	public void testIncorrectlyCapturedTaskKill()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		StatChanged statChanged = new StatChanged(
			Skill.SLAYER,
			100,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		slayerPlugin.setTaskName("Monster");
		slayerPlugin.setAmount(98);

		assert Task.getTask("Monster") == null;

		statChanged = new StatChanged(
			Skill.SLAYER,
			110,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(97, slayerPlugin.getAmount());
	}

	@Test
	public void testJadTaskKill()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		StatChanged statChanged = new StatChanged(
			Skill.SLAYER,
			100,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		slayerPlugin.setTaskName("TzTok-Jad");
		slayerPlugin.setAmount(1);

		// One bat kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			110,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(1, slayerPlugin.getAmount());

		// One Jad kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			25360,
			-1,
			-1
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testZukTaskKill()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		StatChanged statChanged = new StatChanged(
			Skill.SLAYER,
			110,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		slayerPlugin.setTaskName("TzKal-Zuk");
		slayerPlugin.setAmount(1);

		// One bat kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			125,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(1, slayerPlugin.getAmount());

		// One Zuk kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			102_015,
			-1,
			-1
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testBraceletSlaughter()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", BRACLET_SLAUGHTER, null, 0);
		slayerPlugin.setAmount(42);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(43, slayerPlugin.getAmount());
	}

	@Test
	public void testBraceletExpeditious()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", BRACLET_EXPEDITIOUS, null, 0);
		slayerPlugin.setAmount(42);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(41, slayerPlugin.getAmount());
	}

	@Test
	public void testCombatBraceletUpdate()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		slayerPlugin.setTaskName("Suqahs");
		slayerPlugin.setAmount(231);

		ChatMessage chatMessage = new ChatMessage(null, GAMEMESSAGE, "", TASK_UPDATE_COMBAT_BRACELET, null, 0);
		slayerPlugin.onChatMessage(chatMessage);

		assertEquals("Suqahs", slayerPlugin.getTaskName());
		slayerPlugin.killed(1);
		assertEquals(30, slayerPlugin.getAmount());
	}

	@Test
	public void updateInitialAmount()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_EXISTING);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals(222, slayerPlugin.getInitialAmount());
	}

	@Test
	public void testTaskLookup() throws IOException
	{
		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask("Abyssal demons");
		task.setLocation("Abyss");
		task.setAmount(42);
		task.setInitialAmount(42);

		when(slayerConfig.taskCommand()).thenReturn(true);
		when(chatClient.getTask(anyString())).thenReturn(task);

		ChatMessage setMessage = new ChatMessage();
		setMessage.setType(ChatMessageType.PUBLICCHAT);
		setMessage.setName("Adam");
		setMessage.setMessageNode(mock(MessageNode.class));

		slayerPlugin.taskLookup(setMessage, "!task");

		verify(chatMessageManager).update(any(MessageNode.class));
	}

	@Test
	public void testTaskLookupInvalid() throws IOException
	{
		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask("task<");
		task.setLocation("loc");
		task.setAmount(42);
		task.setInitialAmount(42);

		when(slayerConfig.taskCommand()).thenReturn(true);
		when(chatClient.getTask(anyString())).thenReturn(task);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName("Adam");
		chatMessage.setMessageNode(mock(MessageNode.class));

		slayerPlugin.taskLookup(chatMessage, "!task");

		verify(chatMessageManager, never()).update(any(MessageNode.class));
	}

	@Test
	public void testNewAccountSlayerKill()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		slayerPlugin.setTaskName("Bears");
		slayerPlugin.setAmount(35);

		StatChanged statChanged = new StatChanged(
			Skill.SLAYER,
			0,
			1,
			1
		);
		slayerPlugin.onStatChanged(statChanged);

		statChanged = new StatChanged(
			Skill.SLAYER,
			27,
			1,
			1
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(34, slayerPlugin.getAmount());
	}

	@Test
	public void infoboxNotAddedOnLogin()
	{
		when(slayerPlugin.getStringProfileConfig(SlayerConfig.TASK_NAME_KEY)).thenReturn(Task.BLOODVELD.getName());
		when(slayerPlugin.getIntProfileConfig(SlayerConfig.AMOUNT_KEY)).thenReturn(50);
		// Lenient required as this is not called assuming correct plugin logic
		lenient().when(slayerConfig.showInfobox()).thenReturn(true);

		GameStateChanged loggingIn = new GameStateChanged();
		loggingIn.setGameState(GameState.LOGGING_IN);
		slayerPlugin.onGameStateChanged(loggingIn);

		GameStateChanged loggedIn = new GameStateChanged();
		loggedIn.setGameState(GameState.LOGGED_IN);
		slayerPlugin.onGameStateChanged(loggedIn);

		verify(infoBoxManager, never()).addInfoBox(any());
	}

	@Test
	public void testMultikill()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		// Setup xp cache
		StatChanged statChanged = new StatChanged(
			Skill.SLAYER,
			0,
			1,
			1
		);
		slayerPlugin.onStatChanged(statChanged);

		NPCComposition npcComposition = mock(NPCComposition.class);
		when(npcComposition.getActions()).thenReturn(new String[]{"Attack"});

		NPC npc1 = mock(NPC.class);
		when(npc1.getName()).thenReturn("Suqah");
		when(npc1.getTransformedComposition()).thenReturn(npcComposition);

		NPC npc2 = mock(NPC.class);
		when(npc2.getName()).thenReturn("Suqah");
		when(npc2.getTransformedComposition()).thenReturn(npcComposition);

		when(client.getNpcs()).thenReturn(Arrays.asList(npc1, npc2));

		// Set task
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(new GameTick());

		// Damage both npcs
		Hitsplat hitsplat = new Hitsplat(Hitsplat.HitsplatType.DAMAGE_ME, 1, 1);
		HitsplatApplied hitsplatApplied = new HitsplatApplied();
		hitsplatApplied.setHitsplat(hitsplat);
		hitsplatApplied.setActor(npc1);
		slayerPlugin.onHitsplatApplied(hitsplatApplied);

		hitsplatApplied.setActor(npc2);
		slayerPlugin.onHitsplatApplied(hitsplatApplied);

		// Kill both npcs
		slayerPlugin.onActorDeath(new ActorDeath(npc1));
		slayerPlugin.onActorDeath(new ActorDeath(npc2));

		slayerPlugin.onGameTick(new GameTick());

		statChanged = new StatChanged(
			Skill.SLAYER,
			105,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(229, slayerPlugin.getAmount()); // 2 kills
	}
}
