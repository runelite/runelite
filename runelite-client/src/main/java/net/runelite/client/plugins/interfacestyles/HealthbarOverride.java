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
import net.runelite.api.gameval.SpriteID;
import net.runelite.client.game.SpriteOverride;

@RequiredArgsConstructor
enum HealthbarOverride implements SpriteOverride
{
	// Reusing the 40px image for the 30px bars is intentional,
	// as a 30px HD bar is way too small and looks very wrong
	DEFAULT_FRONT_30PX(SpriteID.StandardHealth30.FRONT, "default_front_40px.png"),
	DEFAULT_FRONT_40PX(SpriteID.StandardHealth40.FRONT, "default_front_40px.png"),
	DEFAULT_FRONT_50PX(SpriteID.StandardHealth50.FRONT, "default_front_50px.png"),
	DEFAULT_FRONT_60PX(SpriteID.StandardHealth60.FRONT, "default_front_60px.png"),
	DEFAULT_FRONT_70PX(SpriteID.StandardHealth70.FRONT, "default_front_70px.png"),
	DEFAULT_FRONT_80PX(SpriteID.StandardHealth80.FRONT, "default_front_80px.png"),
	DEFAULT_FRONT_90PX(SpriteID.StandardHealth90.FRONT, "default_front_90px.png"),
	DEFAULT_FRONT_100PX(SpriteID.StandardHealth100.FRONT, "default_front_100px.png"),
	DEFAULT_FRONT_120PX(SpriteID.StandardHealth120.FRONT, "default_front_120px.png"),
	DEFAULT_FRONT_140PX(SpriteID.StandardHealth140.FRONT, "default_front_140px.png"),
	DEFAULT_FRONT_160PX(SpriteID.StandardHealth160.FRONT, "default_front_160px.png"),

	DEFAULT_BACK_30PX(SpriteID.StandardHealth30.BACK, "default_back_40px.png"),
	DEFAULT_BACK_40PX(SpriteID.StandardHealth40.BACK, "default_back_40px.png"),
	DEFAULT_BACK_50PX(SpriteID.StandardHealth50.BACK, "default_back_50px.png"),
	DEFAULT_BACK_60PX(SpriteID.StandardHealth60.BACK, "default_back_60px.png"),
	DEFAULT_BACK_70PX(SpriteID.StandardHealth70.BACK, "default_back_70px.png"),
	DEFAULT_BACK_80PX(SpriteID.StandardHealth80.BACK, "default_back_80px.png"),
	DEFAULT_BACK_90PX(SpriteID.StandardHealth90.BACK, "default_back_90px.png"),
	DEFAULT_BACK_100PX(SpriteID.StandardHealth100.BACK, "default_back_100px.png"),
	DEFAULT_BACK_120PX(SpriteID.StandardHealth120.BACK, "default_back_120px.png"),
	DEFAULT_BACK_140PX(SpriteID.StandardHealth140.BACK, "default_back_140px.png"),
	DEFAULT_BACK_160PX(SpriteID.StandardHealth160.BACK, "default_back_160px.png"),

	CYAN_FRONT_30PX(SpriteID.StandardShield30.FRONT, "cyan_front_40px.png"),
	CYAN_FRONT_40PX(SpriteID.StandardShield40.FRONT, "cyan_front_40px.png"),
	CYAN_FRONT_50PX(SpriteID.StandardShield50.FRONT, "cyan_front_50px.png"),
	CYAN_FRONT_60PX(SpriteID.StandardShield60.FRONT, "cyan_front_60px.png"),
	CYAN_FRONT_70PX(SpriteID.StandardShield70.FRONT, "cyan_front_70px.png"),
	CYAN_FRONT_80PX(SpriteID.StandardShield80.FRONT, "cyan_front_80px.png"),
	CYAN_FRONT_90PX(SpriteID.StandardShield90.FRONT, "cyan_front_90px.png"),
	CYAN_FRONT_100PX(SpriteID.StandardShield100.FRONT, "cyan_front_100px.png"),
	CYAN_FRONT_120PX(SpriteID.StandardShield120.FRONT, "cyan_front_120px.png"),
	CYAN_FRONT_140PX(SpriteID.StandardShield140.FRONT, "cyan_front_140px.png"),
	CYAN_FRONT_160PX(SpriteID.StandardShield160.FRONT, "cyan_front_160px.png"),

