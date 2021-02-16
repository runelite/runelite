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

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.CC_OP;
import static net.runelite.api.MenuAction.RUNELITE;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import static net.runelite.api.widgets.WidgetInfo.WORLD_MAP_OPTION;
import net.runelite.client.util.Text;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MenuManagerTest
{
	private static final MenuEntry CANCEL = new MenuEntry();

	@Inject
	private MenuManager menuManager;

	@Mock
	@Bind
	private Client client;

	private MenuEntry[] clientMenuEntries = {CANCEL};

	@BeforeClass
	public static void beforeClass()
	{
		CANCEL.setOption("Cancel");
		CANCEL.setType(MenuAction.CANCEL.getId());
		CANCEL.setParam1(WORLD_MAP_OPTION.getPackedId());
	}

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		doAnswer((Answer<Void>) invocationOnMock ->
		{
			clientMenuEntries = invocationOnMock.getArgument(0, MenuEntry[].class);
			return null;
		}).when(client).setMenuEntries(ArgumentMatchers.any(MenuEntry[].class));
		when(client.getMenuEntries()).thenAnswer((Answer<MenuEntry[]>) invocationMock -> clientMenuEntries);
	}

	@Test
	public void testManagedMenuOrder()
	{
		final MenuEntry first = new MenuEntry();
		final MenuEntry second = new MenuEntry();
		final MenuEntry third = new MenuEntry();
		first.setOption("Test");
		first.setTarget("First Entry");
		first.setParam1(WORLD_MAP_OPTION.getPackedId());
		first.setType(RUNELITE.getId());
		second.setOption("Test");
		second.setTarget("Second Entry");
		second.setParam1(WORLD_MAP_OPTION.getPackedId());
		second.setType(RUNELITE.getId());
		third.setOption("Test");
		third.setTarget("Third Entry");
		third.setParam1(WORLD_MAP_OPTION.getPackedId());
		third.setType(RUNELITE.getId());
		menuManager.addManagedCustomMenu(new WidgetMenuOption(first.getOption(), first.getTarget(), WORLD_MAP_OPTION));
		menuManager.addManagedCustomMenu(new WidgetMenuOption(second.getOption(), second.getTarget(), WORLD_MAP_OPTION));
		menuManager.addManagedCustomMenu(new WidgetMenuOption(third.getOption(), third.getTarget(), WORLD_MAP_OPTION));

		menuManager.onMenuEntryAdded(new MenuEntryAdded(
			CANCEL.getOption(),
			CANCEL.getTarget(),
			CC_OP.getId(),
			CANCEL.getIdentifier(),
			CANCEL.getParam0(),
			CANCEL.getParam1()));

		ArgumentCaptor<MenuEntry[]> captor = ArgumentCaptor.forClass(MenuEntry[].class);
		verify(client, atLeastOnce()).setMenuEntries(captor.capture());

		final MenuEntry[] resultMenuEntries = captor.getValue();
		// Strip color tags from menu options before array comparison
		for (MenuEntry resultEntry : resultMenuEntries)
		{
			final String resultTarget = resultEntry.getTarget();
			if (resultTarget != null)
			{
				resultEntry.setTarget(Text.removeTags(resultEntry.getTarget()));
			}
		}

		assertArrayEquals(new MenuEntry[]{CANCEL, third, second, first}, resultMenuEntries);
	}
}
