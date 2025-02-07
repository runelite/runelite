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
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.VarPlayer;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class WoodcuttingOverlay extends OverlayPanel
{
	private static final String WOODCUTTING_RESET = "Reset";
	private static final int BUFF_BAR_DISPLAYED = 96;

	private final Client client;
	private final WoodcuttingPlugin plugin;
	private final WoodcuttingConfig config;

	@Inject
	private WoodcuttingOverlay(Client client, WoodcuttingPlugin plugin, WoodcuttingConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Woodcutting overlay");
		addMenuEntry(RUNELITE_OVERLAY, WOODCUTTING_RESET, "Woodcutting overlay", e -> plugin.resetSession());
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		WoodcuttingSession session = plugin.getSession();
		if (session == null || !session.isActive() || !config.showWoodcuttingStats())
		{
			return null;
		}

		if (WoodcuttingPlugin.WOODCUTTING_ANIMS.contains(client.getLocalPlayer().getAnimation())
			|| client.getVarpValue(VarPlayer.BUFF_BAR_WC_GROUP_BONUS) == BUFF_BAR_DISPLAYED)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Woodcutting")
				.color(Color.GREEN)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("NOT woodcutting")
				.color(Color.RED)
				.build());
		}

		int logsCut = session.getLogsCut();
		if (logsCut > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Logs cut:")
				.right(Integer.toString(logsCut))
				.build());

			int logsPerHr = session.getLogsPerHr();
			if (logsPerHr > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Logs/hr:")
					.right(Integer.toString(logsPerHr))
					.build());
			}
		}

		int bark = session.getBark();
		if (bark > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Bark:")
				.right(Integer.toString(bark))
				.build());

			int barkPerHr = session.getBarkPerHr();
			if (barkPerHr > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Bark/hr:")
					.right(Integer.toString(barkPerHr))
					.build());
			}
		}

		return super.render(graphics);
	}

}