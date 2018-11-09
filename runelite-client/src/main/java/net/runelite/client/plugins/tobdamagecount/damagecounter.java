/*
 * Copyright (c) 2018, Bryan Chau(RSN:Laura Brehm) <https://github.com/akarhi>
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

package net.runelite.client.plugins.tobdamagecount;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Skill;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ActorDespawned;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
		name = "ToB Damage Counter",
		description = "Gives you an estimation damage on a boss after the fight is done" +
				"the damage will be posted in chat",
		tags = {"combat", "npcs", "tob", "damage"},
		enabledByDefault = false
)

public class damagecounter extends Plugin
{
	private int currentWorld = -1;
	private int DamageCount;
	private String BossName;
	private int currenthp = -1;
	private boolean bossfound = false;

	//locations at ToB
	private static final int MAIDEN_REGION = 12613;
	private static final int MAIDEN_REGION_1 = 12869;
	private static final int BLOAT_REGION = 13125;
	private static final int NYLOCAS_REGION = 13122;
	private static final int SOTETSEG_REGION = 13123;
	private static final int XARPUS_REGION = 12612;
	private static final int VERZIK_REGION = 12611;
	private static final int[] ToB_Region = {MAIDEN_REGION, MAIDEN_REGION_1, BLOAT_REGION, NYLOCAS_REGION,
			SOTETSEG_REGION, XARPUS_REGION, VERZIK_REGION};

	//setting up the array for a check list
	private static int[] NPCARRAY = {NpcID.THE_MAIDEN_OF_SUGADINTI, NpcID.THE_MAIDEN_OF_SUGADINTI_8361,
			NpcID.THE_MAIDEN_OF_SUGADINTI_8362, NpcID.THE_MAIDEN_OF_SUGADINTI_8363, NpcID.THE_MAIDEN_OF_SUGADINTI_8364,
			NpcID.THE_MAIDEN_OF_SUGADINTI_8365, NpcID.PESTILENT_BLOAT, NpcID.NYLOCAS_VASILIAS, NpcID.NYLOCAS_VASILIAS_8355,
			NpcID.NYLOCAS_VASILIAS_8356, NpcID.NYLOCAS_VASILIAS_8357, NpcID.SOTETSEG, NpcID.SOTETSEG_8388, NpcID.XARPUS,
			NpcID.XARPUS_8339, NpcID.XARPUS_8340, NpcID.XARPUS_8341, NpcID.VERZIK_VITUR, NpcID.VERZIK_VITUR_8369,
			NpcID.VERZIK_VITUR_8370, NpcID.VERZIK_VITUR_8371, NpcID.VERZIK_VITUR_8372, NpcID.VERZIK_VITUR_8373,
			NpcID.VERZIK_VITUR_8374, NpcID.VERZIK_VITUR_8375};

	@Inject
	private Client client;
	@Inject
	private ChatMessageManager chatMessangerManager;
	//every gametick it will check these methods
	@Subscribe
	private void onGameTick(GameTick tick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			ResetCounter();
			return;
		}
		checkInterAction();
		DamageCounting();
		currenthp = client.getSkillExperience(Skill.HITPOINTS);
	}
	//checks for npcID and put the boss name into a string be easier to ID it
	//once the boss is found it will never check it
	private void checkInterAction()
	{
		Player localPlayer = client.getLocalPlayer();
		Actor interacting = localPlayer.getInteracting();
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			if (!bossfound)
			{
				if (interacting instanceof NPC)
				{
					int interactingId = ((NPC) interacting).getId();
					String interactingName = interacting.getName();
					for (int aNPCARRAY : NPCARRAY)
					{
						if (aNPCARRAY == interactingId)
						{
							BossName = interactingName;
							this.bossfound = true;
						}
					}
				}
			}
		}
	}

	@Subscribe
	//if you hop it will reset the counter
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (currentWorld == -1)
			{
				currentWorld = client.getWorld();
			}
			else if (currentWorld != client.getWorld())
			{
				currentWorld = client.getWorld();
				ResetCounter();
			}
		}
	}

	//grabbing the xp and calculating the damage
	private int XPtoDamage()
	{
		int NewXp = 0;
		double damageOutput = 0;
		int XPdrop = 0;
		if (currenthp != -1)
		{
			XPdrop = client.getSkillExperience(Skill.HITPOINTS);
			NewXp = XPdrop - currenthp;
			currenthp = -1;
			damageOutput = NewXp / 1.3333;
		}
		//returns the damage you have done
		return (int) Math.floor(damageOutput);
	}

	//adding up the damage for the print message checks every tick(aka attack tick)
	private void DamageCounting()
	{
		Player localPlayer = client.getLocalPlayer();
		Actor interacting = localPlayer.getInteracting();
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			if (interacting instanceof NPC)
			{
				String interactingName = ((NPC) interacting).getName();
				if (interactingName == BossName)
				{
					this.DamageCount += XPtoDamage();
				}
			}
		}
	}

	@Subscribe
	//will check for the monster if it died works only on ToB Bosses
	// Verzik has three phases so the program will add up all the damage and prints it into one message
	// making sure else if statement doesnt check with Verzik
	public void onNpcDespawned(ActorDespawned npc)
	{
		NPC actor = (NPC) npc.getActor();
		if (actor.isDead() && actor.getId() == NpcID.VERZIK_VITUR_8375)
		{
			DamagePrint(actor);
			ResetCounter();
		}
		else if (actor.isDead() && actor.getName().equals(BossName) && actor.getId() != NpcID.VERZIK_VITUR_8374 &&
				actor.getId() != NpcID.VERZIK_VITUR_8372 &&  actor.getId() != NpcID.VERZIK_VITUR_8370)
		{
			DamagePrint(actor);
			ResetCounter();
		}
	}

	//just reset the counter
	private void ResetCounter()
	{
		this.DamageCount = 0;
		BossName = null;
		this.bossfound = false;
	}

	//print out the damage after the boss have died
	private void DamagePrint(NPC actor)
	{
		String MessageDamage = "Well done! You have done " + this.DamageCount + " damage to " + actor.getName() + "!";
		sendChatMessage(MessageDamage);
	}

	@Subscribe
	//whenever you have died in tob you will get a death message with damage
	// made sure the message works at ToB area or else we will get it every where
	private void Death(LocalPlayerDeath death)
	{
		String DeathMessage = "You have tried your best! You have done " + this.DamageCount + " damage to this " +
				BossName + "!";
		for (int i = 0; i < ToB_Region.length; i++)
		{
			if (client.getLocalPlayer().getWorldLocation().getRegionID() == ToB_Region[i])
			{
				sendChatMessage(DeathMessage);
				ResetCounter();
			}
		}
	}

	//sends a message saying this "You have done XYZ damage to boss name! or the death message
	// "Well done! you have done your best, you have done XYZ damage to boss name
	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(chatMessage)
				.build();
		chatMessangerManager.queue(
				QueuedMessage.builder()
						.type(ChatMessageType.GAME)
						.runeLiteFormattedMessage(message)
						.build());
	}
}