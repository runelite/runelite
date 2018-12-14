/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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
package net.runelite.client.plugins.barbarianassault;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;

class TextOverlay extends Overlay
{
	private final Client client;
	private final BarbarianAssaultPlugin plugin;
	private final BarbarianAssaultConfig config;
	private final TextComponent textComponent = new TextComponent();

	@Getter
	@Setter
	private Round currentRound;


	@Inject
	private TextOverlay(Client client, BarbarianAssaultPlugin plugin, BarbarianAssaultConfig config)
	{
		setPosition(OverlayPosition.BOTTOM_LEFT);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || currentRound == null)
		{
			return null;
		}
		if (config.textOverlay()) {
			showText(graphics);
		}
		return null;
	}

	private void showText(Graphics2D graphics)
	{
		String text = getText(plugin.currentWave);
		if (text != null)
		{
			textComponent.setColor(config.chooseColor());
			textComponent.setText(text);
			textComponent.render(graphics);
		}
	}

	private String getText(String currentWave)
	{
		switch (currentWave) {
			case "1":
				return "3-3";
			case "2":
				return "2-2(3)-4";
			case "3":
				return "1-6-2";
			case "4":
				return "1-4-3 // 0-0-0-7";
			case "5":
				return "1-3-2-2 // 0-0-0-0-7 \n d-18-d-27-d";
			case "6":
				return "2-3-2-2 // 0-0-0-0-6-8 \n 18-18-21-27-54(or 51 and use 7 food)-d";
			case "7":
				return "5-2-1-1 // 0-1-1-1-3-3 \n Overstock, rp the 48, spam the last.";
			case "8":
				return "4-2-2-1 // 1-1-0-1-2-2-1 \n d-d-27-d-48(rp 5th after the 48 spawns)";
			case "9":
				return "2-5-1-1 // 1-2-1-1-2-1-1";
			case "10":
				return "5-2-1-1 // 0-1-1-1-3-3 \n 27-33-d-d-51";
			default:
				return null;
		}
	}
}
