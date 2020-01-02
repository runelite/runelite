package net.runelite.client.plugins.raids.bats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.Constants.CHUNK_SIZE;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.coords.WorldPoint;

public class BatsLocator
{
	public static final int TROUGH = ObjectID.TROUGH_29746;
	public static final int CLOSED = ObjectID.CHEST_29742;
	public static final int OPENED_POISON_OR_BATS = ObjectID.CHEST_29743;
	public static final int OPENED_WITHOUT_GRUBS = ObjectID.CHEST_29744;
	public static final int OPENED_WITH_GRUBS = ObjectID.CHEST_29745;

	@Getter
	private RoomType roomType;

	@Getter
	private HashMap<WorldPoint, Chest> chestMap = new HashMap<>();

	@Getter
	private ArrayList<WorldPoint> chestLocations = new ArrayList<>();

	@Getter
	private HashSet<WorldPoint> poisonBatsChestLocations = new HashSet<>();

	@Getter
	private HashSet<WorldPoint> grubsChestLocations = new HashSet<>();

	@Getter
	private ArrayList<ArrayList<WorldPoint>> solutionSets = new ArrayList<>();

	@Getter
	private int[] chestCounts = new int[0];

	@Getter
	private int highestChestCountIndex = -1;

	@Getter
	private boolean drawChestNumbers = false;

	private Client client;
	private int rotation = -1;

	public BatsLocator(Client client)
	{
		this.client = client;
	}

	public void troughSpawnEvent(GameObject trough)
	{
		if (roomType == null && rotation == -1)
		{
			int plane = trough.getPlane();
			int chunkX = trough.getLocalLocation().getSceneX() / CHUNK_SIZE;
			int chunkY = trough.getLocalLocation().getSceneY() / CHUNK_SIZE;
			int chunkData = client.getInstanceTemplateChunks()[plane][chunkX][chunkY];
			int instanceX = (chunkData >> 14 & 0x3FF) * CHUNK_SIZE;
			rotation = chunkData >> 1 & 0x3;
			switch (instanceX)
			{
				case 3264:
				case 3272:
					roomType = RoomType.LEFT;
					break;
				case 3344:
					roomType = RoomType.RIGHT;
					break;
				case 3312:
					roomType = RoomType.STRAIGHT;
					break;
			}
			//This code is repeated from the chest spawn event since the room type may not have been set when the last chest spawns, same goes for the rotation.
			sortChestLocations();
			generateSolutionSets();
		}
	}

	public void chestSpawnEvent(GameObject chestObject)
	{
		WorldPoint chestLocation = chestObject.getWorldLocation();
		if (!chestMap.containsKey(chestLocation))
		{
			chestMap.put(chestLocation, new Chest());
			chestLocations.add(chestLocation);
			switch (chestObject.getId())
			{
				case OPENED_POISON_OR_BATS:
					poisonBatsChestLocations.add(chestLocation);
					break;
				case OPENED_WITHOUT_GRUBS:
				case OPENED_WITH_GRUBS:
					grubsChestLocations.add(chestLocation);
					break;
			}
			//This code is repeated at the trough spawn event since the room type may not have been set when the last chest spawns, same goes for the rotation.
			sortChestLocations();
			generateSolutionSets();
		}
		else
		{
			switch (chestObject.getId())
			{
				case OPENED_POISON_OR_BATS:
					poisonBatsChestLocations.add(chestLocation);
					openChest(chestLocation, Chest.State.POISON);
					break;
				case OPENED_WITHOUT_GRUBS:
				case OPENED_WITH_GRUBS:
					grubsChestLocations.add(chestLocation);
					openChest(chestLocation, Chest.State.GRUBS);
					break;
			}
		}
	}

	private ArrayList<ArrayList<WorldPoint>> solutionSetsContaining(WorldPoint chestLocation)
	{
		ArrayList<ArrayList<WorldPoint>> solutionSets = new ArrayList<>();
		for (ArrayList<WorldPoint> solutionSet : this.solutionSets)
		{
			if (solutionSet.contains(chestLocation))
			{
				solutionSets.add(solutionSet);
			}
		}
		return solutionSets;
	}

	private boolean solutionSetContains(ArrayList<WorldPoint> solutionSet, Chest.State state)
	{
		for (WorldPoint worldPoint : solutionSet)
		{
			if (chestMap.get(worldPoint).getState() == state)
			{
				return true;
			}
		}
		return false;
	}

