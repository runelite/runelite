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
package net.runelite.client.ui.overlay;

import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.client.config.RuneliteConfig;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxOverlay;
import net.runelite.client.ui.overlay.tooltips.TooltipRenderer;

@Singleton
public class OverlayRenderer
{
	private final Client client;
	private final TooltipRenderer tooltipRenderer;
	private final InfoBoxOverlay infoBoxOverlay;

	@Inject
	PluginManager pluginManager;

	@Inject
	public OverlayRenderer(@Nullable Client client, InfoBoxManager infoboxManager, RuneliteConfig config)
	{
		this.client = client;
		tooltipRenderer = new TooltipRenderer(client, config);
		infoBoxOverlay = new InfoBoxOverlay(client, tooltipRenderer, infoboxManager);
	}

	public void render(BufferedImage clientBuffer)
	{
		TopDownRendererLeft tdl = new TopDownRendererLeft();
		TopDownRendererRight tdr = new TopDownRendererRight(client);
		DynamicRenderer dr = new DynamicRenderer();
		for (Plugin plugin : pluginManager.getPlugins())
		{
			for (Overlay overlay : plugin.getOverlays())
			{
				switch (overlay.getPosition())
				{
					case TOP_RIGHT:
						tdr.add(overlay);
						break;
					case TOP_LEFT:
						tdl.add(overlay);
						break;
					case DYNAMIC:
						dr.add(overlay);
						break;
				}
			}
		}

		tdl.add(infoBoxOverlay);

		tdl.render(clientBuffer);
		tdr.render(clientBuffer);
		dr.render(clientBuffer);

		// tooltips are always rendered on top of other overlays
		tooltipRenderer.render(clientBuffer);
	}

	public TooltipRenderer getTooltipRenderer()
	{
		return tooltipRenderer;
	}
}
