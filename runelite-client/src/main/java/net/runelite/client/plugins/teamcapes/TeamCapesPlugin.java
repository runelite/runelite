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

import com.google.inject.Provides;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Team Capes",
	description = "Show the different team capes in your area and the amount of each",
	tags = {"overlay", "players"},
	enabledByDefault = false
)
public class TeamCapesPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TeamCapesOverlay overlay;

	// Hashmap of team capes: Key is the teamCape #, Value is the count of teamcapes in the area.
	private Map<Integer, Integer> teams = new HashMap<>();

	@Provides
	TeamCapesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TeamCapesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		teams.clear();
	}

	@Schedule(
		period = 1800,
		unit = ChronoUnit.MILLIS
	)
	public void update()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		List<Player> players = client.getPlayers();
		teams.clear();
		for (Player player : players)
		{
			int team = player.getTeam();
			if (team > 0)
			{
				if (teams.containsKey(team))
				{
					teams.put(team, teams.get(team) + 1);
				}
				else
				{
					teams.put(team, 1);
				}
			}
		}

		// Sort teams by value in descending order and then by key in ascending order, limited to 5 entries
		teams = teams.entrySet().stream()
					.sorted(
						Comparator.comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
								.thenComparingInt(Map.Entry::getKey)
					)
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public Map<Integer, Integer> getTeams()
	{
		return teams;
	}

}
