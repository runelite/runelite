/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.playerinfo;

import java.awt.Color;
import java.awt.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.util.ColorUtil;

public class PlayerInfoCustomIndicator extends InfoBox
{
	@AllArgsConstructor
	@Getter
	enum IndicatorType
	{
		HEALTH("Current Hitpoints"),
		PRAYER("Current Prayer Points"),
		ENERGY("Current Run Energy"),
		SPECIAL("Current Special Attack"),
		WORLD("Current World");

		private final String description;
	}

	private final PlayerInfoConfig config;
	private final Client client;
	private final IndicatorType type;

	PlayerInfoCustomIndicator(Image image, PlayerInfoPlugin plugin, PlayerInfoConfig config, Client client, IndicatorType type)
	{
		super(image, plugin);
		this.config = config;
		this.client = client;
		this.type = type;

		setTooltip(type.getDescription());
	}

	@Override
	public String getText()
	{
		switch (type)
		{
			case HEALTH:
				return String.valueOf(client.getBoostedSkillLevel(Skill.HITPOINTS));
			case PRAYER:
				return String.valueOf(client.getBoostedSkillLevel(Skill.PRAYER));
			case ENERGY:
				return String.valueOf(client.getEnergy());
			case SPECIAL:
				return String.valueOf(client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) / 10);
			case WORLD:
				return String.valueOf(client.getWorld());
		}

		return null;
	}

	@Override
	public Color getTextColor()
	{
		float currLvl = 0;
		switch (type)
		{
			case HEALTH:
				currLvl = client.getBoostedSkillLevel(Skill.HITPOINTS) / (float) client.getRealSkillLevel(Skill.HITPOINTS);
				break;
			case PRAYER:
				currLvl = client.getBoostedSkillLevel(Skill.PRAYER) / (float) client.getRealSkillLevel(Skill.PRAYER);
				break;
			case ENERGY:
				currLvl = client.getEnergy() / 100.0F;
				break;
			case SPECIAL:
				currLvl = client.getVar(VarPlayer.SPECIAL_ATTACK_PERCENT) / 1000.0F;
				break;
			case WORLD:
				currLvl = 1000; // hacky
		}

		if (currLvl > 1.0)
		{
			return config.colorHigh();
		}
		else if (currLvl > 0.5)
		{
			return ColorUtil.colorLerp(config.colorMed(), config.colorHigh(), (currLvl * 2) - 1.0F);
		}
		else
		{
			return ColorUtil.colorLerp(config.colorLow(), config.colorMed(), (currLvl * 2));
		}
	}

	@Override
	public boolean render()
	{
		switch (type)
		{
			case HEALTH:
				return config.enableHealth();
			case PRAYER:
				return config.enablePrayer();
			case ENERGY:
				return config.enableEnergy();
			case SPECIAL:
				return config.enableSpec();
			case WORLD:
				return config.enableWorld();
		}

		return false;
	}
}
