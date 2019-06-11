/*
 * Copyright (c) 2018, https://runelitepl.us
 * Copyright (c) 2019, Infinitay <https://github.com/Infinitay>
 *
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
package net.runelite.client.plugins.vorkath;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class VorkathOverlay extends Overlay
{
	private static final Color COLOR_ICON_BACKGROUND = new Color(0, 0, 0, 128);
	private static final Color COLOR_ICON_BORDER = new Color(0, 0, 0, 255);
	private static final Color COLOR_ICON_BORDER_FILL = new Color(219, 175, 0, 255);
	private static final int OVERLAY_ICON_DISTANCE = 30;
	private static final int OVERLAY_ICON_MARGIN = 1;

	private Client client;
	private VorkathPlugin plugin;

	@Inject
	public VorkathOverlay(Client client, VorkathPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getVorkath() != null)
		{
			Vorkath vorkath = plugin.getVorkath();

			LocalPoint localLocation = vorkath.getVorkath().getLocalLocation();
			if (localLocation != null)
			{
				Point point = Perspective.localToCanvas(client, localLocation, client.getPlane(), vorkath.getVorkath().getLogicalHeight() + 16);
				if (point != null)
				{
					point = new Point(point.getX(), point.getY());

					BufferedImage currentPhaseIcon = getIcon(vorkath);

					int totalWidth = currentPhaseIcon.getWidth() * OVERLAY_ICON_MARGIN;
					int bgPadding = 8;
					int currentPosX = 0;

					graphics.setStroke(new BasicStroke(2));
					graphics.setColor(COLOR_ICON_BACKGROUND);
					graphics.fillOval(
						point.getX() - totalWidth / 2 + currentPosX - bgPadding,
						point.getY() - currentPhaseIcon.getHeight() / 2 - OVERLAY_ICON_DISTANCE - bgPadding,
						currentPhaseIcon.getWidth() + bgPadding * 2,
						currentPhaseIcon.getHeight() + bgPadding * 2);

					graphics.setColor(COLOR_ICON_BORDER);
					graphics.drawOval(
						point.getX() - totalWidth / 2 + currentPosX - bgPadding,
						point.getY() - currentPhaseIcon.getHeight() / 2 - OVERLAY_ICON_DISTANCE - bgPadding,
						currentPhaseIcon.getWidth() + bgPadding * 2,
						currentPhaseIcon.getHeight() + bgPadding * 2);

					graphics.drawImage(
						currentPhaseIcon,
						point.getX() - totalWidth / 2 + currentPosX,
						point.getY() - currentPhaseIcon.getHeight() / 2 - OVERLAY_ICON_DISTANCE,
						null);

					graphics.setColor(COLOR_ICON_BORDER_FILL);
					Arc2D.Double arc = new Arc2D.Double(
						point.getX() - totalWidth / 2 + currentPosX - bgPadding,
						point.getY() - currentPhaseIcon.getHeight() / 2 - OVERLAY_ICON_DISTANCE - bgPadding,
						currentPhaseIcon.getWidth() + bgPadding * 2,
						currentPhaseIcon.getHeight() + bgPadding * 2,
						90.0,
						-360.0 * getAttacksLeftProgress(),
						Arc2D.OPEN);
					graphics.draw(arc);
				}
			}
		}

		return null;
	}

	/**
	 * @param vorkath Vorkath object
	 * @return image of the current phase Vorkath is on
	 */
	private BufferedImage getIcon(Vorkath vorkath)
	{
		switch (vorkath.getCurrentPhase())
		{
			case UNKNOWN:
				return VorkathPlugin.UNKNOWN;
			case ACID:
				return VorkathPlugin.ACID;
			case FIRE_BALL:
				return VorkathPlugin.FIRE_BALL;
			case SPAWN:
				return VorkathPlugin.SPAWN;
		}
		return null;
	}

	/**
	 * @return number of attacks Vorkath has left in the current phase
	 */
	private double getAttacksLeftProgress()
	{
		if (plugin.getVorkath().getCurrentPhase() != Vorkath.Phase.FIRE_BALL)
		{
			return (double) (Vorkath.ATTACKS_PER_SWITCH - plugin.getVorkath().getAttacksLeft()) / Vorkath.ATTACKS_PER_SWITCH;
		}
		else
		{
			return (double) (Vorkath.FIRE_BALL_ATTACKS - plugin.getVorkath().getAttacksLeft()) / Vorkath.FIRE_BALL_ATTACKS;
		}
	}
}