/*
 * Copyright (c) 2018, terminatusx <jbfleischman@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.wintertodt;

import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.StackFormatter;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.client.plugins.wintertodt.WintertodtPlugin.WINTERTODT_KINDLING_MULTIPLIER;
import static net.runelite.client.plugins.wintertodt.WintertodtPlugin.WINTERTODT_ROOTS_MULTIPLIER;

class WintertodtOverlay extends Overlay
{
	@Inject
	private Client client;

	private final WintertodtPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private WintertodtOverlay(WintertodtPlugin plugin)
	{
		this.plugin = plugin;
		setPosition(OverlayPosition.BOTTOM_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInWintertodt())
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.setPreferredSize(new Dimension(180, 0));

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Points in inventory")
			.color(Color.WHITE)
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Status:")
			.leftColor(Color.WHITE)
			.right(plugin.getCurrentActivity().getActionString())
			.rightColor(plugin.getCurrentActivity() == WintertodtActivity.IDLE ? Color.RED : Color.GREEN)
			.build());

		int firemakingLvl = client.getRealSkillLevel(Skill.FIREMAKING);

		int rootsScore = plugin.getNumRoots() * WINTERTODT_ROOTS_MULTIPLIER;
		int rootsXp = plugin.getNumRoots() * Math.round(2 + (3 * firemakingLvl));
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Roots:")
			.leftColor(Color.WHITE)
			.right(rootsScore + " pts (" + rootsXp + " xp)")
			.rightColor(plugin.getNumRoots() > 0 ? Color.GREEN : Color.RED)
			.build());

		int kindlingScore = plugin.getNumKindling() * WINTERTODT_KINDLING_MULTIPLIER;
		long kindlingXp = plugin.getNumKindling() * Math.round(3.8 * firemakingLvl);
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Kindling:")
			.leftColor(Color.WHITE)
			.right(kindlingScore + " pts (" + kindlingXp + " xp)")
			.rightColor(plugin.getNumKindling() > 0 ? Color.GREEN : Color.RED)
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Total:")
			.leftColor(Color.WHITE)
			.right((rootsScore + kindlingScore) + " pts (" + (rootsXp + kindlingXp) + " xp)")
			.rightColor((rootsScore + kindlingScore > 0) ? Color.GREEN : Color.RED)
			.build());

		return panelComponent.render(graphics);
	}
}