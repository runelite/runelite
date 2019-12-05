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

package net.runelite.client.plugins.prayagainstplayer;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Pray Against Player",
	description = "Use plugin in PvP situations for best results!!",
	tags = {"highlight", "pvp", "overlay", "players"},
	type = PluginType.PVP,
	enabledByDefault = false
)
@Singleton
@Getter(AccessLevel.PACKAGE)
public class PrayAgainstPlayerPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private SpriteManager spriteManager;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private PrayAgainstPlayerOverlay overlay;
	@Inject
	private PrayAgainstPlayerOverlayPrayerTab overlayPrayerTab;
	@Inject
	private PrayAgainstPlayerConfig config;

	private boolean ignoreFriends;
	private boolean ignoreClanMates;
	private boolean drawTargetPrayAgainstPrayerTab;
	private boolean highlightAttackers;
	private int highlightWidth;

	@Provides
	PrayAgainstPlayerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrayAgainstPlayerConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		overlayManager.add(overlay);
		overlayManager.add(overlayPrayerTab);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		overlayManager.remove(overlayPrayerTab);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("prayagainstplayer"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.ignoreFriends = config.ignoreFriends();
		this.ignoreClanMates = config.ignoreClanMates();
		this.drawTargetPrayAgainstPrayerTab = config.drawTargetPrayAgainstPrayerTab();
		this.highlightAttackers = config.highlightAttackers();
		this.highlightWidth = config.highlightWidth();

		if (this.drawTargetPrayAgainstPrayerTab)
		{
			overlayManager.add(overlayPrayerTab);
		}
		else
		{
			overlayManager.remove(overlayPrayerTab);
		}
	}
}
