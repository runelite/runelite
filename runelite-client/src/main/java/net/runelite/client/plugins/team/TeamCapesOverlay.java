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
package net.runelite.client.plugins.team;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.ImageComponent;

class TeamCapesOverlay extends OverlayPanel
{
	private final TeamPlugin plugin;
	private final TeamConfig config;
	private final ItemManager manager;

	@Inject
	private TeamCapesOverlay(TeamPlugin plugin, TeamConfig config, ItemManager manager)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(PRIORITY_LOW);
		this.plugin = plugin;
		this.config = config;
		this.manager = manager;
		panelComponent.setWrap(true);
		panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Teamcapes overlay");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Map<Integer, Integer> teams = plugin.getTeams();
		if (teams.isEmpty() || !config.teamCapesOverlay())
		{
			return null;
		}

		for (Map.Entry<Integer, Integer> team : teams.entrySet())
		{
			// Only display team capes that have a count greater than the configured minimum
			if (team.getValue() < config.getMinimumCapeCount())
			{
				continue;
			}

			// Make the number 0 based
			final int teamcapeNumber = team.getKey() - 1;
			final int itemID;
			if (teamcapeNumber < 50)
			{
				// The team cape is every 2nd item id based on tc number
				itemID = 2 * teamcapeNumber + ItemID.WILDERNESS_CAPE_1;
			}
			else
			{
				// The team cape is every 3rd item id based on tc number starting from 0
				itemID = 3 * (teamcapeNumber - 50) + ItemID.WILDERNESS_CAPE_ZERO;
			}

			panelComponent.getChildren().add(new ImageComponent(manager.getImage(itemID, team.getValue(), true)));
		}

		return super.render(graphics);
	}
}
