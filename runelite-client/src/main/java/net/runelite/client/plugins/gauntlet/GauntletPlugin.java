/*
 * Copyright (c) 2019, xperiaclash <https://github.com/xperiaclash>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.gauntlet;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.HeadIcon;
import net.runelite.api.NPC;
import net.runelite.api.NPCDefinition;
import net.runelite.api.Prayer;
import net.runelite.api.ProjectileID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Gauntlet Boss Helper",
	description = "Prayer Overlay For The Gauntlet Boss",
	tags = {"gauntlet"},
	type = PluginType.PVM,
	enabledByDefault = false
)

@Singleton
@Slf4j
public class GauntletPlugin extends Plugin
{

	private static final Set<Integer> HUNLEFF_ANIMATIONS = ImmutableSet.of(AnimationID.HUNLEFF_ATTACK, AnimationID.HUNLEFF_TORNADO);
	private static final Set<Integer> HUNLEFF_MAGE_PROJECTILES = ImmutableSet.of(ProjectileID.HUNLEFF_MAGE_ATTACK, ProjectileID.HUNLEFF_CORRUPTED_MAGE_ATTACK);
	private static final Set<Integer> HUNLEFF_RANGE_PROJECTILES = ImmutableSet.of(ProjectileID.HUNLEFF_RANGE_ATTACK, ProjectileID.HUNLEFF_CORRUPTED_RANGE_ATTACK);
	@Inject
	private EventBus eventBus;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private GauntletInfoBox GauntletInfoBox;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private int attacks = 0;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private Prayer nextPrayer;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private NPC hunllef;
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private boolean firstHitDetected;


	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();
		overlayManager.add(GauntletInfoBox);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		overlayManager.remove(GauntletInfoBox);
		reset();
	}

	private void addSubscriptions()
	{

		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (npc.getName() == null || !npc.getName().toLowerCase().contains("hunllef"))
		{
			return;
		}

		setHunllef(npc);

		eventBus.subscribe(AnimationChanged.class, "gauntlet", this::onAnimationChanged);
		eventBus.subscribe(ProjectileSpawned.class, "gauntlet", this::onProjectileSpawned);
	}

	private void onNpcDespawned(NpcDespawned event)
	{
		final NPC npc = event.getNpc();

		if (npc.getName() == null || !npc.getName().toLowerCase().contains("hunllef"))
		{
			return;
		}

		eventBus.unregister("gauntlet");
		reset();
	}

	private void onProjectileSpawned(ProjectileSpawned event)
	{
		if (getHunllef() == null || isFirstHitDetected())
		{
			return;
		}

		final int projectileID = event.getProjectile().getId();

		if (HUNLEFF_MAGE_PROJECTILES.contains(projectileID))
		{
			setNextPrayer(Prayer.PROTECT_FROM_MAGIC);
			setFirstHitDetected(true);
		}
		else if (HUNLEFF_RANGE_PROJECTILES.contains(projectileID))
		{
			setNextPrayer(Prayer.PROTECT_FROM_MISSILES);
			setFirstHitDetected(true);
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (hunllef == null)
		{
			return;
		}

		final int anim = event.getActor().getAnimation();

		if (!HUNLEFF_ANIMATIONS.contains(anim))
		{
			return;
		}

		setAttacks(getAttacks() + 1);

		if (getAttacks() == 4)
		{
			if (getNextPrayer() == Prayer.PROTECT_FROM_MISSILES)
			{
				log.debug("Attacks are: {}, switching to prot mage", getAttacks());
				setNextPrayer(Prayer.PROTECT_FROM_MAGIC);
			}
			else if (getNextPrayer() == Prayer.PROTECT_FROM_MAGIC)
			{
				log.debug("Attacks are: {}, switching to prot missiles", getAttacks());
				setNextPrayer(Prayer.PROTECT_FROM_MISSILES);
			}
			setAttacks(0);
		}
	}

	private void reset()
	{
		setHunllef(null);
		setNextPrayer(null);
		setFirstHitDetected(false);
		setAttacks(0);
	}

	private HeadIcon getOverheadIcon(NPC npc)
	{
		NPCDefinition composition = npc.getDefinition();
		if (composition != null)
		{
			return composition.getOverheadIcon();
		}
		return null;
	}

}
