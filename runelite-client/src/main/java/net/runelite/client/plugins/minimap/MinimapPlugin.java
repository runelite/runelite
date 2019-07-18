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

import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Sprite;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Minimap",
	description = "Customize the color of minimap dots",
	tags = {"items", "npcs", "players"}
)
@Singleton
public class MinimapPlugin extends Plugin
{
	private static final int NUM_MAPDOTS = 6;

	@Inject
	private Client client;

	@Inject
	private MinimapConfig config;

	@Inject
	private EventBus eventBus;

	private Sprite[] originalDotSprites;

	private Color itemColor;
	private Color npcColor;
	private Color playerColor;
	private Color friendColor;
	private Color teamColor;
	private Color clanColor;
	private boolean hideMinimap;

	@Provides
	private MinimapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MinimapConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		updateMinimapWidgetVisibility(this.hideMinimap);
		storeOriginalDots();
		replaceMapDots();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		updateMinimapWidgetVisibility(false);
		restoreOriginalDots();
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(WidgetHiddenChanged.class, this, this::onWidgetHiddenChanged);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN && originalDotSprites == null)
		{
			storeOriginalDots();
			replaceMapDots();
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("minimap"))
		{
			return;
		}

		updateConfig();

		if (event.getKey().equals("hideMinimap"))
		{
			updateMinimapWidgetVisibility(this.hideMinimap);
			return;
		}

		replaceMapDots();
	}

	private void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		updateMinimapWidgetVisibility(this.hideMinimap);
	}

	private void updateMinimapWidgetVisibility(boolean enable)
	{
		final Widget resizableStonesWidget = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_STONES_WIDGET);

		if (resizableStonesWidget != null)
		{
			resizableStonesWidget.setHidden(enable);
		}

		final Widget resizableNormalWidget = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_WIDGET);

		if (resizableNormalWidget != null && !resizableNormalWidget.isSelfHidden())
		{
			for (Widget widget : resizableNormalWidget.getStaticChildren())
			{
				if (widget.getId() != WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_LOGOUT_BUTTON.getId() &&
					widget.getId() != WidgetInfo.RESIZABLE_MINIMAP_LOGOUT_BUTTON.getId())
				{
					widget.setHidden(enable);
				}
			}
		}
	}

	private void replaceMapDots()
	{
		Sprite[] mapDots = client.getMapDots();

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

	private Color[] getColors()
	{
		Color[] colors = new Color[NUM_MAPDOTS];
		colors[0] = this.itemColor;
		colors[1] = this.npcColor;
		colors[2] = this.playerColor;
		colors[3] = this.friendColor;
		colors[4] = this.teamColor;
		colors[5] = this.clanColor;

		return colors;
	}

	private void storeOriginalDots()
	{
		Sprite[] originalDots = client.getMapDots();

		if (originalDots == null)
		{
			return;
		}

		originalDotSprites = Arrays.copyOf(originalDots, originalDots.length);
	}

	private void restoreOriginalDots()
	{
		Sprite[] mapDots = client.getMapDots();

		if (originalDotSprites == null || mapDots == null)
		{
			return;
		}

		System.arraycopy(originalDotSprites, 0, mapDots, 0, mapDots.length);
	}

	private void updateConfig()
	{
		this.itemColor = config.itemColor();
		this.npcColor = config.npcColor();
		this.playerColor = config.playerColor();
		this.friendColor = config.friendColor();
		this.teamColor = config.teamColor();
		this.clanColor = config.clanColor();
		this.hideMinimap = config.hideMinimap();
	}
}