/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.theatreofblood;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.theatreofblood.data.Attempt;
import net.runelite.client.plugins.theatreofblood.data.AttemptTotal;
import net.runelite.client.plugins.theatreofblood.data.BossExpModifier;
import net.runelite.client.plugins.theatreofblood.data.NpcHps;
import net.runelite.client.plugins.theatreofblood.data.RoomStat;

@PluginDescriptor(
	name = "ToB Stats",
	description = "Shows stats for your Theatre of Blood attempts",
	tags = {"theatre", "blood", "tob", "stats", "raids"}
)
@Slf4j
public class TheatreOfBloodPlugin extends Plugin
{
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");
	private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#,###");

	private static final int LOBBY_REGION = 14642;
	private static final int MAIDEN_REGION = 12869;
	private static final int BLOAT_REGION = 13125;
	private static final int NYLOCAS_REGION = 13122;
	private static final int SOTETSEG_REGION = 13123;
	private static final int XARPUS_REGION = 12612;
	private static final int VERZIK_REGION = 12611;
	private static final int REWARD_REGION = 12867;

	// For every damage point dealt, 1.33 experience is given to the player's hitpoints (base rate)
	private static final double HITPOINT_RATIO = 1.33;

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private TheatreOfBloodConfig config;

	private Attempt current;
	private RoomStat room;
	private final List<Attempt> attempts = new ArrayList<>();
	private int state = 0;
	private int region = 0;
	private double hpExp = 0;
	private Actor oldTarget;
	private boolean isSpectator = false;

