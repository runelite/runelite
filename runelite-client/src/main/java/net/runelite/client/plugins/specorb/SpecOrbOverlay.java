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
package net.runelite.client.plugins.specorb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.events.GameTick;
import net.runelite.client.events.VarbitChanged;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class SpecOrbOverlay extends Overlay
{
	private static final int RECHARGE_TIME_TICKS = 51;

	private static final int ORB_X_OFFSET = 60;
	private static final int ORB_Y_OFFSET = 123;
	private static final Color SPECIAL_ORB_BACKGROUND_COLOR = new Color(51, 102, 255);
	private static final Color SPECIAL_ORB_RECHARGE_COLOR = new Color(153, 204, 255, 50);

	private final Client client;
	private final SpecOrbConfig config;
	private final SpecOrbPlugin plugin;
	private int lastSpecialPercent = 0;
	private int tickCounter = 0;

	@Inject
	public SpecOrbOverlay(@Nullable Client client, SpecOrbConfig config, SpecOrbPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point point)
	{
		if (!config.enabled())
		{
			return null;
		}

		Widget xpOrb = client.getWidget(WidgetInfo.MINIMAP_XP_ORB);
		if (xpOrb == null)
		{
			return null;
		}

		graphics.setColor(SPECIAL_ORB_BACKGROUND_COLOR);

		boolean specialAttackEnabled = client.getSetting(Varbits.SPECIAL_ATTACK_ENABLED) == 1;

		// draw relative to the xp orb
		Point xpOrbPoint = xpOrb.getCanvasLocation();
		Point specOrbPoint = new Point(xpOrbPoint.getX() + ORB_X_OFFSET, xpOrbPoint.getY() + ORB_Y_OFFSET);

		double specialPercent = client.getSetting(Varbits.SPECIAL_ATTACK_PERCENT) / 1000.0;
		double specialRechargePercent = tickCounter / (double) RECHARGE_TIME_TICKS;

		OverlayUtil.drawMinimapOrb(graphics, specOrbPoint, specialPercent,
			SPECIAL_ORB_RECHARGE_COLOR, specialRechargePercent,
			plugin.getMinimapOrbBackground(), plugin.getSpecialAttackIcon(),
			(int) (specialPercent * 100), specialAttackEnabled);

		return null;
	}

	public void onVarbitChanged(VarbitChanged event)
	{
		int specialPercent = client.getSetting(Varbits.SPECIAL_ATTACK_PERCENT);
		if (lastSpecialPercent != specialPercent)
		{
			int diff = specialPercent - lastSpecialPercent;
			lastSpecialPercent = specialPercent;
			onSpecialChange(diff);
		}
	}

	private void onSpecialChange(int diff)
	{
		// If we went from 500-600 for example
		if (diff > 0)
		{
			// Reset the tick counter as we just recharged
			tickCounter = 0;
		}
	}

	public void onTick(GameTick event)
	{
		// 1000 = 100%, 500 = 50%, 0 = 0%
		int specialPercent = client.getSetting(Varbits.SPECIAL_ATTACK_PERCENT);
		// The recharge doesn't tick when at 100%
		if (specialPercent == 1000)
		{
			tickCounter = 0;
		}
		else
		{
			tickCounter++;
		}
	}
}
