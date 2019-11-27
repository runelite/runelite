/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ClanMemberManager;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.plugins.raids.solver.Room;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class RaidsOverlay extends Overlay
{
	private static final int OLM_PLANE = 0;
	static final String BROADCAST_ACTION = "Broadcast layout";
	static final String SCREENSHOT_ACTION = "Screenshot";

	private Client client;
	private RaidsPlugin plugin;
	private RaidsConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Getter
	@Setter
	private boolean scoutOverlayShown = false;

	@Inject
	private RaidsOverlay(Client client, RaidsPlugin plugin, RaidsConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Raids overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, BROADCAST_ACTION, "Raids overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, SCREENSHOT_ACTION, "Raids overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.scoutOverlay() || !scoutOverlayShown || plugin.isInRaidChambers() && client.getPlane() == OLM_PLANE)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		if (plugin.getRaid() == null || plugin.getRaid().getLayout() == null)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Unable to scout this raid!")
				.color(Color.RED)
				.build());

			return panelComponent.render(graphics);
		}

		Color color = Color.WHITE;
		String layout = plugin.getRaid().getLayout().toCodeString();

		if (config.enableLayoutWhitelist() && !plugin.getLayoutWhitelist().contains(layout.toLowerCase()))
		{
			color = Color.RED;
		}

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(layout)
			.color(color)
			.build());

		if (config.ccDisplay())
		{
			color = Color.RED;
			ClanMemberManager clanMemberManager = client.getClanMemberManager();
			FontMetrics metrics = graphics.getFontMetrics();
			String worldString = "W" + client.getWorld();
			String clanOwner = "Join a CC";
			if (clanMemberManager != null)
			{
				clanOwner = clanMemberManager.getClanOwner();
				color = Color.ORANGE;
			}

			panelComponent.setPreferredSize(new Dimension(Math.max(ComponentConstants.STANDARD_WIDTH, metrics.stringWidth(worldString) + metrics.stringWidth(clanOwner) + 14), 0));
			panelComponent.getChildren().add(LineComponent.builder()
				.left(worldString)
				.right(clanOwner)
				.leftColor(Color.ORANGE)
				.rightColor(color)
				.build());
		}

		for (Room layoutRoom : plugin.getRaid().getLayout().getRooms())
		{
			int position = layoutRoom.getPosition();
			RaidRoom room = plugin.getRaid().getRoom(position);

			if (room == null)
			{
				continue;
			}

			color = Color.WHITE;

			switch (room.getType())
			{
				case COMBAT:
					if (plugin.getRoomWhitelist().contains(room.getName().toLowerCase()))
					{
						color = Color.GREEN;
					}
					else if (plugin.getRoomBlacklist().contains(room.getName().toLowerCase())
							|| config.enableRotationWhitelist() && !plugin.getRotationMatches())
					{
						color = Color.RED;
					}

					String name = room == RaidRoom.UNKNOWN_COMBAT ? "Unknown" : room.getName();

					panelComponent.getChildren().add(LineComponent.builder()
						.left(room.getType().getName())
						.right(name)
						.rightColor(color)
						.build());

					break;

				case PUZZLE:
					if (plugin.getRoomWhitelist().contains(room.getName().toLowerCase()))
					{
						color = Color.GREEN;
					}
					else if (plugin.getRoomBlacklist().contains(room.getName().toLowerCase()))
					{
						color = Color.RED;
					}

					name = room == RaidRoom.UNKNOWN_PUZZLE ? "Unknown" : room.getName();

					panelComponent.getChildren().add(LineComponent.builder()
						.left(room.getType().getName())
						.right(name)
						.rightColor(color)
						.build());
					break;
			}
		}

		return panelComponent.render(graphics);
	}
}
