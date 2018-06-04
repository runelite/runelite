/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.prayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class PrayerFlickOverlay extends Overlay
{
	private final Client client;
	private boolean prayersActive = false;
	private Instant startOfLastTick = Instant.now();

	@Inject
	public PrayerFlickOverlay(Client client)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
	}

	public void onTick()
	{
		startOfLastTick = Instant.now(); //Reset the tick timer
		prayersActive = isAnyPrayerActive(); //Check if prayers are active
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!prayersActive) //If there are no prayers active we don't need to be flicking
		{
			return null;
		}

		Widget xpOrb = client.getWidget(WidgetInfo.QUICK_PRAYER_ORB);
		if (xpOrb == null)
		{
			return null;
		}

		Rectangle2D bounds = xpOrb.getBounds().getBounds2D();
		if (bounds.getX() <= 0)
		{
			return null;
		}

		//Purposefully using height twice here as the bounds of the prayer orb includes the number sticking out the side
		int orbInnerHeight = (int) bounds.getHeight();
		int orbInnerWidth = orbInnerHeight;

		int orbInnerX = (int) (bounds.getX() + 24);//x pos of the inside of the prayer orb
		int orbInnerY = (int) (bounds.getY() - 1);//y pos of the inside of the prayer orb

		long timeSinceLastTick = Duration.between(startOfLastTick, Instant.now()).toMillis();

		float tickProgress = timeSinceLastTick / 600f;
		tickProgress = Math.min(tickProgress, 1);//Cap to 1, so if a tick continues past the expected 600 we don't move the indicator off the orb

		double t = tickProgress * Math.PI;//t on interval [0,pi]

		int xOffset = (int) (-Math.cos(t) * orbInnerWidth / 2) + orbInnerWidth / 2;
		int indicatorHeight = (int) (Math.sin(t) * orbInnerHeight);

		int yOffset = (orbInnerHeight / 2) - (indicatorHeight / 2);

		graphics.setColor(Color.cyan);
		graphics.fillRect(orbInnerX + xOffset, orbInnerY + yOffset, 1, indicatorHeight);

		return new Dimension((int) bounds.getWidth(), (int) bounds.getHeight());
	}

	boolean isAnyPrayerActive()
	{
		for (Prayer pray : Prayer.values())//Check if any prayers are active
		{
			if (client.isPrayerActive(pray))
			{
				return true;
			}
		}

		return false;
	}
}
