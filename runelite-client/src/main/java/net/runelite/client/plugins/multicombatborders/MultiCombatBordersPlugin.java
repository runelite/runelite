/*
 * Copyright (c) 2018, Mattias Cederlund <https://github.com/mattec92>
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
package net.runelite.client.plugins.multicombatborders;

import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.inject.Provides;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.Constants.CHUNK_SIZE;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.opponentinfo.OpponentInfoPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Multi-combat borders",
	description = "Show borders between mutli and single combat areas",
	enabledByDefault = false
)
public class MultiCombatBordersPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MultiCombatBordersOverlay multiCombatBordersOverlay;

	private Map<Integer, Map<Integer, List<MultiCombatBorder>>> chunks = new HashMap<>();

	List<MultiCombatBorder> multiCombatBordersWithinView = Collections.emptyList();
	private WorldPoint prevPlayerLocation;

	@Provides
	private MultiCombatBordersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MultiCombatBordersConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		chunks = chunk(loadMultiCombatBorders());
		overlayManager.add(multiCombatBordersOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(multiCombatBordersOverlay);
	}

	private static List<MultiCombatBorder> loadMultiCombatBorders()
	{
		Gson gson = new Gson();
		InputStream multiBordersFile = OpponentInfoPlugin.class.getResourceAsStream("/multi_borders.json");
		JsonArray items = gson.fromJson(new InputStreamReader(multiBordersFile), JsonArray.class);

		List<MultiCombatBorder> output = new ArrayList<>(items.size());

		for (JsonElement element : items)
		{
			JsonObject item = (JsonObject) element;
			for (String key : item.keySet())
			{
				JsonObject nested = item.getAsJsonObject(key);
				output.add(
					new MultiCombatBorder(
						key,
						fromJsonObject(nested.getAsJsonObject("single")),
						fromJsonObject(nested.getAsJsonObject("multi"))));
			}
		}

		return output;
	}

	private static WorldPoint fromJsonObject(@Nonnull JsonObject jsonObject)
	{
		JsonPrimitive x = jsonObject.getAsJsonPrimitive("x");
		JsonPrimitive y = jsonObject.getAsJsonPrimitive("y");
		return new WorldPoint(x.getAsInt(), y.getAsInt(), 0);
	}

	private static Map<Integer, Map<Integer, List<MultiCombatBorder>>> chunk(List<MultiCombatBorder> borders)
	{
		Map<Integer, Map<Integer, List<MultiCombatBorder>>> output = new HashMap<>();
		for (MultiCombatBorder border : borders)
		{
			int chunkX = border.getMulti().getX() / CHUNK_SIZE;
			int chunkY = border.getMulti().getY() / CHUNK_SIZE;
			Map<Integer, List<MultiCombatBorder>> xMap = output.computeIfAbsent(chunkX, k -> new HashMap<>());
			List<MultiCombatBorder> yList = xMap.computeIfAbsent(chunkY, k -> new ArrayList<>());
			yList.add(border);
		}
		return output;
	}

	@Subscribe
	void onTick(GameTick tick)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
		if (playerLocation != null && !playerLocation.equals(prevPlayerLocation))
		{
			prevPlayerLocation = playerLocation;
			multiCombatBordersWithinView = getBordersWithinView(playerLocation);
		}
	}

	private List<MultiCombatBorder> getAdjacentChunks()
	{
		List<MultiCombatBorder> output = new ArrayList<>();
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
		int chunkX = playerLocation.getX() / CHUNK_SIZE;
		int chunkY = playerLocation.getY() / CHUNK_SIZE;
		for (int x = chunkX - 3; x < chunkX + 3; x++)
		{
			for (int y = chunkY - 3; y < chunkY + 3; y++)
			{
				Map<Integer, List<MultiCombatBorder>> xMap = chunks.get(x);
				if (xMap != null)
				{
					List<MultiCombatBorder> yList = xMap.get(y);
					if (yList != null)
					{
						output.addAll(yList);
					}
				}
			}
		}
		return output;
	}

	private List<MultiCombatBorder> getBordersWithinView(@Nonnull WorldPoint playerLocation)
	{
		return getAdjacentChunks()
			.stream()
			.filter(border -> playerLocation.distanceTo(border.getMulti()) <= 18)
			.collect(Collectors.toList());
	}
}
