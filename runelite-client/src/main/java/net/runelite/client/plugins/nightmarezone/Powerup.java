/*
 * Copyright (c) 2019, Adam Witkowski <https://github.com/adwitkow>
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
package net.runelite.client.plugins.nightmarezone;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import net.runelite.api.ObjectID;
import net.runelite.api.SpriteID;
import java.util.Map;

enum Powerup
{
	RECURRENT_DAMAGE("Recurrent damage", 45, ObjectID.RECURRENT_DAMAGE, SpriteID.MINIMAP_ORB_HITPOINTS),
	ZAPPER("Zapper", 60, ObjectID.ZAPPER_26256, SpriteID.MINIMAP_ORB_PRAYER),
	POWER_SURGE("Power surge", 45, ObjectID.POWER_SURGE, SpriteID.MINIMAP_ORB_HITPOINTS_DISEASE),
	ULTIMATE_FORCE("Ultimate force", 0, ObjectID.ULTIMATE_FORCE, SpriteID.MINIMAP_ORB_RUN);

	private static final Map<Integer, Powerup> POWERUPS;

	static
	{
		ImmutableMap.Builder<Integer, Powerup> builder = new ImmutableMap.Builder<>();
		for (Powerup powerup : values())
		{
			builder.put(powerup.gameObjectId, powerup);
		}
		POWERUPS = builder.build();
	}

	@Getter
	private final String name;
	@Getter
	private final int activityTime;
	@Getter
	private final int spriteId;
	private final int gameObjectId;

	Powerup(String name, int activityTime, int gameObjectId, int spriteId)
	{
		this.name = name;
		this.activityTime = activityTime;
		this.gameObjectId = gameObjectId;
		this.spriteId = spriteId;
	}

	static Powerup getPowerup(int gameObjectId)
	{
		return POWERUPS.get(gameObjectId);
	}
}
