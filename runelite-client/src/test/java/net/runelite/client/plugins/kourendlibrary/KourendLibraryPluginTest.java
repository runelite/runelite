/*
 * Copyright (c) 2026, Max Freedom Pollard <272618364+MaxFreedomPollard@users.noreply.github.com>
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
package net.runelite.client.plugins.kourendlibrary;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.overlay.OverlayManager;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KourendLibraryPluginTest
{
	// Inside the library, region 6459
	private static final WorldPoint IN_LIBRARY = new WorldPoint(1632, 3810, 1);
	private static final WorldPoint OUTSIDE_LIBRARY = new WorldPoint(1250, 3750, 0);

	@Inject
	private KourendLibraryPlugin kourendLibraryPlugin;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ClientThread clientThread;

	@Mock
	@Bind
	private ClientToolbar clientToolbar;

	@Mock
	@Bind
	private KourendLibraryConfig kourendLibraryConfig;

	@Mock
	@Bind
	private KourendLibraryOverlay kourendLibraryOverlay;

	@Mock
	@Bind
	private KourendLibraryTutorialOverlay kourendLibraryTutorialOverlay;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	@Mock
	private Player player;

	/**
	 * True only while a runnable handed to {@link ClientThread} is running, mirroring
	 * {@link Client#isClientThread()}.
	 */
	private final AtomicBoolean onClientThread = new AtomicBoolean();

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		// The client asserts that these are only reached from the client thread
		when(client.getLocalPlayer()).thenAnswer(invocation ->
		{
			assertTrue("Client#getLocalPlayer called off the client thread", onClientThread.get());
			return player;
		});

		doAnswer(invocation ->
		{
			onClientThread.set(true);
			try
			{
				invocation.getArgument(0, Runnable.class).run();
			}
			finally
			{
				onClientThread.set(false);
			}
			return null;
		}).when(clientThread).invoke(any(Runnable.class));
	}

	@Test
	public void testShowTargetHintArrowChanged()
	{
		when(player.getWorldLocation()).thenReturn(IN_LIBRARY);

		kourendLibraryPlugin.onConfigChanged(configChanged("showTargetHintArrow"));

		// No book is requested of the player, so any existing hint arrow is cleared
		verify(client).clearHintArrow();
	}

	@Test
	public void testHideButtonChangedInLibrary()
	{
		when(kourendLibraryConfig.hideButton()).thenReturn(true);
		when(player.getWorldLocation()).thenReturn(IN_LIBRARY);

		kourendLibraryPlugin.onConfigChanged(configChanged("hideButton"));

		verify(clientToolbar).addNavigation(any());
	}

	@Test
	public void testHideButtonChangedOutsideLibrary()
	{
		when(kourendLibraryConfig.hideButton()).thenReturn(true);
		when(player.getWorldLocation()).thenReturn(OUTSIDE_LIBRARY);

		kourendLibraryPlugin.onConfigChanged(configChanged("hideButton"));

		verify(clientToolbar).removeNavigation(any());
	}

	private static ConfigChanged configChanged(String key)
	{
		ConfigChanged configChanged = new ConfigChanged();
		configChanged.setGroup(KourendLibraryConfig.GROUP_KEY);
		configChanged.setKey(key);
		return configChanged;
	}
}
