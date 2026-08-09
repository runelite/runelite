/*
 * Copyright (c) 2019, gregg1494 <https://github.com/gregg1494>
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.worldhopper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.fps.FpsConfig;
import net.runelite.client.plugins.fps.FpsPlugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class WorldHopperPingOverlay extends Overlay
{
	private static final int Y_OFFSET = 1;
	private static final int X_OFFSET = 1;

	private final Client client;
	private final WorldHopperPlugin worldHopperPlugin;
	private final WorldHopperConfig worldHopperConfig;
	private final ConfigManager configManager;
	private final PluginManager pluginManager;

	@Inject
	private WorldHopperPingOverlay(
		Client client,
		WorldHopperPlugin worldHopperPlugin,
		WorldHopperConfig worldHopperConfig,
		ConfigManager configManager,
		PluginManager pluginManager)
	{
		this.client = client;
		this.worldHopperPlugin = worldHopperPlugin;
		this.worldHopperConfig = worldHopperConfig;
		this.configManager = configManager;
		this.pluginManager = pluginManager;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(PRIORITY_HIGH);
		setPosition(OverlayPosition.DYNAMIC);
		setPreferPanelContentScale(true);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!worldHopperConfig.displayPing())
		{
			return null;
		}

		int xOffset = X_OFFSET;

		// Adjust offset for logout button
		Widget logoutButton = client.getWidget(InterfaceID.ToplevelPreEoc.ICON10);
		if (logoutButton != null && !logoutButton.isHidden())
		{
			xOffset += logoutButton.getWidth();
		}

		final FontMetrics fm = graphics.getFontMetrics();
		final int textHeight = fm.getAscent() - fm.getDescent();
		// Content-space width so panel scale (size/aspect) keeps this flush-right.
		final int width = OverlayUtil.getContentSpaceWidth(graphics, (int) client.getRealDimensions().getWidth());
		// Stack under FPS when that indicator is visible; otherwise occupy the top row.
		final int y = isFpsIndicatorShown()
			? Y_OFFSET + fm.getHeight() + textHeight
			: textHeight + Y_OFFSET;

		final int ping = worldHopperPlugin.getCurrentPing();
		if (ping >= 0)
		{
			String text = ping + " ms";
			int textWidth = fm.stringWidth(text);
			Point point = new Point(width - textWidth - xOffset, y);
			OverlayUtil.renderTextLocation(graphics, point, text, Color.YELLOW);
			xOffset += textWidth + fm.stringWidth(" ");
		}

		int percRetransmit = worldHopperPlugin.retransmitCalculator.getRetransmitPercent();
		if (percRetransmit > 0)
		{
			String text = percRetransmit + "% loss";
			Point point = new Point(width - fm.stringWidth(text) - xOffset, y);
			OverlayUtil.renderTextLocation(graphics, point, text, Color.RED);
		}

		return null;
	}

	private boolean isFpsIndicatorShown()
	{
		if (!configManager.getConfig(FpsConfig.class).drawFps())
		{
			return false;
		}
		for (Plugin plugin : pluginManager.getPlugins())
		{
			if (plugin instanceof FpsPlugin)
			{
				return pluginManager.isPluginEnabled(plugin);
			}
		}
		return false;
	}
}
