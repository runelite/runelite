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
import java.util.LinkedHashMap;
import net.runelite.client.plugins.banktags.PluginBankTabItem;

public class PluginBankTagService
{
	/**
	 * Get whether the provided item should be tagged
	 */
	public boolean shouldTag(int itemID)
	{
		return false;
	}

	/**
	 * Get a list of the plugin's current items to tag
	 */
	public ArrayList<Integer> itemsToTag()
	{
		LinkedHashMap<String, ArrayList<PluginBankTabItem>> sortedItems = tabItemsAsPluginBankTagItem();

		ArrayList<Integer> flattenedList = new ArrayList<>();
		for (String key : sortedItems.keySet())
		{
			for (PluginBankTabItem pluginBankTabItem : sortedItems.get(key))
			{
				flattenedList.add(pluginBankTabItem.getItemID());
			}
		}
		return flattenedList;
	}

	/**
	 * Get a LinkedHashMap of the current plugin's PluginBankTagItem to be tagged sorted into sections
	 */
	public LinkedHashMap<String, ArrayList<PluginBankTabItem>> tabItemsAsPluginBankTagItem()
	{
		return null;
	}

	/**
	 * Get whether items not in the bank and without a placeholder should be represented in the plugin's bank tab
	 */
	public boolean shouldShowMissingItems()
	{
		return false;
	}
}
