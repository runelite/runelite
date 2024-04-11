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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.AccessLevel;
import lombok.Getter;
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
import net.runelite.api.Player;
import net.runelite.api.ScriptID;
import net.runelite.api.VarPlayer;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import static net.runelite.client.plugins.specialcounter.SpecialWeapon.TONALZTICS_OF_RALOS;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.ImageUtil;

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
		NpcID.DARK_ENERGY_CORE, // corp 
		NpcID.ZOMBIFIED_SPAWN, NpcID.ZOMBIFIED_SPAWN_8063, // vorkath
		NpcID.COMBAT_DUMMY, NpcID.UNDEAD_COMBAT_DUMMY, // poh
		NpcID.SKELETON_HELLHOUND_6613, NpcID.GREATER_SKELETON_HELLHOUND, // vetion
		NpcID.SPAWN, NpcID.SCION // abyssal sire
	);

	private int currentWorld;
	private int specialPercentage;

	private SpecialWeapon specialWeapon;
	// expected tick the hitsplat will happen on
	private int hitsplatTick;
	// most recent hitsplat and the target it was on
	private Hitsplat lastSpecHitsplat;
	private Hitsplat secondToLastSpecHitsplat;
	private NPC lastSpecTarget;
	private int specialAttackHits = 0;

	private final Set<Integer> interactedNpcIndexes = new HashSet<>();
	private final SpecialCounter[] specialCounter = new SpecialCounter[SpecialWeapon.values().length];

	@Getter(AccessLevel.PACKAGE)
	private final List<PlayerInfoDrop> playerInfoDrops = new ArrayList<>();

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

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PlayerInfoDropOverlay playerInfoDropOverlay;

	@Inject
	@Named("developerMode")
	boolean developerMode;

	@Provides
	SpecialCounterConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SpecialCounterConfig.class);
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(playerInfoDropOverlay);
		wsClient.registerMessage(SpecialCounterUpdate.class);
		currentWorld = -1;
		specialPercentage = -1;
		interactedNpcIndexes.clear();
	}

	@Override
	protected void shutDown()
	{
		specialWeapon = null;
		lastSpecTarget = null;
		lastSpecHitsplat = null;
		secondToLastSpecHitsplat = null;
		removeCounters();
		overlayManager.remove(playerInfoDropOverlay);
		wsClient.unregisterMessage(SpecialCounterUpdate.class);
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == ScriptID.TOB_HUD_SOTETSEG_FADE)
		{
			log.debug("Resetting spec counter as sotetseg maze script was ran");
			removeCounters();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (lastSpecHitsplat != null && specialWeapon != null && lastSpecTarget != null)
		{
			if (lastSpecHitsplat.getAmount() > 0)
			{
				specialAttackHits++;
			}
			if (specialWeapon == TONALZTICS_OF_RALOS && secondToLastSpecHitsplat != null
				&& secondToLastSpecHitsplat.getAmount() > 0)
			{
				specialAttackHits++;
			}

			if (specialAttackHits > 0)
			{
				int hit = specialWeapon == TONALZTICS_OF_RALOS ? specialAttackHits : getHit(specialWeapon, lastSpecHitsplat);
				specialAttackHit(specialWeapon, hit, lastSpecTarget);
			}

			specialWeapon = null;
			lastSpecHitsplat = null;
			secondToLastSpecHitsplat = null;
			lastSpecTarget = null;
			specialAttackHits = 0;
		}
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
		if (event.getVarpId() != VarPlayer.SPECIAL_ATTACK_PERCENT)
		{
			return;
		}

		int specialPercentage = event.getValue();
		if (this.specialPercentage == -1 || specialPercentage >= this.specialPercentage)
		{
			this.specialPercentage = specialPercentage;
			return;
		}

		this.specialPercentage = specialPercentage;

		// This event runs prior to player and npc updating, making getInteracting() too early to call..
		// defer this with invokeLater(), but note that this will run after incrementing the server tick counter
		// so we capture the current server tick counter here for use in computing the final hitsplat tick
		final int serverTicks = client.getTickCount();
		clientThread.invokeLater(() ->
		{
			this.specialWeapon = usedSpecialWeapon();

			if (this.specialWeapon == null)
			{
				// unrecognized special attack weapon
				return;
			}

			Actor target = client.getLocalPlayer().getInteracting();
			lastSpecTarget = target instanceof NPC ? (NPC) target : null;
			hitsplatTick = serverTicks + getHitDelay(specialWeapon, target);
			log.debug("Special attack used - percent: {} weapon: {} server cycle {} hitsplat cycle {}", specialPercentage, specialWeapon, serverTicks, hitsplatTick);
		});
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

		// only check hitsplats applied to the target we are specing
		if (lastSpecTarget == null || target != lastSpecTarget)
		{
			return;
		}

		NPC npc = (NPC) target;
		int interactingId = npc.getId();
		int npcIndex = npc.getIndex();

		if (IGNORED_NPCS.contains(interactingId))
		{
			return;
		}

		// If this is a new NPC reset the counters
		if (!interactedNpcIndexes.contains(npcIndex))
		{
			removeCounters();
			interactedNpcIndexes.add(npcIndex);
		}

		// The weapon hitsplat is always last, after other hitsplats which occur on the same tick such as from
		// venge or thralls.
		if (hitsplatTick == client.getTickCount())
		{
			secondToLastSpecHitsplat = lastSpecHitsplat;
			lastSpecHitsplat = hitsplat;
		}
	}

	private void specialAttackHit(SpecialWeapon specialWeapon, int hit, NPC target)
	{
		int localPlayerId = client.getLocalPlayer().getId();

		log.debug("Special attack hit {} hitsplat {}", specialWeapon, hit);

		if (config.infobox())
		{
			updateCounter(specialWeapon, null, hit);
		}

		if (party.isInParty())
		{
			final int npcIndex = target.getIndex();
			final SpecialCounterUpdate specialCounterUpdate = new SpecialCounterUpdate(npcIndex, specialWeapon, hit, client.getWorld(), localPlayerId);
			party.send(specialCounterUpdate);
		}

		playerInfoDrops.add(createSpecInfoDrop(specialWeapon, hit, localPlayerId));
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC actor = npcDespawned.getNpc();

		if (lastSpecTarget == actor)
		{
			lastSpecTarget = null;
		}

		if (actor.isDead() && interactedNpcIndexes.contains(actor.getIndex()))
		{
			removeCounters();
		}
	}

	@Subscribe
	public void onNpcChanged(NpcChanged npcChanged)
	{
		final NPC npc = npcChanged.getNpc();
		// Duke does not despawn when dead
		if (npc.getId() == NpcID.DUKE_SUCELLUS_12192 || npc.getId() == NpcID.DUKE_SUCELLUS_12196)
		{
			log.debug("Duke died");
			removeCounters();
		}
	}

	@Subscribe
	public void onSpecialCounterUpdate(SpecialCounterUpdate event)
	{
		if (party.getLocalMember().getMemberId() == event.getMemberId()
			|| event.getWorld() != client.getWorld())
		{
			return;
		}

		String name = party.getMemberById(event.getMemberId()).getDisplayName();
		if (name == null)
		{
			return;
		}

		clientThread.invoke(() ->
		{
			// If not interacting with any npcs currently, add to interacting list
			if (interactedNpcIndexes.isEmpty())
			{
				interactedNpcIndexes.add(event.getNpcIndex());
			}

			// Otherwise we only add the count if it is against a npc we are already tracking
			if (interactedNpcIndexes.contains(event.getNpcIndex()))
			{
				if (config.infobox())
				{
					updateCounter(event.getWeapon(), name, event.getHit());
				}
			}

			playerInfoDrops.add(createSpecInfoDrop(event.getWeapon(), event.getHit(), event.getPlayerId()));
		});
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (developerMode && commandExecuted.getCommand().equals("spec"))
		{
			playerInfoDrops.add(createSpecInfoDrop(SpecialWeapon.BANDOS_GODSWORD, 42, client.getLocalPlayer().getId()));
		}
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
		if (party.isInParty())
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
		interactedNpcIndexes.clear();

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

	private PlayerInfoDrop createSpecInfoDrop(SpecialWeapon weapon, int hit, int playerId)
	{
		int cycle = client.getGameCycle();
		BufferedImage image = ImageUtil.resizeImage(itemManager.getImage(weapon.getItemID()[0]), 24, 24);

		return PlayerInfoDrop.builder(cycle, cycle + 100, playerId, Integer.toString(hit))
			.color(config.specDropColor())
			.startHeightOffset(100)
			.endHeightOffset(400)
			.image(image)
			.build();
	}

	private int getHitDelay(SpecialWeapon specialWeapon, Actor target)
	{
		if (target == null)
			return 1;

		Player player = client.getLocalPlayer();
		if (player == null)
			return 1;

		WorldPoint playerWp = player.getWorldLocation();
		if (playerWp == null)
			return 1;

		WorldArea targetArea = target.getWorldArea();
		if (targetArea == null)
			return 1;

		final int distance = targetArea.distanceTo(playerWp);
		final int serverCycles = specialWeapon.getHitDelay(distance);

		if (serverCycles != 1)
		{
			log.debug("Projectile distance {} server cycles {}", distance, serverCycles);
		}

		return serverCycles;
	}
}
