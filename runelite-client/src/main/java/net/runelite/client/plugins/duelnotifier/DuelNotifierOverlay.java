/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.duelnotifier;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

public class DuelNotifierOverlay extends Overlay
{
	private final DuelNotifierConfig config;
	private Instant instant;
	private Instant toggleInstant;
	private boolean toggle;

	private Client client;

	@Inject
	private DuelNotifierOverlay(DuelNotifierConfig config, Client client)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.config = config;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if(config.overlayEnabled() && instant != null) {
			if (Duration.between(instant, Instant.now()).toMillis() > 30000)
				resetTimer();
			if ((Duration.between(toggleInstant, Instant.now()).toMillis() > 500)) {
				toggle = !toggle;
				toggleInstant = Instant.now();
			}
			if (toggle) {
				Color color = config.getOverlayColor();
				graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 120));
				graphics.fill(client.getCanvas().getBounds());
			}
		}
		return null;
	}

	public void startTimer() {
		instant = Instant.now();
		toggleInstant = Instant.now();
		toggle = true;
	}

	public void resetTimer() {
		instant = null;
		toggleInstant = null;
		toggle = false;
	}


}
