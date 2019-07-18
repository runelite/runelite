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
package net.runelite.client.plugins.stonedloottracker.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.client.RuneLite.RUNELITE_DIR;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.stonedloottracker.data.events.LootTrackerNameChange;
import net.runelite.client.plugins.stonedloottracker.data.events.LootTrackerRecordStored;
import net.runelite.http.api.RuneLiteAPI;

@Slf4j
@Singleton
public class LootRecordWriter
{
	private static final String FILE_EXTENSION = ".log";
	private static final File LOOT_RECORD_DIR = new File(RUNELITE_DIR, "loots");

	// Data is stored in a folder with the players in-game username
	private File playerFolder = LOOT_RECORD_DIR;

	private final EventBus bus;

	@Inject
	public LootRecordWriter(EventBus bus)
	{
		this.bus = bus;
		playerFolder.mkdir();
	}

	private static String npcNameToFileName(String npcName)
	{
		return npcName.toLowerCase().trim() + FILE_EXTENSION;
	}

	public void setPlayerUsername(String username)
	{
		playerFolder = new File(LOOT_RECORD_DIR, username);
		playerFolder.mkdir();
		bus.post(LootTrackerNameChange.class, new LootTrackerNameChange());
	}

	public Set<String> getKnownFileNames()
	{
		Set<String> fileNames = new HashSet<>();

		File[] files = playerFolder.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));
		if (files != null)
		{
			for (File f : files)
			{
				fileNames.add(f.getName().replace(FILE_EXTENSION, ""));
			}
		}

		return fileNames;
	}

	public synchronized Collection<LootRecordCustom> loadLootTrackerRecords(String npcName)
	{
		String fileName = npcNameToFileName(npcName);
		File file = new File(playerFolder, fileName);
		Collection<LootRecordCustom> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				// Skip empty line at end of file
				if (line.length() > 0)
				{
					LootRecordCustom r = RuneLiteAPI.GSON.fromJson(line, LootRecordCustom.class);
					data.add(r);
				}
			}

		}
		catch (FileNotFoundException e)
		{
			log.debug("File not found: {}", fileName);
		}
		catch (IOException e)
		{
			log.warn("IOException for file {}: {}", fileName, e.getMessage());
		}

		return data;
	}

	public synchronized void addLootTrackerRecord(LootRecordCustom rec)
	{
		// Grab file
		String fileName = npcNameToFileName(rec.getName());
		File lootFile = new File(playerFolder, fileName);

		// Convert entry to JSON
		String dataAsString = RuneLiteAPI.GSON.toJson(rec);

		// Open File in append mode and write new data
		try
		{
			BufferedWriter file = new BufferedWriter(new FileWriter(String.valueOf(lootFile), true));
			file.append(dataAsString);
			file.newLine();
			file.close();
			bus.post(LootTrackerRecordStored.class, new LootTrackerRecordStored(rec));
		}
		catch (IOException ioe)
		{
			log.warn("Error writing loot data to file {}: {}", fileName, ioe.getMessage());
		}
	}

	// Mostly used to adjust previous loot entries such as adding pet drops/abyssal sire drops
	public synchronized void writeLootTrackerFile(String npcName, Collection<LootRecordCustom> loots)
	{
		String fileName = npcNameToFileName(npcName);
		File lootFile = new File(playerFolder, fileName);

		try
		{
			BufferedWriter file = new BufferedWriter(new FileWriter(String.valueOf(lootFile), false));
			for (LootRecordCustom rec : loots)
			{
				// Convert entry to JSON
				String dataAsString = RuneLiteAPI.GSON.toJson(rec);
				file.append(dataAsString);
				file.newLine();
			}
			file.close();

		}
		catch (IOException ioe)
		{
			log.warn("Error rewriting loot data to file {}: {}", fileName, ioe.getMessage());
		}
	}

	public synchronized void deleteLootTrackerRecords(String npcName)
	{
		String fileName = npcNameToFileName(npcName);

		File lootFile = new File(playerFolder, fileName);

		if (lootFile.delete())
		{
			log.debug("Deleted loot file: {}", fileName);
		}
		else
		{
			log.debug("Couldn't delete file: {}", fileName);
		}
	}

	public Collection<LootRecordCustom> loadAllLootTrackerRecords()
	{
		List<LootRecordCustom> recs = new ArrayList<>();

		for (String n : getKnownFileNames())
		{
			recs.addAll(loadLootTrackerRecords(n));
		}

		return recs;
	}

	public void convertFileFormats()
	{
		for (String f : getKnownFileNames())
		{
			updateFileFormat(npcNameToFileName(f));
		}
		log.info("Done converting");
	}

	private void updateFileFormat(String fileName)
	{
		File lootFile = new File(playerFolder, fileName);
		Collection<LootRecordCustom> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(lootFile)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				// Skip empty line at end of file
				if (line.length() > 0)
				{
					LootRecordCustom r = RuneLiteAPI.GSON.fromJson(line, LootRecord.class).toNewFormat();
					data.add(r);
				}
			}

		}
		catch (FileNotFoundException e)
		{
			log.info("File not found: {}", fileName);
		}
		catch (IOException e)
		{
			log.warn("IOException for file {}: {}", fileName, e.getMessage());
		}

		try
		{
			BufferedWriter file = new BufferedWriter(new FileWriter(String.valueOf(lootFile), false));
			for (LootRecordCustom rec : data)
			{
				// Convert entry to JSON
				String dataAsString = RuneLiteAPI.GSON.toJson(rec);
				file.append(dataAsString);
				file.newLine();
			}
			file.close();
		}
		catch (IOException ioe)
		{
			log.warn("Error rewriting loot data to file {}: {}", fileName, ioe.getMessage());
		}
	}
}