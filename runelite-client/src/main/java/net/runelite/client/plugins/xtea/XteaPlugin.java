/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.xtea;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.http.api.xtea.XteaKey;
import net.runelite.http.api.xtea.XteaRequest;

@PluginDescriptor(
	name = "Xtea",
	hidden = true
)
@Slf4j
public class XteaPlugin extends Plugin
{
	private static final File XTEA_CACHE = new File(RuneLite.CACHE_DIR, "xtea.json");

	@Inject
	private Client client;

	@Inject
	private XteaClient xteaClient;

	@Inject
	private ScheduledExecutorService executorService;

	@Inject
	private Gson gson;

	private Map<Integer, int[]> xteas;

	@Override
	protected void startUp()
	{
		executorService.execute(() -> xteas = load());
	}

	private Map<Integer, int[]> load()
	{
		try (FileInputStream in = new FileInputStream(XTEA_CACHE);
			FileChannel channel = in.getChannel();
			InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8))
		{
			channel.lock(0, Long.MAX_VALUE, true);
			return gson.fromJson(reader,
				new TypeToken<Map<Integer, int[]>>()
				{
				}.getType());
		}
		catch (FileNotFoundException ex)
		{
			return new HashMap<>();
		}
		catch (IOException | JsonSyntaxException e)
		{
			log.debug("error loading xteas", e);
			return new HashMap<>();
		}
	}

	private void save()
	{
		try (FileOutputStream out = new FileOutputStream(XTEA_CACHE);
			FileChannel channel = out.getChannel();
			OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8))
		{
			channel.lock();
			gson.toJson(xteas,
				new TypeToken<Map<Integer, int[]>>()
				{
				}.getType(),
				writer);
		}
		catch (IOException e)
		{
			log.debug("error saving xteas", e);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		int revision = client.getRevision();
		int[] regions = client.getMapRegions();
		int[][] xteaKeys = client.getXteaKeys();

		XteaRequest xteaRequest = new XteaRequest();
		xteaRequest.setRevision(revision);

		for (int idx = 0; idx < regions.length; ++idx)
		{
			int region = regions[idx];
			int[] keys = xteaKeys[idx];

			int[] seenKeys = xteas.get(region);
			if (Arrays.equals(seenKeys, keys))
			{
				continue;
			}

			xteas.put(region, keys);

			log.debug("Region {} keys {}, {}, {}, {}", region, keys[0], keys[1], keys[2], keys[3]);

			XteaKey xteaKey = new XteaKey();
			xteaKey.setRegion(region);
			xteaKey.setKeys(keys);
			xteaRequest.addKey(xteaKey);
		}

		if (xteaRequest.getKeys().isEmpty())
		{
			return;
		}

		xteaClient.submit(xteaRequest);
		executorService.execute(this::save);
	}
}
