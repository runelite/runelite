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
import net.runelite.api.ProjectileID;

public enum AoeProjectileInfo
{
	LIZARDMAN_SHAMAN_AOE(ProjectileID.LIZARDMAN_SHAMAN_AOE, 3000, 3),
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
	TEKTON_METEOR_AOE(ProjectileID.TEKTON_METEOR_AOE, 4000, 3);

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
		for (AoeProjectileInfo aoeProjectileInfo : values())
		{
			if (id == aoeProjectileInfo.getId())
			{
				return aoeProjectileInfo;
			}
		}
		return null;
	}
}
