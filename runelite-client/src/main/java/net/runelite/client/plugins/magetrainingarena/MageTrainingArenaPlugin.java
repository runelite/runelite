/*
 * Copyright (c) 2018, Toocanzs <https://github.com/Toocanzs>
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
package net.runelite.client.plugins.magetrainingarena;

import com.google.common.eventbus.Subscribe;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.ObjectID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.api.queries.GroundObjectQuery;
import net.runelite.api.queries.InventoryItemQuery;
import net.runelite.api.queries.NPCQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.QueryRunner;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static net.runelite.client.plugins.magetrainingarena.AlchemyRoomItem.ADAMANT_KITESHIELD;
import static net.runelite.client.plugins.magetrainingarena.AlchemyRoomItem.ADAMANT_MED_HELM;
import static net.runelite.client.plugins.magetrainingarena.AlchemyRoomItem.EMERALD;
import static net.runelite.client.plugins.magetrainingarena.AlchemyRoomItem.LEATHER_BOOTS;
import static net.runelite.client.plugins.magetrainingarena.AlchemyRoomItem.RUNE_LONGSWORD;

@PluginDescriptor(
		name = "Mage Training Arena"
)
public class MageTrainingArenaPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private QueryRunner queryRunner;
	@Inject
	ItemManager itemManager;
	@Inject
	private InfoBoxManager infoBoxManager;

	private AlchemyRoomOverlay alchemyRoomOverlay;
	private TelekineticOverlay telekineticOverlay;

	private Map<Integer, Integer> alchemyObjectIDToArrayIndexMap;
	//Permutation order goes from north west->south west->south west->north east
	private AlchemyRoomItem[][] alchemyPermutations = {
			{LEATHER_BOOTS, null, null, null, RUNE_LONGSWORD, EMERALD, ADAMANT_MED_HELM, ADAMANT_KITESHIELD},
			{ADAMANT_KITESHIELD, LEATHER_BOOTS, null, null, null, RUNE_LONGSWORD, EMERALD, ADAMANT_MED_HELM},
			{ADAMANT_MED_HELM, ADAMANT_KITESHIELD, LEATHER_BOOTS, null, null, null, RUNE_LONGSWORD, EMERALD},
			{EMERALD, ADAMANT_MED_HELM, ADAMANT_KITESHIELD, LEATHER_BOOTS, null, null, null, RUNE_LONGSWORD},
			{RUNE_LONGSWORD, EMERALD, ADAMANT_MED_HELM, ADAMANT_KITESHIELD, LEATHER_BOOTS, null, null, null},
			{null, RUNE_LONGSWORD, EMERALD, ADAMANT_MED_HELM, ADAMANT_KITESHIELD, LEATHER_BOOTS, null, null},
			{null, null, RUNE_LONGSWORD, EMERALD, ADAMANT_MED_HELM, ADAMANT_KITESHIELD, LEATHER_BOOTS, null},
			{null, null, null, RUNE_LONGSWORD, EMERALD, ADAMANT_MED_HELM, ADAMANT_KITESHIELD, LEATHER_BOOTS}
	};
	private int lastObjectIdClicked = -1;
	private AlchemyRoomItem[] currentPermutation;
	@Getter
	private GameObject[] cabinets;

	@Getter
	private int totalFruitFromBones = 0;
	private GraveyardBoneCounter counter;

	TelekineticPuzzle currentTelekineticPuzzle;
	private int telekineticPuzzleStep = 0;

	//Holds the current target and next target for the overlay to render
	@Getter
	private Tile[] playerTargetTiles = new Tile[2];
	@Getter
	private Tile[] guardianTargetTiles = new Tile[2];

	@Override
	protected void startUp() throws Exception
	{
		alchemyRoomOverlay = new AlchemyRoomOverlay(client, this);
		telekineticOverlay = new TelekineticOverlay(client, this);
		setupHashMap();
	}

	private void addCabientToHashMap(AlchemyRoomCabinet alchemyRoomCabinet, int index)
	{
		//Cabinets have 2 object ids. Open and closed, so map both ids to the same index.
		alchemyObjectIDToArrayIndexMap.put(alchemyRoomCabinet.openObjectId, index);
		alchemyObjectIDToArrayIndexMap.put(alchemyRoomCabinet.closedObjectId, index);
	}

	private void setupHashMap()
	{
		//Setup hashmap to map an object id to an index in a permutation.
		alchemyObjectIDToArrayIndexMap = new HashMap<Integer, Integer>();
		addCabientToHashMap(AlchemyRoomCabinet.WEST_0, 0);
		addCabientToHashMap(AlchemyRoomCabinet.WEST_1, 1);
		addCabientToHashMap(AlchemyRoomCabinet.WEST_2, 2);
		addCabientToHashMap(AlchemyRoomCabinet.WEST_3, 3);

		addCabientToHashMap(AlchemyRoomCabinet.EAST_3, 4);
		addCabientToHashMap(AlchemyRoomCabinet.EAST_2, 5);
		addCabientToHashMap(AlchemyRoomCabinet.EAST_1, 6);
		addCabientToHashMap(AlchemyRoomCabinet.EAST_0, 7);
	}

	public List<Overlay> getOverlays()
	{
		return Arrays.asList(alchemyRoomOverlay, telekineticOverlay);
	}

	@Subscribe
	public void OnChatMessage(ChatMessage event)
	{
		String message = event.getMessage();
		if (message.contains("You found: "))
		{
			String item = message.split("You found: ")[1];
			Integer arrayIndex = alchemyObjectIDToArrayIndexMap.get(lastObjectIdClicked);
			if (arrayIndex == null)
			{
				return;
			}

			currentPermutation = getPermutation(item, arrayIndex);
		}
		if (message.equalsIgnoreCase("The cupboard is empty.") && currentPermutation != null)
		{
			Integer arrayIndex = alchemyObjectIDToArrayIndexMap.get(lastObjectIdClicked);
			if (arrayIndex == null)
			{
				return;
			}

			//Reset if we start finding nothing and the current permutation doesn't match
			if (currentPermutation[arrayIndex] != null)
			{
				currentPermutation = null;
			}
		}
		//Reset if you re-enter the area
		if (message.equalsIgnoreCase("You've entered the Alchemists' Playground."))
		{
			currentPermutation = null;
		}
	}

	private AlchemyRoomItem[] getPermutation(String item, int arrayIndex)
	{
		for (AlchemyRoomItem[] permutation : alchemyPermutations)
		{
			if (permutation[arrayIndex] != null && permutation[arrayIndex].name.equalsIgnoreCase(item))
			{
				return permutation;
			}
		}
		return null;
	}

	private int[] getCabinetObjectIds()
	{
		int[] cabinetIds = new int[AlchemyRoomCabinet.values().length * 2];

		//Generate array of all possible ids for cabinets to use in object query
		for (int i = 0; i < AlchemyRoomCabinet.values().length; i++)
		{
			AlchemyRoomCabinet cabinet = AlchemyRoomCabinet.values()[i];
			cabinetIds[i * 2] = cabinet.closedObjectId;
			cabinetIds[i * 2 + 1] = cabinet.openObjectId;
		}

		return cabinetIds;
	}

	public BufferedImage getCabinetItemImage(int objectId)
	{
		int permutationArrayIndex = alchemyObjectIDToArrayIndexMap.get(objectId);

		if (currentPermutation == null)
		{
			return null;
		}
		AlchemyRoomItem item = currentPermutation[permutationArrayIndex];

		if (item == null)
		{
			return null;
		}

		BufferedImage image = itemManager.getImage(item.itemID);
		return image;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		final GameObjectQuery query = new GameObjectQuery().idEquals(getCabinetObjectIds());
		cabinets = queryRunner.runQuery(query);

		sumTotalFruitFromBones();
		checkForTelekineticPuzzle();
	}

	private void checkForTelekineticPuzzle()
	{
		Widget telekineticTitle = client.getWidget(WidgetInfo.MAGE_TRAINING_ARENA_TELEKINETIC_TITLE);
		if (telekineticTitle != null && !telekineticTitle.isHidden())
		{
			final GroundObjectQuery groundObjectQuery = new GroundObjectQuery().idEquals(ObjectID.TELEKINETIC_GOAL);
			GroundObject[] groundObjectResult = queryRunner.runQuery(groundObjectQuery);
			GroundObject telekineticGoalGroundObject = groundObjectResult.length >= 1 ? groundObjectResult[0] : null;

			final NPCQuery npcQuery = new NPCQuery().idEquals(NpcID.MAZE_GUARDIAN);
			NPC[] npcResult = queryRunner.runQuery(npcQuery);
			NPC telekineticGuardianNpc = npcResult.length >= 1 ? npcResult[0] : null;

			if (telekineticGoalGroundObject == null)
			{
				resetTelekinetic();
			}


			if (currentTelekineticPuzzle == null && telekineticGoalGroundObject != null && telekineticGuardianNpc != null)
			{
				Tile[][] tiles = client.getRegion().getTiles()[client.getPlane()];
				WorldPoint startPoint = telekineticGuardianNpc.getWorldLocation();
				WorldPoint endPoint = telekineticGoalGroundObject.getWorldLocation();

				currentTelekineticPuzzle = TelekineticPuzzle.findTelekineticPuzzle(startPoint, endPoint, tiles);
			}
			getTargetTiles(telekineticGoalGroundObject, telekineticGuardianNpc);
		}
	}

	private void getTargetTiles(GroundObject telekineticGoalGroundObject, NPC telekineticGuardianNpc)
	{
		if (currentTelekineticPuzzle != null)
		{
			List<TelekineticTile> puzzleShortestPath = currentTelekineticPuzzle.getPuzzleShortestPath();

			if (telekineticGoalGroundObject != null && telekineticGuardianNpc != null && puzzleShortestPath != null)
			{
				if (telekineticPuzzleStep < puzzleShortestPath.size())
				{
					WorldPoint currentGuardianTargetPoint = puzzleShortestPath.get(telekineticPuzzleStep).getTile().getWorldLocation();
					if (telekineticGuardianNpc.getWorldLocation().equals(currentGuardianTargetPoint))
					{
						telekineticPuzzleStep++;
					}

					guardianTargetTiles[0] = puzzleShortestPath.get(telekineticPuzzleStep).getTile();
					guardianTargetTiles[1] = telekineticPuzzleStep + 1 < puzzleShortestPath.size() ? puzzleShortestPath.get(telekineticPuzzleStep + 1).getTile() : null;

				}

				List<TelekineticTile> playerPredictedTiles = currentTelekineticPuzzle.getPlayerPredictedTiles();
				playerTargetTiles[0] = telekineticPuzzleStep > 0 ? playerPredictedTiles.get(telekineticPuzzleStep - 1).getTile() : null;
				playerTargetTiles[1] = telekineticPuzzleStep < playerPredictedTiles.size() ? playerPredictedTiles.get(telekineticPuzzleStep).getTile() : null;
			}
		}
	}

	private void sumTotalFruitFromBones()
	{

		final InventoryItemQuery inventoryItemQuery = new InventoryItemQuery(InventoryID.INVENTORY);
		Item[] items = queryRunner.runQuery(inventoryItemQuery);

		//Sum fruit from bones
		totalFruitFromBones = 0;

		Widget graveyardTitle = client.getWidget(WidgetInfo.MAGE_TRAINING_ARENA_GRAVEYARD_TITLE);

		if (graveyardTitle != null && !graveyardTitle.isHidden())
		{
			if (counter == null)
			{
				counter = new GraveyardBoneCounter(itemManager.getImage(ItemID.BONES_TO_PEACHES), this);
				infoBoxManager.addInfoBox(counter);
			}

			for (Item item : items)
			{
				GraveyardBone bone = GraveyardBone.getBoneById(item.getId());
				if (bone != null)
				{
					totalFruitFromBones += bone.fruitAmount;
				}
			}
		}
		else
		{
			if (counter != null)
			{
				infoBoxManager.removeInfoBox(counter);
				counter = null;
			}
		}
	}

	@Subscribe
	public void onMapRegionChange(MapRegionChanged event)
	{
		resetTelekinetic();
	}

	private void resetTelekinetic()
	{
		currentTelekineticPuzzle = null;
		telekineticPuzzleStep = 0;

		guardianTargetTiles[0] = null;
		guardianTargetTiles[1] = null;

		playerTargetTiles[0] = null;
		playerTargetTiles[1] = null;
	}

	@Subscribe
	public void onMenuEntryOptionClicked(MenuOptionClicked event)
	{
		lastObjectIdClicked = event.getId();
	}
}