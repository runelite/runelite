/*
 * Copyright (c) 2024
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
package net.runelite.client.plugins.music;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Preferences;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VolumeChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MusicPluginTest
{
	@Inject
	MusicPlugin musicPlugin;

	@Mock
	@Bind
	Client client;

	@Mock
	@Bind
	MusicConfig musicConfig;

	@Mock
	@Bind
	ClientThread clientThread;

	@Mock
	@Bind
	ChatboxPanelManager chatboxPanelManager;

	@Mock
	@Bind
	TooltipManager tooltipManager;

	@Mock
	Preferences preferences;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(client.getPreferences()).thenReturn(preferences);
		when(client.getGameState()).thenReturn(GameState.LOGGED_IN);

		doAnswer(invocation -> {
			Runnable runnable = invocation.getArgument(0);
			runnable.run();
			return null;
		}).when(clientThread).invoke(any(Runnable.class));

		musicPlugin.startUp();
	}

	@Test
	public void testVolumeChangedDoesNotOverrideExternalVolumeChanges()
	{
		when(musicConfig.granularSliders()).thenReturn(true);

		VolumeChanged volumeChanged = new VolumeChanged(VolumeChanged.Type.MUSIC);
		musicPlugin.onVolumeChanged(volumeChanged);

		verify(client, never()).setMusicVolume(anyInt());
		verify(preferences, never()).setSoundEffectVolume(anyInt());
		verify(preferences, never()).setAreaSoundEffectVolume(anyInt());
	}

	@Test
	public void testVolumeChangedDoesNotOverrideExternalSoundEffectChanges()
	{
		when(musicConfig.granularSliders()).thenReturn(true);

		VolumeChanged volumeChanged = new VolumeChanged(VolumeChanged.Type.EFFECTS);
		musicPlugin.onVolumeChanged(volumeChanged);

		verify(client, never()).setMusicVolume(anyInt());
		verify(preferences, never()).setSoundEffectVolume(anyInt());
		verify(preferences, never()).setAreaSoundEffectVolume(anyInt());
	}

	@Test
	public void testVolumeChangedDoesNotOverrideExternalAreaSoundChanges()
	{
		when(musicConfig.granularSliders()).thenReturn(true);

		VolumeChanged volumeChanged = new VolumeChanged(VolumeChanged.Type.AREA);
		musicPlugin.onVolumeChanged(volumeChanged);

		verify(client, never()).setMusicVolume(anyInt());
		verify(preferences, never()).setSoundEffectVolume(anyInt());
		verify(preferences, never()).setAreaSoundEffectVolume(anyInt());
	}

	@Test
	public void testVolumeChangedIgnoredWhenGranularSlidersDisabled()
	{
		when(musicConfig.granularSliders()).thenReturn(false);

		VolumeChanged volumeChanged = new VolumeChanged(VolumeChanged.Type.MUSIC);
		musicPlugin.onVolumeChanged(volumeChanged);

		verify(client, never()).setMusicVolume(anyInt());
		verify(preferences, never()).setSoundEffectVolume(anyInt());
		verify(preferences, never()).setAreaSoundEffectVolume(anyInt());
	}

	@Test
	public void testVolumeSetWhenSettingsWidgetLoaded()
	{
		when(musicConfig.granularSliders()).thenReturn(true);
		when(musicConfig.getMusicVolume()).thenReturn(128);
		when(musicConfig.getSoundEffectVolume()).thenReturn(64);
		when(musicConfig.getAreaSoundEffectVolume()).thenReturn(64);

		net.runelite.api.events.WidgetLoaded widgetLoaded = new net.runelite.api.events.WidgetLoaded();
		widgetLoaded.setGroupId(net.runelite.api.gameval.InterfaceID.SETTINGS_SIDE);
		musicPlugin.onWidgetLoaded(widgetLoaded);

		verify(client).setMusicVolume(127);
		verify(preferences).setSoundEffectVolume(63);
		verify(preferences).setAreaSoundEffectVolume(63);
	}

	@Test
	public void testVolumeSetOnLogin()
	{
		when(musicConfig.granularSliders()).thenReturn(true);
		when(musicConfig.getMusicVolume()).thenReturn(128);
		when(musicConfig.getSoundEffectVolume()).thenReturn(64);
		when(musicConfig.getAreaSoundEffectVolume()).thenReturn(64);

		GameStateChanged gameStateChanged = new GameStateChanged();
		gameStateChanged.setGameState(GameState.LOGGED_IN);
		musicPlugin.onGameStateChanged(gameStateChanged);

		verify(client).setMusicVolume(127);
		verify(preferences).setSoundEffectVolume(63);
		verify(preferences).setAreaSoundEffectVolume(63);
	}
}
