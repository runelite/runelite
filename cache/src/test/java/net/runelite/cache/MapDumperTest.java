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
package net.runelite.cache;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.cache.definitions.LocationsDefinition;
import net.runelite.cache.definitions.MapDefinition;
import net.runelite.cache.definitions.loaders.LocationsLoader;
import net.runelite.cache.definitions.loaders.MapLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.XteaKeyManager;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(MapDumperTest.class);

	private static final int MAX_REGIONS = 32768;
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	@Ignore
	public void dumpRaw() throws IOException
	{
		File base = StoreLocation.LOCATION,
			outDir = folder.newFolder();
		XteaKeyManager keyManager = new XteaKeyManager();
		keyManager.loadKeys();

		try (Store store = new Store(base))
		{
			store.load();

			Storage storage = store.getStorage();
			Index index = store.getIndex(IndexType.MAPS);

			for (int i = 0; i < MAX_REGIONS; i++)
			{
				int[] keys = keyManager.getKeys(i);

				int x = i >> 8;
				int y = i & 0xFF;

				Archive map = index.findArchiveByName("m" + x + "_" + y);
				Archive land = index.findArchiveByName("l" + x + "_" + y);

				assert (map == null) == (land == null);

				if (map == null || land == null)
				{
					continue;
				}

				byte[] data = map.decompress(storage.loadArchive(map));

				Files.write(data, new File(outDir, "m" + x + "_" + y + ".dat"));

				if (keys != null)
				{
					try
					{
						data = land.decompress(storage.loadArchive(land), keys);
					}
					catch (IOException ex)
					{
						logger.info("Unable to decompress and load land " + x + "," + y + " (bad keys?)", ex);
						continue;
					}

					logger.info("Decrypted region {} coords {},{}", i, x, y);

					Files.write(data, new File(outDir, "l" + x + "_" + y + ".dat"));
				}
			}
		}
	}

	private Map<MapDefinition, LocationsDefinition> loadRegions(Store store) throws IOException
	{
		Map<MapDefinition, LocationsDefinition> mapMap = new HashMap<>();
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.MAPS);
		XteaKeyManager keyManager = new XteaKeyManager();
		keyManager.loadKeys();

		for (int i = 0; i < MAX_REGIONS; ++i)
		{
			int x = i >> 8;
			int y = i & 0xFF;

			Archive map = index.findArchiveByName("m" + x + "_" + y);
			Archive land = index.findArchiveByName("l" + x + "_" + y);

			assert (map == null) == (land == null);

			if (map == null || land == null)
			{
				continue;
			}

			byte[] data = map.decompress(storage.loadArchive(map));
			MapDefinition mapDef = new MapLoader().load(x, y, data);
			LocationsDefinition locDef = null;

			int[] keys = keyManager.getKeys(i);
			if (keys != null)
			{
				try
				{
					data = land.decompress(storage.loadArchive(land), keys);
				}
				catch (IOException ex)
				{
					continue;
				}

				locDef = new LocationsLoader().load(x, y, data);
			}

			mapMap.put(mapDef, locDef);
		}

		return mapMap;
	}

	@Test
	@Ignore
	public void dumpJson() throws IOException
	{
		File base = StoreLocation.LOCATION,
			outDir = folder.newFolder();

		try (Store store = new Store(base))
		{
			store.load();

			Map<MapDefinition, LocationsDefinition> regions = loadRegions(store);

			for (Entry<MapDefinition, LocationsDefinition> entry : regions.entrySet())
			{
				MapDefinition key = entry.getKey();
				LocationsDefinition value = entry.getValue();

				int x = key.getRegionX();
				int y = key.getRegionY();
				Files.write(gson.toJson(key).getBytes(), new File(outDir, "m" + x + "_" + y + ".json"));
				if (value != null)
				{
					Files.write(gson.toJson(value).getBytes(), new File(outDir, "l" + x + "_" + y + ".json"));
				}
			}
		}

		logger.info("Dumped regions to {}", outDir);
	}
}
