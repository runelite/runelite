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

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.Text;
import net.runelite.http.api.RuneLiteAPI;

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

	@Inject
	private ItemManager itemManager;

	private LootRecorderPanel panel;

	private NavigationButton navButton;

	private PluginToolbar pluginToolbar;


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
	protected void startUp() throws IOException
	{
		LOOTS_DIR.mkdirs();
		panel = injector.getInstance(LootRecorderPanel.class);

		BufferedImage icon = null;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("ge_icon.png"));
		}
		panel = new LootRecorderPanel(client, itemManager);
		navButton = NavigationButton.builder()
			.name("Loot Recorder")
			.icon(icon)
			.panel(panel)
			.build();

		pluginToolbar.addNavigation(navButton);
	}

	// Checks for loot that is rewarded via interfaces
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		// Barrows Chests
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && lootRecorderConfig.recordBarrowsChest())
		{
			ItemContainer rewardContainer = client.getItemContainer(InventoryID.BARROWS_REWARD);
			LootEntry entry = createLootEntry(barrowsNumber, rewardContainer);
			barrows.add(entry);
			addLootEntry(barrowsFilename, entry);
			log.info("Recorded a barrows chest!");
			log.info("Entry:", entry);
		}

		// Raids Chest
		if (event.getGroupId() == WidgetID.RAIDS_REWARD_GROUP_ID && lootRecorderConfig.recordRaidsChest())
		{
			ItemContainer rewardContainer = client.getItemContainer(InventoryID.valueOf("RAIDS_REWARD_GROUP_ID")); // TODO: Update to RAIDS REWARD ONCE implemented
			LootEntry entry = createLootEntry(raidsNumber, rewardContainer);
			raids.add(entry);
			addLootEntry(raidsFilename, entry);
			log.info("Recorded a raids chest!");
			log.info("Entry:", entry);
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
			loadLootEntries(barrowsFilename, barrows);
			loadLootEntries(raidsFilename, raids);
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

	private LootEntry createLootEntry(Integer kill_count, ItemContainer container)
	{
		ArrayList<DropEntry> drops = new ArrayList<>();
		for (Item item : container.getItems())
		{
			int id = item.getId();
			int amount = item.getQuantity();
			drops.add(new DropEntry(id, amount));
		}
		return new LootEntry(kill_count, drops);
	}


	// Add Loot Entry to the necessary file
	private void addLootEntry(String fileName, LootEntry entry)
	{
		String dataAsString = RuneLiteAPI.GSON.toJson(entry);
		log.info(dataAsString);

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
			log.warn("Error witting loot data in file.", ioe);
		}
	}

	// Receive Loot from the necessary file
	private synchronized void loadLootEntries(String fileName, ArrayList data)
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
		File file = new File(playerFolder, fileName);

		// Read the loot log line by line
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				// Read the data from each line
				LootEntry entry = RuneLiteAPI.GSON.fromJson(line, LootEntry.class);
				data.add(entry);
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
		log.info("Loaded Data:");
		log.info(String.valueOf(data));
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