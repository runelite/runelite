/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.menuentryswapper;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.Arrays;
import net.runelite.api.Client;
import net.runelite.api.KeyCode;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.events.PostMenuSort;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.menus.TestMenuEntry;
import org.junit.After;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MenuEntrySwapperPluginTest
{
	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	ConfigManager configManager;

	@Mock
	@Bind
	ItemManager itemManager;

	@Mock
	@Bind
	ChatMessageManager chatMessageManager;

	@Mock
	@Bind
	MenuEntrySwapperConfig config;

	@Inject
	MenuEntrySwapperPlugin menuEntrySwapperPlugin;

	private Menu menu;
	private NPC npc;
	private MenuEntry[] entries;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getObjectDefinition(anyInt())).thenReturn(mock(ObjectComposition.class));

		npc = mock(NPC.class);
		NPCComposition composition = mock(NPCComposition.class);
		when(npc.getTransformedComposition()).thenReturn(composition);

		menu = mock(Menu.class);
		when(client.getMenu()).thenReturn(menu);

		when(menu.getMenuEntries()).thenAnswer((Answer<MenuEntry[]>) invocationOnMock ->
		{
			// The menu implementation returns a copy of the array, which causes swap() to not
			// modify the same array being iterated in onClientTick
			return Arrays.copyOf(entries, entries.length);
		});
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			entries = (MenuEntry[]) argument;
			return null;
		}).when(menu).setMenuEntries(any(MenuEntry[].class));

		menuEntrySwapperPlugin.startUp();
	}

	@After
	public void after()
	{
		menuEntrySwapperPlugin.shutDown();
	}

	private MenuEntry menu(String option, String target, MenuAction menuAction)
	{
		return menu(option, target, menuAction, 0);
	}

	private MenuEntry menu(String option, String target, MenuAction menuAction, int identifier)
	{
		TestMenuEntry menuEntry = new TestMenuEntry();
		menuEntry.setOption(option);
		menuEntry.setTarget(target);
		menuEntry.setType(menuAction);
		menuEntry.setIdentifier(identifier);
		menuEntry.setActor(npc);
		return menuEntry;
	}

	@Test
	public void testSlayerMaster()
	{
		lenient().when(config.swapTrade()).thenReturn(true);
		when(config.swapAssignment()).thenReturn(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Rewards", "Duradel", MenuAction.NPC_FIFTH_OPTION),
			menu("Trade", "Duradel", MenuAction.NPC_FOURTH_OPTION),
			menu("Assignment", "Duradel", MenuAction.NPC_THIRD_OPTION),
			menu("Talk-to", "Duradel", MenuAction.NPC_FIRST_OPTION),
		};
		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu).setMenuEntries(argumentCaptor.capture());

		// check the assignment swap is hit first instead of trade
		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Rewards", "Duradel", MenuAction.NPC_FIFTH_OPTION),
			menu("Trade", "Duradel", MenuAction.NPC_FOURTH_OPTION),
			menu("Talk-to", "Duradel", MenuAction.NPC_FIRST_OPTION),
			menu("Assignment", "Duradel", MenuAction.NPC_THIRD_OPTION),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testBankers()
	{
		when(config.swapBank()).thenReturn(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Gnome banker", MenuAction.EXAMINE_NPC),
			menu("Examine", "Gnome banker", MenuAction.EXAMINE_NPC),
			menu("Walk here", "", MenuAction.WALK),

			// Banker 2
			menu("Collect", "Gnome banker", MenuAction.NPC_FOURTH_OPTION),
			menu("Bank", "Gnome banker", MenuAction.NPC_THIRD_OPTION),
			menu("Talk-to", "Gnome banker", MenuAction.NPC_FIRST_OPTION),

			// Banker 1
			menu("Collect", "Gnome banker", MenuAction.NPC_FOURTH_OPTION),
			menu("Bank", "Gnome banker", MenuAction.NPC_THIRD_OPTION),
			menu("Talk-to", "Gnome banker", MenuAction.NPC_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu, times(2)).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Gnome banker", MenuAction.EXAMINE_NPC),
			menu("Examine", "Gnome banker", MenuAction.EXAMINE_NPC),
			menu("Walk here", "", MenuAction.WALK),

			// Banker 2
			menu("Collect", "Gnome banker", MenuAction.NPC_FOURTH_OPTION),
			menu("Talk-to", "Gnome banker", MenuAction.NPC_FIRST_OPTION),
			menu("Bank", "Gnome banker", MenuAction.NPC_THIRD_OPTION),

			// Banker 1
			menu("Collect", "Gnome banker", MenuAction.NPC_FOURTH_OPTION),
			menu("Talk-to", "Gnome banker", MenuAction.NPC_FIRST_OPTION),
			menu("Bank", "Gnome banker", MenuAction.NPC_THIRD_OPTION),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testContains()
	{
		when(config.swapPay()).thenReturn(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Kragen", MenuAction.EXAMINE_NPC),
			menu("Walk here", "", MenuAction.WALK),

			menu("Pay (south)", "Kragen", MenuAction.NPC_FOURTH_OPTION),
			menu("Pay (north)", "Kragen", MenuAction.NPC_THIRD_OPTION),
			menu("Talk-to", "Kragen", MenuAction.NPC_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Kragen", MenuAction.EXAMINE_NPC),
			menu("Walk here", "", MenuAction.WALK),

			menu("Pay (south)", "Kragen", MenuAction.NPC_FOURTH_OPTION),
			menu("Talk-to", "Kragen", MenuAction.NPC_FIRST_OPTION),
			menu("Pay (north)", "Kragen", MenuAction.NPC_THIRD_OPTION),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testTobDoor()
	{
		when(config.swapQuick()).thenReturn(true);

		//Quick-enter, Enter
		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Formidable Passage", MenuAction.EXAMINE_OBJECT),
			menu("Walk here", "", MenuAction.WALK),

			menu("Quick-Enter", "Formidable Passage", MenuAction.GAME_OBJECT_SECOND_OPTION),
			menu("Enter", "Formidable Passage", MenuAction.GAME_OBJECT_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Formidable Passage", MenuAction.EXAMINE_OBJECT),
			menu("Walk here", "", MenuAction.WALK),

			menu("Enter", "Formidable Passage", MenuAction.GAME_OBJECT_FIRST_OPTION),
			menu("Quick-Enter", "Formidable Passage", MenuAction.GAME_OBJECT_SECOND_OPTION),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testShiftWithdraw()
	{
		when(config.bankDepositShiftClick()).thenReturn(ShiftDepositMode.EXTRA_OP);
		when(client.isKeyPressed(KeyCode.KC_SHIFT)).thenReturn(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Wield", "Abyssal whip", MenuAction.CC_OP_LOW_PRIORITY, 9),
			menu("Deposit-1", "Abyssal whip", MenuAction.CC_OP, 2),
		};

		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Deposit-1", "Abyssal whip", MenuAction.CC_OP, 2),
			menu("Wield", "Abyssal whip", MenuAction.CC_OP, 9),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testShiftDeposit()
	{
		when(config.bankDepositShiftClick()).thenReturn(ShiftDepositMode.DEPOSIT_ALL);
		when(client.isKeyPressed(KeyCode.KC_SHIFT)).thenReturn(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Wield", "Rune arrow", MenuAction.CC_OP_LOW_PRIORITY, 9),
			menu("Deposit-All", "Rune arrow", MenuAction.CC_OP_LOW_PRIORITY, 8),
			menu("Deposit-1", "Rune arrow", MenuAction.CC_OP, 2),
		};

		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Wield", "Rune arrow", MenuAction.CC_OP_LOW_PRIORITY, 9),
			menu("Deposit-1", "Rune arrow", MenuAction.CC_OP, 2),
			menu("Deposit-All", "Rune arrow", MenuAction.CC_OP, 8),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testBirdhouse()
	{
		when(config.swapBirdhouseEmpty()).thenReturn(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Redwood birdhouse", MenuAction.EXAMINE_OBJECT),
			menu("Walk here", "", MenuAction.WALK),

			menu("Empty", "Redwood birdhouse", MenuAction.GAME_OBJECT_THIRD_OPTION),
			menu("Seeds", "Redwood birdhouse", MenuAction.GAME_OBJECT_SECOND_OPTION),
			menu("Interact", "Redwood birdhouse", MenuAction.GAME_OBJECT_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Redwood birdhouse", MenuAction.EXAMINE_OBJECT),
			menu("Walk here", "", MenuAction.WALK),

			menu("Interact", "Redwood birdhouse", MenuAction.GAME_OBJECT_FIRST_OPTION),
			menu("Seeds", "Redwood birdhouse", MenuAction.GAME_OBJECT_SECOND_OPTION),
			menu("Empty", "Redwood birdhouse", MenuAction.GAME_OBJECT_THIRD_OPTION),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testZanarisFairyRing()
	{
		when(config.swapFairyRing()).thenReturn(FairyRingMode.ZANARIS);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Fairy ring", MenuAction.EXAMINE_OBJECT),
			menu("Walk here", "", MenuAction.WALK),

			menu("Last-destination (AIQ)", "Fairy ring", MenuAction.GAME_OBJECT_SECOND_OPTION),
			menu("Configure", "Fairy ring", MenuAction.GAME_OBJECT_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onPostMenuSort(new PostMenuSort());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(menu).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Fairy ring", MenuAction.EXAMINE_OBJECT),
			menu("Walk here", "", MenuAction.WALK),

			menu("Configure", "Fairy ring", MenuAction.GAME_OBJECT_FIRST_OPTION),
			menu("Last-destination (AIQ)", "Fairy ring", MenuAction.GAME_OBJECT_SECOND_OPTION),
		}, argumentCaptor.getValue());
	}
}