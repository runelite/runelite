/*
 * Copyright (c) 2019 Im2be <https://github.com/Im2be>
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

package net.runelite.client.plugins.cerberus;

import com.google.common.collect.ComparisonChain;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cerberus.domain.Cerberus;
import net.runelite.client.plugins.cerberus.domain.CerberusAttack;
import net.runelite.client.plugins.cerberus.domain.Ghost;
import net.runelite.client.plugins.cerberus.domain.Phase;
import net.runelite.client.plugins.cerberus.overlays.CurrentAttackOverlay;
import net.runelite.client.plugins.cerberus.overlays.PrayerOverlay;
import net.runelite.client.plugins.cerberus.overlays.SceneOverlay;
import net.runelite.client.plugins.cerberus.overlays.UpcomingAttackOverlay;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;

@Slf4j
@Singleton
@PluginDescriptor(
	name = "Cerberus",
	enabledByDefault = false,
	description = "A plugin for the Cerberus boss.",
	tags = {"cerberus", "hellhound"}
)
public class CerberusPlugin extends Plugin
{
	private static final int ANIMATION_ID_IDLE = -1;
	private static final int ANIMATION_ID_STAND_UP = 4486;
	private static final int ANIMATION_ID_SIT_DOWN = 4487;
	private static final int ANIMATION_ID_FLINCH = 4489;
	private static final int ANIMATION_ID_RANGED = 4490;
	private static final int ANIMATION_ID_MELEE = 4491;
	private static final int ANIMATION_ID_LAVA = 4493;
	private static final int ANIMATION_ID_GHOSTS = 4494;
	private static final int ANIMATION_ID_DEATH = 4495;

	private static final int PROJECTILE_ID_MAGIC = 1242;
	private static final int PROJECTILE_ID_RANGE = 1245;

	private static final int GHOST_PROJECTILE_ID_RANGE = 34;
	private static final int GHOST_PROJECTILE_ID_MAGIC = 100;
	private static final int GHOST_PROJECTILE_ID_MELEE = 1248;

	private static final int PROJECTILE_ID_NO_FUCKING_IDEA = 15;
	private static final int PROJECTILE_ID_LAVA = 1247;

	//private static final Set<Integer> REGION_IDS = Set.of(4883, 5140, 5395);

	@Inject
	private Client client;

	@Inject
	private CerberusConfig config;

	@Inject
	private ItemManager itemManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private SceneOverlay sceneOverlay;

	@Inject
	private PrayerOverlay prayerOverlay;

	@Inject
	private CurrentAttackOverlay currentAttackOverlay;

	@Inject
	private UpcomingAttackOverlay upcomingAttackOverlay;

	@Getter
	private final List<NPC> ghosts = new ArrayList<>();

	@Getter
	private final List<CerberusAttack> upcomingAttacks = new ArrayList<>();

	private final List<Long> tickTimestamps = new ArrayList<>();

	@Getter
	@Nullable
	private Prayer prayer = Prayer.PROTECT_FROM_MAGIC;

	@Getter
	@Nullable
	private Cerberus cerberus;

	@Getter
	private int gameTick;

	private int tickTimestampIndex;

	@Getter
	private long lastTick;

	private boolean inArena;

	@Provides
	CerberusConfig getConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(CerberusConfig.class);
	}

	@Override
	protected void startUp()
	{
		if (client.getGameState() != GameState.LOGGED_IN || !inCerberusRegion())
		{
			return;
		}

		init();
	}

	private void init()
	{
		inArena = true;

		overlayManager.add(sceneOverlay);
		overlayManager.add(prayerOverlay);
		overlayManager.add(currentAttackOverlay);
		overlayManager.add(upcomingAttackOverlay);
	}

	@Override
	protected void shutDown()
	{
		inArena = false;

		overlayManager.remove(sceneOverlay);
		overlayManager.remove(prayerOverlay);
		overlayManager.remove(currentAttackOverlay);
		overlayManager.remove(upcomingAttackOverlay);

		ghosts.clear();
		upcomingAttacks.clear();
		tickTimestamps.clear();

		prayer = Prayer.PROTECT_FROM_MAGIC;

		cerberus = null;

		gameTick = 0;
		tickTimestampIndex = 0;
		lastTick = 0;
	}

	@Subscribe
	private void onGameStateChanged(final GameStateChanged event)
	{
		final GameState gameState = event.getGameState();

		switch (gameState)
		{
			case LOGGED_IN:
				if (inCerberusRegion())
				{
					if (!inArena)
					{
						init();
					}
				}
				else
				{
					if (inArena)
					{
						shutDown();
					}
				}
				break;
			case HOPPING:
			case LOGIN_SCREEN:
				if (inArena)
				{
					shutDown();
				}
				break;
			default:
				break;
		}
	}

	@Subscribe
	private void onGameTick(final GameTick event)
	{
		if (cerberus == null)
		{
			return;
		}

		if (tickTimestamps.size() <= tickTimestampIndex)
		{
			tickTimestamps.add(System.currentTimeMillis());
		}
		else
		{
			tickTimestamps.set(tickTimestampIndex, System.currentTimeMillis());
		}

		long min = 0;

		for (int i = 0; i < tickTimestamps.size(); ++i)
		{
			if (min == 0)
			{
				min = tickTimestamps.get(i) + 600 * ((tickTimestampIndex - i + 5) % 5);
			}
			else
			{
				min = Math.min(min, tickTimestamps.get(i) + 600 * ((tickTimestampIndex - i + 5) % 5));
			}
		}

		tickTimestampIndex = (tickTimestampIndex + 1) % 5;

		lastTick = min;

		++gameTick;

		if (config.calculateAutoAttackPrayer() && gameTick % 10 == 3)
		{
			setAutoAttackPrayer();
		}

		calculateUpcomingAttacks();

		if (ghosts.size() > 1)
		{
			/*
			 * First, sort by the southernmost ghost (e.g with lowest y).
			 * Then, sort by the westernmost ghost (e.g with lowest x).
			 * This will give use the current wave and order of the ghosts based on what ghost will attack first.
			 */
			ghosts.sort((a, b) -> ComparisonChain.start()
				.compare(a.getLocalLocation().getY(), b.getLocalLocation().getY())
				.compare(a.getLocalLocation().getX(), b.getLocalLocation().getX())
				.result());
		}
	}

	@Subscribe
	private void onProjectileSpawned(final ProjectileSpawned event)
	{
		if (cerberus == null)
		{
			return;
		}

		final Projectile projectile = event.getProjectile();

		final int hp = cerberus.getHp();

		final Phase expectedAttack = cerberus.getNextAttackPhase(1, hp);

		switch (projectile.getId())
		{
			case PROJECTILE_ID_MAGIC:
				log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, cerbProjectile={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "MAGIC");

				if (expectedAttack != Phase.TRIPLE)
				{
					cerberus.nextPhase(Phase.AUTO);
				}
				else
				{
					cerberus.setLastTripleAttack(Cerberus.Attack.MAGIC);
				}

				cerberus.doProjectileOrAnimation(gameTick, Cerberus.Attack.MAGIC);
				break;
			case PROJECTILE_ID_RANGE:
				log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, cerbProjectile={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "RANGED");

				if (expectedAttack != Phase.TRIPLE)
				{
					cerberus.nextPhase(Phase.AUTO);
				}
				else
				{
					cerberus.setLastTripleAttack(Cerberus.Attack.RANGED);
				}

				cerberus.doProjectileOrAnimation(gameTick, Cerberus.Attack.RANGED);
				break;
			case GHOST_PROJECTILE_ID_RANGE:
				if (!ghosts.isEmpty())
				{
					log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, ghostProjectile={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "RANGED");
				}
				break;
			case GHOST_PROJECTILE_ID_MAGIC:
				if (!ghosts.isEmpty())
				{
					log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, ghostProjectile={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "MAGIC");
				}
				break;
			case GHOST_PROJECTILE_ID_MELEE:
				if (!ghosts.isEmpty())
				{
					log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, ghostProjectile={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "MELEE");
				}
				break;
			case PROJECTILE_ID_NO_FUCKING_IDEA:
			case PROJECTILE_ID_LAVA: //Lava
			default:
				break;

		}
	}

	@Subscribe
	private void onAnimationChanged(final AnimationChanged event)
	{
		if (cerberus == null)
		{
			return;
		}

		final Actor actor = event.getActor();

		final NPC npc = cerberus.getNpc();

		if (npc == null || actor != npc)
		{
			return;
		}

		final int animationId = npc.getAnimation();

		final int hp = cerberus.getHp();

		final Phase expectedAttack = cerberus.getNextAttackPhase(1, hp);

		switch (animationId)
		{
			case ANIMATION_ID_MELEE:
				log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, cerbAnimation={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "MELEE");

				cerberus.setLastTripleAttack(null);
				cerberus.nextPhase(expectedAttack);
				cerberus.doProjectileOrAnimation(gameTick, Cerberus.Attack.MELEE);
				break;
			case ANIMATION_ID_LAVA:
				log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, cerbAnimation={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "LAVA");

				cerberus.nextPhase(Phase.LAVA);
				cerberus.doProjectileOrAnimation(gameTick, Cerberus.Attack.LAVA);
				break;
			case ANIMATION_ID_GHOSTS:
				log.debug("gameTick={}, attack={}, cerbHp={}, expectedAttack={}, cerbAnimation={}", gameTick, cerberus.getPhaseCount() + 1, hp, expectedAttack, "GHOSTS");

				cerberus.nextPhase(Phase.GHOSTS);
				cerberus.setLastGhostYellTick(gameTick);
				cerberus.setLastGhostYellTime(System.currentTimeMillis());
				cerberus.doProjectileOrAnimation(gameTick, Cerberus.Attack.GHOSTS);
				break;
			case ANIMATION_ID_SIT_DOWN:
			case ANIMATION_ID_STAND_UP:
				cerberus = new Cerberus(cerberus.getNpc());
				gameTick = 0;
				lastTick = System.currentTimeMillis();
				upcomingAttacks.clear();
				tickTimestamps.clear();
				tickTimestampIndex = 0;
				cerberus.doProjectileOrAnimation(gameTick, Cerberus.Attack.SPAWN);
				break;
			case ANIMATION_ID_IDLE:
			case ANIMATION_ID_FLINCH:
			case ANIMATION_ID_RANGED:
				break;
			case ANIMATION_ID_DEATH:
				cerberus = null;
				ghosts.clear();
				break;
			default:
				log.debug("gameTick={}, animationId={} (UNKNOWN)", gameTick, animationId);
				break;
		}
	}

	@Subscribe
	private void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (cerberus == null && npc != null && npc.getName() != null && npc.getName().toLowerCase().contains("cerberus"))
		{
			log.debug("onNpcSpawned name={}, id={}", npc.getName(), npc.getId());

			cerberus = new Cerberus(npc);

			gameTick = 0;
			tickTimestampIndex = 0;
			lastTick = System.currentTimeMillis();

			upcomingAttacks.clear();
			tickTimestamps.clear();
		}

		if (cerberus == null)
		{
			return;
		}

		final Ghost ghost = Ghost.fromNPC(npc);

		if (ghost != null)
		{
			ghosts.add(npc);
		}
	}

	@Subscribe
	private void onNpcDespawned(final NpcDespawned event)
	{
		final NPC npc = event.getNpc();

		if (npc != null && npc.getName() != null && npc.getName().toLowerCase().contains("cerberus"))
		{
			cerberus = null;
			ghosts.clear();

			log.debug("onNpcDespawned name={}, id={}", npc.getName(), npc.getId());
		}

		if (cerberus == null && !ghosts.isEmpty())
		{
			ghosts.clear();
			return;
		}

		ghosts.remove(event.getNpc());
	}

	private void calculateUpcomingAttacks()
	{
		upcomingAttacks.clear();

		final Cerberus.Attack lastCerberusAttack = cerberus.getLastAttack();

		if (lastCerberusAttack == null)
		{
			return;
		}

		final int lastCerberusAttackTick = cerberus.getLastAttackTick();

		final int hp = cerberus.getHp();

		final Phase expectedPhase = cerberus.getNextAttackPhase(1, hp);
		final Phase lastPhase = cerberus.getLastAttackPhase();

		int tickDelay = 0;

		if (lastPhase != null)
		{
			tickDelay = lastPhase.getTickDelay();
		}

		for (int tick = gameTick + 1; tick <= gameTick + 10; ++tick)
		{
			if (ghosts.size() == 3)
			{
				final Ghost ghost;

				if (cerberus.getLastGhostYellTick() == tick - 13)
				{
					ghost = Ghost.fromNPC(ghosts.get(ghosts.size() - 3));
				}
				else if (cerberus.getLastGhostYellTick() == tick - 15)
				{
					ghost = Ghost.fromNPC(ghosts.get(ghosts.size() - 2));
				}
				else if (cerberus.getLastGhostYellTick() == tick - 17)
				{
					ghost = Ghost.fromNPC(ghosts.get(ghosts.size() - 1));
				}
				else
				{
					ghost = null;
				}

				if (ghost != null)
				{
					switch (ghost.getType())
					{
						case ATTACK:
							upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.GHOST_MELEE));
							break;
						case RANGED:
							upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.GHOST_RANGED));
							break;
						case MAGIC:
							upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.GHOST_MAGIC));
							break;
					}

					continue;
				}
			}

			if (expectedPhase == Phase.TRIPLE)
			{
				if (cerberus.getLastTripleAttack() == Cerberus.Attack.MAGIC)
				{
					if (lastCerberusAttackTick + 4 == tick)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.RANGED));
					}
					else if (lastCerberusAttackTick + 7 == tick)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.MELEE));
					}
				}
				else if (cerberus.getLastTripleAttack() == Cerberus.Attack.RANGED)
				{
					if (lastCerberusAttackTick + 4 == tick)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.MELEE));
					}
				}
				else if (cerberus.getLastTripleAttack() == null)
				{
					if (lastCerberusAttackTick + tickDelay + 2 == tick)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.MAGIC));
					}
					else if (lastCerberusAttackTick + tickDelay + 5 == tick)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.RANGED));
					}
				}
			}
			else if (expectedPhase == Phase.AUTO)
			{
				if (lastCerberusAttackTick + tickDelay + 1 == tick)
				{
					if (prayer == Prayer.PROTECT_FROM_MAGIC)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.MAGIC));
					}
					else if (prayer == Prayer.PROTECT_FROM_MISSILES)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.RANGED));
					}
					else if (prayer == Prayer.PROTECT_FROM_MELEE)
					{
						upcomingAttacks.add(new CerberusAttack(tick, Cerberus.Attack.MELEE));
					}
				}
			}
		}
	}

	private void setAutoAttackPrayer()
	{
		int defenseStab = 0, defenseMagic = 0, defenseRange = 0;

		final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

		if (itemContainer != null)
		{
			final Item[] items = itemContainer.getItems();

			for (final Item item : items)
			{
				if (item == null)
				{
					continue;
				}

				final ItemStats itemStats = itemManager.getItemStats(item.getId(), false);

				if (itemStats == null)
				{
					continue;
				}

				final ItemEquipmentStats itemStatsEquipment = itemStats.getEquipment();

				if (itemStatsEquipment == null)
				{
					continue;
				}

				defenseStab += itemStatsEquipment.getDstab();
				defenseMagic += itemStatsEquipment.getDmagic();
				defenseRange += itemStatsEquipment.getDrange();
			}
		}

		final int magicLvl = client.getBoostedSkillLevel(Skill.MAGIC);
		final int defenseLvl = client.getBoostedSkillLevel(Skill.DEFENCE);

		final int magicDefenseTotal = (int) (((double) magicLvl) * 0.7 + ((double) defenseLvl) * 0.3) + defenseMagic;
		final int rangeDefenseTotal = defenseLvl + defenseRange;

		int meleeDefenseTotal = defenseLvl + defenseStab;

		final Player player = client.getLocalPlayer();

		if (player != null)
		{
			final WorldPoint worldPointPlayer = client.getLocalPlayer().getWorldLocation();
			final WorldPoint worldPointCerberus = cerberus.getNpc().getWorldLocation();

			if (worldPointPlayer.getX() < worldPointCerberus.getX() - 1
				|| worldPointPlayer.getX() > worldPointCerberus.getX() + 5
				|| worldPointPlayer.getY() < worldPointCerberus.getY() - 1
				|| worldPointPlayer.getY() > worldPointCerberus.getY() + 5)
			{
				meleeDefenseTotal = Integer.MAX_VALUE;
			}
		}

		if (magicDefenseTotal <= rangeDefenseTotal && magicDefenseTotal <= meleeDefenseTotal)
		{
			prayer = Prayer.PROTECT_FROM_MAGIC;
		}
		else if (rangeDefenseTotal <= meleeDefenseTotal)
		{
			prayer = Prayer.PROTECT_FROM_MISSILES;
		}
		else
		{
			prayer = Prayer.PROTECT_FROM_MELEE;
		}
	}

	private boolean inCerberusRegion()
	{
		final int REGION_IDS = 4883;
		for (final int regionId : client.getMapRegions())
		{

			if (REGION_IDS == regionId)
			{
				return true;
			}
		}

		return false;
	}
}
