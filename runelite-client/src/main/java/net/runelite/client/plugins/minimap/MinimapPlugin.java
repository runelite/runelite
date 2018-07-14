/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.plugins.minimap;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Minimap",
	description = "Customize the color of minimap dots",
	tags = {"items", "npcs", "players"}
)
public class MinimapPlugin extends Plugin
{
	private static final int NUM_MAPDOTS = 6;

	@Inject
	private Client client;

	@Inject
	private MinimapConfig config;

	private SpritePixels[] originalDotSprites;

	@Provides
	private MinimapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MinimapConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		Widget minimapWidget = client.getWidget(WidgetInfo.MINIMAP_WIDGET);

		if (minimapWidget != null)
		{
			minimapWidget.setHidden(config.hideMinimap());
		}

		storeOriginalDots();
		replaceMapDots();
	}

	@Override
	protected void shutDown() throws Exception
	{
		Widget minimapWidget = client.getWidget(WidgetInfo.MINIMAP_WIDGET);

		if (minimapWidget != null)
		{
			minimapWidget.setHidden(false);
		}

		restoreOriginalDots();
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN && originalDotSprites == null)
		{
			storeOriginalDots();
			replaceMapDots();
		}
	}

	private Color[] getColors()
	{
		Color[] colors = new Color[NUM_MAPDOTS];
		colors[0] = config.itemColor();
		colors[1] = config.npcColor();
		colors[2] = config.playerColor();
		colors[3] = config.friendColor();
		colors[4] = config.teamColor();
		colors[5] = config.clanColor();
		return colors;
	}

	private void storeOriginalDots()
	{
		SpritePixels[] originalDots = client.getMapDots();

		if (originalDots == null)
		{
			return;
		}

		originalDotSprites = Arrays.copyOf(originalDots, originalDots.length);
	}

	private void restoreOriginalDots()
	{
		SpritePixels[] mapDots = client.getMapDots();

		if (originalDotSprites == null || mapDots == null)
		{
			return;
		}

		System.arraycopy(originalDotSprites, 0, mapDots, 0, mapDots.length);
	}

	@Subscribe
	public void configChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("minimap"))
		{
			return;
		}

		if (event.getKey().equals("hideMinimap"))
		{
			Widget minimapWidget = client.getWidget(WidgetInfo.MINIMAP_WIDGET);

			if (minimapWidget != null)
			{
				minimapWidget.setHidden(config.hideMinimap());
			}
			return;
		}

		replaceMapDots();
	}

	@Subscribe
	public void onWidgetHiddenChange(WidgetHiddenChanged event)
	{
		Widget minimapWidget = client.getWidget(WidgetInfo.MINIMAP_WIDGET);

		if (event.getWidget() == minimapWidget)
		{
			minimapWidget.setHidden(config.hideMinimap());
		}
	}

	private void replaceMapDots()
	{
		SpritePixels[] mapDots = client.getMapDots();

		if (mapDots == null)
		{
			return;
		}

		Color[] minimapDotColors = getColors();
		for (int i = 0; i < mapDots.length && i < minimapDotColors.length; ++i)
		{
			mapDots[i] = MinimapDot.create(this.client, minimapDotColors[i]);
		}
	}

}
