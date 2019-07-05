/*
 * Copyright (c) 2018, Ethan <https://github.com/shmeeps>
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
package net.runelite.client.plugins.prayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;
import org.apache.commons.lang3.StringUtils;

@Singleton
class PrayerDoseOverlay extends Overlay
{
	private static final float PULSE_TIME = 2f * Constants.GAME_TICK_LENGTH;

	private static final Color START_COLOR = new Color(0, 255, 255);
	private static final Color END_COLOR = new Color(0, 92, 92);

	private final Client client;
	private final PrayerPlugin plugin;
	private final TooltipManager tooltipManager;
	private Instant startOfLastTick = Instant.now();
	private boolean trackTick = true;

	@Setter(AccessLevel.PACKAGE)
	private int prayerBonus;
	@Setter(AccessLevel.PACKAGE)
	private boolean hasPrayerRestore;
	@Setter(AccessLevel.PACKAGE)
	private int bonusPrayer;
	@Setter(AccessLevel.PACKAGE)
	private boolean hasHolyWrench;

	@Inject
	private PrayerDoseOverlay(final Client client, final TooltipManager tooltipManager, final PrayerPlugin plugin)
	{
		this.client = client;
		this.tooltipManager = tooltipManager;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	void onTick()
	{
		// Only track the time on every other tick
		if (trackTick)
		{
			startOfLastTick = Instant.now(); //Reset the tick timer
			trackTick = false;
		}
		else
		{
			trackTick = true;
		}
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget xpOrb = client.getWidget(WidgetInfo.MINIMAP_QUICK_PRAYER_ORB);
		if (xpOrb == null || xpOrb.isHidden())
		{
			return null;
		}

		final Rectangle bounds = xpOrb.getBounds();
		if (bounds.getX() <= 0)
		{
			return null;
		}

		final Point mousePosition = client.getMouseCanvasPosition();

		if (plugin.isShowPrayerStatistics() && bounds.contains(mousePosition.getX(), mousePosition.getY()))
		{
			final String tooltip = "Time Remaining: " + getEstimatedTimeRemaining() +
				"</br>" +
				"Prayer Bonus: " + prayerBonus;

			tooltipManager.add(new Tooltip(tooltip));
		}

		if (!plugin.isShowPrayerDoseIndicator() || !hasPrayerRestore)
		{
			return null;
		}

		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
		final int maxPrayer = client.getRealSkillLevel(Skill.PRAYER);

		final int prayerPointsMissing = maxPrayer - currentPrayer;
		if (prayerPointsMissing <= 0)
		{
			return null;
		}

		final double dosePercentage = hasHolyWrench ? .27 : .25;
		final int basePointsRestored = (int) Math.floor(maxPrayer * dosePercentage);

		final int pointsRestored = basePointsRestored + 7 + bonusPrayer;

		if (prayerPointsMissing < pointsRestored)
		{
			return null;
		}

		// Purposefully using height twice here as the bounds of the prayer orb includes the number sticking out the side
		final int orbInnerSize = (int) bounds.getHeight();

		final int orbInnerX = (int) (bounds.getX() + 24); // x pos of the inside of the prayer orb
		final int orbInnerY = (int) (bounds.getY() - 1); // y pos of the inside of the prayer orb

		final long timeSinceLastTick = Duration.between(startOfLastTick, Instant.now()).toMillis();

		final float tickProgress = Math.min(timeSinceLastTick / PULSE_TIME, 1); // Cap between 0 and 1
		final double t = tickProgress * Math.PI; // Convert to 0 - pi

		graphics.setColor(ColorUtil.colorLerp(START_COLOR, END_COLOR, Math.sin(t)));
		graphics.setStroke(new BasicStroke(2));
		graphics.drawOval(orbInnerX, orbInnerY, orbInnerSize, orbInnerSize);

		return new Dimension((int) bounds.getWidth(), (int) bounds.getHeight());
	}

	private double getPrayerDrainRate(Client client)
	{
		double drainRate = 0.0;

		for (Prayer prayer : Prayer.values())
		{
			if (client.isPrayerActive(prayer))
			{
				drainRate += prayer.getDrainRate();
			}
		}

		return drainRate;
	}

	private String getEstimatedTimeRemaining()
	{
		// Base data
		final double drainRate = getPrayerDrainRate(client);

		if (drainRate == 0)
		{
			return "N/A";
		}

		final int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);

		// Calculate how many seconds each prayer points last so the prayer bonus can be applied
		final double secondsPerPoint = (60.0 / drainRate) * (1.0 + (prayerBonus / 30.0));

		// Calculate the number of seconds left
		final double secondsLeft = (currentPrayer * secondsPerPoint);
		final int minutes = (int) Math.floor(secondsLeft / 60.0);
		final int seconds = (int) Math.floor(secondsLeft - (minutes * 60.0));

		// Return the text
		return minutes + ":" + StringUtils.leftPad(Integer.toString(seconds), 2, "0");
	}
}
