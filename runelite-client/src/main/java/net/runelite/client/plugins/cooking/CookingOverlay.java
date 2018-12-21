/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.Duration;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.COOKING_FIRE;
import static net.runelite.api.AnimationID.COOKING_RANGE;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class CookingOverlay extends Overlay
{
	private static final int COOK_TIMEOUT = 3;
	private static final DecimalFormat FORMAT = new DecimalFormat("#.#");

	private final Client client;
	private final CookingPlugin plugin;
	private final CookingConfig config;
	private final XpTrackerService xpTrackerService;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private CookingOverlay(Client client, CookingPlugin plugin, CookingConfig config, XpTrackerService xpTrackerService)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.xpTrackerService = xpTrackerService;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		CookingSession session = plugin.getSession();
		if (session == null)
		{
			return null;
		}

		panelComponent.setPreferredSize(new Dimension(145, 0));
		panelComponent.getChildren().clear();

		if (isCooking() || Duration.between(session.getLastCookingAction(), Instant.now()).getSeconds() < COOK_TIMEOUT)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Cooking")
				.color(Color.GREEN)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("NOT cooking")
				.color(Color.RED)
				.build());
		}

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Cooked:")
			.right(session.getCookAmount() + (session.getCookAmount() >= 1 ? " (" + xpTrackerService.getActionsHr(Skill.COOKING) + "/hr)" : ""))
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Burnt:")
			.right(session.getBurnAmount() + (session.getBurnAmount() >= 1 ? " (" + FORMAT.format(session.getBurntPercentage()) + "%)" : ""))
			.build());

		return panelComponent.render(graphics);
	}

	private boolean isCooking()
	{
		switch (client.getLocalPlayer().getAnimation())
		{
			case COOKING_FIRE:
			case COOKING_RANGE:
				return true;
			default:
				return false;
		}
	}
}
