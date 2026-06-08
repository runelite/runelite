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
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ScriptID;
import net.runelite.api.SpritePixels;
import net.runelite.api.annotations.Component;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;

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

	@Inject
	private ClientThread clientThread;

	@Inject
	private ConfigManager configManager;

	private SpritePixels[] originalDotSprites;

	@Provides
	private MinimapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MinimapConfig.class);
	}

	@Override
	protected void startUp()
	{
		clientThread.invokeLater(() -> updateMinimapWidgetVisibility(config.hideMinimap()));
		storeOriginalDots();
		replaceMapDots();
		client.setMinimapZoom(config.zoom());
		Double zoomLevel = configManager.getConfiguration(MinimapConfig.GROUP, "zoomLevel", double.class);
		if (zoomLevel != null && zoomLevel > 0d)
		{
			client.setMinimapZoom(zoomLevel);
		}
	}

	@Override
	protected void shutDown()
	{
		clientThread.invokeLater(() -> updateMinimapWidgetVisibility(false));
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
			clientThread.invokeLater(() -> updateMinimapWidgetVisibility(config.hideMinimap()));
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

	@Schedule(period = 11, unit = ChronoUnit.SECONDS, asynchronous = true)
	public void saveZoom()
	{
		double zoom = client.getMinimapZoom();
		configManager.setConfiguration(MinimapConfig.GROUP, "zoomLevel", zoom);
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired)
	{
		if (scriptPostFired.getScriptId() == ScriptID.TOPLEVEL_REDRAW || scriptPostFired.getScriptId() == ScriptID.TOPLEVEL_RESIZE_CUSTOMISE)
		{
			updateMinimapWidgetVisibility(config.hideMinimap());
		}
	}

	private void updateMinimapWidgetVisibility(boolean hide)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		boolean vanillaHideMinimap = client.getVarbitValue(VarbitID.MINIMAP_TOGGLE) == 1;

		setHidden(InterfaceID.ToplevelOsrsStretch.MAP_MINIMAP, hide || vanillaHideMinimap);
		setHidden(InterfaceID.ToplevelOsrsStretch.ORBS, hide);

		setHidden(InterfaceID.ToplevelPreEoc.MAP_MINIMAP, hide || vanillaHideMinimap);
		setHidden(InterfaceID.ToplevelPreEoc.ORBS, hide);
	}

	private void setHidden(@Component int widget, boolean hide)
	{
		var w = client.getWidget(widget);

		if (w != null)
		{
			w.setHidden(hide);
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