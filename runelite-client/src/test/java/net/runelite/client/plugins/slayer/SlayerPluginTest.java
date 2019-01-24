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

import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Model;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Node;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.SpritePixels;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
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

import org.junit.Assert;
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

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", TASK_NEW_FROM_PARTNER, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("Dust Devils", slayerPlugin.getTaskName());
		assertEquals(377, slayerPlugin.getAmount());
	}

	@Test
	public void testCheckSlayerGem()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", TASK_CHECKSLAYERGEM, null);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
	}

	@Test
	public void testCheckSlayerGemWildernessTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", TASK_CHECKSLAYERGEM_WILDERNESS, null);
		slayerPlugin.onChatMessage(chatMessageEvent);
		assertEquals("Suqahs", slayerPlugin.getTaskName());
		assertEquals(211, slayerPlugin.getAmount());
		assertEquals("Wilderness", slayerPlugin.getTaskLocation());
	}

	@Test
	public void testCheckSlayerGemKonarTask()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", TASK_CHECKSLAYERGEM_KONAR, null);
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
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "Perterter", TASK_ONE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testNoPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "Perterter", TASK_COMPLETE_NO_POINTS, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(3, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testPoints()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "Perterter", TASK_POINTS, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(9, slayerPlugin.getStreak());
		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
		assertEquals(18_000, slayerPlugin.getPoints());
	}

	@Test
	public void testLargeStreak()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "Perterter", TASK_LARGE_STREAK, null);
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

		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "Perterter", TASK_COMPLETE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testCancelled()
	{
		slayerPlugin.setTaskName("cows");
		slayerPlugin.setAmount(42);

		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "Perterter", TASK_CANCELED, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals("", slayerPlugin.getTaskName());
		assertEquals(0, slayerPlugin.getAmount());
	}

	@Test
	public void testSuperiorNotification()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "Superior", SUPERIOR_MESSAGE, null);

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
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_SLAUGHTER, null);

		slayerPlugin.setAmount(42);
		slayerPlugin.setSlaughterChargeCount(10);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(9, slayerPlugin.getSlaughterChargeCount());
		assertEquals(43, slayerPlugin.getAmount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_SLAUGHTER_CHARGE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(12, slayerPlugin.getSlaughterChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_SLAUGHTER_CHARGE_ONE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getSlaughterChargeCount());

		slayerPlugin.setSlaughterChargeCount(1);
		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_SLAUGHTER_V3, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(30, slayerPlugin.getSlaughterChargeCount());

		Widget braceletBreakWidget = mock(Widget.class);
		when(braceletBreakWidget.getText()).thenReturn(BREAK_SLAUGHTER);
		when(client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT)).thenReturn(braceletBreakWidget);

		slayerPlugin.setSlaughterChargeCount(-1);
		slayerPlugin.onGameTick(new GameTick());
		assertEquals(30, slayerPlugin.getSlaughterChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_SLAUGHTER_V2, null);

		slayerPlugin.setAmount(42);
		slayerPlugin.setSlaughterChargeCount(2);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getSlaughterChargeCount());
		assertEquals(43, slayerPlugin.getAmount());
	}

	@Test
	public void testBraceletExpeditious()
	{
		ChatMessage chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_EXPEDITIOUS, null);

		slayerPlugin.setAmount(42);
		slayerPlugin.setExpeditiousChargeCount(10);

		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(41, slayerPlugin.getAmount());
		assertEquals(9, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_EXPEDITIOUS_CHARGE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(12, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", CHAT_BRACELET_EXPEDITIOUS_CHARGE_ONE, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(1, slayerPlugin.getExpeditiousChargeCount());

		slayerPlugin.setExpeditiousChargeCount(1);
		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_EXPEDITIOUS_V3, null);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(30, slayerPlugin.getExpeditiousChargeCount());

		Widget braceletBreakWidget = mock(Widget.class);
		when(braceletBreakWidget.getText()).thenReturn(BREAK_EXPEDITIOUS);
		when(client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT)).thenReturn(braceletBreakWidget);

		slayerPlugin.setExpeditiousChargeCount(-1);
		slayerPlugin.onGameTick(new GameTick());
		assertEquals(30, slayerPlugin.getExpeditiousChargeCount());

		chatMessageEvent = new ChatMessage(SERVER, "", BRACLET_EXPEDITIOUS_V2, null);

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

		ChatMessage chatMessage = new ChatMessage(SERVER, "", TASK_UPDATE_COMBAT_BRACELET, null);
		slayerPlugin.onChatMessage(chatMessage);

		assertEquals("Suqahs", slayerPlugin.getTaskName());
		slayerPlugin.killedOne();
		assertEquals(30, slayerPlugin.getAmount());
	}
	
	private static NPC newNPC(String name, int combatLevel)
	{
		return new NPC() {
			@Override
			public int getId() {
				return 0;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public int getCombatLevel() {
				return combatLevel;
			}

			@Override
			public int getIndex() {
				return 0;
			}

			@Override
			public NPCComposition getComposition() {
				return null;
			}

			@Override
			public NPCComposition getTransformedComposition() {
				return null;
			}

			@Override
			public boolean isDead() {
				return false;
			}

			@Override
			public Actor getInteracting() {
				return null;
			}

			@Override
			public int getHealthRatio() {
				return 0;
			}

			@Override
			public int getHealth() {
				return 0;
			}

			@Override
			public WorldPoint getWorldLocation() {
				return null;
			}

			@Override
			public LocalPoint getLocalLocation() {
				return null;
			}

			@Override
			public void setIdlePoseAnimation(int animation) {

			}

			@Override
			public void setPoseAnimation(int animation) {

			}

			@Override
			public int getOrientation() {
				return 0;
			}

			@Override
			public int getAnimation() {
				return 0;
			}

			@Override
			public void setAnimation(int animation) {

			}

			@Override
			public void setActionFrame(int actionFrame) {

			}

			@Override
			public int getGraphic() {
				return 0;
			}

			@Override
			public void setGraphic(int graphic) {

			}

			@Override
			public void setSpotAnimFrame(int spotAnimFrame) {

			}

			@Override
			public int getModelHeight() {
				return 0;
			}

			@Override
			public Polygon getCanvasTilePoly() {
				return null;
			}

			@Override
			public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset) {
				return null;
			}

			@Override
			public Point getCanvasImageLocation(BufferedImage image, int zOffset) {
				return null;
			}

			@Override
			public Point getCanvasSpriteLocation(SpritePixels sprite, int zOffset) {
				return null;
			}

			@Override
			public Point getMinimapLocation() {
				return null;
			}

			@Override
			public int getLogicalHeight() {
				return 0;
			}

			@Override
			public Polygon getConvexHull() {
				return null;
			}

			@Override
			public WorldArea getWorldArea() {
				return null;
			}

			@Override
			public String getOverhead() {
				return null;
			}

			@Override
			public Model getModel() {
				return null;
			}

			@Override
			public void setModelHeight(int modelHeight) {

			}

			@Override
			public void draw(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash) {

			}

			@Override
			public Node getNext() {
				return null;
			}

			@Override
			public Node getPrevious() {
				return null;
			}

			@Override
			public long getHash() {
				return 0;
			}
		};
	}

	@Test
	public void testSackMulti() throws Exception
	{
		slayerPlugin.startUp();

		List<NPC> died = new ArrayList<>();
		NPC npc0 = newNPC("Dust devil", 93);
		NPC npc1 = newNPC("Dust devil", 110);
		died.add(npc1);
		died.add(npc0);
		died.add(npc0);
		died.add(npc0);
		died.add(npc1);
		died.add(npc0);
		died.add(npc0);
		died.add(npc0);
		died.add(npc0);
		died.add(npc0);
		died.add(npc1);
		// 5 93s and 2 110s
		// = 5 * 105 + 2 * 130 = 785
		int estimatedCount = slayerPlugin.estimateKillCount(died, 785);
		Assert.assertEquals(7, estimatedCount);
	}

	@Test
	public void testSackSingle() throws Exception
	{
		slayerPlugin.startUp();

		List<NPC> died0 = new ArrayList<>();
		NPC npc0 = newNPC("Dust devil", 93);
		died0.add(npc0);
		died0.add(npc0);
		// 1 93
		// = 1 * 105 = 105
		int estimatedCount0 = slayerPlugin.estimateKillCount(died0, 105);
		Assert.assertEquals(1, estimatedCount0);

		List<NPC> died1 = new ArrayList<>();
		NPC npc1 = newNPC("Dust devil", 110);
		died1.add(npc1);
		died1.add(npc1);
		died1.add(npc1);
		// 1 110
		// = 1 * 130 = 130
		int estimatedCount1 = slayerPlugin.estimateKillCount(died1, 130);
		Assert.assertEquals(1, estimatedCount1);
	}

	@Test
	public void testSackAmbiguous() throws Exception
	{
		slayerPlugin.startUp();

		List<NPC> died = new ArrayList<>();
		NPC npc0 = newNPC("Desert Lizard", 42);
		NPC npc1 = newNPC("Desert Lizard", 24);
		NPC npc2 = newNPC("Desert Lizard", 12);
		died.add(npc0);
		died.add(npc0);
		died.add(npc1);
		died.add(npc2);
		died.add(npc2);
		// 1 42
		// = 1 * 40 = 40
		// but 1 12 and 1 24
		// = 1 * 15 + 1 * 25 = 40
		// so expect to go for smallest kill count and return 1 for the lvl 42 kill
		int estimatedCount = slayerPlugin.estimateKillCount(died, 40);
		Assert.assertEquals(1, estimatedCount);
	}

	@Test
	public void testSackAlwaysOne() throws Exception {
		slayerPlugin.startUp();

		List<NPC> died = new ArrayList<>();
		NPC npc = newNPC("Greater demon", 92);
		died.add(npc);
		// 1 92 (partial)
		// 1 * 87 * 0.5 = 43.5 round down to 43
		// but 87 can't fit into 43.5 any times so knapsack solver gives 0
		// but we gained xp and 1 enemy died so failsafes give at least 1
		int estimatedCount = slayerPlugin.estimateKillCount(died, 43);
		Assert.assertEquals(1, estimatedCount);

	}

	@Test
	public void testSubsequenceMatches()
	{
		String name0 = "Brutal Black Dragon".toLowerCase();
		String target0 = "Black Dragon".toLowerCase();

		String[] name0A = name0.split(" ");
		assertEquals(true, slayerPlugin.contiguousSubsequenceMatches(name0A, target0));

		String name1 = "Green Dragon".toLowerCase();
		String target1 = "Black Dragon".toLowerCase();

		String[] name1A = name1.split(" ");
		assertEquals(false, slayerPlugin.contiguousSubsequenceMatches(name1A, target1));

		String name2 = "Pirate".toLowerCase();
		String target2 = "Rat".toLowerCase();

		String[] name2A = name2.split(" ");
		assertEquals(false, slayerPlugin.contiguousSubsequenceMatches(name2A, target2));

		String name3 = "Giant Bat".toLowerCase();
		String target3 = "Bat".toLowerCase();

		String[] name3A = name3.split(" ");
		assertEquals(true, slayerPlugin.contiguousSubsequenceMatches(name3A, target3));

		String name4 = "Nechryael";
		String target4 = "Nechryael";

		String[] name4A = name4.split(" ");
		assertEquals(true, slayerPlugin.contiguousSubsequenceMatches(name4A, target4));
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

		SetMessage setMessage = new SetMessage();
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

		SetMessage setMessage = new SetMessage();
		setMessage.setType(ChatMessageType.PUBLIC);
		setMessage.setName("Adam");
		setMessage.setMessageNode(mock(MessageNode.class));

		slayerPlugin.taskLookup(setMessage, "!task");

		verify(chatMessageManager, never()).update(any(MessageNode.class));
	}

}
