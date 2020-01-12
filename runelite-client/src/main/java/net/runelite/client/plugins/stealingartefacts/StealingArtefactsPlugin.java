/*
 * Copyright (c) 2020, Dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.stealingartefacts;

import com.google.inject.Provides;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.HintArrowType;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.util.Text;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

@PluginDescriptor(
	name = "Stealing Artefacts",
	description = "A plugin for the Stealing Artefacts minigame.",
	tags = {"stealing", "artefacts", "artifacts", "thieving", "minigame", "zeah"},
	type = PluginType.MINIGAME,
	enabledByDefault = false
)
@Slf4j
@Singleton
public class StealingArtefactsPlugin extends Plugin
{
	private static final String HOUSE_TEXT = "^You need to recover an artefact for me\\. It can be found in the " +
		"([a-zA-Z\\-]+) house in the residential district over on the west side of town\\.$";

	private static final String HOUSE_TEXT_PREFIX = HOUSE_TEXT.substring(1, 31);

	private static final Pattern HOUSE_TEXT_PATTERN = Pattern.compile(HOUSE_TEXT);

	private static final String CONFIG_GROUP_NAME = "stealingartefacts";

	private static final String CONFIG_ITEM_NAME_INFOBOX = "houseInfoBox";

	private static final String CONFIG_ITEM_NAME_HINT_ARROW = "displayHintArrow";

	private static final String NPC_NAME_CAPTAIN_KHALED = "Captain Khaled";

	private static final Set<Integer> REGION_IDS = Set.of(
		6970, 6971, 7226, 7227
	);

	private static final int REGION_ID_HOUSE = 6970;

	private static final int REGION_ID_CAPTAIN_KHALED = 7226;

	private static final Set<Integer> ARTEFACTS = Set.of(
		ItemID.STOLEN_PENDANT,
		ItemID.STOLEN_GARNET_RING,
		ItemID.STOLEN_CIRCLET,
		ItemID.STOLEN_FAMILY_HEIRLOOM,
		ItemID.STOLEN_JEWELRY_BOX
	);

	private boolean displayHouseInfoBox = false;

	private boolean displayHintArrow = false;

	@Getter(AccessLevel.PACKAGE)
	private StealingArtefactsHouse stealingArtefactsHouse = StealingArtefactsHouse.CAPTAIN_KHALED;

	private StealingArtefactsInfoBox stealingArtefactsInfoBox;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private StealingArtefactsConfig stealingArtefactsConfig;

	@Provides
	StealingArtefactsConfig getStealingArtefactsConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StealingArtefactsConfig.class);
	}

	@Override
	protected void startUp()
	{
		initConfig();

		if (displayHouseInfoBox)
		{
			addHouseInfoBox();
		}
		else
		{
			removeHouseInfoBox();
		}

		removeWorldMapPoint();
		removeHintArrow();

		if (displayHintArrow)
		{
			addWorldMapPoint();
			addHintArrow();
		}
	}

	@Override
	protected void shutDown()
	{
		resetHouse();
		removeHouseInfoBox();
		removeWorldMapPoint();
		removeHintArrow();
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP_NAME))
		{
			initConfig();

			switch (event.getKey())
			{
				case CONFIG_ITEM_NAME_INFOBOX:
					if (displayHouseInfoBox)
					{
						addHouseInfoBox();
					}
					else
					{
						removeHouseInfoBox();
					}
					break;
				case CONFIG_ITEM_NAME_HINT_ARROW:
					removeWorldMapPoint();
					removeHintArrow();

					if (displayHintArrow)
					{
						addWorldMapPoint();
						addHintArrow();
					}
					break;
				default:
					break;
			}
		}
	}

	@Subscribe
	private void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (isConfigSettingEnabled() &&
			widgetLoaded.getGroupId() == WidgetID.DIALOG_NPC_GROUP_ID &&
			isPlayerInRegion(REGION_ID_CAPTAIN_KHALED))
		{
			clientThread.invokeLater(this::updateStealingArtefactsHouse);
		}
	}

	@Subscribe
	private void onItemContainerChanged(ItemContainerChanged event)
	{
		if (isConfigSettingEnabled() &&
			!stealingArtefactsHouse.equals(StealingArtefactsHouse.CAPTAIN_KHALED) &&
			event.getContainerId() == InventoryID.INVENTORY.getId() &&
			isPlayerInRegion(REGION_ID_HOUSE) &&
			containsArtefact(event.getItemContainer()))
		{
			resetHouse();
			removeWorldMapPoint();
			removeHintArrow();

			if (displayHintArrow)
			{
				addWorldMapPoint();
				addHintArrow();
			}
		}
	}

	@Subscribe
	private void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();

		if (displayHintArrow &&
			Objects.equals(npc.getName(), NPC_NAME_CAPTAIN_KHALED) &&
			stealingArtefactsHouse.equals(StealingArtefactsHouse.CAPTAIN_KHALED) &&
			!client.getHintArrowType().equals(HintArrowType.NPC))
		{
			removeHintArrow();
			client.setHintArrow(npc);
		}
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event)
	{
		if (displayHintArrow && event.getGameState().equals(GameState.LOGGED_IN))
		{
			removeWorldMapPoint();
			removeHintArrow();
			addWorldMapPoint();
			addHintArrow();
		}
	}

	private void initConfig()
	{
		displayHouseInfoBox = stealingArtefactsConfig.displayHouseInfoBox();
		displayHintArrow = stealingArtefactsConfig.displayHintArrow();
	}

	/**
	 * Parses any existing npc dialog widget text and updates the artefact house and hint arrows if applicable.
	 */
	private void updateStealingArtefactsHouse()
	{
		Widget widgetDialogNpcText = client.getWidget(WidgetInfo.DIALOG_NPC_TEXT);

		if (widgetDialogNpcText == null)
		{
			return;
		}

		String text = widgetDialogNpcText.getText();

		if (!text.startsWith(HOUSE_TEXT_PREFIX))
		{
			return;
		}

		StealingArtefactsHouse stealingArtefactsHouse =
			getStealingArtefactsHouseFromNpcDialogText(Text.sanitizeMultilineText(text));

		if (stealingArtefactsHouse == null)
		{
			return;
		}

		this.stealingArtefactsHouse = stealingArtefactsHouse;

		removeWorldMapPoint();
		removeHintArrow();

		if (displayHintArrow)
		{
			addWorldMapPoint();
			addHintArrow();
		}
	}

	private StealingArtefactsHouse getStealingArtefactsHouseFromNpcDialogText(String text)
	{
		StealingArtefactsHouse stealingArtefactsHouse = null;

		Matcher matcher = HOUSE_TEXT_PATTERN.matcher(text);

		if (matcher.find())
		{
			String houseName = matcher.group(1);

			try
			{
				stealingArtefactsHouse = StealingArtefactsHouse.fromName(houseName);
			}
			catch (IllegalArgumentException e)
			{
				log.debug("Unsupported StealingArtefactsHouse name: {}", houseName);
			}
		}

		return stealingArtefactsHouse;
	}

	private boolean containsArtefact(ItemContainer itemContainer)
	{
		boolean containsArtefact = false;

		for (Item item : itemContainer.getItems())
		{
			int itemId = item.getId();

			if (ARTEFACTS.contains(itemId))
			{
				containsArtefact = true;
				break;
			}
		}

		return containsArtefact;
	}

	private void addHouseInfoBox()
	{
		if (stealingArtefactsInfoBox == null)
		{
			stealingArtefactsInfoBox = new StealingArtefactsInfoBox(itemManager.getImage(ItemID.HAIR_CLIP), this);
			infoBoxManager.addInfoBox(stealingArtefactsInfoBox);
		}
	}

	private void removeHouseInfoBox()
	{
		if (stealingArtefactsInfoBox != null)
		{
			infoBoxManager.removeInfoBox(stealingArtefactsInfoBox);
			stealingArtefactsInfoBox = null;
		}
	}

	private void addHintArrow()
	{
		if (stealingArtefactsHouse == StealingArtefactsHouse.CAPTAIN_KHALED)
		{
			for (NPC npc : client.getCachedNPCs())
			{
				if (npc == null)
				{
					continue;
				}

				if (Objects.equals(npc.getName(), NPC_NAME_CAPTAIN_KHALED))
				{
					client.setHintArrow(npc);
					return;
				}
			}
		}

		client.setHintArrow(stealingArtefactsHouse.getWorldPoint());
	}

	private void removeHintArrow()
	{
		if (client.hasHintArrow())
		{
			client.clearHintArrow();
		}
	}

	private void addWorldMapPoint()
	{
		if (isPlayerInStealingArtefactsRegion())
		{
			StealingArtefactsWorldMapPoint stealingArtefactsWorldMapPoint =
				new StealingArtefactsWorldMapPoint(stealingArtefactsHouse.getWorldPoint(),
					itemManager.getImage(ItemID.HAIR_CLIP));

			stealingArtefactsWorldMapPoint.setTooltip(stealingArtefactsHouse.toString());

			worldMapPointManager.add(stealingArtefactsWorldMapPoint);
		}
	}

	private void removeWorldMapPoint()
	{
		worldMapPointManager.removeIf(StealingArtefactsWorldMapPoint.class::isInstance);
	}

	private boolean isPlayerInStealingArtefactsRegion()
	{
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return false;
		}

		WorldPoint worldPoint = player.getWorldLocation();

		if (worldPoint == null)
		{
			return false;
		}

		return REGION_IDS.contains(worldPoint.getRegionID());
	}

	private boolean isPlayerInRegion(int regionId)
	{
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			return false;
		}

		WorldPoint worldPoint = player.getWorldLocation();

		if (worldPoint == null)
		{
			return false;
		}

		return worldPoint.getRegionID() == regionId;
	}

	private boolean isConfigSettingEnabled()
	{
		return displayHouseInfoBox || displayHintArrow;
	}

	private void resetHouse()
	{
		stealingArtefactsHouse = StealingArtefactsHouse.CAPTAIN_KHALED;
	}
}
