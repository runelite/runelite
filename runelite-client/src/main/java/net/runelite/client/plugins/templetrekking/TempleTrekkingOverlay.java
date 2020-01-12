/*
 * Copyright (c) 2018, Frosty Fridge <https://github.com/frostyfridge>
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
package net.runelite.client.plugins.templetrekking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class TempleTrekkingOverlay extends Overlay
{
	private final TempleTrekkingConfig config;
	private final TempleTrekkingPlugin plugin;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private TempleTrekkingOverlay(TempleTrekkingConfig config, TempleTrekkingPlugin plugin)
	{
		super(plugin);
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.pointTrackerActive() && plugin.isInTrek())
		{
			int points = plugin.getRewardPoints();
			double percentage = plugin.getRewardPercentage() * 100;
			panelComponent.getChildren().clear();
			Color rightColor = percentage < 25 ? Color.RED : percentage >= 25 && percentage < 50 ? Color.YELLOW :
				percentage >= 50 && percentage < 75 ? Color.BLUE : Color.GREEN;
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Trek Points: ")
				.right(Integer.toString(points))
				.rightColor(rightColor)
				.build());
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Reward %: ")
				.right(String.format("%.2f", percentage) + "%")
				.rightColor(rightColor)
				.build());
			return panelComponent.render(graphics);
		}
		return null;
	}
}
