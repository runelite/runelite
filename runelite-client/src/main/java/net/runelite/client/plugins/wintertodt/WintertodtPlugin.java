/*
 * Copyright (c) 2018, EmptySet <https://github.com/OTRD5k>
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

package net.runelite.client.plugins.wintertodt;

import javax.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import java.util.Arrays;
import java.util.Collection;

@PluginDescriptor(
		name = "Wintertodt"
)
public class WintertodtPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private WintertodtConfig config;

	private static final int WINTERTODT_REGION = 6462;

	@Getter
	private static final WorldPoint[] safespots = {
			new WorldPoint(1622, 3988, 0),
			new WorldPoint(1622, 3996, 0),
			new WorldPoint(1638, 3996, 0),
			new WorldPoint(1638, 3988, 0)
	};


	@Inject
	private WintertodtSafespotOverlay safespotOverlay;

	@Inject
	WintertodtSnowOverlay snowOverlay;

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(safespotOverlay, snowOverlay);
	}

	@Provides
	WintertodtConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WintertodtConfig.class);
	}

	public boolean isInWintertodt()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return false;
		}
		return client.getLocalPlayer().getWorldLocation().getRegionID() == WINTERTODT_REGION;
	}
}
