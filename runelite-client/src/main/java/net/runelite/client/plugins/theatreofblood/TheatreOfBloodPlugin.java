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
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.theatreofblood.data.Attempt;
import net.runelite.client.plugins.theatreofblood.data.BossExpModifier;
import net.runelite.client.plugins.theatreofblood.data.NpcHps;
import net.runelite.client.plugins.theatreofblood.data.RoomStat;
import net.runelite.client.ui.overlay.OverlayManager;


@PluginDescriptor(
	name = "ToB Stats",
	description = "Shows stats for your Theatre of Blood attempts",
	tags = {"theatre", "blood", "tob", "stats", "raids"}
)
@Slf4j
public class TheatreOfBloodPlugin extends Plugin
{
	// Boss Regions
	private static final int MAIDEN_REGION = 12613;
	private static final int BLOAT_REGION = 13125;
	private static final int NYLOCAS_REGION = 13122;
	private static final int SOTETSEG_REGION = 13123;
	private static final int XARPUS_REGION = 12612;
	private static final int VERZIK_REGION = 12611;

	private static final int LOBBY_REGION = 14642;
	private static final int REWARD_REGION = 12867;

	// For every damage point dealt, 1.33 experience is given to the player's hitpoints
	private static final double HITPOINT_RATIO = 1.33;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StatOverlay overlay;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Getter
	private final List<Attempt> attempts = new ArrayList<>();
	private int state = 0;
	private int region = 0;
	private double hpExp = 0;
	@Getter
	private Attempt current;
	@Getter
	private RoomStat room;
	private Actor oldTarget;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		attempts.clear();
		state = 0;
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
		if (state <= 1)
		{
			return;
		}

		// Hitsplat on us = damage taken
		if (e.getActor().equals(client.getLocalPlayer()))
		{
			current.addDamageTaken(e.getHitsplat().getAmount());
			room.addDamageTaken(e.getHitsplat().getAmount());
		}
	}

	@Subscribe
	protected void onExperienceChanged(ExperienceChanged c)
	{
		if (c.getSkill().equals(Skill.HITPOINTS))
		{
			if (state >= 2)
			{
				// Calculate XP difference & damage dealt based on HP ratio
				double oldExp = hpExp;
				hpExp = client.getSkillExperience(Skill.HITPOINTS);
				double diff = hpExp - oldExp;
				if (diff < 1)
				{
					return;
				}
				double damageDealt = diff / HITPOINT_RATIO;

				// Determine which NPC we are attacking, if not interacting with one use last ticks npc
				NPC target = (NPC) client.getLocalPlayer().getInteracting();
				if (target == null) // Sometimes interacting is null if you click off at the right tick
				{
					if (oldTarget == null)
					{
						log.warn("Couldn't find current or past target...");
						return;
					}
					target = (NPC) oldTarget;
				}

				// Account for Verzik phases by NPC id
				String targetName = target.getName();
				if (targetName.toLowerCase().contains("verzik"))
				{
					targetName = BossExpModifier.getBossNameByNpcId(target.getId());
				}

				// Some NPCs have an XP modifier, account for that.
				BossExpModifier m = BossExpModifier.getByName(targetName);
				if (m != null)
				{
					damageDealt = damageDealt / BossExpModifier.calculateBonus(m);
				}

				// We need to limit damageDealt to the current NPCs health for weapons that can overhit, such as Scythe
				log.debug("Ratio: {} | Health: {}", target.getHealthRatio(), target.getHealth());
				int maxHP = NpcHps.getMaxHpByNpcName(targetName);
				log.debug("Max HP: {}", maxHP);
				int currentHP = getCurrentHealth(target.getHealthRatio(), target.getHealth(), maxHP);
				log.debug("Current Hp: {}", currentHP);

				if (currentHP > -1 && damageDealt > currentHP)
				{
					damageDealt = currentHP;
				}

				log.debug("Damage Dealt: {} | {}", Math.round(damageDealt), damageDealt);
				current.addDamageDealt(damageDealt);
				room.addDamageDealt(damageDealt);
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (state >= 1 && event.getGameState() == GameState.LOGGED_IN)
		{
			// LOGGED_IN is triggered between region changes too.
			int oldRegion = region;
			region = client.getLocalPlayer().getWorldLocation().getRegionID();

			if (region != oldRegion)
			{
				handleRegionChange(oldRegion);
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		oldTarget = client.getLocalPlayer().getInteracting();
	}

	private void stateChanged(int old)
	{
		// Wasn't previously doing a raid
		// TODO: Figure out a way to determine if they are logging back into a raid
		if (old == 0)
		{
			hpExp = client.getSkillExperience(Skill.HITPOINTS);
			current = new Attempt();
			return;
		}

		switch (state)
		{
			case 0:
				// Left the Theatre of Blood area
				current = null;
				overlay.reset();
				break;
			case 1:
				// Back to just in a party, must have died/completed a raid
				attempts.add(current);
				current = new Attempt();
				overlay.calculateTotal();
				break;
			case 2:
				// Inside the Theatre (includes spectators), not sure if I need to do anything here.
				break;
			case 3:
				// Died, increment attempt death counter.
				current.addDeath();
				room.setDied(true);
				break;
		}
	}

	private void handleRegionChange(int old)
	{
		if (room != null)
		{
			current.addRoomStat(room);
			room = null;
		}

		int act = -1;
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
				return;
			case LOBBY_REGION:
				// Don't create a new room if they end up in the lobby
				return;
		}

		// Create a new room stat
		room = new RoomStat();
		room.setAct(act);
	}


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
}
