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

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import com.google.common.base.Strings;
import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.screenmarkers.ui.ScreenMarkerPluginPanel;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Screen Markers"
)
@Slf4j
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
	private KeyManager keyManager;

	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Inject
	private ScreenMarkerCreationOverlay overlay;

	@Inject
	private ScreenMarkerKeyListener keyListener;

	private ScreenMarkerMouseListener mouseListener;
	private ScreenMarkerPluginPanel pluginPanel;
	private NavigationButton navigationButton;

	@Getter(AccessLevel.PACKAGE)
	private ScreenMarker currentMarker;

	@Getter
	private boolean creatingScreenMarker = false;
	private Point startLocation = null;
	private boolean shiftModifier = false;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		loadConfig(configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY)).forEach(screenMarkers::add);
		screenMarkers.forEach(overlayManager::add);

		pluginPanel = injector.getInstance(ScreenMarkerPluginPanel.class);
		pluginPanel.init();

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(ScreenMarkerPlugin.class.getResourceAsStream(ICON_FILE));
		}

		navigationButton = NavigationButton.builder()
			.tooltip(PLUGIN_NAME)
			.icon(icon)
			.priority(5)
			.panel(pluginPanel)
			.build();

		pluginToolbar.addNavigation(navigationButton);

		mouseListener = new ScreenMarkerMouseListener(this);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		overlayManager.removeIf(ScreenMarkerOverlay.class::isInstance);
		screenMarkers.clear();
		pluginToolbar.removeNavigation(navigationButton);
		setMouseListenerEnabled(false);
		setKeyListenerEnabled(false);
		creatingScreenMarker = false;

		pluginPanel = null;
		currentMarker = null;
		mouseListener = null;
		navigationButton = null;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (screenMarkers.isEmpty() && event.getGroup().equals(CONFIG_GROUP) && event.getKey().equals(CONFIG_KEY))
		{
			loadConfig(event.getNewValue()).forEach(screenMarkers::add);
			overlayManager.removeIf(ScreenMarkerOverlay.class::isInstance);
			screenMarkers.forEach(overlayManager::add);
		}
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

	public void setKeyListenerEnabled(boolean enabled)
	{
		if (enabled)
		{
			keyManager.registerKeyListener(keyListener);
		}
		else
		{
			keyManager.unregisterKeyListener(keyListener);
		}
	}

	public void startCreation(Point location)
	{
		currentMarker = new ScreenMarker(
			Instant.now().toEpochMilli(),
			DEFAULT_MARKER_NAME + " " + (screenMarkers.size() + 1),
			pluginPanel.getSelectedBorderThickness(),
			pluginPanel.getSelectedColor(),
			pluginPanel.getSelectedFillColor(),
			true
		);

		overlay.setPreferredLocation(location);
		creatingScreenMarker = true;

		Rectangle clicked = findContaining(client.getWidgetRoots(), location);
		if (shiftModifier && clicked != null)
		{
			startLocation = new Point(clicked.x, clicked.y);
			overlay.setPreferredLocation(startLocation);
			overlay.setPreferredSize(clicked.getBounds().getSize());
		}
		else
		{
			// Set overlay creator bounds to current position and default size
			startLocation = location;
			overlay.setPreferredLocation(location);
			overlay.setPreferredSize(DEFAULT_SIZE);
		}
	}

	private Rectangle findContaining(Widget[] widgets, Point location)
	{
		Widget last = null;
		for (Widget widget : widgets)
		{

			if (widget.getWidgetItems() != null)
			{
				for (WidgetItem item : widget.getWidgetItems())
				{
					Rectangle itemBounds = item.getCanvasBounds();
					if (itemBounds.contains(location))
					{
						return itemBounds;
					}
				}
			}

			if (!widget.getBounds().contains(location) || widget.isHidden() || widget.isSelfHidden())
			{
				continue;
			}

			Widget[] children = new Widget[0];

			if (widget.getChildren() != null)
			{
				children = ArrayUtils.addAll(children, widget.getChildren());
			}

			if (widget.getStaticChildren() != null)
			{
				children = ArrayUtils.addAll(children, widget.getStaticChildren());
			}

			if (widget.getNestedChildren() != null)
			{
				children = ArrayUtils.addAll(children, widget.getNestedChildren());
			}

			if (widget.getDynamicChildren() != null)
			{
				children = ArrayUtils.addAll(children, widget.getDynamicChildren());
			}

			if (children.length > 0)
			{
				Rectangle find = findContaining(children, location);
				if (find != null)
				{
					return find;
				}
			}

			last = widget;
		}

		if (last != null)
		{
			return last.getBounds();
		}

		return null;
	}

	public void finishCreation(boolean aborted)
	{
		if (!aborted)
		{
			final ScreenMarkerOverlay screenMarkerOverlay = new ScreenMarkerOverlay(currentMarker);
			screenMarkerOverlay.setPreferredLocation(overlay.getBounds().getLocation());
			screenMarkerOverlay.setPreferredSize(overlay.getBounds().getSize());

			screenMarkers.add(screenMarkerOverlay);
			overlayManager.saveOverlay(screenMarkerOverlay);
			overlayManager.add(screenMarkerOverlay);
			pluginPanel.rebuild();
			updateConfig();
		}

		creatingScreenMarker = false;
		startLocation = null;
		currentMarker = null;
		setMouseListenerEnabled(false);

		pluginPanel.setCreation(false);
	}

	/* The marker area has been drawn, inform the user and unlock the confirm button */
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

		final Gson gson = new Gson();
		final String json = gson
			.toJson(screenMarkers.stream().map(ScreenMarkerOverlay::getMarker).collect(Collectors.toList()));
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, json);
	}

	public void setShiftModifier(boolean shiftModifier)
	{
		this.shiftModifier = shiftModifier;
	}

	private Stream<ScreenMarkerOverlay> loadConfig(String json)
	{
		if (Strings.isNullOrEmpty(json))
		{
			return Stream.empty();
		}

		final Gson gson = new Gson();
		final List<ScreenMarker> screenMarkerData = gson.fromJson(json, new TypeToken<ArrayList<ScreenMarker>>()
		{
		}.getType());

		return screenMarkerData.stream().map(ScreenMarkerOverlay::new);
	}
}
