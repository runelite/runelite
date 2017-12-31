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
import java.awt.Graphics2D;
import java.awt.Point;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;

class BoostsOverlay extends Overlay
{
	private static final Skill[] COMBAT = new Skill[]
	{
		Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE, Skill.RANGED, Skill.MAGIC
	};
	private static final Skill[] SKILLING = new Skill[]
	{
		Skill.MINING, Skill.AGILITY, Skill.SMITHING, Skill.HERBLORE, Skill.FISHING, Skill.THIEVING,
		Skill.COOKING, Skill.CRAFTING, Skill.FIREMAKING, Skill.FLETCHING, Skill.WOODCUTTING, Skill.RUNECRAFT,
		Skill.SLAYER, Skill.FARMING, Skill.CONSTRUCTION, Skill.HUNTER
	};

	private final Client client;
	private final BoostsConfig config;
	private PanelComponent panelComponent;

	@Inject
	BoostsOverlay(@Nullable Client client, BoostsConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.MED);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
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

		panelComponent = new PanelComponent();

		for (Skill skill : show)
		{
			int boosted = client.getBoostedSkillLevel(skill),
				base = client.getRealSkillLevel(skill);

			if (boosted == base)
			{
				continue;
			}


			String str;
			Color strColor = Color.WHITE;
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
					strColor = Color.GREEN.darker();
				}
				else
				{
					strColor = Color.RED.darker();
				}
			}

			panelComponent.getLines().add(new PanelComponent.Line(
				skill.getName(),
				Color.WHITE,
				str,
				strColor
			));
		}

		return panelComponent.render(graphics, parent);
	}

}
