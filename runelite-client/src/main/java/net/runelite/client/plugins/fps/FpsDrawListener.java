/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package net.runelite.client.plugins.fps;

import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.events.FocusChanged;
import net.runelite.client.ui.DrawListener;

public class FpsDrawListener implements DrawListener
{
	private final FpsConfig config;
	private long lastDelay = 0;
	private long lastMillis = 0;
	private boolean alwaysEnabled = false;
	private boolean unfocusedEnabled = false;
	private boolean isFocused = true;
	private long maxFPS = 60;

	@Inject
	private FpsDrawListener(FpsConfig config)
	{
		this.config = config;
		reloadConfig();
	}

	void reloadConfig()
	{
		alwaysEnabled = config.alwaysLimitFps();
		unfocusedEnabled = config.unfocusedLimitFps();
		lastDelay = 1000 / Math.max(1, config.maxFPS());
		lastMillis = 0;
		maxFPS = config.maxFPS();
	}

	void onFocusChanged(FocusChanged event) {
		this.isFocused = event.isFocused();
	}

	@Override
	public void drawComplete(BufferedImage image)
	{
		if (alwaysEnabled || (unfocusedEnabled && !isFocused))
		{
			long now = System.currentTimeMillis();

			// We can't trust client.getFPS to get frame-perfect FPS knowledge.
			long fps = 1000 / Math.min(1000, now - this.lastMillis);
			long fpsDiff = fps - maxFPS;

			// ease into it
			if (fpsDiff > 0)
			{
				this.lastDelay += 2;
			}
			else if (fpsDiff < 0)
			{
				this.lastDelay -= 2;
			}

			if (this.lastDelay > 0)
			{
				try
				{
					Thread.sleep(this.lastDelay);
				}
				catch (InterruptedException e)
				{
					// Can happen on shutdown
				}
			}

			this.lastMillis = now;
		}
	}
}
