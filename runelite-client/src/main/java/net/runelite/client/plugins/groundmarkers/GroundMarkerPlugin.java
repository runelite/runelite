/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
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

package net.runelite.client.plugins.groundmarkers;

import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import com.google.inject.Provides;
import java.awt.Polygon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.api.Region ;
import net.runelite.api.Tile ;
import net.runelite.api.coords.LocalPoint ;
import net.runelite.api.Perspective ;
import org.apache.commons.lang3.ArrayUtils;
import net.runelite.api.events.MenuEntryAdded;
import java.util.Arrays;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuAction;

@Slf4j
@PluginDescriptor(
	name = "Ground Markers"
)
public class GroundMarkerPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "groundMarker";
	private static final String PREFIX = "markers";
	private static final int REGION_SIZE = 104;
	private static final String MARK = "Mark tile";

	@Inject
	Client client;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean resetHotkeyPressed;

	@Inject
	private GroundMarkerInputListener inputListener;

	@Inject
	private ConfigManager configManager;

	@Inject
	private GroundMarkerConfig config;

	@Inject
	private GroundMarkerOverlay overlay ;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private KeyManager keyManager;

	@Inject
	ScheduledExecutorService executor;

	@Provides
	GroundMarkerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundMarkerConfig.class);
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused() && (hotKeyPressed || resetHotkeyPressed))
		{
			setHotKeyPressed(false);
			setResetHotkeyPressed(false);
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (event.getOption().equals("Walk here"))
		{
			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

			MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();

			menuEntry.setOption(MARK);
			menuEntry.setTarget(event.getTarget());
			menuEntry.setType(MenuAction.CANCEL.getId());

			client.setMenuEntries(menuEntries);
		}

		return;
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!event.getMenuOption().equals(MARK))
		{
			return;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();

		for (int i = 0; i < menuEntries.length; i++)
		{
			if (menuEntries[i].getOption().equals("Walk here"))
			{
				Point target = new Point(menuEntries[i].getParam0(), menuEntries[i].getParam1());
				executor.execute(() -> markTile(target));

				return ;
			}
		}
	}

	private int getPointIndex(WorldPoint ptWorld)
	{
		for (GroundMarkerPoint pt : overlay.getLstPoints())
		{
			if (pt.getPoint().equals(ptWorld))
			{
				return overlay.getLstPoints().indexOf(pt);
			}
		}

		return -1 ;
	}

	public void addPoint(WorldPoint ptWorld)
	{
		overlay.getLstPoints().add(new GroundMarkerPoint(ptWorld, client));
		savePoints();
	}

	private void addPoint(int[] intPoint)
	{
		overlay.getLstPoints().add(new GroundMarkerPoint(intPoint));
	}

	public void removePoint(WorldPoint ptWorld)
	{
		int intIndex = this.getPointIndex(ptWorld);

		if (intIndex < 0)
		{
			return;
		}

		overlay.getLstPoints().remove(intIndex);

		savePoints();
	}

	public boolean hasPoint(WorldPoint ptWorld)
	{
		return this.getPointIndex(ptWorld) >= 0;
	}

	public void clearPoints()
	{
		overlay.getLstPoints().clear();
		savePoints();
	}

	protected void togglePoint(WorldPoint ptWorld)
	{
		if (this.hasPoint(ptWorld))
		{
			this.removePoint(ptWorld);
		}
		else
		{
			this.addPoint(ptWorld);
		}
	}

	private int[][] listToRaw()
	{
		int[][] intOut = {};

		for (GroundMarkerPoint point : overlay.getLstPoints())
		{
			if (!point.isInstanced())
			{
				intOut = ArrayUtils.add(intOut, point.toRaw());
			}
		}

		return intOut ;
	}

	private final Gson gson = new Gson();

	public void loadPoints()
	{
		String config = configManager.getConfiguration(CONFIG_GROUP, PREFIX);

		if (config == null || config.isEmpty())
		{
			return;
		}

		int[][] intIn = gson.fromJson(config, int[][].class);

		for (int[] intPoint : intIn)
		{
			addPoint(intPoint);
		}
	}

	public void savePoints()
	{
		configManager.setConfiguration(CONFIG_GROUP, PREFIX, gson.toJson(listToRaw()));
	}

	@Override
	protected void startUp()
	{
		loadPoints();

		mouseManager.registerMouseListener(inputListener);
		keyManager.registerKeyListener(inputListener);
	}

	@Override
	protected void shutDown()
	{
		savePoints();

		mouseManager.unregisterMouseListener(inputListener);
		keyManager.unregisterKeyListener(inputListener);
	}

	@Override
	public GroundMarkerOverlay getOverlay()
	{
		return overlay;
	}

	protected void markTile(Point ptMouse)
	{
		WorldPoint ptWorld = getTile(ptMouse);

		if (ptWorld == null)
		{
			return;
		}

		this.togglePoint(ptWorld);
	}

	public WorldPoint getTile(Point mouse)
	{
		try
		{
			Region region = client.getRegion();
			Tile[][][] tiles = region.getTiles();
			int z = client.getPlane();

			java.awt.Point gameMouse = new java.awt.Point(mouse.getX(), mouse.getY());

			for (int x = 0; x < REGION_SIZE; ++x)
			{
				for (int y = 0; y < REGION_SIZE; ++y)
				{
					Tile tile = tiles[z][x][y];

					if (tile == null)
					{
						continue;
					}

					LocalPoint local = (tile.getLocalLocation());
					Polygon poly = Perspective.getCanvasTilePoly(client, local);

					if ( poly == null )
					{
						continue;
					}

					if (Perspective.getCanvasTilePoly(client, local).contains(gameMouse))
					{
						return new WorldPoint(0, 0, 0).fromLocal(client, local);
					}
				}
			}
		}
		catch (Exception e)
		{
			log.debug(e.toString());
		}

		return null;
	}
}