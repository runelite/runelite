/*
 * Copyright (c) 2021, Alexsuperfly <alexsuperfly@users.noreply.github.com>
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
package net.runelite.client.plugins.cannon;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CannonPluginTest
{

	@Inject
	private CannonPlugin plugin;

	@Mock
	@Bind
	private CannonConfig config;

	@Mock
	@Bind
	private CannonOverlay cannonOverlay;

	@Mock
	@Bind
	private CannonSpotOverlay cannonSpotOverlay;

	@Mock
	@Bind
	private InfoBoxManager infoBoxManager;

	@Mock
	@Bind
	private Notifier notifier;

	@Mock
	@Bind
	private ItemManager itemManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private OverlayManager overlayManager;

	private static final VarbitChanged cannonAmmoChanged = new VarbitChanged();

	@BeforeClass
	public static void cannonVarpSetup()
	{
		cannonAmmoChanged.setIndex(VarPlayer.CANNON_AMMO.getId());
	}

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
	}

	@Test
	public void testAmmoCountOnPlace()
	{
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.SPAM);
		chatMessage.setMessage("You add the furnace.");

		plugin.onChatMessage(chatMessage);
		assertTrue(plugin.isCannonPlaced());

		plugin.onVarbitChanged(cannonAmmoChanged);
		assertEquals(0, plugin.getCballsLeft());

		// Some time passes...

		when(client.getVar(VarPlayer.CANNON_AMMO)).thenReturn(30);
		plugin.onVarbitChanged(cannonAmmoChanged);
		assertEquals(30, plugin.getCballsLeft());
	}

	@Test
	public void testCannonInfoBox()
	{
		when(config.showInfobox()).thenReturn(true);

		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(ChatMessageType.SPAM);
		chatMessage.setMessage("You add the furnace.");

		plugin.onChatMessage(chatMessage);
		assertTrue(plugin.isCannonPlaced());

		assertEquals(0, plugin.getCballsLeft());
		verify(infoBoxManager).addInfoBox(any(CannonCounter.class));
	}

	@Test
	public void testThresholdNotificationShouldNotify()
	{
		when(config.showCannonNotifications()).thenReturn(true);
		when(config.lowWarningThreshold()).thenReturn(10);

		when(client.getVar(VarPlayer.CANNON_AMMO)).thenReturn(30);
		plugin.onVarbitChanged(cannonAmmoChanged);
		when(client.getVar(VarPlayer.CANNON_AMMO)).thenReturn(10);
		plugin.onVarbitChanged(cannonAmmoChanged);

		verify(notifier, times(1)).notify("Your cannon has 10 cannon balls remaining!");
	}

	@Test
	public void testThresholdNotificationShouldNotifyOnce()
	{
		when(config.showCannonNotifications()).thenReturn(true);
		when(config.lowWarningThreshold()).thenReturn(10);

		for (int cballs = 15; cballs >= 8; --cballs)
		{
			when(client.getVar(VarPlayer.CANNON_AMMO)).thenReturn(cballs);
			plugin.onVarbitChanged(cannonAmmoChanged);
		}

		verify(notifier, times(1)).notify("Your cannon has 10 cannon balls remaining!");
	}

	@Test
	public void testThresholdNotificationsShouldNotNotify()
	{
		when(config.showCannonNotifications()).thenReturn(true);
		when(config.lowWarningThreshold()).thenReturn(0);

		when(client.getVar(VarPlayer.CANNON_AMMO)).thenReturn(30);
		plugin.onVarbitChanged(cannonAmmoChanged);
		when(client.getVar(VarPlayer.CANNON_AMMO)).thenReturn(10);
		plugin.onVarbitChanged(cannonAmmoChanged);

		verify(notifier, never()).notify("Your cannon has 10 cannon balls remaining!");
	}

	@Test
	public void testCannonOutOfAmmo()
	{
		when(config.showCannonNotifications()).thenReturn(true);
		ChatMessage cannonOutOfAmmo = new ChatMessage(null, ChatMessageType.GAMEMESSAGE, "", "Your cannon is out of ammo!", "", 0);

		plugin.onChatMessage(cannonOutOfAmmo);

		verify(notifier, times(1)).notify("Your cannon is out of ammo!");
	}
}
