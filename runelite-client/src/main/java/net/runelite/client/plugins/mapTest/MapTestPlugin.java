/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.plugins.mapTest;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.WorldMapView;

@PluginDescriptor(
	name = "Map Test",
	developerPlugin = true
)
public class MapTestPlugin extends Plugin
{
	@Inject
	private MapViewOverlay overlay;

	@Inject
	private MapTestConfig config;

	@Inject
	@Getter
	private WorldMapView mapView;

	@Provides
	MapTestConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MapTestConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("devtoolsmap"))
		{
			return;
		}

		WorldPoint center = new WorldPoint(config.mapTestCoords().width, config.mapTestCoords().height, 0);
		mapView.setCenter(center);
		mapView.setZoom(config.mapTestZoom() / 100f);
		mapView.setGraphicsHeight(config.mapTestDisplay().height);
		mapView.setGraphicsWidth(config.mapTestDisplay().width);

		BufferedImage image = mapView.buildMapImage();
		overlay.setImage(image);
	}

	@Override
	protected void startUp()
	{
		WorldPoint center = new WorldPoint(config.mapTestCoords().width, config.mapTestCoords().height, 0);
		mapView.setCenter(center);
		mapView.setZoom(config.mapTestZoom() / 100f);
		mapView.setGraphicsHeight(config.mapTestDisplay().height);
		mapView.setGraphicsWidth(config.mapTestDisplay().width);

		BufferedImage image = mapView.buildMapImage();
		overlay.setImage(image);
	}

	@Override
	public MapViewOverlay getOverlay()
	{
		return overlay;
	}
}
