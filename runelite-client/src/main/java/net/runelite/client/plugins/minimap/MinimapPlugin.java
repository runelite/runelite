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
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.SpritePixels;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Minimap",
	description = "Customize the color of minimap dots, hide the minimap, and zoom",
	tags = {"items", "npcs", "players", "zoom"}
)
public class MinimapPlugin extends Plugin
{
	private static final int DOT_ITEM = 0;
	private static final int DOT_NPC = 1;
	private static final int DOT_PLAYER = 2;
	private static final int DOT_FRIEND = 3;
	private static final int DOT_TEAM = 4;
	private static final int DOT_FRIENDSCHAT = 5;
	private static final int DOT_CLAN = 6;

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
	protected void startUp()
	{
		updateMinimapWidgetVisibility(config.hideMinimap());
		storeOriginalDots();
		replaceMapDots();
		client.setMinimapZoom(config.zoom());
	}

	@Override
	protected void shutDown()
	{
		updateMinimapWidgetVisibility(false);
		restoreOriginalDots();
		client.setMinimapZoom(false);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		var state = event.getGameState();
		if (state == GameState.STARTING)
		{
			originalDotSprites = null;
		}
		else if (state == GameState.LOGIN_SCREEN && originalDotSprites == null)
		{
			storeOriginalDots();
			replaceMapDots();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(MinimapConfig.GROUP))
		{
			return;
		}

		if (event.getKey().equals("hideMinimap"))
		{
			updateMinimapWidgetVisibility(config.hideMinimap());
			return;
		}
		else if (event.getKey().equals("zoom"))
		{
			client.setMinimapZoom(config.zoom());
			return;
		}

		restoreOriginalDots();
		replaceMapDots();
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.TOPLEVEL_REDRAW)
		{
			updateMinimapWidgetVisibility(config.hideMinimap());
		}
	}

	private void updateMinimapWidgetVisibility(boolean enable)
	{
		final Widget resizableStonesWidget = client.getWidget(ComponentID.RESIZABLE_VIEWPORT_MINIMAP);

		if (resizableStonesWidget != null)
		{
			resizableStonesWidget.setHidden(enable);
		}

		final Widget resizableNormalWidget = client.getWidget(ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_MINIMAP);

		if (resizableNormalWidget != null && !resizableNormalWidget.isSelfHidden())
		{
			for (Widget widget : resizableNormalWidget.getStaticChildren())
			{
				if (widget.getId() != ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_LOGOUT_BUTTON_OVERLAY &&
					widget.getId() != ComponentID.RESIZABLE_VIEWPORT_BOTTOM_LINE_MINIMAP_LOGOUT_BUTTON)
				{
					widget.setHidden(enable);
				}
			}
		}
	}

	private void replaceMapDots()
	{
		SpritePixels[] mapDots = client.getMapDots();

		if (mapDots == null)
		{
			return;
		}

		applyDot(mapDots, DOT_ITEM, config.itemColor());
		applyDot(mapDots, DOT_NPC, config.npcColor());
		applyDot(mapDots, DOT_PLAYER, config.playerColor());
		applyDot(mapDots, DOT_FRIEND, config.friendColor());
		applyDot(mapDots, DOT_TEAM, config.teamColor());
		applyDot(mapDots, DOT_FRIENDSCHAT, config.friendsChatColor());
		applyDot(mapDots, DOT_CLAN, config.clanChatColor());
	}

	private void applyDot(SpritePixels[] mapDots, int id, Color color)
	{
		if (id < mapDots.length && color != null)
		{
			mapDots[id] = MinimapDot.create(client, color);
		}
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
}