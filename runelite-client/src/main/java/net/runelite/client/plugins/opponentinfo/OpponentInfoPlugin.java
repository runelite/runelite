/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.opponentinfo;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.api.worlds.WorldType;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

@PluginDescriptor(
	name = "Opponent Information"
)
@Slf4j
public class OpponentInfoPlugin extends Plugin
{
	@Inject
	private OpponentInfoOverlay overlay;

	@Inject
	private Client client;

	private WorldResult worldInfo;

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	protected void startUp() throws Exception
	{
		try
		{
			worldInfo = new WorldClient().lookupWorlds();

			if (worldInfo != null)
			{
				log.debug("Worlds list contains {} worlds", worldInfo.getWorlds().size());
			}
			else
			{
				log.warn("Unable to look up worlds");
			}
		}
		catch (IOException e)
		{
			log.warn("Error looking up worlds list", e);
		}
	}

	HiscoreEndpoint getHiscoreEndpoint()
	{
		HiscoreEndpoint result = HiscoreEndpoint.NORMAL; //Our default will be normal because im lazy

		if (worldInfo == null)
		{
			return result;
		}

		World world = worldInfo.findWorld(client.getWorld());

		WorldType type = null;
		if (world != null)
		{
			if (world.getTypes().contains(WorldType.DEADMAN))
			{
				result = HiscoreEndpoint.DEADMAN;
			}
			else if (world.getTypes().contains(WorldType.SEASONAL_DEADMAN))
			{
				result = HiscoreEndpoint.SEASONAL_DEADMAN;
			}
		}

		return result;

	}

	public static Map<String, Integer> loadNpcHealth()
	{
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Integer>>()
		{
		}.getType();

		InputStream healthFile = OpponentInfoPlugin.class.getResourceAsStream("/npc_health.json");
		return gson.fromJson(new InputStreamReader(healthFile), type);
	}
}