	@Provides
	TheatreOfBloodConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TheatreOfBloodConfig.class);
	}

	@Override
	protected void shutDown()
	{
		attempts.clear();
		state = -1;
	}

	@Subscribe
	protected void onVarbitChanged(VarbitChanged e)
	{
		int old = state;
		state = client.getVar(Varbits.THEATRE_OF_BLOOD);
		if (old != state)
		{
			stateChanged(old);
		}
	}

	@Subscribe
	protected void onHitsplatApplied(HitsplatApplied e)
	{
		// Hitsplat on us while inside Theatre of Blood means we took damage
		if (state == 2 && e.getActor().equals(client.getLocalPlayer()))
		{
			current.addDamageTaken(e.getHitsplat().getAmount());
			room.addDamageTaken(e.getHitsplat().getAmount());
		}
	}

	@Subscribe
	protected void onExperienceChanged(ExperienceChanged c)
	{
		if (c.getSkill().equals(Skill.HITPOINTS) && state >= 2)
		{
			// Calculate XP difference for HP skill and calculate damage based off it
			double oldExp = hpExp;
			hpExp = client.getSkillExperience(Skill.HITPOINTS);
			double diff = hpExp - oldExp;
			if (diff < 1)
			{
				return;
			}
			double damageDealt = calculateDamageDealt(diff);

			// Add damage dealt to the current logs
			log.debug("Damage Dealt: {} | Exact: {}", Math.round(damageDealt), damageDealt);
			current.addDamageDealt(damageDealt);
			room.addDamageDealt(damageDealt);
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (!isSpectator && state >= 1 && event.getGameState() == GameState.LOGGED_IN)
		{
			// LOGGED_IN is triggered between region changes
			int oldRegion = region;
			region = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();

			if (region != oldRegion)
			{
				handleRegionChange();
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (!isSpectator && state == 2)
		{
			oldTarget = client.getLocalPlayer().getInteracting();
		}
	}

	/**
	 * Handles changes to the Theatre of Blood Varbit
	 * @param old previous Theatre of Blood varbit value
	 */
	private void stateChanged(int old)
	{
		// TODO: Figure out a way to determine if they are logging back into a raid
		// 0=default | 1=party | 2=inside/spectator | 3=dead-spectator
		switch (state)
		{
			case 0:
				if (old == 2)
				{
					isSpectator = false;
					return;
				}
				current = null;
				break;
			case 1:
				if (old == 0)
				{
					// Starting a new raid
					hpExp = client.getSkillExperience(Skill.HITPOINTS);
					current = new Attempt();
				}
				else
				{
					// Back to just in a party, submit the raid
					if (!current.isCompleted())
					{
						// Didn't finish room but complete anyway
						roomCompleted();
					}
					else
					{
						currentMessage();
					}
					submitAttempt();
				}
				break;
			case 2:
				// Inside the Theatre, are they a spectator?
				if (old == 0)
				{
					isSpectator = true;
					return;
				}
				break;
			case 3:
				if (old == 0)
				{
					log.debug("Logged out and returned to non-existing raid");
					return;
				}
				// Died, increment attempt death counter.
				current.addDeath();
				room.setDied(true);
				break;
		}
	}

	/**
	 * Handles region changes while inside Theatre of Blood
	 *
	 */
	private void handleRegionChange()
	{
		int act;
		switch (region)
		{
			case MAIDEN_REGION:
				act = 1;
				break;
			case BLOAT_REGION:
				act = 2;
				break;
			case NYLOCAS_REGION:
				act = 3;
				break;
			case SOTETSEG_REGION:
				act = 4;
				break;
			case XARPUS_REGION:
				act = 5;
				break;
			case VERZIK_REGION:
				act = 6;
				break;
			case REWARD_REGION:
				current.setCompleted(true);
				roomCompleted();
				return;
			case LOBBY_REGION:
			default:
				// Don't create a new room if they end up in the lobby or somewhere else
				return;
		}

		// Went to new room which means last room was completed.
		if (act > 1)
		{
			roomCompleted();
		}

		// Create a room stat for the next act
		room = new RoomStat();
		room.setAct(act);
		log.debug("Starting act {}", act);
	}

	private void roomCompleted()
	{
		if (room == null)
		{
			log.warn("Tried completing a null room");
			return;
		}

		// Add RoomStat to current Attempt
		current.addRoomStat(room);
		log.debug("Completed act {}", room.getAct());
		roomMessage();
		currentMessage();
		room = null;
	}

	private void submitAttempt()
	{
		totalMessage();
		attempts.add(current);
		current = new Attempt();
	}

	/**
	 * Estimate NPCs current health based on passed parameters
	 *
	 * Slightly modified version of what the OpponentInformation plugin does
	 *
	 * @param healthRatio Current amount of bars above NPCs head
	 * @param health Maximum amount of bars above NPCs head
	 * @param maxHP Maximum HP of NPC (full hp bar)
	 * @return estimated current health
	 */
	private int getCurrentHealth(int healthRatio, int health, int maxHP)
	{
		int currentHealth = -1;

		if (healthRatio >= 0 && health > 0)
		{
			// This is the reverse of the calculation of healthRatio done by the server
			// which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
			// It's able to recover the exact health if maxHealth <= healthScale.
			if (healthRatio > 0)
			{
				int minHealth = 1;
				int maxHealth;
				if (health > 1)
				{
					if (healthRatio > 1)
					{
						// This doesn't apply if healthRatio = 1, because of the special case in the server calculation that
						// health = 0 forces healthRatio = 0 instead of the expected healthRatio = 1
						minHealth = (maxHP * (healthRatio - 1) + health - 2) / (health - 1);
					}
					maxHealth = (maxHP * healthRatio - 1) / (health - 1);
					if (maxHealth > maxHP)
					{
						maxHealth = maxHP;
					}
				}
				else
				{
					// If healthScale is 1, healthRatio will always be 1 unless health = 0
					// so we know nothing about the upper limit except that it can't be higher than maxHealth
					maxHealth = maxHP;
				}
				// Take the average of min and max possible healths
				currentHealth = (minHealth + maxHealth + 1) / 2;
			}
		}

		return currentHealth;
	}

	/**
	 * Calculates damage dealt based on HP xp gained
	 * @param diff HP xp gained
	 * @return damage dealt
	 */
	private double calculateDamageDealt(double diff)
	{
		double damageDealt = diff / HITPOINT_RATIO;

		// Determine which NPC we attacked.
		NPC target = (NPC) client.getLocalPlayer().getInteracting();
		if (target == null)
		{
			// If we are interacting with nothing we may have clicked away at the perfect time
			// Fall back to the actor we were interacting with last game tick
			if (oldTarget == null)
			{
				log.warn("Couldn't find current or past target...");
				return damageDealt;
			}
			target = (NPC) oldTarget;
		}

		// Account for Verzik phases by NPC id
		String targetName = target.getName();
		if (targetName.toLowerCase().contains("verzik"))
		{
			targetName = BossExpModifier.getBossNameByNpcId(target.getId());
		}
		log.debug("Attacking NPC named: {}", targetName);

		// Some NPCs have an XP modifier, account for that.
		BossExpModifier m = BossExpModifier.getByName(targetName);
		if (m != null)
		{
			damageDealt = damageDealt / BossExpModifier.calculateBonus(m);
		}

		// We need to limit damage dealt to the current NPCs health for weapons that can overhit, such as Scythe
		log.debug("Ratio: {} | Health: {}", target.getHealthRatio(), target.getHealth());
		int maxHP = NpcHps.getMaxHpByNpcName(targetName);
		log.debug("Max HP: {}", maxHP);
		int currentHP = getCurrentHealth(target.getHealthRatio(), target.getHealth(), maxHP);
		log.debug("Current Hp: {}", currentHP);

		if (currentHP > -1 && damageDealt > currentHP)
		{
			damageDealt = currentHP;
		}

		return damageDealt;
	}

	private void roomMessage()
	{
		if (config.showRoomChatMessages())
		{
			String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Room Stats: ")
				.append(ChatColorType.NORMAL)
				.append("Damage Taken: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(NUMBER_FORMAT.format(room.getDamageTaken()))
				.append(ChatColorType.NORMAL)
				.append(", Damage Dealt: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(NUMBER_FORMAT.format(room.getDamageDealt()))
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CLANCHAT_INFO)
				.runeLiteFormattedMessage(chatMessage)
				.build());
		}
	}

	private void currentMessage()
	{
		if (config.showCurrentRaidChatMessages())
		{
			String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Current Raid Stats: ")
				.append(ChatColorType.NORMAL)
				.append("Damage Taken: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(NUMBER_FORMAT.format(current.getDamageTaken()))
				.append(ChatColorType.NORMAL)
				.append(", Damage Dealt: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(NUMBER_FORMAT.format(current.getDamageDealt()))
				.append(ChatColorType.NORMAL)
				.append(", Death Count: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(current.getDeathCount()))
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CLANCHAT_INFO)
				.runeLiteFormattedMessage(chatMessage)
				.build());
		}

	}

	private void totalMessage()
	{
		if (config.showTotalRaidChatMessages())
		{
			AttemptTotal total = new AttemptTotal(attempts);
			total.addAttempt(current);

			String title = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Session Raid Stats: ")
				.append(ChatColorType.NORMAL)
				.append("Attempted: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(total.getAttempts()))
				.append(ChatColorType.NORMAL)
				.append(", Completed: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(total.getCompletions()))
				.append(", (")
				.append(ChatColorType.HIGHLIGHT)
				.append(DECIMAL_FORMAT.format(total.getCompletions() / total.getAttempts()))
				.append("%)")
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CLANCHAT_INFO)
				.runeLiteFormattedMessage(title)
				.build());

			String chatMessage = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("Session Raid Stats: ")
				.append(ChatColorType.NORMAL)
				.append("Damage Taken: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(NUMBER_FORMAT.format(total.getDamageTaken()))
				.append(ChatColorType.NORMAL)
				.append(", Damage Dealt: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(NUMBER_FORMAT.format(total.getDamageDealt()))
				.append(ChatColorType.NORMAL)
				.append(", Death Count: ")
				.append(ChatColorType.HIGHLIGHT)
				.append(String.valueOf(total.getDeathCount()))
				.build();

			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CLANCHAT_INFO)
				.runeLiteFormattedMessage(chatMessage)
				.build());
		}
	}
}
