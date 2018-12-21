/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.specialcounter;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Special Attack Counter",
	description = "Track DWH, Arclight, Darklight, and BGS special attacks used on NPCs",
	tags = {"combat", "npcs", "overlay"},
	enabledByDefault = false
)
public class SpecialCounterPlugin extends Plugin
{
	private int currentWorld = -1;
	private int specialPercentage = -1;
	private int specialHitpointsExperience = -1;
	private boolean specialUsed;
	private double modifier = 1d;

	private SpecialWeapon specialWeapon;
	private final Set<Integer> interactedNpcIds = new HashSet<>();
	private final SpecialCounter[] specialCounter = new SpecialCounter[SpecialWeapon.values().length];

	@Inject
	private Client client;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Override
	protected void shutDown()
	{
		removeCounters();
	}

	@Subscribe
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
				removeCounters();
			}
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int specialPercentage = client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT);

		if (this.specialPercentage == -1 || specialPercentage >= this.specialPercentage)
		{
			this.specialPercentage = specialPercentage;
			return;
		}

		this.specialPercentage = specialPercentage;
		this.specialWeapon = usedSpecialWeapon();

		checkInteracting();

		specialUsed = true;
		specialHitpointsExperience = client.getSkillExperience(Skill.HITPOINTS);
	}

	@Subscribe
	private void onGameTick(GameTick tick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		checkInteracting();

		if (specialHitpointsExperience != -1 && specialUsed)
		{
			specialUsed = false;
			int hpXp = client.getSkillExperience(Skill.HITPOINTS);
			int deltaExperience = hpXp - specialHitpointsExperience;
			specialHitpointsExperience = -1;

			if (deltaExperience > 0)
			{
				if (specialWeapon != null)
				{
					updateCounter(specialWeapon, deltaExperience);
				}
			}
		}
	}

	private void checkInteracting()
	{
		Player localPlayer = client.getLocalPlayer();
		Actor interacting = localPlayer.getInteracting();

		if (interacting instanceof NPC)
		{
			int interactingId = ((NPC) interacting).getId();

			if (!interactedNpcIds.contains(interactingId))
			{
				removeCounters();
				modifier = 1d;
				interactedNpcIds.add(interactingId);

				final Boss boss = Boss.getBoss(interactingId);
				if (boss != null)
				{
					modifier = boss.getModifier();
					interactedNpcIds.addAll(boss.getIds());
				}

			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC actor = npcDespawned.getNpc();

		if (actor.isDead() && interactedNpcIds.contains(actor.getId()))
		{
			removeCounters();
		}
	}

	private SpecialWeapon usedSpecialWeapon()
	{
		ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipment == null)
		{
			return null;
		}

		Item[] items = equipment.getItems();
		int weaponIdx = EquipmentInventorySlot.WEAPON.getSlotIdx();

		if (items == null || weaponIdx >= items.length)
		{
			return null;
		}

		Item weapon = items[weaponIdx];

		for (SpecialWeapon specialWeapon : SpecialWeapon.values())
		{
			if (specialWeapon.getItemID() == weapon.getId())
			{
				return specialWeapon;
			}
		}
		return null;
	}

	private void updateCounter(SpecialWeapon specialWeapon, int deltaExperience)
	{
		SpecialCounter counter = specialCounter[specialWeapon.ordinal()];
		int hit = getHit(specialWeapon, deltaExperience);

		if (counter == null)
		{
			counter = new SpecialCounter(itemManager.getImage(specialWeapon.getItemID()), this,
				hit, specialWeapon);
			infoBoxManager.addInfoBox(counter);
			specialCounter[specialWeapon.ordinal()] = counter;
		}
		else
		{
			counter.addHits(hit);
		}
	}

	private void removeCounters()
	{
		interactedNpcIds.clear();

		for (int i = 0; i < specialCounter.length; ++i)
		{
			SpecialCounter counter = specialCounter[i];

			if (counter != null)
			{
				infoBoxManager.removeInfoBox(counter);
				specialCounter[i] = null;
			}
		}
	}

	private int getHit(SpecialWeapon specialWeapon, int deltaExperience)
	{
		double modifierBase = 1d / modifier;
		double damageOutput = (deltaExperience * modifierBase) / 1.3333d;

		if (!specialWeapon.isDamage())
		{
			return 1;
		}
		else
		{
			return (int) Math.round(damageOutput);
		}
	}
}