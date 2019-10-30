/*
 * Copyright (c) 2018, WooxSolo <https://github.com/WooxSolo>
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
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

class SoundEffectOverlay extends Overlay
{
	private final static int MAX_LINES = 16;
	private final static Color COLOR_SOUND_EFFECT = Color.WHITE;
	private final static Color COLOR_AREA_SOUND_EFFECT = Color.YELLOW;
	private final static Color COLOR_SILENT_SOUND_EFFECT = Color.GRAY;

	private final Client client;
	private final DevToolsPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	SoundEffectOverlay(Client client, DevToolsPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		panelComponent.setPreferredSize(new Dimension(200, 0));
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Sound Effects")
			.leftColor(Color.CYAN)
			.build());
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getSoundEffects().isActive())
		{
			return null;
		}

		return panelComponent.render(graphics);
	}

	void onSoundEffectPlayed(SoundEffectPlayed event)
	{
		String text =
			"Id: " + event.getSoundId() +
			" - D: " + event.getDelay();

		panelComponent.getChildren().add(LineComponent.builder()
			.left(text)
			.leftColor(COLOR_SOUND_EFFECT)
			.build());

		checkMaxLines();
	}

	void onAreaSoundEffectPlayed(AreaSoundEffectPlayed event)
	{
		Color textColor = COLOR_AREA_SOUND_EFFECT;

		// Check if the player is within range to hear the sound
		Player localPlayer = client.getLocalPlayer();
		if (localPlayer != null)
		{
			LocalPoint lp = localPlayer.getLocalLocation();
			if (lp != null)
			{
				int sceneX = lp.getSceneX();
				int sceneY = lp.getSceneY();
				int distance = Math.abs(sceneX - event.getSceneX()) + Math.abs(sceneY - event.getSceneY());
				if (distance > event.getRange())
				{
					textColor = COLOR_SILENT_SOUND_EFFECT;
				}
			}
		}

		String text =
			"Id: " + event.getSoundId() +
			" - L: " + event.getSceneX() + "," + event.getSceneY() +
			" - R: " + event.getRange() +
			" - D: " + event.getDelay();

		panelComponent.getChildren().add(LineComponent.builder()
			.left(text)
			.leftColor(textColor)
			.build());

		checkMaxLines();
	}

	private void checkMaxLines()
	{
		while (panelComponent.getChildren().size() > MAX_LINES)
		{
			panelComponent.getChildren().remove(1);
		}
	}
}
