/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.regenmeter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.annotations.Component;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class RegenMeterOverlay extends Overlay
{
	private static final Color HITPOINTS_COLOR = brighter(0x9B0703);
	private static final Color SPECIAL_COLOR = brighter(0x1E95B0);
	private static final int DIAMETER = 26;
	private static final int OFFSET = 27;
	private static final int STROKE = 2;

	private final Client client;
	private final RegenMeterPlugin plugin;
	private final RegenMeterConfig config;

	private static Color brighter(int color)
	{
		float[] hsv = new float[3];
		Color.RGBtoHSB(color >>> 16, (color >> 8) & 0xFF, color & 0xFF, hsv);
		return Color.getHSBColor(hsv[0], 1.f, 1.f);
	}

	@Inject
	public RegenMeterOverlay(Client client, RegenMeterPlugin plugin, RegenMeterConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPreferUiPixelGrid(true);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		if (config.showHitpoints())
		{
			renderRegen(g, InterfaceID.Orbs.ORB_HEALTH, InterfaceID.OrbsNomap.ORB_HEALTH, plugin.getHitpointsPercentage(), HITPOINTS_COLOR);
		}

		if (config.showSpecial())
		{
			renderRegen(g, InterfaceID.Orbs.ORB_SPECENERGY, InterfaceID.OrbsNomap.ORB_SPECENERGY, plugin.getSpecialPercentage(), SPECIAL_COLOR);
		}

		return null;
	}

	private void renderRegen(Graphics2D g, @Component int componentId, @Component int noOrbComponentId, double percent, Color color)
	{
		Widget widget = client.getWidget(componentId);
		if (widget == null || widget.isHidden())
		{
			widget = client.getWidget(noOrbComponentId);
		}
		if (widget == null || widget.isHidden())
		{
			return;
		}
		Rectangle bounds = widget.getBounds();
		final int x = bounds.x + OFFSET;
		final int y = bounds.y + (bounds.height / 2 - DIAMETER / 2);

		g.setColor(color);
		OverlayUtil.drawPixelArc(g, x, y, DIAMETER, STROKE, 90, -360.0 * percent);
	}
}
