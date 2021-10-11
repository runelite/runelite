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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.KeyCode;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
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
	private static final String UNMARK = "Unmark tile";
	private static final String LABEL = "Label tile";
	private static final String WALK_HERE = "Walk here";
	private static final String REGION_PREFIX = "region_";

	@Getter(AccessLevel.PACKAGE)
	private final List<ColorTileMarker> points = new ArrayList<>();

	@Inject
	private Client client;

	@Inject
	private GroundMarkerConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private GroundMarkerOverlay overlay;

	@Inject
	private GroundMarkerMinimapOverlay minimapOverlay;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private EventBus eventBus;

	@Inject
	private GroundMarkerSharingManager sharingManager;

	@Inject
	private Gson gson;

	void savePoints(int regionId, Collection<GroundMarkerPoint> points)
	{
		if (points == null || points.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId);
			return;
		}

		String json = gson.toJson(points);
		configManager.setConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId, json);
	}

	Collection<GroundMarkerPoint> getPoints(int regionId)
	{
		String json = configManager.getConfiguration(CONFIG_GROUP, REGION_PREFIX + regionId);
		if (Strings.isNullOrEmpty(json))
		{
			return Collections.emptyList();
		}

		// CHECKSTYLE:OFF
		return gson.fromJson(json, new TypeToken<List<GroundMarkerPoint>>(){}.getType());
		// CHECKSTYLE:ON
	}

	@Provides
	GroundMarkerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GroundMarkerConfig.class);
	}

	void loadPoints()
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
			Collection<GroundMarkerPoint> regionPoints = getPoints(regionId);
			Collection<ColorTileMarker> colorTileMarkers = translateToColorTileMarker(regionPoints);
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
		if (points.isEmpty())
		{
			return Collections.emptyList();
		}

		return points.stream()
			.map(point -> new ColorTileMarker(
				WorldPoint.fromRegion(point.getRegionId(), point.getRegionX(), point.getRegionY(), point.getZ()),
				point.getColor(), point.getLabel()))
			.flatMap(colorTile ->
			{
				final Collection<WorldPoint> localWorldPoints = WorldPoint.toLocalInstance(client, colorTile.getWorldPoint());
				return localWorldPoints.stream().map(wp -> new ColorTileMarker(wp, colorTile.getColor(), colorTile.getLabel()));
			})
			.collect(Collectors.toList());
	}

	@Override
	public void startUp()
	{
		overlayManager.add(overlay);
		overlayManager.add(minimapOverlay);
		if (config.showImportExport())
		{
			sharingManager.addImportExportMenuOptions();
		}
		if (config.showClear())
		{
			sharingManager.addClearMenuOption();
		}
		loadPoints();
		eventBus.register(sharingManager);
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(sharingManager);
		overlayManager.remove(overlay);
		overlayManager.remove(minimapOverlay);
		sharingManager.removeMenuOptions();
		points.clear();
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
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		final boolean hotKeyPressed = client.isKeyPressed(KeyCode.KC_SHIFT);
		if (hotKeyPressed && event.getOption().equals(WALK_HERE))
		{
			final Tile selectedSceneTile = client.getSelectedSceneTile();

			if (selectedSceneTile == null)
			{
				return;
			}

			final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, selectedSceneTile.getLocalLocation());
			final int regionId = worldPoint.getRegionID();
			final GroundMarkerPoint point = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), client.getPlane(), null, null);
			final boolean exists = getPoints(regionId).contains(point);

			MenuEntry[] menuEntries = client.getMenuEntries();
			menuEntries = Arrays.copyOf(menuEntries, menuEntries.length + (exists ? 2 : 1));

			MenuEntry mark = menuEntries[menuEntries.length - 1] = new MenuEntry();
			mark.setOption(exists ? UNMARK : MARK);
			mark.setTarget(event.getTarget());
			mark.setType(MenuAction.RUNELITE.getId());

			if (exists)
			{
				MenuEntry label = menuEntries[menuEntries.length - 2] = new MenuEntry();
				label.setOption(LABEL);
				label.setTarget(event.getTarget());
				label.setType(MenuAction.RUNELITE.getId());
			}

			client.setMenuEntries(menuEntries);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction().getId() != MenuAction.RUNELITE.getId())
		{
			return;
		}

		Tile target = client.getSelectedSceneTile();
		if (target == null)
		{
			return;
		}

		final String option = event.getMenuOption();
		if (option.equals(MARK) || option.equals(UNMARK))
		{
			markTile(target.getLocalLocation());
		}
		else if (option.equals(LABEL))
		{
			labelTile(target);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(GroundMarkerConfig.GROUND_MARKER_CONFIG_GROUP)
			&& (event.getKey().equals(GroundMarkerConfig.SHOW_IMPORT_EXPORT_KEY_NAME)
				|| event.getKey().equals(GroundMarkerConfig.SHOW_CLEAR_KEY_NAME)))
		{
			// Maintain consistent menu option order by removing everything then adding according to config
			sharingManager.removeMenuOptions();

			if (config.showImportExport())
			{
				sharingManager.addImportExportMenuOptions();
			}
			if (config.showClear())
			{
				sharingManager.addClearMenuOption();
			}
		}
	}

	private void markTile(LocalPoint localPoint)
	{
		if (localPoint == null)
		{
			return;
		}

		WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, localPoint);

		int regionId = worldPoint.getRegionID();
		GroundMarkerPoint point = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), client.getPlane(), config.markerColor(), null);
		log.debug("Updating point: {} - {}", point, worldPoint);

		List<GroundMarkerPoint> groundMarkerPoints = new ArrayList<>(getPoints(regionId));
		if (groundMarkerPoints.contains(point))
		{
			groundMarkerPoints.remove(point);
		}
		else
		{
			groundMarkerPoints.add(point);
		}

		savePoints(regionId, groundMarkerPoints);

		loadPoints();
	}

	private void labelTile(Tile tile)
	{
		LocalPoint localPoint = tile.getLocalLocation();
		WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, localPoint);
		final int regionId = worldPoint.getRegionID();

		GroundMarkerPoint searchPoint = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), client.getPlane(), null, null);
		Collection<GroundMarkerPoint> points = getPoints(regionId);
		GroundMarkerPoint existing = points.stream()
			.filter(p -> p.equals(searchPoint))
			.findFirst().orElse(null);
		if (existing == null)
		{
			return;
		}

		chatboxPanelManager.openTextInput("Tile label")
			.value(Optional.ofNullable(existing.getLabel()).orElse(""))
			.onDone((input) ->
			{
				input = Strings.emptyToNull(input);

				GroundMarkerPoint newPoint = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), client.getPlane(), existing.getColor(), input);
				points.remove(searchPoint);
				points.add(newPoint);
				savePoints(regionId, points);

				loadPoints();
			})
			.build();
	}
}
