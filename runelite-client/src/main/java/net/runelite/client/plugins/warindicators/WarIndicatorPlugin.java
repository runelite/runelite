/*
 * Copyright (c) 2018, Andrew EP | ElPinche256 <https://github.com/ElPinche256>
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
package net.runelite.client.plugins.warindicators;

import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.FOLLOW;
import static net.runelite.api.MenuAction.ITEM_USE_ON_PLAYER;
import static net.runelite.api.MenuAction.PLAYER_EIGTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIFTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIRST_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FOURTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SECOND_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SEVENTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SIXTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_THIRD_OPTION;
import static net.runelite.api.MenuAction.SPELL_CAST_ON_PLAYER;
import static net.runelite.api.MenuAction.TRADE;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "War calling indicators",
	description = "War War War.",
	tags = {"skill", "total", "max", "PVP"},
	type = PluginType.PVP,
	enabledByDefault = false
)
@Singleton
public class WarIndicatorPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WarIndicatorConfig config;

	@Inject
	private WarIndicatorOverlay warIndicatorOverlay;

	@Inject
	private WarIndicatorMiniMapOverlay warIndicatorMiniMapOverlay;

	@Inject
	private Client client;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean highLightCallers;
	@Getter(AccessLevel.PACKAGE)
	private Color getCallerColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean callerMinimap;
	@Getter(AccessLevel.PACKAGE)
	private boolean callerTile;
	@Getter(AccessLevel.PACKAGE)
	private String getActiveCallers;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightSnipes;
	@Getter(AccessLevel.PACKAGE)
	private Color getSnipeColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean snipeMinimap;
	@Getter(AccessLevel.PACKAGE)
	private boolean snipeTile;
	@Getter(AccessLevel.PACKAGE)
	private String getTargetedSnipes;

	@Provides
	WarIndicatorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WarIndicatorConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(warIndicatorOverlay);
		overlayManager.add(warIndicatorMiniMapOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
		overlayManager.remove(warIndicatorOverlay);
		overlayManager.remove(warIndicatorMiniMapOverlay);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
	}

	private void onMenuEntryAdded(MenuEntryAdded onMenuEntryAdded)
	{
		int type = onMenuEntryAdded.getType();

		if (type >= 2000)
		{
			type -= 2000;
		}

		int identifier = onMenuEntryAdded.getIdentifier();
		if (type == FOLLOW.getId() || type == TRADE.getId()
			|| type == SPELL_CAST_ON_PLAYER.getId()
			|| type == ITEM_USE_ON_PLAYER.getId()
			|| type == PLAYER_FIRST_OPTION.getId()
			|| type == PLAYER_SECOND_OPTION.getId()
			|| type == PLAYER_THIRD_OPTION.getId()
			|| type == PLAYER_FOURTH_OPTION.getId()
			|| type == PLAYER_FIFTH_OPTION.getId()
			|| type == PLAYER_SIXTH_OPTION.getId()
			|| type == PLAYER_SEVENTH_OPTION.getId()
			|| type == PLAYER_EIGTH_OPTION.getId())
		{
			Player[] players = client.getCachedPlayers();
			Player player = null;
			String player2 = null;

			String[] callers = this.getActiveCallers.split(", ");
			String[] targets = this.getTargetedSnipes.split(", ");

			if (identifier >= 0 && identifier < players.length)
			{
				player = players[identifier];
				player2 = players[identifier].getName();
			}

			if (player == null)
			{
				return;
			}

			Color color = null;

			if (this.highLightCallers && ArrayUtils.contains(callers, player2))
			{
				color = this.getCallerColor;
			}

			if (this.highlightSnipes && ArrayUtils.contains(targets, player2))
			{
				color = this.getSnipeColor;
			}

			if (color != null)
			{
				MenuEntry[] menuEntries = client.getMenuEntries();
				MenuEntry lastEntry = menuEntries[menuEntries.length - 1];
				String target = lastEntry.getTarget();

				int idx = target.indexOf('>');
				if (idx != -1)
				{
					target = target.substring(idx + 1);
				}

				lastEntry.setTarget("<col=" + Integer.toHexString(color.getRGB() & 0xFFFFFF) + ">" + target);
				client.setMenuEntries(menuEntries);
			}

		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("warIndicators"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.highLightCallers = config.highLightCallers();
		this.getCallerColor = config.getCallerColor();
		this.callerMinimap = config.callerMinimap();
		this.callerTile = config.callerTile();
		this.getActiveCallers = config.getActiveCallers();
		this.highlightSnipes = config.highlightSnipes();
		this.getSnipeColor = config.getSnipeColor();
		this.snipeMinimap = config.snipeMinimap();
		this.snipeTile = config.snipeTile();
		this.getTargetedSnipes = config.getTargetedSnipes();
	}
}
