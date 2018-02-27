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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@Slf4j
class BoostsOverlay extends Overlay
{
	@Getter
	private final BoostIndicator[] indicators = new BoostIndicator[Skill.values().length - 1];

	private static final int SMALL_WIDTH = 120;
	private static final int NORMAL_WIDTH = 140;

	private final Client client;
	private final BoostsConfig config;
	private final InfoBoxManager infoBoxManager;

	private Instant startTime;
	private Skill sampleSkill;
	private int lastSampleSkillLevel = 0;
	private int activeBoostCount = 0;

	@Inject
	private BoostsPlugin plugin;

	@Inject
	private SkillIconManager iconManager;

	public enum FontType
	{
		NORMAL,
		SMALL
	}

	@Inject
	BoostsOverlay(Client client, BoostsConfig config, InfoBoxManager infoBoxManager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.MED);
		this.client = client;
		this.config = config;
		this.infoBoxManager = infoBoxManager;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		final PanelComponent panelComponent = new PanelComponent();
		final Font font = config.type() == FontType.SMALL ? FontManager.getRunescapeSmallFont() : FontManager.getRunescapeFont();
		panelComponent.setFont(font);
		int width = config.type() == FontType.SMALL ? SMALL_WIDTH : NORMAL_WIDTH;
		width = config.useRelativeBoost() ? width - 20 : width;
		panelComponent.setWidth(width);

		if (sampleSkill != null)
		{
			if (Arrays.stream(plugin.getShownSkills()).anyMatch((skill -> client.getBoostedSkillLevel(skill) != client.getRealSkillLevel(skill) && skill == sampleSkill)))
			{
				int boosted = client.getBoostedSkillLevel(sampleSkill);
				int base = client.getRealSkillLevel(sampleSkill);
				if (((boosted > base) && (boosted == lastSampleSkillLevel - 1)) || ((boosted < base) && (boosted == lastSampleSkillLevel + 1)))
				{
					startTime = Instant.now();
				}
				lastSampleSkillLevel = boosted;
			}
			else
			{
				sampleSkill = null;
			}
		}
		if (startTime != null && activeBoostCount > 0)
		{
			int nextChange = 60 - (int)Duration.between(startTime, Instant.now()).getSeconds();
			nextChange = nextChange <= 0 ? 0 : nextChange;
			panelComponent.getLines().add(new PanelComponent.Line(
				"Next change in",
				Color.white,
				String.valueOf(nextChange),
				Color.white
			));
		}
		activeBoostCount = 0;
		for (Skill skill : plugin.getShownSkills())
		{
			int boosted = client.getBoostedSkillLevel(skill),
				base = client.getRealSkillLevel(skill);

			BoostIndicator indicator = indicators[skill.ordinal()];

			if (boosted == base)
			{
				if (indicator != null && infoBoxManager.getInfoBoxes().contains(indicator))
				{
					infoBoxManager.removeInfoBox(indicator);
				}

				continue;
			}

			if (sampleSkill == null)
			{
				sampleSkill = skill;
				lastSampleSkillLevel = boosted;
				startTime = Instant.now();
			}

			if (config.displayIndicators())
			{
				if (indicator == null)
				{
					indicator = new BoostIndicator(skill, iconManager.getSkillImage(skill), client, config, this);
					indicators[skill.ordinal()] = indicator;
				}

				if (!infoBoxManager.getInfoBoxes().contains(indicator))
				{
					infoBoxManager.addInfoBox(indicator);
				}
			}
			else
			{
				if (indicator != null && infoBoxManager.getInfoBoxes().contains(indicator))
				{
					infoBoxManager.removeInfoBox(indicator);
				}

				String str;
				int boost = boosted - base;
				Color strColor = getTextColor(base, boosted);
				if (!config.useRelativeBoost())
				{
					str = "<col=" + Integer.toHexString(strColor.getRGB() & 0xFFFFFF) + ">" + boosted + "<col=ffffff>/" + base;
				}
				else
				{
					str = String.valueOf(boost);
					if (boost > 0)
					{
						str = "+" + str;
					}
				}

				panelComponent.getLines().add(new PanelComponent.Line(
					skill.getName(),
					Color.WHITE,
					str,
					strColor
				));
			}
			activeBoostCount++;
		}

		return config.displayIndicators() ? null : panelComponent.render(graphics, parent);
	}

	public Color getTextColor(int base, int boosted)
	{
		if (base > 0)
		{
			float boostPercentage = (boosted - base) / (5 + .15f * base) * 100;
			if (boosted > base)
			{
				if (boostPercentage > config.medBoostPercentage())
				{
					return config.highBoost();
				}
				else if (boostPercentage > config.lowBoostPercentage())
				{
					return config.medBoost();
				}
				else
				{
					return config.lowBoost();
				}
			}
		}

		return new Color(255, 0, 0);
	}
}
