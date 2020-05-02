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
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

class TearsOfGuthixOverlay extends Overlay
{
	private static final Color CYAN_ALPHA = new Color(Color.CYAN.getRed(), Color.CYAN.getGreen(), Color.CYAN.getBlue(), 100);
	private static final Duration MAX_TIME = Duration.ofSeconds(9);
	private static final WorldPoint JUNA_LOCATION = new WorldPoint(3252, 9517, 2);
	private static final int MAX_ICON_DISTANCE = 15;
	private final TearsOfGuthixPlugin plugin;
	private final TearsOfGuthixConfig config;
	private final SkillIconManager skillIconManager;
	private final Client client;

	@Inject
	private TearsOfGuthixOverlay(TearsOfGuthixPlugin plugin, TearsOfGuthixConfig config, SkillIconManager skillIconManager, Client client)
	{
		this.plugin = plugin;
		this.config = config;
		this.skillIconManager = skillIconManager;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		plugin.getStreams().forEach((object, timer) ->
		{
			if (object.getWorldLocation().distanceTo(client.getLocalPlayer().getWorldLocation()) >= MAX_ICON_DISTANCE)
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
			progressPie.setFill(CYAN_ALPHA);
			progressPie.setBorderColor(Color.CYAN);
			progressPie.setPosition(position);

			final Duration duration = Duration.between(timer, Instant.now());
			progressPie.setProgress(1 - (duration.compareTo(MAX_TIME) < 0
				? (double) duration.toMillis() / MAX_TIME.toMillis()
				: 1));

			progressPie.render(graphics);
		});

		drawSkillOverlay(graphics);

		return null;
	}

	// Draws the skill which will receive experience from TOG on Juna
	private void drawSkillOverlay(final Graphics2D graphics)
	{
		if (!config.displaySkillIcon() || client.getLocalPlayer().getWorldLocation().distanceTo(JUNA_LOCATION) >= MAX_ICON_DISTANCE)
		{
			return;
		}

		final BufferedImage icon = skillIconManager.getSkillImage(plugin.getTearsOfGuthixSkill());
		OverlayUtil.renderImageLocation(client, graphics, LocalPoint.fromWorld(client, JUNA_LOCATION), icon, 40);
	}
}