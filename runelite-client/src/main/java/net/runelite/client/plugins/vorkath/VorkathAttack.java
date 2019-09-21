/*
 * Copyright (c) 2019, Infinitay <https://github.com/Infinitay>
 *
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

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.ProjectileID;

@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public enum VorkathAttack
{
	/**
	 * Vorkath's melee attack (see VorkathPlugin#onAnimationChanged)
	 */
	SLASH_ATTACK(AnimationID.VORKATH_SLASH_ATTACK, -1),
	/**
	 * Vorkath's dragon breath attack
	 */
	FIRE_BREATH(AnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_DRAGONBREATH),
	/**
	 * Vorkath's dragon breath attack causing the player's active prayers to be deactivated
	 */
	PRAYER_BREATH(AnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_PRAYER_DISABLE),
	/**
	 * Vorkath's dragon breath attack causing the player to become poisoned with venom
	 */
	VENOM_BREATH(AnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_VENOM),
	/**
	 * Vorkath's ranged attack
	 */
	SPIKE(AnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_RANGED),
	/**
	 * Vorkath's magic attack
	 */
	ICE(AnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_MAGIC),
	/**
	 * Vorkath's aoe fire bomb attack (3x3 from where player was originally standing)
	 */
	FIRE_BOMB(AnimationID.VORKATH_FIRE_BOMB_OR_SPAWN_ATTACK, ProjectileID.VORKATH_BOMB_AOE),
	/**
	 * Vorkath's aoe acid attacking, spewing acid across the instance
	 */
	ACID(AnimationID.VORKATH_ACID_ATTACK, ProjectileID.VORKATH_POISON_POOL_AOE),
	/**
	 * Vorkath's fire ball attack that is fired during the acid phase, almost every tick for 25(?) attacks total
	 */
	FIRE_BALL(AnimationID.VORKATH_ACID_ATTACK, ProjectileID.VORKATH_TICK_FIRE_AOE),
	/**
	 * Vorkath's dragon breath attack causing the player to be frozen during Zombified Spawn phase
	 */
	FREEZE_BREATH(AnimationID.VORKATH_ATTACK, ProjectileID.VORKATH_ICE),
	/**
	 * Vorkath's spawning of a Zombified Spawn
	 */
	ZOMBIFIED_SPAWN(AnimationID.VORKATH_FIRE_BOMB_OR_SPAWN_ATTACK, ProjectileID.VORKATH_SPAWN_AOE);

	private static final Map<Integer, VorkathAttack> VORKATH_ATTACKS;
	private static final Map<Integer, VorkathAttack> VORKATH_BASIC_ATTACKS;

	static
	{
		ImmutableMap.Builder<Integer, VorkathAttack> builder = new ImmutableMap.Builder<>();
		for (VorkathAttack vorkathAttack : values())
		{
			builder.put(vorkathAttack.getProjectileID(), vorkathAttack);
		}
		VORKATH_ATTACKS = builder.build();
	}

	static
	{
		ImmutableMap.Builder<Integer, VorkathAttack> builder = new ImmutableMap.Builder<>();
		builder.put(FIRE_BREATH.getProjectileID(), FIRE_BREATH)
			.put(PRAYER_BREATH.getProjectileID(), PRAYER_BREATH)
			.put(VENOM_BREATH.getProjectileID(), VENOM_BREATH)
			.put(SPIKE.getProjectileID(), SPIKE)
			.put(ICE.getProjectileID(), ICE)
			.put(FIRE_BOMB.getProjectileID(), FIRE_BOMB)
			.put(FIRE_BALL.getProjectileID(), FIRE_BALL);
		// FIRE_BOMB and FIRE_BALL are also basic attacks
		// Although SLASH_ATTACK is a basic attack, we're going to handle it differently
		VORKATH_BASIC_ATTACKS = builder.build();
	}

	private final int vorkathAnimationID;
	private final int projectileID;

	/**
	 * @param projectileID id of projectile
	 * @return {@link VorkathAttack} associated with the specified projectile
	 */
	public static VorkathAttack getVorkathAttack(int projectileID)
	{
		return VORKATH_ATTACKS.get(projectileID);
	}

	/**
	 * @param projectileID id of projectile
	 * @return true if the projectile id matches a {@link VorkathAttack#getProjectileID()} within {@link VorkathAttack#VORKATH_BASIC_ATTACKS},
	 * false otherwise
	 */
	public static boolean isBasicAttack(int projectileID)
	{
		return VORKATH_BASIC_ATTACKS.get(projectileID) != null;
	}
}
