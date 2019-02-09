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
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import static net.runelite.api.ChatMessageType.SERVER;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.http.api.chat.ChatClient;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SlayerPluginTest
{
	private static final String TASK_NEW = "Your new task is to kill 231 Suqahs.";
	private static final String TASK_NEW_KONAR = "You are to bring balance to 147 Wyrms in the Karuulm Slayer Dungeon.";
	private static final String TASK_NEW_KONAR_2 = "You are to bring balance to 142 Hellhounds in Witchhaven Dungeon.";
	private static final String TASK_NEW_FIRST = "We'll start you off hunting goblins, you'll need to kill 17 of them.";
	private static final String TASK_NEW_NPC_CONTACT = "Excellent, you're doing great. Your new task is to kill<br>211 Suqahs.";
	private static final String TASK_NEW_FROM_PARTNER = "You have received a new Slayer assignment from breaklulz: Dust Devils (377)";
	private static final String TASK_CHECKSLAYERGEM = "You're assigned to kill Suqahs; only 211 more to go.";
	private static final String TASK_CHECKSLAYERGEM_WILDERNESS = "You're assigned to kill Suqahs in the Wilderness; only 211 more to go.";
	private static final String TASK_CHECKSLAYERGEM_KONAR = "You're assigned to kill Blue dragons in the Ogre Enclave; only 122 more to go.";
	private static final String TASK_UPDATE_COMBAT_BRACELET = "You still need to kill 30 monsters to complete your current Slayer assignment";

	private static final String TASK_BOSS_NEW = "Excellent. You're now assigned to kill Vet'ion 3 times.<br>Your reward point tally is 914.";
	private static final String TASK_BOSS_NEW_THE = "Excellent. You're now assigned to kill the Chaos <br>Elemental 3 times. Your reward point tally is 914.";

	private static final String TASK_EXISTING = "You're still hunting suqahs; you have 222 to go. Come<br>back when you've finished your task.";

	private static final String REWARD_POINTS = "Reward points: 17,566";

	private static final String TASK_ONE = "You've completed one task; return to a Slayer master.";
	private static final String TASK_COMPLETE_NO_POINTS = "<col=ef1020>You've completed 3 tasks; return to a Slayer master.</col>";
	private static final String TASK_POINTS = "You've completed 9 tasks and received 0 points, giving you a total of 18,000; return to a Slayer master.";
	private static final String TASK_LARGE_STREAK = "You've completed 2,465 tasks and received 15 points, giving you a total of 17,566,000; return to a Slayer master.";

	private static final String TASK_COMPLETE = "You need something new to hunt.";
	private static final String TASK_CANCELED = "Your task has been cancelled.";

	private static final String SUPERIOR_MESSAGE = "A superior foe has appeared...";

	private static final String BRACLET_SLAUGHTER = "Your bracelet of slaughter prevents your slayer count decreasing. It has 9 charges left.";
	private static final String BRACLET_EXPEDITIOUS = "Your expeditious bracelet helps you progress your slayer task faster. It has 9 charges left.";

	private static final String BRACLET_SLAUGHTER_V2 = "Your bracelet of slaughter prevents your slayer count decreasing. It has 1 charge left.";
	private static final String BRACLET_EXPEDITIOUS_V2 = "Your expeditious bracelet helps you progress your slayer faster. It has 1 charge left.";

	private static final String BRACLET_SLAUGHTER_V3 = "Your bracelet of slaughter prevents your slayer count decreasing. It then crumbles to dust.";
	private static final String BRACLET_EXPEDITIOUS_V3 = "Your expeditious bracelet helps you progress your slayer faster. It then crumbles to dust.";

	private static final String CHAT_BRACELET_SLAUGHTER_CHARGE = "Your bracelet of slaughter has 12 charges left.";
	private static final String CHAT_BRACELET_EXPEDITIOUS_CHARGE = "Your expeditious bracelet has 12 charges left.";

	private static final String CHAT_BRACELET_SLAUGHTER_CHARGE_ONE = "Your bracelet of slaughter has 1 charge left.";
	private static final String CHAT_BRACELET_EXPEDITIOUS_CHARGE_ONE = "Your expeditious bracelet has 1 charge left.";

	private static final String BREAK_SLAUGHTER = "The bracelet shatters. Your next bracelet of slaughter<br>will start afresh from 30 charges.";
	private static final String BREAK_EXPEDITIOUS = "The bracelet shatters. Your next expeditious bracelet<br>will start afresh from 30 charges.";

	@Mock
	@Bind
	Client client;

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
		assertEquals(914, slayerPlugin.getPoints());
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
		assertEquals(914, slayerPlugin.getPoints());
	}

	@Test
	public void testPartnerTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", TASK_NEW_FROM_PARTNER, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("Dust Devils", slayerPlugin.getTaskName());
		assertEquals(377, slayerPlugin.getAmount());
	}

	@Test
	public void testCheckSlayerGem()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", TASK_CHECKSLAYERGEM, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
	}

	@Test
	public void testCheckSlayerGemWildernessTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", TASK_CHECKSLAYERGEM_WILDERNESS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
		assertEquals("Wilderness", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testCheckSlayerGemKonarTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", TASK_CHECKSLAYERGEM_KONAR, null, 0);
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
	public void testRewardPointsWidget()
	{
		Widget rewardBar = mock(Widget.class);
		Widget rewardBarText = mock(Widget.class);
		Widget[] rewardBarChildren = new Widget[]{rewardBarText};

		when(rewardBar.getDynamicChildren()).thenReturn(rewardBarChildren);
		when(rewardBarText.getText()).thenReturn(REWARD_POINTS);
		when(client.getWidget(WidgetInfo.SLAYER_REWARDS_TOPBAR)).thenReturn(rewardBar);
		slayerPlugin.onGameTick(new GameTick());

		assertEquals(17566, slayerPlugin.getPoints());
	}

	@Test
	public void testOneTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Perterter", TASK_ONE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testNoPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Perterter", TASK_COMPLETE_NO_POINTS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(3, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Perterter", TASK_POINTS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(9, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
		assertEquals(18_000, slayerPlugin.getPoints());
	}

	@Test
	public void testLargeStreak()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Perterter", TASK_LARGE_STREAK, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(2465, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
		assertEquals(17_566_000, slayerPlugin.getPoints());
	}

	@Test
	public void testComplete()
	{
		slayerPlugin.setTaskName("cows");
		slayerPlugin.setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Perterter", TASK_COMPLETE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testCancelled()
	{
		slayerPlugin.setTaskName("cows");
		slayerPlugin.setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Perterter", TASK_CANCELED, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testSuperiorNotification()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "Superior", SUPERIOR_MESSAGE, null, 0);

		when(slayerConfig.showSuperiorNotification()).thenReturn(true);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verify(notifier).notify(SUPERIOR_MESSAGE);

		when(slayerConfig.showSuperiorNotification()).thenReturn(false);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verifyNoMoreInteractions(notifier);
	}

	@Test
	public void testBraceletSlaughter()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", BRACLET_SLAUGHTER, null, 0);

		slayerPlugin.setAmount(42);
		slayerPlugin.setSlaughterChargeCount(10);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(9, slayerPlugin.getSlaughterChargeCount());
		assertEquals(43, slayerPlugin.getAmount());

		chatMessageEvent = new ChatMessage(null, SERVER, "", CHAT_BRACELET_SLAUGHTER_CHARGE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(12, slayerPlugin.getSlaughterChargeCount());

		chatMessageEvent = new ChatMessage(null, SERVER, "", CHAT_BRACELET_SLAUGHTER_CHARGE_ONE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getSlaughterChargeCount());

		slayerPlugin.setSlaughterChargeCount(1);
		chatMessageEvent = new ChatMessage(null, SERVER, "", BRACLET_SLAUGHTER_V3, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(30, slayerPlugin.getSlaughterChargeCount());

		Widget braceletBreakWidget = mock(Widget.class);
		when(braceletBreakWidget.getText()).thenReturn(BREAK_SLAUGHTER);
		when(client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT)).thenReturn(braceletBreakWidget);

		slayerPlugin.setSlaughterChargeCount(-1);
		slayerPlugin.onGameTick(new GameTick());
		assertEquals(30, slayerPlugin.getSlaughterChargeCount());

		chatMessageEvent = new ChatMessage(null, SERVER, "", BRACLET_SLAUGHTER_V2, null, 0);

		slayerPlugin.setAmount(42);
		slayerPlugin.setSlaughterChargeCount(2);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getSlaughterChargeCount());
		assertEquals(43, slayerPlugin.getAmount());
	}

	@Test
	public void testBraceletExpeditious()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, SERVER, "", BRACLET_EXPEDITIOUS, null, 0);

		slayerPlugin.setAmount(42);
		slayerPlugin.setExpeditiousChargeCount(10);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(41, slayerPlugin.getAmount());
		assertEquals(9, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(null, SERVER, "", CHAT_BRACELET_EXPEDITIOUS_CHARGE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(12, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(null, SERVER, "", CHAT_BRACELET_EXPEDITIOUS_CHARGE_ONE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getExpeditiousChargeCount());

		slayerPlugin.setExpeditiousChargeCount(1);
		chatMessageEvent = new ChatMessage(null, SERVER, "", BRACLET_EXPEDITIOUS_V3, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(30, slayerPlugin.getExpeditiousChargeCount());

		Widget braceletBreakWidget = mock(Widget.class);
		when(braceletBreakWidget.getText()).thenReturn(BREAK_EXPEDITIOUS);
		when(client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT)).thenReturn(braceletBreakWidget);

		slayerPlugin.setExpeditiousChargeCount(-1);
		slayerPlugin.onGameTick(new GameTick());
		assertEquals(30, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(null, SERVER, "", BRACLET_EXPEDITIOUS_V2, null, 0);

		slayerPlugin.setAmount(42);
		slayerPlugin.setExpeditiousChargeCount(2);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(41, slayerPlugin.getAmount());
		assertEquals(1, slayerPlugin.getExpeditiousChargeCount());
	}

	@Test
	public void testCombatBraceletUpdate()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		slayerPlugin.setTaskName("Suqahs");
		slayerPlugin.setAmount(231);

		ChatMessage chatMessage = new ChatMessage(null, SERVER, "", TASK_UPDATE_COMBAT_BRACELET, null, 0);
		slayerPlugin.onChatMessage(chatMessage);

		assertEquals("Suqahs", slayerPlugin.getTaskName());
		slayerPlugin.killedOne();
		assertEquals(30, slayerPlugin.getAmount());
	}

	@Test
	public void testTaskLookup() throws IOException
	{
		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask("task");
		task.setLocation("loc");
		task.setAmount(42);
		task.setInitialAmount(42);

		when(slayerConfig.taskCommand()).thenReturn(true);
		when(chatClient.getTask(anyString())).thenReturn(task);

		ChatMessage setMessage = new ChatMessage();
		setMessage.setType(ChatMessageType.PUBLIC);
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
		chatMessage.setType(ChatMessageType.PUBLIC);
		chatMessage.setName("Adam");
		chatMessage.setMessageNode(mock(MessageNode.class));

		slayerPlugin.taskLookup(chatMessage, "!task");

		verify(chatMessageManager, never()).update(any(MessageNode.class));
	}
}
