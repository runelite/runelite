/*
 * Copyright (c) 2018, https://openosrs.com
 * Copyright (c) 2020, Dutta64 <https://github.com/dutta64>
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
package net.runelite.client.plugins.hydra;

import com.google.inject.Provides;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Hydra Helper",
	description = "Overlays for normal Hydras.",
	tags = {"hydra", "helper", "baby", "small", "normal", "regular"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Slf4j
@Singleton
public class HydraPlugin extends Plugin
{
	static final Set<HydraAnimation> VALID_HYDRA_ANIMATIONS = EnumSet.of(
		HydraAnimation.RANGE,
		HydraAnimation.MAGIC
	);

	private static final String CONFIG_GROUP_NAME = "hydra";
	private static final String CONFIG_ITEM_ATTACK_COUNTER = "attackCounterOverlay";
	private static final String CONFIG_ITEM_PRAYER_OVERLAY = "prayerOverlay";
	private static final String CONFIG_ITEM_POISON_PROJECTILE_OVERLAY = "poisonProjectileOverlay";
	private static final String CONFIG_ITEM_BOLD_ATTACK_COUNTER_OVERLAY = "boldAttackCounterOverlay";

	private static final String NPC_NAME_HYDRA = "Hydra";

	private static final int HYDRA_REGION_1 = 5279;
	private static final int HYDRA_REGION_2 = 5280;

	@Inject
	private Client client;

	@Inject
	private HydraConfig hydraConfig;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private HydraAttackCounterOverlay hydraAttackCounterOverlay;

	@Inject
	private HydraPrayerOverlay hydraPrayerOverlay;

	@Inject
	private HydraPrayerAttackCounterOverlay hydraPrayerAttackCounterOverlay;

	@Inject
	private HydraPoisonOverlay hydraPoisonOverlay;

	private final Map<Integer, Hydra> hydras = new HashMap<>();

	private final Map<LocalPoint, Projectile> poisonProjectiles = new HashMap<>();

	@Getter(AccessLevel.PACKAGE)
	private NPC interactingNpc = null;

	@Provides
	HydraConfig provideConfig(final ConfigManager configManager)
	{
		return configManager.getConfig(HydraConfig.class);
	}

	@Override
	protected void startUp()
	{
		if (hydraConfig.isAttackCounterOverlay())
		{
			overlayManager.add(hydraAttackCounterOverlay);
		}

		if (hydraConfig.isPrayerOverlay())
		{
			overlayManager.add(hydraPrayerOverlay);
			overlayManager.add(hydraPrayerAttackCounterOverlay);
		}

		if (hydraConfig.isPoisonOverlay())
		{
			overlayManager.add(hydraPoisonOverlay);
		}

		hydraAttackCounterOverlay.setBoldAttackCounterOverlay(hydraConfig.isBoldAttackCounterOverlay());

		hydraAttackCounterOverlay.setHydras(hydras);
		hydraPrayerOverlay.setHydras(hydras);
		hydraPrayerAttackCounterOverlay.setHydras(hydras);

		hydraPoisonOverlay.setPoisonProjectiles(poisonProjectiles);

		resetHydras();
		poisonProjectiles.clear();
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(hydraAttackCounterOverlay);
		overlayManager.remove(hydraPrayerOverlay);
		overlayManager.remove(hydraPrayerAttackCounterOverlay);
		overlayManager.remove(hydraPoisonOverlay);
		resetHydras();
		poisonProjectiles.clear();

	}

	@Subscribe
	private void onConfigChanged(final ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_GROUP_NAME))
		{
			return;
		}

		final boolean newConfigValue = Boolean.parseBoolean(event.getNewValue());

		switch (event.getKey())
		{
			case CONFIG_ITEM_ATTACK_COUNTER:
				if (newConfigValue)
				{
					overlayManager.add(hydraAttackCounterOverlay);
				}
				else
				{
					overlayManager.remove(hydraAttackCounterOverlay);
				}
				break;
			case CONFIG_ITEM_PRAYER_OVERLAY:
				if (newConfigValue)
				{
					overlayManager.add(hydraPrayerOverlay);
					overlayManager.add(hydraPrayerAttackCounterOverlay);
				}
				else
				{
					overlayManager.remove(hydraPrayerOverlay);
					overlayManager.remove(hydraPrayerAttackCounterOverlay);
				}
				break;
			case CONFIG_ITEM_POISON_PROJECTILE_OVERLAY:
				if (newConfigValue)
				{
					overlayManager.add(hydraPoisonOverlay);
				}
				else
				{
					overlayManager.remove(hydraPoisonOverlay);
				}
				break;
			case CONFIG_ITEM_BOLD_ATTACK_COUNTER_OVERLAY:
				hydraAttackCounterOverlay.setBoldAttackCounterOverlay(hydraConfig.isBoldAttackCounterOverlay());
				break;
			default:
				break;
		}
	}

	@Subscribe
	private void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (isActorHydra(npc))
		{
			addHydra(npc);
		}
	}

	@Subscribe
	private void onNpcDespawned(final NpcDespawned event)
	{
		final NPC npc = event.getNpc();

		if (isActorHydra(npc))
		{
			removeHydra(npc);
			poisonProjectiles.clear();
		}
	}

	@Subscribe
	private void onInteractingChanged(final InteractingChanged event)
	{
		final Actor source = event.getSource();

		if (!isActorHydra(source))
		{
			return;
		}

		final NPC npc = (NPC) source;

		addHydra(npc);
		updateInteractingNpc(npc);
	}

	@Subscribe
	private void onAnimationChanged(final AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (!isActorHydra(actor))
		{
			return;
		}

		final NPC npc = (NPC) event.getActor();

		addHydra(npc);
		updateInteractingNpc(npc);

		HydraAnimation hydraAnimation;

		try
		{
			hydraAnimation = HydraAnimation.fromId(npc.getAnimation());
		}
		catch (final IllegalArgumentException e)
		{
			hydraAnimation = null;
		}

		if (hydraAnimation == null || !VALID_HYDRA_ANIMATIONS.contains(hydraAnimation))
		{
			// If the animation is not range/magic then do nothing.
			return;
		}

		final Hydra hydra = hydras.get(npc.getIndex());

		if (hydra.getHydraAnimation() == null)
		{
			// If this is the first observed animation then set it
			hydra.setHydraAnimation(hydraAnimation);
		}
		else
		{
			if (!Objects.equals(hydra.getHydraAnimation(), hydraAnimation))
			{
				// If the animation switched from range/magic then set it and reset attack count
				hydra.setHydraAnimation(hydraAnimation);
				hydra.resetAttackCount();
			}
		}

		hydra.updateAttackCount();

		if (!poisonProjectiles.isEmpty())
		{
			updatePoisonProjectiles();
		}
	}

	/**
	 * See net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin
	 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
	 *
	 * @param event event object
	 */
	@Subscribe
	private void onProjectileMoved(final ProjectileMoved event)
	{
		if (interactingNpc == null || client.getGameCycle() >= event.getProjectile().getStartMovementCycle())
		{
			return;
		}

		final Projectile projectile = event.getProjectile();

		final int projectileId = projectile.getId();

		if (projectileId == ProjectileID.HYDRA_POISON)
		{
			poisonProjectiles.put(event.getPosition(), projectile);
		}
	}

	/**
	 * See net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin
	 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
	 */
	private void updatePoisonProjectiles()
	{
		final Set<LocalPoint> expiredPoisonProjectiles = new HashSet<>();

		for (final Map.Entry<LocalPoint, Projectile> entry : poisonProjectiles.entrySet())
		{
			if (entry.getValue().getEndCycle() < client.getGameCycle())
			{
				expiredPoisonProjectiles.add(entry.getKey());
			}
		}

		for (final LocalPoint projectileLocalPoint : expiredPoisonProjectiles)
		{
			poisonProjectiles.remove(projectileLocalPoint);
		}
	}

	boolean isPlayerAtHydraRegion()
	{
		final Player player = client.getLocalPlayer();

		if (player == null)
		{
			return false;
		}

		final WorldPoint worldPoint = player.getWorldLocation();

		if (worldPoint == null)
		{
			return false;
		}

		final int regionId = worldPoint.getRegionID();

		return regionId == HYDRA_REGION_1 || regionId == HYDRA_REGION_2;
	}

	private static boolean isActorHydra(final Actor actor)
	{
		return Objects.equals(actor.getName(), NPC_NAME_HYDRA);
	}

	private void updateInteractingNpc(final NPC npc)
	{
		if (!Objects.equals(interactingNpc, npc) &&
			Objects.equals(npc.getInteracting(), client.getLocalPlayer()))
		{
			interactingNpc = npc;
		}
	}

	private void addHydra(final NPC npc)
	{
		final int npcIndex = npc.getIndex();

		if (!hydras.containsKey(npcIndex))
		{
			hydras.put(npcIndex, new Hydra(npc));
		}
	}

	private void removeHydra(final NPC npc)
	{
		final int npcIndex = npc.getIndex();

		hydras.remove(npcIndex);

		if (Objects.equals(interactingNpc, npc))
		{
			interactingNpc = null;
		}
	}

	private void resetHydras()
	{
		hydras.clear();
		interactingNpc = null;
	}
}
