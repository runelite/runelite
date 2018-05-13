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
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.*;

@Singleton
public class PrayerBarOverlay extends Overlay
{
	private static final Color BAR_FILL_COLOR = Color.cyan;
	private static final Color BAR_BG_COLOR = Color.white;
	private static final Dimension PRAYER_BAR_SIZE = new Dimension(30, 5); // 30x5 is the size of health bars

	private final Client client;
	private final PrayerBarPlugin plugin;
	private final PrayerBarConfig config;

	@Inject
	private PrayerBarOverlay(PrayerBarPlugin plugin, PrayerBarConfig config, Client client)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isShowingPrayerBar())
		{
			return renderPrayerBar(graphics, client.getLocalPlayer());
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

		int barWidth = PRAYER_BAR_SIZE.width;
		int barHeight = PRAYER_BAR_SIZE.height;

		float ratio = (float) client.getBoostedSkillLevel(Skill.PRAYER) / client.getRealSkillLevel(Skill.PRAYER);

		int progressFill = (int) Math.ceil(Math.min((barWidth * ratio), barWidth)); // Restricted by the width to prevent the bar from being too long while you are boosted above your real prayer level.

		graphics.setColor(BAR_BG_COLOR);
		graphics.fillRect(barX, barY, barWidth, barHeight);
		graphics.setColor(BAR_FILL_COLOR);
		graphics.fillRect(barX, barY, progressFill, barHeight);

		return new Dimension(barWidth, barHeight);
	}
}
