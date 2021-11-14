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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.GameState;
import net.runelite.api.Hitsplat;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.VarPlayer;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ws.PartyService;
import net.runelite.client.ws.WSClient;

@PluginDescriptor(
	name = "Special Attack Counter",
	description = "Track special attacks used on NPCs",
	tags = {"combat", "npcs", "overlay"},
	enabledByDefault = false
)
@Slf4j
public class SpecialCounterPlugin extends Plugin
{
	private static final Set<Integer> IGNORED_NPCS = ImmutableSet.of(
		NpcID.DARK_ENERGY_CORE, NpcID.ZOMBIFIED_SPAWN, NpcID.ZOMBIFIED_SPAWN_8063,
		NpcID.COMBAT_DUMMY, NpcID.UNDEAD_COMBAT_DUMMY,
		NpcID.SKELETON_HELLHOUND_6613, NpcID.GREATER_SKELETON_HELLHOUND
	);
	
	private static final Set<Integer> RESET_ON_LEAVE_INSTANCED_REGIONS = ImmutableSet.of(
			9023, // vorkath
			5536 // hydra
	);

	private int currentWorld;
	private int specialPercentage;
	private Actor lastSpecTarget;
	private int lastSpecTick;

	private int previousRegion;
	private boolean wasInInstance;

	private SpecialWeapon specialWeapon;
	private final Set<Integer> interactedNpcIds = new HashSet<>();
	private final SpecialCounter[] specialCounter = new SpecialCounter[SpecialWeapon.values().length];

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private WSClient wsClient;

	@Inject
	private PartyService party;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private Notifier notifier;

	@Inject
	private SpecialCounterConfig config;

