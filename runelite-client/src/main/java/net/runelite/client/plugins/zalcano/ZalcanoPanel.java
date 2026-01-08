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
import javax.inject.Inject;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

class ZalcanoPanel extends OverlayPanel
{
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

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Health damage:")
			.leftColor(colorFromCount(plugin.getHealthDamage()))
			.right(Integer.toString(plugin.getHealthDamage()))
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Shield damage:")
			.leftColor(colorFromCount(plugin.getShieldDamage()))
			.right(Integer.toString(plugin.getShieldDamage()))
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
