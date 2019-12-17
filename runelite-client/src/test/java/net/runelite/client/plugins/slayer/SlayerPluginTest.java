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
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.OpenOSRSConfig;
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

	@Mock
	@Bind
	SlayerTaskPanel panel;

	@Mock
	@Bind
	private OpenOSRSConfig openOSRSConfig;

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
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("Suqahs", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(231, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testNewKonarTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_KONAR);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("Wyrms", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(147, slayerPlugin.getCurrentTask().getAmount());
		assertEquals("Karuulm Slayer Dungeon", slayerPlugin.getCurrentTask().getTaskLocation());
	}

	@Test
	public void testNewKonarTask2()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_KONAR_2);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("Hellhounds", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(142, slayerPlugin.getCurrentTask().getAmount());
		assertEquals("Witchhaven Dungeon", slayerPlugin.getCurrentTask().getTaskLocation());
	}

	@Test
	public void testNewKonarTask3()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_KONAR_3);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("Trolls", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(135, slayerPlugin.getCurrentTask().getAmount());
		assertEquals("Mount Quidamortem", slayerPlugin.getCurrentTask().getTaskLocation());
	}

	@Test
	public void testFirstTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_FIRST);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("goblins", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(17, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testFirstTaskKonar()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_FIRST_KONAR);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("cows", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(44, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testNewNpcContactTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_NEW_NPC_CONTACT);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("Suqahs", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(211, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testBossTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_BOSS_NEW);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("Vet'ion", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(3, slayerPlugin.getCurrentTask().getAmount());
		assertEquals(914, slayerPlugin.getPoints());
	}

	@Test
	public void testBossTaskThe()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_BOSS_NEW_THE);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("Chaos Elemental", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(3, slayerPlugin.getCurrentTask().getAmount());
		assertEquals(914, slayerPlugin.getPoints());
	}

	@Test
	public void testPartnerTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_NEW_FROM_PARTNER, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("Dust Devils", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(377, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testCheckSlayerGem()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_CHECKSLAYERGEM, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(211, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testCheckSlayerGemWildernessTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_CHECKSLAYERGEM_WILDERNESS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(211, slayerPlugin.getCurrentTask().getAmount());
		assertEquals("Wilderness", slayerPlugin.getCurrentTask().getTaskLocation());
	}

	@Test
	public void testCheckSlayerGemKonarTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", TASK_CHECKSLAYERGEM_KONAR, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("Blue dragons", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(122, slayerPlugin.getCurrentTask().getAmount());
		assertEquals("Ogre Enclave", slayerPlugin.getCurrentTask().getTaskLocation());
	}

	@Test
	public void testExistingTask()
	{
		Widget npcDialog = mock(Widget.class);
		when(npcDialog.getText()).thenReturn(TASK_EXISTING);
		when(client.getWidget(WidgetInfo.DIALOG_NPC_TEXT)).thenReturn(npcDialog);
		slayerPlugin.onGameTick(GameTick.INSTANCE);

		assertEquals("suqahs", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(222, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testOneTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_ONE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testNoPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_COMPLETE_NO_POINTS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(3, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testPoints()
	{
		when(client.getVar(Varbits.SLAYER_REWARD_POINTS)).thenReturn(18_000);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_POINTS, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		VarbitChanged varbitChanged = new VarbitChanged();
		slayerPlugin.onVarbitChanged(varbitChanged);

		assertEquals(9, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
		assertEquals(18_000, slayerPlugin.getPoints());
	}

	@Test
	public void testLargeStreak()
	{
		when(client.getVar(Varbits.SLAYER_REWARD_POINTS)).thenReturn(17_566_000);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_LARGE_STREAK, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);
		VarbitChanged varbitChanged = new VarbitChanged();
		slayerPlugin.onVarbitChanged(varbitChanged);

		assertEquals(2465, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
		assertEquals(17_566_000, slayerPlugin.getPoints());
	}

	@Test
	public void testComplete()
	{
		slayerPlugin.getCurrentTask().setTaskName("cows");
		slayerPlugin.getCurrentTask().setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_COMPLETE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testCancelled()
	{
		slayerPlugin.getCurrentTask().setTaskName("cows");
		slayerPlugin.getCurrentTask().setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Perterter", TASK_CANCELED, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getCurrentTask().getTaskName());
		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testSuperiorNotification()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Superior", SUPERIOR_MESSAGE, null, 0);

		slayerPlugin.setShowSuperiorNotification(true);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verify(notifier).notify(SUPERIOR_MESSAGE);

		slayerPlugin.setShowSuperiorNotification(false);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verifyNoMoreInteractions(notifier);
	}

	@Test
	public void testTaskLookup() throws IOException
	{
		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask("Abyssal demons");
		task.setLocation("Abyss");
		task.setAmount(42);
		task.setInitialAmount(42);

		slayerPlugin.setTaskCommand(true);
		when(chatClient.getTask(anyString())).thenReturn(task);

		ChatMessage setMessage = new ChatMessage();
		setMessage.setType(ChatMessageType.PUBLICCHAT);
		setMessage.setName("Adam");
		setMessage.setMessageNode(mock(MessageNode.class));

		slayerPlugin.taskLookup(setMessage, "!task");

		verify(chatMessageManager).update(any(MessageNode.class));
	}

	@Test
	public void testTaskLookupInvalid()
	{
		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask("task<");
		task.setLocation("loc");
		task.setAmount(42);
		task.setInitialAmount(42);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName("Adam");
		chatMessage.setMessageNode(mock(MessageNode.class));

		slayerPlugin.taskLookup(chatMessage, "!task");

		verify(chatMessageManager, never()).update(any(MessageNode.class));
	}

	@Test
	public void testSuperiorsLowercase()
	{
		for (String name : SlayerPlugin.SUPERIOR_SLAYER_MONSTERS)
		{
			assertEquals(name, name.toLowerCase());
		}
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

		slayerPlugin.setTask("Dagannoth", 143, 143, true, 0);

		statChanged = new StatChanged(
			Skill.SLAYER,
			110,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(142, slayerPlugin.getCurrentTask().getAmount());
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

		slayerPlugin.setTask("Monster", 98, 98, true, 0);
		assert Task.getTask("Monster") == null;

		statChanged = new StatChanged(
			Skill.SLAYER,
			110,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(97, slayerPlugin.getCurrentTask().getAmount());
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

		slayerPlugin.setTask("TzTok-Jad", 1, 1, true, 0);

		// One bat kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			110,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(1, slayerPlugin.getCurrentTask().getAmount());

		// One Jad kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			25360,
			-1,
			-1
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
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

		slayerPlugin.setTask("TzKal-Zuk", 1, 1, true, 0);

		// One bat kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			125,
			2,
			2
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(1, slayerPlugin.getCurrentTask().getAmount());

		// One Zuk kill
		statChanged = new StatChanged(
			Skill.SLAYER,
			102_015,
			-1,
			-1
		);
		slayerPlugin.onStatChanged(statChanged);

		assertEquals(0, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void testNewAccountSlayerKill()
	{
		final Player player = mock(Player.class);
		when(player.getLocalLocation()).thenReturn(new LocalPoint(0, 0));
		when(client.getLocalPlayer()).thenReturn(player);

		slayerPlugin.setTask("Bears", 35, 35, true, 0);

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

		assertEquals(34, slayerPlugin.getCurrentTask().getAmount());
	}

	@Test
	public void infoboxNotAddedOnLogin()
	{
		GameStateChanged loggingIn = new GameStateChanged();
		loggingIn.setGameState(GameState.LOGGING_IN);
		slayerPlugin.onGameStateChanged(loggingIn);

		GameStateChanged loggedIn = new GameStateChanged();
		loggedIn.setGameState(GameState.LOGGED_IN);
		slayerPlugin.onGameStateChanged(loggedIn);

		verify(infoBoxManager, never()).addInfoBox(any());
	}
}
