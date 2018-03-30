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
package net.runelite.client.plugins.raids.projectileindicators;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ProjectileID;

public enum ProjectileInfo
{
	LIZARDMAN_SHAMAN_AOE(ProjectileID.LIZARDMAN_SHAMAN_AOE),
	VASA_RANGED_AOE(ProjectileID.VASA_RANGED_AOE),
	TEKTON_METEOR_AOE(ProjectileID.TEKTON_METEOR_AOE);

	/**
	 * The id of the projectile to trigger this AoE warning
	 */
	private final int id;

	private static final Map<Integer, ProjectileInfo> map = new HashMap<>();

	static
	{
		for (ProjectileInfo aoe : values())
		{
			map.put(aoe.id, aoe);
		}
	}

	ProjectileInfo(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public static ProjectileInfo getById(int id)
	{
		return map.get(id);
	}
}