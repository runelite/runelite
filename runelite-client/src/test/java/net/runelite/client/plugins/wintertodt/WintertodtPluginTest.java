/*
 * Copyright (c) 2019, Kusha Gharahi<kusha.me>
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
package net.runelite.client.plugins.wintertodt;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.Notifier;
import net.runelite.client.ui.overlay.OverlayManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WintertodtPluginTest
{
	@Inject
	WintertodtPlugin wintertodtPlugin;

	@Mock
	@Bind
	WintertodtConfig config;

	@Mock
	@Bind
	WintertodtOverlay wintertodtOverlay;

	@Mock
	@Bind
	OverlayManager overlayManager;

	@Mock
	@Bind
	Notifier notifier;

	@Mock
	@Bind
	Client client;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);

		Player local = mock(Player.class);
		when(local.getWorldLocation()).thenReturn(new WorldPoint(1600, 3968, 0));
		when(client.getLocalPlayer()).thenReturn(local);

		wintertodtPlugin.onGameTick(new GameTick());
	}

	@Test
	public void matchStartingNotification_shouldNotify_when15SecondsOptionSelected()
	{
		when(config.roundNotification()).thenReturn(15);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(VarbitID.WINT_TRANSMIT_RESPAWNDELAY);

		varbitChanged.setValue(35);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		//(15 * 50) / 30 = ~25
		varbitChanged.setValue(25);
		wintertodtPlugin.onVarbitChanged(varbitChanged);

		verify(notifier, times(1)).notify("Wintertodt round is about to start");
	}

	@Test
	public void matchStartingNotification_shouldNotify_when10SecondsOptionSelected()
	{
		when(config.roundNotification()).thenReturn(10);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(VarbitID.WINT_TRANSMIT_RESPAWNDELAY);

		varbitChanged.setValue(20);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		//(10 * 50) / 30 = ~16
		varbitChanged.setValue(16);
		wintertodtPlugin.onVarbitChanged(varbitChanged);

		verify(notifier, times(1)).notify("Wintertodt round is about to start");
	}

	@Test
	public void matchStartingNotification_shouldNotify_when5SecondsOptionSelected()
	{
		when(config.roundNotification()).thenReturn(5);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(VarbitID.WINT_TRANSMIT_RESPAWNDELAY);

		varbitChanged.setValue(10);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		//(5 * 50) / 30 = ~8
		varbitChanged.setValue(8);
		wintertodtPlugin.onVarbitChanged(varbitChanged);

		verify(notifier, times(1)).notify("Wintertodt round is about to start");
	}

	@Test
	public void matchStartingNotification_shouldNotifyOnce()
	{
		when(config.roundNotification()).thenReturn(5);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(VarbitID.WINT_TRANSMIT_RESPAWNDELAY);

		varbitChanged.setValue(0);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		varbitChanged.setValue(10);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		varbitChanged.setValue(8);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		varbitChanged.setValue(6);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		varbitChanged.setValue(5);
		wintertodtPlugin.onVarbitChanged(varbitChanged);
		varbitChanged.setValue(4);
		wintertodtPlugin.onVarbitChanged(varbitChanged);

		verify(notifier, times(1)).notify("Wintertodt round is about to start");
	}

	@Test
	public void matchStartingNotification_shouldNotNotify_whenNoneOptionSelected()
	{
		when(config.roundNotification()).thenReturn(5);

		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setVarbitId(VarbitID.WINT_TRANSMIT_RESPAWNDELAY);

		wintertodtPlugin.onVarbitChanged(varbitChanged);
		verify(notifier, times(0)).notify("Wintertodt round is about to start");
	}
}
