/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 *
 * Modified by farhan1666
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
package net.runelite.client.plugins.dropparty;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.util.Text;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@PluginDescriptor(
	name = "Drop Party",
	description = "Marks where a user ran, for drop partys",
	tags = {"Drop", "Party", "marker", "player"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
@Slf4j
public class DropPartyPlugin extends Plugin
{
	@Inject
	private DropPartyConfig config;
	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> playerPath = new ArrayList<>();
	@Getter(AccessLevel.PACKAGE)
	private String playerName = "";
	@Getter(AccessLevel.PACKAGE)
	private int showAmmount = 0;
	@Getter(AccessLevel.PACKAGE)
	private int MAXPATHSIZE = 100;
	private Player runningPlayer;
	@Getter(AccessLevel.PACKAGE)
	private Color overlayColor;

	@Inject
	private Notifier notifier;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private DropPartyOverlay coreOverlay;
	@Inject
	private EventBus eventbus;
	@Inject
	private Client client;
	@Getter(AccessLevel.PACKAGE)
	private int fontStyle;
	@Getter(AccessLevel.PACKAGE)
	private int textSize;

	@Provides
	DropPartyConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DropPartyConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();
		overlayManager.add(coreOverlay);
		reset();
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(coreOverlay);
		reset();
		eventbus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventbus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventbus.subscribe(GameTick.class, this, this::onGameTick);
	}


	private void onGameTick(GameTick event)
	{
		shuffleList();
		if (playerName.equalsIgnoreCase(""))
		{
			return;
		}

		runningPlayer = null;

		for (Player player : client.getPlayers())
		{
			if (player.getName() == null)
			{
				continue;
			}
			if (Text.standardize(player.getName()).equalsIgnoreCase(playerName))
			{
				runningPlayer = player;
				break;
			}

		}

		if (runningPlayer == null)
		{
			cordsError();
			return;
		}
		addCords();
	}

	private void cordsError()
	{
		playerPath.add(null);

	}

	private void shuffleList()
	{
		if (playerPath.size() > MAXPATHSIZE - 1)
		{
			playerPath.remove(0);
		}
	}

	private void addCords()
	{
		while (true)
		{
			if (playerPath.size() >= MAXPATHSIZE)
			{
				playerPath.add(runningPlayer.getWorldLocation());
				break;
			}
			playerPath.add(null);

		}


	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("drop"))
		{
			return;
		}

		updateConfig();
	}


	private void reset()
	{
		playerPath.clear();

	}


	private void updateConfig()
	{
		this.playerName = config.playerName();
		this.showAmmount = config.showAmmount();
		this.overlayColor = config.overlayColor();
		this.fontStyle = config.fontStyle().getFont();
		this.textSize = config.textSize();
	}
}
