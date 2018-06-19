/*
 * Copyright (c) 2016-2018, Dewin <dewin@dewinster.com>
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
package net.runelite.client.plugins.vorkath;

import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.Subscribe;
import java.util.Set;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(name = "Vorkath")
public class VorkathPlugin extends Plugin
{
	private static final int AMOUNT_SPECIAL_ATTACK_COUNTER = 6;
	private static final int AMOUNT_OF_POISON_BOLTS = 25;
	private static final Set<Integer> VORKATH_NPC_IDS = ImmutableSet.of(
		NpcID.VORKATH,
		NpcID.VORKATH_8058,
		NpcID.VORKATH_8059,
		NpcID.VORKATH_8060,
		NpcID.VORKATH_8061);

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private VorkathOverlay vorkathOverlay;

	@Getter
	private int normalAttackCounter;

	@Getter
	private int poisonBoltsCounter;

	@Getter
	private VorkathState nextSpecialAttack;

	@Getter
	private VorkathState vorkathState;

	@Getter
	private boolean isInArea;

	int getAttacksTillSpecial()
	{
		return AMOUNT_SPECIAL_ATTACK_COUNTER - normalAttackCounter;
	}

	int getAmountOfPoisonBoltsLeft()
	{
		return AMOUNT_OF_POISON_BOLTS - poisonBoltsCounter;
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(vorkathOverlay);
		reset();
		isInArea = false;
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(vorkathOverlay);
		reset();
		isInArea = false;
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (!(actor instanceof NPC))
		{
			return;
		}

		NPC npc = (NPC) actor;

		if (!VORKATH_NPC_IDS.contains(npc.getId()))
		{
			return;
		}

		switch (npc.getAnimation())
		{
			case AnimationID.VORKATH_WAKE_UP:
			case AnimationID.VORKATH_DEATH:
				reset();
				break;
			case AnimationID.VORKATH_SLASH_ATTACK:
				onNormalAttack();
				break;
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		final NPC npc = npcSpawned.getNpc();

		if (npc != null && VORKATH_NPC_IDS.contains(npc.getId()))
		{
			isInArea = true;
			reset();
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		final NPC npc = npcDespawned.getNpc();

		if (npc != null && VORKATH_NPC_IDS.contains(npc.getId()))
		{
			isInArea = false;
			reset();
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		final Projectile projectile = event.getProjectile();

		if (projectile.getInteracting() != null && client.getGameCycle() >= projectile.getStartMovementCycle())
		{
			return;
		}

		int projectileId = projectile.getId();

		switch (projectileId)
		{
			case ProjectileID.VORKATH_DRAGONBREATH:
			case ProjectileID.VORKATH_RANGED:
			case ProjectileID.VORKATH_MAGIC:
			case ProjectileID.VORKATH_VENOM:
			case ProjectileID.VORKATH_PRAYER_DISABLE:
			case ProjectileID.VORKATH_BOMB_AOE:
				onNormalAttack();
				break;
			case ProjectileID.VORKATH_ICE:
				normalAttackCounter = 0;
				poisonBoltsCounter = 0;
				vorkathState = VorkathState.FREEZE_PHASE;
				nextSpecialAttack = VorkathState.TICKER_FIRE_PHASE;
				break;
			case ProjectileID.VORKATH_TICK_FIRE_AOE:
				normalAttackCounter = 0;
				poisonBoltsCounter++;
				vorkathState = VorkathState.TICKER_FIRE_PHASE;
				nextSpecialAttack = VorkathState.FREEZE_PHASE;
				break;
		}

	}

	@Subscribe
	public void onGameState(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			reset();
		}
	}

	@Subscribe
	public void onLocalPlayerDeath(LocalPlayerDeath player)
	{
		reset();
	}

	private void reset()
	{
		normalAttackCounter = 0;
		poisonBoltsCounter = 0;
		vorkathState = VorkathState.IDLE;
		nextSpecialAttack = VorkathState.IDLE;
	}

	private void onNormalAttack()
	{
		normalAttackCounter++;
		poisonBoltsCounter = 0;
		vorkathState = VorkathState.IDLE;
	}
}
