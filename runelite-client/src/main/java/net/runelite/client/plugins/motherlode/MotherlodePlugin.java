/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.ItemContainer;
import net.runelite.api.Perspective;
import net.runelite.api.ScriptID;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.loottracker.PluginLootReceived;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.loottracker.LootRecordType;

@PluginDescriptor(
	name = "Motherlode Mine",
	description = "Show helpful information inside the Motherlode Mine",
	tags = {"pay", "dirt", "mining", "mlm", "skilling", "overlay"},
	enabledByDefault = false
)
public class MotherlodePlugin extends Plugin
{
	private static final Set<Integer> MOTHERLODE_MAP_REGIONS = ImmutableSet.of(14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193);
	private static final Set<Integer> MINE_SPOTS = ImmutableSet.of(ObjectID.MOTHERLODE_ORE_SINGLE, ObjectID.MOTHERLODE_ORE_LEFT, ObjectID.MOTHERLODE_ORE_MIDDLE, ObjectID.MOTHERLODE_ORE_RIGHT);
	private static final Set<Integer> MLM_ORE_TYPES = ImmutableSet.of(ItemID.RUNITE_ORE, ItemID.ADAMANTITE_ORE,
		ItemID.MITHRIL_ORE, ItemID.GOLD_ORE, ItemID.COAL, ItemID.MOTHERLODE_NUGGET);
	private static final Set<Integer> ROCK_OBSTACLES = ImmutableSet.of(ObjectID.MOTHERLODE_ROCKFALL_1, ObjectID.MOTHERLODE_ROCKFALL_2);

	private static final int SACK_LARGE_SIZE = 189;
	private static final int SACK_SIZE = 108;

	private static final int UPPER_FLOOR_HEIGHT = -490;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MotherlodeSceneOverlay sceneOverlay;

	@Inject
	private MotherlodeConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean inMlm;

	private int curSackSize;

	private boolean shouldUpdateOres;
	private Multiset<Integer> inventorySnapshot;

	@Getter(AccessLevel.PACKAGE)
	private final Set<WallObject> veins = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> rocks = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> brokenStruts = new HashSet<>();

	@Provides
	MotherlodeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MotherlodeConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(sceneOverlay);

		inMlm = checkInMlm();

