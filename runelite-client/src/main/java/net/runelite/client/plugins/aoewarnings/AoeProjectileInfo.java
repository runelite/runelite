/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.aoewarnings;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ProjectileID;

public enum AoeProjectileInfo
{
	LIZARDMAN_SHAMAN_AOE(ProjectileID.LIZARDMAN_SHAMAN_AOE, 3000, 3),
	CRAZY_ARCHAEOLOGIST_AOE(ProjectileID.CRAZY_ARCHAEOLOGIST_AOE, 3000, 3),
	ICE_DEMON_RANGED_AOE(ProjectileID.ICE_DEMON_RANGED_AOE, 3000, 3),
	/**
	 * When you don't have pray range on ice demon does an ice barrage
	 */
	ICE_DEMON_ICE_BARRAGE_AOE(ProjectileID.ICE_DEMON_ICE_BARRAGE_AOE, 3000, 3),
	/**
	 * The AOE when vasa first starts
	 */
	VASA_AWAKEN_AOE(ProjectileID.VASA_AWAKEN_AOE, 4500, 3),
	VASA_RANGED_AOE(ProjectileID.VASA_RANGED_AOE, 3000, 3),
	TEKTON_METEOR_AOE(ProjectileID.TEKTON_METEOR_AOE, 4000, 3),

	/**
	 * The AOEs of Vorkath
	 */
	VORKATH_BOMB(ProjectileID.VORKATH_BOMB_AOE, 2400, 3),
	VORKATH_POISON_POOL(ProjectileID.VORKATH_POISON_POOL_AOE, 1800, 1),
	VORKATH_SPAWN(ProjectileID.VORKATH_SPAWN_AOE, 3000, 1), //extra tick because hard to see otherwise
	VORKATH_TICK_FIRE(ProjectileID.VORKATH_TICK_FIRE_AOE, 600, 1),

	/**
	 * the AOEs of Galvek
	 */
	GALVEK_MINE(ProjectileID.GALVEK_MINE, 3600, 3),
	GALVEK_BOMB(ProjectileID.GALVEK_BOMB, 2400, 3),

	DAWN_FREEZE(ProjectileID.DAWN_FREEZE, 3000, 3),
	DUSK_CEILING(ProjectileID.DUSK_CEILING, 3000, 3),

	/**
	 * the AOE of Vet'ion
	 */
	VETION_LIGHTNING(ProjectileID.VETION_LIGHTNING, 3000, 1),

	/**
	 * the AOE of Chaos Fanatic
	 */
	CHAOS_FANATIC(ProjectileID.CHAOS_FANATIC_AOE, 3000, 1),

	/**
	 * the AOE of the Corporeal Beast
	 */

	CORPOREAL_BEAST(ProjectileID.CORPOREAL_BEAST_AOE, 3000, 1),
	CORPOREAL_BEAST_DARK_CORE(ProjectileID.CORPOREAL_BEAST_DARK_CORE_AOE, 3000, 3),

	/**
	 * the AOEs of The Great Olm
	 * missing ids and length, please help
	 */
	OLM_FALLING_CRYSTAL(ProjectileID.OLM_FALLING_CRYSTAL_AOE, 2400, 3),
	OLM_BURNING(ProjectileID.OLM_BURNING_AOE, 2400, 3),

	/**
	 * the AOE of the Wintertodt snow that falls
	 */
	WINTERTODT_SNOW_FALL(ProjectileID.WINTERTODT_SNOW_FALL_AOE, 4000, 3);


	/**
	 * The id of the projectile to trigger this AoE warning
	 */
	private final int id;

	/**
	 * How long the indicator should last for this AoE warning This might
	 * need to be a bit longer than the projectile actually takes to land as
	 * there is a fade effect on the warning
	 */
	private final Duration lifeTime;

	/**
	 * The size of the splash radius of the AoE warning Ex. Lizardman shaman
	 * AoE is a 3x3, so aoeSize = 3
	 */
	private final int aoeSize;

	private static final Map<Integer, AoeProjectileInfo> map = new HashMap<>();

	static
	{
		for (AoeProjectileInfo aoe : values())
		{
			map.put(aoe.id, aoe);
		}
	}

	AoeProjectileInfo(int id, int lifeTimeMillis, int aoeSize)
	{
		this.id = id;
		this.lifeTime = Duration.ofMillis(lifeTimeMillis);
		this.aoeSize = aoeSize;
	}

	public Duration getLifeTime()
	{
		return lifeTime;
	}

	public int getId()
	{
		return id;
	}

	public int getAoeSize()
	{
		return aoeSize;
	}

	public static AoeProjectileInfo getById(int id)
	{
		return map.get(id);
	}
}
