/*
 * Copyright (c) 2018 Kamiel
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
package net.runelite.client.plugins.boosts;

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.ui.overlay.infobox.InfoBoxPriority;

public class BoostIndicator extends InfoBox
{
	private final BoostsPlugin plugin;
	private final BoostsConfig config;
	private final Client client;

	@Getter
	private final Skill skill;

	BoostIndicator(Skill skill, BufferedImage image, BoostsPlugin plugin, Client client, BoostsConfig config)
	{
		super(image, plugin);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
		this.skill = skill;
		setTooltip(skill.getName() + " boost");
		setPriority(InfoBoxPriority.HIGH);
	}

	@Override
	public String getText()
	{
		if (!config.useRelativeBoost())
		{
			return String.valueOf(client.getBoostedSkillLevel(skill));
		}

		int boost = client.getBoostedSkillLevel(skill) - client.getRealSkillLevel(skill);
		String text = String.valueOf(boost);
		if (boost > 0)
		{
			text = "+" + text;
		}

		return text;
	}

	@Override
	public Color getTextColor()
	{
		int boosted = client.getBoostedSkillLevel(skill),
			base = client.getRealSkillLevel(skill);

		if (boosted < base)
		{
			return new Color(238, 51, 51);
		}

		return boosted - base <= config.boostThreshold() ? Color.YELLOW : Color.GREEN;
	}

	@Override
	public boolean render()
	{
		if (config.displayIndicators() && plugin.canShowBoosts() && plugin.getShownSkills().contains(getSkill()))
		{
			return client.getBoostedSkillLevel(skill) != client.getRealSkillLevel(skill);
		}

		return false;
	}
}
