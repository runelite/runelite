/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
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
package net.runelite.client.plugins.teamcapes;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class TeamCapesOverlay extends Overlay
{

	private final PanelComponent panelComponent = new PanelComponent();
	private final TeamCapesPlugin plugin;
	private final TeamCapesConfig config;
	private final ItemManager manager;

	@Inject
	private TeamCapesOverlay(TeamCapesPlugin plugin, TeamCapesConfig config, ItemManager manager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.plugin = plugin;
		this.config = config;
		this.manager = manager;
		panelComponent.setOrientation(PanelComponent.Orientation.HORIZONTAL);
		panelComponent.setWrapping(4);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		Map<Integer, Integer> teams = plugin.getTeams();
		if (teams.isEmpty())
		{
			return null;
		}
		for (Map.Entry<Integer, Integer> team : teams.entrySet())
		{
			// Only display team capes that have a count greater than the configured minimum
			if (team.getValue() >= config.getMinimumCapeCount())
			{
				//ItemID.TEAM1_CAPE == 4315 (1), ItemID.TEAM2_CAPE == 4317 (2), ItemID.TEAM50_CAPE == 4413 (50)
				//ItemID.TEAM_CAPE_ZERO == 20211 (51), ItemID.TEAM_CAPE_X == 20214 (52), ItemID.TEAM_CAPE_I == 20217 (53)
				int teamcapeNumber = team.getKey();
				int ItemID = teamcapeNumber < 51 ? (2 * teamcapeNumber + 4313) : (3 * (teamcapeNumber - 50) + 20208);
				panelComponent.getChildren().add(new ImageComponent(manager.getImage( ItemID ,  team.getValue(), true)));
			}
		}
		return panelComponent.render(graphics);
	}
}
