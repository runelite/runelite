/*
 * Copyright (c) 2021, roflmuffin <shortguy014@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;

class WintertodtIdleOverlay extends OverlayPanel
{
	private final WintertodtPlugin plugin;
	private final WintertodtConfig wintertodtConfig;
	private final Client client;

	@Inject
	private WintertodtIdleOverlay(WintertodtPlugin plugin, WintertodtConfig wintertodtConfig, Client client)
	{
		super(plugin);
		this.plugin = plugin;
		this.wintertodtConfig = wintertodtConfig;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension getPreferredSize()
	{
		return client.getCanvas().getSize();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInWintertodt() || !wintertodtConfig.showIdleOverlay() || plugin.getPreviousTimerValue() > wintertodtConfig.roundNotification())
		{
			return null;
		}

		if (plugin.getCurrentActivity() == WintertodtActivity.IDLE)
		{
			final Color color = graphics.getColor();
			graphics.setColor(wintertodtConfig.idleOverlayColor());
			graphics.fill(new Rectangle(client.getCanvas().getSize()));
			graphics.setColor(color);
		}

		return super.render(graphics);
	}
}