	private void openChest(WorldPoint chestLocation, Chest.State state)
	{
		chestMap.get(chestLocation).setState(state);

		if (solutionSets.size() == 0)
		{
			return;
		}

		if (state == Chest.State.POISON || state == Chest.State.BATS)
		{
			HashSet<WorldPoint> possiblePoisonBatsChestLocations = new HashSet<>();
			for (ArrayList<WorldPoint> solutionSet : solutionSetsContaining(chestLocation))
			{
				for (WorldPoint worldPoint : solutionSet)
				{
					if (chestMap.get(worldPoint).getState() != Chest.State.GRUBS)
					{
						possiblePoisonBatsChestLocations.add(worldPoint);
					}
				}
			}
			if (possiblePoisonBatsChestLocations.size() == 0)
			{
				solutionSets.clear();
			}
			for (ArrayList<WorldPoint> solutionSet : solutionSets)
			{
				for (WorldPoint worldPoint : solutionSet)
				{
					if (!possiblePoisonBatsChestLocations.contains(worldPoint) && chestMap.get(worldPoint).getState() == Chest.State.UNDEFINED)
					{
						chestMap.get(worldPoint).setState(Chest.State.GRUBS);
					}
				}
			}
		}

		Iterator<ArrayList<WorldPoint>> solutionSets = this.solutionSets.iterator();
		while (solutionSets.hasNext())
		{
			ArrayList<WorldPoint> solutionSet = solutionSets.next();
			for (WorldPoint worldPoint : solutionSet)
			{
				if (chestMap.get(worldPoint).getState() == Chest.State.UNDEFINED)
				{
					boolean setState = true;
					for (ArrayList<WorldPoint> otherSolutionSet : solutionSetsContaining(worldPoint))
					{
						if (!solutionSetContains(otherSolutionSet, Chest.State.GRUBS))
						{
							setState = false;
							break;
						}
					}
					if (setState)
					{
						chestMap.get(worldPoint).setState(Chest.State.GRUBS);
					}
				}
			}
			if (solutionSetContains(solutionSet, Chest.State.GRUBS))
			{
				solutionSets.remove();
			}
		}

		if (this.solutionSets.size() == 1 && solutionSetContains(this.solutionSets.get(0), Chest.State.BATS))
		{
			for (WorldPoint worldPoint : this.solutionSets.get(0))
			{
				if (chestMap.get(worldPoint).getState() == Chest.State.UNDEFINED)
				{
					chestMap.get(worldPoint).setState(Chest.State.POISON);
				}
			}
		}

		if (this.solutionSets.size() == 0)
		{
			for (WorldPoint location : chestLocations)
			{
				if (!poisonBatsChestLocations.contains(location) && !grubsChestLocations.contains(location))
				{
					chestMap.get(location).setState(Chest.State.UNDEFINED);
				}
			}
		}

		findChestCounts();
	}

	private void findChestCounts()
	{
		Arrays.fill(chestCounts, 0);
		highestChestCountIndex = -1;
		for (int i = 0; i < chestLocations.size(); i++)
		{
			if (chestMap.get(chestLocations.get(i)).getState() == Chest.State.UNDEFINED)
			{
				for (ArrayList<WorldPoint> solutionSet : solutionSetsContaining(chestLocations.get(i)))
				{
					if (!solutionSetContains(solutionSet, Chest.State.GRUBS))
					{
						chestCounts[i]++;
					}
				}
				if (highestChestCountIndex == -1 || chestCounts[i] > chestCounts[highestChestCountIndex])
				{
					highestChestCountIndex = i;
				}
			}
		}
	}

	private void sortChestLocations()
	{
		if (rotation != -1 && roomType != null && chestLocations.size() == roomType.getChestCount())
		{
			chestLocations.sort(new WorldPointComparator(rotation));
			chestCounts = new int[roomType.getChestCount()];
			drawChestNumbers = true;
		}
	}

