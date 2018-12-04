/*
 * Copyright (c) 2018, Trevor <https://github.com/15987632>
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
package net.runelite.client.plugins.skullnotifier;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.SkullIcon;
import net.runelite.api.WorldType;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
		name = "Skull Notifier",
		description = "Receive notifications when you get or remove a skull.",
		tags = {"notifications"},
		enabledByDefault = false
)
public class SkullNotifierPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SkullNotifierConfig config;

	@Inject
	private Notifier notifier;

	private SkullIcon lastTickSkull = null;
	private boolean isFirstTick;

	@Provides
	SkullNotifierConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SkullNotifierConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		isFirstTick = true;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getWorldType().contains(WorldType.DEADMAN) || client.getWorldType().contains(WorldType.SEASONAL_DEADMAN))
		{
			return;
		}

		Player player = client.getLocalPlayer();
		SkullIcon currentTickSkull = player.getSkullIcon();

		if (!isFirstTick)
		{
			if (config.showSkullNotification() && lastTickSkull == null && currentTickSkull == SkullIcon.SKULL)
			{
				notifier.notify("[" + player.getName() + "] is now skulled!");
			}
			else if (config.showUnskullNotification() && lastTickSkull == SkullIcon.SKULL && currentTickSkull == null)
			{
				notifier.notify("[" + player.getName() + "] is now unskulled!");
			}
		}
		else
		{
			isFirstTick = false;
		}

		lastTickSkull = currentTickSkull;
	}
}
