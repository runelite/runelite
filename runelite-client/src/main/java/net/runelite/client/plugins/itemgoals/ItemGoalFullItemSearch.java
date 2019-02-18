/*
 * Copyright (c) 2019, halworsen <mwh@halvorsenfamilien.com>
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
package net.runelite.client.plugins.itemgoals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.ItemVariationMapping;

// Helper class for searching all known items in the game, tradeable or not
public class ItemGoalFullItemSearch
{
	private ItemManager itemManager;

	ItemGoalFullItemSearch(ItemManager itemManager)
	{
		this.itemManager = itemManager;
	}

	// Converts to upper case, strips away special characters and then converts spaces to underscores
	// The result is a UPPER_CASE string, the same format as ItemID member names
	private String convertSearchString(String searchStr)
	{
		return searchStr.toUpperCase().replaceAll("[^a-zA-Z ]", "").replaceAll("\\s", "_");
	}

	/*
	 * Hackety hack hack!
	 * Since the ItemID class uses the item names as variable names,
	 * we can use reflection to get the item ID of any item in the game
	 */
	public List<Integer> searchByName(String searchStr, boolean giveTrueResult)
	{
		if(searchStr.isEmpty())
		{
			return new ArrayList<>();
		}

		searchStr = convertSearchString(searchStr);

		ArrayList<Integer> foundItemIDs = new ArrayList<>();

		Field[] itemIdFields = ItemID.class.getFields();

		for(Field field : itemIdFields)
		{
			String fieldName = field.getName();

			if(fieldName.contains(searchStr))
			{
				try
				{
					int itemID = field.getInt(null);

					// "True result" as in include every variation of the base item
					if(!giveTrueResult)
					{
						itemID = ItemVariationMapping.map(itemID);
					}

					if(giveTrueResult || !foundItemIDs.contains(itemID))
					{
						foundItemIDs.add(itemID);
					}
				}
				catch (java.lang.IllegalAccessException e) { }
			}
		}

		return foundItemIDs;
	}
}
