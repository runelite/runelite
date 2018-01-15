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
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class SpecOrbOverlay extends Overlay
{
	private static final int RECHARGE_TIME_TICKS = 51;

	private static final int SPEC_ORB_X_FIXED = 34;
	private static final int SPEC_ORB_Y_FIXED = 26;
	private static final int PRAYER_ORB_Y_FIXED = 73;
	private static final int RUN_ORB_X_FIXED = 12;
	private static final int RUN_ORB_Y_FIXED = 108;

	private static final int SPEC_ORB_X_RESIZABLE = 29;
	private static final int SPEC_ORB_Y_RESIZABLE = 28;
	private static final int PRAYER_ORB_Y_RESIZABLE = 71;
	private static final int RUN_ORB_X_RESIZABLE = 12;
	private static final int RUN_ORB_Y_RESIZABLE = 103;

	private static final Color SPECIAL_ORB_BACKGROUND_COLOR = new Color(51, 102, 255);
	private static final Color SPECIAL_ORB_RECHARGE_COLOR = new Color(153, 204, 255, 50);

	private final Client client;
	private final SpecOrbPlugin plugin;
	private int lastSpecialPercent = 0;
	private int tickCounter = 0;

	@Inject
	public SpecOrbOverlay(@Nullable Client client, SpecOrbPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics, java.awt.Point point)
	{
		Widget prayerOrb = client.getWidget(WidgetInfo.MINIMAP_PRAYER_ORB);
		if (prayerOrb == null)
		{
			return null;
		}

		Widget runOrb = client.getWidget(WidgetInfo.MINIMAP_RUN_ORB);
		if (runOrb == null)
		{
			return null;
		}

		if (client.isResized())
		{
			if (prayerOrb.getRelativeY() != PRAYER_ORB_Y_FIXED)
			{
				prayerOrb.setRelativeY(PRAYER_ORB_Y_FIXED);
			}

			if (runOrb.getRelativeX() != RUN_ORB_X_FIXED)
			{
				runOrb.setRelativeX(RUN_ORB_X_FIXED);
			}

			if (runOrb.getRelativeY() != RUN_ORB_Y_FIXED)
			{
				runOrb.setRelativeY(RUN_ORB_Y_FIXED);
			}
		}
		else
		{
			if (prayerOrb.getRelativeY() != PRAYER_ORB_Y_RESIZABLE)
			{
				prayerOrb.setRelativeY(PRAYER_ORB_Y_RESIZABLE);
			}

			if (runOrb.getRelativeX() != RUN_ORB_X_RESIZABLE)
			{
				runOrb.setRelativeX(RUN_ORB_X_RESIZABLE);
			}

			if (runOrb.getRelativeY() != RUN_ORB_Y_RESIZABLE)
			{
				runOrb.setRelativeY(RUN_ORB_Y_RESIZABLE);
			}
		}

		graphics.setColor(SPECIAL_ORB_BACKGROUND_COLOR);

		boolean specialAttackEnabled = client.getSetting(Varbits.SPECIAL_ATTACK_ENABLED) == 1;

		// draw relative to run orb
		Point runOrbPoint = runOrb.getCanvasLocation();
		Point specOrbPoint = new Point(runOrbPoint.getX() + (client.isResized() ? SPEC_ORB_X_RESIZABLE : SPEC_ORB_X_FIXED),
				runOrbPoint.getY() + (client.isResized() ? SPEC_ORB_Y_RESIZABLE : SPEC_ORB_Y_FIXED));

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
