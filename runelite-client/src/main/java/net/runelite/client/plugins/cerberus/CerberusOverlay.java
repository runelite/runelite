/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
 * Copyright (c) 2018, Magic fTail
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
package net.runelite.client.plugins.cerberus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class CerberusOverlay extends Overlay
{
	private static final Color COLOR_ICON_BACKGROUND = new Color(0, 0, 0, 128);
	private static final Color COLOR_ICON_BORDER = Color.BLACK;
	private static final int OVERLAY_ICON_DISTANCE = 50;
	private static final int OVERLAY_ICON_MARGIN = 8;
	private static final int OVERLAY_Z_OFFSET = 100;

	private final Client client;
	private final CerberusPlugin plugin;
	private final SkillIconManager iconManager;

	private BufferedImage icon;

	@Inject
	private CerberusOverlay(Client client, CerberusPlugin plugin, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.iconManager = iconManager;
	}

	private void getIcon(NPC ghost)
	{
		CerberusGhost.fromNPC(ghost).ifPresent(cerberusGhost ->
			icon = iconManager.getSkillImage(cerberusGhost.getType()));
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (NPC ghost : plugin.getGhosts())
		{
			LocalPoint lp = ghost.getLocalLocation();
			if (lp != null)
			{
				Point point = Perspective.localToCanvas(client, lp, client.getPlane(),
					OVERLAY_Z_OFFSET);

				if (point != null)
				{
					point = new Point(point.getX(), point.getY());

					getIcon(ghost);

					if (icon == null)
					{
						continue;
					}

					renderPrayerIndicator(graphics, icon, point);
				}
			}
		}
		return null;
	}

	private static void renderPrayerIndicator(Graphics2D graphics, BufferedImage icon, Point point)
	{
		int width = OVERLAY_ICON_MARGIN + icon.getWidth();

		int bgPadding = 4;
		graphics.setStroke(new BasicStroke(2));
		graphics.setColor(COLOR_ICON_BACKGROUND);
		graphics.fillOval(
			point.getX() - width / 2 - bgPadding,
			point.getY() - icon.getHeight() / 2 - OVERLAY_ICON_DISTANCE - bgPadding,
			icon.getWidth() + bgPadding * 2,
			icon.getHeight() + bgPadding * 2);

		graphics.setColor(COLOR_ICON_BORDER);
		graphics.drawOval(
			point.getX() - width / 2 - bgPadding,
			point.getY() - icon.getHeight() / 2 - OVERLAY_ICON_DISTANCE - bgPadding,
			icon.getWidth() + bgPadding * 2,
			icon.getHeight() + bgPadding * 2);

		graphics.drawImage(
			icon,
			point.getX() - width / 2,
			point.getY() - icon.getHeight() / 2 - OVERLAY_ICON_DISTANCE,
			null);
	}
}