	private void generateSolutionSets()
	{
		if (roomType != null && chestLocations.size() == roomType.getChestCount())
		{
			switch (roomType)
			{
				case LEFT:
					addSolutionSet(0, 15, 16, 54);
					addSolutionSet(0, 16, 37, 53);
					addSolutionSet(1, 6, 20, 36);
					addSolutionSet(2, 4, 18, 29);
					addSolutionSet(2, 10, 14, 39);
					addSolutionSet(3, 21, 26, 45);
					addSolutionSet(4, 8, 18, 44);
					addSolutionSet(5, 23, 25, 40);
					addSolutionSet(5, 25, 31, 51);
					addSolutionSet(6, 12, 43, 58);
					addSolutionSet(7, 9, 27, 32);
					addSolutionSet(7, 13, 40, 42);
					addSolutionSet(7, 30, 46, 49);
					addSolutionSet(9, 29, 31, 58);
					addSolutionSet(9, 34, 53, 62);
					addSolutionSet(11, 12, 41, 53);
					addSolutionSet(11, 39, 52, 55);
					addSolutionSet(12, 21, 26, 45);
					addSolutionSet(13, 17, 22, 50);
					addSolutionSet(14, 15, 41, 44);
					addSolutionSet(14, 42, 43, 57);
					addSolutionSet(19, 24, 31, 33);
					addSolutionSet(19, 27, 50, 61);
					addSolutionSet(19, 28, 44, 50);
					addSolutionSet(20, 38, 40, 57);
					addSolutionSet(21, 24, 53, 63);
					addSolutionSet(22, 30, 46, 54);
					addSolutionSet(22, 32, 36, 59);
					addSolutionSet(23, 33, 47, 54);
					addSolutionSet(25, 26, 49, 62);
					addSolutionSet(28, 38, 40, 60);
					addSolutionSet(32, 45, 51, 56);
					addSolutionSet(33, 44, 48, 59);
					addSolutionSet(35, 39, 41, 61);
					addSolutionSet(36, 37, 50, 63);
					addSolutionSet(47, 52, 54, 55);
					break;
				case RIGHT:
					addSolutionSet(0, 6, 23, 54);
					addSolutionSet(0, 9, 20, 34);
					addSolutionSet(1, 14, 16, 43);
					addSolutionSet(2, 8, 21, 51);
					addSolutionSet(2, 10, 20, 33);
					addSolutionSet(3, 13, 18, 36);
					addSolutionSet(3, 16, 17, 40);
					addSolutionSet(4, 7, 29, 60);
					addSolutionSet(4, 12, 22, 35);
					addSolutionSet(5, 11, 53, 55);
					addSolutionSet(5, 12, 26);
					addSolutionSet(6, 23, 41, 72);
					addSolutionSet(7, 8, 25, 27);
					addSolutionSet(9, 28, 32);
					addSolutionSet(10, 43, 46, 56);
					addSolutionSet(11, 39, 57, 69);
					addSolutionSet(13, 18, 45, 52);
					addSolutionSet(14, 19, 32, 73);
					addSolutionSet(15, 21, 39, 48);
					addSolutionSet(17, 19, 44, 47);
					addSolutionSet(24, 53, 61, 63);
					addSolutionSet(26, 53, 69, 71);
					addSolutionSet(26, 53, 69);
					addSolutionSet(27, 29, 57, 67);
					addSolutionSet(27, 36, 70);
					addSolutionSet(28, 31, 43, 71);
					addSolutionSet(30, 43, 64, 72);
					addSolutionSet(30, 54);
					addSolutionSet(32, 34, 61, 66);
					addSolutionSet(33, 42, 55, 65);
					addSolutionSet(33, 46, 68, 73);
					addSolutionSet(35, 37, 56, 63);
					addSolutionSet(35, 38, 48, 58);
					addSolutionSet(39, 51, 59, 65);
					addSolutionSet(40, 47, 60, 62);
					addSolutionSet(41, 50, 54, 70);
					addSolutionSet(42, 45, 52, 58);
					addSolutionSet(44, 50, 54, 66);
					break;
				case STRAIGHT:
					addSolutionSet(0, 39, 43, 51);
					addSolutionSet(1, 15, 20, 53);
					addSolutionSet(2, 10, 42, 44);
					addSolutionSet(3, 21, 54);
					addSolutionSet(4, 14, 38, 52);
					addSolutionSet(5, 6, 35, 41);
					addSolutionSet(7, 16, 34, 49);
					addSolutionSet(9, 12, 26, 27);
					addSolutionSet(13, 25, 30, 31);
					addSolutionSet(15, 20, 53);
					addSolutionSet(17, 24, 34, 58);
					addSolutionSet(18, 23, 35, 57);
					addSolutionSet(19, 26, 47, 65);
					addSolutionSet(21, 33, 36, 61);
					addSolutionSet(22, 25, 46, 55);
					addSolutionSet(24, 34, 58);
					addSolutionSet(28, 40, 52, 63);
					addSolutionSet(29, 41, 42, 64);
					addSolutionSet(30, 32, 37, 62);
					addSolutionSet(39, 43, 51);
					addSolutionSet(43, 45, 50, 60);
					addSolutionSet(51, 53, 56, 59);
					break;
			}
			for (WorldPoint chestLocation : chestLocations)
			{
				if (solutionSetsContaining(chestLocation).size() == 0)
				{
					openChest(chestLocation, Chest.State.GRUBS);
				}
			}
			for (WorldPoint chestLocation : poisonBatsChestLocations)
			{
				openChest(chestLocation, Chest.State.POISON);
			}
			for (WorldPoint chestLocation : grubsChestLocations)
			{
				openChest(chestLocation, Chest.State.GRUBS);
			}

			findChestCounts();
		}
	}

	private void addSolutionSet(int... indices)
	{
		ArrayList<WorldPoint> solutionSet = new ArrayList<>();
		for (int index : indices)
		{
			solutionSet.add(chestLocations.get(index));
		}
		solutionSets.add(solutionSet);
	}

	public void poisonSplatEvent(WorldPoint worldPoint)
	{
		Chest chest = chestMap.get(worldPoint);
		if (chest != null)
		{
			chest.setTickPoison(client.getTickCount());
		}
	}

	//This does have a delay switching from poison chest to bats chest which can be observed by the color change at the chest, only when starting the plugin.
	public void gameTickEvent()
	{
		for (WorldPoint chestLocation : poisonBatsChestLocations)
		{
			Chest chest = chestMap.get(chestLocation);
			if (chest.getState() == Chest.State.POISON && chest.getTickPoison() == -1)
			{
				openChest(chestLocation, Chest.State.BATS);
			}
		}
	}
}
