/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package net.runelite.client.plugins.prayflick;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class PrayerFlickOverlay  extends Overlay
{
	private final RuneLite runelite;
	private final Client client;
	private final PrayerFlickConfig config;

	private long startOfLastTick = System.currentTimeMillis();

	public void resetTickIndicator()
	{
		startOfLastTick = System.currentTimeMillis();
	}

	@Inject
	public PrayerFlickOverlay(RuneLite runelite, @Nullable Client client, PrayerFlickConfig config)
	{
		super(OverlayPosition.DYNAMIC);
		this.runelite = runelite;
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !config.enabled())
		{
			return null;
		}

		Widget xpOrb = client.getWidget(WidgetInfo.MINIMAP_XP_ORB);
		if (xpOrb == null)
		{
			return null;
		}

		Rectangle2D bounds = xpOrb.getBounds().getBounds2D();
		if (bounds.getX() <= 0)
		{
			return null;
		}


		int orbInnerHeight = 28;
		int orbInnerWidth = 29;

		int orbInnerX = (int) (bounds.getX() + 26);//x pos of the inside of the prayer orb
		int orbInnerY = (int) (bounds.getY() + 67);//y pos of the inside of the prayer orb

		long timeSinceLastTick = System.currentTimeMillis() - startOfLastTick;

		float tickProgress = timeSinceLastTick/600f;
		tickProgress = Math.min(tickProgress,1);//Cap to 1, so if a tick continues past the expected 600 we don't move the indicator off the orb

		double t = tickProgress * Math.PI;//t on interval [0,pi]

		int xOffset = (int)(-Math.cos(t)*orbInnerWidth/2) + orbInnerWidth/2;
		int indicatorHeight = (int)(Math.sin(t)*orbInnerHeight);

		int yOffset = (orbInnerHeight/2)-(indicatorHeight/2);


		graphics.setColor(Color.cyan);
		graphics.fillRect(orbInnerX+xOffset,orbInnerY+yOffset,1,indicatorHeight);

		return null;
	}
}
