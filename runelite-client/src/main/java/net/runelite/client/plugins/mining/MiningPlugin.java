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
package net.runelite.client.plugins.mining;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.mining.MiningConfig;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

import static net.runelite.api.ObjectID.*;

@PluginDescriptor(
	name = "Mining",
	description = "Show helpful information about Mining",
	tags = {"mining", "skilling", "overlay"},
	enabledByDefault = false
)
public class MiningPlugin extends Plugin
{
	private static final Set<Integer> MOTHERLODE_MAP_REGIONS = ImmutableSet.of(14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193);
	private static final Set<Integer> MINE_SPOTS = ImmutableSet.of(ORE_VEIN_26661, ORE_VEIN_26662, ORE_VEIN_26663, ORE_VEIN_26664);
	private static final Set<Integer> MLM_ORE_TYPES = ImmutableSet.of(ItemID.RUNITE_ORE, ItemID.ADAMANTITE_ORE,
			ItemID.MITHRIL_ORE, ItemID.GOLD_ORE, ItemID.COAL, ItemID.GOLDEN_NUGGET);
	private static final Set<Integer> MINING_ROCKS = ImmutableSet.of(968,
			1480,
			1855,
			4043,
			4487,
			7533,
			9716,
			21250, 1997, 2581, 2582, 2694, 2695, 2696, 2697, 2835, 2836, 2837, 2901, 2965, 3339, 3364, 4526, 4552, 4553, 4554, 4555, 4556, 4557, 4558, 4887, 5604, 5605, 5606, 5844, 5845, 5896, 5985, 5987, 6622, 6623, 6707, 6708, 6709, 7466, 8725, 8726, 8950, 8951, 8952, 9031, 9032, 10036, 10782, 10783, 10784, 10785, 10786, 10787, 10788, 11097, 11098, 11182, 11183, 11424, 11425, 12564, 12565, 12566, 12567, 12588, 12589, 12774, 14814, 14815, 14816, 14817, 15198, 15199, 15217, 15218, 15219, 15410, 15536, 15537, 16077, 16078, 16079, 16080, 16115, 16136, 16284, 16303, 17350, 17351, 17352, 17353, 17354, 17355, 17356, 17357, 17358, 17364, 17365, 17366, 17679, 17958, 17959, 17960, 17970, 17971, 17972, 18871, 18872, 18873, 19131, 21571, 21572, 21573, 22549, 22550, 22551, 23124, 23125, 23126, 23127, 23165, 23976, 23977, 23978, 23979, 23980, 23981, 24693, 24694, 24695, 24696, 24697, 24698, 24699, 24700, 24701, 24781, 25158, 25159, 25160, 25422, 25423, 26372, 26373, 26376, 26377, 26850, 26856, 28580, 29102, 29883, 29884, 29885, 30344, 30519, 30521, 30522, 30857, 30858, 31045, 31781, 31782, 31783, 31784, 31785, 31786, 31787, 31788, 31789);
	private static final int MAX_INVENTORY_SIZE = 28;

//	private static final int SACK_LARGE_SIZE = 162;
//	private static final int SACK_SIZE = 81;
//
//	private static final int UPPER_FLOOR_HEIGHT = -500;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiningOverlay overlay;

	@Inject
	private MiningRocksOverlay rocksOverlay;

	@Inject
	private MiningConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Getter(AccessLevel.PACKAGE)
	private boolean inMlm;

	@Getter(AccessLevel.PACKAGE)
	private int curSackSize;
	@Getter(AccessLevel.PACKAGE)
	private int maxSackSize;
	@Getter(AccessLevel.PACKAGE)
	private Integer depositsLeft;

	private MiningSession session;

	@Getter(AccessLevel.PACKAGE)
	private final Set<WallObject> veins = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> rocks = new HashSet<>();

	@Provides
	MiningConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MiningConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(rocksOverlay);
//		overlayManager.add(motherlodeGemOverlay);
//		overlayManager.add(motherlodeSackOverlay);

		session = new MiningSession();
		//inMlm = checkInMlm();

//		if (inMlm)
//		{
//			clientThread.invokeLater(this::refreshSackValues);
//		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(rocksOverlay);
//		overlayManager.remove(motherlodeGemOverlay);
//		overlayManager.remove(motherlodeSackOverlay);
		session = null;
//		veins.clear();
		rocks.clear();

//		Widget sack = client.getWidget(WidgetInfo.MOTHERLODE_MINE);

//		clientThread.invokeLater(() ->
//		{
//			if (sack != null && sack.isHidden())
//			{
//				sack.setHidden(false);
//			}
//		});
	}

	public MiningSession getSession()
	{
		return session;
	}

//	@Subscribe
//	public void onVarbitChanged(VarbitChanged event)
//	{
//		if (inMlm)
//		{
//			refreshSackValues();
//		}
//	}

//	@Subscribe
//	public void onChatMessage(ChatMessage event)
//	{
//		if (!inMlm || event.getType() != ChatMessageType.FILTERED)
//		{
//			return;
//		}
//
//		String chatMessage = event.getMessage();
//
//		switch (chatMessage)
//		{
//			case "You manage to mine some pay-dirt.":
//				session.incrementPayDirtMined();
//				break;
//
//			case "You just found a Diamond!":
//				session.incrementGemFound(ItemID.UNCUT_DIAMOND);
//				break;
//
//			case "You just found a Ruby!":
//				session.incrementGemFound(ItemID.UNCUT_RUBY);
//				break;
//
//			case "You just found an Emerald!":
//				session.incrementGemFound(ItemID.UNCUT_EMERALD);
//				break;
//
//			case "You just found a Sapphire!":
//				session.incrementGemFound(ItemID.UNCUT_SAPPHIRE);
//				break;
//		}
//	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
//	public void checkMining()
//	{
//		if (!inMlm)
//		{
//			return;
//		}
//
//		depositsLeft = calculateDepositsLeft();
//
//		Instant lastPayDirtMined = session.getLastPayDirtMined();
//		if (lastPayDirtMined == null)
//		{
//			return;
//		}
//
//		// reset recentPayDirtMined if you haven't mined anything recently
//		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
//		Duration sinceMined = Duration.between(lastPayDirtMined, Instant.now());
//
//		if (sinceMined.compareTo(statTimeout) >= 0)
//		{
//			session.resetRecent();
//		}
//	}

