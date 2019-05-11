/*
 * Copyright (c) 2019, Bryan Chau(RSN:Laura Brehm) <https://github.com/akarhi>
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
package net.runelite.client.plugins.tobDamageCounter;

import com.google.inject.Provides;
import java.text.DecimalFormat;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


@PluginDescriptor(
		name = "ToB Damage Counter",
		description = "Prints out damage after the fight in ToB",
		tags = {"combat", "npcs", "tob", "damage"},
		enabledByDefault = false
)

public class tobDamageCounterPlugin extends Plugin
{
	private int currentWorld = -1;
	private int DamageCount = 0;
	private int currenthpxp = -1; // setting the current HP XP for now
	private String BossName = null; //to ID the boss to calculate the damage
	private int DamageTaken = 0;
	private int DamageHeal = 0;
	private boolean status = true; //default boolean alive = true, dead = false
	//formatting the number for damage taken and dealt with to look better
	private static final DecimalFormat DAMAGEFORMAT = new DecimalFormat("#,###");
	private static final double XP_RATIO = 1.3333;
	private static final double BOSS_MODIFIER = 1.05;
	//bosses hp for 5 man
	private static final int MAIDENHP = 3500;
	private static final int BLOATHP = 2000;
	private static final int NYLOHP = 2500;
	private static final int SOTHP = 4000;
	private static final int XARPUSHP = 5080;
	private static final int VERZIKHP = 8500;
	private static final boolean ALIVE = true; //
	private static final boolean DEAD = false; //if they're dead they cannot "recreate" the message of being alive
	//locations at ToB
	private static final int MAIDEN_REGION = 12613;
	private static final int MAIDEN_REGION_1 = 12869;
	private static final int BLOAT_REGION = 13125;
	private static final int NYLOCAS_REGION = 13122;
	private static final int SOTETSEG_REGION = 13123;
	private static final int SOTETSEG_REGION2 = 13379;
	private static final int XARPUS_REGION = 12612;
	private static final int VERZIK_REGION = 12611;
	private static final int[] ToB_Region = {MAIDEN_REGION, MAIDEN_REGION_1, BLOAT_REGION, NYLOCAS_REGION,
			SOTETSEG_REGION, SOTETSEG_REGION2, XARPUS_REGION, VERZIK_REGION};
	//setting up the array for a check list
	private static int[] NPCARRAY = {NpcID.THE_MAIDEN_OF_SUGADINTI, NpcID.THE_MAIDEN_OF_SUGADINTI_8361,
			NpcID.THE_MAIDEN_OF_SUGADINTI_8362, NpcID.THE_MAIDEN_OF_SUGADINTI_8363, NpcID.THE_MAIDEN_OF_SUGADINTI_8364,
			NpcID.THE_MAIDEN_OF_SUGADINTI_8365, NpcID.PESTILENT_BLOAT, NpcID.NYLOCAS_VASILIAS,
			NpcID.NYLOCAS_VASILIAS_8355, NpcID.NYLOCAS_VASILIAS_8356, NpcID.NYLOCAS_VASILIAS_8357, NpcID.SOTETSEG,
			NpcID.SOTETSEG_8388, NpcID.XARPUS, NpcID.XARPUS_8339, NpcID.XARPUS_8340, NpcID.XARPUS_8341,
			NpcID.VERZIK_VITUR, NpcID.VERZIK_VITUR_8369, NpcID.VERZIK_VITUR_8370, NpcID.VERZIK_VITUR_8371,
			NpcID.VERZIK_VITUR_8372, NpcID.VERZIK_VITUR_8373, NpcID.VERZIK_VITUR_8374, NpcID.VERZIK_VITUR_8375};


	@Inject
	private Client client;
	@Inject
	private ChatMessageManager chatMessangerManager;
	@Inject
	private tobDamageCounterConfig config;


	@Provides
	tobDamageCounterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(tobDamageCounterConfig.class);
	}


	//every game tick it will go through methods
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
		currenthpxp = client.getSkillExperience(Skill.HITPOINTS);
	}

	//checks for npcID and put the boss name into a string be easier to ID it
	//once the boss is found it will never check it
	private void checkInterAction()
	{
		Player localPlayer = client.getLocalPlayer();
		Actor interacting = localPlayer.getInteracting();
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			if (BossName == null)
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
		int NewXp;
		double damageOutput = 0;
		int XPdrop;
		if (currenthpxp != -1)
		{
			XPdrop = client.getSkillExperience(Skill.HITPOINTS);
			NewXp = XPdrop - currenthpxp;
			currenthpxp = -1;
			damageOutput = NewXp / XP_RATIO;
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
				String interactingName = interacting.getName();
				if (interactingName.equals(BossName))
				{
					DamageCount += (XPtoDamage() * BOSS_MODIFIER);

				}
			}
		}
	}

	//will add the damage that you have taken from the current boss fight
	@Subscribe
	private void onHitsplatApplied(HitsplatApplied Hit)
	{
		if (Hit.getActor().equals(client.getLocalPlayer()))
		{
			DamageTaken += Hit.getHitsplat().getAmount();
		}
		//Will count the boss healing, since hitsplat shows on boss only
		if (Hitsplat.HitsplatType.HEAL.equals(Hit.getHitsplat().getHitsplatType()))
		{
			DamageHeal += Hit.getHitsplat().getAmount();
		}
	}


	//will check for the monster if it died works only on ToB Bosses
	//Verzik has three phases so the program will add up all the damage and prints it into one message
	//because every time she phases she "dies" so making sure the counter doesn't print out the damage for phase 1, 2,
	//and 3.
	@Subscribe
	public void onNpcDespawned(NpcDespawned npc)
	{
		NPC actor = npc.getNpc();
		double Percent = calculatePercent(WorldPoint.fromLocalInstance(client,
				client.getLocalPlayer().getLocalLocation()).getRegionID());
		if (actor.isDead() && actor.getId() == NpcID.VERZIK_VITUR_8375 && status)
		{
			DamagePrint(actor, Percent);
			ResetCounter();
		}
		else if (actor.isDead() && actor.getName().equals(BossName) && actor.getId() != NpcID.VERZIK_VITUR_8374 &&
				actor.getId() != NpcID.VERZIK_VITUR_8372 &&  actor.getId() != NpcID.VERZIK_VITUR_8370 &&
				status)
		{
			DamagePrint(actor, Percent);
			ResetCounter();
		}
		//will reset the counter after the boss dies and if you died during the fight
		else if (actor.isDead() && actor.getName().equals(BossName) && !status)
		{
			ResetCounter();
		}
	}

	//This method change the boss HP due to the party members and healing the boss has done.
	//Afterwards the HP will become a percentage
	private double calculatePercent(int id)
	{
		final double PERCENTAGECHANGE = 100;
		double percent = 0;
		if (DamageCount != 0)
		{
			if (id == MAIDEN_REGION || id == MAIDEN_REGION_1)
			{
				percent = (DamageCount / (ToBScaling(MAIDENHP) + DamageHeal)) * PERCENTAGECHANGE;
			}
			else if (id == BLOAT_REGION)
			{
				percent = (DamageCount / ToBScaling(BLOATHP)) * PERCENTAGECHANGE;
			}
			else if (id == NYLOCAS_REGION)
			{
				percent = (DamageCount / (ToBScaling(NYLOHP) * HealPercent(DamageHeal))) * PERCENTAGECHANGE;
			}
			else if (id == SOTETSEG_REGION || id == SOTETSEG_REGION2)
			{
				percent = (DamageCount / ToBScaling(SOTHP)  * PERCENTAGECHANGE);
			}
			else if (id == XARPUS_REGION)
			{
				percent = (DamageCount / ToBScaling(XARPUSHP) * PERCENTAGECHANGE);
			}
			else if (id == VERZIK_REGION)
			{
				percent = (DamageCount / (ToBScaling(VERZIKHP) * HealPercent(DamageHeal))) * PERCENTAGECHANGE;
			}
		}
		return percent;
	}


	//This method changes the boss hp to scale to the number of party members and returns the HP
	//if there more than 5 parry members will not change
	private double ToBScaling(int bossHP)
	{
		double newBossHP;
		if (config.tobParty() <= 3)
		{
			newBossHP = bossHP * .75;
		}
		else if (config.tobParty() == 4)
		{
			newBossHP = bossHP * .875;
		}
		else
		{
			return bossHP;
		}

		return newBossHP;
	}


	//In ToB when a boss heal its a percentage of there total health except in Maiden
	private double HealPercent(double heal)
	{
		final double PERCENTAGENUM = 100;
		double healing = heal / PERCENTAGENUM;
		healing += 1;
		return healing;
	}

	//just reset the counter for the next fight and status
	private void ResetCounter()
	{
		DamageCount = 0;
		DamageTaken = 0;
		DamageHeal = 0;
		BossName = null;
		status = ALIVE;
	}

	//print out the damage after the boss have died
	//prevent people from spectating to get the damage message, it is impossible for them to get damage
	private void DamagePrint(NPC actor, double percent)
	{
		String Encouragement;
		String DamagePer;
		if (percent >= 50)
		{
			Encouragement = "Well done carrying the fucking boulders in your team! WOWEEW";
			DamagePer = "You did " + String.format("%.2f", percent) + "% of the damage " +
					actor.getName() + "!";
		}
		else if (percent >= 25)
		{
			Encouragement = "Well done carrying some dead weight in your team! Awesome!";
			DamagePer = "You did " + String.format("%.2f", percent) + "% of the damage " +
					actor.getName() + "!";
		}
		else if (percent >= 1)
		{
			Encouragement = "Well done everyone is pulling their weight!";
			DamagePer = "You did " + String.format("%.2f", percent) + "% of the damage " +
					actor.getName() + "!";
		}
		else
		{
			Encouragement = "YOU'RE LEECHING!";
			DamagePer = "You the leech did " + String.format("%.2f", percent) + "% of the damage " +
					actor.getName() + "!";
		}

		if (config.tobEncouragement())
		{
			sendChatMessage(Encouragement);
		}

		sendChatMessage(DamagePer);

		if (config.tobDamageTaken())
		{
			String MessageTaken = "You have taken " + DAMAGEFORMAT.format(DamageTaken) + " damage from this fight!";
			sendChatMessage(MessageTaken);
		}

	}

	//Whenever you have died in tob you will get a death message with damage given and taken.
	//Made sure the message works at ToB area or else it will message every where you died
	@Subscribe
	public void onLocalPlayerDeath(LocalPlayerDeath dead)
	{
		double Percent = calculatePercent(WorldPoint.fromLocalInstance(client,
				client.getLocalPlayer().getLocalLocation()).getRegionID());

		String Encouragement = "PLANKER!!!!!";
		String Damageper = "You did " + String.format("%.2f", Percent) + "% of the damage" +
				BossName + "!";

		String MessageTaken = "You have taken " + DAMAGEFORMAT.format(DamageTaken) + " damage from this fight!";
		for (int i = 0; i < ToB_Region.length; i++)
		{
			if (WorldPoint.fromLocalInstance(client,
					client.getLocalPlayer().getLocalLocation()).getRegionID() == ToB_Region[i])
			{
				if (config.tobEncouragement())
				{
					sendChatMessage(Encouragement);
				}

				sendChatMessage(Damageper);

				if (config.tobDamageTaken())
				{
					sendChatMessage(MessageTaken);
				}

				ResetCounter();
				//status will become "dead" after you died in the fight
				status = DEAD;
			}

		}
	}

	//sends a message saying this "You have done XYZ damage to boss name! or the death message
	//"Well done! you have done your best, you have done XYZ damage to boss name
	private void sendChatMessage(String chatMessage)
	{
		final String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append(chatMessage)
				.build();
		chatMessangerManager.queue(
				QueuedMessage.builder()
						.type(ChatMessageType.CONSOLE)
						.runeLiteFormattedMessage(message)
						.build());

	}

}
