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
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.PlayerChanged;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Team Capes",
	description = "Show the different team capes in your area and the amount of each",
	tags = {"overlay", "players"},
	enabledByDefault = false
)
@Slf4j
public class TeamCapesPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TeamCapesOverlay overlay;

	// Team number -> Number of players
	@Getter(AccessLevel.PACKAGE)
	private Map<Integer, Integer> teams = new LinkedHashMap<>();
	// Player -> Team number
	private final Map<Player, Integer> playerTeam = new HashMap<>();

	@Provides
	TeamCapesConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TeamCapesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		clientThread.invokeLater(() -> client.getPlayers().forEach(this::update));
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		teams.clear();
		playerTeam.clear();
	}

	@Subscribe
	public void onPlayerChanged(PlayerChanged playerChanged)
	{
		Player player = playerChanged.getPlayer();
		update(player);
	}

	private void update(Player player)
	{
		int oldTeam = playerTeam.getOrDefault(player, 0);
		if (oldTeam == player.getTeam())
		{
			return;
		}

		log.debug("{} has changed teams: {} -> {}", player.getName(), oldTeam, player.getTeam());

		if (oldTeam > 0)
		{
			teams.computeIfPresent(oldTeam, (key, value) -> value > 1 ? value - 1 : null);
			playerTeam.remove(player);
		}

		if (player.getTeam() > 0)
		{
			teams.merge(player.getTeam(), 1, Integer::sum);
			playerTeam.put(player, player.getTeam());
		}

		sort();
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned playerDespawned)
	{
		Player player = playerDespawned.getPlayer();
		Integer team = playerTeam.remove(player);
		if (team != null)
		{
			teams.computeIfPresent(team, (key, value) -> value > 1 ? value - 1 : null);
			sort();
		}
	}

	private void sort()
	{
		// Sort teams by value in descending order and then by key in ascending order, limited to 5 entries
		teams = teams.entrySet().stream()
			.sorted(
				Comparator.comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
					.thenComparingInt(Map.Entry::getKey)
			)
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}
