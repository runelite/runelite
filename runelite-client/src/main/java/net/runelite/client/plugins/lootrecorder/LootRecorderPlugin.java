/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.lootrecorder;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.Text;

import static net.runelite.client.RuneLite.LOOTS_DIR;

@PluginDescriptor(
	name = "Loot Recorder"
)

@Slf4j
public class LootRecorderPlugin extends Plugin
{
	private Integer barrowsNumber;
	private Integer raidsNumber;

	private String barrowsFilename = "barrows.log";
	private String raidsFilename = "raids.log";

	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");

	private ArrayList<LootEntry> barrows = new ArrayList<LootEntry>();
	private ArrayList<LootEntry> raids = new ArrayList<LootEntry>();

	@Inject
	private LootRecorderOverlay lootRecorderOverlay;

	@Inject
	private LootRecorderConfig lootRecorderConfig;

	@Inject
	private Client client;

	private final Properties properties = new Properties();


	@Provides
	LootRecorderConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LootRecorderConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return lootRecorderOverlay;
	}

	@Override
	protected void startUp()
	{
		LOOTS_DIR.mkdirs();
	}

	// Checks for loot that is rewarded via interfaces
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		// Barrows Chests
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && lootRecorderConfig.recordBarrowsChest())
		{

		}

		// Raids Chest
		if (event.getGroupId() == WidgetID.RAIDS_REWARD_GROUP_ID && lootRecorderConfig.recordRaidsChest())
		{
			
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		// Only update if our plugin config was changed
		if (!event.getGroup().equals("loot-recorder"))
		{
			return;
		}

		// Overlay Toggle
		if (event.getKey().equals("showLootTotals"))
		{
			return;
		}
	}


	// Update KC variables on chat message event
	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMessage = event.getMessage();

		if (chatMessage.startsWith("Your Barrows chest count is"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				barrowsNumber = Integer.valueOf(m.group());
				return;
			}
		}

		// Raids KC
		if (chatMessage.startsWith("Your completed Chambers of Xeric count is:"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				raidsNumber = Integer.valueOf(m.group());
				return;
			}
		}
	}


	// Add Loot Entry to the necessary file
	private void addLootEntry(String fileName, String dataAsString)
	{
		File playerFolder;
		if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
		{
			playerFolder = new File(LOOTS_DIR, client.getLocalPlayer().getName());
		}
		else
		{
			playerFolder = LOOTS_DIR;
		}
		playerFolder.mkdirs();
		File lootFile = new File(playerFolder, fileName);

		try
		{
			final Path path = Paths.get(String.valueOf(lootFile));
			Files.write(path, Arrays.asList(dataAsString), StandardCharsets.UTF_8, Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
		}
		catch (IOException ioe)
		{
			log.warn("Error writting loot data in file.", ioe);
		}
	}

	// Recieve Loot from the necessary file
	private synchronized void loadLootEntries(File file, ArrayList data)
	{
		// Read the loot log line by line
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			Integer kc = 1;
			while ((line = br.readLine()) != null)
			{
				final String[] split = line.split("||", 2);
				if (split.length == 2)
				{
					final String item_name = split[0];
					final Integer item_amount = Integer.parseInt(split[1]);
					data.add(kc, new DropEntry(item_name, item_amount) );
				}
				kc = kc + 1;
			}
		}
		catch (FileNotFoundException e)
			{
			log.warn("File not found");
		}
		catch (IOException e)
		{
			log.warn("Unexpected error", e);
		}
	}


	@VisibleForTesting
	int getBarrowsNumber()
	{
		return barrowsNumber;
	}

	@VisibleForTesting
	int getRaidsNumber()
	{
		return raidsNumber;
	}
}