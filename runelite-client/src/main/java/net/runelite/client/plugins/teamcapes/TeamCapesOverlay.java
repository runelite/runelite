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

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TeamCapesOverlay extends Overlay
{
	private final TeamCapesPlugin plugin;
	private final TeamCapesConfig config;
	private final PanelComponent panelComponent = new PanelComponent();
	private final int MAX_CLAN_NAME_LENGTH = 35;
	private Map<Integer, String> teamNames = new HashMap<>();

	@Inject
	TeamCapesOverlay(TeamCapesPlugin plugin, TeamCapesConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		Map<Integer, Integer> teams = plugin.getTeams();
		if (teams.isEmpty())
		{
			return null;
		}
		panelComponent.getLines().clear();
		final FontMetrics metrics = graphics.getFontMetrics();

		// Setup customTeamNames by parsing the formatted input to rename team-capes.
		// Format w/ examples (comma seperated): teamcape#=TEAMNAME
		// 7=Critical Damage,30=FOE
		teamNames.clear();
		if (this.config.getCustomTeamNames().length() >= 3)
		{
			for (String teamName : this.config.getCustomTeamNames().split(","))
			{
				String[] values = teamName.split("=");
				int capeNum;
				String capeName;
				try
				{
					capeNum = Integer.parseInt(values[0]);
					capeName = values[1];
				}
				// If parse error, then invalid formatting. Go to next comma seperated group.
				catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
				{
					continue;
				}

				teamNames.put(capeNum, capeName);
			}
		}


		for (Map.Entry<Integer, Integer> team : teams.entrySet())
		{
			// Only display team capes that have a count greater than the configured minimum.
			if (team.getValue() >= config.getMinimumCapeCount())
			{
				String capeName;

				if (teamNames.containsKey(team.getKey()))
				{
					// If the cape has a name assigned, output that instead of the #.
					capeName = teamNames.get(team.getKey());

					// Cut the name if it's way too long to prevent the following loop from doing
					// too many useless calculations/function calls.
					if (capeName.length() > MAX_CLAN_NAME_LENGTH)
					{
						capeName = capeName.substring(0, MAX_CLAN_NAME_LENGTH );
						teamNames.replace(team.getKey(), capeName);
					}

					// If the capeName is too long, it will go all the way until it's under the cape count.
					// So take chars off the cape name until it is short enough to fit reasonably.
					while (metrics.stringWidth(capeName) >=
							(panelComponent.getWidth() -
									metrics.stringWidth(Integer.toString(team.getValue())) -
									PanelComponent.LEFT_BORDER - PanelComponent.RIGHT_BORDER - 4))
					{
						capeName = capeName.substring(0, capeName.length() - 1);
					}
				}
				else // If it has no custom name, just display Team-##
				{
					capeName = "Team-" + Integer.toString(team.getKey());
				}

				panelComponent.getLines().add(new PanelComponent.Line(
						capeName,
						Color.WHITE,
						Integer.toString(team.getValue()),
						Color.WHITE
				));
			}
		}
		return panelComponent.render(graphics, parent);
	}
}
