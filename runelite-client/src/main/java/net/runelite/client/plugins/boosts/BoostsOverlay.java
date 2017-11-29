/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

import com.google.common.collect.ObjectArrays;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class BoostsOverlay extends Overlay
{
	private static final int WIDTH = 140;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);

	private static final Skill[] COMBAT = new Skill[]
	{
		Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE, Skill.RANGED, Skill.MAGIC
	};
	private static final Skill[] SKILLING = new Skill[]
	{
		Skill.COOKING, Skill.WOODCUTTING, Skill.FLETCHING, Skill.FISHING, Skill.FIREMAKING, Skill.CRAFTING,
		Skill.SMITHING, Skill.HERBLORE, Skill.AGILITY, Skill.THIEVING, Skill.SLAYER, Skill.FARMING, Skill.RUNECRAFT,
		Skill.HUNTER, Skill.CONSTRUCTION
	};

	private static final int TOP_BORDER = 2;
	private static final int BOTTOM_BORDER = 2;
	private static final int LEFT_BORDER = 2;
	private static final int RIGHT_BORDER = 2;

	private static final int SEPARATOR = 2;

	private final Client client;
	private final BoostsConfig config;

	@Inject
	BoostsOverlay(@Nullable Client client, BoostsConfig config)
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.MED);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.enabled())
		{
			return null;
		}

		Skill[] show;
		if (config.enableSkill())
		{
			show = ObjectArrays.concat(COMBAT, SKILLING, Skill.class);
		}
		else
		{
			show = COMBAT;
		}

		FontMetrics metrics = graphics.getFontMetrics();

		int height = TOP_BORDER;
		for (Skill skill : show)
		{
			int boosted = client.getBoostedSkillLevel(skill),
				base = client.getRealSkillLevel(skill);

			if (boosted == base)
			{
				continue;
			}

			height += metrics.getHeight() + SEPARATOR;
		}

		if (height == TOP_BORDER)
		{
			return null;
		}

		height += BOTTOM_BORDER;

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, height);

		int y = TOP_BORDER;
		for (Skill skill : show)
		{
			int boosted = client.getBoostedSkillLevel(skill),
				base = client.getRealSkillLevel(skill);

			if (boosted == base)
			{
				continue;
			}

			graphics.setColor(Color.white);
			graphics.drawString(skill.getName(), LEFT_BORDER, y + metrics.getHeight());

			String str;
			if (!config.useRelativeBoost())
			{
				str = boosted + "/" + base;
			}
			else
			{
				int boost = boosted - base;
				str = String.valueOf(boost);
				if (boost > 0)
				{
					str = "+"  + str;
					graphics.setColor(Color.GREEN.darker());
				}
				else
				{
					graphics.setColor(Color.RED.darker());
				}
			}
			graphics.drawString(str, WIDTH - RIGHT_BORDER - metrics.stringWidth(str), y + metrics.getHeight());
			y += metrics.getHeight() + SEPARATOR;
		}

		return new Dimension(WIDTH, height);
	}

}
