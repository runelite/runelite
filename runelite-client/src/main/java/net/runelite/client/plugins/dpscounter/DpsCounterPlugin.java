/*
 * Copyright (c) 2020 Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.dpscounter;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Hitsplat;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.gameval.NpcID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.WSClient;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "DPS Counter",
	description = "Counts damage (per second) by a party",
	enabledByDefault = false
)
@Slf4j
public class DpsCounterPlugin extends Plugin
{
	private static final ImmutableSet<Integer> BOSSES = ImmutableSet.of(
		NpcID.ABYSSALSIRE_SIRE_STASIS_SLEEPING, NpcID.ABYSSALSIRE_SIRE_STASIS_AWAKE, NpcID.ABYSSALSIRE_SIRE_STASIS_STUNNED, NpcID.ABYSSALSIRE_SIRE_PUPPET, NpcID.ABYSSALSIRE_SIRE_WANDERING, NpcID.ABYSSALSIRE_SIRE_PANICKING, NpcID.ABYSSALSIRE_SIRE_APOCALYPSE,
		NpcID.HYDRABOSS, NpcID.HYDRABOSS_P1_TRANSITION, NpcID.HYDRABOSS_P2_TRANSITION, NpcID.HYDRABOSS_P3_TRANSITION, NpcID.HYDRABOSS_4, NpcID.HYDRABOSS_3, NpcID.HYDRABOSS_2, NpcID.HYDRABOSS_FINALDEATH,
		NpcID.BARROWS_AHRIM, NpcID.BARROWS_DHAROK, NpcID.BARROWS_GUTHAN, NpcID.BARROWS_KARIL, NpcID.BARROWS_TORAG, NpcID.BARROWS_VERAC,
		NpcID.ARAXXOR, NpcID.ARAXXOR_DEAD,
		NpcID.GB_MOSSGIANT,
		NpcID.CLANCUP_CALLISTO, NpcID.CALLISTO,
		NpcID.CERBERUS_ATTACKING, NpcID.CERBERUS_SITTING, NpcID.CERBERUS_RESETTING,
		NpcID.CHAOSELEMENTAL, NpcID.CLANCUP_CHAOSELEMENTAL,
		NpcID.CHAOS_FANATIC,
		NpcID.GODWARS_SARADOMIN_AVATAR, NpcID.CLANCUP_GODWARS_SARADOMIN_AVATAR,
		NpcID.CORP_BEAST,
		NpcID.CRAZY_ARCHAEOLOGIST,
		NpcID.CRYSTAL_HUNLLEF_MELEE, NpcID.CRYSTAL_HUNLLEF_RANGED, NpcID.CRYSTAL_HUNLLEF_MAGIC, NpcID.CRYSTAL_HUNLLEF_DEATH,
		NpcID.CRYSTAL_HUNLLEF_MELEE_HM, NpcID.CRYSTAL_HUNLLEF_RANGED_HM, NpcID.CRYSTAL_HUNLLEF_MAGIC_HM, NpcID.CRYSTAL_HUNLLEF_DEATH_HM,
		NpcID.DAGCAVE_RANGED_BOSS, NpcID.DAGCAVE_MAGIC_BOSS, NpcID.DAGCAVE_MELEE_BOSS, NpcID.CLANCUP_DAGCAVE_RANGED_BOSS, NpcID.CLANCUP_DAGCAVE_MAGIC_BOSS, NpcID.CLANCUP_DAGCAVE_MELEE_BOSS,
		NpcID.GARGBOSS_DUSK_SPAWN, NpcID.GARGBOSS_DAWN_SPAWN, NpcID.GARGBOSS_DUSK_PHASE1_DEFENSIVE, NpcID.GARGBOSS_DAWN_PHASE1, NpcID.GARGBOSS_DAWN_PHASE1_TRANSITION, NpcID.GARGBOSS_DUSK_PHASE1_TRANSITION, NpcID.GARGBOSS_DUSK_PHASE1_FLYTRANSITION,
		NpcID.GODWARS_BANDOS_AVATAR, NpcID.CLANCUP_GODWARS_BANDOS_AVATAR,
		NpcID.MOLE_GIANT, NpcID.CLANCUP_MOLE_GIANT,
		NpcID.HESPORI,
		NpcID.POH_MOUNTED_KQ, NpcID.KALPHITE_QUEEN, NpcID.KALPHITE_FLYINGQUEEN, NpcID.SWAN_KALPHITE_1, NpcID.SWAN_KALPHITE_2, NpcID.CLANCUP_KALPHITE_QUEEN, NpcID.CLANCUP_KALPHITE_FLYINGQUEEN,
		NpcID.KING_DRAGON, NpcID.TWOCATS_KBD_CUTSCENE, NpcID.CLANCUP_KING_DRAGON,
		NpcID.SLAYER_KRAKEN_BOSS, NpcID.KRAKEN_PET, NpcID.POH_KRAKEN_PET,
		NpcID.GODWARS_ARMADYL_AVATAR, NpcID.CLANCUP_GODWARS_ARMADYL_AVATAR,
		NpcID.GODWARS_ZAMORAK_AVATAR, NpcID.CLANCUP_GODWARS_ZAMORAK_AVATAR,
		NpcID.TRAIL_MIMIC_NONCOMBAT, NpcID.TRAIL_MIMIC_COMBAT,
		NpcID.NEX, NpcID.NEX_SPAWNING, NpcID.NEX_SOULSPLIT, NpcID.NEX_DEFLECT, NpcID.NEX_DYING,
		NpcID.NIGHTMARE_DEAD, NpcID.NIGHTMARE_PHASE_02, NpcID.NIGHTMARE_PHASE_03, NpcID.NIGHTMARE_WEAK_PHASE_01, NpcID.NIGHTMARE_WEAK_PHASE_02, NpcID.NIGHTMARE_WEAK_PHASE_03, NpcID.NIGHTMARE_BLAST, NpcID.NIGHTMARE_INITIAL, NpcID.NIGHTMARE_DYING,
		NpcID.HILLGIANT_BOSS,
		NpcID.SARACHNIS,
		NpcID.SCORPIA,
		NpcID.RAT_BOSS_NORMAL, NpcID.RAT_BOSS_INSTANCE,
		NpcID.CATA_BOSS,
		NpcID.SMOKE_DEVIL_BOSS,
		NpcID.INFERNO_TZKALZUK_PLACEHOLDER,
		NpcID.TZHAAR_FIGHTCAVE_SWARM_BOSS, NpcID.CLANCUP_TZHAAR_FIGHTCAVE_SWARM_BOSS,
		NpcID.CLANCUP_VENENATIS, NpcID.VENENATIS,
		NpcID.VETION, NpcID.VETION_2,
		NpcID.POH_MOUNTED_VORKATH, NpcID.VORKATH_SLEEPING_NOOP, NpcID.VORKATH_SLEEPING, NpcID.VORKATH_QUEST, NpcID.VORKATH,
		NpcID.ZALCANO, NpcID.ZALCANO_WEAK,
		NpcID.SNAKEBOSS_BOSS_RANGED, NpcID.SNAKEBOSS_BOSS_MELEE, NpcID.SNAKEBOSS_BOSS_MAGIC,
		NpcID.YAMA,

		// ToB
		NpcID.TOB_MAIDEN_100, NpcID.TOB_MAIDEN_70, NpcID.TOB_MAIDEN_50, NpcID.TOB_MAIDEN_30, NpcID.TOB_MAIDEN_DYING_A, NpcID.TOB_MAIDEN_DYING_B,
		NpcID.TOB_BLOAT,
		NpcID.NYLOCAS_BOSS_SPAWNING, NpcID.NYLOCAS_BOSS_MELEE, NpcID.NYLOCAS_BOSS_MAGIC, NpcID.NYLOCAS_BOSS_RANGED,
		NpcID.TOB_SOTETSEG_NONCOMBAT, NpcID.TOB_SOTETSEG_COMBAT,
		NpcID.TOB_XARPUS_COMBAT, NpcID.XARPUS_DEATH,
		NpcID.VERZIK_PHASE1,
		NpcID.VERZIK_PHASE2,
		NpcID.VERZIK_PHASE3,

		// CoX
		NpcID.RAIDS_TEKTON_WAITING, NpcID.RAIDS_TEKTON_WALKING_STANDARD, NpcID.RAIDS_TEKTON_FIGHTING_STANDARD, NpcID.RAIDS_TEKTON_WALKING_ENRAGED, NpcID.RAIDS_TEKTON_FIGHTING_ENRAGED, NpcID.RAIDS_TEKTON_HAMMERING,
		NpcID.RAIDS_VESPULA_FLYING, NpcID.RAIDS_VESPULA_ENRAGED, NpcID.RAIDS_VESPULA_WALKING, NpcID.RAIDS_VESPULA_PORTAL,
		NpcID.RAIDS_VANGUARD_DORMANT, NpcID.RAIDS_VANGUARD_WALKING, NpcID.RAIDS_VANGUARD_MELEE, NpcID.RAIDS_VANGUARD_RANGED, NpcID.RAIDS_VANGUARD_MAGIC,
		NpcID.OLM_HEAD_SPAWNING, NpcID.OLM_HAND_LEFT_SPAWNING, NpcID.OLM_HAND_RIGHT, NpcID.OLM_HEAD, NpcID.OLM_HAND_LEFT,
		NpcID.RAIDS_TIGHTROPE_RANGER, NpcID.RAIDS_TIGHTROPE_MAGE,
		NpcID.RAIDS_DOGODILE_SUBMERGED, NpcID.RAIDS_DOGODILE_JUNIOR, NpcID.RAIDS_DOGODILE,
		NpcID.RAIDS_VASANISTIRIO_WALKING, NpcID.RAIDS_VASANISTIRIO_HEALING,
		NpcID.RAIDS_STONEGUARDIANS_LEFT, NpcID.RAIDS_STONEGUARDIANS_RIGHT, NpcID.RAIDS_STONEGUARDIANS_LEFT_DEAD, NpcID.RAIDS_STONEGUARDIANS_RIGHT_DEAD,
		NpcID.RAIDS_LIZARDSHAMAN_A, NpcID.RAIDS_LIZARDSHAMAN_B,
		NpcID.RAIDS_ICEDEMON_NONCOMBAT, NpcID.RAIDS_ICEDEMON_COMBAT,
		NpcID.RAIDS_SKELETONMYSTIC_A, NpcID.RAIDS_SKELETONMYSTIC_B, NpcID.RAIDS_SKELETONMYSTIC_C
	);

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyService partyService;

	@Inject
	private WSClient wsClient;

	@Inject
	private DpsOverlay dpsOverlay;

	@Inject
	private DpsConfig dpsConfig;

	@Getter(AccessLevel.PACKAGE)
	private final Map<String, DpsMember> members = new ConcurrentHashMap<>();
	@Getter(AccessLevel.PACKAGE)
	private final DpsMember total = new DpsMember("Total");

	@Provides
	DpsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DpsConfig.class);
	}

	@Override
	protected void startUp()
	{
		total.reset();
		overlayManager.add(dpsOverlay);
		wsClient.registerMessage(DpsUpdate.class);
	}

	@Override
	protected void shutDown()
	{
		wsClient.unregisterMessage(DpsUpdate.class);
		overlayManager.remove(dpsOverlay);
		members.clear();
	}

	@Subscribe
	public void onPartyChanged(PartyChanged partyChanged)
	{
		members.clear();
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied)
	{
		Player player = client.getLocalPlayer();
		Actor actor = hitsplatApplied.getActor();
		if (!(actor instanceof NPC))
		{
			return;
		}

		Hitsplat hitsplat = hitsplatApplied.getHitsplat();

		final int npcId = ((NPC) actor).getId();
		final boolean isBoss = BOSSES.contains(npcId);

		if (hitsplat.isMine())
		{
			int hit = hitsplat.getAmount();
			PartyMember localMember = partyService.getLocalMember();

			// broadcast damage
			if (localMember != null)
			{
				final DpsUpdate dpsUpdate = new DpsUpdate(hit, isBoss);
				partyService.send(dpsUpdate);
			}

			if (dpsConfig.bossDamage() && !isBoss)
			{
				return;
			}

			// If not in a party, user local player name
			final String name = localMember == null ? player.getName() : localMember.getDisplayName();
			DpsMember dpsMember = members.computeIfAbsent(name, DpsMember::new);
			dpsMember.addDamage(hit);

			// apply to total
		}
		else if (hitsplat.isOthers())
		{
			if ((dpsConfig.bossDamage() || actor != player.getInteracting()) && !isBoss)
			{
				// only track damage to npcs we are attacking, or is a nearby common boss
				return;
			}
			// apply to total
		}
		else
		{
			return;
		}

		unpause();
		total.addDamage(hitsplat.getAmount());
	}

	@Subscribe
	public void onDpsUpdate(DpsUpdate dpsUpdate)
	{
		if (partyService.getLocalMember().getMemberId() == dpsUpdate.getMemberId())
		{
			return;
		}

		String name = partyService.getMemberById(dpsUpdate.getMemberId()).getDisplayName();
		if (name == null)
		{
			return;
		}

		// Received non-boss damage, but we only want boss damage
		if (!dpsUpdate.isBoss() && dpsConfig.bossDamage())
		{
			return;
		}

		unpause();

		DpsMember dpsMember = members.computeIfAbsent(name, DpsMember::new);
		dpsMember.addDamage(dpsUpdate.getHit());
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		NPC npc = npcDespawned.getNpc();

		if (npc.isDead() && BOSSES.contains(npc.getId()))
		{
			log.debug("Boss has died!");

			if (dpsConfig.autoreset())
			{
				members.values().forEach(DpsMember::reset);
				total.reset();
			}
			else if (dpsConfig.autopause())
			{
				pause();
			}
		}
	}

	void reset()
	{
		members.clear();
		total.reset();
	}

	void pause()
	{
		if (total.isPaused())
		{
			return;
		}

		log.debug("Pausing");

		for (DpsMember dpsMember : members.values())
		{
			dpsMember.pause();
		}
		total.pause();

		dpsOverlay.setPaused(true);
	}

	void unpause()
	{
		if (!total.isPaused())
		{
			return;
		}

		log.debug("Unpausing");

		for (DpsMember dpsMember : members.values())
		{
			dpsMember.unpause();
		}
		total.unpause();

		dpsOverlay.setPaused(false);
	}
}
