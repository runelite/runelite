/*
 * Copyright (c) 2018, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.tripchecker;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Skill;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ChatboxInputManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Trip Checker"
)
@Slf4j
public class TripCheckerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private SkillIconManager iconManager;

	@Inject
	private ChatboxInputManager chatboxInputManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private TripCheckerConfig config;

	@Inject
	private TripCheckerOverlay overlay;

	@Getter(AccessLevel.PACKAGE)
	private final HashMap<String, TripItemList> tripLists = new HashMap<>();
	private final Gson gson = new Gson();

	private NavigationButton uiNavigationButton;
	private TripCheckerPanel uiPanel;

	@Getter(AccessLevel.PACKAGE)
	private boolean isMissingItem;
	@Getter(AccessLevel.PACKAGE)
	private List<Item> missingItems = new ArrayList<>();

	@Provides
	TripCheckerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TripCheckerConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Override
	public void startUp()
	{
		loadExistingLists();
		BufferedImage icon = iconManager.getSkillImage(Skill.COMBAT);
		uiPanel = injector.getInstance(TripCheckerPanel.class);
		uiNavigationButton = NavigationButton.builder()
			.tooltip("Trip Checker")
			.icon(icon)
			.priority(10)
			.panel(uiPanel)
			.build();

		pluginToolbar.addNavigation(uiNavigationButton);
	}

	private void loadExistingLists()
	{
		// Search directory
		Type mapType = new TypeToken<HashMap<String, TripItemList>>()
		{

		}.getType();
		try
		{
			HashMap<String, TripItemList> loadedTripLists = gson.fromJson(config.loadouts(), mapType);
			if (loadedTripLists == null || loadedTripLists.isEmpty())
			{
				return;
			}
			for (String key : loadedTripLists.keySet())
			{
				tripLists.put(key, loadedTripLists.get(key));
			}
		}
		catch (JsonSyntaxException ex)
		{
			log.warn("Error loading existing loadouts: {}", ex);
		}
	}

	void copyCurrentItemsToTripList()
	{
		TripItemList itemList = new TripItemList();

		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		chatboxInputManager.openInputWindow("Loadout Name:", "", (name) ->
		{
			ItemContainer inventoryContainer = client.getItemContainer(InventoryID.INVENTORY);
			ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);

			itemList.setInventory(inventoryContainer);
			itemList.setEquipment(equipmentContainer);

			tripLists.put(name, itemList);
			uiPanel.refreshLoadouts();
			saveLoadouts();
		});
	}

	boolean deleteLoadout(String loadoutName)
	{
		if (!tripLists.containsKey(loadoutName))
		{
			return false;
		}

		TripItemList deletedLoadout = tripLists.remove(loadoutName);
		if (deletedLoadout != null)
		{
			//Only save the loadouts if we successfully deleted the loadout
			saveLoadouts();
			return true;
		}

		return false;
	}

	private void saveLoadouts()
	{
		String json = gson.toJson(tripLists);
		config.loadouts(json);
	}

	void checkInventoryAgainstLoadout(String loadoutName)
	{
		TripItemList tripLoadout = tripLists.get(loadoutName);
		if (tripLoadout == null)
		{
			return;
		}

		//Check equipment
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipmentContainer == null)
		{
			return;
		}

		isMissingItem = false;
		missingItems = new ArrayList<>();
		DisplayMode missingItemDisplayMode = config.getNotificationStyle();

		for (int loadoutEquipmentId : tripLoadout.getEquipmentIds())
		{
			if (Arrays.stream(equipmentContainer.getItems()).noneMatch(e -> e.getId() == loadoutEquipmentId))
			{
				//No item
				if (missingItemDisplayMode == DisplayMode.BOTH || missingItemDisplayMode == DisplayMode.CHATBOX)
				{
					client.addChatMessage(ChatMessageType.SERVER, "", "<col=FF0000>Missing " + itemManager.getItemComposition(loadoutEquipmentId).getName(), null);
				}
				if (missingItemDisplayMode == DisplayMode.BOTH || missingItemDisplayMode == DisplayMode.PANEL)
				{
					Item item = client.createItem();
					item.setId(loadoutEquipmentId);
					item.setQuantity(1);
					missingItems.add(item);
				}
				isMissingItem = true;
			}
		}

		//Check inventory
		ItemContainer inventoryContainer = client.getItemContainer(InventoryID.INVENTORY);
		if (inventoryContainer == null)
		{
			return;
		}

		for (Integer loadoutInventoryId : tripLoadout.getInventoryItems().keySet())
		{
			int expectedQuantity = tripLoadout.getInventoryItems().get(loadoutInventoryId);
			int quantityInInventory = 0;
			for (Item i : inventoryContainer.getItems())
			{
				if (i.getId() == loadoutInventoryId)
				{
					quantityInInventory++;
				}
			}
			if (quantityInInventory != expectedQuantity)
			{
				int delta = expectedQuantity - quantityInInventory;
				if (missingItemDisplayMode == DisplayMode.BOTH || missingItemDisplayMode == DisplayMode.CHATBOX)
				{
					client.addChatMessage(ChatMessageType.SERVER, "", "<col=FF0000>Missing " + delta + " " + itemManager.getItemComposition(loadoutInventoryId).getName(), null);
				}
				if (missingItemDisplayMode == DisplayMode.BOTH || missingItemDisplayMode == DisplayMode.PANEL)
				{
					Item item = client.createItem();
					item.setId(loadoutInventoryId);
					item.setQuantity(delta);
					missingItems.add(item);
				}
				isMissingItem = true;
			}
		}

		if (!isMissingItem)
		{
			client.addChatMessage(ChatMessageType.SERVER, "", "<col=FF0000>No items missing!", null);
		}
	}
}
