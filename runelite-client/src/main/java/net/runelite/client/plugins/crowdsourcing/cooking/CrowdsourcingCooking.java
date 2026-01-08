/*
 * Copyright (c) 2019, Weird Gloop <admin@weirdgloop.org>
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

package net.runelite.client.plugins.crowdsourcing.cooking;

import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemContainer;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;

public class CrowdsourcingCooking
{
	private static final int HOSIDIUS_KITCHEN_REGION = 6712;

	@Inject
	private CrowdsourcingManager manager;

	@Inject
	private Client client;

	private int lastGameObjectClicked;

	private boolean hasCookingGauntlets()
	{
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.WORN);
		if (equipmentContainer == null)
		{
			return false;
		}

		return equipmentContainer.contains(ItemID.GAUNTLETS_OF_COOKING);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();
		// Message prefixes taken from CookingPlugin
		if (message.startsWith("You successfully cook")
			|| message.startsWith("You successfully bake")
			|| message.startsWith("You successfully fry")
			|| message.startsWith("You manage to cook")
			|| message.startsWith("You roast a")
			|| message.startsWith("You spit-roast")
			|| message.startsWith("You cook")
			|| message.equals("You burn the mushroom in the fire.")
			|| message.startsWith("Eventually the Jubbly")
			|| message.startsWith("Unfortunately the Jubbly")
			|| message.startsWith("You accidentally burn")
			|| message.startsWith("You half-cook")
			|| message.startsWith("The undead meat is now cooked")
			|| message.startsWith("The undead chicken is now cooked")
			|| message.startsWith("You successfully scramble")
			|| message.startsWith("You accidentally spoil"))
		{
			boolean inHosidiusKitchen = false;
			Player local = client.getLocalPlayer();
			if (local != null && local.getWorldLocation().getRegionID() == HOSIDIUS_KITCHEN_REGION)
			{
				inHosidiusKitchen = true;
			}

			int cookingLevel = client.getBoostedSkillLevel(Skill.COOKING);
			boolean hasCookingGauntlets = hasCookingGauntlets();
			boolean kourendElite = client.getVarbitValue(VarbitID.KOUREND_DIARY_ELITE_COMPLETE) == 1;
			CookingData data = new CookingData(message, hasCookingGauntlets, inHosidiusKitchen, kourendElite, lastGameObjectClicked, cookingLevel);
			manager.storeEvent(data);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		MenuAction action = menuOptionClicked.getMenuAction();
		if (action == MenuAction.GAME_OBJECT_FIRST_OPTION
			|| action == MenuAction.GAME_OBJECT_SECOND_OPTION
			|| action == MenuAction.GAME_OBJECT_THIRD_OPTION
			|| action == MenuAction.GAME_OBJECT_FOURTH_OPTION
			|| action == MenuAction.GAME_OBJECT_FIFTH_OPTION
			|| (action == MenuAction.WIDGET_TARGET_ON_GAME_OBJECT
				&& client.getSelectedWidget() != null
				&& client.getSelectedWidget().getId() == InterfaceID.Inventory.ITEMS))
		{
			lastGameObjectClicked = menuOptionClicked.getId();
		}
	}
}
