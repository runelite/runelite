/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.screenmarkers;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.screenmarkers.ui.ScreenMarkerPluginPanel;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Screen Markers",
	description = "Enable drawing of screen markers on top of the client",
	tags = {"boxes", "overlay", "panel"}
)
public class ScreenMarkerPlugin extends Plugin
{
	private static final String PLUGIN_NAME = "Screen Markers";
	private static final String CONFIG_GROUP = "screenmarkers";
	private static final String CONFIG_KEY = "markers";
	private static final String ICON_FILE = "panel_icon.png";
	private static final String DEFAULT_MARKER_NAME = "Marker";
	private static final Dimension DEFAULT_SIZE = new Dimension(2, 2);

	@Getter
	private final List<ScreenMarkerOverlay> screenMarkers = new ArrayList<>();

	@Inject
	private ConfigManager configManager;

	@Inject
	private MouseManager mouseManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ScreenMarkerCreationOverlay overlay;

	@Inject
	private Gson gson;

	@Getter
	@Inject
	private ColorPickerManager colorPickerManager;

	@Inject
	private ScreenMarkerWidgetHighlightOverlay widgetHighlight;

	private ScreenMarkerMouseListener mouseListener;
	private ScreenMarkerPluginPanel pluginPanel;
	private NavigationButton navigationButton;

	@Getter(AccessLevel.PACKAGE)
	private ScreenMarker currentMarker;

	@Getter
	@Setter
	private boolean creatingScreenMarker = false;

	@Getter
	private boolean drawingScreenMarker = false;

	@Getter
	@Setter
	private Rectangle selectedWidgetBounds = null;
	private Point startLocation = null;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlayManager.add(widgetHighlight);
		loadConfig(configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY)).forEach(screenMarkers::add);
		screenMarkers.forEach(overlayManager::add);

		pluginPanel = new ScreenMarkerPluginPanel(this);
		pluginPanel.rebuild();

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), ICON_FILE);

		navigationButton = NavigationButton.builder()
			.tooltip(PLUGIN_NAME)
			.icon(icon)
			.priority(5)
			.panel(pluginPanel)
			.build();

		clientToolbar.addNavigation(navigationButton);

		mouseListener = new ScreenMarkerMouseListener(this);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.remove(widgetHighlight);
		overlayManager.removeIf(ScreenMarkerOverlay.class::isInstance);
		screenMarkers.clear();
		clientToolbar.removeNavigation(navigationButton);
		setMouseListenerEnabled(false);
		creatingScreenMarker = false;
		drawingScreenMarker = false;

		pluginPanel = null;
		currentMarker = null;
		mouseListener = null;
		navigationButton = null;
		selectedWidgetBounds = null;
	}

	@Subscribe
	private void onProfileChanged(ProfileChanged profileChanged)
	{
		screenMarkers.clear();
		loadConfig(configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY)).forEach(screenMarkers::add);
		overlayManager.removeIf(ScreenMarkerOverlay.class::isInstance);
		screenMarkers.forEach(overlayManager::add);
		SwingUtilities.invokeLater(pluginPanel::rebuild);
	}

	public void setMouseListenerEnabled(boolean enabled)
	{
		if (enabled)
		{
			mouseManager.registerMouseListener(mouseListener);
		}
		else
		{
			mouseManager.unregisterMouseListener(mouseListener);
		}
	}

	public void startCreation(Point location)
	{
		startCreation(location, DEFAULT_SIZE);

		// Stop the highlighting so we don't get rectangles around widgets while trying to make normal screen markers
		if (selectedWidgetBounds == null)
		{
			drawingScreenMarker = true;
		}
	}

	public void startCreation(Point location, Dimension size)
	{
		currentMarker = new ScreenMarker(
			Instant.now().toEpochMilli(),
			DEFAULT_MARKER_NAME + " " + (screenMarkers.size() + 1),
			ScreenMarkerPluginPanel.SELECTED_BORDER_THICKNESS,
			ScreenMarkerPluginPanel.SELECTED_COLOR,
			ScreenMarkerPluginPanel.SELECTED_FILL_COLOR,
			true,
			false
		);

		// Set overlay creator bounds to current position and default size
		startLocation = location;
		overlay.setPreferredLocation(location);
		overlay.setPreferredSize(size);
	}

	public void finishCreation(boolean aborted)
	{
		ScreenMarker marker = currentMarker;
		if (!aborted && marker != null)
		{
			final ScreenMarkerOverlay screenMarkerOverlay = new ScreenMarkerOverlay(marker);
			screenMarkerOverlay.setPreferredLocation(overlay.getBounds().getLocation());
			screenMarkerOverlay.setPreferredSize(overlay.getBounds().getSize());

			screenMarkers.add(screenMarkerOverlay);
			overlayManager.saveOverlay(screenMarkerOverlay);
			overlayManager.add(screenMarkerOverlay);
			pluginPanel.rebuild();
			updateConfig();
		}

		creatingScreenMarker = false;
		drawingScreenMarker = false;
		selectedWidgetBounds = null;
		startLocation = null;
		currentMarker = null;
		setMouseListenerEnabled(false);

		pluginPanel.setCreation(false);
	}

	public void completeSelection()
	{
		pluginPanel.getCreationPanel().unlockConfirm();
	}

	public void deleteMarker(final ScreenMarkerOverlay marker)
	{
		screenMarkers.remove(marker);
		overlayManager.remove(marker);
		overlayManager.resetOverlay(marker);
		pluginPanel.rebuild();
		updateConfig();
	}

	void resizeMarker(Point point)
	{
		drawingScreenMarker = true;
		Rectangle bounds = new Rectangle(startLocation);
		bounds.add(point);
		overlay.setPreferredLocation(bounds.getLocation());
		overlay.setPreferredSize(bounds.getSize());
	}

	public void updateConfig()
	{
		if (screenMarkers.isEmpty())
		{
			configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_KEY);
			return;
		}

		final String json = gson
			.toJson(screenMarkers.stream().map(ScreenMarkerOverlay::getMarker).collect(Collectors.toList()));
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, json);
	}

	private Stream<ScreenMarkerOverlay> loadConfig(String json)
	{
		if (Strings.isNullOrEmpty(json))
		{
			return Stream.empty();
		}

		final List<ScreenMarker> screenMarkerData = gson.fromJson(json, new TypeToken<ArrayList<ScreenMarker>>()
		{
		}.getType());

		return screenMarkerData.stream().filter(Objects::nonNull).map(ScreenMarkerOverlay::new);
	}
}