	@Provides
	SpecialCounterConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpecialCounterConfig.class);
	}

	@Override
	protected void startUp()
	{
		wsClient.registerMessage(SpecialCounterUpdate.class);
		currentWorld = -1;
		specialPercentage = -1;
		lastSpecTarget = null;
		lastSpecTick = -1;
		interactedNpcIds.clear();
	}

	@Override
	protected void shutDown()
	{
		removeCounters();
		wsClient.unregisterMessage(SpecialCounterUpdate.class);
	}
	
	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		
		assert client.getLocalPlayer() != null;
		int currentRegion = WorldPoint.fromLocalInstance(client, client.getLocalPlayer().getLocalLocation()).getRegionID();
		boolean inInstance = client.isInInstancedRegion();
		
		// if the player left the region/instance and was fighting boss that resets, reset specs
		if (currentRegion != previousRegion || (wasInInstance && !inInstance))
		{
			if (RESET_ON_LEAVE_INSTANCED_REGIONS.contains(previousRegion))
			{
				removeCounters();
			}
		}
		
		previousRegion = currentRegion;
		wasInInstance = inInstance;
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
	public void onInteractingChanged(InteractingChanged interactingChanged)
	{
		Actor source = interactingChanged.getSource();
		Actor target = interactingChanged.getTarget();
		if (lastSpecTick != client.getTickCount() || source != client.getLocalPlayer() || target == null)
		{
			return;
		}

		log.debug("Updating last spec target to {} (was {})", target.getName(), lastSpecTarget);
		lastSpecTarget = target;
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

		log.debug("Special attack used - percent: {} weapon: {}", specialPercentage, specialWeapon);

		// spec was used; since the varbit change event fires before the interact change event,
		// this will be specing on the target of interact changed *if* it fires this tick,
		// otherwise it is what we are currently interacting with
		lastSpecTarget = client.getLocalPlayer().getInteracting();
		lastSpecTick = client.getTickCount();
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
	{
		Actor target = hitsplatApplied.getActor();
		Hitsplat hitsplat = hitsplatApplied.getHitsplat();
		// Ignore all hitsplats other than mine
		if (!hitsplat.isMine() || target == client.getLocalPlayer())
		{
			return;
		}

		log.debug("Hitsplat target: {} spec target: {}", target, lastSpecTarget);

		// If waiting for a spec, ignore hitsplats not on the actor we specced
		if (lastSpecTarget != null && lastSpecTarget != target)
		{
			return;
		}

		boolean wasSpec = lastSpecTarget != null;
		lastSpecTarget = null;

		if (!(target instanceof NPC))
		{
			return;
		}

		NPC npc = (NPC) target;
		int interactingId = npc.getId();

		if (IGNORED_NPCS.contains(interactingId))
		{
			return;
		}

		// If this is a new NPC reset the counters
		if (!interactedNpcIds.contains(interactingId))
		{
			removeCounters();
			addInteracting(interactingId);
		}

		if (wasSpec && specialWeapon != null && hitsplat.getAmount() > 0)
		{
			int hit = getHit(specialWeapon, hitsplat);

			updateCounter(specialWeapon, null, hit);

			if (!party.getMembers().isEmpty())
			{
				final SpecialCounterUpdate specialCounterUpdate = new SpecialCounterUpdate(interactingId, specialWeapon, hit);
				specialCounterUpdate.setMemberId(party.getLocalMember().getMemberId());
				wsClient.send(specialCounterUpdate);
			}
		}
	}

	private void addInteracting(int npcId)
	{
		interactedNpcIds.add(npcId);

		// Add alternate forms of bosses
		final Boss boss = Boss.getBoss(npcId);
		if (boss != null)
		{
			interactedNpcIds.addAll(boss.getIds());
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC actor = npcDespawned.getNpc();

		if (lastSpecTarget == actor)
		{
			lastSpecTarget = null;
		}

		if (actor.isDead() && interactedNpcIds.contains(actor.getId()))
		{
			removeCounters();
		}
	}

	@Subscribe
	public void onSpecialCounterUpdate(SpecialCounterUpdate event)
	{
		if (party.getLocalMember().getMemberId().equals(event.getMemberId()))
		{
			return;
		}

		String name = party.getMemberById(event.getMemberId()).getName();
		if (name == null)
		{
			return;
		}

		clientThread.invoke(() ->
		{
			// If not interacting with any npcs currently, add to interacting list
			if (interactedNpcIds.isEmpty())
			{
				addInteracting(event.getNpcId());
			}

			// Otherwise we only add the count if it is against a npc we are already tracking
			if (interactedNpcIds.contains(event.getNpcId()))
			{
				updateCounter(event.getWeapon(), name, event.getHit());
			}
		});
	}

	private SpecialWeapon usedSpecialWeapon()
	{
		ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipment == null)
		{
			return null;
		}

		Item weapon = equipment.getItem(EquipmentInventorySlot.WEAPON.getSlotIdx());
		if (weapon == null)
		{
			return null;
		}

		for (SpecialWeapon specialWeapon : SpecialWeapon.values())
		{
			if (Arrays.stream(specialWeapon.getItemID()).anyMatch(id -> id == weapon.getId()))
			{
				return specialWeapon;
			}
		}
		return null;
	}

	private void updateCounter(SpecialWeapon specialWeapon, String name, int hit)
	{
		SpecialCounter counter = specialCounter[specialWeapon.ordinal()];

		if (counter == null)
		{
			counter = new SpecialCounter(itemManager.getImage(specialWeapon.getItemID()[0]), this, config,
				hit, specialWeapon);
			infoBoxManager.addInfoBox(counter);
			specialCounter[specialWeapon.ordinal()] = counter;
		}
		else
		{
			counter.addHits(hit);
		}

		// Display a notification if special attack thresholds are met
		sendNotification(specialWeapon, counter);

		// If in a party, add hit to partySpecs for the infobox tooltip
		Map<String, Integer> partySpecs = counter.getPartySpecs();
		if (!party.getMembers().isEmpty())
		{
			if (partySpecs.containsKey(name))
			{
				partySpecs.put(name, hit + partySpecs.get(name));
			}
			else
			{
				partySpecs.put(name, hit);
			}
		}
	}

	private void sendNotification(SpecialWeapon weapon, SpecialCounter counter)
	{
		int threshold = weapon.getThreshold().apply(config);
		if (threshold > 0 && counter.getCount() >= threshold && config.thresholdNotification())
		{
			notifier.notify(weapon.getName() + " special attack threshold reached!");
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

	private int getHit(SpecialWeapon specialWeapon, Hitsplat hitsplat)
	{
		return specialWeapon.isDamage() ? hitsplat.getAmount() : 1;
	}
}