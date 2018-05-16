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

import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import static net.runelite.api.ObjectID.ROCKFALL;
import static net.runelite.api.ObjectID.ROCKFALL_26680;
import net.runelite.api.Perspective;
import net.runelite.api.Varbits;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Motherlode Mine",
	enabledByDefault = false
)
public class MotherlodePlugin extends Plugin
{
	private static final Set<Integer> MOTHERLODE_MAP_REGIONS = ImmutableSet.of(14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193);
	private static final Set<Integer> MINE_SPOTS = ImmutableSet.of(ORE_VEIN_26661, ORE_VEIN_26662, ORE_VEIN_26663, ORE_VEIN_26664);
	private static final Set<Integer> MLM_ORE_TYPES = ImmutableSet.of(ItemID.RUNITE_ORE, ItemID.ADAMANTITE_ORE,
			ItemID.MITHRIL_ORE, ItemID.GOLD_ORE, ItemID.COAL, ItemID.GOLDEN_NUGGET);
	private static final Set<Integer> ROCK_OBSTACLES = ImmutableSet.of(ROCKFALL, ROCKFALL_26680);

	private static final int SACK_LARGE_SIZE = 162;
	private static final int SACK_SIZE = 81;

	private static final int UPPER_FLOOR_HEIGHT = -500;

	private static final int EMPTY_INVENTORY_SPACE = -1;

	@Inject
	private MotherlodeOverlay overlay;

	@Inject
	private MotherlodeRocksOverlay rocksOverlay;

	@Inject
	private MotherlodeSackOverlay motherlodeSackOverlay;

	@Inject
	private MotherlodeGemOverlay motherlodeGemOverlay;

	@Inject
	private MotherlodeOreOverlay motherlodeOreOverlay;

	@Inject
	private MotherlodeConfig config;

	@Inject
	private Client client;

	@Getter(AccessLevel.PACKAGE)
	private boolean inMlm;

	private Item[] currentInventory;
	private ArrayList<Item> previousInventory = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private int prevSackSize;
	@Getter(AccessLevel.PACKAGE)
	private int curSackSize;
	@Getter(AccessLevel.PACKAGE)
	private int maxSackSize;
	@Getter(AccessLevel.PACKAGE)
	private Integer depositsLeft;

	private final MotherlodeSession session = new MotherlodeSession();

	@Getter(AccessLevel.PACKAGE)
	private final Set<WallObject> veins = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> rocks = new HashSet<>();