	CYAN_BACK_30PX(SpriteID.StandardShield30.BACK, "cyan_back_40px.png"),
	CYAN_BACK_40PX(SpriteID.StandardShield40.BACK, "cyan_back_40px.png"),
	CYAN_BACK_50PX(SpriteID.StandardShield50.BACK, "cyan_back_50px.png"),
	CYAN_BACK_60PX(SpriteID.StandardShield60.BACK, "cyan_back_60px.png"),
	CYAN_BACK_70PX(SpriteID.StandardShield70.BACK, "cyan_back_70px.png"),
	CYAN_BACK_80PX(SpriteID.StandardShield80.BACK, "cyan_back_80px.png"),
	CYAN_BACK_90PX(SpriteID.StandardShield90.BACK, "cyan_back_90px.png"),
	CYAN_BACK_100PX(SpriteID.StandardShield100.BACK, "cyan_back_100px.png"),
	CYAN_BACK_120PX(SpriteID.StandardShield120.BACK, "cyan_back_120px.png"),
	CYAN_BACK_140PX(SpriteID.StandardShield140.BACK, "cyan_back_140px.png"),
	CYAN_BACK_160PX(SpriteID.StandardShield160.BACK, "cyan_back_160px.png"),

	ORANGE_FRONT_30PX(SpriteID.StandardArmour30.FRONT, "orange_front_40px.png"),
	ORANGE_FRONT_40PX(SpriteID.StandardArmour40.FRONT, "orange_front_40px.png"),
	ORANGE_FRONT_50PX(SpriteID.StandardArmour50.FRONT, "orange_front_50px.png"),
	ORANGE_FRONT_60PX(SpriteID.StandardArmour60.FRONT, "orange_front_60px.png"),
	ORANGE_FRONT_70PX(SpriteID.StandardArmour70.FRONT, "orange_front_70px.png"),
	ORANGE_FRONT_80PX(SpriteID.StandardArmour80.FRONT, "orange_front_80px.png"),
	ORANGE_FRONT_90PX(SpriteID.StandardArmour90.FRONT, "orange_front_90px.png"),
	ORANGE_FRONT_100PX(SpriteID.StandardArmour100.FRONT, "orange_front_100px.png"),
	ORANGE_FRONT_120PX(SpriteID.StandardArmour120.FRONT, "orange_front_120px.png"),
	ORANGE_FRONT_140PX(SpriteID.StandardArmour140.FRONT, "orange_front_140px.png"),
	ORANGE_FRONT_160PX(SpriteID.StandardArmour160.FRONT, "orange_front_160px.png"),

	ORANGE_BACK_30PX(SpriteID.StandardArmour30.BACK, "orange_back_40px.png"),
	ORANGE_BACK_40PX(SpriteID.StandardArmour40.BACK, "orange_back_40px.png"),
	ORANGE_BACK_50PX(SpriteID.StandardArmour50.BACK, "orange_back_50px.png"),
	ORANGE_BACK_60PX(SpriteID.StandardArmour60.BACK, "orange_back_60px.png"),
	ORANGE_BACK_70PX(SpriteID.StandardArmour70.BACK, "orange_back_70px.png"),
	ORANGE_BACK_80PX(SpriteID.StandardArmour80.BACK, "orange_back_80px.png"),
	ORANGE_BACK_90PX(SpriteID.StandardArmour90.BACK, "orange_back_90px.png"),
	ORANGE_BACK_100PX(SpriteID.StandardArmour100.BACK, "orange_back_100px.png"),
	ORANGE_BACK_120PX(SpriteID.StandardArmour120.BACK, "orange_back_120px.png"),
	ORANGE_BACK_140PX(SpriteID.StandardArmour140.BACK, "orange_back_140px.png"),
	ORANGE_BACK_160PX(SpriteID.StandardArmour160.BACK, "orange_back_160px.png"),

	YELLOW_FRONT_30PX(SpriteID.StandardCharge30.FRONT, "yellow_front_40px.png"),
	YELLOW_FRONT_40PX(SpriteID.StandardCharge40.FRONT, "yellow_front_40px.png"),
	YELLOW_FRONT_50PX(SpriteID.StandardCharge50.FRONT, "yellow_front_50px.png"),
	YELLOW_FRONT_60PX(SpriteID.StandardCharge60.FRONT, "yellow_front_60px.png"),
	YELLOW_FRONT_70PX(SpriteID.StandardCharge70.FRONT, "yellow_front_70px.png"),
	YELLOW_FRONT_80PX(SpriteID.StandardCharge80.FRONT, "yellow_front_80px.png"),
	YELLOW_FRONT_90PX(SpriteID.StandardCharge90.FRONT, "yellow_front_90px.png"),
	YELLOW_FRONT_100PX(SpriteID.StandardCharge100.FRONT, "yellow_front_100px.png"),
	YELLOW_FRONT_120PX(SpriteID.StandardCharge120.FRONT, "yellow_front_120px.png"),
	YELLOW_FRONT_140PX(SpriteID.StandardCharge140.FRONT, "yellow_front_140px.png"),
	YELLOW_FRONT_160PX(SpriteID.StandardCharge160.FRONT, "yellow_front_160px.png"),

