/*
 * Copyright (c) 2020, Adam Davies <https://github.com/acdvs>
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
package net.runelite.client.plugins.metronome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.plugins.metronome.ui.MetronomePanel;
import net.runelite.client.ui.overlay.OverlayPosition;

class MetronomeOverlay extends MetronomePanel
{
	private final MetronomePlugin plugin;
	private final MetronomePluginConfiguration config;

	private static final int TICK_FRAMES = 8;
	private static int tickFramesLeft = TICK_FRAMES;

	@Inject
	public MetronomeOverlay(MetronomePlugin plugin, MetronomePluginConfiguration config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_RIGHT);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showVisual())
		{
			return null;
		}

		Color currentColor = config.baseColor();

		if (tickFramesLeft > 0)
		{
			if (config.tockVolume() == 0)
			{
				currentColor = config.tickColor();
			}
			else
			{
				currentColor = plugin.shouldTock ? config.tickColor() : config.tockColor();
			}

			tickFramesLeft--;
		}

		metronomeComponent.setBackgroundColor(currentColor);
		metronomeComponent.setDiameter(config.size());

		return super.render(graphics);
	}

	void resetTickFramesLeft()
	{
		tickFramesLeft = TICK_FRAMES;
	}
}
