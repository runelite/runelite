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
import com.google.common.util.concurrent.Runnables;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.KeyCode;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;

@Slf4j
@PluginDescriptor(
	name = "Ground Markers",
	description = "Enable marking of tiles using the Shift key",
	tags = {"overlay", "tiles"}
)
public class GroundMarkerPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "groundMarker";
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

	@Inject
	private ColorPickerManager colorPickerManager;

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
	public void onProfileChanged(ProfileChanged profileChanged)
	{
		loadPoints();
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
			var regionPoints = getPoints(regionId);
			var existingOpt = regionPoints.stream()
				.filter(p -> p.getRegionX() == worldPoint.getRegionX() && p.getRegionY() == worldPoint.getRegionY() && p.getZ() == worldPoint.getPlane())
				.findFirst();

			client.createMenuEntry(-1)
				.setOption(existingOpt.isPresent() ? "Unmark" : "Mark")
				.setTarget("Tile")
				.setType(MenuAction.RUNELITE)
				.onClick(e ->
				{
					Tile target = client.getSelectedSceneTile();
					if (target != null)
					{
						markTile(target.getLocalLocation());
					}
				});

			if (existingOpt.isPresent())
			{
				var existing = existingOpt.get();

				client.createMenuEntry(-2)
					.setOption("Label")
					.setTarget("Tile")
					.setType(MenuAction.RUNELITE)
					.onClick(e -> labelTile(existing));

				MenuEntry menuColor = client.createMenuEntry(-3)
					.setOption("Color")
					.setTarget("Tile")
					.setType(MenuAction.RUNELITE);
				Menu submenu = menuColor.createSubMenu();

				if (regionPoints.size() > 1)
				{
					submenu.createMenuEntry(-1)
						.setOption("Reset all")
						.setType(MenuAction.RUNELITE)
						.onClick(e ->
							chatboxPanelManager.openTextMenuInput("Are you sure you want to reset the color of " + regionPoints.size() + " tiles?")
								.option("Yes", () ->
								{
									var newPoints = regionPoints.stream()
										.map(p -> new GroundMarkerPoint(p.getRegionId(), p.getRegionX(), p.getRegionY(), p.getZ(), config.markerColor(), p.getLabel()))
										.collect(Collectors.toList());
									savePoints(regionId, newPoints);
									loadPoints();
								})
								.option("No", Runnables.doNothing())
								.build());
				}

				submenu.createMenuEntry(-1)
					.setOption("Pick")
					.setType(MenuAction.RUNELITE)
					.onClick(e ->
					{
						Color color = existing.getColor();
						SwingUtilities.invokeLater(() ->
						{
							RuneliteColorPicker colorPicker = colorPickerManager.create(client,
								color, "Tile marker color", false);
							colorPicker.setOnClose(c -> colorTile(existing, c));
							colorPicker.setVisible(true);
						});
					});

				var existingColors = points.stream()
					.map(ColorTileMarker::getColor)
					.distinct()
					.collect(Collectors.toList());
				for (Color color : existingColors)
				{
					if (!color.equals(existing.getColor()))
					{
						submenu.createMenuEntry(-1)
							.setOption(ColorUtil.prependColorTag("Color", color))
							.setType(MenuAction.RUNELITE)
							.onClick(e -> colorTile(existing, color));
					}
				}
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(GroundMarkerConfig.GROUND_MARKER_CONFIG_GROUP)
			&& event.getKey().equals(GroundMarkerConfig.SHOW_IMPORT_EXPORT_KEY_NAME))
		{
			sharingManager.removeMenuOptions();

			if (config.showImportExport())
			{
				sharingManager.addImportExportMenuOptions();
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
		GroundMarkerPoint point = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), worldPoint.getPlane(), config.markerColor(), null);
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

	private void labelTile(GroundMarkerPoint existing)
	{
		chatboxPanelManager.openTextInput("Tile label")
			.value(Optional.ofNullable(existing.getLabel()).orElse(""))
			.onDone((input) ->
			{
				input = Strings.emptyToNull(input);

				var newPoint = new GroundMarkerPoint(existing.getRegionId(), existing.getRegionX(), existing.getRegionY(), existing.getZ(), existing.getColor(), input);
				Collection<GroundMarkerPoint> points = new ArrayList<>(getPoints(existing.getRegionId()));
				points.remove(existing);
				points.add(newPoint);
				savePoints(existing.getRegionId(), points);

				loadPoints();
			})
			.build();
	}

	private void colorTile(GroundMarkerPoint existing, Color newColor)
	{
		var newPoint = new GroundMarkerPoint(existing.getRegionId(), existing.getRegionX(), existing.getRegionY(), existing.getZ(), newColor, existing.getLabel());
		Collection<GroundMarkerPoint> points = new ArrayList<>(getPoints(existing.getRegionId()));
		points.remove(newPoint);
		points.add(newPoint);
		savePoints(existing.getRegionId(), points);

		loadPoints();
	}
}
