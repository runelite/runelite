/*
 * Copyright (c) 2018 AWPH-I
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
package net.runelite.client.plugins.inventoryviewer;

import com.google.inject.Provides;
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
	name = "Inventory Viewer",
	description = "Add an overlay showing the contents of your inventory",
	tags = {"alternate", "items", "overlay", "second"},
	enabledByDefault = false
)
@Singleton
public class InventoryViewerPlugin extends Plugin
{
	static final String CONFIG_GROUP_KEY = "inventoryviewer";

	@Inject
	private InventoryViewerOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InventoryViewerConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private InventoryViewerMode viewerMode;
	@Getter(AccessLevel.PACKAGE)
	private boolean showFreeSlots;
	@Getter(AccessLevel.PACKAGE)
	private boolean hideWhenInvOpen;

	@Provides
	InventoryViewerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InventoryViewerConfig.class);
	}

	@Override
	public void startUp()
	{
		updateConfig();
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		overlayManager.add(overlay);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP_KEY))
		{
			updateConfig();
		}
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	private void updateConfig()
	{
		this.viewerMode = config.viewerMode();
		this.showFreeSlots = config.showFreeSlots();
		this.hideWhenInvOpen = config.hideWhenInvOpen();
	}
}