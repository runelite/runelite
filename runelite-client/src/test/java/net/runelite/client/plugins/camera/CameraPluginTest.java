/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.camera;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CameraPluginTest
{
	@Inject
	CameraPlugin cameraPlugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	CameraConfig cameraConfig;

	@Mock
	@Bind
	MouseManager mouseManager;

	@Mock
	@Bind
	KeyManager keyManager;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testHasMenuEntries()
	{
		/*
			                    right click examine?    right click object?      move camera
			  has object op     Y                       Y                        N
			                    Y                       N                        N
			                    N                       Y                        N
			                    N                       N                        Y

			 has examine op     Y                       Y                        N
			                    Y                       N                        N
			                    N                       Y                        Y
			                    N                       N                        Y
		 */
		test(true, true, true, true, false);
		test(true, true, true, false, false);
		test(true, true, false, true, false);
		test(true, true, false, false, true);

		test(false, true, true, true, false);
		test(false, true, true, false, false);
		test(false, true, false, true, true);
		test(false, true, false, false, true);
	}

	private void test(boolean hasOp, boolean hasExamine, boolean rightClickExamine, boolean rightClickObject, boolean movesCamera)
	{
		assert !(hasOp && !hasExamine);
		List<MenuEntry> menus = new ArrayList<>();
		if (hasOp)
		{
			MenuEntry entry = mock(MenuEntry.class);
			when(entry.getType()).thenReturn(MenuAction.GAME_OBJECT_FIRST_OPTION);
			menus.add(entry);
		}
		if (hasExamine)
		{
			MenuEntry entry = mock(MenuEntry.class);
			when(entry.getType()).thenReturn(MenuAction.EXAMINE_OBJECT);
			menus.add(entry);
		}
		when(cameraConfig.rightClickObjects()).thenReturn(rightClickObject);
		when(cameraConfig.rightClickExamine()).thenReturn(rightClickExamine);
		assertEquals(!movesCamera, cameraPlugin.hasMenuEntries(menus.toArray(new MenuEntry[0])));
	}
}