/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.cluescrolls.clues.item;

import java.util.ArrayList;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.client.plugins.banktags.CustomBankTabItem;
import net.runelite.client.plugins.banktags.CustomBankTabItems;

public class AnyRequirementCollection implements ItemRequirement
{
	private final String name;
	private final ItemRequirement[] requirements;

	public AnyRequirementCollection(String name, ItemRequirement... requirements)
	{
		this.name = name;
		this.requirements = requirements;
	}

	@Override
	public boolean fulfilledBy(int itemId)
	{
		for (ItemRequirement requirement : requirements)
		{
			if (requirement.fulfilledBy(itemId))
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean fulfilledBy(Item[] items)
	{
		for (ItemRequirement requirement : requirements)
		{
			if (requirement.fulfilledBy(items))
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public ArrayList<CustomBankTabItems> getPluginBankTabItems(Client client)
	{
		ArrayList<CustomBankTabItems> newSections = new ArrayList<>();

		ArrayList<CustomBankTabItems> allRequirementsResults = new ArrayList<>();

		boolean isSingleObjects = true;
		for (ItemRequirement requirement : requirements)
		{
			ArrayList<CustomBankTabItems> itemTabSections = requirement.getPluginBankTabItems(client);
			allRequirementsResults.addAll(itemTabSections);
			if (itemTabSections.size() > 1)
			{
				isSingleObjects = false;
			}

			for (CustomBankTabItems section : itemTabSections)
			{
				if (section.getItems().size() > 1)
				{
					isSingleObjects = false;
					break;
				}
			}
		}

		// If all requirements are just 1 object, combine together into a single item req
		if (isSingleObjects)
		{
			CustomBankTabItem combinedItems = allRequirementsResults.get(0).getItems().get(0);
			combinedItems.setText(name);

			for (int i = 1; i < allRequirementsResults.size(); i++)
			{
				combinedItems.addItemIDs(allRequirementsResults.get(i).getItems().get(0).getItemIDs());
			}

			newSections.add(new CustomBankTabItems(name, combinedItems));
			return newSections;
		}

		return allRequirementsResults;
	}

	@Override
	public String getCollectiveName(Client client)
	{
		return name;
	}
}
