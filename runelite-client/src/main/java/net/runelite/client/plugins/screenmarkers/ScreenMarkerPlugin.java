/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;

@PluginDescriptor(name = "Screen Markers")

public class ScreenMarkerPlugin extends Plugin
{
	@Inject
	private ScreenMarkerOverlay overlay;

	@Inject
	private ScreenMarkerMouseListener mouseListener;

	@Inject
	private MouseManager mouseManager;

	@Inject
	@Getter(AccessLevel.PACKAGE)
	private ScreenMarkerConfig config;

	@Getter(AccessLevel.PACKAGE)
	private final ArrayList<ScreenMarker> markers;

	@Getter(AccessLevel.PACKAGE)
	private final ScreenMarker drawingMarker;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean isPlacingMarker = false;

	public ScreenMarkerPlugin()
	{
		this.markers = new ArrayList<>();
		this.drawingMarker = new ScreenMarker(200, 200, 20, 20, 3, Color.red.darker());
		this.addMarker(this.drawingMarker);
	}

	void addMarker(ScreenMarker marker)
	{
		this.markers.add(marker);
	}

	private void removeAllMarkers()
	{
		this.markers.clear();
		this.addMarker(this.drawingMarker);
	}

	private void updateMarkerVisibility()
	{
		boolean showDrawingMarker = this.drawingMarker.isVisible();
		for (ScreenMarker marker : this.markers)
			marker.setVisible(config.displayMarkers());

		this.drawingMarker.setVisible(showDrawingMarker);
	}

	private void loadMarkersFromConfig()
	{
		this.removeAllMarkers();

		String[] parts = this.config.markerData().split(";");
		for (String part : parts)
		{
			ScreenMarker marker = ScreenMarker.fromString(part);
			if (marker != null)
			{
				marker.setVisible(this.config.displayMarkers());
				this.addMarker(marker);
			}
		}
	}

	void updateMarkerConfig()
	{
		ArrayList<String> parts = new ArrayList<>(this.markers.size() - 1);
		for (ScreenMarker marker : this.markers)
		{
			if (marker.equals(this.drawingMarker))
				continue;

			parts.add(marker.toString());
		}

		this.config.markerData(String.join(";", parts));
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("screenmarkers"))
		{
			switch (event.getKey())
			{
				case "displayMarkers":
					this.updateMarkerVisibility();
					break;
				case "markerData":
					this.loadMarkersFromConfig();
					break;
				case "markerColor":
					this.drawingMarker.setColor(this.config.markerColor());
					break;
				case "markerThickness":
					this.drawingMarker.setStrokeSize(this.config.markerThickness());
					break;
				case "addMarkers":
					this.setPlacingMarker(this.config.addMarkers());
					break;
			}
		}
	}

	@Override
	protected void startUp()
	{
		mouseManager.registerMouseListener(mouseListener);
		this.updateMarkerVisibility();
		this.loadMarkersFromConfig();

		this.drawingMarker.setColor(this.config.markerColor());
		this.drawingMarker.setStrokeSize(this.config.markerThickness());
		this.config.addMarkers(false);
	}

	@Override
	protected void shutDown() throws Exception
	{
		mouseManager.unregisterMouseListener(mouseListener);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Provides
	ScreenMarkerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ScreenMarkerConfig.class);
	}
}