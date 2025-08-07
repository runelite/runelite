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
import java.util.function.BooleanSupplier;
import javax.inject.Inject;
import javax.inject.Named;
import net.runelite.api.ChatMessageType;
import static net.runelite.api.ChatMessageType.GAMEMESSAGE;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.EnumID;
import net.runelite.api.GameState;
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatClient;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Notification;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.npcoverlay.NpcOverlayService;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SlayerPluginTest
{
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
	Notifier notifier;

	@Mock
	@Bind
	ChatCommandManager chatCommandManager;

	@Mock
	@Bind
	ScheduledExecutorService executor;

	@Mock
	@Bind
	ChatClient chatClient;

	@Bind
	@Named("developerMode")
	boolean developerMode;

	@Mock
	@Bind
	NpcOverlayService npcOverlayService;

	@Mock
	@Bind
	ClientThread clientThread;

	@Inject
	SlayerPlugin slayerPlugin;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getGameState()).thenReturn(GameState.LOGIN_SCREEN);

		doAnswer(a ->
		{
			final Runnable r = a.getArgument(0);
			r.run();
			return null;
		}).when(clientThread).invokeLater(any(Runnable.class));

		doAnswer(a ->
		{
			final BooleanSupplier b = a.getArgument(0);
			return b.getAsBoolean();
		}).when(clientThread).invoke(any(BooleanSupplier.class));

		EnumComposition e = mock(EnumComposition.class);
		when(e.getStringVals()).thenReturn(new String[]{"The Abyss"});
		when(client.getEnum(EnumID.SLAYER_TASK_LOCATION)).thenReturn(e);

		slayerPlugin.startUp();
	}

	@After
	public void after()
	{
		slayerPlugin.shutDown();
	}

	@Test
	public void testSuperiorNotification()
	{
		ChatMessage chatMessageEvent = new ChatMessage(null, GAMEMESSAGE, "Superior", SUPERIOR_MESSAGE, null, 0);

		when(slayerConfig.showSuperiorNotification()).thenReturn(Notification.ON);
		slayerPlugin.onChatMessage(chatMessageEvent);
		verify(notifier).notify(Notification.ON, SUPERIOR_MESSAGE);
	}

	@Test
	public void testTaskLookup() throws IOException
	{
		net.runelite.http.api.chat.Task task = new net.runelite.http.api.chat.Task();
		task.setTask("Abyssal demons");
		task.setLocation("The Abyss");
		task.setAmount(42);
		task.setInitialAmount(42);

		when(slayerConfig.taskCommand()).thenReturn(true);
		when(chatClient.getTask(anyString())).thenReturn(task);

		MessageNode messageNode = mock(MessageNode.class);
		ChatMessage setMessage = new ChatMessage();
		setMessage.setType(ChatMessageType.PUBLICCHAT);
		setMessage.setName("Adam");
		setMessage.setMessageNode(messageNode);

		slayerPlugin.taskLookup(setMessage, "!task");

		verify(messageNode).setRuneLiteFormatMessage(anyString());
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

		MessageNode messageNode = mock(MessageNode.class);
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.PUBLICCHAT);
		chatMessage.setName("Adam");
		chatMessage.setMessageNode(messageNode);

		slayerPlugin.taskLookup(chatMessage, "!task");

		verify(messageNode, never()).setRuneLiteFormatMessage(anyString());
	}

	@Test
	public void infoboxNotAddedOnLogin()
	{
		// Lenient required as this is not called assuming correct plugin logic
		lenient().when(slayerConfig.showInfobox()).thenReturn(true);

		GameStateChanged loggingIn = new GameStateChanged();
		loggingIn.setGameState(GameState.LOGGING_IN);
		slayerPlugin.onGameStateChanged(loggingIn);

		GameStateChanged loggedIn = new GameStateChanged();
		loggedIn.setGameState(GameState.LOGGED_IN);
		slayerPlugin.onGameStateChanged(loggedIn);

		when(client.getVarpValue(VarPlayerID.SLAYER_COUNT)).thenReturn(42);
		when(client.getVarpValue(VarPlayerID.SLAYER_TARGET)).thenReturn(1);
		when(client.getEnum(EnumID.SLAYER_TASK_CREATURE))
			.thenAnswer(a ->
			{
				EnumComposition e = mock(EnumComposition.class);
				when(e.getStringValue(anyInt())).thenReturn("mocked npc");
				return e;
			});

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SLAYER_COUNT);
		slayerPlugin.onVarbitChanged(varbitChanged);

		varbitChanged = new VarbitChanged();
		varbitChanged.setVarpId(VarPlayerID.SLAYER_TARGET);
		slayerPlugin.onVarbitChanged(varbitChanged);

		slayerPlugin.onGameTick(new GameTick());

		verify(infoBoxManager, never()).addInfoBox(any());
	}

	@Test
	public void npcMatching()
	{
		assertTrue(matches("Abyssal Sire", Task.ABYSSAL_DEMONS));
		assertTrue(matches("Abyssal demon", Task.ABYSSAL_DEMONS));
		assertTrue(matches("Baby blue dragon", Task.BLUE_DRAGONS));
		assertTrue(matches("Vorkath", Task.BLUE_DRAGONS));
		assertTrue(matches("Brutal red dragon", Task.RED_DRAGONS));
		assertTrue(matches("Duck", Task.BIRDS));
		assertTrue(matches("Donny the Lad", Task.BANDITS));
		assertTrue(matches("Revenant Imp", Task.GHOSTS));
		assertTrue(matches("Sulphur lizard", Task.LIZARDS));
		assertTrue(matches("Spiked Turoth", Task.TUROTH));
		assertTrue(matches("Loar shade", Task.SHADES));
		assertTrue(matches("Loar shadow", Task.SHADES));
		assertTrue(matches("Urium shadow", Task.SHADES));

		assertFalse(matches("Rat", Task.PIRATES));
		assertFalse(matches("Wolf", Task.WEREWOLVES));
		assertFalse(matches("Scorpia's offspring", Task.SCORPIA));
		assertFalse(matches("Jonny the beard", Task.BEARS));
	}

	private boolean matches(final String npcName, final Task task)
	{
		final NPC npc = mock(NPC.class);
		final NPCComposition comp = mock(NPCComposition.class);
		when(npc.getTransformedComposition()).thenReturn(comp);
		when(comp.getName()).thenReturn(npcName);
		when(comp.getActions()).thenReturn(new String[] { "Attack" });

		slayerPlugin.setTask(task.getName(), 0, 0);
		return slayerPlugin.isTarget(npc);
	}

	@Test
	public void testDisconnect()
	{
		when(client.getVarpValue(VarPlayerID.SLAYER_COUNT)).thenReturn(42);
		when(client.getVarpValue(VarPlayerID.SLAYER_TARGET)).thenReturn(1);
		when(client.getEnum(EnumID.SLAYER_TASK_CREATURE))
			.thenAnswer(a ->
			{
				EnumComposition e = mock(EnumComposition.class);
				when(e.getStringValue(anyInt())).thenReturn("mocked npc");
				return e;
			});

		// initial amount is fetched from config at sync
		when(configManager.getRSProfileConfiguration("slayer", "initialAmount", int.class)).thenReturn(99);

		slayerPlugin.setTaskName("mocked npc");
		slayerPlugin.setAmount(42);
		slayerPlugin.setInitialAmount(99);

		// Disconnect looks like:
		// gs connection_lost
		// gs logged_in
		// varp=0
		// varp=value

		GameStateChanged connectionLost = new GameStateChanged();
		connectionLost.setGameState(GameState.CONNECTION_LOST);
		slayerPlugin.onGameStateChanged(connectionLost);

		GameStateChanged loggedIn = new GameStateChanged();
		loggedIn.setGameState(GameState.LOGGED_IN);
		slayerPlugin.onGameStateChanged(loggedIn);

		when(client.getVarpValue(VarPlayerID.SLAYER_COUNT)).thenReturn(0);
		when(client.getVarpValue(VarPlayerID.SLAYER_TARGET)).thenReturn(0);

		VarbitChanged taskSizeChanged = new VarbitChanged();
		taskSizeChanged.setVarpId(VarPlayerID.SLAYER_COUNT);
		slayerPlugin.onVarbitChanged(taskSizeChanged);

		VarbitChanged taskCreatureChanged = new VarbitChanged();
		taskCreatureChanged.setVarpId(VarPlayerID.SLAYER_TARGET);
		slayerPlugin.onVarbitChanged(taskCreatureChanged);

		when(client.getVarpValue(VarPlayerID.SLAYER_COUNT)).thenReturn(42);
		when(client.getVarpValue(VarPlayerID.SLAYER_TARGET)).thenReturn(1);

		slayerPlugin.onVarbitChanged(taskSizeChanged);
		slayerPlugin.onVarbitChanged(taskCreatureChanged);

		assertEquals("mocked npc", slayerPlugin.getTaskName());
		assertEquals(42, slayerPlugin.getAmount());
		assertEquals(99, slayerPlugin.getInitialAmount());
	}
}
