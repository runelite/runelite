/*
 * Copyright (c) 2021 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.roofremoval;

import com.google.common.base.Stopwatch;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import static net.runelite.api.Constants.ROOF_FLAG_BETWEEN;
import static net.runelite.api.Constants.ROOF_FLAG_DESTINATION;
import static net.runelite.api.Constants.ROOF_FLAG_HOVERED;
import static net.runelite.api.Constants.ROOF_FLAG_POSITION;
import net.runelite.api.GameState;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Roof Removal",
	description = "Remove only the needed roofs above your player, hovered tile, or destination",
	enabledByDefault = false
)
@Slf4j
public class RoofRemovalPlugin extends Plugin
{
	private static class FlaggedArea
	{
		int rx1;
		int ry1;
		int rx2;
		int ry2;
		int z1;
		int z2;
	}

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private Gson gson;

	@Inject
	private RoofRemovalConfig config;

	private final Map<Integer, long[]> overrides = new HashMap<>();
	private final Set<Integer> configOverrideRegions = new HashSet<>();

	@Provides
	RoofRemovalConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RoofRemovalConfig.class);
	}

	@Override
	public void startUp() throws IOException
	{
		buildConfigOverrides();
		loadRoofOverrides();
		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				performRoofRemoval();
			}
			client.getScene().setRoofRemovalMode(buildRoofRemovalFlags());
		});
	}

	@Override
	public void shutDown()
	{
		overrides.clear();
		clientThread.invoke(() ->
		{
			client.getScene().setRoofRemovalMode(0);
			// Reload the scene to clear roof flag overrides
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				client.setGameState(GameState.LOADING);
			}
		});
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged e)
	{
		if (e.getGameState() == GameState.LOGGED_IN)
		{
			performRoofRemoval();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged e)
	{
		if (!e.getGroup().equals(RoofRemovalConfig.CONFIG_GROUP))
		{
			return;
		}

		if (e.getKey().startsWith("remove"))
		{
			client.getScene().setRoofRemovalMode(buildRoofRemovalFlags());
		}
		else if (e.getKey().startsWith("override"))
		{
			buildConfigOverrides();
			clientThread.invoke(() ->
			{
				if (client.getGameState() == GameState.LOGGED_IN)
				{
					client.setGameState(GameState.LOADING);
				}
			});
		}
	}

	private int buildRoofRemovalFlags()
	{
		int roofRemovalMode = 0;
		if (config.removePosition())
		{
			roofRemovalMode |= ROOF_FLAG_POSITION;
		}
		if (config.removeHovered())
		{
			roofRemovalMode |= ROOF_FLAG_HOVERED;
		}
		if (config.removeDestination())
		{
			roofRemovalMode |= ROOF_FLAG_DESTINATION;
		}
		if (config.removeBetween())
		{
			roofRemovalMode |= ROOF_FLAG_BETWEEN;
		}
		return roofRemovalMode;
	}

	private void buildConfigOverrides()
	{
		configOverrideRegions.clear();
		for (RoofRemovalConfigOverride configOverride : RoofRemovalConfigOverride.values())
		{
			if (configOverride.getEnabled().test(config))
			{
				configOverrideRegions.addAll(configOverride.getRegions());
			}
		}
	}

	private void performRoofRemoval()
	{
		assert client.isClientThread();
		applyRoofOverrides();

		Stopwatch sw = Stopwatch.createStarted();
		client.getScene().generateHouses();
		log.debug("House generation duration: {}", sw.stop());
	}

	private void loadRoofOverrides() throws IOException
	{
		try (InputStream in = getClass().getResourceAsStream("overrides.jsonc"))
		{
			final InputStreamReader data = new InputStreamReader(in, StandardCharsets.UTF_8);
			//CHECKSTYLE:OFF
			final Type type = new TypeToken<Map<Integer, List<FlaggedArea>>>() {}.getType();
			//CHECKSTYLE:ON
			Map<Integer, List<FlaggedArea>> parsed = gson.fromJson(data, type);
			overrides.clear();
			for (Map.Entry<Integer, List<FlaggedArea>> entry : parsed.entrySet())
			{
				for (FlaggedArea fla : entry.getValue())
				{
					for (int z = fla.z1; z <= fla.z2; z++)
					{
						// Given that each region is 64x64, and the override data is a boolean, one of the axis can be stored as
						// bits in a long. This removes the need for a boolean[64][64] and an extra array lookup in favour of
						// a bitwise &, and results in a consistently smaller amount of memory required to store the overrides.
						int packedRegion = entry.getKey() << 2 | z;
						long[] regionData = overrides.computeIfAbsent(packedRegion, k -> new long[Constants.REGION_SIZE]);
						for (int y = fla.ry1; y <= fla.ry2; y++)
						{
							long row = regionData[y];
							for (int x = fla.rx1; x <= fla.rx2; x++)
							{
								row |= (1L << x);
							}
							regionData[y] = row;
						}
					}
				}
			}
		}
	}

	private void applyRoofOverrides()
	{
		Stopwatch sw = Stopwatch.createStarted();
		boolean regionsHaveOverrides = false;

		outer:
		for (int regionID : client.getMapRegions())
		{
			if (configOverrideRegions.contains(regionID))
			{
				regionsHaveOverrides = true;
				break;
			}
			for (int z = 0; z < Constants.MAX_Z; z++)
			{
				if (overrides.containsKey(regionID << 2 | z))
				{
					regionsHaveOverrides = true;
					break outer;
				}
			}
		}
		if (!regionsHaveOverrides)
		{
			return;
		}

		Tile[][][] tiles = client.getScene().getTiles();
		// the extended tile settings control what is actually drawn, the normal
		// tile settings are just a copy
		byte[][][] settings = client.getScene().getExtendedTileSettings();
		final int SCENE_OFFSET = (Constants.EXTENDED_SCENE_SIZE - Constants.SCENE_SIZE) / 2;

		for (int z = 0; z < Constants.MAX_Z; z++)
		{
			for (int x = 0; x < Constants.SCENE_SIZE; x++)
			{
				for (int y = 0; y < Constants.SCENE_SIZE; y++)
				{
					Tile tile = tiles[z][x][y];
					if (tile == null)
					{
						continue;
					}

					// Properly account for instances shifting worldpoints around
					final WorldPoint wp = WorldPoint.fromLocalInstance(client, tile.getLocalLocation(), tile.getPlane());

					int regionAndPlane = wp.getRegionID() << 2 | wp.getPlane();
					if (configOverrideRegions.contains(wp.getRegionID()))
					{
						settings[z][x + SCENE_OFFSET][y + SCENE_OFFSET] |= Constants.TILE_FLAG_UNDER_ROOF;
					}
					else if (overrides.containsKey(regionAndPlane))
					{
						int rx = wp.getRegionX();
						int ry = wp.getRegionY();
						long[] region = overrides.get(regionAndPlane);
						if ((region[ry] & (1L << rx)) != 0)
						{
							settings[z][x + SCENE_OFFSET][y + SCENE_OFFSET] |= Constants.TILE_FLAG_UNDER_ROOF;
						}
					}
				}
			}
		}
		log.debug("Roof override duration: {}", sw.stop());
	}
}
