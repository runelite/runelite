/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, Ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.dagannothkings.overlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.dagannothkings.DagannothKingsConfig;
import net.runelite.client.plugins.dagannothkings.DagannothKingsPlugin;
import net.runelite.client.plugins.dagannothkings.entity.DagannothKing;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class PrayerOverlay extends Overlay
{
	private static final int TICK_PIXEL_SIZE = 60;
	private static final int BOX_WIDTH = 10;
	private static final int BOX_HEIGHT = 5;

	private final DagannothKingsPlugin plugin;
	private final DagannothKingsConfig config;
	private final Client client;

	private Set<DagannothKing> dagannothKings;

	@Inject
	public PrayerOverlay(final DagannothKingsPlugin plugin, final DagannothKingsConfig config, final Client client)
	{
		super(plugin);

		this.plugin = plugin;
		this.config = config;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(final Graphics2D graphics2D)
	{
		dagannothKings = plugin.getDagannothKings();

		if (dagannothKings.isEmpty() || (!config.showPrayerWidgetOverlay() && !config.showGuitarHeroOverlay()))
		{
			return null;
		}

		renderPrayer(graphics2D);

		return null;
	}

	private void renderPrayer(final Graphics2D graphics2D)
	{
		final Actor player = client.getLocalPlayer();

		final Map<Prayer, Integer> tickMap = new HashMap<>();

		for (final DagannothKing dagannothKing : dagannothKings)
		{
			final NPC npc = dagannothKing.getNpc();

			final int ticksUntilNextAnimation = dagannothKing.getTicksUntilNextAnimation();

			final DagannothKing.AttackStyle attackStyle = dagannothKing.getAttackStyle();

			if (npc == null || npc.isDead() || ticksUntilNextAnimation <= 0
				|| (config.ignoringNonAttacking() && dagannothKing.getInteractingActor() != player))
			{
				continue;
			}

			if (config.showPrayerWidgetOverlay())
			{
				final Rectangle rectangle = OverlayUtil.renderPrayerOverlay(graphics2D, client, attackStyle.getPrayer(), attackStyle.getColor());

				if (rectangle == null)
				{
					continue;
				}

				final String text = String.valueOf(ticksUntilNextAnimation);

				final int fontSize = 16;
				final int fontStyle = Font.BOLD;
				final Color fontColor = ticksUntilNextAnimation == 1 ? Color.WHITE : attackStyle.getColor();

				final int x = (int) (rectangle.getX() + rectangle.getWidth() / 2);
				final int y = (int) (rectangle.getY() + rectangle.getHeight() / 2);

				final Point prayerWidgetPoint = new Point(x, y);

				final Point canvasPoint = new Point(prayerWidgetPoint.getX() - 3, prayerWidgetPoint.getY() + 6);

				OverlayUtil.renderTextLocation(graphics2D, text, fontSize, fontStyle, fontColor, canvasPoint, true, 0);
			}

			if (config.showGuitarHeroOverlay())
			{
				tickMap.put(attackStyle.getPrayer(), ticksUntilNextAnimation);
			}
		}

		if (!tickMap.isEmpty())
		{
			for (final Map.Entry<Prayer, Integer> entry : tickMap.entrySet())
			{
				renderDescendingBoxes(graphics2D, entry.getKey(), entry.getValue());
			}
		}
	}

	private void renderDescendingBoxes(final Graphics2D graphics2D, final Prayer prayer, final int tick)
	{
		final Color color = tick == 1 ? Color.RED : Color.ORANGE;

		final Widget prayerWidget = null;

		if (prayerWidget == null || prayerWidget.isHidden())
		{
			return;
		}

		int baseX = (int) prayerWidget.getBounds().getX();
		baseX += prayerWidget.getBounds().getWidth() / 2;
		baseX -= BOX_WIDTH / 2;

		int baseY = (int) prayerWidget.getBounds().getY() - tick * TICK_PIXEL_SIZE - BOX_HEIGHT;
		baseY += TICK_PIXEL_SIZE - ((plugin.getLastTickTime() + 600 - System.currentTimeMillis()) / 600.0 * TICK_PIXEL_SIZE);

		final Rectangle boxRectangle = new Rectangle(BOX_WIDTH, BOX_HEIGHT);
		boxRectangle.translate(baseX, baseY);

		OverlayUtil.renderFilledPolygon(graphics2D, boxRectangle, color);
	}
}
