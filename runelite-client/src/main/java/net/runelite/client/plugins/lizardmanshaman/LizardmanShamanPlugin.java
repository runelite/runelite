/*
 * Copyright (c) 2018, https://openosrs.com Dutta64
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
package net.runelite.client.plugins.lizardmanshaman;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import static net.runelite.client.plugins.lizardmanshaman.LizardmanShamanConfig.SpawnOverlayConfig;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Lizardman Shamans",
	description = "Display an overlay for spawn explosion tiles",
	tags = {"lizardman", "shaman", "lizard"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Slf4j
@Singleton
public class LizardmanShamanPlugin extends Plugin
{
	private static final String CONFIG_GROUP_NAME = "lizardmanshaman";

	@Getter(AccessLevel.PACKAGE)
	private SpawnOverlayConfig spawnOverlayConfig;

	@Getter(AccessLevel.PACKAGE)
	private Color explosionBorderColor;

	@Getter(AccessLevel.PACKAGE)
	private Color explosionFillColor;

	@Getter(AccessLevel.PACKAGE)
	private Color spawnWalkableBorderColor;

	@Getter(AccessLevel.PACKAGE)
	private Color spawnWalkableFillColor;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private LizardmanShamanOverlay overlay;

	@Inject
	private LizardmanShamanConfig config;

	@Provides
	LizardmanShamanConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LizardmanShamanConfig.class);
	}

	@Override
	protected void startUp()
	{
		initConfig();

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (Objects.equals(event.getGroup(), CONFIG_GROUP_NAME))
		{
			initConfig();
		}
	}

	private void initConfig()
	{
		this.spawnOverlayConfig = config.showSpawnOverlay();

		this.explosionBorderColor = config.explosionBorderColor();
		this.explosionFillColor = config.explosionFillColor();

		this.spawnWalkableBorderColor = config.spawnWalkableBorderColor();
		this.spawnWalkableFillColor = config.spawnWalkableFillColor();
	}
}
