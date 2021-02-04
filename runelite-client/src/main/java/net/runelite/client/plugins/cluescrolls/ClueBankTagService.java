/*
 * Copyright (c) 2020, Zoinkwiz <https://github.com/Zoinkwiz>
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
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
package net.runelite.client.plugins.cluescrolls;

import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ItemID;
import net.runelite.client.plugins.CustomBankTagService;
import net.runelite.client.plugins.banktags.CustomBankTabItem;
import net.runelite.client.plugins.banktags.CustomBankTabItems;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.plugins.cluescrolls.clues.CoordinateClue;
import net.runelite.client.plugins.cluescrolls.clues.EmoteClue;
import net.runelite.client.plugins.cluescrolls.clues.FairyRingClue;
import net.runelite.client.plugins.cluescrolls.clues.HotColdClue;
import net.runelite.client.plugins.cluescrolls.clues.MapClue;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;

@Singleton
public class ClueBankTagService extends CustomBankTagService
{
	private final ClueScrollPlugin plugin;

	private final HashMap<ClueScroll, ArrayList<CustomBankTabItems>> solutions = new HashMap<>();

	private static final String EMOTE_CLUE_START = "Emote clue solution";
	private static final String DIG_CLUE = "Clue items";

	@Inject
	public ClueBankTagService(ClueScrollPlugin plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean shouldTag(int itemID)
	{
		return itemsToTag().contains(itemID);
	}

	@Override
	public ArrayList<CustomBankTabItems> getCustomBankTagItemsForSections()
	{
		ArrayList<CustomBankTabItems> newList = new ArrayList<>();
		ClueScroll c = plugin.getClue();

		if (solutions.get(c) != null)
		{
			return solutions.get(c);
		}

		if (c == null)
		{
			return newList;
		}
		else if (c instanceof EmoteClue)
		{
			EmoteClue emote = (EmoteClue) c;
			ItemRequirement[] requirements = emote.getItemRequirements();

			newList = requirements[0].getPluginBankTabItems(plugin.getClient());

			for (int i = 1; i < requirements.length; i++)
			{
				ArrayList<CustomBankTabItems> nextNewSections = new ArrayList<>();
				ArrayList<CustomBankTabItems> currentSectionBeingAdded = requirements[i].getPluginBankTabItems(plugin.getClient());
				for (CustomBankTabItems newSection : newList)
				{
					for (CustomBankTabItems customBankTabItems : currentSectionBeingAdded)
					{
						nextNewSections.add(newSection.combineWith(customBankTabItems));
					}
				}
				newList = nextNewSections;
			}

			if (newList.size() == 1)
			{
				newList.get(0).setName(EMOTE_CLUE_START);
			}
			else
			{
				int i = 1;
				for (CustomBankTabItems customBankTabItems : newList)
				{
					customBankTabItems.setName(EMOTE_CLUE_START + " " + i);
					i++;
				}
			}
		}
		else if (c instanceof CoordinateClue || c instanceof HotColdClue || c instanceof FairyRingClue)
		{
			newList.add(new CustomBankTabItems(DIG_CLUE, new CustomBankTabItem(1, "Spade", ItemID.SPADE)));
		}
		else if (c instanceof MapClue)
		{
			MapClue mapClue = (MapClue) c;
			if (mapClue.getObjectId() == -1)
			{
				newList.add(new CustomBankTabItems(DIG_CLUE, new CustomBankTabItem(1, "Spade", ItemID.SPADE)));
			}
		}
		solutions.put(c, newList);
		return newList;
	}

	@Override
	public boolean shouldSortTabIntoSections()
	{
		return true;
	}

	@Override
	public boolean shouldShowMissingItems()
	{
		return true;
	}
}
