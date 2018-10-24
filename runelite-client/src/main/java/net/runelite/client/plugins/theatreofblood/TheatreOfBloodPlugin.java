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
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.theatreofblood.data.Attempt;
import net.runelite.client.plugins.theatreofblood.data.BossExpModifier;
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
		}
	}

	@Subscribe
	protected void onExperienceChanged(ExperienceChanged c)
	{
		if (c.getSkill().equals(Skill.HITPOINTS))
		{
			if (state >= 2)
			{
				double oldExp = hpExp;
				hpExp = client.getSkillExperience(Skill.HITPOINTS);
				double diff = hpExp - oldExp;
				double damageDealt = diff / HITPOINT_RATIO;

				// Account for NPCs that give bonus xp
				NPC target = (NPC) client.getLocalPlayer().getInteracting();
				String targetName = target.getName();
				// Account for Verzik phases by NPC id
				if (targetName.toLowerCase().contains("verzik"))
				{
					targetName = BossExpModifier.getBossNameByNpcId(target.getId());
				}
				BossExpModifier m = BossExpModifier.getByName(targetName);
				if (m != null)
				{
					damageDealt = damageDealt / BossExpModifier.calculateBonus(m);
				}

				current.addDamageDealt(damageDealt);
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			// LOGGED_IN is triggered between region changes too.
			int oldRegion = region;
			region = client.getLocalPlayer().getWorldLocation().getRegionID();

			if (region == REWARD_REGION)
			{
				current.setCompleted(true);
			}
		}
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
				break;
		}
	}
}
