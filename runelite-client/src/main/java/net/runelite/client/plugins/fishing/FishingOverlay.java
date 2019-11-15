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
package net.runelite.client.plugins.fishing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
class FishingOverlay extends Overlay
{
	private static final String FISHING_SPOT = "Fishing spot";
	static final String FISHING_RESET = "Reset";

	private final Client client;
	private final FishingPlugin plugin;
	private final XpTrackerService xpTrackerService;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public FishingOverlay(final Client client, final FishingPlugin plugin, final XpTrackerService xpTrackerService)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.xpTrackerService = xpTrackerService;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Fishing overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, FISHING_RESET, "Fishing overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isShowFishingStats() || plugin.getSession().getLastFishCaught() == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		if (client.getLocalPlayer().getInteracting() != null
			&& client.getLocalPlayer().getInteracting().getName().contains(FISHING_SPOT)
			&& client.getLocalPlayer().getInteracting().getSpotAnimation() != GraphicID.FLYING_FISH)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Fishing")
				.color(Color.GREEN)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("NOT fishing")
				.color(Color.RED)
				.build());
		}

		int actions = xpTrackerService.getActions(Skill.FISHING);
		if (actions > 0)
		{
			TableComponent tableComponent = new TableComponent();
			tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

			tableComponent.addRow("Caught fish:", Integer.toString(actions));

			if (actions > 2)
			{
				tableComponent.addRow("Fish/hr:", Integer.toString(xpTrackerService.getActionsHr(Skill.FISHING)));
			}

			panelComponent.getChildren().add(tableComponent);
		}

		return panelComponent.render(graphics);
	}
}
