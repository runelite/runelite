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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@PluginDescriptor(
	name = "Ground Markers",
	description = "Enable marking of tiles using the Shift key",
	tags = {"overlay", "tiles"}
)
public class GroundMarkerPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "groundMarker";
	private static final String PLUGIN_NAME = "Ground Marker";
	private static final String WALK_HERE = "Walk here";
	private static final String REGION_PREFIX = "region_";
	private static final String GROUP_PREFIX = "_group_";

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

	@Inject
	private GroundMarkerPluginPanel pluginPanel;

	@Inject
	private ClientToolbar clientToolbar;

	private NavigationButton navigationButton;

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
		return gson.fromJson(json, new TypeToken<List<GroundMarkerPoint>>()
		{
		}.getType());
		// CHECKSTYLE:ON
	}

	void savePoints(int regionId, String groupName, Collection<GroundMarkerPoint> points)
	{
		if (groupName == null)
		{
			savePoints(regionId, points);
		}

		String configKey = REGION_PREFIX + regionId + GROUP_PREFIX + groupName;
		if (points == null || points.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, configKey);
			return;
		}

		String json = gson.toJson(points);
		configManager.setConfiguration(CONFIG_GROUP, configKey, json);
	}

	Collection<GroundMarkerPoint> getPoints(int regionId, String groupName)
	{
		if (groupName == null)
		{
			return getPoints(regionId);
		}

		String configKey = REGION_PREFIX + regionId + GROUP_PREFIX + groupName;
		String json = configManager.getConfiguration(CONFIG_GROUP, configKey);
		if (Strings.isNullOrEmpty(json))
		{
			return Collections.emptyList();
		}

		// CHECKSTYLE:OFF
		return gson.fromJson(json, new TypeToken<List<GroundMarkerPoint>>()
		{
		}.getType());
		// CHECKSTYLE:ON
	}

	void saveGroups(Collection<GroundMarkerGroup> groups)
	{
		if (groups == null || groups.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, "groups");
			return;
		}

		String json = gson.toJson(groups);
		configManager.setConfiguration(CONFIG_GROUP, "groups", json);
	}

	Collection<GroundMarkerGroup> getGroups()
	{
		String json = configManager.getConfiguration(CONFIG_GROUP, "groups");
		if (Strings.isNullOrEmpty(json))
		{
			return Collections.emptySet();
		}

		// CHECKSTYLE:OFF
		return gson.fromJson(json, new TypeToken<Set<GroundMarkerGroup>>()
		{
		}.getType());
		// CHECKSTYLE:ON
	}

	List<String> getVisibleGroups()
	{
		return getGroups().stream()
			.filter(GroundMarkerGroup::isVisible)
			.map(GroundMarkerGroup::getName)
			.sorted()
			.collect(Collectors.toList());
	}

	Collection<GroundMarkerPoint> getAllPointsForGroup(String groupName)
	{
		Collection<GroundMarkerPoint> points = new ArrayList<>();
		List<String> keys = configManager.getConfigurationKeys(CONFIG_GROUP + "." + REGION_PREFIX).stream()
			.filter(regionPrefixedKey -> regionPrefixedKey.endsWith(GROUP_PREFIX + groupName))
			.collect(Collectors.toList());
		for (String key : keys)
		{
			int regionId = Integer.parseInt(StringUtils.substringBetween(key, REGION_PREFIX, GROUP_PREFIX));
			Collection<GroundMarkerPoint> groupPoints = getPoints(regionId, groupName).stream()
				.filter(p -> p.getGroup() != null && p.getGroup().equals(groupName))
				.collect(Collectors.toList());
			points.addAll(groupPoints);
		}

		return points;
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

		Collection<String> visibleGroups = getVisibleGroups();
		for (int regionId : regions)
		{
			// load points for region
			log.debug("Loading points for region {}", regionId);
			Collection<GroundMarkerPoint> regionPoints = new HashSet<>(getPoints(regionId));
			Collection<GroundMarkerPoint> mergedPoints = visibleGroups.stream()
				.flatMap(group -> getPoints(regionId, group).stream())
				.collect(Collectors.toSet());
			mergedPoints.addAll(regionPoints);
			Collection<ColorTileMarker> colorTileMarkers = translateToColorTileMarker(mergedPoints);
			points.addAll(colorTileMarkers);
		}
	}

	/**
	 * Translate a collection of ground marker points to color tile markers, accounting for instances
	 *
	 * @param points {@link GroundMarkerPoint}s to be converted to {@link ColorTileMarker}s
	 * @return A collection of color tile markers, converted from the passed ground marker points, accounting for local
	 * instance points. See {@link WorldPoint#toLocalInstance(Client, WorldPoint)}
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

		pluginPanel = new GroundMarkerPluginPanel(this);

		final BufferedImage icon = ImageUtil.loadImageResource(GroundMarkerPlugin.class, "ground_marker_icon.png");

		navigationButton = NavigationButton.builder()
			.tooltip(PLUGIN_NAME)
			.icon(icon)
			.priority(5)
			.panel(pluginPanel)
			.build();

		clientToolbar.addNavigation(navigationButton);
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(sharingManager);
		overlayManager.remove(overlay);
		overlayManager.remove(minimapOverlay);
		sharingManager.removeMenuOptions();
		points.clear();
		clientToolbar.removeNavigation(navigationButton);
		navigationButton = null;
		pluginPanel = null;
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
			Collection<String> visibleGroups = getVisibleGroups();
			final WorldPoint worldPoint = WorldPoint.fromLocalInstance(client, selectedSceneTile.getLocalLocation());
			final int regionId = worldPoint.getRegionID();
			var regionPoints = getPoints(regionId);
			var groupPoints = visibleGroups.stream()
				.flatMap(group -> getPoints(regionId, group).stream())
				.collect(Collectors.toList());
			var existingPoints = Stream.concat(groupPoints.stream(), regionPoints.stream())
				.filter(p -> p.getRegionX() == worldPoint.getRegionX() && p.getRegionY() == worldPoint.getRegionY() && p.getZ() == worldPoint.getPlane())
				.collect(Collectors.toList());

			client.createMenuEntry(-1)
				.setOption(!existingPoints.isEmpty() ? "Unmark" : "Mark")
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

			if (!existingPoints.isEmpty())
			{
				var visible = existingPoints.get(0);

				client.createMenuEntry(-2)
					.setOption("Label")
					.setTarget("Tile")
					.setType(MenuAction.RUNELITE)
					.onClick(e -> labelTile(visible));

				MenuEntry menuColor = client.createMenuEntry(-3)
					.setOption("Color")
					.setTarget("Tile")
					.setType(MenuAction.RUNELITE);
				Menu colorSubMenu = menuColor.createSubMenu();

				if (regionPoints.size() > 1)
				{
					colorSubMenu.createMenuEntry(-1)
						.setOption("Reset all")
						.setType(MenuAction.RUNELITE)
						.onClick(e ->
							chatboxPanelManager.openTextMenuInput("Are you sure you want to reset the color of " + regionPoints.size() + " tiles?")
								.option("Yes", () ->
								{
									var newPoints = regionPoints.stream()
										.map(p -> new GroundMarkerPoint(p.getRegionId(), p.getRegionX(), p.getRegionY(), p.getZ(), config.markerColor(), p.getLabel(), p.getGroup()))
										.collect(Collectors.toList());
									savePoints(regionId, newPoints);
									loadPoints();
								})
								.option("No", Runnables.doNothing())
								.build());
				}

				colorSubMenu.createMenuEntry(-1)
					.setOption("Pick")
					.setType(MenuAction.RUNELITE)
					.onClick(e ->
					{
						Color color = visible.getColor();
						SwingUtilities.invokeLater(() ->
						{
							RuneliteColorPicker colorPicker = colorPickerManager.create(client,
								color, "Tile marker color", false);
							colorPicker.setOnClose(c -> colorTile(visible, c));
							colorPicker.setVisible(true);
						});
					});

				var existingColors = points.stream()
					.map(ColorTileMarker::getColor)
					.distinct()
					.collect(Collectors.toList());
				for (Color color : existingColors)
				{
					if (!color.equals(visible.getColor()))
					{
						colorSubMenu.createMenuEntry(-1)
							.setOption(ColorUtil.prependColorTag("Color", color))
							.setType(MenuAction.RUNELITE)
							.onClick(e -> colorTile(visible, color));
					}
				}

				MenuEntry menuAddGroup = client.createMenuEntry(-4)
					.setOption("Add Group")
					.setTarget("Tile")
					.setType(MenuAction.RUNELITE);

				Menu menuAddGroupSubMenu = menuAddGroup.createSubMenu();
				menuAddGroupSubMenu.createMenuEntry(-1)
					.setOption("New")
					.setType(MenuAction.RUNELITE)
					.onClick(e ->
					{
						chatboxPanelManager.openTextInput("Group Name")
							.onDone((newValue) ->
							{
								addTileToGroup(visible, newValue);
							})
							.build();
					});
				Collection<String> currentGroupsForTile = existingPoints.stream()
					.map(GroundMarkerPoint::getGroup)
					.collect(Collectors.toSet());
				Collection<String> groupNames = getGroups().stream()
					.map(GroundMarkerGroup::getName)
					.filter(g -> !currentGroupsForTile.contains(g))
					.collect(Collectors.toSet());

				for (String groupName : groupNames)
				{
					menuAddGroupSubMenu.createMenuEntry(-1)
						.setOption(groupName)
						.setType(MenuAction.RUNELITE)
						.onClick(e ->
						{
							addTileToGroup(visible, groupName);
						});
				}

				if (existingPoints.size() > 1 || existingPoints.get(0).getGroup() != null)
				{
					MenuEntry menuRemoveGroup = client.createMenuEntry(-5)
						.setOption("Remove Group")
						.setTarget("Tile")
						.setType(MenuAction.RUNELITE);

					Menu removeGroupSubMenu = menuRemoveGroup.createSubMenu();
					List<String> removableGroups = existingPoints.stream()
						.map(GroundMarkerPoint::getGroup)
						.filter(Objects::nonNull)
						.collect(Collectors.toList());
					for (String groupName : removableGroups)
					{
						removeGroupSubMenu.createMenuEntry(-1)
							.setOption(groupName)
							.setType(MenuAction.RUNELITE)
							.onClick(e ->
							{
								removeTileFromGroup(existingPoints, groupName);
							});
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
		GroundMarkerPoint point = new GroundMarkerPoint(regionId, worldPoint.getRegionX(), worldPoint.getRegionY(), worldPoint.getPlane(), config.markerColor(), null, null);
		log.debug("Updating point: {} - {}", point, worldPoint);

		HashSet<GroundMarkerPoint> groundMarkerPoints = new HashSet<>(getPoints(regionId));
		Map<String, List<GroundMarkerPoint>> groupPoints = getVisibleGroups().stream()
			.flatMap(g -> getPoints(regionId, g).stream())
			.collect(Collectors.groupingBy(GroundMarkerPoint::getGroup));

		var groupPointOpt = groupPoints.values().stream()
			.flatMap(Collection::stream)
			.filter(p -> p.equals(point))
			.findFirst();
		if (groundMarkerPoints.contains(point) || groupPointOpt.isPresent())
		{
			groundMarkerPoints.remove(point);
			groupPoints.forEach((groupName, points) ->
			{
				points.remove(point);
				savePoints(regionId, groupName, points);
			});
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

				var newPoint = new GroundMarkerPoint(existing.getRegionId(), existing.getRegionX(), existing.getRegionY(), existing.getZ(), existing.getColor(), input, existing.getGroup());
				Collection<GroundMarkerPoint> points = new HashSet<>(getPoints(existing.getRegionId(), existing.getGroup()));
				points.remove(existing);
				points.add(newPoint);
				savePoints(existing.getRegionId(), existing.getGroup(), points);

				loadPoints();
			})
			.build();
	}

	private void colorTile(GroundMarkerPoint existing, Color newColor)
	{
		var newPoint = new GroundMarkerPoint(existing.getRegionId(), existing.getRegionX(), existing.getRegionY(), existing.getZ(), newColor, existing.getLabel(), existing.getGroup());
		Collection<GroundMarkerPoint> points = new HashSet<>(getPoints(existing.getRegionId(), existing.getGroup()));
		points.remove(newPoint);
		points.add(newPoint);
		savePoints(existing.getRegionId(), existing.getGroup(), points);

		loadPoints();
	}

	private void addTileToGroup(GroundMarkerPoint existing, String groupName)
	{
		var newPoint = new GroundMarkerPoint(existing.getRegionId(), existing.getRegionX(), existing.getRegionY(), existing.getZ(), existing.getColor(), existing.getLabel(), groupName);
		Collection<GroundMarkerPoint> points = new HashSet<>(getPoints(existing.getRegionId()));

		if (existing.getGroup() == null)
		{
			points.remove(existing);
		}

		Collection<GroundMarkerPoint> groupPoints = new HashSet<>(getPoints(existing.getRegionId(), groupName));
		groupPoints.remove(newPoint);
		groupPoints.add(newPoint);

		Collection<GroundMarkerGroup> groups = new HashSet<>(getGroups());
		GroundMarkerGroup newGroup = new GroundMarkerGroup(groupName, true);
		groups.remove(newGroup);
		groups.add(newGroup);
		saveGroups(groups);

		savePoints(existing.getRegionId(), points);
		savePoints(existing.getRegionId(), groupName, groupPoints);
		loadPoints();
		rebuildPanel();
	}

	private void removeTileFromGroup(List<GroundMarkerPoint> existingPoints, String groupName)
	{
		Optional<GroundMarkerPoint> groupPointToRemove = existingPoints.stream()
			.filter(p -> p.getGroup() != null && p.getGroup().equals(groupName))
			.findFirst();

		if (groupPointToRemove.isEmpty())
		{
			return;
		}

		GroundMarkerPoint point = groupPointToRemove.get();

		if (existingPoints.size() == 1)
		{
			Collection<GroundMarkerPoint> regionPoints = new ArrayList<>(getPoints(point.getRegionId()));
			var newPoint = new GroundMarkerPoint(point.getRegionId(), point.getRegionX(), point.getRegionY(), point.getZ(), point.getColor(), point.getLabel(), null);
			regionPoints.add(newPoint);
			savePoints(newPoint.getRegionId(), regionPoints);
		}

		Collection<GroundMarkerPoint> groupPoints = new HashSet<>(getPoints(point.getRegionId(), groupName));
		groupPoints.remove(point);
		if (groupPoints.isEmpty())
		{
			Collection<GroundMarkerGroup> groups = getGroups();
			groups.remove(new GroundMarkerGroup(groupName, false));
			saveGroups(groups);
			rebuildPanel();
		}
		savePoints(point.getRegionId(), groupName, groupPoints);
		loadPoints();
	}

	void deleteGroup(String groupName)
	{
		Collection<GroundMarkerPoint> points = getAllPointsForGroup(groupName);
		Collection<GroundMarkerGroup> groups = new HashSet<>(getGroups());
		points.stream()
			.collect(Collectors.groupingBy(GroundMarkerPoint::getRegionId))
			.forEach((regionId, groupPointsInRegion) ->
			{
				Collection<GroundMarkerPoint> regionPoints = new HashSet<>(getPoints(regionId, groupName));
				regionPoints.removeAll(groupPointsInRegion);
				savePoints(regionId, groupName, regionPoints);
			});

		groups.remove(new GroundMarkerGroup(groupName, false));
		saveGroups(groups);
		loadPoints();
		rebuildPanel();
	}

	void setGroupVisibility(String groupName, boolean isVisible)
	{
		HashSet<GroundMarkerGroup> groups = new HashSet<>(getGroups());
		GroundMarkerGroup newGroup = new GroundMarkerGroup(groupName, isVisible);
		groups.remove(newGroup);
		groups.add(newGroup);

		saveGroups(groups);
		loadPoints();
	}

	void exportGroup(String groupName)
	{
		Collection<GroundMarkerPoint> pointsToExport = getAllPointsForGroup(groupName).stream()
			.filter(p -> p.getGroup() != null && p.getGroup().equals(groupName))
			.collect(Collectors.toList());

		sharingManager.exportGroundMarkers(pointsToExport);
	}

	void rebuildPanel()
	{
		pluginPanel.rebuild();
	}
}
