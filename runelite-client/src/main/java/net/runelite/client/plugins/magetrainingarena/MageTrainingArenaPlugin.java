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
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.api.queries.InventoryItemQuery;
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
import java.util.HashMap;
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

	@Override
	protected void startUp() throws Exception
	{
		alchemyRoomOverlay = new AlchemyRoomOverlay(client, this);
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

	@Override
	public Overlay getOverlay()
	{
		return alchemyRoomOverlay;
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
	public void OnGameTick(GameTick event)
	{
		final GameObjectQuery query = new GameObjectQuery().idEquals(getCabinetObjectIds());
		cabinets = queryRunner.runQuery(query);

		Item[] items = queryRunner.runQuery(new InventoryItemQuery(InventoryID.INVENTORY));

		//Sum fruit from bones
		totalFruitFromBones = 0;

		Widget widget = client.getWidget(WidgetInfo.MAGE_TRAINING_ARENA_GRAVEYARD_TITLE);

		if (widget != null && !widget.isHidden())
		{
			if (counter == null)
			{
				counter = new GraveyardBoneCounter(itemManager.getImage(ItemID.BONES_TO_PEACHES), this);
				infoBoxManager.addInfoBox(counter);
			}

			for (Item item : items)
			{
				GraveyardBone bone = GraveyardBone.GetBoneById(item.getId());
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
	public void OnMenuEntryOptionClicked(MenuOptionClicked event)
	{
		lastObjectIdClicked = event.getId();
	}
}