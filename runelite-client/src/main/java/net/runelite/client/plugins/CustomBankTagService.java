/*
 * Copyright (c) 2020, Zoinkwiz <https://github.com/Zoinkwiz>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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

package net.runelite.client.plugins;

import java.util.ArrayList;
import net.runelite.client.plugins.banktags.CustomBankTabItem;
import net.runelite.client.plugins.banktags.CustomBankTabItems;

public class CustomBankTagService
{
	/**
	 * Get whether the provided item should be tagged
	 */
	public boolean shouldTag(int itemID)
	{
		return false;
	}

	/**
	 * Get a list of the custom tab's items to tag
	 */
	public ArrayList<Integer> itemsToTag()
	{
		ArrayList<CustomBankTabItems> sortedItems = getCustomBankTagItemsForSections();

		if (sortedItems == null)
		{
			return null;
		}

		ArrayList<Integer> flattenedList = new ArrayList<>();

		for (CustomBankTabItems sortedItem : sortedItems)
		{
			for (CustomBankTabItem customBankTabItem : sortedItem.getItems())
			{
				ArrayList<Integer> itemIds = customBankTabItem.getItemIDs();
				if (itemIds != null)
				{
					for (Integer itemId : itemIds)
					{
						if (!flattenedList.contains(itemId))
						{
							flattenedList.add(itemId);
						}
					}
				}
			}
		}
		return flattenedList;
	}

	/**
	 * Get an ArrayList of the current custom tab's CustomBankTagItems to be tagged sorted into sections
	 */
	public ArrayList<CustomBankTabItems> getCustomBankTagItemsForSections()
	{
		return null;
	}

	/**
	 * Get whether or not the bank's tab should be sorted into sections, or left to whatever the default Bank Tab behaviour is
	 */
	public boolean shouldSortTabIntoSections()
	{
		return false;
	}


	/**
	 * Get whether items not in the bank and without a placeholder should be represented in the plugin's bank tab
	 */
	public boolean shouldShowMissingItems()
	{
		return false;
	}
}
