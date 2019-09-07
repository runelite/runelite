/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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
package net.runelite.client.plugins.customcursor;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;

import java.io.IOException;

@Slf4j
@PluginDescriptor(
	name = "Custom Cursor",
	description = "Replaces your mouse cursor image",
	enabledByDefault = false
)
@Singleton
public class CustomCursorPlugin extends Plugin
{
	@Inject
	private ClientUI clientUI;

	@Inject
	private CustomCursorConfig config;

	@Inject
	private EventBus eventBus;

	private Clip skillSpecsRage;
	private int volume = 35;

	@Provides
	CustomCursorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CustomCursorConfig.class);
	}

	@Override
	protected void startUp()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		updateCursor();

		try (AudioInputStream ais = AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream("specs-rage.wav")))
		{
			skillSpecsRage = AudioSystem.getClip();
			skillSpecsRage.open(ais);
			FloatControl gain = (FloatControl) skillSpecsRage.getControl(FloatControl.Type.MASTER_GAIN);
			float gainVal = (((float) volume) * 40f / 100f) - 35f;
			gain.setValue(gainVal);
		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			log.warn("Error opening audiostream from specs-rage.wav", e);
			skillSpecsRage = null;
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		clientUI.resetCursor();
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("customcursor") && event.getKey().equals("cursorStyle"))
		{
			updateCursor();
		}

		if (event.getGroup().equals("metronome") && event.getKey().equals("volume"))
		{
			this.volume = Integer.parseInt(event.getNewValue());
		}
	}

	private void updateCursor()
	{
		CustomCursor selectedCursor = config.selectedCursor();

		if (selectedCursor == CustomCursor.SKILL_SPECS)
		{
			if (skillSpecsRage != null)
			{
				if (skillSpecsRage.isRunning())
				{
					skillSpecsRage.stop();
				}

				skillSpecsRage.setFramePosition(0);
				skillSpecsRage.start();
			}
		}

		clientUI.setCursor(selectedCursor.getCursorImage(), selectedCursor.toString());
	}
}