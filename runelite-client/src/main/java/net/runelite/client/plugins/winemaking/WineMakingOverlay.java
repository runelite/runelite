/*
 * Copyright (c) 2017, Evan Walden <etwalden@edu.uwaterloo.ca>
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
package net.runelite.client.plugins.winemaking;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

class WineMakingOverlay extends Overlay
{
	private static final int WINE_FERMENTATION_DURATION_SECONDS = 12;
	
	private final WineMakingPlugin plugin;
	private final WineMakingConfig config;
	
	private final PanelComponent panelComponent = new PanelComponent();
	private final PanelComponent.Line timeRemainingLine = new PanelComponent.Line("Time left (s)", "");
	
	@Inject
	public WineMakingOverlay(Client client, WineMakingPlugin plugin, WineMakingConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.config = config;
		
		panelComponent.setTitle("Wine Timer");
		panelComponent.getLines().add(timeRemainingLine);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{	
		if (!config.showFermentationTimer() 
			|| plugin.getLastWineMade() == null)
		{
			return null;
		}
		
		long elapsedSeconds = Duration.between(plugin.getLastWineMade(), Instant.now()).getSeconds();
		
		long remainingSeconds = WINE_FERMENTATION_DURATION_SECONDS - elapsedSeconds;
		
		if (remainingSeconds <= 0)
		{
			return null;
		}
		
		timeRemainingLine.setRight(String.valueOf(remainingSeconds));
		
		return panelComponent.render(graphics);
	}
}
