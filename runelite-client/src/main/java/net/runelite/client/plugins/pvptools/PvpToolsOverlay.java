/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.pvptools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class PvpToolsOverlay extends Overlay
{
	private final PvpToolsPlugin pvpToolsPlugin;

	@Inject
	private PvpToolsOverlay(final PvpToolsPlugin pvpToolsPlugin)
	{
		this.pvpToolsPlugin = pvpToolsPlugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (pvpToolsPlugin.isFallInHelper() && pvpToolsPlugin.fallinHelperEnabled)
		{
			graphics.setFont(FontManager.getRunescapeFont().deriveFont(28));
			OverlayUtil.renderTextLocation(graphics, new Point(200, 80), "FALL IN HELPER ENABLED", Color.YELLOW);
		}
		return null;
	}
}
