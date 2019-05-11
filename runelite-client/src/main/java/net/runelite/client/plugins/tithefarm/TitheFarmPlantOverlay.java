/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package net.runelite.client.plugins.tithefarm;

<<<<<<< HEAD
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
=======
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
>>>>>>> upstream/master
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
<<<<<<< HEAD

public class TitheFarmPlantOverlay extends Overlay
{
	private static final int TIMER_SIZE = 25;
	private static final int TIMER_BORDER_WIDTH = 1;

	private final Client client;
	private final TitheFarmPlugin plugin;
	private final TitheFarmPluginConfig config;
=======
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

public class TitheFarmPlantOverlay extends Overlay
{
	private final Client client;
	private final TitheFarmPlugin plugin;
	private final TitheFarmPluginConfig config;
	private final Map<TitheFarmPlantState, Color> borders = new HashMap<>();
	private final Map<TitheFarmPlantState, Color> fills = new HashMap<>();
>>>>>>> upstream/master

	@Inject
	TitheFarmPlantOverlay(Client client, TitheFarmPlugin plugin, TitheFarmPluginConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
	}

<<<<<<< HEAD
	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget viewport = client.getViewportWidget();
		for (TitheFarmPlant plant : plugin.getPlants())
		{
			LocalPoint localLocation = LocalPoint.fromWorld(client, plant.getWorldLocation());
=======
	/**
	 * Updates the timer colors.
	 */
	public void updateConfig()
	{
		borders.clear();
		fills.clear();

		final Color colorUnwateredBorder = config.getColorUnwatered();
		final Color colorUnwatered = new Color(colorUnwateredBorder.getRed(), colorUnwateredBorder.getGreen(), colorUnwateredBorder.getBlue(), 100);
		borders.put(TitheFarmPlantState.UNWATERED, colorUnwateredBorder);
		fills.put(TitheFarmPlantState.UNWATERED, colorUnwatered);

		final Color colorWateredBorder = config.getColorWatered();
		final Color colorWatered = new Color(colorWateredBorder.getRed(), colorWateredBorder.getGreen(), colorWateredBorder.getBlue(), 100);
		borders.put(TitheFarmPlantState.WATERED, colorWateredBorder);
		fills.put(TitheFarmPlantState.WATERED, colorWatered);

		final Color colorGrownBorder = config.getColorGrown();
		final Color colorGrown = new Color(colorGrownBorder.getRed(), colorGrownBorder.getGreen(), colorGrownBorder.getBlue(), 100);
		borders.put(TitheFarmPlantState.GROWN, colorGrownBorder);
		fills.put(TitheFarmPlantState.GROWN, colorGrown);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget viewport = client.getViewportWidget();

		for (TitheFarmPlant plant : plugin.getPlants())
		{
			if (plant.getState() == TitheFarmPlantState.DEAD)
			{
				continue;
			}

			final LocalPoint localLocation = LocalPoint.fromWorld(client, plant.getWorldLocation());

>>>>>>> upstream/master
			if (localLocation == null)
			{
				continue;
			}
<<<<<<< HEAD
			net.runelite.api.Point canvasLocation = Perspective.worldToCanvas(client, localLocation.getX(), localLocation.getY(), client.getPlane());
			if (viewport != null && canvasLocation != null)
			{
				switch (plant.getState())
				{
					case UNWATERED:
						drawTimerOnPlant(graphics, plant, canvasLocation, config.getColorUnwatered());
						break;
					case WATERED:
						drawTimerOnPlant(graphics, plant, canvasLocation, config.getColorWatered());
						break;
					case GROWN:
						drawTimerOnPlant(graphics, plant, canvasLocation, config.getColorGrown());
						break;
				}
=======

			final Point canvasLocation = Perspective.localToCanvas(client, localLocation, client.getPlane());

			if (viewport != null && canvasLocation != null)
			{
				final ProgressPieComponent progressPieComponent = new ProgressPieComponent();
				progressPieComponent.setPosition(canvasLocation);
				progressPieComponent.setProgress(1 - plant.getPlantTimeRelative());
				progressPieComponent.setBorderColor(borders.get(plant.getState()));
				progressPieComponent.setFill(fills.get(plant.getState()));
				progressPieComponent.render(graphics);
>>>>>>> upstream/master
			}
		}

		return null;
	}
<<<<<<< HEAD

	private void drawTimerOnPlant(Graphics2D graphics, TitheFarmPlant plant, net.runelite.api.Point loc, Color color)
	{
		//Construct the arc
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setAngleStart(90);
		double timeLeft = 1 - plant.getPlantTimeRelative();
		arc.setAngleExtent(timeLeft * 360);
		arc.setFrame(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);

		//Draw the inside of the arc
		graphics.setColor(color);
		graphics.fill(arc);

		//Draw the outlines of the arc
		graphics.setStroke(new BasicStroke(TIMER_BORDER_WIDTH));
		graphics.drawOval(loc.getX() - TIMER_SIZE / 2, loc.getY() - TIMER_SIZE / 2, TIMER_SIZE, TIMER_SIZE);
	}
=======
>>>>>>> upstream/master
}
