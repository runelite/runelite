/*
 * Copyright (c) 2017, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving;

import com.google.inject.Provides;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.raidsthieving.BatSolver.BatSolver;
import net.runelite.client.plugins.raidsthieving.BatSolver.ChestIdentifier;
import net.runelite.client.plugins.raidsthieving.BatSolver.ThievingRoomType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;
import javax.inject.Inject;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import static net.runelite.client.plugins.raidsthieving.BatSolver.Matrix2D.MatrixMultiple2D;
import static net.runelite.client.plugins.raidsthieving.BatSolver.Matrix2D.Rotate90;

@Slf4j
@PluginDescriptor(
	name = "Raids Bat Finder",
	description = "Tracks which chests need to be searched for bats and which poison",
	tags = {"overlay", "skilling", "raid"}
)
public class RaidsThievingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ChestOverlay overlay;

	@Inject
	private Notifier notifier;

	@Inject
	private RaidsThievingConfig config;

	@Getter
	private final Map<WorldPoint, ThievingChest> chests = new HashMap<>();

	@Getter
	private Instant lastActionTime = Instant.ofEpochMilli(0);

	private boolean inRaidChambers;

	@Getter
	private boolean batsFound;

	@Getter
	private BatSolver solver;

	@Getter
	private ChestIdentifier identifier;

	private WorldPoint thievingStorageLocation = null;

	@Provides
	RaidsThievingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsThievingConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		overlay.updateConfig();
		reset();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		lastActionTime = Instant.ofEpochMilli(0);
		chests.clear();
	}

	private int getNumberOfChestsNearStorage(double maxDistance)
	{
		int number = 0;
		for (WorldPoint point : chests.keySet())
		{
			if (Math.abs(point.getX() - thievingStorageLocation.getX()) < maxDistance &&
				Math.abs(point.getY() - thievingStorageLocation.getY()) < maxDistance)
			{
				number++;
			}
		}
		return number;
	}

	private boolean isStorageChestInThievingRoom(GameObject storageChest, WorldPoint location)
	{

		for (WorldPoint point : chests.keySet())
		{
			double distance = Math.pow((point.getX() - location.getX()), 2) +
				Math.pow((point.getY() - location.getY()), 2);
			if (distance < 5)
			{
				return true;
			}

		}

		return false;
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject obj = event.getGameObject();
		WorldPoint loc = obj.getWorldLocation();
		if (ArrayUtils.indexOf(RaidsThievingConstants.STORAGE, obj.getId()) != -1 && thievingStorageLocation == null)
		{
			// Found a storage chest possibly
			LocalPoint storageChestLocation = event.getTile().getLocalLocation();
			log.debug(MessageFormat.format("Found storage chest at {0},{1}", storageChestLocation.getX(), storageChestLocation.getY()));
			if (chests.keySet().size() > 0 && isStorageChestInThievingRoom(obj, loc))
			{
				log.debug("found thieving room chest");
				thievingStorageLocation = loc;
			}
			else
			{
				log.debug("But it wasn't for thieving...");
			}

		}
		switch (obj.getId())
		{

			case RaidsThievingConstants.EMPTY_TROUGH:
				// Found an empty trough
				if (solver == null || identifier == null)
				{
					// Initialise the BatSolver
					WorldPoint chestLoc = findChestNearTrough(obj.getLocalLocation());
					if (chestLoc != null)
					{
						ThievingRoomType roomType = determineRoom();
						int[][] roomRotation = determineRoomRotation(roomType);
						log.debug(MessageFormat.format("Room is {0}", roomType));
						identifier = new ChestIdentifier(roomType, roomRotation);
						solver = new BatSolver(roomType);
					}
				}
				break;

			case RaidsThievingConstants.CLOSED_CHEST_ID:
				if (!chests.containsKey(loc))
				{
					log.debug(MessageFormat.format("Found a new chest at {0}, {1}",
						event.getTile().getLocalLocation().getX(), event.getTile().getLocalLocation().getY()));
					chests.put(loc, new ThievingChest(obj));
				}
				else
				{
					// A chest that had been opened just closed
					// If there is still a chest marked empty and without poison, it had the bats
					checkForBats();
				}
				break;

			case RaidsThievingConstants.OPEN_EMPTY_CHEST:
				log.debug(MessageFormat.format("Found empty chest with Bats or Poison at {0}, {1}",
					event.getTile().getLocalLocation().getX(), event.getTile().getLocalLocation().getY()));
				chests.get(loc).setEverOpened(true);
				chests.get(loc).setEmpty(true);
				solver.addEmptyChest(getChestId(loc));
				break;
			case RaidsThievingConstants.OPEN_FULL_CHEST_1:
			case RaidsThievingConstants.OPEN_FULL_CHEST_2:
				log.debug(MessageFormat.format("Found full chest at {0}, {1}",
					event.getTile().getLocalLocation().getX(), event.getTile().getLocalLocation().getY()));
				chests.get(loc).setEverOpened(true);
				if (solver != null)
				{
					solver.addGrubsChest(getChestId(loc));
				}
				break;


		}
	}

	@Subscribe
	public void onGraphicsObjectCreated(GraphicsObjectCreated event)
	{
		GraphicsObject obj = event.getGraphicsObject();
		if (obj.getId() == 184)
		{
			log.debug("Found poison splat");
			WorldPoint loc = WorldPoint.fromLocal(client, obj.getLocation());
			chests.get(loc).setPoison(true);
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		boolean setting = client.getVar(Varbits.IN_RAID) == 1;

		if (inRaidChambers != setting)
		{
			inRaidChambers = setting;
			reset();
		}

	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("raidsthievingplugin"))
		{
			overlay.updateConfig();
		}
	}

	private void reset()
	{
		chests.clear();
		batsFound = false;
		solver = null;
		identifier = null;
		thievingStorageLocation = null;
	}

	private void checkForBats()
	{
		for (Map.Entry<WorldPoint, ThievingChest> entry : getChests().entrySet())
		{
			ThievingChest chest = entry.getValue();
			if (chest != null)
			{
				if (chest.isEmpty() && !chest.isPoison())
				{
					log.debug("Found bats!");
					batsFound = true;
					if (config.batFoundNotify())
					{
						notifier.notify("Bats have been found!");
					}
				}
			}
		}
	}

	private WorldPoint findChestNearTrough(LocalPoint point)
	{
		return thievingStorageLocation;
	}

	private ThievingRoomType determineRoom()
	{

		if (getNumberOfChestsNearStorage(2) == 0)
		{
			return ThievingRoomType.STRAIGHT;
		}

		int numberChests = getNumberOfChestsNearStorage(4);
		log.debug(MessageFormat.format("Found {0} chests near storage", numberChests));

		if (numberChests == 2)
		{
			return ThievingRoomType.LEFT_TURN;
		}

		if (numberChests == 4)
		{
			return ThievingRoomType.RIGHT_TURN;
		}

		log.debug("Couldn't determine which room...");
		log.error(MessageFormat.format("Number of chests: {0}", numberChests));
		return ThievingRoomType.UNKNOWN;
	}

	private int[][] determineRoomRotation(ThievingRoomType roomType)
	{
		int[][] currentRot = {{1, 0}, {0, 1}};
		int[][] expectedLoc = {{0}, {0}};
		switch (roomType)
		{
			case LEFT_TURN:
			case RIGHT_TURN:
				expectedLoc[0][0] = -1;
				expectedLoc[1][0] = -1;
				break;
			case STRAIGHT:
				expectedLoc[0][0] = 0;
				expectedLoc[1][0] = -2;
				break;
			case UNKNOWN:
				log.error("Couldn't determine thieving room rotation, please report with screenshot of thieving room zoomed out Camera North");
				break;
		}
		int[][] testLoc;

		for (int i = 0; i < 4; i++)
		{
			testLoc = MatrixMultiple2D(currentRot, expectedLoc);

			WorldPoint point = new WorldPoint(thievingStorageLocation.getX() + testLoc[0][0],
				thievingStorageLocation.getY() + testLoc[1][0],
				thievingStorageLocation.getPlane());

			if (chests.containsKey(point))
			{
				return currentRot;
			}
			currentRot = Rotate90(currentRot);
		}
		return new int[][]{{1, 1}, {1, 1}};
	}

	public int numberOfEmptyChestsFound()
	{
		int emptyFound = 0;
		for (ThievingChest chest : getChests().values())
		{
			if (chest.isEmpty() || chest.isPoison())
			{
				emptyFound++;
			}
		}
		return emptyFound;
	}

	private int[] getDeltaFromStorage(WorldPoint pos)
	{
		int dx = pos.getX() - thievingStorageLocation.getX();
		int dy = pos.getY() - thievingStorageLocation.getY();
		return new int[]{dx, dy};
	}

	public int getChestId(WorldPoint pos)
	{
		if (thievingStorageLocation != null)
		{
			int[] delta = getDeltaFromStorage(pos);
			return identifier.findChestId(delta[0], delta[1]);
		}
		return -1;
	}

}