	@Provides
	MotherlodeConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MotherlodeConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, rocksOverlay, motherlodeSackOverlay, motherlodeGemOverlay, motherlodeOreOverlay);
	}

	@Override
	protected void startUp()
	{
		inMlm = checkInMlm();
	}

	@Override
	protected void shutDown() throws Exception
	{
		veins.clear();
		rocks.clear();
	}

	public MotherlodeSession getSession()
	{
		return session;
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY) || !inMlm)
		{
			return;
		}

		// Clear previous inventory items
		previousInventory.clear();

		if (currentInventory != null)
		{
			// Copy current inventory items over to previous inventory
			previousInventory.addAll(Arrays.asList(currentInventory));
		}
		else
		{
			// NullPointerExceptions were being raised after logon and emptying the sack.
			// This ensures that previousInventory contains the current inventory structure in those cases,
			// so ores are counted correctly if client is restarted and a user logs on and empties the sack
			// before ItemContainerChanged event fires twice.
			previousInventory.addAll(Arrays.asList(event.getItemContainer().getItems()));
		}

		currentInventory = event.getItemContainer().getItems();

		boolean sackValueDecreasing = prevSackSize > curSackSize;

		// Check whether sackValueDecreasing is false, as we will only count ores collected when the sack
		// is decreasing.

		if (previousInventory.size() <= 0 || !sackValueDecreasing)
		{
			return;
		}

		for (int i = 0; i < currentInventory.length; i++)
		{
			Item item = currentInventory[i];

			// Fetch previous item id and quantity from the previous inventory index
			int previousItemId = previousInventory.get(i).getId();
			int previousItemQty = previousInventory.get(i).getQuantity();

			// Verify that it's a new item before ores are counted to prevent false counts.
			// Examples of this are when you empty the sack, fill coal sack then empty the sack again.
			//
			// Another example is with golden nuggets (being the only stackable item you can receive).
			// If you deposit pay-dirt into the hopper, empty sack (before it has reached the sack),
			// then once it has reached the sack again there is a chance you will receive golden nuggets again.
			boolean isNewItem =
					previousItemId == EMPTY_INVENTORY_SPACE
							|| (previousItemId == ItemID.GOLDEN_NUGGET && (item.getQuantity() > previousItemQty))
							&& item.getId() != EMPTY_INVENTORY_SPACE;

			if (!isNewItem)
			{
				continue;
			}

			// Calculate nuggetAmount, account for above statement where it's possible to receive nuggets
			// twice in one inventory.
			int nuggetAmount =
					item.getId() == ItemID.GOLDEN_NUGGET && previousItemId == ItemID.GOLDEN_NUGGET ?
							item.getQuantity() - previousItemQty : item.getQuantity();

			switch (item.getId())
			{
				case ItemID.RUNITE_ORE:
					session.incrementCollected(ItemID.RUNITE_ORE);
					break;

				case ItemID.ADAMANTITE_ORE:
					session.incrementCollected(ItemID.ADAMANTITE_ORE);
					break;

				case ItemID.MITHRIL_ORE:
					session.incrementCollected(ItemID.MITHRIL_ORE);
					break;

				case ItemID.GOLD_ORE:
					session.incrementCollected(ItemID.GOLD_ORE);
					break;

				case ItemID.COAL:
					session.incrementCollected(ItemID.COAL);
					break;

				case ItemID.GOLDEN_NUGGET:
					session.incrementCollected(ItemID.GOLDEN_NUGGET, nuggetAmount);
					break;
			}
		}

		// Update sack values for next ItemContainerChanged event
		prevSackSize = curSackSize;
		curSackSize = client.getVar(Varbits.SACK_NUMBER);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		prevSackSize = curSackSize;
		curSackSize = client.getVar(Varbits.SACK_NUMBER);

		/*
		 * Reason why it's done like this is because the ore counter checks whether the sack
		 * is decreasing. This is done with curSackSize and prevSack being equal,
		 * and as soon as the sack is emptied the Varbit and Inventory event happens (Varbit first),
		 * where the Varbit event sets sackValueDecreasing to prevSackSize > curSackSize.
		 *
		 * If these are not made equal and a player deposits ores into the hopper, the sack will not be decreasing
		 * for the first search which means a player can withdraw ores from their bank,
		 * which will count towards the number of ores collected.
		 */

		if (curSackSize > prevSackSize)
		{
			prevSackSize = curSackSize;
		}

		boolean sackUpgraded = client.getVar(Varbits.SACK_UPGRADED) == 1;
		maxSackSize = sackUpgraded ? SACK_LARGE_SIZE : SACK_SIZE;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!inMlm || event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMessage = event.getMessage();

		switch (chatMessage)
		{
			case "You manage to mine some pay-dirt.":
				session.incrementPayDirtMined();
				break;

			case "You just found a Diamond!":
				session.incrementGemFound(ItemID.UNCUT_DIAMOND);
				break;

			case "You just found a Ruby!":
				session.incrementGemFound(ItemID.UNCUT_RUBY);
				break;

			case "You just found an Emerald!":
				session.incrementGemFound(ItemID.UNCUT_EMERALD);
				break;

			case "You just found a Sapphire!":
				session.incrementGemFound(ItemID.UNCUT_SAPPHIRE);
				break;
		}
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void checkMining()
	{
		if (!inMlm)
		{
			return;
		}

		depositsLeft = calculateDepositsLeft();

		Instant lastPayDirtMined = session.getLastPayDirtMined();
		if (lastPayDirtMined == null)
		{
			return;
		}

		// reset recentPayDirtMined if you haven't mined anything recently
		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceMined = Duration.between(lastPayDirtMined, Instant.now());

		if (sinceMined.compareTo(statTimeout) >= 0)
		{
			session.resetRecent();
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
	public void onWallObjectChanged(WallObjectChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		WallObject previous = event.getPrevious();
		WallObject wallObject = event.getWallObject();

		veins.remove(previous);
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

		GameObject gameObject = event.getGameObject();
		if (ROCK_OBSTACLES.contains(gameObject.getId()))
		{
			rocks.add(gameObject);
		}
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		if (!inMlm)
		{
			return;
		}

		GameObject previous = event.getPrevious();
		GameObject gameObject = event.getGameObject();

		rocks.remove(previous);
		if (ROCK_OBSTACLES.contains(gameObject.getId()))
		{
			rocks.add(gameObject);
		}

	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (!inMlm)
		{
			return;
		}

		GameObject gameObject = event.getGameObject();
		rocks.remove(gameObject);
	}

	@Subscribe
	public void onRegionChanged(MapRegionChanged event)
	{
		inMlm = checkInMlm();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			// on region changes the tiles get set to null
			veins.clear();
			rocks.clear();
		}
		else if (event.getGameState() == GameState.LOGGED_IN)
		{
			inMlm = checkInMlm();
		}
	}

	private Integer calculateDepositsLeft()
	{
		if (maxSackSize == 0) // check if maxSackSize has been initialized
		{
			return null;
		}

		double depositsLeft = 0;
		int nonPayDirtItems = 0;

		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		if (inventory == null)
		{
			return null;
		}

		Item[] result = inventory.getItems();
		assert result != null;

		int inventorySize = result.length;

		for (Item item : result)
		{
			// Assume that MLM ores are being banked and exclude them from the check,
			// so the user doesn't see the Overlay switch between deposits left and N/A.
			//
			// Count other items at nonPayDirtItems so depositsLeft is calculated accordingly.
			if (item.getId() != ItemID.PAYDIRT && item.getId() != EMPTY_INVENTORY_SPACE && !MLM_ORE_TYPES.contains(item.getId()))
			{
				nonPayDirtItems += 1;
			}
		}

		double inventorySpace = inventorySize - nonPayDirtItems;
		double sackSizeRemaining = maxSackSize - curSackSize;

		if (inventorySpace > 0 && sackSizeRemaining > 0)
		{
			depositsLeft = Math.ceil(sackSizeRemaining / inventorySpace);
		}
		else if (inventorySpace == 0)
		{
			return null;
		}

		return (int) depositsLeft;
	}

	private boolean checkInMlm()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
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

	/**
	 * Checks if the given point is "upstairs" in the mlm.
	 * The upper floor is actually on z=0.
	 * @param localPoint
	 * @return
	 */
	boolean isUpstairs(LocalPoint localPoint)
	{
		return Perspective.getTileHeight(client, localPoint.getX(), localPoint.getY(), 0) < UPPER_FLOOR_HEIGHT;
	}
}
