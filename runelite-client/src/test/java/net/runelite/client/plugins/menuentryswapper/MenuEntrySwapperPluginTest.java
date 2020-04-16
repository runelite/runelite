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
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.doAnswer;
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
	MenuEntrySwapperConfig config;

	@Inject
	MenuEntrySwapperPlugin menuEntrySwapperPlugin;

	private MenuEntry[] entries;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);

		when(client.getMenuEntries()).thenAnswer((Answer<MenuEntry[]>) invocationOnMock ->
		{
			// The menu implementation returns a copy of the array, which causes swap() to not
			// modify the same array being iterated in onClientTick
			MenuEntry[] copy = new MenuEntry[entries.length];
			System.arraycopy(entries, 0, copy, 0, entries.length);
			return copy;
		});
		doAnswer((Answer<Void>) invocationOnMock ->
		{
			Object argument = invocationOnMock.getArguments()[0];
			entries = (MenuEntry[]) argument;
			return null;
		}).when(client).setMenuEntries(any(MenuEntry[].class));
	}

	private static MenuEntry menu(String option, String target, MenuAction menuAction)
	{
		return menu(option, target, menuAction, 0);
	}

	private static MenuEntry menu(String option, String target, MenuAction menuAction, int identifier)
	{
		MenuEntry menuEntry = new MenuEntry();
		menuEntry.setOption(option);
		menuEntry.setTarget(target);
		menuEntry.setType(menuAction.getId());
		menuEntry.setIdentifier(identifier);
		return menuEntry;
	}

	@Test
	public void testSlayerMaster()
	{
		when(config.swapTrade()).thenReturn(true);
		when(config.swapAssignment()).thenReturn(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Rewards", "Duradel", MenuAction.NPC_FIFTH_OPTION),
			menu("Trade", "Duradel", MenuAction.NPC_FOURTH_OPTION),
			menu("Assignment", "Duradel", MenuAction.NPC_THIRD_OPTION),
			menu("Talk-to", "Duradel", MenuAction.NPC_FIRST_OPTION),
		};
		menuEntrySwapperPlugin.onClientTick(new ClientTick());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		// Once for assignment<->talk-to and once for trade<->talk-to
		verify(client, times(2)).setMenuEntries(argumentCaptor.capture());

		MenuEntry[] value = argumentCaptor.getValue();
		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Rewards", "Duradel", MenuAction.NPC_FIFTH_OPTION),
			menu("Talk-to", "Duradel", MenuAction.NPC_FIRST_OPTION),
			menu("Trade", "Duradel", MenuAction.NPC_FOURTH_OPTION),
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

		menuEntrySwapperPlugin.onClientTick(new ClientTick());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client, times(2)).setMenuEntries(argumentCaptor.capture());

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

		menuEntrySwapperPlugin.onClientTick(new ClientTick());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());

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
	public void testTeleport()
	{
		when(config.swapTeleportSpell()).thenReturn(true);
		menuEntrySwapperPlugin.setShiftModifier(true);

		// Cast -> Grand Exchange
		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),

			menu("Configure", "Varrock Teleport", MenuAction.WIDGET_THIRD_OPTION),
			menu("Grand Exchange", "Varrock Teleport", MenuAction.WIDGET_SECOND_OPTION),
			menu("Cast", "Varrock Teleport", MenuAction.WIDGET_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onClientTick(new ClientTick());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),

			menu("Configure", "Varrock Teleport", MenuAction.WIDGET_THIRD_OPTION),
			menu("Cast", "Varrock Teleport", MenuAction.WIDGET_FIRST_OPTION),
			menu("Grand Exchange", "Varrock Teleport", MenuAction.WIDGET_SECOND_OPTION),
		}, argumentCaptor.getValue());

		clearInvocations(client);

		// Grand Exchange -> Cast
		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),

			menu("Configure", "Varrock Teleport", MenuAction.WIDGET_THIRD_OPTION),
			menu("Cast", "Varrock Teleport", MenuAction.WIDGET_SECOND_OPTION),
			menu("Grand Exchange", "Varrock Teleport", MenuAction.WIDGET_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onClientTick(new ClientTick());

		argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),

			menu("Configure", "Varrock Teleport", MenuAction.WIDGET_THIRD_OPTION),
			menu("Grand Exchange", "Varrock Teleport", MenuAction.WIDGET_FIRST_OPTION),
			menu("Cast", "Varrock Teleport", MenuAction.WIDGET_SECOND_OPTION),
		}, argumentCaptor.getValue());
	}

	@Test
	public void testTobDoor()
	{
		when(config.swapQuick()).thenReturn(true);
		when(config.swapHomePortal()).thenReturn(HouseMode.HOME);

		//Quick-enter, Enter
		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Examine", "Formidable Passage", MenuAction.EXAMINE_OBJECT),
			menu("Walk here", "", MenuAction.WALK),

			menu("Quick-Enter", "Formidable Passage", MenuAction.GAME_OBJECT_SECOND_OPTION),
			menu("Enter", "Formidable Passage", MenuAction.GAME_OBJECT_FIRST_OPTION),
		};

		menuEntrySwapperPlugin.onClientTick(new ClientTick());

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());

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
		menuEntrySwapperPlugin.setShiftModifier(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Wield", "Abyssal whip", MenuAction.CC_OP_LOW_PRIORITY, 9),
			menu("Deposit-1", "Abyssal whip", MenuAction.CC_OP, 2),
		};

		menuEntrySwapperPlugin.onMenuEntryAdded(new MenuEntryAdded(
			"Deposit-1",
			"Abyssal whip",
			MenuAction.CC_OP.getId(),
			2,
			-1,
			-1
		));

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());

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
		menuEntrySwapperPlugin.setShiftModifier(true);

		entries = new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Wield", "Rune arrow", MenuAction.CC_OP_LOW_PRIORITY, 9),
			menu("Deposit-All", "Rune arrow", MenuAction.CC_OP_LOW_PRIORITY, 8),
			menu("Deposit-1", "Rune arrow", MenuAction.CC_OP, 2),
		};

		menuEntrySwapperPlugin.onMenuEntryAdded(new MenuEntryAdded(
			"Deposit-1",
			"Rune arrow",
			MenuAction.CC_OP.getId(),
			2,
			-1,
			-1
		));

		ArgumentCaptor<MenuEntry[]> argumentCaptor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client).setMenuEntries(argumentCaptor.capture());

		assertArrayEquals(new MenuEntry[]{
			menu("Cancel", "", MenuAction.CANCEL),
			menu("Wield", "Rune arrow", MenuAction.CC_OP_LOW_PRIORITY, 9),
			menu("Deposit-1", "Rune arrow", MenuAction.CC_OP, 2),
			menu("Deposit-All", "Rune arrow", MenuAction.CC_OP, 8),
		}, argumentCaptor.getValue());
	}
}