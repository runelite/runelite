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
package net.runelite.client.plugins.tabsviewer;

import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Tabs Viewer",
	description = "Add an overlay showing the contents of your inventory or equipped tab",
	tags = {"alternate", "items", "overlay", "second"},
	enabledByDefault = false
)
public class TabsViewerPlugin extends Plugin
{
	@Inject
	private InventoryViewerOverlay inventoryOverlay;

	@Inject
	private EquipmentViewerOverlay equipmentOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TabsViewerConfig config;

	@Provides
	TabsViewerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TabsViewerConfig.class);
	}

	@Override
	public void startUp()
	{
		overlayManager.add(inventoryOverlay);
		overlayManager.add(equipmentOverlay);
	}

	@Override
	public void shutDown()
	{
		overlayManager.remove(inventoryOverlay);
		overlayManager.remove(equipmentOverlay);
	}
}