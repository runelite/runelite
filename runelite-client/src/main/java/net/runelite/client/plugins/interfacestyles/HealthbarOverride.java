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
	// Reusing the 40px image for the 30px bars is intentional,
	// as a 30px HD bar is way too small and looks very wrong
	DEFAULT_FRONT_30PX(HEALTHBAR_DEFAULT_FRONT_30PX, "default_front_40px.png"),
	DEFAULT_FRONT_40PX(HEALTHBAR_DEFAULT_FRONT_40PX, "default_front_40px.png"),
	DEFAULT_FRONT_50PX(HEALTHBAR_DEFAULT_FRONT_50PX, "default_front_50px.png"),
	DEFAULT_FRONT_60PX(HEALTHBAR_DEFAULT_FRONT_60PX, "default_front_60px.png"),
	DEFAULT_FRONT_70PX(HEALTHBAR_DEFAULT_FRONT_70PX, "default_front_70px.png"),
	DEFAULT_FRONT_80PX(HEALTHBAR_DEFAULT_FRONT_80PX, "default_front_80px.png"),
	DEFAULT_FRONT_100PX(HEALTHBAR_DEFAULT_FRONT_100PX, "default_front_100px.png"),
	DEFAULT_FRONT_120PX(HEALTHBAR_DEFAULT_FRONT_120PX, "default_front_120px.png"),
	DEFAULT_FRONT_140PX(HEALTHBAR_DEFAULT_FRONT_140PX, "default_front_140px.png"),
	DEFAULT_FRONT_160PX(HEALTHBAR_DEFAULT_FRONT_160PX, "default_front_160px.png"),

	DEFAULT_BACK_30PX(HEALTHBAR_DEFAULT_BACK_30PX, "default_back_40px.png"),
	DEFAULT_BACK_40PX(HEALTHBAR_DEFAULT_BACK_40PX, "default_back_40px.png"),
	DEFAULT_BACK_50PX(HEALTHBAR_DEFAULT_BACK_50PX, "default_back_50px.png"),
	DEFAULT_BACK_60PX(HEALTHBAR_DEFAULT_BACK_60PX, "default_back_60px.png"),
	DEFAULT_BACK_70PX(HEALTHBAR_DEFAULT_BACK_70PX, "default_back_70px.png"),
	DEFAULT_BACK_80PX(HEALTHBAR_DEFAULT_BACK_80PX, "default_back_80px.png"),
	DEFAULT_BACK_100PX(HEALTHBAR_DEFAULT_BACK_100PX, "default_back_100px.png"),
	DEFAULT_BACK_120PX(HEALTHBAR_DEFAULT_BACK_120PX, "default_back_120px.png"),
	DEFAULT_BACK_140PX(HEALTHBAR_DEFAULT_BACK_140PX, "default_back_140px.png"),
	DEFAULT_BACK_160PX(HEALTHBAR_DEFAULT_BACK_160PX, "default_back_160px.png"),

	CYAN_FRONT_30PX(HEALTHBAR_CYAN_FRONT_30PX, "cyan_front_40px.png"),
	CYAN_FRONT_40PX(HEALTHBAR_CYAN_FRONT_40PX, "cyan_front_40px.png"),
	CYAN_FRONT_50PX(HEALTHBAR_CYAN_FRONT_50PX, "cyan_front_50px.png"),
	CYAN_FRONT_60PX(HEALTHBAR_CYAN_FRONT_60PX, "cyan_front_60px.png"),
	CYAN_FRONT_70PX(HEALTHBAR_CYAN_FRONT_70PX, "cyan_front_70px.png"),
	CYAN_FRONT_80PX(HEALTHBAR_CYAN_FRONT_80PX, "cyan_front_80px.png"),
	CYAN_FRONT_100PX(HEALTHBAR_CYAN_FRONT_100PX, "cyan_front_100px.png"),
	CYAN_FRONT_120PX(HEALTHBAR_CYAN_FRONT_120PX, "cyan_front_120px.png"),
	CYAN_FRONT_140PX(HEALTHBAR_CYAN_FRONT_140PX, "cyan_front_140px.png"),
	CYAN_FRONT_160PX(HEALTHBAR_CYAN_FRONT_160PX, "cyan_front_160px.png"),

	CYAN_BACK_30PX(HEALTHBAR_CYAN_BACK_30PX, "cyan_back_40px.png"),
	CYAN_BACK_40PX(HEALTHBAR_CYAN_BACK_40PX, "cyan_back_40px.png"),
	CYAN_BACK_50PX(HEALTHBAR_CYAN_BACK_50PX, "cyan_back_50px.png"),
	CYAN_BACK_60PX(HEALTHBAR_CYAN_BACK_60PX, "cyan_back_60px.png"),
	CYAN_BACK_70PX(HEALTHBAR_CYAN_BACK_70PX, "cyan_back_70px.png"),
	CYAN_BACK_80PX(HEALTHBAR_CYAN_BACK_80PX, "cyan_back_80px.png"),
	CYAN_BACK_100PX(HEALTHBAR_CYAN_BACK_100PX, "cyan_back_100px.png"),
	CYAN_BACK_120PX(HEALTHBAR_CYAN_BACK_120PX, "cyan_back_120px.png"),
	CYAN_BACK_140PX(HEALTHBAR_CYAN_BACK_140PX, "cyan_back_140px.png"),
	CYAN_BACK_160PX(HEALTHBAR_CYAN_BACK_160PX, "cyan_back_160px.png"),

	ORANGE_FRONT_30PX(HEALTHBAR_ORANGE_FRONT_30PX, "orange_front_40px.png"),
	ORANGE_FRONT_40PX(HEALTHBAR_ORANGE_FRONT_40PX, "orange_front_40px.png"),
	ORANGE_FRONT_50PX(HEALTHBAR_ORANGE_FRONT_50PX, "orange_front_50px.png"),
	ORANGE_FRONT_60PX(HEALTHBAR_ORANGE_FRONT_60PX, "orange_front_60px.png"),
	ORANGE_FRONT_70PX(HEALTHBAR_ORANGE_FRONT_70PX, "orange_front_70px.png"),
	ORANGE_FRONT_80PX(HEALTHBAR_ORANGE_FRONT_80PX, "orange_front_80px.png"),
	ORANGE_FRONT_100PX(HEALTHBAR_ORANGE_FRONT_100PX, "orange_front_100px.png"),
	ORANGE_FRONT_120PX(HEALTHBAR_ORANGE_FRONT_120PX, "orange_front_120px.png"),
	ORANGE_FRONT_140PX(HEALTHBAR_ORANGE_FRONT_140PX, "orange_front_140px.png"),
	ORANGE_FRONT_160PX(HEALTHBAR_ORANGE_FRONT_160PX, "orange_front_160px.png"),

	ORANGE_BACK_30PX(HEALTHBAR_ORANGE_BACK_30PX, "orange_back_40px.png"),
	ORANGE_BACK_40PX(HEALTHBAR_ORANGE_BACK_40PX, "orange_back_40px.png"),
	ORANGE_BACK_50PX(HEALTHBAR_ORANGE_BACK_50PX, "orange_back_50px.png"),
	ORANGE_BACK_60PX(HEALTHBAR_ORANGE_BACK_60PX, "orange_back_60px.png"),
	ORANGE_BACK_70PX(HEALTHBAR_ORANGE_BACK_70PX, "orange_back_70px.png"),
	ORANGE_BACK_80PX(HEALTHBAR_ORANGE_BACK_80PX, "orange_back_80px.png"),
	ORANGE_BACK_100PX(HEALTHBAR_ORANGE_BACK_100PX, "orange_back_100px.png"),
	ORANGE_BACK_120PX(HEALTHBAR_ORANGE_BACK_120PX, "orange_back_120px.png"),
	ORANGE_BACK_140PX(HEALTHBAR_ORANGE_BACK_140PX, "orange_back_140px.png"),
	ORANGE_BACK_160PX(HEALTHBAR_ORANGE_BACK_160PX, "orange_back_160px.png"),

	YELLOW_FRONT_30PX(HEALTHBAR_YELLOW_FRONT_30PX, "yellow_front_40px.png"),
	YELLOW_FRONT_40PX(HEALTHBAR_YELLOW_FRONT_40PX, "yellow_front_40px.png"),
	YELLOW_FRONT_50PX(HEALTHBAR_YELLOW_FRONT_50PX, "yellow_front_50px.png"),
	YELLOW_FRONT_60PX(HEALTHBAR_YELLOW_FRONT_60PX, "yellow_front_60px.png"),
	YELLOW_FRONT_70PX(HEALTHBAR_YELLOW_FRONT_70PX, "yellow_front_70px.png"),
	YELLOW_FRONT_80PX(HEALTHBAR_YELLOW_FRONT_80PX, "yellow_front_80px.png"),
	YELLOW_FRONT_100PX(HEALTHBAR_YELLOW_FRONT_100PX, "yellow_front_100px.png"),
	YELLOW_FRONT_120PX(HEALTHBAR_YELLOW_FRONT_120PX, "yellow_front_120px.png"),
	YELLOW_FRONT_140PX(HEALTHBAR_YELLOW_FRONT_140PX, "yellow_front_140px.png"),
	YELLOW_FRONT_160PX(HEALTHBAR_YELLOW_FRONT_160PX, "yellow_front_160px.png"),

	YELLOW_BACK_30PX(HEALTHBAR_YELLOW_BACK_30PX, "yellow_back_40px.png"),
	YELLOW_BACK_40PX(HEALTHBAR_YELLOW_BACK_40PX, "yellow_back_40px.png"),
	YELLOW_BACK_50PX(HEALTHBAR_YELLOW_BACK_50PX, "yellow_back_50px.png"),
	YELLOW_BACK_60PX(HEALTHBAR_YELLOW_BACK_60PX, "yellow_back_60px.png"),
	YELLOW_BACK_70PX(HEALTHBAR_YELLOW_BACK_70PX, "yellow_back_70px.png"),
	YELLOW_BACK_80PX(HEALTHBAR_YELLOW_BACK_80PX, "yellow_back_80px.png"),
	YELLOW_BACK_100PX(HEALTHBAR_YELLOW_BACK_100PX, "yellow_back_100px.png"),
	YELLOW_BACK_120PX(HEALTHBAR_YELLOW_BACK_120PX, "yellow_back_120px.png"),
	YELLOW_BACK_140PX(HEALTHBAR_YELLOW_BACK_140PX, "yellow_back_140px.png"),
	YELLOW_BACK_160PX(HEALTHBAR_YELLOW_BACK_160PX, "yellow_back_160px.png"),

	PURPLE_FRONT_30PX(HEALTHBAR_PURPLE_FRONT_30PX, "purple_front_40px.png"),
	PURPLE_FRONT_40PX(HEALTHBAR_PURPLE_FRONT_40PX, "purple_front_40px.png"),
	PURPLE_FRONT_50PX(HEALTHBAR_PURPLE_FRONT_50PX, "purple_front_50px.png"),
	PURPLE_FRONT_60PX(HEALTHBAR_PURPLE_FRONT_60PX, "purple_front_60px.png"),
	PURPLE_FRONT_70PX(HEALTHBAR_PURPLE_FRONT_70PX, "purple_front_70px.png"),
	PURPLE_FRONT_80PX(HEALTHBAR_PURPLE_FRONT_80PX, "purple_front_80px.png"),
	PURPLE_FRONT_100PX(HEALTHBAR_PURPLE_FRONT_100PX, "purple_front_100px.png"),
	PURPLE_FRONT_120PX(HEALTHBAR_PURPLE_FRONT_120PX, "purple_front_120px.png"),
	PURPLE_FRONT_140PX(HEALTHBAR_PURPLE_FRONT_140PX, "purple_front_140px.png"),
	PURPLE_FRONT_160PX(HEALTHBAR_PURPLE_FRONT_160PX, "purple_front_160px.png"),

	PURPLE_BACK_30PX(HEALTHBAR_PURPLE_BACK_30PX, "purple_back_40px.png"),
	PURPLE_BACK_40PX(HEALTHBAR_PURPLE_BACK_40PX, "purple_back_40px.png"),
	PURPLE_BACK_50PX(HEALTHBAR_PURPLE_BACK_50PX, "purple_back_50px.png"),
	PURPLE_BACK_60PX(HEALTHBAR_PURPLE_BACK_60PX, "purple_back_60px.png"),
	PURPLE_BACK_70PX(HEALTHBAR_PURPLE_BACK_70PX, "purple_back_70px.png"),
	PURPLE_BACK_80PX(HEALTHBAR_PURPLE_BACK_80PX, "purple_back_80px.png"),
	PURPLE_BACK_100PX(HEALTHBAR_PURPLE_BACK_100PX, "purple_back_100px.png"),
	PURPLE_BACK_120PX(HEALTHBAR_PURPLE_BACK_120PX, "purple_back_120px.png"),
	PURPLE_BACK_140PX(HEALTHBAR_PURPLE_BACK_140PX, "purple_back_140px.png"),
	PURPLE_BACK_160PX(HEALTHBAR_PURPLE_BACK_160PX, "purple_back_160px.png"),

	BLUE_FRONT_50PX(HEALTHBAR_BLUE_FRONT_50PX, "blue_front_50px.png"),
	BLUE_BACK_50PX(HEALTHBAR_BLUE_BACK_50PX, "blue_back_50px.png"),

	COX_GREEN(HEALTHBAR_COX_GREEN, "cox_green.png"),
	COX_BLUE(HEALTHBAR_COX_BLUE, "cox_blue.png"),
	COX_YELLOW(HEALTHBAR_COX_YELLOW, "cox_yellow.png"),
	COX_RED(HEALTHBAR_COX_RED, "cox_red.png");

	@Getter
	private final int spriteId;

	private final String fileName;

	@Getter
	@SuppressWarnings("PMD.FinalFieldCouldBeStatic")
	private final int padding = 1;

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