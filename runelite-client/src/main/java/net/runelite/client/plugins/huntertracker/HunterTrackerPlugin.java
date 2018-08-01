/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018 Jeff LaJoie
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.huntertracker;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarPlayer;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.UsernameChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;

@PluginDescriptor(
		name = "Hunter Tracker"
)
@Slf4j
public class HunterTrackerPlugin extends Plugin
{
	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Client client;

	@Inject
	private HunterWorld hunterWorld;

	@Inject
	private ItemManager itemManager;

	@Inject
	private HunterTrackerConfig config;

	private HunterTrackerPanel panel;

	private NavigationButton navButton;

	private WorldPoint lastTickLoc;

	@Provides
	HunterTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HunterTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("hunter.png"));
		}

		panel = new HunterTrackerPanel(client, itemManager, configManager, config, hunterWorld);

		navButton = NavigationButton.builder()
				.tooltip("Hunter Tracker")
				.icon(icon)
				.panel(panel)
				.priority(4)
				.build();

		pluginToolbar.addNavigation(navButton);

		updatePanel();
	}

	@Subscribe
	public void onUsernameChanged(UsernameChanged e)
	{
		updatePanel();
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onGameTick(GameTick t)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			lastTickLoc = null;
			return;
		}

		// This VarClientInt is only -1 when you aren't actively in game (including at the post-login screen)
		// The Birdhouse VarPs are only initialized once you've clicked CLICK HERE TO PLAY
		if (client.getVar(VarClientInt.INVENTORY_TAB) == -1)
		{
			return;
		}

		WorldPoint loc = lastTickLoc;
		lastTickLoc = client.getLocalPlayer().getWorldLocation();
		if (loc == null || loc.getRegionID() != lastTickLoc.getRegionID())
		{
			return;
		}

		BirdhouseRegion region = hunterWorld.getRegions().get(loc.getRegionID());
		if (region != null)
		{
			// Write config with new varp and timestamps
			// huntertracker.<username>.<regionID>.<varpID>=<varpValue>:<startTime>:<updatedAt>
			String group = HunterTrackerConfig.KEY_NAME + "." + client.getUsername() + "." + region.getRegionID();
			long unixNow = Instant.now().getEpochSecond();
			for (VarPlayer varp : region.getVarps())
			{
				// Write the config value if it doesn't match what is current, or it is more than 5 minutes old
				String key = Integer.toString(varp.getId());
				String strVarp = Integer.toString(client.getVar(varp));
				String storedValue = configManager.getConfiguration(group, key);
				if (storedValue != null)
				{
					String[] parts = storedValue.split(":");
					if (parts.length == 3)
					{
						long startTime = 0;
						long updatedAt = 0;
						try
						{
							startTime = Long.parseLong(parts[1]);
							updatedAt = Long.parseLong(parts[2]);
						}
						catch (NumberFormatException e)
						{
							log.debug(e.getMessage());
						}
						// If it's been at least 5 minutes and the varp hasn't changed, re-write the config and update
						if (parts[0].equals(strVarp) && updatedAt + (5 * 60) <= unixNow)
						{
							String value = strVarp + ":" + startTime + ':' + unixNow;
							configManager.setConfiguration(group, key, value);
							updatePanel();
						}
						// If the varp doesn't match, update the config and re-init the startTime
						else if (!parts[0].equals(strVarp))
						{
							String value = strVarp + ":" + unixNow + ":" + unixNow;
							configManager.setConfiguration(group, key, value);
							updatePanel();
						}
					}
				}
				else
				{
					// If there's no config value add one
					String value = strVarp + ":" + unixNow + ":" + unixNow;
					configManager.setConfiguration(group, key, value);
					updatePanel();
				}
			}
		}
	}

	@Schedule(period = 10, unit = ChronoUnit.SECONDS)
	public void updatePanel()
	{
		// Only update this panel if it's active
		if (panel.active)
		{
			SwingUtilities.invokeLater(panel::update);
		}
	}
}
