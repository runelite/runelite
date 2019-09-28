/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.tileindicators;

import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Tile Indicators",
	description = "Highlight the tile you are currently moving to",
	tags = {"highlight", "overlay"},
	enabledByDefault = false
)
@Singleton
public class TileIndicatorsPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TileIndicatorsOverlay overlay;

	@Inject
	private TileIndicatorsConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private Color highlightDestinationColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightDestinationTile;
	@Getter(AccessLevel.PACKAGE)
	private boolean thinDestinationTile;
	@Getter(AccessLevel.PACKAGE)
	private Color highlightCurrentColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightCurrentTile;
	@Getter(AccessLevel.PACKAGE)
	private boolean thinCurrentTile;
	@Getter(AccessLevel.PACKAGE)
	private Color highlightHoveredColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean highlightHoveredTile;
	@Getter(AccessLevel.PACKAGE)
	private boolean thinHoveredTile;

	@Provides
	TileIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TileIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!"tileindicators".equals(event.getGroup()))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.highlightDestinationColor = config.highlightDestinationColor();
		this.highlightDestinationTile = config.highlightDestinationTile();
		this.thinDestinationTile = config.thinDestinationTile();
		this.highlightCurrentColor = config.highlightCurrentColor();
		this.highlightCurrentTile = config.highlightCurrentTile();
		this.thinCurrentTile = config.thinCurrentTile();
		this.highlightHoveredColor = config.highlightHoveredColor();
		this.highlightHoveredTile = config.highlightHoveredTile();
		this.thinHoveredTile = config.thinHoveredTile();
	}
}
