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

package net.runelite.client.plugins.crowdsourcing.thieving;

import java.util.regex.Pattern;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.crowdsourcing.CrowdsourcingManager;

public class CrowdsourcingThieving
{
	private static final String BLACKJACK_SUCCESS = "You smack the bandit over the head and render them unconscious.";
	private static final String BLACKJACK_FAIL = "Your blow only glances off the bandit's head.";
	private static final Pattern PICKPOCKET_SUCCESS = Pattern.compile("You pick .*'s pocket\\.");
	private static final Pattern PICKPOCKET_FAIL = Pattern.compile("You fail to pick .*'s pocket\\.");

	@Inject
	private Client client;

	@Inject
	private CrowdsourcingManager manager;

	private int lastPickpocketTarget;

	private boolean hasGlovesOfSilence()
	{
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipmentContainer == null)
		{
			return false;
		}

		return equipmentContainer.contains(ItemID.GLOVES_OF_SILENCE);
	}

	private boolean hasThievingCape()
	{
		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipmentContainer == null)
		{
			return false;
		}

		return equipmentContainer.contains(ItemID.THIEVING_CAPE) ||
			equipmentContainer.contains(ItemID.THIEVING_CAPET) ||
			equipmentContainer.contains(ItemID.MAX_CAPE);
	}

	private int getArdougneDiary()
	{
		int easy = client.getVar(Varbits.DIARY_ARDOUGNE_EASY);
		int medium = client.getVar(Varbits.DIARY_ARDOUGNE_MEDIUM);
		int hard = client.getVar(Varbits.DIARY_ARDOUGNE_HARD);
		int elite = client.getVar(Varbits.DIARY_ARDOUGNE_ELITE);
		return easy + 2 * medium + 4 * hard + 8 * elite;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String message = event.getMessage();
		if (BLACKJACK_SUCCESS.equals(message)
			|| BLACKJACK_FAIL.equals(message)
			|| PICKPOCKET_FAIL.matcher(message).matches()
			|| PICKPOCKET_SUCCESS.matcher(message).matches())
		{
			WorldPoint location = client.getLocalPlayer().getWorldLocation();
			int ardougneDiary = getArdougneDiary();
			boolean silence = hasGlovesOfSilence();
			boolean thievingCape = hasThievingCape();
			int thievingLevel = client.getBoostedSkillLevel(Skill.THIEVING);
			PickpocketData data = new PickpocketData(thievingLevel, lastPickpocketTarget, message, location, silence, thievingCape, ardougneDiary);
			manager.storeEvent(data);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuOption().equals("Pickpocket") || event.getMenuOption().equals("Knock-Out"))
		{
			NPC[] cachedNPCs = client.getCachedNPCs();
			NPC npc = cachedNPCs[event.getId()];
			lastPickpocketTarget = npc.getId();
		}
	}
}
