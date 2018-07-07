/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package net.runelite.client.plugins.implings;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

/**
 *
 * @author robin
 */
@ConfigGroup("It's coming home")
public interface ImplingsConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showBaby()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getBabyColor()
	{
		return new Color(177, 143, 179);
	}

	@ConfigItem(
		position = 3,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showYoung()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getYoungColor()
	{
		return new Color(175, 164, 136);
	}

	@ConfigItem(
		position = 5,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showGourmet()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getGourmetColor()
	{
		return new Color(169, 131, 98);
	}

	@ConfigItem(
		position = 7,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showEarth()
	{
		return false;
	}

	@ConfigItem(
		position = 8,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getEarthColor()
	{
		return new Color(62, 86, 64);
	}

	@ConfigItem(
		position = 9,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showEssence()
	{
		return false;
	}

	@ConfigItem(
		position = 10,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getEssenceColor()
	{
		return new Color(32, 89, 90);
	}

	@ConfigItem(
		position = 11,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showEclectic()
	{
		return false;
	}

	@ConfigItem(
		position = 12,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getEclecticColor()
	{
		return new Color(145, 155, 69);
	}

	@ConfigItem(
		position = 13,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showNature()
	{
		return false;
	}

	@ConfigItem(
		position = 14,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getNatureColor()
	{
		return new Color(92, 138, 95);
	}

	@ConfigItem(
		position = 15,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showMagpie()
	{
		return false;
	}

	@ConfigItem(
		position = 16,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getMagpieColor()
	{
		return new Color(142, 142, 19);
	}

	@ConfigItem(
		position = 17,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showNinja()
	{
		return false;
	}

	@ConfigItem(
		position = 18,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getNinjaColor()
	{
		return new Color(71, 70, 75);
	}

	@ConfigItem(
		position = 19,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showDragon()
	{
		return true;
	}

	@ConfigItem(
		position = 20,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getDragonColor()
	{
		return new Color(210, 85, 75);
	}

	@ConfigItem(
		position = 21,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showLucky()
	{
		return true;
	}

	@ConfigItem(
		position = 22,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getLuckyColor()
	{
		return new Color(102, 7, 101);
	}

	@ConfigItem(
		position = 23,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showSpawn()
	{
		return false;
	}

	@ConfigItem(
		position = 24,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default Color getSpawnColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		position = 25,
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home"
	)
	default boolean showName()
	{
		return false;
	}
}