	YELLOW_BACK_30PX(SpriteID.StandardCharge30.BACK, "yellow_back_40px.png"),
	YELLOW_BACK_40PX(SpriteID.StandardCharge40.BACK, "yellow_back_40px.png"),
	YELLOW_BACK_50PX(SpriteID.StandardCharge50.BACK, "yellow_back_50px.png"),
	YELLOW_BACK_60PX(SpriteID.StandardCharge60.BACK, "yellow_back_60px.png"),
	YELLOW_BACK_70PX(SpriteID.StandardCharge70.BACK, "yellow_back_70px.png"),
	YELLOW_BACK_80PX(SpriteID.StandardCharge80.BACK, "yellow_back_80px.png"),
	YELLOW_BACK_90PX(SpriteID.StandardCharge90.BACK, "yellow_back_90px.png"),
	YELLOW_BACK_100PX(SpriteID.StandardCharge100.BACK, "yellow_back_100px.png"),
	YELLOW_BACK_120PX(SpriteID.StandardCharge120.BACK, "yellow_back_120px.png"),
	YELLOW_BACK_140PX(SpriteID.StandardCharge140.BACK, "yellow_back_140px.png"),
	YELLOW_BACK_160PX(SpriteID.StandardCharge160.BACK, "yellow_back_160px.png"),

	PURPLE_FRONT_30PX(SpriteID.StandardPrayer30.FRONT, "purple_front_40px.png"),
	PURPLE_FRONT_40PX(SpriteID.StandardPrayer40.FRONT, "purple_front_40px.png"),
	PURPLE_FRONT_50PX(SpriteID.StandardPrayer50.FRONT, "purple_front_50px.png"),
	PURPLE_FRONT_60PX(SpriteID.StandardPrayer60.FRONT, "purple_front_60px.png"),
	PURPLE_FRONT_70PX(SpriteID.StandardPrayer70.FRONT, "purple_front_70px.png"),
	PURPLE_FRONT_80PX(SpriteID.StandardPrayer80.FRONT, "purple_front_80px.png"),
	PURPLE_FRONT_90PX(SpriteID.StandardPrayer90.FRONT, "purple_front_90px.png"),
	PURPLE_FRONT_100PX(SpriteID.StandardPrayer100.FRONT, "purple_front_100px.png"),
	PURPLE_FRONT_120PX(SpriteID.StandardPrayer120.FRONT, "purple_front_120px.png"),
	PURPLE_FRONT_140PX(SpriteID.StandardPrayer140.FRONT, "purple_front_140px.png"),
	PURPLE_FRONT_160PX(SpriteID.StandardPrayer160.FRONT, "purple_front_160px.png"),

	PURPLE_BACK_30PX(SpriteID.StandardPrayer30.BACK, "purple_back_40px.png"),
	PURPLE_BACK_40PX(SpriteID.StandardPrayer40.BACK, "purple_back_40px.png"),
	PURPLE_BACK_50PX(SpriteID.StandardPrayer50.BACK, "purple_back_50px.png"),
	PURPLE_BACK_60PX(SpriteID.StandardPrayer60.BACK, "purple_back_60px.png"),
	PURPLE_BACK_70PX(SpriteID.StandardPrayer70.BACK, "purple_back_70px.png"),
	PURPLE_BACK_80PX(SpriteID.StandardPrayer80.BACK, "purple_back_80px.png"),
	PURPLE_BACK_90PX(SpriteID.StandardPrayer90.BACK, "purple_back_90px.png"),
	PURPLE_BACK_100PX(SpriteID.StandardPrayer100.BACK, "purple_back_100px.png"),
	PURPLE_BACK_120PX(SpriteID.StandardPrayer120.BACK, "purple_back_120px.png"),
	PURPLE_BACK_140PX(SpriteID.StandardPrayer140.BACK, "purple_back_140px.png"),
	PURPLE_BACK_160PX(SpriteID.StandardPrayer160.BACK, "purple_back_160px.png"),