		if (inMlm)
		{
			clientThread.invokeLater(this::refreshSackValues);
		}
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(sceneOverlay);
		veins.clear();
		rocks.clear();
		brokenStruts.clear();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (inMlm)
		{
			int lastSackValue = curSackSize;
			refreshSackValues();
			shouldUpdateOres = curSackSize < lastSackValue;
			if (shouldUpdateOres)
			{
				// Take a snapshot of the inventory before the new ore is added.
				ItemContainer itemContainer = client.getItemContainer(InventoryID.INV);
				if (itemContainer != null)
				{
					inventorySnapshot = HashMultiset.create();
					Arrays.stream(itemContainer.getItems())
						.filter(item -> MLM_ORE_TYPES.contains(item.getId()))
						.forEach(item -> inventorySnapshot.add(item.getId(), item.getQuantity()));
				}
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!inMlm || event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String chatMessage = event.getMessage();

		switch (chatMessage)
		{

			case "You just found a Diamond!":
				if (config.trackGemsFound())
				{
					broadcastLootItem(ItemID.UNCUT_DIAMOND);
				}
				break;

			case "You just found a Ruby!":
				if (config.trackGemsFound())
				{
					broadcastLootItem(ItemID.UNCUT_RUBY);
				}
				break;

			case "You just found an Emerald!":
				if (config.trackGemsFound())
				{
					broadcastLootItem(ItemID.UNCUT_EMERALD);
				}
				break;

			case "You just found a Sapphire!":
				if (config.trackGemsFound())
				{
					broadcastLootItem(ItemID.UNCUT_SAPPHIRE);
				}
				break;
		}
	}

	private void broadcastLootItem(int itemId)
	{
		var lootEvent = PluginLootReceived.builder()
			.source(this)
			.name("Motherlode Mine")
			.type(LootRecordType.EVENT)
			.items(Collections.singleton(new ItemStack(itemId, 1, client.getLocalPlayer().getLocalLocation())))
			.build();
		eventBus.post(lootEvent);
	}

	@Subscribe
	private void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.MOTHERLODE_HUD_UPDATE)
		{
			recolorSackOverlay();
		}
	}

	private void recolorSackOverlay()
	{
		ItemContainer inv = client.getItemContainer(InventoryID.INV);
		if (inv == null)
		{
			return;
		}

		int sackSize = client.getVarbitValue(VarbitID.MOTHERLODE_SACK_TRANSMIT);
		boolean sackUpgraded = client.getVarbitValue(VarbitID.MOTHERLODE_BIGGERSACK) == 1;
		int sackCapacity = sackUpgraded ? SACK_LARGE_SIZE : SACK_SIZE;
		int payDir = inv.count(ItemID.PAYDIRT);

		Widget sackSizeWidget = client.getWidget(InterfaceID.MotherlodeHud.PAY_DIRT);
		Widget spaceTextWidget = client.getWidget(InterfaceID.MotherlodeHud.DEPOSITS);
		if (sackSizeWidget != null && spaceTextWidget != null)
		{
			if (payDir >= sackCapacity - sackSize)
			{
				sackSizeWidget.setTextColor(0xff0000);
				spaceTextWidget.setTextColor(0xff0000);
			}
			else
			{
				sackSizeWidget.setTextColor(0xc8c8c8);
				spaceTextWidget.setTextColor(0xffffff);
			}
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject wallObject = event.getWallObject();
		if (MINE_SPOTS.contains(wallObject.getId()))
		{
			veins.add(wallObject);
		}
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject wallObject = event.getWallObject();
		veins.remove(wallObject);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!inMlm)
		{
			return;
		}

		addGameObject(event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (!inMlm)
		{
			return;
		}

		removeGameObject(event.getGameObject());
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			// on region changes the tiles get set to null
			veins.clear();
			rocks.clear();
			brokenStruts.clear();

			inMlm = checkInMlm();
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent code from running while logged out.
			inMlm = false;
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		recolorSackOverlay();

		if (!shouldUpdateOres || inventorySnapshot == null || event.getContainerId() != InventoryID.INV)
		{
			return;
		}

		final ItemContainer container = event.getItemContainer();

		// Build set of current inventory
		Multiset<Integer> current = HashMultiset.create();
		Arrays.stream(container.getItems())
			.filter(item -> MLM_ORE_TYPES.contains(item.getId()))
			.forEach(item -> current.add(item.getId(), item.getQuantity()));

		// Take the difference
		Multiset<Integer> delta = Multisets.difference(current, inventorySnapshot);

		// Advertise the loot
		var lootEvent = PluginLootReceived.builder()
			.source(this)
			.name("Motherlode Mine")
			.type(LootRecordType.EVENT)
			.items(delta.entrySet().stream()
				.map(e -> new ItemStack(e.getElement(), e.getCount()))
				.collect(Collectors.toList()))
			.build();
		if (config.trackOresFound())
		{
			eventBus.post(lootEvent);
		}

		inventorySnapshot = null;
		shouldUpdateOres = false;
	}

	private boolean checkInMlm()
	{
		GameState gameState = client.getGameState();
		if (gameState != GameState.LOGGED_IN
			&& gameState != GameState.LOADING)
		{
			return false;
		}

		int[] currentMapRegions = client.getMapRegions();

		// Verify that all regions exist in MOTHERLODE_MAP_REGIONS
		for (int region : currentMapRegions)
		{
			if (!MOTHERLODE_MAP_REGIONS.contains(region))
			{
				return false;
			}
		}

		return true;
	}

	private void refreshSackValues()
	{
		curSackSize = client.getVarbitValue(VarbitID.MOTHERLODE_SACK_TRANSMIT);
	}

	/**
	 * Checks if the given point is "upstairs" in the mlm.
	 * The upper floor is actually on z=0.
	 *
	 * @param localPoint
	 * @return
	 */
	boolean isUpstairs(LocalPoint localPoint)
	{
		return Perspective.getTileHeight(client, localPoint, 0) < UPPER_FLOOR_HEIGHT;
	}

	private void addGameObject(GameObject gameObject)
	{
		if (ROCK_OBSTACLES.contains(gameObject.getId()))
		{
			rocks.add(gameObject);
		}

		if (ObjectID.MOTHERLODE_WHEEL_STRUT_BROKEN == gameObject.getId())
		{
			brokenStruts.add(gameObject);
		}
	}

	private void removeGameObject(GameObject gameObject)
	{
		rocks.remove(gameObject);
		brokenStruts.remove(gameObject);
	}
}
