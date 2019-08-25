/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.inventorygrid;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.awt.Color;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Inventory Grid",
	description = "Shows a grid over the inventory and a preview of where items will be dragged",
	tags = {"items", "overlay"},
	enabledByDefault = false
)
@Singleton
public class InventoryGridPlugin extends Plugin
{
	@Inject
	private InventoryGridOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InventoryGridConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean showItem;
	@Getter(AccessLevel.PACKAGE)
	boolean showGrid;
	@Getter(AccessLevel.PACKAGE)
	private boolean showHighlight;
	@Getter(AccessLevel.PACKAGE)
	private int dragDelay;
	@Getter(AccessLevel.PACKAGE)
	private Color gridColor;
	@Getter(AccessLevel.PACKAGE)
	private Color highlightColor;

	@Override
	public void startUp()
	{
		updateConfig();
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		overlayManager.add(overlay);
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	@Provides
	InventoryGridConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InventoryGridConfig.class);
	}

	private void onConfigChanged(ConfigChanged config)
	{
		if (config.getGroup().equals("inventorygrid"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.showItem = config.showItem();
		this.showGrid = config.showGrid();
		this.showHighlight = config.showHighlight();
		this.dragDelay = config.dragDelay();
		this.gridColor = config.gridColor();
		this.highlightColor = config.highlightColor();
	}
}
