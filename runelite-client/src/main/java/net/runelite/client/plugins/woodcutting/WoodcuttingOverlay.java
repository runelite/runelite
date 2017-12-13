/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.woodcutting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.*;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

class WoodcuttingOverlay extends Overlay
{
	private static final int[] animationIds =
	{
		WOODCUTTING_BRONZE, WOODCUTTING_IRON, WOODCUTTING_STEEL, WOODCUTTING_BLACK,
		WOODCUTTING_MITHRIL, WOODCUTTING_ADAMANT, WOODCUTTING_RUNE, WOODCUTTING_DRAGON,
		WOODCUTTING_INFERNAL
	};

	private final Client client;
	private final WoodcuttingPlugin plugin;
	private final WoodcuttingConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public WoodcuttingOverlay(@Nullable Client client, WoodcuttingPlugin plugin, WoodcuttingConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (!config.enabled())
		{
			return null;
		}

		WoodcuttingSession session = plugin.getSession();

		if (session.getLastLogCut() == null)
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastLogCut(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		panelComponent.getLines().clear();

		if (IntStream.of(animationIds).anyMatch(x -> x == client.getLocalPlayer().getAnimation()))
		{
			panelComponent.setTitle("You are woodcutting");
			panelComponent.setTitleColor(Color.GREEN);
		}
		else
		{
			panelComponent.setTitle("You are NOT woodcutting");
			panelComponent.setTitleColor(Color.RED);
		}

		panelComponent.getLines().add(new PanelComponent.Line(
			"Logs cut:",
			Integer.toString(session.getTotalCut())
		));


		panelComponent.getLines().add(new PanelComponent.Line(
			"Logs/hr:",
			session.getRecentCut() > 2
				? Integer.toString(session.getPerHour())
				: ""
		));

		return panelComponent.render(graphics, parent);
	}
}