	GREEN_FRONT_30PX(SpriteID.StandardPoison30.FRONT, "green_front_40px.png"),
	GREEN_FRONT_40PX(SpriteID.StandardPoison40.FRONT, "green_front_40px.png"),
	GREEN_FRONT_50PX(SpriteID.StandardPoison50.FRONT, "green_front_50px.png"),
	GREEN_FRONT_60PX(SpriteID.StandardPoison60.FRONT, "green_front_60px.png"),
	GREEN_FRONT_70PX(SpriteID.StandardPoison70.FRONT, "green_front_70px.png"),
	GREEN_FRONT_80PX(SpriteID.StandardPoison80.FRONT, "green_front_80px.png"),
	GREEN_FRONT_90PX(SpriteID.StandardPoison90.FRONT, "green_front_90px.png"),
	GREEN_FRONT_100PX(SpriteID.StandardPoison100.FRONT, "green_front_100px.png"),
	GREEN_FRONT_120PX(SpriteID.StandardPoison120.FRONT, "green_front_120px.png"),
	GREEN_FRONT_140PX(SpriteID.StandardPoison140.FRONT, "green_front_140px.png"),
	GREEN_FRONT_160PX(SpriteID.StandardPoison160.FRONT, "green_front_160px.png"),

	GREEN_BACK_30PX(SpriteID.StandardPoison30.BACK, "green_back_40px.png"),
	GREEN_BACK_40PX(SpriteID.StandardPoison40.BACK, "green_back_40px.png"),
	GREEN_BACK_50PX(SpriteID.StandardPoison50.BACK, "green_back_50px.png"),
	GREEN_BACK_60PX(SpriteID.StandardPoison60.BACK, "green_back_60px.png"),
	GREEN_BACK_70PX(SpriteID.StandardPoison70.BACK, "green_back_70px.png"),
	GREEN_BACK_80PX(SpriteID.StandardPoison80.BACK, "green_back_80px.png"),
	GREEN_BACK_90PX(SpriteID.StandardPoison90.BACK, "green_back_90px.png"),
	GREEN_BACK_100PX(SpriteID.StandardPoison100.BACK, "green_back_100px.png"),
	GREEN_BACK_120PX(SpriteID.StandardPoison120.BACK, "green_back_120px.png"),
	GREEN_BACK_140PX(SpriteID.StandardPoison140.BACK, "green_back_140px.png"),
	GREEN_BACK_160PX(SpriteID.StandardPoison160.BACK, "green_back_160px.png"),

	BLUE_FRONT_50PX(SpriteID.HeadbarShootingStar50.FRONT, "blue_front_50px.png"),
	BLUE_BACK_50PX(SpriteID.HeadbarShootingStar50.BACK, "blue_back_50px.png"),

	COX_GREEN(SpriteID.HeadbarShield100.COX_GREEN, "cox_green.png"),
	COX_BLUE(SpriteID.HeadbarShield100.COX_BLUE, "cox_blue.png"),
	COX_YELLOW(SpriteID.HeadbarOlmtimer100.YELLOW, "cox_yellow.png"),
	COX_RED(SpriteID.HeadbarOlmtimer100.RED, "cox_red.png"),

	BLOOD_MOON_FRONT_120PX(SpriteID.HeadbarBlood120.FRONT, "blood_moon_front_120px.png"),
	BLOOD_MOON_BACK_120PX(SpriteID.HeadbarBlood120.BACK, "blood_moon_back_120px.png"),
	BLUE_MOON_FRONT_120PX(SpriteID.HeadbarIce120.FRONT, "blue_moon_front_120px.png"),
	BLUE_MOON_BACK_120PX(SpriteID.HeadbarIce120.BACK, "blue_moon_back_120px.png"),
	ECLIPSE_MOON_FRONT_120PX(SpriteID.HeadbarHeat120.FRONT, "eclipse_moon_front_120px.png"),
	ECLIPSE_MOON_BACK_120PX(SpriteID.HeadbarHeat120.BACK, "eclipse_moon_back_120px.png"),

	BLOOD_MOON_FRONT_90PX(SpriteID.HeadbarBlood90.FRONT, "blood_moon_front_90px.png"),
	BLOOD_MOON_BACK_90PX(SpriteID.HeadbarBlood90.BACK, "blood_moon_back_90px.png"),
	BLUE_MOON_FRONT_90PX(SpriteID.HeadbarIce90.FRONT, "blue_moon_front_90px.png"),
	BLUE_MOON_BACK_90PX(SpriteID.HeadbarIce90.BACK, "blue_moon_back_90px.png"),
	ECLIPSE_MOON_FRONT_90PX(SpriteID.HeadbarHeat90.FRONT, "eclipse_moon_front_90px.png"),
	ECLIPSE_MOON_BACK_90PX(SpriteID.HeadbarHeat90.BACK, "eclipse_moon_back_90px.png"),

	LAST_STAND_FRONT(SpriteID.HeadbarBlood30.FRONT, "last_stand_front.png"),
	LAST_STAND_BACK(SpriteID.HeadbarBlood30.BACK, "last_stand_back.png"),
	;

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