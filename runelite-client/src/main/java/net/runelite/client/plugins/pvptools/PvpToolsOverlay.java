/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.pvptools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class PvpToolsOverlay extends Overlay
{
	private PvpToolsPlugin pvpToolsPlugin;
	private PvpToolsConfig pvpToolsConfig;
	private Client client;

	@Inject
	private PvpToolsOverlay(PvpToolsConfig pvpToolsConfig, PvpToolsPlugin pvpToolsPlugin, Client client)
	{
		this.pvpToolsPlugin = pvpToolsPlugin;
		this.pvpToolsConfig = pvpToolsConfig;
		this.client = client;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (pvpToolsConfig.fallInHelper())
		{
			if (pvpToolsPlugin.fallinHelperEnabled)
			{
				graphics.setFont(FontManager.getRunescapeFont().deriveFont(28));
				OverlayUtil.renderTextLocation(graphics, new Point(200, 80), "FALL IN HELPER ENABLED", Color.YELLOW);
			}
		}
		return null;
	}

	private void renderPoly(Graphics2D graphics, Color color, Polygon polygon)
	{
		if (polygon != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(polygon);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
			graphics.fill(polygon);
		}
	}
}
