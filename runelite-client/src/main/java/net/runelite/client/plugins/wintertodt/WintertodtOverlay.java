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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class WintertodtOverlay extends Overlay
{
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
		panelComponent.setPreferredSize(new Dimension(150, 0));

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(plugin.getCurrentActivity().getActionString())
			.color(plugin.getCurrentActivity() == WintertodtActivity.IDLE ? Color.RED : Color.GREEN)
			.build());

		String inventoryString = plugin.getNumLogs() > 0 ? plugin.getInventoryScore() + " (" + plugin.getTotalPotentialinventoryScore() + ") pts" : plugin.getInventoryScore() + " pts";
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Inventory:")
			.leftColor(Color.WHITE)
			.right(inventoryString)
			.rightColor(plugin.getInventoryScore() > 0 ? Color.GREEN : Color.RED)
			.build());

		String kindlingString = plugin.getNumLogs() > 0 ? plugin.getNumKindling() + " (" + (plugin.getNumLogs() + plugin.getNumKindling()) + ")" : Integer.toString(plugin.getNumKindling());
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Kindling:")
			.leftColor(Color.WHITE)
			.right(kindlingString)
			.rightColor(plugin.getNumKindling() + plugin.getNumLogs() > 0 ? Color.GREEN : Color.RED)
			.build());

		return panelComponent.render(graphics);
	}
}