/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Ground Markers",
	description = "Enable marking of tiles using the Shift key",
	tags = {"overlay", "tiles"}
)
public class GroundMarkerPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "groundMarker";
	private static final String MARK = "Mark tile";
	private static final String WALK_HERE = "Walk here";
	private static final String REGION_PREFIX = "region_";

	private static final Gson GSON = new Gson();

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean hotKeyPressed;

	@Getter(AccessLevel.PACKAGE)
	private final Set<ColorTileMarker> points = new HashSet<>();

	@Inject
	private Client client;

	@Inject
	private GroundMarkerConfig config;

	@Inject
	private GroundMarkerInputListener inputListener;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private GroundMarkerOverlay overlay;

	@Inject
	private KeyManager keyManager;

	private void saveColorTileMarkers(int regionId, Collection<ColorTileMarker> points)
	{
		savePoints(regionId, translateFromColorTileMarker(points));
	}

	private void savePoints(int regionId, Collection<GroundMarkerPoint> points)
	{
		if (points == null || points.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId);
			return;
		}

		String json = GSON.toJson(points);
		configManager.setConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId, json);
	}

	private Collection<GroundMarkerPoint> getPoints(int regionId)
	{
		String json = configManager.getConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId);
		if (Strings.isNullOrEmpty(json))
		{
			return Collections.emptyList();
		}

		Collection<GroundMarkerPoint> configPoints = GSON.fromJson(json, new GroundMarkerListTypeToken().getType());

		if (configPoints.stream().anyMatch(point -> point.getColor() == null))
		{
			log.debug("Adding color to old ground marker(s) of region " + regionId);
			configPoints = configPoints.stream()
				.map(point ->
				{
					if (point.getColor() != null)
					{
						return point;
					}
					return new GroundMarkerPoint(point.getRegionId(), point.getRegionX(), point.getRegionY(), point.getZ(), config.markerColor());
				})
				.collect(Collectors.toSet());
			savePoints(regionId, configPoints);
		}
		return configPoints;
	}

	private static class GroundMarkerListTypeToken extends TypeToken<List<GroundMarkerPoint>>
	{
	}

	@Provides
	GroundMarkerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundMarkerConfig.class);
	}

	private void loadPoints()
	{
		points.clear();

		int[] regions = client.getMapRegions();

		if (regions == null)
		{
			return;
		}

		for (int regionId : regions)
		{
			// load points for region
			log.debug("Loading points for region {}", regionId);
			final Collection<GroundMarkerPoint> configPoints = getPoints(regionId);
			final Collection<ColorTileMarker> colorTileMarkers = translateToColorTileMarker(configPoints);
			points.addAll(colorTileMarkers);
		}
	}

	/**
	 * Translate a collection of ground marker points to color tile markers, accounting for instances
	 *
	 * @param points {@link GroundMarkerPoint}s to be converted to {@link ColorTileMarker}s
	 * @return A collection of color tile markers, converted from the passed ground marker points, accounting for local
	 *         instance points. See {@link WorldPoint#toLocalInstance(Client, WorldPoint)}
	 */
	private Collection<ColorTileMarker> translateToColorTileMarker(Collection<GroundMarkerPoint> points)
	{
		if (points == null || points.isEmpty())
		{
			return Collections.emptyList();
		}

		return points.stream()
			.map(point -> new ColorTileMarker(
				WorldPoint.fromRegion(point.getRegionId(), point.getRegionX(), point.getRegionY(), point.getZ()),
				point.getColor()))
			.flatMap(colorTile ->
			{
				final Collection<WorldPoint> localWorldPoints = WorldPoint.toLocalInstance(client, colorTile.getWorldPoint());
				return localWorldPoints.stream().map(wp -> new ColorTileMarker(wp, colorTile.getColor()));
			})
			.collect(Collectors.toSet());
	}

	/**
	 * Translate a collection of color tile markers to a set of ground marker points
	 *
	 * @param points {@link ColorTileMarker}s to be converted to {@link GroundMarkerPoint}s
	 * @return A set of ground marker points, converted from the passed color tile markers
	 */
	private static Set<GroundMarkerPoint> translateFromColorTileMarker(Collection<ColorTileMarker> points)
	{
		if (points == null || points.isEmpty())
		{
			return Collections.emptySet();
		}

		return points.stream()
			.map(point ->
			{
				final WorldPoint worldPoint = point.getWorldPoint();
				return new GroundMarkerPoint(worldPoint.getRegionID(), worldPoint.getRegionX(), worldPoint.getRegionY(), worldPoint.getPlane(), point.getColor());
			})
			.collect(Collectors.toSet());
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		// map region has just been updated
		loadPoints();
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged)
	{
		if (!focusChanged.isFocused())
		{
			hotKeyPressed = false;
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		if (hotKeyPressed && event.getOption().equals(WALK_HERE))
		{
			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + 1);

			MenuEntry menuEntry = menuEntries[menuEntries.length - 1] = new MenuEntry();

			menuEntry.setOption(MARK);
			menuEntry.setTarget(event.getTarget());
			menuEntry.setType(MenuAction.CANCEL.getId());

			client.setMenuEntries(menuEntries);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!event.getMenuOption().equals(MARK))
		{
			return;
		}

		Tile target = client.getSelectedSceneTile();
		if (target == null)
		{
			return;
		}
		markTile(target.getLocalLocation());
	}

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
		keyManager.registerKeyListener(inputListener);
		loadPoints();
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		keyManager.unregisterKeyListener(inputListener);
		points.clear();
	}

	private void markTile(LocalPoint localPoint)
	{
		if (localPoint == null)
		{
			return;
		}

		final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, localPoint);
		final ColorTileMarker point = new ColorTileMarker(worldPoint, config.markerColor());
		log.debug("Updating point: {} - {}", point, worldPoint);

		if (points.contains(point))
		{
			points.remove(point);
		}
		else
		{
			// Remove any points on the same tile but are of a different color.
			// Add a new point if no tile was removed, or if remembering tile colors is enabled, which means the marked
			// tile was previously of a different color than the new tile marking.
			if (!points.removeIf(p -> p.sameTile(point)) || config.rememberTileColors())
			{
				points.add(point);
			}
		}

		final int regionId = worldPoint.getRegionID();
		saveColorTileMarkers(regionId, points);

		loadPoints();
	}
}
