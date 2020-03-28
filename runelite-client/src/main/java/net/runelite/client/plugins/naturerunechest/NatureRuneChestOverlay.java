/*
 * Copyright (c) 2020, Travis Earley <travis.earley96@gmail.com>
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
package net.runelite.client.plugins.naturerunechest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

class NatureRuneChestOverlay extends Overlay
{
	private static final Duration DOWN_TIME = Duration.ofSeconds(8);
	private final Client client;
	private final NatureRuneChestPlugin plugin;
	private final NatureRuneChestConfig config;
	private Color colorFull, colorFullBorder;
	private Color colorEmpty, colorEmptyBorder;

	@Inject
	private NatureRuneChestOverlay(NatureRuneChestPlugin plugin, Client client, NatureRuneChestConfig config)
	{
		this.plugin = plugin;
		this.client = client;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	public void updateConfig()
	{
		colorEmptyBorder = config.getEmptyChestColor();
		colorEmpty = new Color(colorEmptyBorder.getRed(), colorEmptyBorder.getGreen(), colorEmptyBorder.getBlue(), 100);
		colorFullBorder = config.getFullChestColor();
		colorFull = new Color(colorFullBorder.getRed(), colorFullBorder.getGreen(), colorFullBorder.getBlue(), 100);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getChest() == null)
		{
			return null;
		}

		final LocalPoint localLoc = LocalPoint.fromWorld(client, plugin.getChest().getWorldLocation());
		if (localLoc == null)
		{
			return null;
		}
		net.runelite.api.Point loc = Perspective.localToCanvas(client, localLoc, client.getPlane());
		if (loc == null)
		{
			return null;
		}
		final ProgressPieComponent progressPie = new ProgressPieComponent();
		int empty = plugin.getState();

		updateConfig();

		if (empty == 2)
		{
			progressPie.setDiameter(60);
			progressPie.setFill(colorEmpty);
			progressPie.setBorderColor(colorEmptyBorder);
			progressPie.setPosition(loc);

			final Duration duration = Duration.between(plugin.getStart(), Instant.now());
			progressPie.setProgress(1 - (duration.compareTo(DOWN_TIME) < 0
					? (double) duration.toMillis() / DOWN_TIME.toMillis()
					: 1));

			progressPie.render(graphics);
		}

		if (empty == 1)
		{
			progressPie.setDiameter(0);

			progressPie.render(graphics);
		}

		if (empty == 0)
		{
			progressPie.setDiameter(60);
			progressPie.setFill(colorFull);
			progressPie.setBorderColor(colorFullBorder);
			progressPie.setPosition(loc);
			progressPie.setProgress(100);

			progressPie.render(graphics);
		}

		return null;
	}
}