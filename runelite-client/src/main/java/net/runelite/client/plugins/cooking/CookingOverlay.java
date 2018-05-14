/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
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
package net.runelite.client.plugins.cooking;

import net.runelite.api.Client;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.inject.Inject;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

import static net.runelite.api.AnimationID.COOKING_FIRE;
import static net.runelite.api.AnimationID.COOKING_RANGE;

class CookingOverlay extends Overlay
{
	private static final int[] animationIds =
			{
					COOKING_FIRE, COOKING_RANGE
			};

	private final Client client;
	private final CookingPlugin plugin;
	private final CookingConfig config;
	private final CookingSession session;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public CookingOverlay(Client client, CookingPlugin plugin, CookingConfig config, CookingSession session, XpTrackerService xpTrackerService)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.session = session;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showCookingStats())
		{
			return null;
		}

		CookingSession session = plugin.getSession();
		if (session.getLastCookingAction() == null)
		{
			if (session.getCookAmount() > 0 && config.resetStatsOnClose())
			{
				session.reset(false);
			}
			return null;
		}

		Duration cookingTimeout = Duration.ofMinutes(config.cookingResetTimeout());
		Duration cookedSince = Duration.between(session.getLastCookingAction(), Instant.now());
		if (cookedSince.compareTo(cookingTimeout) >= 0)
		{
			session.reset(!config.resetStatsOnClose());
			return null;
		}

		if (session.getStartCooking() == null)
		{
			session.setStartCooking();
		}

		panelComponent.setWidth(145);
		panelComponent.getLines().clear();
		if (IntStream.of(animationIds).anyMatch(x -> x == client.getLocalPlayer().getAnimation()) ||
				Duration.between(session.getLastCookingAction(), Instant.now()).getSeconds() < 3)
		{
			panelComponent.setTitle("Cooking");
			panelComponent.setTitleColor(Color.GREEN);
		}
		else
		{
			panelComponent.setTitle("NOT Cooking");
			panelComponent.setTitleColor(Color.RED);
		}

		panelComponent.getLines().add(new PanelComponent.Line(
				"Cooked:",
				Integer.toString(session.getCookAmount()) +
						(session.getCookAmount() > 2 ? " (" + Long.toString(session.getActionsPerHour()) + "/hr)" : ""))
		);

		panelComponent.getLines().add(new PanelComponent.Line(
				"Burnt:",
				Integer.toString(session.getBurnAmount()) + " (" + session.getBurntPercentage() + "%)")
		);

		panelComponent.getLines().add(new PanelComponent.Line(
				"Time:",
				DurationFormatUtils.formatDuration(session.getSessionTime().toMillis(), "HH:mm:ss"))

		);

		return panelComponent.render(graphics);
	}

}
