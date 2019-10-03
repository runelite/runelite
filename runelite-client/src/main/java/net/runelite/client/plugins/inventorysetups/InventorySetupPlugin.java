/*
 * Copyright (c) 2018-2019, Ethan <https://github.com/Wea1thRS/>
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.inventorysetups;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemDefinition;
import net.runelite.api.ItemContainer;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.inventorysetups.ui.InventorySetupPluginPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Inventory Setups",
	description = "Save inventory setups",
	tags = {"items", "inventory", "setups"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)

@Slf4j
@Singleton
public class InventorySetupPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "inventorysetups";
	private static final String CONFIG_KEY = "setups";
	private static final int NUM_INVENTORY_ITEMS = 28;
	private static final int NUM_EQUIPMENT_ITEMS = 14;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InventorySetupBankOverlay overlay;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private InventorySetupConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	@Inject
	private ConfigManager configManager;

	private InventorySetupPluginPanel panel;

	private final Map<String, InventorySetup> inventorySetups = new HashMap<>();

	private NavigationButton navButton;

	private boolean highlightDifference;

	private boolean getHighlightDifferences;
	@Getter(AccessLevel.PUBLIC)
	private Color getHighlightColor;
	@Getter(AccessLevel.PUBLIC)
	private boolean getStackDifference;
	@Getter(AccessLevel.PUBLIC)
	private boolean getVariationDifference;
	@Getter(AccessLevel.PACKAGE)
	private boolean getBankHighlight;
	@Getter(AccessLevel.PACKAGE)
	private Color getBankHighlightColor;

	@Override
	public void startUp()
	{
		updateConfigOptions();
		addSubscriptions();

		overlayManager.add(overlay);

		panel = new InventorySetupPluginPanel(this, itemManager);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "inventorysetups_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Inventory Setups")
			.icon(icon)
			.priority(9)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);

		// load all the inventory setups from the config file
		clientThread.invokeLater(() ->
		{
			if (client.getGameState() != GameState.LOGIN_SCREEN)
			{
				return false;
			}

			loadConfig();
			panel.showNoSetupsPanel();
			return true;
		});

	}

	public void addInventorySetup()
	{
		final String name = JOptionPane.showInputDialog(panel,
			"Enter the name of this setup.",
			"Add New Setup",
			JOptionPane.PLAIN_MESSAGE);

		// cancel button was clicked
		if (name == null)
		{
			return;
		}

		if (name.isEmpty())
		{
			JOptionPane.showMessageDialog(panel,
				"Invalid Setup Name",
				"Names must not be empty.",
				JOptionPane.PLAIN_MESSAGE);
			return;
		}

		if (inventorySetups.containsKey(name))
		{
			String builder = "The setup " + name + " already exists. " +
				"Would you like to replace it with the current setup?";
			int confirm = JOptionPane.showConfirmDialog(panel,
				builder,
				"Warning",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

			if (confirm == JOptionPane.CANCEL_OPTION)
			{
				return;
			}

			// delete the old setup, no need to ask for confirmation
			// because the user confirmed above
			removeInventorySetup(name, false);
		}

		clientThread.invoke(() ->
		{
			List<InventorySetupItem> inv = getNormalizedContainer(InventoryID.INVENTORY);
			List<InventorySetupItem> eqp = getNormalizedContainer(InventoryID.EQUIPMENT);

			final InventorySetup invSetup = new InventorySetup(inv, eqp);
			SwingUtilities.invokeLater(() ->
			{
				inventorySetups.put(name, invSetup);
				panel.addInventorySetup(name);
				panel.setCurrentInventorySetup(name);

				updateConfig();
			});
		});
	}

	public void removeInventorySetup(final String name, boolean askForConfirmation)
	{
		if (inventorySetups.containsKey(name))
		{
			int confirm = JOptionPane.YES_OPTION;

			if (askForConfirmation)
			{
				confirm = JOptionPane.showConfirmDialog(panel,
					"Are you sure you want to remove this setup?",
					"Warning",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE);
			}

			if (confirm == JOptionPane.YES_OPTION)
			{
				inventorySetups.remove(name);
				panel.removeInventorySetup(name);
			}

			updateConfig();
		}
	}

	public final InventorySetup getInventorySetup(final String name)
	{
		return inventorySetups.get(name);
	}

	@Provides
	InventorySetupConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InventorySetupConfig.class);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP))
		{
			updateConfigOptions();
			// only allow highlighting if the config is enabled and the player is logged in
			highlightDifference = this.getHighlightDifferences && client.getGameState() == GameState.LOGGED_IN;
			final String setupName = panel.getSelectedInventorySetup();
			if (highlightDifference && !setupName.isEmpty())
			{
				panel.setCurrentInventorySetup(setupName);
			}
		}
	}

	private void updateConfig()
	{
		if (inventorySetups.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_KEY);
			return;
		}

		final Gson gson = new Gson();
		final String json = gson.toJson(inventorySetups);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, json);
	}

	private void loadConfig()
	{
		// serialize the internal data structure from the json in the configuration
		final String json = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY);
		if (json == null || json.isEmpty())
		{
			inventorySetups.clear();
		}
		else
		{
			// TODO add last resort?, serialize exception just make empty map
			final Gson gson = new Gson();
			Type type = new TypeToken<HashMap<String, InventorySetup>>()
			{

			}.getType();
			inventorySetups.clear();
			inventorySetups.putAll(gson.fromJson(json, type));
		}

		for (final String key : inventorySetups.keySet())
		{
			panel.addInventorySetup(key);
		}

	}

	private void onItemContainerChanged(ItemContainerChanged event)
	{

		if (!highlightDifference || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// empty entry, no need to compare anything
		final String selectedInventorySetup = panel.getSelectedInventorySetup();
		if (selectedInventorySetup.isEmpty())
		{
			return;
		}

		// check to see that the container is the equipment or inventory
		ItemContainer container = event.getItemContainer();

		if (container == client.getItemContainer(InventoryID.INVENTORY))
		{
			List<InventorySetupItem> normContainer = getNormalizedContainer(InventoryID.INVENTORY);
			final InventorySetup setup = inventorySetups.get(selectedInventorySetup);
			panel.highlightDifferences(normContainer, setup, InventoryID.INVENTORY);
		}
		else if (container == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			List<InventorySetupItem> normContainer = getNormalizedContainer(InventoryID.EQUIPMENT);
			final InventorySetup setup = inventorySetups.get(selectedInventorySetup);
			panel.highlightDifferences(normContainer, setup, InventoryID.EQUIPMENT);
		}

	}

	private void onGameStateChanged(GameStateChanged event)
	{
		switch (event.getGameState())
		{
			// set the highlighting off if login screen shows up
			case LOGIN_SCREEN:
				highlightDifference = false;
				break;

			// set highlighting
			case LOGGED_IN:
				highlightDifference = this.getHighlightDifferences;
				break;

			default:
				return;
		}

		if (panel == null)
		{
			return;
		}
		
		final String setupName = panel.getSelectedInventorySetup();
		if (!setupName.isEmpty())
		{
			panel.setCurrentInventorySetup(setupName);
		}
	}

	public List<InventorySetupItem> getNormalizedContainer(final InventoryID id)
	{
		assert id == InventoryID.INVENTORY || id == InventoryID.EQUIPMENT : "invalid inventory ID";

		final ItemContainer container = client.getItemContainer(id);

		List<InventorySetupItem> newContainer = new ArrayList<>();

		Item[] items = null;
		if (container != null)
		{
			items = container.getItems();
		}

		int size = id == InventoryID.INVENTORY ? NUM_INVENTORY_ITEMS : NUM_EQUIPMENT_ITEMS;

		for (int i = 0; i < size; i++)
		{
			if (items == null || i >= items.length)
			{
				newContainer.add(new InventorySetupItem(-1, "", 0));
			}
			else
			{
				final Item item = items[i];
				String itemName = "";
				if (client.isClientThread())
				{
					itemName = itemManager.getItemDefinition(item.getId()).getName();
				}
				newContainer.add(new InventorySetupItem(item.getId(), itemName, item.getQuantity()));
			}
		}

		return newContainer;
	}

	public final InventorySetupConfig getConfig()
	{
		return config;
	}

	public boolean getHighlightDifference()
	{
		return highlightDifference;
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);
		overlayManager.remove(overlay);
		clientToolbar.removeNavigation(navButton);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
	}

	final int[] getCurrentInventorySetupIds()
	{
		InventorySetup setup = inventorySetups.get(panel.getSelectedInventorySetup());
		if (setup == null)
		{
			return null;
		}
		ArrayList<InventorySetupItem> items = new ArrayList<>();
		items.addAll(setup.getEquipment());
		items.addAll(setup.getInventory());
		ArrayList<Integer> itemIds = new ArrayList<>();
		for (InventorySetupItem item : items)
		{
			int id = item.getId();
			ItemDefinition itemComposition = itemManager.getItemDefinition(id);
			if (id > 0)
			{
				itemIds.add(ItemVariationMapping.map(id));
				itemIds.add(itemComposition.getPlaceholderId());
			}

		}
		return itemIds.stream()
			.mapToInt(i -> i)
			.filter(Objects::nonNull)
			.filter(id -> id != -1)
			.toArray();
	}

	private void updateConfigOptions()
	{
		this.getHighlightDifferences = config.getHighlightDifferences();
		this.getHighlightColor = config.getHighlightColor();
		this.getStackDifference = config.getHighlightDifferences();
		this.getVariationDifference = config.getVariationDifference();
		this.getBankHighlight = config.getBankHighlight();
		this.getBankHighlightColor = config.getBankHighlightColor();
	}
}