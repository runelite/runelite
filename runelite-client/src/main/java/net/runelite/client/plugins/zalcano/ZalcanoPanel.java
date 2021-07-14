/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.zalcano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TitleComponent;

class ZalcanoPanel extends OverlayPanel
{
	private static final DecimalFormat PERCENTAGE_FORMAT = new DecimalFormat(" (##0.0%)");
	private final ZalcanoPlugin plugin;

	@Inject
	public ZalcanoPanel(ZalcanoPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		if (!plugin.isInCavern())
		{
			return null;
		}

		double healthRatio = 0;
		double shieldRatio = 0;
		if (plugin.getTotalHealthDamage() > 0)
		{
			healthRatio = plugin.getHealthDamage() / (double)(plugin.getTotalHealthDamage());
		}
		if (plugin.getTotalShieldDamage() > 0)
		{
			shieldRatio = plugin.getShieldDamage() / (double)(plugin.getTotalShieldDamage());
		}

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Health damage:")
			.color(colorFromCount(plugin.getHealthDamage()))
			.build());

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(plugin.getHealthDamage() + "/" + plugin.getTotalHealthDamage() + PERCENTAGE_FORMAT.format(healthRatio))
			.build());

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Shield damage:")
			.color(colorFromCount(plugin.getShieldDamage()))
			.build());

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(plugin.getShieldDamage() + "/" + plugin.getTotalShieldDamage() + PERCENTAGE_FORMAT.format(shieldRatio))
			.build());
		return super.render(g);
	}

	private static Color colorFromCount(int damage)
	{
		if (damage >= 50)
		{
			// Eligible for uniques/pet
			return Color.GREEN;
		}
		if (damage >= 30)
		{
			// Eligible for drops
			return Color.YELLOW;
		}
		return Color.RED;
	}
}
