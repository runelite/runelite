/*
 * Copyright (c) 2018 Nicholas I
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

package net.runelite.client.plugins.prayerindicator;

import com.google.inject.Inject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

public class PrayerIndicatorOverlay extends Overlay
{
	private Color orbIndicatorColor = new Color (0, 255, 255, 255);
	// How much to subtract/add to the alpha of the indicator orb
	private int alphaOffset = -10;
	
	private final PrayerIndicatorPlugin plugin;
	private final Client client;
	private final PrayerIndicatorConfig config;
	private final InfoBoxManager infoBoxManager;
	
	@Inject
	public PrayerIndicatorOverlay (PrayerIndicatorPlugin plugin, Client client, PrayerIndicatorConfig config, InfoBoxManager infoBoxManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.plugin = plugin;
		this.client = client;
		this.config = config;
		this.infoBoxManager = infoBoxManager;
	}
	
	@Override
	public Dimension render (Graphics2D graphics)
	{
		if (!plugin.isPlayerPrayerLow() || plugin.getPlayerPotionID() == -1)
		{
			//First remove the indicator from the info box if needed
			if (infoBoxManager.getInfoBoxes().contains(plugin.getIndicator()))
				infoBoxManager.removeInfoBox(plugin.getIndicator());
			
			return null;
		}
		
		if (config.inInfoBox())
		{
			if (!infoBoxManager.getInfoBoxes().contains(plugin.getIndicator()))
				infoBoxManager.addInfoBox(plugin.getIndicator());
		}
		
		if (config.displayOverOrb())
		{
			Widget quickPrayOrb = client.getWidget(WidgetInfo.QUICK_PRAYER_ORB);
			//Make sure the prayer orb isn't deactivated
			if (quickPrayOrb == null)
			{
				return null;
			}
			
			Rectangle orbBounds = quickPrayOrb.getBounds();
			if (orbBounds.getX() <= 0)
				return null;
			
			//We need to offset the bounds due to it including the prayer number
			//	This is easily achieved by just using the height for the width
			//	Then it also needs to be changed so that it fills the entire prayer orb
			double orbOffsetSize = orbBounds.getHeight();
			//Do the same but for the x coord
			//	However this time it's achieved by just adding onto the existing
			//	x coord with the difference of the original width and offset width.
			double orbOffsetX = (orbBounds.getX() + (orbBounds.getWidth() - orbOffsetSize));
			double orbOffsetY = orbBounds.getY() - 2d;
			
			//Every loop add or subtract to the transparency of the orb indicator
			//First we need to check if the orb's alpha value is >= 1 or <= 0.5f
			if (orbIndicatorColor.getAlpha() >= 255)
			{
				//Since the orb's alpha is at the top most value the alphaOffset needs to be set to a negative to subtract from it
				alphaOffset = -5;
			}
			else if (orbIndicatorColor.getAlpha() <= 100)
			{
				//Since the orb's alpha is at the bottom most value the alphaOffset needs to be set to a positive to add to it
				alphaOffset = 5;
			}
			
			//Now actually change the alpha
			orbIndicatorColor = new Color(
					orbIndicatorColor.getRed(),
					orbIndicatorColor.getGreen(),
					orbIndicatorColor.getBlue(),
					orbIndicatorColor.getAlpha() + alphaOffset);
			
			graphics.setColor(orbIndicatorColor);
			graphics.setStroke(new BasicStroke(2f));
			//Let's create a 2d ellipse object so we can set the x/y value as a double rather then an int for a more precise position
			Ellipse2D.Double shape = new Ellipse2D.Double(orbOffsetX, orbOffsetY, orbOffsetSize, orbOffsetSize);
			graphics.draw(shape);
		}
		
		return null;
	}
}
