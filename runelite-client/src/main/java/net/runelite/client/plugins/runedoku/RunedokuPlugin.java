/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.runedoku;

import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Runedoku Solver",
	description = "Show solutions for current Runedoku puzzle.",
	tags = {"overlay", "runedoku", "sudoku", "puzzle", "solving"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)

@Slf4j
@Singleton
public class RunedokuPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RunedokuOverlay runedokuOverlay;

	@Inject
	private RunedokuConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private Color mindRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color fireRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color bodyRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color airRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color deathRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color waterRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color chaosRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color earthRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private Color lawRuneColor;
	@Getter(AccessLevel.PACKAGE)
	private boolean onlyHighlightSelectedPiece;

	@Provides
	RunedokuConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunedokuConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();

		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		overlayManager.add(runedokuOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(runedokuOverlay);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("runedoku"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.mindRuneColor = config.mindRuneColor();
		this.fireRuneColor = config.fireRuneColor();
		this.bodyRuneColor = config.bodyRuneColor();
		this.airRuneColor = config.airRuneColor();
		this.deathRuneColor = config.deathRuneColor();
		this.waterRuneColor = config.waterRuneColor();
		this.chaosRuneColor = config.chaosRuneColor();
		this.earthRuneColor = config.earthRuneColor();
		this.lawRuneColor = config.lawRuneColor();
		this.onlyHighlightSelectedPiece = config.onlyHighlightSelectedPiece();
	}
}