//	@Subscribe
//	public void onWallObjectSpawned(WallObjectSpawned event)
//	{
//		if (!inMlm)
//		{
//			return;
//		}
//
//		WallObject wallObject = event.getWallObject();
//		if (MINE_SPOTS.contains(wallObject.getId()))
//		{
//			veins.add(wallObject);
//		}
//	}
//
	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		GameObject previous = event.getPrevious();
		GameObject gameObject = event.getGameObject();

		rocks.remove(previous);
		if (MINING_ROCKS.contains(gameObject.getId()))
		{
			rocks.add(gameObject);
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectChanged event)
	{
		GameObject gameObject = event.getGameObject();
		rocks.remove(gameObject);
	}

//	@Subscribe
//	public void onGameObjectSpawned(GameObjectSpawned event)
//	{
//		GameObject gameObject = event.getGameObject();
//		if (MINING_ROCKS.contains(gameObject.getId()))
//		{
//			rocks.add(gameObject);
//		}
//	}

//	@Subscribe
//	public void onGameObjectChanged(GameObjectChanged event)
//	{
//		if (!inMlm)
//		{
//			return;
//		}
//
//		GameObject previous = event.getPrevious();
//		GameObject gameObject = event.getGameObject();
//
//		rocks.remove(previous);
//		if (ROCK_OBSTACLES.contains(gameObject.getId()))
//		{
//			rocks.add(gameObject);
//		}
//
//	}
//
//	@Subscribe
//	public void onGameObjectDespawned(GameObjectDespawned event)
//	{
//		if (!inMlm)
//		{
//			return;
//		}
//
//		GameObject gameObject = event.getGameObject();
//		rocks.remove(gameObject);
//	}

//	@Subscribe
//	public void onGameStateChanged(GameStateChanged event)
//	{
//		if (event.getGameState() == GameState.LOADING)
//		{
//			// on region changes the tiles get set to null
//			veins.clear();
//			rocks.clear();
//		}
//		else if (event.getGameState() == GameState.LOGGED_IN)
//		{
//			inMlm = checkInMlm();
//		}
//		else if (event.getGameState() == GameState.LOGIN_SCREEN)
//		{
//			// Prevent code from running while logged out.
//			inMlm = false;
//		}
//	}

//	private Integer calculateDepositsLeft()
//	{
//		if (maxSackSize == 0) // check if maxSackSize has been initialized
//		{
//			refreshSackValues();
//		}
//
//		double depositsLeft = 0;
//		int nonPayDirtItems = 0;
//
//		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
//		if (inventory == null)
//		{
//			return null;
//		}
//
//		Item[] result = inventory.getItems();
//		assert result != null;
//
//		for (Item item : result)
//		{
//			// Assume that MLM ores are being banked and exclude them from the check,
//			// so the user doesn't see the Overlay switch between deposits left and N/A.
//			//
//			// Count other items at nonPayDirtItems so depositsLeft is calculated accordingly.
//			if (item.getId() != ItemID.PAYDIRT && item.getId() != -1 && !MLM_ORE_TYPES.contains(item.getId()))
//			{
//				nonPayDirtItems += 1;
//			}
//		}
//
//		double inventorySpace = MAX_INVENTORY_SIZE - nonPayDirtItems;
//		double sackSizeRemaining = maxSackSize - curSackSize;
//
//		if (inventorySpace > 0 && sackSizeRemaining > 0)
//		{
//			depositsLeft = Math.ceil(sackSizeRemaining / inventorySpace);
//		}
//		else if (inventorySpace == 0)
//		{
//			return null;
//		}
//
//		return (int) depositsLeft;
//	}
//
//	private boolean checkInMlm()
//	{
//		if (client.getGameState() != GameState.LOGGED_IN)
//		{
//			return false;
//		}
//
//		int[] currentMapRegions = client.getMapRegions();
//
//		// Verify that all regions exist in MOTHERLODE_MAP_REGIONS
//		for (int region : currentMapRegions)
//		{
//			if (!MOTHERLODE_MAP_REGIONS.contains(region))
//			{
//				return false;
//			}
//		}
//
//		return true;
//	}
//
//	private void refreshSackValues()
//	{
//		curSackSize = client.getVar(Varbits.SACK_NUMBER);
//		boolean sackUpgraded = client.getVar(Varbits.SACK_UPGRADED) == 1;
//		maxSackSize = sackUpgraded ? SACK_LARGE_SIZE : SACK_SIZE;
//	}
//
//	/**
//	 * Checks if the given point is "upstairs" in the mlm.
//	 * The upper floor is actually on z=0.
//	 * @param localPoint
//	 * @return
//	 */
//	boolean isUpstairs(LocalPoint localPoint)
//	{
//		return Perspective.getTileHeight(client, localPoint, 0) < UPPER_FLOOR_HEIGHT;
//	}
}
