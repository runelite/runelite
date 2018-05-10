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
import java.awt.Graphics2D;
import java.time.Instant;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

class BoostsOverlay extends Overlay
{
	@Getter
	private final BoostIndicator[] indicators = new BoostIndicator[Skill.values().length - 1];

	private final Client client;
	private final BoostsConfig config;
	private final InfoBoxManager infoBoxManager;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private BoostsPlugin plugin;

	@Inject
	private SkillIconManager iconManager;

	private boolean overlayActive;

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
	public Dimension render(Graphics2D graphics)
	{
		Instant lastChange = plugin.getLastChange();
		panelComponent.getChildren().clear();

		if (!config.displayIndicators()
			&& config.displayNextChange()
			&& lastChange != null
			&& overlayActive)
		{
			int nextChange = plugin.getChangeTime();
			if (nextChange > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Next change in")
					.right(String.valueOf(nextChange))
					.build());
			}
		}

		overlayActive = false;

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

			overlayActive = true;

			if (config.displayIndicators())
			{
				if (indicator == null)
				{
					indicator = new BoostIndicator(skill, iconManager.getSkillImage(skill), plugin, client, config);
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
				Color strColor = getTextColor(boost);
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

				panelComponent.getChildren().add(LineComponent.builder()
					.left(skill.getName())
					.right(str)
					.rightColor(strColor)
					.build());
			}
		}

		return panelComponent.render(graphics);
	}

	private Color getTextColor(int boost)
	{
		if (boost > 0)
		{
			return Color.GREEN;
		}

		return new Color(238, 51, 51);

	}
}
