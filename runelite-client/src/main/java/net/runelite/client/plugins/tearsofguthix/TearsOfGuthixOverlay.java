/*
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package net.runelite.client.plugins.tearsofguthix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Point;
import net.runelite.api.gameval.ObjectID;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.util.ColorUtil;

class TearsOfGuthixOverlay extends Overlay
{
	private static final Duration MAX_TIME = Duration.ofSeconds(9);
	private final TearsOfGuthixConfig config;
	private final TearsOfGuthixPlugin plugin;

	@Inject
	private TearsOfGuthixOverlay(TearsOfGuthixConfig config, TearsOfGuthixPlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getStreams().isEmpty())
		{
			return null;
		}

		Color blueTearsFill = config.getBlueTearsColor();
		Color greenTearsFill = config.getGreenTearsColor();
		Color blueTearsBorder = ColorUtil.colorWithAlpha(blueTearsFill, 255);
		Color greenTearsBorder = ColorUtil.colorWithAlpha(greenTearsFill, 255);

		plugin.getStreams().forEach((object, timer) ->
		{
			if ((object.getId() == ObjectID.TOG_WEEPING_WALL_BAD_R || object.getId() == ObjectID.TOG_WEEPING_WALL_BAD_L)
				&& !config.showGreenTearsTimer())
			{
				return;
			}

			final Point position = object.getCanvasLocation(100);

			if (position == null)
			{
				return;
			}

			final ProgressPieComponent progressPie = new ProgressPieComponent();
			progressPie.setDiameter(15);

			if (object.getId() == ObjectID.TOG_WEEPING_WALL_GOOD_R ||
				object.getId() == ObjectID.TOG_WEEPING_WALL_GOOD_L)
			{
				progressPie.setFill(blueTearsFill);
				progressPie.setBorderColor(blueTearsBorder);
			}
			else if (object.getId() == ObjectID.TOG_WEEPING_WALL_BAD_R ||
				object.getId() == ObjectID.TOG_WEEPING_WALL_BAD_L)
			{
				progressPie.setFill(greenTearsFill);
				progressPie.setBorderColor(greenTearsBorder);
			}

			progressPie.setPosition(position);

			final Duration duration = Duration.between(timer, Instant.now());
			progressPie.setProgress(1 - (duration.compareTo(MAX_TIME) < 0
				? (double) duration.toMillis() / MAX_TIME.toMillis()
				: 1));

			progressPie.render(graphics);
		});

		return null;
	}
}