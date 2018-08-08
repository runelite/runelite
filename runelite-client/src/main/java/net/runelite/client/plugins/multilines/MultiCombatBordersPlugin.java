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
package net.runelite.client.plugins.multilines;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.inject.Provides;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.opponentinfo.OpponentInfoPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Multicombat borders"
)
public class MultiCombatBordersPlugin extends Plugin
{

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MultiCombatBordersOverlay multiLinesOverlay;

	List<MultiCombatBorder> multiCombatBorders = loadMultiCombatBorders();

	@Provides
	MultiCombatBordersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MultiCombatBordersConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(multiLinesOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(multiLinesOverlay);
	}

	private List<MultiCombatBorder> loadMultiCombatBorders()
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

	private WorldPoint fromJsonObject(JsonObject jsonObject)
	{
		JsonPrimitive x = jsonObject.getAsJsonPrimitive("x");
		JsonPrimitive y = jsonObject.getAsJsonPrimitive("y");
		return new WorldPoint(x.getAsInt(), y.getAsInt(), 0);
	}

}
