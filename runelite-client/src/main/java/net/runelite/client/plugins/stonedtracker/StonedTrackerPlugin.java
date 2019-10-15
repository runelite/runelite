/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.stonedtracker;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.NpcID;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.loottracker.localstorage.LTItemEntry;
import net.runelite.client.plugins.loottracker.localstorage.LTRecord;
import net.runelite.client.plugins.loottracker.localstorage.LootRecordWriter;
import net.runelite.client.plugins.loottracker.localstorage.events.LTNameChange;
import net.runelite.client.plugins.loottracker.localstorage.events.LTRecordStored;
import net.runelite.client.plugins.stonedtracker.data.BossTab;
import net.runelite.client.plugins.stonedtracker.data.UniqueItem;
import net.runelite.client.plugins.stonedtracker.ui.LootTrackerPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Stoned Tracker",
	description = "Local data persistence and unique UI for the Loot Tracker.",
	tags = {"Stoned", "Loot", "Tracker"}
)
@Slf4j
public class StonedTrackerPlugin extends Plugin
{
	private static final String SIRE_FONT_TEXT = "you place the unsired into the font of consumption...";
	private static final String SIRE_REWARD_TEXT = "the font consumes the unsired";

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	public StonedTrackerConfig config;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private LootRecordWriter writer;

	@Inject
	private EventBus eventBus;

	private LootTrackerPanel panel;
	private NavigationButton navButton;
	@Getter
	private Set<String> lootNames = new TreeSet<>();

	private boolean loaded = false;
	private boolean unsiredReclaiming = false;

	@Provides
	StonedTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StonedTrackerConfig.class);
	}

	private void onLTRecordStored(final LTRecordStored s)
	{
		final LTRecord record = s.getRecord();
		lootNames.add(record.getName());
		SwingUtilities.invokeLater(() -> panel.addLog(record));
	}

	private void onLTNameChange(final LTNameChange c)
	{
		lootNames = new TreeSet<>(writer.getKnownFileNames());
		SwingUtilities.invokeLater(() -> panel.showSelectionView());
	}

	private void onConfigChanged(final ConfigChanged event)
	{
		if (event.getGroup().equals("stonedtracker"))
		{
			panel.refreshUI();
		}
	}

	@Override
	protected void startUp()
	{
		addSubscriptions();

		panel = new LootTrackerPanel(itemManager, this);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "panel-icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Stoned Tracker")
			.icon(icon)
			.priority(5)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		// Attach necessary info from item manager on load
		if (!loaded)
		{
			loaded = true;
			clientThread.invokeLater(() ->
			{
				switch (client.getGameState())
				{
					case UNKNOWN:
					case STARTING:
						loaded = false;
						return false;
				}

				UniqueItem.prepareUniqueItems(itemManager);
				return true;
			});
		}
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
		clientToolbar.removeNavigation(navButton);
	}

	private void addSubscriptions()
	{
		this.eventBus.subscribe(LTRecordStored.class, this, this::onLTRecordStored);
		this.eventBus.subscribe(LTNameChange.class, this, this::onLTNameChange);
		this.eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		this.eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		this.eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	private void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != WidgetID.DIALOG_SPRITE_GROUP_ID)
		{
			return;
		}

		Widget text = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		if (SIRE_FONT_TEXT.equals(text.getText().toLowerCase()))
		{
			unsiredReclaiming = true;
		}
	}

	private void onGameTick(GameTick t)
	{
		if (unsiredReclaiming)
		{
			checkUnsiredWidget();
		}
	}

	// Handles checking for unsired loot reclamation
	private void checkUnsiredWidget()
	{
		log.info("Checking for text widget change...");
		Widget text = client.getWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
		if (text.getText().toLowerCase().contains(SIRE_REWARD_TEXT))
		{
			unsiredReclaiming = false;
			log.info("Text widget changed, reclaimed an item");
			Widget sprite = client.getWidget(WidgetInfo.DIALOG_SPRITE);
			log.info("Sprite Item ID: {}", sprite.getItemId());
			receivedUnsiredLoot(sprite.getItemId());
		}
		else
		{
			log.info("Old text still...");
		}
	}

	// Handles adding the unsired loot to the tracker
	private void receivedUnsiredLoot(int itemID)
	{
		clientThread.invokeLater(() ->
		{
			Collection<LTRecord> data = getDataByName("Abyssal sire");
			ItemDefinition c = itemManager.getItemDefinition(itemID);
			LTItemEntry itemEntry = new LTItemEntry(c.getName(), itemID, 1, 0);

			log.debug("Received Unsired item: {}", c.getName());

			// Don't have data for sire, create a new record with just this data.
			if (data == null)
			{
				log.debug("No previous Abyssal sire loot, creating new loot record");
				LTRecord r = new LTRecord(NpcID.ABYSSAL_SIRE, "Abyssal sire", 350, -1, Collections.singletonList(itemEntry));
				writer.addLootTrackerRecord(r);
				return;
			}

			log.debug("Adding drop to last abyssal sire loot record");
			// Add data to last kill count
			List<LTRecord> items = new ArrayList<>(data);
			LTRecord r = items.get(items.size() - 1);
			r.addDropEntry(itemEntry);
			writer.writeLootTrackerFile("Abyssal sire", items);
			// Write will trigger event this plugin is subscribed too
		});
	}

	public Collection<LTRecord> getDataByName(String name)
	{
		final BossTab tab = BossTab.getByName(name);
		if (tab != null)
		{
			name = tab.getName();
		}

		return writer.loadLootTrackerRecords(name);
	}

	public boolean clearStoredDataByName(final String name)
	{
		lootNames.remove(name);
		return writer.deleteLootTrackerRecords(name);
	}
}