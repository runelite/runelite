/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.theatreofblood.overlays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.plugins.theatreofblood.TheatreOfBloodConfig;
import net.runelite.client.plugins.theatreofblood.TheatreOfBloodPlugin;
import net.runelite.client.plugins.theatreofblood.data.Attempt;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class AttemptOverlay extends Overlay
{
	private final TheatreOfBloodPlugin plugin;
	private final TheatreOfBloodConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	private String attempt = "";

	@Inject
	AttemptOverlay(TheatreOfBloodPlugin plugin, TheatreOfBloodConfig config)
	{
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.LOW);
		this.plugin = plugin;
		this.config = config;
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showCurrentRaidOverlay() || plugin.getState() < 1)
		{
			return null;
		}

		if (!attempt.equals(plugin.getCurrent().toString()))
		{
			Attempt a = plugin.getCurrent();
			attempt = a.toString();
			reset();

			graphics.setColor(Color.WHITE);

			LayoutableRenderableEntity title = TitleComponent.builder().text("Current Raid").build();
			LayoutableRenderableEntity dealt = LineComponent.builder().left("Dmg Dealt").right(String.valueOf((int) Math.round(a.getDamageDealt()))).build();
			LayoutableRenderableEntity taken = LineComponent.builder().left("Dmg Taken").right(String.valueOf(a.getDamageTaken())).build();
			LayoutableRenderableEntity deaths = LineComponent.builder().left("Deaths").right(String.valueOf(a.getDeathCount())).build();
			add(title);
			add(dealt);
			add(taken);
			add(deaths);
		}

		return panelComponent.render(graphics);
	}

	private void add(LayoutableRenderableEntity a)
	{
		panelComponent.getChildren().add(a);
	}

	public void reset()
	{
		panelComponent.getChildren().clear();
	}
}
