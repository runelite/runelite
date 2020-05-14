/*
 * Copyright (c) 2020, bfmoatbio <bfmoatbio@protonmail.com>
 * Copyright (c) 2020, Jordan Atwood <nightfirecat@protonmail.com>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
import com.google.inject.Inject;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.PlayerMenuOptionClicked;
import net.runelite.client.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MenuManagerTest
{
	@Inject
	private MenuManager menuManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private EventBus eventBus;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testPlayerMenuOptionClicked()
	{
		MenuOptionClicked event = new MenuOptionClicked();
		event.setMenuAction(MenuAction.RUNELITE);
		event.setMenuTarget("username<col=40ff00>  (level-42)");

		menuManager.onMenuOptionClicked(event);

		ArgumentCaptor<PlayerMenuOptionClicked> captor = ArgumentCaptor.forClass(PlayerMenuOptionClicked.class);
		verify(eventBus).post(captor.capture());
		PlayerMenuOptionClicked clicked = captor.getValue();
		assertEquals("username", clicked.getMenuTarget());
	}

	@Test
	public void testPlayerMenuOptionWithBountyHunterEmblemClicked()
	{
		MenuOptionClicked event = new MenuOptionClicked();
		event.setMenuAction(MenuAction.RUNELITE);
		event.setMenuTarget("username<img=20>5<col=40ff00>  (level-42)");

		menuManager.onMenuOptionClicked(event);

		ArgumentCaptor<PlayerMenuOptionClicked> captor = ArgumentCaptor.forClass(PlayerMenuOptionClicked.class);
		verify(eventBus).post(captor.capture());
		PlayerMenuOptionClicked clicked = captor.getValue();
		assertEquals("username", clicked.getMenuTarget());
	}
}
