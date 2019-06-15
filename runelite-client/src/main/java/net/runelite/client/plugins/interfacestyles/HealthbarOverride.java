/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.interfacestyles;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import static net.runelite.api.SpriteID.*;
import net.runelite.client.game.SpriteOverride;

@RequiredArgsConstructor
enum HealthbarOverride implements SpriteOverride
{
	BACK_30PX(HEALTHBAR_DEFAULT_BACK_30PX, "back_30px.png"),
	BACK_50PX(HEALTHBAR_DEFAULT_BACK_50PX, "back_30px.png"),
	BACK_60PX(HEALTHBAR_DEFAULT_BACK_60PX, "back_30px.png"),
	BACK_80PX(HEALTHBAR_DEFAULT_BACK_80PX, "back_90px.png"),
	BACK_100PX(HEALTHBAR_DEFAULT_BACK_100PX, "back_90px.png"),
	BACK_120PX(HEALTHBAR_DEFAULT_BACK_120PX, "back_90px.png"),
	BACK_140PX(HEALTHBAR_DEFAULT_BACK_140PX, "back_90px.png"),
	BACK_160PX(HEALTHBAR_DEFAULT_BACK_160PX, "back_90px.png"),

	FRONT_30PX(HEALTHBAR_DEFAULT_FRONT_30PX, "front_30px.png"),
	FRONT_50PX(HEALTHBAR_DEFAULT_FRONT_50PX, "front_30px.png"),
	FRONT_60PX(HEALTHBAR_DEFAULT_FRONT_60PX, "front_30px.png"),
	FRONT_80PX(HEALTHBAR_DEFAULT_FRONT_80PX, "front_90px.png"),
	FRONT_100PX(HEALTHBAR_DEFAULT_FRONT_100PX, "front_90px.png"),
	FRONT_120PX(HEALTHBAR_DEFAULT_FRONT_120PX, "front_90px.png"),
	FRONT_140PX(HEALTHBAR_DEFAULT_FRONT_140PX, "front_90px.png"),
	FRONT_160PX(HEALTHBAR_DEFAULT_FRONT_160PX, "front_90px.png");

	@Getter
	private final int spriteId;

	private final String fileName;

	@Getter
	private int padding = 1;

	private static final Map<Integer, HealthbarOverride> MAP;

	static
	{
		ImmutableMap.Builder<Integer, HealthbarOverride> builder = new ImmutableMap.Builder<>();

		for (HealthbarOverride override : values())
		{
			builder.put(override.spriteId, override);
		}

		MAP = builder.build();
	}

	static HealthbarOverride get(int spriteID)
	{
		return MAP.get(spriteID);
	}

	@Override
	public String getFileName()
	{
		return Skin.AROUND_2010.toString() + "/healthbar/" + this.fileName;
	}
}