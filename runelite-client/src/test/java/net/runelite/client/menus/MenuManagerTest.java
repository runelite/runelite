/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.menus;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.RUNELITE;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.client.util.Text;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MenuManagerTest
{
	@Inject
	private MenuManager menuManager;

	@Mock
	@Bind
	private Client client;

	private final MenuEntry CANCEL = createMenuEntry("Cancel", "", MenuAction.CANCEL, InterfaceID.Orbs.WORLDMAP);

	private final List<MenuEntry> createdMenuEntries = new ArrayList<>();

	private static MenuEntry createMenuEntry(String option, String target, MenuAction type, int param1)
	{
		MenuEntry menuEntry = new TestMenuEntry();
		menuEntry.setOption(option);
		menuEntry.setTarget(target);
		menuEntry.setType(type);
		menuEntry.setParam1(param1);
		return menuEntry;
	}

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		when(client.createMenuEntry(anyInt()))
			.thenAnswer(a ->
			{
				MenuEntry e = new TestMenuEntry();
				createdMenuEntries.add(e);
				return e;
			});
		when(client.getMenuEntries()).thenReturn(new MenuEntry[]{CANCEL});
	}

	@Test
	public void testManagedMenuOrder()
	{
		final MenuEntry first = createMenuEntry("Test", "First Entry", RUNELITE, InterfaceID.Orbs.WORLDMAP);
		final MenuEntry second = createMenuEntry("Test", "Second Entry", RUNELITE, InterfaceID.Orbs.WORLDMAP);
		final MenuEntry third = createMenuEntry("Test", "Third Entry", RUNELITE, InterfaceID.Orbs.WORLDMAP);
		menuManager.addManagedCustomMenu(new WidgetMenuOption(first.getOption(), first.getTarget(), InterfaceID.Orbs.WORLDMAP), null);
		menuManager.addManagedCustomMenu(new WidgetMenuOption(second.getOption(), second.getTarget(), InterfaceID.Orbs.WORLDMAP), null);
		menuManager.addManagedCustomMenu(new WidgetMenuOption(third.getOption(), third.getTarget(), InterfaceID.Orbs.WORLDMAP), null);

		menuManager.onMenuEntryAdded(new MenuEntryAdded(createMenuEntry("Cancel", "", MenuAction.CC_OP, InterfaceID.Orbs.WORLDMAP)));

		verify(client, times(3)).createMenuEntry(anyInt());

		// Strip color tags from menu options before array comparison
		for (MenuEntry resultEntry : createdMenuEntries)
		{
			final String resultTarget = resultEntry.getTarget();
			if (resultTarget != null)
			{
				resultEntry.setTarget(Text.removeTags(resultEntry.getTarget()));
			}
		}

		assertArrayEquals(new MenuEntry[]{third, second, first},
			Lists.reverse(createdMenuEntries).toArray(new MenuEntry[0]));
	}
}
