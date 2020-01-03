/*
 * Copyright (c) 2020, chestnut1693 <chestnut1693@gmail.com>
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
package net.runelite.client.plugins.raids.bats;

import java.util.ArrayList;
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
	private HashMap<WorldPoint, Chest> chests = new HashMap<>();

	@Getter
	private HashSet<Chest> poisonBatsChests = new HashSet<>();

	@Getter
	private HashSet<Chest> grubsChests = new HashSet<>();

	@Getter
	private ArrayList<ArrayList<Chest>> solutionSets = new ArrayList<>();

	@Getter
	private int highestSolutionSetCount = 0;

	@Getter
	private boolean drawChestStates = false;

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
			assignChestNumbersAndGenerateSolutionSets();
		}
	}

	public void chestSpawnEvent(GameObject chestObject)
	{
		WorldPoint chestLocation = chestObject.getWorldLocation();
		Chest chest = chests.get(chestLocation);
		if (chest == null)
		{
			chest = new Chest(chestLocation);
			chests.put(chestLocation, chest);
			switch (chestObject.getId())
			{
				case OPENED_POISON_OR_BATS:
					poisonBatsChests.add(chest);
					break;
				case OPENED_WITHOUT_GRUBS:
				case OPENED_WITH_GRUBS:
					grubsChests.add(chest);
					break;
			}
			//This code is repeated at the trough spawn event since the room type may not have been set when the last chest spawns, same goes for the rotation.
			assignChestNumbersAndGenerateSolutionSets();
		}
		else
		{
			switch (chestObject.getId())
			{
				case OPENED_POISON_OR_BATS:
					poisonBatsChests.add(chest);
					openChest(chest, Chest.State.POISON);
					break;
				case OPENED_WITHOUT_GRUBS:
				case OPENED_WITH_GRUBS:
					grubsChests.add(chests.get(chestLocation));
					openChest(chest, Chest.State.GRUBS);
					break;
			}
		}
	}

	private ArrayList<ArrayList<Chest>> solutionSetsContaining(Chest chest)
	{
		ArrayList<ArrayList<Chest>> solutionSets = new ArrayList<>();
		for (ArrayList<Chest> solutionSet : this.solutionSets)
		{
			if (solutionSet.contains(chest))
			{
				solutionSets.add(solutionSet);
			}
		}
		return solutionSets;
	}

	private boolean solutionSetContains(ArrayList<Chest> solutionSet, Chest.State state)
	{
		for (Chest chest : solutionSet)
		{
			if (chest.getState() == state)
			{
				return true;
			}
		}
		return false;
	}

	private void openChest(Chest openedChest, Chest.State state)
	{
		openedChest.setState(state);

		if (solutionSets.size() == 0)
		{
			if (poisonBatsChests.size() == 4)
			{
				for (Chest chest : chests.values())
				{
					if (!poisonBatsChests.contains(chest))
					{
						chest.setState(Chest.State.GRUBS);
					}
				}
			}
			return;
		}

		if (state == Chest.State.POISON || state == Chest.State.BATS)
		{
			HashSet<Chest> possiblePoisonBatsChests = new HashSet<>();
			for (ArrayList<Chest> solutionSet : solutionSetsContaining(openedChest))
			{
				for (Chest chest : solutionSet)
				{
					if (chest.getState() != Chest.State.GRUBS)
					{
						possiblePoisonBatsChests.add(chest);
					}
				}
			}
			if (possiblePoisonBatsChests.size() == 0)
			{
				solutionSets.clear();
			}
			for (ArrayList<Chest> solutionSet : solutionSets)
			{
				for (Chest chest : solutionSet)
				{
					if (!possiblePoisonBatsChests.contains(chest) && chest.getState() == Chest.State.UNDEFINED)
					{
						chest.setState(Chest.State.GRUBS);
					}
				}
			}
		}

		Iterator<ArrayList<Chest>> solutionSets = this.solutionSets.iterator();
		while (solutionSets.hasNext())
		{
			ArrayList<Chest> solutionSet = solutionSets.next();
			for (Chest chest : solutionSet)
			{
				if (chest.getState() == Chest.State.UNDEFINED)
				{
					boolean setState = true;
					for (ArrayList<Chest> otherSolutionSet : solutionSetsContaining(chest))
					{
						if (!solutionSetContains(otherSolutionSet, Chest.State.GRUBS))
						{
							setState = false;
							break;
						}
					}
					if (setState)
					{
						chest.setState(Chest.State.GRUBS);
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
			for (Chest chest : this.solutionSets.get(0))
			{
				if (chest.getState() == Chest.State.UNDEFINED)
				{
					chest.setState(Chest.State.POISON);
				}
			}
		}

		if (this.solutionSets.size() == 0)
		{
			if (poisonBatsChests.size() == 4)
			{
				for (Chest chest : chests.values())
				{
					if (!poisonBatsChests.contains(chest))
					{
						chest.setState(Chest.State.GRUBS);
					}
				}
			}
			else
			{
				for (Chest chest : chests.values())
				{
					if (!poisonBatsChests.contains(chest) && !grubsChests.contains(chest))
					{
						chest.setState(Chest.State.UNDEFINED);
					}
				}
			}
		}

		findSolutionSetCounts();
	}

	private void findSolutionSetCounts()
	{
		highestSolutionSetCount = 0;
		for (Chest chest : chests.values())
		{
			chest.setSolutionSetCount(0);
			if (chest.getState() != Chest.State.UNDEFINED)
			{
				continue;
			}
			for (ArrayList<Chest> solutionSet : solutionSetsContaining(chest))
			{
				if (!solutionSetContains(solutionSet, Chest.State.GRUBS))
				{
					chest.setSolutionSetCount(chest.getSolutionSetCount() + 1);
				}
			}
			if (chest.getSolutionSetCount() > highestSolutionSetCount)
			{
				highestSolutionSetCount = chest.getSolutionSetCount();
			}
		}
	}

	private void assignChestNumbersAndGenerateSolutionSets()
	{
		if (rotation != -1 && roomType != null && chests.size() == roomType.getChestCount())
		{
			//Assign chest numbers.
			ArrayList<Chest> chests = new ArrayList<>();
			for (WorldPoint chestLocation : this.chests.keySet())
			{
				chests.add(this.chests.get(chestLocation));
			}
			chests.sort(new WorldPointComparator(rotation));
			for (int i = 0; i < chests.size(); i++)
			{
				chests.get(i).setNumber(i);
			}

			//Generate solution sets.
			switch (roomType)
			{
				case LEFT:
					addSolutionSet(chests, 0, 15, 16, 54);
					addSolutionSet(chests, 0, 16, 37, 53);
					addSolutionSet(chests, 1, 6, 20, 36);
					addSolutionSet(chests, 2, 4, 18, 29);
					addSolutionSet(chests, 2, 10, 14, 39);
					addSolutionSet(chests, 3, 21, 26, 45);
					addSolutionSet(chests, 4, 8, 18, 44);
					addSolutionSet(chests, 5, 23, 25, 40);
					addSolutionSet(chests, 5, 25, 31, 51);
					addSolutionSet(chests, 6, 12, 43, 58);
					addSolutionSet(chests, 7, 9, 27, 32);
					addSolutionSet(chests, 7, 13, 40, 42);
					addSolutionSet(chests, 7, 30, 46, 49);
					addSolutionSet(chests, 9, 29, 31, 58);
					addSolutionSet(chests, 9, 34, 53, 62);
					addSolutionSet(chests, 11, 12, 41, 53);
					addSolutionSet(chests, 11, 39, 52, 55);
					addSolutionSet(chests, 12, 21, 26, 45);
					addSolutionSet(chests, 13, 17, 22, 50);
					addSolutionSet(chests, 14, 15, 41, 44);
					addSolutionSet(chests, 14, 42, 43, 57);
					addSolutionSet(chests, 19, 24, 31, 33);
					addSolutionSet(chests, 19, 27, 50, 61);
					addSolutionSet(chests, 19, 28, 44, 50);
					addSolutionSet(chests, 20, 38, 40, 57);
					addSolutionSet(chests, 21, 24, 53, 63);
					addSolutionSet(chests, 22, 30, 46, 54);
					addSolutionSet(chests, 22, 32, 36, 59);
					addSolutionSet(chests, 23, 33, 47, 54);
					addSolutionSet(chests, 25, 26, 49, 62);
					addSolutionSet(chests, 28, 38, 40, 60);
					addSolutionSet(chests, 32, 45, 51, 56);
					addSolutionSet(chests, 33, 44, 48, 59);
					addSolutionSet(chests, 35, 39, 41, 61);
					addSolutionSet(chests, 36, 37, 50, 63);
					addSolutionSet(chests, 47, 52, 54, 55);
					break;
				case RIGHT:
					addSolutionSet(chests, 0, 6, 23, 54);
					addSolutionSet(chests, 0, 9, 20, 34);
					addSolutionSet(chests, 1, 14, 16, 43);
					addSolutionSet(chests, 2, 8, 21, 51);
					addSolutionSet(chests, 2, 10, 20, 33);
					addSolutionSet(chests, 3, 13, 18, 36);
					addSolutionSet(chests, 3, 16, 17, 40);
					addSolutionSet(chests, 4, 7, 29, 60);
					addSolutionSet(chests, 4, 12, 22, 35);
					addSolutionSet(chests, 5, 11, 53, 55);
					addSolutionSet(chests, 5, 12, 26);
					addSolutionSet(chests, 6, 23, 41, 72);
					addSolutionSet(chests, 7, 8, 25, 27);
					addSolutionSet(chests, 9, 28, 32);
					addSolutionSet(chests, 10, 43, 46, 56);
					addSolutionSet(chests, 11, 39, 57, 69);
					addSolutionSet(chests, 13, 18, 45, 52);
					addSolutionSet(chests, 14, 19, 32, 73);
					addSolutionSet(chests, 15, 21, 39, 48);
					addSolutionSet(chests, 17, 19, 44, 47);
					addSolutionSet(chests, 24, 53, 61, 63);
					addSolutionSet(chests, 26, 53, 69, 71);
					addSolutionSet(chests, 26, 53, 69);
					addSolutionSet(chests, 27, 29, 57, 67);
					addSolutionSet(chests, 27, 36, 70);
					addSolutionSet(chests, 28, 31, 43, 71);
					addSolutionSet(chests, 30, 43, 64, 72);
					addSolutionSet(chests, 30, 54);
					addSolutionSet(chests, 32, 34, 61, 66);
					addSolutionSet(chests, 33, 42, 55, 65);
					addSolutionSet(chests, 33, 46, 68, 73);
					addSolutionSet(chests, 35, 37, 56, 63);
					addSolutionSet(chests, 35, 38, 48, 58);
					addSolutionSet(chests, 39, 51, 59, 65);
					addSolutionSet(chests, 40, 47, 60, 62);
					addSolutionSet(chests, 41, 50, 54, 70);
					addSolutionSet(chests, 42, 45, 52, 58);
					addSolutionSet(chests, 44, 50, 54, 66);
					break;
				case STRAIGHT:
					addSolutionSet(chests, 0, 39, 43, 51);
					addSolutionSet(chests, 1, 15, 20, 53);
					addSolutionSet(chests, 2, 10, 42, 44);
					addSolutionSet(chests, 3, 21, 54);
					addSolutionSet(chests, 4, 14, 38, 52);
					addSolutionSet(chests, 5, 6, 35, 41);
					addSolutionSet(chests, 7, 16, 34, 49);
					addSolutionSet(chests, 9, 12, 26, 27);
					addSolutionSet(chests, 13, 25, 30, 31);
					addSolutionSet(chests, 15, 20, 53);
					addSolutionSet(chests, 17, 24, 34, 58);
					addSolutionSet(chests, 18, 23, 35, 57);
					addSolutionSet(chests, 19, 26, 47, 65);
					addSolutionSet(chests, 21, 33, 36, 61);
					addSolutionSet(chests, 22, 25, 46, 55);
					addSolutionSet(chests, 24, 34, 58);
					addSolutionSet(chests, 28, 40, 52, 63);
					addSolutionSet(chests, 29, 41, 42, 64);
					addSolutionSet(chests, 30, 32, 37, 62);
					addSolutionSet(chests, 39, 43, 51);
					addSolutionSet(chests, 43, 45, 50, 60);
					addSolutionSet(chests, 51, 53, 56, 59);
					break;
			}

			for (Chest chest : this.chests.values())
			{
				if (solutionSetsContaining(chest).size() == 0)
				{
					openChest(chest, Chest.State.GRUBS);
				}
			}
			for (Chest chest : poisonBatsChests)
			{
				openChest(chest, Chest.State.POISON);
			}
			for (Chest chest : grubsChests)
			{
				openChest(chest, Chest.State.GRUBS);
			}

			findSolutionSetCounts();
			drawChestStates = true;
		}
	}

	private void addSolutionSet(ArrayList<Chest> chests, int... indices)
	{
		ArrayList<Chest> solutionSet = new ArrayList<>();
		for (int index : indices)
		{
			solutionSet.add(chests.get(index));
		}
		solutionSets.add(solutionSet);
	}

	public void poisonSplatEvent(WorldPoint worldPoint)
	{
		Chest chest = chests.get(worldPoint);
		if (chest != null)
		{
			chest.setTickPoison(client.getTickCount());
		}
	}

	//This does have a delay switching from poison chest to bats chest which can be observed by the color change at the chest, only when starting the plugin.
	//An open poison chest can't be differentiated from the bats chest which results in the poison chest being changed to a bats chest, only when starting the plugin.
	public void gameTickEvent()
	{
		for (Chest chest : poisonBatsChests)
		{
			if (chest.getState() == Chest.State.POISON && chest.getTickPoison() == -1)
			{
				openChest(chest, Chest.State.BATS);
			}
		}
	}
}
