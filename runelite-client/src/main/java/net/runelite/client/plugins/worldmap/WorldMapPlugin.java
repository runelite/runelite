/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.plugins.worldmap;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

@PluginDescriptor(
	name = "World Map"
)
public class WorldMapPlugin extends Plugin
{
	static final BufferedImage BLANK_ICON;
	static final BufferedImage FAIRY_TRAVEL_ICON;

	static final String CONFIG_KEY = "worldmap";
	static final String CONFIG_KEY_FAIRY_RING_TOOLTIPS = "fairyRingTooltips";
	static final String CONFIG_KEY_FAIRY_RING_ICON = "fairyRingIcon";

	static
	{
		//A size of 17 gives us a buffer when triggering tooltips
		final int iconBufferSize = 17;

		BLANK_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);

		try
		{
			synchronized (ImageIO.class)
			{
				FAIRY_TRAVEL_ICON = new BufferedImage(iconBufferSize, iconBufferSize, BufferedImage.TYPE_INT_ARGB);
				final BufferedImage icon = ImageIO.read(WorldMapPlugin.class.getResourceAsStream("fairy_ring_travel.png"));
				FAIRY_TRAVEL_ICON.getGraphics().drawImage(icon, 1, 1, null);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Inject
	private WorldMapConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Provides
	WorldMapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldMapConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_KEY))
		{
			switch (event.getKey())
			{
				case CONFIG_KEY_FAIRY_RING_TOOLTIPS:
					if (config.fairyRingTooltips())
					{
						Arrays.stream(FairyRingLocation.values())
							.map(FairyRingLocation::getFairyRingPoint)
							.forEach(worldMapPointManager::add);
					}
					else
					{
						worldMapPointManager.removeIf(FairyRingPoint.class::isInstance);
					}
					break;
				case CONFIG_KEY_FAIRY_RING_ICON:
					FairyRingLocation.setIcon(config.fairyRingIcon() ? FAIRY_TRAVEL_ICON : BLANK_ICON);
					break;
			}
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		FairyRingLocation.setIcon(config.fairyRingIcon() ? FAIRY_TRAVEL_ICON : BLANK_ICON);

		if (config.fairyRingTooltips())
		{
			Arrays.stream(FairyRingLocation.values())
				.map(FairyRingLocation::getFairyRingPoint)
				.forEach(worldMapPointManager::add);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		worldMapPointManager.removeIf(FairyRingPoint.class::isInstance);
	}
}
