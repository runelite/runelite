/*
 * Copyright (c) 2022 LlemonDuck
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking.farming;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.time.Instant;
import java.util.Collections;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.MenuAction;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Player;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.WorldView;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CompostTrackerTest
{

	@Inject
	private CompostTracker compostTracker;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private FarmingWorld farmingWorld;

	@Mock
	@Bind
	private ConfigManager configManager;

	@Mock
	@Bind
	private FarmingRegion farmingRegion;

	@Mock
	@Bind
	private FarmingPatch farmingPatch;

	@Mock
	@Bind
	private GameObject patchObject;

	@Mock
	@Bind
	private Player player;

	@Mock
	@Bind
	private Scene scene;

	@Mock
	@Bind
	private Tile tile;

	@Mock
	@Bind
	private ObjectComposition patchDef;

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	private static final int PATCH_ID = 12345;
	private static final int PATCH_VARBIT = 54321;
	private static final WorldPoint worldPoint = new WorldPoint(1, 2, 0);

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		compostTracker.pendingCompostActions.clear();

		WorldView wv = mock(WorldView.class);
		when(wv.getSizeX()).thenReturn(104);
		when(wv.getSizeY()).thenReturn(104);
		when(client.getTopLevelWorldView()).thenReturn(wv);

		when(client.getLocalPlayer()).thenReturn(player);
		when(player.getWorldLocation()).thenReturn(worldPoint);
		when(client.getScene()).thenReturn(scene);
		when(client.getObjectDefinition(PATCH_ID)).thenReturn(patchDef);

		when(scene.getTiles()).thenReturn(new Tile[][][]{{null, {null, null, tile}}}); // indices match worldPoint
		when(tile.getGameObjects()).thenReturn(new GameObject[]{patchObject});

		when(farmingWorld.getRegionsForLocation(any())).thenReturn(Collections.singleton(farmingRegion));

		when(farmingRegion.getPatches()).thenReturn(new FarmingPatch[]{farmingPatch});

		when(farmingPatch.getVarbit()).thenReturn(PATCH_VARBIT);
		when(farmingPatch.configKey()).thenReturn("MOCK");

		when(patchObject.getId()).thenReturn(PATCH_ID);
		when(patchObject.sizeX()).thenReturn(1);
		when(patchObject.sizeY()).thenReturn(1);

		when(patchDef.getVarbitId()).thenReturn(PATCH_VARBIT);
	}

	@Test
	public void setCompostState_storesNonNullChangesToConfig()
	{
		compostTracker.setCompostState(farmingPatch, CompostState.COMPOST);
		verify(configManager).setRSProfileConfiguration("timetracking", "MOCK.compost", CompostState.COMPOST);
	}

	@Test
	public void setCompostState_storesNullChangesByClearingConfig()
	{
		compostTracker.setCompostState(farmingPatch, null);
		verify(configManager).unsetRSProfileConfiguration("timetracking", "MOCK.compost");
	}

	@Test
	public void getCompostState_directlyReturnsFromConfig()
	{
		when(configManager.getRSProfileConfiguration("timetracking", "MOCK.compost", CompostState.class)).thenReturn(
			CompostState.SUPERCOMPOST);
		assertThat(compostTracker.getCompostState(farmingPatch), is(CompostState.SUPERCOMPOST));
	}

	@Test
	public void determineCompostUsed_returnsAppropriateCompostValues()
	{
		// invalid
		collector.checkThat(
			CompostTracker.determineCompostUsed("This is not a farming chat message."),
			is((CompostState) null)
		);
		collector.checkThat(
			CompostTracker.determineCompostUsed("Contains word compost but is not examine message."),
			is((CompostState) null)
		);

		// inspect
		collector.checkThat(
			CompostTracker.determineCompostUsed("This is an allotment. The soil has been treated with supercompost. The patch is empty and weeded."),
			is(CompostState.SUPERCOMPOST)
		);

		// fertile soil on existing patch
		collector.checkThat(
			CompostTracker.determineCompostUsed("This patch has already been fertilised with ultracompost - the spell can't make it any more fertile."),
			is(CompostState.ULTRACOMPOST)
		);
		// fertile soil on cleared patch
		collector.checkThat(
			CompostTracker.determineCompostUsed("The herb patch has been treated with supercompost."),
			is(CompostState.SUPERCOMPOST)
		);

		// bucket on cleared patch
		collector.checkThat(
			CompostTracker.determineCompostUsed("You treat the herb patch with ultracompost."),
			is(CompostState.ULTRACOMPOST)
		);
		collector.checkThat(
			CompostTracker.determineCompostUsed("You treat the tree patch with compost."),
			is(CompostState.COMPOST)
		);
		collector.checkThat(
			CompostTracker.determineCompostUsed("You treat the fruit tree patch with supercompost."),
			is(CompostState.SUPERCOMPOST)
		);
	}

	@Test
	public void onMenuOptionClicked_queuesPendingCompostForInspectActions()
	{
		MenuOptionClicked inspectPatchAction = mock(MenuOptionClicked.class);
		when(inspectPatchAction.getMenuAction()).thenReturn(MenuAction.GAME_OBJECT_SECOND_OPTION);
		when(inspectPatchAction.getMenuOption()).thenReturn("Inspect");
		when(inspectPatchAction.getId()).thenReturn(PATCH_ID);
		when(inspectPatchAction.getParam0()).thenReturn(1);
		when(inspectPatchAction.getParam1()).thenReturn(2);

		compostTracker.onMenuOptionClicked(inspectPatchAction);
		CompostTracker.PendingCompost actual = compostTracker.pendingCompostActions.get(farmingPatch);

		assertThat(actual.getFarmingPatch(), is(farmingPatch));
		assertThat(actual.getPatchLocation(), is(new WorldPoint(1, 2, 0)));
	}

	@Test
	public void onMenuOptionClicked_queuesPendingCompostForCompostActions()
	{
		Widget widget = mock(Widget.class);
		when(client.getSelectedWidget()).thenReturn(widget);
		when(widget.getItemId()).thenReturn(ItemID.BUCKET_ULTRACOMPOST);

		MenuOptionClicked inspectPatchAction = mock(MenuOptionClicked.class);
		when(inspectPatchAction.getMenuAction()).thenReturn(MenuAction.WIDGET_TARGET_ON_GAME_OBJECT);
		when(inspectPatchAction.getId()).thenReturn(PATCH_ID);
		when(inspectPatchAction.getParam0()).thenReturn(1);
		when(inspectPatchAction.getParam1()).thenReturn(2);

		compostTracker.onMenuOptionClicked(inspectPatchAction);
		CompostTracker.PendingCompost actual = compostTracker.pendingCompostActions.get(farmingPatch);

		assertThat(actual.getFarmingPatch(), is(farmingPatch));
		assertThat(actual.getPatchLocation(), is(new WorldPoint(1, 2, 0)));
	}

	@Test
	public void onMenuOptionClicked_queuesPendingCompostForFertileSoilSpellActions()
	{
		Widget widget = mock(Widget.class);
		when(client.getSelectedWidget()).thenReturn(widget);
		when(widget.getId()).thenReturn(InterfaceID.MagicSpellbook.FERTILE_SOIL);

		MenuOptionClicked inspectPatchAction = mock(MenuOptionClicked.class);
		when(inspectPatchAction.getMenuAction()).thenReturn(MenuAction.WIDGET_TARGET_ON_GAME_OBJECT);
		when(inspectPatchAction.getId()).thenReturn(PATCH_ID);
		when(inspectPatchAction.getParam0()).thenReturn(1);
		when(inspectPatchAction.getParam1()).thenReturn(2);

		compostTracker.onMenuOptionClicked(inspectPatchAction);
		CompostTracker.PendingCompost actual = compostTracker.pendingCompostActions.get(farmingPatch);

		assertThat(actual.getFarmingPatch(), is(farmingPatch));
		assertThat(actual.getPatchLocation(), is(new WorldPoint(1, 2, 0)));
	}

	@Test
	public void onChatMessage_ignoresInvalidTypes()
	{
		ChatMessage chatEvent = mock(ChatMessage.class);
		when(chatEvent.getType()).thenReturn(ChatMessageType.PUBLICCHAT);

		compostTracker.onChatMessage(chatEvent);

		verifyNoInteractions(client);
		verifyNoInteractions(farmingWorld);
	}

	@Test
	public void onChatMessage_handlesInspectMessages()
	{
		ChatMessage chatEvent = mock(ChatMessage.class);
		when(chatEvent.getType()).thenReturn(ChatMessageType.SPAM);
		when(chatEvent.getMessage()).thenReturn("This is a tree patch. The soil has been treated with ultracompost. The patch is empty and weeded.");

		compostTracker.pendingCompostActions.put(farmingPatch, new CompostTracker.PendingCompost(Instant.MAX, worldPoint, farmingPatch));
		compostTracker.onChatMessage(chatEvent);

		verify(configManager).setRSProfileConfiguration("timetracking", "MOCK.compost", CompostState.ULTRACOMPOST);
	}

	@Test
	public void onChatMessage_handlesBucketUseMessages()
	{
		ChatMessage chatEvent = mock(ChatMessage.class);
		when(chatEvent.getType()).thenReturn(ChatMessageType.SPAM);
		when(chatEvent.getMessage()).thenReturn("You treat the herb patch with compost.");

		compostTracker.pendingCompostActions.put(farmingPatch, new CompostTracker.PendingCompost(Instant.MAX, worldPoint, farmingPatch));
		compostTracker.onChatMessage(chatEvent);

		verify(configManager).setRSProfileConfiguration("timetracking", "MOCK.compost", CompostState.COMPOST);
	}

	@Test
	public void onChatMessage_handlesFertileSoilMessages()
	{
		ChatMessage chatEvent = mock(ChatMessage.class);
		when(chatEvent.getType()).thenReturn(ChatMessageType.SPAM);
		when(chatEvent.getMessage()).thenReturn("The allotment has been treated with supercompost.");

		compostTracker.pendingCompostActions.put(farmingPatch, new CompostTracker.PendingCompost(Instant.MAX, worldPoint, farmingPatch));
		compostTracker.onChatMessage(chatEvent);

		verify(configManager).setRSProfileConfiguration("timetracking", "MOCK.compost", CompostState.SUPERCOMPOST);
	}

	@Test
	public void onChatMessage_volcanicAsh()
	{
		ChatMessage chatEvent = mock(ChatMessage.class);
		when(chatEvent.getType()).thenReturn(ChatMessageType.SPAM);
		when(chatEvent.getMessage()).thenReturn("The fruit tree patch has been treated with ultracompost consuming 2 of your volcanic ash.");

		compostTracker.pendingCompostActions.put(farmingPatch, new CompostTracker.PendingCompost(Instant.MAX, worldPoint, farmingPatch));
		compostTracker.onChatMessage(chatEvent);

		verify(configManager).setRSProfileConfiguration("timetracking", "MOCK.compost", CompostState.ULTRACOMPOST);
	}
}
