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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.util.ColorUtil;

public class TitheFarmPlantOverlay extends Overlay
{
	private final Client client;
	private final TitheFarmPlugin plugin;
	private final TitheFarmPluginConfig config;
	private final Map<TitheFarmPlantState, Color> borders = new HashMap<>();
	private final Map<TitheFarmPlantState, Color> fills = new HashMap<>();

	@Inject
	TitheFarmPlantOverlay(Client client, TitheFarmPlugin plugin, TitheFarmPluginConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
	}

	/**
	 * Updates the timer colors.
	 */
	public void updateConfig()
	{
		borders.clear();
		fills.clear();

		final Color colorUnwateredBorder = config.getColorUnwatered();
		final Color colorUnwatered = ColorUtil.colorWithAlpha(colorUnwateredBorder, (int) (colorUnwateredBorder.getAlpha() / 2.5));
		borders.put(TitheFarmPlantState.UNWATERED, colorUnwateredBorder);
		fills.put(TitheFarmPlantState.UNWATERED, colorUnwatered);

		final Color colorWateredBorder = config.getColorWatered();
		final Color colorWatered = ColorUtil.colorWithAlpha(colorWateredBorder, (int) (colorWateredBorder.getAlpha() / 2.5));
		borders.put(TitheFarmPlantState.WATERED, colorWateredBorder);
		fills.put(TitheFarmPlantState.WATERED, colorWatered);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (TitheFarmPlant plant : plugin.getPlants())
		{
			if (plant.getState() == TitheFarmPlantState.DEAD || plant.getState() == TitheFarmPlantState.GROWN)
			{
				continue;
			}

			final LocalPoint localLocation = LocalPoint.fromWorld(client, plant.getWorldLocation());

			if (localLocation == null)
			{
				continue;
			}

			final Point canvasLocation = Perspective.localToCanvas(client, localLocation, client.getPlane());

			if (canvasLocation != null)
			{
				final ProgressPieComponent progressPieComponent = new ProgressPieComponent();
				progressPieComponent.setPosition(canvasLocation);
				progressPieComponent.setProgress(1 - plant.getPlantTimeRelative());
				progressPieComponent.setBorderColor(borders.get(plant.getState()));
				progressPieComponent.setFill(fills.get(plant.getState()));
				progressPieComponent.render(graphics);
			}
		}

		return null;
	}
}
