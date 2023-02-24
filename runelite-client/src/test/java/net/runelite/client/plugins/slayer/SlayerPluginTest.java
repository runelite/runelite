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
import net.runelite.api.MessageNode;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatClient;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.npcoverlay.NpcOverlayService;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.npchighlight.NpcIndicatorService;
import net.runelite.client.plugins.npchighlight.NpcIndicatorsConfig;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SlayerPluginTest
{
	private static final String WILDERNESS_TASK_COMPLETED_50_MESSAGE = "<col=ff0000>You've completed</col> 50 Wilderness tasks <col=ff0000>and received</col> 375 points<col=ff0000>, giving you a total of</col><br>1375<col=ff0000>; return to a Slayer master.</col>";
	private static final String SUPERIOR_MESSAGE = "A superior foe has appeared...";

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
	TargetWeaknessOverlay targetWeaknessOverlay;

	@Mock
	@Bind
	InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	NpcIndicatorsConfig npcIndicatorsConfig;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	ScheduledExecutorService executor;

	@Mock
	@Bind
	ChatClient chatClient;

	@Mock
	@Bind
	NpcOverlayService npcOverlayService;

	@Mock
	@Bind
	PluginManager pluginManager;

	@Mock
	@Bind
	NpcIndicatorService npcIndicatorService;

	@Inject
	SlayerPlugin slayerPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
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
	public void testWildernessStreak()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "", WILDERNESS_TASK_COMPLETED_50_MESSAGE, null, 0);
		slayerPlugin.onChatMessage(chatMessageEvent);

		assertEquals(50, slayerPlugin.wildernessStreak);
	}

	@Test
	public void testTaskLookupHasAnyLocation() throws IOException
	{
		Task slayerTask = new Task();
		slayerTask.taskNPC = TaskNpc.ICE_GIANTS;
		slayerTask.location = Location.ANYWHERE;
		slayerTask.setAmount(99);
		SlayerPlugin.setTask(slayerTask);
		SlayerPlugin.setInitialAmount(99);

		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask(slayerTask.taskNPC.getName());
		task.setLocation(slayerTask.getLocation().getName());
		task.setAmount(slayerTask.getAmount());
		task.setInitialAmount(99);

		when(slayerConfig.taskCommand()).thenReturn(true);
		when(chatClient.getTask(anyString())).thenReturn(task);

		MessageNode messageNode = mock(MessageNode.class);
		ChatMessage setMessage = new ChatMessage();
		setMessage.setType(ChatMessageType.PUBLICCHAT);
		setMessage.setName("Adam");
		setMessage.setMessageNode(messageNode);

		slayerPlugin.taskLookup(setMessage, "!task");

		verify(messageNode).setRuneLiteFormatMessage("<colNORMAL>Slayer Task: <colHIGHLIGHT>Ice Giants: 0/99 killed");
	}

	@Test
	public void testTaskLookupHasSpecificLocation() throws IOException
	{
		Task slayerTask = new Task();
		slayerTask.taskNPC = TaskNpc.ABYSSAL_DEMONS;
		slayerTask.location = Location.THE_ABYSS;
		slayerTask.setAmount(4869);
		SlayerPlugin.setTask(slayerTask);
		SlayerPlugin.setInitialAmount(7829);

		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask(slayerTask.taskNPC.getName());
		task.setLocation(slayerTask.getLocation().getName());
		task.setAmount(slayerTask.getAmount());
		task.setInitialAmount(7829);

		when(slayerConfig.taskCommand()).thenReturn(true);
		when(chatClient.getTask(anyString())).thenReturn(task);

		MessageNode messageNode = mock(MessageNode.class);
		ChatMessage setMessage = new ChatMessage();
		setMessage.setType(ChatMessageType.PUBLICCHAT);
		setMessage.setName("Adam");
		setMessage.setMessageNode(messageNode);

		slayerPlugin.taskLookup(setMessage, "!task");

		verify(messageNode).setRuneLiteFormatMessage("<colNORMAL>Slayer Task: <colHIGHLIGHT>Abyssal Demons (The Abyss): 2960/7829 killed");
	}

	@Test
	public void testTaskLookupNotValidTask()
	{
		Task slayerTask = new Task();
		slayerTask.taskNPC = TaskNpc.ABYSSAL_DEMONS;
		slayerTask.location = Location.THE_ABYSS;
		slayerTask.setAmount(0);
		SlayerPlugin.setTask(slayerTask);
		SlayerPlugin.setInitialAmount(42);

		slayerPlugin.streak = 5;
		slayerPlugin.wildernessStreak = 999;

		when(slayerConfig.taskCommand()).thenReturn(true);

		MessageNode messageNode = mock(MessageNode.class);
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName("Adam");
		chatMessage.setMessageNode(messageNode);

		slayerPlugin.taskLookup(chatMessage, "!task");

		verify(messageNode).setRuneLiteFormatMessage("<colNORMAL>Slayer Task: <colHIGHLIGHT>none <colNORMAL>Streak: <colHIGHLIGHT>5 <colNORMAL>Wilderness Streak: <colHIGHLIGHT>999");
	}

	@Test
	public void testTaskLookupNonExistent()
	{
		SlayerPlugin.setTask(null);
		SlayerPlugin.setInitialAmount(42);

		slayerPlugin.streak = 5;
		slayerPlugin.wildernessStreak = 999;

		when(slayerConfig.taskCommand()).thenReturn(true);

		MessageNode messageNode = mock(MessageNode.class);
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName("Adam");
		chatMessage.setMessageNode(messageNode);

		slayerPlugin.taskLookup(chatMessage, "!task");

		verify(messageNode).setRuneLiteFormatMessage("<colNORMAL>Slayer Task: <colHIGHLIGHT>none <colNORMAL>Streak: <colHIGHLIGHT>5 <colNORMAL>Wilderness Streak: <colHIGHLIGHT>999");
	}
}
