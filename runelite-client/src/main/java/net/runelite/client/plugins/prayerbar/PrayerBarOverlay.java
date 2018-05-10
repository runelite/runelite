/*
 * Copyright (c) 2018, Chdata
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
package net.runelite.client.plugins.prayerbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Singleton
public class PrayerBarOverlay extends Overlay
{
	private final Client client;
	private Player localPlayer;
	private boolean showPrayerBar = true;
	private final PrayerBarConfig config;
	private Dimension prayerBarSize = new Dimension(30, 5); // 30x5 is the size of health bars
	//private static final Logger logger = LoggerFactory.getLogger(PrayerBarOverlay.class);

	@Inject
	private PrayerBarOverlay(PrayerBarConfig config, Client client)
	{
		this.config = config;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	public void checkToShowPrayerBar()
	{
		showPrayerBar = true;

		localPlayer = client.getLocalPlayer();

		if (localPlayer == null)
		{
			showPrayerBar = false;
			return;
		}

		if (config.hideIfNotPraying() && !isAnyPrayerActive())
		{
			showPrayerBar = false;
			return;
		}

		if (config.hideIfOutOfCombat() && localPlayer.getHealth() == -1)
		{
			showPrayerBar = false;
		}
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (showPrayerBar)
		{
			return renderPrayerBar(graphics, localPlayer);
		}
		return null;
	}

	private Dimension renderPrayerBar(Graphics2D graphics, Player localPlayer)
	{
		int height = localPlayer.getLogicalHeight() + 15;
		LocalPoint localLocation = localPlayer.getLocalLocation();
		Point canvasPoint = Perspective.worldToCanvas(client, localLocation.getX(), localLocation.getY(), client.getPlane(), height);

		//Draw bar
		int barX = canvasPoint.getX() - 15; // (-15, 3) is to line it up with your health bar, 1 pixel beneath it.
		int barY = canvasPoint.getY() + 3;

		int barWidth = prayerBarSize.width;
		int barHeight = prayerBarSize.height;

		float ratio = (float) client.getBoostedSkillLevel(Skill.PRAYER) / client.getRealSkillLevel(Skill.PRAYER);

		int progressFill = (int) Math.ceil(Math.min((barWidth * ratio), barWidth)); // Restricted by the width to prevent the bar from being too long while you are boosted above your real prayer level.

		graphics.setColor(Color.white);
		graphics.fillRect(barX, barY, barWidth, barHeight);
		graphics.setColor(Color.cyan);
		graphics.fillRect(barX, barY, progressFill, barHeight);

		return new Dimension(barWidth, barHeight);
	}

	private boolean isAnyPrayerActive()
	{
		for (Prayer pray : Prayer.values()) // Check if any prayers are active
		{
			if (client.isPrayerActive(pray))
			{
				return true;
			}
		}

		return false;
	}
}
