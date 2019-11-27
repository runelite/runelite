/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
 * Copyright (c) 2019, ermalsh <github.com/ermalsh>
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
package net.runelite.client.plugins.thieving;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import javax.inject.Inject;
import javax.inject.Singleton;
import static net.runelite.api.AnimationID.BLOCK_UNARMED;
import static net.runelite.api.AnimationID.PICKPOCKET_SUCCESS;
import static net.runelite.api.AnimationID.THIEVING_STALL;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
public class ThievingOverlay extends Overlay
{
	private static final DecimalFormat FORMAT = new DecimalFormat("#.#");

	private final Client client;
	private final ThievingPlugin plugin;
	private final XpTrackerService xpTrackerService;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private ThievingOverlay(final Client client, final ThievingPlugin plugin, final XpTrackerService xpTrackerService)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.xpTrackerService = xpTrackerService;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ThievingSession session = plugin.getSession();
		if (session == null)
		{
			return null;
		}

		panelComponent.setPreferredSize(new Dimension(145, 0));
		panelComponent.getChildren().clear();

		if (isThieving())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Thieving")
				.color(Color.GREEN)
				.build());
		}
		else if (isStunned())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Stunned")
				.color(Color.ORANGE)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("NOT thieving")
				.color(Color.RED)
				.build());
		}

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		tableComponent.addRow("Succeeded:", session.getSuccessful() + (session.getSuccessful() >= 1 ? " (" + xpTrackerService.getActionsHr(Skill.THIEVING) + "/hr)" : ""));
		tableComponent.addRow("Failed:", session.getFailed() + (session.getFailed() >= 1 ? " (" + FORMAT.format(session.getSuccessRate()) + "%)" : ""));

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}

	private boolean isThieving()
	{
		if (client.getLocalPlayer() == null)
		{
			return false;
		}

		switch (client.getLocalPlayer().getAnimation())
		{
			case THIEVING_STALL:
			case PICKPOCKET_SUCCESS:
				return true;
			default:
				return false;
		}
	}

	private boolean isStunned()
	{
		if (client.getLocalPlayer() == null)
		{
			return false;
		}

		return client.getLocalPlayer().getAnimation() == BLOCK_UNARMED;
	}
}
