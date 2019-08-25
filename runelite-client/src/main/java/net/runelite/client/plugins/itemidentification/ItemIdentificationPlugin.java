/*
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.itemidentification;

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
	name = "Item Identification",
	description = "Show identifying text over items with difficult to distinguish sprites",
	enabledByDefault = false
)
@Singleton
public class ItemIdentificationPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ItemIdentificationOverlay overlay;

	@Inject
	private ItemIdentificationConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private ItemIdentificationMode identificationType;
	@Getter(AccessLevel.PACKAGE)
	private Color textColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSeeds;
	@Getter(AccessLevel.PACKAGE)
	private boolean showHerbs;
	@Getter(AccessLevel.PACKAGE)
	private boolean showSaplings;
	@Getter(AccessLevel.PACKAGE)
	private boolean showOres;
	@Getter(AccessLevel.PACKAGE)
	private boolean showGems;

	@Provides
	ItemIdentificationConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemIdentificationConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("itemidentification"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.identificationType = config.identificationType();
		this.textColor = config.textColor();
		this.showSeeds = config.showSeeds();
		this.showHerbs = config.showHerbs();
		this.showSaplings = config.showSaplings();
		this.showOres = config.showOres();
		this.showGems = config.showGems();
	}
}