/*
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://openosrs.com
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
package net.runelite.client.plugins.barbarianassault;

import com.google.common.collect.ImmutableMap;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.util.Map;

@Singleton
class AboveSceneOverlay extends Overlay
{
	private static final int HEALTH_BAR_HEIGHT = 20;
	private static final int HEALTH_BAR_WIDTH = 115;
	private static final int CENTER_OFFSET = Perspective.LOCAL_HALF_TILE_SIZE / 8;
	private static final int EGG_DIAMETER = Perspective.LOCAL_HALF_TILE_SIZE / 4;
	private static final Color HEALTH_BAR_COLOR = new Color(225, 35, 0, 125);
	private static final ImmutableMap<WidgetInfo, Point> TEAMMATES = ImmutableMap.of(
			WidgetInfo.BA_HEAL_TEAMMATE1, new Point(28, 2),
			WidgetInfo.BA_HEAL_TEAMMATE2, new Point(26, 2),
			WidgetInfo.BA_HEAL_TEAMMATE3, new Point(26, 2),
			WidgetInfo.BA_HEAL_TEAMMATE4, new Point(25, 2));

	private final Client client;
	private final BarbarianAssaultPlugin game;


	@Inject
	private AboveSceneOverlay(final Client client, final BarbarianAssaultPlugin game)
	{
		super(game);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.game = game;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!game.isInGame() || game.getRole() == null || game.isUsingGloryHorn())
		{
			return null;
		}

		switch (game.getRole())
		{

			case HEALER:
				if (game.isShowTeammateHealthbars())
				{
					renderHealthBars(graphics);
				}
				if (game.isHealerCodes())
				{
					renderHealerCodes(graphics);
				}
				break;


			case COLLECTOR:
				if (game.isHighlightCollectorEggs())
				{
					renderEggs(graphics);
				}
				break;
		}
		return null;
	}

	//TODO add poison color change or low health color change
	private void renderHealthBars(Graphics2D graphics)
	{
		for (Map.Entry<WidgetInfo, Point> teammate : TEAMMATES.entrySet())
		{
			Widget widget = client.getWidget(teammate.getKey());
			if (widget == null)
			{
				continue;
			}

			// This will give us two elements, the first will be current health, and the second will be max health
			String[] teammateHealth = widget.getText().split(" / ");

			graphics.setColor(HEALTH_BAR_COLOR);
			graphics.fillRect((widget.getCanvasLocation().getX() - teammate.getValue().getX()),
					(widget.getCanvasLocation().getY() - teammate.getValue().getY()),
					getBarWidth(Integer.parseInt(teammateHealth[1]), Integer.parseInt(teammateHealth[0])),
					HEALTH_BAR_HEIGHT);
		}
	}

	private int getBarWidth(int base, int current)
	{
		final double ratio = (double) current / base;

		if (ratio >= 1)
		{
			return HEALTH_BAR_WIDTH;
		}

		return (int) Math.round(ratio * HEALTH_BAR_WIDTH);
	}

	private void renderHealerCodes(Graphics2D graphics)
	{
		for (Healer healer : game.getHealers().values())
		{
			Color color = Color.GREEN;
			int timeLeft = 0;

			if (game.getWave() != null)
			{
				timeLeft = healer.getLastFoodTime() - (int) game.getWave().getWaveTimer().getElapsedTime();
			}

			timeLeft = timeLeft < 1 ? 0 : timeLeft;

			if (timeLeft > 0)
			{
				color = Color.RED;
			}

			String text = String.format("%d  %d", healer.getFoodRemaining(), timeLeft);

			OverlayUtil.renderActorOverlay(graphics, healer.getNpc(), text, color);
		}
	}

	private void renderEggs(Graphics2D graphics)
	{
		final Color color = graphics.getColor();
		final Stroke originalStroke = graphics.getStroke();
		String listen = game.getLastListenText();
		if (listen != null && !listen.equals("- - -"))
		{
			graphics.setStroke(new BasicStroke(2));
			//TODO Render quantity text as well
			//TODO add config options for overlay colors
			switch (listen)
			{
				case "Red eggs":
					graphics.setColor(new Color(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue(), 150));
					game.getRedEggs().forEach((point, quantity) -> drawCircle(graphics, LocalPoint.fromWorld(client, point)));
					break;
				case "Green eggs":
					graphics.setColor(new Color(Color.GREEN.getRed(), Color.GREEN.getGreen(), Color.GREEN.getBlue(), 150));
					game.getGreenEggs().forEach((point, quantity) -> drawCircle(graphics, LocalPoint.fromWorld(client, point)));
					break;
				case "Blue eggs":
					graphics.setColor(new Color(Color.BLUE.getRed(), Color.BLUE.getGreen(), Color.BLUE.getBlue(), 150));
					game.getBlueEggs().forEach((point, quantity) -> drawCircle(graphics, LocalPoint.fromWorld(client, point)));
					break;
			}
		}
		graphics.setColor(new Color(Color.YELLOW.getRed(), Color.YELLOW.getGreen(), Color.YELLOW.getBlue(), 150));
		game.getYellowEggs().forEach((point, quantity) -> drawCircle(graphics, LocalPoint.fromWorld(client, point)));
		graphics.setColor(color);
		graphics.setStroke(originalStroke);
	}

	private void drawCircle(Graphics2D graphics, LocalPoint point)
	{
		if (point == null)
		{
			return;
		}

		Point canvasPoint = Perspective.localToCanvas(client, point, 0);
		if (canvasPoint == null)
		{
			return;
		}

		//TODO rendering a model would be better / more accurate
		graphics.fillOval(canvasPoint.getX() - CENTER_OFFSET, canvasPoint.getY() - CENTER_OFFSET, EGG_DIAMETER, EGG_DIAMETER);
	}
}