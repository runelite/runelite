/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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

package net.runelite.client.plugins.gauntletextended.overlay;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedConfig;
import net.runelite.client.plugins.gauntletextended.GauntletExtendedPlugin;
import net.runelite.client.plugins.gauntletextended.entity.Hunllef;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;

import static net.runelite.client.plugins.gauntletextended.GauntletExtendedConfig.PrayerHighlightMode;

@Singleton
public class OverlayPrayerWidget extends Overlay
{
	private final Client client;
	private final GauntletExtendedPlugin plugin;
	private final GauntletExtendedConfig config;

	@Inject
	OverlayPrayerWidget(final Client client, final GauntletExtendedPlugin plugin, final GauntletExtendedConfig config)
	{
		super(plugin);

		this.client = client;
		this.plugin = plugin;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		determineLayer();
	}

	@Override
	public Dimension render(final Graphics2D graphics2D)
	{
		final PrayerHighlightMode prayerHighlightMode = config.prayerOverlay();

		if (prayerHighlightMode == PrayerHighlightMode.NONE || prayerHighlightMode == PrayerHighlightMode.BOX)
		{
			return null;
		}

		final Hunllef hunllef = plugin.getHunllef();

		if (hunllef == null)
		{
			return null;
		}

		final NPC npc = hunllef.getNpc();

		if (npc == null || npc.isDead())
		{
			return null;
		}

		// Overlay outline on the prayer widget

		final Hunllef.AttackPhase phase = hunllef.getAttackPhase();

		final Prayer prayer = phase.getPrayer();

		final Color phaseColor = phase.getColor();

		final Rectangle rectangle = OverlayUtil.renderPrayerOverlay(graphics2D, client, prayer, phaseColor);

		if (rectangle == null)
		{
			return null;
		}

		// Overlay tick count on the prayer widget

		final int ticksUntilAttack = hunllef.getTicksUntilNextAttack();

		final String text = String.valueOf(ticksUntilAttack);

		final int fontSize = 16;
		final int fontStyle = Font.BOLD;
		final Color fontColor = ticksUntilAttack == 1 ? Color.WHITE : phaseColor;

		final int x = (int) (rectangle.getX() + rectangle.getWidth() / 2);
		final int y = (int) (rectangle.getY() + rectangle.getHeight() / 2);

		final Point point = new Point(x, y);

		final Point canvasPoint = new Point(point.getX() - 3, point.getY() + 6);

		OverlayUtil.renderTextLocation(graphics2D, text, fontSize, fontStyle, fontColor, canvasPoint, true, 0);

		return null;
	}

	public void determineLayer()
	{
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}
}
