/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.loottracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.WorldType;
import static net.runelite.client.RuneLite.RUNELITE_DIR;

@Slf4j
class CsvWriter
{
	private static final String FILE_EXTENSION = ".csv";
	private static final File OUTPUT_DIR = new File(RUNELITE_DIR, "loots");

	private final Client client;

	CsvWriter(Client client)
	{
		this.client = client;
		OUTPUT_DIR.mkdir();
	}

	// playerFolder functionality pulled from screenshot plugin
	private File getOutputFile(String fileName)
	{
		return new File(getPlayerFolder(), fileName.toLowerCase().trim() + FILE_EXTENSION);
	}

	private File getPlayerFolder()
	{
		File playerFolder;
		if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			final EnumSet<WorldType> worldTypes = client.getWorldType();
			final boolean dmm = worldTypes.contains(WorldType.DEADMAN);
			final boolean sdmm = worldTypes.contains(WorldType.SEASONAL_DEADMAN);
			final boolean isDmmWorld = dmm || sdmm;

			String playerDir = client.getLocalPlayer().getName();
			if (isDmmWorld)
			{
				playerDir += "-Deadman";
			}
			playerFolder = new File(OUTPUT_DIR, playerDir);
		}
		else
		{
			playerFolder = OUTPUT_DIR;
		}

		playerFolder.mkdirs();
		return playerFolder;
	}

	synchronized Collection<LootTrackerData> loadData(String fileName)
	{
		File file = getOutputFile(fileName);
		Collection<LootTrackerData> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				if (line.length() > 0)
				{
					LootTrackerData m = LootTrackerData.fromCSV(line);
					if (m != null)
					{
						data.add(m);
					}
				}
			}

			return data;
		}
		catch (FileNotFoundException e)
		{
			log.info("File not found: {}", file.toString());
			return data;
		}
		catch (IOException e)
		{
			log.warn("IOException for file {}: {}", file.toString(), e.getMessage());
			return data;
		}
	}

	synchronized boolean storeData(LootTrackerData data)
	{
		// Grab file
		File lootFile = getOutputFile(data.getName());

		boolean addHeader = false;
		if (!lootFile.exists())
		{
			addHeader = true;
		}

		// Open File in append mode and write new data
		try
		{
			BufferedWriter file = new BufferedWriter(new FileWriter(String.valueOf(lootFile), true));
			if (addHeader)
			{
				file.append(LootTrackerData.getCSVHeader());
			}
			file.newLine();
			file.append(data.asCSV());
			file.close();
			return true;
		}
		catch (IOException ioe)
		{
			log.warn("Error writing loot data to file {}: {}", lootFile.toString(), ioe.getMessage());
			return false;
		}
	}

	// Delete log file for specified npc name
	synchronized boolean clearStoredData(String npcName)
	{
		File lootFile = getOutputFile(npcName);

		if (lootFile.delete())
		{
			log.debug("Deleted loot file: {}", lootFile.toString());
			return true;
		}
		else
		{
			log.debug("Couldn't delete file: {}", lootFile.toString());
			return false;
		}
	}

	synchronized Collection<LootTrackerData> loadAllData()
	{
		List<LootTrackerData> data = new ArrayList<>();
		File[] files = getPlayerFolder().listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));
		if (files != null)
		{
			for (File f : files)
			{
				log.info("Found log file: {}", f.getName());
				data.addAll(loadData(f.getName().replace(FILE_EXTENSION, "")));
			}
		}

		return data;
	}
}
